package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveConditionRedPackPreparePageUIConfig extends MessageNano {
    private static volatile LiveConditionRedPackPreparePageUIConfig[] _emptyArray;
    public String actionText;
    public String avatarDesc;
    public UserInfos.PicUrl[] headPic;
    public String mainStateTips;
    public String objectStateNotParticipantActionSubTips;
    public String objectStateNotParticipantTips;
    public String objectStateParticipantActionSubTips;
    public String objectStateParticipantTips;
    public int targetTaskTotalCount;
    public String taskReadyDesc;

    public static LiveConditionRedPackPreparePageUIConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveConditionRedPackPreparePageUIConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveConditionRedPackPreparePageUIConfig() {
        clear();
    }

    public final LiveConditionRedPackPreparePageUIConfig clear() {
        this.avatarDesc = "";
        this.mainStateTips = "";
        this.objectStateNotParticipantTips = "";
        this.objectStateParticipantTips = "";
        this.actionText = "";
        this.taskReadyDesc = "";
        this.targetTaskTotalCount = 0;
        this.objectStateNotParticipantActionSubTips = "";
        this.objectStateParticipantActionSubTips = "";
        this.headPic = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.avatarDesc.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.avatarDesc);
        }
        if (!this.mainStateTips.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.mainStateTips);
        }
        if (!this.objectStateNotParticipantTips.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.objectStateNotParticipantTips);
        }
        if (!this.objectStateParticipantTips.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.objectStateParticipantTips);
        }
        if (!this.actionText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.actionText);
        }
        if (!this.taskReadyDesc.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.taskReadyDesc);
        }
        int i = this.targetTaskTotalCount;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i);
        }
        if (!this.objectStateNotParticipantActionSubTips.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.objectStateNotParticipantActionSubTips);
        }
        if (!this.objectStateParticipantActionSubTips.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.objectStateParticipantActionSubTips);
        }
        UserInfos.PicUrl[] picUrlArr = this.headPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headPic;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(10, picUrl);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.avatarDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.avatarDesc);
        }
        if (!this.mainStateTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.mainStateTips);
        }
        if (!this.objectStateNotParticipantTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.objectStateNotParticipantTips);
        }
        if (!this.objectStateParticipantTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.objectStateParticipantTips);
        }
        if (!this.actionText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.actionText);
        }
        if (!this.taskReadyDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.taskReadyDesc);
        }
        int i = this.targetTaskTotalCount;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i);
        }
        if (!this.objectStateNotParticipantActionSubTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.objectStateNotParticipantActionSubTips);
        }
        if (!this.objectStateParticipantActionSubTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.objectStateParticipantActionSubTips);
        }
        UserInfos.PicUrl[] picUrlArr = this.headPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headPic;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, picUrl);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveConditionRedPackPreparePageUIConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.avatarDesc = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.mainStateTips = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.objectStateNotParticipantTips = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.objectStateParticipantTips = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.actionText = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.taskReadyDesc = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.targetTaskTotalCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.objectStateNotParticipantActionSubTips = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.objectStateParticipantActionSubTips = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
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
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveConditionRedPackPreparePageUIConfig parseFrom(byte[] bArr) {
        return (LiveConditionRedPackPreparePageUIConfig) MessageNano.mergeFrom(new LiveConditionRedPackPreparePageUIConfig(), bArr);
    }

    public static LiveConditionRedPackPreparePageUIConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveConditionRedPackPreparePageUIConfig().mergeFrom(codedInputByteBufferNano);
    }
}
