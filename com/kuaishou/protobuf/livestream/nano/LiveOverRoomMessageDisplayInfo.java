package com.kuaishou.protobuf.livestream.nano;

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
public final class LiveOverRoomMessageDisplayInfo extends MessageNano {
    private static volatile LiveOverRoomMessageDisplayInfo[] _emptyArray;
    public long backgroundDuration;
    public String[] backgroundWebp;
    public String[] backgroundWebpV2;
    public int bizTypeValue;
    public String broadcastInfo;
    public String defaultPreloadAfterFileName;
    public String defaultPreloadBeforeFileName;
    public long displayDuration;
    public String displayText;
    public int displayType;
    public String[] displayUrl;
    public boolean enableBackgroundWebpV2;
    public boolean enableDisplayLiveIcon;
    public boolean enableHeadIconInCircle;
    public boolean enablePreload;
    public String exptag;
    public Map<String, String> extraMessage;
    public UserInfos.PicUrl[] headUrl;
    public String[] iconUrl;
    public String link;
    public String linkV2;
    public String noticeText;
    public String preloadAfterFileName;
    public String preloadBeforeFileName;
    public String roomOpenUrl;
    public String serverExpTag;
    public String toLiveStreamId;
    public String userName;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisplayType {
        public static final int GIF = 2;
        public static final int LOTTIE = 4;
        public static final int PNG = 3;
        public static final int UNKNOWN = 0;
        public static final int WEBP = 1;
    }

    public static LiveOverRoomMessageDisplayInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveOverRoomMessageDisplayInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveOverRoomMessageDisplayInfo() {
        clear();
    }

