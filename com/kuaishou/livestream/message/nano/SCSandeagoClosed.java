package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCSandeagoClosed extends MessageNano {
    private static volatile SCSandeagoClosed[] _emptyArray;
    public String itemId;
    public String liveStreamId;
    public long remainProductCount;

    public static SCSandeagoClosed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCSandeagoClosed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCSandeagoClosed() {
        clear();
    }

    public final SCSandeagoClosed clear() {
        this.liveStreamId = "";
        this.itemId = "";
        this.remainProductCount = 0L;
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
        long j = this.remainProductCount;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
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
        long j = this.remainProductCount;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCSandeagoClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.itemId = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.remainProductCount = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCSandeagoClosed parseFrom(byte[] bArr) {
        return (SCSandeagoClosed) MessageNano.mergeFrom(new SCSandeagoClosed(), bArr);
    }

    public static SCSandeagoClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCSandeagoClosed().mergeFrom(codedInputByteBufferNano);
    }
}
