package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveDistrictRankForTk {

    public static final class KdsInfo extends MessageNano {
        private static volatile KdsInfo[] _emptyArray;
        public String bundleId;
        public String data;

        public static KdsInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new KdsInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public KdsInfo() {
            clear();
        }

        public final KdsInfo clear() {
            this.bundleId = "";
            this.data = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bundleId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bundleId);
            }
            if (!this.data.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.data);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bundleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bundleId);
            }
            return !this.data.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.data) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final KdsInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.bundleId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.data = codedInputByteBufferNano.readString();
                }
            }
        }

        public static KdsInfo parseFrom(byte[] bArr) {
            return (KdsInfo) MessageNano.mergeFrom(new KdsInfo(), bArr);
        }

        public static KdsInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new KdsInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
