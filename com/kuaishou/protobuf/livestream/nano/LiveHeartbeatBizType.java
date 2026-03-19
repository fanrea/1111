package com.kuaishou.protobuf.livestream.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveHeartbeatBizType {
    public static final int BIZ_TYPE_UNKNOWN = 0;
    public static final int LIVE_AUTHOR_CHAT = 4;
    public static final int LIVE_CHAT = 2;
    public static final int LIVE_LINE_CHAT = 5;
    public static final int LIVE_PK = 1;
    public static final int LIVE_VOICE_PARTY = 3;
}
