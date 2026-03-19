package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLivePopularityRankInfo extends MessageNano {
    private static volatile SCLivePopularityRankInfo[] _emptyArray;
    public long currentTimestamp;
    public String displayRank;
    public boolean isInTop;
    public String liveStreamId;
    public int priority;
    public String rank;
    public int rankType;
    public boolean showRank;

    public static SCLivePopularityRankInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePopularityRankInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePopularityRankInfo() {
        clear();
    }

    public final SCLivePopularityRankInfo clear() {
        this.liveStreamId = "";
        this.isInTop = false;
        this.displayRank = "";
        this.showRank = false;
        this.priority = 0;
        this.currentTimestamp = 0L;
        this.rank = "";
        this.rankType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        boolean z = this.isInTop;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        if (!this.displayRank.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.displayRank);
        }
        boolean z2 = this.showRank;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        int i = this.priority;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i);
        }
        long j = this.currentTimestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        if (!this.rank.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.rank);
        }
        int i2 = this.rankType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        boolean z = this.isInTop;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        if (!this.displayRank.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayRank);
        }
        boolean z2 = this.showRank;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
        }
        int i = this.priority;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
        }
        long j = this.currentTimestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
        }
        if (!this.rank.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.rank);
        }
        int i2 = this.rankType;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(8, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePopularityRankInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.isInTop = codedInputByteBufferNano.readBool();
            } else if (tag == 26) {
                this.displayRank = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.showRank = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.priority = codedInputByteBufferNano.readUInt32();
            } else if (tag == 48) {
                this.currentTimestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 58) {
                this.rank = codedInputByteBufferNano.readString();
            } else if (tag != 64) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.rankType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLivePopularityRankInfo parseFrom(byte[] bArr) {
        return (SCLivePopularityRankInfo) MessageNano.mergeFrom(new SCLivePopularityRankInfo(), bArr);
    }

    public static SCLivePopularityRankInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePopularityRankInfo().mergeFrom(codedInputByteBufferNano);
    }
}
