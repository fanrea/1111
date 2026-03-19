package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveStreamActivityMessages {

    public static final class SCActivityLiveInfo extends MessageNano {
        private static volatile SCActivityLiveInfo[] _emptyArray;
        public String accumulatedWatchCount;
        public String liteAccumulatedWatchCount;
        public String liveStreamId;

        public static SCActivityLiveInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCActivityLiveInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCActivityLiveInfo() {
            clear();
        }

        public final SCActivityLiveInfo clear() {
            this.liveStreamId = "";
            this.accumulatedWatchCount = "";
            this.liteAccumulatedWatchCount = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.accumulatedWatchCount.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.accumulatedWatchCount);
            }
            if (!this.liteAccumulatedWatchCount.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.liteAccumulatedWatchCount);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.accumulatedWatchCount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.accumulatedWatchCount);
            }
            return !this.liteAccumulatedWatchCount.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.liteAccumulatedWatchCount) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCActivityLiveInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.accumulatedWatchCount = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liteAccumulatedWatchCount = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCActivityLiveInfo parseFrom(byte[] bArr) {
            return (SCActivityLiveInfo) MessageNano.mergeFrom(new SCActivityLiveInfo(), bArr);
        }

        public static SCActivityLiveInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCActivityLiveInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
