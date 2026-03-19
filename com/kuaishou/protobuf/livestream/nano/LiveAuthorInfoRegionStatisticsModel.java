package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveAuthorInfoRegionStatisticsModel extends MessageNano {
    private static volatile LiveAuthorInfoRegionStatisticsModel[] _emptyArray;
    public String displayCount;
    public long realCount;

    public static LiveAuthorInfoRegionStatisticsModel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveAuthorInfoRegionStatisticsModel[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveAuthorInfoRegionStatisticsModel() {
        clear();
    }

    public final LiveAuthorInfoRegionStatisticsModel clear() {
        this.realCount = 0L;
        this.displayCount = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.realCount;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.displayCount.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.displayCount);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.realCount;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        return !this.displayCount.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.displayCount) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveAuthorInfoRegionStatisticsModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.realCount = codedInputByteBufferNano.readUInt64();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayCount = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveAuthorInfoRegionStatisticsModel parseFrom(byte[] bArr) {
        return (LiveAuthorInfoRegionStatisticsModel) MessageNano.mergeFrom(new LiveAuthorInfoRegionStatisticsModel(), bArr);
    }

    public static LiveAuthorInfoRegionStatisticsModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveAuthorInfoRegionStatisticsModel().mergeFrom(codedInputByteBufferNano);
    }
}
