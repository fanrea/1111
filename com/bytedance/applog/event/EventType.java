package com.bytedance.applog.event;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class EventType {
    public static final int EVENT_ALL = Integer.MAX_VALUE;
    public static final int EVENT_CLICK = 8;
    public static final int EVENT_PAGE = 4;
    public static final int EVENT_PROFILE = 2;
    public static final int USER_EVENT = 1;

    public static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }
}
