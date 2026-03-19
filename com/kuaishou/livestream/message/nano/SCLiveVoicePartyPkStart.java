package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyPkStart extends MessageNano {
    private static volatile SCLiveVoicePartyPkStart[] _emptyArray;
    public String base64MicSeatsInfo;
    public String opBase64MicSeatsInfo;
    public String pkId;
    public long time;
    public long voteStartTime;

    public static SCLiveVoicePartyPkStart[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkStart[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkStart() {
        clear();
    }

    public final SCLiveVoicePartyPkStart clear() {
        this.pkId = "";
        this.time = 0L;
        this.voteStartTime = 0L;
        this.base64MicSeatsInfo = "";
        this.opBase64MicSeatsInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.voteStartTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        if (!this.base64MicSeatsInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.base64MicSeatsInfo);
        }
        if (!this.opBase64MicSeatsInfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.opBase64MicSeatsInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.voteStartTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        if (!this.base64MicSeatsInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.base64MicSeatsInfo);
        }
        return !this.opBase64MicSeatsInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.opBase64MicSeatsInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkStart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.voteStartTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.base64MicSeatsInfo = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.opBase64MicSeatsInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveVoicePartyPkStart parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkStart) MessageNano.mergeFrom(new SCLiveVoicePartyPkStart(), bArr);
    }

    public static SCLiveVoicePartyPkStart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkStart().mergeFrom(codedInputByteBufferNano);
    }
}
