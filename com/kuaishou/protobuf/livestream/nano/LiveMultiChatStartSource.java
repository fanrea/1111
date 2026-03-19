package com.kuaishou.protobuf.livestream.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface LiveMultiChatStartSource {
    public static final int AUTHOR_CLICK_CHAT_PANEL = 1;
    public static final int AUTHOR_CLICK_COMMENT = 2;
    public static final int AUTHOR_CLICK_GUIDE_WINDOW = 4;
    public static final int AUTHOR_CLICK_USER_PROFILE = 3;
    public static final int UNKNOWN_START_SOURCE = 0;
}
