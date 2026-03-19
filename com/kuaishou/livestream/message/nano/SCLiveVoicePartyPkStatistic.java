package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyPkStatistic extends MessageNano {
    private static volatile SCLiveVoicePartyPkStatistic[] _emptyArray;
    public int myTeamType;
    public long penaltyDeadline;
    public String pkId;
    public long prePenaltyDeadline;
    public LiveVoicePartyPkTeamStatistic[] teamStat;
    public long time;
    public long timestamp;
    public long voteDeadline;
    public boolean voteEnd;
    public long voteEndWaitDeadline;
    public long voteStartTime;

    public static SCLiveVoicePartyPkStatistic[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkStatistic[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkStatistic() {
        clear();
    }

    public final SCLiveVoicePartyPkStatistic clear() {
        this.pkId = "";
        this.time = 0L;
        this.voteStartTime = 0L;
        this.voteDeadline = 0L;
        this.teamStat = LiveVoicePartyPkTeamStatistic.emptyArray();
        this.voteEnd = false;
        this.voteEndWaitDeadline = 0L;
        this.prePenaltyDeadline = 0L;
        this.penaltyDeadline = 0L;
        this.myTeamType = 0;
        this.timestamp = 0L;
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
        long j3 = this.voteDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        LiveVoicePartyPkTeamStatistic[] liveVoicePartyPkTeamStatisticArr = this.teamStat;
        if (liveVoicePartyPkTeamStatisticArr != null && liveVoicePartyPkTeamStatisticArr.length > 0) {
            int i = 0;
            while (true) {
                LiveVoicePartyPkTeamStatistic[] liveVoicePartyPkTeamStatisticArr2 = this.teamStat;
                if (i >= liveVoicePartyPkTeamStatisticArr2.length) {
                    break;
                }
                LiveVoicePartyPkTeamStatistic liveVoicePartyPkTeamStatistic = liveVoicePartyPkTeamStatisticArr2[i];
                if (liveVoicePartyPkTeamStatistic != null) {
                    codedOutputByteBufferNano.writeMessage(5, liveVoicePartyPkTeamStatistic);
                }
                i++;
            }
        }
        boolean z = this.voteEnd;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        long j4 = this.voteEndWaitDeadline;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j4);
        }
        long j5 = this.prePenaltyDeadline;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j5);
        }
        long j6 = this.penaltyDeadline;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j6);
        }
        int i2 = this.myTeamType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i2);
        }
        long j7 = this.timestamp;
        if (j7 != 0) {
            codedOutputByteBufferNano.writeUInt64(11, j7);
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
        long j3 = this.voteDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        LiveVoicePartyPkTeamStatistic[] liveVoicePartyPkTeamStatisticArr = this.teamStat;
        if (liveVoicePartyPkTeamStatisticArr != null && liveVoicePartyPkTeamStatisticArr.length > 0) {
            int i = 0;
            while (true) {
                LiveVoicePartyPkTeamStatistic[] liveVoicePartyPkTeamStatisticArr2 = this.teamStat;
                if (i >= liveVoicePartyPkTeamStatisticArr2.length) {
                    break;
                }
                LiveVoicePartyPkTeamStatistic liveVoicePartyPkTeamStatistic = liveVoicePartyPkTeamStatisticArr2[i];
                if (liveVoicePartyPkTeamStatistic != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveVoicePartyPkTeamStatistic);
                }
                i++;
            }
        }
        boolean z = this.voteEnd;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        long j4 = this.voteEndWaitDeadline;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j4);
        }
        long j5 = this.prePenaltyDeadline;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j5);
        }
        long j6 = this.penaltyDeadline;
        if (j6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j6);
        }
        int i2 = this.myTeamType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i2);
        }
        long j7 = this.timestamp;
        return j7 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(11, j7) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.pkId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.time = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.voteStartTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.voteDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LiveVoicePartyPkTeamStatistic[] liveVoicePartyPkTeamStatisticArr = this.teamStat;
                    int length = liveVoicePartyPkTeamStatisticArr == null ? 0 : liveVoicePartyPkTeamStatisticArr.length;
                    LiveVoicePartyPkTeamStatistic[] liveVoicePartyPkTeamStatisticArr2 = new LiveVoicePartyPkTeamStatistic[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.teamStat, 0, liveVoicePartyPkTeamStatisticArr2, 0, length);
                    }
                    while (length < liveVoicePartyPkTeamStatisticArr2.length - 1) {
                        liveVoicePartyPkTeamStatisticArr2[length] = new LiveVoicePartyPkTeamStatistic();
                        codedInputByteBufferNano.readMessage(liveVoicePartyPkTeamStatisticArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveVoicePartyPkTeamStatisticArr2[length] = new LiveVoicePartyPkTeamStatistic();
                    codedInputByteBufferNano.readMessage(liveVoicePartyPkTeamStatisticArr2[length]);
                    this.teamStat = liveVoicePartyPkTeamStatisticArr2;
                    break;
                case 48:
                    this.voteEnd = codedInputByteBufferNano.readBool();
                    break;
                case 56:
                    this.voteEndWaitDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.prePenaltyDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.penaltyDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 80:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.myTeamType = int32;
                        break;
                    }
                case 88:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveVoicePartyPkStatistic parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkStatistic) MessageNano.mergeFrom(new SCLiveVoicePartyPkStatistic(), bArr);
    }

    public static SCLiveVoicePartyPkStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkStatistic().mergeFrom(codedInputByteBufferNano);
    }
}
