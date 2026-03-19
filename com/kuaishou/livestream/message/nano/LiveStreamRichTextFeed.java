package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveAudienceState;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveStreamRichTextFeed {

    public static final class RichTextFeed extends MessageNano {
        private static volatile RichTextFeed[] _emptyArray;
        public String id;
        public RichTextSegment[] segments;
        public long sortRank;
        public long time;
        public int type;

        public static RichTextFeed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RichTextFeed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RichTextFeed() {
            clear();
        }

        public final RichTextFeed clear() {
            this.id = "";
            this.sortRank = 0L;
            this.time = 0L;
            this.type = 0;
            this.segments = RichTextSegment.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            long j = this.sortRank;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.time;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            RichTextSegment[] richTextSegmentArr = this.segments;
            if (richTextSegmentArr != null && richTextSegmentArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RichTextSegment[] richTextSegmentArr2 = this.segments;
                    if (i2 >= richTextSegmentArr2.length) {
                        break;
                    }
                    RichTextSegment richTextSegment = richTextSegmentArr2[i2];
                    if (richTextSegment != null) {
                        codedOutputByteBufferNano.writeMessage(5, richTextSegment);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            long j = this.sortRank;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.time;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            RichTextSegment[] richTextSegmentArr = this.segments;
            if (richTextSegmentArr != null && richTextSegmentArr.length > 0) {
                int i2 = 0;
                while (true) {
                    RichTextSegment[] richTextSegmentArr2 = this.segments;
                    if (i2 >= richTextSegmentArr2.length) {
                        break;
                    }
                    RichTextSegment richTextSegment = richTextSegmentArr2[i2];
                    if (richTextSegment != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, richTextSegment);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RichTextFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.id = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.sortRank = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.time = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.type = codedInputByteBufferNano.readUInt32();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    RichTextSegment[] richTextSegmentArr = this.segments;
                    int length = richTextSegmentArr == null ? 0 : richTextSegmentArr.length;
                    RichTextSegment[] richTextSegmentArr2 = new RichTextSegment[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.segments, 0, richTextSegmentArr2, 0, length);
                    }
                    while (length < richTextSegmentArr2.length - 1) {
                        richTextSegmentArr2[length] = new RichTextSegment();
                        codedInputByteBufferNano.readMessage(richTextSegmentArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    richTextSegmentArr2[length] = new RichTextSegment();
                    codedInputByteBufferNano.readMessage(richTextSegmentArr2[length]);
                    this.segments = richTextSegmentArr2;
                }
            }
        }

        public static RichTextFeed parseFrom(byte[] bArr) {
            return (RichTextFeed) MessageNano.mergeFrom(new RichTextFeed(), bArr);
        }

        public static RichTextFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RichTextFeed().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RichTextSegment extends MessageNano {
        public static final int BUTTON_FIELD_NUMBER = 4;
        public static final int GIFT_FIELD_NUMBER = 5;
        public static final int IMAGE_FIELD_NUMBER = 3;
        public static final int PLAIN_FIELD_NUMBER = 2;
        public static final int STATE_FIELD_NUMBER = 6;
        public static final int USER_INFO_FIELD_NUMBER = 1;
        private static volatile RichTextSegment[] _emptyArray;
        private int contentCase_ = 0;
        private Object content_;

        public final int getContentCase() {
            return this.contentCase_;
        }

        public final RichTextSegment clearContent() {
            this.contentCase_ = 0;
            this.content_ = null;
            return this;
        }

        public static RichTextSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RichTextSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasUserInfo() {
            return this.contentCase_ == 1;
        }

        public final UserInfoSegment getUserInfo() {
            if (this.contentCase_ == 1) {
                return (UserInfoSegment) this.content_;
            }
            return null;
        }

        public final RichTextSegment setUserInfo(UserInfoSegment userInfoSegment) {
            if (userInfoSegment == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 1;
            this.content_ = userInfoSegment;
            return this;
        }

        public final boolean hasPlain() {
            return this.contentCase_ == 2;
        }

        public final PlainSegment getPlain() {
            if (this.contentCase_ == 2) {
                return (PlainSegment) this.content_;
            }
            return null;
        }

        public final RichTextSegment setPlain(PlainSegment plainSegment) {
            if (plainSegment == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 2;
            this.content_ = plainSegment;
            return this;
        }

        public final boolean hasImage() {
            return this.contentCase_ == 3;
        }

        public final ImageSegment getImage() {
            if (this.contentCase_ == 3) {
                return (ImageSegment) this.content_;
            }
            return null;
        }

        public final RichTextSegment setImage(ImageSegment imageSegment) {
            if (imageSegment == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 3;
            this.content_ = imageSegment;
            return this;
        }

        public final boolean hasButton() {
            return this.contentCase_ == 4;
        }

        public final ButtonSegment getButton() {
            if (this.contentCase_ == 4) {
                return (ButtonSegment) this.content_;
            }
            return null;
        }

        public final RichTextSegment setButton(ButtonSegment buttonSegment) {
            if (buttonSegment == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 4;
            this.content_ = buttonSegment;
            return this;
        }

        public final boolean hasGift() {
            return this.contentCase_ == 5;
        }

        public final GiftSegment getGift() {
            if (this.contentCase_ == 5) {
                return (GiftSegment) this.content_;
            }
            return null;
        }

        public final RichTextSegment setGift(GiftSegment giftSegment) {
            if (giftSegment == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 5;
            this.content_ = giftSegment;
            return this;
        }

        public final boolean hasState() {
            return this.contentCase_ == 6;
        }

        public final AudienceStateSegment getState() {
            if (this.contentCase_ == 6) {
                return (AudienceStateSegment) this.content_;
            }
            return null;
        }

        public final RichTextSegment setState(AudienceStateSegment audienceStateSegment) {
            if (audienceStateSegment == null) {
                throw new NullPointerException();
            }
            this.contentCase_ = 6;
            this.content_ = audienceStateSegment;
            return this;
        }

        public RichTextSegment() {
            clear();
        }

        public final RichTextSegment clear() {
            clearContent();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.contentCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 3) {
                codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 4) {
                codedOutputByteBufferNano.writeMessage(4, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 5) {
                codedOutputByteBufferNano.writeMessage(5, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 6) {
                codedOutputByteBufferNano.writeMessage(6, (MessageNano) this.content_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (this.contentCase_ == 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano) this.content_);
            }
            if (this.contentCase_ == 5) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano) this.content_);
            }
            return this.contentCase_ == 6 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, (MessageNano) this.content_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RichTextSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.contentCase_ != 1) {
                        this.content_ = new UserInfoSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 1;
                } else if (tag == 18) {
                    if (this.contentCase_ != 2) {
                        this.content_ = new PlainSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 2;
                } else if (tag == 26) {
                    if (this.contentCase_ != 3) {
                        this.content_ = new ImageSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 3;
                } else if (tag == 34) {
                    if (this.contentCase_ != 4) {
                        this.content_ = new ButtonSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 4;
                } else if (tag == 42) {
                    if (this.contentCase_ != 5) {
                        this.content_ = new GiftSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 5;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.contentCase_ != 6) {
                        this.content_ = new AudienceStateSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.content_);
                    this.contentCase_ = 6;
                }
            }
        }

        public static RichTextSegment parseFrom(byte[] bArr) {
            return (RichTextSegment) MessageNano.mergeFrom(new RichTextSegment(), bArr);
        }

        public static RichTextSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RichTextSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class UserInfoSegment extends MessageNano {
        private static volatile UserInfoSegment[] _emptyArray;
        public String color;
        public UserInfos.UserInfo user;

        public static UserInfoSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UserInfoSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UserInfoSegment() {
            clear();
        }

        public final UserInfoSegment clear() {
            this.user = null;
            this.color = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.user;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            if (!this.color.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.color);
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
            return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final UserInfoSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.user == null) {
                        this.user = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.color = codedInputByteBufferNano.readString();
                }
            }
        }

        public static UserInfoSegment parseFrom(byte[] bArr) {
            return (UserInfoSegment) MessageNano.mergeFrom(new UserInfoSegment(), bArr);
        }

        public static UserInfoSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UserInfoSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class PlainSegment extends MessageNano {
        private static volatile PlainSegment[] _emptyArray;
        public String color;
        public String text;

        public static PlainSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PlainSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PlainSegment() {
            clear();
        }

        public final PlainSegment clear() {
            this.text = "";
            this.color = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            if (!this.color.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.color);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PlainSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.color = codedInputByteBufferNano.readString();
                }
            }
        }

        public static PlainSegment parseFrom(byte[] bArr) {
            return (PlainSegment) MessageNano.mergeFrom(new PlainSegment(), bArr);
        }

        public static PlainSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PlainSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ImageSegment extends MessageNano {
        private static volatile ImageSegment[] _emptyArray;
        public String alternativeColor;
        public String alternativeText;
        public UserInfos.PicUrl[] imageUrls;

        public static ImageSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ImageSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ImageSegment() {
            clear();
        }

        public final ImageSegment clear() {
            this.imageUrls = UserInfos.PicUrl.emptyArray();
            this.alternativeText = "";
            this.alternativeColor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.imageUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrls;
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
            if (!this.alternativeText.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.alternativeText);
            }
            if (!this.alternativeColor.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.alternativeColor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.imageUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrls;
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
            if (!this.alternativeText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.alternativeText);
            }
            return !this.alternativeColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.alternativeColor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ImageSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.imageUrls;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.imageUrls, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.imageUrls = picUrlArr2;
                } else if (tag == 18) {
                    this.alternativeText = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.alternativeColor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ImageSegment parseFrom(byte[] bArr) {
            return (ImageSegment) MessageNano.mergeFrom(new ImageSegment(), bArr);
        }

        public static ImageSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ImageSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ButtonSegment extends MessageNano {
        private static volatile ButtonSegment[] _emptyArray;
        public String actionLink;
        public int actionType;
        public String text;
        public String textColor;
        public String traceMessage;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ButtonActionType {
            public static final int ACTION_UNKNOWN = 0;
            public static final int KWAI_URL = 1;
            public static final int LIVE_ROUTER = 3;
            public static final int WEB_VIEW = 2;
        }

        public static ButtonSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ButtonSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ButtonSegment() {
            clear();
        }

        public final ButtonSegment clear() {
            this.text = "";
            this.textColor = "";
            this.actionType = 0;
            this.actionLink = "";
            this.traceMessage = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.textColor);
            }
            int i = this.actionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            if (!this.actionLink.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.actionLink);
            }
            if (!this.traceMessage.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.traceMessage);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.textColor);
            }
            int i = this.actionType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            if (!this.actionLink.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.actionLink);
            }
            return !this.traceMessage.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.traceMessage) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ButtonSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.textColor = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.actionType = int32;
                    }
                } else if (tag == 34) {
                    this.actionLink = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.traceMessage = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ButtonSegment parseFrom(byte[] bArr) {
            return (ButtonSegment) MessageNano.mergeFrom(new ButtonSegment(), bArr);
        }

        public static ButtonSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ButtonSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class GiftSegment extends MessageNano {
        private static volatile GiftSegment[] _emptyArray;
        public int giftId;

        public static GiftSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GiftSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GiftSegment() {
            clear();
        }

        public final GiftSegment clear() {
            this.giftId = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.giftId;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final GiftSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static GiftSegment parseFrom(byte[] bArr) {
            return (GiftSegment) MessageNano.mergeFrom(new GiftSegment(), bArr);
        }

        public static GiftSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new GiftSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AudienceStateSegment extends MessageNano {
        private static volatile AudienceStateSegment[] _emptyArray;
        public LiveAudienceState audienceState;

        public static AudienceStateSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AudienceStateSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AudienceStateSegment() {
            clear();
        }

        public final AudienceStateSegment clear() {
            this.audienceState = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveAudienceState liveAudienceState = this.audienceState;
            if (liveAudienceState != null) {
                codedOutputByteBufferNano.writeMessage(1, liveAudienceState);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveAudienceState liveAudienceState = this.audienceState;
            return liveAudienceState != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveAudienceState) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AudienceStateSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.audienceState == null) {
                        this.audienceState = new LiveAudienceState();
                    }
                    codedInputByteBufferNano.readMessage(this.audienceState);
                }
            }
        }

        public static AudienceStateSegment parseFrom(byte[] bArr) {
            return (AudienceStateSegment) MessageNano.mergeFrom(new AudienceStateSegment(), bArr);
        }

        public static AudienceStateSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AudienceStateSegment().mergeFrom(codedInputByteBufferNano);
        }
    }
}
