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
public final class SCMultiLiveCommonAuthorInfo extends MessageNano {
    private static volatile SCMultiLiveCommonAuthorInfo[] _emptyArray;
    public Map<Long, String> authorLabelMap;
    public long timestamp;

    public static SCMultiLiveCommonAuthorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCMultiLiveCommonAuthorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCMultiLiveCommonAuthorInfo() {
        clear();
    }

    public final SCMultiLiveCommonAuthorInfo clear() {
        this.authorLabelMap = null;
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<Long, String> map = this.authorLabelMap;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 4, 9);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Map<Long, String> map = this.authorLabelMap;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 4, 9);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCMultiLiveCommonAuthorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.authorLabelMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.authorLabelMap, mapFactory, 4, 9, null, 8, 18);
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCMultiLiveCommonAuthorInfo parseFrom(byte[] bArr) {
        return (SCMultiLiveCommonAuthorInfo) MessageNano.mergeFrom(new SCMultiLiveCommonAuthorInfo(), bArr);
    }

    public static SCMultiLiveCommonAuthorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCMultiLiveCommonAuthorInfo().mergeFrom(codedInputByteBufferNano);
    }
}
