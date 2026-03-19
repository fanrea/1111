package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCTheaterNextEpisodeOrderInfo extends MessageNano {
    private static volatile SCTheaterNextEpisodeOrderInfo[] _emptyArray;
    public TheaterEpisodeOrderInfo episodeOrderInfo;
    public String liveStreamId;
    public long photoUrlQueryMaxDelayMillis;
    public int switchType;
    public String theaterId;
    public String uniqueId;
    public String voicePartyId;

    public static SCTheaterNextEpisodeOrderInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCTheaterNextEpisodeOrderInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCTheaterNextEpisodeOrderInfo() {
        clear();
    }

    public final SCTheaterNextEpisodeOrderInfo clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.theaterId = "";
        this.episodeOrderInfo = null;
        this.photoUrlQueryMaxDelayMillis = 0L;
        this.switchType = 0;
        this.uniqueId = "";
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
        TheaterEpisodeOrderInfo theaterEpisodeOrderInfo = this.episodeOrderInfo;
        if (theaterEpisodeOrderInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, theaterEpisodeOrderInfo);
        }
        long j = this.photoUrlQueryMaxDelayMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        int i = this.switchType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(6, i);
        }
        if (!this.uniqueId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.uniqueId);
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
        if (!this.theaterId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.theaterId);
        }
        TheaterEpisodeOrderInfo theaterEpisodeOrderInfo = this.episodeOrderInfo;
        if (theaterEpisodeOrderInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, theaterEpisodeOrderInfo);
        }
        long j = this.photoUrlQueryMaxDelayMillis;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        int i = this.switchType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i);
        }
        return !this.uniqueId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.uniqueId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCTheaterNextEpisodeOrderInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.theaterId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                if (this.episodeOrderInfo == null) {
                    this.episodeOrderInfo = new TheaterEpisodeOrderInfo();
                }
                codedInputByteBufferNano.readMessage(this.episodeOrderInfo);
            } else if (tag == 40) {
                this.photoUrlQueryMaxDelayMillis = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.switchType = int32;
                }
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.uniqueId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCTheaterNextEpisodeOrderInfo parseFrom(byte[] bArr) {
        return (SCTheaterNextEpisodeOrderInfo) MessageNano.mergeFrom(new SCTheaterNextEpisodeOrderInfo(), bArr);
    }

    public static SCTheaterNextEpisodeOrderInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCTheaterNextEpisodeOrderInfo().mergeFrom(codedInputByteBufferNano);
    }
}
