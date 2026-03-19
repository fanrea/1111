package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveTagClose extends MessageNano {
    private static volatile SCLiveTagClose[] _emptyArray;
    public int reason;
    public long tagId;

    public static SCLiveTagClose[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveTagClose[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveTagClose() {
        clear();
    }

    public final SCLiveTagClose clear() {
        this.tagId = 0L;
        this.reason = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.tagId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        int i = this.reason;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.tagId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        int i = this.reason;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveTagClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.tagId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.reason = int32;
                }
            }
        }
    }

    public static SCLiveTagClose parseFrom(byte[] bArr) {
        return (SCLiveTagClose) MessageNano.mergeFrom(new SCLiveTagClose(), bArr);
    }

    public static SCLiveTagClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveTagClose().mergeFrom(codedInputByteBufferNano);
    }
}
