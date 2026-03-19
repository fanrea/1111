package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatApplyReject extends MessageNano {
    private static volatile SCInteractiveChatApplyReject[] _emptyArray;
    public UserInfos.UserInfo applicant;
    public InteractiveChatUserInfoIdentity applicantIdentity;
    public InteractiveChatBizIdentity bizIdentity;
    public String extraInfo;
    public String operationId;
    public UserInfos.UserInfo respondent;
    public InteractiveChatUserInfoIdentity respondentIdentity;
    public long timestamp;

    public static SCInteractiveChatApplyReject[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatApplyReject[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatApplyReject() {
        clear();
    }

    public final SCInteractiveChatApplyReject clear() {
        this.bizIdentity = null;
        this.applicant = null;
        this.respondent = null;
        this.extraInfo = "";
        this.timestamp = 0L;
        this.applicantIdentity = null;
        this.respondentIdentity = null;
        this.operationId = "";
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
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.applicantIdentity;
        if (interactiveChatUserInfoIdentity != null) {
            codedOutputByteBufferNano.writeMessage(6, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.respondentIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            codedOutputByteBufferNano.writeMessage(7, interactiveChatUserInfoIdentity2);
        }
        if (!this.operationId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.operationId);
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
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.applicantIdentity;
        if (interactiveChatUserInfoIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.respondentIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, interactiveChatUserInfoIdentity2);
        }
        return !this.operationId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.operationId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatApplyReject mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.bizIdentity == null) {
                    this.bizIdentity = new InteractiveChatBizIdentity();
                }
                codedInputByteBufferNano.readMessage(this.bizIdentity);
            } else if (tag == 18) {
                if (this.applicant == null) {
                    this.applicant = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.applicant);
            } else if (tag == 26) {
                if (this.respondent == null) {
                    this.respondent = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.respondent);
            } else if (tag == 34) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                if (this.applicantIdentity == null) {
                    this.applicantIdentity = new InteractiveChatUserInfoIdentity();
                }
                codedInputByteBufferNano.readMessage(this.applicantIdentity);
            } else if (tag == 58) {
                if (this.respondentIdentity == null) {
                    this.respondentIdentity = new InteractiveChatUserInfoIdentity();
                }
                codedInputByteBufferNano.readMessage(this.respondentIdentity);
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.operationId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCInteractiveChatApplyReject parseFrom(byte[] bArr) {
        return (SCInteractiveChatApplyReject) MessageNano.mergeFrom(new SCInteractiveChatApplyReject(), bArr);
    }

    public static SCInteractiveChatApplyReject parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatApplyReject().mergeFrom(codedInputByteBufferNano);
    }
}
