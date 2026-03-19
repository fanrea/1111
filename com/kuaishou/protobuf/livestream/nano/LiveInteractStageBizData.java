package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveInteractStageBizData {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveInteractStageLayoutConfigBizDataType {
        public static final int DUET_PK_BULLY_SCREEN = 1;
        public static final int UNKNOWN_STAGE_LAYOUT_CONFIG_BIZ_DATA_TYPE = 0;
    }

    public static final class LiveInteractStageLayoutConfigBizData extends MessageNano {
        private static volatile LiveInteractStageLayoutConfigBizData[] _emptyArray;
        public byte[] data;
        public int dataType;

        public static LiveInteractStageLayoutConfigBizData[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveInteractStageLayoutConfigBizData[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveInteractStageLayoutConfigBizData() {
            clear();
        }

        public final LiveInteractStageLayoutConfigBizData clear() {
            this.dataType = 0;
            this.data = WireFormatNano.EMPTY_BYTES;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.dataType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(2, this.data);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.dataType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            return !Arrays.equals(this.data, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.data) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveInteractStageLayoutConfigBizData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.dataType = int32;
                    }
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.data = codedInputByteBufferNano.readBytes();
                }
            }
        }

        public static LiveInteractStageLayoutConfigBizData parseFrom(byte[] bArr) {
            return (LiveInteractStageLayoutConfigBizData) MessageNano.mergeFrom(new LiveInteractStageLayoutConfigBizData(), bArr);
        }

        public static LiveInteractStageLayoutConfigBizData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveInteractStageLayoutConfigBizData().mergeFrom(codedInputByteBufferNano);
        }
    }
}
