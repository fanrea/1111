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
public interface LiveRevenueBlessgingBagProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BlessingBagWidgetStatus {
        public static final int BLESSING_BAG_WIDGET_CAMPAIGN_END = 3;
        public static final int BLESSING_BAG_WIDGET_CAN_GRAB = 2;
        public static final int BLESSING_BAG_WIDGET_TASK_FINISH = 4;
        public static final int BLESSING_BAG_WIDGET_TASK_IS_ON = 1;
        public static final int BLESSING_BAG_WIDGET_UNKNOWN = 0;
    }

    public static final class SCLiveRevenueBlessingBagWidget extends MessageNano {
        private static volatile SCLiveRevenueBlessingBagWidget[] _emptyArray;
        public UserInfos.PicUrl[] bagUrl;
        public BlessingBagWidgeContentWithStyle bottomText;
        public String campaignId;
        public String liveStreamId;
        public int status;
        public UserInfos.PicUrl[] titleBgUrl;

        public static SCLiveRevenueBlessingBagWidget[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRevenueBlessingBagWidget[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRevenueBlessingBagWidget() {
            clear();
        }

        public final SCLiveRevenueBlessingBagWidget clear() {
            this.campaignId = "";
            this.status = 0;
            this.bagUrl = UserInfos.PicUrl.emptyArray();
            this.bottomText = null;
            this.titleBgUrl = UserInfos.PicUrl.emptyArray();
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.campaignId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.campaignId);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.bagUrl;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.bagUrl;
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
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle = this.bottomText;
            if (blessingBagWidgeContentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(4, blessingBagWidgeContentWithStyle);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.titleBgUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.titleBgUrl;
                    if (i2 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i2];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl2);
                    }
                    i2++;
                }
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.campaignId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.campaignId);
            }
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.bagUrl;
            int i2 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.bagUrl;
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
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle = this.bottomText;
            if (blessingBagWidgeContentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, blessingBagWidgeContentWithStyle);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.titleBgUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.titleBgUrl;
                    if (i2 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i2];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl2);
                    }
                    i2++;
                }
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRevenueBlessingBagWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.campaignId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                        this.status = int32;
                    }
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr = this.bagUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.bagUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.bagUrl = picUrlArr2;
                } else if (tag == 34) {
                    if (this.bottomText == null) {
                        this.bottomText = new BlessingBagWidgeContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.bottomText);
                } else if (tag == 42) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr3 = this.titleBgUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.titleBgUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.titleBgUrl = picUrlArr4;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveRevenueBlessingBagWidget parseFrom(byte[] bArr) {
            return (SCLiveRevenueBlessingBagWidget) MessageNano.mergeFrom(new SCLiveRevenueBlessingBagWidget(), bArr);
        }

        public static SCLiveRevenueBlessingBagWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRevenueBlessingBagWidget().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRevenueBlessingBagToast extends MessageNano {
        private static volatile SCLiveRevenueBlessingBagToast[] _emptyArray;
        public BlessingBagWidgeContentWithStyle noticeTextCaption;
        public BlessingBagWidgeContentWithStyle noticeTextSubline;

        public static SCLiveRevenueBlessingBagToast[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRevenueBlessingBagToast[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRevenueBlessingBagToast() {
            clear();
        }

        public final SCLiveRevenueBlessingBagToast clear() {
            this.noticeTextCaption = null;
            this.noticeTextSubline = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle = this.noticeTextCaption;
            if (blessingBagWidgeContentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(1, blessingBagWidgeContentWithStyle);
            }
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle2 = this.noticeTextSubline;
            if (blessingBagWidgeContentWithStyle2 != null) {
                codedOutputByteBufferNano.writeMessage(2, blessingBagWidgeContentWithStyle2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle = this.noticeTextCaption;
            if (blessingBagWidgeContentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, blessingBagWidgeContentWithStyle);
            }
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle2 = this.noticeTextSubline;
            return blessingBagWidgeContentWithStyle2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, blessingBagWidgeContentWithStyle2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRevenueBlessingBagToast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.noticeTextCaption == null) {
                        this.noticeTextCaption = new BlessingBagWidgeContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.noticeTextCaption);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.noticeTextSubline == null) {
                        this.noticeTextSubline = new BlessingBagWidgeContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.noticeTextSubline);
                }
            }
        }

        public static SCLiveRevenueBlessingBagToast parseFrom(byte[] bArr) {
            return (SCLiveRevenueBlessingBagToast) MessageNano.mergeFrom(new SCLiveRevenueBlessingBagToast(), bArr);
        }

        public static SCLiveRevenueBlessingBagToast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRevenueBlessingBagToast().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRevenueBlessingBagNotice extends MessageNano {
        private static volatile SCLiveRevenueBlessingBagNotice[] _emptyArray;
        public String liveStreamId;
        public BlessingBagWidgeContentWithStyle noticeTextCaption;
        public BlessingBagWidgeContentWithStyle noticeTextSubline;
        public int taskType;

        public static SCLiveRevenueBlessingBagNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRevenueBlessingBagNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRevenueBlessingBagNotice() {
            clear();
        }

        public final SCLiveRevenueBlessingBagNotice clear() {
            this.noticeTextCaption = null;
            this.noticeTextSubline = null;
            this.taskType = 0;
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle = this.noticeTextCaption;
            if (blessingBagWidgeContentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(1, blessingBagWidgeContentWithStyle);
            }
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle2 = this.noticeTextSubline;
            if (blessingBagWidgeContentWithStyle2 != null) {
                codedOutputByteBufferNano.writeMessage(2, blessingBagWidgeContentWithStyle2);
            }
            int i = this.taskType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle = this.noticeTextCaption;
            if (blessingBagWidgeContentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, blessingBagWidgeContentWithStyle);
            }
            BlessingBagWidgeContentWithStyle blessingBagWidgeContentWithStyle2 = this.noticeTextSubline;
            if (blessingBagWidgeContentWithStyle2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, blessingBagWidgeContentWithStyle2);
            }
            int i = this.taskType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRevenueBlessingBagNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.noticeTextCaption == null) {
                        this.noticeTextCaption = new BlessingBagWidgeContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.noticeTextCaption);
                } else if (tag == 18) {
                    if (this.noticeTextSubline == null) {
                        this.noticeTextSubline = new BlessingBagWidgeContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.noticeTextSubline);
                } else if (tag == 24) {
                    this.taskType = codedInputByteBufferNano.readUInt32();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveRevenueBlessingBagNotice parseFrom(byte[] bArr) {
            return (SCLiveRevenueBlessingBagNotice) MessageNano.mergeFrom(new SCLiveRevenueBlessingBagNotice(), bArr);
        }

        public static SCLiveRevenueBlessingBagNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRevenueBlessingBagNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class BlessingBagWidgeContentWithStyle extends MessageNano {
        private static volatile BlessingBagWidgeContentWithStyle[] _emptyArray;
        public String color;
        public String content;

        public static BlessingBagWidgeContentWithStyle[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new BlessingBagWidgeContentWithStyle[0];
                    }
                }
            }
            return _emptyArray;
        }

        public BlessingBagWidgeContentWithStyle() {
            clear();
        }

        public final BlessingBagWidgeContentWithStyle clear() {
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
        public final BlessingBagWidgeContentWithStyle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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

        public static BlessingBagWidgeContentWithStyle parseFrom(byte[] bArr) {
            return (BlessingBagWidgeContentWithStyle) MessageNano.mergeFrom(new BlessingBagWidgeContentWithStyle(), bArr);
        }

        public static BlessingBagWidgeContentWithStyle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new BlessingBagWidgeContentWithStyle().mergeFrom(codedInputByteBufferNano);
        }
    }
}
