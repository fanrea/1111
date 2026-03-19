package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentAction;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCommentRichText {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FontFamily {
        public static final int FONT_FAMILY_DEFAULT = 1;
        public static final int FONT_FAMILY_LEVEL = 3;
        public static final int FONT_FAMILY_MEDIUM = 2;
        public static final int FONT_FAMILY_NUMBER_DIN = 5;
        public static final int FONT_FAMILY_SIMPLE_TEXT = 4;
        public static final int FONT_FAMILY_UNKNOWN = 0;
    }

    public static final class TextStyle extends MessageNano {
        private static volatile TextStyle[] _emptyArray;
        public int color;
        public int fontFamily;
        public int fontSize;
        public int shadowColor;

        public static TextStyle[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TextStyle[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TextStyle() {
            clear();
        }

        public final TextStyle clear() {
            this.color = 0;
            this.shadowColor = 0;
            this.fontSize = 0;
            this.fontFamily = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.color;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.shadowColor;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.fontSize;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            int i4 = this.fontFamily;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.color;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.shadowColor;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.fontSize;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            int i4 = this.fontFamily;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TextStyle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.color = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.shadowColor = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.fontSize = codedInputByteBufferNano.readUInt32();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                        this.fontFamily = int32;
                    }
                }
            }
        }

        public static TextStyle parseFrom(byte[] bArr) {
            return (TextStyle) MessageNano.mergeFrom(new TextStyle(), bArr);
        }

        public static TextStyle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TextStyle().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommentTextSegment extends MessageNano {
        private static volatile CommentTextSegment[] _emptyArray;
        public LiveCommentAction.Action tapAction;
        public String text;
        public TextStyle textStyle;

        public static CommentTextSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentTextSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentTextSegment() {
            clear();
        }

        public final CommentTextSegment clear() {
            this.text = "";
            this.textStyle = null;
            this.tapAction = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            TextStyle textStyle = this.textStyle;
            if (textStyle != null) {
                codedOutputByteBufferNano.writeMessage(2, textStyle);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                codedOutputByteBufferNano.writeMessage(3, action);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            TextStyle textStyle = this.textStyle;
            if (textStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, textStyle);
            }
            LiveCommentAction.Action action = this.tapAction;
            return action != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, action) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentTextSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.textStyle == null) {
                        this.textStyle = new TextStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.textStyle);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.tapAction == null) {
                        this.tapAction = new LiveCommentAction.Action();
                    }
                    codedInputByteBufferNano.readMessage(this.tapAction);
                }
            }
        }

        public static CommentTextSegment parseFrom(byte[] bArr) {
            return (CommentTextSegment) MessageNano.mergeFrom(new CommentTextSegment(), bArr);
        }

        public static CommentTextSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentTextSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommentIconSegment extends MessageNano {
        private static volatile CommentIconSegment[] _emptyArray;
        public CustomizedStyleInfo customizedStyleInfo;
        public boolean enableStretch;
        public String iconPath;
        public String resPackId;
        public LiveCommentAction.Action tapAction;
        public String text;
        public TextStyle textStyle;

        public static CommentIconSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentIconSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentIconSegment() {
            clear();
        }

        public final CommentIconSegment clear() {
            this.resPackId = "";
            this.iconPath = "";
            this.enableStretch = false;
            this.text = "";
            this.textStyle = null;
            this.tapAction = null;
            this.customizedStyleInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.resPackId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.resPackId);
            }
            if (!this.iconPath.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.iconPath);
            }
            boolean z = this.enableStretch;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.text);
            }
            TextStyle textStyle = this.textStyle;
            if (textStyle != null) {
                codedOutputByteBufferNano.writeMessage(5, textStyle);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                codedOutputByteBufferNano.writeMessage(6, action);
            }
            CustomizedStyleInfo customizedStyleInfo = this.customizedStyleInfo;
            if (customizedStyleInfo != null) {
                codedOutputByteBufferNano.writeMessage(7, customizedStyleInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.resPackId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.resPackId);
            }
            if (!this.iconPath.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.iconPath);
            }
            boolean z = this.enableStretch;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.text);
            }
            TextStyle textStyle = this.textStyle;
            if (textStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, textStyle);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, action);
            }
            CustomizedStyleInfo customizedStyleInfo = this.customizedStyleInfo;
            return customizedStyleInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, customizedStyleInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentIconSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.resPackId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.iconPath = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.enableStretch = codedInputByteBufferNano.readBool();
                } else if (tag == 34) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    if (this.textStyle == null) {
                        this.textStyle = new TextStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.textStyle);
                } else if (tag == 50) {
                    if (this.tapAction == null) {
                        this.tapAction = new LiveCommentAction.Action();
                    }
                    codedInputByteBufferNano.readMessage(this.tapAction);
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.customizedStyleInfo == null) {
                        this.customizedStyleInfo = new CustomizedStyleInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.customizedStyleInfo);
                }
            }
        }

        public static CommentIconSegment parseFrom(byte[] bArr) {
            return (CommentIconSegment) MessageNano.mergeFrom(new CommentIconSegment(), bArr);
        }

        public static CommentIconSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentIconSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CustomizedStyleInfo extends MessageNano {
        private static volatile CustomizedStyleInfo[] _emptyArray;
        public boolean enableEffect;
        public String iconPath;
        public String resPackId;
        public DrawTextInfo[] textInfoList;

        public static CustomizedStyleInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CustomizedStyleInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CustomizedStyleInfo() {
            clear();
        }

        public final CustomizedStyleInfo clear() {
            this.resPackId = "";
            this.iconPath = "";
            this.textInfoList = DrawTextInfo.emptyArray();
            this.enableEffect = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.resPackId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.resPackId);
            }
            if (!this.iconPath.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.iconPath);
            }
            DrawTextInfo[] drawTextInfoArr = this.textInfoList;
            if (drawTextInfoArr != null && drawTextInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    DrawTextInfo[] drawTextInfoArr2 = this.textInfoList;
                    if (i >= drawTextInfoArr2.length) {
                        break;
                    }
                    DrawTextInfo drawTextInfo = drawTextInfoArr2[i];
                    if (drawTextInfo != null) {
                        codedOutputByteBufferNano.writeMessage(3, drawTextInfo);
                    }
                    i++;
                }
            }
            boolean z = this.enableEffect;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.resPackId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.resPackId);
            }
            if (!this.iconPath.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.iconPath);
            }
            DrawTextInfo[] drawTextInfoArr = this.textInfoList;
            if (drawTextInfoArr != null && drawTextInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    DrawTextInfo[] drawTextInfoArr2 = this.textInfoList;
                    if (i >= drawTextInfoArr2.length) {
                        break;
                    }
                    DrawTextInfo drawTextInfo = drawTextInfoArr2[i];
                    if (drawTextInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, drawTextInfo);
                    }
                    i++;
                }
            }
            boolean z = this.enableEffect;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CustomizedStyleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.resPackId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.iconPath = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    DrawTextInfo[] drawTextInfoArr = this.textInfoList;
                    int length = drawTextInfoArr == null ? 0 : drawTextInfoArr.length;
                    DrawTextInfo[] drawTextInfoArr2 = new DrawTextInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.textInfoList, 0, drawTextInfoArr2, 0, length);
                    }
                    while (length < drawTextInfoArr2.length - 1) {
                        drawTextInfoArr2[length] = new DrawTextInfo();
                        codedInputByteBufferNano.readMessage(drawTextInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    drawTextInfoArr2[length] = new DrawTextInfo();
                    codedInputByteBufferNano.readMessage(drawTextInfoArr2[length]);
                    this.textInfoList = drawTextInfoArr2;
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.enableEffect = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static CustomizedStyleInfo parseFrom(byte[] bArr) {
            return (CustomizedStyleInfo) MessageNano.mergeFrom(new CustomizedStyleInfo(), bArr);
        }

        public static CustomizedStyleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CustomizedStyleInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DrawTextInfo extends MessageNano {
        private static volatile DrawTextInfo[] _emptyArray;
        public String customizedFontFamilyId;
        public String customizedFontFamilyName;
        public String customizedFontFamilyPath;
        public HorizontalLocation location;
        public String text;
        public TextStyle textStyle;

        public static DrawTextInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DrawTextInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DrawTextInfo() {
            clear();
        }

        public final DrawTextInfo clear() {
            this.text = "";
            this.textStyle = null;
            this.location = null;
            this.customizedFontFamilyId = "";
            this.customizedFontFamilyName = "";
            this.customizedFontFamilyPath = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            TextStyle textStyle = this.textStyle;
            if (textStyle != null) {
                codedOutputByteBufferNano.writeMessage(2, textStyle);
            }
            HorizontalLocation horizontalLocation = this.location;
            if (horizontalLocation != null) {
                codedOutputByteBufferNano.writeMessage(3, horizontalLocation);
            }
            if (!this.customizedFontFamilyId.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.customizedFontFamilyId);
            }
            if (!this.customizedFontFamilyName.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.customizedFontFamilyName);
            }
            if (!this.customizedFontFamilyPath.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.customizedFontFamilyPath);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            TextStyle textStyle = this.textStyle;
            if (textStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, textStyle);
            }
            HorizontalLocation horizontalLocation = this.location;
            if (horizontalLocation != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, horizontalLocation);
            }
            if (!this.customizedFontFamilyId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.customizedFontFamilyId);
            }
            if (!this.customizedFontFamilyName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.customizedFontFamilyName);
            }
            return !this.customizedFontFamilyPath.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.customizedFontFamilyPath) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final DrawTextInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.textStyle == null) {
                        this.textStyle = new TextStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.textStyle);
                } else if (tag == 26) {
                    if (this.location == null) {
                        this.location = new HorizontalLocation();
                    }
                    codedInputByteBufferNano.readMessage(this.location);
                } else if (tag == 34) {
                    this.customizedFontFamilyId = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.customizedFontFamilyName = codedInputByteBufferNano.readString();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.customizedFontFamilyPath = codedInputByteBufferNano.readString();
                }
            }
        }

        public static DrawTextInfo parseFrom(byte[] bArr) {
            return (DrawTextInfo) MessageNano.mergeFrom(new DrawTextInfo(), bArr);
        }

        public static DrawTextInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DrawTextInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class HorizontalLocation extends MessageNano {
        private static volatile HorizontalLocation[] _emptyArray;
        public int alignForm;
        public int anchorDep;
        public int anchorOffset;

        @Retention(RetentionPolicy.SOURCE)
        public @interface AlignForm {
            public static final int CENTER = 1;
            public static final int LEFT_ALIGN = 0;
            public static final int RIGHT_ALIGN = 2;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface AnchorDep {
            public static final int LEFT_BOUNDARY = 0;
            public static final int RIGHT_BOUNDARY = 1;
        }

        public static HorizontalLocation[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new HorizontalLocation[0];
                    }
                }
            }
            return _emptyArray;
        }

        public HorizontalLocation() {
            clear();
        }

        public final HorizontalLocation clear() {
            this.anchorDep = 0;
            this.anchorOffset = 0;
            this.alignForm = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.anchorDep;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.anchorOffset;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.alignForm;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.anchorDep;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.anchorOffset;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.alignForm;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final HorizontalLocation mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.anchorDep = int32;
                    }
                } else if (tag == 16) {
                    this.anchorOffset = codedInputByteBufferNano.readUInt32();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1 || int322 == 2) {
                        this.alignForm = int322;
                    }
                }
            }
        }

        public static HorizontalLocation parseFrom(byte[] bArr) {
            return (HorizontalLocation) MessageNano.mergeFrom(new HorizontalLocation(), bArr);
        }

        public static HorizontalLocation parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new HorizontalLocation().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommentGiftSegment extends MessageNano {
        private static volatile CommentGiftSegment[] _emptyArray;
        public int giftId;
        public LiveCommentAction.Action tapAction;

        public static CommentGiftSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentGiftSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentGiftSegment() {
            clear();
        }

        public final CommentGiftSegment clear() {
            this.giftId = 0;
            this.tapAction = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                codedOutputByteBufferNano.writeMessage(2, action);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.giftId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            LiveCommentAction.Action action = this.tapAction;
            return action != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, action) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentGiftSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.tapAction == null) {
                        this.tapAction = new LiveCommentAction.Action();
                    }
                    codedInputByteBufferNano.readMessage(this.tapAction);
                }
            }
        }

        public static CommentGiftSegment parseFrom(byte[] bArr) {
            return (CommentGiftSegment) MessageNano.mergeFrom(new CommentGiftSegment(), bArr);
        }

        public static CommentGiftSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentGiftSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommentImageSegment extends MessageNano {
        private static volatile CommentImageSegment[] _emptyArray;
        public int height;
        public LiveCommentAction.Action tapAction;
        public UserInfos.PicUrl[] url;
        public int width;

        public static CommentImageSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentImageSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentImageSegment() {
            clear();
        }

        public final CommentImageSegment clear() {
            this.url = UserInfos.PicUrl.emptyArray();
            this.width = 0;
            this.height = 0;
            this.tapAction = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.url;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.url;
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
            int i2 = this.width;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.height;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                codedOutputByteBufferNano.writeMessage(4, action);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.url;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.url;
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
            int i2 = this.width;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.height;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            LiveCommentAction.Action action = this.tapAction;
            return action != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, action) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentImageSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.url;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.url, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.url = picUrlArr2;
                } else if (tag == 16) {
                    this.width = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.height = codedInputByteBufferNano.readUInt32();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.tapAction == null) {
                        this.tapAction = new LiveCommentAction.Action();
                    }
                    codedInputByteBufferNano.readMessage(this.tapAction);
                }
            }
        }

        public static CommentImageSegment parseFrom(byte[] bArr) {
            return (CommentImageSegment) MessageNano.mergeFrom(new CommentImageSegment(), bArr);
        }

        public static CommentImageSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentImageSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommentEmoticonSegment extends MessageNano {
        private static volatile CommentEmoticonSegment[] _emptyArray;
        public int heightPx;
        public boolean isAnimated;
        public LiveCommentAction.Action tapAction;
        public int targetDisplayHeightDp;
        public UserInfos.PicUrl[] url;
        public int widthPx;

        public static CommentEmoticonSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentEmoticonSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentEmoticonSegment() {
            clear();
        }

        public final CommentEmoticonSegment clear() {
            this.url = UserInfos.PicUrl.emptyArray();
            this.widthPx = 0;
            this.heightPx = 0;
            this.targetDisplayHeightDp = 0;
            this.tapAction = null;
            this.isAnimated = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.url;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.url;
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
            int i2 = this.widthPx;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.heightPx;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            int i4 = this.targetDisplayHeightDp;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                codedOutputByteBufferNano.writeMessage(5, action);
            }
            boolean z = this.isAnimated;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.url;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.url;
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
            int i2 = this.widthPx;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.heightPx;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            int i4 = this.targetDisplayHeightDp;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, action);
            }
            boolean z = this.isAnimated;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentEmoticonSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.url;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.url, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.url = picUrlArr2;
                } else if (tag == 16) {
                    this.widthPx = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.heightPx = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.targetDisplayHeightDp = codedInputByteBufferNano.readUInt32();
                } else if (tag == 42) {
                    if (this.tapAction == null) {
                        this.tapAction = new LiveCommentAction.Action();
                    }
                    codedInputByteBufferNano.readMessage(this.tapAction);
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.isAnimated = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static CommentEmoticonSegment parseFrom(byte[] bArr) {
            return (CommentEmoticonSegment) MessageNano.mergeFrom(new CommentEmoticonSegment(), bArr);
        }

        public static CommentEmoticonSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentEmoticonSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommentBadgeSegment extends MessageNano {
        private static volatile CommentBadgeSegment[] _emptyArray;
        public String badgeAnimationKey;
        public String badgeKey;
        public LiveCommentAction.Action tapAction;

        public static CommentBadgeSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentBadgeSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentBadgeSegment() {
            clear();
        }

        public final CommentBadgeSegment clear() {
            this.badgeKey = "";
            this.tapAction = null;
            this.badgeAnimationKey = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.badgeKey.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.badgeKey);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                codedOutputByteBufferNano.writeMessage(2, action);
            }
            if (!this.badgeAnimationKey.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.badgeAnimationKey);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.badgeKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.badgeKey);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, action);
            }
            return !this.badgeAnimationKey.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.badgeAnimationKey) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentBadgeSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.badgeKey = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.tapAction == null) {
                        this.tapAction = new LiveCommentAction.Action();
                    }
                    codedInputByteBufferNano.readMessage(this.tapAction);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.badgeAnimationKey = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CommentBadgeSegment parseFrom(byte[] bArr) {
            return (CommentBadgeSegment) MessageNano.mergeFrom(new CommentBadgeSegment(), bArr);
        }

        public static CommentBadgeSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentBadgeSegment().mergeFrom(codedInputByteBufferNano);
        }
    }
}
