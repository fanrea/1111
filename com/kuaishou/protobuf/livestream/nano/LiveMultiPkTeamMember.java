package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LivePkMessages;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkTeamMember extends MessageNano {
    private static volatile LiveMultiPkTeamMember[] _emptyArray;
    public BountyGameInfo bountyGameInfo;
    public MultiPkSkinTheme customPkSkinTheme;
    public String displayScore;
    public String liveStreamId;
    public UserInfos.UserInfo player;
    public long score;
    public LiveMultiPkColorInfo scoreBackgroundColor;
    public LivePkMessages.PkTopScoreUserDetailInfo[] topUserDetail;

    public static LiveMultiPkTeamMember[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkTeamMember[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkTeamMember() {
        clear();
    }

    public final LiveMultiPkTeamMember clear() {
        this.player = null;
        this.score = 0L;
        this.displayScore = "";
        this.liveStreamId = "";
        this.scoreBackgroundColor = null;
        this.topUserDetail = LivePkMessages.PkTopScoreUserDetailInfo.emptyArray();
        this.customPkSkinTheme = null;
        this.bountyGameInfo = null;
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
        LiveMultiPkColorInfo liveMultiPkColorInfo = this.scoreBackgroundColor;
        if (liveMultiPkColorInfo != null) {
            codedOutputByteBufferNano.writeMessage(5, liveMultiPkColorInfo);
        }
        LivePkMessages.PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr = this.topUserDetail;
        if (pkTopScoreUserDetailInfoArr != null && pkTopScoreUserDetailInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LivePkMessages.PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr2 = this.topUserDetail;
                if (i >= pkTopScoreUserDetailInfoArr2.length) {
                    break;
                }
                LivePkMessages.PkTopScoreUserDetailInfo pkTopScoreUserDetailInfo = pkTopScoreUserDetailInfoArr2[i];
                if (pkTopScoreUserDetailInfo != null) {
                    codedOutputByteBufferNano.writeMessage(6, pkTopScoreUserDetailInfo);
                }
                i++;
            }
        }
        MultiPkSkinTheme multiPkSkinTheme = this.customPkSkinTheme;
        if (multiPkSkinTheme != null) {
            codedOutputByteBufferNano.writeMessage(7, multiPkSkinTheme);
        }
        BountyGameInfo bountyGameInfo = this.bountyGameInfo;
        if (bountyGameInfo != null) {
            codedOutputByteBufferNano.writeMessage(8, bountyGameInfo);
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
        LiveMultiPkColorInfo liveMultiPkColorInfo = this.scoreBackgroundColor;
        if (liveMultiPkColorInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveMultiPkColorInfo);
        }
        LivePkMessages.PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr = this.topUserDetail;
        if (pkTopScoreUserDetailInfoArr != null && pkTopScoreUserDetailInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LivePkMessages.PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr2 = this.topUserDetail;
                if (i >= pkTopScoreUserDetailInfoArr2.length) {
                    break;
                }
                LivePkMessages.PkTopScoreUserDetailInfo pkTopScoreUserDetailInfo = pkTopScoreUserDetailInfoArr2[i];
                if (pkTopScoreUserDetailInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, pkTopScoreUserDetailInfo);
                }
                i++;
            }
        }
        MultiPkSkinTheme multiPkSkinTheme = this.customPkSkinTheme;
        if (multiPkSkinTheme != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, multiPkSkinTheme);
        }
        BountyGameInfo bountyGameInfo = this.bountyGameInfo;
        return bountyGameInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, bountyGameInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkTeamMember mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 42) {
                if (this.scoreBackgroundColor == null) {
                    this.scoreBackgroundColor = new LiveMultiPkColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.scoreBackgroundColor);
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                LivePkMessages.PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr = this.topUserDetail;
                int length = pkTopScoreUserDetailInfoArr == null ? 0 : pkTopScoreUserDetailInfoArr.length;
                LivePkMessages.PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr2 = new LivePkMessages.PkTopScoreUserDetailInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.topUserDetail, 0, pkTopScoreUserDetailInfoArr2, 0, length);
                }
                while (length < pkTopScoreUserDetailInfoArr2.length - 1) {
                    pkTopScoreUserDetailInfoArr2[length] = new LivePkMessages.PkTopScoreUserDetailInfo();
                    codedInputByteBufferNano.readMessage(pkTopScoreUserDetailInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                pkTopScoreUserDetailInfoArr2[length] = new LivePkMessages.PkTopScoreUserDetailInfo();
                codedInputByteBufferNano.readMessage(pkTopScoreUserDetailInfoArr2[length]);
                this.topUserDetail = pkTopScoreUserDetailInfoArr2;
            } else if (tag == 58) {
                if (this.customPkSkinTheme == null) {
                    this.customPkSkinTheme = new MultiPkSkinTheme();
                }
                codedInputByteBufferNano.readMessage(this.customPkSkinTheme);
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.bountyGameInfo == null) {
                    this.bountyGameInfo = new BountyGameInfo();
                }
                codedInputByteBufferNano.readMessage(this.bountyGameInfo);
            }
        }
    }

    public static LiveMultiPkTeamMember parseFrom(byte[] bArr) {
        return (LiveMultiPkTeamMember) MessageNano.mergeFrom(new LiveMultiPkTeamMember(), bArr);
    }

    public static LiveMultiPkTeamMember parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkTeamMember().mergeFrom(codedInputByteBufferNano);
    }
}
