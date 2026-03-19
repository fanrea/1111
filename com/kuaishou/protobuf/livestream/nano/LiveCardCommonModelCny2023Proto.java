package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCardCommonModelCny2023Proto {

    public static final class LiveCardPriorityCny2023 extends MessageNano {
        private static volatile LiveCardPriorityCny2023[] _emptyArray;
        public int priority;

        public static LiveCardPriorityCny2023[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCardPriorityCny2023[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCardPriorityCny2023() {
            clear();
        }

        public final LiveCardPriorityCny2023 clear() {
            this.priority = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.priority;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.priority;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCardPriorityCny2023 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.priority = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveCardPriorityCny2023 parseFrom(byte[] bArr) {
            return (LiveCardPriorityCny2023) MessageNano.mergeFrom(new LiveCardPriorityCny2023(), bArr);
        }

        public static LiveCardPriorityCny2023 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCardPriorityCny2023().mergeFrom(codedInputByteBufferNano);
        }
    }
}
