package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveHotProgrammeEnhanceInfoIndex extends MessageNano {
    private static volatile SCLiveHotProgrammeEnhanceInfoIndex[] _emptyArray;
    public double leftMarginScale;
    public long programmeId;
    public double topMarginScale;

    public static SCLiveHotProgrammeEnhanceInfoIndex[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveHotProgrammeEnhanceInfoIndex[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveHotProgrammeEnhanceInfoIndex() {
        clear();
    }

    public final SCLiveHotProgrammeEnhanceInfoIndex clear() {
        this.programmeId = 0L;
        this.topMarginScale = 0.0d;
        this.leftMarginScale = 0.0d;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.programmeId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (Double.doubleToLongBits(this.topMarginScale) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.topMarginScale);
        }
        if (Double.doubleToLongBits(this.leftMarginScale) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.leftMarginScale);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.programmeId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (Double.doubleToLongBits(this.topMarginScale) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.topMarginScale);
        }
        return Double.doubleToLongBits(this.leftMarginScale) != Double.doubleToLongBits(0.0d) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeDoubleSize(3, this.leftMarginScale) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveHotProgrammeEnhanceInfoIndex mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.programmeId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 17) {
                this.topMarginScale = codedInputByteBufferNano.readDouble();
            } else if (tag != 25) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.leftMarginScale = codedInputByteBufferNano.readDouble();
            }
        }
    }

    public static SCLiveHotProgrammeEnhanceInfoIndex parseFrom(byte[] bArr) {
        return (SCLiveHotProgrammeEnhanceInfoIndex) MessageNano.mergeFrom(new SCLiveHotProgrammeEnhanceInfoIndex(), bArr);
    }

    public static SCLiveHotProgrammeEnhanceInfoIndex parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveHotProgrammeEnhanceInfoIndex().mergeFrom(codedInputByteBufferNano);
    }
}
