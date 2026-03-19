package com.kuaishou.livestream.message.nano;

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
public final class HighFrequencyActionGuide extends MessageNano {
    private static volatile HighFrequencyActionGuide[] _emptyArray;
    public String actionText;
    public String actionUrl;
    public String businessParams;
    public String configBizId;
    public String configBizIdV2;
    public int count;
    public int giftId;
    public String giftToken;
    public UserInfos.PicUrl[] leftIcon;
    public int liteBizType;
    public long maxShowDurationMs;
    public int style;
    public String subBizId;
    public String subBizType;
    public TextDescription subTitle;
    public String text;
    public TextDescription titleLarge;
    public TextDescription titleSmall;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiteBizType {
        public static final int JOIN_FANS_GROUP = 2;
        public static final int SEND_GIFT = 1;
        public static final int UNKNOWN = 0;
    }

    public static final class TextDescription extends MessageNano {
        private static volatile TextDescription[] _emptyArray;
        public int animDurationMs;
        public int animType;
        public int displayStyle;
        public int endCount;
        public int startCount;
        public int steps;
        public String text;

        public static TextDescription[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TextDescription[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TextDescription() {
            clear();
        }

        public final TextDescription clear() {
            this.text = "";
            this.startCount = 0;
            this.endCount = 0;
            this.steps = 0;
            this.animType = 0;
            this.displayStyle = 0;
            this.animDurationMs = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            int i = this.startCount;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.endCount;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            int i3 = this.steps;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i3);
            }
            int i4 = this.animType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i4);
            }
            int i5 = this.displayStyle;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i5);
            }
            int i6 = this.animDurationMs;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i6);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            int i = this.startCount;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.endCount;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            int i3 = this.steps;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
            }
            int i4 = this.animType;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i4);
            }
            int i5 = this.displayStyle;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i5);
            }
            int i6 = this.animDurationMs;
            return i6 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i6) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TextDescription mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.startCount = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.endCount = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.steps = codedInputByteBufferNano.readUInt32();
                } else if (tag == 40) {
                    this.animType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 48) {
                    this.displayStyle = codedInputByteBufferNano.readUInt32();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.animDurationMs = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static TextDescription parseFrom(byte[] bArr) {
            return (TextDescription) MessageNano.mergeFrom(new TextDescription(), bArr);
        }

        public static TextDescription parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TextDescription().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static HighFrequencyActionGuide[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HighFrequencyActionGuide[0];
                }
            }
        }
        return _emptyArray;
    }

    public HighFrequencyActionGuide() {
        clear();
    }

    public final HighFrequencyActionGuide clear() {
        this.configBizId = "";
        this.text = "";
        this.count = 0;
        this.actionUrl = "";
        this.actionText = "";
        this.giftId = 0;
        this.configBizIdV2 = "";
        this.style = 0;
        this.titleLarge = null;
        this.titleSmall = null;
        this.subTitle = null;
        this.leftIcon = UserInfos.PicUrl.emptyArray();
        this.businessParams = "";
        this.subBizType = "";
        this.subBizId = "";
        this.maxShowDurationMs = 0L;
        this.liteBizType = 0;
        this.giftToken = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.configBizId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.configBizId);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.text);
        }
        int i = this.count;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        if (!this.actionUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.actionUrl);
        }
        if (!this.actionText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.actionText);
        }
        int i2 = this.giftId;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        if (!this.configBizIdV2.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.configBizIdV2);
        }
        int i3 = this.style;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        TextDescription textDescription = this.titleLarge;
        if (textDescription != null) {
            codedOutputByteBufferNano.writeMessage(9, textDescription);
        }
        TextDescription textDescription2 = this.titleSmall;
        if (textDescription2 != null) {
            codedOutputByteBufferNano.writeMessage(10, textDescription2);
        }
        TextDescription textDescription3 = this.subTitle;
        if (textDescription3 != null) {
            codedOutputByteBufferNano.writeMessage(11, textDescription3);
        }
        UserInfos.PicUrl[] picUrlArr = this.leftIcon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.leftIcon;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(12, picUrl);
                }
                i4++;
            }
        }
        if (!this.businessParams.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.businessParams);
        }
        if (!this.subBizType.equals("")) {
            codedOutputByteBufferNano.writeString(14, this.subBizType);
        }
        if (!this.subBizId.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.subBizId);
        }
        long j = this.maxShowDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(16, j);
        }
        int i5 = this.liteBizType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(17, i5);
        }
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.giftToken);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.configBizId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.configBizId);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
        }
        int i = this.count;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        if (!this.actionUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.actionUrl);
        }
        if (!this.actionText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.actionText);
        }
        int i2 = this.giftId;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
        }
        if (!this.configBizIdV2.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.configBizIdV2);
        }
        int i3 = this.style;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        TextDescription textDescription = this.titleLarge;
        if (textDescription != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, textDescription);
        }
        TextDescription textDescription2 = this.titleSmall;
        if (textDescription2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, textDescription2);
        }
        TextDescription textDescription3 = this.subTitle;
        if (textDescription3 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, textDescription3);
        }
        UserInfos.PicUrl[] picUrlArr = this.leftIcon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.leftIcon;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, picUrl);
                }
                i4++;
            }
        }
        if (!this.businessParams.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.businessParams);
        }
        if (!this.subBizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.subBizType);
        }
        if (!this.subBizId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.subBizId);
        }
        long j = this.maxShowDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(16, j);
        }
        int i5 = this.liteBizType;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(17, i5);
        }
        return !this.giftToken.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(18, this.giftToken) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final HighFrequencyActionGuide mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.configBizId = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.text = codedInputByteBufferNano.readString();
                    break;
                case 24:
                    this.count = codedInputByteBufferNano.readUInt32();
                    break;
                case 34:
                    this.actionUrl = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.actionText = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.configBizIdV2 = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.style = codedInputByteBufferNano.readUInt32();
                    break;
                case 74:
                    if (this.titleLarge == null) {
                        this.titleLarge = new TextDescription();
                    }
                    codedInputByteBufferNano.readMessage(this.titleLarge);
                    break;
                case 82:
                    if (this.titleSmall == null) {
                        this.titleSmall = new TextDescription();
                    }
                    codedInputByteBufferNano.readMessage(this.titleSmall);
                    break;
                case 90:
                    if (this.subTitle == null) {
                        this.subTitle = new TextDescription();
                    }
                    codedInputByteBufferNano.readMessage(this.subTitle);
                    break;
                case 98:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    UserInfos.PicUrl[] picUrlArr = this.leftIcon;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.leftIcon, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.leftIcon = picUrlArr2;
                    break;
                case 106:
                    this.businessParams = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    this.subBizType = codedInputByteBufferNano.readString();
                    break;
                case 122:
                    this.subBizId = codedInputByteBufferNano.readString();
                    break;
                case 128:
                    this.maxShowDurationMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 136:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.liteBizType = int32;
                        break;
                    }
                    break;
                case 146:
                    this.giftToken = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static HighFrequencyActionGuide parseFrom(byte[] bArr) {
        return (HighFrequencyActionGuide) MessageNano.mergeFrom(new HighFrequencyActionGuide(), bArr);
    }

    public static HighFrequencyActionGuide parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new HighFrequencyActionGuide().mergeFrom(codedInputByteBufferNano);
    }
}
