package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAudienceBottomBarConfig extends MessageNano {
    private static volatile SCLiveAudienceBottomBarConfig[] _emptyArray;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FeatureType {
        public static final int ADD_FANS_SETTING = 1034;
        public static final int AD_TASK = 1016;
        public static final int AIR_PLAY = 1027;
        public static final int ALIPAY_DISCOUNT_QUICK_ENTRANCE = 4015;
        public static final int ASSISTANT = 1010;
        public static final int ATTACH_CAPSULE_GIFT = 1041;
        public static final int AVATAR_FRAME_PREFERENCE_SETTING = 2005;
        public static final int BARRAGE_SETTING = 1006;
        public static final int BARRAGE_SWITCH = 1005;
        public static final int BULLET_PLAY_CLEAR_SCREEN = 4017;
        public static final int BUSINESS_PROMOTION = 1008;
        public static final int CHAT_APPLY = 1025;
        public static final int CLEAN_SCREEN = 1018;
        public static final int COMMENT_INPUT = 1002;
        public static final int COURSE_BUY = 1011;
        public static final int COURSE_PROMOTION = 1012;
        public static final int EQUITY_CENTER = 4007;
        public static final int EXPOSURE_GIFT = 1019;
        public static final int FEATURE_VOICE_PARTY_CROSS_ROOM_PK_WAITING = 2006;
        public static final int FIRST_RECHARGE_BAG = 1051;
        public static final int FLOATING_WINDOW = 1022;
        public static final int FOLLOW = 1015;
        public static final int GIFT = 1003;
        public static final int GIFT_CONSUME_REMIND = 1040;
        public static final int GIFT_EFFECT = 1024;
        public static final int GZONE_ACCOMPANY = 4005;
        public static final int GZONE_ANCHOR_PROMOTION = 4012;
        public static final int GZONE_ANCHOR_WISH_VOTE = 4009;
        public static final int GZONE_GAME_PROMOTION = 4002;
        public static final int GZONE_LUCKY_PLAYER = 4011;
        public static final int GZONE_MULTI_PERSPECTIVE = 4010;
        public static final int GZONE_PROP_SHOP = 4001;
        public static final int GZONE_PURE_ROOM = 4008;
        public static final int GZONE_SHIELD_GIFT = 4004;
        public static final int GZONE_WATCH_PLAY = 4014;
        public static final int INDUSTRY = 1052;
        public static final int INTELLIGENT_LEEE = 1049;
        public static final int INTERACTIVE_BARRAGE_PLAY = 1050;
        public static final int INTERACTIVE_FUNCTION = 1045;
        public static final int INVITE_AUDIENCE = 2002;
        public static final int LINE = 1029;
        public static final int LIVE_ATMOSPHERE_GIFT = 1047;
        public static final int LIVE_GAME_INTERACTIVE = 4003;
        public static final int LIVE_HOT_PROGRAMME = 1048;
        public static final int LIVE_HOUSE = 1044;
        public static final int LIVE_KSMG = 4006;
        public static final int LIVE_LOCAL_LIFE = 1043;
        public static final int LIVE_PURE_MODE = 1042;
        public static final int MAGIC = 1035;
        public static final int MODIFY_NICK_NAME = 1031;
        public static final int MORE = 1001;
        public static final int OPEN_LIVE = 1028;
        public static final int PAID_SHOW = 1020;
        public static final int PAID_TALENT = 1039;
        public static final int PANORAMA = 1026;
        public static final int PK_RECOMMEND_GIFT = 1037;
        public static final int PLAY_SETTING = 1030;
        public static final int PROMOTION = 1014;
        public static final int QUICK_GIFT = 4013;
        public static final int QUIZ_GROUP = 3002;
        public static final int QUIZ_REVIVE_CARD = 3001;
        public static final int RECHARGE_DISCOUNT = 1053;
        public static final int RECOVER_CLEAN_SCREEN = 1032;
        public static final int RECRUIT = 1036;
        public static final int REPORT = 1021;
        public static final int RESOLUTION = 1004;
        public static final int ROBOT = 1033;
        public static final int ROTATION = 1007;
        public static final int SCREEN_RECORDING = 1023;
        public static final int SHARE = 1013;
        public static final int SHOP = 1009;
        public static final int SMALL_PLAY_QUICK_ENTRANCE = 4016;
        public static final int THEATER_EXIT_FULL_SCREEN = 2004;
        public static final int THEATER_RESOLUTION = 2003;
        public static final int TUNA = 1017;
        public static final int UNKNOWN = 0;
        public static final int VOICE_PARTY_FUNCTION = 2001;
        public static final int WISH = 3003;
        public static final int WISH_GIFT_BATTLE_ATTACH_GIFT = 1046;
        public static final int WISH_LIGHT_GUIDE_ITEM = 1038;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
        public static final int ACTIVITY_MODE = 8;
        public static final int CLEAR_MODE = 9;
        public static final int GAME_LANDSCAPE_MODE = 7;
        public static final int GAME_PORTRAIT_MODE = 6;
        public static final int GR_PR_LANDSCAPE_MODE = 11;
        public static final int GR_PR_PORTRAIT_MODE = 10;
        public static final int MERCHANT_INSTENSITY_LANDSCAPE_MODE = 24;
        public static final int MERCHANT_INSTENSITY_PORTRAIT_MODE = 23;
        public static final int MERCHANT_LANDSCAPE_MODE = 18;
        public static final int MERCHANT_PORTRAIT_MODE = 17;
        public static final int MULTI_TAB_LANDSCAPE_MODE = 16;
        public static final int MULTI_TAB_PORTRAIT_MODE = 15;
        public static final int NEW_GAME_LANDSCAPE_MODE = 14;
        public static final int NEW_GAME_PORTRAIT_MODE = 13;
        public static final int NORMAL_LANDSCAPE_MODE = 2;
        public static final int NORMAL_PORTRAIT_MODE = 1;
        public static final int SHOP_INSTENSITY_LANDSCAPE_MODE = 22;
        public static final int SHOP_INSTENSITY_PORTRAIT_MODE = 21;
        public static final int SHOP_LANDSCAPE_MODE = 20;
        public static final int SHOP_PORTRAIT_MODE = 19;
        public static final int UNKNOWN_AUDIENCE_MODE = 0;
        public static final int VOICE_PARTY_FULL_PORTRAIT_MODE = 4;
        public static final int VOICE_PARTY_LANDSCAPE_MODE = 5;
        public static final int VOICE_PARTY_PORTRAIT_MODE = 3;
        public static final int WISH_MODE = 12;
    }

    public static SCLiveAudienceBottomBarConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAudienceBottomBarConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAudienceBottomBarConfig() {
        clear();
    }

    public final SCLiveAudienceBottomBarConfig clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAudienceBottomBarConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static SCLiveAudienceBottomBarConfig parseFrom(byte[] bArr) {
        return (SCLiveAudienceBottomBarConfig) MessageNano.mergeFrom(new SCLiveAudienceBottomBarConfig(), bArr);
    }

    public static SCLiveAudienceBottomBarConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAudienceBottomBarConfig().mergeFrom(codedInputByteBufferNano);
    }
}
