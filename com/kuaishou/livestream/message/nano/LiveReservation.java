package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveReservation {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveAuthorReservationCreateSource {
        public static final int AD_SOCIAL = 29;
        public static final int AUTHOR_ACTIVITY = 12;
        public static final int BRAND_ZONE = 25;
        public static final int CNY2023_INTERACTION_LIVE = 33;
        public static final int END_PAGE_PRIME_AUDIENCE = 30;
        public static final int FLOW = 32;
        public static final int GAME_MATE_PRE_PUSH = 13;
        public static final int GAME_MATE_STOP_PUSH = 14;
        public static final int GAME_MATE_STOP_PUSH_PRE_GUIDE = 15;
        public static final int LIVE_AUTHOR_BULLETIN = 24;
        public static final int LIVE_AUTHOR_CENTER = 26;
        public static final int LIVE_AUTHOR_CENTER_OPTIMIZE = 27;
        public static final int LIVE_COMMENT_NOTICE = 21;
        public static final int LIVE_DYNAMIC = 23;
        public static final int LIVE_MOTIVATION = 22;
        public static final int LIVE_STREAM_PANEL_BUTTON = 19;
        public static final int LIVE_STREAM_RESERVATION_STICKER = 20;
        public static final int LIVE_SUPPLY_ACTIVITY = 28;
        public static final int LIVE_VOICE_ROBOT = 31;
        public static final int PC_MATE_FUNCTION_PANEL = 16;
        public static final int PC_MATE_STOP_PUSH = 18;
        public static final int PC_MATE_STOP_PUSH_PRE_GUIDE = 17;
        public static final int PHOTO_EDIT = 11;
        public static final int PHOTO_EDIT_STICKER = 34;
        public static final int PHOTO_PUBLISH = 10;
        public static final int PRE_PUSH = 1;
        public static final int STOP_PUSH = 3;
        public static final int STOP_PUSH_PRE_GUIDE = 4;
        public static final int UNKNOWN_CREATE_SOURCE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveUserReservationSourceType {
        public static final int AD_BRAND_FEED = 27;
        public static final int AD_BRAND_SEARCH_LIVE_ZONE = 19;
        public static final int AD_FANS_PUSH_TO_PROFILE_LIVE_DYNAMIC = 35;
        public static final int BOOKED_LIST = 1;
        public static final int CNY2023_INTERACTION_LIVE_AUDIENCE = 29;
        public static final int COMMERCE_ASSOCIATES = 24;
        public static final int DOODLE = 25;
        public static final int END_SUMMARY = 11;
        public static final int FOLLOW = 13;
        public static final int H5_ACTIVITY = 5;
        public static final int HALF_POP_UP = 2;
        public static final int LIVE_22_NEW_YEAR_LUCKY_STAR = 23;
        public static final int LIVE_22_YEAR_END_CEREMONY = 28;
        public static final int LIVE_23_CNY_ECOMMERCE_PLACE = 30;
        public static final int LIVE_BULLETIN = 18;
        public static final int LIVE_END_PAGE_FOLLOW = 21;
        public static final int LIVE_FOLLOW_CARD = 20;
        public static final int LIVE_PLUTUS_RESERVATION_RED_PACK = 32;
        public static final int LIVE_PLUTUS_RESERVATION_RED_PACK_AUTO_GRAB = 33;
        public static final int LIVE_PROFILE = 10;
        public static final int LIVE_RESERVATION_GUIDE_POPUP = 31;
        public static final int LIVE_RESERVATION_STICKER_BOOKED = 15;
        public static final int LIVE_REVENUE_HUNTER = 26;
        public static final int LIVING_COMMENT_NOTICE = 3;
        public static final int PHOTO_LABEL = 34;
        public static final int PHOTO_LEFT_CORNER = 22;
        public static final int PHOTO_QUICK_INTERACTIVE_LIVE_BUTTON = 37;
        public static final int PLAYBACK_NOTICE = 12;
        public static final int POPULARITY_KING_ACTIVITY = 17;
        public static final int PRODUCER_PHOTO_LABEL = 36;
        public static final int PROFILE_DETAILS = 4;
        public static final int PROFILE_LIVE_DYNAMIC = 16;
        public static final int SEARCH_ACTIVITY = 6;
        public static final int SIMPLE_LIVE_STREAM_CARD = 14;
        public static final int UNKNOWN_RESERVATION = 0;
        public static final int XIAO_DIAN_TONG_H5 = 7;
        public static final int XIAO_DIAN_TONG_MANUAL = 8;
        public static final int XIAO_DIAN_TONG_NATIVE = 9;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PhotoRelateLiveReservationSource {
        public static final int AD_SOCIAL_RELATE = 10;
        public static final int APOLLO_ADMIN_RELATE = 11;
        public static final int END_PAGE_RELATE = 6;
        public static final int LIVE_DYNAMIC_DETAIL = 9;
        public static final int LIVE_STREAM_PANEL_BUTTON_RELATE = 7;
        public static final int LIVE_STREAM_RESERVATION_STICKER_RELATE = 8;
        public static final int LIVING_RESERVATION_NOTICE_RELATE = 4;
        public static final int PHOTO_EDIT_RELATE = 2;
        public static final int PHOTO_PUBLISH_RELATE = 1;
        public static final int PRE_PUSH_RELATE = 3;
        public static final int STOP_PUSH_PRE_GUIDE_RELATE = 5;
        public static final int UNKNOWN_RELATE_SOURCE = 0;
    }
}
