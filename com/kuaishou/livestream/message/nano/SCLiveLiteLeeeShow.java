package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveLiteLeeeShow extends MessageNano {
    private static volatile SCLiveLiteLeeeShow[] _emptyArray;
    public UserInfos.PicUrl[] authorInfoAreaIconUrl;
    public long endTime;
    public UserInfos.PicUrl[] iconUrl;
    public String leeeId;
    public int leeeType;
    public String routerUrl;
    public UserInfos.PicUrl[] senderHeadUrl;
    public String showText;

    public static SCLiveLiteLeeeShow[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveLiteLeeeShow[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveLiteLeeeShow() {
        clear();
    }

    public final SCLiveLiteLeeeShow clear() {
        this.leeeId = "";
        this.leeeType = 0;
        this.iconUrl = UserInfos.PicUrl.emptyArray();
        this.showText = "";
        this.routerUrl = "";
        this.endTime = 0L;
        this.senderHeadUrl = UserInfos.PicUrl.emptyArray();
        this.authorInfoAreaIconUrl = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.leeeId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.leeeId);
        }
        int i = this.leeeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrl;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i3++;
            }
        }
        if (!this.showText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.showText);
        }
        if (!this.routerUrl.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.routerUrl);
        }
        long j = this.endTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(6, j);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.senderHeadUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.senderHeadUrl;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl2);
                }
                i4++;
            }
        }
        UserInfos.PicUrl[] picUrlArr5 = this.authorInfoAreaIconUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.authorInfoAreaIconUrl;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(8, picUrl3);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.leeeId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.leeeId);
        }
        int i = this.leeeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrl;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.showText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.showText);
        }
        if (!this.routerUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.routerUrl);
        }
        long j = this.endTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.senderHeadUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.senderHeadUrl;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(7, picUrl2);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        UserInfos.PicUrl[] picUrlArr5 = this.authorInfoAreaIconUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.authorInfoAreaIconUrl;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, picUrl3);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveLiteLeeeShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.leeeId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.leeeType = codedInputByteBufferNano.readInt32();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.iconUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.iconUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.iconUrl = picUrlArr2;
            } else if (tag == 34) {
                this.showText = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.routerUrl = codedInputByteBufferNano.readString();
            } else if (tag == 48) {
                this.endTime = codedInputByteBufferNano.readInt64();
            } else if (tag == 58) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                UserInfos.PicUrl[] picUrlArr3 = this.senderHeadUrl;
                int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.senderHeadUrl, 0, picUrlArr4, 0, length2);
                }
                while (length2 < picUrlArr4.length - 1) {
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr4[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                this.senderHeadUrl = picUrlArr4;
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                UserInfos.PicUrl[] picUrlArr5 = this.authorInfoAreaIconUrl;
                int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.authorInfoAreaIconUrl, 0, picUrlArr6, 0, length3);
                }
                while (length3 < picUrlArr6.length - 1) {
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                picUrlArr6[length3] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                this.authorInfoAreaIconUrl = picUrlArr6;
            }
        }
    }

    public static SCLiveLiteLeeeShow parseFrom(byte[] bArr) {
        return (SCLiveLiteLeeeShow) MessageNano.mergeFrom(new SCLiveLiteLeeeShow(), bArr);
    }

    public static SCLiveLiteLeeeShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveLiteLeeeShow().mergeFrom(codedInputByteBufferNano);
    }
}
