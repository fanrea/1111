package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveEncourageTreasureBoxWidget extends MessageNano {
    private static volatile SCLiveEncourageTreasureBoxWidget[] _emptyArray;
    public long giftTaskId;
    public LiveEncourageTaskStageInfo giftTaskStage;
    public String guideText;
    public boolean isTimerTaskProcessing;
    public String kuaishouLinkUrl;
    public String nebulaLinkUrl;
    public boolean showGuideToast;
    public String text;
    public String timerTaskStageId;
    public int timerTaskStageIndex;
    public String timerTaskStageReportId;
    public int timerTaskStageSeconds;
    public int timerTaskStageStatus;
    public int widgetStatus;

    public static SCLiveEncourageTreasureBoxWidget[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveEncourageTreasureBoxWidget[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveEncourageTreasureBoxWidget() {
        clear();
    }

    public final SCLiveEncourageTreasureBoxWidget clear() {
        this.isTimerTaskProcessing = false;
        this.timerTaskStageId = "";
        this.timerTaskStageIndex = 0;
        this.timerTaskStageSeconds = 0;
        this.timerTaskStageStatus = 0;
        this.text = "";
        this.kuaishouLinkUrl = "";
        this.widgetStatus = 0;
        this.showGuideToast = false;
        this.timerTaskStageReportId = "";
        this.nebulaLinkUrl = "";
        this.giftTaskStage = null;
        this.giftTaskId = 0L;
        this.guideText = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isTimerTaskProcessing;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        if (!this.timerTaskStageId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.timerTaskStageId);
        }
        int i = this.timerTaskStageIndex;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        int i2 = this.timerTaskStageSeconds;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        int i3 = this.timerTaskStageStatus;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.text);
        }
        if (!this.kuaishouLinkUrl.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.kuaishouLinkUrl);
        }
        int i4 = this.widgetStatus;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i4);
        }
        boolean z2 = this.showGuideToast;
        if (z2) {
            codedOutputByteBufferNano.writeBool(9, z2);
        }
        if (!this.timerTaskStageReportId.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.timerTaskStageReportId);
        }
        if (!this.nebulaLinkUrl.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.nebulaLinkUrl);
        }
        LiveEncourageTaskStageInfo liveEncourageTaskStageInfo = this.giftTaskStage;
        if (liveEncourageTaskStageInfo != null) {
            codedOutputByteBufferNano.writeMessage(12, liveEncourageTaskStageInfo);
        }
        long j = this.giftTaskId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j);
        }
        if (!this.guideText.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.guideText);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isTimerTaskProcessing;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        if (!this.timerTaskStageId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.timerTaskStageId);
        }
        int i = this.timerTaskStageIndex;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        int i2 = this.timerTaskStageSeconds;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
        }
        int i3 = this.timerTaskStageStatus;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.text);
        }
        if (!this.kuaishouLinkUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.kuaishouLinkUrl);
        }
        int i4 = this.widgetStatus;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i4);
        }
        boolean z2 = this.showGuideToast;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z2);
        }
        if (!this.timerTaskStageReportId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.timerTaskStageReportId);
        }
        if (!this.nebulaLinkUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.nebulaLinkUrl);
        }
        LiveEncourageTaskStageInfo liveEncourageTaskStageInfo = this.giftTaskStage;
        if (liveEncourageTaskStageInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, liveEncourageTaskStageInfo);
        }
        long j = this.giftTaskId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j);
        }
        return !this.guideText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(14, this.guideText) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveEncourageTreasureBoxWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.isTimerTaskProcessing = codedInputByteBufferNano.readBool();
                    break;
                case 18:
                    this.timerTaskStageId = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.timerTaskStageIndex = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.timerTaskStageSeconds = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                        break;
                    } else {
                        this.timerTaskStageStatus = int32;
                        break;
                    }
                    break;
                case 50:
                    this.text = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.kuaishouLinkUrl = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2) {
                        break;
                    } else {
                        this.widgetStatus = int322;
                        break;
                    }
                    break;
                case 72:
                    this.showGuideToast = codedInputByteBufferNano.readBool();
                    break;
                case 82:
                    this.timerTaskStageReportId = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.nebulaLinkUrl = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    if (this.giftTaskStage == null) {
                        this.giftTaskStage = new LiveEncourageTaskStageInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.giftTaskStage);
                    break;
                case 104:
                    this.giftTaskId = codedInputByteBufferNano.readUInt64();
                    break;
                case 114:
                    this.guideText = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveEncourageTreasureBoxWidget parseFrom(byte[] bArr) {
        return (SCLiveEncourageTreasureBoxWidget) MessageNano.mergeFrom(new SCLiveEncourageTreasureBoxWidget(), bArr);
    }

    public static SCLiveEncourageTreasureBoxWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveEncourageTreasureBoxWidget().mergeFrom(codedInputByteBufferNano);
    }
}
