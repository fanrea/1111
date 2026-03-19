package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MediaContext extends MessageNano {
    private static volatile MediaContext[] _emptyArray;
    public int audioFecVer;
    public boolean enableAudioRx;
    public boolean enableAudioTx;
    public boolean enableVideoRx;
    public boolean enableVideoTx;
    public boolean isMain;
    public int maxVideoBitrate;
    public int sourceType;

    public static MediaContext[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MediaContext[0];
                }
            }
        }
        return _emptyArray;
    }

    public MediaContext() {
        clear();
    }

    public final MediaContext clear() {
        this.isMain = false;
        this.sourceType = 0;
        this.enableVideoTx = false;
        this.enableVideoRx = false;
        this.enableAudioTx = false;
        this.enableAudioRx = false;
        this.maxVideoBitrate = 0;
        this.audioFecVer = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isMain;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        int i = this.sourceType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        boolean z2 = this.enableVideoTx;
        if (z2) {
            codedOutputByteBufferNano.writeBool(3, z2);
        }
        boolean z3 = this.enableVideoRx;
        if (z3) {
            codedOutputByteBufferNano.writeBool(4, z3);
        }
        boolean z4 = this.enableAudioTx;
        if (z4) {
            codedOutputByteBufferNano.writeBool(5, z4);
        }
        boolean z5 = this.enableAudioRx;
        if (z5) {
            codedOutputByteBufferNano.writeBool(6, z5);
        }
        int i2 = this.maxVideoBitrate;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i2);
        }
        int i3 = this.audioFecVer;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isMain;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        int i = this.sourceType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        boolean z2 = this.enableVideoTx;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z2);
        }
        boolean z3 = this.enableVideoRx;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z3);
        }
        boolean z4 = this.enableAudioTx;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z4);
        }
        boolean z5 = this.enableAudioRx;
        if (z5) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z5);
        }
        int i2 = this.maxVideoBitrate;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i2);
        }
        int i3 = this.audioFecVer;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MediaContext mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.isMain = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.sourceType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 24) {
                this.enableVideoTx = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                this.enableVideoRx = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.enableAudioTx = codedInputByteBufferNano.readBool();
            } else if (tag == 48) {
                this.enableAudioRx = codedInputByteBufferNano.readBool();
            } else if (tag == 56) {
                this.maxVideoBitrate = codedInputByteBufferNano.readUInt32();
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.audioFecVer = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static MediaContext parseFrom(byte[] bArr) {
        return (MediaContext) MessageNano.mergeFrom(new MediaContext(), bArr);
    }

    public static MediaContext parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MediaContext().mergeFrom(codedInputByteBufferNano);
    }
}
