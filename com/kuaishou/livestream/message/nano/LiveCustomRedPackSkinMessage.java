package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCustomRedPackSkinMessage {

    public static final class CustomRedPackSkinButtonInfo extends MessageNano {
        private static volatile CustomRedPackSkinButtonInfo[] _emptyArray;
        public UserInfos.PicUrl[] buttonBgPict;
        public String textColor;

        public static CustomRedPackSkinButtonInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomRedPackSkinButtonInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CustomRedPackSkinButtonInfo() {
            clear();
        }

        public final CustomRedPackSkinButtonInfo clear() {
            this.buttonBgPict = UserInfos.PicUrl.emptyArray();
            this.textColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.buttonBgPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.buttonBgPict;
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
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.textColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.buttonBgPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.buttonBgPict;
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
            return !this.textColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.textColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomRedPackSkinButtonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.buttonBgPict;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.buttonBgPict, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.buttonBgPict = picUrlArr2;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.textColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CustomRedPackSkinButtonInfo parseFrom(byte[] bArr) {
            return (CustomRedPackSkinButtonInfo) MessageNano.mergeFrom(new CustomRedPackSkinButtonInfo(), bArr);
        }

        public static CustomRedPackSkinButtonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomRedPackSkinButtonInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CustomRedPackSkinOpenButtonInfo extends MessageNano {
        private static volatile CustomRedPackSkinOpenButtonInfo[] _emptyArray;
        public UserInfos.PicUrl[] buttonBgPict;
        public String[] buttonColor;
        public UserInfos.PicUrl[] buttonOpenAnimationPict;
        public UserInfos.PicUrl[] buttonOpenPict;
        public String buttonProgressBgColor;
        public String buttonProgressColor;

        public static CustomRedPackSkinOpenButtonInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomRedPackSkinOpenButtonInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CustomRedPackSkinOpenButtonInfo() {
            clear();
        }

        public final CustomRedPackSkinOpenButtonInfo clear() {
            this.buttonColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.buttonProgressColor = "";
            this.buttonProgressBgColor = "";
            this.buttonBgPict = UserInfos.PicUrl.emptyArray();
            this.buttonOpenPict = UserInfos.PicUrl.emptyArray();
            this.buttonOpenAnimationPict = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            String[] strArr = this.buttonColor;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.buttonColor;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(1, str);
                    }
                    i2++;
                }
            }
            if (!this.buttonProgressColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.buttonProgressColor);
            }
            if (!this.buttonProgressBgColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.buttonProgressBgColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.buttonBgPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.buttonBgPict;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.buttonOpenPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.buttonOpenPict;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl2);
                    }
                    i4++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.buttonOpenAnimationPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.buttonOpenAnimationPict;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl3);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String[] strArr = this.buttonColor;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.buttonColor;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            if (!this.buttonProgressColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.buttonProgressColor);
            }
            if (!this.buttonProgressBgColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.buttonProgressBgColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.buttonBgPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.buttonBgPict;
                    if (i4 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i4];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.buttonOpenPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.buttonOpenPict;
                    if (i5 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i5];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(5, picUrl2);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr5 = this.buttonOpenAnimationPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.buttonOpenAnimationPict;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl3);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomRedPackSkinOpenButtonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr = this.buttonColor;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.buttonColor, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.buttonColor = strArr2;
                } else if (tag == 18) {
                    this.buttonProgressColor = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.buttonProgressBgColor = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr = this.buttonBgPict;
                    int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.buttonBgPict, 0, picUrlArr2, 0, length2);
                    }
                    while (length2 < picUrlArr2.length - 1) {
                        picUrlArr2[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    this.buttonBgPict = picUrlArr2;
                } else if (tag == 42) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr3 = this.buttonOpenPict;
                    int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.buttonOpenPict, 0, picUrlArr4, 0, length3);
                    }
                    while (length3 < picUrlArr4.length - 1) {
                        picUrlArr4[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr4[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                    this.buttonOpenPict = picUrlArr4;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    UserInfos.PicUrl[] picUrlArr5 = this.buttonOpenAnimationPict;
                    int length4 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.buttonOpenAnimationPict, 0, picUrlArr6, 0, length4);
                    }
                    while (length4 < picUrlArr6.length - 1) {
                        picUrlArr6[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr6[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                    this.buttonOpenAnimationPict = picUrlArr6;
                }
            }
        }

        public static CustomRedPackSkinOpenButtonInfo parseFrom(byte[] bArr) {
            return (CustomRedPackSkinOpenButtonInfo) MessageNano.mergeFrom(new CustomRedPackSkinOpenButtonInfo(), bArr);
        }

        public static CustomRedPackSkinOpenButtonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomRedPackSkinOpenButtonInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CustomRedPackSkinBasicInnerInfo extends MessageNano {
        private static volatile CustomRedPackSkinBasicInnerInfo[] _emptyArray;
        public UserInfos.PicUrl[] innerBgPict;

        public static CustomRedPackSkinBasicInnerInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomRedPackSkinBasicInnerInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CustomRedPackSkinBasicInnerInfo() {
            clear();
        }

        public final CustomRedPackSkinBasicInnerInfo clear() {
            this.innerBgPict = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.innerBgPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.innerBgPict;
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
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.innerBgPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.innerBgPict;
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
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomRedPackSkinBasicInnerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.innerBgPict;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.innerBgPict, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.innerBgPict = picUrlArr2;
                }
            }
        }

        public static CustomRedPackSkinBasicInnerInfo parseFrom(byte[] bArr) {
            return (CustomRedPackSkinBasicInnerInfo) MessageNano.mergeFrom(new CustomRedPackSkinBasicInnerInfo(), bArr);
        }

        public static CustomRedPackSkinBasicInnerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomRedPackSkinBasicInnerInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CustomRedPackSkinInnerInfo extends MessageNano {
        private static volatile CustomRedPackSkinInnerInfo[] _emptyArray;
        public UserInfos.PicUrl[] luckyResultBgPict;
        public UserInfos.PicUrl[] resultInnerBgPict;

        public static CustomRedPackSkinInnerInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomRedPackSkinInnerInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CustomRedPackSkinInnerInfo() {
            clear();
        }

        public final CustomRedPackSkinInnerInfo clear() {
            this.resultInnerBgPict = UserInfos.PicUrl.emptyArray();
            this.luckyResultBgPict = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.resultInnerBgPict;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.resultInnerBgPict;
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
            UserInfos.PicUrl[] picUrlArr3 = this.luckyResultBgPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.luckyResultBgPict;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl2);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.resultInnerBgPict;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.resultInnerBgPict;
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
            UserInfos.PicUrl[] picUrlArr3 = this.luckyResultBgPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.luckyResultBgPict;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl2);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomRedPackSkinInnerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.resultInnerBgPict;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.resultInnerBgPict, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.resultInnerBgPict = picUrlArr2;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr3 = this.luckyResultBgPict;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.luckyResultBgPict, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.luckyResultBgPict = picUrlArr4;
                }
            }
        }

        public static CustomRedPackSkinInnerInfo parseFrom(byte[] bArr) {
            return (CustomRedPackSkinInnerInfo) MessageNano.mergeFrom(new CustomRedPackSkinInnerInfo(), bArr);
        }

        public static CustomRedPackSkinInnerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomRedPackSkinInnerInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CustomRedPackSkinCommonInfo extends MessageNano {
        private static volatile CustomRedPackSkinCommonInfo[] _emptyArray;
        public UserInfos.PicUrl[] ambientBottomPict;
        public UserInfos.PicUrl[] ambientTopPict;
        public UserInfos.PicUrl[] bgPict;
        public UserInfos.PicUrl[] coverBottomPict;
        public UserInfos.PicUrl[] coverTopPict;

        public static CustomRedPackSkinCommonInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomRedPackSkinCommonInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CustomRedPackSkinCommonInfo() {
            clear();
        }

        public final CustomRedPackSkinCommonInfo clear() {
            this.coverTopPict = UserInfos.PicUrl.emptyArray();
            this.coverBottomPict = UserInfos.PicUrl.emptyArray();
            this.bgPict = UserInfos.PicUrl.emptyArray();
            this.ambientTopPict = UserInfos.PicUrl.emptyArray();
            this.ambientBottomPict = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.coverTopPict;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.coverTopPict;
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
            UserInfos.PicUrl[] picUrlArr3 = this.coverBottomPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.coverBottomPict;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl2);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.bgPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.bgPict;
                    if (i4 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i4];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl3);
                    }
                    i4++;
                }
            }
            UserInfos.PicUrl[] picUrlArr7 = this.ambientTopPict;
            if (picUrlArr7 != null && picUrlArr7.length > 0) {
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr8 = this.ambientTopPict;
                    if (i5 >= picUrlArr8.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl4 = picUrlArr8[i5];
                    if (picUrl4 != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl4);
                    }
                    i5++;
                }
            }
            UserInfos.PicUrl[] picUrlArr9 = this.ambientBottomPict;
            if (picUrlArr9 != null && picUrlArr9.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr10 = this.ambientBottomPict;
                    if (i >= picUrlArr10.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl5 = picUrlArr10[i];
                    if (picUrl5 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl5);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.coverTopPict;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.coverTopPict;
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
            UserInfos.PicUrl[] picUrlArr3 = this.coverBottomPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.coverBottomPict;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(2, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr5 = this.bgPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.bgPict;
                    if (i4 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i4];
                    if (picUrl3 != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(3, picUrl3);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            UserInfos.PicUrl[] picUrlArr7 = this.ambientTopPict;
            if (picUrlArr7 != null && picUrlArr7.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr8 = this.ambientTopPict;
                    if (i5 >= picUrlArr8.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl4 = picUrlArr8[i5];
                    if (picUrl4 != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(4, picUrl4);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            UserInfos.PicUrl[] picUrlArr9 = this.ambientBottomPict;
            if (picUrlArr9 != null && picUrlArr9.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr10 = this.ambientBottomPict;
                    if (i >= picUrlArr10.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl5 = picUrlArr10[i];
                    if (picUrl5 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl5);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomRedPackSkinCommonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.coverTopPict;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.coverTopPict, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.coverTopPict = picUrlArr2;
                } else if (tag == 18) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr3 = this.coverBottomPict;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.coverBottomPict, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.coverBottomPict = picUrlArr4;
                } else if (tag == 26) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr5 = this.bgPict;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.bgPict, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.bgPict = picUrlArr6;
                } else if (tag == 34) {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr7 = this.ambientTopPict;
                    int length4 = picUrlArr7 == null ? 0 : picUrlArr7.length;
                    UserInfos.PicUrl[] picUrlArr8 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.ambientTopPict, 0, picUrlArr8, 0, length4);
                    }
                    while (length4 < picUrlArr8.length - 1) {
                        picUrlArr8[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr8[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                    this.ambientTopPict = picUrlArr8;
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr9 = this.ambientBottomPict;
                    int length5 = picUrlArr9 == null ? 0 : picUrlArr9.length;
                    UserInfos.PicUrl[] picUrlArr10 = new UserInfos.PicUrl[repeatedFieldArrayLength5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.ambientBottomPict, 0, picUrlArr10, 0, length5);
                    }
                    while (length5 < picUrlArr10.length - 1) {
                        picUrlArr10[length5] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr10[length5]);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    picUrlArr10[length5] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr10[length5]);
                    this.ambientBottomPict = picUrlArr10;
                }
            }
        }

        public static CustomRedPackSkinCommonInfo parseFrom(byte[] bArr) {
            return (CustomRedPackSkinCommonInfo) MessageNano.mergeFrom(new CustomRedPackSkinCommonInfo(), bArr);
        }

        public static CustomRedPackSkinCommonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomRedPackSkinCommonInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CustomRedPackSkinTheme extends MessageNano {
        public static final int AUDIENCE_RED_PACK_SKIN_FIELD_NUMBER = 4;
        public static final int COMMON_OR_ARROW_RED_PACK_SKIN_FIELD_NUMBER = 2;
        public static final int CONDITION_RED_PACK_SKIN_FIELD_NUMBER = 3;
        private static volatile CustomRedPackSkinTheme[] _emptyArray;
        public CustomRedPackSkinCommonInfo commonInfo;
        private int skinInfoCase_ = 0;
        private Object skinInfo_;

        public final int getSkinInfoCase() {
            return this.skinInfoCase_;
        }

        public final CustomRedPackSkinTheme clearSkinInfo() {
            this.skinInfoCase_ = 0;
            this.skinInfo_ = null;
            return this;
        }

        public static CustomRedPackSkinTheme[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomRedPackSkinTheme[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasCommonOrArrowRedPackSkin() {
            return this.skinInfoCase_ == 2;
        }

        public final CommonOrArrowRedPackSkin getCommonOrArrowRedPackSkin() {
            if (this.skinInfoCase_ == 2) {
                return (CommonOrArrowRedPackSkin) this.skinInfo_;
            }
            return null;
        }

        public final CustomRedPackSkinTheme setCommonOrArrowRedPackSkin(CommonOrArrowRedPackSkin commonOrArrowRedPackSkin) {
            if (commonOrArrowRedPackSkin == null) {
                throw new NullPointerException();
            }
            this.skinInfoCase_ = 2;
            this.skinInfo_ = commonOrArrowRedPackSkin;
            return this;
        }

        public final boolean hasConditionRedPackSkin() {
            return this.skinInfoCase_ == 3;
        }

        public final ConditionRedPackSkin getConditionRedPackSkin() {
            if (this.skinInfoCase_ == 3) {
                return (ConditionRedPackSkin) this.skinInfo_;
            }
            return null;
        }

        public final CustomRedPackSkinTheme setConditionRedPackSkin(ConditionRedPackSkin conditionRedPackSkin) {
            if (conditionRedPackSkin == null) {
                throw new NullPointerException();
            }
            this.skinInfoCase_ = 3;
            this.skinInfo_ = conditionRedPackSkin;
            return this;
        }

        public final boolean hasAudienceRedPackSkin() {
            return this.skinInfoCase_ == 4;
        }

        public final AudienceRedPackSkin getAudienceRedPackSkin() {
            if (this.skinInfoCase_ == 4) {
                return (AudienceRedPackSkin) this.skinInfo_;
            }
            return null;
        }

        public final CustomRedPackSkinTheme setAudienceRedPackSkin(AudienceRedPackSkin audienceRedPackSkin) {
            if (audienceRedPackSkin == null) {
                throw new NullPointerException();
            }
            this.skinInfoCase_ = 4;
            this.skinInfo_ = audienceRedPackSkin;
            return this;
        }

        public CustomRedPackSkinTheme() {
            clear();
        }

        public final CustomRedPackSkinTheme clear() {
            this.commonInfo = null;
            clearSkinInfo();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            CustomRedPackSkinCommonInfo customRedPackSkinCommonInfo = this.commonInfo;
            if (customRedPackSkinCommonInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, customRedPackSkinCommonInfo);
            }
            if (this.skinInfoCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.skinInfo_);
            }
            if (this.skinInfoCase_ == 3) {
                codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.skinInfo_);
            }
            if (this.skinInfoCase_ == 4) {
                codedOutputByteBufferNano.writeMessage(4, (MessageNano) this.skinInfo_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            CustomRedPackSkinCommonInfo customRedPackSkinCommonInfo = this.commonInfo;
            if (customRedPackSkinCommonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, customRedPackSkinCommonInfo);
            }
            if (this.skinInfoCase_ == 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.skinInfo_);
            }
            if (this.skinInfoCase_ == 3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.skinInfo_);
            }
            return this.skinInfoCase_ == 4 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano) this.skinInfo_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomRedPackSkinTheme mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.commonInfo == null) {
                        this.commonInfo = new CustomRedPackSkinCommonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.commonInfo);
                } else if (tag == 18) {
                    if (this.skinInfoCase_ != 2) {
                        this.skinInfo_ = new CommonOrArrowRedPackSkin();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.skinInfo_);
                    this.skinInfoCase_ = 2;
                } else if (tag == 26) {
                    if (this.skinInfoCase_ != 3) {
                        this.skinInfo_ = new ConditionRedPackSkin();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.skinInfo_);
                    this.skinInfoCase_ = 3;
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.skinInfoCase_ != 4) {
                        this.skinInfo_ = new AudienceRedPackSkin();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.skinInfo_);
                    this.skinInfoCase_ = 4;
                }
            }
        }

        public static CustomRedPackSkinTheme parseFrom(byte[] bArr) {
            return (CustomRedPackSkinTheme) MessageNano.mergeFrom(new CustomRedPackSkinTheme(), bArr);
        }

        public static CustomRedPackSkinTheme parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomRedPackSkinTheme().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommonOrArrowRedPackSkin extends MessageNano {
        private static volatile CommonOrArrowRedPackSkin[] _emptyArray;
        public CustomRedPackSkinInnerInfo innerInfo;
        public CustomRedPackSkinOpenButtonInfo openButton;

        public static CommonOrArrowRedPackSkin[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommonOrArrowRedPackSkin[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommonOrArrowRedPackSkin() {
            clear();
        }

        public final CommonOrArrowRedPackSkin clear() {
            this.openButton = null;
            this.innerInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            CustomRedPackSkinOpenButtonInfo customRedPackSkinOpenButtonInfo = this.openButton;
            if (customRedPackSkinOpenButtonInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, customRedPackSkinOpenButtonInfo);
            }
            CustomRedPackSkinInnerInfo customRedPackSkinInnerInfo = this.innerInfo;
            if (customRedPackSkinInnerInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, customRedPackSkinInnerInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            CustomRedPackSkinOpenButtonInfo customRedPackSkinOpenButtonInfo = this.openButton;
            if (customRedPackSkinOpenButtonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, customRedPackSkinOpenButtonInfo);
            }
            CustomRedPackSkinInnerInfo customRedPackSkinInnerInfo = this.innerInfo;
            return customRedPackSkinInnerInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, customRedPackSkinInnerInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommonOrArrowRedPackSkin mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.openButton == null) {
                        this.openButton = new CustomRedPackSkinOpenButtonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.openButton);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.innerInfo == null) {
                        this.innerInfo = new CustomRedPackSkinInnerInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.innerInfo);
                }
            }
        }

        public static CommonOrArrowRedPackSkin parseFrom(byte[] bArr) {
            return (CommonOrArrowRedPackSkin) MessageNano.mergeFrom(new CommonOrArrowRedPackSkin(), bArr);
        }

        public static CommonOrArrowRedPackSkin parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommonOrArrowRedPackSkin().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ConditionRedPackSkin extends MessageNano {
        private static volatile ConditionRedPackSkin[] _emptyArray;
        public CustomRedPackSkinBadgeInfo badgeInfo;
        public CustomRedPackSkinBasicInnerInfo innerInfo;
        public CustomRedPackSkinButtonInfo joinButton;
        public String[] resultRefreshButtonBgColor;
        public CustomRedPackSkinButtonInfo sendGiftButton;
        public String themeTextColor;

        public static ConditionRedPackSkin[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ConditionRedPackSkin[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ConditionRedPackSkin() {
            clear();
        }

        public final ConditionRedPackSkin clear() {
            this.joinButton = null;
            this.innerInfo = null;
            this.badgeInfo = null;
            this.sendGiftButton = null;
            this.themeTextColor = "";
            this.resultRefreshButtonBgColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            CustomRedPackSkinButtonInfo customRedPackSkinButtonInfo = this.joinButton;
            if (customRedPackSkinButtonInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, customRedPackSkinButtonInfo);
            }
            CustomRedPackSkinBasicInnerInfo customRedPackSkinBasicInnerInfo = this.innerInfo;
            if (customRedPackSkinBasicInnerInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, customRedPackSkinBasicInnerInfo);
            }
            CustomRedPackSkinBadgeInfo customRedPackSkinBadgeInfo = this.badgeInfo;
            if (customRedPackSkinBadgeInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, customRedPackSkinBadgeInfo);
            }
            CustomRedPackSkinButtonInfo customRedPackSkinButtonInfo2 = this.sendGiftButton;
            if (customRedPackSkinButtonInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(4, customRedPackSkinButtonInfo2);
            }
            if (!this.themeTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.themeTextColor);
            }
            String[] strArr = this.resultRefreshButtonBgColor;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.resultRefreshButtonBgColor;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(6, str);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            CustomRedPackSkinButtonInfo customRedPackSkinButtonInfo = this.joinButton;
            if (customRedPackSkinButtonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, customRedPackSkinButtonInfo);
            }
            CustomRedPackSkinBasicInnerInfo customRedPackSkinBasicInnerInfo = this.innerInfo;
            if (customRedPackSkinBasicInnerInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, customRedPackSkinBasicInnerInfo);
            }
            CustomRedPackSkinBadgeInfo customRedPackSkinBadgeInfo = this.badgeInfo;
            if (customRedPackSkinBadgeInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, customRedPackSkinBadgeInfo);
            }
            CustomRedPackSkinButtonInfo customRedPackSkinButtonInfo2 = this.sendGiftButton;
            if (customRedPackSkinButtonInfo2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, customRedPackSkinButtonInfo2);
            }
            if (!this.themeTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.themeTextColor);
            }
            String[] strArr = this.resultRefreshButtonBgColor;
            if (strArr == null || strArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeStringSizeNoTag = 0;
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.resultRefreshButtonBgColor;
                if (i >= strArr2.length) {
                    return iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
                }
                String str = strArr2[i];
                if (str != null) {
                    i2++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i++;
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ConditionRedPackSkin mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.joinButton == null) {
                        this.joinButton = new CustomRedPackSkinButtonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.joinButton);
                } else if (tag == 18) {
                    if (this.innerInfo == null) {
                        this.innerInfo = new CustomRedPackSkinBasicInnerInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.innerInfo);
                } else if (tag == 26) {
                    if (this.badgeInfo == null) {
                        this.badgeInfo = new CustomRedPackSkinBadgeInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.badgeInfo);
                } else if (tag == 34) {
                    if (this.sendGiftButton == null) {
                        this.sendGiftButton = new CustomRedPackSkinButtonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.sendGiftButton);
                } else if (tag == 42) {
                    this.themeTextColor = codedInputByteBufferNano.readString();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr = this.resultRefreshButtonBgColor;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.resultRefreshButtonBgColor, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.resultRefreshButtonBgColor = strArr2;
                }
            }
        }

        public static ConditionRedPackSkin parseFrom(byte[] bArr) {
            return (ConditionRedPackSkin) MessageNano.mergeFrom(new ConditionRedPackSkin(), bArr);
        }

        public static ConditionRedPackSkin parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ConditionRedPackSkin().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AudienceRedPackSkin extends MessageNano {
        private static volatile AudienceRedPackSkin[] _emptyArray;
        public CustomRedPackSkinInnerInfo innerInfo;
        public CustomRedPackSkinOpenButtonInfo openButton;
        public CustomRedPackSkinButtonInfo sendGiftButton;

        public static AudienceRedPackSkin[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AudienceRedPackSkin[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AudienceRedPackSkin() {
            clear();
        }

        public final AudienceRedPackSkin clear() {
            this.openButton = null;
            this.innerInfo = null;
            this.sendGiftButton = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            CustomRedPackSkinOpenButtonInfo customRedPackSkinOpenButtonInfo = this.openButton;
            if (customRedPackSkinOpenButtonInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, customRedPackSkinOpenButtonInfo);
            }
            CustomRedPackSkinInnerInfo customRedPackSkinInnerInfo = this.innerInfo;
            if (customRedPackSkinInnerInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, customRedPackSkinInnerInfo);
            }
            CustomRedPackSkinButtonInfo customRedPackSkinButtonInfo = this.sendGiftButton;
            if (customRedPackSkinButtonInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, customRedPackSkinButtonInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            CustomRedPackSkinOpenButtonInfo customRedPackSkinOpenButtonInfo = this.openButton;
            if (customRedPackSkinOpenButtonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, customRedPackSkinOpenButtonInfo);
            }
            CustomRedPackSkinInnerInfo customRedPackSkinInnerInfo = this.innerInfo;
            if (customRedPackSkinInnerInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, customRedPackSkinInnerInfo);
            }
            CustomRedPackSkinButtonInfo customRedPackSkinButtonInfo = this.sendGiftButton;
            return customRedPackSkinButtonInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, customRedPackSkinButtonInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AudienceRedPackSkin mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.openButton == null) {
                        this.openButton = new CustomRedPackSkinOpenButtonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.openButton);
                } else if (tag == 18) {
                    if (this.innerInfo == null) {
                        this.innerInfo = new CustomRedPackSkinInnerInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.innerInfo);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.sendGiftButton == null) {
                        this.sendGiftButton = new CustomRedPackSkinButtonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.sendGiftButton);
                }
            }
        }

        public static AudienceRedPackSkin parseFrom(byte[] bArr) {
            return (AudienceRedPackSkin) MessageNano.mergeFrom(new AudienceRedPackSkin(), bArr);
        }

        public static AudienceRedPackSkin parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AudienceRedPackSkin().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CustomRedPackSkinBadgeInfo extends MessageNano {
        private static volatile CustomRedPackSkinBadgeInfo[] _emptyArray;
        public String badgeLabelBgColor;

        public static CustomRedPackSkinBadgeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomRedPackSkinBadgeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CustomRedPackSkinBadgeInfo() {
            clear();
        }

        public final CustomRedPackSkinBadgeInfo clear() {
            this.badgeLabelBgColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.badgeLabelBgColor.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.badgeLabelBgColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.badgeLabelBgColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.badgeLabelBgColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomRedPackSkinBadgeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.badgeLabelBgColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CustomRedPackSkinBadgeInfo parseFrom(byte[] bArr) {
            return (CustomRedPackSkinBadgeInfo) MessageNano.mergeFrom(new CustomRedPackSkinBadgeInfo(), bArr);
        }

        public static CustomRedPackSkinBadgeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomRedPackSkinBadgeInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveLEEEnhancedUiConfig extends MessageNano {
        private static volatile LiveLEEEnhancedUiConfig[] _emptyArray;
        public UserInfos.PicUrl[] beanIconUrl;
        public UserInfos.PicUrl[] bgIconUrl;
        public String displayAmount;
        public String displayTitle;
        public String displayUnit;
        public boolean enableShowEnhancedStyle;
        public UserInfos.PicUrl[] lottieAnimationUrl;

        public static LiveLEEEnhancedUiConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveLEEEnhancedUiConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveLEEEnhancedUiConfig() {
            clear();
        }

        public final LiveLEEEnhancedUiConfig clear() {
            this.beanIconUrl = UserInfos.PicUrl.emptyArray();
            this.displayUnit = "";
            this.displayAmount = "";
            this.bgIconUrl = UserInfos.PicUrl.emptyArray();
            this.displayTitle = "";
            this.lottieAnimationUrl = UserInfos.PicUrl.emptyArray();
            this.enableShowEnhancedStyle = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.beanIconUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.beanIconUrl;
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
            if (!this.displayUnit.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.displayUnit);
            }
            if (!this.displayAmount.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.displayAmount);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.bgIconUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.bgIconUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl2);
                    }
                    i3++;
                }
            }
            if (!this.displayTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.displayTitle);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.lottieAnimationUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.lottieAnimationUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl3);
                    }
                    i++;
                }
            }
            boolean z = this.enableShowEnhancedStyle;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.beanIconUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.beanIconUrl;
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
            if (!this.displayUnit.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.displayUnit);
            }
            if (!this.displayAmount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayAmount);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.bgIconUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.bgIconUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(4, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            if (!this.displayTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayTitle);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.lottieAnimationUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.lottieAnimationUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl3);
                    }
                    i++;
                }
            }
            boolean z = this.enableShowEnhancedStyle;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveLEEEnhancedUiConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.beanIconUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.beanIconUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.beanIconUrl = picUrlArr2;
                } else if (tag == 18) {
                    this.displayUnit = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.displayAmount = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr3 = this.bgIconUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.bgIconUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.bgIconUrl = picUrlArr4;
                } else if (tag == 42) {
                    this.displayTitle = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    UserInfos.PicUrl[] picUrlArr5 = this.lottieAnimationUrl;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.lottieAnimationUrl, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.lottieAnimationUrl = picUrlArr6;
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enableShowEnhancedStyle = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveLEEEnhancedUiConfig parseFrom(byte[] bArr) {
            return (LiveLEEEnhancedUiConfig) MessageNano.mergeFrom(new LiveLEEEnhancedUiConfig(), bArr);
        }

        public static LiveLEEEnhancedUiConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveLEEEnhancedUiConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
