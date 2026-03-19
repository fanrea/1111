package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveKrnRedPackMessage {

    public static final class LiveKrnRedPack extends MessageNano {
        private static volatile LiveKrnRedPack[] _emptyArray;
        public String bundleId;
        public String componentName;
        public Map<String, String> extraMessage;
        public String followBizCustomParams;
        public long grabTime;
        public String kwaiUrl;
        public String place;
        public UserInfos.UserInfo receiverInfo;
        public String redPackId;
        public int redPackType;
        public long senderId;
        public UserInfos.UserInfo senderInfo;
        public long showDeadline;
        public LiveKrnRedPackShowPage[] showPage;
        public long showTime;
        public long totalKsCoin;
        public String transparent;

        public static LiveKrnRedPack[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveKrnRedPack[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveKrnRedPack() {
            clear();
        }

        public final LiveKrnRedPack clear() {
            this.redPackId = "";
            this.senderId = 0L;
            this.redPackType = 0;
            this.kwaiUrl = "";
            this.showTime = 0L;
            this.showDeadline = 0L;
            this.grabTime = 0L;
            this.showPage = LiveKrnRedPackShowPage.emptyArray();
            this.extraMessage = null;
            this.bundleId = "";
            this.componentName = "";
            this.senderInfo = null;
            this.receiverInfo = null;
            this.totalKsCoin = 0L;
            this.followBizCustomParams = "";
            this.place = "";
            this.transparent = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.redPackId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.redPackId);
            }
            long j = this.senderId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i = this.redPackType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            if (!this.kwaiUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.kwaiUrl);
            }
            long j2 = this.showTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.showDeadline;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            long j4 = this.grabTime;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j4);
            }
            LiveKrnRedPackShowPage[] liveKrnRedPackShowPageArr = this.showPage;
            if (liveKrnRedPackShowPageArr != null && liveKrnRedPackShowPageArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveKrnRedPackShowPage[] liveKrnRedPackShowPageArr2 = this.showPage;
                    if (i2 >= liveKrnRedPackShowPageArr2.length) {
                        break;
                    }
                    LiveKrnRedPackShowPage liveKrnRedPackShowPage = liveKrnRedPackShowPageArr2[i2];
                    if (liveKrnRedPackShowPage != null) {
                        codedOutputByteBufferNano.writeMessage(8, liveKrnRedPackShowPage);
                    }
                    i2++;
                }
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 9, 9, 9);
            }
            if (!this.bundleId.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.bundleId);
            }
            if (!this.componentName.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.componentName);
            }
            UserInfos.UserInfo userInfo = this.senderInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(12, userInfo);
            }
            UserInfos.UserInfo userInfo2 = this.receiverInfo;
            if (userInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(13, userInfo2);
            }
            long j5 = this.totalKsCoin;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(14, j5);
            }
            if (!this.followBizCustomParams.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.followBizCustomParams);
            }
            if (!this.place.equals("")) {
                codedOutputByteBufferNano.writeString(16, this.place);
            }
            if (!this.transparent.equals("")) {
                codedOutputByteBufferNano.writeString(17, this.transparent);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.redPackId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.redPackId);
            }
            long j = this.senderId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i = this.redPackType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            if (!this.kwaiUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.kwaiUrl);
            }
            long j2 = this.showTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.showDeadline;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
            }
            long j4 = this.grabTime;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j4);
            }
            LiveKrnRedPackShowPage[] liveKrnRedPackShowPageArr = this.showPage;
            if (liveKrnRedPackShowPageArr != null && liveKrnRedPackShowPageArr.length > 0) {
                int i2 = 0;
                while (true) {
                    LiveKrnRedPackShowPage[] liveKrnRedPackShowPageArr2 = this.showPage;
                    if (i2 >= liveKrnRedPackShowPageArr2.length) {
                        break;
                    }
                    LiveKrnRedPackShowPage liveKrnRedPackShowPage = liveKrnRedPackShowPageArr2[i2];
                    if (liveKrnRedPackShowPage != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveKrnRedPackShowPage);
                    }
                    i2++;
                }
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 9, 9, 9);
            }
            if (!this.bundleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.bundleId);
            }
            if (!this.componentName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.componentName);
            }
            UserInfos.UserInfo userInfo = this.senderInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, userInfo);
            }
            UserInfos.UserInfo userInfo2 = this.receiverInfo;
            if (userInfo2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, userInfo2);
            }
            long j5 = this.totalKsCoin;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j5);
            }
            if (!this.followBizCustomParams.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.followBizCustomParams);
            }
            if (!this.place.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.place);
            }
            return !this.transparent.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(17, this.transparent) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveKrnRedPack mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.redPackId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.senderId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 24:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2) {
                            switch (int32) {
                            }
                        }
                        this.redPackType = int32;
                        break;
                    case 34:
                        this.kwaiUrl = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.showTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 48:
                        this.showDeadline = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.grabTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 66:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        LiveKrnRedPackShowPage[] liveKrnRedPackShowPageArr = this.showPage;
                        int length = liveKrnRedPackShowPageArr == null ? 0 : liveKrnRedPackShowPageArr.length;
                        LiveKrnRedPackShowPage[] liveKrnRedPackShowPageArr2 = new LiveKrnRedPackShowPage[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.showPage, 0, liveKrnRedPackShowPageArr2, 0, length);
                        }
                        while (length < liveKrnRedPackShowPageArr2.length - 1) {
                            liveKrnRedPackShowPageArr2[length] = new LiveKrnRedPackShowPage();
                            codedInputByteBufferNano.readMessage(liveKrnRedPackShowPageArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveKrnRedPackShowPageArr2[length] = new LiveKrnRedPackShowPage();
                        codedInputByteBufferNano.readMessage(liveKrnRedPackShowPageArr2[length]);
                        this.showPage = liveKrnRedPackShowPageArr2;
                        break;
                    case 74:
                        this.extraMessage = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMessage, mapFactory, 9, 9, null, 10, 18);
                        break;
                    case 82:
                        this.bundleId = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.componentName = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        if (this.senderInfo == null) {
                            this.senderInfo = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.senderInfo);
                        break;
                    case 106:
                        if (this.receiverInfo == null) {
                            this.receiverInfo = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.receiverInfo);
                        break;
                    case 112:
                        this.totalKsCoin = codedInputByteBufferNano.readUInt64();
                        break;
                    case 122:
                        this.followBizCustomParams = codedInputByteBufferNano.readString();
                        break;
                    case 130:
                        this.place = codedInputByteBufferNano.readString();
                        break;
                    case 138:
                        this.transparent = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveKrnRedPack parseFrom(byte[] bArr) {
            return (LiveKrnRedPack) MessageNano.mergeFrom(new LiveKrnRedPack(), bArr);
        }

        public static LiveKrnRedPack parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveKrnRedPack().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveKrnRedPackShowPage extends MessageNano {
        private static volatile LiveKrnRedPackShowPage[] _emptyArray;
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

        public static LiveKrnRedPackShowPage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveKrnRedPackShowPage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveKrnRedPackShowPage() {
            clear();
        }

        public final LiveKrnRedPackShowPage clear() {
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
        public final LiveKrnRedPackShowPage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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

        public static LiveKrnRedPackShowPage parseFrom(byte[] bArr) {
            return (LiveKrnRedPackShowPage) MessageNano.mergeFrom(new LiveKrnRedPackShowPage(), bArr);
        }

        public static LiveKrnRedPackShowPage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveKrnRedPackShowPage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveKrnRedPackShow extends MessageNano {
        private static volatile SCLiveKrnRedPackShow[] _emptyArray;
        public LiveKrnRedPack[] redPack;

        public static SCLiveKrnRedPackShow[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveKrnRedPackShow[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveKrnRedPackShow() {
            clear();
        }

        public final SCLiveKrnRedPackShow clear() {
            this.redPack = LiveKrnRedPack.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveKrnRedPack[] liveKrnRedPackArr = this.redPack;
            if (liveKrnRedPackArr != null && liveKrnRedPackArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveKrnRedPack[] liveKrnRedPackArr2 = this.redPack;
                    if (i >= liveKrnRedPackArr2.length) {
                        break;
                    }
                    LiveKrnRedPack liveKrnRedPack = liveKrnRedPackArr2[i];
                    if (liveKrnRedPack != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveKrnRedPack);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveKrnRedPack[] liveKrnRedPackArr = this.redPack;
            if (liveKrnRedPackArr != null && liveKrnRedPackArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveKrnRedPack[] liveKrnRedPackArr2 = this.redPack;
                    if (i >= liveKrnRedPackArr2.length) {
                        break;
                    }
                    LiveKrnRedPack liveKrnRedPack = liveKrnRedPackArr2[i];
                    if (liveKrnRedPack != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveKrnRedPack);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveKrnRedPackShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveKrnRedPack[] liveKrnRedPackArr = this.redPack;
                    int length = liveKrnRedPackArr == null ? 0 : liveKrnRedPackArr.length;
                    LiveKrnRedPack[] liveKrnRedPackArr2 = new LiveKrnRedPack[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.redPack, 0, liveKrnRedPackArr2, 0, length);
                    }
                    while (length < liveKrnRedPackArr2.length - 1) {
                        liveKrnRedPackArr2[length] = new LiveKrnRedPack();
                        codedInputByteBufferNano.readMessage(liveKrnRedPackArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveKrnRedPackArr2[length] = new LiveKrnRedPack();
                    codedInputByteBufferNano.readMessage(liveKrnRedPackArr2[length]);
                    this.redPack = liveKrnRedPackArr2;
                }
            }
        }

        public static SCLiveKrnRedPackShow parseFrom(byte[] bArr) {
            return (SCLiveKrnRedPackShow) MessageNano.mergeFrom(new SCLiveKrnRedPackShow(), bArr);
        }

        public static SCLiveKrnRedPackShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveKrnRedPackShow().mergeFrom(codedInputByteBufferNano);
        }
    }
}
