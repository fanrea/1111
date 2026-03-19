package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveFrameSeiMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveFrameSeiBizType {
        public static final int LIVE_FRAME_SEI_BIZ_DUMP = 1;
        public static final int LIVE_FRAME_SEI_BIZ_UNKNOWN = 0;
    }

    public static final class LiveFrameSeiDumpInfo extends MessageNano {
        private static volatile LiveFrameSeiDumpInfo[] _emptyArray;
        public boolean isDump;
        public long ptsMs;

        public static LiveFrameSeiDumpInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFrameSeiDumpInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFrameSeiDumpInfo() {
            clear();
        }

        public final LiveFrameSeiDumpInfo clear() {
            this.isDump = false;
            this.ptsMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.isDump;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            long j = this.ptsMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.isDump;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            long j = this.ptsMs;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFrameSeiDumpInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.isDump = codedInputByteBufferNano.readBool();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.ptsMs = codedInputByteBufferNano.readInt64();
                }
            }
        }

        public static LiveFrameSeiDumpInfo parseFrom(byte[] bArr) {
            return (LiveFrameSeiDumpInfo) MessageNano.mergeFrom(new LiveFrameSeiDumpInfo(), bArr);
        }

        public static LiveFrameSeiDumpInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFrameSeiDumpInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveFrameSeiContent extends MessageNano {
        private static volatile LiveFrameSeiContent[] _emptyArray;
        public int bizType;
        public LiveFrameSeiDumpInfo dumpInfo;

        public static LiveFrameSeiContent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveFrameSeiContent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveFrameSeiContent() {
            clear();
        }

        public final LiveFrameSeiContent clear() {
            this.bizType = 0;
            this.dumpInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            LiveFrameSeiDumpInfo liveFrameSeiDumpInfo = this.dumpInfo;
            if (liveFrameSeiDumpInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, liveFrameSeiDumpInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            LiveFrameSeiDumpInfo liveFrameSeiDumpInfo = this.dumpInfo;
            return liveFrameSeiDumpInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, liveFrameSeiDumpInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveFrameSeiContent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.bizType = int32;
                    }
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.dumpInfo == null) {
                        this.dumpInfo = new LiveFrameSeiDumpInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.dumpInfo);
                }
            }
        }

        public static LiveFrameSeiContent parseFrom(byte[] bArr) {
            return (LiveFrameSeiContent) MessageNano.mergeFrom(new LiveFrameSeiContent(), bArr);
        }

        public static LiveFrameSeiContent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveFrameSeiContent().mergeFrom(codedInputByteBufferNano);
        }
    }
}
