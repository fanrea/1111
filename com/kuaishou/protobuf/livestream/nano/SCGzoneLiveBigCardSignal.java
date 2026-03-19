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
public final class SCGzoneLiveBigCardSignal extends MessageNano {
    private static volatile SCGzoneLiveBigCardSignal[] _emptyArray;
    public int action;
    public BigCardInfo[] bigCardInfo;
    public int bizType;
    public BigCardDisplay displayInfo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SignalType {
        public static final int CLOSE = 2;
        public static final int OPEN = 1;
        public static final int UNKNOWN = 0;
    }

    public static final class BigCardDisplay extends MessageNano {
        private static volatile BigCardDisplay[] _emptyArray;
        public int displayInterval;
        public int displayLoop;
        public int displaySecond;

        public static BigCardDisplay[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new BigCardDisplay[0];
                    }
                }
            }
            return _emptyArray;
        }

        public BigCardDisplay() {
            clear();
        }

        public final BigCardDisplay clear() {
            this.displaySecond = 0;
            this.displayLoop = 0;
            this.displayInterval = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.displaySecond;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.displayLoop;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            int i3 = this.displayInterval;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.displaySecond;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.displayLoop;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
            }
            int i3 = this.displayInterval;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final BigCardDisplay mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.displaySecond = codedInputByteBufferNano.readInt32();
                } else if (tag == 16) {
                    this.displayLoop = codedInputByteBufferNano.readInt32();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.displayInterval = codedInputByteBufferNano.readInt32();
                }
            }
        }

        public static BigCardDisplay parseFrom(byte[] bArr) {
            return (BigCardDisplay) MessageNano.mergeFrom(new BigCardDisplay(), bArr);
        }

        public static BigCardDisplay parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new BigCardDisplay().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class BigCardInfo extends MessageNano {
        private static volatile BigCardInfo[] _emptyArray;
        public UserInfos.PicUrl[] bigCardPic;
        public int cardType;
        public String extra;
        public String jumpUrl;
        public String title;

        public static BigCardInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new BigCardInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public BigCardInfo() {
            clear();
        }

        public final BigCardInfo clear() {
            this.cardType = 0;
            this.title = "";
            this.bigCardPic = UserInfos.PicUrl.emptyArray();
            this.jumpUrl = "";
            this.extra = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.cardType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            UserInfos.PicUrl[] picUrlArr = this.bigCardPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.bigCardPic;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.jumpUrl);
            }
            if (!this.extra.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.extra);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.cardType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            UserInfos.PicUrl[] picUrlArr = this.bigCardPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.bigCardPic;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.jumpUrl);
            }
            return !this.extra.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.extra) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final BigCardInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.cardType = codedInputByteBufferNano.readInt32();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.bigCardPic;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.bigCardPic, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.bigCardPic = picUrlArr2;
                } else if (tag == 34) {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extra = codedInputByteBufferNano.readString();
                }
            }
        }

        public static BigCardInfo parseFrom(byte[] bArr) {
            return (BigCardInfo) MessageNano.mergeFrom(new BigCardInfo(), bArr);
        }

        public static BigCardInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new BigCardInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static SCGzoneLiveBigCardSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCGzoneLiveBigCardSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCGzoneLiveBigCardSignal() {
        clear();
    }

    public final SCGzoneLiveBigCardSignal clear() {
        this.action = 0;
        this.bizType = 0;
        this.bigCardInfo = BigCardInfo.emptyArray();
        this.displayInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.action;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.bizType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        BigCardInfo[] bigCardInfoArr = this.bigCardInfo;
        if (bigCardInfoArr != null && bigCardInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                BigCardInfo[] bigCardInfoArr2 = this.bigCardInfo;
                if (i3 >= bigCardInfoArr2.length) {
                    break;
                }
                BigCardInfo bigCardInfo = bigCardInfoArr2[i3];
                if (bigCardInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, bigCardInfo);
                }
                i3++;
            }
        }
        BigCardDisplay bigCardDisplay = this.displayInfo;
        if (bigCardDisplay != null) {
            codedOutputByteBufferNano.writeMessage(4, bigCardDisplay);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.action;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.bizType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        BigCardInfo[] bigCardInfoArr = this.bigCardInfo;
        if (bigCardInfoArr != null && bigCardInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                BigCardInfo[] bigCardInfoArr2 = this.bigCardInfo;
                if (i3 >= bigCardInfoArr2.length) {
                    break;
                }
                BigCardInfo bigCardInfo = bigCardInfoArr2[i3];
                if (bigCardInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bigCardInfo);
                }
                i3++;
            }
        }
        BigCardDisplay bigCardDisplay = this.displayInfo;
        return bigCardDisplay != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, bigCardDisplay) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCGzoneLiveBigCardSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.action = int32;
                }
            } else if (tag == 16) {
                this.bizType = codedInputByteBufferNano.readInt32();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                BigCardInfo[] bigCardInfoArr = this.bigCardInfo;
                int length = bigCardInfoArr == null ? 0 : bigCardInfoArr.length;
                BigCardInfo[] bigCardInfoArr2 = new BigCardInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.bigCardInfo, 0, bigCardInfoArr2, 0, length);
                }
                while (length < bigCardInfoArr2.length - 1) {
                    bigCardInfoArr2[length] = new BigCardInfo();
                    codedInputByteBufferNano.readMessage(bigCardInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bigCardInfoArr2[length] = new BigCardInfo();
                codedInputByteBufferNano.readMessage(bigCardInfoArr2[length]);
                this.bigCardInfo = bigCardInfoArr2;
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.displayInfo == null) {
                    this.displayInfo = new BigCardDisplay();
                }
                codedInputByteBufferNano.readMessage(this.displayInfo);
            }
        }
    }

    public static SCGzoneLiveBigCardSignal parseFrom(byte[] bArr) {
        return (SCGzoneLiveBigCardSignal) MessageNano.mergeFrom(new SCGzoneLiveBigCardSignal(), bArr);
    }

    public static SCGzoneLiveBigCardSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCGzoneLiveBigCardSignal().mergeFrom(codedInputByteBufferNano);
    }
}
