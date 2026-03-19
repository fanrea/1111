package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCTheaterEpisodeSwitchToast extends MessageNano {
    private static volatile SCTheaterEpisodeSwitchToast[] _emptyArray;
    public String currentPlayingOrderId;
    public String liveStreamId;
    public String theaterId;
    public String toastMessage;
    public String voicePartyId;

    public static SCTheaterEpisodeSwitchToast[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCTheaterEpisodeSwitchToast[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCTheaterEpisodeSwitchToast() {
        clear();
    }

    public final SCTheaterEpisodeSwitchToast clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.theaterId = "";
        this.currentPlayingOrderId = "";
        this.toastMessage = "";
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
        if (!this.currentPlayingOrderId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.currentPlayingOrderId);
        }
        if (!this.toastMessage.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.toastMessage);
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
        if (!this.currentPlayingOrderId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.currentPlayingOrderId);
        }
        return !this.toastMessage.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.toastMessage) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCTheaterEpisodeSwitchToast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.currentPlayingOrderId = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.toastMessage = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCTheaterEpisodeSwitchToast parseFrom(byte[] bArr) {
        return (SCTheaterEpisodeSwitchToast) MessageNano.mergeFrom(new SCTheaterEpisodeSwitchToast(), bArr);
    }

    public static SCTheaterEpisodeSwitchToast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCTheaterEpisodeSwitchToast().mergeFrom(codedInputByteBufferNano);
    }
}
