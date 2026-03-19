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
public final class SCLiveEcoExplainCardSignal extends MessageNano {
    private static volatile SCLiveEcoExplainCardSignal[] _emptyArray;
    public String actionUrl;
    public String bizType;
    public String bundleInfo;
    public ActionInfoProto buttonActionInfo;
    public String buttonText;
    public RequestInfo cardRefreshInfo;
    public int cardStyleType;
    public Map<String, String> clientStatInfo;
    public String ext;
    public String extraInfo;
    public UserInfos.PicUrl[] headUrl;
    public String highlightLabel;
    public String highlightSubLabel;
    public UserInfos.PicUrl[] icon;
    public boolean showClose;
    public int signalType;
    public String title;
    public UserInfos.PicUrl[] topLeftIcon;
    public String topLeftTips;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CardStyleType {
        public static final int CARD_STYLE_EIGHT = 8;
        public static final int CARD_STYLE_FIVE = 5;
        public static final int CARD_STYLE_FOUR = 4;
        public static final int CARD_STYLE_NINE = 9;
        public static final int CARD_STYLE_ONE = 1;
        public static final int CARD_STYLE_SEVEN = 7;
        public static final int CARD_STYLE_SIX = 6;
        public static final int CARD_STYLE_THREE = 3;
        public static final int CARD_STYLE_TWO = 2;
        public static final int UNKNOWN_CARD_STYLE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SignalType {
        public static final int DELETE = 0;
        public static final int SHOW = 1;
        public static final int SHOW_WHITE_BOARD = 2;
    }

    public static SCLiveEcoExplainCardSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveEcoExplainCardSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveEcoExplainCardSignal() {
        clear();
    }

    public final SCLiveEcoExplainCardSignal clear() {
        this.signalType = 0;
        this.title = "";
        this.icon = UserInfos.PicUrl.emptyArray();
        this.actionUrl = "";
        this.buttonText = "";
        this.topLeftTips = "";
        this.topLeftIcon = UserInfos.PicUrl.emptyArray();
        this.showClose = false;
        this.bundleInfo = "";
        this.ext = "";
        this.bizType = "";
        this.highlightLabel = "";
        this.highlightSubLabel = "";
        this.cardStyleType = 0;
        this.headUrl = UserInfos.PicUrl.emptyArray();
        this.buttonActionInfo = null;
        this.cardRefreshInfo = null;
        this.clientStatInfo = null;
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.signalType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.title);
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
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i3++;
            }
        }
        if (!this.actionUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.actionUrl);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.buttonText);
        }
        if (!this.topLeftTips.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.topLeftTips);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.topLeftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.topLeftIcon;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl2);
                }
                i4++;
            }
        }
        boolean z = this.showClose;
        if (z) {
            codedOutputByteBufferNano.writeBool(8, z);
        }
        if (!this.bundleInfo.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.bundleInfo);
        }
        if (!this.ext.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.ext);
        }
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.bizType);
        }
        if (!this.highlightLabel.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.highlightLabel);
        }
        if (!this.highlightSubLabel.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.highlightSubLabel);
        }
        int i5 = this.cardStyleType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(14, i5);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.headUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.headUrl;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(15, picUrl3);
                }
                i2++;
            }
        }
        ActionInfoProto actionInfoProto = this.buttonActionInfo;
        if (actionInfoProto != null) {
            codedOutputByteBufferNano.writeMessage(16, actionInfoProto);
        }
        RequestInfo requestInfo = this.cardRefreshInfo;
        if (requestInfo != null) {
            codedOutputByteBufferNano.writeMessage(18, requestInfo);
        }
        Map<String, String> map = this.clientStatInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 19, 9, 9);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.signalType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
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
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.actionUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.actionUrl);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.buttonText);
        }
        if (!this.topLeftTips.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.topLeftTips);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.topLeftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.topLeftIcon;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(7, picUrl2);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        boolean z = this.showClose;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
        }
        if (!this.bundleInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.bundleInfo);
        }
        if (!this.ext.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.ext);
        }
        if (!this.bizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.bizType);
        }
        if (!this.highlightLabel.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.highlightLabel);
        }
        if (!this.highlightSubLabel.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.highlightSubLabel);
        }
        int i5 = this.cardStyleType;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i5);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.headUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.headUrl;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, picUrl3);
                }
                i2++;
            }
        }
        ActionInfoProto actionInfoProto = this.buttonActionInfo;
        if (actionInfoProto != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, actionInfoProto);
        }
        RequestInfo requestInfo = this.cardRefreshInfo;
        if (requestInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, requestInfo);
        }
        Map<String, String> map = this.clientStatInfo;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 19, 9, 9);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(21, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveEcoExplainCardSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.signalType = int32;
                        break;
                    }
                    break;
                case 18:
                    this.title = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
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
                    break;
                case 34:
                    this.actionUrl = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.buttonText = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.topLeftTips = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    UserInfos.PicUrl[] picUrlArr3 = this.topLeftIcon;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.topLeftIcon, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.topLeftIcon = picUrlArr4;
                    break;
                case 64:
                    this.showClose = codedInputByteBufferNano.readBool();
                    break;
                case 74:
                    this.bundleInfo = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.ext = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.bizType = codedInputByteBufferNano.readString();
                    break;
                case 98:
                    this.highlightLabel = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.highlightSubLabel = codedInputByteBufferNano.readString();
                    break;
                case 112:
                    int int322 = codedInputByteBufferNano.readInt32();
                    switch (int322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                            this.cardStyleType = int322;
                            break;
                    }
                case 122:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    UserInfos.PicUrl[] picUrlArr5 = this.headUrl;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.headUrl, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.headUrl = picUrlArr6;
                    break;
                case 130:
                    if (this.buttonActionInfo == null) {
                        this.buttonActionInfo = new ActionInfoProto();
                    }
                    codedInputByteBufferNano.readMessage(this.buttonActionInfo);
                    break;
                case 146:
                    if (this.cardRefreshInfo == null) {
                        this.cardRefreshInfo = new RequestInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.cardRefreshInfo);
                    break;
                case 154:
                    this.clientStatInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.clientStatInfo, mapFactory, 9, 9, null, 10, 18);
                    break;
                case 170:
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

    public static SCLiveEcoExplainCardSignal parseFrom(byte[] bArr) {
        return (SCLiveEcoExplainCardSignal) MessageNano.mergeFrom(new SCLiveEcoExplainCardSignal(), bArr);
    }

    public static SCLiveEcoExplainCardSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveEcoExplainCardSignal().mergeFrom(codedInputByteBufferNano);
    }
}
