package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAttachGiftNoticeAnimation extends MessageNano {
    private static volatile SCLiveAttachGiftNoticeAnimation[] _emptyArray;
    public LiveAttachGiftGuideConfigMessage attachGiftConfig;
    public long executeDeadlineTime;
    public long executeTime;
    public int giftId;
    public String giftToken;
    public String liveStreamId;
    public int noticeType;
    public int priority;
    public long protectIntervalTime;
    public long showTime;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveAttachGiftNoticeType {
        public static final int LIVE_COMMENT = 5;
        public static final int LIVE_FOLLOW = 2;
        public static final int LIVE_LIKE = 4;
        public static final int LIVE_SHARE = 3;
        public static final int PERIODIC_TRIGGER = 9;
        public static final int PK_CRIT_MOMENT = 7;
        public static final int PK_START = 6;
        public static final int PK_STEAL_TOWER = 8;
        public static final int STAY_IN_ROOM = 1;
        public static final int UNKNOWN_TYPE = 0;
    }

    public static SCLiveAttachGiftNoticeAnimation[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAttachGiftNoticeAnimation[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAttachGiftNoticeAnimation() {
        clear();
    }

    public final SCLiveAttachGiftNoticeAnimation clear() {
        this.executeTime = 0L;
        this.executeDeadlineTime = 0L;
        this.showTime = 0L;
        this.protectIntervalTime = 0L;
        this.liveStreamId = "";
        this.noticeType = 0;
        this.giftId = 0;
        this.giftToken = "";
        this.priority = 0;
        this.attachGiftConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.executeTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.executeDeadlineTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.showTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j4 = this.protectIntervalTime;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j4);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.liveStreamId);
        }
        int i = this.noticeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(6, i);
        }
        int i2 = this.giftId;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i2);
        }
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.giftToken);
        }
        int i3 = this.priority;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i3);
        }
        LiveAttachGiftGuideConfigMessage liveAttachGiftGuideConfigMessage = this.attachGiftConfig;
        if (liveAttachGiftGuideConfigMessage != null) {
            codedOutputByteBufferNano.writeMessage(10, liveAttachGiftGuideConfigMessage);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.executeTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.executeDeadlineTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.showTime;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j4 = this.protectIntervalTime;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j4);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.liveStreamId);
        }
        int i = this.noticeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i);
        }
        int i2 = this.giftId;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i2);
        }
        if (!this.giftToken.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.giftToken);
        }
        int i3 = this.priority;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i3);
        }
        LiveAttachGiftGuideConfigMessage liveAttachGiftGuideConfigMessage = this.attachGiftConfig;
        return liveAttachGiftGuideConfigMessage != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, liveAttachGiftGuideConfigMessage) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAttachGiftNoticeAnimation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.executeTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.executeDeadlineTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.showTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.protectIntervalTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 48:
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
                            this.noticeType = int32;
                            break;
                    }
                case 56:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.giftToken = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.priority = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    if (this.attachGiftConfig == null) {
                        this.attachGiftConfig = new LiveAttachGiftGuideConfigMessage();
                    }
                    codedInputByteBufferNano.readMessage(this.attachGiftConfig);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveAttachGiftNoticeAnimation parseFrom(byte[] bArr) {
        return (SCLiveAttachGiftNoticeAnimation) MessageNano.mergeFrom(new SCLiveAttachGiftNoticeAnimation(), bArr);
    }

    public static SCLiveAttachGiftNoticeAnimation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAttachGiftNoticeAnimation().mergeFrom(codedInputByteBufferNano);
    }
}
