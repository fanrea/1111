package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TeamPkStatisticInfo extends MessageNano {
    private static volatile TeamPkStatisticInfo[] _emptyArray;
    public long penaltyDeadline;
    public long startTime;
    public TeamStatisticInfo[] teamStatisticInfo;
    public long time;
    public long voteDeadline;
    public boolean voteEnd;
    public long voteEndWaitDeadline;

    public static TeamPkStatisticInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TeamPkStatisticInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public TeamPkStatisticInfo() {
        clear();
    }

    public final TeamPkStatisticInfo clear() {
        this.startTime = 0L;
        this.voteDeadline = 0L;
        this.voteEnd = false;
        this.penaltyDeadline = 0L;
        this.voteEndWaitDeadline = 0L;
        this.teamStatisticInfo = TeamStatisticInfo.emptyArray();
        this.time = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.startTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.voteDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        boolean z = this.voteEnd;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        long j3 = this.penaltyDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j3);
        }
        long j4 = this.voteEndWaitDeadline;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j4);
        }
        TeamStatisticInfo[] teamStatisticInfoArr = this.teamStatisticInfo;
        if (teamStatisticInfoArr != null && teamStatisticInfoArr.length > 0) {
            int i = 0;
            while (true) {
                TeamStatisticInfo[] teamStatisticInfoArr2 = this.teamStatisticInfo;
                if (i >= teamStatisticInfoArr2.length) {
                    break;
                }
                TeamStatisticInfo teamStatisticInfo = teamStatisticInfoArr2[i];
                if (teamStatisticInfo != null) {
                    codedOutputByteBufferNano.writeMessage(6, teamStatisticInfo);
                }
                i++;
            }
        }
        long j5 = this.time;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.startTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.voteDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        boolean z = this.voteEnd;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        long j3 = this.penaltyDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j3);
        }
        long j4 = this.voteEndWaitDeadline;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j4);
        }
        TeamStatisticInfo[] teamStatisticInfoArr = this.teamStatisticInfo;
        if (teamStatisticInfoArr != null && teamStatisticInfoArr.length > 0) {
            int i = 0;
            while (true) {
                TeamStatisticInfo[] teamStatisticInfoArr2 = this.teamStatisticInfo;
                if (i >= teamStatisticInfoArr2.length) {
                    break;
                }
                TeamStatisticInfo teamStatisticInfo = teamStatisticInfoArr2[i];
                if (teamStatisticInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, teamStatisticInfo);
                }
                i++;
            }
        }
        long j5 = this.time;
        return j5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j5) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TeamPkStatisticInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.voteDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.voteEnd = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                this.penaltyDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.voteEndWaitDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                TeamStatisticInfo[] teamStatisticInfoArr = this.teamStatisticInfo;
                int length = teamStatisticInfoArr == null ? 0 : teamStatisticInfoArr.length;
                TeamStatisticInfo[] teamStatisticInfoArr2 = new TeamStatisticInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.teamStatisticInfo, 0, teamStatisticInfoArr2, 0, length);
                }
                while (length < teamStatisticInfoArr2.length - 1) {
                    teamStatisticInfoArr2[length] = new TeamStatisticInfo();
                    codedInputByteBufferNano.readMessage(teamStatisticInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                teamStatisticInfoArr2[length] = new TeamStatisticInfo();
                codedInputByteBufferNano.readMessage(teamStatisticInfoArr2[length]);
                this.teamStatisticInfo = teamStatisticInfoArr2;
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.time = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static TeamPkStatisticInfo parseFrom(byte[] bArr) {
        return (TeamPkStatisticInfo) MessageNano.mergeFrom(new TeamPkStatisticInfo(), bArr);
    }

    public static TeamPkStatisticInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TeamPkStatisticInfo().mergeFrom(codedInputByteBufferNano);
    }
}
