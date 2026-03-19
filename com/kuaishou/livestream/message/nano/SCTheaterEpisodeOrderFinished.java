package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCTheaterEpisodeOrderFinished extends MessageNano {
    private static volatile SCTheaterEpisodeOrderFinished[] _emptyArray;
    public String liveStreamId;
    public String theaterId;
    public String voicePartyId;

    public static SCTheaterEpisodeOrderFinished[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCTheaterEpisodeOrderFinished[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCTheaterEpisodeOrderFinished() {
        clear();
    }

    public final SCTheaterEpisodeOrderFinished clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.theaterId = "";
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
        if (!this.theaterId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.theaterId);
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
        return !this.theaterId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.theaterId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCTheaterEpisodeOrderFinished mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.theaterId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCTheaterEpisodeOrderFinished parseFrom(byte[] bArr) {
        return (SCTheaterEpisodeOrderFinished) MessageNano.mergeFrom(new SCTheaterEpisodeOrderFinished(), bArr);
    }

    public static SCTheaterEpisodeOrderFinished parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCTheaterEpisodeOrderFinished().mergeFrom(codedInputByteBufferNano);
    }
}
