package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveUserClipLightGuide extends MessageNano {
    private static volatile LiveUserClipLightGuide[] _emptyArray;
    public long time;

    public static LiveUserClipLightGuide[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveUserClipLightGuide[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveUserClipLightGuide() {
        clear();
    }

    public final LiveUserClipLightGuide clear() {
        this.time = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.time;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveUserClipLightGuide mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.time = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveUserClipLightGuide parseFrom(byte[] bArr) {
        return (LiveUserClipLightGuide) MessageNano.mergeFrom(new LiveUserClipLightGuide(), bArr);
    }

    public static LiveUserClipLightGuide parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveUserClipLightGuide().mergeFrom(codedInputByteBufferNano);
    }
}
