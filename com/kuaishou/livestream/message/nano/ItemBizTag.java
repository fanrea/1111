package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ItemBizTag extends MessageNano {
    private static volatile ItemBizTag[] _emptyArray;
    public UserInfos.PicUrl[] iconUrl;
    public String positionCode;
    public int scene;
    public String[] text;
    public String textColor;

    public static ItemBizTag[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ItemBizTag[0];
                }
            }
        }
        return _emptyArray;
    }

    public ItemBizTag() {
        clear();
    }

    public final ItemBizTag clear() {
        this.scene = 0;
        this.text = WireFormatNano.EMPTY_STRING_ARRAY;
        this.textColor = "";
        this.iconUrl = UserInfos.PicUrl.emptyArray();
        this.positionCode = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.scene;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        String[] strArr = this.text;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.text;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i3++;
            }
        }
        if (!this.textColor.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.textColor);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(4, picUrl);
                }
                i2++;
            }
        }
        if (!this.positionCode.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.positionCode);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.scene;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        String[] strArr = this.text;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.text;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i4++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
        }
        if (!this.textColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.textColor);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                }
                i2++;
            }
        }
        return !this.positionCode.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.positionCode) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ItemBizTag mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.scene = codedInputByteBufferNano.readInt32();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                String[] strArr = this.text;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.text, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.text = strArr2;
            } else if (tag == 26) {
                this.textColor = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserInfos.PicUrl[] picUrlArr = this.iconUrl;
                int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.iconUrl, 0, picUrlArr2, 0, length2);
                }
                while (length2 < picUrlArr2.length - 1) {
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr2[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                this.iconUrl = picUrlArr2;
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.positionCode = codedInputByteBufferNano.readString();
            }
        }
    }

    public static ItemBizTag parseFrom(byte[] bArr) {
        return (ItemBizTag) MessageNano.mergeFrom(new ItemBizTag(), bArr);
    }

    public static ItemBizTag parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ItemBizTag().mergeFrom(codedInputByteBufferNano);
    }
}
