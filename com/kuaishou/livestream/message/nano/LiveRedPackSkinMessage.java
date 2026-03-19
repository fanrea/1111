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
public interface LiveRedPackSkinMessage {

    @Retention(RetentionPolicy.SOURCE)
    public @interface RedPackSkinType {
        public static final int GIFT = 1;
        public static final int KS_COIN = 2;
        public static final int NO_EXPOSE = 3;
        public static final int SKIN_UNKNOWN = 0;
    }

    public static final class RedPackSkinTheme extends MessageNano {
        private static volatile RedPackSkinTheme[] _emptyArray;
        public String authorContent;
        public UserInfos.PicUrl[] bgHolidayBottomPict;
        public UserInfos.PicUrl[] bgHolidayPict;
        public UserInfos.PicUrl[] bgResultPict;
        public String bgThemeColor;
        public String bottomContent;
        public String bottomContentLink;
        public int bottomContentLinkType;
        public UserInfos.PicUrl[] bottomIcon;
        public ImageTextInfo bottomTip;
        public ImageTextInfo bottomTipReplace;
        public UserInfos.PicUrl[] coverBottomPict;
        public UserInfos.PicUrl[] coverTopPict;
        public String decisionColor;
        public RedPackSkinButtonInfo defaultButton;
        public UserInfos.PicUrl[] disableDirectFollowPict;
        public RedPackSkinButtonInfo followButton;
        public UserInfos.PicUrl[] followPict;
        public RedPackItemColorConfig grabItemColorConfig;
        public RedPackSkinInnerInfo innerInfo;
        public boolean needBookReservation;
        public boolean needFollow;
        public boolean needReserve;
        public RedPackSkinButtonInfo openButton;
        public UserInfos.PicUrl[] openDynamicPic;
        public RedPackSkinButtonInfo outsideBottomTip;
        public RedPackItemColorConfig prepareItemColorConfig;
        public RedPackSkinButtonInfo receiveButton;
        public String redPacketPopAnimationKey;
        public String reeeItemDescriptionColor;
        public String reservationId;
        public RedPackSkinButtonInfo reserveButton;
        public RedPackSkinButtonInfo reserveFollowButton;
        public int skinType;
        public boolean superCover;
        public UserInfos.PicUrl[] unFollowPict;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ActionType {
            public static final int ROUTER = 1;
            public static final int UNKNOWN = 0;
        }

