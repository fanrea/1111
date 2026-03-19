package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveVoicePartyCrossRoomFeatureType {
    public static final int ASSISTANT_CLICK_OP_AUTHOR_MIC = 8;
    public static final int ASSISTANT_CLICK_OP_EMPTY_MIC = 6;
    public static final int ASSISTANT_CLICK_OP_GUEST_MIC = 7;
    public static final int AUDIENCE_CLICK_OP_AUTHOR_MIC = 4;
    public static final int AUDIENCE_CLICK_OP_GUEST_MIC = 5;
    public static final int AUTHOR_CLICK_OP_AUTHOR_MIC = 3;
    public static final int AUTHOR_CLICK_OP_EMPTY_MIC = 1;
    public static final int AUTHOR_CLICK_OP_GUEST_MIC = 2;
    public static final int UNKNOWN_OP_FEATURE = 0;
}
