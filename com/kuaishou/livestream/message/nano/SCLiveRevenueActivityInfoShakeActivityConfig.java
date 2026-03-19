package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRevenueActivityInfoShakeActivityConfig extends MessageNano {
    private static volatile SCLiveRevenueActivityInfoShakeActivityConfig[] _emptyArray;
    public boolean enableSlide;
    public String shakeGuideBackgroundColor;
    public long shakeGuideDelayMs;
    public long shakeGuideDisplayMs;
    public String shakeGuideImage;
    public long shakeGuideIntervalMs;
    public String shakeGuideSecondText;
    public String shakeGuideSecondTextColor;
    public String shakeGuideText;
    public String shakeGuideTextColor;
    public String shakeImage;
    public String shakeResultDialogDescription;
    public String shakeText;
    public String shakeTextColor;
    public String shakeTipsDialogDescription;
    public long shakeTipsDialogMinDisplayMs;
    public String shakeTipsDialogTitle;

    public static SCLiveRevenueActivityInfoShakeActivityConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRevenueActivityInfoShakeActivityConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRevenueActivityInfoShakeActivityConfig() {
        clear();
    }

    public final SCLiveRevenueActivityInfoShakeActivityConfig clear() {
        this.shakeGuideText = "";
        this.shakeGuideTextColor = "";
        this.shakeGuideSecondText = "";
        this.shakeGuideSecondTextColor = "";
        this.shakeGuideBackgroundColor = "";
        this.shakeGuideImage = "";
        this.shakeText = "";
        this.shakeTextColor = "";
        this.shakeImage = "";
        this.shakeTipsDialogTitle = "";
        this.shakeTipsDialogDescription = "";
        this.shakeResultDialogDescription = "";
        this.shakeGuideDelayMs = 0L;
        this.shakeGuideDisplayMs = 0L;
        this.shakeGuideIntervalMs = 0L;
        this.shakeTipsDialogMinDisplayMs = 0L;
        this.enableSlide = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.shakeGuideText.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.shakeGuideText);
        }
        if (!this.shakeGuideTextColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.shakeGuideTextColor);
        }
        if (!this.shakeGuideSecondText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.shakeGuideSecondText);
        }
        if (!this.shakeGuideSecondTextColor.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.shakeGuideSecondTextColor);
        }
        if (!this.shakeGuideBackgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.shakeGuideBackgroundColor);
        }
        if (!this.shakeGuideImage.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.shakeGuideImage);
        }
        if (!this.shakeText.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.shakeText);
        }
        if (!this.shakeTextColor.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.shakeTextColor);
        }
        if (!this.shakeImage.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.shakeImage);
        }
        if (!this.shakeTipsDialogTitle.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.shakeTipsDialogTitle);
        }
        if (!this.shakeTipsDialogDescription.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.shakeTipsDialogDescription);
        }
        if (!this.shakeResultDialogDescription.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.shakeResultDialogDescription);
        }
        long j = this.shakeGuideDelayMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j);
        }
        long j2 = this.shakeGuideDisplayMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(14, j2);
        }
        long j3 = this.shakeGuideIntervalMs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(15, j3);
        }
        long j4 = this.shakeTipsDialogMinDisplayMs;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j4);
        }
        boolean z = this.enableSlide;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.shakeGuideText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.shakeGuideText);
        }
        if (!this.shakeGuideTextColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.shakeGuideTextColor);
        }
        if (!this.shakeGuideSecondText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.shakeGuideSecondText);
        }
        if (!this.shakeGuideSecondTextColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.shakeGuideSecondTextColor);
        }
        if (!this.shakeGuideBackgroundColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.shakeGuideBackgroundColor);
        }
        if (!this.shakeGuideImage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.shakeGuideImage);
        }
        if (!this.shakeText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.shakeText);
        }
        if (!this.shakeTextColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.shakeTextColor);
        }
        if (!this.shakeImage.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.shakeImage);
        }
        if (!this.shakeTipsDialogTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.shakeTipsDialogTitle);
        }
        if (!this.shakeTipsDialogDescription.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.shakeTipsDialogDescription);
        }
        if (!this.shakeResultDialogDescription.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.shakeResultDialogDescription);
        }
        long j = this.shakeGuideDelayMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j);
        }
        long j2 = this.shakeGuideDisplayMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j2);
        }
        long j3 = this.shakeGuideIntervalMs;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j3);
        }
        long j4 = this.shakeTipsDialogMinDisplayMs;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j4);
        }
        boolean z = this.enableSlide;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(17, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRevenueActivityInfoShakeActivityConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.shakeGuideText = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.shakeGuideTextColor = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.shakeGuideSecondText = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.shakeGuideSecondTextColor = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.shakeGuideBackgroundColor = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.shakeGuideImage = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.shakeText = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.shakeTextColor = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.shakeImage = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.shakeTipsDialogTitle = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.shakeTipsDialogDescription = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.shakeResultDialogDescription = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.shakeGuideDelayMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 112:
                    this.shakeGuideDisplayMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 120:
                    this.shakeGuideIntervalMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 128:
                    this.shakeTipsDialogMinDisplayMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    this.enableSlide = codedInputByteBufferNano.readBool();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveRevenueActivityInfoShakeActivityConfig parseFrom(byte[] bArr) {
        return (SCLiveRevenueActivityInfoShakeActivityConfig) MessageNano.mergeFrom(new SCLiveRevenueActivityInfoShakeActivityConfig(), bArr);
    }

    public static SCLiveRevenueActivityInfoShakeActivityConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRevenueActivityInfoShakeActivityConfig().mergeFrom(codedInputByteBufferNano);
    }
}
