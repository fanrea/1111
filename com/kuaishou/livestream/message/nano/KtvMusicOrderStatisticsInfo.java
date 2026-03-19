package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KtvMusicOrderStatisticsInfo extends MessageNano {
    private static volatile KtvMusicOrderStatisticsInfo[] _emptyArray;
    public String displayMusicOrderUserCount;
    public long musicOrderCount;
    public long musicOrderUserCount;

    public static KtvMusicOrderStatisticsInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new KtvMusicOrderStatisticsInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public KtvMusicOrderStatisticsInfo() {
        clear();
    }

    public final KtvMusicOrderStatisticsInfo clear() {
        this.musicOrderUserCount = 0L;
        this.displayMusicOrderUserCount = "";
        this.musicOrderCount = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.musicOrderUserCount;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.displayMusicOrderUserCount.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.displayMusicOrderUserCount);
        }
        long j2 = this.musicOrderCount;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.musicOrderUserCount;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.displayMusicOrderUserCount.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.displayMusicOrderUserCount);
        }
        long j2 = this.musicOrderCount;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final KtvMusicOrderStatisticsInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.musicOrderUserCount = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.displayMusicOrderUserCount = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.musicOrderCount = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static KtvMusicOrderStatisticsInfo parseFrom(byte[] bArr) {
        return (KtvMusicOrderStatisticsInfo) MessageNano.mergeFrom(new KtvMusicOrderStatisticsInfo(), bArr);
    }

    public static KtvMusicOrderStatisticsInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new KtvMusicOrderStatisticsInfo().mergeFrom(codedInputByteBufferNano);
    }
}
