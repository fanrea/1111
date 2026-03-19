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
public interface LiveActiveInfo {

    public static final class KwaiActiveInfo extends MessageNano {
        private static volatile KwaiActiveInfo[] _emptyArray;
        public String activityId;
        public String matchStage;
        public String matchType;
        public int status;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveMatchStatus {
            public static final int JOIN_IN = 2;
            public static final int NOT_JOIN = 1;
            public static final int OUT = 3;
            public static final int UNKONWN = 0;
        }

        public static KwaiActiveInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new KwaiActiveInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public KwaiActiveInfo() {
            clear();
        }

        public final KwaiActiveInfo clear() {
            this.status = 0;
            this.matchType = "";
            this.matchStage = "";
            this.activityId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.matchType.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.matchType);
            }
            if (!this.matchStage.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.matchStage);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.activityId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.matchType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.matchType);
            }
            if (!this.matchStage.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.matchStage);
            }
            return !this.activityId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.activityId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final KwaiActiveInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.status = int32;
                    }
                } else if (tag == 18) {
                    this.matchType = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.matchStage = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.activityId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static KwaiActiveInfo parseFrom(byte[] bArr) {
            return (KwaiActiveInfo) MessageNano.mergeFrom(new KwaiActiveInfo(), bArr);
        }

        public static KwaiActiveInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new KwaiActiveInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
