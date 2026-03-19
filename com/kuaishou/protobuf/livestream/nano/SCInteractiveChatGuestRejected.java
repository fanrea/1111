package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatGuestRejected extends MessageNano {
    private static volatile SCInteractiveChatGuestRejected[] _emptyArray;
    public InteractiveChatBizIdentity bizIdentity;
    public String extraInfo;
    public InteractiveChatUserInfoIdentity[] guest;
    public Map<Long, String> inviteeId2OperationId;
    public long timestamp;

    public static SCInteractiveChatGuestRejected[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatGuestRejected[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatGuestRejected() {
        clear();
    }

    public final SCInteractiveChatGuestRejected clear() {
        this.bizIdentity = null;
        this.guest = InteractiveChatUserInfoIdentity.emptyArray();
        this.extraInfo = "";
        this.timestamp = 0L;
        this.inviteeId2OperationId = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.guest;
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
        Map<Long, String> map = this.inviteeId2OperationId;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 5, 4, 9);
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
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.guest;
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
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        Map<Long, String> map = this.inviteeId2OperationId;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 5, 4, 9) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatGuestRejected mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
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
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
                int length = interactiveChatUserInfoIdentityArr == null ? 0 : interactiveChatUserInfoIdentityArr.length;
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = new InteractiveChatUserInfoIdentity[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.guest, 0, interactiveChatUserInfoIdentityArr2, 0, length);
                }
                while (length < interactiveChatUserInfoIdentityArr2.length - 1) {
                    interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                    codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveChatUserInfoIdentityArr2[length] = new InteractiveChatUserInfoIdentity();
                codedInputByteBufferNano.readMessage(interactiveChatUserInfoIdentityArr2[length]);
                this.guest = interactiveChatUserInfoIdentityArr2;
            } else if (tag == 26) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.inviteeId2OperationId = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.inviteeId2OperationId, mapFactory, 4, 9, null, 8, 18);
            }
        }
    }

    public static SCInteractiveChatGuestRejected parseFrom(byte[] bArr) {
        return (SCInteractiveChatGuestRejected) MessageNano.mergeFrom(new SCInteractiveChatGuestRejected(), bArr);
    }

    public static SCInteractiveChatGuestRejected parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatGuestRejected().mergeFrom(codedInputByteBufferNano);
    }
}
