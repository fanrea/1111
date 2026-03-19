package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveCustomizationShareConfig extends MessageNano {
    private static volatile LiveCustomizationShareConfig[] _emptyArray;
    public boolean externalShow;
    public int version;

    public static LiveCustomizationShareConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCustomizationShareConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCustomizationShareConfig() {
        clear();
    }

    public final LiveCustomizationShareConfig clear() {
        this.version = 0;
        this.externalShow = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.version;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        boolean z = this.externalShow;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.version;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        boolean z = this.externalShow;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCustomizationShareConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.version = codedInputByteBufferNano.readUInt32();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.externalShow = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveCustomizationShareConfig parseFrom(byte[] bArr) {
        return (LiveCustomizationShareConfig) MessageNano.mergeFrom(new LiveCustomizationShareConfig(), bArr);
    }

    public static LiveCustomizationShareConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCustomizationShareConfig().mergeFrom(codedInputByteBufferNano);
    }
}
