package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCCommentNotice extends MessageNano {
    private static volatile SCCommentNotice[] _emptyArray;
    public String bizId;
    public int bizType;
    public CommentNoticeButton button;
    public ClickCommentNoticeEvent clickEvent;
    public CommentNoticeButton clickedButton;
    public String clickedDesc;
    public long clickedDisplayDurationMs;
    public String clickedSubTitle;
    public String clickedTitle;
    public UserInfos.PicUrl[] commentNoticePicUrl;
    public String commonGuideSubBizType;
    public long delayDisplayMs;
    public String desc;
    public long displayDurationMs;
    public long displayEndTime;
    public int enableLiveModel;
    public String extraInfo;
    public boolean noticePicIsSquare;
    public int priority;
    public String subTitle;
    public String targetLiveStreamId;
    public String title;
    public UserInfos.PicUrl[] titleIcon;
    public int totalShowTimes;
    public int type;

    public static SCCommentNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCCommentNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCCommentNotice() {
        clear();
    }

    public final SCCommentNotice clear() {
        this.type = 0;
        this.bizId = "";
        this.commentNoticePicUrl = UserInfos.PicUrl.emptyArray();
        this.desc = "";
        this.displayDurationMs = 0L;
        this.title = "";
        this.totalShowTimes = 0;
        this.extraInfo = "";
        this.titleIcon = UserInfos.PicUrl.emptyArray();
        this.subTitle = "";
        this.button = null;
        this.clickEvent = null;
        this.bizType = 0;
        this.noticePicIsSquare = false;
        this.priority = 0;
        this.targetLiveStreamId = "";
        this.delayDisplayMs = 0L;
        this.displayEndTime = 0L;
        this.clickedDesc = "";
        this.clickedTitle = "";
        this.clickedSubTitle = "";
        this.clickedDisplayDurationMs = 0L;
        this.clickedButton = null;
        this.commonGuideSubBizType = "";
        this.enableLiveModel = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.bizId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.bizId);
        }
        UserInfos.PicUrl[] picUrlArr = this.commentNoticePicUrl;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.commentNoticePicUrl;
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
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.desc);
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.title);
        }
        int i4 = this.totalShowTimes;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i4);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.extraInfo);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.titleIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.titleIcon;
                if (i2 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i2];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(9, picUrl2);
                }
                i2++;
            }
        }
        if (!this.subTitle.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.subTitle);
        }
        CommentNoticeButton commentNoticeButton = this.button;
        if (commentNoticeButton != null) {
            codedOutputByteBufferNano.writeMessage(11, commentNoticeButton);
        }
        ClickCommentNoticeEvent clickCommentNoticeEvent = this.clickEvent;
        if (clickCommentNoticeEvent != null) {
            codedOutputByteBufferNano.writeMessage(12, clickCommentNoticeEvent);
        }
        int i5 = this.bizType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i5);
        }
        boolean z = this.noticePicIsSquare;
        if (z) {
            codedOutputByteBufferNano.writeBool(14, z);
        }
        int i6 = this.priority;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i6);
        }
        if (!this.targetLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(16, this.targetLiveStreamId);
        }
        long j2 = this.delayDisplayMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(17, j2);
        }
        long j3 = this.displayEndTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(18, j3);
        }
        if (!this.clickedDesc.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.clickedDesc);
        }
        if (!this.clickedTitle.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.clickedTitle);
        }
        if (!this.clickedSubTitle.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.clickedSubTitle);
        }
        long j4 = this.clickedDisplayDurationMs;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(22, j4);
        }
        CommentNoticeButton commentNoticeButton2 = this.clickedButton;
        if (commentNoticeButton2 != null) {
            codedOutputByteBufferNano.writeMessage(23, commentNoticeButton2);
        }
        if (!this.commonGuideSubBizType.equals("")) {
            codedOutputByteBufferNano.writeString(24, this.commonGuideSubBizType);
        }
        int i7 = this.enableLiveModel;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeInt32(25, i7);
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
        if (!this.bizId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bizId);
        }
        UserInfos.PicUrl[] picUrlArr = this.commentNoticePicUrl;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.commentNoticePicUrl;
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
        if (!this.desc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.desc);
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.title);
        }
        int i4 = this.totalShowTimes;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i4);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.extraInfo);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.titleIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.titleIcon;
                if (i2 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i2];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, picUrl2);
                }
                i2++;
            }
        }
        if (!this.subTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.subTitle);
        }
        CommentNoticeButton commentNoticeButton = this.button;
        if (commentNoticeButton != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, commentNoticeButton);
        }
        ClickCommentNoticeEvent clickCommentNoticeEvent = this.clickEvent;
        if (clickCommentNoticeEvent != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, clickCommentNoticeEvent);
        }
        int i5 = this.bizType;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i5);
        }
        boolean z = this.noticePicIsSquare;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, z);
        }
        int i6 = this.priority;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i6);
        }
        if (!this.targetLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.targetLiveStreamId);
        }
        long j2 = this.delayDisplayMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(17, j2);
        }
        long j3 = this.displayEndTime;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(18, j3);
        }
        if (!this.clickedDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.clickedDesc);
        }
        if (!this.clickedTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.clickedTitle);
        }
        if (!this.clickedSubTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.clickedSubTitle);
        }
        long j4 = this.clickedDisplayDurationMs;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(22, j4);
        }
        CommentNoticeButton commentNoticeButton2 = this.clickedButton;
        if (commentNoticeButton2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, commentNoticeButton2);
        }
        if (!this.commonGuideSubBizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(24, this.commonGuideSubBizType);
        }
        int i7 = this.enableLiveModel;
        return i7 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(25, i7) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCCommentNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
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
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                            this.type = int32;
                            break;
                        default:
                            switch (int32) {
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                    this.type = int32;
                                    break;
                                default:
                                    switch (int32) {
                                        case 200:
                                        case 201:
                                        case 202:
                                        case 203:
                                        case 204:
                                            this.type = int32;
                                            break;
                                    }
                            }
                    }
                case 18:
                    this.bizId = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.commentNoticePicUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.commentNoticePicUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.commentNoticePicUrl = picUrlArr2;
                    break;
                case 34:
                    this.desc = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.displayDurationMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.title = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.totalShowTimes = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    UserInfos.PicUrl[] picUrlArr3 = this.titleIcon;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.titleIcon, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.titleIcon = picUrlArr4;
                    break;
                case 82:
                    this.subTitle = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.button == null) {
                        this.button = new CommentNoticeButton();
                    }
                    codedInputByteBufferNano.readMessage(this.button);
                    break;
                case 98:
                    if (this.clickEvent == null) {
                        this.clickEvent = new ClickCommentNoticeEvent();
                    }
                    codedInputByteBufferNano.readMessage(this.clickEvent);
                    break;
                case 104:
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
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 40:
                        case 41:
                        case 42:
                        case 43:
                        case 44:
                        case 45:
                        case 46:
                        case 47:
                        case 48:
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                        case 59:
                        case 60:
                        case 61:
                        case 62:
                        case 63:
                        case 64:
                        case 65:
                        case 66:
                        case 67:
                        case 68:
                        case 69:
                        case 70:
                        case 71:
                        case 72:
                        case 73:
                        case 74:
                        case 75:
                        case 76:
                        case 77:
                        case 78:
                        case 79:
                        case 80:
                        case 81:
                        case 82:
                        case 83:
                        case 84:
                        case 85:
                        case 86:
                        case 87:
                        case 88:
                        case 89:
                        case 90:
                        case 91:
                        case 92:
                        case 93:
                        case 94:
                        case 95:
                        case 96:
                        case 97:
                        case 98:
                        case 99:
                        case 100:
                        case 101:
                        case 102:
                        case 103:
                        case 104:
                        case 105:
                        case 106:
                        case 107:
                        case 108:
                        case 109:
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case 114:
                        case 115:
                        case 116:
                        case 117:
                        case 118:
                        case 119:
                        case 120:
                        case 121:
                        case 122:
                        case 123:
                        case 124:
                        case 125:
                        case 126:
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                        case 131:
                        case 132:
                        case 133:
                        case 134:
                        case 135:
                        case 136:
                        case 137:
                        case 138:
                        case 139:
                        case 140:
                        case 141:
                        case 142:
                        case 143:
                        case 144:
                        case 145:
                        case 146:
                        case 147:
                        case 148:
                        case 149:
                        case 150:
                        case 151:
                        case 152:
                        case 153:
                        case 154:
                        case 155:
                        case 156:
                        case 157:
                        case 158:
                        case 159:
                        case 160:
                        case 161:
                        case 162:
                        case 163:
                        case 164:
                        case 165:
                        case 166:
                        case 167:
                        case 168:
                        case 169:
                        case 170:
                        case 171:
                        case 172:
                        case 173:
                        case 174:
                        case 175:
                        case 176:
                        case 177:
                        case 178:
                        case 179:
                        case 180:
                        case 181:
                        case 182:
                        case 183:
                        case 184:
                        case 185:
                        case 186:
                        case 187:
                        case 188:
                        case 189:
                        case 190:
                        case 191:
                        case 192:
                        case 193:
                        case 194:
                        case 195:
                        case 196:
                        case 197:
                        case 198:
                        case 199:
                        case 200:
                        case 201:
                        case 202:
                        case 203:
                        case 204:
                        case 205:
                        case 206:
                        case 207:
                        case 208:
                        case 209:
                        case 210:
                        case 211:
                        case 212:
                        case 213:
                        case 214:
                        case 215:
                        case 216:
                        case 217:
                        case 218:
                        case 219:
                        case 220:
                        case 221:
                        case 222:
                        case 223:
                        case 224:
                        case 225:
                        case 226:
                        case 227:
                        case 228:
                        case 229:
                        case 230:
                        case 231:
                        case 232:
                        case 233:
                        case 234:
                        case 235:
                        case 236:
                        case 237:
                        case 238:
                        case 239:
                        case 240:
                        case 241:
                        case 242:
                        case 243:
                        case 244:
                        case 245:
                        case 246:
                        case 247:
                        case 248:
                        case 249:
                        case 250:
                        case 251:
                        case 252:
                        case 253:
                        case 254:
                        case 255:
                        case 256:
                        case 257:
                        case 258:
                        case 259:
                        case 260:
                        case 261:
                        case 262:
                        case 263:
                        case 264:
                        case 265:
                        case 266:
                        case 267:
                        case 268:
                        case 269:
                        case 270:
                        case 271:
                        case 272:
                        case 273:
                        case 274:
                        case 275:
                        case 276:
                            this.bizType = int322;
                            break;
                    }
                case 112:
                    this.noticePicIsSquare = codedInputByteBufferNano.readBool();
                    break;
                case 120:
                    this.priority = codedInputByteBufferNano.readUInt32();
                    break;
                case 130:
                    this.targetLiveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 136:
                    this.delayDisplayMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 144:
                    this.displayEndTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 154:
                    this.clickedDesc = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.clickedTitle = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    this.clickedSubTitle = codedInputByteBufferNano.readString();
                    break;
                case 176:
                    this.clickedDisplayDurationMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 186:
                    if (this.clickedButton == null) {
                        this.clickedButton = new CommentNoticeButton();
                    }
                    codedInputByteBufferNano.readMessage(this.clickedButton);
                    break;
                case 194:
                    this.commonGuideSubBizType = codedInputByteBufferNano.readString();
                    break;
                case 200:
                    this.enableLiveModel = codedInputByteBufferNano.readInt32();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCCommentNotice parseFrom(byte[] bArr) {
        return (SCCommentNotice) MessageNano.mergeFrom(new SCCommentNotice(), bArr);
    }

    public static SCCommentNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCCommentNotice().mergeFrom(codedInputByteBufferNano);
    }
}
