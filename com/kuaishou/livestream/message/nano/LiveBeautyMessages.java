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
public interface LiveBeautyMessages {

    public static final class SCLiveBeautyLabel extends MessageNano {
        private static volatile SCLiveBeautyLabel[] _emptyArray;
        public int beautyLabel;

        @Retention(RetentionPolicy.SOURCE)
        public @interface BeautyLabel {
            public static final int LIGHT_BEAUTY = 2;
            public static final int NO_BEAUTY = 1;
            public static final int UNKNOWN = 0;
            public static final int WITH_BEAUTY = 3;
        }

        public static SCLiveBeautyLabel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBeautyLabel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBeautyLabel() {
            clear();
        }

        public final SCLiveBeautyLabel clear() {
            this.beautyLabel = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.beautyLabel;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.beautyLabel;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBeautyLabel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.beautyLabel = int32;
                    }
                }
            }
        }

        public static SCLiveBeautyLabel parseFrom(byte[] bArr) {
            return (SCLiveBeautyLabel) MessageNano.mergeFrom(new SCLiveBeautyLabel(), bArr);
        }

        public static SCLiveBeautyLabel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBeautyLabel().mergeFrom(codedInputByteBufferNano);
        }
    }
}
