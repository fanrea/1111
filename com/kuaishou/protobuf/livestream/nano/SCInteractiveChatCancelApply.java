package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatCancelApply extends MessageNano {
    private static volatile SCInteractiveChatCancelApply[] _emptyArray;
    public InteractiveChatUserInfoIdentity applicantIdentity;
    public InteractiveChatBizIdentity bizIdentity;
    public String extraInfo;
    public String operationId;
    public InteractiveChatUserInfoIdentity respondentIdentity;

    public static SCInteractiveChatCancelApply[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatCancelApply[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatCancelApply() {
        clear();
    }

    public final SCInteractiveChatCancelApply clear() {
        this.bizIdentity = null;
        this.applicantIdentity = null;
        this.respondentIdentity = null;
        this.extraInfo = "";
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
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.applicantIdentity;
        if (interactiveChatUserInfoIdentity != null) {
            codedOutputByteBufferNano.writeMessage(2, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.respondentIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            codedOutputByteBufferNano.writeMessage(3, interactiveChatUserInfoIdentity2);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.extraInfo);
        }
        if (!this.operationId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.operationId);
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
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.applicantIdentity;
        if (interactiveChatUserInfoIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = this.respondentIdentity;
        if (interactiveChatUserInfoIdentity2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, interactiveChatUserInfoIdentity2);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extraInfo);
        }
        return !this.operationId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.operationId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatCancelApply mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.applicantIdentity == null) {
                    this.applicantIdentity = new InteractiveChatUserInfoIdentity();
                }
                codedInputByteBufferNano.readMessage(this.applicantIdentity);
            } else if (tag == 26) {
                if (this.respondentIdentity == null) {
                    this.respondentIdentity = new InteractiveChatUserInfoIdentity();
                }
                codedInputByteBufferNano.readMessage(this.respondentIdentity);
            } else if (tag == 34) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.operationId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCInteractiveChatCancelApply parseFrom(byte[] bArr) {
        return (SCInteractiveChatCancelApply) MessageNano.mergeFrom(new SCInteractiveChatCancelApply(), bArr);
    }

    public static SCInteractiveChatCancelApply parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatCancelApply().mergeFrom(codedInputByteBufferNano);
    }
}
