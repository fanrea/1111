package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCTeamPkStatisticInfo extends MessageNano {
    private static volatile SCTeamPkStatisticInfo[] _emptyArray;
    public String liveStreamId;
    public String pkId;
    public String pkRoomId;
    public TeamPkStatisticInfo statisticInfo;
    public String voicePartyId;

    public static SCTeamPkStatisticInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCTeamPkStatisticInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCTeamPkStatisticInfo() {
        clear();
    }

    public final SCTeamPkStatisticInfo clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.pkRoomId = "";
        this.pkId = "";
        this.statisticInfo = null;
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
        TeamPkStatisticInfo teamPkStatisticInfo = this.statisticInfo;
        if (teamPkStatisticInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, teamPkStatisticInfo);
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
        TeamPkStatisticInfo teamPkStatisticInfo = this.statisticInfo;
        return teamPkStatisticInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, teamPkStatisticInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCTeamPkStatisticInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.statisticInfo == null) {
                    this.statisticInfo = new TeamPkStatisticInfo();
                }
                codedInputByteBufferNano.readMessage(this.statisticInfo);
            }
        }
    }

    public static SCTeamPkStatisticInfo parseFrom(byte[] bArr) {
        return (SCTeamPkStatisticInfo) MessageNano.mergeFrom(new SCTeamPkStatisticInfo(), bArr);
    }

    public static SCTeamPkStatisticInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCTeamPkStatisticInfo().mergeFrom(codedInputByteBufferNano);
    }
}
