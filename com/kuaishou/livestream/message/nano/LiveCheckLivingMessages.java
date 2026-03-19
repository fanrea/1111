package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCheckLivingMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveCheckLivingBizType {
        public static final int CARD_FIND = 5;
        public static final int CARD_FOLLOW = 4;
        public static final int CARD_LIVE_FIND = 7;
        public static final int CARD_NEARBY = 6;
        public static final int DETAIL_LIVE = 1;
        public static final int DETAIL_LIVE_MIX = 2;
        public static final int FOLLOW_LIVE_RED_DOT = 14;
        public static final int LITE_LIVE_SIDEBAR = 11;
        public static final int PREFETCH_FIND = 8;
        public static final int PREFETCH_FOLLOW = 9;
        public static final int PREFETCH_NEARBY = 10;
        public static final int PREVIEW_LIVE = 3;
        public static final int SCHOOL_HEAD_CARD = 13;
        public static final int SMALL_SCREEN_CARD = 15;
        public static final int THEATER_TAB = 12;
        public static final int UNKNOWN_CHECK_LIVING_BIZ_TYPE = 0;
    }
}
