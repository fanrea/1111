package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveFollowGuide extends MessageNano {
    private static volatile LiveFollowGuide[] _emptyArray;
    public long time;
    public int type;

    public static LiveFollowGuide[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveFollowGuide[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveFollowGuide() {
        clear();
    }

    public final LiveFollowGuide clear() {
        this.time = 0L;
        this.type = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        int i = this.type;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveFollowGuide mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.type = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LiveFollowGuide parseFrom(byte[] bArr) {
        return (LiveFollowGuide) MessageNano.mergeFrom(new LiveFollowGuide(), bArr);
    }

    public static LiveFollowGuide parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveFollowGuide().mergeFrom(codedInputByteBufferNano);
    }
}
