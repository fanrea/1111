package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveGiftOutsideMessages {

    public static final class LiveGiftOutsideConfig extends MessageNano {
        private static volatile LiveGiftOutsideConfig[] _emptyArray;
        public int[] giftId;
        public String showContent;

        public static LiveGiftOutsideConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveGiftOutsideConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveGiftOutsideConfig() {
            clear();
        }

        public final LiveGiftOutsideConfig clear() {
            this.giftId = WireFormatNano.EMPTY_INT_ARRAY;
            this.showContent = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int[] iArr = this.giftId;
            if (iArr != null && iArr.length > 0) {
                int i = 0;
                while (true) {
                    int[] iArr2 = this.giftId;
                    if (i >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt32(1, iArr2[i]);
                    i++;
                }
            }
            if (!this.showContent.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.showContent);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int[] iArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            int[] iArr2 = this.giftId;
            if (iArr2 != null && iArr2.length > 0) {
                int i = 0;
                int iComputeUInt32SizeNoTag = 0;
                while (true) {
                    iArr = this.giftId;
                    if (i >= iArr.length) {
                        break;
                    }
                    iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i]);
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr.length * 1);
            }
            return !this.showContent.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.showContent) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveGiftOutsideConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    int[] iArr = this.giftId;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.giftId, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    this.giftId = iArr2;
                } else if (tag == 10) {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.giftId;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.giftId, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = codedInputByteBufferNano.readUInt32();
                        length2++;
                    }
                    this.giftId = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.showContent = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveGiftOutsideConfig parseFrom(byte[] bArr) {
            return (LiveGiftOutsideConfig) MessageNano.mergeFrom(new LiveGiftOutsideConfig(), bArr);
        }

        public static LiveGiftOutsideConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveGiftOutsideConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
