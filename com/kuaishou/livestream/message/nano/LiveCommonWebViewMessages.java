package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCommonWebViewMessages {

    public static final class SCLiveCommonWebViewDisplay extends MessageNano {
        private static volatile SCLiveCommonWebViewDisplay[] _emptyArray;
        public String link;
        public String liveStreamId;

        public static SCLiveCommonWebViewDisplay[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCommonWebViewDisplay[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCommonWebViewDisplay() {
            clear();
        }

        public final SCLiveCommonWebViewDisplay clear() {
            this.liveStreamId = "";
            this.link = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.link.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.link);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            return !this.link.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.link) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCommonWebViewDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.link = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveCommonWebViewDisplay parseFrom(byte[] bArr) {
            return (SCLiveCommonWebViewDisplay) MessageNano.mergeFrom(new SCLiveCommonWebViewDisplay(), bArr);
        }

        public static SCLiveCommonWebViewDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCommonWebViewDisplay().mergeFrom(codedInputByteBufferNano);
        }
    }
}
