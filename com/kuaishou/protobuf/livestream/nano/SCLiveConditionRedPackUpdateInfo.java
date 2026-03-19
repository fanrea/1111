package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCustomRedPackSkinMessage;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveConditionRedPackUpdateInfo extends MessageNano {
    private static volatile SCLiveConditionRedPackUpdateInfo[] _emptyArray;
    public String displayParticipantCount;
    public boolean enableGrabLeeeNotice;
    public boolean enableGrabLeeePopup;
    public LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig enhancedUiConfig;
    public String liveStreamId;
    public int participantCount;
    public LiveConditionRedPackPreparePageUIConfig preparePageUiConfig;
    public long realLotteryTime;
    public int redPackBizType;
    public String redPackId;
    public int redPackType;
    public LiveConditionLEEETaskPageUIConfig taskPageUiConfig;
    public int taskState;

    public static SCLiveConditionRedPackUpdateInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveConditionRedPackUpdateInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveConditionRedPackUpdateInfo() {
        clear();
    }

    public final SCLiveConditionRedPackUpdateInfo clear() {
        this.liveStreamId = "";
        this.redPackType = 0;
        this.redPackId = "";
        this.displayParticipantCount = "";
        this.participantCount = 0;
        this.redPackBizType = 0;
        this.preparePageUiConfig = null;
        this.taskState = 0;
        this.taskPageUiConfig = null;
        this.realLotteryTime = 0L;
        this.enableGrabLeeePopup = false;
        this.enableGrabLeeeNotice = false;
        this.enhancedUiConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.redPackId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.redPackId);
        }
        if (!this.displayParticipantCount.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.displayParticipantCount);
        }
        int i2 = this.participantCount;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i2);
        }
        int i3 = this.redPackBizType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        LiveConditionRedPackPreparePageUIConfig liveConditionRedPackPreparePageUIConfig = this.preparePageUiConfig;
        if (liveConditionRedPackPreparePageUIConfig != null) {
            codedOutputByteBufferNano.writeMessage(7, liveConditionRedPackPreparePageUIConfig);
        }
        int i4 = this.taskState;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i4);
        }
        LiveConditionLEEETaskPageUIConfig liveConditionLEEETaskPageUIConfig = this.taskPageUiConfig;
        if (liveConditionLEEETaskPageUIConfig != null) {
            codedOutputByteBufferNano.writeMessage(9, liveConditionLEEETaskPageUIConfig);
        }
        long j = this.realLotteryTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j);
        }
        boolean z = this.enableGrabLeeePopup;
        if (z) {
            codedOutputByteBufferNano.writeBool(11, z);
        }
        boolean z2 = this.enableGrabLeeeNotice;
        if (z2) {
            codedOutputByteBufferNano.writeBool(12, z2);
        }
        LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig liveLEEEnhancedUiConfig = this.enhancedUiConfig;
        if (liveLEEEnhancedUiConfig != null) {
            codedOutputByteBufferNano.writeMessage(13, liveLEEEnhancedUiConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.redPackType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        if (!this.redPackId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.redPackId);
        }
        if (!this.displayParticipantCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayParticipantCount);
        }
        int i2 = this.participantCount;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i2);
        }
        int i3 = this.redPackBizType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        LiveConditionRedPackPreparePageUIConfig liveConditionRedPackPreparePageUIConfig = this.preparePageUiConfig;
        if (liveConditionRedPackPreparePageUIConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveConditionRedPackPreparePageUIConfig);
        }
        int i4 = this.taskState;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i4);
        }
        LiveConditionLEEETaskPageUIConfig liveConditionLEEETaskPageUIConfig = this.taskPageUiConfig;
        if (liveConditionLEEETaskPageUIConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveConditionLEEETaskPageUIConfig);
        }
        long j = this.realLotteryTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j);
        }
        boolean z = this.enableGrabLeeePopup;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z);
        }
        boolean z2 = this.enableGrabLeeeNotice;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z2);
        }
        LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig liveLEEEnhancedUiConfig = this.enhancedUiConfig;
        return liveLEEEnhancedUiConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(13, liveLEEEnhancedUiConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveConditionRedPackUpdateInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        switch (int32) {
                        }
                    }
                    this.redPackType = int32;
                    break;
                case 26:
                    this.redPackId = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.displayParticipantCount = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.participantCount = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.redPackBizType = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    if (this.preparePageUiConfig == null) {
                        this.preparePageUiConfig = new LiveConditionRedPackPreparePageUIConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.preparePageUiConfig);
                    break;
                case 64:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3) {
                        break;
                    } else {
                        this.taskState = int322;
                        break;
                    }
                    break;
                case 74:
                    if (this.taskPageUiConfig == null) {
                        this.taskPageUiConfig = new LiveConditionLEEETaskPageUIConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.taskPageUiConfig);
                    break;
                case 80:
                    this.realLotteryTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 88:
                    this.enableGrabLeeePopup = codedInputByteBufferNano.readBool();
                    break;
                case 96:
                    this.enableGrabLeeeNotice = codedInputByteBufferNano.readBool();
                    break;
                case 106:
                    if (this.enhancedUiConfig == null) {
                        this.enhancedUiConfig = new LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.enhancedUiConfig);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveConditionRedPackUpdateInfo parseFrom(byte[] bArr) {
        return (SCLiveConditionRedPackUpdateInfo) MessageNano.mergeFrom(new SCLiveConditionRedPackUpdateInfo(), bArr);
    }

    public static SCLiveConditionRedPackUpdateInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveConditionRedPackUpdateInfo().mergeFrom(codedInputByteBufferNano);
    }
}
