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
public interface LiveBsStateMessages {

    public static final class SCLiveCurrentBsState extends MessageNano {
        private static volatile SCLiveCurrentBsState[] _emptyArray;
        public String actionUrl;
        public Button activeButton;
        public long appId;
        public String bizType;
        public String exposureId;
        public String extraInfo;
        public int floatLiveType;
        public String formId;
        public String ksOrderId;
        public int openFloatLive;
        public String statisticsInfo;
        public int supportType;
        public String tunaDownloadPackageName;
        public String tunaDownloadUrl;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ButtonType {
            public static final int AD_BRAND = 6;
            public static final int APP_DOWNLOAD = 2;
            public static final int DEFAULT = 0;
            public static final int LEAD = 1;
            public static final int LOCATION = 4;
            public static final int MINI_PROGRAM = 3;
            public static final int SPARK = 5;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface FloatLiveType {
            public static final int CLOSE = 0;
            public static final int OPEN = 1;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SupportType {
            public static final int ALL = 0;
            public static final int ANDROID = 2;
            public static final int IOS = 1;
        }

        public static final class Button extends MessageNano {
            private static volatile Button[] _emptyArray;
            public int buttonType;
            public String desc;
            public UserInfos.PicUrl[] icon;
            public UserInfos.PicUrl[] iconV2;
            public String link;
            public UserInfos.PicUrl[] lottieIcon;
            public String name;

            public static Button[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new Button[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public Button() {
                clear();
            }

            public final Button clear() {
                this.buttonType = 0;
                this.name = "";
                this.desc = "";
                this.link = "";
                this.icon = UserInfos.PicUrl.emptyArray();
                this.iconV2 = UserInfos.PicUrl.emptyArray();
                this.lottieIcon = UserInfos.PicUrl.emptyArray();
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                int i = this.buttonType;
                if (i != 0) {
                    codedOutputByteBufferNano.writeInt32(1, i);
                }
                if (!this.name.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.name);
                }
                if (!this.desc.equals("")) {
                    codedOutputByteBufferNano.writeString(3, this.desc);
                }
                if (!this.link.equals("")) {
                    codedOutputByteBufferNano.writeString(4, this.link);
                }
                UserInfos.PicUrl[] picUrlArr = this.icon;
                int i2 = 0;
                if (picUrlArr != null && picUrlArr.length > 0) {
                    int i3 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
                UserInfos.PicUrl[] picUrlArr3 = this.iconV2;
                if (picUrlArr3 != null && picUrlArr3.length > 0) {
                    int i4 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr4 = this.iconV2;
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
                UserInfos.PicUrl[] picUrlArr5 = this.lottieIcon;
                if (picUrlArr5 != null && picUrlArr5.length > 0) {
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr6 = this.lottieIcon;
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
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                int i = this.buttonType;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
                }
                if (!this.name.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
                }
                if (!this.desc.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.desc);
                }
                if (!this.link.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.link);
                }
                UserInfos.PicUrl[] picUrlArr = this.icon;
                int i2 = 0;
                if (picUrlArr != null && picUrlArr.length > 0) {
                    int iComputeMessageSize = iComputeSerializedSize;
                    int i3 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
                UserInfos.PicUrl[] picUrlArr3 = this.iconV2;
                if (picUrlArr3 != null && picUrlArr3.length > 0) {
                    int iComputeMessageSize2 = iComputeSerializedSize;
                    int i4 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr4 = this.iconV2;
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
                UserInfos.PicUrl[] picUrlArr5 = this.lottieIcon;
                if (picUrlArr5 != null && picUrlArr5.length > 0) {
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr6 = this.lottieIcon;
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
                return iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final Button mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        int int32 = codedInputByteBufferNano.readInt32();
                        switch (int32) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.buttonType = int32;
                                break;
                        }
                    } else if (tag == 18) {
                        this.name = codedInputByteBufferNano.readString();
                    } else if (tag == 26) {
                        this.desc = codedInputByteBufferNano.readString();
                    } else if (tag == 34) {
                        this.link = codedInputByteBufferNano.readString();
                    } else if (tag == 42) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        UserInfos.PicUrl[] picUrlArr = this.icon;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.icon = picUrlArr2;
                    } else if (tag == 50) {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        UserInfos.PicUrl[] picUrlArr3 = this.iconV2;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.iconV2, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.iconV2 = picUrlArr4;
                    } else if (tag != 58) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        UserInfos.PicUrl[] picUrlArr5 = this.lottieIcon;
                        int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                        UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.lottieIcon, 0, picUrlArr6, 0, length3);
                        }
                        while (length3 < picUrlArr6.length - 1) {
                            picUrlArr6[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        this.lottieIcon = picUrlArr6;
                    }
                }
            }

            public static Button parseFrom(byte[] bArr) {
                return (Button) MessageNano.mergeFrom(new Button(), bArr);
            }

            public static Button parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new Button().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static SCLiveCurrentBsState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCurrentBsState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCurrentBsState() {
            clear();
        }

        public final SCLiveCurrentBsState clear() {
            this.activeButton = null;
            this.formId = "";
            this.ksOrderId = "";
            this.tunaDownloadUrl = "";
            this.tunaDownloadPackageName = "";
            this.appId = 0L;
            this.actionUrl = "";
            this.supportType = 0;
            this.openFloatLive = 0;
            this.statisticsInfo = "";
            this.floatLiveType = 0;
            this.bizType = "";
            this.exposureId = "";
            this.extraInfo = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            Button button = this.activeButton;
            if (button != null) {
                codedOutputByteBufferNano.writeMessage(1, button);
            }
            if (!this.formId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.formId);
            }
            if (!this.ksOrderId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.ksOrderId);
            }
            if (!this.tunaDownloadUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.tunaDownloadUrl);
            }
            if (!this.tunaDownloadPackageName.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.tunaDownloadPackageName);
            }
            long j = this.appId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            if (!this.actionUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.actionUrl);
            }
            int i = this.supportType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(9, i);
            }
            int i2 = this.openFloatLive;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(10, i2);
            }
            if (!this.statisticsInfo.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.statisticsInfo);
            }
            int i3 = this.floatLiveType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(12, i3);
            }
            if (!this.bizType.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.bizType);
            }
            if (!this.exposureId.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.exposureId);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(16, this.extraInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            Button button = this.activeButton;
            if (button != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, button);
            }
            if (!this.formId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.formId);
            }
            if (!this.ksOrderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.ksOrderId);
            }
            if (!this.tunaDownloadUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.tunaDownloadUrl);
            }
            if (!this.tunaDownloadPackageName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.tunaDownloadPackageName);
            }
            long j = this.appId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            if (!this.actionUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.actionUrl);
            }
            int i = this.supportType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i);
            }
            int i2 = this.openFloatLive;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i2);
            }
            if (!this.statisticsInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.statisticsInfo);
            }
            int i3 = this.floatLiveType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i3);
            }
            if (!this.bizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.bizType);
            }
            if (!this.exposureId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.exposureId);
            }
            return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(16, this.extraInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCurrentBsState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.activeButton == null) {
                            this.activeButton = new Button();
                        }
                        codedInputByteBufferNano.readMessage(this.activeButton);
                        break;
                    case 18:
                        this.formId = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.ksOrderId = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.tunaDownloadUrl = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.tunaDownloadPackageName = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        this.appId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 58:
                        this.actionUrl = codedInputByteBufferNano.readString();
                        break;
                    case 72:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            break;
                        } else {
                            this.supportType = int32;
                            break;
                        }
                        break;
                    case 80:
                        this.openFloatLive = codedInputByteBufferNano.readUInt32();
                        break;
                    case 90:
                        this.statisticsInfo = codedInputByteBufferNano.readString();
                        break;
                    case 96:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1) {
                            break;
                        } else {
                            this.floatLiveType = int322;
                            break;
                        }
                        break;
                    case 106:
                        this.bizType = codedInputByteBufferNano.readString();
                        break;
                    case 114:
                        this.exposureId = codedInputByteBufferNano.readString();
                        break;
                    case 130:
                        this.extraInfo = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveCurrentBsState parseFrom(byte[] bArr) {
            return (SCLiveCurrentBsState) MessageNano.mergeFrom(new SCLiveCurrentBsState(), bArr);
        }

        public static SCLiveCurrentBsState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCurrentBsState().mergeFrom(codedInputByteBufferNano);
        }
    }
}
