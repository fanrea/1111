package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKuaishouNightLotteryChanging extends MessageNano {
    private static volatile SCKuaishouNightLotteryChanging[] _emptyArray;
    public long maxDelayDeadlineTimeMs;
    public long maxDelayMs;
    public int maxRequestTimes;

    public static SCKuaishouNightLotteryChanging[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKuaishouNightLotteryChanging[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKuaishouNightLotteryChanging() {
        clear();
    }

    public final SCKuaishouNightLotteryChanging clear() {
        this.maxDelayDeadlineTimeMs = 0L;
        this.maxDelayMs = 0L;
        this.maxRequestTimes = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.maxDelayDeadlineTimeMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.maxDelayMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        int i = this.maxRequestTimes;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.maxDelayDeadlineTimeMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.maxDelayMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        int i = this.maxRequestTimes;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKuaishouNightLotteryChanging mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.maxDelayDeadlineTimeMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.maxDelayMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.maxRequestTimes = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCKuaishouNightLotteryChanging parseFrom(byte[] bArr) {
        return (SCKuaishouNightLotteryChanging) MessageNano.mergeFrom(new SCKuaishouNightLotteryChanging(), bArr);
    }

    public static SCKuaishouNightLotteryChanging parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKuaishouNightLotteryChanging().mergeFrom(codedInputByteBufferNano);
    }
}
