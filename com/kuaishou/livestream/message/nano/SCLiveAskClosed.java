package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAskClosed extends MessageNano {
    private static volatile SCLiveAskClosed[] _emptyArray;
    public String askId;

    public static SCLiveAskClosed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAskClosed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAskClosed() {
        clear();
    }

    public final SCLiveAskClosed clear() {
        this.askId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.askId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.askId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.askId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.askId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAskClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.askId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveAskClosed parseFrom(byte[] bArr) {
        return (SCLiveAskClosed) MessageNano.mergeFrom(new SCLiveAskClosed(), bArr);
    }

    public static SCLiveAskClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAskClosed().mergeFrom(codedInputByteBufferNano);
    }
}
