package com.kwad.sdk.message;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.aj;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.kwad.components.offline.api.core.adlive.model.LiveMessage;
import com.kwad.sdk.utils.LiveViewUtils;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class LiveMessageController implements View.OnClickListener {
    private static final int MESSAGE_LIST_REFRESH_INTERVAL_MS = 1200;
    private static final int MESSAGE_LIST_REFRESH_SIZE = 8;
    private static final String TAG = "LiveMessageController";
    private boolean mIsTouching;
    private LiveMessageAdapter mLiveMessageAdapter;
    private aj mMessageRecyclerView;
    private int mNewMsgCount;
    private TextView mNewMsgTip;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private final LinkedList<LiveMessage> mCacheMessagesQueen = new LinkedList<>();
    private final LinkedList<LiveMessage> mUserCacheMessagesQueen = new LinkedList<>();
    private long mLastUpdateTimeStamp = 0;
    private boolean mAutoScroll = true;
    private aj.n mOnScrollListener = new aj.n() { // from class: com.kwad.sdk.message.LiveMessageController.1
        @Override // android.support.v7.widget.aj.n
        public void onScrollStateChanged(aj ajVar, int i) {
            if (i == 0 && LiveViewUtils.isLastItemAtListEnd(LiveMessageController.this.mMessageRecyclerView, true)) {
                try {
                    LiveMessageController.this.startAutoScroll(false);
                } catch (Throwable unused) {
                }
            }
        }
    };
    private View.OnTouchListener mOnTouchListener = new View.OnTouchListener() { // from class: com.kwad.sdk.message.LiveMessageController.2
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                LiveMessageController.this.mIsTouching = true;
            } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                LiveMessageController.this.mIsTouching = false;
            } else if (motionEvent.getAction() == 2) {
                LiveMessageController.this.stopAutoScroll();
            }
            return false;
        }
    };
    private final Runnable mMessageRefreshRunnable = new Runnable() { // from class: com.kwad.sdk.message.LiveMessageController.3
        @Override // java.lang.Runnable
        public void run() {
            LiveMessageController.this.refresh();
        }
    };

    public LiveMessageController(aj ajVar, LiveMessageAdapter liveMessageAdapter, TextView textView) {
        this.mMessageRecyclerView = ajVar;
        this.mLiveMessageAdapter = liveMessageAdapter;
        this.mNewMsgTip = textView;
        aj ajVar2 = this.mMessageRecyclerView;
        if (ajVar2 != null) {
            ajVar2.addOnScrollListener(this.mOnScrollListener);
            this.mMessageRecyclerView.setOnTouchListener(this.mOnTouchListener);
        }
        try {
            if (this.mNewMsgTip != null) {
                this.mNewMsgTip.setVisibility(8);
                this.mNewMsgTip.setOnClickListener(this);
            }
        } catch (Throwable unused) {
        }
    }

    public void release() {
        stopRefreshMessage();
        aj ajVar = this.mMessageRecyclerView;
        if (ajVar != null) {
            ajVar.clearOnScrollListeners();
            this.mMessageRecyclerView.setOnTouchListener(null);
        }
        try {
            if (this.mNewMsgTip != null) {
                this.mNewMsgTip.setOnClickListener(null);
                this.mNewMsgTip.setVisibility(8);
            }
        } catch (Throwable unused) {
        }
    }

    public void addLiveMessage(LiveMessage liveMessage) {
        if (liveMessage == null || liveMessage.isInValid()) {
            return;
        }
        Log.d(TAG, "addLiveMessage:" + liveMessage.userName);
        this.mCacheMessagesQueen.add(liveMessage);
        Log.d("live message tag", "live message size:" + this.mCacheMessagesQueen.size());
    }

    public void addUserMessage(LiveMessage liveMessage) {
        if (liveMessage == null || liveMessage.isInValid()) {
            return;
        }
        Log.d(TAG, "addUserMessage:" + liveMessage.userName);
        this.mUserCacheMessagesQueen.add(liveMessage);
        startRefreshMessage();
    }

    public void startRefreshMessage() {
        this.mHandler.removeCallbacks(this.mMessageRefreshRunnable);
        this.mHandler.postDelayed(this.mMessageRefreshRunnable, 0L);
    }

    public void stopRefreshMessage() {
        this.mHandler.removeCallbacks(this.mMessageRefreshRunnable);
    }

    public void startAutoScroll(boolean z) {
        this.mAutoScroll = true;
        this.mNewMsgCount = 0;
        hideNewMsgTip();
        scrollDownRecyclerView(z);
    }

    public void stopAutoScroll() {
        this.mAutoScroll = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.mHandler.removeCallbacks(this.mMessageRefreshRunnable);
        pollAndShowMessages();
        this.mLastUpdateTimeStamp = System.currentTimeMillis();
        this.mHandler.postDelayed(this.mMessageRefreshRunnable, 1200L);
    }

    private void pollAndShowMessages() {
        if (this.mCacheMessagesQueen.isEmpty() && this.mUserCacheMessagesQueen.isEmpty()) {
            return;
        }
        Log.d("live message tag", "start poll message");
        int iMin = Math.min(this.mCacheMessagesQueen.size(), 8);
        ArrayList arrayList = new ArrayList(iMin);
        while (iMin > 0) {
            arrayList.add(this.mCacheMessagesQueen.poll());
            iMin--;
        }
        for (int size = this.mUserCacheMessagesQueen.size(); size > 0; size--) {
            arrayList.add(this.mUserCacheMessagesQueen.poll());
        }
        LiveMessageAdapter liveMessageAdapter = this.mLiveMessageAdapter;
        if (liveMessageAdapter != null) {
            liveMessageAdapter.addAll(arrayList);
        }
        if (this.mAutoScroll) {
            scrollDownRecyclerView(false);
            return;
        }
        this.mNewMsgCount += arrayList.size();
        try {
            showNewMsgTip();
        } catch (Throwable unused) {
        }
    }

    private void scrollDownRecyclerView(boolean z) {
        if (this.mIsTouching) {
            return;
        }
        LiveMessageAdapter liveMessageAdapter = this.mLiveMessageAdapter;
        int itemCount = liveMessageAdapter != null ? liveMessageAdapter.getItemCount() : 0;
        if (itemCount > 0) {
            if (z) {
                aj ajVar = this.mMessageRecyclerView;
                if (ajVar != null) {
                    ajVar.scrollToPosition(itemCount - 1);
                    return;
                }
                return;
            }
            aj ajVar2 = this.mMessageRecyclerView;
            if (ajVar2 != null) {
                ajVar2.smoothScrollToPosition(itemCount - 1);
            }
        }
    }

    private void hideNewMsgTip() {
        TextView textView = this.mNewMsgTip;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void showNewMsgTip() {
        if (this.mNewMsgCount > 99) {
            TextView textView = this.mNewMsgTip;
            if (textView != null) {
                textView.setText("99+条新消息");
            }
        } else {
            TextView textView2 = this.mNewMsgTip;
            if (textView2 != null) {
                textView2.setText(this.mNewMsgCount + "条新消息");
            }
        }
        TextView textView3 = this.mNewMsgTip;
        if (textView3 != null) {
            textView3.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.mNewMsgTip) {
            startAutoScroll(true);
        }
    }
}
