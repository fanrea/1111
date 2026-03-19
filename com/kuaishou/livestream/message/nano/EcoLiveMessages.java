package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface EcoLiveMessages {

    public static final class SCEcoConsultCardNotice extends MessageNano {
        private static volatile SCEcoConsultCardNotice[] _emptyArray;
        public String backGroundColor;
        public int businessBizType;
        public long cardDepartureMillis;
        public long cardDurationMillis;
        public long cardEntranceMillis;
        public String iconCdnUrl;
        public String[] noticeText;

        public static SCEcoConsultCardNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCEcoConsultCardNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCEcoConsultCardNotice() {
            clear();
        }

        public final SCEcoConsultCardNotice clear() {
            this.noticeText = WireFormatNano.EMPTY_STRING_ARRAY;
            this.iconCdnUrl = "";
            this.backGroundColor = "";
            this.businessBizType = 0;
            this.cardEntranceMillis = 0L;
            this.cardDepartureMillis = 0L;
            this.cardDurationMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            String[] strArr = this.noticeText;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.noticeText;
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
            if (!this.iconCdnUrl.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.iconCdnUrl);
            }
            if (!this.backGroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.backGroundColor);
            }
            int i2 = this.businessBizType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            long j = this.cardEntranceMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            long j2 = this.cardDepartureMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            long j3 = this.cardDurationMillis;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String[] strArr = this.noticeText;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                int iComputeStringSizeNoTag = 0;
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.noticeText;
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
            if (!this.iconCdnUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.iconCdnUrl);
            }
            if (!this.backGroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.backGroundColor);
            }
            int i3 = this.businessBizType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
            }
            long j = this.cardEntranceMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
            }
            long j2 = this.cardDepartureMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            long j3 = this.cardDurationMillis;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCEcoConsultCardNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr = this.noticeText;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.noticeText, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.noticeText = strArr2;
                } else if (tag == 18) {
                    this.iconCdnUrl = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.backGroundColor = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.businessBizType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 40) {
                    this.cardEntranceMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    this.cardDepartureMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.cardDurationMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCEcoConsultCardNotice parseFrom(byte[] bArr) {
            return (SCEcoConsultCardNotice) MessageNano.mergeFrom(new SCEcoConsultCardNotice(), bArr);
        }

        public static SCEcoConsultCardNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCEcoConsultCardNotice().mergeFrom(codedInputByteBufferNano);
        }
    }
}
