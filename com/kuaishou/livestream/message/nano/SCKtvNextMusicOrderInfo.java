package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKtvNextMusicOrderInfo extends MessageNano {
    private static volatile SCKtvNextMusicOrderInfo[] _emptyArray;
    public String ktvId;
    public KtvMusicOrderInfo ktvMusicOrderInfo;
    public String liveStreamId;
    public String voicePartyId;

    public static SCKtvNextMusicOrderInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKtvNextMusicOrderInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKtvNextMusicOrderInfo() {
        clear();
    }

    public final SCKtvNextMusicOrderInfo clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.ktvId = "";
        this.ktvMusicOrderInfo = null;
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
        KtvMusicOrderInfo ktvMusicOrderInfo = this.ktvMusicOrderInfo;
        if (ktvMusicOrderInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, ktvMusicOrderInfo);
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
        KtvMusicOrderInfo ktvMusicOrderInfo = this.ktvMusicOrderInfo;
        return ktvMusicOrderInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, ktvMusicOrderInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKtvNextMusicOrderInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.ktvMusicOrderInfo == null) {
                    this.ktvMusicOrderInfo = new KtvMusicOrderInfo();
                }
                codedInputByteBufferNano.readMessage(this.ktvMusicOrderInfo);
            }
        }
    }

    public static SCKtvNextMusicOrderInfo parseFrom(byte[] bArr) {
        return (SCKtvNextMusicOrderInfo) MessageNano.mergeFrom(new SCKtvNextMusicOrderInfo(), bArr);
    }

    public static SCKtvNextMusicOrderInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKtvNextMusicOrderInfo().mergeFrom(codedInputByteBufferNano);
    }
}
