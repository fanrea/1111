package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAllDayBvrpSf2023Proto {

    public static final class LiveAllDayBvrpSf2023 extends MessageNano {
        private static volatile LiveAllDayBvrpSf2023[] _emptyArray;
        public String encryptRoundsId;
        public long signalDeadlineTime;
        public long userId;
        public boolean videoReadyFlag;

        public static LiveAllDayBvrpSf2023[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAllDayBvrpSf2023[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAllDayBvrpSf2023() {
            clear();
        }

        public final LiveAllDayBvrpSf2023 clear() {
            this.videoReadyFlag = false;
            this.userId = 0L;
            this.encryptRoundsId = "";
            this.signalDeadlineTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.videoReadyFlag;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.encryptRoundsId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.encryptRoundsId);
            }
            long j2 = this.signalDeadlineTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.videoReadyFlag;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.encryptRoundsId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.encryptRoundsId);
            }
            long j2 = this.signalDeadlineTime;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAllDayBvrpSf2023 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.videoReadyFlag = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.encryptRoundsId = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.signalDeadlineTime = codedInputByteBufferNano.readInt64();
                }
            }
        }

        public static LiveAllDayBvrpSf2023 parseFrom(byte[] bArr) {
            return (LiveAllDayBvrpSf2023) MessageNano.mergeFrom(new LiveAllDayBvrpSf2023(), bArr);
        }

        public static LiveAllDayBvrpSf2023 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAllDayBvrpSf2023().mergeFrom(codedInputByteBufferNano);
        }
    }
}
