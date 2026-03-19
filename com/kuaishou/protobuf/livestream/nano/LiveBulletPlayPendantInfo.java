package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveBulletPlayPendantInfo extends MessageNano {
    private static volatile LiveBulletPlayPendantInfo[] _emptyArray;
    public UserInfos.PicUrl[] backgroundImgUrls;
    public UserInfos.PicUrl[] iconUrls;
    public String link;
    public String text;

    public static LiveBulletPlayPendantInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveBulletPlayPendantInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveBulletPlayPendantInfo() {
        clear();
    }

    public final LiveBulletPlayPendantInfo clear() {
        this.iconUrls = UserInfos.PicUrl.emptyArray();
        this.link = "";
        this.text = "";
        this.backgroundImgUrls = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.PicUrl[] picUrlArr = this.iconUrls;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrls;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(1, picUrl);
                }
                i2++;
            }
        }
        if (!this.link.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.link);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.text);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.backgroundImgUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.backgroundImgUrls;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, picUrl2);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.PicUrl[] picUrlArr = this.iconUrls;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrls;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.link.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.link);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.text);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.backgroundImgUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.backgroundImgUrls;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl2);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveBulletPlayPendantInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                UserInfos.PicUrl[] picUrlArr = this.iconUrls;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.iconUrls, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.iconUrls = picUrlArr2;
            } else if (tag == 18) {
                this.link = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserInfos.PicUrl[] picUrlArr3 = this.backgroundImgUrls;
                int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.backgroundImgUrls, 0, picUrlArr4, 0, length2);
                }
                while (length2 < picUrlArr4.length - 1) {
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr4[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                this.backgroundImgUrls = picUrlArr4;
            }
        }
    }

    public static LiveBulletPlayPendantInfo parseFrom(byte[] bArr) {
        return (LiveBulletPlayPendantInfo) MessageNano.mergeFrom(new LiveBulletPlayPendantInfo(), bArr);
    }

    public static LiveBulletPlayPendantInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveBulletPlayPendantInfo().mergeFrom(codedInputByteBufferNano);
    }
}
