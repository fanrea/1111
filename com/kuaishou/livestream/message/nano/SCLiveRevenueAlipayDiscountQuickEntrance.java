package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRevenueAlipayDiscountQuickEntrance extends MessageNano {
    private static volatile SCLiveRevenueAlipayDiscountQuickEntrance[] _emptyArray;
    public boolean checkBalance;
    public long currentTimestamp;
    public long maxDelayMillis;
    public String source;

    public static SCLiveRevenueAlipayDiscountQuickEntrance[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRevenueAlipayDiscountQuickEntrance[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRevenueAlipayDiscountQuickEntrance() {
        clear();
    }

    public final SCLiveRevenueAlipayDiscountQuickEntrance clear() {
        this.maxDelayMillis = 0L;
        this.source = "";
        this.checkBalance = false;
        this.currentTimestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.maxDelayMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.source.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.source);
        }
        boolean z = this.checkBalance;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        long j2 = this.currentTimestamp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.maxDelayMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.source.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.source);
        }
        boolean z = this.checkBalance;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        long j2 = this.currentTimestamp;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRevenueAlipayDiscountQuickEntrance mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.maxDelayMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.source = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.checkBalance = codedInputByteBufferNano.readBool();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.currentTimestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveRevenueAlipayDiscountQuickEntrance parseFrom(byte[] bArr) {
        return (SCLiveRevenueAlipayDiscountQuickEntrance) MessageNano.mergeFrom(new SCLiveRevenueAlipayDiscountQuickEntrance(), bArr);
    }

    public static SCLiveRevenueAlipayDiscountQuickEntrance parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRevenueAlipayDiscountQuickEntrance().mergeFrom(codedInputByteBufferNano);
    }
}
