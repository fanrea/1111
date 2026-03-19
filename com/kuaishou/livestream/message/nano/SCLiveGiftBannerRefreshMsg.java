package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftBannerRefreshMsg extends MessageNano {
    private static volatile SCLiveGiftBannerRefreshMsg[] _emptyArray;
    public String[] bannerId;
    public int giftId;

    public static SCLiveGiftBannerRefreshMsg[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftBannerRefreshMsg[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftBannerRefreshMsg() {
        clear();
    }

    public final SCLiveGiftBannerRefreshMsg clear() {
        this.giftId = 0;
        this.bannerId = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        String[] strArr = this.bannerId;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.bannerId;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        String[] strArr = this.bannerId;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int i2 = 0;
        int iComputeStringSizeNoTag = 0;
        int i3 = 0;
        while (true) {
            String[] strArr2 = this.bannerId;
            if (i2 >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            String str = strArr2[i2];
            if (str != null) {
                i3++;
                iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
            }
            i2++;
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftBannerRefreshMsg mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.giftId = codedInputByteBufferNano.readInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr = this.bannerId;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.bannerId, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.bannerId = strArr2;
            }
        }
    }

    public static SCLiveGiftBannerRefreshMsg parseFrom(byte[] bArr) {
        return (SCLiveGiftBannerRefreshMsg) MessageNano.mergeFrom(new SCLiveGiftBannerRefreshMsg(), bArr);
    }

    public static SCLiveGiftBannerRefreshMsg parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftBannerRefreshMsg().mergeFrom(codedInputByteBufferNano);
    }
}
