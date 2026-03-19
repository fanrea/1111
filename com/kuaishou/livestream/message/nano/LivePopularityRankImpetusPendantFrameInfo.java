package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePopularityRankImpetusPendantFrameInfo extends MessageNano {
    private static volatile LivePopularityRankImpetusPendantFrameInfo[] _emptyArray;
    public PopularityRankImpetusPendantFold pendantFold;
    public PopularityRankImpetusPendantUnfold pendantUnfold;

    public static LivePopularityRankImpetusPendantFrameInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePopularityRankImpetusPendantFrameInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePopularityRankImpetusPendantFrameInfo() {
        clear();
    }

    public final LivePopularityRankImpetusPendantFrameInfo clear() {
        this.pendantFold = null;
        this.pendantUnfold = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        PopularityRankImpetusPendantFold popularityRankImpetusPendantFold = this.pendantFold;
        if (popularityRankImpetusPendantFold != null) {
            codedOutputByteBufferNano.writeMessage(1, popularityRankImpetusPendantFold);
        }
        PopularityRankImpetusPendantUnfold popularityRankImpetusPendantUnfold = this.pendantUnfold;
        if (popularityRankImpetusPendantUnfold != null) {
            codedOutputByteBufferNano.writeMessage(2, popularityRankImpetusPendantUnfold);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        PopularityRankImpetusPendantFold popularityRankImpetusPendantFold = this.pendantFold;
        if (popularityRankImpetusPendantFold != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, popularityRankImpetusPendantFold);
        }
        PopularityRankImpetusPendantUnfold popularityRankImpetusPendantUnfold = this.pendantUnfold;
        return popularityRankImpetusPendantUnfold != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, popularityRankImpetusPendantUnfold) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePopularityRankImpetusPendantFrameInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.pendantFold == null) {
                    this.pendantFold = new PopularityRankImpetusPendantFold();
                }
                codedInputByteBufferNano.readMessage(this.pendantFold);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.pendantUnfold == null) {
                    this.pendantUnfold = new PopularityRankImpetusPendantUnfold();
                }
                codedInputByteBufferNano.readMessage(this.pendantUnfold);
            }
        }
    }

    public static LivePopularityRankImpetusPendantFrameInfo parseFrom(byte[] bArr) {
        return (LivePopularityRankImpetusPendantFrameInfo) MessageNano.mergeFrom(new LivePopularityRankImpetusPendantFrameInfo(), bArr);
    }

    public static LivePopularityRankImpetusPendantFrameInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePopularityRankImpetusPendantFrameInfo().mergeFrom(codedInputByteBufferNano);
    }
}
