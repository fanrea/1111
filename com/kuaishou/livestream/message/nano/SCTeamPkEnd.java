package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCTeamPkEnd extends MessageNano {
    private static volatile SCTeamPkEnd[] _emptyArray;
    public int endType;
    public String liveStreamId;
    public String pkId;
    public String pkRoomId;
    public String toastMsg;
    public String voicePartyId;

    public static SCTeamPkEnd[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCTeamPkEnd[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCTeamPkEnd() {
        clear();
    }

    public final SCTeamPkEnd clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.pkRoomId = "";
        this.pkId = "";
        this.endType = 0;
        this.toastMsg = "";
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
        if (!this.pkRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.pkRoomId);
        }
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.pkId);
        }
        int i = this.endType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        if (!this.toastMsg.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.toastMsg);
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
        if (!this.pkRoomId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.pkRoomId);
        }
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.pkId);
        }
        int i = this.endType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        return !this.toastMsg.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.toastMsg) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCTeamPkEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.pkRoomId = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.endType = int32;
                }
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.toastMsg = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCTeamPkEnd parseFrom(byte[] bArr) {
        return (SCTeamPkEnd) MessageNano.mergeFrom(new SCTeamPkEnd(), bArr);
    }

    public static SCTeamPkEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCTeamPkEnd().mergeFrom(codedInputByteBufferNano);
    }
}
