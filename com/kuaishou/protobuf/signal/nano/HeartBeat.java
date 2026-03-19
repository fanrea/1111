package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class HeartBeat extends MessageNano {
    private static volatile HeartBeat[] _emptyArray;
    public String appId;
    public long sequenceNumber;

    public static HeartBeat[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new HeartBeat[0];
                }
            }
        }
        return _emptyArray;
    }

    public HeartBeat() {
        clear();
    }

    public final HeartBeat clear() {
        this.sequenceNumber = 0L;
        this.appId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.sequenceNumber;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        if (!this.appId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.appId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.sequenceNumber;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        return !this.appId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.appId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final HeartBeat mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.sequenceNumber = codedInputByteBufferNano.readInt64();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.appId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static HeartBeat parseFrom(byte[] bArr) {
        return (HeartBeat) MessageNano.mergeFrom(new HeartBeat(), bArr);
    }

    public static HeartBeat parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new HeartBeat().mergeFrom(codedInputByteBufferNano);
    }
}
