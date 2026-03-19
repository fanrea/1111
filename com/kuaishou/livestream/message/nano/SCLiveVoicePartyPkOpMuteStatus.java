package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyPkOpMuteStatus extends MessageNano {
    private static volatile SCLiveVoicePartyPkOpMuteStatus[] _emptyArray;
    public String liveStreamId;
    public boolean mute;
    public String pkId;
    public String voicePartyId;

    public static SCLiveVoicePartyPkOpMuteStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkOpMuteStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkOpMuteStatus() {
        clear();
    }

    public final SCLiveVoicePartyPkOpMuteStatus clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.pkId = "";
        this.mute = false;
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
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.pkId);
        }
        boolean z = this.mute;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
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
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.pkId);
        }
        boolean z = this.mute;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkOpMuteStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.mute = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCLiveVoicePartyPkOpMuteStatus parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkOpMuteStatus) MessageNano.mergeFrom(new SCLiveVoicePartyPkOpMuteStatus(), bArr);
    }

    public static SCLiveVoicePartyPkOpMuteStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkOpMuteStatus().mergeFrom(codedInputByteBufferNano);
    }
}