        public static RedPackSkinTheme[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackSkinTheme[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackSkinTheme() {
            clear();
        }

        public final RedPackSkinTheme clear() {
            this.skinType = 0;
            this.coverTopPict = UserInfos.PicUrl.emptyArray();
            this.coverBottomPict = UserInfos.PicUrl.emptyArray();
            this.bgHolidayPict = UserInfos.PicUrl.emptyArray();
            this.followPict = UserInfos.PicUrl.emptyArray();
            this.unFollowPict = UserInfos.PicUrl.emptyArray();
            this.bgThemeColor = "";
            this.openButton = null;
            this.followButton = null;
            this.innerInfo = null;
            this.receiveButton = null;
            this.openDynamicPic = UserInfos.PicUrl.emptyArray();
            this.authorContent = "";
            this.bottomContent = "";
            this.bgResultPict = UserInfos.PicUrl.emptyArray();
            this.bgHolidayBottomPict = UserInfos.PicUrl.emptyArray();
            this.needFollow = false;
            this.bottomIcon = UserInfos.PicUrl.emptyArray();
            this.bottomContentLink = "";
            this.bottomContentLinkType = 0;
            this.disableDirectFollowPict = UserInfos.PicUrl.emptyArray();
            this.bottomTip = null;
            this.bottomTipReplace = null;
            this.outsideBottomTip = null;
            this.redPacketPopAnimationKey = "";
            this.needReserve = false;
            this.reservationId = "";
            this.reserveButton = null;
            this.reserveFollowButton = null;
            this.defaultButton = null;
            this.needBookReservation = false;
            this.prepareItemColorConfig = null;
            this.grabItemColorConfig = null;
            this.reeeItemDescriptionColor = "";
            this.decisionColor = "";
            this.superCover = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.skinType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.coverTopPict;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.coverTopPict;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.coverBottomPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.coverBottomPict;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl2);
                    }
                    i4++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.bgHolidayPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.bgHolidayPict;
                    if (i5 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i5];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl3);
                    }
                    i5++;
                }
            }
            UserInfos.PicUrl[] picUrlArr7 = this.followPict;
            if (picUrlArr7 != null && picUrlArr7.length > 0) {
                int i6 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr8 = this.followPict;
                    if (i6 >= picUrlArr8.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl4 = picUrlArr8[i6];
                    if (picUrl4 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl4);
                    }
                    i6++;
                }
            }
            UserInfos.PicUrl[] picUrlArr9 = this.unFollowPict;
            if (picUrlArr9 != null && picUrlArr9.length > 0) {
                int i7 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr10 = this.unFollowPict;
                    if (i7 >= picUrlArr10.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl5 = picUrlArr10[i7];
                    if (picUrl5 != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl5);
                    }
                    i7++;
                }
            }
            if (!this.bgThemeColor.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.bgThemeColor);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo = this.openButton;
            if (redPackSkinButtonInfo != null) {
                codedOutputByteBufferNano.writeMessage(8, redPackSkinButtonInfo);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo2 = this.followButton;
            if (redPackSkinButtonInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(9, redPackSkinButtonInfo2);
            }
            RedPackSkinInnerInfo redPackSkinInnerInfo = this.innerInfo;
            if (redPackSkinInnerInfo != null) {
                codedOutputByteBufferNano.writeMessage(10, redPackSkinInnerInfo);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo3 = this.receiveButton;
            if (redPackSkinButtonInfo3 != null) {
                codedOutputByteBufferNano.writeMessage(11, redPackSkinButtonInfo3);
            }
            UserInfos.PicUrl[] picUrlArr11 = this.openDynamicPic;
            if (picUrlArr11 != null && picUrlArr11.length > 0) {
                int i8 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr12 = this.openDynamicPic;
                    if (i8 >= picUrlArr12.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl6 = picUrlArr12[i8];
                    if (picUrl6 != null) {
                        codedOutputByteBufferNano.writeMessage(12, picUrl6);
                    }
                    i8++;
                }
            }
            if (!this.authorContent.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.authorContent);
            }
            if (!this.bottomContent.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.bottomContent);
            }
            UserInfos.PicUrl[] picUrlArr13 = this.bgResultPict;
            if (picUrlArr13 != null && picUrlArr13.length > 0) {
                int i9 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr14 = this.bgResultPict;
                    if (i9 >= picUrlArr14.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl7 = picUrlArr14[i9];
                    if (picUrl7 != null) {
                        codedOutputByteBufferNano.writeMessage(15, picUrl7);
                    }
                    i9++;
                }
            }
            UserInfos.PicUrl[] picUrlArr15 = this.bgHolidayBottomPict;
            if (picUrlArr15 != null && picUrlArr15.length > 0) {
                int i10 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr16 = this.bgHolidayBottomPict;
                    if (i10 >= picUrlArr16.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl8 = picUrlArr16[i10];
                    if (picUrl8 != null) {
                        codedOutputByteBufferNano.writeMessage(16, picUrl8);
                    }
                    i10++;
                }
            }
            boolean z = this.needFollow;
            if (z) {
                codedOutputByteBufferNano.writeBool(17, z);
            }
            UserInfos.PicUrl[] picUrlArr17 = this.bottomIcon;
            if (picUrlArr17 != null && picUrlArr17.length > 0) {
                int i11 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr18 = this.bottomIcon;
                    if (i11 >= picUrlArr18.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl9 = picUrlArr18[i11];
                    if (picUrl9 != null) {
                        codedOutputByteBufferNano.writeMessage(18, picUrl9);
                    }
                    i11++;
                }
            }
            if (!this.bottomContentLink.equals("")) {
                codedOutputByteBufferNano.writeString(19, this.bottomContentLink);
            }
            int i12 = this.bottomContentLinkType;
            if (i12 != 0) {
                codedOutputByteBufferNano.writeInt32(20, i12);
            }
            UserInfos.PicUrl[] picUrlArr19 = this.disableDirectFollowPict;
            if (picUrlArr19 != null && picUrlArr19.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr20 = this.disableDirectFollowPict;
                    if (i2 >= picUrlArr20.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl10 = picUrlArr20[i2];
                    if (picUrl10 != null) {
                        codedOutputByteBufferNano.writeMessage(21, picUrl10);
                    }
                    i2++;
                }
            }
            ImageTextInfo imageTextInfo = this.bottomTip;
            if (imageTextInfo != null) {
                codedOutputByteBufferNano.writeMessage(22, imageTextInfo);
            }
            ImageTextInfo imageTextInfo2 = this.bottomTipReplace;
            if (imageTextInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(23, imageTextInfo2);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo4 = this.outsideBottomTip;
            if (redPackSkinButtonInfo4 != null) {
                codedOutputByteBufferNano.writeMessage(24, redPackSkinButtonInfo4);
            }
            if (!this.redPacketPopAnimationKey.equals("")) {
                codedOutputByteBufferNano.writeString(25, this.redPacketPopAnimationKey);
            }
            boolean z2 = this.needReserve;
            if (z2) {
                codedOutputByteBufferNano.writeBool(26, z2);
            }
            if (!this.reservationId.equals("")) {
                codedOutputByteBufferNano.writeString(27, this.reservationId);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo5 = this.reserveButton;
            if (redPackSkinButtonInfo5 != null) {
                codedOutputByteBufferNano.writeMessage(28, redPackSkinButtonInfo5);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo6 = this.reserveFollowButton;
            if (redPackSkinButtonInfo6 != null) {
                codedOutputByteBufferNano.writeMessage(29, redPackSkinButtonInfo6);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo7 = this.defaultButton;
            if (redPackSkinButtonInfo7 != null) {
                codedOutputByteBufferNano.writeMessage(30, redPackSkinButtonInfo7);
            }
            boolean z3 = this.needBookReservation;
            if (z3) {
                codedOutputByteBufferNano.writeBool(31, z3);
            }
            RedPackItemColorConfig redPackItemColorConfig = this.prepareItemColorConfig;
            if (redPackItemColorConfig != null) {
                codedOutputByteBufferNano.writeMessage(32, redPackItemColorConfig);
            }
            RedPackItemColorConfig redPackItemColorConfig2 = this.grabItemColorConfig;
            if (redPackItemColorConfig2 != null) {
                codedOutputByteBufferNano.writeMessage(33, redPackItemColorConfig2);
            }
            if (!this.reeeItemDescriptionColor.equals("")) {
                codedOutputByteBufferNano.writeString(34, this.reeeItemDescriptionColor);
            }
            if (!this.decisionColor.equals("")) {
                codedOutputByteBufferNano.writeString(35, this.decisionColor);
            }
            boolean z4 = this.superCover;
            if (z4) {
                codedOutputByteBufferNano.writeBool(36, z4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.skinType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.coverTopPict;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.coverTopPict;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.coverBottomPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.coverBottomPict;
                    if (i4 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(3, picUrl2);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr5 = this.bgHolidayPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i5 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.bgHolidayPict;
                    if (i5 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i5];
                    if (picUrl3 != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(4, picUrl3);
                    }
                    i5++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            UserInfos.PicUrl[] picUrlArr7 = this.followPict;
            if (picUrlArr7 != null && picUrlArr7.length > 0) {
                int iComputeMessageSize4 = iComputeSerializedSize;
                int i6 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr8 = this.followPict;
                    if (i6 >= picUrlArr8.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl4 = picUrlArr8[i6];
                    if (picUrl4 != null) {
                        iComputeMessageSize4 += CodedOutputByteBufferNano.computeMessageSize(5, picUrl4);
                    }
                    i6++;
                }
                iComputeSerializedSize = iComputeMessageSize4;
            }
            UserInfos.PicUrl[] picUrlArr9 = this.unFollowPict;
            if (picUrlArr9 != null && picUrlArr9.length > 0) {
                int iComputeMessageSize5 = iComputeSerializedSize;
                int i7 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr10 = this.unFollowPict;
                    if (i7 >= picUrlArr10.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl5 = picUrlArr10[i7];
                    if (picUrl5 != null) {
                        iComputeMessageSize5 += CodedOutputByteBufferNano.computeMessageSize(6, picUrl5);
                    }
                    i7++;
                }
                iComputeSerializedSize = iComputeMessageSize5;
            }
            if (!this.bgThemeColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.bgThemeColor);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo = this.openButton;
            if (redPackSkinButtonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, redPackSkinButtonInfo);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo2 = this.followButton;
            if (redPackSkinButtonInfo2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, redPackSkinButtonInfo2);
            }
            RedPackSkinInnerInfo redPackSkinInnerInfo = this.innerInfo;
            if (redPackSkinInnerInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, redPackSkinInnerInfo);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo3 = this.receiveButton;
            if (redPackSkinButtonInfo3 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, redPackSkinButtonInfo3);
            }
            UserInfos.PicUrl[] picUrlArr11 = this.openDynamicPic;
            if (picUrlArr11 != null && picUrlArr11.length > 0) {
                int iComputeMessageSize6 = iComputeSerializedSize;
                int i8 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr12 = this.openDynamicPic;
                    if (i8 >= picUrlArr12.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl6 = picUrlArr12[i8];
                    if (picUrl6 != null) {
                        iComputeMessageSize6 += CodedOutputByteBufferNano.computeMessageSize(12, picUrl6);
                    }
                    i8++;
                }
                iComputeSerializedSize = iComputeMessageSize6;
            }
            if (!this.authorContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.authorContent);
            }
            if (!this.bottomContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.bottomContent);
            }
            UserInfos.PicUrl[] picUrlArr13 = this.bgResultPict;
            if (picUrlArr13 != null && picUrlArr13.length > 0) {
                int iComputeMessageSize7 = iComputeSerializedSize;
                int i9 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr14 = this.bgResultPict;
                    if (i9 >= picUrlArr14.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl7 = picUrlArr14[i9];
                    if (picUrl7 != null) {
                        iComputeMessageSize7 += CodedOutputByteBufferNano.computeMessageSize(15, picUrl7);
                    }
                    i9++;
                }
                iComputeSerializedSize = iComputeMessageSize7;
            }
            UserInfos.PicUrl[] picUrlArr15 = this.bgHolidayBottomPict;
            if (picUrlArr15 != null && picUrlArr15.length > 0) {
                int iComputeMessageSize8 = iComputeSerializedSize;
                int i10 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr16 = this.bgHolidayBottomPict;
                    if (i10 >= picUrlArr16.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl8 = picUrlArr16[i10];
                    if (picUrl8 != null) {
                        iComputeMessageSize8 += CodedOutputByteBufferNano.computeMessageSize(16, picUrl8);
                    }
                    i10++;
                }
                iComputeSerializedSize = iComputeMessageSize8;
            }
            boolean z = this.needFollow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(17, z);
            }
            UserInfos.PicUrl[] picUrlArr17 = this.bottomIcon;
            if (picUrlArr17 != null && picUrlArr17.length > 0) {
                int iComputeMessageSize9 = iComputeSerializedSize;
                int i11 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr18 = this.bottomIcon;
                    if (i11 >= picUrlArr18.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl9 = picUrlArr18[i11];
                    if (picUrl9 != null) {
                        iComputeMessageSize9 += CodedOutputByteBufferNano.computeMessageSize(18, picUrl9);
                    }
                    i11++;
                }
                iComputeSerializedSize = iComputeMessageSize9;
            }
            if (!this.bottomContentLink.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(19, this.bottomContentLink);
            }
            int i12 = this.bottomContentLinkType;
            if (i12 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(20, i12);
            }
            UserInfos.PicUrl[] picUrlArr19 = this.disableDirectFollowPict;
            if (picUrlArr19 != null && picUrlArr19.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr20 = this.disableDirectFollowPict;
                    if (i2 >= picUrlArr20.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl10 = picUrlArr20[i2];
                    if (picUrl10 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, picUrl10);
                    }
                    i2++;
                }
            }
            ImageTextInfo imageTextInfo = this.bottomTip;
            if (imageTextInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, imageTextInfo);
            }
            ImageTextInfo imageTextInfo2 = this.bottomTipReplace;
            if (imageTextInfo2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, imageTextInfo2);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo4 = this.outsideBottomTip;
            if (redPackSkinButtonInfo4 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, redPackSkinButtonInfo4);
            }
            if (!this.redPacketPopAnimationKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(25, this.redPacketPopAnimationKey);
            }
            boolean z2 = this.needReserve;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(26, z2);
            }
            if (!this.reservationId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(27, this.reservationId);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo5 = this.reserveButton;
            if (redPackSkinButtonInfo5 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(28, redPackSkinButtonInfo5);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo6 = this.reserveFollowButton;
            if (redPackSkinButtonInfo6 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(29, redPackSkinButtonInfo6);
            }
            RedPackSkinButtonInfo redPackSkinButtonInfo7 = this.defaultButton;
            if (redPackSkinButtonInfo7 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(30, redPackSkinButtonInfo7);
            }
            boolean z3 = this.needBookReservation;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(31, z3);
            }
            RedPackItemColorConfig redPackItemColorConfig = this.prepareItemColorConfig;
            if (redPackItemColorConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(32, redPackItemColorConfig);
            }
            RedPackItemColorConfig redPackItemColorConfig2 = this.grabItemColorConfig;
            if (redPackItemColorConfig2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(33, redPackItemColorConfig2);
            }
            if (!this.reeeItemDescriptionColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(34, this.reeeItemDescriptionColor);
            }
            if (!this.decisionColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(35, this.decisionColor);
            }
            boolean z4 = this.superCover;
            return z4 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(36, z4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackSkinTheme mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                            break;
                        } else {
                            this.skinType = int32;
                            break;
                        }
                    case 18:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        UserInfos.PicUrl[] picUrlArr = this.coverTopPict;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.coverTopPict, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.coverTopPict = picUrlArr2;
                        break;
                    case 26:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        UserInfos.PicUrl[] picUrlArr3 = this.coverBottomPict;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.coverBottomPict, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.coverBottomPict = picUrlArr4;
                        break;
                    case 34:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                        UserInfos.PicUrl[] picUrlArr5 = this.bgHolidayPict;
                        int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                        UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.bgHolidayPict, 0, picUrlArr6, 0, length3);
                        }
                        while (length3 < picUrlArr6.length - 1) {
                            picUrlArr6[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        this.bgHolidayPict = picUrlArr6;
                        break;
                    case 42:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        UserInfos.PicUrl[] picUrlArr7 = this.followPict;
                        int length4 = picUrlArr7 == null ? 0 : picUrlArr7.length;
                        UserInfos.PicUrl[] picUrlArr8 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.followPict, 0, picUrlArr8, 0, length4);
                        }
                        while (length4 < picUrlArr8.length - 1) {
                            picUrlArr8[length4] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        picUrlArr8[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr8[length4]);
                        this.followPict = picUrlArr8;
                        break;
                    case 50:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        UserInfos.PicUrl[] picUrlArr9 = this.unFollowPict;
                        int length5 = picUrlArr9 == null ? 0 : picUrlArr9.length;
                        UserInfos.PicUrl[] picUrlArr10 = new UserInfos.PicUrl[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.unFollowPict, 0, picUrlArr10, 0, length5);
                        }
                        while (length5 < picUrlArr10.length - 1) {
                            picUrlArr10[length5] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr10[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        picUrlArr10[length5] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr10[length5]);
                        this.unFollowPict = picUrlArr10;
                        break;
                    case 58:
                        this.bgThemeColor = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        if (this.openButton == null) {
                            this.openButton = new RedPackSkinButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.openButton);
                        break;
                    case 74:
                        if (this.followButton == null) {
                            this.followButton = new RedPackSkinButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.followButton);
                        break;
                    case 82:
                        if (this.innerInfo == null) {
                            this.innerInfo = new RedPackSkinInnerInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.innerInfo);
                        break;
                    case 90:
                        if (this.receiveButton == null) {
                            this.receiveButton = new RedPackSkinButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.receiveButton);
                        break;
                    case 98:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                        UserInfos.PicUrl[] picUrlArr11 = this.openDynamicPic;
                        int length6 = picUrlArr11 == null ? 0 : picUrlArr11.length;
                        UserInfos.PicUrl[] picUrlArr12 = new UserInfos.PicUrl[repeatedFieldArrayLength6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.openDynamicPic, 0, picUrlArr12, 0, length6);
                        }
                        while (length6 < picUrlArr12.length - 1) {
                            picUrlArr12[length6] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr12[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        picUrlArr12[length6] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr12[length6]);
                        this.openDynamicPic = picUrlArr12;
                        break;
                    case 106:
                        this.authorContent = codedInputByteBufferNano.readString();
                        break;
                    case 114:
                        this.bottomContent = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 122);
                        UserInfos.PicUrl[] picUrlArr13 = this.bgResultPict;
                        int length7 = picUrlArr13 == null ? 0 : picUrlArr13.length;
                        UserInfos.PicUrl[] picUrlArr14 = new UserInfos.PicUrl[repeatedFieldArrayLength7 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.bgResultPict, 0, picUrlArr14, 0, length7);
                        }
                        while (length7 < picUrlArr14.length - 1) {
                            picUrlArr14[length7] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr14[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        picUrlArr14[length7] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr14[length7]);
                        this.bgResultPict = picUrlArr14;
                        break;
                    case 130:
                        int repeatedFieldArrayLength8 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 130);
                        UserInfos.PicUrl[] picUrlArr15 = this.bgHolidayBottomPict;
                        int length8 = picUrlArr15 == null ? 0 : picUrlArr15.length;
                        UserInfos.PicUrl[] picUrlArr16 = new UserInfos.PicUrl[repeatedFieldArrayLength8 + length8];
                        if (length8 != 0) {
                            System.arraycopy(this.bgHolidayBottomPict, 0, picUrlArr16, 0, length8);
                        }
                        while (length8 < picUrlArr16.length - 1) {
                            picUrlArr16[length8] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr16[length8]);
                            codedInputByteBufferNano.readTag();
                            length8++;
                        }
                        picUrlArr16[length8] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr16[length8]);
                        this.bgHolidayBottomPict = picUrlArr16;
                        break;
                    case 136:
                        this.needFollow = codedInputByteBufferNano.readBool();
                        break;
                    case 146:
                        int repeatedFieldArrayLength9 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 146);
                        UserInfos.PicUrl[] picUrlArr17 = this.bottomIcon;
                        int length9 = picUrlArr17 == null ? 0 : picUrlArr17.length;
                        UserInfos.PicUrl[] picUrlArr18 = new UserInfos.PicUrl[repeatedFieldArrayLength9 + length9];
                        if (length9 != 0) {
                            System.arraycopy(this.bottomIcon, 0, picUrlArr18, 0, length9);
                        }
                        while (length9 < picUrlArr18.length - 1) {
                            picUrlArr18[length9] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr18[length9]);
                            codedInputByteBufferNano.readTag();
                            length9++;
                        }
                        picUrlArr18[length9] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr18[length9]);
                        this.bottomIcon = picUrlArr18;
                        break;
                    case 154:
                        this.bottomContentLink = codedInputByteBufferNano.readString();
                        break;
                    case 160:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1) {
                            break;
                        } else {
                            this.bottomContentLinkType = int322;
                            break;
                        }
                        break;
                    case 170:
                        int repeatedFieldArrayLength10 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 170);
                        UserInfos.PicUrl[] picUrlArr19 = this.disableDirectFollowPict;
                        int length10 = picUrlArr19 == null ? 0 : picUrlArr19.length;
                        UserInfos.PicUrl[] picUrlArr20 = new UserInfos.PicUrl[repeatedFieldArrayLength10 + length10];
                        if (length10 != 0) {
                            System.arraycopy(this.disableDirectFollowPict, 0, picUrlArr20, 0, length10);
                        }
                        while (length10 < picUrlArr20.length - 1) {
                            picUrlArr20[length10] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr20[length10]);
                            codedInputByteBufferNano.readTag();
                            length10++;
                        }
                        picUrlArr20[length10] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr20[length10]);
                        this.disableDirectFollowPict = picUrlArr20;
                        break;
                    case 178:
                        if (this.bottomTip == null) {
                            this.bottomTip = new ImageTextInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.bottomTip);
                        break;
                    case 186:
                        if (this.bottomTipReplace == null) {
                            this.bottomTipReplace = new ImageTextInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.bottomTipReplace);
                        break;
                    case 194:
                        if (this.outsideBottomTip == null) {
                            this.outsideBottomTip = new RedPackSkinButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.outsideBottomTip);
                        break;
                    case 202:
                        this.redPacketPopAnimationKey = codedInputByteBufferNano.readString();
                        break;
                    case 208:
                        this.needReserve = codedInputByteBufferNano.readBool();
                        break;
                    case 218:
                        this.reservationId = codedInputByteBufferNano.readString();
                        break;
                    case 226:
                        if (this.reserveButton == null) {
                            this.reserveButton = new RedPackSkinButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.reserveButton);
                        break;
                    case 234:
                        if (this.reserveFollowButton == null) {
                            this.reserveFollowButton = new RedPackSkinButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.reserveFollowButton);
                        break;
                    case 242:
                        if (this.defaultButton == null) {
                            this.defaultButton = new RedPackSkinButtonInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.defaultButton);
                        break;
                    case 248:
                        this.needBookReservation = codedInputByteBufferNano.readBool();
                        break;
                    case 258:
                        if (this.prepareItemColorConfig == null) {
                            this.prepareItemColorConfig = new RedPackItemColorConfig();
                        }
                        codedInputByteBufferNano.readMessage(this.prepareItemColorConfig);
                        break;
                    case 266:
                        if (this.grabItemColorConfig == null) {
                            this.grabItemColorConfig = new RedPackItemColorConfig();
                        }
                        codedInputByteBufferNano.readMessage(this.grabItemColorConfig);
                        break;
                    case 274:
                        this.reeeItemDescriptionColor = codedInputByteBufferNano.readString();
                        break;
                    case 282:
                        this.decisionColor = codedInputByteBufferNano.readString();
                        break;
                    case 288:
                        this.superCover = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static RedPackSkinTheme parseFrom(byte[] bArr) {
            return (RedPackSkinTheme) MessageNano.mergeFrom(new RedPackSkinTheme(), bArr);
        }

        public static RedPackSkinTheme parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackSkinTheme().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedPackSkinButtonInfo extends MessageNano {
        private static volatile RedPackSkinButtonInfo[] _emptyArray;
        public String buttonBorderColor;
        public String buttonClickUrl;
        public String[] buttonColor;
        public UserInfos.PicUrl[] buttonPict;
        public boolean disableAuthorShow;
        public UserInfos.PicUrl[] iconPict;
        public int insertLeftDp;
        public int insertRightDp;
        public String text;
        public String textColor;

        public static RedPackSkinButtonInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackSkinButtonInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackSkinButtonInfo() {
            clear();
        }

        public final RedPackSkinButtonInfo clear() {
            this.textColor = "";
            this.text = "";
            this.buttonColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.buttonBorderColor = "";
            this.buttonPict = UserInfos.PicUrl.emptyArray();
            this.iconPict = UserInfos.PicUrl.emptyArray();
            this.insertLeftDp = 0;
            this.insertRightDp = 0;
            this.disableAuthorShow = false;
            this.buttonClickUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.textColor);
            }
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.text);
            }
            String[] strArr = this.buttonColor;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.buttonColor;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(3, str);
                    }
                    i2++;
                }
            }
            if (!this.buttonBorderColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.buttonBorderColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.buttonPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.buttonPict;
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
            UserInfos.PicUrl[] picUrlArr3 = this.iconPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.iconPict;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl2);
                    }
                    i++;
                }
            }
            int i4 = this.insertLeftDp;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(7, i4);
            }
            int i5 = this.insertRightDp;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i5);
            }
            boolean z = this.disableAuthorShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(9, z);
            }
            if (!this.buttonClickUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.buttonClickUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.textColor);
            }
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
            }
            String[] strArr = this.buttonColor;
            int i = 0;
            if (strArr != null && strArr.length > 0) {
                int i2 = 0;
                int iComputeStringSizeNoTag = 0;
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.buttonColor;
                    if (i2 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i2];
                    if (str != null) {
                        i3++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
            }
            if (!this.buttonBorderColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.buttonBorderColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.buttonPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.buttonPict;
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
            UserInfos.PicUrl[] picUrlArr3 = this.iconPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.iconPict;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl2);
                    }
                    i++;
                }
            }
            int i5 = this.insertLeftDp;
            if (i5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i5);
            }
            int i6 = this.insertRightDp;
            if (i6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i6);
            }
            boolean z = this.disableAuthorShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z);
            }
            return !this.buttonClickUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.buttonClickUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackSkinButtonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.textColor = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.text = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        String[] strArr = this.buttonColor;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.buttonColor, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr2[length] = codedInputByteBufferNano.readString();
                        this.buttonColor = strArr2;
                        break;
                    case 34:
                        this.buttonBorderColor = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        UserInfos.PicUrl[] picUrlArr = this.buttonPict;
                        int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.buttonPict, 0, picUrlArr2, 0, length2);
                        }
                        while (length2 < picUrlArr2.length - 1) {
                            picUrlArr2[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr2[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                        this.buttonPict = picUrlArr2;
                        break;
                    case 50:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        UserInfos.PicUrl[] picUrlArr3 = this.iconPict;
                        int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.iconPict, 0, picUrlArr4, 0, length3);
                        }
                        while (length3 < picUrlArr4.length - 1) {
                            picUrlArr4[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr4[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                        this.iconPict = picUrlArr4;
                        break;
                    case 56:
                        this.insertLeftDp = codedInputByteBufferNano.readInt32();
                        break;
                    case 64:
                        this.insertRightDp = codedInputByteBufferNano.readInt32();
                        break;
                    case 72:
                        this.disableAuthorShow = codedInputByteBufferNano.readBool();
                        break;
                    case 82:
                        this.buttonClickUrl = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static RedPackSkinButtonInfo parseFrom(byte[] bArr) {
            return (RedPackSkinButtonInfo) MessageNano.mergeFrom(new RedPackSkinButtonInfo(), bArr);
        }

        public static RedPackSkinButtonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackSkinButtonInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedPackSkinInnerInfo extends MessageNano {
        private static volatile RedPackSkinInnerInfo[] _emptyArray;
        public String[] bgSubscriptColor;
        public String[] borderColor;
        public String bottomMaskColorEnd;
        public String bottomMaskColorStart;
        public String[] gbInnerColor;
        public String luckyFontColor;
        public String luckyTitleColor;
        public String resultFontColor;
        public int skinType;
        public String subscriptFontColor;
        public UserInfos.PicUrl[] topLuckyBackPict;
        public UserInfos.PicUrl[] topLuckyBgPict;
        public String topLuckyEmptyColor;
        public UserInfos.PicUrl[] topLuckyEmptyPict;
        public UserInfos.PicUrl[] topLuckyProcessingPict;

        public static RedPackSkinInnerInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackSkinInnerInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackSkinInnerInfo() {
            clear();
        }

        public final RedPackSkinInnerInfo clear() {
            this.skinType = 0;
            this.luckyTitleColor = "";
            this.luckyFontColor = "";
            this.resultFontColor = "";
            this.gbInnerColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.borderColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.subscriptFontColor = "";
            this.bgSubscriptColor = WireFormatNano.EMPTY_STRING_ARRAY;
            this.topLuckyEmptyPict = UserInfos.PicUrl.emptyArray();
            this.topLuckyEmptyColor = "";
            this.topLuckyProcessingPict = UserInfos.PicUrl.emptyArray();
            this.topLuckyBgPict = UserInfos.PicUrl.emptyArray();
            this.topLuckyBackPict = UserInfos.PicUrl.emptyArray();
            this.bottomMaskColorStart = "";
            this.bottomMaskColorEnd = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.skinType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.luckyTitleColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.luckyTitleColor);
            }
            if (!this.luckyFontColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.luckyFontColor);
            }
            if (!this.resultFontColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.resultFontColor);
            }
            String[] strArr = this.gbInnerColor;
            int i2 = 0;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                while (true) {
                    String[] strArr2 = this.gbInnerColor;
                    if (i3 >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i3];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(5, str);
                    }
                    i3++;
                }
            }
            String[] strArr3 = this.borderColor;
            if (strArr3 != null && strArr3.length > 0) {
                int i4 = 0;
                while (true) {
                    String[] strArr4 = this.borderColor;
                    if (i4 >= strArr4.length) {
                        break;
                    }
                    String str2 = strArr4[i4];
                    if (str2 != null) {
                        codedOutputByteBufferNano.writeString(6, str2);
                    }
                    i4++;
                }
            }
            if (!this.subscriptFontColor.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.subscriptFontColor);
            }
            String[] strArr5 = this.bgSubscriptColor;
            if (strArr5 != null && strArr5.length > 0) {
                int i5 = 0;
                while (true) {
                    String[] strArr6 = this.bgSubscriptColor;
                    if (i5 >= strArr6.length) {
                        break;
                    }
                    String str3 = strArr6[i5];
                    if (str3 != null) {
                        codedOutputByteBufferNano.writeString(8, str3);
                    }
                    i5++;
                }
            }
            UserInfos.PicUrl[] picUrlArr = this.topLuckyEmptyPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i6 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.topLuckyEmptyPict;
                    if (i6 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i6];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(9, picUrl);
                    }
                    i6++;
                }
            }
            if (!this.topLuckyEmptyColor.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.topLuckyEmptyColor);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.topLuckyProcessingPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i7 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.topLuckyProcessingPict;
                    if (i7 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i7];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(11, picUrl2);
                    }
                    i7++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.topLuckyBgPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int i8 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.topLuckyBgPict;
                    if (i8 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i8];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(12, picUrl3);
                    }
                    i8++;
                }
            }
            UserInfos.PicUrl[] picUrlArr7 = this.topLuckyBackPict;
            if (picUrlArr7 != null && picUrlArr7.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr8 = this.topLuckyBackPict;
                    if (i2 >= picUrlArr8.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl4 = picUrlArr8[i2];
                    if (picUrl4 != null) {
                        codedOutputByteBufferNano.writeMessage(13, picUrl4);
                    }
                    i2++;
                }
            }
            if (!this.bottomMaskColorStart.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.bottomMaskColorStart);
            }
            if (!this.bottomMaskColorEnd.equals("")) {
                codedOutputByteBufferNano.writeString(15, this.bottomMaskColorEnd);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.skinType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.luckyTitleColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.luckyTitleColor);
            }
            if (!this.luckyFontColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.luckyFontColor);
            }
            if (!this.resultFontColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.resultFontColor);
            }
            String[] strArr = this.gbInnerColor;
            int i2 = 0;
            if (strArr != null && strArr.length > 0) {
                int i3 = 0;
                int iComputeStringSizeNoTag = 0;
                int i4 = 0;
                while (true) {
                    String[] strArr2 = this.gbInnerColor;
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
            String[] strArr3 = this.borderColor;
            if (strArr3 != null && strArr3.length > 0) {
                int i5 = 0;
                int iComputeStringSizeNoTag2 = 0;
                int i6 = 0;
                while (true) {
                    String[] strArr4 = this.borderColor;
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
            if (!this.subscriptFontColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.subscriptFontColor);
            }
            String[] strArr5 = this.bgSubscriptColor;
            if (strArr5 != null && strArr5.length > 0) {
                int i7 = 0;
                int iComputeStringSizeNoTag3 = 0;
                int i8 = 0;
                while (true) {
                    String[] strArr6 = this.bgSubscriptColor;
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
            UserInfos.PicUrl[] picUrlArr = this.topLuckyEmptyPict;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i9 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.topLuckyEmptyPict;
                    if (i9 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i9];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(9, picUrl);
                    }
                    i9++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.topLuckyEmptyColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.topLuckyEmptyColor);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.topLuckyProcessingPict;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i10 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.topLuckyProcessingPict;
                    if (i10 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i10];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(11, picUrl2);
                    }
                    i10++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr5 = this.topLuckyBgPict;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i11 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.topLuckyBgPict;
                    if (i11 >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i11];
                    if (picUrl3 != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(12, picUrl3);
                    }
                    i11++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            UserInfos.PicUrl[] picUrlArr7 = this.topLuckyBackPict;
            if (picUrlArr7 != null && picUrlArr7.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr8 = this.topLuckyBackPict;
                    if (i2 >= picUrlArr8.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl4 = picUrlArr8[i2];
                    if (picUrl4 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, picUrl4);
                    }
                    i2++;
                }
            }
            if (!this.bottomMaskColorStart.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.bottomMaskColorStart);
            }
            return !this.bottomMaskColorEnd.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(15, this.bottomMaskColorEnd) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackSkinInnerInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                            break;
                        } else {
                            this.skinType = int32;
                            break;
                        }
                    case 18:
                        this.luckyTitleColor = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.luckyFontColor = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.resultFontColor = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                        String[] strArr = this.gbInnerColor;
                        int length = strArr == null ? 0 : strArr.length;
                        String[] strArr2 = new String[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.gbInnerColor, 0, strArr2, 0, length);
                        }
                        while (length < strArr2.length - 1) {
                            strArr2[length] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        strArr2[length] = codedInputByteBufferNano.readString();
                        this.gbInnerColor = strArr2;
                        break;
                    case 50:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                        String[] strArr3 = this.borderColor;
                        int length2 = strArr3 == null ? 0 : strArr3.length;
                        String[] strArr4 = new String[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.borderColor, 0, strArr4, 0, length2);
                        }
                        while (length2 < strArr4.length - 1) {
                            strArr4[length2] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        strArr4[length2] = codedInputByteBufferNano.readString();
                        this.borderColor = strArr4;
                        break;
                    case 58:
                        this.subscriptFontColor = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                        String[] strArr5 = this.bgSubscriptColor;
                        int length3 = strArr5 == null ? 0 : strArr5.length;
                        String[] strArr6 = new String[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.bgSubscriptColor, 0, strArr6, 0, length3);
                        }
                        while (length3 < strArr6.length - 1) {
                            strArr6[length3] = codedInputByteBufferNano.readString();
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        strArr6[length3] = codedInputByteBufferNano.readString();
                        this.bgSubscriptColor = strArr6;
                        break;
                    case 74:
                        int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                        UserInfos.PicUrl[] picUrlArr = this.topLuckyEmptyPict;
                        int length4 = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                        if (length4 != 0) {
                            System.arraycopy(this.topLuckyEmptyPict, 0, picUrlArr2, 0, length4);
                        }
                        while (length4 < picUrlArr2.length - 1) {
                            picUrlArr2[length4] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length4]);
                            codedInputByteBufferNano.readTag();
                            length4++;
                        }
                        picUrlArr2[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length4]);
                        this.topLuckyEmptyPict = picUrlArr2;
                        break;
                    case 82:
                        this.topLuckyEmptyColor = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        int repeatedFieldArrayLength5 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                        UserInfos.PicUrl[] picUrlArr3 = this.topLuckyProcessingPict;
                        int length5 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength5 + length5];
                        if (length5 != 0) {
                            System.arraycopy(this.topLuckyProcessingPict, 0, picUrlArr4, 0, length5);
                        }
                        while (length5 < picUrlArr4.length - 1) {
                            picUrlArr4[length5] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length5]);
                            codedInputByteBufferNano.readTag();
                            length5++;
                        }
                        picUrlArr4[length5] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length5]);
                        this.topLuckyProcessingPict = picUrlArr4;
                        break;
                    case 98:
                        int repeatedFieldArrayLength6 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 98);
                        UserInfos.PicUrl[] picUrlArr5 = this.topLuckyBgPict;
                        int length6 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                        UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength6 + length6];
                        if (length6 != 0) {
                            System.arraycopy(this.topLuckyBgPict, 0, picUrlArr6, 0, length6);
                        }
                        while (length6 < picUrlArr6.length - 1) {
                            picUrlArr6[length6] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr6[length6]);
                            codedInputByteBufferNano.readTag();
                            length6++;
                        }
                        picUrlArr6[length6] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length6]);
                        this.topLuckyBgPict = picUrlArr6;
                        break;
                    case 106:
                        int repeatedFieldArrayLength7 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                        UserInfos.PicUrl[] picUrlArr7 = this.topLuckyBackPict;
                        int length7 = picUrlArr7 == null ? 0 : picUrlArr7.length;
                        UserInfos.PicUrl[] picUrlArr8 = new UserInfos.PicUrl[repeatedFieldArrayLength7 + length7];
                        if (length7 != 0) {
                            System.arraycopy(this.topLuckyBackPict, 0, picUrlArr8, 0, length7);
                        }
                        while (length7 < picUrlArr8.length - 1) {
                            picUrlArr8[length7] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr8[length7]);
                            codedInputByteBufferNano.readTag();
                            length7++;
                        }
                        picUrlArr8[length7] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr8[length7]);
                        this.topLuckyBackPict = picUrlArr8;
                        break;
                    case 114:
                        this.bottomMaskColorStart = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        this.bottomMaskColorEnd = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static RedPackSkinInnerInfo parseFrom(byte[] bArr) {
            return (RedPackSkinInnerInfo) MessageNano.mergeFrom(new RedPackSkinInnerInfo(), bArr);
        }

        public static RedPackSkinInnerInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackSkinInnerInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ImageTextInfo extends MessageNano {
        private static volatile ImageTextInfo[] _emptyArray;
        public UserInfos.PicUrl[] backGround;
        public int insertLeftDp;
        public int insertRightDp;
        public String messageContent;
        public String messageFontColor;

        public static ImageTextInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ImageTextInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ImageTextInfo() {
            clear();
        }

        public final ImageTextInfo clear() {
            this.backGround = UserInfos.PicUrl.emptyArray();
            this.messageContent = "";
            this.messageFontColor = "";
            this.insertLeftDp = 0;
            this.insertRightDp = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.backGround;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backGround;
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
            if (!this.messageContent.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.messageContent);
            }
            if (!this.messageFontColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.messageFontColor);
            }
            int i2 = this.insertLeftDp;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            int i3 = this.insertRightDp;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(5, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.backGround;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backGround;
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
            if (!this.messageContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.messageContent);
            }
            if (!this.messageFontColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.messageFontColor);
            }
            int i2 = this.insertLeftDp;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            int i3 = this.insertRightDp;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ImageTextInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.backGround;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.backGround, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.backGround = picUrlArr2;
                } else if (tag == 18) {
                    this.messageContent = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.messageFontColor = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.insertLeftDp = codedInputByteBufferNano.readInt32();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.insertRightDp = codedInputByteBufferNano.readInt32();
                }
            }
        }

        public static ImageTextInfo parseFrom(byte[] bArr) {
            return (ImageTextInfo) MessageNano.mergeFrom(new ImageTextInfo(), bArr);
        }

        public static ImageTextInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ImageTextInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedPackItemColorConfig extends MessageNano {
        private static volatile RedPackItemColorConfig[] _emptyArray;
        public String itemContainerColorEnd;
        public String itemContainerColorStart;
        public String itemCountColor;
        public String itemCountContainerColor;

        public static RedPackItemColorConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackItemColorConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackItemColorConfig() {
            clear();
        }

        public final RedPackItemColorConfig clear() {
            this.itemContainerColorStart = "";
            this.itemContainerColorEnd = "";
            this.itemCountContainerColor = "";
            this.itemCountColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.itemContainerColorStart.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.itemContainerColorStart);
            }
            if (!this.itemContainerColorEnd.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.itemContainerColorEnd);
            }
            if (!this.itemCountContainerColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.itemCountContainerColor);
            }
            if (!this.itemCountColor.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.itemCountColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.itemContainerColorStart.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemContainerColorStart);
            }
            if (!this.itemContainerColorEnd.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.itemContainerColorEnd);
            }
            if (!this.itemCountContainerColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.itemCountContainerColor);
            }
            return !this.itemCountColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.itemCountColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackItemColorConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.itemContainerColorStart = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.itemContainerColorEnd = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.itemCountContainerColor = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.itemCountColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedPackItemColorConfig parseFrom(byte[] bArr) {
            return (RedPackItemColorConfig) MessageNano.mergeFrom(new RedPackItemColorConfig(), bArr);
        }

        public static RedPackItemColorConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackItemColorConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
