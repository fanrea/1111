package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveContentOpPromotionShowStatus {
    public static final int PROMOTION_AUDIT = 1;
    public static final int PROMOTION_AUDIT_FAILED = 3;
    public static final int PROMOTION_AUDIT_PASSED = 2;
    public static final int PROMOTION_BANNED = 6;
    public static final int PROMOTION_LIVE_STREAM_LIMIT = 7;
    public static final int PROMOTION_MANUAL_BANNED = 9;
    public static final int PROMOTION_NO_TASK = 8;
    public static final int PROMOTION_TRAFFIC_END = 5;
    public static final int PROMOTION_TRAFFIC_ING = 4;
    public static final int PROMOTION_UNKNOWN = 0;
}
