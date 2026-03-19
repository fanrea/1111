package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UpdatePushStreamConfig extends MessageNano {
    private static volatile UpdatePushStreamConfig[] _emptyArray;
    public int captureFps;
    public int captureFullHeight;
    public int captureFullWidth;
    public int captureHeight;
    public int captureMinFps;
    public int captureOutFps;
    public int captureWidth;
    public int frameRate;
    public int initBitrate;
    public int maxBitrate;
    public int minBitrate;
    public int targetHeight;
    public int targetWidth;

    public static UpdatePushStreamConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdatePushStreamConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public UpdatePushStreamConfig() {
        clear();
    }

    public final UpdatePushStreamConfig clear() {
        this.captureWidth = 0;
        this.captureHeight = 0;
        this.captureFullWidth = 0;
        this.captureFullHeight = 0;
        this.captureFps = 0;
        this.captureMinFps = 0;
        this.captureOutFps = 0;
        this.targetWidth = 0;
        this.targetHeight = 0;
        this.frameRate = 0;
        this.initBitrate = 0;
        this.minBitrate = 0;
        this.maxBitrate = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.captureWidth;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.captureHeight;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        int i3 = this.captureFullWidth;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i3);
        }
        int i4 = this.captureFullHeight;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i4);
        }
        int i5 = this.captureFps;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i5);
        }
        int i6 = this.captureMinFps;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i6);
        }
        int i7 = this.captureOutFps;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i7);
        }
        int i8 = this.targetWidth;
        if (i8 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i8);
        }
        int i9 = this.targetHeight;
        if (i9 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i9);
        }
        int i10 = this.frameRate;
        if (i10 != 0) {
            codedOutputByteBufferNano.writeUInt32(10, i10);
        }
        int i11 = this.initBitrate;
        if (i11 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i11);
        }
        int i12 = this.minBitrate;
        if (i12 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i12);
        }
        int i13 = this.maxBitrate;
        if (i13 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i13);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.captureWidth;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.captureHeight;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        int i3 = this.captureFullWidth;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
        }
        int i4 = this.captureFullHeight;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
        }
        int i5 = this.captureFps;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i5);
        }
        int i6 = this.captureMinFps;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i6);
        }
        int i7 = this.captureOutFps;
        if (i7 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i7);
        }
        int i8 = this.targetWidth;
        if (i8 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i8);
        }
        int i9 = this.targetHeight;
        if (i9 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i9);
        }
        int i10 = this.frameRate;
        if (i10 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(10, i10);
        }
        int i11 = this.initBitrate;
        if (i11 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i11);
        }
        int i12 = this.minBitrate;
        if (i12 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i12);
        }
        int i13 = this.maxBitrate;
        return i13 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(13, i13) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final UpdatePushStreamConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.captureWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 16:
                    this.captureHeight = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.captureFullWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.captureFullHeight = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.captureFps = codedInputByteBufferNano.readUInt32();
                    break;
                case 48:
                    this.captureMinFps = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.captureOutFps = codedInputByteBufferNano.readUInt32();
                    break;
                case 64:
                    this.targetWidth = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.targetHeight = codedInputByteBufferNano.readUInt32();
                    break;
                case 80:
                    this.frameRate = codedInputByteBufferNano.readUInt32();
                    break;
                case 88:
                    this.initBitrate = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.minBitrate = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.maxBitrate = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static UpdatePushStreamConfig parseFrom(byte[] bArr) {
        return (UpdatePushStreamConfig) MessageNano.mergeFrom(new UpdatePushStreamConfig(), bArr);
    }

    public static UpdatePushStreamConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new UpdatePushStreamConfig().mergeFrom(codedInputByteBufferNano);
    }
}
