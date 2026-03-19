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
public interface LiveBsLocalLifeStateMessages {

    public static final class SCLiveCurrentLocalLifeState extends MessageNano {
        private static volatile SCLiveCurrentLocalLifeState[] _emptyArray;
        public String actionUrl;
        public Button activeButton;
        public String authorRole;
        public int floatLiveType;
        public boolean isDynamicIcon;
        public String ksOrderId;
        public int liteSignalType;
        public int loopCount;
        public String lottieUrl;
        public int openFloatLive;
        public long serverTime;
        public int signalType;
        public String statisticsInfo;
        public int supportType;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ButtonType {
            public static final int DEFAULT = 0;
            public static final int LOCATION_BUY = 1;
            public static final int LOCATION_ESTATE = 2;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface FloatLiveType {
            public static final int CLOSE = 0;
            public static final int OPEN = 1;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface SignalType {
            public static final int HIDE = 1;
            public static final int SHOW = 0;
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
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr4 = this.iconV2;
                        if (i2 >= picUrlArr4.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl2 = picUrlArr4[i2];
                        if (picUrl2 != null) {
                            codedOutputByteBufferNano.writeMessage(6, picUrl2);
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
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr4 = this.iconV2;
                        if (i2 >= picUrlArr4.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl2 = picUrlArr4[i2];
                        if (picUrl2 != null) {
                            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl2);
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
                        if (int32 == 0 || int32 == 1 || int32 == 2) {
                            this.buttonType = int32;
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
                    } else if (tag != 50) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
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

        public static SCLiveCurrentLocalLifeState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCurrentLocalLifeState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCurrentLocalLifeState() {
            clear();
        }

        public final SCLiveCurrentLocalLifeState clear() {
            this.activeButton = null;
            this.ksOrderId = "";
            this.actionUrl = "";
            this.supportType = 0;
            this.openFloatLive = 0;
            this.statisticsInfo = "";
            this.floatLiveType = 0;
            this.isDynamicIcon = false;
            this.loopCount = 0;
            this.lottieUrl = "";
            this.signalType = 0;
            this.serverTime = 0L;
            this.authorRole = "";
            this.liteSignalType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            Button button = this.activeButton;
            if (button != null) {
                codedOutputByteBufferNano.writeMessage(1, button);
            }
            if (!this.ksOrderId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.ksOrderId);
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
            boolean z = this.isDynamicIcon;
            if (z) {
                codedOutputByteBufferNano.writeBool(13, z);
            }
            int i4 = this.loopCount;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(14, i4);
            }
            if (!this.lottieUrl.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.lottieUrl);
            }
            int i5 = this.signalType;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(16, i5);
            }
            long j = this.serverTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(17, j);
            }
            if (!this.authorRole.equals("")) {
                codedOutputByteBufferNano.writeString(18, this.authorRole);
            }
            int i6 = this.liteSignalType;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeInt32(19, i6);
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
            if (!this.ksOrderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.ksOrderId);
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
            boolean z = this.isDynamicIcon;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z);
            }
            int i4 = this.loopCount;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i4);
            }
            if (!this.lottieUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.lottieUrl);
            }
            int i5 = this.signalType;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(16, i5);
            }
            long j = this.serverTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(17, j);
            }
            if (!this.authorRole.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.authorRole);
            }
            int i6 = this.liteSignalType;
            return i6 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(19, i6) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCurrentLocalLifeState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    case 26:
                        this.ksOrderId = codedInputByteBufferNano.readString();
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
                    case 104:
                        this.isDynamicIcon = codedInputByteBufferNano.readBool();
                        break;
                    case 112:
                        this.loopCount = codedInputByteBufferNano.readInt32();
                        break;
                    case 122:
                        this.lottieUrl = codedInputByteBufferNano.readString();
                        break;
                    case 128:
                        int int323 = codedInputByteBufferNano.readInt32();
                        if (int323 != 0 && int323 != 1) {
                            break;
                        } else {
                            this.signalType = int323;
                            break;
                        }
                    case 136:
                        this.serverTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 146:
                        this.authorRole = codedInputByteBufferNano.readString();
                        break;
                    case 152:
                        int int324 = codedInputByteBufferNano.readInt32();
                        if (int324 != 0 && int324 != 1) {
                            break;
                        } else {
                            this.liteSignalType = int324;
                            break;
                        }
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveCurrentLocalLifeState parseFrom(byte[] bArr) {
            return (SCLiveCurrentLocalLifeState) MessageNano.mergeFrom(new SCLiveCurrentLocalLifeState(), bArr);
        }

        public static SCLiveCurrentLocalLifeState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCurrentLocalLifeState().mergeFrom(codedInputByteBufferNano);
        }
    }
}
