package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCSandeagoOpened extends MessageNano {
    private static volatile SCSandeagoOpened[] _emptyArray;
    public String bubbleDesc;
    public long displayIntervalMillis;
    public UserInfos.PicUrl[] imageUrls;
    public String itemId;
    public String liveStreamId;
    public long maxDelayMillis;
    public String price;
    public long totalStock;

    public static SCSandeagoOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCSandeagoOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCSandeagoOpened() {
        clear();
    }

    public final SCSandeagoOpened clear() {
        this.liveStreamId = "";
        this.itemId = "";
        this.imageUrls = UserInfos.PicUrl.emptyArray();
        this.totalStock = 0L;
        this.displayIntervalMillis = 0L;
        this.maxDelayMillis = 0L;
        this.price = "";
        this.bubbleDesc = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.itemId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.itemId);
        }
        UserInfos.PicUrl[] picUrlArr = this.imageUrls;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.imageUrls;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i++;
            }
        }
        long j = this.totalStock;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.displayIntervalMillis;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.maxDelayMillis;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        if (!this.price.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.price);
        }
        if (!this.bubbleDesc.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.bubbleDesc);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.itemId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.itemId);
        }
        UserInfos.PicUrl[] picUrlArr = this.imageUrls;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.imageUrls;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i++;
            }
        }
        long j = this.totalStock;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.displayIntervalMillis;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.maxDelayMillis;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        if (!this.price.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.price);
        }
        return !this.bubbleDesc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.bubbleDesc) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCSandeagoOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.itemId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.imageUrls;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.imageUrls, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.imageUrls = picUrlArr2;
            } else if (tag == 32) {
                this.totalStock = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.displayIntervalMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                this.maxDelayMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 58) {
                this.price = codedInputByteBufferNano.readString();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bubbleDesc = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCSandeagoOpened parseFrom(byte[] bArr) {
        return (SCSandeagoOpened) MessageNano.mergeFrom(new SCSandeagoOpened(), bArr);
    }

    public static SCSandeagoOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCSandeagoOpened().mergeFrom(codedInputByteBufferNano);
    }
}
