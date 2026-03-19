package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatTeamMember extends MessageNano {
    private static volatile LiveScoreLineChatTeamMember[] _emptyArray;
    public String displayScore;
    public String displayTargetScore;
    public String liveStreamId;
    public UserInfos.UserInfo player;
    public long score;
    public String scoreBackgroundColor;
    public String scoreBlankColor;
    public String scoreProgressColor;
    public long targetScore;

    public static LiveScoreLineChatTeamMember[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatTeamMember[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatTeamMember() {
        clear();
    }

    public final LiveScoreLineChatTeamMember clear() {
        this.player = null;
        this.score = 0L;
        this.displayScore = "";
        this.liveStreamId = "";
        this.targetScore = 0L;
        this.displayTargetScore = "";
        this.scoreProgressColor = "";
        this.scoreBlankColor = "";
        this.scoreBackgroundColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.player;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        long j = this.score;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.displayScore.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.displayScore);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.liveStreamId);
        }
        long j2 = this.targetScore;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        if (!this.displayTargetScore.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.displayTargetScore);
        }
        if (!this.scoreProgressColor.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.scoreProgressColor);
        }
        if (!this.scoreBlankColor.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.scoreBlankColor);
        }
        if (!this.scoreBackgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.scoreBackgroundColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.player;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        long j = this.score;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.displayScore.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayScore);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
        }
        long j2 = this.targetScore;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        if (!this.displayTargetScore.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.displayTargetScore);
        }
        if (!this.scoreProgressColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.scoreProgressColor);
        }
        if (!this.scoreBlankColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.scoreBlankColor);
        }
        return !this.scoreBackgroundColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.scoreBackgroundColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatTeamMember mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.player == null) {
                    this.player = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.player);
            } else if (tag == 16) {
                this.score = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.displayScore = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.targetScore = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                this.displayTargetScore = codedInputByteBufferNano.readString();
            } else if (tag == 58) {
                this.scoreProgressColor = codedInputByteBufferNano.readString();
            } else if (tag == 66) {
                this.scoreBlankColor = codedInputByteBufferNano.readString();
            } else if (tag != 74) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.scoreBackgroundColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveScoreLineChatTeamMember parseFrom(byte[] bArr) {
        return (LiveScoreLineChatTeamMember) MessageNano.mergeFrom(new LiveScoreLineChatTeamMember(), bArr);
    }

    public static LiveScoreLineChatTeamMember parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatTeamMember().mergeFrom(codedInputByteBufferNano);
    }
}
