package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveEncourageTimerTaskStageStatus {
    public static final int COMPLETED_STAGE = 3;
    public static final int PROCESSING_STAGE = 2;
    public static final int REWARDED_STAGE = 4;
    public static final int UNACCEPTED_STAGE = 1;
    public static final int UNKNOWN_STAGE_STATUS = 0;
}
