package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveConditionLEEETaskPageUIConfig extends MessageNano {
    private static volatile LiveConditionLEEETaskPageUIConfig[] _emptyArray;
    public String actionAreaHasParticipateObjectStateSubTitle;
    public String actionAreaHasParticipateObjectStateTitle;
    public String actionAreaMainStateSubTitle;
    public String actionAreaMainStateTitle;
    public String actionAreaNoParticipateObjectStateSubTitle;
    public String actionAreaNoParticipateObjectStateTitle;
    public LiveConditionLEEETaskPageUIBottomPanel bottomPanelInfo;
    public UserInfos.PicUrl[] headPic;
    public String policyAreaMainStateTipsTitle;
    public String policyAreaObjectStateTipsTitle;
    public int realTaskProgressCount;
    public int targetTaskTotalCount;
    public long taskDeadLineMs;
    public long taskDisplayDeadLineMs;
    public String taskDoingDesc;
    public String taskDoingMainStateDesc;
    public String taskWaitSettleDesc;

    public static LiveConditionLEEETaskPageUIConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveConditionLEEETaskPageUIConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveConditionLEEETaskPageUIConfig() {
        clear();
    }

    public final LiveConditionLEEETaskPageUIConfig clear() {
        this.taskDoingDesc = "";
        this.realTaskProgressCount = 0;
        this.targetTaskTotalCount = 0;
        this.taskDeadLineMs = 0L;
        this.actionAreaNoParticipateObjectStateTitle = "";
        this.actionAreaNoParticipateObjectStateSubTitle = "";
        this.policyAreaObjectStateTipsTitle = "";
        this.policyAreaMainStateTipsTitle = "";
        this.actionAreaMainStateTitle = "";
        this.actionAreaMainStateSubTitle = "";
        this.actionAreaHasParticipateObjectStateTitle = "";
        this.actionAreaHasParticipateObjectStateSubTitle = "";
        this.taskDisplayDeadLineMs = 0L;
        this.taskWaitSettleDesc = "";
        this.headPic = UserInfos.PicUrl.emptyArray();
        this.bottomPanelInfo = null;
        this.taskDoingMainStateDesc = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.taskDoingDesc.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.taskDoingDesc);
        }
        int i = this.realTaskProgressCount;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        int i2 = this.targetTaskTotalCount;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i2);
        }
        long j = this.taskDeadLineMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        if (!this.actionAreaNoParticipateObjectStateTitle.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.actionAreaNoParticipateObjectStateTitle);
        }
        if (!this.actionAreaNoParticipateObjectStateSubTitle.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.actionAreaNoParticipateObjectStateSubTitle);
        }
        if (!this.policyAreaObjectStateTipsTitle.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.policyAreaObjectStateTipsTitle);
        }
        if (!this.policyAreaMainStateTipsTitle.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.policyAreaMainStateTipsTitle);
        }
        if (!this.actionAreaMainStateTitle.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.actionAreaMainStateTitle);
        }
        if (!this.actionAreaMainStateSubTitle.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.actionAreaMainStateSubTitle);
        }
        if (!this.actionAreaHasParticipateObjectStateTitle.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.actionAreaHasParticipateObjectStateTitle);
        }
        if (!this.actionAreaHasParticipateObjectStateSubTitle.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.actionAreaHasParticipateObjectStateSubTitle);
        }
        long j2 = this.taskDisplayDeadLineMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j2);
        }
        if (!this.taskWaitSettleDesc.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.taskWaitSettleDesc);
        }
        UserInfos.PicUrl[] picUrlArr = this.headPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headPic;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(15, picUrl);
                }
                i3++;
            }
        }
        LiveConditionLEEETaskPageUIBottomPanel liveConditionLEEETaskPageUIBottomPanel = this.bottomPanelInfo;
        if (liveConditionLEEETaskPageUIBottomPanel != null) {
            codedOutputByteBufferNano.writeMessage(16, liveConditionLEEETaskPageUIBottomPanel);
        }
        if (!this.taskDoingMainStateDesc.equals("")) {
            codedOutputByteBufferNano.writeString(17, this.taskDoingMainStateDesc);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.taskDoingDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.taskDoingDesc);
        }
        int i = this.realTaskProgressCount;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        int i2 = this.targetTaskTotalCount;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
        }
        long j = this.taskDeadLineMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        if (!this.actionAreaNoParticipateObjectStateTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.actionAreaNoParticipateObjectStateTitle);
        }
        if (!this.actionAreaNoParticipateObjectStateSubTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.actionAreaNoParticipateObjectStateSubTitle);
        }
        if (!this.policyAreaObjectStateTipsTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.policyAreaObjectStateTipsTitle);
        }
        if (!this.policyAreaMainStateTipsTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.policyAreaMainStateTipsTitle);
        }
        if (!this.actionAreaMainStateTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.actionAreaMainStateTitle);
        }
        if (!this.actionAreaMainStateSubTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.actionAreaMainStateSubTitle);
        }
        if (!this.actionAreaHasParticipateObjectStateTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.actionAreaHasParticipateObjectStateTitle);
        }
        if (!this.actionAreaHasParticipateObjectStateSubTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.actionAreaHasParticipateObjectStateSubTitle);
        }
        long j2 = this.taskDisplayDeadLineMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j2);
        }
        if (!this.taskWaitSettleDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.taskWaitSettleDesc);
        }
        UserInfos.PicUrl[] picUrlArr = this.headPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headPic;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, picUrl);
                }
                i3++;
            }
        }
        LiveConditionLEEETaskPageUIBottomPanel liveConditionLEEETaskPageUIBottomPanel = this.bottomPanelInfo;
        if (liveConditionLEEETaskPageUIBottomPanel != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, liveConditionLEEETaskPageUIBottomPanel);
        }
        return !this.taskDoingMainStateDesc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.taskDoingMainStateDesc) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveConditionLEEETaskPageUIConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.taskDoingDesc = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.realTaskProgressCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.targetTaskTotalCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.taskDeadLineMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    this.actionAreaNoParticipateObjectStateTitle = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.actionAreaNoParticipateObjectStateSubTitle = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.policyAreaObjectStateTipsTitle = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.policyAreaMainStateTipsTitle = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.actionAreaMainStateTitle = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.actionAreaMainStateSubTitle = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.actionAreaHasParticipateObjectStateTitle = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.actionAreaHasParticipateObjectStateSubTitle = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.taskDisplayDeadLineMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 114:
                    this.taskWaitSettleDesc = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    UserInfos.PicUrl[] picUrlArr = this.headPic;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.headPic, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.headPic = picUrlArr2;
                    break;
                case 130:
                    if (this.bottomPanelInfo == null) {
                        this.bottomPanelInfo = new LiveConditionLEEETaskPageUIBottomPanel();
                    }
                    codedInputByteBufferNano.readMessage(this.bottomPanelInfo);
                    break;
                case 138:
                    this.taskDoingMainStateDesc = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveConditionLEEETaskPageUIConfig parseFrom(byte[] bArr) {
        return (LiveConditionLEEETaskPageUIConfig) MessageNano.mergeFrom(new LiveConditionLEEETaskPageUIConfig(), bArr);
    }

    public static LiveConditionLEEETaskPageUIConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveConditionLEEETaskPageUIConfig().mergeFrom(codedInputByteBufferNano);
    }
}
