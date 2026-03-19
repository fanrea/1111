package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletPlayRoomBottomMaskLayer extends MessageNano {
    private static volatile SCLiveBulletPlayRoomBottomMaskLayer[] _emptyArray;
    public boolean enableMaskLayer;
    public long timestamp;

    public static SCLiveBulletPlayRoomBottomMaskLayer[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletPlayRoomBottomMaskLayer[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletPlayRoomBottomMaskLayer() {
        clear();
    }

    public final SCLiveBulletPlayRoomBottomMaskLayer clear() {
        this.timestamp = 0L;
        this.enableMaskLayer = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        boolean z = this.enableMaskLayer;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        boolean z = this.enableMaskLayer;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletPlayRoomBottomMaskLayer mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enableMaskLayer = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCLiveBulletPlayRoomBottomMaskLayer parseFrom(byte[] bArr) {
        return (SCLiveBulletPlayRoomBottomMaskLayer) MessageNano.mergeFrom(new SCLiveBulletPlayRoomBottomMaskLayer(), bArr);
    }

    public static SCLiveBulletPlayRoomBottomMaskLayer parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletPlayRoomBottomMaskLayer().mergeFrom(codedInputByteBufferNano);
    }
}
