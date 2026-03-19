package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAuthorInfoRegionStatistics extends MessageNano {
    private static volatile SCLiveAuthorInfoRegionStatistics[] _emptyArray;
    public Map<Integer, LiveAuthorInfoRegionStatisticsModel> statisticsMap;

    public static SCLiveAuthorInfoRegionStatistics[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAuthorInfoRegionStatistics[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAuthorInfoRegionStatistics() {
        clear();
    }

    public final SCLiveAuthorInfoRegionStatistics clear() {
        this.statisticsMap = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Integer, LiveAuthorInfoRegionStatisticsModel> map = this.statisticsMap;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 13, 11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Map<Integer, LiveAuthorInfoRegionStatisticsModel> map = this.statisticsMap;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 1, 13, 11) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAuthorInfoRegionStatistics mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
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
                this.statisticsMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.statisticsMap, mapFactory, 13, 11, new LiveAuthorInfoRegionStatisticsModel(), 8, 18);
            }
        }
    }

    public static SCLiveAuthorInfoRegionStatistics parseFrom(byte[] bArr) {
        return (SCLiveAuthorInfoRegionStatistics) MessageNano.mergeFrom(new SCLiveAuthorInfoRegionStatistics(), bArr);
    }

    public static SCLiveAuthorInfoRegionStatistics parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAuthorInfoRegionStatistics().mergeFrom(codedInputByteBufferNano);
    }
}
