package com.bytedance.sdk.djx.core.vod.layerevent;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LayerEvent {
    public static final int BOTTOM_STATUS_HIDE = 22;
    public static final int BOTTOM_STATUS_SHOW = 21;
    public static final int CMD_EXIT_FULL_SCREEN = 5001;
    public static final int FULL_SCREEN_ENTER = 31;
    public static final int FULL_SCREEN_EXIT = 32;
    public static final int TOUCH_TYPE_DOUBLE_CLICK = 14;
    public static final int TOUCH_TYPE_DOWN = 11;
    public static final int TOUCH_TYPE_LONG_PRESS = 12;
    public static final int TOUCH_TYPE_SINGLE_CLICK = 13;
    private Object mData;
    private int mEventId;

    public static LayerEvent build(int i) {
        return new LayerEvent().setEventId(i);
    }

    public int getEventId() {
        return this.mEventId;
    }

    public LayerEvent setEventId(int i) {
        this.mEventId = i;
        return this;
    }

    public Object getData() {
        return this.mData;
    }

    public LayerEvent setData(Object obj) {
        this.mData = obj;
        return this;
    }

    public <T> T getData(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        try {
            if (cls.isInstance(this.mData)) {
                return (T) this.mData;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
