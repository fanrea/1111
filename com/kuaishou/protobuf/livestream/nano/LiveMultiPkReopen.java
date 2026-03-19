package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkReopen extends MessageNano {
    private static volatile LiveMultiPkReopen[] _emptyArray;
    public boolean enableReopenAtEndInAdvance;
    public boolean enableReopenAtPenalty;
    public boolean enableReopenAtPenaltyAtPkingPannel;
    public boolean enableReopenAtVoteAtPkingPannel;
    public long reopenDisplayBeforeEndDuration;
    public long reopenDisplayBeforeEndDurationAtPkingPannel;
    public long reopenRespondTimeoutMillis;

    public static LiveMultiPkReopen[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkReopen[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkReopen() {
        clear();
    }

    public final LiveMultiPkReopen clear() {
        this.enableReopenAtPenalty = false;
        this.reopenDisplayBeforeEndDuration = 0L;
        this.enableReopenAtEndInAdvance = false;
        this.reopenRespondTimeoutMillis = 0L;
        this.enableReopenAtVoteAtPkingPannel = false;
        this.reopenDisplayBeforeEndDurationAtPkingPannel = 0L;
        this.enableReopenAtPenaltyAtPkingPannel = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.enableReopenAtPenalty;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.reopenDisplayBeforeEndDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        boolean z2 = this.enableReopenAtEndInAdvance;
        if (z2) {
            codedOutputByteBufferNano.writeBool(3, z2);
        }
        long j2 = this.reopenRespondTimeoutMillis;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        boolean z3 = this.enableReopenAtVoteAtPkingPannel;
        if (z3) {
            codedOutputByteBufferNano.writeBool(5, z3);
        }
        long j3 = this.reopenDisplayBeforeEndDurationAtPkingPannel;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        boolean z4 = this.enableReopenAtPenaltyAtPkingPannel;
        if (z4) {
            codedOutputByteBufferNano.writeBool(7, z4);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.enableReopenAtPenalty;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.reopenDisplayBeforeEndDuration;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        boolean z2 = this.enableReopenAtEndInAdvance;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z2);
        }
        long j2 = this.reopenRespondTimeoutMillis;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        boolean z3 = this.enableReopenAtVoteAtPkingPannel;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z3);
        }
        long j3 = this.reopenDisplayBeforeEndDurationAtPkingPannel;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        boolean z4 = this.enableReopenAtPenaltyAtPkingPannel;
        return z4 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z4) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkReopen mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.enableReopenAtPenalty = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.reopenDisplayBeforeEndDuration = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.enableReopenAtEndInAdvance = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                this.reopenRespondTimeoutMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.enableReopenAtVoteAtPkingPannel = codedInputByteBufferNano.readBool();
            } else if (tag == 48) {
                this.reopenDisplayBeforeEndDurationAtPkingPannel = codedInputByteBufferNano.readUInt64();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enableReopenAtPenaltyAtPkingPannel = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveMultiPkReopen parseFrom(byte[] bArr) {
        return (LiveMultiPkReopen) MessageNano.mergeFrom(new LiveMultiPkReopen(), bArr);
    }

    public static LiveMultiPkReopen parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkReopen().mergeFrom(codedInputByteBufferNano);
    }
}
