package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCommonNoticeMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface NoticePriorityType {
        public static final int GREEN_NOTICE = 1;
        public static final int GREEN_REALTIME_NOTICE = 4;
        public static final int NORMAL_NOTICE = 3;
        public static final int REALTIME_NOTICE = 2;
        public static final int UNKNOWN_NOTICE_PRIORITY_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NoticeRouteType {
        public static final int ARROW_ROUTE = 2;
        public static final int ICON_ROUTE = 3;
        public static final int NO_ROUTE = 1;
        public static final int UNKNOWN_NOTICE_ROUTE_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface NoticeStyleType {
        public static final int STRONG_STYLE = 2;
        public static final int UNKNOWN_NOTICE_STYLE_TYPE = 0;
        public static final int WEAK_STYLE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TopBannerActionType {
        public static final int DO_NOTHING = 3;
        public static final int JUMP_LIVE_STREAM = 2;
        public static final int POP_USER_PROFILE = 1;
        public static final int TOP_BANNER_LIVE_ROUTER = 4;
        public static final int UNKNOWN_ACTION_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TopBannerNoticeType {
        public static final int ADMIN_DANGEROUS_DRIVING_WARNING = 21;
        public static final int ANNUAL_AUTHOR_START_LIVE_NOTICE = 23;
        public static final int AUTHOR_TASK_CONDITION_FINISHED = 31;
        public static final int AUTHOR_TASK_FINISHED = 32;
        public static final int AUTHOR_WATCH_TASK_NOTICE = 33;
        public static final int COVER_AUDIT_NOT_ALLOW = 27;
        public static final int COVER_REAUDIT_ALLOW = 29;
        public static final int COVER_REAUDIT_NOT_ALLOW = 28;
        public static final int FANS_TOP_POP_GUIDANCE = 6;
        public static final int GIFT_WHEEL_USER_DRAW = 7;
        public static final int GIFT_WHEEL_USER_SEND = 8;
        public static final int LIVE_AUTHOR_RESERVATION_ENCOURAGE = 34;
        public static final int LIVE_ENTRUST_ASSISTANT_ENTER_OR_EXIT = 17;
        public static final int LIVE_FANS_GROUP_SHARE_NOTICE = 26;
        public static final int LIVE_GIFT_SPREAD_GIFT_SENT = 20;
        public static final int LIVE_PAID_SHOW = 16;
        public static final int LIVE_PK_CHANGE_FORMAT_UPGRADE = 15;
        public static final int LIVE_PK_PUNISH_MAGIC_FACE = 1;
        public static final int LIVE_QUIZ2_AWARD_RESULT = 14;
        public static final int LIVE_SHOP_NOTIFY = 2;
        public static final int LIVE_TOP1_USER_PRIVILEGE = 18;
        public static final int LIVE_USER_EDUCATION = 25;
        public static final int SF2021_SQUARE_AUTHOR_SUPPORT_TOP_NOTICE = 22;
        public static final int THANKS_RED_PACK_AUTHOR_FRIEND_THANKS_SUCCESS = 10;
        public static final int THANKS_RED_PACK_AUTHOR_THANKS_SUCCESS = 9;
        public static final int THANKS_RED_PACK_AWARD_AVERAGE_HINT = 13;
        public static final int THANKS_RED_PACK_FIRST_RANK = 11;
        public static final int THANKS_RED_PACK_GRAND_AWARD = 12;
        public static final int UNION_AUTHOR_STATE_CHANGED_BROADCAST = 30;
        public static final int UNKNOWN_TOP_BANNER_NOTICE_TYPE = 0;
        public static final int USER_ENTER_ROOM_BY_SEARCH_MERCHANT = 19;
        public static final int WEALTH_GRADE_PRIVILEGE = 24;
        public static final int WHEEL_DECIDE_AUDIT_PASS = 4;
        public static final int WHEEL_DECIDE_AUDIT_REJECT = 5;
        public static final int WHEEL_DECIDE_DRAW_RESULT = 3;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TopBroadcastDisableDisplaySignal {
        public static final int ALL_DISPLAY = 0;
        public static final int DISABLE_AUDIENCE = 1;
        public static final int DISABLE_AUTHOR = 2;
    }

    public static final class SCTopBannerNotice extends MessageNano {
        private static volatile SCTopBannerNotice[] _emptyArray;
        public int actionType;
        public UserInfos.PicUrl[] backGroundPictureUrl;
        public String backgroundColor;
        public String backgroundColorBegin;
        public String backgroundColorEnd;
        public String backgroupColor;
        public long displayDurationMillis;
        public UserInfos.PicUrl[] displayIcon;
        public int displayIconHeightDp;
        public int displayIconWidthDp;
        public String extraInfo;
        public String link;
        public int priority;
        public int source;
        public String targetLiveStreamId;
        public UserInfos.UserInfo targetUserInfo;
        public String textColor;
        public String textContent;
        public int type;

        public static SCTopBannerNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCTopBannerNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCTopBannerNotice() {
            clear();
        }

        public final SCTopBannerNotice clear() {
            this.backgroupColor = "";
            this.textColor = "";
            this.textContent = "";
            this.type = 0;
            this.backgroundColor = "";
            this.backgroundColorBegin = "";
            this.backgroundColorEnd = "";
            this.priority = 0;
            this.actionType = 0;
            this.targetUserInfo = null;
            this.targetLiveStreamId = "";
            this.displayIcon = UserInfos.PicUrl.emptyArray();
            this.backGroundPictureUrl = UserInfos.PicUrl.emptyArray();
            this.source = 0;
            this.displayDurationMillis = 0L;
            this.displayIconWidthDp = 0;
            this.displayIconHeightDp = 0;
            this.link = "";
            this.extraInfo = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.backgroupColor.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.backgroupColor);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.textColor);
            }
            if (!this.textContent.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.textContent);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            if (!this.backgroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.backgroundColor);
            }
            if (!this.backgroundColorBegin.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.backgroundColorBegin);
            }
            if (!this.backgroundColorEnd.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.backgroundColorEnd);
            }
            int i2 = this.priority;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i2);
            }
            int i3 = this.actionType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(9, i3);
            }
            UserInfos.UserInfo userInfo = this.targetUserInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(10, userInfo);
            }
            if (!this.targetLiveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.targetLiveStreamId);
            }
            UserInfos.PicUrl[] picUrlArr = this.displayIcon;
            int i4 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.displayIcon;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(12, picUrl);
                    }
                    i5++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.backGroundPictureUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.backGroundPictureUrl;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(13, picUrl2);
                    }
                    i4++;
                }
            }
            int i6 = this.source;
            if (i6 != 0) {
                codedOutputByteBufferNano.writeInt32(14, i6);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(15, j);
            }
            int i7 = this.displayIconWidthDp;
            if (i7 != 0) {
                codedOutputByteBufferNano.writeUInt32(16, i7);
            }
            int i8 = this.displayIconHeightDp;
            if (i8 != 0) {
                codedOutputByteBufferNano.writeUInt32(17, i8);
            }
            if (!this.link.equals("")) {
                codedOutputByteBufferNano.writeString(18, this.link);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(19, this.extraInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.backgroupColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.backgroupColor);
            }
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.textColor);
            }
            if (!this.textContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.textContent);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            if (!this.backgroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.backgroundColor);
            }
            if (!this.backgroundColorBegin.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.backgroundColorBegin);
            }
            if (!this.backgroundColorEnd.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.backgroundColorEnd);
            }
            int i2 = this.priority;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i2);
            }
            int i3 = this.actionType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i3);
            }
            UserInfos.UserInfo userInfo = this.targetUserInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, userInfo);
            }
            if (!this.targetLiveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.targetLiveStreamId);
            }
            UserInfos.PicUrl[] picUrlArr = this.displayIcon;
            int i4 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.displayIcon;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(12, picUrl);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.backGroundPictureUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.backGroundPictureUrl;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, picUrl2);
                    }
                    i4++;
                }
            }
            int i6 = this.source;
            if (i6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i6);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j);
            }
            int i7 = this.displayIconWidthDp;
            if (i7 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i7);
            }
            int i8 = this.displayIconHeightDp;
            if (i8 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i8);
            }
            if (!this.link.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.link);
            }
            return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(19, this.extraInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCTopBannerNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.backgroupColor = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.textColor = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.textContent = codedInputByteBufferNano.readString();
                        break;
                    case 32:
                        this.type = codedInputByteBufferNano.readUInt32();
                        break;
                    case 42:
                        this.backgroundColor = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.backgroundColorBegin = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.backgroundColorEnd = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.priority = codedInputByteBufferNano.readUInt32();
                        break;
                    case 72:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                            break;
                        } else {
                            this.actionType = int32;
                            break;
                        }
                    case 82:
                        if (this.targetUserInfo == null) {
                            this.targetUserInfo = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.targetUserInfo);
                        break;
                    case 90:
                        this.targetLiveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                        UserInfos.PicUrl[] picUrlArr = this.displayIcon;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.displayIcon, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.displayIcon = picUrlArr2;
                        break;
                    case 106:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        UserInfos.PicUrl[] picUrlArr3 = this.backGroundPictureUrl;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.backGroundPictureUrl, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.backGroundPictureUrl = picUrlArr4;
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
                                this.source = int322;
                                break;
                        }
                    case 120:
                        this.displayDurationMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 128:
                        this.displayIconWidthDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 136:
                        this.displayIconHeightDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 146:
                        this.link = codedInputByteBufferNano.readString();
                        break;
                    case 154:
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

        public static SCTopBannerNotice parseFrom(byte[] bArr) {
            return (SCTopBannerNotice) MessageNano.mergeFrom(new SCTopBannerNotice(), bArr);
        }

        public static SCTopBannerNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCTopBannerNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class StretchablePicture extends MessageNano {
        private static volatile StretchablePicture[] _emptyArray;
        public int insetBottomDp;
        public int insetLeftDp;
        public int insetRightDp;
        public int insetTopDp;
        public UserInfos.PicUrl[] picUrl;

        public static StretchablePicture[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StretchablePicture[0];
                    }
                }
            }
            return _emptyArray;
        }

        public StretchablePicture() {
            clear();
        }

        public final StretchablePicture clear() {
            this.picUrl = UserInfos.PicUrl.emptyArray();
            this.insetLeftDp = 0;
            this.insetRightDp = 0;
            this.insetTopDp = 0;
            this.insetBottomDp = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i++;
                }
            }
            int i2 = this.insetLeftDp;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.insetRightDp;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            int i4 = this.insetTopDp;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            int i5 = this.insetBottomDp;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i5);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i++;
                }
            }
            int i2 = this.insetLeftDp;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.insetRightDp;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            int i4 = this.insetTopDp;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
            }
            int i5 = this.insetBottomDp;
            return i5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i5) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final StretchablePicture mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.picUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.picUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.picUrl = picUrlArr2;
                } else if (tag == 16) {
                    this.insetLeftDp = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.insetRightDp = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.insetTopDp = codedInputByteBufferNano.readUInt32();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.insetBottomDp = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static StretchablePicture parseFrom(byte[] bArr) {
            return (StretchablePicture) MessageNano.mergeFrom(new StretchablePicture(), bArr);
        }

        public static StretchablePicture parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new StretchablePicture().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class TextDesc extends MessageNano {
        private static volatile TextDesc[] _emptyArray;
        public String textColor;
        public String textContent;

        public static TextDesc[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TextDesc[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TextDesc() {
            clear();
        }

        public final TextDesc clear() {
            this.textContent = "";
            this.textColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.textContent.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.textContent);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.textColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.textContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.textContent);
            }
            return !this.textColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.textColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TextDesc mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.textContent = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.textColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static TextDesc parseFrom(byte[] bArr) {
            return (TextDesc) MessageNano.mergeFrom(new TextDesc(), bArr);
        }

        public static TextDesc parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TextDesc().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiteTextNotice extends MessageNano {
        private static volatile LiteTextNotice[] _emptyArray;
        public String animationString;
        public String backgroundColorBegin;
        public String backgroundColorEnd;
        public int bizType;
        public long displayDelayMillis;
        public long displayDurationMillis;
        public int displayPriority;
        public long endTimestamp;
        public LiveCdnNodeView[] iconUrl;
        public boolean needForceDisplay;
        public boolean needUpdateDisplayDuration;
        public String routeUrl;
        public long startTimestamp;
        public String textColor;
        public String textContent;

        @Retention(RetentionPolicy.SOURCE)
        public @interface NoticeBizType {
            public static final int AUTHOR_PERCEPTION = 8;
            public static final int BIZ_UNKNOWN = 0;
            public static final int BULLET_PLAY_RANK = 9;
            public static final int DISTRICT_CITY_RANK = 6;
            public static final int DISTRICT_HEAD_RANK = 2;
            public static final int DISTRICT_HOUR_RANK = 1;
            public static final int LIVE_HOTSPOT_RANK = 7;
            public static final int LIVE_TAG = 4;
            public static final int POPULARITY_RANK = 5;
            public static final int ROOKIE_RANK = 10;
            public static final int TRAFFIC_OPERATION = 3;
        }

        public static LiteTextNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiteTextNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiteTextNotice() {
            clear();
        }

        public final LiteTextNotice clear() {
            this.textContent = "";
            this.textColor = "";
            this.backgroundColorBegin = "";
            this.backgroundColorEnd = "";
            this.displayDurationMillis = 0L;
            this.bizType = 0;
            this.routeUrl = "";
            this.startTimestamp = 0L;
            this.endTimestamp = 0L;
            this.displayPriority = 0;
            this.needForceDisplay = false;
            this.needUpdateDisplayDuration = false;
            this.displayDelayMillis = 0L;
            this.animationString = "";
            this.iconUrl = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.textContent.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.textContent);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.textColor);
            }
            if (!this.backgroundColorBegin.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.backgroundColorBegin);
            }
            if (!this.backgroundColorEnd.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.backgroundColorEnd);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(6, i);
            }
            if (!this.routeUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.routeUrl);
            }
            long j2 = this.startTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j2);
            }
            long j3 = this.endTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j3);
            }
            int i2 = this.displayPriority;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(10, i2);
            }
            boolean z = this.needForceDisplay;
            if (z) {
                codedOutputByteBufferNano.writeBool(11, z);
            }
            boolean z2 = this.needUpdateDisplayDuration;
            if (z2) {
                codedOutputByteBufferNano.writeBool(12, z2);
            }
            long j4 = this.displayDelayMillis;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(13, j4);
            }
            if (!this.animationString.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.animationString);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconUrl;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i3 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconUrl;
                    if (i3 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(15, liveCdnNodeView);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.textContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.textContent);
            }
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.textColor);
            }
            if (!this.backgroundColorBegin.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.backgroundColorBegin);
            }
            if (!this.backgroundColorEnd.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.backgroundColorEnd);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i);
            }
            if (!this.routeUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.routeUrl);
            }
            long j2 = this.startTimestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
            }
            long j3 = this.endTimestamp;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
            }
            int i2 = this.displayPriority;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i2);
            }
            boolean z = this.needForceDisplay;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z);
            }
            boolean z2 = this.needUpdateDisplayDuration;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z2);
            }
            long j4 = this.displayDelayMillis;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j4);
            }
            if (!this.animationString.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.animationString);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconUrl;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i3 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconUrl;
                    if (i3 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, liveCdnNodeView);
                    }
                    i3++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiteTextNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.textContent = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.textColor = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.backgroundColorBegin = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.backgroundColorEnd = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.displayDurationMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 48:
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
                                this.bizType = int32;
                                break;
                        }
                    case 58:
                        this.routeUrl = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.startTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 72:
                        this.endTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 80:
                        this.displayPriority = codedInputByteBufferNano.readUInt32();
                        break;
                    case 88:
                        this.needForceDisplay = codedInputByteBufferNano.readBool();
                        break;
                    case 96:
                        this.needUpdateDisplayDuration = codedInputByteBufferNano.readBool();
                        break;
                    case 104:
                        this.displayDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 114:
                        this.animationString = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                        LiveCdnNodeView[] liveCdnNodeViewArr = this.iconUrl;
                        int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.iconUrl, 0, liveCdnNodeViewArr2, 0, length);
                        }
                        while (length < liveCdnNodeViewArr2.length - 1) {
                            liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        this.iconUrl = liveCdnNodeViewArr2;
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiteTextNotice parseFrom(byte[] bArr) {
            return (LiteTextNotice) MessageNano.mergeFrom(new LiteTextNotice(), bArr);
        }

        public static LiteTextNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiteTextNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRankLiteNotice extends MessageNano {
        private static volatile SCLiveRankLiteNotice[] _emptyArray;
        public UserInfos.PicUrl[] backgroundPicUrls;
        public int bizType;
        public int displayDurationMillis;
        public int displayPriority;
        public String iconUrl;
        public String jumpKwaiUrl;
        public LiveCdnNodeView[] refreshingIconUrl;
        public String textContent;

        @Retention(RetentionPolicy.SOURCE)
        public @interface NoticeBizType {
            public static final int BIZ_UNKNOWN = 0;
            public static final int POPULARITY_ASSISTANT = 1;
        }

        public static SCLiveRankLiteNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRankLiteNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRankLiteNotice() {
            clear();
        }

        public final SCLiveRankLiteNotice clear() {
            this.bizType = 0;
            this.displayPriority = 0;
            this.displayDurationMillis = 0;
            this.iconUrl = "";
            this.textContent = "";
            this.backgroundPicUrls = UserInfos.PicUrl.emptyArray();
            this.jumpKwaiUrl = "";
            this.refreshingIconUrl = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.displayPriority;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.displayDurationMillis;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            if (!this.iconUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.iconUrl);
            }
            if (!this.textContent.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.textContent);
            }
            UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrls;
            int i4 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrls;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl);
                    }
                    i5++;
                }
            }
            if (!this.jumpKwaiUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.jumpKwaiUrl);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.refreshingIconUrl;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.refreshingIconUrl;
                    if (i4 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i4];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(8, liveCdnNodeView);
                    }
                    i4++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.displayPriority;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.displayDurationMillis;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            if (!this.iconUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.iconUrl);
            }
            if (!this.textContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.textContent);
            }
            UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrls;
            int i4 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrls;
                    if (i5 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i5];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.jumpKwaiUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.jumpKwaiUrl);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.refreshingIconUrl;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.refreshingIconUrl;
                    if (i4 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i4];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveCdnNodeView);
                    }
                    i4++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRankLiteNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.bizType = int32;
                    }
                } else if (tag == 16) {
                    this.displayPriority = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.displayDurationMillis = codedInputByteBufferNano.readUInt32();
                } else if (tag == 34) {
                    this.iconUrl = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.textContent = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrls;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.backgroundPicUrls, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.backgroundPicUrls = picUrlArr2;
                } else if (tag == 58) {
                    this.jumpKwaiUrl = codedInputByteBufferNano.readString();
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.refreshingIconUrl;
                    int length2 = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.refreshingIconUrl, 0, liveCdnNodeViewArr2, 0, length2);
                    }
                    while (length2 < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length2] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    liveCdnNodeViewArr2[length2] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length2]);
                    this.refreshingIconUrl = liveCdnNodeViewArr2;
                }
            }
        }

        public static SCLiveRankLiteNotice parseFrom(byte[] bArr) {
            return (SCLiveRankLiteNotice) MessageNano.mergeFrom(new SCLiveRankLiteNotice(), bArr);
        }

        public static SCLiveRankLiteNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRankLiteNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCTopBroadcastNotice extends MessageNano {
        private static volatile SCTopBroadcastNotice[] _emptyArray;
        public int actionType;
        public String[] backgroundColor;
        public StretchablePicture backgroundPicture;
        public int bizType;
        public int disableDisplaySignal;
        public long displayDurationMillis;
        public String extraInfo;
        public UserInfos.PicUrl[] leftIcon;
        public int leftIconHeightDp;
        public int leftIconMarginLeftDp;
        public int leftIconType;
        public int leftIconWidthDp;
        public long limitExpireTime;
        public String limitTarget;
        public long limitTimeWindow;
        public int limitTimes;
        public String link;
        public int priority;
        public UserInfos.PicUrl[] rightButtonPic;
        public int rightButtonPicHeightDp;
        public int rightButtonPicMarginRightDp;
        public int rightButtonPicWidthDp;
        public UserInfos.PicUrl[] shimmerPic;
        public String targetLiveStreamId;
        public UserInfos.UserInfo targetUserInfo;
        public String textColor;
        public String textContent;
        public TextDesc[] textDesc;
        public int textMarginLeftDp;
        public int textMarginRightDp;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LeftIconType {
            public static final int DEFAULT = 1;
            public static final int UNKNOWN = 0;
            public static final int WEBP = 2;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface NoticeActionType {
            public static final int ACTION_UNKNOWN = 0;
            public static final int JUMP_LIVE_STREAM = 4;
            public static final int KWAI_URL = 2;
            public static final int LIVE_ROUTER = 5;
            public static final int POP_USER_PROFILE = 1;
            public static final int WEB_VIEW = 3;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface NoticeBizType {
            public static final int BIZ_UNKNOWN = 0;
            public static final int LIVE_ACTIVITY_BROADCAST_NOTICE = 1;
            public static final int LIVE_ACTIVITY_FEEDS_WATCH_TASK_NOTICE = 19;
            public static final int LIVE_ACTIVITY_REUSABLE_APHRODITE = 28;
            public static final int LIVE_ACTIVITY_REUSABLE_APOLLO = 25;
            public static final int LIVE_ACTIVITY_REUSABLE_ARES = 27;
            public static final int LIVE_ACTIVITY_REUSABLE_ARTEMIS = 26;
            public static final int LIVE_ACTIVITY_REUSABLE_ATHENA = 24;
            public static final int LIVE_ACTIVITY_REUSABLE_DEMETER = 23;
            public static final int LIVE_ACTIVITY_REUSABLE_DIONYSUS = 32;
            public static final int LIVE_ACTIVITY_REUSABLE_HEPHAESTUS = 29;
            public static final int LIVE_ACTIVITY_REUSABLE_HERA = 21;
            public static final int LIVE_ACTIVITY_REUSABLE_HERMES = 30;
            public static final int LIVE_ACTIVITY_REUSABLE_HESTIA = 31;
            public static final int LIVE_ACTIVITY_REUSABLE_POSEIDON = 22;
            public static final int LIVE_ACTIVITY_REUSABLE_ZEUS = 20;
            public static final int LIVE_BLESSING_RED_PACK_LUCKY_CHARM_NOTICE = 7;
            public static final int LIVE_BLESSING_RED_PACK_RANK_LIST_NOTICE = 6;
            public static final int LIVE_COLLECT_CARD_PK_NOTICE = 9;
            public static final int LIVE_DELTA_AUTHOR_RECALL = 34;
            public static final int LIVE_EQUITY_CENTER_REWARD_EXCHANGE = 37;
            public static final int LIVE_EQUITY_CENTER_TASK_FINISH = 36;
            public static final int LIVE_FANS_GROUP_NOTICE = 4;
            public static final int LIVE_FANS_GROUP_RED_PACKET_GUIDE = 5;
            public static final int LIVE_GUARD = 3;
            public static final int LIVE_HAPPY_PLAY_DRAW_SUCCESS_BROADCAST_NOTICE = 2;
            public static final int LIVE_HAPPY_PLAY_SUPREME_DRAW_SUCCESS_BROADCAST_NOTICE = 10;
            public static final int LIVE_HAPPY_SCRATCH_NOTICE = 12;
            public static final int LIVE_HOUR_RANK_START_PLAY_COUNT_NOTICE = 16;
            public static final int LIVE_HOUR_RANK_TOPN_NOTICE = 15;
            public static final int LIVE_LOVE_520_LUCKY_CHARM_NOTICE = 13;
            public static final int LIVE_LOVE_520_RANK_LIST_NOTICE = 14;
            public static final int LIVE_NEBULA_PRIVATE_DOMAIN_GUIDE = 35;
            public static final int LIVE_NOBLE_PURCHASE_SUCCESS = 33;
            public static final int LIVE_PK_BOUNTY_GAME_NOTICE = 11;
            public static final int LIVE_SEND_GIFT_NOTICE = 8;
            public static final int LIVE_SUPER_PK_NOTICE = 17;
            public static final int LIVE_SUPER_PK_NOTICE_V2 = 18;
        }

        public static SCTopBroadcastNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCTopBroadcastNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCTopBroadcastNotice() {
            clear();
        }

        public final SCTopBroadcastNotice clear() {
            this.textContent = "";
            this.textColor = "";
            this.textMarginLeftDp = 0;
            this.textMarginRightDp = 0;
            this.leftIcon = UserInfos.PicUrl.emptyArray();
            this.leftIconMarginLeftDp = 0;
            this.backgroundPicture = null;
            this.rightButtonPic = UserInfos.PicUrl.emptyArray();
            this.rightButtonPicMarginRightDp = 0;
            this.targetUserInfo = null;
            this.link = "";
            this.priority = 0;
            this.displayDurationMillis = 0L;
            this.bizType = 0;
            this.actionType = 0;
            this.targetLiveStreamId = "";
            this.leftIconWidthDp = 0;
            this.leftIconHeightDp = 0;
            this.rightButtonPicWidthDp = 0;
            this.rightButtonPicHeightDp = 0;
            this.extraInfo = "";
            this.textDesc = TextDesc.emptyArray();
            this.shimmerPic = UserInfos.PicUrl.emptyArray();
            this.leftIconType = 0;
            this.backgroundColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.limitTimeWindow = 0L;
            this.limitTimes = 0;
            this.limitExpireTime = 0L;
            this.limitTarget = "";
            this.disableDisplaySignal = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.textContent.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.textContent);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.textColor);
            }
            int i = this.textMarginLeftDp;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            int i2 = this.textMarginRightDp;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            UserInfos.PicUrl[] picUrlArr = this.leftIcon;
            int i3 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.leftIcon;
                    if (i4 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i4];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl);
                    }
                    i4++;
                }
            }
            int i5 = this.leftIconMarginLeftDp;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i5);
            }
            StretchablePicture stretchablePicture = this.backgroundPicture;
            if (stretchablePicture != null) {
                codedOutputByteBufferNano.writeMessage(7, stretchablePicture);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.rightButtonPic;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i6 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.rightButtonPic;
                    if (i6 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i6];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(8, picUrl2);
                    }
                    i6++;
                }
            }
            int i7 = this.rightButtonPicMarginRightDp;
            if (i7 != 0) {
                codedOutputByteBufferNano.writeUInt32(9, i7);
            }
            UserInfos.UserInfo userInfo = this.targetUserInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(10, userInfo);
            }
            if (!this.link.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.link);
            }
            int i8 = this.priority;
            if (i8 != 0) {
                codedOutputByteBufferNano.writeUInt32(12, i8);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(13, j);
            }
            int i9 = this.bizType;
            if (i9 != 0) {
                codedOutputByteBufferNano.writeInt32(14, i9);
            }
            int i10 = this.actionType;
            if (i10 != 0) {
                codedOutputByteBufferNano.writeInt32(15, i10);
            }
            if (!this.targetLiveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(16, this.targetLiveStreamId);
            }
            int i11 = this.leftIconWidthDp;
            if (i11 != 0) {
                codedOutputByteBufferNano.writeUInt32(17, i11);
            }
            int i12 = this.leftIconHeightDp;
            if (i12 != 0) {
                codedOutputByteBufferNano.writeUInt32(18, i12);
            }
            int i13 = this.rightButtonPicWidthDp;
            if (i13 != 0) {
                codedOutputByteBufferNano.writeUInt32(19, i13);
            }
            int i14 = this.rightButtonPicHeightDp;
            if (i14 != 0) {
                codedOutputByteBufferNano.writeUInt32(20, i14);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(21, this.extraInfo);
            }
            TextDesc[] textDescArr = this.textDesc;
            if (textDescArr != null && textDescArr.length > 0) {
                int i15 = 0;
                while (true) {
                    TextDesc[] textDescArr2 = this.textDesc;
                    if (i15 >= textDescArr2.length) {
                        break;
                    }
                    TextDesc textDesc = textDescArr2[i15];
                    if (textDesc != null) {
                        codedOutputByteBufferNano.writeMessage(22, textDesc);
                    }
                    i15++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.shimmerPic;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int i16 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.shimmerPic;
                    if (i16 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i16];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(23, picUrl3);
                    }
                    i16++;
                }
            }
            int i17 = this.leftIconType;
            if (i17 != 0) {
                codedOutputByteBufferNano.writeInt32(24, i17);
            }
            String[] strArr = this.backgroundColor;
            if (strArr != null && strArr.length > 0) {
                while (true) {
                    String[] strArr2 = this.backgroundColor;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(25, str);
                    }
                    i3++;
                }
            }
            long j2 = this.limitTimeWindow;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(26, j2);
            }
            int i18 = this.limitTimes;
            if (i18 != 0) {
                codedOutputByteBufferNano.writeUInt32(27, i18);
            }
            long j3 = this.limitExpireTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(28, j3);
            }
            if (!this.limitTarget.equals("")) {
                codedOutputByteBufferNano.writeString(29, this.limitTarget);
            }
            int i19 = this.disableDisplaySignal;
            if (i19 != 0) {
                codedOutputByteBufferNano.writeUInt32(30, i19);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.textContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.textContent);
            }
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.textColor);
            }
            int i = this.textMarginLeftDp;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            int i2 = this.textMarginRightDp;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            UserInfos.PicUrl[] picUrlArr = this.leftIcon;
            int i3 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.leftIcon;
                    if (i4 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i4];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            int i5 = this.leftIconMarginLeftDp;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i5);
            }
            StretchablePicture stretchablePicture = this.backgroundPicture;
            if (stretchablePicture != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, stretchablePicture);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.rightButtonPic;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.rightButtonPic;
                    if (i6 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i6];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(8, picUrl2);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            int i7 = this.rightButtonPicMarginRightDp;
            if (i7 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i7);
            }
            UserInfos.UserInfo userInfo = this.targetUserInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, userInfo);
            }
            if (!this.link.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.link);
            }
            int i8 = this.priority;
            if (i8 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i8);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j);
            }
            int i9 = this.bizType;
            if (i9 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(14, i9);
            }
            int i10 = this.actionType;
            if (i10 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(15, i10);
            }
            if (!this.targetLiveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.targetLiveStreamId);
            }
            int i11 = this.leftIconWidthDp;
            if (i11 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(17, i11);
            }
            int i12 = this.leftIconHeightDp;
            if (i12 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(18, i12);
            }
            int i13 = this.rightButtonPicWidthDp;
            if (i13 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(19, i13);
            }
            int i14 = this.rightButtonPicHeightDp;
            if (i14 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(20, i14);
            }
            if (!this.extraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.extraInfo);
            }
            TextDesc[] textDescArr = this.textDesc;
            if (textDescArr != null && textDescArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i15 = 0;
                while (true) {
                    TextDesc[] textDescArr2 = this.textDesc;
                    if (i15 >= textDescArr2.length) {
                        break;
                    }
                    TextDesc textDesc = textDescArr2[i15];
                    if (textDesc != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(22, textDesc);
                    }
                    i15++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            UserInfos.PicUrl[] picUrlArr5 = this.shimmerPic;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i16 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.shimmerPic;
                    if (i16 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i16];
                    if (picUrl3 != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(23, picUrl3);
                    }
                    i16++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            int i17 = this.leftIconType;
            if (i17 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(24, i17);
            }
            String[] strArr = this.backgroundColor;
            if (strArr != null && strArr.length > 0) {
                int iComputeStringSizeNoTag = 0;
                int i18 = 0;
                while (true) {
                    String[] strArr2 = this.backgroundColor;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        i18++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i18 * 2);
            }
            long j2 = this.limitTimeWindow;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(26, j2);
            }
            int i19 = this.limitTimes;
            if (i19 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(27, i19);
            }
            long j3 = this.limitExpireTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(28, j3);
            }
            if (!this.limitTarget.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(29, this.limitTarget);
            }
            int i20 = this.disableDisplaySignal;
            return i20 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(30, i20) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCTopBroadcastNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.textContent = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.textColor = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.textMarginLeftDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 32:
                        this.textMarginRightDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
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
                    case 48:
                        this.leftIconMarginLeftDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 58:
                        if (this.backgroundPicture == null) {
                            this.backgroundPicture = new StretchablePicture();
                        }
                        codedInputByteBufferNano.readMessage(this.backgroundPicture);
                        break;
                    case 66:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        UserInfos.PicUrl[] picUrlArr3 = this.rightButtonPic;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.rightButtonPic, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.rightButtonPic = picUrlArr4;
                        break;
                    case 72:
                        this.rightButtonPicMarginRightDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 82:
                        if (this.targetUserInfo == null) {
                            this.targetUserInfo = new UserInfos.UserInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.targetUserInfo);
                        break;
                    case 90:
                        this.link = codedInputByteBufferNano.readString();
                        break;
                    case 96:
                        this.priority = codedInputByteBufferNano.readUInt32();
                        break;
                    case 104:
                        this.displayDurationMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 112:
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
                                this.bizType = int32;
                                break;
                        }
                    case 120:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3 && int322 != 4 && int322 != 5) {
                            break;
                        } else {
                            this.actionType = int322;
                            break;
                        }
                        break;
                    case 130:
                        this.targetLiveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 136:
                        this.leftIconWidthDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 144:
                        this.leftIconHeightDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 152:
                        this.rightButtonPicWidthDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 160:
                        this.rightButtonPicHeightDp = codedInputByteBufferNano.readUInt32();
                        break;
                    case 170:
                        this.extraInfo = codedInputByteBufferNano.readString();
                        break;
                    case 178:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 178);
                        TextDesc[] textDescArr = this.textDesc;
                        int length3 = textDescArr == null ? 0 : textDescArr.length;
                        TextDesc[] textDescArr2 = new TextDesc[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.textDesc, 0, textDescArr2, 0, length3);
                        }
                        while (length3 < textDescArr2.length - 1) {
                            textDescArr2[length3] = new TextDesc();
                            codedInputByteBufferNano.readMessage(textDescArr2[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        textDescArr2[length3] = new TextDesc();
                        codedInputByteBufferNano.readMessage(textDescArr2[length3]);
                        this.textDesc = textDescArr2;
                        break;
                    case 186:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 186);
                        UserInfos.PicUrl[] picUrlArr5 = this.shimmerPic;
                        int length4 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                        UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.shimmerPic, 0, picUrlArr6, 0, length4);
                        }
                        while (length4 < picUrlArr6.length - 1) {
                            picUrlArr6[length4] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        picUrlArr6[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                        this.shimmerPic = picUrlArr6;
                        break;
                    case 192:
                        int int323 = codedInputByteBufferNano.readInt32();
                        if (int323 != 0 && int323 != 1 && int323 != 2) {
                            break;
                        } else {
                            this.leftIconType = int323;
                            break;
                        }
                    case 202:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 202);
                        String[] strArr = this.backgroundColor;
                        int length5 = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.backgroundColor, 0, strArr2, 0, length5);
                        }
                        while (length5 < strArr2.length - 1) {
                            strArr2[length5] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        strArr2[length5] = codedInputByteBufferNano.readString();
                        this.backgroundColor = strArr2;
                        break;
                    case 208:
                        this.limitTimeWindow = codedInputByteBufferNano.readUInt64();
                        break;
                    case 216:
                        this.limitTimes = codedInputByteBufferNano.readUInt32();
                        break;
                    case 224:
                        this.limitExpireTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 234:
                        this.limitTarget = codedInputByteBufferNano.readString();
                        break;
                    case 240:
                        this.disableDisplaySignal = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCTopBroadcastNotice parseFrom(byte[] bArr) {
            return (SCTopBroadcastNotice) MessageNano.mergeFrom(new SCTopBroadcastNotice(), bArr);
        }

        public static SCTopBroadcastNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCTopBroadcastNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCTopBannerBroadcastNotice extends MessageNano {
        private static volatile SCTopBannerBroadcastNotice[] _emptyArray;
        public String backgroundColorBegin;
        public String backgroundColorEnd;
        public long bizId;
        public String buttonContent;
        public String configBizId;
        public String content;
        public String contentForA;
        public String contentForI;
        public long displayDurationMillis;
        public boolean enableWipe;
        public long expiredTimestamp;
        public String extraInfo;
        public String iconUrl;
        public int priorityType;
        public TopBannerBroadcastRefreshingNoticeInfo refreshNoticeInfo;
        public int routeType;
        public String routeUrl;
        public int style;

        public static SCTopBannerBroadcastNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCTopBannerBroadcastNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCTopBannerBroadcastNotice() {
            clear();
        }

        public final SCTopBannerBroadcastNotice clear() {
            this.content = "";
            this.style = 0;
            this.priorityType = 0;
            this.backgroundColorBegin = "";
            this.backgroundColorEnd = "";
            this.enableWipe = false;
            this.iconUrl = "";
            this.routeType = 0;
            this.buttonContent = "";
            this.routeUrl = "";
            this.displayDurationMillis = 0L;
            this.configBizId = "";
            this.extraInfo = "";
            this.bizId = 0L;
            this.expiredTimestamp = 0L;
            this.contentForA = "";
            this.contentForI = "";
            this.refreshNoticeInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.content);
            }
            int i = this.style;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            int i2 = this.priorityType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i2);
            }
            if (!this.backgroundColorBegin.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.backgroundColorBegin);
            }
            if (!this.backgroundColorEnd.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.backgroundColorEnd);
            }
            boolean z = this.enableWipe;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            if (!this.iconUrl.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.iconUrl);
            }
            int i3 = this.routeType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i3);
            }
            if (!this.buttonContent.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.buttonContent);
            }
            if (!this.routeUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.routeUrl);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j);
            }
            if (!this.configBizId.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.configBizId);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.extraInfo);
            }
            long j2 = this.bizId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(14, j2);
            }
            long j3 = this.expiredTimestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(15, j3);
            }
            if (!this.contentForA.equals("")) {
                codedOutputByteBufferNano.writeString(16, this.contentForA);
            }
            if (!this.contentForI.equals("")) {
                codedOutputByteBufferNano.writeString(17, this.contentForI);
            }
            TopBannerBroadcastRefreshingNoticeInfo topBannerBroadcastRefreshingNoticeInfo = this.refreshNoticeInfo;
            if (topBannerBroadcastRefreshingNoticeInfo != null) {
                codedOutputByteBufferNano.writeMessage(18, topBannerBroadcastRefreshingNoticeInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
            }
            int i = this.style;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            int i2 = this.priorityType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
            }
            if (!this.backgroundColorBegin.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.backgroundColorBegin);
            }
            if (!this.backgroundColorEnd.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.backgroundColorEnd);
            }
            boolean z = this.enableWipe;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
            }
            if (!this.iconUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.iconUrl);
            }
            int i3 = this.routeType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
            }
            if (!this.buttonContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.buttonContent);
            }
            if (!this.routeUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.routeUrl);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(11, j);
            }
            if (!this.configBizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.configBizId);
            }
            if (!this.extraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.extraInfo);
            }
            long j2 = this.bizId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j2);
            }
            long j3 = this.expiredTimestamp;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(15, j3);
            }
            if (!this.contentForA.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(16, this.contentForA);
            }
            if (!this.contentForI.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(17, this.contentForI);
            }
            TopBannerBroadcastRefreshingNoticeInfo topBannerBroadcastRefreshingNoticeInfo = this.refreshNoticeInfo;
            return topBannerBroadcastRefreshingNoticeInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(18, topBannerBroadcastRefreshingNoticeInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCTopBannerBroadcastNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.content = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.style = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                            break;
                        } else {
                            this.priorityType = int32;
                            break;
                        }
                    case 34:
                        this.backgroundColorBegin = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.backgroundColorEnd = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        this.enableWipe = codedInputByteBufferNano.readBool();
                        break;
                    case 58:
                        this.iconUrl = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.routeType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 74:
                        this.buttonContent = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.routeUrl = codedInputByteBufferNano.readString();
                        break;
                    case 88:
                        this.displayDurationMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 98:
                        this.configBizId = codedInputByteBufferNano.readString();
                        break;
                    case 106:
                        this.extraInfo = codedInputByteBufferNano.readString();
                        break;
                    case 112:
                        this.bizId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 120:
                        this.expiredTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 130:
                        this.contentForA = codedInputByteBufferNano.readString();
                        break;
                    case 138:
                        this.contentForI = codedInputByteBufferNano.readString();
                        break;
                    case 146:
                        if (this.refreshNoticeInfo == null) {
                            this.refreshNoticeInfo = new TopBannerBroadcastRefreshingNoticeInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.refreshNoticeInfo);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCTopBannerBroadcastNotice parseFrom(byte[] bArr) {
            return (SCTopBannerBroadcastNotice) MessageNano.mergeFrom(new SCTopBannerBroadcastNotice(), bArr);
        }

        public static SCTopBannerBroadcastNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCTopBannerBroadcastNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class TopBannerBroadcastRefreshingNoticeInfo extends MessageNano {
        private static volatile TopBannerBroadcastRefreshingNoticeInfo[] _emptyArray;
        public String backgroundColorBegin;
        public String backgroundColorEnd;
        public long displayDurationMillis;
        public boolean enableWipe;
        public String iconUrl;
        public int priorityType;
        public int routeType;

        public static TopBannerBroadcastRefreshingNoticeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TopBannerBroadcastRefreshingNoticeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TopBannerBroadcastRefreshingNoticeInfo() {
            clear();
        }

        public final TopBannerBroadcastRefreshingNoticeInfo clear() {
            this.priorityType = 0;
            this.routeType = 0;
            this.displayDurationMillis = 0L;
            this.iconUrl = "";
            this.enableWipe = false;
            this.backgroundColorBegin = "";
            this.backgroundColorEnd = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.priorityType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.routeType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.iconUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.iconUrl);
            }
            boolean z = this.enableWipe;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            if (!this.backgroundColorBegin.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.backgroundColorBegin);
            }
            if (!this.backgroundColorEnd.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.backgroundColorEnd);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.priorityType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.routeType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            long j = this.displayDurationMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            if (!this.iconUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.iconUrl);
            }
            boolean z = this.enableWipe;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            if (!this.backgroundColorBegin.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.backgroundColorBegin);
            }
            return !this.backgroundColorEnd.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.backgroundColorEnd) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TopBannerBroadcastRefreshingNoticeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                        this.priorityType = int32;
                    }
                } else if (tag == 16) {
                    this.routeType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.displayDurationMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 34) {
                    this.iconUrl = codedInputByteBufferNano.readString();
                } else if (tag == 40) {
                    this.enableWipe = codedInputByteBufferNano.readBool();
                } else if (tag == 50) {
                    this.backgroundColorBegin = codedInputByteBufferNano.readString();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.backgroundColorEnd = codedInputByteBufferNano.readString();
                }
            }
        }

        public static TopBannerBroadcastRefreshingNoticeInfo parseFrom(byte[] bArr) {
            return (TopBannerBroadcastRefreshingNoticeInfo) MessageNano.mergeFrom(new TopBannerBroadcastRefreshingNoticeInfo(), bArr);
        }

        public static TopBannerBroadcastRefreshingNoticeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TopBannerBroadcastRefreshingNoticeInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityPopAnimationPicInfo extends MessageNano {
        private static volatile LiveActivityPopAnimationPicInfo[] _emptyArray;
        public int loopCount;
        public int translateX;
        public int translateY;
        public UserInfos.PicUrl[] webpUrl;

        public static LiveActivityPopAnimationPicInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityPopAnimationPicInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityPopAnimationPicInfo() {
            clear();
        }

        public final LiveActivityPopAnimationPicInfo clear() {
            this.webpUrl = UserInfos.PicUrl.emptyArray();
            this.translateX = 0;
            this.translateY = 0;
            this.loopCount = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.webpUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.webpUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i++;
                }
            }
            int i2 = this.translateX;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            int i3 = this.translateY;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i3);
            }
            int i4 = this.loopCount;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.webpUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.webpUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i++;
                }
            }
            int i2 = this.translateX;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
            }
            int i3 = this.translateY;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
            }
            int i4 = this.loopCount;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityPopAnimationPicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.webpUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.webpUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.webpUrl = picUrlArr2;
                } else if (tag == 16) {
                    this.translateX = codedInputByteBufferNano.readInt32();
                } else if (tag == 24) {
                    this.translateY = codedInputByteBufferNano.readInt32();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.loopCount = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveActivityPopAnimationPicInfo parseFrom(byte[] bArr) {
            return (LiveActivityPopAnimationPicInfo) MessageNano.mergeFrom(new LiveActivityPopAnimationPicInfo(), bArr);
        }

        public static LiveActivityPopAnimationPicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityPopAnimationPicInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveCommonPopup extends MessageNano {
        private static volatile LiveCommonPopup[] _emptyArray;
        public String buttonContent;
        public long buttonCountdownSecond;
        public String detail;
        public LiveCdnNodeView[] iconCdnNodeView;
        public String title;

        public static LiveCommonPopup[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCommonPopup[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCommonPopup() {
            clear();
        }

        public final LiveCommonPopup clear() {
            this.iconCdnNodeView = LiveCdnNodeView.emptyArray();
            this.title = "";
            this.detail = "";
            this.buttonContent = "";
            this.buttonCountdownSecond = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.detail.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.detail);
            }
            if (!this.buttonContent.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.buttonContent);
            }
            long j = this.buttonCountdownSecond;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.detail.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.detail);
            }
            if (!this.buttonContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.buttonContent);
            }
            long j = this.buttonCountdownSecond;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCommonPopup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.iconCdnNodeView, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.iconCdnNodeView = liveCdnNodeViewArr2;
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.detail = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.buttonContent = codedInputByteBufferNano.readString();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.buttonCountdownSecond = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveCommonPopup parseFrom(byte[] bArr) {
            return (LiveCommonPopup) MessageNano.mergeFrom(new LiveCommonPopup(), bArr);
        }

        public static LiveCommonPopup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCommonPopup().mergeFrom(codedInputByteBufferNano);
        }
    }
}
