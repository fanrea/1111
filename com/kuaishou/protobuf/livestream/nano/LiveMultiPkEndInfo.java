package com.kuaishou.protobuf.livestream.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveMultiPkEndInfo {
    public static final int END_INFO_ADVANCE_END_BY_RPC = 10;
    public static final int END_INFO_ADVANCE_END_PENALTY = 6;
    public static final int END_INFO_ADVANCE_END_VOTE = 5;
    public static final int END_INFO_AUTHOR_ADVANCE_END = 4;
    public static final int END_INFO_CONTINUE_INVITE = 12;
    public static final int END_INFO_DEADLINE_CLEANUP = 3;
    public static final int END_INFO_END_BIZ = 14;
    public static final int END_INFO_FRAMEWORK = 2;
    public static final int END_INFO_HANDLE_ABNORMAL_PK = 13;
    public static final int END_INFO_HEART_BEAT_TIMEOUT = 7;
    public static final int END_INFO_LIVE_STREAM_END = 8;
    public static final int END_INFO_REJECT_REOPEN = 9;
    public static final int END_INFO_REOPEN = 1;
    public static final int END_INFO_SWITCH_BIZ_FAIL = 11;
    public static final int LIVE_PK_END_INFO_UNKNOWN = 0;
}
