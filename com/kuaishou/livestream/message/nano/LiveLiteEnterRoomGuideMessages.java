package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveLiteEnterRoomGuideMessages {

    public static final class SCLiveLiteEnterRoomGuideNotice extends MessageNano {
        private static volatile SCLiveLiteEnterRoomGuideNotice[] _emptyArray;
        public long maxShowDurationMs;
        public String subBizId;
        public String subBizType;

        public static SCLiveLiteEnterRoomGuideNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveLiteEnterRoomGuideNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveLiteEnterRoomGuideNotice() {
            clear();
        }

        public final SCLiveLiteEnterRoomGuideNotice clear() {
            this.subBizType = "";
            this.subBizId = "";
            this.maxShowDurationMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.subBizType.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.subBizType);
            }
            if (!this.subBizId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.subBizId);
            }
            long j = this.maxShowDurationMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.subBizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.subBizType);
            }
            if (!this.subBizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.subBizId);
            }
            long j = this.maxShowDurationMs;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveLiteEnterRoomGuideNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.subBizType = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.subBizId = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxShowDurationMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveLiteEnterRoomGuideNotice parseFrom(byte[] bArr) {
            return (SCLiveLiteEnterRoomGuideNotice) MessageNano.mergeFrom(new SCLiveLiteEnterRoomGuideNotice(), bArr);
        }

        public static SCLiveLiteEnterRoomGuideNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveLiteEnterRoomGuideNotice().mergeFrom(codedInputByteBufferNano);
        }
    }
}
