package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveHelpWishNotice extends MessageNano {
    private static volatile SCLiveHelpWishNotice[] _emptyArray;
    public String displayCurrentCount;
    public String displayExpectCount;
    public UserInfos.PicUrl[] displayPic;
    public long durationMillis;
    public String wishType;

    public static SCLiveHelpWishNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveHelpWishNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveHelpWishNotice() {
        clear();
    }

    public final SCLiveHelpWishNotice clear() {
        this.displayPic = UserInfos.PicUrl.emptyArray();
        this.durationMillis = 0L;
        this.displayExpectCount = "";
        this.displayCurrentCount = "";
        this.wishType = "";
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
        long j = this.durationMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.displayExpectCount.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.displayExpectCount);
        }
        if (!this.displayCurrentCount.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.displayCurrentCount);
        }
        if (!this.wishType.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.wishType);
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
        long j = this.durationMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.displayExpectCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayExpectCount);
        }
        if (!this.displayCurrentCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayCurrentCount);
        }
        return !this.wishType.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.wishType) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveHelpWishNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 16) {
                this.durationMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.displayExpectCount = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.displayCurrentCount = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.wishType = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveHelpWishNotice parseFrom(byte[] bArr) {
        return (SCLiveHelpWishNotice) MessageNano.mergeFrom(new SCLiveHelpWishNotice(), bArr);
    }

    public static SCLiveHelpWishNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveHelpWishNotice().mergeFrom(codedInputByteBufferNano);
    }
}
