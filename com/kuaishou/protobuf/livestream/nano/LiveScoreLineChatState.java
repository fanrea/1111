package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatState extends MessageNano {
    private static volatile LiveScoreLineChatState[] _emptyArray;
    public String contributionListKrn;
    public boolean enableShowAttachGiftEntrance;
    public int giftId;
    public String giftToken;
    public LiveScoreLineChatHeadView[] headViewList;
    public UserInfos.PicUrl[] headerViewPicUrl;
    public long roomOwner;
    public String scoreLineChatId;
    public int scoreType;
    public SCLiveScoreLineChatStatistic statistic;
    public int status;
    public TargetGiftTabInfo targetGiftTabInfo;
    public LiveScoreLineChatTeam[] team;
    public LiveScoreLineChatTimeLine timeLine;
    public LiveScoreLineChatTopProgressBarInfo topProgressBarInfo;
    public LiveScoreLineChatVoteEnd voteEndInfo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveScoreLineChatStatus {
        public static final int START = 1;
        public static final int UNKNOWN = 0;
        public static final int VOTE_END = 2;
    }

    public static LiveScoreLineChatState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatState[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatState() {
        clear();
    }

    public final LiveScoreLineChatState clear() {
        this.scoreLineChatId = "";
        this.scoreType = 0;
        this.status = 0;
        this.timeLine = null;
        this.team = LiveScoreLineChatTeam.emptyArray();
        this.giftId = 0;
        this.roomOwner = 0L;
        this.voteEndInfo = null;
        this.targetGiftTabInfo = null;
        this.giftToken = "";
        this.headerViewPicUrl = UserInfos.PicUrl.emptyArray();
        this.enableShowAttachGiftEntrance = false;
        this.headViewList = LiveScoreLineChatHeadView.emptyArray();
        this.topProgressBarInfo = null;
        this.contributionListKrn = "";
        this.statistic = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.scoreLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.scoreLineChatId);
        }
        int i = this.scoreType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        int i2 = this.status;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        LiveScoreLineChatTimeLine liveScoreLineChatTimeLine = this.timeLine;
        if (liveScoreLineChatTimeLine != null) {
            codedOutputByteBufferNano.writeMessage(4, liveScoreLineChatTimeLine);
        }
        LiveScoreLineChatTeam[] liveScoreLineChatTeamArr = this.team;
        int i3 = 0;
        if (liveScoreLineChatTeamArr != null && liveScoreLineChatTeamArr.length > 0) {
            int i4 = 0;
            while (true) {
                LiveScoreLineChatTeam[] liveScoreLineChatTeamArr2 = this.team;
                if (i4 >= liveScoreLineChatTeamArr2.length) {
                    break;
                }
                LiveScoreLineChatTeam liveScoreLineChatTeam = liveScoreLineChatTeamArr2[i4];
                if (liveScoreLineChatTeam != null) {
                    codedOutputByteBufferNano.writeMessage(5, liveScoreLineChatTeam);
                }
                i4++;
            }
        }
        int i5 = this.giftId;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i5);
        }
        long j = this.roomOwner;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j);
        }
        LiveScoreLineChatVoteEnd liveScoreLineChatVoteEnd = this.voteEndInfo;
        if (liveScoreLineChatVoteEnd != null) {
            codedOutputByteBufferNano.writeMessage(8, liveScoreLineChatVoteEnd);
        }
        TargetGiftTabInfo targetGiftTabInfo = this.targetGiftTabInfo;
        if (targetGiftTabInfo != null) {
            codedOutputByteBufferNano.writeMessage(9, targetGiftTabInfo);
        }
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.giftToken);
        }
        UserInfos.PicUrl[] picUrlArr = this.headerViewPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headerViewPicUrl;
                if (i6 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i6];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(11, picUrl);
                }
                i6++;
            }
        }
        boolean z = this.enableShowAttachGiftEntrance;
        if (z) {
            codedOutputByteBufferNano.writeBool(12, z);
        }
        LiveScoreLineChatHeadView[] liveScoreLineChatHeadViewArr = this.headViewList;
        if (liveScoreLineChatHeadViewArr != null && liveScoreLineChatHeadViewArr.length > 0) {
            while (true) {
                LiveScoreLineChatHeadView[] liveScoreLineChatHeadViewArr2 = this.headViewList;
                if (i3 >= liveScoreLineChatHeadViewArr2.length) {
                    break;
                }
                LiveScoreLineChatHeadView liveScoreLineChatHeadView = liveScoreLineChatHeadViewArr2[i3];
                if (liveScoreLineChatHeadView != null) {
                    codedOutputByteBufferNano.writeMessage(13, liveScoreLineChatHeadView);
                }
                i3++;
            }
        }
        LiveScoreLineChatTopProgressBarInfo liveScoreLineChatTopProgressBarInfo = this.topProgressBarInfo;
        if (liveScoreLineChatTopProgressBarInfo != null) {
            codedOutputByteBufferNano.writeMessage(14, liveScoreLineChatTopProgressBarInfo);
        }
        if (!this.contributionListKrn.equals("")) {
            codedOutputByteBufferNano.writeString(15, this.contributionListKrn);
        }
        SCLiveScoreLineChatStatistic sCLiveScoreLineChatStatistic = this.statistic;
        if (sCLiveScoreLineChatStatistic != null) {
            codedOutputByteBufferNano.writeMessage(16, sCLiveScoreLineChatStatistic);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.scoreLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.scoreLineChatId);
        }
        int i = this.scoreType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        int i2 = this.status;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        LiveScoreLineChatTimeLine liveScoreLineChatTimeLine = this.timeLine;
        if (liveScoreLineChatTimeLine != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveScoreLineChatTimeLine);
        }
        LiveScoreLineChatTeam[] liveScoreLineChatTeamArr = this.team;
        int i3 = 0;
        if (liveScoreLineChatTeamArr != null && liveScoreLineChatTeamArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                LiveScoreLineChatTeam[] liveScoreLineChatTeamArr2 = this.team;
                if (i4 >= liveScoreLineChatTeamArr2.length) {
                    break;
                }
                LiveScoreLineChatTeam liveScoreLineChatTeam = liveScoreLineChatTeamArr2[i4];
                if (liveScoreLineChatTeam != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, liveScoreLineChatTeam);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        int i5 = this.giftId;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i5);
        }
        long j = this.roomOwner;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j);
        }
        LiveScoreLineChatVoteEnd liveScoreLineChatVoteEnd = this.voteEndInfo;
        if (liveScoreLineChatVoteEnd != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveScoreLineChatVoteEnd);
        }
        TargetGiftTabInfo targetGiftTabInfo = this.targetGiftTabInfo;
        if (targetGiftTabInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, targetGiftTabInfo);
        }
        if (!this.giftToken.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.giftToken);
        }
        UserInfos.PicUrl[] picUrlArr = this.headerViewPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.headerViewPicUrl;
                if (i6 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i6];
                if (picUrl != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(11, picUrl);
                }
                i6++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        boolean z = this.enableShowAttachGiftEntrance;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z);
        }
        LiveScoreLineChatHeadView[] liveScoreLineChatHeadViewArr = this.headViewList;
        if (liveScoreLineChatHeadViewArr != null && liveScoreLineChatHeadViewArr.length > 0) {
            while (true) {
                LiveScoreLineChatHeadView[] liveScoreLineChatHeadViewArr2 = this.headViewList;
                if (i3 >= liveScoreLineChatHeadViewArr2.length) {
                    break;
                }
                LiveScoreLineChatHeadView liveScoreLineChatHeadView = liveScoreLineChatHeadViewArr2[i3];
                if (liveScoreLineChatHeadView != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(13, liveScoreLineChatHeadView);
                }
                i3++;
            }
        }
        LiveScoreLineChatTopProgressBarInfo liveScoreLineChatTopProgressBarInfo = this.topProgressBarInfo;
        if (liveScoreLineChatTopProgressBarInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, liveScoreLineChatTopProgressBarInfo);
        }
        if (!this.contributionListKrn.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(15, this.contributionListKrn);
        }
        SCLiveScoreLineChatStatistic sCLiveScoreLineChatStatistic = this.statistic;
        return sCLiveScoreLineChatStatistic != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(16, sCLiveScoreLineChatStatistic) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.scoreLineChatId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1) {
                        break;
                    } else {
                        this.scoreType = int32;
                        break;
                    }
                case 24:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2) {
                        break;
                    } else {
                        this.status = int322;
                        break;
                    }
                    break;
                case 34:
                    if (this.timeLine == null) {
                        this.timeLine = new LiveScoreLineChatTimeLine();
                    }
                    codedInputByteBufferNano.readMessage(this.timeLine);
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LiveScoreLineChatTeam[] liveScoreLineChatTeamArr = this.team;
                    int length = liveScoreLineChatTeamArr == null ? 0 : liveScoreLineChatTeamArr.length;
                    LiveScoreLineChatTeam[] liveScoreLineChatTeamArr2 = new LiveScoreLineChatTeam[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.team, 0, liveScoreLineChatTeamArr2, 0, length);
                    }
                    while (length < liveScoreLineChatTeamArr2.length - 1) {
                        liveScoreLineChatTeamArr2[length] = new LiveScoreLineChatTeam();
                        codedInputByteBufferNano.readMessage(liveScoreLineChatTeamArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveScoreLineChatTeamArr2[length] = new LiveScoreLineChatTeam();
                    codedInputByteBufferNano.readMessage(liveScoreLineChatTeamArr2[length]);
                    this.team = liveScoreLineChatTeamArr2;
                    break;
                case 48:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 56:
                    this.roomOwner = codedInputByteBufferNano.readUInt64();
                    break;
                case 66:
                    if (this.voteEndInfo == null) {
                        this.voteEndInfo = new LiveScoreLineChatVoteEnd();
                    }
                    codedInputByteBufferNano.readMessage(this.voteEndInfo);
                    break;
                case 74:
                    if (this.targetGiftTabInfo == null) {
                        this.targetGiftTabInfo = new TargetGiftTabInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.targetGiftTabInfo);
                    break;
                case 82:
                    this.giftToken = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    UserInfos.PicUrl[] picUrlArr = this.headerViewPicUrl;
                    int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.headerViewPicUrl, 0, picUrlArr2, 0, length2);
                    }
                    while (length2 < picUrlArr2.length - 1) {
                        picUrlArr2[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    this.headerViewPicUrl = picUrlArr2;
                    break;
                case 96:
                    this.enableShowAttachGiftEntrance = codedInputByteBufferNano.readBool();
                    break;
                case 106:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 106);
                    LiveScoreLineChatHeadView[] liveScoreLineChatHeadViewArr = this.headViewList;
                    int length3 = liveScoreLineChatHeadViewArr == null ? 0 : liveScoreLineChatHeadViewArr.length;
                    LiveScoreLineChatHeadView[] liveScoreLineChatHeadViewArr2 = new LiveScoreLineChatHeadView[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.headViewList, 0, liveScoreLineChatHeadViewArr2, 0, length3);
                    }
                    while (length3 < liveScoreLineChatHeadViewArr2.length - 1) {
                        liveScoreLineChatHeadViewArr2[length3] = new LiveScoreLineChatHeadView();
                        codedInputByteBufferNano.readMessage(liveScoreLineChatHeadViewArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    liveScoreLineChatHeadViewArr2[length3] = new LiveScoreLineChatHeadView();
                    codedInputByteBufferNano.readMessage(liveScoreLineChatHeadViewArr2[length3]);
                    this.headViewList = liveScoreLineChatHeadViewArr2;
                    break;
                case 114:
                    if (this.topProgressBarInfo == null) {
                        this.topProgressBarInfo = new LiveScoreLineChatTopProgressBarInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.topProgressBarInfo);
                    break;
                case 122:
                    this.contributionListKrn = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    if (this.statistic == null) {
                        this.statistic = new SCLiveScoreLineChatStatistic();
                    }
                    codedInputByteBufferNano.readMessage(this.statistic);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveScoreLineChatState parseFrom(byte[] bArr) {
        return (LiveScoreLineChatState) MessageNano.mergeFrom(new LiveScoreLineChatState(), bArr);
    }

    public static LiveScoreLineChatState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatState().mergeFrom(codedInputByteBufferNano);
    }
}
