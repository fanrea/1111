package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiChatOpened extends MessageNano {
    private static volatile SCLiveMultiChatOpened[] _emptyArray;
    public int mode;
    public String modeExtra;
    public String multiChatId;

    public static SCLiveMultiChatOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiChatOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiChatOpened() {
        clear();
    }

    public final SCLiveMultiChatOpened clear() {
        this.multiChatId = "";
        this.mode = 0;
        this.modeExtra = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.multiChatId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.multiChatId);
        }
        int i = this.mode;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        if (!this.modeExtra.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.modeExtra);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.multiChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.multiChatId);
        }
        int i = this.mode;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        return !this.modeExtra.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.modeExtra) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiChatOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.multiChatId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.mode = int32;
                }
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.modeExtra = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveMultiChatOpened parseFrom(byte[] bArr) {
        return (SCLiveMultiChatOpened) MessageNano.mergeFrom(new SCLiveMultiChatOpened(), bArr);
    }

    public static SCLiveMultiChatOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiChatOpened().mergeFrom(codedInputByteBufferNano);
    }
}
