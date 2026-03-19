package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveOperationModuleConfig extends MessageNano {
    private static volatile LiveOperationModuleConfig[] _emptyArray;
    public long delayTimeWorkMs;
    public int moduleType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BottomBarItemType {
        public static final int COMMENT_INPUT = 1;
        public static final int EXPOSURE_GIFT = 4;
        public static final int FOLLOW = 6;
        public static final int GIFT = 5;
        public static final int LINE = 3;
        public static final int SHARE = 0;
        public static final int SHOP = 2;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ModuleType {
        public static final int ANCHOR_INFO_AREA = 26;
        public static final int ANCHOR_RADAR_AREA = 45;
        public static final int ASSOCIATE_AREA = 25;
        public static final int AUDIENCE_TOPIC = 2;
        public static final int BOTTOM_BAR = 42;
        public static final int BOTTOM_MESSAGE_NOTICE = 38;
        public static final int COMMENT_LIST_REFRESH_ANIMATION = 16;
        public static final int COMMENT_NOTICE = 10;
        public static final int DISTRICT_HOURLY_RANK_TEMP_ENHANCE = 15;
        public static final int DISTRICT_RANK = 6;
        public static final int ENTER_ROOM_MESSAGE = 31;
        public static final int FLOAT_SCREEN = 32;
        public static final int FOLD_MESSAGE = 35;
        public static final int GIFT_ACHIEVEMENT = 46;
        public static final int GIFT_SLOT = 30;
        public static final int GLOBAL_BROADCAST_NOTICE = 13;
        public static final int HIGH_FREQUENCY_COMMENT = 34;
        public static final int HOTSPOT_RANK = 14;
        public static final int INTERACTIVE_PROGAMMME = 19;
        public static final int LIKE_HEART_PARTICLE = 24;
        public static final int LIVE_SUBCRIBE = 18;
        public static final int LYRICS = 9;
        public static final int MAGIC_MAGIC_GIFT_EFFECTS = 11;
        public static final int MERCHANT_PENDANT_AREA = 23;
        public static final int NON_UGC_COMMENT_MESSAGE = 29;
        public static final int OVER_ROOM = 22;
        public static final int PASTER = 21;
        public static final int QUICK_COMMENT = 33;
        public static final int RIGHT_BOTTOM_REVENUE_WIDGET = 1;
        public static final int RIGHT_PENDANT = 43;
        public static final int SQUARE_BACK_ENTRANCE = 44;
        public static final int STICKER = 20;
        public static final int TEMP_ENHANCE_MESSAGE = 5;
        public static final int TEMP_INDICATOR_AREA = 27;
        public static final int TOP_BROADCAST_NOTICE = 4;
        public static final int TOP_LEFT_REVENUE_WIDGET = 8;
        public static final int TOP_RIGHT_NOTICE = 3;
        public static final int UGC_COMMENT_MESSAGE = 28;
        public static final int UNKNOWN = 0;
        public static final int UPPER_LEFT_BANNER = 40;
        public static final int USER_RANK_AREA = 17;
        public static final int WEALTH_GRADE_ENTER_ROOM_EFFECT = 12;
        public static final int WISH_LIST = 7;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface RightPendantItemType {
        public static final int ASK_QUESTION = 0;
        public static final int BANNER_PENDANT = 4;
        public static final int BUSINESS_PENDANT = 2;
        public static final int GAME_PENDANT = 3;
        public static final int HOUSE_CONSULT_PENDANT = 1;
    }

    public static LiveOperationModuleConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveOperationModuleConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveOperationModuleConfig() {
        clear();
    }

    public final LiveOperationModuleConfig clear() {
        this.moduleType = 0;
        this.delayTimeWorkMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.moduleType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.delayTimeWorkMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.moduleType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.delayTimeWorkMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveOperationModuleConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 38:
                    case 40:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                        this.moduleType = int32;
                        break;
                }
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.delayTimeWorkMs = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static LiveOperationModuleConfig parseFrom(byte[] bArr) {
        return (LiveOperationModuleConfig) MessageNano.mergeFrom(new LiveOperationModuleConfig(), bArr);
    }

    public static LiveOperationModuleConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveOperationModuleConfig().mergeFrom(codedInputByteBufferNano);
    }
}
