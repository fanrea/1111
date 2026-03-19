package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveQuizSf2023Proto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveQuizSyncTypeSf2023 {
        public static final int COUNT_DOWN = 2;
        public static final int PUBLISH_ANSWER = 3;
        public static final int QUIZ_SF2023_UNKNOWN = 0;
        public static final int QUIZ_START = 1;
    }

    public static final class LiveQuizAacSyncSf2023 extends MessageNano {
        private static volatile LiveQuizAacSyncSf2023[] _emptyArray;
        public long apiDelayDurationMs;
        public long index;
        public String quizId;
        public int type;

        public static LiveQuizAacSyncSf2023[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveQuizAacSyncSf2023[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveQuizAacSyncSf2023() {
            clear();
        }

        public final LiveQuizAacSyncSf2023 clear() {
            this.quizId = "";
            this.index = 0L;
            this.type = 0;
            this.apiDelayDurationMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.quizId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.quizId);
            }
            long j = this.index;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            long j2 = this.apiDelayDurationMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.quizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.quizId);
            }
            long j = this.index;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            long j2 = this.apiDelayDurationMs;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveQuizAacSyncSf2023 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.quizId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.index = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.type = int32;
                    }
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.apiDelayDurationMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveQuizAacSyncSf2023 parseFrom(byte[] bArr) {
            return (LiveQuizAacSyncSf2023) MessageNano.mergeFrom(new LiveQuizAacSyncSf2023(), bArr);
        }

        public static LiveQuizAacSyncSf2023 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveQuizAacSyncSf2023().mergeFrom(codedInputByteBufferNano);
        }
    }
}
