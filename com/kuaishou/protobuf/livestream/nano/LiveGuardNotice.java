package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGuardNotice extends MessageNano {
    private static volatile LiveGuardNotice[] _emptyArray;
    public UserInfos.PicUrl[] backgroundPict;
    public int bizValue;
    public UserInfos.PicUrl[] buttonPict;
    public String contentInCurRoom;
    public String contentInOtherRoom;
    public UserInfos.PicUrl[] leftIcon;
    public String liveStreamId;
    public int noticeType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface NoticeType {
        public static final int COVERED = 2;
        public static final int EXPIRED = 1;
        public static final int FAIL = 3;
        public static final int SUCCESS = 4;
        public static final int UNKNOWN_TYPE = 0;
    }

    public static LiveGuardNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGuardNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGuardNotice() {
        clear();
    }

    public final LiveGuardNotice clear() {
        this.noticeType = 0;
        this.contentInCurRoom = "";
        this.contentInOtherRoom = "";
        this.liveStreamId = "";
        this.buttonPict = UserInfos.PicUrl.emptyArray();
        this.leftIcon = UserInfos.PicUrl.emptyArray();
        this.backgroundPict = UserInfos.PicUrl.emptyArray();
        this.bizValue = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.noticeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.contentInCurRoom.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.contentInCurRoom);
        }
        if (!this.contentInOtherRoom.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.contentInOtherRoom);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.liveStreamId);
        }
        UserInfos.PicUrl[] picUrlArr = this.buttonPict;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.buttonPict;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(5, picUrl);
                }
                i3++;
            }
        }
        UserInfos.PicUrl[] picUrlArr3 = this.leftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.leftIcon;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(6, picUrl2);
                }
                i4++;
            }
        }
        UserInfos.PicUrl[] picUrlArr5 = this.backgroundPict;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.backgroundPict;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl3);
                }
                i2++;
            }
        }
        int i5 = this.bizValue;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.noticeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.contentInCurRoom.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.contentInCurRoom);
        }
        if (!this.contentInOtherRoom.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.contentInOtherRoom);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
        }
        UserInfos.PicUrl[] picUrlArr = this.buttonPict;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.buttonPict;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        UserInfos.PicUrl[] picUrlArr3 = this.leftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.leftIcon;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(6, picUrl2);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        UserInfos.PicUrl[] picUrlArr5 = this.backgroundPict;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.backgroundPict;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, picUrl3);
                }
                i2++;
            }
        }
        int i5 = this.bizValue;
        return i5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(8, i5) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGuardNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.noticeType = int32;
                }
            } else if (tag == 18) {
                this.contentInCurRoom = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.contentInOtherRoom = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                UserInfos.PicUrl[] picUrlArr = this.buttonPict;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.buttonPict, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.buttonPict = picUrlArr2;
            } else if (tag == 50) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                UserInfos.PicUrl[] picUrlArr3 = this.leftIcon;
                int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.leftIcon, 0, picUrlArr4, 0, length2);
                }
                while (length2 < picUrlArr4.length - 1) {
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr4[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                this.leftIcon = picUrlArr4;
            } else if (tag == 58) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                UserInfos.PicUrl[] picUrlArr5 = this.backgroundPict;
                int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.backgroundPict, 0, picUrlArr6, 0, length3);
                }
                while (length3 < picUrlArr6.length - 1) {
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                picUrlArr6[length3] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                this.backgroundPict = picUrlArr6;
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizValue = codedInputByteBufferNano.readInt32();
            }
        }
    }

    public static LiveGuardNotice parseFrom(byte[] bArr) {
        return (LiveGuardNotice) MessageNano.mergeFrom(new LiveGuardNotice(), bArr);
    }

    public static LiveGuardNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGuardNotice().mergeFrom(codedInputByteBufferNano);
    }
}
