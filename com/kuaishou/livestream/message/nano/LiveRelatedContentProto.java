package com.kuaishou.livestream.message.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRelatedContentProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveAssociateAreaType {
        public static final int GAME_LIVE_STREAM_TYPE = 1;
        public static final int GR_PR_LIVE_STREAM_TYPE = 4;
        public static final int LOCAL_LIFE_TYPE = 6;
        public static final int SHOP_LIVE_STREAM_TYPE = 2;
        public static final int SHOW_LIVE_STREAM_TYPE = 5;
        public static final int UNKNOWN_LIVE_STREAM_TYPE = 0;
        public static final int VOICE_PARTY_LIVE_STREAM_TYPE = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveAssociateAreaWidgetBiz {
        public static final int COMMERCIAL_FANS_TOP = 15;
        public static final int GRPR_BUSINESS_CONTENT_TITLE = 6;
        public static final int GZONE_COMPETITION_DIVERSION = 19;
        public static final int GZONE_TV = 21;
        public static final int GZONE_WISH_LIST = 20;
        public static final int HEAT_HIGH = 34;
        public static final int HOTSPOT_RANK = 24;
        public static final int HOURLY_RANK = 10;
        public static final int HOURLY_RANK_BENEFIT = 11;
        public static final int HOURLY_RANK_REFRESHING = 500;
        public static final int LIVE_ANCHOR_NETWORK_TIP = 14;
        public static final int LIVE_CONTENT_STORY_HINT = 26;
        public static final int LIVE_GUEST_ACTIVITY_EXPAND_PENDANT = 2;
        public static final int LIVE_GUEST_ACTIVITY_SHRINK_PENDANT = 1;
        public static final int LIVE_OFFICIAL_PROGRAMME = 27;
        public static final int LIVE_PROGRAMME_TALENT_RANK = 35;
        public static final int LIVE_QUALITY_ANCHOR = 22;
        public static final int LIVE_SQUAD_REFRESHING = 502;
        public static final int LIVE_SQUARE = 3;
        public static final int LIVE_TOPIC = 5;
        public static final int LOCAL_LIFE_ACTIVITY = 30;
        public static final int LOCAL_LIFE_GIFT = 29;
        public static final int LOCAL_LIFE_HOT = 32;
        public static final int LOCAL_LIFE_LIVE_RANK_LIST = 28;
        public static final int LOCAL_LIFE_NEW_PRODUCT = 33;
        public static final int LOCAL_LIFE_POPULARITY = 31;
        public static final int MERCHANT_AUTHENTICATION = 4;
        public static final int MERCHANT_HOURLY_RANK = 12;
        public static final int MERCHANT_TRAFFIC = 18;
        public static final int PUSH_DIVERSION = 16;
        public static final int REBROADCAST = 9;
        public static final int RECRUIT_RANK = 25;
        public static final int REVENUE_CPS_AUTHOR = 23;
        public static final int ROCKET_ENTERS_PEOPLE = 17;
        public static final int TEN_BILLION_SUBSIDIES_ICON = 7;
        public static final int UNKNOWN_USER_WIDGET_BIZ = 0;
        public static final int VOICE_PARTY_CLOSE_BUTTON = 13;
        public static final int VOICE_PARTY_TOPIC = 8;
        public static final int WISH_LIST_REFRESHING = 501;
    }
}
