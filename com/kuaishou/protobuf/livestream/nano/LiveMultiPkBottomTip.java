package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkBottomTip extends MessageNano {
    private static volatile LiveMultiPkBottomTip[] _emptyArray;
    public long displayMs;
    public String displayText;

    public static LiveMultiPkBottomTip[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkBottomTip[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkBottomTip() {
        clear();
    }

    public final LiveMultiPkBottomTip clear() {
        this.displayText = "";
        this.displayMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.displayText.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.displayText);
        }
        long j = this.displayMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.displayText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.displayText);
        }
        long j = this.displayMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkBottomTip mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.displayText = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiPkBottomTip parseFrom(byte[] bArr) {
        return (LiveMultiPkBottomTip) MessageNano.mergeFrom(new LiveMultiPkBottomTip(), bArr);
    }

    public static LiveMultiPkBottomTip parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkBottomTip().mergeFrom(codedInputByteBufferNano);
    }
}
