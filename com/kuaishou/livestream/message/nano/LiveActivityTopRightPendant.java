package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveActivityTopRightPendant {

    public static final class SCLiveActivityTopRightPendant extends MessageNano {
        private static volatile SCLiveActivityTopRightPendant[] _emptyArray;
        public String buttonText;
        public String clickUrl;
        public long endShowTime;
        public String logMessage;
        public int maxDailyEffectShowTimes;
        public String pendantId;
        public int pendantType;
        public UserInfos.PicUrl[] picUrlV2;
        public UserInfos.PicUrl[] picUrlWithoutText;
        public UserInfos.PicUrl[] picUrls;
        public boolean redDotRemind;

        public static SCLiveActivityTopRightPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveActivityTopRightPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveActivityTopRightPendant() {
            clear();
        }

        public final SCLiveActivityTopRightPendant clear() {
            this.pendantId = "";
            this.pendantType = 0;
            this.endShowTime = 0L;
            this.maxDailyEffectShowTimes = 0;
            this.clickUrl = "";
            this.logMessage = "";
            this.picUrls = UserInfos.PicUrl.emptyArray();
            this.picUrlV2 = UserInfos.PicUrl.emptyArray();
            this.redDotRemind = false;
            this.picUrlWithoutText = UserInfos.PicUrl.emptyArray();
            this.buttonText = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pendantId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pendantId);
            }
            int i = this.pendantType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            long j = this.endShowTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            int i2 = this.maxDailyEffectShowTimes;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            if (!this.clickUrl.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.clickUrl);
            }
            if (!this.logMessage.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.logMessage);
            }
            UserInfos.PicUrl[] picUrlArr = this.picUrls;
            int i3 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrls;
                    if (i4 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i4];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(8, picUrl);
                    }
                    i4++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.picUrlV2;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.picUrlV2;
                    if (i5 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i5];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(9, picUrl2);
                    }
                    i5++;
                }
            }
            boolean z = this.redDotRemind;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.picUrlWithoutText;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.picUrlWithoutText;
                    if (i3 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i3];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(11, picUrl3);
                    }
                    i3++;
                }
            }
            if (!this.buttonText.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.buttonText);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.pendantId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pendantId);
            }
            int i = this.pendantType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            long j = this.endShowTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            int i2 = this.maxDailyEffectShowTimes;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            if (!this.clickUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.clickUrl);
            }
            if (!this.logMessage.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.logMessage);
            }
            UserInfos.PicUrl[] picUrlArr = this.picUrls;
            int i3 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrls;
                    if (i4 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i4];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(8, picUrl);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.picUrlV2;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.picUrlV2;
                    if (i5 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i5];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(9, picUrl2);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            boolean z = this.redDotRemind;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.picUrlWithoutText;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.picUrlWithoutText;
                    if (i3 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i3];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, picUrl3);
                    }
                    i3++;
                }
            }
            return !this.buttonText.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.buttonText) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveActivityTopRightPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.pendantId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.pendantType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        this.endShowTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 32:
                        this.maxDailyEffectShowTimes = codedInputByteBufferNano.readUInt32();
                        break;
                    case 50:
                        this.clickUrl = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.logMessage = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
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
                        break;
                    case 74:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        UserInfos.PicUrl[] picUrlArr3 = this.picUrlV2;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.picUrlV2, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.picUrlV2 = picUrlArr4;
                        break;
                    case 80:
                        this.redDotRemind = codedInputByteBufferNano.readBool();
                        break;
                    case 90:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        UserInfos.PicUrl[] picUrlArr5 = this.picUrlWithoutText;
                        int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                        UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.picUrlWithoutText, 0, picUrlArr6, 0, length3);
                        }
                        while (length3 < picUrlArr6.length - 1) {
                            picUrlArr6[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        this.picUrlWithoutText = picUrlArr6;
                        break;
                    case 98:
                        this.buttonText = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveActivityTopRightPendant parseFrom(byte[] bArr) {
            return (SCLiveActivityTopRightPendant) MessageNano.mergeFrom(new SCLiveActivityTopRightPendant(), bArr);
        }

        public static SCLiveActivityTopRightPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveActivityTopRightPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveActivityTopRightPendantClose extends MessageNano {
        private static volatile SCLiveActivityTopRightPendantClose[] _emptyArray;
        public String pendantId;

        public static SCLiveActivityTopRightPendantClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveActivityTopRightPendantClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveActivityTopRightPendantClose() {
            clear();
        }

        public final SCLiveActivityTopRightPendantClose clear() {
            this.pendantId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pendantId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pendantId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.pendantId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.pendantId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveActivityTopRightPendantClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.pendantId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveActivityTopRightPendantClose parseFrom(byte[] bArr) {
            return (SCLiveActivityTopRightPendantClose) MessageNano.mergeFrom(new SCLiveActivityTopRightPendantClose(), bArr);
        }

        public static SCLiveActivityTopRightPendantClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveActivityTopRightPendantClose().mergeFrom(codedInputByteBufferNano);
        }
    }
}
