package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCny2024Program {

    public static final class SCLiveCny2024Program extends MessageNano {
        private static volatile SCLiveCny2024Program[] _emptyArray;
        public String data;

        public static SCLiveCny2024Program[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024Program[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024Program() {
            clear();
        }

        public final SCLiveCny2024Program clear() {
            this.data = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.data.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.data);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.data.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.data) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024Program mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.data = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveCny2024Program parseFrom(byte[] bArr) {
            return (SCLiveCny2024Program) MessageNano.mergeFrom(new SCLiveCny2024Program(), bArr);
        }

        public static SCLiveCny2024Program parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024Program().mergeFrom(codedInputByteBufferNano);
        }
    }
}
