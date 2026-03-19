package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatApplyAccept extends MessageNano {
    private static volatile SCInteractiveChatApplyAccept[] _emptyArray;
    public UserInfos.UserInfo applicant;
    public InteractiveChatUserInfoIdentity applicantIdentity;
    public String aryaConfig;
    public long aryaConfigVersion;
    public InteractiveChatBizIdentity bizIdentity;
    public boolean cleanRemainApplication;
    public String extraInfo;
    public String operationId;
    public UserInfos.UserInfo respondent;
    public InteractiveChatUserInfoIdentity respondentIdentity;
    public long timestamp;

    public static SCInteractiveChatApplyAccept[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatApplyAccept[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatApplyAccept() {
        clear();
    }

    public final SCInteractiveChatApplyAccept clear() {
        this.bizIdentity = null;
        this.applicant = null;
        this.respondent = null;
        this.aryaConfig = "";
        this.extraInfo = "";
        this.timestamp = 0L;
        this.applicantIdentity = null;
        this.respondentIdentity = null;
        this.cleanRemainApplication = false;
        this.operationId = "";
        this.aryaConfigVersion = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        UserInfos.UserInfo userInfo = this.applicant;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.respondent;
        if (userInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(3, userInfo2);
        }
        if (!this.aryaConfig.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.aryaConfig);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.applicantIdentity;
        if (interactiveChatUserInfoIdentity != null) {
            codedOutputByteBufferNano.writeMessage(7, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.respondentIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            codedOutputByteBufferNano.writeMessage(8, interactiveChatUserInfoIdentity2);
        }
        boolean z = this.cleanRemainApplication;
        if (z) {
            codedOutputByteBufferNano.writeBool(9, z);
        }
        if (!this.operationId.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.operationId);
        }
        long j2 = this.aryaConfigVersion;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveChatBizIdentity);
        }
        UserInfos.UserInfo userInfo = this.applicant;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        UserInfos.UserInfo userInfo2 = this.respondent;
        if (userInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo2);
        }
        if (!this.aryaConfig.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.aryaConfig);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.applicantIdentity;
        if (interactiveChatUserInfoIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.respondentIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, interactiveChatUserInfoIdentity2);
        }
        boolean z = this.cleanRemainApplication;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
        }
        if (!this.operationId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.operationId);
        }
        long j2 = this.aryaConfigVersion;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatApplyAccept mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.bizIdentity == null) {
                        this.bizIdentity = new InteractiveChatBizIdentity();
                    }
                    codedInputByteBufferNano.readMessage(this.bizIdentity);
                    break;
                case 18:
                    if (this.applicant == null) {
                        this.applicant = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.applicant);
                    break;
                case 26:
                    if (this.respondent == null) {
                        this.respondent = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.respondent);
                    break;
                case 34:
                    this.aryaConfig = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    if (this.applicantIdentity == null) {
                        this.applicantIdentity = new InteractiveChatUserInfoIdentity();
                    }
                    codedInputByteBufferNano.readMessage(this.applicantIdentity);
                    break;
                case 66:
                    if (this.respondentIdentity == null) {
                        this.respondentIdentity = new InteractiveChatUserInfoIdentity();
                    }
                    codedInputByteBufferNano.readMessage(this.respondentIdentity);
                    break;
                case 72:
                    this.cleanRemainApplication = codedInputByteBufferNano.readBool();
                    break;
                case 82:
                    this.operationId = codedInputByteBufferNano.readString();
                    break;
                case 88:
                    this.aryaConfigVersion = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCInteractiveChatApplyAccept parseFrom(byte[] bArr) {
        return (SCInteractiveChatApplyAccept) MessageNano.mergeFrom(new SCInteractiveChatApplyAccept(), bArr);
    }

    public static SCInteractiveChatApplyAccept parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatApplyAccept().mergeFrom(codedInputByteBufferNano);
    }
}
