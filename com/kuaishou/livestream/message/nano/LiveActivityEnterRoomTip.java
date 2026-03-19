package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCommonNoticeMessages;
import com.kuaishou.protobuf.livestream.nano.LiveAudienceState;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichTextMessage;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveActivityEnterRoomTip extends MessageNano {
    private static volatile LiveActivityEnterRoomTip[] _emptyArray;
    public String activityBiz;
    public long animationIntervalMillis;
    public String animationKey;
    public String animationKeyV2;
    public String[] backgroudBorderColor;
    public int backgroundBorderWidth;
    public String[] backgroundColor;
    public UserInfos.PicUrl[] backgroundPicUrl;
    public LiveCommonNoticeMessages.StretchablePicture backgroundStretchablePicUrl;
    public LiveCommonEffectInfo commonEffectInfo;
    public String displayText;
    public int displayType;
    public UserInfos.PicUrl[] headPic;
    public int headPicHeight;
    public int headPicWidth;
    public int picHeight;
    public UserInfos.PicUrl[] picUrl;
    public int picWidth;
    public LiveCommentRichTextMessage.CommentRichTextSegment[] richTextArray;
    public int sizeOfAvatar;
    public int sizeOfCar;
    public int sizeOfHead;
    public int specialShapedPicHeight;
    public UserInfos.PicUrl[] specialShapedPicUrl;
    public int specialShapedPicWidth;
    public String textColor;
    public int textDisplayType;
    public int textLeftDistance;
    public boolean useCommonEffectInfo;
    public UserInfos.UserInfo user;
    public LiveAudienceState userState;
    public String welcomeAnimationKey;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EnterRoomTipDisplayType {
        public static final int ADVANCE = 2;
        public static final int ADVANCE_V2 = 3;
        public static final int ADVANCE_V3 = 5;
        public static final int NORMAL = 1;
        public static final int NORMAL_BIG = 4;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TextDisplayType {
        public static final int NORMAL_TEXT = 1;
        public static final int RICH_TEXT = 2;
        public static final int UNKNOWN_TYPE = 0;
    }

    public static LiveActivityEnterRoomTip[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveActivityEnterRoomTip[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveActivityEnterRoomTip() {
        clear();
    }

    public final LiveActivityEnterRoomTip clear() {
        this.user = null;
        this.userState = null;
        this.displayType = 0;
        this.picUrl = UserInfos.PicUrl.emptyArray();
        this.picWidth = 0;
        this.picHeight = 0;
        this.displayText = "";
        this.textColor = "";
        this.textLeftDistance = 0;
        this.backgroundBorderWidth = 0;
        this.backgroundColor = WireFormatNano.EMPTY_STRING_ARRAY;
        this.backgroudBorderColor = WireFormatNano.EMPTY_STRING_ARRAY;
        this.activityBiz = "";
        this.specialShapedPicUrl = UserInfos.PicUrl.emptyArray();
        this.specialShapedPicWidth = 0;
        this.specialShapedPicHeight = 0;
        this.backgroundPicUrl = UserInfos.PicUrl.emptyArray();
        this.animationKey = "";
        this.animationIntervalMillis = 0L;
        this.backgroundStretchablePicUrl = null;
        this.animationKeyV2 = "";
        this.welcomeAnimationKey = "";
        this.sizeOfAvatar = 0;
        this.sizeOfHead = 0;
        this.sizeOfCar = 0;
        this.headPic = UserInfos.PicUrl.emptyArray();
        this.headPicWidth = 0;
        this.headPicHeight = 0;
        this.useCommonEffectInfo = false;
        this.commonEffectInfo = null;
        this.textDisplayType = 0;
        this.richTextArray = LiveCommentRichTextMessage.CommentRichTextSegment.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(2, liveAudienceState);
        }
        int i = this.displayType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.picUrl;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(4, picUrl);
                }
                i3++;
            }
        }
        int i4 = this.picWidth;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i4);
        }
        int i5 = this.picHeight;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i5);
        }
        if (!this.displayText.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.displayText);
        }
        if (!this.textColor.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.textColor);
        }
        int i6 = this.textLeftDistance;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i6);
        }
        int i7 = this.backgroundBorderWidth;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i7);
        }
        String[] strArr = this.backgroundColor;
        if (strArr != null && strArr.length > 0) {
            int i8 = 0;
            while (true) {
                String[] strArr2 = this.backgroundColor;
                if (i8 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i8];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(11, str);
                }
                i8++;
            }
        }
        String[] strArr3 = this.backgroudBorderColor;
        if (strArr3 != null && strArr3.length > 0) {
            int i9 = 0;
            while (true) {
                String[] strArr4 = this.backgroudBorderColor;
                if (i9 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i9];
                if (str2 != null) {
                    codedOutputByteBufferNano.writeString(12, str2);
                }
                i9++;
            }
        }
        if (!this.activityBiz.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.activityBiz);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.specialShapedPicUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int i10 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.specialShapedPicUrl;
                if (i10 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i10];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(14, picUrl2);
                }
                i10++;
            }
        }
        int i11 = this.specialShapedPicWidth;
        if (i11 != 0) {
            codedOutputByteBufferNano.writeUInt32(15, i11);
        }
        int i12 = this.specialShapedPicHeight;
        if (i12 != 0) {
            codedOutputByteBufferNano.writeUInt32(16, i12);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.backgroundPicUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int i13 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.backgroundPicUrl;
                if (i13 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i13];
                if (picUrl3 != null) {
                    codedOutputByteBufferNano.writeMessage(17, picUrl3);
                }
                i13++;
            }
        }
        if (!this.animationKey.equals("")) {
            codedOutputByteBufferNano.writeString(18, this.animationKey);
        }
        long j = this.animationIntervalMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(19, j);
        }
        LiveCommonNoticeMessages.StretchablePicture stretchablePicture = this.backgroundStretchablePicUrl;
        if (stretchablePicture != null) {
            codedOutputByteBufferNano.writeMessage(20, stretchablePicture);
        }
        if (!this.animationKeyV2.equals("")) {
            codedOutputByteBufferNano.writeString(21, this.animationKeyV2);
        }
        if (!this.welcomeAnimationKey.equals("")) {
            codedOutputByteBufferNano.writeString(22, this.welcomeAnimationKey);
        }
        int i14 = this.sizeOfAvatar;
        if (i14 != 0) {
            codedOutputByteBufferNano.writeUInt32(23, i14);
        }
        int i15 = this.sizeOfHead;
        if (i15 != 0) {
            codedOutputByteBufferNano.writeUInt32(24, i15);
        }
        int i16 = this.sizeOfCar;
        if (i16 != 0) {
            codedOutputByteBufferNano.writeUInt32(25, i16);
        }
        UserInfos.PicUrl[] picUrlArr7 = this.headPic;
        if (picUrlArr7 != null && picUrlArr7.length > 0) {
            int i17 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr8 = this.headPic;
                if (i17 >= picUrlArr8.length) {
                    break;
                }
                UserInfos.PicUrl picUrl4 = picUrlArr8[i17];
                if (picUrl4 != null) {
                    codedOutputByteBufferNano.writeMessage(26, picUrl4);
                }
                i17++;
            }
        }
        int i18 = this.headPicWidth;
        if (i18 != 0) {
            codedOutputByteBufferNano.writeUInt32(27, i18);
        }
        int i19 = this.headPicHeight;
        if (i19 != 0) {
            codedOutputByteBufferNano.writeUInt32(28, i19);
        }
        boolean z = this.useCommonEffectInfo;
        if (z) {
            codedOutputByteBufferNano.writeBool(29, z);
        }
        LiveCommonEffectInfo liveCommonEffectInfo = this.commonEffectInfo;
        if (liveCommonEffectInfo != null) {
            codedOutputByteBufferNano.writeMessage(30, liveCommonEffectInfo);
        }
        int i20 = this.textDisplayType;
        if (i20 != 0) {
            codedOutputByteBufferNano.writeInt32(31, i20);
        }
        LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr = this.richTextArray;
        if (commentRichTextSegmentArr != null && commentRichTextSegmentArr.length > 0) {
            while (true) {
                LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr2 = this.richTextArray;
                if (i2 >= commentRichTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichTextMessage.CommentRichTextSegment commentRichTextSegment = commentRichTextSegmentArr2[i2];
                if (commentRichTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(32, commentRichTextSegment);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveAudienceState);
        }
        int i = this.displayType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.picUrl;
        int i2 = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        int i4 = this.picWidth;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i4);
        }
        int i5 = this.picHeight;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i5);
        }
        if (!this.displayText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.displayText);
        }
        if (!this.textColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.textColor);
        }
        int i6 = this.textLeftDistance;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i6);
        }
        int i7 = this.backgroundBorderWidth;
        if (i7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i7);
        }
        String[] strArr = this.backgroundColor;
        if (strArr != null && strArr.length > 0) {
            int i8 = 0;
            int iComputeStringSizeNoTag = 0;
            int i9 = 0;
            while (true) {
                String[] strArr2 = this.backgroundColor;
                if (i8 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i8];
                if (str != null) {
                    i9++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i8++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i9 * 1);
        }
        String[] strArr3 = this.backgroudBorderColor;
        if (strArr3 != null && strArr3.length > 0) {
            int i10 = 0;
            int iComputeStringSizeNoTag2 = 0;
            int i11 = 0;
            while (true) {
                String[] strArr4 = this.backgroudBorderColor;
                if (i10 >= strArr4.length) {
                    break;
                }
                String str2 = strArr4[i10];
                if (str2 != null) {
                    i11++;
                    iComputeStringSizeNoTag2 += CodedOutputByteBufferNano.computeStringSizeNoTag(str2);
                }
                i10++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag2 + (i11 * 1);
        }
        if (!this.activityBiz.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.activityBiz);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.specialShapedPicUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i12 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.specialShapedPicUrl;
                if (i12 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i12];
                if (picUrl2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(14, picUrl2);
                }
                i12++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        int i13 = this.specialShapedPicWidth;
        if (i13 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i13);
        }
        int i14 = this.specialShapedPicHeight;
        if (i14 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(16, i14);
        }
        UserInfos.PicUrl[] picUrlArr5 = this.backgroundPicUrl;
        if (picUrlArr5 != null && picUrlArr5.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i15 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr6 = this.backgroundPicUrl;
                if (i15 >= picUrlArr6.length) {
                    break;
                }
                UserInfos.PicUrl picUrl3 = picUrlArr6[i15];
                if (picUrl3 != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(17, picUrl3);
                }
                i15++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        if (!this.animationKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(18, this.animationKey);
        }
        long j = this.animationIntervalMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(19, j);
        }
        LiveCommonNoticeMessages.StretchablePicture stretchablePicture = this.backgroundStretchablePicUrl;
        if (stretchablePicture != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, stretchablePicture);
        }
        if (!this.animationKeyV2.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(21, this.animationKeyV2);
        }
        if (!this.welcomeAnimationKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(22, this.welcomeAnimationKey);
        }
        int i16 = this.sizeOfAvatar;
        if (i16 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(23, i16);
        }
        int i17 = this.sizeOfHead;
        if (i17 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(24, i17);
        }
        int i18 = this.sizeOfCar;
        if (i18 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(25, i18);
        }
        UserInfos.PicUrl[] picUrlArr7 = this.headPic;
        if (picUrlArr7 != null && picUrlArr7.length > 0) {
            int iComputeMessageSize4 = iComputeSerializedSize;
            int i19 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr8 = this.headPic;
                if (i19 >= picUrlArr8.length) {
                    break;
                }
                UserInfos.PicUrl picUrl4 = picUrlArr8[i19];
                if (picUrl4 != null) {
                    iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(26, picUrl4);
                }
                i19++;
            }
            iComputeSerializedSize = iComputeMessageSize4;
        }
        int i20 = this.headPicWidth;
        if (i20 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(27, i20);
        }
        int i21 = this.headPicHeight;
        if (i21 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(28, i21);
        }
        boolean z = this.useCommonEffectInfo;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(29, z);
        }
        LiveCommonEffectInfo liveCommonEffectInfo = this.commonEffectInfo;
        if (liveCommonEffectInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(30, liveCommonEffectInfo);
        }
        int i22 = this.textDisplayType;
        if (i22 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(31, i22);
        }
        LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr = this.richTextArray;
        if (commentRichTextSegmentArr != null && commentRichTextSegmentArr.length > 0) {
            while (true) {
                LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr2 = this.richTextArray;
                if (i2 >= commentRichTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichTextMessage.CommentRichTextSegment commentRichTextSegment = commentRichTextSegmentArr2[i2];
                if (commentRichTextSegment != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(32, commentRichTextSegment);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveActivityEnterRoomTip mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.user == null) {
                        this.user = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                    break;
                case 18:
                    if (this.userState == null) {
                        this.userState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.userState);
                    break;
                case 24:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4 && int32 != 5) {
                        break;
                    } else {
                        this.displayType = int32;
                        break;
                    }
                    break;
                case 34:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
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
                    break;
                case 40:
                    this.picWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.picHeight = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.displayText = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.textColor = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    this.textLeftDistance = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.backgroundBorderWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    String[] strArr = this.backgroundColor;
                    int length2 = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.backgroundColor, 0, strArr2, 0, length2);
                    }
                    while (length2 < strArr2.length - 1) {
                        strArr2[length2] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    this.backgroundColor = strArr2;
                    break;
                case 98:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                    String[] strArr3 = this.backgroudBorderColor;
                    int length3 = strArr3 == null ? 0 : strArr3.length;
                    String[] strArr4 = new String[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.backgroudBorderColor, 0, strArr4, 0, length3);
                    }
                    while (length3 < strArr4.length - 1) {
                        strArr4[length3] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    strArr4[length3] = codedInputByteBufferNano.readString();
                    this.backgroudBorderColor = strArr4;
                    break;
                case 106:
                    this.activityBiz = codedInputByteBufferNano.readString();
                    break;
                case 114:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 114);
                    UserInfos.PicUrl[] picUrlArr3 = this.specialShapedPicUrl;
                    int length4 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.specialShapedPicUrl, 0, picUrlArr4, 0, length4);
                    }
                    while (length4 < picUrlArr4.length - 1) {
                        picUrlArr4[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr4[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length4]);
                    this.specialShapedPicUrl = picUrlArr4;
                    break;
                case 120:
                    this.specialShapedPicWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 128:
                    this.specialShapedPicHeight = codedInputByteBufferNano.readUInt32();
                    break;
                case 138:
                    int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 138);
                    UserInfos.PicUrl[] picUrlArr5 = this.backgroundPicUrl;
                    int length5 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength5 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.backgroundPicUrl, 0, picUrlArr6, 0, length5);
                    }
                    while (length5 < picUrlArr6.length - 1) {
                        picUrlArr6[length5] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length5]);
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    picUrlArr6[length5] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length5]);
                    this.backgroundPicUrl = picUrlArr6;
                    break;
                case 146:
                    this.animationKey = codedInputByteBufferNano.readString();
                    break;
                case 152:
                    this.animationIntervalMillis = codedInputByteBufferNano.readUInt64();
                    break;
                case 162:
                    if (this.backgroundStretchablePicUrl == null) {
                        this.backgroundStretchablePicUrl = new LiveCommonNoticeMessages.StretchablePicture();
                    }
                    codedInputByteBufferNano.readMessage(this.backgroundStretchablePicUrl);
                    break;
                case 170:
                    this.animationKeyV2 = codedInputByteBufferNano.readString();
                    break;
                case 178:
                    this.welcomeAnimationKey = codedInputByteBufferNano.readString();
                    break;
                case 184:
                    this.sizeOfAvatar = codedInputByteBufferNano.readUInt32();
                    break;
                case 192:
                    this.sizeOfHead = codedInputByteBufferNano.readUInt32();
                    break;
                case 200:
                    this.sizeOfCar = codedInputByteBufferNano.readUInt32();
                    break;
                case 210:
                    int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 210);
                    UserInfos.PicUrl[] picUrlArr7 = this.headPic;
                    int length6 = picUrlArr7 == null ? 0 : picUrlArr7.length;
                    UserInfos.PicUrl[] picUrlArr8 = new UserInfos.PicUrl[repeatedFieldArrayLength6 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.headPic, 0, picUrlArr8, 0, length6);
                    }
                    while (length6 < picUrlArr8.length - 1) {
                        picUrlArr8[length6] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr8[length6]);
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    picUrlArr8[length6] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr8[length6]);
                    this.headPic = picUrlArr8;
                    break;
                case 216:
                    this.headPicWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 224:
                    this.headPicHeight = codedInputByteBufferNano.readUInt32();
                    break;
                case 232:
                    this.useCommonEffectInfo = codedInputByteBufferNano.readBool();
                    break;
                case 242:
                    if (this.commonEffectInfo == null) {
                        this.commonEffectInfo = new LiveCommonEffectInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.commonEffectInfo);
                    break;
                case 248:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2) {
                        break;
                    } else {
                        this.textDisplayType = int322;
                        break;
                    }
                    break;
                case 258:
                    int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 258);
                    LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr = this.richTextArray;
                    int length7 = commentRichTextSegmentArr == null ? 0 : commentRichTextSegmentArr.length;
                    LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr2 = new LiveCommentRichTextMessage.CommentRichTextSegment[repeatedFieldArrayLength7 + length7];
                    if (length7 != 0) {
                        System.arraycopy(this.richTextArray, 0, commentRichTextSegmentArr2, 0, length7);
                    }
                    while (length7 < commentRichTextSegmentArr2.length - 1) {
                        commentRichTextSegmentArr2[length7] = new LiveCommentRichTextMessage.CommentRichTextSegment();
                        codedInputByteBufferNano.readMessage(commentRichTextSegmentArr2[length7]);
                        codedInputByteBufferNano.readTag();
                        length7++;
                    }
                    commentRichTextSegmentArr2[length7] = new LiveCommentRichTextMessage.CommentRichTextSegment();
                    codedInputByteBufferNano.readMessage(commentRichTextSegmentArr2[length7]);
                    this.richTextArray = commentRichTextSegmentArr2;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveActivityEnterRoomTip parseFrom(byte[] bArr) {
        return (LiveActivityEnterRoomTip) MessageNano.mergeFrom(new LiveActivityEnterRoomTip(), bArr);
    }

    public static LiveActivityEnterRoomTip parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveActivityEnterRoomTip().mergeFrom(codedInputByteBufferNano);
    }
}
