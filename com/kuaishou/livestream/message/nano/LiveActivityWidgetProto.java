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
public interface LiveActivityWidgetProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveActivityWidgetPopupOpenType {
        public static final int FULL_POPUP_OPEN_TYPE = 2;
        public static final int HALF_POPUP_OPEN_TYPE = 1;
        public static final int UNKNOWN_POPUP_OPEN_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveActivityWidgetScalingColorType {
        public static final int DARK_COLOR_BAR_TYPE = 2;
        public static final int TINT_COLOR_BAR_TYPE = 1;
        public static final int UNKNOWN_BAR_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveActivityWidgetTemplate {
        public static final int FOUR_TEXT_TEMPLATE = 1;
        public static final int ONE_TEXT_ONE_PIC_TEMPLATE = 5;
        public static final int THREE_TEXT_TEMPLATE = 2;
        public static final int TWO_TEXT_ONE_PIC_TEMPLATE = 3;
        public static final int TWO_TEXT_TEMPLATE = 4;
        public static final int UNKNOWN_TEMPLATE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveActivityWidgetTextType {
        public static final int NORMAL_TEXT_TYPE = 1;
        public static final int TIMESTAMP_TEXT_TYPE = 2;
        public static final int UNKNOWN_TEXT_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveActivityWidgetType {
        public static final int BIG_WIDGET_TYPE = 3;
        public static final int NORMAL_WIDGET_TYPE = 2;
        public static final int STATIC_WIDGET_TYPE = 1;
        public static final int UNKNOWN_WIDGET_TYPE = 0;
    }

    public static final class LiveActivityWidgetBase extends MessageNano {
        private static volatile LiveActivityWidgetBase[] _emptyArray;
        public boolean isExclusive;
        public String ksOrderId;
        public String name;
        public long startTime;
        public int type;

        public static LiveActivityWidgetBase[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetBase[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityWidgetBase() {
            clear();
        }

        public final LiveActivityWidgetBase clear() {
            this.type = 0;
            this.name = "";
            this.startTime = 0L;
            this.ksOrderId = "";
            this.isExclusive = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.name.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.name);
            }
            long j = this.startTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.ksOrderId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.ksOrderId);
            }
            boolean z = this.isExclusive;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
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
            if (!this.name.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
            }
            long j = this.startTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            if (!this.ksOrderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.ksOrderId);
            }
            boolean z = this.isExclusive;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetBase mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.type = int32;
                    }
                } else if (tag == 18) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 34) {
                    this.ksOrderId = codedInputByteBufferNano.readString();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.isExclusive = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static LiveActivityWidgetBase parseFrom(byte[] bArr) {
            return (LiveActivityWidgetBase) MessageNano.mergeFrom(new LiveActivityWidgetBase(), bArr);
        }

        public static LiveActivityWidgetBase parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetBase().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityWidgetTextModel extends MessageNano {
        public static final int TEXT_FIELD_NUMBER = 1;
        public static final int TIMESTAMP_FIELD_NUMBER = 2;
        private static volatile LiveActivityWidgetTextModel[] _emptyArray;
        public String textColor;
        private int textContentCase_ = 0;
        private Object textContent_;
        public int textType;

        public final int getTextContentCase() {
            return this.textContentCase_;
        }

        public final LiveActivityWidgetTextModel clearTextContent() {
            this.textContentCase_ = 0;
            this.textContent_ = null;
            return this;
        }

        public static LiveActivityWidgetTextModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetTextModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasText() {
            return this.textContentCase_ == 1;
        }

        public final String getText() {
            return this.textContentCase_ == 1 ? (String) this.textContent_ : "";
        }

        public final LiveActivityWidgetTextModel setText(String str) {
            this.textContentCase_ = 1;
            this.textContent_ = str;
            return this;
        }

        public final boolean hasTimestamp() {
            return this.textContentCase_ == 2;
        }

        public final long getTimestamp() {
            if (this.textContentCase_ == 2) {
                return ((Long) this.textContent_).longValue();
            }
            return 0L;
        }

        public final LiveActivityWidgetTextModel setTimestamp(long j) {
            this.textContentCase_ = 2;
            this.textContent_ = Long.valueOf(j);
            return this;
        }

        public LiveActivityWidgetTextModel() {
            clear();
        }

        public final LiveActivityWidgetTextModel clear() {
            this.textColor = "";
            this.textType = 0;
            clearTextContent();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.textContentCase_ == 1) {
                codedOutputByteBufferNano.writeString(1, (String) this.textContent_);
            }
            if (this.textContentCase_ == 2) {
                codedOutputByteBufferNano.writeUInt64(2, ((Long) this.textContent_).longValue());
            }
            if (!this.textColor.equals("")) {
                codedOutputByteBufferNano.writeString(20, this.textColor);
            }
            int i = this.textType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(21, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (this.textContentCase_ == 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, (String) this.textContent_);
            }
            if (this.textContentCase_ == 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, ((Long) this.textContent_).longValue());
            }
            if (!this.textColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(20, this.textColor);
            }
            int i = this.textType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(21, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetTextModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.textContent_ = codedInputByteBufferNano.readString();
                    this.textContentCase_ = 1;
                } else if (tag == 16) {
                    this.textContent_ = Long.valueOf(codedInputByteBufferNano.readUInt64());
                    this.textContentCase_ = 2;
                } else if (tag == 162) {
                    this.textColor = codedInputByteBufferNano.readString();
                } else if (tag != 168) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.textType = int32;
                    }
                }
            }
        }

        public static LiveActivityWidgetTextModel parseFrom(byte[] bArr) {
            return (LiveActivityWidgetTextModel) MessageNano.mergeFrom(new LiveActivityWidgetTextModel(), bArr);
        }

        public static LiveActivityWidgetTextModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetTextModel().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityWidgetLineText extends MessageNano {
        private static volatile LiveActivityWidgetLineText[] _emptyArray;
        public LiveActivityWidgetTextModel firstFieldText;
        public LiveActivityWidgetTextModel secondFieldText;

        public static LiveActivityWidgetLineText[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetLineText[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityWidgetLineText() {
            clear();
        }

        public final LiveActivityWidgetLineText clear() {
            this.firstFieldText = null;
            this.secondFieldText = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveActivityWidgetTextModel liveActivityWidgetTextModel = this.firstFieldText;
            if (liveActivityWidgetTextModel != null) {
                codedOutputByteBufferNano.writeMessage(1, liveActivityWidgetTextModel);
            }
            LiveActivityWidgetTextModel liveActivityWidgetTextModel2 = this.secondFieldText;
            if (liveActivityWidgetTextModel2 != null) {
                codedOutputByteBufferNano.writeMessage(2, liveActivityWidgetTextModel2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveActivityWidgetTextModel liveActivityWidgetTextModel = this.firstFieldText;
            if (liveActivityWidgetTextModel != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveActivityWidgetTextModel);
            }
            LiveActivityWidgetTextModel liveActivityWidgetTextModel2 = this.secondFieldText;
            return liveActivityWidgetTextModel2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, liveActivityWidgetTextModel2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetLineText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.firstFieldText == null) {
                        this.firstFieldText = new LiveActivityWidgetTextModel();
                    }
                    codedInputByteBufferNano.readMessage(this.firstFieldText);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.secondFieldText == null) {
                        this.secondFieldText = new LiveActivityWidgetTextModel();
                    }
                    codedInputByteBufferNano.readMessage(this.secondFieldText);
                }
            }
        }

        public static LiveActivityWidgetLineText parseFrom(byte[] bArr) {
            return (LiveActivityWidgetLineText) MessageNano.mergeFrom(new LiveActivityWidgetLineText(), bArr);
        }

        public static LiveActivityWidgetLineText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetLineText().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityWidgetLinePic extends MessageNano {
        private static volatile LiveActivityWidgetLinePic[] _emptyArray;
        public UserInfos.PicUrl[] picUrl;

        public static LiveActivityWidgetLinePic[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetLinePic[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityWidgetLinePic() {
            clear();
        }

        public final LiveActivityWidgetLinePic clear() {
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
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
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
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetLinePic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
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

        public static LiveActivityWidgetLinePic parseFrom(byte[] bArr) {
            return (LiveActivityWidgetLinePic) MessageNano.mergeFrom(new LiveActivityWidgetLinePic(), bArr);
        }

        public static LiveActivityWidgetLinePic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetLinePic().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityWidgetLineContent extends MessageNano {
        public static final int LINE_PIC_FIELD_NUMBER = 2;
        public static final int LINE_TEXT_FIELD_NUMBER = 1;
        private static volatile LiveActivityWidgetLineContent[] _emptyArray;
        private int lineContentCase_ = 0;
        private Object lineContent_;

        public final int getLineContentCase() {
            return this.lineContentCase_;
        }

        public final LiveActivityWidgetLineContent clearLineContent() {
            this.lineContentCase_ = 0;
            this.lineContent_ = null;
            return this;
        }

        public static LiveActivityWidgetLineContent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetLineContent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasLineText() {
            return this.lineContentCase_ == 1;
        }

        public final LiveActivityWidgetLineText getLineText() {
            if (this.lineContentCase_ == 1) {
                return (LiveActivityWidgetLineText) this.lineContent_;
            }
            return null;
        }

        public final LiveActivityWidgetLineContent setLineText(LiveActivityWidgetLineText liveActivityWidgetLineText) {
            if (liveActivityWidgetLineText == null) {
                throw new NullPointerException();
            }
            this.lineContentCase_ = 1;
            this.lineContent_ = liveActivityWidgetLineText;
            return this;
        }

        public final boolean hasLinePic() {
            return this.lineContentCase_ == 2;
        }

        public final LiveActivityWidgetLinePic getLinePic() {
            if (this.lineContentCase_ == 2) {
                return (LiveActivityWidgetLinePic) this.lineContent_;
            }
            return null;
        }

        public final LiveActivityWidgetLineContent setLinePic(LiveActivityWidgetLinePic liveActivityWidgetLinePic) {
            if (liveActivityWidgetLinePic == null) {
                throw new NullPointerException();
            }
            this.lineContentCase_ = 2;
            this.lineContent_ = liveActivityWidgetLinePic;
            return this;
        }

        public LiveActivityWidgetLineContent() {
            clear();
        }

        public final LiveActivityWidgetLineContent clear() {
            clearLineContent();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.lineContentCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.lineContent_);
            }
            if (this.lineContentCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.lineContent_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (this.lineContentCase_ == 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.lineContent_);
            }
            return this.lineContentCase_ == 2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.lineContent_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetLineContent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.lineContentCase_ != 1) {
                        this.lineContent_ = new LiveActivityWidgetLineText();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.lineContent_);
                    this.lineContentCase_ = 1;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.lineContentCase_ != 2) {
                        this.lineContent_ = new LiveActivityWidgetLinePic();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.lineContent_);
                    this.lineContentCase_ = 2;
                }
            }
        }

        public static LiveActivityWidgetLineContent parseFrom(byte[] bArr) {
            return (LiveActivityWidgetLineContent) MessageNano.mergeFrom(new LiveActivityWidgetLineContent(), bArr);
        }

        public static LiveActivityWidgetLineContent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetLineContent().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityWidgetMessage extends MessageNano {
        private static volatile LiveActivityWidgetMessage[] _emptyArray;
        public UserInfos.PicUrl[] backgroundPic;
        public LiveActivityWidgetLineContent[] line;
        public int template;

        public static LiveActivityWidgetMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityWidgetMessage() {
            clear();
        }

        public final LiveActivityWidgetMessage clear() {
            this.backgroundPic = UserInfos.PicUrl.emptyArray();
            this.template = 0;
            this.line = LiveActivityWidgetLineContent.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPic;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            int i3 = this.template;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i3);
            }
            LiveActivityWidgetLineContent[] liveActivityWidgetLineContentArr = this.line;
            if (liveActivityWidgetLineContentArr != null && liveActivityWidgetLineContentArr.length > 0) {
                while (true) {
                    LiveActivityWidgetLineContent[] liveActivityWidgetLineContentArr2 = this.line;
                    if (i >= liveActivityWidgetLineContentArr2.length) {
                        break;
                    }
                    LiveActivityWidgetLineContent liveActivityWidgetLineContent = liveActivityWidgetLineContentArr2[i];
                    if (liveActivityWidgetLineContent != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveActivityWidgetLineContent);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPic;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            int i3 = this.template;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i3);
            }
            LiveActivityWidgetLineContent[] liveActivityWidgetLineContentArr = this.line;
            if (liveActivityWidgetLineContentArr != null && liveActivityWidgetLineContentArr.length > 0) {
                while (true) {
                    LiveActivityWidgetLineContent[] liveActivityWidgetLineContentArr2 = this.line;
                    if (i >= liveActivityWidgetLineContentArr2.length) {
                        break;
                    }
                    LiveActivityWidgetLineContent liveActivityWidgetLineContent = liveActivityWidgetLineContentArr2[i];
                    if (liveActivityWidgetLineContent != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveActivityWidgetLineContent);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.backgroundPic;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.backgroundPic, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.backgroundPic = picUrlArr2;
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                        this.template = int32;
                    }
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveActivityWidgetLineContent[] liveActivityWidgetLineContentArr = this.line;
                    int length2 = liveActivityWidgetLineContentArr == null ? 0 : liveActivityWidgetLineContentArr.length;
                    LiveActivityWidgetLineContent[] liveActivityWidgetLineContentArr2 = new LiveActivityWidgetLineContent[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.line, 0, liveActivityWidgetLineContentArr2, 0, length2);
                    }
                    while (length2 < liveActivityWidgetLineContentArr2.length - 1) {
                        liveActivityWidgetLineContentArr2[length2] = new LiveActivityWidgetLineContent();
                        codedInputByteBufferNano.readMessage(liveActivityWidgetLineContentArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    liveActivityWidgetLineContentArr2[length2] = new LiveActivityWidgetLineContent();
                    codedInputByteBufferNano.readMessage(liveActivityWidgetLineContentArr2[length2]);
                    this.line = liveActivityWidgetLineContentArr2;
                }
            }
        }

        public static LiveActivityWidgetMessage parseFrom(byte[] bArr) {
            return (LiveActivityWidgetMessage) MessageNano.mergeFrom(new LiveActivityWidgetMessage(), bArr);
        }

        public static LiveActivityWidgetMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityWidgetScaling extends MessageNano {
        private static volatile LiveActivityWidgetScaling[] _emptyArray;
        public String backgroundColor;
        public int scalingColorType;
        public UserInfos.PicUrl[] shrinkBarImg;
        public String shrinkBarImgTitle;
        public String title;

        public static LiveActivityWidgetScaling[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetScaling[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityWidgetScaling() {
            clear();
        }

        public final LiveActivityWidgetScaling clear() {
            this.backgroundColor = "";
            this.title = "";
            this.scalingColorType = 0;
            this.shrinkBarImg = UserInfos.PicUrl.emptyArray();
            this.shrinkBarImgTitle = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.backgroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.backgroundColor);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            int i = this.scalingColorType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.shrinkBarImg;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.shrinkBarImg;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.shrinkBarImgTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.shrinkBarImgTitle);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.backgroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.backgroundColor);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            int i = this.scalingColorType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            UserInfos.PicUrl[] picUrlArr = this.shrinkBarImg;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.shrinkBarImg;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                    }
                    i2++;
                }
            }
            return !this.shrinkBarImgTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.shrinkBarImgTitle) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetScaling mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.backgroundColor = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.scalingColorType = int32;
                    }
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr = this.shrinkBarImg;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.shrinkBarImg, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.shrinkBarImg = picUrlArr2;
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.shrinkBarImgTitle = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveActivityWidgetScaling parseFrom(byte[] bArr) {
            return (LiveActivityWidgetScaling) MessageNano.mergeFrom(new LiveActivityWidgetScaling(), bArr);
        }

        public static LiveActivityWidgetScaling parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetScaling().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityWidgetExtend extends MessageNano {
        private static volatile LiveActivityWidgetExtend[] _emptyArray;
        public String jumpUrl;
        public int popupOpenType;

        public static LiveActivityWidgetExtend[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityWidgetExtend[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityWidgetExtend() {
            clear();
        }

        public final LiveActivityWidgetExtend clear() {
            this.popupOpenType = 0;
            this.jumpUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.popupOpenType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.jumpUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.popupOpenType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            return !this.jumpUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.jumpUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityWidgetExtend mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.popupOpenType = int32;
                    }
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveActivityWidgetExtend parseFrom(byte[] bArr) {
            return (LiveActivityWidgetExtend) MessageNano.mergeFrom(new LiveActivityWidgetExtend(), bArr);
        }

        public static LiveActivityWidgetExtend parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityWidgetExtend().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCActivityWidgetUpdated extends MessageNano {
        private static volatile SCActivityWidgetUpdated[] _emptyArray;
        public LiveActivityWidgetBase base;
        public LiveActivityWidgetExtend extend;
        public long id;
        public LiveActivityWidgetMessage message;
        public LiveActivityWidgetScaling scaling;
        public int weight;

        public static SCActivityWidgetUpdated[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCActivityWidgetUpdated[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCActivityWidgetUpdated() {
            clear();
        }

        public final SCActivityWidgetUpdated clear() {
            this.id = 0L;
            this.base = null;
            this.message = null;
            this.scaling = null;
            this.extend = null;
            this.weight = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            LiveActivityWidgetBase liveActivityWidgetBase = this.base;
            if (liveActivityWidgetBase != null) {
                codedOutputByteBufferNano.writeMessage(2, liveActivityWidgetBase);
            }
            LiveActivityWidgetMessage liveActivityWidgetMessage = this.message;
            if (liveActivityWidgetMessage != null) {
                codedOutputByteBufferNano.writeMessage(3, liveActivityWidgetMessage);
            }
            LiveActivityWidgetScaling liveActivityWidgetScaling = this.scaling;
            if (liveActivityWidgetScaling != null) {
                codedOutputByteBufferNano.writeMessage(4, liveActivityWidgetScaling);
            }
            LiveActivityWidgetExtend liveActivityWidgetExtend = this.extend;
            if (liveActivityWidgetExtend != null) {
                codedOutputByteBufferNano.writeMessage(5, liveActivityWidgetExtend);
            }
            int i = this.weight;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            LiveActivityWidgetBase liveActivityWidgetBase = this.base;
            if (liveActivityWidgetBase != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveActivityWidgetBase);
            }
            LiveActivityWidgetMessage liveActivityWidgetMessage = this.message;
            if (liveActivityWidgetMessage != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveActivityWidgetMessage);
            }
            LiveActivityWidgetScaling liveActivityWidgetScaling = this.scaling;
            if (liveActivityWidgetScaling != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveActivityWidgetScaling);
            }
            LiveActivityWidgetExtend liveActivityWidgetExtend = this.extend;
            if (liveActivityWidgetExtend != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveActivityWidgetExtend);
            }
            int i = this.weight;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCActivityWidgetUpdated mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    if (this.base == null) {
                        this.base = new LiveActivityWidgetBase();
                    }
                    codedInputByteBufferNano.readMessage(this.base);
                } else if (tag == 26) {
                    if (this.message == null) {
                        this.message = new LiveActivityWidgetMessage();
                    }
                    codedInputByteBufferNano.readMessage(this.message);
                } else if (tag == 34) {
                    if (this.scaling == null) {
                        this.scaling = new LiveActivityWidgetScaling();
                    }
                    codedInputByteBufferNano.readMessage(this.scaling);
                } else if (tag == 42) {
                    if (this.extend == null) {
                        this.extend = new LiveActivityWidgetExtend();
                    }
                    codedInputByteBufferNano.readMessage(this.extend);
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.weight = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCActivityWidgetUpdated parseFrom(byte[] bArr) {
            return (SCActivityWidgetUpdated) MessageNano.mergeFrom(new SCActivityWidgetUpdated(), bArr);
        }

        public static SCActivityWidgetUpdated parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCActivityWidgetUpdated().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCActivityWidgetClose extends MessageNano {
        private static volatile SCActivityWidgetClose[] _emptyArray;
        public long id;

        public static SCActivityWidgetClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCActivityWidgetClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCActivityWidgetClose() {
            clear();
        }

        public final SCActivityWidgetClose clear() {
            this.id = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCActivityWidgetClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.id = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCActivityWidgetClose parseFrom(byte[] bArr) {
            return (SCActivityWidgetClose) MessageNano.mergeFrom(new SCActivityWidgetClose(), bArr);
        }

        public static SCActivityWidgetClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCActivityWidgetClose().mergeFrom(codedInputByteBufferNano);
        }
    }
}
