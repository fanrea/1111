package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveSticker extends MessageNano {
    private static volatile LiveSticker[] _emptyArray;
    public double bottomMarginScale;
    public String content;
    public String fontColor;
    public int fontSize;
    public double height;
    public long id;
    public double leftMarginScale;
    public int maxRow;
    public double rightMarginScale;
    public int stickerType;
    public double textViewLeftMargin;
    public double textViewTopMargin;
    public double topMarginScale;
    public UserInfos.PicUrl[] url;
    public double width;

    public static LiveSticker[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveSticker[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveSticker() {
        clear();
    }

    public final LiveSticker clear() {
        this.id = 0L;
        this.stickerType = 0;
        this.url = UserInfos.PicUrl.emptyArray();
        this.content = "";
        this.height = 0.0d;
        this.width = 0.0d;
        this.topMarginScale = 0.0d;
        this.leftMarginScale = 0.0d;
        this.textViewLeftMargin = 0.0d;
        this.textViewTopMargin = 0.0d;
        this.fontSize = 0;
        this.fontColor = "";
        this.maxRow = 0;
        this.rightMarginScale = 0.0d;
        this.bottomMarginScale = 0.0d;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.id;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        int i = this.stickerType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.url;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.url;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i2++;
            }
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.content);
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(5, this.height);
        }
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(6, this.width);
        }
        if (Double.doubleToLongBits(this.topMarginScale) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(7, this.topMarginScale);
        }
        if (Double.doubleToLongBits(this.leftMarginScale) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(8, this.leftMarginScale);
        }
        if (Double.doubleToLongBits(this.textViewLeftMargin) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(9, this.textViewLeftMargin);
        }
        if (Double.doubleToLongBits(this.textViewTopMargin) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(10, this.textViewTopMargin);
        }
        int i3 = this.fontSize;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i3);
        }
        if (!this.fontColor.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.fontColor);
        }
        int i4 = this.maxRow;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i4);
        }
        if (Double.doubleToLongBits(this.rightMarginScale) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(14, this.rightMarginScale);
        }
        if (Double.doubleToLongBits(this.bottomMarginScale) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(15, this.bottomMarginScale);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.id;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        int i = this.stickerType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.url;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.url;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i2++;
            }
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.content);
        }
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(5, this.height);
        }
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(6, this.width);
        }
        if (Double.doubleToLongBits(this.topMarginScale) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(7, this.topMarginScale);
        }
        if (Double.doubleToLongBits(this.leftMarginScale) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(8, this.leftMarginScale);
        }
        if (Double.doubleToLongBits(this.textViewLeftMargin) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(9, this.textViewLeftMargin);
        }
        if (Double.doubleToLongBits(this.textViewTopMargin) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(10, this.textViewTopMargin);
        }
        int i3 = this.fontSize;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i3);
        }
        if (!this.fontColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.fontColor);
        }
        int i4 = this.maxRow;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(13, i4);
        }
        if (Double.doubleToLongBits(this.rightMarginScale) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(14, this.rightMarginScale);
        }
        return Double.doubleToLongBits(this.bottomMarginScale) != Double.doubleToLongBits(0.0d) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(15, this.bottomMarginScale) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveSticker mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.id = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.stickerType = int32;
                        break;
                    }
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.url;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.url, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.url = picUrlArr2;
                    break;
                case 34:
                    this.content = codedInputByteBufferNano.readString();
                    break;
                case 41:
                    this.height = codedInputByteBufferNano.readDouble();
                    break;
                case 49:
                    this.width = codedInputByteBufferNano.readDouble();
                    break;
                case 57:
                    this.topMarginScale = codedInputByteBufferNano.readDouble();
                    break;
                case 65:
                    this.leftMarginScale = codedInputByteBufferNano.readDouble();
                    break;
                case 73:
                    this.textViewLeftMargin = codedInputByteBufferNano.readDouble();
                    break;
                case 81:
                    this.textViewTopMargin = codedInputByteBufferNano.readDouble();
                    break;
                case 88:
                    this.fontSize = codedInputByteBufferNano.readUInt32();
                    break;
                case 98:
                    this.fontColor = codedInputByteBufferNano.readString();
                    break;
                case 104:
                    this.maxRow = codedInputByteBufferNano.readUInt32();
                    break;
                case 113:
                    this.rightMarginScale = codedInputByteBufferNano.readDouble();
                    break;
                case 121:
                    this.bottomMarginScale = codedInputByteBufferNano.readDouble();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveSticker parseFrom(byte[] bArr) {
        return (LiveSticker) MessageNano.mergeFrom(new LiveSticker(), bArr);
    }

    public static LiveSticker parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveSticker().mergeFrom(codedInputByteBufferNano);
    }
}
