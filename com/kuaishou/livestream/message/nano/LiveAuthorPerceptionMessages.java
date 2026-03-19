package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAuthorPerceptionMessages {

    public static final class SCLiveAuthorPerceptionTopUserInfo extends MessageNano {
        private static volatile SCLiveAuthorPerceptionTopUserInfo[] _emptyArray;
        public UserInfos.PicUrl[] activeBottomIcon;
        public UserInfos.PicUrl[] activeBottomPicUrl;
        public String capsuleColor;
        public long enterRoomCount;
        public LiveAuthorPerceptionContentConfig enterRoomText;
        public LiveAuthorPerceptionContentConfig onlineCountConfig;
        public long serverTime;
        public UserInfos.PicUrl[] startPicUrl;

        public static SCLiveAuthorPerceptionTopUserInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveAuthorPerceptionTopUserInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveAuthorPerceptionTopUserInfo() {
            clear();
        }

        public final SCLiveAuthorPerceptionTopUserInfo clear() {
            this.onlineCountConfig = null;
            this.startPicUrl = UserInfos.PicUrl.emptyArray();
            this.activeBottomIcon = UserInfos.PicUrl.emptyArray();
            this.activeBottomPicUrl = UserInfos.PicUrl.emptyArray();
            this.enterRoomText = null;
            this.enterRoomCount = 0L;
            this.capsuleColor = "";
            this.serverTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveAuthorPerceptionContentConfig liveAuthorPerceptionContentConfig = this.onlineCountConfig;
            if (liveAuthorPerceptionContentConfig != null) {
                codedOutputByteBufferNano.writeMessage(1, liveAuthorPerceptionContentConfig);
            }
            UserInfos.PicUrl[] picUrlArr = this.startPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.startPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i2++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.activeBottomIcon;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.activeBottomIcon;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl2);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.activeBottomPicUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.activeBottomPicUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl3);
                    }
                    i++;
                }
            }
            LiveAuthorPerceptionContentConfig liveAuthorPerceptionContentConfig2 = this.enterRoomText;
            if (liveAuthorPerceptionContentConfig2 != null) {
                codedOutputByteBufferNano.writeMessage(5, liveAuthorPerceptionContentConfig2);
            }
            long j = this.enterRoomCount;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            if (!this.capsuleColor.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.capsuleColor);
            }
            long j2 = this.serverTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveAuthorPerceptionContentConfig liveAuthorPerceptionContentConfig = this.onlineCountConfig;
            if (liveAuthorPerceptionContentConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveAuthorPerceptionContentConfig);
            }
            UserInfos.PicUrl[] picUrlArr = this.startPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.startPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.activeBottomIcon;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.activeBottomIcon;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(3, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr5 = this.activeBottomPicUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.activeBottomPicUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl3);
                    }
                    i++;
                }
            }
            LiveAuthorPerceptionContentConfig liveAuthorPerceptionContentConfig2 = this.enterRoomText;
            if (liveAuthorPerceptionContentConfig2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveAuthorPerceptionContentConfig2);
            }
            long j = this.enterRoomCount;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            if (!this.capsuleColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.capsuleColor);
            }
            long j2 = this.serverTime;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(8, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveAuthorPerceptionTopUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.onlineCountConfig == null) {
                        this.onlineCountConfig = new LiveAuthorPerceptionContentConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.onlineCountConfig);
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr = this.startPicUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.startPicUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.startPicUrl = picUrlArr2;
                } else if (tag == 26) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr3 = this.activeBottomIcon;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.activeBottomIcon, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.activeBottomIcon = picUrlArr4;
                } else if (tag == 34) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr5 = this.activeBottomPicUrl;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.activeBottomPicUrl, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.activeBottomPicUrl = picUrlArr6;
                } else if (tag == 42) {
                    if (this.enterRoomText == null) {
                        this.enterRoomText = new LiveAuthorPerceptionContentConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.enterRoomText);
                } else if (tag == 48) {
                    this.enterRoomCount = codedInputByteBufferNano.readUInt64();
                } else if (tag == 58) {
                    this.capsuleColor = codedInputByteBufferNano.readString();
                } else if (tag != 64) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveAuthorPerceptionTopUserInfo parseFrom(byte[] bArr) {
            return (SCLiveAuthorPerceptionTopUserInfo) MessageNano.mergeFrom(new SCLiveAuthorPerceptionTopUserInfo(), bArr);
        }

        public static SCLiveAuthorPerceptionTopUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveAuthorPerceptionTopUserInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveAuthorPerceptionContentConfig extends MessageNano {
        private static volatile LiveAuthorPerceptionContentConfig[] _emptyArray;
        public String color;
        public String font;
        public long fontSize;
        public long fontWeight;
        public String text;

        public static LiveAuthorPerceptionContentConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveAuthorPerceptionContentConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveAuthorPerceptionContentConfig() {
            clear();
        }

        public final LiveAuthorPerceptionContentConfig clear() {
            this.text = "";
            this.fontSize = 0L;
            this.color = "";
            this.fontWeight = 0L;
            this.font = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            long j = this.fontSize;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            if (!this.color.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.color);
            }
            long j2 = this.fontWeight;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            if (!this.font.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.font);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            long j = this.fontSize;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            if (!this.color.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.color);
            }
            long j2 = this.fontWeight;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            return !this.font.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.font) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveAuthorPerceptionContentConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.fontSize = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.color = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.fontWeight = codedInputByteBufferNano.readUInt64();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.font = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveAuthorPerceptionContentConfig parseFrom(byte[] bArr) {
            return (LiveAuthorPerceptionContentConfig) MessageNano.mergeFrom(new LiveAuthorPerceptionContentConfig(), bArr);
        }

        public static LiveAuthorPerceptionContentConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveAuthorPerceptionContentConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCTrafficOpPendantClosed extends MessageNano {
        private static volatile SCTrafficOpPendantClosed[] _emptyArray;
        public String liveStreamId;
        public long serverTime;

        public static SCTrafficOpPendantClosed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCTrafficOpPendantClosed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCTrafficOpPendantClosed() {
            clear();
        }

        public final SCTrafficOpPendantClosed clear() {
            this.liveStreamId = "";
            this.serverTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            long j = this.serverTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            long j = this.serverTime;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCTrafficOpPendantClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCTrafficOpPendantClosed parseFrom(byte[] bArr) {
            return (SCTrafficOpPendantClosed) MessageNano.mergeFrom(new SCTrafficOpPendantClosed(), bArr);
        }

        public static SCTrafficOpPendantClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCTrafficOpPendantClosed().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveAuthorPerceptionTopUserClosed extends MessageNano {
        private static volatile SCLiveAuthorPerceptionTopUserClosed[] _emptyArray;
        public String liveStreamId;
        public long serverTime;

        public static SCLiveAuthorPerceptionTopUserClosed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveAuthorPerceptionTopUserClosed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveAuthorPerceptionTopUserClosed() {
            clear();
        }

        public final SCLiveAuthorPerceptionTopUserClosed clear() {
            this.liveStreamId = "";
            this.serverTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            long j = this.serverTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            long j = this.serverTime;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveAuthorPerceptionTopUserClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveAuthorPerceptionTopUserClosed parseFrom(byte[] bArr) {
            return (SCLiveAuthorPerceptionTopUserClosed) MessageNano.mergeFrom(new SCLiveAuthorPerceptionTopUserClosed(), bArr);
        }

        public static SCLiveAuthorPerceptionTopUserClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveAuthorPerceptionTopUserClosed().mergeFrom(codedInputByteBufferNano);
        }
    }
}
