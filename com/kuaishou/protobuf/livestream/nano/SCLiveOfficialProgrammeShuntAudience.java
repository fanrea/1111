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
public final class SCLiveOfficialProgrammeShuntAudience extends MessageNano {
    private static volatile SCLiveOfficialProgrammeShuntAudience[] _emptyArray;
    public Map<String, Integer> liveStreamIdPercentMap;
    public long maxDelayMs;
    public long minDelayMs;
    public String tagId;

    public static SCLiveOfficialProgrammeShuntAudience[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveOfficialProgrammeShuntAudience[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveOfficialProgrammeShuntAudience() {
        clear();
    }

    public final SCLiveOfficialProgrammeShuntAudience clear() {
        this.liveStreamIdPercentMap = null;
        this.minDelayMs = 0L;
        this.maxDelayMs = 0L;
        this.tagId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        Map<String, Integer> map = this.liveStreamIdPercentMap;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 1, 9, 5);
        }
        long j = this.minDelayMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.maxDelayMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        if (!this.tagId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.tagId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Map<String, Integer> map = this.liveStreamIdPercentMap;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 1, 9, 5);
        }
        long j = this.minDelayMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.maxDelayMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        return !this.tagId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.tagId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveOfficialProgrammeShuntAudience mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamIdPercentMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.liveStreamIdPercentMap, mapFactory, 9, 5, null, 10, 16);
            } else if (tag == 16) {
                this.minDelayMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.maxDelayMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.tagId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveOfficialProgrammeShuntAudience parseFrom(byte[] bArr) {
        return (SCLiveOfficialProgrammeShuntAudience) MessageNano.mergeFrom(new SCLiveOfficialProgrammeShuntAudience(), bArr);
    }

    public static SCLiveOfficialProgrammeShuntAudience parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveOfficialProgrammeShuntAudience().mergeFrom(codedInputByteBufferNano);
    }
}
