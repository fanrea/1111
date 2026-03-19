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
public interface LiveTopUserV2 {

    public static final class SCLiveTopUserScoreEventToast extends MessageNano {
        private static volatile SCLiveTopUserScoreEventToast[] _emptyArray;
        public int actionType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface EventType {
            public static final int COMMENT = 2;
            public static final int DEFAULT = 0;
            public static final int WATCH_DURATION = 1;
        }

        public static SCLiveTopUserScoreEventToast[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveTopUserScoreEventToast[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveTopUserScoreEventToast() {
            clear();
        }

        public final SCLiveTopUserScoreEventToast clear() {
            this.actionType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.actionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.actionType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveTopUserScoreEventToast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.actionType = int32;
                    }
                }
            }
        }

        public static SCLiveTopUserScoreEventToast parseFrom(byte[] bArr) {
            return (SCLiveTopUserScoreEventToast) MessageNano.mergeFrom(new SCLiveTopUserScoreEventToast(), bArr);
        }

        public static SCLiveTopUserScoreEventToast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveTopUserScoreEventToast().mergeFrom(codedInputByteBufferNano);
        }
    }
}
