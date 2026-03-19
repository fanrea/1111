package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveWishPointNotice extends MessageNano {
    private static volatile SCLiveWishPointNotice[] _emptyArray;
    public long currentCount;
    public long diffCount;
    public UserInfos.PicUrl[] displayPic;
    public long durationMillis;
    public int percent;
    public boolean wishDone;
    public String wishId;
    public String wishName;
    public String wishType;

    public static SCLiveWishPointNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveWishPointNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveWishPointNotice() {
        clear();
    }

    public final SCLiveWishPointNotice clear() {
        this.displayPic = UserInfos.PicUrl.emptyArray();
        this.wishName = "";
        this.wishType = "";
        this.durationMillis = 0L;
        this.diffCount = 0L;
        this.currentCount = 0L;
        this.wishDone = false;
        this.wishId = "";
        this.percent = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.PicUrl[] picUrlArr = this.displayPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.displayPic;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(1, picUrl);
                }
                i++;
            }
        }
        if (!this.wishName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.wishName);
        }
        if (!this.wishType.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.wishType);
        }
        long j = this.durationMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.diffCount;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.currentCount;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        boolean z = this.wishDone;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        if (!this.wishId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.wishId);
        }
        int i2 = this.percent;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.PicUrl[] picUrlArr = this.displayPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.displayPic;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                }
                i++;
            }
        }
        if (!this.wishName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.wishName);
        }
        if (!this.wishType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.wishType);
        }
        long j = this.durationMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.diffCount;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.currentCount;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        boolean z = this.wishDone;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        if (!this.wishId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.wishId);
        }
        int i2 = this.percent;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveWishPointNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                UserInfos.PicUrl[] picUrlArr = this.displayPic;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.displayPic, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.displayPic = picUrlArr2;
            } else if (tag == 18) {
                this.wishName = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.wishType = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.durationMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.diffCount = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                this.currentCount = codedInputByteBufferNano.readUInt64();
            } else if (tag == 56) {
                this.wishDone = codedInputByteBufferNano.readBool();
            } else if (tag == 66) {
                this.wishId = codedInputByteBufferNano.readString();
            } else if (tag != 72) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.percent = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveWishPointNotice parseFrom(byte[] bArr) {
        return (SCLiveWishPointNotice) MessageNano.mergeFrom(new SCLiveWishPointNotice(), bArr);
    }

    public static SCLiveWishPointNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveWishPointNotice().mergeFrom(codedInputByteBufferNano);
    }
}
