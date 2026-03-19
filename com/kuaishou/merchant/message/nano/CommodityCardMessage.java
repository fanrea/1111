package com.kuaishou.merchant.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface CommodityCardMessage {

    public static final class CommodityCardChange extends MessageNano {
        private static volatile CommodityCardChange[] _emptyArray;
        public boolean cleanFrames;
        public String[] frame;
        public String itemId;

        public static CommodityCardChange[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommodityCardChange[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommodityCardChange() {
            clear();
        }

        public final CommodityCardChange clear() {
            this.itemId = "";
            this.frame = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cleanFrames = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            String[] strArr = this.frame;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.frame;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(2, str);
                    }
                    i++;
                }
            }
            boolean z = this.cleanFrames;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            String[] strArr = this.frame;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                int iComputeStringSizeNoTag = 0;
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.frame;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        i2++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
            }
            boolean z = this.cleanFrames;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommodityCardChange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    String[] strArr = this.frame;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.frame, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.frame = strArr2;
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.cleanFrames = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static CommodityCardChange parseFrom(byte[] bArr) {
            return (CommodityCardChange) MessageNano.mergeFrom(new CommodityCardChange(), bArr);
        }

        public static CommodityCardChange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommodityCardChange().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommodityCardComponentChange extends MessageNano {
        private static volatile CommodityCardComponentChange[] _emptyArray;

        public static CommodityCardComponentChange[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommodityCardComponentChange[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommodityCardComponentChange() {
            clear();
        }

        public final CommodityCardComponentChange clear() {
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommodityCardComponentChange mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            int tag;
            do {
                tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    break;
                }
            } while (WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag));
            return this;
        }

        public static CommodityCardComponentChange parseFrom(byte[] bArr) {
            return (CommodityCardComponentChange) MessageNano.mergeFrom(new CommodityCardComponentChange(), bArr);
        }

        public static CommodityCardComponentChange parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommodityCardComponentChange().mergeFrom(codedInputByteBufferNano);
        }
    }
}
