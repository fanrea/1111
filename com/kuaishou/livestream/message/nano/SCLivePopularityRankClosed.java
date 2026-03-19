package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLivePopularityRankClosed extends MessageNano {
    private static volatile SCLivePopularityRankClosed[] _emptyArray;
    public String liveStreamId;

    public static SCLivePopularityRankClosed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePopularityRankClosed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePopularityRankClosed() {
        clear();
    }

    public final SCLivePopularityRankClosed clear() {
        this.liveStreamId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePopularityRankClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.liveStreamId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLivePopularityRankClosed parseFrom(byte[] bArr) {
        return (SCLivePopularityRankClosed) MessageNano.mergeFrom(new SCLivePopularityRankClosed(), bArr);
    }

    public static SCLivePopularityRankClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePopularityRankClosed().mergeFrom(codedInputByteBufferNano);
    }
}
