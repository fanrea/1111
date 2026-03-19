package com.bytedance.sdk.djx.core.business.view.like;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.sdk.djx.core.business.view.like.DJXLikeAnimLayout;
import com.bytedance.sdk.djx.utils.WeakHandler;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class LikeAnimTouchHelper implements WeakHandler.IHandler {
    private static final int MSG_AUTO_CLEAN = 102;
    private static final int MSG_LONG_CANCEL = 104;
    private static final int MSG_LONG_CLICK = 103;
    private static final int MSG_TAP = 101;
    private static final String TAG = "LikeAnimTouchHelper";
    private MotionEvent mCurDownEvent;
    private final int mDoubleTapSlop;
    private final int mDoubleTapSlopSquare;
    private float mInitX;
    private float mInitY;
    private final DJXLikeAnimLayout mLikeAnimLayout;
    private DJXLikeAnimLayout.LikeAnimListener mListener;
    private MotionEvent mPreUpEvent;
    private final int mTouchSlop;
    private final int mTouchSlopSquare;
    private boolean mAlwaysInBiggerTapRegion = false;
    private boolean mAlwaysInTapRegion = false;
    private boolean mIsDoubleTap = false;
    private final WeakHandler mHandler = new WeakHandler(Looper.getMainLooper(), this);

    public LikeAnimTouchHelper(Context context, DJXLikeAnimLayout dJXLikeAnimLayout) {
        this.mLikeAnimLayout = dJXLikeAnimLayout;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
        this.mDoubleTapSlop = scaledDoubleTapSlop;
        int scaledTouchSlop = viewConfiguration.getScaledTouchSlop() * 3;
        this.mTouchSlop = scaledTouchSlop;
        this.mTouchSlopSquare = scaledTouchSlop * scaledTouchSlop;
        this.mDoubleTapSlopSquare = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }

    public void setListener(DJXLikeAnimLayout.LikeAnimListener likeAnimListener) {
        this.mListener = likeAnimListener;
    }

    public void handleMsg(Message message) {
        switch (message.what) {
            case 101:
                DJXLikeAnimLayout.LikeAnimListener likeAnimListener = this.mListener;
                if (likeAnimListener != null) {
                    likeAnimListener.onSingleTab();
                }
                this.mHandler.removeMessages(102);
                break;
            case 102:
                this.mHandler.removeMessages(102);
                break;
            case 103:
                DJXLikeAnimLayout.LikeAnimListener likeAnimListener2 = this.mListener;
                if (likeAnimListener2 != null) {
                    likeAnimListener2.onLongClick();
                }
                this.mHandler.removeMessages(102);
                break;
            case 104:
                DJXLikeAnimLayout.LikeAnimListener likeAnimListener3 = this.mListener;
                if (likeAnimListener3 != null) {
                    likeAnimListener3.onLongClickCancel();
                }
                this.mHandler.removeMessages(104);
                break;
        }
    }

    public boolean onTouch(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            if (this.mHandler.hasMessages(101)) {
                this.mHandler.removeMessages(101);
            }
            if (this.mHandler.hasMessages(102)) {
                this.mHandler.removeMessages(102);
            }
            MotionEvent motionEvent2 = this.mCurDownEvent;
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            this.mCurDownEvent = motionEventObtain;
            this.mIsDoubleTap = false;
            if (isConsideredDoubleTap(motionEventObtain, this.mPreUpEvent, motionEvent)) {
                this.mIsDoubleTap = true;
                handleDoubleClick(this.mCurDownEvent);
            }
            MotionEvent motionEvent3 = this.mPreUpEvent;
            if (motionEvent3 != null) {
                motionEvent3.recycle();
            }
            this.mPreUpEvent = MotionEvent.obtain(motionEvent);
            this.mAlwaysInTapRegion = true;
            this.mAlwaysInBiggerTapRegion = true;
            this.mInitX = motionEvent.getX();
            this.mInitY = motionEvent.getY();
            this.mHandler.sendEmptyMessageDelayed(103, ViewConfiguration.getLongPressTimeout());
        } else if (action == 1) {
            if (this.mAlwaysInTapRegion && !this.mIsDoubleTap && isConsideredSingleTap(this.mCurDownEvent, motionEvent)) {
                this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(101, new Point((int) this.mInitX, (int) this.mInitY)), (ViewConfiguration.getDoubleTapTimeout() - motionEvent.getEventTime()) + this.mCurDownEvent.getEventTime());
            }
            Log.d(TAG, "onTouch: up remove long click");
            this.mHandler.removeMessages(103);
        } else if (action == 2) {
            float x = motionEvent.getX() - this.mInitX;
            float y = motionEvent.getY() - this.mInitY;
            float f = (x * x) + (y * y);
            if (f > this.mTouchSlopSquare || Math.abs(x) >= this.mTouchSlop) {
                this.mHandler.removeMessages(101);
                this.mHandler.removeMessages(103);
            }
            if (f > this.mDoubleTapSlopSquare) {
                this.mAlwaysInBiggerTapRegion = false;
            }
        } else if (action == 3) {
            this.mHandler.removeMessages(101);
            this.mHandler.removeMessages(103);
            WeakHandler weakHandler = this.mHandler;
            weakHandler.sendMessage(weakHandler.obtainMessage(104));
        }
        return true;
    }

    private void handleDoubleClick(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return;
        }
        this.mLikeAnimLayout.showLikeView(motionEvent.getX(), motionEvent.getY());
        DJXLikeAnimLayout.LikeAnimListener likeAnimListener = this.mListener;
        if (likeAnimListener != null) {
            likeAnimListener.onDoubleTab();
        }
    }

    private boolean isConsideredDoubleTap(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (motionEvent == null || motionEvent2 == null || motionEvent3 == null || !this.mAlwaysInBiggerTapRegion) {
            return false;
        }
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime > ViewConfiguration.getDoubleTapTimeout() || eventTime < 40) {
            return false;
        }
        float x = motionEvent.getX() - motionEvent3.getX();
        float y = motionEvent.getY() - motionEvent3.getY();
        return (x * x) + (y * y) < ((float) this.mDoubleTapSlopSquare);
    }

    private boolean isConsideredSingleTap(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        return this.mAlwaysInTapRegion;
    }

    public void release() {
        WeakHandler weakHandler = this.mHandler;
        if (weakHandler != null) {
            weakHandler.removeCallbacksAndMessages((Object) null);
        }
    }
}
