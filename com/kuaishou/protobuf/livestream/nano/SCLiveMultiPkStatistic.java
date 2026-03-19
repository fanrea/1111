package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiPkStatistic extends MessageNano {
    private static volatile SCLiveMultiPkStatistic[] _emptyArray;
    public long[] enableShowRealScoreUser;
    public String pkId;
    public long pkInfoScatterDurationMs;
    public long statisticVersion;
    public LiveMultiPkTeam[] team;
    public long teamVersion;
    public long time;

    public static SCLiveMultiPkStatistic[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiPkStatistic[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiPkStatistic() {
        clear();
    }

    public final SCLiveMultiPkStatistic clear() {
        this.pkId = "";
        this.time = 0L;
        this.team = LiveMultiPkTeam.emptyArray();
        this.enableShowRealScoreUser = WireFormatNano.EMPTY_LONG_ARRAY;
        this.pkInfoScatterDurationMs = 0L;
        this.teamVersion = 0L;
        this.statisticVersion = 0L;
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
        LiveMultiPkTeam[] liveMultiPkTeamArr = this.team;
        int i = 0;
        if (liveMultiPkTeamArr != null && liveMultiPkTeamArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTeam[] liveMultiPkTeamArr2 = this.team;
                if (i2 >= liveMultiPkTeamArr2.length) {
                    break;
                }
                LiveMultiPkTeam liveMultiPkTeam = liveMultiPkTeamArr2[i2];
                if (liveMultiPkTeam != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveMultiPkTeam);
                }
                i2++;
            }
        }
        long[] jArr = this.enableShowRealScoreUser;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.enableShowRealScoreUser;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(4, jArr2[i]);
                i++;
            }
        }
        long j2 = this.pkInfoScatterDurationMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.teamVersion;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        long j4 = this.statisticVersion;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j4);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        LiveMultiPkTeam[] liveMultiPkTeamArr = this.team;
        int i = 0;
        if (liveMultiPkTeamArr != null && liveMultiPkTeamArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                LiveMultiPkTeam[] liveMultiPkTeamArr2 = this.team;
                if (i2 >= liveMultiPkTeamArr2.length) {
                    break;
                }
                LiveMultiPkTeam liveMultiPkTeam = liveMultiPkTeamArr2[i2];
                if (liveMultiPkTeam != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, liveMultiPkTeam);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        long[] jArr2 = this.enableShowRealScoreUser;
        if (jArr2 != null && jArr2.length > 0) {
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.enableShowRealScoreUser;
                if (i >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        long j2 = this.pkInfoScatterDurationMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.teamVersion;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
        }
        long j4 = this.statisticVersion;
        return j4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j4) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiPkStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveMultiPkTeam[] liveMultiPkTeamArr = this.team;
                int length = liveMultiPkTeamArr == null ? 0 : liveMultiPkTeamArr.length;
                LiveMultiPkTeam[] liveMultiPkTeamArr2 = new LiveMultiPkTeam[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.team, 0, liveMultiPkTeamArr2, 0, length);
                }
                while (length < liveMultiPkTeamArr2.length - 1) {
                    liveMultiPkTeamArr2[length] = new LiveMultiPkTeam();
                    codedInputByteBufferNano.readMessage(liveMultiPkTeamArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveMultiPkTeamArr2[length] = new LiveMultiPkTeam();
                codedInputByteBufferNano.readMessage(liveMultiPkTeamArr2[length]);
                this.team = liveMultiPkTeamArr2;
            } else if (tag == 32) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                long[] jArr = this.enableShowRealScoreUser;
                int length2 = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.enableShowRealScoreUser, 0, jArr2, 0, length2);
                }
                while (length2 < jArr2.length - 1) {
                    jArr2[length2] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                jArr2[length2] = codedInputByteBufferNano.readUInt64();
                this.enableShowRealScoreUser = jArr2;
            } else if (tag == 34) {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.enableShowRealScoreUser;
                int length3 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length3];
                if (length3 != 0) {
                    System.arraycopy(this.enableShowRealScoreUser, 0, jArr4, 0, length3);
                }
                while (length3 < jArr4.length) {
                    jArr4[length3] = codedInputByteBufferNano.readUInt64();
                    length3++;
                }
                this.enableShowRealScoreUser = jArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            } else if (tag == 40) {
                this.pkInfoScatterDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                this.teamVersion = codedInputByteBufferNano.readUInt64();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.statisticVersion = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveMultiPkStatistic parseFrom(byte[] bArr) {
        return (SCLiveMultiPkStatistic) MessageNano.mergeFrom(new SCLiveMultiPkStatistic(), bArr);
    }

    public static SCLiveMultiPkStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiPkStatistic().mergeFrom(codedInputByteBufferNano);
    }
}
