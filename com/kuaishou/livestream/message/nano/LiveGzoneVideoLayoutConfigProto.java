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
public interface LiveGzoneVideoLayoutConfigProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface BizType {
        public static final int GZONE_SHOW_FACE_VERTICAL_LAYOUT = 1;
        public static final int INVALID = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LayoutType {
        public static final int CENTER = 0;
        public static final int TOP = 1;
    }

    public static final class Size extends MessageNano {
        private static volatile Size[] _emptyArray;
        public int height;
        public int width;

        public static Size[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Size[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Size() {
            clear();
        }

        public final Size clear() {
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
        public final Size mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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

        public static Size parseFrom(byte[] bArr) {
            return (Size) MessageNano.mergeFrom(new Size(), bArr);
        }

        public static Size parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Size().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MainViewPosition extends MessageNano {
        private static volatile MainViewPosition[] _emptyArray;
        public int bottom;
        public int left;
        public int right;
        public int top;

        public static MainViewPosition[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MainViewPosition[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MainViewPosition() {
            clear();
        }

        public final MainViewPosition clear() {
            this.left = 0;
            this.top = 0;
            this.right = 0;
            this.bottom = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.left;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.top;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.right;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            int i4 = this.bottom;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.left;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.top;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.right;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            int i4 = this.bottom;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MainViewPosition mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.left = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.top = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.right = codedInputByteBufferNano.readUInt32();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bottom = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static MainViewPosition parseFrom(byte[] bArr) {
            return (MainViewPosition) MessageNano.mergeFrom(new MainViewPosition(), bArr);
        }

        public static MainViewPosition parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MainViewPosition().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class VideoLayoutConfig extends MessageNano {
        private static volatile VideoLayoutConfig[] _emptyArray;
        public int bizType;
        public int layoutType;
        public MainViewPosition mainViewPosition;
        public Size size;
        public long videoBgId;

        public static VideoLayoutConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new VideoLayoutConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public VideoLayoutConfig() {
            clear();
        }

        public final VideoLayoutConfig clear() {
            this.bizType = 0;
            this.size = null;
            this.mainViewPosition = null;
            this.layoutType = 0;
            this.videoBgId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            Size size = this.size;
            if (size != null) {
                codedOutputByteBufferNano.writeMessage(2, size);
            }
            MainViewPosition mainViewPosition = this.mainViewPosition;
            if (mainViewPosition != null) {
                codedOutputByteBufferNano.writeMessage(3, mainViewPosition);
            }
            int i2 = this.layoutType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            long j = this.videoBgId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            Size size = this.size;
            if (size != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, size);
            }
            MainViewPosition mainViewPosition = this.mainViewPosition;
            if (mainViewPosition != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, mainViewPosition);
            }
            int i2 = this.layoutType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
            }
            long j = this.videoBgId;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final VideoLayoutConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.bizType = int32;
                    }
                } else if (tag == 18) {
                    if (this.size == null) {
                        this.size = new Size();
                    }
                    codedInputByteBufferNano.readMessage(this.size);
                } else if (tag == 26) {
                    if (this.mainViewPosition == null) {
                        this.mainViewPosition = new MainViewPosition();
                    }
                    codedInputByteBufferNano.readMessage(this.mainViewPosition);
                } else if (tag == 32) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 == 0 || int322 == 1) {
                        this.layoutType = int322;
                    }
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.videoBgId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static VideoLayoutConfig parseFrom(byte[] bArr) {
            return (VideoLayoutConfig) MessageNano.mergeFrom(new VideoLayoutConfig(), bArr);
        }

        public static VideoLayoutConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new VideoLayoutConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
