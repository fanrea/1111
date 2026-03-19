package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveVoicePartyFeatureType {
    public static final int ASSISTANT_CLICK_AUTHOR_MIC = 10;
    public static final int ASSISTANT_CLICK_EMPTY_MIC = 7;
    public static final int ASSISTANT_CLICK_INVITE = 12;
    public static final int ASSISTANT_CLICK_OTHER_GUEST_MIC = 8;
    public static final int ASSISTANT_CLICK_SELF_MIC = 9;
    public static final int AUDIENCE_CLICK_AUTHOR_MIC = 4;
    public static final int AUDIENCE_CLICK_OTHER_GUEST_MIC = 5;
    public static final int AUTHOR_CLICK_EMPTY_MIC = 1;
    public static final int AUTHOR_CLICK_GUEST_MIC = 2;
    public static final int AUTHOR_CLICK_INVITE = 11;
    public static final int AUTHOR_CLICK_SELF_MIC = 3;
    public static final int GUEST_CLICK_SELF_MIC = 6;
    public static final int UNKNOWN_FEATURE = 0;
}
