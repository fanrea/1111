package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePkGuideBubbleTip extends MessageNano {
    private static volatile LivePkGuideBubbleTip[] _emptyArray;
    public int durationMs;
    public int pkGuideDurationMs;
    public String region;

    public static LivePkGuideBubbleTip[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePkGuideBubbleTip[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePkGuideBubbleTip() {
        clear();
    }

    public final LivePkGuideBubbleTip clear() {
        this.region = "";
        this.durationMs = 0;
        this.pkGuideDurationMs = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.region.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.region);
        }
        int i = this.durationMs;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        int i2 = this.pkGuideDurationMs;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.region.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.region);
        }
        int i = this.durationMs;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        int i2 = this.pkGuideDurationMs;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(3, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePkGuideBubbleTip mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.region = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.durationMs = codedInputByteBufferNano.readUInt32();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.pkGuideDurationMs = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LivePkGuideBubbleTip parseFrom(byte[] bArr) {
        return (LivePkGuideBubbleTip) MessageNano.mergeFrom(new LivePkGuideBubbleTip(), bArr);
    }

    public static LivePkGuideBubbleTip parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePkGuideBubbleTip().mergeFrom(codedInputByteBufferNano);
    }
}
