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
public final class SCInteractiveChatCancelCall extends MessageNano {
    private static volatile SCInteractiveChatCancelCall[] _emptyArray;
    public InteractiveChatBizIdentity bizIdentity;
    public InteractiveChatUserInfoIdentity caller;
    public String extraInfo;
    public InteractiveChatUserInfoIdentity[] guest;
    public Map<Long, String> inviteeId2OperationId;

    public static SCInteractiveChatCancelCall[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatCancelCall[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatCancelCall() {
        clear();
    }

    public final SCInteractiveChatCancelCall clear() {
        this.bizIdentity = null;
        this.caller = null;
        this.guest = InteractiveChatUserInfoIdentity.emptyArray();
        this.extraInfo = "";
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
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.caller;
        if (interactiveChatUserInfoIdentity != null) {
            codedOutputByteBufferNano.writeMessage(2, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.guest;
                if (i >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = interactiveChatUserInfoIdentityArr2[i];
                if (interactiveChatUserInfoIdentity2 != null) {
                    codedOutputByteBufferNano.writeMessage(3, interactiveChatUserInfoIdentity2);
                }
                i++;
            }
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.extraInfo);
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
        InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity = this.caller;
        if (interactiveChatUserInfoIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, interactiveChatUserInfoIdentity);
        }
        InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr = this.guest;
        if (interactiveChatUserInfoIdentityArr != null && interactiveChatUserInfoIdentityArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatUserInfoIdentity[] interactiveChatUserInfoIdentityArr2 = this.guest;
                if (i >= interactiveChatUserInfoIdentityArr2.length) {
                    break;
                }
                InteractiveChatUserInfoIdentity interactiveChatUserInfoIdentity2 = interactiveChatUserInfoIdentityArr2[i];
                if (interactiveChatUserInfoIdentity2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, interactiveChatUserInfoIdentity2);
                }
                i++;
            }
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extraInfo);
        }
        Map<Long, String> map = this.inviteeId2OperationId;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 5, 4, 9) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatCancelCall mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.caller == null) {
                    this.caller = new InteractiveChatUserInfoIdentity();
                }
                codedInputByteBufferNano.readMessage(this.caller);
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
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
            } else if (tag == 34) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.inviteeId2OperationId = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.inviteeId2OperationId, mapFactory, 4, 9, null, 8, 18);
            }
        }
    }

    public static SCInteractiveChatCancelCall parseFrom(byte[] bArr) {
        return (SCInteractiveChatCancelCall) MessageNano.mergeFrom(new SCInteractiveChatCancelCall(), bArr);
    }

    public static SCInteractiveChatCancelCall parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatCancelCall().mergeFrom(codedInputByteBufferNano);
    }
}
