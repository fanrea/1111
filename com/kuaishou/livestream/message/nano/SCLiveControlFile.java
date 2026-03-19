package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveControlFile extends MessageNano {
    private static volatile SCLiveControlFile[] _emptyArray;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
        public static final int ACTIVITY_LEEE = 54;
        public static final int AI_DENOISE_MODEL = 55;
        public static final int ANCHOR_ROBOT_AUDIO = 3;
        public static final int ANCHOR_ROBOT_MMU_MODEL = 27;
        public static final int ATMOSPHERE = 30;
        public static final int AUDIENCE_GIFT_ICON_ANIMATION = 31;
        public static final int AUDIENCE_RECORD_MMU_RED_LINE_MODEL = 28;
        public static final int AUDIENCE_ROBOT_AUDIO = 40;
        public static final int AUDIO_ANIMATION = 38;
        public static final int BARRAGE_BACKGROUND = 39;
        public static final int CAE_MODEL = 56;
        public static final int COMBO_SEND_GIFT_ANIMATION = 64;
        public static final int ENTER_ROOM_TAIL_PARTICAL = 37;
        public static final int ENTER_ROOM_TIP_ANIMATION = 44;
        public static final int ENTER_ROOM_WELCOME_ANIMATION = 45;
        public static final int FISRT_RECHARGE = 24;
        public static final int GIFT_SLOT_GRADE = 63;
        public static final int HAPPY_PLAY_LOADING_PICTURE = 51;
        public static final int HONOR_MEDAL = 26;
        public static final int LEEE_RAIN = 67;
        public static final int LIVE_AUDIO_DEEP_AEC_MODEL_AND = 79;
        public static final int LIVE_AUDIO_DEEP_AEC_MODEL_AND_2 = 85;
        public static final int LIVE_AUDIO_DEEP_AEC_MODEL_IOS = 78;
        public static final int LIVE_AUDIO_DEEP_AEC_MODEL_IOS_2 = 84;
        public static final int LIVE_AUDIO_INPAINTING_MODEL = 86;
        public static final int LIVE_AUDIO_INPAINTING_MODEL_2 = 87;
        public static final int LIVE_GIFT_BOX_EFFECT = 73;
        public static final int LIVE_MULTI_PK_RESOURCE_IMAGE_ACTIVITY_SKIN = 77;
        public static final int LIVE_MULTI_PK_RESOURCE_IMAGE_CUSTOM_SKIN = 74;
        public static final int LIVE_MULTI_PK_RESOURCE_IMAGE_HONOR_SKIN = 75;
        public static final int LIVE_MULTI_PK_RESOURCE_IMAGE_NORMAL_SKIN = 76;
        public static final int LIVE_OVER_ROOM_RESOURCE = 80;
        public static final int LIVE_PK_BULLY_SCREEN_PC_RESOURCE = 83;
        public static final int LIVE_PK_BULLY_SCREEN_RESOURCE = 82;
        public static final int LIVE_PUZZLE_RESOURCE = 81;
        public static final int LUXURY_ENTER_EFFECT = 34;
        public static final int MERCHANT_ROBOT_MMU_MODEL = 50;
        public static final int MULTI_PK_RESOURCE = 69;
        public static final int NOBLE = 42;
        public static final int PK_CUSTOM_LOTTIE = 60;
        public static final int PK_CUSTOM_LOTTIE_V2 = 71;
        public static final int PK_CUSTOM_PRIVILEGE_LOTTIE = 61;
        public static final int PK_CUSTOM_PRIVILEGE_LOTTIE_V2 = 72;
        public static final int PK_LOTTIE = 33;
        public static final int PK_PROGRESS_EFFECT = 35;
        public static final int PK_RESOURCE = 68;
        public static final int PK_SCORE_LIMIT_RESOURCE = 70;
        public static final int QUIZ = 19;
        public static final int ROBOT_LOTTIE = 66;
        public static final int SEND_GIFT_COMBO_ANIMATION = 53;
        public static final int UNKNOWN = 0;
        public static final int VOICE_PARTY_KTV_APPLAUSE = 16;
        public static final int VOICE_PARTY_MIC_SEAT_SHARE = 62;
        public static final int VOICE_PARTY_PK = 41;
        public static final int VOICE_PARTY_TEAM_PK = 10;
        public static final int WEALTH_GRADEV4 = 36;
    }

    public static SCLiveControlFile[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveControlFile[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveControlFile() {
        clear();
    }

    public final SCLiveControlFile clear() {
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveControlFile mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        int tag;
        do {
            tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                break;
            }
        } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
        return this;
    }

    public static SCLiveControlFile parseFrom(byte[] bArr) {
        return (SCLiveControlFile) MessageNano.mergeFrom(new SCLiveControlFile(), bArr);
    }

    public static SCLiveControlFile parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveControlFile().mergeFrom(codedInputByteBufferNano);
    }
}
