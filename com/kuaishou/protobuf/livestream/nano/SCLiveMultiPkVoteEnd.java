package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiPkVoteEnd extends MessageNano {
    private static volatile SCLiveMultiPkVoteEnd[] _emptyArray;
    public LiveMultiPkBottomTip bottomTip;
    public LiveMultiPkContinuousWin continuousWin;
    public long[] enableShowRealScoreUser;
    public long penaltyDeadline;
    public String penaltyText;
    public String pkId;
    public long prePenaltyDeadline;
    public LiveMultiPkTeam[] team;
    public long time;
    public int voteEndType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface VoteEndType {
        public static final int SCORE_LIMIT_END = 1;
        public static final int SINGLE_AUTHOR_SCORE_LIMIT_END = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveMultiPkVoteEnd[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiPkVoteEnd[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiPkVoteEnd() {
        clear();
    }

    public final SCLiveMultiPkVoteEnd clear() {
        this.pkId = "";
        this.time = 0L;
        this.team = LiveMultiPkTeam.emptyArray();
        this.prePenaltyDeadline = 0L;
        this.penaltyDeadline = 0L;
        this.penaltyText = "";
        this.continuousWin = null;
        this.voteEndType = 0;
        this.bottomTip = null;
        this.enableShowRealScoreUser = WireFormatNano.EMPTY_LONG_ARRAY;
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
        long j2 = this.prePenaltyDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        long j3 = this.penaltyDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        if (!this.penaltyText.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.penaltyText);
        }
        LiveMultiPkContinuousWin liveMultiPkContinuousWin = this.continuousWin;
        if (liveMultiPkContinuousWin != null) {
            codedOutputByteBufferNano.writeMessage(7, liveMultiPkContinuousWin);
        }
        int i3 = this.voteEndType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i3);
        }
        LiveMultiPkBottomTip liveMultiPkBottomTip = this.bottomTip;
        if (liveMultiPkBottomTip != null) {
            codedOutputByteBufferNano.writeMessage(9, liveMultiPkBottomTip);
        }
        long[] jArr = this.enableShowRealScoreUser;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.enableShowRealScoreUser;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(10, jArr2[i]);
                i++;
            }
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
        long j2 = this.prePenaltyDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        long j3 = this.penaltyDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        if (!this.penaltyText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.penaltyText);
        }
        LiveMultiPkContinuousWin liveMultiPkContinuousWin = this.continuousWin;
        if (liveMultiPkContinuousWin != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveMultiPkContinuousWin);
        }
        int i3 = this.voteEndType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i3);
        }
        LiveMultiPkBottomTip liveMultiPkBottomTip = this.bottomTip;
        if (liveMultiPkBottomTip != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveMultiPkBottomTip);
        }
        long[] jArr = this.enableShowRealScoreUser;
        if (jArr == null || jArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeUInt64SizeNoTag = 0;
        while (true) {
            long[] jArr2 = this.enableShowRealScoreUser;
            if (i < jArr2.length) {
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i]);
                i++;
            } else {
                return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiPkVoteEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                case 26:
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
                    break;
                case 32:
                    this.prePenaltyDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 40:
                    this.penaltyDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 50:
                    this.penaltyText = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    if (this.continuousWin == null) {
                        this.continuousWin = new LiveMultiPkContinuousWin();
                    }
                    codedInputByteBufferNano.readMessage(this.continuousWin);
                    break;
                case 64:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.voteEndType = int32;
                        break;
                    }
                    break;
                case 74:
                    if (this.bottomTip == null) {
                        this.bottomTip = new LiveMultiPkBottomTip();
                    }
                    codedInputByteBufferNano.readMessage(this.bottomTip);
                    break;
                case 80:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 80);
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
                    break;
                case 82:
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
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveMultiPkVoteEnd parseFrom(byte[] bArr) {
        return (SCLiveMultiPkVoteEnd) MessageNano.mergeFrom(new SCLiveMultiPkVoteEnd(), bArr);
    }

    public static SCLiveMultiPkVoteEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiPkVoteEnd().mergeFrom(codedInputByteBufferNano);
    }
}
