package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class YUVDump extends MessageNano {
    private static volatile YUVDump[] _emptyArray;
    public int cpuUsageUpper;
    public long dumpId;
    public long dumpIntervalMs;
    public int dumpTimes;
    public int memoryUsedUpper;

    public static YUVDump[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new YUVDump[0];
                }
            }
        }
        return _emptyArray;
    }

    public YUVDump() {
        clear();
    }

    public final YUVDump clear() {
        this.dumpId = 0L;
        this.dumpIntervalMs = 0L;
        this.dumpTimes = 0;
        this.cpuUsageUpper = 0;
        this.memoryUsedUpper = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.dumpId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.dumpIntervalMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        int i = this.dumpTimes;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        int i2 = this.cpuUsageUpper;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        int i3 = this.memoryUsedUpper;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.dumpId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.dumpIntervalMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        int i = this.dumpTimes;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        int i2 = this.cpuUsageUpper;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
        }
        int i3 = this.memoryUsedUpper;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final YUVDump mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.dumpId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.dumpIntervalMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.dumpTimes = codedInputByteBufferNano.readUInt32();
            } else if (tag == 32) {
                this.cpuUsageUpper = codedInputByteBufferNano.readUInt32();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.memoryUsedUpper = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static YUVDump parseFrom(byte[] bArr) {
        return (YUVDump) MessageNano.mergeFrom(new YUVDump(), bArr);
    }

    public static YUVDump parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new YUVDump().mergeFrom(codedInputByteBufferNano);
    }
}
