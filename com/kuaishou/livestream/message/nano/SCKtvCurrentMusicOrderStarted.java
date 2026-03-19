package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKtvCurrentMusicOrderStarted extends MessageNano {
    private static volatile SCKtvCurrentMusicOrderStarted[] _emptyArray;
    public String ktvId;
    public String liveStreamId;
    public String musicOrderId;
    public String voicePartyId;

    public static SCKtvCurrentMusicOrderStarted[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKtvCurrentMusicOrderStarted[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKtvCurrentMusicOrderStarted() {
        clear();
    }

    public final SCKtvCurrentMusicOrderStarted clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.ktvId = "";
        this.musicOrderId = "";
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
        if (!this.musicOrderId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.musicOrderId);
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
        return !this.musicOrderId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.musicOrderId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKtvCurrentMusicOrderStarted mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.musicOrderId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCKtvCurrentMusicOrderStarted parseFrom(byte[] bArr) {
        return (SCKtvCurrentMusicOrderStarted) MessageNano.mergeFrom(new SCKtvCurrentMusicOrderStarted(), bArr);
    }

    public static SCKtvCurrentMusicOrderStarted parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKtvCurrentMusicOrderStarted().mergeFrom(codedInputByteBufferNano);
    }
}
