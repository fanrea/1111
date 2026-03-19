package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAuthorRadarAudienceInfo extends MessageNano {
    private static volatile SCLiveAuthorRadarAudienceInfo[] _emptyArray;
    public long audienceCount;

    public static SCLiveAuthorRadarAudienceInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAuthorRadarAudienceInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAuthorRadarAudienceInfo() {
        clear();
    }

    public final SCLiveAuthorRadarAudienceInfo clear() {
        this.audienceCount = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.audienceCount;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.audienceCount;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAuthorRadarAudienceInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.audienceCount = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveAuthorRadarAudienceInfo parseFrom(byte[] bArr) {
        return (SCLiveAuthorRadarAudienceInfo) MessageNano.mergeFrom(new SCLiveAuthorRadarAudienceInfo(), bArr);
    }

    public static SCLiveAuthorRadarAudienceInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAuthorRadarAudienceInfo().mergeFrom(codedInputByteBufferNano);
    }
}
