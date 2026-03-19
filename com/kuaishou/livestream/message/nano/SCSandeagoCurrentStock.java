package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCSandeagoCurrentStock extends MessageNano {
    private static volatile SCSandeagoCurrentStock[] _emptyArray;
    public long currentStock;
    public String itemId;
    public String liveStreamId;
    public long totalStock;

    public static SCSandeagoCurrentStock[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCSandeagoCurrentStock[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCSandeagoCurrentStock() {
        clear();
    }

    public final SCSandeagoCurrentStock clear() {
        this.liveStreamId = "";
        this.itemId = "";
        this.currentStock = 0L;
        this.totalStock = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.itemId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.itemId);
        }
        long j = this.currentStock;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.totalStock;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.itemId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.itemId);
        }
        long j = this.currentStock;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.totalStock;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCSandeagoCurrentStock mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.itemId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.currentStock = codedInputByteBufferNano.readUInt64();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.totalStock = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCSandeagoCurrentStock parseFrom(byte[] bArr) {
        return (SCSandeagoCurrentStock) MessageNano.mergeFrom(new SCSandeagoCurrentStock(), bArr);
    }

    public static SCSandeagoCurrentStock parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCSandeagoCurrentStock().mergeFrom(codedInputByteBufferNano);
    }
}
