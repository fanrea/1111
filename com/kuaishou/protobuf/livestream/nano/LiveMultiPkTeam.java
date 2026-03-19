package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkTeam extends MessageNano {
    private static volatile LiveMultiPkTeam[] _emptyArray;
    public int currentRank;
    public String displayTeamScore;
    public boolean enableClickContributionList;
    public boolean needFuzzyScore;
    public LiveMultiPkColorInfo progressBarColor;
    public LiveMultiPkColorInfo teamFrameColor;
    public int teamId;
    public LiveMultiPkTeamMember[] teamMember;
    public long teamScore;

    public static LiveMultiPkTeam[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkTeam[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkTeam() {
        clear();
    }

    public final LiveMultiPkTeam clear() {
        this.teamId = 0;
        this.teamScore = 0L;
        this.displayTeamScore = "";
        this.teamMember = LiveMultiPkTeamMember.emptyArray();
        this.enableClickContributionList = false;
        this.currentRank = 0;
        this.teamFrameColor = null;
        this.progressBarColor = null;
        this.needFuzzyScore = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.teamId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.teamScore;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.displayTeamScore.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.displayTeamScore);
        }
        LiveMultiPkTeamMember[] liveMultiPkTeamMemberArr = this.teamMember;
        if (liveMultiPkTeamMemberArr != null && liveMultiPkTeamMemberArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTeamMember[] liveMultiPkTeamMemberArr2 = this.teamMember;
                if (i2 >= liveMultiPkTeamMemberArr2.length) {
                    break;
                }
                LiveMultiPkTeamMember liveMultiPkTeamMember = liveMultiPkTeamMemberArr2[i2];
                if (liveMultiPkTeamMember != null) {
                    codedOutputByteBufferNano.writeMessage(4, liveMultiPkTeamMember);
                }
                i2++;
            }
        }
        boolean z = this.enableClickContributionList;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        int i3 = this.currentRank;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        LiveMultiPkColorInfo liveMultiPkColorInfo = this.teamFrameColor;
        if (liveMultiPkColorInfo != null) {
            codedOutputByteBufferNano.writeMessage(7, liveMultiPkColorInfo);
        }
        LiveMultiPkColorInfo liveMultiPkColorInfo2 = this.progressBarColor;
        if (liveMultiPkColorInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(8, liveMultiPkColorInfo2);
        }
        boolean z2 = this.needFuzzyScore;
        if (z2) {
            codedOutputByteBufferNano.writeBool(9, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.teamId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.teamScore;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.displayTeamScore.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayTeamScore);
        }
        LiveMultiPkTeamMember[] liveMultiPkTeamMemberArr = this.teamMember;
        if (liveMultiPkTeamMemberArr != null && liveMultiPkTeamMemberArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTeamMember[] liveMultiPkTeamMemberArr2 = this.teamMember;
                if (i2 >= liveMultiPkTeamMemberArr2.length) {
                    break;
                }
                LiveMultiPkTeamMember liveMultiPkTeamMember = liveMultiPkTeamMemberArr2[i2];
                if (liveMultiPkTeamMember != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveMultiPkTeamMember);
                }
                i2++;
            }
        }
        boolean z = this.enableClickContributionList;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        int i3 = this.currentRank;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i3);
        }
        LiveMultiPkColorInfo liveMultiPkColorInfo = this.teamFrameColor;
        if (liveMultiPkColorInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveMultiPkColorInfo);
        }
        LiveMultiPkColorInfo liveMultiPkColorInfo2 = this.progressBarColor;
        if (liveMultiPkColorInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveMultiPkColorInfo2);
        }
        boolean z2 = this.needFuzzyScore;
        return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(9, z2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkTeam mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.teamId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.teamScore = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.displayTeamScore = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                LiveMultiPkTeamMember[] liveMultiPkTeamMemberArr = this.teamMember;
                int length = liveMultiPkTeamMemberArr == null ? 0 : liveMultiPkTeamMemberArr.length;
                LiveMultiPkTeamMember[] liveMultiPkTeamMemberArr2 = new LiveMultiPkTeamMember[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.teamMember, 0, liveMultiPkTeamMemberArr2, 0, length);
                }
                while (length < liveMultiPkTeamMemberArr2.length - 1) {
                    liveMultiPkTeamMemberArr2[length] = new LiveMultiPkTeamMember();
                    codedInputByteBufferNano.readMessage(liveMultiPkTeamMemberArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveMultiPkTeamMemberArr2[length] = new LiveMultiPkTeamMember();
                codedInputByteBufferNano.readMessage(liveMultiPkTeamMemberArr2[length]);
                this.teamMember = liveMultiPkTeamMemberArr2;
            } else if (tag == 40) {
                this.enableClickContributionList = codedInputByteBufferNano.readBool();
            } else if (tag == 48) {
                this.currentRank = codedInputByteBufferNano.readUInt32();
            } else if (tag == 58) {
                if (this.teamFrameColor == null) {
                    this.teamFrameColor = new LiveMultiPkColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.teamFrameColor);
            } else if (tag == 66) {
                if (this.progressBarColor == null) {
                    this.progressBarColor = new LiveMultiPkColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.progressBarColor);
            } else if (tag != 72) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.needFuzzyScore = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveMultiPkTeam parseFrom(byte[] bArr) {
        return (LiveMultiPkTeam) MessageNano.mergeFrom(new LiveMultiPkTeam(), bArr);
    }

    public static LiveMultiPkTeam parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkTeam().mergeFrom(codedInputByteBufferNano);
    }
}
