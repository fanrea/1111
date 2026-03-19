package com.bytedance.sdk.djx.core.toast;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewParent;
import android.view.WindowManager;
import java.util.Comparator;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class CompatTN extends Handler {
    private static final int REMOVE = 2;
    private final DJXPriorityQueue<CompatToast> toastQueue;

    private CompatTN() {
        this.toastQueue = new DJXPriorityQueue<>(new Comparator<CompatToast>() { // from class: com.bytedance.sdk.djx.core.toast.CompatTN.1
            @Override // java.util.Comparator
            public int compare(CompatToast compatToast, CompatToast compatToast2) {
                if (compatToast2.isShowing()) {
                    return 1;
                }
                if (compatToast.getTimestamp() == compatToast2.getTimestamp()) {
                    return 0;
                }
                return compatToast.getTimestamp() < compatToast2.getTimestamp() ? -1 : 1;
            }
        });
    }

    static CompatTN instance() {
        return SingletonHolder.mTn;
    }

    private static class SingletonHolder {
        private static final CompatTN mTn = new CompatTN();

        private SingletonHolder() {
        }
    }

    public void add(CompatToast compatToast) {
        CompatToast compatToastClone;
        if (compatToast == null || (compatToastClone = compatToast.m362clone()) == null) {
            return;
        }
        notifyNewToastComeIn(compatToastClone);
    }

    private boolean isShowing() {
        return this.toastQueue.size() > 0;
    }

    private void notifyNewToastComeIn(CompatToast compatToast) {
        boolean zIsShowing = isShowing();
        if (compatToast.getTimestamp() <= 0) {
            compatToast.setTimestamp(System.currentTimeMillis());
        }
        this.toastQueue.add(compatToast);
        if (zIsShowing) {
            if (this.toastQueue.size() == 2) {
                CompatToast compatToastPeek = this.toastQueue.peek();
                if (compatToast.getPriority() >= compatToastPeek.getPriority()) {
                    sendRemoveMsg(compatToastPeek);
                    return;
                }
                return;
            }
            return;
        }
        showNextToast();
    }

    private void remove(CompatToast compatToast) {
        this.toastQueue.remove(compatToast);
        removeInternal(compatToast);
    }

    void cancelAll() {
        removeMessages(2);
        if (!this.toastQueue.isEmpty()) {
            removeInternal(this.toastQueue.peek());
        }
        this.toastQueue.clear();
    }

    void cancelActivityToast(Activity activity) {
        if (activity == null) {
            return;
        }
        Iterator<CompatToast> it = this.toastQueue.iterator();
        while (it.hasNext()) {
            CompatToast next = it.next();
            if ((next instanceof ActivityToast) && next.getContext() == activity) {
                remove(next);
            }
        }
    }

    private void removeInternal(CompatToast compatToast) {
        if (compatToast == null || !compatToast.isShowing()) {
            return;
        }
        WindowManager wMManager = compatToast.getWMManager();
        if (wMManager != null) {
            try {
                wMManager.removeViewImmediate(compatToast.getViewInternal());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        compatToast.isShowing = false;
    }

    private void showNextToast() {
        if (this.toastQueue.isEmpty()) {
            return;
        }
        CompatToast compatToastPeek = this.toastQueue.peek();
        if (compatToastPeek == null) {
            this.toastQueue.poll();
            showNextToast();
        } else {
            if (this.toastQueue.size() > 1) {
                if (this.toastQueue.get(1).getPriority() >= compatToastPeek.getPriority()) {
                    this.toastQueue.remove(compatToastPeek);
                    showNextToast();
                    return;
                } else {
                    displayToast(compatToastPeek);
                    return;
                }
            }
            displayToast(compatToastPeek);
        }
    }

    private void sendRemoveMsgDelay(CompatToast compatToast) {
        removeMessages(2);
        Message messageObtainMessage = obtainMessage(2);
        messageObtainMessage.obj = compatToast;
        sendMessageDelayed(messageObtainMessage, compatToast.getDuration());
    }

    private void sendRemoveMsg(CompatToast compatToast) {
        removeMessages(2);
        Message messageObtainMessage = obtainMessage(2);
        messageObtainMessage.obj = compatToast;
        sendMessage(messageObtainMessage);
    }

    private void displayToast(CompatToast compatToast) {
        WindowManager wMManager = compatToast.getWMManager();
        if (wMManager == null) {
            return;
        }
        View viewInternal = compatToast.getViewInternal();
        if (viewInternal == null) {
            this.toastQueue.remove(compatToast);
            showNextToast();
            return;
        }
        ViewParent parent = viewInternal.getParent();
        if (parent instanceof ViewManager) {
            ((ViewManager) parent).removeView(viewInternal);
        }
        try {
            wMManager.addView(viewInternal, compatToast.getWMParams());
            compatToast.isShowing = true;
            sendRemoveMsgDelay(compatToast);
        } catch (Throwable th) {
            if (!(th instanceof WindowManager.BadTokenException) || th.getMessage() == null) {
                return;
            }
            if (th.getMessage().contains("token null is not valid") || th.getMessage().contains("is your activity running")) {
                if (compatToast instanceof ActivityToast) {
                    CompatToast.Count4BadTokenException = 0L;
                    return;
                }
                CompatToast.Count4BadTokenException++;
                if (compatToast.getContext() instanceof Activity) {
                    this.toastQueue.remove(compatToast);
                    removeMessages(2);
                    compatToast.isShowing = false;
                    try {
                        wMManager.removeViewImmediate(viewInternal);
                    } catch (Throwable unused) {
                    }
                    new ActivityToast(compatToast.getContext()).setTimestamp(compatToast.getTimestamp()).setView(viewInternal).setDuration(compatToast.getDuration()).setGravity(compatToast.getGravity(), compatToast.getXOffset(), compatToast.getYOffset()).show();
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null && message.what == 2) {
            remove((CompatToast) message.obj);
            showNextToast();
        }
    }
}
