package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveStreamLatencyChangedSignal extends MessageNano {
    private static volatile SCLiveStreamLatencyChangedSignal[] _emptyArray;
    public long serverTime;

    public static SCLiveStreamLatencyChangedSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveStreamLatencyChangedSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveStreamLatencyChangedSignal() {
        clear();
    }

    public final SCLiveStreamLatencyChangedSignal clear() {
        this.serverTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.serverTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.serverTime;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveStreamLatencyChangedSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.serverTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveStreamLatencyChangedSignal parseFrom(byte[] bArr) {
        return (SCLiveStreamLatencyChangedSignal) MessageNano.mergeFrom(new SCLiveStreamLatencyChangedSignal(), bArr);
    }

    public static SCLiveStreamLatencyChangedSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveStreamLatencyChangedSignal().mergeFrom(codedInputByteBufferNano);
    }
}
