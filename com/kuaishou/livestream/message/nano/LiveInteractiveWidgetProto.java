package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveInteractiveWidgetProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveInteractiveWidgetStatus {
        public static final int CLOSE = 1;
        public static final int UPDATE = 0;
    }

    public static final class LiveInteractiveWidgetGroup extends MessageNano {
        private static volatile LiveInteractiveWidgetGroup[] _emptyArray;
        public LiveInteractiveWidget[] liveInteractiveWidget;

        public static LiveInteractiveWidgetGroup[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveInteractiveWidgetGroup[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveInteractiveWidgetGroup() {
            clear();
        }

        public final LiveInteractiveWidgetGroup clear() {
            this.liveInteractiveWidget = LiveInteractiveWidget.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveInteractiveWidget[] liveInteractiveWidgetArr = this.liveInteractiveWidget;
            if (liveInteractiveWidgetArr != null && liveInteractiveWidgetArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveInteractiveWidget[] liveInteractiveWidgetArr2 = this.liveInteractiveWidget;
                    if (i >= liveInteractiveWidgetArr2.length) {
                        break;
                    }
                    LiveInteractiveWidget liveInteractiveWidget = liveInteractiveWidgetArr2[i];
                    if (liveInteractiveWidget != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveInteractiveWidget);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveInteractiveWidget[] liveInteractiveWidgetArr = this.liveInteractiveWidget;
            if (liveInteractiveWidgetArr != null && liveInteractiveWidgetArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveInteractiveWidget[] liveInteractiveWidgetArr2 = this.liveInteractiveWidget;
                    if (i >= liveInteractiveWidgetArr2.length) {
                        break;
                    }
                    LiveInteractiveWidget liveInteractiveWidget = liveInteractiveWidgetArr2[i];
                    if (liveInteractiveWidget != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveInteractiveWidget);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveInteractiveWidgetGroup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    LiveInteractiveWidget[] liveInteractiveWidgetArr = this.liveInteractiveWidget;
                    int length = liveInteractiveWidgetArr == null ? 0 : liveInteractiveWidgetArr.length;
                    LiveInteractiveWidget[] liveInteractiveWidgetArr2 = new LiveInteractiveWidget[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.liveInteractiveWidget, 0, liveInteractiveWidgetArr2, 0, length);
                    }
                    while (length < liveInteractiveWidgetArr2.length - 1) {
                        liveInteractiveWidgetArr2[length] = new LiveInteractiveWidget();
                        codedInputByteBufferNano.readMessage(liveInteractiveWidgetArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveInteractiveWidgetArr2[length] = new LiveInteractiveWidget();
                    codedInputByteBufferNano.readMessage(liveInteractiveWidgetArr2[length]);
                    this.liveInteractiveWidget = liveInteractiveWidgetArr2;
                }
            }
        }

        public static LiveInteractiveWidgetGroup parseFrom(byte[] bArr) {
            return (LiveInteractiveWidgetGroup) MessageNano.mergeFrom(new LiveInteractiveWidgetGroup(), bArr);
        }

        public static LiveInteractiveWidgetGroup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveInteractiveWidgetGroup().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveInteractiveWidget extends MessageNano {
        private static volatile LiveInteractiveWidget[] _emptyArray;
        public String bundleId;
        public String dataP;
        public LiveInteractiveWidgetProperty property;
        public int status;
        public long version;
        public String viewKey;
        public String widgetId;

        public static LiveInteractiveWidget[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveInteractiveWidget[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveInteractiveWidget() {
            clear();
        }

        public final LiveInteractiveWidget clear() {
            this.widgetId = "";
            this.property = null;
            this.status = 0;
            this.version = 0L;
            this.bundleId = "";
            this.viewKey = "";
            this.dataP = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.widgetId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.widgetId);
            }
            LiveInteractiveWidgetProperty liveInteractiveWidgetProperty = this.property;
            if (liveInteractiveWidgetProperty != null) {
                codedOutputByteBufferNano.writeMessage(2, liveInteractiveWidgetProperty);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(3, i);
            }
            long j = this.version;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (!this.bundleId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bundleId);
            }
            if (!this.viewKey.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.viewKey);
            }
            if (!this.dataP.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.dataP);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.widgetId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.widgetId);
            }
            LiveInteractiveWidgetProperty liveInteractiveWidgetProperty = this.property;
            if (liveInteractiveWidgetProperty != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveInteractiveWidgetProperty);
            }
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
            }
            long j = this.version;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (!this.bundleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.bundleId);
            }
            if (!this.viewKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.viewKey);
            }
            return !this.dataP.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.dataP) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveInteractiveWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.widgetId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.property == null) {
                        this.property = new LiveInteractiveWidgetProperty();
                    }
                    codedInputByteBufferNano.readMessage(this.property);
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.status = int32;
                    }
                } else if (tag == 32) {
                    this.version = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    this.bundleId = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.viewKey = codedInputByteBufferNano.readString();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.dataP = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveInteractiveWidget parseFrom(byte[] bArr) {
            return (LiveInteractiveWidget) MessageNano.mergeFrom(new LiveInteractiveWidget(), bArr);
        }

        public static LiveInteractiveWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveInteractiveWidget().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveInteractiveWidgetProperty extends MessageNano {
        private static volatile LiveInteractiveWidgetProperty[] _emptyArray;
        public long expireTime;
        public long order;
        public int priority;

        public static LiveInteractiveWidgetProperty[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveInteractiveWidgetProperty[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveInteractiveWidgetProperty() {
            clear();
        }

        public final LiveInteractiveWidgetProperty clear() {
            this.priority = 0;
            this.order = 0L;
            this.expireTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.priority;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.order;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.expireTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.priority;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.order;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.expireTime;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveInteractiveWidgetProperty mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.priority = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.order = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.expireTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveInteractiveWidgetProperty parseFrom(byte[] bArr) {
            return (LiveInteractiveWidgetProperty) MessageNano.mergeFrom(new LiveInteractiveWidgetProperty(), bArr);
        }

        public static LiveInteractiveWidgetProperty parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveInteractiveWidgetProperty().mergeFrom(codedInputByteBufferNano);
        }
    }
}
