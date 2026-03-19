package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveCommonEffectInfo extends MessageNano {
    private static volatile LiveCommonEffectInfo[] _emptyArray;
    public int banBizType;
    public int batchSize;
    public String bizExtraInfo;
    public String[] blackUser;
    public boolean cannotBebreak;
    public boolean disableCreateTasksByBatchSize;
    public boolean displayImmediately;
    public int effectBiz;
    public String effectiveKey;
    public long expireDurationMs;
    public String extraInfo;
    public LiveEffectExtraResInfo[] extraResInfo;
    public UserInfos.UserInfo fromUser;
    public LiveSendGiftTraceInfo giftTraceInfo;
    public boolean isControlledByAuthor;
    public boolean isFaceFollowingEffect;
    public String liveStreamId;
    public String mergeKey;
    public int rank;
    public int sendInfoToYtechTime;
    public boolean showNickname;
    public boolean showUserHeadPic;
    public boolean streamMerge;
    public long time;
    public UserInfos.UserInfo toUser;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommonEffectBiz {
        public static final int CNY2024_WARMUP_PRAY_WISH_EFFECT = 13;
        public static final int LIVE_ACTIVITY_ENTER_ROOM_ADVANCE_V3 = 6;
        public static final int LIVE_ATMOSPHERE_GIFT = 12;
        public static final int LIVE_CNY2023_EVE = 8;
        public static final int LIVE_CNY2024_EVE = 14;
        public static final int LIVE_CUSTOM_GIFT = 10;
        public static final int LIVE_DIY_GIFT = 7;
        public static final int LIVE_FANS_GROUP_PK_ADDITION_GIFT = 9;
        public static final int LIVE_INTERACTIVE_RANDOM_GIFT = 2;
        public static final int LIVE_MULTI_PLAYER_INTERACTIVE_GIFT = 3;
        public static final int LIVE_PARALLEL_RENDER_EFFECT = 11;
        public static final int LIVE_PK_LUCKY_TIME = 1;
        public static final int LIVE_RECHARGEABLE_GIFT = 4;
        public static final int LIVE_VIRTUAL_IMAGE_EFFECT = 5;
        public static final int UNKNOWN_BIZ = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SendInfoToYtechTime {
        public static final int ON_RECEIVE_YTECH_READY = 1;
        public static final int ON_RENDER_START = 0;
    }

    public static LiveCommonEffectInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCommonEffectInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCommonEffectInfo() {
        clear();
    }

    public final LiveCommonEffectInfo clear() {
        this.effectiveKey = "";
        this.mergeKey = "";
        this.rank = 0;
        this.time = 0L;
        this.fromUser = null;
        this.toUser = null;
        this.liveStreamId = "";
        this.expireDurationMs = 0L;
        this.displayImmediately = false;
        this.isControlledByAuthor = false;
        this.showUserHeadPic = false;
        this.showNickname = false;
        this.effectBiz = 0;
        this.streamMerge = false;
        this.extraInfo = "";
        this.isFaceFollowingEffect = false;
        this.banBizType = 0;
        this.blackUser = WireFormatNano.EMPTY_STRING_ARRAY;
        this.bizExtraInfo = "";
        this.extraResInfo = LiveEffectExtraResInfo.emptyArray();
        this.sendInfoToYtechTime = 0;
        this.cannotBebreak = false;
        this.batchSize = 0;
        this.disableCreateTasksByBatchSize = false;
        this.giftTraceInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.effectiveKey.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.effectiveKey);
        }
        if (!this.mergeKey.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.mergeKey);
        }
        int i = this.rank;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        UserInfos.UserInfo userInfo = this.fromUser;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.toUser;
        if (userInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(6, userInfo2);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.liveStreamId);
        }
        long j2 = this.expireDurationMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        boolean z = this.displayImmediately;
        if (z) {
            codedOutputByteBufferNano.writeBool(9, z);
        }
        boolean z2 = this.isControlledByAuthor;
        if (z2) {
            codedOutputByteBufferNano.writeBool(10, z2);
        }
        boolean z3 = this.showUserHeadPic;
        if (z3) {
            codedOutputByteBufferNano.writeBool(11, z3);
        }
        boolean z4 = this.showNickname;
        if (z4) {
            codedOutputByteBufferNano.writeBool(12, z4);
        }
        int i2 = this.effectBiz;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i2);
        }
        boolean z5 = this.streamMerge;
        if (z5) {
            codedOutputByteBufferNano.writeBool(14, z5);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.extraInfo);
        }
        boolean z6 = this.isFaceFollowingEffect;
        if (z6) {
            codedOutputByteBufferNano.writeBool(16, z6);
        }
        int i3 = this.banBizType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(17, i3);
        }
        String[] strArr = this.blackUser;
        int i4 = 0;
        if (strArr != null && strArr.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.blackUser;
                if (i5 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i5];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(18, str);
                }
                i5++;
            }
        }
        if (!this.bizExtraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.bizExtraInfo);
        }
        LiveEffectExtraResInfo[] liveEffectExtraResInfoArr = this.extraResInfo;
        if (liveEffectExtraResInfoArr != null && liveEffectExtraResInfoArr.length > 0) {
            while (true) {
                LiveEffectExtraResInfo[] liveEffectExtraResInfoArr2 = this.extraResInfo;
                if (i4 >= liveEffectExtraResInfoArr2.length) {
                    break;
                }
                LiveEffectExtraResInfo liveEffectExtraResInfo = liveEffectExtraResInfoArr2[i4];
                if (liveEffectExtraResInfo != null) {
                    codedOutputByteBufferNano.writeMessage(20, liveEffectExtraResInfo);
                }
                i4++;
            }
        }
        int i6 = this.sendInfoToYtechTime;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(21, i6);
        }
        boolean z7 = this.cannotBebreak;
        if (z7) {
            codedOutputByteBufferNano.writeBool(22, z7);
        }
        int i7 = this.batchSize;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeUInt32(23, i7);
        }
        boolean z8 = this.disableCreateTasksByBatchSize;
        if (z8) {
            codedOutputByteBufferNano.writeBool(24, z8);
        }
        LiveSendGiftTraceInfo liveSendGiftTraceInfo = this.giftTraceInfo;
        if (liveSendGiftTraceInfo != null) {
            codedOutputByteBufferNano.writeMessage(25, liveSendGiftTraceInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.effectiveKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.effectiveKey);
        }
        if (!this.mergeKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.mergeKey);
        }
        int i = this.rank;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        UserInfos.UserInfo userInfo = this.fromUser;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.toUser;
        if (userInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, userInfo2);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.liveStreamId);
        }
        long j2 = this.expireDurationMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        boolean z = this.displayImmediately;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
        }
        boolean z2 = this.isControlledByAuthor;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z2);
        }
        boolean z3 = this.showUserHeadPic;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z3);
        }
        boolean z4 = this.showNickname;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z4);
        }
        int i2 = this.effectBiz;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i2);
        }
        boolean z5 = this.streamMerge;
        if (z5) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, z5);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.extraInfo);
        }
        boolean z6 = this.isFaceFollowingEffect;
        if (z6) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(16, z6);
        }
        int i3 = this.banBizType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i3);
        }
        String[] strArr = this.blackUser;
        int i4 = 0;
        if (strArr != null && strArr.length > 0) {
            int i5 = 0;
            int iComputeStringSizeNoTag = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.blackUser;
                if (i5 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i5];
                if (str != null) {
                    i6++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i6 * 2);
        }
        if (!this.bizExtraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.bizExtraInfo);
        }
        LiveEffectExtraResInfo[] liveEffectExtraResInfoArr = this.extraResInfo;
        if (liveEffectExtraResInfoArr != null && liveEffectExtraResInfoArr.length > 0) {
            while (true) {
                LiveEffectExtraResInfo[] liveEffectExtraResInfoArr2 = this.extraResInfo;
                if (i4 >= liveEffectExtraResInfoArr2.length) {
                    break;
                }
                LiveEffectExtraResInfo liveEffectExtraResInfo = liveEffectExtraResInfoArr2[i4];
                if (liveEffectExtraResInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, liveEffectExtraResInfo);
                }
                i4++;
            }
        }
        int i7 = this.sendInfoToYtechTime;
        if (i7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(21, i7);
        }
        boolean z7 = this.cannotBebreak;
        if (z7) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, z7);
        }
        int i8 = this.batchSize;
        if (i8 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(23, i8);
        }
        boolean z8 = this.disableCreateTasksByBatchSize;
        if (z8) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(24, z8);
        }
        LiveSendGiftTraceInfo liveSendGiftTraceInfo = this.giftTraceInfo;
        return liveSendGiftTraceInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(25, liveSendGiftTraceInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCommonEffectInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.effectiveKey = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.mergeKey = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    if (this.fromUser == null) {
                        this.fromUser = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.fromUser);
                    break;
                case 50:
                    if (this.toUser == null) {
                        this.toUser = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.toUser);
                    break;
                case 58:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.expireDurationMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.displayImmediately = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.isControlledByAuthor = codedInputByteBufferNano.readBool();
                    break;
                case 88:
                    this.showUserHeadPic = codedInputByteBufferNano.readBool();
                    break;
                case 96:
                    this.showNickname = codedInputByteBufferNano.readBool();
                    break;
                case 104:
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
                            this.effectBiz = int32;
                            break;
                    }
                case 112:
                    this.streamMerge = codedInputByteBufferNano.readBool();
                    break;
                case 122:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.isFaceFollowingEffect = codedInputByteBufferNano.readBool();
                    break;
                case 136:
                    this.banBizType = codedInputByteBufferNano.readUInt32();
                    break;
                case 146:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                    String[] strArr = this.blackUser;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.blackUser, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.blackUser = strArr2;
                    break;
                case 154:
                    this.bizExtraInfo = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    LiveEffectExtraResInfo[] liveEffectExtraResInfoArr = this.extraResInfo;
                    int length2 = liveEffectExtraResInfoArr == null ? 0 : liveEffectExtraResInfoArr.length;
                    LiveEffectExtraResInfo[] liveEffectExtraResInfoArr2 = new LiveEffectExtraResInfo[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.extraResInfo, 0, liveEffectExtraResInfoArr2, 0, length2);
                    }
                    while (length2 < liveEffectExtraResInfoArr2.length - 1) {
                        liveEffectExtraResInfoArr2[length2] = new LiveEffectExtraResInfo();
                        codedInputByteBufferNano.readMessage(liveEffectExtraResInfoArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    liveEffectExtraResInfoArr2[length2] = new LiveEffectExtraResInfo();
                    codedInputByteBufferNano.readMessage(liveEffectExtraResInfoArr2[length2]);
                    this.extraResInfo = liveEffectExtraResInfoArr2;
                    break;
                case 168:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1) {
                        break;
                    } else {
                        this.sendInfoToYtechTime = int322;
                        break;
                    }
                case 176:
                    this.cannotBebreak = codedInputByteBufferNano.readBool();
                    break;
                case 184:
                    this.batchSize = codedInputByteBufferNano.readUInt32();
                    break;
                case 192:
                    this.disableCreateTasksByBatchSize = codedInputByteBufferNano.readBool();
                    break;
                case 202:
                    if (this.giftTraceInfo == null) {
                        this.giftTraceInfo = new LiveSendGiftTraceInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.giftTraceInfo);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveCommonEffectInfo parseFrom(byte[] bArr) {
        return (LiveCommonEffectInfo) MessageNano.mergeFrom(new LiveCommonEffectInfo(), bArr);
    }

    public static LiveCommonEffectInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCommonEffectInfo().mergeFrom(codedInputByteBufferNano);
    }
}
