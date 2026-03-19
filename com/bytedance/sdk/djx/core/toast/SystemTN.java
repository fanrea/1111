package com.bytedance.sdk.djx.core.toast;

import android.os.Handler;
import android.os.Message;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class SystemTN extends Handler {
    static final int REMOVE = 2;
    private final LinkedList<SystemToast> toastQueue;

    private SystemTN() {
        this.toastQueue = new LinkedList<>();
    }

    static SystemTN instance() {
        return SingletonHolder.mTn;
    }

    private static class SingletonHolder {
        private static final SystemTN mTn = new SystemTN();

        private SingletonHolder() {
        }
    }

    void add(SystemToast systemToast) {
        SystemToast systemToastClone;
        if (systemToast == null || (systemToastClone = systemToast.m363clone()) == null) {
            return;
        }
        notifyNewToastComeIn(systemToastClone);
    }

    private boolean isShowing() {
        return this.toastQueue.size() > 0;
    }

    private void notifyNewToastComeIn(SystemToast systemToast) {
        boolean zIsShowing = isShowing();
        this.toastQueue.add(systemToast);
        if (zIsShowing) {
            if (this.toastQueue.size() == 2) {
                SystemToast systemToastPeek = this.toastQueue.peek();
                if (systemToast.getPriority() >= systemToastPeek.getPriority()) {
                    sendRemoveMsg(systemToastPeek);
                    return;
                }
                return;
            }
            return;
        }
        showNextToast();
    }

    private void remove(SystemToast systemToast) {
        this.toastQueue.remove(systemToast);
        systemToast.cancelInternal();
        showNextToast();
    }

    void cancelAll() {
        removeMessages(2);
        if (!this.toastQueue.isEmpty()) {
            this.toastQueue.peek().cancelInternal();
        }
        this.toastQueue.clear();
    }

    private void showNextToast() {
        if (this.toastQueue.isEmpty()) {
            return;
        }
        SystemToast systemToastPeek = this.toastQueue.peek();
        if (systemToastPeek == null) {
            this.toastQueue.poll();
            showNextToast();
        } else {
            if (this.toastQueue.size() > 1) {
                if (this.toastQueue.get(1).getPriority() >= systemToastPeek.getPriority()) {
                    this.toastQueue.remove(systemToastPeek);
                    showNextToast();
                    return;
                } else {
                    displayToast(systemToastPeek);
                    return;
                }
            }
            displayToast(systemToastPeek);
        }
    }

    private void sendRemoveMsgDelay(SystemToast systemToast) {
        removeMessages(2);
        Message messageObtainMessage = obtainMessage(2);
        messageObtainMessage.obj = systemToast;
        sendMessageDelayed(messageObtainMessage, systemToast.getDuration());
    }

    private void sendRemoveMsg(SystemToast systemToast) {
        removeMessages(2);
        Message messageObtainMessage = obtainMessage(2);
        messageObtainMessage.obj = systemToast;
        sendMessage(messageObtainMessage);
    }

    private void displayToast(SystemToast systemToast) {
        systemToast.showInternal();
        sendRemoveMsgDelay(systemToast);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message != null && message.what == 2) {
            remove((SystemToast) message.obj);
        }
    }
}
