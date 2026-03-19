package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveStartSuperFansWishNotice extends MessageNano {
    private static volatile SCLiveStartSuperFansWishNotice[] _emptyArray;
    public UserInfos.PicUrl[] displayPic;
    public long durationMillis;

    public static SCLiveStartSuperFansWishNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveStartSuperFansWishNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveStartSuperFansWishNotice() {
        clear();
    }

    public final SCLiveStartSuperFansWishNotice clear() {
        this.displayPic = UserInfos.PicUrl.emptyArray();
        this.durationMillis = 0L;
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
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveStartSuperFansWishNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.durationMillis = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveStartSuperFansWishNotice parseFrom(byte[] bArr) {
        return (SCLiveStartSuperFansWishNotice) MessageNano.mergeFrom(new SCLiveStartSuperFansWishNotice(), bArr);
    }

    public static SCLiveStartSuperFansWishNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveStartSuperFansWishNotice().mergeFrom(codedInputByteBufferNano);
    }
}
