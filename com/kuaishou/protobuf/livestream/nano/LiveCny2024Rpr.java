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
public interface LiveCny2024Rpr {

    public static final class SCLiveCny2024FansAddRprSignal extends MessageNano {
        private static volatile SCLiveCny2024FansAddRprSignal[] _emptyArray;
        public String activityId;
        public long livestreamId;
        public long playId;
        public double shuffleSection;
        public int status;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RprStatus {
            public static final int CLOSE = 2;
            public static final int OPEN = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveCny2024FansAddRprSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024FansAddRprSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024FansAddRprSignal() {
            clear();
        }

        public final SCLiveCny2024FansAddRprSignal clear() {
            this.livestreamId = 0L;
            this.activityId = "";
            this.playId = 0L;
            this.status = 0;
            this.shuffleSection = 0.0d;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.livestreamId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            long j2 = this.playId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            if (Double.doubleToLongBits(this.shuffleSection) != Double.doubleToLongBits(0.0d)) {
                codedOutputByteBufferNano.writeDouble(5, this.shuffleSection);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.livestreamId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
            }
            long j2 = this.playId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
            }
            return Double.doubleToLongBits(this.shuffleSection) != Double.doubleToLongBits(0.0d) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(5, this.shuffleSection) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024FansAddRprSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.livestreamId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.playId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.status = int32;
                    }
                } else if (tag != 41) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.shuffleSection = codedInputByteBufferNano.readDouble();
                }
            }
        }

        public static SCLiveCny2024FansAddRprSignal parseFrom(byte[] bArr) {
            return (SCLiveCny2024FansAddRprSignal) MessageNano.mergeFrom(new SCLiveCny2024FansAddRprSignal(), bArr);
        }

        public static SCLiveCny2024FansAddRprSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024FansAddRprSignal().mergeFrom(codedInputByteBufferNano);
        }
    }
}
