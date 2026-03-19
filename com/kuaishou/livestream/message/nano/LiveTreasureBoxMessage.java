package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCustomRedPackSkinMessage;
import com.kuaishou.livestream.message.nano.LiveRedPackSkinMessage;
import com.kuaishou.socket.nano.SocketMessages;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveTreasureBoxMessage {

    public static final class LiveTreasureBoxTokenReady extends MessageNano {
        private static volatile LiveTreasureBoxTokenReady[] _emptyArray;
        public int bizType;
        public int boxType;
        public LiveTreasureBoxEffectInfo effectInfo;
        public String extraInfo;
        public Map<String, String> extraMessage;
        public LiveTreasureBoxGrabPage grabPage;
        public long maxRequestTokenTime;
        public int maxRetryCount;
        public long maxRetryIntervalMills;
        public long minRequestTokenTime;
        public String tokenUrl;
        public String treasureBoxId;

        public static LiveTreasureBoxTokenReady[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveTreasureBoxTokenReady[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveTreasureBoxTokenReady() {
            clear();
        }

        public final LiveTreasureBoxTokenReady clear() {
            this.treasureBoxId = "";
            this.bizType = 0;
            this.boxType = 0;
            this.minRequestTokenTime = 0L;
            this.maxRequestTokenTime = 0L;
            this.maxRetryCount = 0;
            this.maxRetryIntervalMills = 0L;
            this.effectInfo = null;
            this.grabPage = null;
            this.extraMessage = null;
            this.extraInfo = "";
            this.tokenUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.treasureBoxId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.treasureBoxId);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.boxType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            long j = this.minRequestTokenTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.maxRequestTokenTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            int i3 = this.maxRetryCount;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i3);
            }
            long j3 = this.maxRetryIntervalMills;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j3);
            }
            LiveTreasureBoxEffectInfo liveTreasureBoxEffectInfo = this.effectInfo;
            if (liveTreasureBoxEffectInfo != null) {
                codedOutputByteBufferNano.writeMessage(8, liveTreasureBoxEffectInfo);
            }
            LiveTreasureBoxGrabPage liveTreasureBoxGrabPage = this.grabPage;
            if (liveTreasureBoxGrabPage != null) {
                codedOutputByteBufferNano.writeMessage(9, liveTreasureBoxGrabPage);
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 10, 9, 9);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.extraInfo);
            }
            if (!this.tokenUrl.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.tokenUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.treasureBoxId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.treasureBoxId);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.boxType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            long j = this.minRequestTokenTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.maxRequestTokenTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            int i3 = this.maxRetryCount;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
            }
            long j3 = this.maxRetryIntervalMills;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
            }
            LiveTreasureBoxEffectInfo liveTreasureBoxEffectInfo = this.effectInfo;
            if (liveTreasureBoxEffectInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveTreasureBoxEffectInfo);
            }
            LiveTreasureBoxGrabPage liveTreasureBoxGrabPage = this.grabPage;
            if (liveTreasureBoxGrabPage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveTreasureBoxGrabPage);
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 10, 9, 9);
            }
            if (!this.extraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.extraInfo);
            }
            return !this.tokenUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.tokenUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveTreasureBoxTokenReady mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.treasureBoxId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.bizType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        this.boxType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.minRequestTokenTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 40:
                        this.maxRequestTokenTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 48:
                        this.maxRetryCount = codedInputByteBufferNano.readUInt32();
                        break;
                    case 56:
                        this.maxRetryIntervalMills = codedInputByteBufferNano.readUInt64();
                        break;
                    case 66:
                        if (this.effectInfo == null) {
                            this.effectInfo = new LiveTreasureBoxEffectInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.effectInfo);
                        break;
                    case 74:
                        if (this.grabPage == null) {
                            this.grabPage = new LiveTreasureBoxGrabPage();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPage);
                        break;
                    case 82:
                        this.extraMessage = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMessage, mapFactory, 9, 9, null, 10, 18);
                        break;
                    case 90:
                        this.extraInfo = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.tokenUrl = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveTreasureBoxTokenReady parseFrom(byte[] bArr) {
            return (LiveTreasureBoxTokenReady) MessageNano.mergeFrom(new LiveTreasureBoxTokenReady(), bArr);
        }

        public static LiveTreasureBoxTokenReady parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveTreasureBoxTokenReady().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveTreasureBoxGrabPage extends MessageNano {
        private static volatile LiveTreasureBoxGrabPage[] _emptyArray;
        public UserInfos.PicUrl[] followHintPopPict;
        public String jumpUrl;
        public boolean needFollow;
        public long popDeadline;
        public long popTime;

        public static LiveTreasureBoxGrabPage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveTreasureBoxGrabPage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveTreasureBoxGrabPage() {
            clear();
        }

        public final LiveTreasureBoxGrabPage clear() {
            this.popTime = 0L;
            this.popDeadline = 0L;
            this.jumpUrl = "";
            this.followHintPopPict = UserInfos.PicUrl.emptyArray();
            this.needFollow = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.popTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.popDeadline;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.jumpUrl);
            }
            UserInfos.PicUrl[] picUrlArr = this.followHintPopPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.followHintPopPict;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl);
                    }
                    i++;
                }
            }
            boolean z = this.needFollow;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.popTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.popDeadline;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
            }
            UserInfos.PicUrl[] picUrlArr = this.followHintPopPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.followHintPopPict;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                    }
                    i++;
                }
            }
            boolean z = this.needFollow;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveTreasureBoxGrabPage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.popTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.popDeadline = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr = this.followHintPopPict;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.followHintPopPict, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.followHintPopPict = picUrlArr2;
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.needFollow = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveTreasureBoxGrabPage parseFrom(byte[] bArr) {
            return (LiveTreasureBoxGrabPage) MessageNano.mergeFrom(new LiveTreasureBoxGrabPage(), bArr);
        }

        public static LiveTreasureBoxGrabPage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveTreasureBoxGrabPage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveTreasureBoxEffectInfo extends MessageNano {
        private static volatile LiveTreasureBoxEffectInfo[] _emptyArray;
        public long displayTime;
        public long giftId;

        public static LiveTreasureBoxEffectInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveTreasureBoxEffectInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveTreasureBoxEffectInfo() {
            clear();
        }

        public final LiveTreasureBoxEffectInfo clear() {
            this.displayTime = 0L;
            this.giftId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.displayTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.giftId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.displayTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.giftId;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveTreasureBoxEffectInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.displayTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.giftId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveTreasureBoxEffectInfo parseFrom(byte[] bArr) {
            return (LiveTreasureBoxEffectInfo) MessageNano.mergeFrom(new LiveTreasureBoxEffectInfo(), bArr);
        }

        public static LiveTreasureBoxEffectInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveTreasureBoxEffectInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveTreasureBoxTokenReady extends MessageNano {
        private static volatile SCLiveTreasureBoxTokenReady[] _emptyArray;
        public LiveTreasureBoxTokenReady[] token;

        public static SCLiveTreasureBoxTokenReady[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveTreasureBoxTokenReady[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveTreasureBoxTokenReady() {
            clear();
        }

        public final SCLiveTreasureBoxTokenReady clear() {
            this.token = LiveTreasureBoxTokenReady.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveTreasureBoxTokenReady[] liveTreasureBoxTokenReadyArr = this.token;
            if (liveTreasureBoxTokenReadyArr != null && liveTreasureBoxTokenReadyArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveTreasureBoxTokenReady[] liveTreasureBoxTokenReadyArr2 = this.token;
                    if (i >= liveTreasureBoxTokenReadyArr2.length) {
                        break;
                    }
                    LiveTreasureBoxTokenReady liveTreasureBoxTokenReady = liveTreasureBoxTokenReadyArr2[i];
                    if (liveTreasureBoxTokenReady != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveTreasureBoxTokenReady);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveTreasureBoxTokenReady[] liveTreasureBoxTokenReadyArr = this.token;
            if (liveTreasureBoxTokenReadyArr != null && liveTreasureBoxTokenReadyArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveTreasureBoxTokenReady[] liveTreasureBoxTokenReadyArr2 = this.token;
                    if (i >= liveTreasureBoxTokenReadyArr2.length) {
                        break;
                    }
                    LiveTreasureBoxTokenReady liveTreasureBoxTokenReady = liveTreasureBoxTokenReadyArr2[i];
                    if (liveTreasureBoxTokenReady != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveTreasureBoxTokenReady);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveTreasureBoxTokenReady mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveTreasureBoxTokenReady[] liveTreasureBoxTokenReadyArr = this.token;
                    int length = liveTreasureBoxTokenReadyArr == null ? 0 : liveTreasureBoxTokenReadyArr.length;
                    LiveTreasureBoxTokenReady[] liveTreasureBoxTokenReadyArr2 = new LiveTreasureBoxTokenReady[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.token, 0, liveTreasureBoxTokenReadyArr2, 0, length);
                    }
                    while (length < liveTreasureBoxTokenReadyArr2.length - 1) {
                        liveTreasureBoxTokenReadyArr2[length] = new LiveTreasureBoxTokenReady();
                        codedInputByteBufferNano.readMessage(liveTreasureBoxTokenReadyArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveTreasureBoxTokenReadyArr2[length] = new LiveTreasureBoxTokenReady();
                    codedInputByteBufferNano.readMessage(liveTreasureBoxTokenReadyArr2[length]);
                    this.token = liveTreasureBoxTokenReadyArr2;
                }
            }
        }

        public static SCLiveTreasureBoxTokenReady parseFrom(byte[] bArr) {
            return (SCLiveTreasureBoxTokenReady) MessageNano.mergeFrom(new SCLiveTreasureBoxTokenReady(), bArr);
        }

        public static SCLiveTreasureBoxTokenReady parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveTreasureBoxTokenReady().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class TreasureBoxStyleText extends MessageNano {
        private static volatile TreasureBoxStyleText[] _emptyArray;
        public int fontSize;
        public String text;
        public String textColor;

        public static TreasureBoxStyleText[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TreasureBoxStyleText[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TreasureBoxStyleText() {
            clear();
        }

        public final TreasureBoxStyleText clear() {
            this.text = "";
            this.fontSize = 0;
            this.textColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            int i = this.fontSize;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.textColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            int i = this.fontSize;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            return !this.textColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.textColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TreasureBoxStyleText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.fontSize = codedInputByteBufferNano.readUInt32();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.textColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static TreasureBoxStyleText parseFrom(byte[] bArr) {
            return (TreasureBoxStyleText) MessageNano.mergeFrom(new TreasureBoxStyleText(), bArr);
        }

        public static TreasureBoxStyleText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TreasureBoxStyleText().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class TreasureBoxSingleItemStyle extends MessageNano {
        private static volatile TreasureBoxSingleItemStyle[] _emptyArray;
        public int displayType;
        public TreasureBoxStyleText subText;
        public TreasureBoxStyleText text;

        @Retention(RetentionPolicy.SOURCE)
        public @interface DisplayType {
            public static final int IMAGE = 2;
            public static final int TEXT = 1;
            public static final int UNKNOWN = 0;
        }

        public static TreasureBoxSingleItemStyle[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TreasureBoxSingleItemStyle[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TreasureBoxSingleItemStyle() {
            clear();
        }

        public final TreasureBoxSingleItemStyle clear() {
            this.displayType = 0;
            this.text = null;
            this.subText = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.displayType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            TreasureBoxStyleText treasureBoxStyleText = this.text;
            if (treasureBoxStyleText != null) {
                codedOutputByteBufferNano.writeMessage(2, treasureBoxStyleText);
            }
            TreasureBoxStyleText treasureBoxStyleText2 = this.subText;
            if (treasureBoxStyleText2 != null) {
                codedOutputByteBufferNano.writeMessage(3, treasureBoxStyleText2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.displayType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            TreasureBoxStyleText treasureBoxStyleText = this.text;
            if (treasureBoxStyleText != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, treasureBoxStyleText);
            }
            TreasureBoxStyleText treasureBoxStyleText2 = this.subText;
            return treasureBoxStyleText2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, treasureBoxStyleText2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TreasureBoxSingleItemStyle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.displayType = int32;
                    }
                } else if (tag == 18) {
                    if (this.text == null) {
                        this.text = new TreasureBoxStyleText();
                    }
                    codedInputByteBufferNano.readMessage(this.text);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.subText == null) {
                        this.subText = new TreasureBoxStyleText();
                    }
                    codedInputByteBufferNano.readMessage(this.subText);
                }
            }
        }

        public static TreasureBoxSingleItemStyle parseFrom(byte[] bArr) {
            return (TreasureBoxSingleItemStyle) MessageNano.mergeFrom(new TreasureBoxSingleItemStyle(), bArr);
        }

        public static TreasureBoxSingleItemStyle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TreasureBoxSingleItemStyle().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class TreasureBoxItem extends MessageNano {
        private static volatile TreasureBoxItem[] _emptyArray;
        public int count;
        public TreasureBoxStyleText countText;
        public UserInfos.PicUrl[] displayPict;
        public long itemId;
        public String showCountStr;
        public TreasureBoxSingleItemStyle singleItemStyle;
        public TreasureBoxStyleText unitText;

        public static TreasureBoxItem[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TreasureBoxItem[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TreasureBoxItem() {
            clear();
        }

        public final TreasureBoxItem clear() {
            this.itemId = 0L;
            this.count = 0;
            this.displayPict = UserInfos.PicUrl.emptyArray();
            this.countText = null;
            this.unitText = null;
            this.singleItemStyle = null;
            this.showCountStr = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.itemId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.count;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.displayPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.displayPict;
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
            TreasureBoxStyleText treasureBoxStyleText = this.countText;
            if (treasureBoxStyleText != null) {
                codedOutputByteBufferNano.writeMessage(4, treasureBoxStyleText);
            }
            TreasureBoxStyleText treasureBoxStyleText2 = this.unitText;
            if (treasureBoxStyleText2 != null) {
                codedOutputByteBufferNano.writeMessage(5, treasureBoxStyleText2);
            }
            TreasureBoxSingleItemStyle treasureBoxSingleItemStyle = this.singleItemStyle;
            if (treasureBoxSingleItemStyle != null) {
                codedOutputByteBufferNano.writeMessage(6, treasureBoxSingleItemStyle);
            }
            if (!this.showCountStr.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.showCountStr);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.itemId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.count;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.displayPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.displayPict;
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
            TreasureBoxStyleText treasureBoxStyleText = this.countText;
            if (treasureBoxStyleText != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, treasureBoxStyleText);
            }
            TreasureBoxStyleText treasureBoxStyleText2 = this.unitText;
            if (treasureBoxStyleText2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, treasureBoxStyleText2);
            }
            TreasureBoxSingleItemStyle treasureBoxSingleItemStyle = this.singleItemStyle;
            if (treasureBoxSingleItemStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, treasureBoxSingleItemStyle);
            }
            return !this.showCountStr.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.showCountStr) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TreasureBoxItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.itemId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.count = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.displayPict;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.displayPict, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.displayPict = picUrlArr2;
                } else if (tag == 34) {
                    if (this.countText == null) {
                        this.countText = new TreasureBoxStyleText();
                    }
                    codedInputByteBufferNano.readMessage(this.countText);
                } else if (tag == 42) {
                    if (this.unitText == null) {
                        this.unitText = new TreasureBoxStyleText();
                    }
                    codedInputByteBufferNano.readMessage(this.unitText);
                } else if (tag == 50) {
                    if (this.singleItemStyle == null) {
                        this.singleItemStyle = new TreasureBoxSingleItemStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.singleItemStyle);
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.showCountStr = codedInputByteBufferNano.readString();
                }
            }
        }

        public static TreasureBoxItem parseFrom(byte[] bArr) {
            return (TreasureBoxItem) MessageNano.mergeFrom(new TreasureBoxItem(), bArr);
        }

        public static TreasureBoxItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TreasureBoxItem().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveTreasureBoxShowPage extends MessageNano {
        private static volatile LiveTreasureBoxShowPage[] _emptyArray;
        public UserInfos.PicUrl[] bgPict;
        public UserInfos.PicUrl[] bgPictV2;
        public String[] capsuleColor;
        public String contentText;
        public String fontColor;
        public String fontColorV2;
        public String iconBorderColor;
        public UserInfos.PicUrl[] iconPict;
        public int type;

        @Retention(RetentionPolicy.SOURCE)
        public @interface StatusType {
            public static final int COUNT_DOWN = 0;
            public static final int OPEN_ENABLE = 1;
        }

        public static LiveTreasureBoxShowPage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveTreasureBoxShowPage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveTreasureBoxShowPage() {
            clear();
        }

        public final LiveTreasureBoxShowPage clear() {
            this.type = 0;
            this.bgPict = UserInfos.PicUrl.emptyArray();
            this.iconPict = UserInfos.PicUrl.emptyArray();
            this.contentText = "";
            this.fontColor = "";
            this.capsuleColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.iconBorderColor = "";
            this.bgPictV2 = UserInfos.PicUrl.emptyArray();
            this.fontColorV2 = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.bgPict;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.bgPict;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.iconPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.iconPict;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl2);
                    }
                    i4++;
                }
            }
            if (!this.contentText.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.contentText);
            }
            if (!this.fontColor.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.fontColor);
            }
            String[] strArr = this.capsuleColor;
            if (strArr != null && strArr.length > 0) {
                int i5 = 0;
                while (true) {
                    String[] strArr2 = this.capsuleColor;
                    if (i5 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i5];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(7, str);
                    }
                    i5++;
                }
            }
            if (!this.iconBorderColor.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.iconBorderColor);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.bgPictV2;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.bgPictV2;
                    if (i2 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(9, picUrl3);
                    }
                    i2++;
                }
            }
            if (!this.fontColorV2.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.fontColorV2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.bgPict;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.bgPict;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.iconPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.iconPict;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(4, picUrl2);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            if (!this.contentText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.contentText);
            }
            if (!this.fontColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.fontColor);
            }
            String[] strArr = this.capsuleColor;
            if (strArr != null && strArr.length > 0) {
                int i5 = 0;
                int iComputeStringSizeNoTag = 0;
                int i6 = 0;
                while (true) {
                    String[] strArr2 = this.capsuleColor;
                    if (i5 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i5];
                    if (str != null) {
                        i6++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i6 * 1);
            }
            if (!this.iconBorderColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.iconBorderColor);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.bgPictV2;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.bgPictV2;
                    if (i2 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, picUrl3);
                    }
                    i2++;
                }
            }
            return !this.fontColorV2.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.fontColorV2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveTreasureBoxShowPage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.type = int32;
                    }
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.bgPict;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.bgPict, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.bgPict = picUrlArr2;
                } else if (tag == 34) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr3 = this.iconPict;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.iconPict, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.iconPict = picUrlArr4;
                } else if (tag == 42) {
                    this.contentText = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.fontColor = codedInputByteBufferNano.readString();
                } else if (tag == 58) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    String[] strArr = this.capsuleColor;
                    int length3 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.capsuleColor, 0, strArr2, 0, length3);
                    }
                    while (length3 < strArr2.length - 1) {
                        strArr2[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr2[length3] = codedInputByteBufferNano.readString();
                    this.capsuleColor = strArr2;
                } else if (tag == 66) {
                    this.iconBorderColor = codedInputByteBufferNano.readString();
                } else if (tag == 74) {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    UserInfos.PicUrl[] picUrlArr5 = this.bgPictV2;
                    int length4 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.bgPictV2, 0, picUrlArr6, 0, length4);
                    }
                    while (length4 < picUrlArr6.length - 1) {
                        picUrlArr6[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr6[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                    this.bgPictV2 = picUrlArr6;
                } else if (tag != 82) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.fontColorV2 = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveTreasureBoxShowPage parseFrom(byte[] bArr) {
            return (LiveTreasureBoxShowPage) MessageNano.mergeFrom(new LiveTreasureBoxShowPage(), bArr);
        }

        public static LiveTreasureBoxShowPage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveTreasureBoxShowPage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveTreasureBoxShow extends MessageNano {
        private static volatile LiveTreasureBoxShow[] _emptyArray;
        public String appendDesc;
        public String appendRouteUrl;
        public int authorMaxAutoShowTimes;
        public long autoFollowMaxDelayMs;
        public long autoFollowMaxTimeoutMs;
        public boolean autoShow;
        public long autoShowTime;
        public int bizType;
        public int boxType;
        public String clickAvatarUrl;
        public boolean cny24WarmupPrayLeee;
        public UserInfos.PicUrl[] contributorHeadIcon;
        public UserInfos.UserInfo contributorInfo;
        public boolean disableAuthorAutoShow;
        public boolean disableDirectFollow;
        public boolean disableFollowShow;
        public boolean enableAppend;
        public boolean enableContributorDisplay;
        public boolean enableNewStyle;
        public boolean enableTimelyReee;
        public LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig enhancedUiConfig;
        public long[] extraFollowAuthorId;
        public Map<String, String> extraMessage;
        public long grabTime;
        public String grabUrl;
        public boolean isAnchorSkipParticipateFilter;
        public TreasureBoxItem[] item;
        public String itemDescription;
        public String layoutConfig;
        public MagicEffectsInfo magicEffects;
        public int mainPriority;
        public String mergeKey;
        public String preGrabConditionData;
        public int preGrabConditionType;
        public String preconditionExtraInfo;
        public int priority;
        public long queryReserveMaxDelayMs;
        public String redPackName;
        public long reserveRequestMaxDelayMs;
        public String serverExtraInfo;
        public UserInfos.PicUrl[] shadowUrl;
        public long showDeadline;
        public LiveTreasureBoxShowPage[] showPage;
        public LiveRedPackSkinMessage.RedPackSkinTheme skinTheme;
        public long startShowPendantTime;
        public long startShowTime;
        public String tokenRequestExtraInfo;
        public String tokenUrl;
        public String topLuckyUrl;
        public long totalKsCoin;
        public String treasureBoxId;
        public String uiConfig;
        public String unShowMessage;
        public UserInfos.UserInfo userInfo;
        public String warmupResourceUrl;

        @Retention(RetentionPolicy.SOURCE)
        public @interface PreGrabConditionType {
            public static final int FOLLOW_AND_SEND_COMMENT = 1;
            public static final int MULTI_CONDITION_COMMON = 2;
            public static final int UNKNOWN = 0;
        }

        public static LiveTreasureBoxShow[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveTreasureBoxShow[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveTreasureBoxShow() {
            clear();
        }

        public final LiveTreasureBoxShow clear() {
            this.treasureBoxId = "";
            this.bizType = 0;
            this.boxType = 0;
            this.skinTheme = null;
            this.item = TreasureBoxItem.emptyArray();
            this.totalKsCoin = 0L;
            this.unShowMessage = "";
            this.showPage = LiveTreasureBoxShowPage.emptyArray();
            this.extraMessage = null;
            this.autoShow = false;
            this.showDeadline = 0L;
            this.userInfo = null;
            this.grabTime = 0L;
            this.startShowTime = 0L;
            this.autoShowTime = 0L;
            this.contributorInfo = null;
            this.enableContributorDisplay = false;
            this.shadowUrl = UserInfos.PicUrl.emptyArray();
            this.contributorHeadIcon = UserInfos.PicUrl.emptyArray();
            this.disableAuthorAutoShow = false;
            this.disableDirectFollow = false;
            this.authorMaxAutoShowTimes = 0;
            this.redPackName = "";
            this.startShowPendantTime = 0L;
            this.disableFollowShow = false;
            this.magicEffects = null;
            this.enableAppend = false;
            this.appendDesc = "";
            this.appendRouteUrl = "";
            this.grabUrl = "";
            this.topLuckyUrl = "";
            this.tokenUrl = "";
            this.clickAvatarUrl = "";
            this.queryReserveMaxDelayMs = 0L;
            this.reserveRequestMaxDelayMs = 0L;
            this.preGrabConditionType = 0;
            this.preGrabConditionData = "";
            this.extraFollowAuthorId = WireFormatNano.EMPTY_LONG_ARRAY;
            this.itemDescription = "";
            this.enableNewStyle = false;
            this.priority = 0;
            this.serverExtraInfo = "";
            this.mainPriority = 0;
            this.cny24WarmupPrayLeee = false;
            this.enableTimelyReee = false;
            this.uiConfig = "";
            this.layoutConfig = "";
            this.tokenRequestExtraInfo = "";
            this.preconditionExtraInfo = "";
            this.warmupResourceUrl = "";
            this.isAnchorSkipParticipateFilter = false;
            this.mergeKey = "";
            this.autoFollowMaxDelayMs = 0L;
            this.autoFollowMaxTimeoutMs = 0L;
            this.enhancedUiConfig = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.treasureBoxId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.treasureBoxId);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.boxType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            LiveRedPackSkinMessage.RedPackSkinTheme redPackSkinTheme = this.skinTheme;
            if (redPackSkinTheme != null) {
                codedOutputByteBufferNano.writeMessage(4, redPackSkinTheme);
            }
            TreasureBoxItem[] treasureBoxItemArr = this.item;
            int i3 = 0;
            if (treasureBoxItemArr != null && treasureBoxItemArr.length > 0) {
                int i4 = 0;
                while (true) {
                    TreasureBoxItem[] treasureBoxItemArr2 = this.item;
                    if (i4 >= treasureBoxItemArr2.length) {
                        break;
                    }
                    TreasureBoxItem treasureBoxItem = treasureBoxItemArr2[i4];
                    if (treasureBoxItem != null) {
                        codedOutputByteBufferNano.writeMessage(5, treasureBoxItem);
                    }
                    i4++;
                }
            }
            long j = this.totalKsCoin;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            if (!this.unShowMessage.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.unShowMessage);
            }
            LiveTreasureBoxShowPage[] liveTreasureBoxShowPageArr = this.showPage;
            if (liveTreasureBoxShowPageArr != null && liveTreasureBoxShowPageArr.length > 0) {
                int i5 = 0;
                while (true) {
                    LiveTreasureBoxShowPage[] liveTreasureBoxShowPageArr2 = this.showPage;
                    if (i5 >= liveTreasureBoxShowPageArr2.length) {
                        break;
                    }
                    LiveTreasureBoxShowPage liveTreasureBoxShowPage = liveTreasureBoxShowPageArr2[i5];
                    if (liveTreasureBoxShowPage != null) {
                        codedOutputByteBufferNano.writeMessage(8, liveTreasureBoxShowPage);
                    }
                    i5++;
                }
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 9, 9, 9);
            }
            boolean z = this.autoShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            long j2 = this.showDeadline;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j2);
            }
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(12, userInfo);
            }
            long j3 = this.grabTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeInt64(13, j3);
            }
            long j4 = this.startShowTime;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeInt64(14, j4);
            }
            long j5 = this.autoShowTime;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeInt64(15, j5);
            }
            UserInfos.UserInfo userInfo2 = this.contributorInfo;
            if (userInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(16, userInfo2);
            }
            boolean z2 = this.enableContributorDisplay;
            if (z2) {
                codedOutputByteBufferNano.writeBool(17, z2);
            }
            UserInfos.PicUrl[] picUrlArr = this.shadowUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i6 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.shadowUrl;
                    if (i6 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i6];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(18, picUrl);
                    }
                    i6++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.contributorHeadIcon;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i7 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.contributorHeadIcon;
                    if (i7 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i7];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(19, picUrl2);
                    }
                    i7++;
                }
            }
            boolean z3 = this.disableAuthorAutoShow;
            if (z3) {
                codedOutputByteBufferNano.writeBool(20, z3);
            }
            boolean z4 = this.disableDirectFollow;
            if (z4) {
                codedOutputByteBufferNano.writeBool(21, z4);
            }
            int i8 = this.authorMaxAutoShowTimes;
            if (i8 != 0) {
                codedOutputByteBufferNano.writeUInt32(22, i8);
            }
            if (!this.redPackName.equals("")) {
                codedOutputByteBufferNano.writeString(23, this.redPackName);
            }
            long j6 = this.startShowPendantTime;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeUInt64(24, j6);
            }
            boolean z5 = this.disableFollowShow;
            if (z5) {
                codedOutputByteBufferNano.writeBool(25, z5);
            }
            MagicEffectsInfo magicEffectsInfo = this.magicEffects;
            if (magicEffectsInfo != null) {
                codedOutputByteBufferNano.writeMessage(26, magicEffectsInfo);
            }
            boolean z6 = this.enableAppend;
            if (z6) {
                codedOutputByteBufferNano.writeBool(27, z6);
            }
            if (!this.appendDesc.equals("")) {
                codedOutputByteBufferNano.writeString(28, this.appendDesc);
            }
            if (!this.appendRouteUrl.equals("")) {
                codedOutputByteBufferNano.writeString(29, this.appendRouteUrl);
            }
            if (!this.grabUrl.equals("")) {
                codedOutputByteBufferNano.writeString(30, this.grabUrl);
            }
            if (!this.topLuckyUrl.equals("")) {
                codedOutputByteBufferNano.writeString(31, this.topLuckyUrl);
            }
            if (!this.tokenUrl.equals("")) {
                codedOutputByteBufferNano.writeString(32, this.tokenUrl);
            }
            if (!this.clickAvatarUrl.equals("")) {
                codedOutputByteBufferNano.writeString(33, this.clickAvatarUrl);
            }
            long j7 = this.queryReserveMaxDelayMs;
            if (j7 != 0) {
                codedOutputByteBufferNano.writeUInt64(34, j7);
            }
            long j8 = this.reserveRequestMaxDelayMs;
            if (j8 != 0) {
                codedOutputByteBufferNano.writeUInt64(35, j8);
            }
            int i9 = this.preGrabConditionType;
            if (i9 != 0) {
                codedOutputByteBufferNano.writeInt32(36, i9);
            }
            if (!this.preGrabConditionData.equals("")) {
                codedOutputByteBufferNano.writeString(37, this.preGrabConditionData);
            }
            long[] jArr = this.extraFollowAuthorId;
            if (jArr != null && jArr.length > 0) {
                while (true) {
                    long[] jArr2 = this.extraFollowAuthorId;
                    if (i3 >= jArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt64(38, jArr2[i3]);
                    i3++;
                }
            }
            if (!this.itemDescription.equals("")) {
                codedOutputByteBufferNano.writeString(39, this.itemDescription);
            }
            boolean z7 = this.enableNewStyle;
            if (z7) {
                codedOutputByteBufferNano.writeBool(40, z7);
            }
            int i10 = this.priority;
            if (i10 != 0) {
                codedOutputByteBufferNano.writeUInt32(41, i10);
            }
            if (!this.serverExtraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(42, this.serverExtraInfo);
            }
            int i11 = this.mainPriority;
            if (i11 != 0) {
                codedOutputByteBufferNano.writeUInt32(43, i11);
            }
            boolean z8 = this.cny24WarmupPrayLeee;
            if (z8) {
                codedOutputByteBufferNano.writeBool(44, z8);
            }
            boolean z9 = this.enableTimelyReee;
            if (z9) {
                codedOutputByteBufferNano.writeBool(45, z9);
            }
            if (!this.uiConfig.equals("")) {
                codedOutputByteBufferNano.writeString(46, this.uiConfig);
            }
            if (!this.layoutConfig.equals("")) {
                codedOutputByteBufferNano.writeString(47, this.layoutConfig);
            }
            if (!this.tokenRequestExtraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(48, this.tokenRequestExtraInfo);
            }
            if (!this.preconditionExtraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(49, this.preconditionExtraInfo);
            }
            if (!this.warmupResourceUrl.equals("")) {
                codedOutputByteBufferNano.writeString(50, this.warmupResourceUrl);
            }
            boolean z10 = this.isAnchorSkipParticipateFilter;
            if (z10) {
                codedOutputByteBufferNano.writeBool(51, z10);
            }
            if (!this.mergeKey.equals("")) {
                codedOutputByteBufferNano.writeString(52, this.mergeKey);
            }
            long j9 = this.autoFollowMaxDelayMs;
            if (j9 != 0) {
                codedOutputByteBufferNano.writeUInt64(53, j9);
            }
            long j10 = this.autoFollowMaxTimeoutMs;
            if (j10 != 0) {
                codedOutputByteBufferNano.writeUInt64(54, j10);
            }
            LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig liveLEEEnhancedUiConfig = this.enhancedUiConfig;
            if (liveLEEEnhancedUiConfig != null) {
                codedOutputByteBufferNano.writeMessage(55, liveLEEEnhancedUiConfig);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            long[] jArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.treasureBoxId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.treasureBoxId);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.boxType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            LiveRedPackSkinMessage.RedPackSkinTheme redPackSkinTheme = this.skinTheme;
            if (redPackSkinTheme != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, redPackSkinTheme);
            }
            TreasureBoxItem[] treasureBoxItemArr = this.item;
            int i3 = 0;
            if (treasureBoxItemArr != null && treasureBoxItemArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    TreasureBoxItem[] treasureBoxItemArr2 = this.item;
                    if (i4 >= treasureBoxItemArr2.length) {
                        break;
                    }
                    TreasureBoxItem treasureBoxItem = treasureBoxItemArr2[i4];
                    if (treasureBoxItem != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, treasureBoxItem);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            long j = this.totalKsCoin;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            if (!this.unShowMessage.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.unShowMessage);
            }
            LiveTreasureBoxShowPage[] liveTreasureBoxShowPageArr = this.showPage;
            if (liveTreasureBoxShowPageArr != null && liveTreasureBoxShowPageArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    LiveTreasureBoxShowPage[] liveTreasureBoxShowPageArr2 = this.showPage;
                    if (i5 >= liveTreasureBoxShowPageArr2.length) {
                        break;
                    }
                    LiveTreasureBoxShowPage liveTreasureBoxShowPage = liveTreasureBoxShowPageArr2[i5];
                    if (liveTreasureBoxShowPage != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(8, liveTreasureBoxShowPage);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 9, 9, 9);
            }
            boolean z = this.autoShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            long j2 = this.showDeadline;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j2);
            }
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, userInfo);
            }
            long j3 = this.grabTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(13, j3);
            }
            long j4 = this.startShowTime;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(14, j4);
            }
            long j5 = this.autoShowTime;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(15, j5);
            }
            UserInfos.UserInfo userInfo2 = this.contributorInfo;
            if (userInfo2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, userInfo2);
            }
            boolean z2 = this.enableContributorDisplay;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z2);
            }
            UserInfos.PicUrl[] picUrlArr = this.shadowUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.shadowUrl;
                    if (i6 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i6];
                    if (picUrl != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(18, picUrl);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.contributorHeadIcon;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i7 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.contributorHeadIcon;
                    if (i7 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i7];
                    if (picUrl2 != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(19, picUrl2);
                    }
                    i7++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            boolean z3 = this.disableAuthorAutoShow;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(20, z3);
            }
            boolean z4 = this.disableDirectFollow;
            if (z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(21, z4);
            }
            int i8 = this.authorMaxAutoShowTimes;
            if (i8 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(22, i8);
            }
            if (!this.redPackName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.redPackName);
            }
            long j6 = this.startShowPendantTime;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(24, j6);
            }
            boolean z5 = this.disableFollowShow;
            if (z5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(25, z5);
            }
            MagicEffectsInfo magicEffectsInfo = this.magicEffects;
            if (magicEffectsInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(26, magicEffectsInfo);
            }
            boolean z6 = this.enableAppend;
            if (z6) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(27, z6);
            }
            if (!this.appendDesc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(28, this.appendDesc);
            }
            if (!this.appendRouteUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, this.appendRouteUrl);
            }
            if (!this.grabUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(30, this.grabUrl);
            }
            if (!this.topLuckyUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(31, this.topLuckyUrl);
            }
            if (!this.tokenUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(32, this.tokenUrl);
            }
            if (!this.clickAvatarUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(33, this.clickAvatarUrl);
            }
            long j7 = this.queryReserveMaxDelayMs;
            if (j7 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(34, j7);
            }
            long j8 = this.reserveRequestMaxDelayMs;
            if (j8 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(35, j8);
            }
            int i9 = this.preGrabConditionType;
            if (i9 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(36, i9);
            }
            if (!this.preGrabConditionData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(37, this.preGrabConditionData);
            }
            long[] jArr2 = this.extraFollowAuthorId;
            if (jArr2 != null && jArr2.length > 0) {
                int iComputeInt64SizeNoTag = 0;
                while (true) {
                    jArr = this.extraFollowAuthorId;
                    if (i3 >= jArr.length) {
                        break;
                    }
                    iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeInt64SizeNoTag(jArr[i3]);
                    i3++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt64SizeNoTag + (jArr.length * 2);
            }
            if (!this.itemDescription.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(39, this.itemDescription);
            }
            boolean z7 = this.enableNewStyle;
            if (z7) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(40, z7);
            }
            int i10 = this.priority;
            if (i10 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(41, i10);
            }
            if (!this.serverExtraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(42, this.serverExtraInfo);
            }
            int i11 = this.mainPriority;
            if (i11 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(43, i11);
            }
            boolean z8 = this.cny24WarmupPrayLeee;
            if (z8) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(44, z8);
            }
            boolean z9 = this.enableTimelyReee;
            if (z9) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(45, z9);
            }
            if (!this.uiConfig.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(46, this.uiConfig);
            }
            if (!this.layoutConfig.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(47, this.layoutConfig);
            }
            if (!this.tokenRequestExtraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(48, this.tokenRequestExtraInfo);
            }
            if (!this.preconditionExtraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(49, this.preconditionExtraInfo);
            }
            if (!this.warmupResourceUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(50, this.warmupResourceUrl);
            }
            boolean z10 = this.isAnchorSkipParticipateFilter;
            if (z10) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(51, z10);
            }
            if (!this.mergeKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(52, this.mergeKey);
            }
            long j9 = this.autoFollowMaxDelayMs;
            if (j9 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(53, j9);
            }
            long j10 = this.autoFollowMaxTimeoutMs;
            if (j10 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(54, j10);
            }
            LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig liveLEEEnhancedUiConfig = this.enhancedUiConfig;
            return liveLEEEnhancedUiConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(55, liveLEEEnhancedUiConfig) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveTreasureBoxShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.treasureBoxId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.bizType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        this.boxType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 34:
                        if (this.skinTheme == null) {
                            this.skinTheme = new LiveRedPackSkinMessage.RedPackSkinTheme();
                        }
                        codedInputByteBufferNano.readMessage(this.skinTheme);
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        TreasureBoxItem[] treasureBoxItemArr = this.item;
                        int length = treasureBoxItemArr == null ? 0 : treasureBoxItemArr.length;
                        TreasureBoxItem[] treasureBoxItemArr2 = new TreasureBoxItem[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.item, 0, treasureBoxItemArr2, 0, length);
                        }
                        while (length < treasureBoxItemArr2.length - 1) {
                            treasureBoxItemArr2[length] = new TreasureBoxItem();
                            codedInputByteBufferNano.readMessage(treasureBoxItemArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        treasureBoxItemArr2[length] = new TreasureBoxItem();
                        codedInputByteBufferNano.readMessage(treasureBoxItemArr2[length]);
                        this.item = treasureBoxItemArr2;
                        break;
                    case 48:
                        this.totalKsCoin = codedInputByteBufferNano.readUInt64();
                        break;
                    case 58:
                        this.unShowMessage = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        LiveTreasureBoxShowPage[] liveTreasureBoxShowPageArr = this.showPage;
                        int length2 = liveTreasureBoxShowPageArr == null ? 0 : liveTreasureBoxShowPageArr.length;
                        LiveTreasureBoxShowPage[] liveTreasureBoxShowPageArr2 = new LiveTreasureBoxShowPage[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.showPage, 0, liveTreasureBoxShowPageArr2, 0, length2);
                        }
                        while (length2 < liveTreasureBoxShowPageArr2.length - 1) {
                            liveTreasureBoxShowPageArr2[length2] = new LiveTreasureBoxShowPage();
                            codedInputByteBufferNano.readMessage(liveTreasureBoxShowPageArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        liveTreasureBoxShowPageArr2[length2] = new LiveTreasureBoxShowPage();
                        codedInputByteBufferNano.readMessage(liveTreasureBoxShowPageArr2[length2]);
                        this.showPage = liveTreasureBoxShowPageArr2;
                        break;
                    case 74:
                        this.extraMessage = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMessage, mapFactory, 9, 9, null, 10, 18);
                        break;
                    case 80:
                        this.autoShow = codedInputByteBufferNano.readBool();
                        break;
                    case 88:
                        this.showDeadline = codedInputByteBufferNano.readUInt64();
                        break;
                    case 98:
                        if (this.userInfo == null) {
                            this.userInfo = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.userInfo);
                        break;
                    case 104:
                        this.grabTime = codedInputByteBufferNano.readInt64();
                        break;
                    case 112:
                        this.startShowTime = codedInputByteBufferNano.readInt64();
                        break;
                    case 120:
                        this.autoShowTime = codedInputByteBufferNano.readInt64();
                        break;
                    case 130:
                        if (this.contributorInfo == null) {
                            this.contributorInfo = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.contributorInfo);
                        break;
                    case 136:
                        this.enableContributorDisplay = codedInputByteBufferNano.readBool();
                        break;
                    case 146:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                        UserInfos.PicUrl[] picUrlArr = this.shadowUrl;
                        int length3 = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.shadowUrl, 0, picUrlArr2, 0, length3);
                        }
                        while (length3 < picUrlArr2.length - 1) {
                            picUrlArr2[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr2[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                        this.shadowUrl = picUrlArr2;
                        break;
                    case 154:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 154);
                        UserInfos.PicUrl[] picUrlArr3 = this.contributorHeadIcon;
                        int length4 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.contributorHeadIcon, 0, picUrlArr4, 0, length4);
                        }
                        while (length4 < picUrlArr4.length - 1) {
                            picUrlArr4[length4] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        picUrlArr4[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length4]);
                        this.contributorHeadIcon = picUrlArr4;
                        break;
                    case 160:
                        this.disableAuthorAutoShow = codedInputByteBufferNano.readBool();
                        break;
                    case 168:
                        this.disableDirectFollow = codedInputByteBufferNano.readBool();
                        break;
                    case 176:
                        this.authorMaxAutoShowTimes = codedInputByteBufferNano.readUInt32();
                        break;
                    case 186:
                        this.redPackName = codedInputByteBufferNano.readString();
                        break;
                    case 192:
                        this.startShowPendantTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 200:
                        this.disableFollowShow = codedInputByteBufferNano.readBool();
                        break;
                    case 210:
                        if (this.magicEffects == null) {
                            this.magicEffects = new MagicEffectsInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.magicEffects);
                        break;
                    case 216:
                        this.enableAppend = codedInputByteBufferNano.readBool();
                        break;
                    case 226:
                        this.appendDesc = codedInputByteBufferNano.readString();
                        break;
                    case 234:
                        this.appendRouteUrl = codedInputByteBufferNano.readString();
                        break;
                    case 242:
                        this.grabUrl = codedInputByteBufferNano.readString();
                        break;
                    case 250:
                        this.topLuckyUrl = codedInputByteBufferNano.readString();
                        break;
                    case 258:
                        this.tokenUrl = codedInputByteBufferNano.readString();
                        break;
                    case 266:
                        this.clickAvatarUrl = codedInputByteBufferNano.readString();
                        break;
                    case 272:
                        this.queryReserveMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 280:
                        this.reserveRequestMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 288:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            break;
                        } else {
                            this.preGrabConditionType = int32;
                            break;
                        }
                        break;
                    case 298:
                        this.preGrabConditionData = codedInputByteBufferNano.readString();
                        break;
                    case 304:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 304);
                        long[] jArr = this.extraFollowAuthorId;
                        int length5 = jArr == null ? 0 : jArr.length;
                        long[] jArr2 = new long[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.extraFollowAuthorId, 0, jArr2, 0, length5);
                        }
                        while (length5 < jArr2.length - 1) {
                            jArr2[length5] = codedInputByteBufferNano.readInt64();
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        jArr2[length5] = codedInputByteBufferNano.readInt64();
                        this.extraFollowAuthorId = jArr2;
                        break;
                    case 306:
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt64();
                            i++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        long[] jArr3 = this.extraFollowAuthorId;
                        int length6 = jArr3 == null ? 0 : jArr3.length;
                        long[] jArr4 = new long[i + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.extraFollowAuthorId, 0, jArr4, 0, length6);
                        }
                        while (length6 < jArr4.length) {
                            jArr4[length6] = codedInputByteBufferNano.readInt64();
                            length6++;
                        }
                        this.extraFollowAuthorId = jArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                        break;
                    case 314:
                        this.itemDescription = codedInputByteBufferNano.readString();
                        break;
                    case 320:
                        this.enableNewStyle = codedInputByteBufferNano.readBool();
                        break;
                    case 328:
                        this.priority = codedInputByteBufferNano.readUInt32();
                        break;
                    case 338:
                        this.serverExtraInfo = codedInputByteBufferNano.readString();
                        break;
                    case 344:
                        this.mainPriority = codedInputByteBufferNano.readUInt32();
                        break;
                    case 352:
                        this.cny24WarmupPrayLeee = codedInputByteBufferNano.readBool();
                        break;
                    case 360:
                        this.enableTimelyReee = codedInputByteBufferNano.readBool();
                        break;
                    case 370:
                        this.uiConfig = codedInputByteBufferNano.readString();
                        break;
                    case 378:
                        this.layoutConfig = codedInputByteBufferNano.readString();
                        break;
                    case 386:
                        this.tokenRequestExtraInfo = codedInputByteBufferNano.readString();
                        break;
                    case 394:
                        this.preconditionExtraInfo = codedInputByteBufferNano.readString();
                        break;
                    case 402:
                        this.warmupResourceUrl = codedInputByteBufferNano.readString();
                        break;
                    case 408:
                        this.isAnchorSkipParticipateFilter = codedInputByteBufferNano.readBool();
                        break;
                    case 418:
                        this.mergeKey = codedInputByteBufferNano.readString();
                        break;
                    case 424:
                        this.autoFollowMaxDelayMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case 432:
                        this.autoFollowMaxTimeoutMs = codedInputByteBufferNano.readUInt64();
                        break;
                    case SocketMessages.PayloadType.SC_BET_CLOSED /* 442 */:
                        if (this.enhancedUiConfig == null) {
                            this.enhancedUiConfig = new LiveCustomRedPackSkinMessage.LiveLEEEnhancedUiConfig();
                        }
                        codedInputByteBufferNano.readMessage(this.enhancedUiConfig);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveTreasureBoxShow parseFrom(byte[] bArr) {
            return (LiveTreasureBoxShow) MessageNano.mergeFrom(new LiveTreasureBoxShow(), bArr);
        }

        public static LiveTreasureBoxShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveTreasureBoxShow().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveTreasureBoxShow extends MessageNano {
        private static volatile SCLiveTreasureBoxShow[] _emptyArray;
        public LiveTreasureBoxShow[] show;

        public static SCLiveTreasureBoxShow[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveTreasureBoxShow[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveTreasureBoxShow() {
            clear();
        }

        public final SCLiveTreasureBoxShow clear() {
            this.show = LiveTreasureBoxShow.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveTreasureBoxShow[] liveTreasureBoxShowArr = this.show;
            if (liveTreasureBoxShowArr != null && liveTreasureBoxShowArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveTreasureBoxShow[] liveTreasureBoxShowArr2 = this.show;
                    if (i >= liveTreasureBoxShowArr2.length) {
                        break;
                    }
                    LiveTreasureBoxShow liveTreasureBoxShow = liveTreasureBoxShowArr2[i];
                    if (liveTreasureBoxShow != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveTreasureBoxShow);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveTreasureBoxShow[] liveTreasureBoxShowArr = this.show;
            if (liveTreasureBoxShowArr != null && liveTreasureBoxShowArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveTreasureBoxShow[] liveTreasureBoxShowArr2 = this.show;
                    if (i >= liveTreasureBoxShowArr2.length) {
                        break;
                    }
                    LiveTreasureBoxShow liveTreasureBoxShow = liveTreasureBoxShowArr2[i];
                    if (liveTreasureBoxShow != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveTreasureBoxShow);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveTreasureBoxShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveTreasureBoxShow[] liveTreasureBoxShowArr = this.show;
                    int length = liveTreasureBoxShowArr == null ? 0 : liveTreasureBoxShowArr.length;
                    LiveTreasureBoxShow[] liveTreasureBoxShowArr2 = new LiveTreasureBoxShow[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.show, 0, liveTreasureBoxShowArr2, 0, length);
                    }
                    while (length < liveTreasureBoxShowArr2.length - 1) {
                        liveTreasureBoxShowArr2[length] = new LiveTreasureBoxShow();
                        codedInputByteBufferNano.readMessage(liveTreasureBoxShowArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveTreasureBoxShowArr2[length] = new LiveTreasureBoxShow();
                    codedInputByteBufferNano.readMessage(liveTreasureBoxShowArr2[length]);
                    this.show = liveTreasureBoxShowArr2;
                }
            }
        }

        public static SCLiveTreasureBoxShow parseFrom(byte[] bArr) {
            return (SCLiveTreasureBoxShow) MessageNano.mergeFrom(new SCLiveTreasureBoxShow(), bArr);
        }

        public static SCLiveTreasureBoxShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveTreasureBoxShow().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MagicEffectsInfo extends MessageNano {
        private static volatile MagicEffectsInfo[] _emptyArray;
        public boolean cannotBeBreak;
        public boolean isDisplayImmediately;
        public String magicEffectKey;
        public int rank;

        public static MagicEffectsInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MagicEffectsInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MagicEffectsInfo() {
            clear();
        }

        public final MagicEffectsInfo clear() {
            this.magicEffectKey = "";
            this.rank = 0;
            this.cannotBeBreak = false;
            this.isDisplayImmediately = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.magicEffectKey.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.magicEffectKey);
            }
            int i = this.rank;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            boolean z = this.cannotBeBreak;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            boolean z2 = this.isDisplayImmediately;
            if (z2) {
                codedOutputByteBufferNano.writeBool(4, z2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.magicEffectKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.magicEffectKey);
            }
            int i = this.rank;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            boolean z = this.cannotBeBreak;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            boolean z2 = this.isDisplayImmediately;
            return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MagicEffectsInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.magicEffectKey = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.rank = codedInputByteBufferNano.readInt32();
                } else if (tag == 24) {
                    this.cannotBeBreak = codedInputByteBufferNano.readBool();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.isDisplayImmediately = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static MagicEffectsInfo parseFrom(byte[] bArr) {
            return (MagicEffectsInfo) MessageNano.mergeFrom(new MagicEffectsInfo(), bArr);
        }

        public static MagicEffectsInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MagicEffectsInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveTreasureBoxClose extends MessageNano {
        private static volatile LiveTreasureBoxClose[] _emptyArray;
        public int bizType;
        public int boxType;
        public String treasureBoxId;

        public static LiveTreasureBoxClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveTreasureBoxClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveTreasureBoxClose() {
            clear();
        }

        public final LiveTreasureBoxClose clear() {
            this.treasureBoxId = "";
            this.bizType = 0;
            this.boxType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.treasureBoxId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.treasureBoxId);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.boxType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.treasureBoxId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.treasureBoxId);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.boxType;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveTreasureBoxClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.treasureBoxId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.bizType = codedInputByteBufferNano.readUInt32();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.boxType = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveTreasureBoxClose parseFrom(byte[] bArr) {
            return (LiveTreasureBoxClose) MessageNano.mergeFrom(new LiveTreasureBoxClose(), bArr);
        }

        public static LiveTreasureBoxClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveTreasureBoxClose().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveTreasureBoxClose extends MessageNano {
        private static volatile SCLiveTreasureBoxClose[] _emptyArray;
        public LiveTreasureBoxClose[] close;

        public static SCLiveTreasureBoxClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveTreasureBoxClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveTreasureBoxClose() {
            clear();
        }

        public final SCLiveTreasureBoxClose clear() {
            this.close = LiveTreasureBoxClose.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveTreasureBoxClose[] liveTreasureBoxCloseArr = this.close;
            if (liveTreasureBoxCloseArr != null && liveTreasureBoxCloseArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveTreasureBoxClose[] liveTreasureBoxCloseArr2 = this.close;
                    if (i >= liveTreasureBoxCloseArr2.length) {
                        break;
                    }
                    LiveTreasureBoxClose liveTreasureBoxClose = liveTreasureBoxCloseArr2[i];
                    if (liveTreasureBoxClose != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveTreasureBoxClose);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveTreasureBoxClose[] liveTreasureBoxCloseArr = this.close;
            if (liveTreasureBoxCloseArr != null && liveTreasureBoxCloseArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveTreasureBoxClose[] liveTreasureBoxCloseArr2 = this.close;
                    if (i >= liveTreasureBoxCloseArr2.length) {
                        break;
                    }
                    LiveTreasureBoxClose liveTreasureBoxClose = liveTreasureBoxCloseArr2[i];
                    if (liveTreasureBoxClose != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveTreasureBoxClose);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveTreasureBoxClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveTreasureBoxClose[] liveTreasureBoxCloseArr = this.close;
                    int length = liveTreasureBoxCloseArr == null ? 0 : liveTreasureBoxCloseArr.length;
                    LiveTreasureBoxClose[] liveTreasureBoxCloseArr2 = new LiveTreasureBoxClose[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.close, 0, liveTreasureBoxCloseArr2, 0, length);
                    }
                    while (length < liveTreasureBoxCloseArr2.length - 1) {
                        liveTreasureBoxCloseArr2[length] = new LiveTreasureBoxClose();
                        codedInputByteBufferNano.readMessage(liveTreasureBoxCloseArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveTreasureBoxCloseArr2[length] = new LiveTreasureBoxClose();
                    codedInputByteBufferNano.readMessage(liveTreasureBoxCloseArr2[length]);
                    this.close = liveTreasureBoxCloseArr2;
                }
            }
        }

        public static SCLiveTreasureBoxClose parseFrom(byte[] bArr) {
            return (SCLiveTreasureBoxClose) MessageNano.mergeFrom(new SCLiveTreasureBoxClose(), bArr);
        }

        public static SCLiveTreasureBoxClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveTreasureBoxClose().mergeFrom(codedInputByteBufferNano);
        }
    }
}
