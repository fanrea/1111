package com.bytedance.sdk.djx.core.vod.layerevent;

import android.view.MotionEvent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LETouchEvent extends LayerEvent {
    private MotionEvent mMotionEvent;

    public static LETouchEvent buildDown(MotionEvent motionEvent) {
        LETouchEvent lETouchEvent = new LETouchEvent();
        lETouchEvent.setEventId(11);
        lETouchEvent.setMotionEvent(motionEvent);
        return lETouchEvent;
    }

    public static LETouchEvent buildLongPress(MotionEvent motionEvent) {
        LETouchEvent lETouchEvent = new LETouchEvent();
        lETouchEvent.setEventId(12);
        lETouchEvent.setMotionEvent(motionEvent);
        return lETouchEvent;
    }

    public static LETouchEvent buildSingleClick(MotionEvent motionEvent) {
        LETouchEvent lETouchEvent = new LETouchEvent();
        lETouchEvent.setEventId(13);
        lETouchEvent.setMotionEvent(motionEvent);
        return lETouchEvent;
    }

    public static LETouchEvent buildDoubleClick(MotionEvent motionEvent) {
        LETouchEvent lETouchEvent = new LETouchEvent();
        lETouchEvent.setEventId(14);
        lETouchEvent.setMotionEvent(motionEvent);
        return lETouchEvent;
    }

    private LETouchEvent() {
    }

    public MotionEvent getMotionEvent() {
        return this.mMotionEvent;
    }

    public void setMotionEvent(MotionEvent motionEvent) {
        this.mMotionEvent = motionEvent;
    }
}
