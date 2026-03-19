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
public interface LiveCommonActivityWidgetProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveCommonActivityWidgetItemType {
        public static final int DEFAULT_DSL_TYPE = 1;
        public static final int KDS_TYPE = 2;
        public static final int UNKNOWN_WIDGET_ITEM_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveCommonActivityWidgetLayoutType {
        public static final int DEFAULT_DSL_LAYOUT_TYPE = 1;
        public static final int UNKNOWN_LAYOUT_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveCommonActivityWidgetType {
        public static final int DYNAMIC_COMMON_WIDGET_TYPE = 2;
        public static final int PERSONAL_COMMON_WIDGET_TYPE = 3;
        public static final int STATIC_COMMON_WIDGET_TYPE = 1;
        public static final int UNKNOWN_COMMON_WIDGET_TYPE = 0;
    }

    public static final class LiveCommonActivityWidget extends MessageNano {
        private static volatile LiveCommonActivityWidget[] _emptyArray;
        public LiveCommonActivityWidgetContent content;
        public long duration;
        public String id;
        public int itemType;
        public String jumpUrl;
        public LiveKdsWidgetContent kdsContent;
        public long maxDelayMillis;
        public String name;
        public UserInfos.PicUrl[] picUrl;
        public LiveCommonActivityWidgetProperty property;
        public int type;

        public static LiveCommonActivityWidget[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCommonActivityWidget[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCommonActivityWidget() {
            clear();
        }

        public final LiveCommonActivityWidget clear() {
            this.id = "";
            this.name = "";
            this.picUrl = UserInfos.PicUrl.emptyArray();
            this.jumpUrl = "";
            this.property = null;
            this.content = null;
            this.type = 0;
            this.itemType = 0;
            this.kdsContent = null;
            this.duration = 0L;
            this.maxDelayMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            if (!this.name.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.name);
            }
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
                        codedOutputByteBufferNano.writeMessage(3, picUrl);
                    }
                    i++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.jumpUrl);
            }
            LiveCommonActivityWidgetProperty liveCommonActivityWidgetProperty = this.property;
            if (liveCommonActivityWidgetProperty != null) {
                codedOutputByteBufferNano.writeMessage(5, liveCommonActivityWidgetProperty);
            }
            LiveCommonActivityWidgetContent liveCommonActivityWidgetContent = this.content;
            if (liveCommonActivityWidgetContent != null) {
                codedOutputByteBufferNano.writeMessage(6, liveCommonActivityWidgetContent);
            }
            int i2 = this.type;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(7, i2);
            }
            int i3 = this.itemType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i3);
            }
            LiveKdsWidgetContent liveKdsWidgetContent = this.kdsContent;
            if (liveKdsWidgetContent != null) {
                codedOutputByteBufferNano.writeMessage(9, liveKdsWidgetContent);
            }
            long j = this.duration;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(10, j);
            }
            long j2 = this.maxDelayMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(11, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            if (!this.name.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
            }
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
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                    }
                    i++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.jumpUrl);
            }
            LiveCommonActivityWidgetProperty liveCommonActivityWidgetProperty = this.property;
            if (liveCommonActivityWidgetProperty != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveCommonActivityWidgetProperty);
            }
            LiveCommonActivityWidgetContent liveCommonActivityWidgetContent = this.content;
            if (liveCommonActivityWidgetContent != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveCommonActivityWidgetContent);
            }
            int i2 = this.type;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i2);
            }
            int i3 = this.itemType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i3);
            }
            LiveKdsWidgetContent liveKdsWidgetContent = this.kdsContent;
            if (liveKdsWidgetContent != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveKdsWidgetContent);
            }
            long j = this.duration;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(10, j);
            }
            long j2 = this.maxDelayMillis;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCommonActivityWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.id = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.name = codedInputByteBufferNano.readString();
                        break;
                    case 26:
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
                        break;
                    case 34:
                        this.jumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        if (this.property == null) {
                            this.property = new LiveCommonActivityWidgetProperty();
                        }
                        codedInputByteBufferNano.readMessage(this.property);
                        break;
                    case 50:
                        if (this.content == null) {
                            this.content = new LiveCommonActivityWidgetContent();
                        }
                        codedInputByteBufferNano.readMessage(this.content);
                        break;
                    case 56:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                            break;
                        } else {
                            this.type = int32;
                            break;
                        }
                        break;
                    case 64:
                        int int322 = codedInputByteBufferNano.readInt32();
                        if (int322 != 0 && int322 != 1 && int322 != 2) {
                            break;
                        } else {
                            this.itemType = int322;
                            break;
                        }
                    case 74:
                        if (this.kdsContent == null) {
                            this.kdsContent = new LiveKdsWidgetContent();
                        }
                        codedInputByteBufferNano.readMessage(this.kdsContent);
                        break;
                    case 80:
                        this.duration = codedInputByteBufferNano.readUInt64();
                        break;
                    case 88:
                        this.maxDelayMillis = codedInputByteBufferNano.readUInt64();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static LiveCommonActivityWidget parseFrom(byte[] bArr) {
            return (LiveCommonActivityWidget) MessageNano.mergeFrom(new LiveCommonActivityWidget(), bArr);
        }

        public static LiveCommonActivityWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCommonActivityWidget().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveKdsWidgetContent extends MessageNano {
        private static volatile LiveKdsWidgetContent[] _emptyArray;
        public String bundleId;
        public String data;
        public int minBundleVer;

        public static LiveKdsWidgetContent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveKdsWidgetContent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveKdsWidgetContent() {
            clear();
        }

        public final LiveKdsWidgetContent clear() {
            this.bundleId = "";
            this.data = "";
            this.minBundleVer = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.bundleId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.bundleId);
            }
            if (!this.data.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.data);
            }
            int i = this.minBundleVer;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.bundleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bundleId);
            }
            if (!this.data.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.data);
            }
            int i = this.minBundleVer;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveKdsWidgetContent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.bundleId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.data = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.minBundleVer = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveKdsWidgetContent parseFrom(byte[] bArr) {
            return (LiveKdsWidgetContent) MessageNano.mergeFrom(new LiveKdsWidgetContent(), bArr);
        }

        public static LiveKdsWidgetContent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveKdsWidgetContent().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveCommonActivityWidgetProperty extends MessageNano {
        private static volatile LiveCommonActivityWidgetProperty[] _emptyArray;
        public boolean autoClose;
        public long createTime;
        public boolean dynamicNumLimit;
        public long endTime;
        public String extraInfo;
        public boolean grprShow;
        public boolean isExclusive;
        public String ksOrderId;
        public String logParams;
        public String logStatus;
        public int priority;

        public static LiveCommonActivityWidgetProperty[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCommonActivityWidgetProperty[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCommonActivityWidgetProperty() {
            clear();
        }

        public final LiveCommonActivityWidgetProperty clear() {
            this.createTime = 0L;
            this.priority = 0;
            this.isExclusive = false;
            this.logParams = "";
            this.logStatus = "";
            this.endTime = 0L;
            this.autoClose = false;
            this.dynamicNumLimit = false;
            this.grprShow = false;
            this.ksOrderId = "";
            this.extraInfo = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.createTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.priority;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            boolean z = this.isExclusive;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            if (!this.logParams.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.logParams);
            }
            if (!this.logStatus.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.logStatus);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            boolean z2 = this.autoClose;
            if (z2) {
                codedOutputByteBufferNano.writeBool(7, z2);
            }
            boolean z3 = this.dynamicNumLimit;
            if (z3) {
                codedOutputByteBufferNano.writeBool(8, z3);
            }
            boolean z4 = this.grprShow;
            if (z4) {
                codedOutputByteBufferNano.writeBool(9, z4);
            }
            if (!this.ksOrderId.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.ksOrderId);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.extraInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.createTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.priority;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            boolean z = this.isExclusive;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            if (!this.logParams.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.logParams);
            }
            if (!this.logStatus.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.logStatus);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            boolean z2 = this.autoClose;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z2);
            }
            boolean z3 = this.dynamicNumLimit;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z3);
            }
            boolean z4 = this.grprShow;
            if (z4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z4);
            }
            if (!this.ksOrderId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.ksOrderId);
            }
            return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.extraInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCommonActivityWidgetProperty mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.createTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 16:
                        this.priority = codedInputByteBufferNano.readUInt32();
                        break;
                    case 24:
                        this.isExclusive = codedInputByteBufferNano.readBool();
                        break;
                    case 34:
                        this.logParams = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.logStatus = codedInputByteBufferNano.readString();
                        break;
                    case 48:
                        this.endTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 56:
                        this.autoClose = codedInputByteBufferNano.readBool();
                        break;
                    case 64:
                        this.dynamicNumLimit = codedInputByteBufferNano.readBool();
                        break;
                    case 72:
                        this.grprShow = codedInputByteBufferNano.readBool();
                        break;
                    case 82:
                        this.ksOrderId = codedInputByteBufferNano.readString();
                        break;
                    case 90:
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

        public static LiveCommonActivityWidgetProperty parseFrom(byte[] bArr) {
            return (LiveCommonActivityWidgetProperty) MessageNano.mergeFrom(new LiveCommonActivityWidgetProperty(), bArr);
        }

        public static LiveCommonActivityWidgetProperty parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCommonActivityWidgetProperty().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveCommonActivityWidgetContent extends MessageNano {
        private static volatile LiveCommonActivityWidgetContent[] _emptyArray;
        public LiveCommonActivityWidgetPageContent[] pageContent;

        public static LiveCommonActivityWidgetContent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCommonActivityWidgetContent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCommonActivityWidgetContent() {
            clear();
        }

        public final LiveCommonActivityWidgetContent clear() {
            this.pageContent = LiveCommonActivityWidgetPageContent.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCommonActivityWidgetPageContent[] liveCommonActivityWidgetPageContentArr = this.pageContent;
            if (liveCommonActivityWidgetPageContentArr != null && liveCommonActivityWidgetPageContentArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCommonActivityWidgetPageContent[] liveCommonActivityWidgetPageContentArr2 = this.pageContent;
                    if (i >= liveCommonActivityWidgetPageContentArr2.length) {
                        break;
                    }
                    LiveCommonActivityWidgetPageContent liveCommonActivityWidgetPageContent = liveCommonActivityWidgetPageContentArr2[i];
                    if (liveCommonActivityWidgetPageContent != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveCommonActivityWidgetPageContent);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCommonActivityWidgetPageContent[] liveCommonActivityWidgetPageContentArr = this.pageContent;
            if (liveCommonActivityWidgetPageContentArr != null && liveCommonActivityWidgetPageContentArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCommonActivityWidgetPageContent[] liveCommonActivityWidgetPageContentArr2 = this.pageContent;
                    if (i >= liveCommonActivityWidgetPageContentArr2.length) {
                        break;
                    }
                    LiveCommonActivityWidgetPageContent liveCommonActivityWidgetPageContent = liveCommonActivityWidgetPageContentArr2[i];
                    if (liveCommonActivityWidgetPageContent != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCommonActivityWidgetPageContent);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCommonActivityWidgetContent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveCommonActivityWidgetPageContent[] liveCommonActivityWidgetPageContentArr = this.pageContent;
                    int length = liveCommonActivityWidgetPageContentArr == null ? 0 : liveCommonActivityWidgetPageContentArr.length;
                    LiveCommonActivityWidgetPageContent[] liveCommonActivityWidgetPageContentArr2 = new LiveCommonActivityWidgetPageContent[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.pageContent, 0, liveCommonActivityWidgetPageContentArr2, 0, length);
                    }
                    while (length < liveCommonActivityWidgetPageContentArr2.length - 1) {
                        liveCommonActivityWidgetPageContentArr2[length] = new LiveCommonActivityWidgetPageContent();
                        codedInputByteBufferNano.readMessage(liveCommonActivityWidgetPageContentArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCommonActivityWidgetPageContentArr2[length] = new LiveCommonActivityWidgetPageContent();
                    codedInputByteBufferNano.readMessage(liveCommonActivityWidgetPageContentArr2[length]);
                    this.pageContent = liveCommonActivityWidgetPageContentArr2;
                }
            }
        }

        public static LiveCommonActivityWidgetContent parseFrom(byte[] bArr) {
            return (LiveCommonActivityWidgetContent) MessageNano.mergeFrom(new LiveCommonActivityWidgetContent(), bArr);
        }

        public static LiveCommonActivityWidgetContent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCommonActivityWidgetContent().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveCommonActivityWidgetPageContent extends MessageNano {
        private static volatile LiveCommonActivityWidgetPageContent[] _emptyArray;
        public String layoutData;
        public String layoutId;
        public String layoutMd5;
        public int layoutType;
        public String widgetData;

        public static LiveCommonActivityWidgetPageContent[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveCommonActivityWidgetPageContent[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveCommonActivityWidgetPageContent() {
            clear();
        }

        public final LiveCommonActivityWidgetPageContent clear() {
            this.layoutData = "";
            this.widgetData = "";
            this.layoutType = 0;
            this.layoutMd5 = "";
            this.layoutId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.layoutData.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.layoutData);
            }
            if (!this.widgetData.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.widgetData);
            }
            int i = this.layoutType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            if (!this.layoutMd5.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.layoutMd5);
            }
            if (!this.layoutId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.layoutId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.layoutData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.layoutData);
            }
            if (!this.widgetData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.widgetData);
            }
            int i = this.layoutType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            if (!this.layoutMd5.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.layoutMd5);
            }
            return !this.layoutId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.layoutId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveCommonActivityWidgetPageContent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.layoutData = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.widgetData = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.layoutType = int32;
                    }
                } else if (tag == 34) {
                    this.layoutMd5 = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.layoutId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveCommonActivityWidgetPageContent parseFrom(byte[] bArr) {
            return (LiveCommonActivityWidgetPageContent) MessageNano.mergeFrom(new LiveCommonActivityWidgetPageContent(), bArr);
        }

        public static LiveCommonActivityWidgetPageContent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveCommonActivityWidgetPageContent().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCommonActivityWidgetUpdate extends MessageNano {
        private static volatile SCLiveCommonActivityWidgetUpdate[] _emptyArray;
        public LiveCommonActivityWidget widget;

        public static SCLiveCommonActivityWidgetUpdate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCommonActivityWidgetUpdate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCommonActivityWidgetUpdate() {
            clear();
        }

        public final SCLiveCommonActivityWidgetUpdate clear() {
            this.widget = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCommonActivityWidget liveCommonActivityWidget = this.widget;
            if (liveCommonActivityWidget != null) {
                codedOutputByteBufferNano.writeMessage(1, liveCommonActivityWidget);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCommonActivityWidget liveCommonActivityWidget = this.widget;
            return liveCommonActivityWidget != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCommonActivityWidget) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCommonActivityWidgetUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    if (this.widget == null) {
                        this.widget = new LiveCommonActivityWidget();
                    }
                    codedInputByteBufferNano.readMessage(this.widget);
                }
            }
        }

        public static SCLiveCommonActivityWidgetUpdate parseFrom(byte[] bArr) {
            return (SCLiveCommonActivityWidgetUpdate) MessageNano.mergeFrom(new SCLiveCommonActivityWidgetUpdate(), bArr);
        }

        public static SCLiveCommonActivityWidgetUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCommonActivityWidgetUpdate().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCommonActivityWidgetClose extends MessageNano {
        private static volatile SCLiveCommonActivityWidgetClose[] _emptyArray;
        public String widgetId;

        public static SCLiveCommonActivityWidgetClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCommonActivityWidgetClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCommonActivityWidgetClose() {
            clear();
        }

        public final SCLiveCommonActivityWidgetClose clear() {
            this.widgetId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.widgetId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.widgetId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.widgetId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.widgetId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCommonActivityWidgetClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.widgetId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveCommonActivityWidgetClose parseFrom(byte[] bArr) {
            return (SCLiveCommonActivityWidgetClose) MessageNano.mergeFrom(new SCLiveCommonActivityWidgetClose(), bArr);
        }

        public static SCLiveCommonActivityWidgetClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCommonActivityWidgetClose().mergeFrom(codedInputByteBufferNano);
        }
    }
}
