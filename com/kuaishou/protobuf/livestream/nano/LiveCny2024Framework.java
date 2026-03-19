package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCny2024Framework {

    public static final class SCLiveCny2024ReplaceSignal extends MessageNano {
        private static volatile SCLiveCny2024ReplaceSignal[] _emptyArray;
        public long deadlineTimestamp;
        public String replaceLiveStreamId;
        public String toast;

        public static SCLiveCny2024ReplaceSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024ReplaceSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024ReplaceSignal() {
            clear();
        }

        public final SCLiveCny2024ReplaceSignal clear() {
            this.replaceLiveStreamId = "";
            this.deadlineTimestamp = 0L;
            this.toast = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.replaceLiveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.replaceLiveStreamId);
            }
            long j = this.deadlineTimestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            if (!this.toast.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.toast);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.replaceLiveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.replaceLiveStreamId);
            }
            long j = this.deadlineTimestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            return !this.toast.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.toast) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024ReplaceSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.replaceLiveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.deadlineTimestamp = codedInputByteBufferNano.readInt64();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.toast = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveCny2024ReplaceSignal parseFrom(byte[] bArr) {
            return (SCLiveCny2024ReplaceSignal) MessageNano.mergeFrom(new SCLiveCny2024ReplaceSignal(), bArr);
        }

        public static SCLiveCny2024ReplaceSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024ReplaceSignal().mergeFrom(codedInputByteBufferNano);
        }
    }
}
