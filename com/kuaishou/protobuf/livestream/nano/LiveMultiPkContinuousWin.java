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
public final class LiveMultiPkContinuousWin extends MessageNano {
    private static volatile LiveMultiPkContinuousWin[] _emptyArray;
    public Map<Long, LiveMultiContinuousWinInfo> continuousWinMap;
    public boolean enableContinuousWin;

    public static LiveMultiPkContinuousWin[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkContinuousWin[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkContinuousWin() {
        clear();
    }

    public final LiveMultiPkContinuousWin clear() {
        this.enableContinuousWin = false;
        this.continuousWinMap = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.enableContinuousWin;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        Map<Long, LiveMultiContinuousWinInfo> map = this.continuousWinMap;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 4, 11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.enableContinuousWin;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        Map<Long, LiveMultiContinuousWinInfo> map = this.continuousWinMap;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 2, 4, 11) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkContinuousWin mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.enableContinuousWin = codedInputByteBufferNano.readBool();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.continuousWinMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.continuousWinMap, mapFactory, 4, 11, new LiveMultiContinuousWinInfo(), 8, 18);
            }
        }
    }

    public static LiveMultiPkContinuousWin parseFrom(byte[] bArr) {
        return (LiveMultiPkContinuousWin) MessageNano.mergeFrom(new LiveMultiPkContinuousWin(), bArr);
    }

    public static LiveMultiPkContinuousWin parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkContinuousWin().mergeFrom(codedInputByteBufferNano);
    }
}
