package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveChatBizIdentity extends MessageNano {
    private static volatile InteractiveChatBizIdentity[] _emptyArray;
    public String bizId;
    public int bizType;
    public String chatId;

    public static InteractiveChatBizIdentity[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatBizIdentity[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatBizIdentity() {
        clear();
    }

    public final InteractiveChatBizIdentity clear() {
        this.bizType = 0;
        this.chatId = "";
        this.bizId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.bizType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.chatId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.chatId);
        }
        if (!this.bizId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.bizId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.bizType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.chatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.chatId);
        }
        return !this.bizId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.bizId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatBizIdentity mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                        this.bizType = int32;
                        break;
                }
            } else if (tag == 18) {
                this.chatId = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static InteractiveChatBizIdentity parseFrom(byte[] bArr) {
        return (InteractiveChatBizIdentity) MessageNano.mergeFrom(new InteractiveChatBizIdentity(), bArr);
    }

    public static InteractiveChatBizIdentity parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatBizIdentity().mergeFrom(codedInputByteBufferNano);
    }
}
