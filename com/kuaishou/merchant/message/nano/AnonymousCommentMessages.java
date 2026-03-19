package com.kuaishou.merchant.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface AnonymousCommentMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowNameType {
        public static final int ANONYMOUS = 3;
        public static final int FIRST_WORLD = 1;
        public static final int LAST_WORLD = 2;
        public static final int UNKOWN = 0;
    }

    public static final class AnonymousCommentMessage extends MessageNano {
        private static volatile AnonymousCommentMessage[] _emptyArray;
        public boolean anonymous;
        public int showNameType;

        public static AnonymousCommentMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AnonymousCommentMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AnonymousCommentMessage() {
            clear();
        }

        public final AnonymousCommentMessage clear() {
            this.anonymous = false;
            this.showNameType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.anonymous;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            int i = this.showNameType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.anonymous;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            int i = this.showNameType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AnonymousCommentMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.anonymous = codedInputByteBufferNano.readBool();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.showNameType = int32;
                    }
                }
            }
        }

        public static AnonymousCommentMessage parseFrom(byte[] bArr) {
            return (AnonymousCommentMessage) MessageNano.mergeFrom(new AnonymousCommentMessage(), bArr);
        }

        public static AnonymousCommentMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AnonymousCommentMessage().mergeFrom(codedInputByteBufferNano);
        }
    }
}
