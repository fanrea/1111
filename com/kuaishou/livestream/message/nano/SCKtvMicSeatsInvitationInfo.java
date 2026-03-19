package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKtvMicSeatsInvitationInfo extends MessageNano {
    private static volatile SCKtvMicSeatsInvitationInfo[] _emptyArray;
    public long guestUserId;
    public String ktvId;
    public String liveStreamId;
    public String token;
    public String voicePartyId;

    public static SCKtvMicSeatsInvitationInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKtvMicSeatsInvitationInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKtvMicSeatsInvitationInfo() {
        clear();
    }

    public final SCKtvMicSeatsInvitationInfo clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.ktvId = "";
        this.guestUserId = 0L;
        this.token = "";
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
        long j = this.guestUserId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        if (!this.token.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.token);
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
        long j = this.guestUserId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        return !this.token.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.token) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKtvMicSeatsInvitationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.guestUserId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.token = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCKtvMicSeatsInvitationInfo parseFrom(byte[] bArr) {
        return (SCKtvMicSeatsInvitationInfo) MessageNano.mergeFrom(new SCKtvMicSeatsInvitationInfo(), bArr);
    }

    public static SCKtvMicSeatsInvitationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKtvMicSeatsInvitationInfo().mergeFrom(codedInputByteBufferNano);
    }
}
