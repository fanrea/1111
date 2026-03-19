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
public interface SeckillMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface SeckillCloseType {
        public static final int CLOSE_SECKILL_TYPE_UNKNOWN = 0;
        public static final int SECKILL_AUTHOR_CLOSE = 1;
        public static final int SECKILL_SELL_END = 2;
        public static final int SECKILL_TIME_UP = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SeckillSoldStatus {
        public static final int CAN_NOT_PURCHASE = 2;
        public static final int CAN_PURCHASE = 1;
        public static final int SOLD_STATUS_UNKNOWN = 0;
    }

    public static final class SeckillProgressMessage extends MessageNano {
        private static volatile SeckillProgressMessage[] _emptyArray;
        public String itemId;
        public MerchantUserPic[] merchantUserPic;
        public long originalStock;
        public long progressStock;
        public String seckillId;
        public int soldStatus;
        public long soldStock;
        public String tips;

        public static SeckillProgressMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SeckillProgressMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SeckillProgressMessage() {
            clear();
        }

        public final SeckillProgressMessage clear() {
            this.itemId = "";
            this.seckillId = "";
            this.originalStock = 0L;
            this.soldStock = 0L;
            this.soldStatus = 0;
            this.merchantUserPic = MerchantUserPic.emptyArray();
            this.tips = "";
            this.progressStock = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            if (!this.seckillId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.seckillId);
            }
            long j = this.originalStock;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.soldStock;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            int i = this.soldStatus;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(5, i);
            }
            MerchantUserPic[] merchantUserPicArr = this.merchantUserPic;
            if (merchantUserPicArr != null && merchantUserPicArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MerchantUserPic[] merchantUserPicArr2 = this.merchantUserPic;
                    if (i2 >= merchantUserPicArr2.length) {
                        break;
                    }
                    MerchantUserPic merchantUserPic = merchantUserPicArr2[i2];
                    if (merchantUserPic != null) {
                        codedOutputByteBufferNano.writeMessage(6, merchantUserPic);
                    }
                    i2++;
                }
            }
            if (!this.tips.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.tips);
            }
            long j3 = this.progressStock;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            if (!this.seckillId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.seckillId);
            }
            long j = this.originalStock;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.soldStock;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            int i = this.soldStatus;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
            }
            MerchantUserPic[] merchantUserPicArr = this.merchantUserPic;
            if (merchantUserPicArr != null && merchantUserPicArr.length > 0) {
                int i2 = 0;
                while (true) {
                    MerchantUserPic[] merchantUserPicArr2 = this.merchantUserPic;
                    if (i2 >= merchantUserPicArr2.length) {
                        break;
                    }
                    MerchantUserPic merchantUserPic = merchantUserPicArr2[i2];
                    if (merchantUserPic != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, merchantUserPic);
                    }
                    i2++;
                }
            }
            if (!this.tips.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.tips);
            }
            long j3 = this.progressStock;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SeckillProgressMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.seckillId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.originalStock = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.soldStock = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.soldStatus = int32;
                    }
                } else if (tag == 50) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    MerchantUserPic[] merchantUserPicArr = this.merchantUserPic;
                    int length = merchantUserPicArr == null ? 0 : merchantUserPicArr.length;
                    MerchantUserPic[] merchantUserPicArr2 = new MerchantUserPic[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.merchantUserPic, 0, merchantUserPicArr2, 0, length);
                    }
                    while (length < merchantUserPicArr2.length - 1) {
                        merchantUserPicArr2[length] = new MerchantUserPic();
                        codedInputByteBufferNano.readMessage(merchantUserPicArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    merchantUserPicArr2[length] = new MerchantUserPic();
                    codedInputByteBufferNano.readMessage(merchantUserPicArr2[length]);
                    this.merchantUserPic = merchantUserPicArr2;
                } else if (tag == 58) {
                    this.tips = codedInputByteBufferNano.readString();
                } else if (tag != 64) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.progressStock = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SeckillProgressMessage parseFrom(byte[] bArr) {
            return (SeckillProgressMessage) MessageNano.mergeFrom(new SeckillProgressMessage(), bArr);
        }

        public static SeckillProgressMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SeckillProgressMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SeckillCloseMessage extends MessageNano {
        private static volatile SeckillCloseMessage[] _emptyArray;
        public int closeType;
        public String itemId;
        public String seckillId;

        public static SeckillCloseMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SeckillCloseMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SeckillCloseMessage() {
            clear();
        }

        public final SeckillCloseMessage clear() {
            this.itemId = "";
            this.seckillId = "";
            this.closeType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemId);
            }
            if (!this.seckillId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.seckillId);
            }
            int i = this.closeType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
            }
            if (!this.seckillId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.seckillId);
            }
            int i = this.closeType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SeckillCloseMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.seckillId = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.closeType = int32;
                    }
                }
            }
        }

        public static SeckillCloseMessage parseFrom(byte[] bArr) {
            return (SeckillCloseMessage) MessageNano.mergeFrom(new SeckillCloseMessage(), bArr);
        }

        public static SeckillCloseMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SeckillCloseMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantUserPic extends MessageNano {
        private static volatile MerchantUserPic[] _emptyArray;
        public MerchantPicCdnUrl[] picUrl;

        public static MerchantUserPic[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantUserPic[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantUserPic() {
            clear();
        }

        public final MerchantUserPic clear() {
            this.picUrl = MerchantPicCdnUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            MerchantPicCdnUrl[] merchantPicCdnUrlArr = this.picUrl;
            if (merchantPicCdnUrlArr != null && merchantPicCdnUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    MerchantPicCdnUrl[] merchantPicCdnUrlArr2 = this.picUrl;
                    if (i >= merchantPicCdnUrlArr2.length) {
                        break;
                    }
                    MerchantPicCdnUrl merchantPicCdnUrl = merchantPicCdnUrlArr2[i];
                    if (merchantPicCdnUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, merchantPicCdnUrl);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            MerchantPicCdnUrl[] merchantPicCdnUrlArr = this.picUrl;
            if (merchantPicCdnUrlArr != null && merchantPicCdnUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    MerchantPicCdnUrl[] merchantPicCdnUrlArr2 = this.picUrl;
                    if (i >= merchantPicCdnUrlArr2.length) {
                        break;
                    }
                    MerchantPicCdnUrl merchantPicCdnUrl = merchantPicCdnUrlArr2[i];
                    if (merchantPicCdnUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, merchantPicCdnUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantUserPic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    MerchantPicCdnUrl[] merchantPicCdnUrlArr = this.picUrl;
                    int length = merchantPicCdnUrlArr == null ? 0 : merchantPicCdnUrlArr.length;
                    MerchantPicCdnUrl[] merchantPicCdnUrlArr2 = new MerchantPicCdnUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.picUrl, 0, merchantPicCdnUrlArr2, 0, length);
                    }
                    while (length < merchantPicCdnUrlArr2.length - 1) {
                        merchantPicCdnUrlArr2[length] = new MerchantPicCdnUrl();
                        codedInputByteBufferNano.readMessage(merchantPicCdnUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    merchantPicCdnUrlArr2[length] = new MerchantPicCdnUrl();
                    codedInputByteBufferNano.readMessage(merchantPicCdnUrlArr2[length]);
                    this.picUrl = merchantPicCdnUrlArr2;
                }
            }
        }

        public static MerchantUserPic parseFrom(byte[] bArr) {
            return (MerchantUserPic) MessageNano.mergeFrom(new MerchantUserPic(), bArr);
        }

        public static MerchantUserPic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantUserPic().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MerchantPicCdnUrl extends MessageNano {
        private static volatile MerchantPicCdnUrl[] _emptyArray;
        public String cdn;
        public String url;

        public static MerchantPicCdnUrl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MerchantPicCdnUrl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MerchantPicCdnUrl() {
            clear();
        }

        public final MerchantPicCdnUrl clear() {
            this.cdn = "";
            this.url = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.cdn.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.cdn);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.url);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.cdn.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
            }
            return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.url) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MerchantPicCdnUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.cdn = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.url = codedInputByteBufferNano.readString();
                }
            }
        }

        public static MerchantPicCdnUrl parseFrom(byte[] bArr) {
            return (MerchantPicCdnUrl) MessageNano.mergeFrom(new MerchantPicCdnUrl(), bArr);
        }

        public static MerchantPicCdnUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MerchantPicCdnUrl().mergeFrom(codedInputByteBufferNano);
        }
    }
}
