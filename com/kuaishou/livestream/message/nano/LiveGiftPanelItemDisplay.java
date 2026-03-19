package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftPanelItemDisplay extends MessageNano {
    private static volatile LiveGiftPanelItemDisplay[] _emptyArray;
    public String description;
    public long dynamicCornerCoolDownMillis;
    public long dynamicCornerExpireMillis;
    public long expireTimeMillis;
    public String name;
    public UserInfos.PicUrl[] picUrls;
    public UserInfos.PicUrl[] rightIconUrls;

    public static LiveGiftPanelItemDisplay[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftPanelItemDisplay[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftPanelItemDisplay() {
        clear();
    }

    public final LiveGiftPanelItemDisplay clear() {
        this.name = "";
        this.expireTimeMillis = 0L;
        this.description = "";
        this.picUrls = UserInfos.PicUrl.emptyArray();
        this.rightIconUrls = UserInfos.PicUrl.emptyArray();
        this.dynamicCornerCoolDownMillis = 0L;
        this.dynamicCornerExpireMillis = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.name);
        }
        long j = this.expireTimeMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.description.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.description);
        }
        UserInfos.PicUrl[] picUrlArr = this.picUrls;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.picUrls;
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
        UserInfos.PicUrl[] picUrlArr3 = this.rightIconUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.rightIconUrls;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(5, picUrl2);
                }
                i++;
            }
        }
        long j2 = this.dynamicCornerCoolDownMillis;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        long j3 = this.dynamicCornerExpireMillis;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.name.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.name);
        }
        long j = this.expireTimeMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.description.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.description);
        }
        UserInfos.PicUrl[] picUrlArr = this.picUrls;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.picUrls;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        UserInfos.PicUrl[] picUrlArr3 = this.rightIconUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.rightIconUrls;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl2);
                }
                i++;
            }
        }
        long j2 = this.dynamicCornerCoolDownMillis;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
        }
        long j3 = this.dynamicCornerExpireMillis;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftPanelItemDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.name = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.expireTimeMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.description = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserInfos.PicUrl[] picUrlArr = this.picUrls;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.picUrls, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.picUrls = picUrlArr2;
            } else if (tag == 42) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                UserInfos.PicUrl[] picUrlArr3 = this.rightIconUrls;
                int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.rightIconUrls, 0, picUrlArr4, 0, length2);
                }
                while (length2 < picUrlArr4.length - 1) {
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr4[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                this.rightIconUrls = picUrlArr4;
            } else if (tag == 48) {
                this.dynamicCornerCoolDownMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.dynamicCornerExpireMillis = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveGiftPanelItemDisplay parseFrom(byte[] bArr) {
        return (LiveGiftPanelItemDisplay) MessageNano.mergeFrom(new LiveGiftPanelItemDisplay(), bArr);
    }

    public static LiveGiftPanelItemDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftPanelItemDisplay().mergeFrom(codedInputByteBufferNano);
    }
}
