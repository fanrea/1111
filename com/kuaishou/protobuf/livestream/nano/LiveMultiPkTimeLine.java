package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkTimeLine extends MessageNano {
    private static volatile LiveMultiPkTimeLine[] _emptyArray;
    public long penaltyDeadline;
    public long prePenaltyDeadline;
    public long serverTime;
    public long startTime;
    public long voteDeadline;
    public long voteEndWaitDeadline;

    public static LiveMultiPkTimeLine[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkTimeLine[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkTimeLine() {
        clear();
    }

    public final LiveMultiPkTimeLine clear() {
        this.serverTime = 0L;
        this.startTime = 0L;
        this.voteDeadline = 0L;
        this.voteEndWaitDeadline = 0L;
        this.prePenaltyDeadline = 0L;
        this.penaltyDeadline = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.serverTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.startTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.voteDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j4 = this.voteEndWaitDeadline;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j4);
        }
        long j5 = this.prePenaltyDeadline;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j5);
        }
        long j6 = this.penaltyDeadline;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j6);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.serverTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.startTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.voteDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j4 = this.voteEndWaitDeadline;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j4);
        }
        long j5 = this.prePenaltyDeadline;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j5);
        }
        long j6 = this.penaltyDeadline;
        return j6 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j6) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkTimeLine mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.serverTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.voteDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 32) {
                this.voteEndWaitDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.prePenaltyDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.penaltyDeadline = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiPkTimeLine parseFrom(byte[] bArr) {
        return (LiveMultiPkTimeLine) MessageNano.mergeFrom(new LiveMultiPkTimeLine(), bArr);
    }

    public static LiveMultiPkTimeLine parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkTimeLine().mergeFrom(codedInputByteBufferNano);
    }
}
