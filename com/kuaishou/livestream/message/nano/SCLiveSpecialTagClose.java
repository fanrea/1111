package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveSpecialTagClose extends MessageNano {
    private static volatile SCLiveSpecialTagClose[] _emptyArray;
    public long tagId;

    public static SCLiveSpecialTagClose[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveSpecialTagClose[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveSpecialTagClose() {
        clear();
    }

    public final SCLiveSpecialTagClose clear() {
        this.tagId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.tagId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.tagId;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveSpecialTagClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.tagId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveSpecialTagClose parseFrom(byte[] bArr) {
        return (SCLiveSpecialTagClose) MessageNano.mergeFrom(new SCLiveSpecialTagClose(), bArr);
    }

    public static SCLiveSpecialTagClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveSpecialTagClose().mergeFrom(codedInputByteBufferNano);
    }
}
