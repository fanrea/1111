package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface SCLiveCny2024EffectiveTaskProgressOuter {

    public static final class SCLiveCny2024EffectiveTaskProgress extends MessageNano {
        private static volatile SCLiveCny2024EffectiveTaskProgress[] _emptyArray;
        public long taskId;

        public static SCLiveCny2024EffectiveTaskProgress[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024EffectiveTaskProgress[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024EffectiveTaskProgress() {
            clear();
        }

        public final SCLiveCny2024EffectiveTaskProgress clear() {
            this.taskId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.taskId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.taskId;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024EffectiveTaskProgress mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.taskId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveCny2024EffectiveTaskProgress parseFrom(byte[] bArr) {
            return (SCLiveCny2024EffectiveTaskProgress) MessageNano.mergeFrom(new SCLiveCny2024EffectiveTaskProgress(), bArr);
        }

        public static SCLiveCny2024EffectiveTaskProgress parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024EffectiveTaskProgress().mergeFrom(codedInputByteBufferNano);
        }
    }
}
