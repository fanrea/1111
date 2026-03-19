package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TeamPkFightMotion extends MessageNano {
    private static volatile TeamPkFightMotion[] _emptyArray;
    public int fromTeam;
    public String liveStreamId;
    public String pkId;
    public String pkRoomId;
    public int toTeam;
    public String voicePartyId;

    public static TeamPkFightMotion[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TeamPkFightMotion[0];
                }
            }
        }
        return _emptyArray;
    }

    public TeamPkFightMotion() {
        clear();
    }

    public final TeamPkFightMotion clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.pkRoomId = "";
        this.pkId = "";
        this.fromTeam = 0;
        this.toTeam = 0;
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
        int i = this.fromTeam;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        int i2 = this.toTeam;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i2);
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
        int i = this.fromTeam;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        int i2 = this.toTeam;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TeamPkFightMotion mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.fromTeam = int32;
                }
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.toTeam = int322;
                }
            }
        }
    }

    public static TeamPkFightMotion parseFrom(byte[] bArr) {
        return (TeamPkFightMotion) MessageNano.mergeFrom(new TeamPkFightMotion(), bArr);
    }

    public static TeamPkFightMotion parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TeamPkFightMotion().mergeFrom(codedInputByteBufferNano);
    }
}
