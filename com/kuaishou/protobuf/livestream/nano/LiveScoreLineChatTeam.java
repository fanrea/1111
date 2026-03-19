package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatTeam extends MessageNano {
    private static volatile LiveScoreLineChatTeam[] _emptyArray;
    public int currentRank;
    public String displayTeamScore;
    public String displayTopProgressBarScore;
    public LiveScoreLineChatColorInfo teamFrameColor;
    public String teamFrameSourcePath;
    public int teamId;
    public LiveScoreLineChatTeamMember[] teamMember;
    public long teamScore;
    public long teamTarget;

    public static LiveScoreLineChatTeam[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatTeam[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatTeam() {
        clear();
    }

    public final LiveScoreLineChatTeam clear() {
        this.teamId = 0;
        this.teamScore = 0L;
        this.displayTeamScore = "";
        this.teamMember = LiveScoreLineChatTeamMember.emptyArray();
        this.currentRank = 0;
        this.teamFrameColor = null;
        this.teamTarget = 0L;
        this.displayTopProgressBarScore = "";
        this.teamFrameSourcePath = "";
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
        LiveScoreLineChatTeamMember[] liveScoreLineChatTeamMemberArr = this.teamMember;
        if (liveScoreLineChatTeamMemberArr != null && liveScoreLineChatTeamMemberArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveScoreLineChatTeamMember[] liveScoreLineChatTeamMemberArr2 = this.teamMember;
                if (i2 >= liveScoreLineChatTeamMemberArr2.length) {
                    break;
                }
                LiveScoreLineChatTeamMember liveScoreLineChatTeamMember = liveScoreLineChatTeamMemberArr2[i2];
                if (liveScoreLineChatTeamMember != null) {
                    codedOutputByteBufferNano.writeMessage(4, liveScoreLineChatTeamMember);
                }
                i2++;
            }
        }
        int i3 = this.currentRank;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i3);
        }
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo = this.teamFrameColor;
        if (liveScoreLineChatColorInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, liveScoreLineChatColorInfo);
        }
        long j2 = this.teamTarget;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j2);
        }
        if (!this.displayTopProgressBarScore.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.displayTopProgressBarScore);
        }
        if (!this.teamFrameSourcePath.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.teamFrameSourcePath);
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
        LiveScoreLineChatTeamMember[] liveScoreLineChatTeamMemberArr = this.teamMember;
        if (liveScoreLineChatTeamMemberArr != null && liveScoreLineChatTeamMemberArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveScoreLineChatTeamMember[] liveScoreLineChatTeamMemberArr2 = this.teamMember;
                if (i2 >= liveScoreLineChatTeamMemberArr2.length) {
                    break;
                }
                LiveScoreLineChatTeamMember liveScoreLineChatTeamMember = liveScoreLineChatTeamMemberArr2[i2];
                if (liveScoreLineChatTeamMember != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveScoreLineChatTeamMember);
                }
                i2++;
            }
        }
        int i3 = this.currentRank;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i3);
        }
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo = this.teamFrameColor;
        if (liveScoreLineChatColorInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveScoreLineChatColorInfo);
        }
        long j2 = this.teamTarget;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j2);
        }
        if (!this.displayTopProgressBarScore.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.displayTopProgressBarScore);
        }
        return !this.teamFrameSourcePath.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.teamFrameSourcePath) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatTeam mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                LiveScoreLineChatTeamMember[] liveScoreLineChatTeamMemberArr = this.teamMember;
                int length = liveScoreLineChatTeamMemberArr == null ? 0 : liveScoreLineChatTeamMemberArr.length;
                LiveScoreLineChatTeamMember[] liveScoreLineChatTeamMemberArr2 = new LiveScoreLineChatTeamMember[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.teamMember, 0, liveScoreLineChatTeamMemberArr2, 0, length);
                }
                while (length < liveScoreLineChatTeamMemberArr2.length - 1) {
                    liveScoreLineChatTeamMemberArr2[length] = new LiveScoreLineChatTeamMember();
                    codedInputByteBufferNano.readMessage(liveScoreLineChatTeamMemberArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveScoreLineChatTeamMemberArr2[length] = new LiveScoreLineChatTeamMember();
                codedInputByteBufferNano.readMessage(liveScoreLineChatTeamMemberArr2[length]);
                this.teamMember = liveScoreLineChatTeamMemberArr2;
            } else if (tag == 40) {
                this.currentRank = codedInputByteBufferNano.readUInt32();
            } else if (tag == 50) {
                if (this.teamFrameColor == null) {
                    this.teamFrameColor = new LiveScoreLineChatColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.teamFrameColor);
            } else if (tag == 56) {
                this.teamTarget = codedInputByteBufferNano.readUInt64();
            } else if (tag == 66) {
                this.displayTopProgressBarScore = codedInputByteBufferNano.readString();
            } else if (tag != 74) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.teamFrameSourcePath = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveScoreLineChatTeam parseFrom(byte[] bArr) {
        return (LiveScoreLineChatTeam) MessageNano.mergeFrom(new LiveScoreLineChatTeam(), bArr);
    }

    public static LiveScoreLineChatTeam parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatTeam().mergeFrom(codedInputByteBufferNano);
    }
}
