package com.kuaishou.socket.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface SocketMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface PayloadType {
        public static final int CS_AUTHOR_PUSH_TRAFFIC_ZERO = 203;
        public static final int CS_ENTER_ROOM = 200;
        public static final int CS_ERROR = 3;
        public static final int CS_HEARTBEAT = 1;
        public static final int CS_HORSE_RACING = 204;
        public static final int CS_PING = 4;
        public static final int CS_RACE_LOSE = 205;
        public static final int CS_SOCKET_MESSAGE_ACK = 207;
        public static final int CS_USER_EXIT = 202;
        public static final int CS_USER_PAUSE = 201;
        public static final int CS_VOIP_SIGNAL = 206;
        public static final int PS_HOST_INFO = 51;
        public static final int SC_ACTION_SIGNAL = 510;
        public static final int SC_ACTIVITY_LIVE_INFO = 596;
        public static final int SC_AD_WATCH_LIVE_TASK_SIGNAL = 972;
        public static final int SC_ARROW_RED_PACK_FEED = 331;
        public static final int SC_ASSISTANT_PRIVILEGE_CHANGED = 415;
        public static final int SC_ASSISTANT_STATUS = 311;
        public static final int SC_AUDIENCE_RED_PACK_SHOW = 680;
        public static final int SC_AUDIENCE_RED_PACK_TOKEN = 681;
        public static final int SC_AUTHOR_BIRTHDAY = 561;
        public static final int SC_AUTHOR_CHAT_END = 482;
        public static final int SC_AUTHOR_CHAT_INVITE = 480;
        public static final int SC_AUTHOR_CHAT_READY = 481;
        public static final int SC_AUTHOR_CHAT_REJECT = 483;
        public static final int SC_AUTHOR_CLIP_STATUS_CHANGED = 584;
        public static final int SC_AUTHOR_HEARTBEAT_MISS = 304;
        public static final int SC_AUTHOR_MUSIC_CLOSED = 491;
        public static final int SC_AUTHOR_MUSIC_OPENED = 490;
        public static final int SC_AUTHOR_PAUSE = 301;
        public static final int SC_AUTHOR_PUSH_TRAFFIC_ZERO = 303;
        public static final int SC_AUTHOR_RESUME = 302;
        public static final int SC_BET_CHANGED = 441;
        public static final int SC_BET_CLOSED = 442;
        public static final int SC_BULLY_SCREEN_PK_CLOSE = 1106;
        public static final int SC_BULLY_SCREEN_PK_OPEN = 1105;
        public static final int SC_BULLY_SCREEN_PK_RICH_TEXT = 1107;
        public static final int SC_CNY2023_LEE_GAME_CONFIG = 1053;
        public static final int SC_COMMENT_FEED = 1036;
        public static final int SC_COMMENT_FOLDING_MESSAGE = 778;
        public static final int SC_COMMENT_LOTTERY_CLOSED = 644;
        public static final int SC_COMMENT_LOTTERY_OPENED = 643;
        public static final int SC_COMMENT_NOTICE_SHOW = 682;
        public static final int SC_COMMENT_NOTICE_SHOW_IM = 686;
        public static final int SC_COMMENT_ZONE_RICH_TEXT = 829;
        public static final int SC_COMMENT_ZONE_RICH_TEXT_CNY2024 = 1207;
        public static final int SC_COURSE_PROMOTE = 356;
        public static final int SC_COURSE_PROMOTE_CLOSED = 357;
        public static final int SC_ECHO = 102;
        public static final int SC_ECO_CONSULT_CARD_NOTICE = 1165;
        public static final int SC_ECO_LIVE_AUTHOR_CONFIG = 1054;
        public static final int SC_EMOTICON_COMMENT_FEED_PUSH = 1131;
        public static final int SC_ENTER_ROOM_ACK = 300;
        public static final int SC_ERROR = 103;
        public static final int SC_FANS_TOP_CLOSED = 418;
        public static final int SC_FANS_TOP_OPENED = 417;
        public static final int SC_FEED_PUSH = 310;
        public static final int SC_FOLLOW_POPUP = 622;
        public static final int SC_FOLLOW_RELATION_PREFETCH = 621;
        public static final int SC_FORBID_COMMENT = 414;
        public static final int SC_FORBID_COMMENT_RECOVER = 416;
        public static final int SC_GAMECENTER_COMMON_COMMAND = 835;
        public static final int SC_GAME_INTERACTION_ACTION_MESSAGE = 854;
        public static final int SC_GAME_INTERACTION_APPLICATION_STATUS_UPDATE = 819;
        public static final int SC_GAME_INTERACTION_ENTER_PK_MODE = 900;
        public static final int SC_GAME_INTERACTION_EXIT_PK_MODE = 901;
        public static final int SC_GAME_INTERACTION_GUESS_ROUND_NOTIFY = 801;
        public static final int SC_GAME_INTERACTION_KSMG_STATE = 957;
        public static final int SC_GAME_INTERACTION_MIC_SEATS_APPLY_INFO = 789;
        public static final int SC_GAME_INTERACTION_MIC_SEATS_INFO = 785;
        public static final int SC_GAME_INTERACTION_MIC_SEATS_LEFT = 788;
        public static final int SC_GAME_INTERACTION_MIC_SEATS_USER_APPLY_AUTHOR_ACCEPT = 786;
        public static final int SC_GAME_INTERACTION_MIC_SEATS_USER_APPLY_AUTHOR_REJECT = 787;
        public static final int SC_GAME_INTERACTION_PK_CONTRIBUTION_RANK = 905;
        public static final int SC_GAME_INTERACTION_PK_OTHER_SIDE_STATUS = 906;
        public static final int SC_GAME_INTERACTION_PK_ROUND_RESULT = 903;
        public static final int SC_GAME_INTERACTION_PK_ROUND_START = 902;
        public static final int SC_GAME_INTERACTION_PK_SCORE_PROGRESS = 904;
        public static final int SC_GAME_INTERACTION_PLAY_ROUND = 820;
        public static final int SC_GAME_INTERACTION_PLAY_STATUS_UPDATE = 817;
        public static final int SC_GAME_INTERACTION_ROOM_STATUS_UPDATE = 816;
        public static final int SC_GAME_INTERACTION_TASK_REWARD_CAN_TAKEN = 821;
        public static final int SC_GAME_INTERACTION_TOOL_STATUS_UPDATE = 1060;
        public static final int SC_GAME_INTERACTION_VOICE_PARTY_STATUS_UPDATE = 818;
        public static final int SC_GAME_INTERACTION_WEBVIEW_PUSHDATA = 883;
        public static final int SC_GAME_ZONE_WISH_VOTE_SIGNAL = 1002;
        public static final int SC_GIFT_ACHIEVEMENT_CLOSED = 1249;
        public static final int SC_GIFT_ACHIEVEMENT_INFO = 1250;
        public static final int SC_GIFT_ACHIEVEMENT_OPENED = 1248;
        public static final int SC_GIFT_CORNER_RED_DOT_SIGNAL = 1088;
        public static final int SC_GUESS_CLOSED = 371;
        public static final int SC_GUESS_OPENED = 370;
        public static final int SC_GZONE_ACCOMPANY_ENTRANCE_HIDE = 741;
        public static final int SC_GZONE_ACCOMPANY_ENTRANCE_SHOW = 740;
        public static final int SC_GZONE_ACCOMPANY_STATE_REFRESH = 742;
        public static final int SC_GZONE_ACTIVITY_LIVE_MARK_MESSAGE = 1244;
        public static final int SC_GZONE_ACTIVITY_UPPER_RIGHT_WIDGET_MESSAGE = 1245;
        public static final int SC_GZONE_COMMON_ACTIVITY_ENTRANCE_HIDE = 825;
        public static final int SC_GZONE_COMMON_ACTIVITY_ENTRANCE_SHOW = 824;
        public static final int SC_GZONE_COMMON_NOTIFICATION_MESSAGE = 770;
        public static final int SC_GZONE_COMPETITION_RECO_PULL = 692;
        public static final int SC_GZONE_CP_ENTRANCE_HIDE = 1182;
        public static final int SC_GZONE_CP_PREDICTION_CHANGED = 1181;
        public static final int SC_GZONE_DISPLAY_FACE_PORTRAIT_LAYOUT = 1170;
        public static final int SC_GZONE_GAME_DATA_CHANGE_NOTICE = 1014;
        public static final int SC_GZONE_GAME_STORE_CLOSED = 666;
        public static final int SC_GZONE_GAME_STORE_OPENED = 665;
        public static final int SC_GZONE_GAME_STORE_REFRESH = 667;
        public static final int SC_GZONE_GIFT_LOTTERY_NOTIFY = 893;
        public static final int SC_GZONE_LIVE_ACTIVITY_COMMON_NOTICE = 916;
        public static final int SC_GZONE_LIVE_ACTIVITY_WINNING_NOTICE = 751;
        public static final int SC_GZONE_LIVE_BIG_CARD_SIGNAL = 1113;
        public static final int SC_GZONE_LIVE_BOTTOM_CARD_SIGNAL = 1096;
        public static final int SC_GZONE_LIVE_BOTTOM_POP_UP_MESSAGE = 969;
        public static final int SC_GZONE_LIVE_HOUR_RANK = 848;
        public static final int SC_GZONE_LIVE_HOUR_RANK_CLOSE = 849;
        public static final int SC_GZONE_LIVE_LITTLE_WIDGET_SIGNAL = 1095;
        public static final int SC_GZONE_LIVE_MATE_AUTHOR_CLOSE = 1242;
        public static final int SC_GZONE_LIVE_MATE_AUTHOR_MATCH_PUSH = 755;
        public static final int SC_GZONE_LIVE_MATE_AUTHOR_OPEN = 1241;
        public static final int SC_GZONE_LIVE_MATE_COMMON_PUSH = 847;
        public static final int SC_GZONE_LIVE_MATE_COVER_AUDIT_STATUS_PUSH = 779;
        public static final int SC_GZONE_LIVE_MATE_MESSAGE_CENTER_NOTIFY = 875;
        public static final int SC_GZONE_LIVE_MATE_NOVICE_TASK_GUIDE = 850;
        public static final int SC_GZONE_LIVE_MATE_PATTERN_CHANGE = 924;
        public static final int SC_GZONE_LIVE_ROOM_MULTI_TAB_CHANGE = 927;
        public static final int SC_GZONE_LIVE_TEXT_NOTICE = 1163;
        public static final int SC_GZONE_LIVE_WIDGET_HIDE_MESSAGE = 968;
        public static final int SC_GZONE_LIVE_WIDGET_SHOW_MESSAGE = 967;
        public static final int SC_GZONE_LUCKY_PLAYER_ENTRANCE_SHOW = 1144;
        public static final int SC_GZONE_PARTNER_EXPLAIN_BIG_CARD_SHOW = 1146;
        public static final int SC_GZONE_PREDICTION_HIDE = 792;
        public static final int SC_GZONE_PREDICTION_PK_END = 919;
        public static final int SC_GZONE_PREDICTION_PK_INVITE_MESSAGE = 921;
        public static final int SC_GZONE_PREDICTION_PK_INVITE_REPLY = 922;
        public static final int SC_GZONE_PREDICTION_PK_PROGRESS = 918;
        public static final int SC_GZONE_PREDICTION_SHOW = 791;
        public static final int SC_GZONE_REVENUE_PK = 853;
        public static final int SC_GZONE_SPREAD_GOLD_ENTRANCE = 885;
        public static final int SC_GZONE_SPREAD_GOLD_EVENT = 886;
        public static final int SC_GZONE_VIRTUAL_TRADE_CLOSED = 671;
        public static final int SC_GZONE_VIRTUAL_TRADE_OPENED = 670;
        public static final int SC_GZONE_WATCHING_PLAY_USER_IM_MESSAGE = 1243;
        public static final int SC_HEARTBEAT_ACK = 101;
        public static final int SC_HORSE_RACING_ACK = 307;
        public static final int SC_INFO = 105;
        public static final int SC_INTERACTIVE_CHAT_APPLY = 869;
        public static final int SC_INTERACTIVE_CHAT_APPLY_ACCEPT = 870;
        public static final int SC_INTERACTIVE_CHAT_APPLY_REJECT = 871;
        public static final int SC_INTERACTIVE_CHAT_CALL = 772;
        public static final int SC_INTERACTIVE_CHAT_CANCEL_APPLY = 1120;
        public static final int SC_INTERACTIVE_CHAT_CANCEL_CALL = 1033;
        public static final int SC_INTERACTIVE_CHAT_CLOSED = 776;
        public static final int SC_INTERACTIVE_CHAT_GUEST_REJECTED = 773;
        public static final int SC_INTERACTIVE_CHAT_INFO_UPDATE = 873;
        public static final int SC_INTERACTIVE_CHAT_MATCHED = 872;
        public static final int SC_INTERACTIVE_CHAT_RESERVATION_AVAILABLE_EVENT = 1148;
        public static final int SC_INTERACTIVE_CHAT_ROOM_INFO = 943;
        public static final int SC_INTERACTIVE_CHAT_SWITCH_BIZ = 944;
        public static final int SC_INTERACTIVE_CHAT_USER_INFO = 774;
        public static final int SC_INTERACTIVE_CHAT_USER_LEAVE_INFO = 775;
        public static final int SC_KTV_APPLAUDED = 478;
        public static final int SC_KTV_CLOSED = 471;
        public static final int SC_KTV_CURRENT_MUSIC_ORDER_STARTED = 477;
        public static final int SC_KTV_MIC_SEATS_INVITATION = 474;
        public static final int SC_KTV_MIC_SEATS_INVITATION_INFO = 662;
        public static final int SC_KTV_MIC_SEATS_LEFT = 475;
        public static final int SC_KTV_MUSIC_ORDER_FINISHED = 476;
        public static final int SC_KTV_NEXT_MUSIC_ORDER_INFO = 472;
        public static final int SC_KTV_OPENED = 470;
        public static final int SC_KTV_RECOMMEND_TO_SING = 479;
        public static final int SC_KTV_SIGNER_VIDEO_STATUS = 1179;
        public static final int SC_KUAISHOU_NIGHT_LOTTERY_CHANGING = 913;
        public static final int SC_KWAISHOP_ARROW_MESSAGE = 743;
        public static final int SC_KWAISHOP_AUCTION_NOTICE = 777;
        public static final int SC_KWAISHOP_LIVE_ACTIVITY_PENDANT = 832;
        public static final int SC_KWAISHOP_LIVE_ACTIVITY_PENDANT_STATE = 833;
        public static final int SC_KWAISHOP_LIVE_ASSISTANT_DATA_PANEL_ENTRY_STATE = 806;
        public static final int SC_KWAISHOP_LIVE_COMMON_DIALOG = 865;
        public static final int SC_KWAISHOP_LIVE_COMMON_TOAST = 866;
        public static final int SC_KWAISHOP_LIVE_ITEM_PENDANT = 863;
        public static final int SC_KWAISHOP_LIVE_PENDANT = 807;
        public static final int SC_KWAISHOP_LIVE_PENDANT_DESTROY = 884;
        public static final int SC_KWAISHOP_LIVE_PUSH_COUPON = 856;
        public static final int SC_KWAISHOP_LIVE_RICH_PENDANT = 815;
        public static final int SC_KWAISHOP_LIVE_SELLER_RANK_PENDANT = 926;
        public static final int SC_KWAISHOP_LIVE_SELLER_RANK_PENDANT_V2 = 975;
        public static final int SC_KWAISHOP_LIVE_SHOP_GROUPON_ACTIVITY_NOTICE = 830;
        public static final int SC_KWAISHOP_LIVE_SHOP_GROUPON_SUC_GROUP = 831;
        public static final int SC_KWAISHOP_LIVE_SKY_FALL_PENDANT_DESTROY = 857;
        public static final int SC_KWAISHOP_RESOURCE_LIVE_PENDANT_DATA = 915;
        public static final int SC_KWAISHOP_RESOURCE_LIVE_PENDANT_SIGNAL_DATA = 960;
        public static final int SC_KWAI_LIVE_SHOP_AUCTION = 804;
        public static final int SC_LIVE_ACTIVITY_ATMOSPHERE_SIGNAL = 1289;
        public static final int SC_LIVE_ACTIVITY_IN_ROOM_PUSH = 1051;
        public static final int SC_LIVE_ACTIVITY_IN_ROOM_PUSH_CNY2024 = 1235;
        public static final int SC_LIVE_ACTIVITY_PASTER_SIGNAL = 1117;
        public static final int SC_LIVE_ACTIVITY_PENDANT = 655;
        public static final int SC_LIVE_ACTIVITY_PENDANT_CLOSE = 656;
        public static final int SC_LIVE_ACTIVITY_POPUP_IM = 678;
        public static final int SC_LIVE_ACTIVITY_POPUP_ROUTE = 1234;
        public static final int SC_LIVE_ACTIVITY_PUSH = 663;
        public static final int SC_LIVE_ACTIVITY_PUSH_V2 = 683;
        public static final int SC_LIVE_ACTIVITY_SPECIAL_AUDIENCE_RANK_EXPAND = 714;
        public static final int SC_LIVE_ACTIVITY_SPECIAL_AUDIENCE_RANK_HIDE = 699;
        public static final int SC_LIVE_ACTIVITY_SPECIAL_AUDIENCE_RANK_SHOW = 698;
        public static final int SC_LIVE_ACTIVITY_SPECIAL_AUDIENCE_RANK_SHRINK = 715;
        public static final int SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT = 867;
        public static final int SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT_CLOSE = 868;
        public static final int SC_LIVE_ACTIVITY_WIDGET_CLOSED = 661;
        public static final int SC_LIVE_ACTIVITY_WIDGET_UPDATED = 660;
        public static final int SC_LIVE_ALL_DAY_BVRP_SG_SF2023 = 1048;
        public static final int SC_LIVE_ARENA_LINE_CHAT_STATISTIC = 1081;
        public static final int SC_LIVE_ASK_ANSWERING_QUESTION = 695;
        public static final int SC_LIVE_ASK_ANSWERING_QUESTION_END = 696;
        public static final int SC_LIVE_ASK_CLOSED = 704;
        public static final int SC_LIVE_ASK_LOCKED = 705;
        public static final int SC_LIVE_ASK_OPENED = 703;
        public static final int SC_LIVE_ASK_QUESTION_STATUS_CHANGE = 697;
        public static final int SC_LIVE_ASK_STATUS_CHANGE = 694;
        public static final int SC_LIVE_ASK_UNLOCKED = 706;
        public static final int SC_LIVE_ATTACH_CAPSULE_GIFT_MESSAGE = 963;
        public static final int SC_LIVE_ATTACH_GIFT_NOTICE_ANIMATION = 1050;
        public static final int SC_LIVE_AUDIENCE_WATCH_DURATION_REPORT = 1137;
        public static final int SC_LIVE_AUTHOR_BUY_PUSH_END = 728;
        public static final int SC_LIVE_AUTHOR_BUY_PUSH_OPENED = 727;
        public static final int SC_LIVE_AUTHOR_CHAT_ACCEPT_INVITE = 672;
        public static final int SC_LIVE_AUTHOR_ENTER_BACKGROUND = 1003;
        public static final int SC_LIVE_AUTHOR_ENTER_FOREGROUND = 1004;
        public static final int SC_LIVE_AUTHOR_HEAD_INFO_CHANGE = 1112;
        public static final int SC_LIVE_AUTHOR_INFO_REGION_STATISTICS = 934;
        public static final int SC_LIVE_AUTHOR_LOCATION_INFO = 1155;
        public static final int SC_LIVE_AUTHOR_PAID_TALENT_AUTHOR_STATUS = 941;
        public static final int SC_LIVE_AUTHOR_PAID_TALENT_AUTHOR_TRADE = 940;
        public static final int SC_LIVE_AUTHOR_PAID_TALENT_VISITOR_TRADE = 942;
        public static final int SC_LIVE_AUTHOR_PERCEPTION_TOP_USER_CLOSED = 1167;
        public static final int SC_LIVE_AUTHOR_PERCEPTION_TOP_USER_INFO = 1153;
        public static final int SC_LIVE_AUTHOR_RADAR = 1140;
        public static final int SC_LIVE_AUTHOR_REINFORCE_INFO = 949;
        public static final int SC_LIVE_BANNED = 594;
        public static final int SC_LIVE_BATTLE_DISTRICT_RANK = 983;
        public static final int SC_LIVE_BATTLE_DISTRICT_RANK_FOR_TK = 1031;
        public static final int SC_LIVE_BATTLE_POPULARITY_RANK = 1092;
        public static final int SC_LIVE_BEAUTY_LABEL_CHANGE = 747;
        public static final int SC_LIVE_BIZ_COMMENT_PLACEHOLDER = 710;
        public static final int SC_LIVE_BLIND_DATE_CHAT_SERVICE_CALL = 993;
        public static final int SC_LIVE_BLIND_DATE_CHAT_SERVICE_END = 995;
        public static final int SC_LIVE_BLIND_DATE_CHAT_SERVICE_NOTICE = 992;
        public static final int SC_LIVE_BLIND_DATE_CHAT_SERVICE_START = 994;
        public static final int SC_LIVE_BLIND_DATE_CLOSE = 978;
        public static final int SC_LIVE_BLIND_DATE_HIDE_AUDIENCE_PENDANT = 1012;
        public static final int SC_LIVE_BLIND_DATE_HIDE_AUTHOR_PENDANT = 1021;
        public static final int SC_LIVE_BLIND_DATE_HIDE_FLOW = 1136;
        public static final int SC_LIVE_BLIND_DATE_OPEN = 976;
        public static final int SC_LIVE_BLIND_DATE_SHOW_AUDIENCE_PENDANT = 1011;
        public static final int SC_LIVE_BLIND_DATE_SHOW_AUTHOR_PENDANT = 1020;
        public static final int SC_LIVE_BLIND_DATE_SHOW_FLOW = 1135;
        public static final int SC_LIVE_BLIND_DATE_TRY_UPDATE_AUDIENCE_PENDANT = 1013;
        public static final int SC_LIVE_BUILD_CONSULTING_INFO = 1027;
        public static final int SC_LIVE_BULLETIN = 759;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_CONTROL = 1150;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_BOTTOM_HIDE = 1282;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_BOTTOM_UPDATE = 1278;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_CLOSE_CONNECT_ALERT = 1283;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_LAYOUT_UPDATE = 1279;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_SCREEN_CLEAN = 1281;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE = 1280;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_PC_ALERT_SIGNAL = 1173;
        public static final int SC_LIVE_BULLET_CLOUD_PLAY_RENDER_SIGNAL = 1164;
        public static final int SC_LIVE_BULLET_PLAY_BOTTOM_ENTRANCE = 1147;
        public static final int SC_LIVE_BULLET_PLAY_CHAT_ENTRANCE = 1142;
        public static final int SC_LIVE_BULLET_PLAY_CHAT_PLACEHOLDER_LAYOUT = 1143;
        public static final int SC_LIVE_BULLET_PLAY_STATUS = 1152;
        public static final int SC_LIVE_BULLET_QUICK_INTERACTIVE_PANEL = 1128;
        public static final int SC_LIVE_BULLET_ROOM_BOTTOM_MASK_LAYER_STATUS = 1178;
        public static final int SC_LIVE_BULLET_SCREEN_DATA_PUSH_STATUS_SIGNAL = 1123;
        public static final int SC_LIVE_BUSINESS_PROMOTION_ENTRANCE_CLOSED = 676;
        public static final int SC_LIVE_BUSINESS_PROMOTION_ENTRANCE_OPENED = 675;
        public static final int SC_LIVE_CAR_UPDATE_CALL_BACK = 1080;
        public static final int SC_LIVE_CDN_DEGRADE_COMMAND_CNY2023 = 1064;
        public static final int SC_LIVE_CHAT_APPLY_USER_CNT_UPDATE = 1129;
        public static final int SC_LIVE_CHAT_CALL = 320;
        public static final int SC_LIVE_CHAT_CALL_ACCEPTED = 321;
        public static final int SC_LIVE_CHAT_CALL_REJECTED = 322;
        public static final int SC_LIVE_CHAT_CALL_V2 = 745;
        public static final int SC_LIVE_CHAT_COMMON_AUTHOR_INFO = 985;
        public static final int SC_LIVE_CHAT_ENDED = 325;
        public static final int SC_LIVE_CHAT_FANS_APPLY = 980;
        public static final int SC_LIVE_CHAT_GUEST_END = 324;
        public static final int SC_LIVE_CHAT_GUEST_GIFT = 812;
        public static final int SC_LIVE_CHAT_READY = 323;
        public static final int SC_LIVE_CHAT_USER_APPLY_CLOSED = 329;
        public static final int SC_LIVE_CHAT_USER_APPLY_OPENED = 328;
        public static final int SC_LIVE_CNY2023_ENTRANCE_DISPLAY_STATE = 1056;
        public static final int SC_LIVE_CNY2024_BASIC_OPERATION_PENDANT_HIGHLIGHT = 1199;
        public static final int SC_LIVE_CNY2024_BASIC_OPERATION_PENDANT_REFRESH = 1198;
        public static final int SC_LIVE_CNY2024_BATTLE_ADD_POOL = 1192;
        public static final int SC_LIVE_CNY2024_BATTLE_SHOW = 1214;
        public static final int SC_LIVE_CNY2024_BATTLE_STATE = 1191;
        public static final int SC_LIVE_CNY2024_BATTLE_STATISTIC = 1193;
        public static final int SC_LIVE_CNY2024_BATTLE_TOKEN_READY = 1213;
        public static final int SC_LIVE_CNY2024_BATTLE_VIDEO_MERGE = 1194;
        public static final int SC_LIVE_CNY2024_BULLET_PLAY_BACK_PACK_INFO = 1236;
        public static final int SC_LIVE_CNY2024_BULLET_PLAY_ENTRANCE_INFO = 1228;
        public static final int SC_LIVE_CNY2024_BULLET_PLAY_LIVE_STREAM_PENDANT = 1208;
        public static final int SC_LIVE_CNY2024_BULLET_PLAY_MAGIC_EFFECT = 1230;
        public static final int SC_LIVE_CNY2024_BULLET_PLAY_SHARE_INFO = 1229;
        public static final int SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO = 1237;
        public static final int SC_LIVE_CNY2024_CDN_DEGRADE_COMMAND = 1225;
        public static final int SC_LIVE_CNY2024_CORE_OPERATION_PENDANT_ACTION = 1197;
        public static final int SC_LIVE_CNY2024_CORE_OPERATION_PENDANT_REFRESH = 1224;
        public static final int SC_LIVE_CNY2024_EFFECTIVE_TASK_PROGRESS = 1233;
        public static final int SC_LIVE_CNY2024_ENHANCE_LIKE_DISPLAY = 1187;
        public static final int SC_LIVE_CNY2024_ENHANCE_PENDANT_DISPLAY = 1189;
        public static final int SC_LIVE_CNY2024_ENHANCE_VIEW_TEXT = 1188;
        public static final int SC_LIVE_CNY2024_FANS_ADD_RPR_NOTICE = 1184;
        public static final int SC_LIVE_CNY2024_GIFT_BOOTH_UPDATE = 1212;
        public static final int SC_LIVE_CNY2024_INDICATOR_PENDANT = 1227;
        public static final int SC_LIVE_CNY2024_KOI = 1211;
        public static final int SC_LIVE_CNY2024_PROGRAM = 1195;
        public static final int SC_LIVE_CNY2024_REPLACE = 1185;
        public static final int SC_LIVE_CNY2024_RIGHT_BOTTOM_PENDANT_ACTION = 1196;
        public static final int SC_LIVE_CNY2024_UPDATE_LIKE_STYLE = 1190;
        public static final int SC_LIVE_CNY2024_UPDATE_LIKE_TEXT = 1186;
        public static final int SC_LIVE_CNY2024_WARMUP_PRAY_PULL_REQUEST = 1222;
        public static final int SC_LIVE_CNY2024_WARMUP_PRAY_TREASURE_BOX_TOKEN_READY = 1223;
        public static final int SC_LIVE_CNY2024_WARMUP_PRAY_WISH_UPDATE = 1239;
        public static final int SC_LIVE_CNY23_CREATOR_WISH = 1055;
        public static final int SC_LIVE_CNY23_CREATOR_WISH_CLOSE = 1059;
        public static final int SC_LIVE_COMMENT_STYLE_CONFIG_SIGNAL = 1126;
        public static final int SC_LIVE_COMMON_ACTIVITY_WIDGET_CLOSE = 718;
        public static final int SC_LIVE_COMMON_ACTIVITY_WIDGET_HIDE = 717;
        public static final int SC_LIVE_COMMON_ACTIVITY_WIDGET_UPDATE = 716;
        public static final int SC_LIVE_COMMON_NOTICE = 964;
        public static final int SC_LIVE_COMMON_PRECISE_CONTROL_SIGNAL = 642;
        public static final int SC_LIVE_COMMON_ROUTE = 753;
        public static final int SC_LIVE_COMMON_ROUTE_CNY2023 = 1063;
        public static final int SC_LIVE_COMMON_STATE_SIGNAL = 641;
        public static final int SC_LIVE_COMMON_TOP_RIGHT_TK_WIDGET = 1057;
        public static final int SC_LIVE_COMMON_WEB_VIEW_DISPLAY = 752;
        public static final int SC_LIVE_CONDITION_AUDIENCE_RED_PACK_SEND = 930;
        public static final int SC_LIVE_CONDITION_AUDIENCE_RED_PACK_UPDATE = 931;
        public static final int SC_LIVE_CONDITION_RED_PACK = 735;
        public static final int SC_LIVE_CONDITION_RED_PACK_CLOSE = 739;
        public static final int SC_LIVE_CONDITION_RED_PACK_OPEN = 738;
        public static final int SC_LIVE_CONDITION_RED_PACK_ROLL_USER = 737;
        public static final int SC_LIVE_CONDITION_RED_PACK_UPDATE = 736;
        public static final int SC_LIVE_CONTENT_OP_PROMOTION = 1025;
        public static final int SC_LIVE_CORE_USER_CRM_INTERACTIVE_CHANGE = 877;
        public static final int SC_LIVE_CORE_USER_CRM_ROOM_ACTION = 876;
        public static final int SC_LIVE_CURRENT_BS_STATE = 712;
        public static final int SC_LIVE_CURRENT_LOCAL_LIFE_BS_STATE = 1006;
        public static final int SC_LIVE_CUSTOMIZATION_CONFIG_WORK_TIMELY = 1019;
        public static final int SC_LIVE_DISTRICT_HOUR_RANK_FOR_TK = 1032;
        public static final int SC_LIVE_DISTRICT_RANK_CLOSED = 588;
        public static final int SC_LIVE_DISTRICT_RANK_INFO = 587;
        public static final int SC_LIVE_DYNAMIC_STATE_INFO = 1023;
        public static final int SC_LIVE_ECO_EXPLAIN_CARD = 986;
        public static final int SC_LIVE_ENCOURAGE_TREASURE_BOX_REWARD_CARTOON = 1104;
        public static final int SC_LIVE_ENCOURAGE_TREASURE_BOX_WIDGET = 1103;
        public static final int SC_LIVE_ENTRUST_CLOSED = 690;
        public static final int SC_LIVE_ENTRUST_OPENED = 689;
        public static final int SC_LIVE_EXCLUSIVE_COMMON_ROUTE = 878;
        public static final int SC_LIVE_FANS_GROUP_ATTACH_GIFT_REPLACE_NOTICE = 864;
        public static final int SC_LIVE_FANS_GROUP_QIXI_TASK_WIDGET = 1156;
        public static final int SC_LIVE_FANS_GROUP_SLOT_FEED_SIGNAL = 1151;
        public static final int SC_LIVE_FANS_GROUP_SPECIAL_EFFECTS_SIGNAL = 1066;
        public static final int SC_LIVE_FANS_GROUP_STATUS_CHANGED = 595;
        public static final int SC_LIVE_FANS_TOP_BOOST_APPLY = 673;
        public static final int SC_LIVE_FANS_TOP_BOOST_END = 674;
        public static final int SC_LIVE_FANS_TOP_CLOSED = 522;
        public static final int SC_LIVE_FANS_TOP_OPENED = 521;
        public static final int SC_LIVE_FANS_TOP_POP_GUIDANCE = 592;
        public static final int SC_LIVE_FANS_TOP_QUICK_ORDER_NOTICE = 729;
        public static final int SC_LIVE_FLOATING_LAYER_RN_OPEN = 1172;
        public static final int SC_LIVE_FOLLOW_CARD_INFO_CLOSE_CNY2023 = 1074;
        public static final int SC_LIVE_FOLLOW_CARD_INFO_CNY2023 = 1062;
        public static final int SC_LIVE_GENERAL_COUPON_SIGNAL = 811;
        public static final int SC_LIVE_GIFT_ACHIEVEMENT_LIGHT_ON_NOTICE = 1263;
        public static final int SC_LIVE_GIFT_ACHIEVEMENT_NOTICE_USER = 1261;
        public static final int SC_LIVE_GIFT_ACHIEVEMENT_UPDATE_NOTICE = 810;
        public static final int SC_LIVE_GIFT_ACHIEVEMENT_USER_SEND_GIFT = 1262;
        public static final int SC_LIVE_GIFT_BANNER_REFRESH_MSG = 1288;
        public static final int SC_LIVE_GIFT_BOOTH_UPDATE = 1269;
        public static final int SC_LIVE_GIFT_BOOTH_UPDATE_CNY2023 = 1065;
        public static final int SC_LIVE_GIFT_COMMON_ROUTE = 956;
        public static final int SC_LIVE_GIFT_NAMING_NOTICE = 1079;
        public static final int SC_LIVE_GIFT_OUTSIDE_MESSAGE = 771;
        public static final int SC_LIVE_GIFT_PANEL_ITEM_REFRESH = 1171;
        public static final int SC_LIVE_GIFT_PANEL_REFRESH = 797;
        public static final int SC_LIVE_GIFT_PANEL_REFRESH_ROOM_VIP_INFO = 939;
        public static final int SC_LIVE_GIFT_RAMPAGE = 790;
        public static final int SC_LIVE_GIFT_TAB_REFRESH = 1209;
        public static final int SC_LIVE_GIFT_TITLE_PLAY_CHANGE_NOTICE = 1083;
        public static final int SC_LIVE_GUARD = 707;
        public static final int SC_LIVE_GUARD_CLOSE = 711;
        public static final int SC_LIVE_GUARD_NOTICE = 708;
        public static final int SC_LIVE_GUIDE_FLOW_CARD_INFO_CLOSE_SF2023 = 1072;
        public static final int SC_LIVE_GUIDE_FLOW_CARD_INFO_SF2023 = 1049;
        public static final int SC_LIVE_GUIDE_FOLLOW_AUTHOR_CARD_INFO = 874;
        public static final int SC_LIVE_GUIDE_STRATEGY = 1034;
        public static final int SC_LIVE_H5_WIDGET_STATE = 651;
        public static final int SC_LIVE_HELP_WISH_NOTICE = 1175;
        public static final int SC_LIVE_HOTSPOT_RANK_CLOSE = 991;
        public static final int SC_LIVE_HOTSPOT_RANK_UPDATE = 990;
        public static final int SC_LIVE_HOT_PROGRAMME_ENHANCE_INFO = 1132;
        public static final int SC_LIVE_HOT_PROGRAMME_ENHANCE_INFO_INDEX = 1133;
        public static final int SC_LIVE_HOT_PROGRAMME_HONOR_WIDGET = 1253;
        public static final int SC_LIVE_HOT_PROGRAMME_SPONSOR_VALUE_CHANGE_INFO = 1161;
        public static final int SC_LIVE_HOUR_RANK_INFO = 798;
        public static final int SC_LIVE_HOUSE_ANCHOR_EXPLAIN_CARD_SIGNAL = 1114;
        public static final int SC_LIVE_HOUSE_LOTTERY = 1102;
        public static final int SC_LIVE_HOUSE_PENDANT = 1101;
        public static final int SC_LIVE_IDEAT_AUDIENCE_IMMEDIATELY_POPUP = 1254;
        public static final int SC_LIVE_IDEAT_AUDIENCE_POPUP_EVENT = 1255;
        public static final int SC_LIVE_IDEAT_COMMENT_BROADCAST = 1121;
        public static final int SC_LIVE_INDUSTRY_COMMON = 1160;
        public static final int SC_LIVE_INTERACTIVE_CHAT_ENTER_ROOM = 1141;
        public static final int SC_LIVE_INTERACTIVE_CHAT_LAYOUT_CHANGE = 1116;
        public static final int SC_LIVE_INTERACTIVE_GUEST_USER_INFO_UPDATE = 846;
        public static final int SC_LIVE_INTERACTIVE_GUIDE = 852;
        public static final int SC_LIVE_INTERACTIVE_GUIDE_CLOSE = 998;
        public static final int SC_LIVE_INTERACTIVE_MAGIC_EFFECT_EVENT = 1090;
        public static final int SC_LIVE_INTERACTIVE_MINI_PROGRAM_STATUS = 1108;
        public static final int SC_LIVE_INTERACTIVE_WIDGET = 914;
        public static final int SC_LIVE_JOB_PENDANT = 890;
        public static final int SC_LIVE_KLINK_MESSAGE = 879;
        public static final int SC_LIVE_KRN_RED_PACK_SHOW = 920;
        public static final int SC_LIVE_KS_VOICE_STARTED = 462;
        public static final int SC_LIVE_KS_VOICE_STOPPED = 463;
        public static final int SC_LIVE_LEEE_LITE = 1024;
        public static final int SC_LIVE_LIMIT_ON_SHOP = 1076;
        public static final int SC_LIVE_LINE_CHAT_END = 733;
        public static final int SC_LIVE_LINE_CHAT_INFO_UPDATE = 734;
        public static final int SC_LIVE_LINE_CHAT_INVITE = 730;
        public static final int SC_LIVE_LINE_CHAT_MATCHED = 731;
        public static final int SC_LIVE_LINE_CHAT_READY = 732;
        public static final int SC_LIVE_LITE_ENTER_ROOM_GUIDE = 1069;
        public static final int SC_LIVE_LIVE_QUIZ_START_SF2023 = 1042;
        public static final int SC_LIVE_LOCAL_LIFE_BULLET_NOTICE_SIGNAL = 1086;
        public static final int SC_LIVE_LOCAL_LIFE_EXPLAIN_CARD = 1005;
        public static final int SC_LIVE_LOCAL_LIFE_EXPLAIN_CARD_STOCK_NOTICE = 1124;
        public static final int SC_LIVE_LOCAL_LIFE_HOT_SELL_PRODUCT_LIST_SIGNAL = 1087;
        public static final int SC_LIVE_LOCAL_LIFE_PENDANT_OPEN_NOTICE = 1119;
        public static final int SC_LIVE_LOCAL_LIFE_PENDANT_SHOW_NOTICE = 1118;
        public static final int SC_LIVE_LOCAL_LIFE_PUT_AWAY_NOTICE_BUBBLE = 1085;
        public static final int SC_LIVE_LOCAL_LIFE_REFRESH = 1007;
        public static final int SC_LIVE_LOCAL_LIFE_REFRESH_EXPLAIN_CARD_SIGNAL = 1162;
        public static final int SC_LIVE_LOCAL_LIFE_RESOURCE_SIGNAL_DATA = 1130;
        public static final int SC_LIVE_LOCATION_PRODUCT_LIST_UPDATE = 1038;
        public static final int SC_LIVE_LUCKY_STAR_PARTICIPANT_STATUS = 909;
        public static final int SC_LIVE_MAGIC_FACE_ENTRANCE_STATE = 800;
        public static final int SC_LIVE_MAGIC_FACE_STATE = 799;
        public static final int SC_LIVE_MASK = 541;
        public static final int SC_LIVE_MATE_AUTHOR_FEED = 929;
        public static final int SC_LIVE_MATE_AUTHOR_MULTI_WIDGET_SIGNAL = 951;
        public static final int SC_LIVE_MATE_AUTHOR_WIDGET_SIGNAL = 928;
        public static final int SC_LIVE_MATE_PC_PARAM_CHANGED = 542;
        public static final int SC_LIVE_MATE_VIP_USER_ENTER_ROOM = 948;
        public static final int SC_LIVE_MERCHANT_CARD_INFO_CLOSE_CNY2023 = 1073;
        public static final int SC_LIVE_MERCHANT_CARD_INFO_CNY2023 = 1061;
        public static final int SC_LIVE_MINI_PROGRAM_AUDIENCE_BOTTOM_ENTRANCE = 1082;
        public static final int SC_LIVE_MODULE_SHIELD_CONFIG_SIGNAL = 1125;
        public static final int SC_LIVE_MULTI_CHAT_MEDIA_TYPE_SWITCH_ACK = 1100;
        public static final int SC_LIVE_MULTI_CHAT_MEDIA_TYPE_SWITCH_APPLY = 1099;
        public static final int SC_LIVE_MULTI_CHAT_OPENED = 1138;
        public static final int SC_LIVE_MULTI_INTERACTIVE_INFO = 946;
        public static final int SC_LIVE_MULTI_LINE_CHAT_OPENED = 1008;
        public static final int SC_LIVE_MULTI_LINE_CHAT_PIT_GUIDE = 999;
        public static final int SC_LIVE_MULTI_LINE_PK_PREPARE_UPDATE = 1037;
        public static final int SC_LIVE_MULTI_PK_ADVANCE_LEAVE = 1134;
        public static final int SC_LIVE_MULTI_PK_APPLY_CONTINUE_INVITE_POPUP = 1028;
        public static final int SC_LIVE_MULTI_PK_APPLY_END_POPUP = 984;
        public static final int SC_LIVE_MULTI_PK_CRIT_MOMENT = 977;
        public static final int SC_LIVE_MULTI_PK_LOGGING_GUIDE = 981;
        public static final int SC_LIVE_MULTI_PK_MATCH_CANCEL = 1001;
        public static final int SC_LIVE_MULTI_PK_MATCH_GUIDE_SHOW = 979;
        public static final int SC_LIVE_MULTI_PK_MISSION_EASTER_MOMENT = 1267;
        public static final int SC_LIVE_MULTI_PK_MISSION_START = 1265;
        public static final int SC_LIVE_MULTI_PK_MISSION_STATISTIC = 1266;
        public static final int SC_LIVE_MULTI_PK_REOPEN_INVITE = 996;
        public static final int SC_LIVE_MULTI_PK_REOPEN_RESPOND = 997;
        public static final int SC_LIVE_MULTI_PK_STATISTIC = 950;
        public static final int SC_LIVE_MULTI_PK_VOTE_END = 953;
        public static final int SC_LIVE_NEBULA_GOLD_COIN_TASK_INFO = 623;
        public static final int SC_LIVE_NEW_ACTIVITY_PENDANT = 803;
        public static final int SC_LIVE_NEW_ACTIVITY_PENDANT_CLOSE = 805;
        public static final int SC_LIVE_NOBLE_PROTECT_NOTICE = 851;
        public static final int SC_LIVE_OFFICIAL_PROGRAMME_DUMP_AUDIENCE = 1110;
        public static final int SC_LIVE_OFFICIAL_PROGRAMME_ENHANCE_INFO = 1109;
        public static final int SC_LIVE_OFFICIAL_PROGRAMME_SHUNT_AUDIENCE = 1111;
        public static final int SC_LIVE_ORDERS_ENTRANCE = 1177;
        public static final int SC_LIVE_ORG_RECRUIT_UPDATE = 1168;
        public static final int SC_LIVE_ORG_RECRUIT_USER_APPLY_SUCCESS = 1169;
        public static final int SC_LIVE_OTT_OPERATE_NOTICE = 1022;
        public static final int SC_LIVE_OVER_ROOM_MESSAGE = 744;
        public static final int SC_LIVE_OVER_ROOM_MESSAGE_V2 = 746;
        public static final int SC_LIVE_PARTY_PLAY_APP_CLOSE = 1271;
        public static final int SC_LIVE_PARTY_PLAY_BOTTOM_HIDE = 1275;
        public static final int SC_LIVE_PARTY_PLAY_PARTICIPATE_STATUS = 1285;
        public static final int SC_LIVE_PARTY_PLAY_ROOM_LAYOUT_UPDATE = 1272;
        public static final int SC_LIVE_PARTY_PLAY_SCREEN_CLEAN = 1273;
        public static final int SC_LIVE_PARTY_PLAY_STATUS = 1284;
        public static final int SC_LIVE_PET_CLOSED = 591;
        public static final int SC_LIVE_PET_OPENED = 590;
        public static final int SC_LIVE_PK_BOUNTY_GAME_MATCH = 754;
        public static final int SC_LIVE_PK_BUFF_CARD_MOMENT = 917;
        public static final int SC_LIVE_PK_COHESION_GIFT_SEND_COMPLETION_NOTICE = 962;
        public static final int SC_LIVE_PK_FIRST_BLOOD = 677;
        public static final int SC_LIVE_PK_GIFT_CRIT_MOMENT = 723;
        public static final int SC_LIVE_PK_KO_INFO = 767;
        public static final int SC_LIVE_PK_KO_MODE = 768;
        public static final int SC_LIVE_PK_LUCKY_TIME_CONTRIBUTION = 826;
        public static final int SC_LIVE_PK_PANEL_NOTICE_TIP_V2 = 1089;
        public static final int SC_LIVE_PK_PRE_GIFT_CRIT_STATISTIC = 750;
        public static final int SC_LIVE_PK_REOPEN_INFO = 762;
        public static final int SC_LIVE_PK_REOPEN_INVITE = 760;
        public static final int SC_LIVE_PK_REOPEN_RESPOND = 761;
        public static final int SC_LIVE_PK_REVENGE_SUPPORT_INFO = 808;
        public static final int SC_LIVE_PK_REVENGE_TOP_USER_LIKE = 809;
        public static final int SC_LIVE_PK_SIGNAL_ROOM_CREATE = 685;
        public static final int SC_LIVE_PK_SKIN_THEME = 889;
        public static final int SC_LIVE_PK_STATE = 974;
        public static final int SC_LIVE_PLUS_ACTIVITY_PENDANT = 1093;
        public static final int SC_LIVE_PLUS_ACTIVITY_PENDANT_CLOSE = 1094;
        public static final int SC_LIVE_PLUS_RECRUIT_AUDIENCE_PANEL_CLOSE = 989;
        public static final int SC_LIVE_PLUS_RECRUIT_AUDIENCE_WIDGET = 882;
        public static final int SC_LIVE_PLUS_RECRUIT_AUTHOR_PANEL_CONDITION = 987;
        public static final int SC_LIVE_PLUS_RECRUIT_AUTHOR_WIDGET = 881;
        public static final int SC_LIVE_PLUS_RECRUIT_BUTTON = 880;
        public static final int SC_LIVE_PLUS_RECRUIT_COMMON_WIDGET_CLOSE = 1035;
        public static final int SC_LIVE_PLUS_RECRUIT_PANEL_DISPLAY = 988;
        public static final int SC_LIVE_PLUS_RECRUIT_RANK_INFO = 1026;
        public static final int SC_LIVE_PLUTUS_ENHANCE_MODE = 1268;
        public static final int SC_LIVE_POPULARITY_RANK_CLOSED = 859;
        public static final int SC_LIVE_POPULARITY_RANK_IMPETUS_PENDANT = 1075;
        public static final int SC_LIVE_POPULARITY_RANK_INFO = 858;
        public static final int SC_LIVE_POPULARITY_RANK_NEW_TEMPLATE_EFFECT_INFO = 1277;
        public static final int SC_LIVE_POPULARITY_TICKET_ENCOURAGE_BATTLE_INFO = 1287;
        public static final int SC_LIVE_POP_UP = 701;
        public static final int SC_LIVE_PRIME_AUDIENCE_ENTER_ROOM = 947;
        public static final int SC_LIVE_PROFIT_AREA = 1018;
        public static final int SC_LIVE_PULL_REQUEST = 1052;
        public static final int SC_LIVE_PUZZLE_LINE_CHAT_STATISTICS = 1084;
        public static final int SC_LIVE_QUESTIONNAIRE = 720;
        public static final int SC_LIVE_QUESTIONNAIRE_V2 = 1158;
        public static final int SC_LIVE_QUICK_COMMENT_CHANGED = 602;
        public static final int SC_LIVE_QUICK_COMMENT_CLOSED = 912;
        public static final int SC_LIVE_QUICK_COMMENT_CONTAINER_CLOSE = 955;
        public static final int SC_LIVE_QUICK_COMMENT_CONTAINER_OPEN = 954;
        public static final int SC_LIVE_QUICK_COMMENT_OPENED = 911;
        public static final int SC_LIVE_QUICK_INTERACTIVE_AREA = 1068;
        public static final int SC_LIVE_QUICK_INTERACTIVE_GIFT_TRIGGER = 1067;
        public static final int SC_LIVE_QUICK_INTERACT_GIFT_AREA = 1226;
        public static final int SC_LIVE_QUICK_INTERACT_GIFT_UPDATE = 1240;
        public static final int SC_LIVE_QUIZ2_AWARD_REVIEWED = 615;
        public static final int SC_LIVE_QUIZ2_CLOSE_CONFIG = 617;
        public static final int SC_LIVE_QUIZ2_EMERGENCY_ENDED = 613;
        public static final int SC_LIVE_QUIZ2_INIT_CONFIG = 616;
        public static final int SC_LIVE_QUIZ2_QUESTION_ASKED = 610;
        public static final int SC_LIVE_QUIZ2_QUESTION_REVIEWED = 611;
        public static final int SC_LIVE_QUIZ2_SYNC = 612;
        public static final int SC_LIVE_QUIZ2_WIDGET_CONTENT = 614;
        public static final int SC_LIVE_QUIZ3_EMERGENCY_ENDED = 1203;
        public static final int SC_LIVE_QUIZ3_END_WINNER_CALCULATION = 1232;
        public static final int SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION = 1231;
        public static final int SC_LIVE_QUIZ3_PUBLISH_STAGE_WINNER = 1206;
        public static final int SC_LIVE_QUIZ3_QUESTION = 1201;
        public static final int SC_LIVE_QUIZ3_REVIVE_CARD_SYNC = 1204;
        public static final int SC_LIVE_QUIZ3_START_PUBLISH_ROUND_WINNER = 1205;
        public static final int SC_LIVE_QUIZ3_SYNC = 1200;
        public static final int SC_LIVE_QUIZ_COUNT_DOWN_SF2023 = 1043;
        public static final int SC_LIVE_QUIZ_EMERGENCY_STOP_SF2023 = 1045;
        public static final int SC_LIVE_QUIZ_ENDED = 353;
        public static final int SC_LIVE_QUIZ_PROCESS_STATUS_SF2023 = 1046;
        public static final int SC_LIVE_QUIZ_PUBLISH_ANSWER_SF2023 = 1044;
        public static final int SC_LIVE_QUIZ_QUESTION_ASKED = 350;
        public static final int SC_LIVE_QUIZ_QUESTION_REVIEWED = 351;
        public static final int SC_LIVE_QUIZ_SF_LEE_SHOW_SF2023 = 1041;
        public static final int SC_LIVE_QUIZ_SF_LEE_TOKEN_READY_SF2023 = 1040;
        public static final int SC_LIVE_QUIZ_SYNC = 352;
        public static final int SC_LIVE_QUIZ_SYNC_SF2023 = 1047;
        public static final int SC_LIVE_QUIZ_WINNERS = 354;
        public static final int SC_LIVE_RANKLIST_PENDANT = 1159;
        public static final int SC_LIVE_RANK_LITE_NOTICE = 1029;
        public static final int SC_LIVE_RANK_VISIBLE_RESET_INFO = 1097;
        public static final int SC_LIVE_RANK_VISIBLE_UPDATE_INFO = 1091;
        public static final int SC_LIVE_RECORD_STATE = 700;
        public static final int SC_LIVE_RECRUIT_APPLY_QUESTION = 970;
        public static final int SC_LIVE_RECRUIT_AUDIENCE_IMMEDIATELY_POPUP = 1251;
        public static final int SC_LIVE_RECRUIT_AUDIENCE_POPUP_EVENT = 1252;
        public static final int SC_LIVE_RECRUIT_AUTHOR_POPUP = 1039;
        public static final int SC_LIVE_RECRUIT_COMMENT_BROADCAST = 971;
        public static final int SC_LIVE_RECRUIT_EXPLAIN_PANEL_DISPLAY_SIGNAL = 1127;
        public static final int SC_LIVE_RECRUIT_RIGHT_PENDANT_TK_WIDGET = 1139;
        public static final int SC_LIVE_RECRUIT_SHARE_GUIDE = 966;
        public static final int SC_LIVE_REPUSH_STOP_PUSH_POPUP = 1078;
        public static final int SC_LIVE_RESERVATION_STICKER_CLOSE = 908;
        public static final int SC_LIVE_RESERVATION_STICKER_INFO = 907;
        public static final int SC_LIVE_RESERVATION_STICKER_REMOVE = 828;
        public static final int SC_LIVE_RESERVATION_STICKER_UPDATE = 827;
        public static final int SC_LIVE_REVENUE_ACTIVITY_INFO_UPDATE = 892;
        public static final int SC_LIVE_REVENUE_ALIPAY_DISCOUNT_QUICK_ENTRANCE = 1264;
        public static final int SC_LIVE_REVENUE_BLESSING_BAG_NOTICE = 1017;
        public static final int SC_LIVE_REVENUE_BLESSING_BAG_TOAST = 1016;
        public static final int SC_LIVE_REVENUE_BLESSING_BAG_WIDGET = 1015;
        public static final int SC_LIVE_REVENUE_DELIVERY_FLOW_DIVERSION_CONTROL = 813;
        public static final int SC_LIVE_REVENUE_FUNCTION_SWITCH_CONFIG = 1286;
        public static final int SC_LIVE_REVENUE_GIFT_PANEL_RECHARGE_ENTRANCE = 1058;
        public static final int SC_LIVE_RICH_TEXT_FEED_PUSH = 702;
        public static final int SC_LIVE_ROOM_VOICE_NOTIFICATION_MESSAGE = 749;
        public static final int SC_LIVE_SCORE_LINE_CHAT_STATISTIC = 1010;
        public static final int SC_LIVE_SCORE_LINE_CHAT_VOTE_END = 1009;
        public static final int SC_LIVE_SELLING_CHAT_INDICATOR = 982;
        public static final int SC_LIVE_SERVER_SIGNAL_BLOCK_MESSAGE = 1247;
        public static final int SC_LIVE_SETTING_INFO = 1157;
        public static final int SC_LIVE_SHARE_GUIDE = 823;
        public static final int SC_LIVE_SHARE_RED_PACK_AUTHOR_PUBLISH = 581;
        public static final int SC_LIVE_SHARE_RED_PACK_PARTICIPANT_COUNT = 582;
        public static final int SC_LIVE_SHARE_RED_PACK_TERMINATE = 583;
        public static final int SC_LIVE_SHARE_REMIND = 565;
        public static final int SC_LIVE_SHOP_ACTION = 363;
        public static final int SC_LIVE_SHOP_STATE = 362;
        public static final int SC_LIVE_SIGNAL_TEST = 1030;
        public static final int SC_LIVE_SMALL_PLAY_BOTTOM_UPDATE = 1270;
        public static final int SC_LIVE_SMALL_PLAY_RIGHT_BOTTOM_PENDANT = 1276;
        public static final int SC_LIVE_SPECIAL_ACCOUNT_CONFIG_STATE = 645;
        public static final int SC_LIVE_SPECIAL_TAG_CLOSE = 1071;
        public static final int SC_LIVE_SPECIAL_TAG_UPDATE = 1070;
        public static final int SC_LIVE_START_SUPER_FANS_WISH_NOTICE = 1174;
        public static final int SC_LIVE_START_WISH_LIST_NOTICE = 1154;
        public static final int SC_LIVE_STICKER_DECORATION = 1122;
        public static final int SC_LIVE_STICKER_UPDATED = 679;
        public static final int SC_LIVE_STICKER_WARNING = 684;
        public static final int SC_LIVE_STREAM_LATENCY_CHANGED_SIGNAL = 1115;
        public static final int SC_LIVE_STREAM_PLATFORM_NOTIFICATION = 1238;
        public static final int SC_LIVE_SURPRISE_RED_PACK_NOTICE = 713;
        public static final int SC_LIVE_TAG_CLOSE = 766;
        public static final int SC_LIVE_TAG_UPDATE = 765;
        public static final int SC_LIVE_TOOL_PLAY_CUSTOMISE_PANEL_SIGNAL = 1246;
        public static final int SC_LIVE_TOP1_USER_PRIVILEGE = 693;
        public static final int SC_LIVE_TOP_USER_FORBIDDEN_DIALOG = 764;
        public static final int SC_LIVE_TOP_USER_SCORE_EVENT_TOAST = 961;
        public static final int SC_LIVE_TRAFFIC_OP_PENDANT_CLOSED = 1166;
        public static final int SC_LIVE_TRAFFIC_OP_PENDANT_INFO = 837;
        public static final int SC_LIVE_TREASURE_BOX_CLOSE = 1210;
        public static final int SC_LIVE_TREASURE_BOX_SHOW = 748;
        public static final int SC_LIVE_TREASURE_BOX_TOKEN_READY = 691;
        public static final int SC_LIVE_TYPE_COMMENT_PLACEHOLDER = 709;
        public static final int SC_LIVE_UNION_LIVE_APPLY = 781;
        public static final int SC_LIVE_UNION_LIVE_APPLY_INVALID = 795;
        public static final int SC_LIVE_UNION_LIVE_AUTHORITY_CHANGED = 796;
        public static final int SC_LIVE_UNION_LIVE_AUTHOR_STATE_CHANGED = 782;
        public static final int SC_LIVE_UNION_LIVE_INVITE = 780;
        public static final int SC_LIVE_UNION_LIVE_INVITE_INVALID = 794;
        public static final int SC_LIVE_USER_INFO_UPDATE = 836;
        public static final int SC_LIVE_USER_TASK_COMMON_ROUTE = 959;
        public static final int SC_LIVE_USER_TASK_STATUS_UPDATE = 958;
        public static final int SC_LIVE_VIRTUAL_IMAGE_SIGNAL = 1000;
        public static final int SC_LIVE_VOICE_PARTY_ABOARD_APPLY_RESULT = 763;
        public static final int SC_LIVE_VOICE_PARTY_CLOSE_GUEST_VIDEO = 862;
        public static final int SC_LIVE_VOICE_PARTY_COMMON_TOAST = 1274;
        public static final int SC_LIVE_VOICE_PARTY_COVER_AUDIT_RESULT = 756;
        public static final int SC_LIVE_VOICE_PARTY_GRID_CHAT_SOLO_PK_STATISTIC = 1145;
        public static final int SC_LIVE_VOICE_PARTY_GUEST_FOLLOW_AUTHOR = 923;
        public static final int SC_LIVE_VOICE_PARTY_GUEST_VIDEO_AUTHORITY = 860;
        public static final int SC_LIVE_VOICE_PARTY_GUEST_VIOLATION_POPUP = 814;
        public static final int SC_LIVE_VOICE_PARTY_INVITE_GUEST_OPEN_VIDEO = 861;
        public static final int SC_LIVE_VOICE_PARTY_LAST_LAYOUT_INFO_SNAPSHOT = 1149;
        public static final int SC_LIVE_VOICE_PARTY_MIC_SEAT_USER_BOMB_INFO = 887;
        public static final int SC_LIVE_VOICE_PARTY_MIC_SEAT_USER_LEVEL_UP_NOTICE = 945;
        public static final int SC_LIVE_VOICE_PARTY_NORMAL_PLAY_CLOSED = 1258;
        public static final int SC_LIVE_VOICE_PARTY_NORMAL_PLAY_OPENED = 1257;
        public static final int SC_LIVE_VOICE_PARTY_PK_ACCEPT = 839;
        public static final int SC_LIVE_VOICE_PARTY_PK_END = 842;
        public static final int SC_LIVE_VOICE_PARTY_PK_INVITATION = 838;
        public static final int SC_LIVE_VOICE_PARTY_PK_OPERATION = 1256;
        public static final int SC_LIVE_VOICE_PARTY_PK_OP_MIC_SEATS = 844;
        public static final int SC_LIVE_VOICE_PARTY_PK_OP_MUTE_STATUS = 845;
        public static final int SC_LIVE_VOICE_PARTY_PK_START = 840;
        public static final int SC_LIVE_VOICE_PARTY_PK_STATISTIC = 841;
        public static final int SC_LIVE_VOICE_PARTY_PK_SWITCH_ROOM = 843;
        public static final int SC_LIVE_VOICE_PARTY_PLAY_TYPE_SWITCH = 822;
        public static final int SC_LIVE_VOICE_PARTY_PLAY_TYPE_SWITCH_NEW = 1183;
        public static final int SC_LIVE_VOICE_PARTY_VIDEO_CLOSED = 1260;
        public static final int SC_LIVE_VOICE_PARTY_VIDEO_OPENED = 1259;
        public static final int SC_LIVE_VOTE_CHANGED = 500;
        public static final int SC_LIVE_VOTE_CLOSED = 501;
        public static final int SC_LIVE_WARNING_MASK_STATUS_CHANGED = 593;
        public static final int SC_LIVE_WARNING_MASK_STATUS_CHANGED_AUDIENCE = 758;
        public static final int SC_LIVE_WARNING_MASK_STATUS_CHANGED_AUTHOR = 757;
        public static final int SC_LIVE_WATCHING_LIST = 340;
        public static final int SC_LIVE_WATCHING_LIST_NOTICE = 965;
        public static final int SC_LIVE_WEALTH_GRADE_UPGRADED = 664;
        public static final int SC_LIVE_WEB_VIEW_DISPLAY = 620;
        public static final int SC_LIVE_WEEK_RANK_DISABLE = 722;
        public static final int SC_LIVE_WEEK_RANK_ENABLE = 721;
        public static final int SC_LIVE_WHEEL_DECIDE_CLOSED = 571;
        public static final int SC_LIVE_WHEEL_DECIDE_OPENED = 570;
        public static final int SC_LIVE_WISHROOM_BULLET_COMMENT_PUSH_INFOS = 888;
        public static final int SC_LIVE_WISH_COUNT_UPDATE = 891;
        public static final int SC_LIVE_WISH_POINT_NOTICE = 1176;
        public static final int SC_LIVE_YEAR_CEREMONY23_FINGER_GUESS_QUICK_GIFT_UPDATE = 1180;
        public static final int SC_LTE_QOS_GRAB_TOKEN = 560;
        public static final int SC_LUCKY_STAR_ABNORMAL_END = 654;
        public static final int SC_LUCKY_STAR_OPENED = 653;
        public static final int SC_LUCKY_STAR_ROLL_USER_READY = 657;
        public static final int SC_LUCKY_STAR_STARTED = 652;
        public static final int SC_MIC_SEATS = 432;
        public static final int SC_MIC_SEATS_APPLY_INFO = 436;
        public static final int SC_MIC_SEATS_INFO = 439;
        public static final int SC_MIC_SEATS_INVITATION = 434;
        public static final int SC_MIC_SEATS_INVITATION_INFO = 440;
        public static final int SC_MIC_SEATS_LEFT = 433;
        public static final int SC_MIC_SEATS_MIC_FORCED_STATUS = 435;
        public static final int SC_MILLION_RED_PACK_TERMINATE = 603;
        public static final int SC_MULTI_LINE_CHAT_WISH_LIST = 973;
        public static final int SC_MUSIC_STATION_LIVE_STREAM_ADDED = 460;
        public static final int SC_MUSIC_STATION_LIVE_STREAM_REMOVED = 461;
        public static final int SC_PING_ACK = 104;
        public static final int SC_PIP_ENDED = 306;
        public static final int SC_PIP_STARTED = 305;
        public static final int SC_PK_ABNORMAL_END = 382;
        public static final int SC_PK_FORMAT_CHANGE_INVITE = 387;
        public static final int SC_PK_GAME_END = 388;
        public static final int SC_PK_GAME_INVITE = 687;
        public static final int SC_PK_GAME_START = 688;
        public static final int SC_PK_INVITATION = 380;
        public static final int SC_PK_INVITATION_CLOSE = 719;
        public static final int SC_PK_LIKE_MOMENT_STARTED = 385;
        public static final int SC_PK_OTHER_PLAYER_VOICE_CLOSED = 384;
        public static final int SC_PK_OTHER_PLAYER_VOICE_OPENED = 383;
        public static final int SC_PK_RANK_GAME_SCORE = 389;
        public static final int SC_PK_STARTED = 386;
        public static final int SC_PK_STATISTIC = 381;
        public static final int SC_POP_COMMODITY = 419;
        public static final int SC_REAL_TIME_RECOGNITION_MUSIC_INFO = 562;
        public static final int SC_REAL_TIME_SIGNAL_CHANNEL_MONITOR = 511;
        public static final int SC_RED_PACK_FEED = 330;
        public static final int SC_RED_PACK_RAIN_GROUP_CLOSED = 422;
        public static final int SC_RED_PACK_RAIN_HIDDEN = 423;
        public static final int SC_RED_PACK_RAIN_READY = 420;
        public static final int SC_RED_PACK_RAIN_RESOURCE = 427;
        public static final int SC_RED_PACK_RAIN_SHOW = 424;
        public static final int SC_RED_PACK_RAIN_TOKEN_READY = 421;
        public static final int SC_RED_PACK_RAIN_WIDGET_CLOSE = 426;
        public static final int SC_RED_PACK_RAIN_WIDGET_READY = 425;
        public static final int SC_REFRESH_WALLET = 312;
        public static final int SC_RENDERING_MAGIC_FACE_DISABLE = 326;
        public static final int SC_RENDERING_MAGIC_FACE_DISABLE_AUDIENCE_PART = 936;
        public static final int SC_RENDERING_MAGIC_FACE_DISABLE_AUTHOR_PART = 935;
        public static final int SC_RENDERING_MAGIC_FACE_ENABLE = 327;
        public static final int SC_RENDERING_MAGIC_FACE_ENABLE_AUDIENCE_PART = 938;
        public static final int SC_RENDERING_MAGIC_FACE_ENABLE_AUTHOR_PART = 937;
        public static final int SC_REQUEST_WARMUP = 399;
        public static final int SC_RIDDLE_CLOESED = 391;
        public static final int SC_RIDDLE_OPENED = 390;
        public static final int SC_RIDE_CHANGED = 412;
        public static final int SC_SANDEAGO_AUTHORITY = 553;
        public static final int SC_SANDEAGO_CLOSED = 551;
        public static final int SC_SANDEAGO_CONTROL = 554;
        public static final int SC_SANDEAGO_CURRENT_STOCK = 552;
        public static final int SC_SANDEAGO_OPENED = 550;
        public static final int SC_SF_PEAK_AUTHOR_RANK_WIDGET_CHANGED = 604;
        public static final int SC_SF_PEAK_AUTHOR_RANK_WIDGET_CLOSED = 605;
        public static final int SC_SF_PEAK_AUTHOR_RANK_WINNER_NOTICE = 606;
        public static final int SC_SHOP_CLOSED = 361;
        public static final int SC_SHOP_ENTRANCE_CONTROL = 1098;
        public static final int SC_SHOP_MERCHANT_SQUARE_OPENED = 585;
        public static final int SC_SHOP_MERCHANT_START_PLAY_NOTICE = 586;
        public static final int SC_SHOP_OPENED = 360;
        public static final int SC_SHOP_THIRD_CONTROL = 1077;
        public static final int SC_SUSPECTED_VIOLATION = 355;
        public static final int SC_TEAM_PK_END = 650;
        public static final int SC_TEAM_PK_ROOM_CLOSED = 647;
        public static final int SC_TEAM_PK_ROOM_OPENED = 646;
        public static final int SC_TEAM_PK_START = 648;
        public static final int SC_TEAM_PK_STATISTIC_INFO = 649;
        public static final int SC_THANKS_RED_PACK_TERMINATE = 601;
        public static final int SC_THANKS_RED_PACK_WIDGET = 600;
        public static final int SC_THANKS_SHARE_BACK_SUCCESS_AUTHOR_NOTIFICATION = 608;
        public static final int SC_THANKS_SHARE_BACK_SUCCESS_NOTIFICATION = 607;
        public static final int SC_THEATER_CLOSED = 631;
        public static final int SC_THEATER_EPISODE_ORDER_FINISHED = 633;
        public static final int SC_THEATER_EPISODE_SWITCH_TOAST = 634;
        public static final int SC_THEATER_NEXT_EPISODE_ORDER_INFO = 632;
        public static final int SC_THEATER_OPENED = 630;
        public static final int SC_TOP_BANNER_BROADCAST = 533;
        public static final int SC_TOP_BANNER_NOTICE = 531;
        public static final int SC_TOP_BROADCAST_NOTICE = 532;
        public static final int SC_VOICE_COMMENT_BGM_CLOSED = 403;
        public static final int SC_VOICE_COMMENT_BGM_OPENED = 402;
        public static final int SC_VOICE_COMMENT_CLOSED = 401;
        public static final int SC_VOICE_COMMENT_CONFIG_UPDATE = 925;
        public static final int SC_VOICE_COMMENT_OPENED = 400;
        public static final int SC_VOICE_PARTY_BACKGROUND_AUDIT_NOT_PASSED = 834;
        public static final int SC_VOICE_PARTY_CLOSED = 431;
        public static final int SC_VOICE_PARTY_COMMON_INFO = 437;
        public static final int SC_VOICE_PARTY_ENTER_ROOM_NOTICE = 438;
        public static final int SC_VOICE_PARTY_GRID_CHAT_CLOSED = 933;
        public static final int SC_VOICE_PARTY_GRID_CHAT_OPENED = 932;
        public static final int SC_VOICE_PARTY_OPENED = 430;
        public static final int SC_VOIP_SIGNAL = 308;
        public static final int SC_WISH_LIST_CLOSED = 411;
        public static final int SC_WISH_LIST_OPENED = 410;
        public static final int SC_X_STREAM_LIVE_CARD_LIST_INFO = 894;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SCInfoType {
        public static final int BEAUTY_DISABLE = 100;
        public static final int BEAUTY_ENABLE = 101;
        public static final int LIVESTREAM_PROVIDER_CHANGED = 6111;
        public static final int UNKNOWN_INFO_TYPE = 0;
    }

    public static final class SocketMessage extends MessageNano {
        private static volatile SocketMessage[] _emptyArray;
        public byte[] ackInfo;
        public int compressionType;
        public String messageId;
        public boolean needAck;
        public byte[] payload;
        public int payloadType;
        public String reportId;
        public long time;

        @Retention(RetentionPolicy.SOURCE)
        public @interface CompressionType {
            public static final int AES = 3;
            public static final int GZIP = 2;
            public static final int NONE = 1;
            public static final int UNKNOWN = 0;
        }

        public static SocketMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SocketMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SocketMessage() {
            clear();
        }

        public final SocketMessage clear() {
            this.payloadType = 0;
            this.compressionType = 0;
            this.payload = WireFormatNano.EMPTY_BYTES;
            this.time = 0L;
            this.reportId = "";
            this.messageId = "";
            this.needAck = false;
            this.ackInfo = WireFormatNano.EMPTY_BYTES;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.payloadType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.compressionType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(3, this.payload);
            }
            long j = this.time;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (!this.reportId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.reportId);
            }
            if (!this.messageId.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.messageId);
            }
            boolean z = this.needAck;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            if (!Arrays.equals(this.ackInfo, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(8, this.ackInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.payloadType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.compressionType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
            }
            if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(3, this.payload);
            }
            long j = this.time;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (!this.reportId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.reportId);
            }
            if (!this.messageId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.messageId);
            }
            boolean z = this.needAck;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
            }
            return !Arrays.equals(this.ackInfo, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(8, this.ackInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SocketMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 3:
                        case 4:
                        case 51:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 200:
                        case 201:
                        case 202:
                        case 203:
                        case 204:
                        case 205:
                        case 206:
                        case 207:
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                        case 304:
                        case 305:
                        case 306:
                        case 307:
                        case 308:
                        case 310:
                        case 311:
                        case 312:
                        case 320:
                        case 321:
                        case 322:
                        case 323:
                        case 324:
                        case 325:
                        case 326:
                        case 327:
                        case 328:
                        case 329:
                        case 330:
                        case 331:
                        case 340:
                        case PayloadType.SC_LIVE_QUIZ_QUESTION_ASKED /* 350 */:
                        case 351:
                        case 352:
                        case 353:
                        case 354:
                        case 355:
                        case 356:
                        case 357:
                        case 360:
                        case 361:
                        case 362:
                        case 363:
                        case 370:
                        case 371:
                        case 380:
                        case 381:
                        case 382:
                        case 383:
                        case 384:
                        case 385:
                        case 386:
                        case 387:
                        case 388:
                        case 389:
                        case 390:
                        case 391:
                        case 399:
                        case 400:
                        case 401:
                        case 402:
                        case 403:
                        case PayloadType.SC_WISH_LIST_OPENED /* 410 */:
                        case PayloadType.SC_WISH_LIST_CLOSED /* 411 */:
                        case PayloadType.SC_RIDE_CHANGED /* 412 */:
                        case 414:
                        case 415:
                        case 416:
                        case PayloadType.SC_FANS_TOP_OPENED /* 417 */:
                        case 418:
                        case PayloadType.SC_POP_COMMODITY /* 419 */:
                        case 420:
                        case 421:
                        case 422:
                        case 423:
                        case 424:
                        case 425:
                        case 426:
                        case PayloadType.SC_RED_PACK_RAIN_RESOURCE /* 427 */:
                        case 430:
                        case 431:
                        case 432:
                        case 433:
                        case PayloadType.SC_MIC_SEATS_INVITATION /* 434 */:
                        case PayloadType.SC_MIC_SEATS_MIC_FORCED_STATUS /* 435 */:
                        case PayloadType.SC_MIC_SEATS_APPLY_INFO /* 436 */:
                        case PayloadType.SC_VOICE_PARTY_COMMON_INFO /* 437 */:
                        case PayloadType.SC_VOICE_PARTY_ENTER_ROOM_NOTICE /* 438 */:
                        case PayloadType.SC_MIC_SEATS_INFO /* 439 */:
                        case PayloadType.SC_MIC_SEATS_INVITATION_INFO /* 440 */:
                        case PayloadType.SC_BET_CHANGED /* 441 */:
                        case PayloadType.SC_BET_CLOSED /* 442 */:
                        case 460:
                        case 461:
                        case 462:
                        case 463:
                        case 470:
                        case 471:
                        case 472:
                        case 474:
                        case 475:
                        case 476:
                        case 477:
                        case 478:
                        case 479:
                        case 480:
                        case 481:
                        case PayloadType.SC_AUTHOR_CHAT_END /* 482 */:
                        case PayloadType.SC_AUTHOR_CHAT_REJECT /* 483 */:
                        case PayloadType.SC_AUTHOR_MUSIC_OPENED /* 490 */:
                        case PayloadType.SC_AUTHOR_MUSIC_CLOSED /* 491 */:
                        case 500:
                        case 501:
                        case 510:
                        case 511:
                        case 521:
                        case 522:
                        case 531:
                        case 532:
                        case 533:
                        case 541:
                        case 542:
                        case 550:
                        case 551:
                        case 552:
                        case 553:
                        case 554:
                        case 560:
                        case 561:
                        case 562:
                        case 565:
                        case 570:
                        case 571:
                        case 581:
                        case 582:
                        case 583:
                        case 584:
                        case 585:
                        case 586:
                        case 587:
                        case 588:
                        case 590:
                        case 591:
                        case 592:
                        case 593:
                        case 594:
                        case 595:
                        case 596:
                        case 600:
                        case 601:
                        case 602:
                        case 603:
                        case 604:
                        case 605:
                        case 606:
                        case 607:
                        case 608:
                        case 610:
                        case 611:
                        case 612:
                        case 613:
                        case 614:
                        case 615:
                        case 616:
                        case 617:
                        case 620:
                        case 621:
                        case 622:
                        case 623:
                        case 630:
                        case 631:
                        case 632:
                        case 633:
                        case PayloadType.SC_THEATER_EPISODE_SWITCH_TOAST /* 634 */:
                        case 641:
                        case 642:
                        case 643:
                        case 644:
                        case 645:
                        case 646:
                        case 647:
                        case 648:
                        case 649:
                        case 650:
                        case 651:
                        case 652:
                        case 653:
                        case 654:
                        case 655:
                        case 656:
                        case 657:
                        case 660:
                        case 661:
                        case 662:
                        case 663:
                        case 664:
                        case 665:
                        case 666:
                        case 667:
                        case 670:
                        case 671:
                        case 672:
                        case 673:
                        case 674:
                        case 675:
                        case 676:
                        case 677:
                        case 678:
                        case 679:
                        case 680:
                        case 681:
                        case 682:
                        case 683:
                        case 684:
                        case 685:
                        case 686:
                        case 687:
                        case 688:
                        case 689:
                        case 690:
                        case 691:
                        case 692:
                        case 693:
                        case 694:
                        case 695:
                        case 696:
                        case 697:
                        case 698:
                        case 699:
                        case 700:
                        case 701:
                        case 702:
                        case 703:
                        case 704:
                        case 705:
                        case 706:
                        case 707:
                        case 708:
                        case 709:
                        case 710:
                        case 711:
                        case 712:
                        case 713:
                        case 714:
                        case 715:
                        case 716:
                        case 717:
                        case 718:
                        case 719:
                        case 720:
                        case 721:
                        case 722:
                        case 723:
                        case 727:
                        case 728:
                        case PayloadType.SC_LIVE_FANS_TOP_QUICK_ORDER_NOTICE /* 729 */:
                        case PayloadType.SC_LIVE_LINE_CHAT_INVITE /* 730 */:
                        case PayloadType.SC_LIVE_LINE_CHAT_MATCHED /* 731 */:
                        case PayloadType.SC_LIVE_LINE_CHAT_READY /* 732 */:
                        case PayloadType.SC_LIVE_LINE_CHAT_END /* 733 */:
                        case PayloadType.SC_LIVE_LINE_CHAT_INFO_UPDATE /* 734 */:
                        case PayloadType.SC_LIVE_CONDITION_RED_PACK /* 735 */:
                        case PayloadType.SC_LIVE_CONDITION_RED_PACK_UPDATE /* 736 */:
                        case PayloadType.SC_LIVE_CONDITION_RED_PACK_ROLL_USER /* 737 */:
                        case PayloadType.SC_LIVE_CONDITION_RED_PACK_OPEN /* 738 */:
                        case PayloadType.SC_LIVE_CONDITION_RED_PACK_CLOSE /* 739 */:
                        case PayloadType.SC_GZONE_ACCOMPANY_ENTRANCE_SHOW /* 740 */:
                        case PayloadType.SC_GZONE_ACCOMPANY_ENTRANCE_HIDE /* 741 */:
                        case PayloadType.SC_GZONE_ACCOMPANY_STATE_REFRESH /* 742 */:
                        case PayloadType.SC_KWAISHOP_ARROW_MESSAGE /* 743 */:
                        case PayloadType.SC_LIVE_OVER_ROOM_MESSAGE /* 744 */:
                        case PayloadType.SC_LIVE_CHAT_CALL_V2 /* 745 */:
                        case PayloadType.SC_LIVE_OVER_ROOM_MESSAGE_V2 /* 746 */:
                        case PayloadType.SC_LIVE_BEAUTY_LABEL_CHANGE /* 747 */:
                        case PayloadType.SC_LIVE_TREASURE_BOX_SHOW /* 748 */:
                        case PayloadType.SC_LIVE_ROOM_VOICE_NOTIFICATION_MESSAGE /* 749 */:
                        case 750:
                        case 751:
                        case 752:
                        case 753:
                        case 754:
                        case 755:
                        case 756:
                        case 757:
                        case 758:
                        case 759:
                        case 760:
                        case 761:
                        case 762:
                        case PayloadType.SC_LIVE_VOICE_PARTY_ABOARD_APPLY_RESULT /* 763 */:
                        case PayloadType.SC_LIVE_TOP_USER_FORBIDDEN_DIALOG /* 764 */:
                        case PayloadType.SC_LIVE_TAG_UPDATE /* 765 */:
                        case PayloadType.SC_LIVE_TAG_CLOSE /* 766 */:
                        case PayloadType.SC_LIVE_PK_KO_INFO /* 767 */:
                        case PayloadType.SC_LIVE_PK_KO_MODE /* 768 */:
                        case 770:
                        case PayloadType.SC_LIVE_GIFT_OUTSIDE_MESSAGE /* 771 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_CALL /* 772 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_GUEST_REJECTED /* 773 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_USER_INFO /* 774 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_USER_LEAVE_INFO /* 775 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_CLOSED /* 776 */:
                        case PayloadType.SC_KWAISHOP_AUCTION_NOTICE /* 777 */:
                        case PayloadType.SC_COMMENT_FOLDING_MESSAGE /* 778 */:
                        case PayloadType.SC_GZONE_LIVE_MATE_COVER_AUDIT_STATUS_PUSH /* 779 */:
                        case 780:
                        case 781:
                        case 782:
                        case PayloadType.SC_GAME_INTERACTION_MIC_SEATS_INFO /* 785 */:
                        case PayloadType.SC_GAME_INTERACTION_MIC_SEATS_USER_APPLY_AUTHOR_ACCEPT /* 786 */:
                        case PayloadType.SC_GAME_INTERACTION_MIC_SEATS_USER_APPLY_AUTHOR_REJECT /* 787 */:
                        case PayloadType.SC_GAME_INTERACTION_MIC_SEATS_LEFT /* 788 */:
                        case PayloadType.SC_GAME_INTERACTION_MIC_SEATS_APPLY_INFO /* 789 */:
                        case PayloadType.SC_LIVE_GIFT_RAMPAGE /* 790 */:
                        case PayloadType.SC_GZONE_PREDICTION_SHOW /* 791 */:
                        case PayloadType.SC_GZONE_PREDICTION_HIDE /* 792 */:
                        case PayloadType.SC_LIVE_UNION_LIVE_INVITE_INVALID /* 794 */:
                        case PayloadType.SC_LIVE_UNION_LIVE_APPLY_INVALID /* 795 */:
                        case PayloadType.SC_LIVE_UNION_LIVE_AUTHORITY_CHANGED /* 796 */:
                        case PayloadType.SC_LIVE_GIFT_PANEL_REFRESH /* 797 */:
                        case PayloadType.SC_LIVE_HOUR_RANK_INFO /* 798 */:
                        case PayloadType.SC_LIVE_MAGIC_FACE_STATE /* 799 */:
                        case 800:
                        case 801:
                        case 803:
                        case 804:
                        case 805:
                        case 806:
                        case 807:
                        case 808:
                        case 809:
                        case 810:
                        case 811:
                        case 812:
                        case 813:
                        case 814:
                        case 815:
                        case 816:
                        case 817:
                        case 818:
                        case 819:
                        case 820:
                        case 821:
                        case 822:
                        case 823:
                        case 824:
                        case 825:
                        case 826:
                        case 827:
                        case 828:
                        case 829:
                        case 830:
                        case 831:
                        case 832:
                        case 833:
                        case 834:
                        case 835:
                        case 836:
                        case 837:
                        case 838:
                        case 839:
                        case 840:
                        case 841:
                        case 842:
                        case 843:
                        case 844:
                        case 845:
                        case 846:
                        case 847:
                        case 848:
                        case 849:
                        case 850:
                        case 851:
                        case 852:
                        case 853:
                        case 854:
                        case 856:
                        case PayloadType.SC_KWAISHOP_LIVE_SKY_FALL_PENDANT_DESTROY /* 857 */:
                        case PayloadType.SC_LIVE_POPULARITY_RANK_INFO /* 858 */:
                        case PayloadType.SC_LIVE_POPULARITY_RANK_CLOSED /* 859 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_GUEST_VIDEO_AUTHORITY /* 860 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_INVITE_GUEST_OPEN_VIDEO /* 861 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_CLOSE_GUEST_VIDEO /* 862 */:
                        case PayloadType.SC_KWAISHOP_LIVE_ITEM_PENDANT /* 863 */:
                        case PayloadType.SC_LIVE_FANS_GROUP_ATTACH_GIFT_REPLACE_NOTICE /* 864 */:
                        case PayloadType.SC_KWAISHOP_LIVE_COMMON_DIALOG /* 865 */:
                        case PayloadType.SC_KWAISHOP_LIVE_COMMON_TOAST /* 866 */:
                        case PayloadType.SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT /* 867 */:
                        case PayloadType.SC_LIVE_ACTIVITY_TOP_RIGHT_PENDANT_CLOSE /* 868 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_APPLY /* 869 */:
                        case 870:
                        case PayloadType.SC_INTERACTIVE_CHAT_APPLY_REJECT /* 871 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_MATCHED /* 872 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_INFO_UPDATE /* 873 */:
                        case PayloadType.SC_LIVE_GUIDE_FOLLOW_AUTHOR_CARD_INFO /* 874 */:
                        case PayloadType.SC_GZONE_LIVE_MATE_MESSAGE_CENTER_NOTIFY /* 875 */:
                        case PayloadType.SC_LIVE_CORE_USER_CRM_ROOM_ACTION /* 876 */:
                        case PayloadType.SC_LIVE_CORE_USER_CRM_INTERACTIVE_CHANGE /* 877 */:
                        case PayloadType.SC_LIVE_EXCLUSIVE_COMMON_ROUTE /* 878 */:
                        case PayloadType.SC_LIVE_KLINK_MESSAGE /* 879 */:
                        case 880:
                        case 881:
                        case 882:
                        case 883:
                        case 884:
                        case 885:
                        case 886:
                        case 887:
                        case PayloadType.SC_LIVE_WISHROOM_BULLET_COMMENT_PUSH_INFOS /* 888 */:
                        case 889:
                        case 890:
                        case 891:
                        case PayloadType.SC_LIVE_REVENUE_ACTIVITY_INFO_UPDATE /* 892 */:
                        case PayloadType.SC_GZONE_GIFT_LOTTERY_NOTIFY /* 893 */:
                        case PayloadType.SC_X_STREAM_LIVE_CARD_LIST_INFO /* 894 */:
                        case 900:
                        case 901:
                        case 902:
                        case 903:
                        case 904:
                        case 905:
                        case 906:
                        case PayloadType.SC_LIVE_RESERVATION_STICKER_INFO /* 907 */:
                        case PayloadType.SC_LIVE_RESERVATION_STICKER_CLOSE /* 908 */:
                        case 909:
                        case 911:
                        case 912:
                        case PayloadType.SC_KUAISHOU_NIGHT_LOTTERY_CHANGING /* 913 */:
                        case PayloadType.SC_LIVE_INTERACTIVE_WIDGET /* 914 */:
                        case PayloadType.SC_KWAISHOP_RESOURCE_LIVE_PENDANT_DATA /* 915 */:
                        case PayloadType.SC_GZONE_LIVE_ACTIVITY_COMMON_NOTICE /* 916 */:
                        case PayloadType.SC_LIVE_PK_BUFF_CARD_MOMENT /* 917 */:
                        case PayloadType.SC_GZONE_PREDICTION_PK_PROGRESS /* 918 */:
                        case PayloadType.SC_GZONE_PREDICTION_PK_END /* 919 */:
                        case 920:
                        case 921:
                        case 922:
                        case 923:
                        case 924:
                        case 925:
                        case 926:
                        case 927:
                        case 928:
                        case 929:
                        case 930:
                        case 931:
                        case 932:
                        case 933:
                        case 934:
                        case 935:
                        case 936:
                        case 937:
                        case 938:
                        case 939:
                        case 940:
                        case 941:
                        case 942:
                        case 943:
                        case 944:
                        case 945:
                        case 946:
                        case 947:
                        case 948:
                        case 949:
                        case 950:
                        case 951:
                        case 953:
                        case 954:
                        case 955:
                        case 956:
                        case 957:
                        case PayloadType.SC_LIVE_USER_TASK_STATUS_UPDATE /* 958 */:
                        case 959:
                        case 960:
                        case 961:
                        case 962:
                        case 963:
                        case 964:
                        case 965:
                        case PayloadType.SC_LIVE_RECRUIT_SHARE_GUIDE /* 966 */:
                        case PayloadType.SC_GZONE_LIVE_WIDGET_SHOW_MESSAGE /* 967 */:
                        case PayloadType.SC_GZONE_LIVE_WIDGET_HIDE_MESSAGE /* 968 */:
                        case PayloadType.SC_GZONE_LIVE_BOTTOM_POP_UP_MESSAGE /* 969 */:
                        case 970:
                        case PayloadType.SC_LIVE_RECRUIT_COMMENT_BROADCAST /* 971 */:
                        case PayloadType.SC_AD_WATCH_LIVE_TASK_SIGNAL /* 972 */:
                        case PayloadType.SC_MULTI_LINE_CHAT_WISH_LIST /* 973 */:
                        case PayloadType.SC_LIVE_PK_STATE /* 974 */:
                        case PayloadType.SC_KWAISHOP_LIVE_SELLER_RANK_PENDANT_V2 /* 975 */:
                        case PayloadType.SC_LIVE_BLIND_DATE_OPEN /* 976 */:
                        case PayloadType.SC_LIVE_MULTI_PK_CRIT_MOMENT /* 977 */:
                        case PayloadType.SC_LIVE_BLIND_DATE_CLOSE /* 978 */:
                        case PayloadType.SC_LIVE_MULTI_PK_MATCH_GUIDE_SHOW /* 979 */:
                        case 980:
                        case 981:
                        case 982:
                        case 983:
                        case 984:
                        case 985:
                        case 986:
                        case 987:
                        case 988:
                        case 989:
                        case 990:
                        case 991:
                        case 992:
                        case 993:
                        case 994:
                        case 995:
                        case 996:
                        case 997:
                        case 998:
                        case 999:
                        case 1000:
                        case 1001:
                        case 1002:
                        case 1003:
                        case 1004:
                        case 1005:
                        case 1006:
                        case 1007:
                        case 1008:
                        case 1009:
                        case 1010:
                        case 1011:
                        case 1012:
                        case 1013:
                        case 1014:
                        case 1015:
                        case 1016:
                        case 1017:
                        case 1018:
                        case 1019:
                        case 1020:
                        case 1021:
                        case 1022:
                        case 1023:
                        case 1024:
                        case 1025:
                        case 1026:
                        case 1027:
                        case 1028:
                        case 1029:
                        case 1030:
                        case 1031:
                        case 1032:
                        case 1033:
                        case 1034:
                        case 1035:
                        case 1036:
                        case 1037:
                        case 1038:
                        case 1039:
                        case 1040:
                        case 1041:
                        case 1042:
                        case 1043:
                        case 1044:
                        case 1045:
                        case 1046:
                        case 1047:
                        case 1048:
                        case 1049:
                        case 1050:
                        case 1051:
                        case 1052:
                        case 1053:
                        case 1054:
                        case 1055:
                        case 1056:
                        case 1057:
                        case 1058:
                        case 1059:
                        case 1060:
                        case 1061:
                        case 1062:
                        case 1063:
                        case 1064:
                        case 1065:
                        case 1066:
                        case 1067:
                        case 1068:
                        case 1069:
                        case 1070:
                        case 1071:
                        case 1072:
                        case 1073:
                        case 1074:
                        case 1075:
                        case 1076:
                        case 1077:
                        case 1078:
                        case 1079:
                        case 1080:
                        case 1081:
                        case 1082:
                        case 1083:
                        case 1084:
                        case 1085:
                        case 1086:
                        case 1087:
                        case PayloadType.SC_GIFT_CORNER_RED_DOT_SIGNAL /* 1088 */:
                        case PayloadType.SC_LIVE_PK_PANEL_NOTICE_TIP_V2 /* 1089 */:
                        case 1090:
                        case 1091:
                        case 1092:
                        case 1093:
                        case 1094:
                        case 1095:
                        case 1096:
                        case 1097:
                        case 1098:
                        case 1099:
                        case 1100:
                        case 1101:
                        case 1102:
                        case 1103:
                        case 1104:
                        case 1105:
                        case 1106:
                        case 1107:
                        case 1108:
                        case 1109:
                        case PayloadType.SC_LIVE_OFFICIAL_PROGRAMME_DUMP_AUDIENCE /* 1110 */:
                        case PayloadType.SC_LIVE_OFFICIAL_PROGRAMME_SHUNT_AUDIENCE /* 1111 */:
                        case PayloadType.SC_LIVE_AUTHOR_HEAD_INFO_CHANGE /* 1112 */:
                        case PayloadType.SC_GZONE_LIVE_BIG_CARD_SIGNAL /* 1113 */:
                        case PayloadType.SC_LIVE_HOUSE_ANCHOR_EXPLAIN_CARD_SIGNAL /* 1114 */:
                        case PayloadType.SC_LIVE_STREAM_LATENCY_CHANGED_SIGNAL /* 1115 */:
                        case PayloadType.SC_LIVE_INTERACTIVE_CHAT_LAYOUT_CHANGE /* 1116 */:
                        case PayloadType.SC_LIVE_ACTIVITY_PASTER_SIGNAL /* 1117 */:
                        case PayloadType.SC_LIVE_LOCAL_LIFE_PENDANT_SHOW_NOTICE /* 1118 */:
                        case PayloadType.SC_LIVE_LOCAL_LIFE_PENDANT_OPEN_NOTICE /* 1119 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_CANCEL_APPLY /* 1120 */:
                        case PayloadType.SC_LIVE_IDEAT_COMMENT_BROADCAST /* 1121 */:
                        case PayloadType.SC_LIVE_STICKER_DECORATION /* 1122 */:
                        case PayloadType.SC_LIVE_BULLET_SCREEN_DATA_PUSH_STATUS_SIGNAL /* 1123 */:
                        case PayloadType.SC_LIVE_LOCAL_LIFE_EXPLAIN_CARD_STOCK_NOTICE /* 1124 */:
                        case PayloadType.SC_LIVE_MODULE_SHIELD_CONFIG_SIGNAL /* 1125 */:
                        case PayloadType.SC_LIVE_COMMENT_STYLE_CONFIG_SIGNAL /* 1126 */:
                        case PayloadType.SC_LIVE_RECRUIT_EXPLAIN_PANEL_DISPLAY_SIGNAL /* 1127 */:
                        case PayloadType.SC_LIVE_BULLET_QUICK_INTERACTIVE_PANEL /* 1128 */:
                        case PayloadType.SC_LIVE_CHAT_APPLY_USER_CNT_UPDATE /* 1129 */:
                        case 1130:
                        case 1131:
                        case 1132:
                        case 1133:
                        case 1134:
                        case 1135:
                        case 1136:
                        case 1137:
                        case 1138:
                        case 1139:
                        case PayloadType.SC_LIVE_AUTHOR_RADAR /* 1140 */:
                        case PayloadType.SC_LIVE_INTERACTIVE_CHAT_ENTER_ROOM /* 1141 */:
                        case PayloadType.SC_LIVE_BULLET_PLAY_CHAT_ENTRANCE /* 1142 */:
                        case PayloadType.SC_LIVE_BULLET_PLAY_CHAT_PLACEHOLDER_LAYOUT /* 1143 */:
                        case PayloadType.SC_GZONE_LUCKY_PLAYER_ENTRANCE_SHOW /* 1144 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_GRID_CHAT_SOLO_PK_STATISTIC /* 1145 */:
                        case PayloadType.SC_GZONE_PARTNER_EXPLAIN_BIG_CARD_SHOW /* 1146 */:
                        case PayloadType.SC_LIVE_BULLET_PLAY_BOTTOM_ENTRANCE /* 1147 */:
                        case PayloadType.SC_INTERACTIVE_CHAT_RESERVATION_AVAILABLE_EVENT /* 1148 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_LAST_LAYOUT_INFO_SNAPSHOT /* 1149 */:
                        case 1150:
                        case 1151:
                        case 1152:
                        case 1153:
                        case 1154:
                        case 1155:
                        case 1156:
                        case 1157:
                        case 1158:
                        case 1159:
                        case 1160:
                        case 1161:
                        case 1162:
                        case 1163:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_RENDER_SIGNAL /* 1164 */:
                        case PayloadType.SC_ECO_CONSULT_CARD_NOTICE /* 1165 */:
                        case PayloadType.SC_LIVE_TRAFFIC_OP_PENDANT_CLOSED /* 1166 */:
                        case PayloadType.SC_LIVE_AUTHOR_PERCEPTION_TOP_USER_CLOSED /* 1167 */:
                        case PayloadType.SC_LIVE_ORG_RECRUIT_UPDATE /* 1168 */:
                        case PayloadType.SC_LIVE_ORG_RECRUIT_USER_APPLY_SUCCESS /* 1169 */:
                        case PayloadType.SC_GZONE_DISPLAY_FACE_PORTRAIT_LAYOUT /* 1170 */:
                        case PayloadType.SC_LIVE_GIFT_PANEL_ITEM_REFRESH /* 1171 */:
                        case PayloadType.SC_LIVE_FLOATING_LAYER_RN_OPEN /* 1172 */:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_PC_ALERT_SIGNAL /* 1173 */:
                        case PayloadType.SC_LIVE_START_SUPER_FANS_WISH_NOTICE /* 1174 */:
                        case PayloadType.SC_LIVE_HELP_WISH_NOTICE /* 1175 */:
                        case PayloadType.SC_LIVE_WISH_POINT_NOTICE /* 1176 */:
                        case PayloadType.SC_LIVE_ORDERS_ENTRANCE /* 1177 */:
                        case PayloadType.SC_LIVE_BULLET_ROOM_BOTTOM_MASK_LAYER_STATUS /* 1178 */:
                        case PayloadType.SC_KTV_SIGNER_VIDEO_STATUS /* 1179 */:
                        case PayloadType.SC_LIVE_YEAR_CEREMONY23_FINGER_GUESS_QUICK_GIFT_UPDATE /* 1180 */:
                        case PayloadType.SC_GZONE_CP_PREDICTION_CHANGED /* 1181 */:
                        case PayloadType.SC_GZONE_CP_ENTRANCE_HIDE /* 1182 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_PLAY_TYPE_SWITCH_NEW /* 1183 */:
                        case PayloadType.SC_LIVE_CNY2024_FANS_ADD_RPR_NOTICE /* 1184 */:
                        case PayloadType.SC_LIVE_CNY2024_REPLACE /* 1185 */:
                        case PayloadType.SC_LIVE_CNY2024_UPDATE_LIKE_TEXT /* 1186 */:
                        case PayloadType.SC_LIVE_CNY2024_ENHANCE_LIKE_DISPLAY /* 1187 */:
                        case PayloadType.SC_LIVE_CNY2024_ENHANCE_VIEW_TEXT /* 1188 */:
                        case PayloadType.SC_LIVE_CNY2024_ENHANCE_PENDANT_DISPLAY /* 1189 */:
                        case 1190:
                        case PayloadType.SC_LIVE_CNY2024_BATTLE_STATE /* 1191 */:
                        case 1192:
                        case PayloadType.SC_LIVE_CNY2024_BATTLE_STATISTIC /* 1193 */:
                        case 1194:
                        case PayloadType.SC_LIVE_CNY2024_PROGRAM /* 1195 */:
                        case PayloadType.SC_LIVE_CNY2024_RIGHT_BOTTOM_PENDANT_ACTION /* 1196 */:
                        case PayloadType.SC_LIVE_CNY2024_CORE_OPERATION_PENDANT_ACTION /* 1197 */:
                        case PayloadType.SC_LIVE_CNY2024_BASIC_OPERATION_PENDANT_REFRESH /* 1198 */:
                        case PayloadType.SC_LIVE_CNY2024_BASIC_OPERATION_PENDANT_HIGHLIGHT /* 1199 */:
                        case PayloadType.SC_LIVE_QUIZ3_SYNC /* 1200 */:
                        case 1201:
                        case 1203:
                        case 1204:
                        case 1205:
                        case 1206:
                        case 1207:
                        case 1208:
                        case 1209:
                        case 1210:
                        case 1211:
                        case PayloadType.SC_LIVE_CNY2024_GIFT_BOOTH_UPDATE /* 1212 */:
                        case PayloadType.SC_LIVE_CNY2024_BATTLE_TOKEN_READY /* 1213 */:
                        case PayloadType.SC_LIVE_CNY2024_BATTLE_SHOW /* 1214 */:
                        case PayloadType.SC_LIVE_CNY2024_WARMUP_PRAY_PULL_REQUEST /* 1222 */:
                        case PayloadType.SC_LIVE_CNY2024_WARMUP_PRAY_TREASURE_BOX_TOKEN_READY /* 1223 */:
                        case PayloadType.SC_LIVE_CNY2024_CORE_OPERATION_PENDANT_REFRESH /* 1224 */:
                        case PayloadType.SC_LIVE_CNY2024_CDN_DEGRADE_COMMAND /* 1225 */:
                        case PayloadType.SC_LIVE_QUICK_INTERACT_GIFT_AREA /* 1226 */:
                        case PayloadType.SC_LIVE_CNY2024_INDICATOR_PENDANT /* 1227 */:
                        case PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_ENTRANCE_INFO /* 1228 */:
                        case PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_SHARE_INFO /* 1229 */:
                        case PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_MAGIC_EFFECT /* 1230 */:
                        case PayloadType.SC_LIVE_QUIZ3_PARTICIPATE_WINNER_CALCULATION /* 1231 */:
                        case PayloadType.SC_LIVE_QUIZ3_END_WINNER_CALCULATION /* 1232 */:
                        case PayloadType.SC_LIVE_CNY2024_EFFECTIVE_TASK_PROGRESS /* 1233 */:
                        case PayloadType.SC_LIVE_ACTIVITY_POPUP_ROUTE /* 1234 */:
                        case PayloadType.SC_LIVE_ACTIVITY_IN_ROOM_PUSH_CNY2024 /* 1235 */:
                        case PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_BACK_PACK_INFO /* 1236 */:
                        case PayloadType.SC_LIVE_CNY2024_BULLET_PLAY_WATCH_TASK_INFO /* 1237 */:
                        case PayloadType.SC_LIVE_STREAM_PLATFORM_NOTIFICATION /* 1238 */:
                        case PayloadType.SC_LIVE_CNY2024_WARMUP_PRAY_WISH_UPDATE /* 1239 */:
                        case PayloadType.SC_LIVE_QUICK_INTERACT_GIFT_UPDATE /* 1240 */:
                        case PayloadType.SC_GZONE_LIVE_MATE_AUTHOR_OPEN /* 1241 */:
                        case PayloadType.SC_GZONE_LIVE_MATE_AUTHOR_CLOSE /* 1242 */:
                        case PayloadType.SC_GZONE_WATCHING_PLAY_USER_IM_MESSAGE /* 1243 */:
                        case PayloadType.SC_GZONE_ACTIVITY_LIVE_MARK_MESSAGE /* 1244 */:
                        case PayloadType.SC_GZONE_ACTIVITY_UPPER_RIGHT_WIDGET_MESSAGE /* 1245 */:
                        case PayloadType.SC_LIVE_TOOL_PLAY_CUSTOMISE_PANEL_SIGNAL /* 1246 */:
                        case PayloadType.SC_LIVE_SERVER_SIGNAL_BLOCK_MESSAGE /* 1247 */:
                        case PayloadType.SC_GIFT_ACHIEVEMENT_OPENED /* 1248 */:
                        case PayloadType.SC_GIFT_ACHIEVEMENT_CLOSED /* 1249 */:
                        case 1250:
                        case 1251:
                        case 1252:
                        case 1253:
                        case 1254:
                        case 1255:
                        case 1256:
                        case 1257:
                        case 1258:
                        case PayloadType.SC_LIVE_VOICE_PARTY_VIDEO_OPENED /* 1259 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_VIDEO_CLOSED /* 1260 */:
                        case PayloadType.SC_LIVE_GIFT_ACHIEVEMENT_NOTICE_USER /* 1261 */:
                        case PayloadType.SC_LIVE_GIFT_ACHIEVEMENT_USER_SEND_GIFT /* 1262 */:
                        case PayloadType.SC_LIVE_GIFT_ACHIEVEMENT_LIGHT_ON_NOTICE /* 1263 */:
                        case PayloadType.SC_LIVE_REVENUE_ALIPAY_DISCOUNT_QUICK_ENTRANCE /* 1264 */:
                        case PayloadType.SC_LIVE_MULTI_PK_MISSION_START /* 1265 */:
                        case PayloadType.SC_LIVE_MULTI_PK_MISSION_STATISTIC /* 1266 */:
                        case PayloadType.SC_LIVE_MULTI_PK_MISSION_EASTER_MOMENT /* 1267 */:
                        case PayloadType.SC_LIVE_PLUTUS_ENHANCE_MODE /* 1268 */:
                        case PayloadType.SC_LIVE_GIFT_BOOTH_UPDATE /* 1269 */:
                        case PayloadType.SC_LIVE_SMALL_PLAY_BOTTOM_UPDATE /* 1270 */:
                        case PayloadType.SC_LIVE_PARTY_PLAY_APP_CLOSE /* 1271 */:
                        case PayloadType.SC_LIVE_PARTY_PLAY_ROOM_LAYOUT_UPDATE /* 1272 */:
                        case PayloadType.SC_LIVE_PARTY_PLAY_SCREEN_CLEAN /* 1273 */:
                        case PayloadType.SC_LIVE_VOICE_PARTY_COMMON_TOAST /* 1274 */:
                        case PayloadType.SC_LIVE_PARTY_PLAY_BOTTOM_HIDE /* 1275 */:
                        case PayloadType.SC_LIVE_SMALL_PLAY_RIGHT_BOTTOM_PENDANT /* 1276 */:
                        case PayloadType.SC_LIVE_POPULARITY_RANK_NEW_TEMPLATE_EFFECT_INFO /* 1277 */:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_BOTTOM_UPDATE /* 1278 */:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_LAYOUT_UPDATE /* 1279 */:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_TYPE_NOTICE /* 1280 */:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_SCREEN_CLEAN /* 1281 */:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_BOTTOM_HIDE /* 1282 */:
                        case PayloadType.SC_LIVE_BULLET_CLOUD_PLAY_OPERATION_CLOSE_CONNECT_ALERT /* 1283 */:
                        case PayloadType.SC_LIVE_PARTY_PLAY_STATUS /* 1284 */:
                        case PayloadType.SC_LIVE_PARTY_PLAY_PARTICIPATE_STATUS /* 1285 */:
                        case PayloadType.SC_LIVE_REVENUE_FUNCTION_SWITCH_CONFIG /* 1286 */:
                        case PayloadType.SC_LIVE_POPULARITY_TICKET_ENCOURAGE_BATTLE_INFO /* 1287 */:
                        case PayloadType.SC_LIVE_GIFT_BANNER_REFRESH_MSG /* 1288 */:
                        case PayloadType.SC_LIVE_ACTIVITY_ATMOSPHERE_SIGNAL /* 1289 */:
                            this.payloadType = int32;
                            break;
                    }
                } else if (tag == 16) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3) {
                        this.compressionType = int322;
                    }
                } else if (tag == 26) {
                    this.payload = codedInputByteBufferNano.readBytes();
                } else if (tag == 32) {
                    this.time = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    this.reportId = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.messageId = codedInputByteBufferNano.readString();
                } else if (tag == 56) {
                    this.needAck = codedInputByteBufferNano.readBool();
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.ackInfo = codedInputByteBufferNano.readBytes();
                }
            }
        }

        public static SocketMessage parseFrom(byte[] bArr) {
            return (SocketMessage) MessageNano.mergeFrom(new SocketMessage(), bArr);
        }

        public static SocketMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SocketMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CSHeartbeat extends MessageNano {
        private static volatile CSHeartbeat[] _emptyArray;
        public int heartbeatType;
        public long timestamp;

        @Retention(RetentionPolicy.SOURCE)
        public @interface HeartbeatType {
            public static final int BACKGROUND = 2;
            public static final int FOREGROUND = 1;
            public static final int UNKNOWN_HEARTBEAT_TYPE = 0;
        }

        public static CSHeartbeat[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CSHeartbeat[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CSHeartbeat() {
            clear();
        }

        public final CSHeartbeat clear() {
            this.timestamp = 0L;
            this.heartbeatType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.heartbeatType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.heartbeatType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CSHeartbeat mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.heartbeatType = int32;
                    }
                }
            }
        }

        public static CSHeartbeat parseFrom(byte[] bArr) {
            return (CSHeartbeat) MessageNano.mergeFrom(new CSHeartbeat(), bArr);
        }

        public static CSHeartbeat parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CSHeartbeat().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCHeartbeatAck extends MessageNano {
        private static volatile SCHeartbeatAck[] _emptyArray;
        public long clientTimestamp;
        public long timestamp;

        public static SCHeartbeatAck[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCHeartbeatAck[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCHeartbeatAck() {
            clear();
        }

        public final SCHeartbeatAck clear() {
            this.timestamp = 0L;
            this.clientTimestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.clientTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.clientTimestamp;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCHeartbeatAck mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.clientTimestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCHeartbeatAck parseFrom(byte[] bArr) {
            return (SCHeartbeatAck) MessageNano.mergeFrom(new SCHeartbeatAck(), bArr);
        }

        public static SCHeartbeatAck parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCHeartbeatAck().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCError extends MessageNano {
        private static volatile SCError[] _emptyArray;
        public int code;
        public long maxDelayMs;
        public long minDelayMs;
        public String msg;
        public int subCode;

        public static SCError[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCError[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCError() {
            clear();
        }

        public final SCError clear() {
            this.code = 0;
            this.msg = "";
            this.subCode = 0;
            this.minDelayMs = 0L;
            this.maxDelayMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.code;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.msg.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.msg);
            }
            int i2 = this.subCode;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            long j = this.minDelayMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.maxDelayMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.code;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.msg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.msg);
            }
            int i2 = this.subCode;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            long j = this.minDelayMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.maxDelayMs;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCError mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.code = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.msg = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.subCode = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.minDelayMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxDelayMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCError parseFrom(byte[] bArr) {
            return (SCError) MessageNano.mergeFrom(new SCError(), bArr);
        }

        public static SCError parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCError().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCInfo extends MessageNano {
        private static volatile SCInfo[] _emptyArray;
        public int code;
        public long maxDelayMs;
        public long minDelayMs;
        public String msg;

        public static SCInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCInfo() {
            clear();
        }

        public final SCInfo clear() {
            this.code = 0;
            this.msg = "";
            this.minDelayMs = 0L;
            this.maxDelayMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.code;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.msg.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.msg);
            }
            long j = this.minDelayMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.maxDelayMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.code;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.msg.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.msg);
            }
            long j = this.minDelayMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.maxDelayMs;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.code = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.msg = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.minDelayMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxDelayMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCInfo parseFrom(byte[] bArr) {
            return (SCInfo) MessageNano.mergeFrom(new SCInfo(), bArr);
        }

        public static SCInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CSError extends MessageNano {
        private static volatile CSError[] _emptyArray;
        public int code;

        public static CSError[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CSError[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CSError() {
            clear();
        }

        public final CSError clear() {
            this.code = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.code;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.code;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CSError mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.code = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static CSError parseFrom(byte[] bArr) {
            return (CSError) MessageNano.mergeFrom(new CSError(), bArr);
        }

        public static CSError parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CSError().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CSPing extends MessageNano {
        private static volatile CSPing[] _emptyArray;
        public String appVer;
        public int clientId;
        public String deviceId;
        public String echoData;

        public static CSPing[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CSPing[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CSPing() {
            clear();
        }

        public final CSPing clear() {
            this.echoData = "";
            this.clientId = 0;
            this.deviceId = "";
            this.appVer = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.echoData.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.echoData);
            }
            int i = this.clientId;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            if (!this.deviceId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.deviceId);
            }
            if (!this.appVer.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.appVer);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.echoData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.echoData);
            }
            int i = this.clientId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            if (!this.deviceId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.deviceId);
            }
            return !this.appVer.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.appVer) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CSPing mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.echoData = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 6 || int32 == 13 || int32 == 8 || int32 == 9 || int32 == 22 || int32 == 23) {
                        this.clientId = int32;
                    }
                } else if (tag == 26) {
                    this.deviceId = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.appVer = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CSPing parseFrom(byte[] bArr) {
            return (CSPing) MessageNano.mergeFrom(new CSPing(), bArr);
        }

        public static CSPing parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CSPing().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCPingAck extends MessageNano {
        private static volatile SCPingAck[] _emptyArray;
        public String echoData;

        public static SCPingAck[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCPingAck[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCPingAck() {
            clear();
        }

        public final SCPingAck clear() {
            this.echoData = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.echoData.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.echoData);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.echoData.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.echoData) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCPingAck mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.echoData = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCPingAck parseFrom(byte[] bArr) {
            return (SCPingAck) MessageNano.mergeFrom(new SCPingAck(), bArr);
        }

        public static SCPingAck parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCPingAck().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCEcho extends MessageNano {
        private static volatile SCEcho[] _emptyArray;
        public String content;

        public static SCEcho[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCEcho[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCEcho() {
            clear();
        }

        public final SCEcho clear() {
            this.content = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.content);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.content.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.content) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCEcho mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.content = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCEcho parseFrom(byte[] bArr) {
            return (SCEcho) MessageNano.mergeFrom(new SCEcho(), bArr);
        }

        public static SCEcho parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCEcho().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class PSHostInfo extends MessageNano {
        private static volatile PSHostInfo[] _emptyArray;
        public String ip;
        public int port;

        public static PSHostInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PSHostInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PSHostInfo() {
            clear();
        }

        public final PSHostInfo clear() {
            this.ip = "";
            this.port = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.ip.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.ip);
            }
            int i = this.port;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.ip.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.ip);
            }
            int i = this.port;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PSHostInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.ip = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.port = codedInputByteBufferNano.readInt32();
                }
            }
        }

        public static PSHostInfo parseFrom(byte[] bArr) {
            return (PSHostInfo) MessageNano.mergeFrom(new PSHostInfo(), bArr);
        }

        public static PSHostInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PSHostInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCVoicePartyCoverAuditInfo extends MessageNano {
        private static volatile SCVoicePartyCoverAuditInfo[] _emptyArray;
        public boolean auditPass;
        public String liveStreamId;
        public String voicePartyId;

        public static SCVoicePartyCoverAuditInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCVoicePartyCoverAuditInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCVoicePartyCoverAuditInfo() {
            clear();
        }

        public final SCVoicePartyCoverAuditInfo clear() {
            this.liveStreamId = "";
            this.voicePartyId = "";
            this.auditPass = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.voicePartyId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.voicePartyId);
            }
            boolean z = this.auditPass;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.voicePartyId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.voicePartyId);
            }
            boolean z = this.auditPass;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCVoicePartyCoverAuditInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.voicePartyId = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.auditPass = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static SCVoicePartyCoverAuditInfo parseFrom(byte[] bArr) {
            return (SCVoicePartyCoverAuditInfo) MessageNano.mergeFrom(new SCVoicePartyCoverAuditInfo(), bArr);
        }

        public static SCVoicePartyCoverAuditInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCVoicePartyCoverAuditInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCVoicePartyAboardApplyResult extends MessageNano {
        private static volatile SCVoicePartyAboardApplyResult[] _emptyArray;
        public boolean allow;
        public String aryaConfig;
        public String liveStreamId;
        public String voicePartyId;

        public static SCVoicePartyAboardApplyResult[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCVoicePartyAboardApplyResult[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCVoicePartyAboardApplyResult() {
            clear();
        }

        public final SCVoicePartyAboardApplyResult clear() {
            this.liveStreamId = "";
            this.voicePartyId = "";
            this.allow = false;
            this.aryaConfig = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.voicePartyId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.voicePartyId);
            }
            boolean z = this.allow;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            if (!this.aryaConfig.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.aryaConfig);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.voicePartyId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.voicePartyId);
            }
            boolean z = this.allow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            return !this.aryaConfig.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.aryaConfig) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCVoicePartyAboardApplyResult mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.voicePartyId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.allow = codedInputByteBufferNano.readBool();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.aryaConfig = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCVoicePartyAboardApplyResult parseFrom(byte[] bArr) {
            return (SCVoicePartyAboardApplyResult) MessageNano.mergeFrom(new SCVoicePartyAboardApplyResult(), bArr);
        }

        public static SCVoicePartyAboardApplyResult parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCVoicePartyAboardApplyResult().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCXStreamLiveCardListInfoSignal extends MessageNano {
        private static volatile SCXStreamLiveCardListInfoSignal[] _emptyArray;
        public String bgColor;
        public SCXStreamLiveCardInfo[] cardList;
        public boolean forceUpdate;
        public String title;

        public static SCXStreamLiveCardListInfoSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCXStreamLiveCardListInfoSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCXStreamLiveCardListInfoSignal() {
            clear();
        }

        public final SCXStreamLiveCardListInfoSignal clear() {
            this.cardList = SCXStreamLiveCardInfo.emptyArray();
            this.forceUpdate = false;
            this.title = "";
            this.bgColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            SCXStreamLiveCardInfo[] sCXStreamLiveCardInfoArr = this.cardList;
            if (sCXStreamLiveCardInfoArr != null && sCXStreamLiveCardInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    SCXStreamLiveCardInfo[] sCXStreamLiveCardInfoArr2 = this.cardList;
                    if (i >= sCXStreamLiveCardInfoArr2.length) {
                        break;
                    }
                    SCXStreamLiveCardInfo sCXStreamLiveCardInfo = sCXStreamLiveCardInfoArr2[i];
                    if (sCXStreamLiveCardInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, sCXStreamLiveCardInfo);
                    }
                    i++;
                }
            }
            boolean z = this.forceUpdate;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.title);
            }
            if (!this.bgColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.bgColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            SCXStreamLiveCardInfo[] sCXStreamLiveCardInfoArr = this.cardList;
            if (sCXStreamLiveCardInfoArr != null && sCXStreamLiveCardInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    SCXStreamLiveCardInfo[] sCXStreamLiveCardInfoArr2 = this.cardList;
                    if (i >= sCXStreamLiveCardInfoArr2.length) {
                        break;
                    }
                    SCXStreamLiveCardInfo sCXStreamLiveCardInfo = sCXStreamLiveCardInfoArr2[i];
                    if (sCXStreamLiveCardInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sCXStreamLiveCardInfo);
                    }
                    i++;
                }
            }
            boolean z = this.forceUpdate;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.title);
            }
            return !this.bgColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.bgColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCXStreamLiveCardListInfoSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    SCXStreamLiveCardInfo[] sCXStreamLiveCardInfoArr = this.cardList;
                    int length = sCXStreamLiveCardInfoArr == null ? 0 : sCXStreamLiveCardInfoArr.length;
                    SCXStreamLiveCardInfo[] sCXStreamLiveCardInfoArr2 = new SCXStreamLiveCardInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.cardList, 0, sCXStreamLiveCardInfoArr2, 0, length);
                    }
                    while (length < sCXStreamLiveCardInfoArr2.length - 1) {
                        sCXStreamLiveCardInfoArr2[length] = new SCXStreamLiveCardInfo();
                        codedInputByteBufferNano.readMessage(sCXStreamLiveCardInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sCXStreamLiveCardInfoArr2[length] = new SCXStreamLiveCardInfo();
                    codedInputByteBufferNano.readMessage(sCXStreamLiveCardInfoArr2[length]);
                    this.cardList = sCXStreamLiveCardInfoArr2;
                } else if (tag == 16) {
                    this.forceUpdate = codedInputByteBufferNano.readBool();
                } else if (tag == 26) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bgColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCXStreamLiveCardListInfoSignal parseFrom(byte[] bArr) {
            return (SCXStreamLiveCardListInfoSignal) MessageNano.mergeFrom(new SCXStreamLiveCardListInfoSignal(), bArr);
        }

        public static SCXStreamLiveCardListInfoSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCXStreamLiveCardListInfoSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCXStreamLiveCardInfo extends MessageNano {
        private static volatile SCXStreamLiveCardInfo[] _emptyArray;
        public XStreamLiveCardCoverCdnUrl[] cdnUrls;
        public String contentUrl;
        public String coverUrl;
        public String[] coverUrls;
        public long id;
        public String tag;
        public String title;

        public static SCXStreamLiveCardInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCXStreamLiveCardInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCXStreamLiveCardInfo() {
            clear();
        }

        public final SCXStreamLiveCardInfo clear() {
            this.id = 0L;
            this.title = "";
            this.tag = "";
            this.coverUrl = "";
            this.contentUrl = "";
            this.coverUrls = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cdnUrls = XStreamLiveCardCoverCdnUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(1, j);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.tag.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.tag);
            }
            if (!this.coverUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.coverUrl);
            }
            if (!this.contentUrl.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.contentUrl);
            }
            String[] strArr = this.coverUrls;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.coverUrls;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(6, str);
                    }
                    i2++;
                }
            }
            XStreamLiveCardCoverCdnUrl[] xStreamLiveCardCoverCdnUrlArr = this.cdnUrls;
            if (xStreamLiveCardCoverCdnUrlArr != null && xStreamLiveCardCoverCdnUrlArr.length > 0) {
                while (true) {
                    XStreamLiveCardCoverCdnUrl[] xStreamLiveCardCoverCdnUrlArr2 = this.cdnUrls;
                    if (i >= xStreamLiveCardCoverCdnUrlArr2.length) {
                        break;
                    }
                    XStreamLiveCardCoverCdnUrl xStreamLiveCardCoverCdnUrl = xStreamLiveCardCoverCdnUrlArr2[i];
                    if (xStreamLiveCardCoverCdnUrl != null) {
                        codedOutputByteBufferNano.writeMessage(7, xStreamLiveCardCoverCdnUrl);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.tag.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.tag);
            }
            if (!this.coverUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.coverUrl);
            }
            if (!this.contentUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.contentUrl);
            }
            String[] strArr = this.coverUrls;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.coverUrls;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            XStreamLiveCardCoverCdnUrl[] xStreamLiveCardCoverCdnUrlArr = this.cdnUrls;
            if (xStreamLiveCardCoverCdnUrlArr != null && xStreamLiveCardCoverCdnUrlArr.length > 0) {
                while (true) {
                    XStreamLiveCardCoverCdnUrl[] xStreamLiveCardCoverCdnUrlArr2 = this.cdnUrls;
                    if (i >= xStreamLiveCardCoverCdnUrlArr2.length) {
                        break;
                    }
                    XStreamLiveCardCoverCdnUrl xStreamLiveCardCoverCdnUrl = xStreamLiveCardCoverCdnUrlArr2[i];
                    if (xStreamLiveCardCoverCdnUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, xStreamLiveCardCoverCdnUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCXStreamLiveCardInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readInt64();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.tag = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.coverUrl = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.contentUrl = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr = this.coverUrls;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.coverUrls, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.coverUrls = strArr2;
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    XStreamLiveCardCoverCdnUrl[] xStreamLiveCardCoverCdnUrlArr = this.cdnUrls;
                    int length2 = xStreamLiveCardCoverCdnUrlArr == null ? 0 : xStreamLiveCardCoverCdnUrlArr.length;
                    XStreamLiveCardCoverCdnUrl[] xStreamLiveCardCoverCdnUrlArr2 = new XStreamLiveCardCoverCdnUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.cdnUrls, 0, xStreamLiveCardCoverCdnUrlArr2, 0, length2);
                    }
                    while (length2 < xStreamLiveCardCoverCdnUrlArr2.length - 1) {
                        xStreamLiveCardCoverCdnUrlArr2[length2] = new XStreamLiveCardCoverCdnUrl();
                        codedInputByteBufferNano.readMessage(xStreamLiveCardCoverCdnUrlArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    xStreamLiveCardCoverCdnUrlArr2[length2] = new XStreamLiveCardCoverCdnUrl();
                    codedInputByteBufferNano.readMessage(xStreamLiveCardCoverCdnUrlArr2[length2]);
                    this.cdnUrls = xStreamLiveCardCoverCdnUrlArr2;
                }
            }
        }

        public static SCXStreamLiveCardInfo parseFrom(byte[] bArr) {
            return (SCXStreamLiveCardInfo) MessageNano.mergeFrom(new SCXStreamLiveCardInfo(), bArr);
        }

        public static SCXStreamLiveCardInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCXStreamLiveCardInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class XStreamLiveCardCoverCdnUrl extends MessageNano {
        private static volatile XStreamLiveCardCoverCdnUrl[] _emptyArray;
        public String cdn;
        public String url;

        public static XStreamLiveCardCoverCdnUrl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new XStreamLiveCardCoverCdnUrl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public XStreamLiveCardCoverCdnUrl() {
            clear();
        }

        public final XStreamLiveCardCoverCdnUrl clear() {
            this.cdn = "";
            this.url = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.cdn.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.cdn);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.url);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.cdn.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
            }
            return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.url) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final XStreamLiveCardCoverCdnUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.cdn = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.url = codedInputByteBufferNano.readString();
                }
            }
        }

        public static XStreamLiveCardCoverCdnUrl parseFrom(byte[] bArr) {
            return (XStreamLiveCardCoverCdnUrl) MessageNano.mergeFrom(new XStreamLiveCardCoverCdnUrl(), bArr);
        }

        public static XStreamLiveCardCoverCdnUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new XStreamLiveCardCoverCdnUrl().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRecruitAudienceImmediatelyPopup extends MessageNano {
        private static volatile SCLiveRecruitAudienceImmediatelyPopup[] _emptyArray;
        public String frequencyConfigBizId;
        public String popupUrl;

        public static SCLiveRecruitAudienceImmediatelyPopup[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRecruitAudienceImmediatelyPopup[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRecruitAudienceImmediatelyPopup() {
            clear();
        }

        public final SCLiveRecruitAudienceImmediatelyPopup clear() {
            this.popupUrl = "";
            this.frequencyConfigBizId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.popupUrl.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.popupUrl);
            }
            if (!this.frequencyConfigBizId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.frequencyConfigBizId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.popupUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.popupUrl);
            }
            return !this.frequencyConfigBizId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.frequencyConfigBizId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRecruitAudienceImmediatelyPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.popupUrl = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.frequencyConfigBizId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveRecruitAudienceImmediatelyPopup parseFrom(byte[] bArr) {
            return (SCLiveRecruitAudienceImmediatelyPopup) MessageNano.mergeFrom(new SCLiveRecruitAudienceImmediatelyPopup(), bArr);
        }

        public static SCLiveRecruitAudienceImmediatelyPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRecruitAudienceImmediatelyPopup().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRecruitAudiencePopupEvent extends MessageNano {
        private static volatile SCLiveRecruitAudiencePopupEvent[] _emptyArray;
        public int event;

        public static SCLiveRecruitAudiencePopupEvent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRecruitAudiencePopupEvent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRecruitAudiencePopupEvent() {
            clear();
        }

        public final SCLiveRecruitAudiencePopupEvent clear() {
            this.event = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.event;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.event;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRecruitAudiencePopupEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.event = codedInputByteBufferNano.readInt32();
                }
            }
        }

        public static SCLiveRecruitAudiencePopupEvent parseFrom(byte[] bArr) {
            return (SCLiveRecruitAudiencePopupEvent) MessageNano.mergeFrom(new SCLiveRecruitAudiencePopupEvent(), bArr);
        }

        public static SCLiveRecruitAudiencePopupEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRecruitAudiencePopupEvent().mergeFrom(codedInputByteBufferNano);
        }
    }
}
