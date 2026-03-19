package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.SocketMessages;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRedPackRainMessage {

    public static final class RedPackRainText extends MessageNano {
        private static volatile RedPackRainText[] _emptyArray;
        public String color;
        public String content;

        public static RedPackRainText[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackRainText[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackRainText() {
            clear();
        }

        public final RedPackRainText clear() {
            this.content = "";
            this.color = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.content);
            }
            if (!this.color.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.color);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
            }
            return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackRainText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.content = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.color = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedPackRainText parseFrom(byte[] bArr) {
            return (RedPackRainText) MessageNano.mergeFrom(new RedPackRainText(), bArr);
        }

        public static RedPackRainText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackRainText().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedPackRainPicture extends MessageNano {
        private static volatile RedPackRainPicture[] _emptyArray;
        public UserInfos.PicUrl[] picUrl;

        public static RedPackRainPicture[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackRainPicture[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackRainPicture() {
            clear();
        }

        public final RedPackRainPicture clear() {
            this.picUrl = UserInfos.PicUrl.emptyArray();
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
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackRainPicture mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                }
            }
        }

        public static RedPackRainPicture parseFrom(byte[] bArr) {
            return (RedPackRainPicture) MessageNano.mergeFrom(new RedPackRainPicture(), bArr);
        }

        public static RedPackRainPicture parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackRainPicture().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedPackRainButton extends MessageNano {
        private static volatile RedPackRainButton[] _emptyArray;
        public boolean isHidden;
        public String link;
        public RedPackRainPicture picture;
        public RedPackRainText text;

        public static RedPackRainButton[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackRainButton[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackRainButton() {
            clear();
        }

        public final RedPackRainButton clear() {
            this.text = null;
            this.picture = null;
            this.link = "";
            this.isHidden = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RedPackRainText redPackRainText = this.text;
            if (redPackRainText != null) {
                codedOutputByteBufferNano.writeMessage(1, redPackRainText);
            }
            RedPackRainPicture redPackRainPicture = this.picture;
            if (redPackRainPicture != null) {
                codedOutputByteBufferNano.writeMessage(2, redPackRainPicture);
            }
            if (!this.link.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.link);
            }
            boolean z = this.isHidden;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RedPackRainText redPackRainText = this.text;
            if (redPackRainText != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, redPackRainText);
            }
            RedPackRainPicture redPackRainPicture = this.picture;
            if (redPackRainPicture != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, redPackRainPicture);
            }
            if (!this.link.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.link);
            }
            boolean z = this.isHidden;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackRainButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.text == null) {
                        this.text = new RedPackRainText();
                    }
                    codedInputByteBufferNano.readMessage(this.text);
                } else if (tag == 18) {
                    if (this.picture == null) {
                        this.picture = new RedPackRainPicture();
                    }
                    codedInputByteBufferNano.readMessage(this.picture);
                } else if (tag == 26) {
                    this.link = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.isHidden = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static RedPackRainButton parseFrom(byte[] bArr) {
            return (RedPackRainButton) MessageNano.mergeFrom(new RedPackRainButton(), bArr);
        }

        public static RedPackRainButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackRainButton().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedPackRainPrizePic extends MessageNano {
        private static volatile RedPackRainPrizePic[] _emptyArray;
        public UserInfos.PicUrl[] picUrl;
        public String prizeId;
        public int prizeType;

        public static RedPackRainPrizePic[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackRainPrizePic[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackRainPrizePic() {
            clear();
        }

        public final RedPackRainPrizePic clear() {
            this.prizeType = 0;
            this.prizeId = "";
            this.picUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.prizeType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.prizeId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.prizeId);
            }
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
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
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.prizeType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!this.prizeId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.prizeId);
            }
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
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
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackRainPrizePic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.prizeType = codedInputByteBufferNano.readInt32();
                } else if (tag == 18) {
                    this.prizeId = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
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
                }
            }
        }

        public static RedPackRainPrizePic parseFrom(byte[] bArr) {
            return (RedPackRainPrizePic) MessageNano.mergeFrom(new RedPackRainPrizePic(), bArr);
        }

        public static RedPackRainPrizePic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackRainPrizePic().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCRedPackRainResource extends MessageNano {
        private static volatile SCRedPackRainResource[] _emptyArray;
        public long animateMagicFaceId;
        public RedPackRainPicture animateSponsorRedPackPic;
        public RedPackRainPicture animateSponsorTitlePic;
        public RedPackRainText countDownText;
        public RedPackRainPicture grabPopAnimateRedPackPic;
        public RedPackRainPicture grabPopAnimateStarPic;
        public RedPackRainButton grabPopCountDownButton;
        public RedPackRainPicture grabPopCoverBottomPic;
        public RedPackRainPicture grabPopCoverTopPic;
        public RedPackRainPicture grabPopGrabPic;
        public RedPackRainButton grabPopReserveButton;
        public RedPackRainButton grabPopRuleButton;
        public RedPackRainText grabPopUnopenedSubtitleText;
        public RedPackRainPicture grabPopUnopenedTitlePic;
        public RedPackRainPicture grabResultBackGroundPic;
        public RedPackRainText grabResultBottomKscoinText;
        public RedPackRainText grabResultBottomPrizeText;
        public RedPackRainPicture grabResultCardPic;
        public RedPackRainPicture grabResultCoverBottomPic;
        public RedPackRainPicture grabResultHeadFrame;
        public RedPackRainPicture grabResultKoiBackgroundPic;
        public RedPackRainButton grabResultKoiButton;
        public RedPackRainPicture grabResultKoiCardPic;
        public RedPackRainPicture grabResultKoiCoverBottomPic;
        public RedPackRainPicture grabResultKoiPic;
        public RedPackRainButton grabResultKoiReceiveButton;
        public RedPackRainButton grabResultKoiShareButton;
        public String grabResultKoiSummaryTextColor;
        public RedPackRainPicture grabResultMissPic;
        public String grabResultMissTextColor;
        public RedPackRainButton grabResultReceiveButton;
        public RedPackRainButton grabResultShareButton;
        public RedPackRainText grabResultSponsorText;
        public String grabResultSummaryTextColor;
        public String grabResultTextColor;
        public long maxDelayRequestMillis;
        public RedPackRainPrizePic[] prizePic;
        public String redPackRainId;
        public String redPackRainResourceId;
        public RedPackRainPicture[] rewardPic;
        public long time;
        public boolean widgetAutoPop;
        public RedPackRainPicture widgetBackGroupPic;
        public RedPackRainPicture widgetBackgroundPic;
        public RedPackRainPicture widgetBackgroundPicV2;
        public RedPackRainButton widgetButton;
        public RedPackRainText widgetDefaultText;
        public RedPackRainPicture widgetLottieJson;
        public RedPackRainPicture widgetLottiePic;
        public RedPackRainButton widgetPopRuleButton;
        public RedPackRainPicture widgetPopupPic;
        public RedPackRainButton widgetPopupShareButton;
        public String widgetTextColor;

        public static SCRedPackRainResource[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCRedPackRainResource[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCRedPackRainResource() {
            clear();
        }

        public final SCRedPackRainResource clear() {
            this.widgetPopupPic = null;
            this.widgetPopupShareButton = null;
            this.widgetPopRuleButton = null;
            this.widgetAutoPop = false;
            this.widgetBackGroupPic = null;
            this.widgetDefaultText = null;
            this.rewardPic = RedPackRainPicture.emptyArray();
            this.countDownText = null;
            this.grabResultBackGroundPic = null;
            this.grabResultHeadFrame = null;
            this.grabResultKoiPic = null;
            this.grabResultSponsorText = null;
            this.grabResultReceiveButton = null;
            this.grabResultTextColor = "";
            this.grabResultShareButton = null;
            this.grabResultKoiShareButton = null;
            this.grabResultBottomKscoinText = null;
            this.grabResultBottomPrizeText = null;
            this.grabResultKoiButton = null;
            this.redPackRainId = "";
            this.time = 0L;
            this.maxDelayRequestMillis = 0L;
            this.redPackRainResourceId = "";
            this.widgetLottiePic = null;
            this.widgetLottieJson = null;
            this.widgetButton = null;
            this.animateMagicFaceId = 0L;
            this.animateSponsorTitlePic = null;
            this.animateSponsorRedPackPic = null;
            this.grabPopCoverTopPic = null;
            this.grabPopCoverBottomPic = null;
            this.grabPopAnimateStarPic = null;
            this.grabPopAnimateRedPackPic = null;
            this.grabPopUnopenedTitlePic = null;
            this.grabPopUnopenedSubtitleText = null;
            this.grabPopCountDownButton = null;
            this.grabPopReserveButton = null;
            this.grabPopGrabPic = null;
            this.grabPopRuleButton = null;
            this.grabResultCardPic = null;
            this.grabResultSummaryTextColor = "";
            this.grabResultKoiBackgroundPic = null;
            this.grabResultKoiCoverBottomPic = null;
            this.grabResultKoiCardPic = null;
            this.grabResultKoiReceiveButton = null;
            this.grabResultKoiSummaryTextColor = "";
            this.grabResultMissPic = null;
            this.grabResultMissTextColor = "";
            this.widgetBackgroundPic = null;
            this.widgetTextColor = "";
            this.grabResultCoverBottomPic = null;
            this.prizePic = RedPackRainPrizePic.emptyArray();
            this.widgetBackgroundPicV2 = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RedPackRainPicture redPackRainPicture = this.widgetPopupPic;
            if (redPackRainPicture != null) {
                codedOutputByteBufferNano.writeMessage(1, redPackRainPicture);
            }
            RedPackRainButton redPackRainButton = this.widgetPopupShareButton;
            if (redPackRainButton != null) {
                codedOutputByteBufferNano.writeMessage(2, redPackRainButton);
            }
            RedPackRainButton redPackRainButton2 = this.widgetPopRuleButton;
            if (redPackRainButton2 != null) {
                codedOutputByteBufferNano.writeMessage(3, redPackRainButton2);
            }
            boolean z = this.widgetAutoPop;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            RedPackRainPicture redPackRainPicture2 = this.widgetBackGroupPic;
            if (redPackRainPicture2 != null) {
                codedOutputByteBufferNano.writeMessage(5, redPackRainPicture2);
            }
            RedPackRainText redPackRainText = this.widgetDefaultText;
            if (redPackRainText != null) {
                codedOutputByteBufferNano.writeMessage(6, redPackRainText);
            }
            RedPackRainPicture[] redPackRainPictureArr = this.rewardPic;
            int i = 0;
            if (redPackRainPictureArr != null && redPackRainPictureArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RedPackRainPicture[] redPackRainPictureArr2 = this.rewardPic;
                    if (i2 >= redPackRainPictureArr2.length) {
                        break;
                    }
                    RedPackRainPicture redPackRainPicture3 = redPackRainPictureArr2[i2];
                    if (redPackRainPicture3 != null) {
                        codedOutputByteBufferNano.writeMessage(7, redPackRainPicture3);
                    }
                    i2++;
                }
            }
            RedPackRainText redPackRainText2 = this.countDownText;
            if (redPackRainText2 != null) {
                codedOutputByteBufferNano.writeMessage(8, redPackRainText2);
            }
            RedPackRainPicture redPackRainPicture4 = this.grabResultBackGroundPic;
            if (redPackRainPicture4 != null) {
                codedOutputByteBufferNano.writeMessage(9, redPackRainPicture4);
            }
            RedPackRainPicture redPackRainPicture5 = this.grabResultHeadFrame;
            if (redPackRainPicture5 != null) {
                codedOutputByteBufferNano.writeMessage(10, redPackRainPicture5);
            }
            RedPackRainPicture redPackRainPicture6 = this.grabResultKoiPic;
            if (redPackRainPicture6 != null) {
                codedOutputByteBufferNano.writeMessage(11, redPackRainPicture6);
            }
            RedPackRainText redPackRainText3 = this.grabResultSponsorText;
            if (redPackRainText3 != null) {
                codedOutputByteBufferNano.writeMessage(12, redPackRainText3);
            }
            RedPackRainButton redPackRainButton3 = this.grabResultReceiveButton;
            if (redPackRainButton3 != null) {
                codedOutputByteBufferNano.writeMessage(13, redPackRainButton3);
            }
            if (!this.grabResultTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(14, this.grabResultTextColor);
            }
            RedPackRainButton redPackRainButton4 = this.grabResultShareButton;
            if (redPackRainButton4 != null) {
                codedOutputByteBufferNano.writeMessage(15, redPackRainButton4);
            }
            RedPackRainButton redPackRainButton5 = this.grabResultKoiShareButton;
            if (redPackRainButton5 != null) {
                codedOutputByteBufferNano.writeMessage(16, redPackRainButton5);
            }
            RedPackRainText redPackRainText4 = this.grabResultBottomKscoinText;
            if (redPackRainText4 != null) {
                codedOutputByteBufferNano.writeMessage(17, redPackRainText4);
            }
            RedPackRainText redPackRainText5 = this.grabResultBottomPrizeText;
            if (redPackRainText5 != null) {
                codedOutputByteBufferNano.writeMessage(18, redPackRainText5);
            }
            RedPackRainButton redPackRainButton6 = this.grabResultKoiButton;
            if (redPackRainButton6 != null) {
                codedOutputByteBufferNano.writeMessage(19, redPackRainButton6);
            }
            if (!this.redPackRainId.equals("")) {
                codedOutputByteBufferNano.writeString(20, this.redPackRainId);
            }
            long j = this.time;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(21, j);
            }
            long j2 = this.maxDelayRequestMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(22, j2);
            }
            if (!this.redPackRainResourceId.equals("")) {
                codedOutputByteBufferNano.writeString(23, this.redPackRainResourceId);
            }
            RedPackRainPicture redPackRainPicture7 = this.widgetLottiePic;
            if (redPackRainPicture7 != null) {
                codedOutputByteBufferNano.writeMessage(24, redPackRainPicture7);
            }
            RedPackRainPicture redPackRainPicture8 = this.widgetLottieJson;
            if (redPackRainPicture8 != null) {
                codedOutputByteBufferNano.writeMessage(25, redPackRainPicture8);
            }
            RedPackRainButton redPackRainButton7 = this.widgetButton;
            if (redPackRainButton7 != null) {
                codedOutputByteBufferNano.writeMessage(26, redPackRainButton7);
            }
            long j3 = this.animateMagicFaceId;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(27, j3);
            }
            RedPackRainPicture redPackRainPicture9 = this.animateSponsorTitlePic;
            if (redPackRainPicture9 != null) {
                codedOutputByteBufferNano.writeMessage(28, redPackRainPicture9);
            }
            RedPackRainPicture redPackRainPicture10 = this.animateSponsorRedPackPic;
            if (redPackRainPicture10 != null) {
                codedOutputByteBufferNano.writeMessage(29, redPackRainPicture10);
            }
            RedPackRainPicture redPackRainPicture11 = this.grabPopCoverTopPic;
            if (redPackRainPicture11 != null) {
                codedOutputByteBufferNano.writeMessage(30, redPackRainPicture11);
            }
            RedPackRainPicture redPackRainPicture12 = this.grabPopCoverBottomPic;
            if (redPackRainPicture12 != null) {
                codedOutputByteBufferNano.writeMessage(31, redPackRainPicture12);
            }
            RedPackRainPicture redPackRainPicture13 = this.grabPopAnimateStarPic;
            if (redPackRainPicture13 != null) {
                codedOutputByteBufferNano.writeMessage(32, redPackRainPicture13);
            }
            RedPackRainPicture redPackRainPicture14 = this.grabPopAnimateRedPackPic;
            if (redPackRainPicture14 != null) {
                codedOutputByteBufferNano.writeMessage(33, redPackRainPicture14);
            }
            RedPackRainPicture redPackRainPicture15 = this.grabPopUnopenedTitlePic;
            if (redPackRainPicture15 != null) {
                codedOutputByteBufferNano.writeMessage(34, redPackRainPicture15);
            }
            RedPackRainText redPackRainText6 = this.grabPopUnopenedSubtitleText;
            if (redPackRainText6 != null) {
                codedOutputByteBufferNano.writeMessage(35, redPackRainText6);
            }
            RedPackRainButton redPackRainButton8 = this.grabPopCountDownButton;
            if (redPackRainButton8 != null) {
                codedOutputByteBufferNano.writeMessage(36, redPackRainButton8);
            }
            RedPackRainButton redPackRainButton9 = this.grabPopReserveButton;
            if (redPackRainButton9 != null) {
                codedOutputByteBufferNano.writeMessage(37, redPackRainButton9);
            }
            RedPackRainPicture redPackRainPicture16 = this.grabPopGrabPic;
            if (redPackRainPicture16 != null) {
                codedOutputByteBufferNano.writeMessage(38, redPackRainPicture16);
            }
            RedPackRainButton redPackRainButton10 = this.grabPopRuleButton;
            if (redPackRainButton10 != null) {
                codedOutputByteBufferNano.writeMessage(39, redPackRainButton10);
            }
            RedPackRainPicture redPackRainPicture17 = this.grabResultCardPic;
            if (redPackRainPicture17 != null) {
                codedOutputByteBufferNano.writeMessage(40, redPackRainPicture17);
            }
            if (!this.grabResultSummaryTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(41, this.grabResultSummaryTextColor);
            }
            RedPackRainPicture redPackRainPicture18 = this.grabResultKoiBackgroundPic;
            if (redPackRainPicture18 != null) {
                codedOutputByteBufferNano.writeMessage(42, redPackRainPicture18);
            }
            RedPackRainPicture redPackRainPicture19 = this.grabResultKoiCoverBottomPic;
            if (redPackRainPicture19 != null) {
                codedOutputByteBufferNano.writeMessage(43, redPackRainPicture19);
            }
            RedPackRainPicture redPackRainPicture20 = this.grabResultKoiCardPic;
            if (redPackRainPicture20 != null) {
                codedOutputByteBufferNano.writeMessage(44, redPackRainPicture20);
            }
            RedPackRainButton redPackRainButton11 = this.grabResultKoiReceiveButton;
            if (redPackRainButton11 != null) {
                codedOutputByteBufferNano.writeMessage(45, redPackRainButton11);
            }
            if (!this.grabResultKoiSummaryTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(46, this.grabResultKoiSummaryTextColor);
            }
            RedPackRainPicture redPackRainPicture21 = this.grabResultMissPic;
            if (redPackRainPicture21 != null) {
                codedOutputByteBufferNano.writeMessage(47, redPackRainPicture21);
            }
            if (!this.grabResultMissTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(48, this.grabResultMissTextColor);
            }
            RedPackRainPicture redPackRainPicture22 = this.widgetBackgroundPic;
            if (redPackRainPicture22 != null) {
                codedOutputByteBufferNano.writeMessage(49, redPackRainPicture22);
            }
            if (!this.widgetTextColor.equals("")) {
                codedOutputByteBufferNano.writeString(50, this.widgetTextColor);
            }
            RedPackRainPicture redPackRainPicture23 = this.grabResultCoverBottomPic;
            if (redPackRainPicture23 != null) {
                codedOutputByteBufferNano.writeMessage(51, redPackRainPicture23);
            }
            RedPackRainPrizePic[] redPackRainPrizePicArr = this.prizePic;
            if (redPackRainPrizePicArr != null && redPackRainPrizePicArr.length > 0) {
                while (true) {
                    RedPackRainPrizePic[] redPackRainPrizePicArr2 = this.prizePic;
                    if (i >= redPackRainPrizePicArr2.length) {
                        break;
                    }
                    RedPackRainPrizePic redPackRainPrizePic = redPackRainPrizePicArr2[i];
                    if (redPackRainPrizePic != null) {
                        codedOutputByteBufferNano.writeMessage(52, redPackRainPrizePic);
                    }
                    i++;
                }
            }
            RedPackRainPicture redPackRainPicture24 = this.widgetBackgroundPicV2;
            if (redPackRainPicture24 != null) {
                codedOutputByteBufferNano.writeMessage(53, redPackRainPicture24);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RedPackRainPicture redPackRainPicture = this.widgetPopupPic;
            if (redPackRainPicture != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, redPackRainPicture);
            }
            RedPackRainButton redPackRainButton = this.widgetPopupShareButton;
            if (redPackRainButton != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, redPackRainButton);
            }
            RedPackRainButton redPackRainButton2 = this.widgetPopRuleButton;
            if (redPackRainButton2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, redPackRainButton2);
            }
            boolean z = this.widgetAutoPop;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
            }
            RedPackRainPicture redPackRainPicture2 = this.widgetBackGroupPic;
            if (redPackRainPicture2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, redPackRainPicture2);
            }
            RedPackRainText redPackRainText = this.widgetDefaultText;
            if (redPackRainText != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, redPackRainText);
            }
            RedPackRainPicture[] redPackRainPictureArr = this.rewardPic;
            int i = 0;
            if (redPackRainPictureArr != null && redPackRainPictureArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    RedPackRainPicture[] redPackRainPictureArr2 = this.rewardPic;
                    if (i2 >= redPackRainPictureArr2.length) {
                        break;
                    }
                    RedPackRainPicture redPackRainPicture3 = redPackRainPictureArr2[i2];
                    if (redPackRainPicture3 != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(7, redPackRainPicture3);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            RedPackRainText redPackRainText2 = this.countDownText;
            if (redPackRainText2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, redPackRainText2);
            }
            RedPackRainPicture redPackRainPicture4 = this.grabResultBackGroundPic;
            if (redPackRainPicture4 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, redPackRainPicture4);
            }
            RedPackRainPicture redPackRainPicture5 = this.grabResultHeadFrame;
            if (redPackRainPicture5 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, redPackRainPicture5);
            }
            RedPackRainPicture redPackRainPicture6 = this.grabResultKoiPic;
            if (redPackRainPicture6 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, redPackRainPicture6);
            }
            RedPackRainText redPackRainText3 = this.grabResultSponsorText;
            if (redPackRainText3 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(12, redPackRainText3);
            }
            RedPackRainButton redPackRainButton3 = this.grabResultReceiveButton;
            if (redPackRainButton3 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, redPackRainButton3);
            }
            if (!this.grabResultTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(14, this.grabResultTextColor);
            }
            RedPackRainButton redPackRainButton4 = this.grabResultShareButton;
            if (redPackRainButton4 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, redPackRainButton4);
            }
            RedPackRainButton redPackRainButton5 = this.grabResultKoiShareButton;
            if (redPackRainButton5 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, redPackRainButton5);
            }
            RedPackRainText redPackRainText4 = this.grabResultBottomKscoinText;
            if (redPackRainText4 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, redPackRainText4);
            }
            RedPackRainText redPackRainText5 = this.grabResultBottomPrizeText;
            if (redPackRainText5 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, redPackRainText5);
            }
            RedPackRainButton redPackRainButton6 = this.grabResultKoiButton;
            if (redPackRainButton6 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, redPackRainButton6);
            }
            if (!this.redPackRainId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.redPackRainId);
            }
            long j = this.time;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(21, j);
            }
            long j2 = this.maxDelayRequestMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(22, j2);
            }
            if (!this.redPackRainResourceId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(23, this.redPackRainResourceId);
            }
            RedPackRainPicture redPackRainPicture7 = this.widgetLottiePic;
            if (redPackRainPicture7 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, redPackRainPicture7);
            }
            RedPackRainPicture redPackRainPicture8 = this.widgetLottieJson;
            if (redPackRainPicture8 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, redPackRainPicture8);
            }
            RedPackRainButton redPackRainButton7 = this.widgetButton;
            if (redPackRainButton7 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(26, redPackRainButton7);
            }
            long j3 = this.animateMagicFaceId;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(27, j3);
            }
            RedPackRainPicture redPackRainPicture9 = this.animateSponsorTitlePic;
            if (redPackRainPicture9 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(28, redPackRainPicture9);
            }
            RedPackRainPicture redPackRainPicture10 = this.animateSponsorRedPackPic;
            if (redPackRainPicture10 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(29, redPackRainPicture10);
            }
            RedPackRainPicture redPackRainPicture11 = this.grabPopCoverTopPic;
            if (redPackRainPicture11 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(30, redPackRainPicture11);
            }
            RedPackRainPicture redPackRainPicture12 = this.grabPopCoverBottomPic;
            if (redPackRainPicture12 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(31, redPackRainPicture12);
            }
            RedPackRainPicture redPackRainPicture13 = this.grabPopAnimateStarPic;
            if (redPackRainPicture13 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(32, redPackRainPicture13);
            }
            RedPackRainPicture redPackRainPicture14 = this.grabPopAnimateRedPackPic;
            if (redPackRainPicture14 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(33, redPackRainPicture14);
            }
            RedPackRainPicture redPackRainPicture15 = this.grabPopUnopenedTitlePic;
            if (redPackRainPicture15 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(34, redPackRainPicture15);
            }
            RedPackRainText redPackRainText6 = this.grabPopUnopenedSubtitleText;
            if (redPackRainText6 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(35, redPackRainText6);
            }
            RedPackRainButton redPackRainButton8 = this.grabPopCountDownButton;
            if (redPackRainButton8 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(36, redPackRainButton8);
            }
            RedPackRainButton redPackRainButton9 = this.grabPopReserveButton;
            if (redPackRainButton9 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(37, redPackRainButton9);
            }
            RedPackRainPicture redPackRainPicture16 = this.grabPopGrabPic;
            if (redPackRainPicture16 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(38, redPackRainPicture16);
            }
            RedPackRainButton redPackRainButton10 = this.grabPopRuleButton;
            if (redPackRainButton10 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(39, redPackRainButton10);
            }
            RedPackRainPicture redPackRainPicture17 = this.grabResultCardPic;
            if (redPackRainPicture17 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(40, redPackRainPicture17);
            }
            if (!this.grabResultSummaryTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(41, this.grabResultSummaryTextColor);
            }
            RedPackRainPicture redPackRainPicture18 = this.grabResultKoiBackgroundPic;
            if (redPackRainPicture18 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(42, redPackRainPicture18);
            }
            RedPackRainPicture redPackRainPicture19 = this.grabResultKoiCoverBottomPic;
            if (redPackRainPicture19 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(43, redPackRainPicture19);
            }
            RedPackRainPicture redPackRainPicture20 = this.grabResultKoiCardPic;
            if (redPackRainPicture20 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(44, redPackRainPicture20);
            }
            RedPackRainButton redPackRainButton11 = this.grabResultKoiReceiveButton;
            if (redPackRainButton11 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(45, redPackRainButton11);
            }
            if (!this.grabResultKoiSummaryTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(46, this.grabResultKoiSummaryTextColor);
            }
            RedPackRainPicture redPackRainPicture21 = this.grabResultMissPic;
            if (redPackRainPicture21 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(47, redPackRainPicture21);
            }
            if (!this.grabResultMissTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(48, this.grabResultMissTextColor);
            }
            RedPackRainPicture redPackRainPicture22 = this.widgetBackgroundPic;
            if (redPackRainPicture22 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(49, redPackRainPicture22);
            }
            if (!this.widgetTextColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(50, this.widgetTextColor);
            }
            RedPackRainPicture redPackRainPicture23 = this.grabResultCoverBottomPic;
            if (redPackRainPicture23 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(51, redPackRainPicture23);
            }
            RedPackRainPrizePic[] redPackRainPrizePicArr = this.prizePic;
            if (redPackRainPrizePicArr != null && redPackRainPrizePicArr.length > 0) {
                while (true) {
                    RedPackRainPrizePic[] redPackRainPrizePicArr2 = this.prizePic;
                    if (i >= redPackRainPrizePicArr2.length) {
                        break;
                    }
                    RedPackRainPrizePic redPackRainPrizePic = redPackRainPrizePicArr2[i];
                    if (redPackRainPrizePic != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(52, redPackRainPrizePic);
                    }
                    i++;
                }
            }
            RedPackRainPicture redPackRainPicture24 = this.widgetBackgroundPicV2;
            return redPackRainPicture24 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(53, redPackRainPicture24) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCRedPackRainResource mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        if (this.widgetPopupPic == null) {
                            this.widgetPopupPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetPopupPic);
                        break;
                    case 18:
                        if (this.widgetPopupShareButton == null) {
                            this.widgetPopupShareButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetPopupShareButton);
                        break;
                    case 26:
                        if (this.widgetPopRuleButton == null) {
                            this.widgetPopRuleButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetPopRuleButton);
                        break;
                    case 32:
                        this.widgetAutoPop = codedInputByteBufferNano.readBool();
                        break;
                    case 42:
                        if (this.widgetBackGroupPic == null) {
                            this.widgetBackGroupPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetBackGroupPic);
                        break;
                    case 50:
                        if (this.widgetDefaultText == null) {
                            this.widgetDefaultText = new RedPackRainText();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetDefaultText);
                        break;
                    case 58:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        RedPackRainPicture[] redPackRainPictureArr = this.rewardPic;
                        int length = redPackRainPictureArr == null ? 0 : redPackRainPictureArr.length;
                        RedPackRainPicture[] redPackRainPictureArr2 = new RedPackRainPicture[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.rewardPic, 0, redPackRainPictureArr2, 0, length);
                        }
                        while (length < redPackRainPictureArr2.length - 1) {
                            redPackRainPictureArr2[length] = new RedPackRainPicture();
                            codedInputByteBufferNano.readMessage(redPackRainPictureArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        redPackRainPictureArr2[length] = new RedPackRainPicture();
                        codedInputByteBufferNano.readMessage(redPackRainPictureArr2[length]);
                        this.rewardPic = redPackRainPictureArr2;
                        break;
                    case 66:
                        if (this.countDownText == null) {
                            this.countDownText = new RedPackRainText();
                        }
                        codedInputByteBufferNano.readMessage(this.countDownText);
                        break;
                    case 74:
                        if (this.grabResultBackGroundPic == null) {
                            this.grabResultBackGroundPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultBackGroundPic);
                        break;
                    case 82:
                        if (this.grabResultHeadFrame == null) {
                            this.grabResultHeadFrame = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultHeadFrame);
                        break;
                    case 90:
                        if (this.grabResultKoiPic == null) {
                            this.grabResultKoiPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultKoiPic);
                        break;
                    case 98:
                        if (this.grabResultSponsorText == null) {
                            this.grabResultSponsorText = new RedPackRainText();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultSponsorText);
                        break;
                    case 106:
                        if (this.grabResultReceiveButton == null) {
                            this.grabResultReceiveButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultReceiveButton);
                        break;
                    case 114:
                        this.grabResultTextColor = codedInputByteBufferNano.readString();
                        break;
                    case 122:
                        if (this.grabResultShareButton == null) {
                            this.grabResultShareButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultShareButton);
                        break;
                    case 130:
                        if (this.grabResultKoiShareButton == null) {
                            this.grabResultKoiShareButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultKoiShareButton);
                        break;
                    case 138:
                        if (this.grabResultBottomKscoinText == null) {
                            this.grabResultBottomKscoinText = new RedPackRainText();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultBottomKscoinText);
                        break;
                    case 146:
                        if (this.grabResultBottomPrizeText == null) {
                            this.grabResultBottomPrizeText = new RedPackRainText();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultBottomPrizeText);
                        break;
                    case 154:
                        if (this.grabResultKoiButton == null) {
                            this.grabResultKoiButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultKoiButton);
                        break;
                    case 162:
                        this.redPackRainId = codedInputByteBufferNano.readString();
                        break;
                    case 168:
                        this.time = codedInputByteBufferNano.readUInt64();
                        break;
                    case 176:
                        this.maxDelayRequestMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    case 186:
                        this.redPackRainResourceId = codedInputByteBufferNano.readString();
                        break;
                    case 194:
                        if (this.widgetLottiePic == null) {
                            this.widgetLottiePic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetLottiePic);
                        break;
                    case 202:
                        if (this.widgetLottieJson == null) {
                            this.widgetLottieJson = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetLottieJson);
                        break;
                    case 210:
                        if (this.widgetButton == null) {
                            this.widgetButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetButton);
                        break;
                    case 216:
                        this.animateMagicFaceId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 226:
                        if (this.animateSponsorTitlePic == null) {
                            this.animateSponsorTitlePic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.animateSponsorTitlePic);
                        break;
                    case 234:
                        if (this.animateSponsorRedPackPic == null) {
                            this.animateSponsorRedPackPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.animateSponsorRedPackPic);
                        break;
                    case 242:
                        if (this.grabPopCoverTopPic == null) {
                            this.grabPopCoverTopPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopCoverTopPic);
                        break;
                    case 250:
                        if (this.grabPopCoverBottomPic == null) {
                            this.grabPopCoverBottomPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopCoverBottomPic);
                        break;
                    case 258:
                        if (this.grabPopAnimateStarPic == null) {
                            this.grabPopAnimateStarPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopAnimateStarPic);
                        break;
                    case 266:
                        if (this.grabPopAnimateRedPackPic == null) {
                            this.grabPopAnimateRedPackPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopAnimateRedPackPic);
                        break;
                    case 274:
                        if (this.grabPopUnopenedTitlePic == null) {
                            this.grabPopUnopenedTitlePic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopUnopenedTitlePic);
                        break;
                    case 282:
                        if (this.grabPopUnopenedSubtitleText == null) {
                            this.grabPopUnopenedSubtitleText = new RedPackRainText();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopUnopenedSubtitleText);
                        break;
                    case 290:
                        if (this.grabPopCountDownButton == null) {
                            this.grabPopCountDownButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopCountDownButton);
                        break;
                    case 298:
                        if (this.grabPopReserveButton == null) {
                            this.grabPopReserveButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopReserveButton);
                        break;
                    case 306:
                        if (this.grabPopGrabPic == null) {
                            this.grabPopGrabPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopGrabPic);
                        break;
                    case 314:
                        if (this.grabPopRuleButton == null) {
                            this.grabPopRuleButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabPopRuleButton);
                        break;
                    case 322:
                        if (this.grabResultCardPic == null) {
                            this.grabResultCardPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultCardPic);
                        break;
                    case 330:
                        this.grabResultSummaryTextColor = codedInputByteBufferNano.readString();
                        break;
                    case 338:
                        if (this.grabResultKoiBackgroundPic == null) {
                            this.grabResultKoiBackgroundPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultKoiBackgroundPic);
                        break;
                    case 346:
                        if (this.grabResultKoiCoverBottomPic == null) {
                            this.grabResultKoiCoverBottomPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultKoiCoverBottomPic);
                        break;
                    case 354:
                        if (this.grabResultKoiCardPic == null) {
                            this.grabResultKoiCardPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultKoiCardPic);
                        break;
                    case 362:
                        if (this.grabResultKoiReceiveButton == null) {
                            this.grabResultKoiReceiveButton = new RedPackRainButton();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultKoiReceiveButton);
                        break;
                    case 370:
                        this.grabResultKoiSummaryTextColor = codedInputByteBufferNano.readString();
                        break;
                    case 378:
                        if (this.grabResultMissPic == null) {
                            this.grabResultMissPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultMissPic);
                        break;
                    case 386:
                        this.grabResultMissTextColor = codedInputByteBufferNano.readString();
                        break;
                    case 394:
                        if (this.widgetBackgroundPic == null) {
                            this.widgetBackgroundPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetBackgroundPic);
                        break;
                    case 402:
                        this.widgetTextColor = codedInputByteBufferNano.readString();
                        break;
                    case SocketMessages.PayloadType.SC_WISH_LIST_OPENED /* 410 */:
                        if (this.grabResultCoverBottomPic == null) {
                            this.grabResultCoverBottomPic = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.grabResultCoverBottomPic);
                        break;
                    case 418:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 418);
                        RedPackRainPrizePic[] redPackRainPrizePicArr = this.prizePic;
                        int length2 = redPackRainPrizePicArr == null ? 0 : redPackRainPrizePicArr.length;
                        RedPackRainPrizePic[] redPackRainPrizePicArr2 = new RedPackRainPrizePic[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.prizePic, 0, redPackRainPrizePicArr2, 0, length2);
                        }
                        while (length2 < redPackRainPrizePicArr2.length - 1) {
                            redPackRainPrizePicArr2[length2] = new RedPackRainPrizePic();
                            codedInputByteBufferNano.readMessage(redPackRainPrizePicArr2[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        redPackRainPrizePicArr2[length2] = new RedPackRainPrizePic();
                        codedInputByteBufferNano.readMessage(redPackRainPrizePicArr2[length2]);
                        this.prizePic = redPackRainPrizePicArr2;
                        break;
                    case 426:
                        if (this.widgetBackgroundPicV2 == null) {
                            this.widgetBackgroundPicV2 = new RedPackRainPicture();
                        }
                        codedInputByteBufferNano.readMessage(this.widgetBackgroundPicV2);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCRedPackRainResource parseFrom(byte[] bArr) {
            return (SCRedPackRainResource) MessageNano.mergeFrom(new SCRedPackRainResource(), bArr);
        }

        public static SCRedPackRainResource parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCRedPackRainResource().mergeFrom(codedInputByteBufferNano);
        }
    }
}