    public final LiveOverRoomMessageDisplayInfo clear() {
        this.displayType = 0;
        this.displayUrl = WireFormatNano.EMPTY_STRING_ARRAY;
        this.displayText = "";
        this.displayDuration = 0L;
        this.iconUrl = WireFormatNano.EMPTY_STRING_ARRAY;
        this.noticeText = "";
        this.backgroundWebp = WireFormatNano.EMPTY_STRING_ARRAY;
        this.backgroundDuration = 0L;
        this.link = "";
        this.userName = "";
        this.exptag = "";
        this.toLiveStreamId = "";
        this.broadcastInfo = "";
        this.bizTypeValue = 0;
        this.serverExpTag = "";
        this.extraMessage = null;
        this.enableDisplayLiveIcon = false;
        this.linkV2 = "";
        this.enableHeadIconInCircle = false;
        this.headUrl = UserInfos.PicUrl.emptyArray();
        this.backgroundWebpV2 = WireFormatNano.EMPTY_STRING_ARRAY;
        this.enableBackgroundWebpV2 = false;
        this.enablePreload = false;
        this.preloadBeforeFileName = "";
        this.defaultPreloadBeforeFileName = "";
        this.preloadAfterFileName = "";
        this.defaultPreloadAfterFileName = "";
        this.roomOpenUrl = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.displayType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        String[] strArr = this.displayUrl;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.displayUrl;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i3++;
            }
        }
        if (!this.displayText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.displayText);
        }
        long j = this.displayDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        String[] strArr3 = this.iconUrl;
        if (strArr3 != null && strArr3.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr4 = this.iconUrl;
                if (i4 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i4];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(5, str2);
                }
                i4++;
            }
        }
        if (!this.noticeText.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.noticeText);
        }
        String[] strArr5 = this.backgroundWebp;
        if (strArr5 != null && strArr5.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr6 = this.backgroundWebp;
                if (i5 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i5];
                if (str3 != null) {
                    codedOutputByteBufferNano.writeString(7, str3);
                }
                i5++;
            }
        }
        long j2 = this.backgroundDuration;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        if (!this.link.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.link);
        }
        if (!this.userName.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.userName);
        }
        if (!this.exptag.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.exptag);
        }
        if (!this.toLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.toLiveStreamId);
        }
        if (!this.broadcastInfo.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.broadcastInfo);
        }
        int i6 = this.bizTypeValue;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeUInt32(14, i6);
        }
        if (!this.serverExpTag.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.serverExpTag);
        }
        Map<String, String> map = this.extraMessage;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 16, 9, 9);
        }
        boolean z = this.enableDisplayLiveIcon;
        if (z) {
            codedOutputByteBufferNano.writeBool(17, z);
        }
        if (!this.linkV2.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.linkV2);
        }
        boolean z2 = this.enableHeadIconInCircle;
        if (z2) {
            codedOutputByteBufferNano.writeBool(19, z2);
        }
        UserInfos.PicUrl[] picUrlArr = this.headUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i7 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headUrl;
                if (i7 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i7];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(20, picUrl);
                }
                i7++;
            }
        }
        String[] strArr7 = this.backgroundWebpV2;
        if (strArr7 != null && strArr7.length > 0) {
            while (true) {
                String[] strArr8 = this.backgroundWebpV2;
                if (i2 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i2];
                if (str4 != null) {
                    codedOutputByteBufferNano.writeString(21, str4);
                }
                i2++;
            }
        }
        boolean z3 = this.enableBackgroundWebpV2;
        if (z3) {
            codedOutputByteBufferNano.writeBool(22, z3);
        }
        boolean z4 = this.enablePreload;
        if (z4) {
            codedOutputByteBufferNano.writeBool(23, z4);
        }
        if (!this.preloadBeforeFileName.equals("")) {
            codedOutputByteBufferNano.writeString(24, this.preloadBeforeFileName);
        }
        if (!this.defaultPreloadBeforeFileName.equals("")) {
            codedOutputByteBufferNano.writeString(25, this.defaultPreloadBeforeFileName);
        }
        if (!this.preloadAfterFileName.equals("")) {
            codedOutputByteBufferNano.writeString(26, this.preloadAfterFileName);
        }
        if (!this.defaultPreloadAfterFileName.equals("")) {
            codedOutputByteBufferNano.writeString(27, this.defaultPreloadAfterFileName);
        }
        if (!this.roomOpenUrl.equals("")) {
            codedOutputByteBufferNano.writeString(28, this.roomOpenUrl);
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
        String[] strArr = this.displayUrl;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.displayUrl;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i4++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
        }
        if (!this.displayText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayText);
        }
        long j = this.displayDuration;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        String[] strArr3 = this.iconUrl;
        if (strArr3 != null && strArr3.length > 0) {
            int i5 = 0;
            int iComputeStringSizeNoTag2 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr4 = this.iconUrl;
                if (i5 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i5];
                if (str2 != null) {
                    i6++;
                    iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag2 + (i6 * 1);
        }
        if (!this.noticeText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.noticeText);
        }
        String[] strArr5 = this.backgroundWebp;
        if (strArr5 != null && strArr5.length > 0) {
            int i7 = 0;
            int iComputeStringSizeNoTag3 = 0;
            int i8 = 0;
            while (true) {
                String[] strArr6 = this.backgroundWebp;
                if (i7 >= strArr6.length) {
                    break;
                }
                String str3 = strArr6[i7];
                if (str3 != null) {
                    i8++;
                    iComputeStringSizeNoTag3 += CodedOutputByteBufferNano.computeStringSizeNoTag(str3);
                }
                i7++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag3 + (i8 * 1);
        }
        long j2 = this.backgroundDuration;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        if (!this.link.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.link);
        }
        if (!this.userName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.userName);
        }
        if (!this.exptag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.exptag);
        }
        if (!this.toLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.toLiveStreamId);
        }
        if (!this.broadcastInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.broadcastInfo);
        }
        int i9 = this.bizTypeValue;
        if (i9 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(14, i9);
        }
        if (!this.serverExpTag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.serverExpTag);
        }
        Map<String, String> map = this.extraMessage;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 16, 9, 9);
        }
        boolean z = this.enableDisplayLiveIcon;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
        }
        if (!this.linkV2.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.linkV2);
        }
        boolean z2 = this.enableHeadIconInCircle;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(19, z2);
        }
        UserInfos.PicUrl[] picUrlArr = this.headUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i10 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headUrl;
                if (i10 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i10];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(20, picUrl);
                }
                i10++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        String[] strArr7 = this.backgroundWebpV2;
        if (strArr7 != null && strArr7.length > 0) {
            int iComputeStringSizeNoTag4 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr8 = this.backgroundWebpV2;
                if (i2 >= strArr8.length) {
                    break;
                }
                String str4 = strArr8[i2];
                if (str4 != null) {
                    i11++;
                    iComputeStringSizeNoTag4 += CodedOutputByteBufferNano.computeStringSizeNoTag(str4);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag4 + (i11 * 2);
        }
        boolean z3 = this.enableBackgroundWebpV2;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, z3);
        }
        boolean z4 = this.enablePreload;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, z4);
        }
        if (!this.preloadBeforeFileName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(24, this.preloadBeforeFileName);
        }
        if (!this.defaultPreloadBeforeFileName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(25, this.defaultPreloadBeforeFileName);
        }
        if (!this.preloadAfterFileName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(26, this.preloadAfterFileName);
        }
        if (!this.defaultPreloadAfterFileName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(27, this.defaultPreloadAfterFileName);
        }
        return !this.roomOpenUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(28, this.roomOpenUrl) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveOverRoomMessageDisplayInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                        break;
                    } else {
                        this.displayType = int32;
                        break;
                    }
                case 18:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    String[] strArr = this.displayUrl;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.displayUrl, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.displayUrl = strArr2;
                    break;
                case 26:
                    this.displayText = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    this.displayDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    String[] strArr3 = this.iconUrl;
                    int length2 = strArr3 == null ? 0 : strArr3.length;
                    String[] strArr4 = new String[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.iconUrl, 0, strArr4, 0, length2);
                    }
                    while (length2 < strArr4.length - 1) {
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr4[length2] = codedInputByteBufferNano.readString();
                    this.iconUrl = strArr4;
                    break;
                case 50:
                    this.noticeText = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    String[] strArr5 = this.backgroundWebp;
                    int length3 = strArr5 == null ? 0 : strArr5.length;
                    String[] strArr6 = new String[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.backgroundWebp, 0, strArr6, 0, length3);
                    }
                    while (length3 < strArr6.length - 1) {
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr6[length3] = codedInputByteBufferNano.readString();
                    this.backgroundWebp = strArr6;
                    break;
                case 64:
                    this.backgroundDuration = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    this.link = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.userName = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.exptag = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.toLiveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.broadcastInfo = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    this.bizTypeValue = codedInputByteBufferNano.readUInt32();
                    break;
                case 122:
                    this.serverExpTag = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    this.extraMessage = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMessage, mapFactory, 9, 9, null, 10, 18);
                    break;
                case 136:
                    this.enableDisplayLiveIcon = codedInputByteBufferNano.readBool();
                    break;
                case 146:
                    this.linkV2 = codedInputByteBufferNano.readString();
                    break;
                case 152:
                    this.enableHeadIconInCircle = codedInputByteBufferNano.readBool();
                    break;
                case 162:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 162);
                    UserInfos.PicUrl[] picUrlArr = this.headUrl;
                    int length4 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.headUrl, 0, picUrlArr2, 0, length4);
                    }
                    while (length4 < picUrlArr2.length - 1) {
                        picUrlArr2[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr2[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length4]);
                    this.headUrl = picUrlArr2;
                    break;
                case 170:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                    String[] strArr7 = this.backgroundWebpV2;
                    int length5 = strArr7 == null ? 0 : strArr7.length;
                    String[] strArr8 = new String[repeatedFieldArrayLength5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.backgroundWebpV2, 0, strArr8, 0, length5);
                    }
                    while (length5 < strArr8.length - 1) {
                        strArr8[length5] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    strArr8[length5] = codedInputByteBufferNano.readString();
                    this.backgroundWebpV2 = strArr8;
                    break;
                case 176:
                    this.enableBackgroundWebpV2 = codedInputByteBufferNano.readBool();
                    break;
                case 184:
                    this.enablePreload = codedInputByteBufferNano.readBool();
                    break;
                case 194:
                    this.preloadBeforeFileName = codedInputByteBufferNano.readString();
                    break;
                case 202:
                    this.defaultPreloadBeforeFileName = codedInputByteBufferNano.readString();
                    break;
                case 210:
                    this.preloadAfterFileName = codedInputByteBufferNano.readString();
                    break;
                case 218:
                    this.defaultPreloadAfterFileName = codedInputByteBufferNano.readString();
                    break;
                case 226:
                    this.roomOpenUrl = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveOverRoomMessageDisplayInfo parseFrom(byte[] bArr) {
        return (LiveOverRoomMessageDisplayInfo) MessageNano.mergeFrom(new LiveOverRoomMessageDisplayInfo(), bArr);
    }

    public static LiveOverRoomMessageDisplayInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveOverRoomMessageDisplayInfo().mergeFrom(codedInputByteBufferNano);
    }
}
