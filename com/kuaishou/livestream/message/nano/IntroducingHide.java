package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class IntroducingHide extends MessageNano {
    private static volatile IntroducingHide[] _emptyArray;
    public long hideTime;
    public long showTime;
    public long updateShowTime;

    public static IntroducingHide[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new IntroducingHide[0];
                }
            }
        }
        return _emptyArray;
    }

    public IntroducingHide() {
        clear();
    }

    public final IntroducingHide clear() {
        this.showTime = 0L;
        this.hideTime = 0L;
        this.updateShowTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.showTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        long j2 = this.hideTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j2);
        }
        long j3 = this.updateShowTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.showTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        long j2 = this.hideTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j2);
        }
        long j3 = this.updateShowTime;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final IntroducingHide mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.showTime = codedInputByteBufferNano.readInt64();
            } else if (tag == 16) {
                this.hideTime = codedInputByteBufferNano.readInt64();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.updateShowTime = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static IntroducingHide parseFrom(byte[] bArr) {
        return (IntroducingHide) MessageNano.mergeFrom(new IntroducingHide(), bArr);
    }

    public static IntroducingHide parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new IntroducingHide().mergeFrom(codedInputByteBufferNano);
    }
}
