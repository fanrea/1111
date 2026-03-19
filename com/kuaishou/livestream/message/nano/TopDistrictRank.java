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
public final class TopDistrictRank extends MessageNano {
    private static volatile TopDistrictRank[] _emptyArray;
    public int actionType;
    public String[] backgroundColor;
    public String benefitTextFirst;
    public String benefitTextSecond;
    public String benefitTextThird;
    public UserInfos.UserInfo[] contributorInfo;
    public String description;
    public String descriptionV2;
    public String displayRank;
    public boolean enableBenefit;
    public String extraInfo;
    public UserInfos.PicUrl[] globalTopBackgroundPicUrls;
    public int jumpToSubTabId;
    public int jumpToTab;
    public int jumpToTabId;
    public UserInfos.PicUrl[] noBenefitPicUrls;
    public int noticeType;
    public int rank;
    public String strikingDescription;
    public String strikingDisplayRank;
    public UserInfos.UserInfo[] strikingGuardInfo;
    public String strikingRankPeriod;
    public UserInfos.PicUrl[] tailIcon;
    public boolean useStrikingStyle;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ClickActionType {
        public static final int RANK_TYPE = 1;
        public static final int UNKNOWN_ACTION_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DistrictNoticeType {
        public static final int GLOBAL_HEAD_RANK_NOTICE = 5;
        public static final int HOUR_BULLET_PLAY_NOTICE = 7;
        public static final int HOUR_CITY_NOTICE = 6;
        public static final int HOUR_DISTRICT_NOTICE = 1;
        public static final int HOUR_GLOBAL_NOTICE = 3;
        public static final int IN_RANK_NOTICE = 2;
        public static final int PK_INVITATION_PRIVILEGE_GRANT = 4;
        public static final int ROOKIE_NOTICE = 8;
        public static final int UNKNOWN_DISTRICT_NOTICE_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DistrictTabType {
        public static final int BEAUTY_HOUR_RANK = 3;
        public static final int CITY = 4;
        public static final int DISTREICT = 2;
        public static final int GLOBAL = 1;
        public static final int JUMP_BY_TAB_ID = 5;
        public static final int UNKNOWN = 0;
    }

    public static TopDistrictRank[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TopDistrictRank[0];
                }
            }
        }
        return _emptyArray;
    }

    public TopDistrictRank() {
        clear();
    }

    public final TopDistrictRank clear() {
        this.rank = 0;
        this.description = "";
        this.contributorInfo = UserInfos.UserInfo.emptyArray();
        this.displayRank = "";
        this.descriptionV2 = "";
        this.useStrikingStyle = false;
        this.strikingDisplayRank = "";
        this.strikingRankPeriod = "";
        this.strikingDescription = "";
        this.strikingGuardInfo = UserInfos.UserInfo.emptyArray();
        this.noticeType = 0;
        this.actionType = 0;
        this.jumpToTab = 0;
        this.tailIcon = UserInfos.PicUrl.emptyArray();
        this.backgroundColor = WireFormatNano.EMPTY_STRING_ARRAY;
        this.globalTopBackgroundPicUrls = UserInfos.PicUrl.emptyArray();
        this.enableBenefit = false;
        this.benefitTextFirst = "";
        this.benefitTextSecond = "";
        this.benefitTextThird = "";
        this.noBenefitPicUrls = UserInfos.PicUrl.emptyArray();
        this.extraInfo = "";
        this.jumpToTabId = 0;
        this.jumpToSubTabId = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.rank;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.description.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.description);
        }
        UserInfos.UserInfo[] userInfoArr = this.contributorInfo;
        int i2 = 0;
        if (userInfoArr != null && userInfoArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr2 = this.contributorInfo;
                if (i3 >= userInfoArr2.length) {
                    break;
                }
                UserInfos.UserInfo userInfo = userInfoArr2[i3];
                if (userInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, userInfo);
                }
                i3++;
            }
        }
        if (!this.displayRank.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.displayRank);
        }
        if (!this.descriptionV2.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.descriptionV2);
        }
        boolean z = this.useStrikingStyle;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        if (!this.strikingDisplayRank.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.strikingDisplayRank);
        }
        if (!this.strikingRankPeriod.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.strikingRankPeriod);
        }
        if (!this.strikingDescription.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.strikingDescription);
        }
        UserInfos.UserInfo[] userInfoArr3 = this.strikingGuardInfo;
        if (userInfoArr3 != null && userInfoArr3.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr4 = this.strikingGuardInfo;
                if (i4 >= userInfoArr4.length) {
                    break;
                }
                UserInfos.UserInfo userInfo2 = userInfoArr4[i4];
                if (userInfo2 != null) {
                    codedOutputByteBufferNano.writeMessage(10, userInfo2);
                }
                i4++;
            }
        }
        int i5 = this.noticeType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i5);
        }
        int i6 = this.actionType;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i6);
        }
        int i7 = this.jumpToTab;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeInt32(13, i7);
        }
        UserInfos.PicUrl[] picUrlArr = this.tailIcon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i8 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.tailIcon;
                if (i8 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i8];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(14, picUrl);
                }
                i8++;
            }
        }
        String[] strArr = this.backgroundColor;
        if (strArr != null && strArr.length > 0) {
            int i9 = 0;
            while (true) {
                String[] strArr2 = this.backgroundColor;
                if (i9 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i9];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(15, str);
                }
                i9++;
            }
        }
        UserInfos.PicUrl[] picUrlArr3 = this.globalTopBackgroundPicUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i10 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.globalTopBackgroundPicUrls;
                if (i10 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i10];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(16, picUrl2);
                }
                i10++;
            }
        }
        boolean z2 = this.enableBenefit;
        if (z2) {
            codedOutputByteBufferNano.writeBool(17, z2);
        }
        if (!this.benefitTextFirst.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.benefitTextFirst);
        }
        if (!this.benefitTextSecond.equals("")) {
            codedOutputByteBufferNano.writeString(19, this.benefitTextSecond);
        }
        if (!this.benefitTextThird.equals("")) {
            codedOutputByteBufferNano.writeString(20, this.benefitTextThird);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.noBenefitPicUrls;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.noBenefitPicUrls;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(21, picUrl3);
                }
                i2++;
            }
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.extraInfo);
        }
        int i11 = this.jumpToTabId;
        if (i11 != 0) {
            codedOutputByteBufferNano.writeUInt32(23, i11);
        }
        int i12 = this.jumpToSubTabId;
        if (i12 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i12);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.rank;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.description.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.description);
        }
        UserInfos.UserInfo[] userInfoArr = this.contributorInfo;
        int i2 = 0;
        if (userInfoArr != null && userInfoArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr2 = this.contributorInfo;
                if (i3 >= userInfoArr2.length) {
                    break;
                }
                UserInfos.UserInfo userInfo = userInfoArr2[i3];
                if (userInfo != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.displayRank.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayRank);
        }
        if (!this.descriptionV2.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.descriptionV2);
        }
        boolean z = this.useStrikingStyle;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        if (!this.strikingDisplayRank.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.strikingDisplayRank);
        }
        if (!this.strikingRankPeriod.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.strikingRankPeriod);
        }
        if (!this.strikingDescription.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.strikingDescription);
        }
        UserInfos.UserInfo[] userInfoArr3 = this.strikingGuardInfo;
        if (userInfoArr3 != null && userInfoArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.UserInfo[] userInfoArr4 = this.strikingGuardInfo;
                if (i4 >= userInfoArr4.length) {
                    break;
                }
                UserInfos.UserInfo userInfo2 = userInfoArr4[i4];
                if (userInfo2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(10, userInfo2);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        int i5 = this.noticeType;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i5);
        }
        int i6 = this.actionType;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i6);
        }
        int i7 = this.jumpToTab;
        if (i7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(13, i7);
        }
        UserInfos.PicUrl[] picUrlArr = this.tailIcon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i8 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.tailIcon;
                if (i8 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i8];
                if (picUrl != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(14, picUrl);
                }
                i8++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        String[] strArr = this.backgroundColor;
        if (strArr != null && strArr.length > 0) {
            int i9 = 0;
            int iComputeStringSizeNoTag = 0;
            int i10 = 0;
            while (true) {
                String[] strArr2 = this.backgroundColor;
                if (i9 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i9];
                if (str != null) {
                    i10++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i9++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i10 * 1);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.globalTopBackgroundPicUrls;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize4 = iComputeSerializedSize;
            int i11 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.globalTopBackgroundPicUrls;
                if (i11 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i11];
                if (picUrl2 != null) {
                    iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(16, picUrl2);
                }
                i11++;
            }
            iComputeSerializedSize = iComputeMessageSize4;
        }
        boolean z2 = this.enableBenefit;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z2);
        }
        if (!this.benefitTextFirst.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.benefitTextFirst);
        }
        if (!this.benefitTextSecond.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.benefitTextSecond);
        }
        if (!this.benefitTextThird.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.benefitTextThird);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.noBenefitPicUrls;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.noBenefitPicUrls;
                if (i2 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i2];
                if (picUrl3 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, picUrl3);
                }
                i2++;
            }
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.extraInfo);
        }
        int i12 = this.jumpToTabId;
        if (i12 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(23, i12);
        }
        int i13 = this.jumpToSubTabId;
        return i13 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(24, i13) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TopDistrictRank mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.description = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.UserInfo[] userInfoArr = this.contributorInfo;
                    int length = userInfoArr == null ? 0 : userInfoArr.length;
                    UserInfos.UserInfo[] userInfoArr2 = new UserInfos.UserInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.contributorInfo, 0, userInfoArr2, 0, length);
                    }
                    while (length < userInfoArr2.length - 1) {
                        userInfoArr2[length] = new UserInfos.UserInfo();
                        codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    userInfoArr2[length] = new UserInfos.UserInfo();
                    codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                    this.contributorInfo = userInfoArr2;
                    break;
                case 34:
                    this.displayRank = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.descriptionV2 = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.useStrikingStyle = codedInputByteBufferNano.readBool();
                    break;
                case 58:
                    this.strikingDisplayRank = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.strikingRankPeriod = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.strikingDescription = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    UserInfos.UserInfo[] userInfoArr3 = this.strikingGuardInfo;
                    int length2 = userInfoArr3 == null ? 0 : userInfoArr3.length;
                    UserInfos.UserInfo[] userInfoArr4 = new UserInfos.UserInfo[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.strikingGuardInfo, 0, userInfoArr4, 0, length2);
                    }
                    while (length2 < userInfoArr4.length - 1) {
                        userInfoArr4[length2] = new UserInfos.UserInfo();
                        codedInputByteBufferNano.readMessage(userInfoArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    userInfoArr4[length2] = new UserInfos.UserInfo();
                    codedInputByteBufferNano.readMessage(userInfoArr4[length2]);
                    this.strikingGuardInfo = userInfoArr4;
                    break;
                case 88:
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
                            this.noticeType = int32;
                            break;
                    }
                case 96:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1) {
                        break;
                    } else {
                        this.actionType = int322;
                        break;
                    }
                case 104:
                    int int323 = codedInputByteBufferNano.readInt32();
                    if (int323 != 0 && int323 != 1 && int323 != 2 && int323 != 3 && int323 != 4 && int323 != 5) {
                        break;
                    } else {
                        this.jumpToTab = int323;
                        break;
                    }
                    break;
                case 114:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    UserInfos.PicUrl[] picUrlArr = this.tailIcon;
                    int length3 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.tailIcon, 0, picUrlArr2, 0, length3);
                    }
                    while (length3 < picUrlArr2.length - 1) {
                        picUrlArr2[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr2[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                    this.tailIcon = picUrlArr2;
                    break;
                case 122:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                    String[] strArr = this.backgroundColor;
                    int length4 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.backgroundColor, 0, strArr2, 0, length4);
                    }
                    while (length4 < strArr2.length - 1) {
                        strArr2[length4] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    strArr2[length4] = codedInputByteBufferNano.readString();
                    this.backgroundColor = strArr2;
                    break;
                case 130:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                    UserInfos.PicUrl[] picUrlArr3 = this.globalTopBackgroundPicUrls;
                    int length5 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.globalTopBackgroundPicUrls, 0, picUrlArr4, 0, length5);
                    }
                    while (length5 < picUrlArr4.length - 1) {
                        picUrlArr4[length5] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length5]);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    picUrlArr4[length5] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length5]);
                    this.globalTopBackgroundPicUrls = picUrlArr4;
                    break;
                case 136:
                    this.enableBenefit = codedInputByteBufferNano.readBool();
                    break;
                case 146:
                    this.benefitTextFirst = codedInputByteBufferNano.readString();
                    break;
                case 154:
                    this.benefitTextSecond = codedInputByteBufferNano.readString();
                    break;
                case 162:
                    this.benefitTextThird = codedInputByteBufferNano.readString();
                    break;
                case 170:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                    UserInfos.PicUrl[] picUrlArr5 = this.noBenefitPicUrls;
                    int length6 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength6 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.noBenefitPicUrls, 0, picUrlArr6, 0, length6);
                    }
                    while (length6 < picUrlArr6.length - 1) {
                        picUrlArr6[length6] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length6]);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    picUrlArr6[length6] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length6]);
                    this.noBenefitPicUrls = picUrlArr6;
                    break;
                case 178:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                case 184:
                    this.jumpToTabId = codedInputByteBufferNano.readUInt32();
                    break;
                case 192:
                    this.jumpToSubTabId = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static TopDistrictRank parseFrom(byte[] bArr) {
        return (TopDistrictRank) MessageNano.mergeFrom(new TopDistrictRank(), bArr);
    }

    public static TopDistrictRank parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TopDistrictRank().mergeFrom(codedInputByteBufferNano);
    }
}
