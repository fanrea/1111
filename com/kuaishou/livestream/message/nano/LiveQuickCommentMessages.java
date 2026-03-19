package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveQuickCommentMessages {

    public static final class SCLiveQuickCommentChanged extends MessageNano {
        private static volatile SCLiveQuickCommentChanged[] _emptyArray;
        public String[] comment;

        public static SCLiveQuickCommentChanged[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveQuickCommentChanged[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveQuickCommentChanged() {
            clear();
        }

        public final SCLiveQuickCommentChanged clear() {
            this.comment = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            String[] strArr = this.comment;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.comment;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(1, str);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String[] strArr = this.comment;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeStringSizeNoTag = 0;
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.comment;
                if (i >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
                }
                String str = strArr2[i];
                if (str != null) {
                    i2++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveQuickCommentChanged mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr = this.comment;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.comment, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.comment = strArr2;
                }
            }
        }

        public static SCLiveQuickCommentChanged parseFrom(byte[] bArr) {
            return (SCLiveQuickCommentChanged) MessageNano.mergeFrom(new SCLiveQuickCommentChanged(), bArr);
        }

        public static SCLiveQuickCommentChanged parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveQuickCommentChanged().mergeFrom(codedInputByteBufferNano);
        }
    }
}
