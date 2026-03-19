package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveEncourageTaskStageInfo extends MessageNano {
    private static volatile LiveEncourageTaskStageInfo[] _emptyArray;
    public long completeConditionAmount;
    public long completedAmount;
    public int stageIndex;
    public int status;

    public static LiveEncourageTaskStageInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveEncourageTaskStageInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveEncourageTaskStageInfo() {
        clear();
    }

    public final LiveEncourageTaskStageInfo clear() {
        this.stageIndex = 0;
        this.completeConditionAmount = 0L;
        this.completedAmount = 0L;
        this.status = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.stageIndex;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.completeConditionAmount;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.completedAmount;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        int i2 = this.status;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.stageIndex;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.completeConditionAmount;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.completedAmount;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        int i2 = this.status;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveEncourageTaskStageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.stageIndex = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.completeConditionAmount = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.completedAmount = codedInputByteBufferNano.readUInt64();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.status = int32;
                }
            }
        }
    }

    public static LiveEncourageTaskStageInfo parseFrom(byte[] bArr) {
        return (LiveEncourageTaskStageInfo) MessageNano.mergeFrom(new LiveEncourageTaskStageInfo(), bArr);
    }

    public static LiveEncourageTaskStageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveEncourageTaskStageInfo().mergeFrom(codedInputByteBufferNano);
    }
}
