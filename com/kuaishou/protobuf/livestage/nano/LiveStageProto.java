package com.kuaishou.protobuf.livestage.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveStageProto {

    @Retention(RetentionPolicy.SOURCE)
    public @interface Version {
        public static final int API_0 = 0;
        public static final int API_1 = 1;
        public static final int API_2 = 2;
        public static final int API_3 = 3;
    }

    public static final class StreamId extends MessageNano {
        public static final int EXTERNAL_STREAM_ID_FIELD_NUMBER = 2;
        public static final int USER_STREAM_ID_FIELD_NUMBER = 1;
        private static volatile StreamId[] _emptyArray;
        private int streamIdCase_ = 0;
        private Object streamId_;

        public static final class UserStreamId extends MessageNano {
            private static volatile UserStreamId[] _emptyArray;
            public long userId;

            public static UserStreamId[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new UserStreamId[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public UserStreamId() {
                clear();
            }

            public final UserStreamId clear() {
                this.userId = 0L;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                long j = this.userId;
                if (j != 0) {
                    codedOutputByteBufferNano.writeUInt64(1, j);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                long j = this.userId;
                return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final UserStreamId mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                        this.userId = codedInputByteBufferNano.readUInt64();
                    }
                }
            }

            public static UserStreamId parseFrom(byte[] bArr) {
                return (UserStreamId) MessageNano.mergeFrom(new UserStreamId(), bArr);
            }

            public static UserStreamId parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new UserStreamId().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static final class ExternalStreamId extends MessageNano {
            private static volatile ExternalStreamId[] _emptyArray;
            public int resourceId;
            public long userId;

            public static ExternalStreamId[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new ExternalStreamId[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public ExternalStreamId() {
                clear();
            }

            public final ExternalStreamId clear() {
                this.userId = 0L;
                this.resourceId = 0;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                long j = this.userId;
                if (j != 0) {
                    codedOutputByteBufferNano.writeUInt64(1, j);
                }
                int i = this.resourceId;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(3, i);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                long j = this.userId;
                if (j != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
                }
                int i = this.resourceId;
                return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final ExternalStreamId mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.userId = codedInputByteBufferNano.readUInt64();
                    } else if (tag != 24) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.resourceId = codedInputByteBufferNano.readUInt32();
                    }
                }
            }

            public static ExternalStreamId parseFrom(byte[] bArr) {
                return (ExternalStreamId) MessageNano.mergeFrom(new ExternalStreamId(), bArr);
            }

            public static ExternalStreamId parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new ExternalStreamId().mergeFrom(codedInputByteBufferNano);
            }
        }

        public final int getStreamIdCase() {
            return this.streamIdCase_;
        }

        public final StreamId clearStreamId() {
            this.streamIdCase_ = 0;
            this.streamId_ = null;
            return this;
        }

        public static StreamId[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new StreamId[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasUserStreamId() {
            return this.streamIdCase_ == 1;
        }

        public final UserStreamId getUserStreamId() {
            if (this.streamIdCase_ == 1) {
                return (UserStreamId) this.streamId_;
            }
            return null;
        }

        public final StreamId setUserStreamId(UserStreamId userStreamId) {
            if (userStreamId == null) {
                throw new NullPointerException();
            }
            this.streamIdCase_ = 1;
            this.streamId_ = userStreamId;
            return this;
        }

        public final boolean hasExternalStreamId() {
            return this.streamIdCase_ == 2;
        }

        public final ExternalStreamId getExternalStreamId() {
            if (this.streamIdCase_ == 2) {
                return (ExternalStreamId) this.streamId_;
            }
            return null;
        }

        public final StreamId setExternalStreamId(ExternalStreamId externalStreamId) {
            if (externalStreamId == null) {
                throw new NullPointerException();
            }
            this.streamIdCase_ = 2;
            this.streamId_ = externalStreamId;
            return this;
        }

        public StreamId() {
            clear();
        }

        public final StreamId clear() {
            clearStreamId();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.streamIdCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.streamId_);
            }
            if (this.streamIdCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.streamId_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (this.streamIdCase_ == 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.streamId_);
            }
            return this.streamIdCase_ == 2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.streamId_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final StreamId mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.streamIdCase_ != 1) {
                        this.streamId_ = new UserStreamId();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.streamId_);
                    this.streamIdCase_ = 1;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.streamIdCase_ != 2) {
                        this.streamId_ = new ExternalStreamId();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.streamId_);
                    this.streamIdCase_ = 2;
                }
            }
        }

        public static StreamId parseFrom(byte[] bArr) {
            return (StreamId) MessageNano.mergeFrom(new StreamId(), bArr);
        }

        public static StreamId parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new StreamId().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class Window extends MessageNano {
        private static volatile Window[] _emptyArray;
        public int height;
        public long userId;
        public StreamId videoStreamId;
        public int width;
        public int windowId;
        public int x;
        public int y;

        public static Window[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new Window[0];
                    }
                }
            }
            return _emptyArray;
        }

        public Window() {
            clear();
        }

        public final Window clear() {
            this.windowId = 0;
            this.userId = 0L;
            this.videoStreamId = null;
            this.x = 0;
            this.y = 0;
            this.width = 0;
            this.height = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.windowId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            StreamId streamId = this.videoStreamId;
            if (streamId != null) {
                codedOutputByteBufferNano.writeMessage(3, streamId);
            }
            int i2 = this.x;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            int i3 = this.y;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i3);
            }
            int i4 = this.width;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i4);
            }
            int i5 = this.height;
            if (i5 != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i5);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.windowId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            StreamId streamId = this.videoStreamId;
            if (streamId != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, streamId);
            }
            int i2 = this.x;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            int i3 = this.y;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
            }
            int i4 = this.width;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i4);
            }
            int i5 = this.height;
            return i5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i5) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final Window mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.windowId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    if (this.videoStreamId == null) {
                        this.videoStreamId = new StreamId();
                    }
                    codedInputByteBufferNano.readMessage(this.videoStreamId);
                } else if (tag == 32) {
                    this.x = codedInputByteBufferNano.readUInt32();
                } else if (tag == 40) {
                    this.y = codedInputByteBufferNano.readUInt32();
                } else if (tag == 48) {
                    this.width = codedInputByteBufferNano.readUInt32();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.height = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static Window parseFrom(byte[] bArr) {
            return (Window) MessageNano.mergeFrom(new Window(), bArr);
        }

        public static Window parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new Window().mergeFrom(codedInputByteBufferNano);
        }
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

    public static final class LayoutConfig extends MessageNano {
        private static volatile LayoutConfig[] _emptyArray;
        public String bizId;
        public int bizType;
        public Size canvasSize;
        public int layoutType;
        public int verion;
        public Window[] windowInfo;

        public static LayoutConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LayoutConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LayoutConfig() {
            clear();
        }

        public final LayoutConfig clear() {
            this.verion = 0;
            this.bizType = 0;
            this.bizId = "";
            this.canvasSize = null;
            this.windowInfo = Window.emptyArray();
            this.layoutType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.verion;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(2, i2);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.bizId);
            }
            Size size = this.canvasSize;
            if (size != null) {
                codedOutputByteBufferNano.writeMessage(4, size);
            }
            Window[] windowArr = this.windowInfo;
            if (windowArr != null && windowArr.length > 0) {
                int i3 = 0;
                while (true) {
                    Window[] windowArr2 = this.windowInfo;
                    if (i3 >= windowArr2.length) {
                        break;
                    }
                    Window window = windowArr2[i3];
                    if (window != null) {
                        codedOutputByteBufferNano.writeMessage(5, window);
                    }
                    i3++;
                }
            }
            int i4 = this.layoutType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.verion;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.bizId);
            }
            Size size = this.canvasSize;
            if (size != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, size);
            }
            Window[] windowArr = this.windowInfo;
            if (windowArr != null && windowArr.length > 0) {
                int i3 = 0;
                while (true) {
                    Window[] windowArr2 = this.windowInfo;
                    if (i3 >= windowArr2.length) {
                        break;
                    }
                    Window window = windowArr2[i3];
                    if (window != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, window);
                    }
                    i3++;
                }
            }
            int i4 = this.layoutType;
            return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LayoutConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.verion = int32;
                    }
                } else if (tag == 16) {
                    int int322 = codedInputByteBufferNano.readInt32();
                    switch (int322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                            this.bizType = int322;
                            break;
                    }
                } else if (tag == 26) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    if (this.canvasSize == null) {
                        this.canvasSize = new Size();
                    }
                    codedInputByteBufferNano.readMessage(this.canvasSize);
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    Window[] windowArr = this.windowInfo;
                    int length = windowArr == null ? 0 : windowArr.length;
                    Window[] windowArr2 = new Window[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.windowInfo, 0, windowArr2, 0, length);
                    }
                    while (length < windowArr2.length - 1) {
                        windowArr2[length] = new Window();
                        codedInputByteBufferNano.readMessage(windowArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    windowArr2[length] = new Window();
                    codedInputByteBufferNano.readMessage(windowArr2[length]);
                    this.windowInfo = windowArr2;
                } else if (tag != 48) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.layoutType = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LayoutConfig parseFrom(byte[] bArr) {
            return (LayoutConfig) MessageNano.mergeFrom(new LayoutConfig(), bArr);
        }

        public static LayoutConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LayoutConfig().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AudioStatus extends MessageNano {
        private static volatile AudioStatus[] _emptyArray;
        public long[] muteUserIds;
        public long[] speakingUserIds;
        public long timestamp;
        public int verion;

        public static AudioStatus[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AudioStatus[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AudioStatus() {
            clear();
        }

        public final AudioStatus clear() {
            this.verion = 0;
            this.muteUserIds = WireFormatNano.EMPTY_LONG_ARRAY;
            this.speakingUserIds = WireFormatNano.EMPTY_LONG_ARRAY;
            this.timestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long[] jArr = this.muteUserIds;
            int i = 0;
            if (jArr != null && jArr.length > 0) {
                int i2 = 0;
                while (true) {
                    long[] jArr2 = this.muteUserIds;
                    if (i2 >= jArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt64(1, jArr2[i2]);
                    i2++;
                }
            }
            long[] jArr3 = this.speakingUserIds;
            if (jArr3 != null && jArr3.length > 0) {
                while (true) {
                    long[] jArr4 = this.speakingUserIds;
                    if (i >= jArr4.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt64(2, jArr4[i]);
                    i++;
                }
            }
            int i3 = this.verion;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i3);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            long[] jArr;
            long[] jArr2;
            int iComputeSerializedSize = super.computeSerializedSize();
            long[] jArr3 = this.muteUserIds;
            int i = 0;
            if (jArr3 != null && jArr3.length > 0) {
                int i2 = 0;
                int iComputeUInt64SizeNoTag = 0;
                while (true) {
                    jArr2 = this.muteUserIds;
                    if (i2 >= jArr2.length) {
                        break;
                    }
                    iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i2]);
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
            }
            long[] jArr4 = this.speakingUserIds;
            if (jArr4 != null && jArr4.length > 0) {
                int iComputeUInt64SizeNoTag2 = 0;
                while (true) {
                    jArr = this.speakingUserIds;
                    if (i >= jArr.length) {
                        break;
                    }
                    iComputeUInt64SizeNoTag2 += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag2 + (jArr.length * 1);
            }
            int i3 = this.verion;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
            }
            long j = this.timestamp;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AudioStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    long[] jArr = this.muteUserIds;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.muteUserIds, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.muteUserIds = jArr2;
                } else if (tag == 10) {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.muteUserIds;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.muteUserIds, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.muteUserIds = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                } else if (tag == 16) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                    long[] jArr5 = this.speakingUserIds;
                    int length3 = jArr5 == null ? 0 : jArr5.length;
                    long[] jArr6 = new long[repeatedFieldArrayLength2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.speakingUserIds, 0, jArr6, 0, length3);
                    }
                    while (length3 < jArr6.length - 1) {
                        jArr6[length3] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    jArr6[length3] = codedInputByteBufferNano.readUInt64();
                    this.speakingUserIds = jArr6;
                } else if (tag == 18) {
                    int iPushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i2 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i2++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    long[] jArr7 = this.speakingUserIds;
                    int length4 = jArr7 == null ? 0 : jArr7.length;
                    long[] jArr8 = new long[i2 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.speakingUserIds, 0, jArr8, 0, length4);
                    }
                    while (length4 < jArr8.length) {
                        jArr8[length4] = codedInputByteBufferNano.readUInt64();
                        length4++;
                    }
                    this.speakingUserIds = jArr8;
                    codedInputByteBufferNano.popLimit(iPushLimit2);
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.verion = int32;
                    }
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static AudioStatus parseFrom(byte[] bArr) {
            return (AudioStatus) MessageNano.mergeFrom(new AudioStatus(), bArr);
        }

        public static AudioStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AudioStatus().mergeFrom(codedInputByteBufferNano);
        }
    }
}
