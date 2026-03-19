package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKtvSingerVideoStatus extends MessageNano {
    private static volatile SCKtvSingerVideoStatus[] _emptyArray;
    public String ktvId;
    public String liveStreamId;
    public long singerId;
    public boolean singerVideoStatus;
    public String voicePartyId;

    public static SCKtvSingerVideoStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKtvSingerVideoStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKtvSingerVideoStatus() {
        clear();
    }

    public final SCKtvSingerVideoStatus clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.ktvId = "";
        this.singerId = 0L;
        this.singerVideoStatus = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.voicePartyId);
        }
        if (!this.ktvId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.ktvId);
        }
        long j = this.singerId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        boolean z = this.singerVideoStatus;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.voicePartyId);
        }
        if (!this.ktvId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.ktvId);
        }
        long j = this.singerId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        boolean z = this.singerVideoStatus;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKtvSingerVideoStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.ktvId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.singerId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.singerVideoStatus = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCKtvSingerVideoStatus parseFrom(byte[] bArr) {
        return (SCKtvSingerVideoStatus) MessageNano.mergeFrom(new SCKtvSingerVideoStatus(), bArr);
    }

    public static SCKtvSingerVideoStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKtvSingerVideoStatus().mergeFrom(codedInputByteBufferNano);
    }
}
