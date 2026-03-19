package com.kuaishou.protobuf.livestream.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveLineChatCandidateStatus {
    public static final int BUSY_LINE_CANDIDATE = 3;
    public static final int ENABLE_INVITE_CANDIDATE = 4;
    public static final int FORBID_FRIEND_INVITE_CANDIDATE = 2;
    public static final int FORBID_SEARCH_INVITE_CANDIDATE = 1;
    public static final int UNKNOWN_LINE_CHAT_CANDIDATE_STATUS = 0;
}
