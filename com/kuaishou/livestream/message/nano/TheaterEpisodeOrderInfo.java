package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TheaterEpisodeOrderInfo extends MessageNano {
    private static volatile TheaterEpisodeOrderInfo[] _emptyArray;
    public TheaterEpisodeInfo episodeInfo;
    public String episodeOrderId;

    public static TheaterEpisodeOrderInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TheaterEpisodeOrderInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public TheaterEpisodeOrderInfo() {
        clear();
    }

    public final TheaterEpisodeOrderInfo clear() {
        this.episodeOrderId = "";
        this.episodeInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.episodeOrderId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.episodeOrderId);
        }
        TheaterEpisodeInfo theaterEpisodeInfo = this.episodeInfo;
        if (theaterEpisodeInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, theaterEpisodeInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.episodeOrderId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.episodeOrderId);
        }
        TheaterEpisodeInfo theaterEpisodeInfo = this.episodeInfo;
        return theaterEpisodeInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, theaterEpisodeInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TheaterEpisodeOrderInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.episodeOrderId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.episodeInfo == null) {
                    this.episodeInfo = new TheaterEpisodeInfo();
                }
                codedInputByteBufferNano.readMessage(this.episodeInfo);
            }
        }
    }

    public static TheaterEpisodeOrderInfo parseFrom(byte[] bArr) {
        return (TheaterEpisodeOrderInfo) MessageNano.mergeFrom(new TheaterEpisodeOrderInfo(), bArr);
    }

    public static TheaterEpisodeOrderInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TheaterEpisodeOrderInfo().mergeFrom(codedInputByteBufferNano);
    }
}
