package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SandeagoItemInfo extends MessageNano {
    private static volatile SandeagoItemInfo[] _emptyArray;
    public long currentStock;
    public String itemId;

    public static SandeagoItemInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SandeagoItemInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SandeagoItemInfo() {
        clear();
    }

    public final SandeagoItemInfo clear() {
        this.itemId = "";
        this.currentStock = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.itemId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.itemId);
        }
        long j = this.currentStock;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.itemId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.itemId);
        }
        long j = this.currentStock;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SandeagoItemInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.itemId = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.currentStock = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SandeagoItemInfo parseFrom(byte[] bArr) {
        return (SandeagoItemInfo) MessageNano.mergeFrom(new SandeagoItemInfo(), bArr);
    }

    public static SandeagoItemInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SandeagoItemInfo().mergeFrom(codedInputByteBufferNano);
    }
}
