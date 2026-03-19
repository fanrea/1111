package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BountyGameInitInfo extends MessageNano {
    private static volatile BountyGameInitInfo[] _emptyArray;
    public String currentRoundEndShortTips;
    public long currentRoundEndTime;
    public String currentRoundEndTips;
    public String jumpUrl;
    public boolean meetBountyGameCondition;
    public String notMeetBountyGameConditionShortTips;
    public String notMeetBountyGameConditionTips;
    public String scoreEnoughShortTips;
    public String scoreEnoughTips;
    public String scoreNotEnoughShortTips;
    public String scoreNotEnoughTips;
    public long serverTimestamp;
    public long winBountyMinScore;

    public static BountyGameInitInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BountyGameInitInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public BountyGameInitInfo() {
        clear();
    }

    public final BountyGameInitInfo clear() {
        this.meetBountyGameCondition = false;
        this.currentRoundEndTime = 0L;
        this.winBountyMinScore = 0L;
        this.scoreNotEnoughTips = "";
        this.scoreNotEnoughShortTips = "";
        this.scoreEnoughTips = "";
        this.scoreEnoughShortTips = "";
        this.notMeetBountyGameConditionTips = "";
        this.notMeetBountyGameConditionShortTips = "";
        this.currentRoundEndTips = "";
        this.currentRoundEndShortTips = "";
        this.jumpUrl = "";
        this.serverTimestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.meetBountyGameCondition;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.currentRoundEndTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.winBountyMinScore;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        if (!this.scoreNotEnoughTips.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.scoreNotEnoughTips);
        }
        if (!this.scoreNotEnoughShortTips.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.scoreNotEnoughShortTips);
        }
        if (!this.scoreEnoughTips.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.scoreEnoughTips);
        }
        if (!this.scoreEnoughShortTips.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.scoreEnoughShortTips);
        }
        if (!this.notMeetBountyGameConditionTips.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.notMeetBountyGameConditionTips);
        }
        if (!this.notMeetBountyGameConditionShortTips.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.notMeetBountyGameConditionShortTips);
        }
        if (!this.currentRoundEndTips.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.currentRoundEndTips);
        }
        if (!this.currentRoundEndShortTips.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.currentRoundEndShortTips);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.jumpUrl);
        }
        long j3 = this.serverTimestamp;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.meetBountyGameCondition;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.currentRoundEndTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.winBountyMinScore;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        if (!this.scoreNotEnoughTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.scoreNotEnoughTips);
        }
        if (!this.scoreNotEnoughShortTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.scoreNotEnoughShortTips);
        }
        if (!this.scoreEnoughTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.scoreEnoughTips);
        }
        if (!this.scoreEnoughShortTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.scoreEnoughShortTips);
        }
        if (!this.notMeetBountyGameConditionTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.notMeetBountyGameConditionTips);
        }
        if (!this.notMeetBountyGameConditionShortTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.notMeetBountyGameConditionShortTips);
        }
        if (!this.currentRoundEndTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.currentRoundEndTips);
        }
        if (!this.currentRoundEndShortTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.currentRoundEndShortTips);
        }
        if (!this.jumpUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.jumpUrl);
        }
        long j3 = this.serverTimestamp;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(13, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final BountyGameInitInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.meetBountyGameCondition = codedInputByteBufferNano.readBool();
                    break;
                case 16:
                    this.currentRoundEndTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.winBountyMinScore = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.scoreNotEnoughTips = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.scoreNotEnoughShortTips = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.scoreEnoughTips = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.scoreEnoughShortTips = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.notMeetBountyGameConditionTips = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.notMeetBountyGameConditionShortTips = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.currentRoundEndTips = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.currentRoundEndShortTips = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.jumpUrl = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.serverTimestamp = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static BountyGameInitInfo parseFrom(byte[] bArr) {
        return (BountyGameInitInfo) MessageNano.mergeFrom(new BountyGameInitInfo(), bArr);
    }

    public static BountyGameInitInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new BountyGameInitInfo().mergeFrom(codedInputByteBufferNano);
    }
}
