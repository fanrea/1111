package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAuthorPauseMessages {

    public static final class SCLiveAuthorEnterBackground extends MessageNano {
        private static volatile SCLiveAuthorEnterBackground[] _emptyArray;
        public int pauseType;
        public long timestamp;

        public static SCLiveAuthorEnterBackground[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveAuthorEnterBackground[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveAuthorEnterBackground() {
            clear();
        }

        public final SCLiveAuthorEnterBackground clear() {
            this.timestamp = 0L;
            this.pauseType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.pauseType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.pauseType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveAuthorEnterBackground mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.pauseType = int32;
                    }
                }
            }
        }

        public static SCLiveAuthorEnterBackground parseFrom(byte[] bArr) {
            return (SCLiveAuthorEnterBackground) MessageNano.mergeFrom(new SCLiveAuthorEnterBackground(), bArr);
        }

        public static SCLiveAuthorEnterBackground parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveAuthorEnterBackground().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveAuthorEnterForeground extends MessageNano {
        private static volatile SCLiveAuthorEnterForeground[] _emptyArray;
        public long timestamp;

        public static SCLiveAuthorEnterForeground[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveAuthorEnterForeground[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveAuthorEnterForeground() {
            clear();
        }

        public final SCLiveAuthorEnterForeground clear() {
            this.timestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.timestamp;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveAuthorEnterForeground mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveAuthorEnterForeground parseFrom(byte[] bArr) {
            return (SCLiveAuthorEnterForeground) MessageNano.mergeFrom(new SCLiveAuthorEnterForeground(), bArr);
        }

        public static SCLiveAuthorEnterForeground parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveAuthorEnterForeground().mergeFrom(codedInputByteBufferNano);
        }
    }
}
