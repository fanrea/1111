package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveEncourageTaskStatus {
    public static final int COMPLETED_STATUS = 3;
    public static final int PROCESSING_STATUS = 2;
    public static final int REWARDED_STATUS = 4;
    public static final int UNACCEPTED_STATUS = 1;
    public static final int UNKNOWN_TASK_STATUS = 0;
}
