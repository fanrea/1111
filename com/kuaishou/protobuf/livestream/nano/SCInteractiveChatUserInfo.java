package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatUserInfo extends MessageNano {
    private static volatile SCInteractiveChatUserInfo[] _emptyArray;
    public InteractiveChatBizIdentity bizIdentity;
    public String extraInfo;
    public long timestamp;
    public InteractiveChatUserInfoIdentity[] userInfo;

    public static SCInteractiveChatUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatUserInfo() {
        clear();
    }

    public final SCInteractiveChatUserInfo clear() {
        this.bizIdentity = null;
        this.userInfo = InteractiveChatUserInfoIdentity.emptyArray();
        this.extraInfo = "";
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.userInfo;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.userInfo;
                if (i >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = interactiveChatUserInfoIdentityArr2[i];
                if (interactiveChatUserInfoIdentity != null) {
                    codedOutputByteBufferNano.writeMessage(2, interactiveChatUserInfoIdentity);
                }
                i++;
            }
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.extraInfo);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
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
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.userInfo;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.userInfo;
                if (i >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = interactiveChatUserInfoIdentityArr2[i];
                if (interactiveChatUserInfoIdentity != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, interactiveChatUserInfoIdentity);
                }
                i++;
            }
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.extraInfo);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.userInfo;
                int length = interactiveChatUserInfoIdentityArr == null ? 0 : interactiveChatUserInfoIdentityArr.length;
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = new InteractiveChatUserInfoIdentity[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.userInfo, 0, interactiveChatUserInfoIdentityArr2, 0, length);
                }
                while (length < interactiveChatUserInfoIdentityArr2.length - 1) {
                    interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                    codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                this.userInfo = interactiveChatUserInfoIdentityArr2;
            } else if (tag == 26) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCInteractiveChatUserInfo parseFrom(byte[] bArr) {
        return (SCInteractiveChatUserInfo) MessageNano.mergeFrom(new SCInteractiveChatUserInfo(), bArr);
    }

    public static SCInteractiveChatUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatUserInfo().mergeFrom(codedInputByteBufferNano);
    }
}
