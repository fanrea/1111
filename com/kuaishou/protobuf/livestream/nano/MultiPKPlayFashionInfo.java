package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MultiPKPlayFashionInfo extends MessageNano {
    private static volatile MultiPKPlayFashionInfo[] _emptyArray;
    public byte[] data;
    public long endTimestamp;
    public long leftEndTimeMinDuration;
    public int playFashionType;
    public long startTimestamp;

    public static MultiPKPlayFashionInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MultiPKPlayFashionInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public MultiPKPlayFashionInfo() {
        clear();
    }

    public final MultiPKPlayFashionInfo clear() {
        this.startTimestamp = 0L;
        this.endTimestamp = 0L;
        this.playFashionType = 0;
        this.leftEndTimeMinDuration = 0L;
        this.data = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.startTimestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.endTimestamp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        int i = this.playFashionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        long j3 = this.leftEndTimeMinDuration;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        if (!Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(5, this.data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.startTimestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.endTimestamp;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        int i = this.playFashionType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        long j3 = this.leftEndTimeMinDuration;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        return !Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(5, this.data) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MultiPKPlayFashionInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.startTimestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.endTimestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.playFashionType = int32;
                }
            } else if (tag == 32) {
                this.leftEndTimeMinDuration = codedInputByteBufferNano.readUInt64();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.data = codedInputByteBufferNano.readBytes();
            }
        }
    }

    public static MultiPKPlayFashionInfo parseFrom(byte[] bArr) {
        return (MultiPKPlayFashionInfo) MessageNano.mergeFrom(new MultiPKPlayFashionInfo(), bArr);
    }

    public static MultiPKPlayFashionInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MultiPKPlayFashionInfo().mergeFrom(codedInputByteBufferNano);
    }
}
