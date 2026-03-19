package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveChatLayoutConfig extends MessageNano {
    private static volatile InteractiveChatLayoutConfig[] _emptyArray;
    public InteractiveChatCanvasSize canvasSize;
    public InteractiveChatCaptureResolutionConfig captureResolutionConfig;
    public int layoutConfigType;
    public InteractiveChatLayoutPreview layoutPreview;
    public int layoutType;
    public InteractiveChatResolutionConfig resolutionConfig;
    public InteractiveChatWindow[] windowInfo;

    public static final class InteractiveChatCaptureResolutionConfig extends MessageNano {
        private static volatile InteractiveChatCaptureResolutionConfig[] _emptyArray;
        public int height;
        public int width;

        public static InteractiveChatCaptureResolutionConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new InteractiveChatCaptureResolutionConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public InteractiveChatCaptureResolutionConfig() {
            clear();
        }

        public final InteractiveChatCaptureResolutionConfig clear() {
            this.width = 0;
            this.height = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.width;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.height;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.width;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.height;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final InteractiveChatCaptureResolutionConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.width = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.height = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static InteractiveChatCaptureResolutionConfig parseFrom(byte[] bArr) {
            return (InteractiveChatCaptureResolutionConfig) MessageNano.mergeFrom(new InteractiveChatCaptureResolutionConfig(), bArr);
        }

        public static InteractiveChatCaptureResolutionConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new InteractiveChatCaptureResolutionConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static InteractiveChatLayoutConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatLayoutConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatLayoutConfig() {
        clear();
    }

    public final InteractiveChatLayoutConfig clear() {
        this.canvasSize = null;
        this.windowInfo = InteractiveChatWindow.emptyArray();
        this.resolutionConfig = null;
        this.layoutType = 0;
        this.captureResolutionConfig = null;
        this.layoutPreview = null;
        this.layoutConfigType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatCanvasSize interactiveChatCanvasSize = this.canvasSize;
        if (interactiveChatCanvasSize != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatCanvasSize);
        }
        InteractiveChatWindow[] interactiveChatWindowArr = this.windowInfo;
        if (interactiveChatWindowArr != null && interactiveChatWindowArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatWindow[] interactiveChatWindowArr2 = this.windowInfo;
                if (i >= interactiveChatWindowArr2.length) {
                    break;
                }
                InteractiveChatWindow interactiveChatWindow = interactiveChatWindowArr2[i];
                if (interactiveChatWindow != null) {
                    codedOutputByteBufferNano.writeMessage(2, interactiveChatWindow);
                }
                i++;
            }
        }
        InteractiveChatResolutionConfig interactiveChatResolutionConfig = this.resolutionConfig;
        if (interactiveChatResolutionConfig != null) {
            codedOutputByteBufferNano.writeMessage(3, interactiveChatResolutionConfig);
        }
        int i2 = this.layoutType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        InteractiveChatCaptureResolutionConfig interactiveChatCaptureResolutionConfig = this.captureResolutionConfig;
        if (interactiveChatCaptureResolutionConfig != null) {
            codedOutputByteBufferNano.writeMessage(5, interactiveChatCaptureResolutionConfig);
        }
        InteractiveChatLayoutPreview interactiveChatLayoutPreview = this.layoutPreview;
        if (interactiveChatLayoutPreview != null) {
            codedOutputByteBufferNano.writeMessage(6, interactiveChatLayoutPreview);
        }
        int i3 = this.layoutConfigType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveChatCanvasSize interactiveChatCanvasSize = this.canvasSize;
        if (interactiveChatCanvasSize != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveChatCanvasSize);
        }
        InteractiveChatWindow[] interactiveChatWindowArr = this.windowInfo;
        if (interactiveChatWindowArr != null && interactiveChatWindowArr.length > 0) {
            int i = 0;
            while (true) {
                InteractiveChatWindow[] interactiveChatWindowArr2 = this.windowInfo;
                if (i >= interactiveChatWindowArr2.length) {
                    break;
                }
                InteractiveChatWindow interactiveChatWindow = interactiveChatWindowArr2[i];
                if (interactiveChatWindow != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, interactiveChatWindow);
                }
                i++;
            }
        }
        InteractiveChatResolutionConfig interactiveChatResolutionConfig = this.resolutionConfig;
        if (interactiveChatResolutionConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, interactiveChatResolutionConfig);
        }
        int i2 = this.layoutType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
        }
        InteractiveChatCaptureResolutionConfig interactiveChatCaptureResolutionConfig = this.captureResolutionConfig;
        if (interactiveChatCaptureResolutionConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, interactiveChatCaptureResolutionConfig);
        }
        InteractiveChatLayoutPreview interactiveChatLayoutPreview = this.layoutPreview;
        if (interactiveChatLayoutPreview != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, interactiveChatLayoutPreview);
        }
        int i3 = this.layoutConfigType;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatLayoutConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.canvasSize == null) {
                    this.canvasSize = new InteractiveChatCanvasSize();
                }
                codedInputByteBufferNano.readMessage(this.canvasSize);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                InteractiveChatWindow[] interactiveChatWindowArr = this.windowInfo;
                int length = interactiveChatWindowArr == null ? 0 : interactiveChatWindowArr.length;
                InteractiveChatWindow[] interactiveChatWindowArr2 = new InteractiveChatWindow[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.windowInfo, 0, interactiveChatWindowArr2, 0, length);
                }
                while (length < interactiveChatWindowArr2.length - 1) {
                    interactiveChatWindowArr2[length] = new InteractiveChatWindow();
                    codedInputByteBufferNano.readMessage(interactiveChatWindowArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                interactiveChatWindowArr2[length] = new InteractiveChatWindow();
                codedInputByteBufferNano.readMessage(interactiveChatWindowArr2[length]);
                this.windowInfo = interactiveChatWindowArr2;
            } else if (tag == 26) {
                if (this.resolutionConfig == null) {
                    this.resolutionConfig = new InteractiveChatResolutionConfig();
                }
                codedInputByteBufferNano.readMessage(this.resolutionConfig);
            } else if (tag == 32) {
                this.layoutType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 42) {
                if (this.captureResolutionConfig == null) {
                    this.captureResolutionConfig = new InteractiveChatCaptureResolutionConfig();
                }
                codedInputByteBufferNano.readMessage(this.captureResolutionConfig);
            } else if (tag == 50) {
                if (this.layoutPreview == null) {
                    this.layoutPreview = new InteractiveChatLayoutPreview();
                }
                codedInputByteBufferNano.readMessage(this.layoutPreview);
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.layoutConfigType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static InteractiveChatLayoutConfig parseFrom(byte[] bArr) {
        return (InteractiveChatLayoutConfig) MessageNano.mergeFrom(new InteractiveChatLayoutConfig(), bArr);
    }

    public static InteractiveChatLayoutConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatLayoutConfig().mergeFrom(codedInputByteBufferNano);
    }
}
