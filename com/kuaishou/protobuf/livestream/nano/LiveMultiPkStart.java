package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveShopMessages;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkStart extends MessageNano {
    private static volatile LiveMultiPkStart[] _emptyArray;
    public CohesionPkInfo cohesionPkInfo;
    public LiveMultiPkContinueInviteInfo continueInviteInfo;
    public LiveMultiPkContinuousWin continuousWin;
    public boolean disablePkNodeAnimation;
    public boolean enableAdvanceEnd;
    public boolean enableReopenMultiPk;
    public boolean enableShowContributorList;
    public boolean enableShowContributorListLite;
    public boolean enableShowMvp;
    public LiveMultiPkEndPopup endPopUp;
    public LiveMultiPkExtConfig extConfig;
    public boolean forbidPopCounterpartProfile;
    public boolean hideScoreRelatedView;
    public LiveMultiPkInitialInfo initialInfo;
    public int mode;
    public int modeV2;
    public PkAttachGiftInfo pkAttachGiftInfo;
    public String pkId;
    public int playType;
    public LiveMultiPkReopen reopen;
    public LiveMultiPkRightBottomInfo rightBottomInfo;
    public LiveMultiPkRightBottomInfo rightBottomInfoLite;
    public LiveMultiPkScoreRuleInfo scoreRuleInfo;
    public LiveShopMessages.LiveInteractiveRoomShopCartStatus shopCartStatus;
    public long startUserId;
    public int startWay;
    public LiveMultiPkTeam[] team;
    public long teamVersion;
    public LiveMultiPkTimeLine timeLine;

    public static LiveMultiPkStart[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkStart[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkStart() {
        clear();
    }

    public final LiveMultiPkStart clear() {
        this.startUserId = 0L;
        this.pkId = "";
        this.timeLine = null;
        this.playType = 0;
        this.team = LiveMultiPkTeam.emptyArray();
        this.enableAdvanceEnd = false;
        this.enableReopenMultiPk = false;
        this.mode = 0;
        this.startWay = 0;
        this.forbidPopCounterpartProfile = false;
        this.hideScoreRelatedView = false;
        this.enableShowContributorList = false;
        this.enableShowMvp = false;
        this.reopen = null;
        this.endPopUp = null;
        this.shopCartStatus = null;
        this.continuousWin = null;
        this.scoreRuleInfo = null;
        this.initialInfo = null;
        this.rightBottomInfo = null;
        this.rightBottomInfoLite = null;
        this.enableShowContributorListLite = false;
        this.disablePkNodeAnimation = false;
        this.continueInviteInfo = null;
        this.cohesionPkInfo = null;
        this.teamVersion = 0L;
        this.pkAttachGiftInfo = null;
        this.modeV2 = 0;
        this.extConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.startUserId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.pkId);
        }
        LiveMultiPkTimeLine liveMultiPkTimeLine = this.timeLine;
        if (liveMultiPkTimeLine != null) {
            codedOutputByteBufferNano.writeMessage(3, liveMultiPkTimeLine);
        }
        int i = this.playType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        LiveMultiPkTeam[] liveMultiPkTeamArr = this.team;
        if (liveMultiPkTeamArr != null && liveMultiPkTeamArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTeam[] liveMultiPkTeamArr2 = this.team;
                if (i2 >= liveMultiPkTeamArr2.length) {
                    break;
                }
                LiveMultiPkTeam liveMultiPkTeam = liveMultiPkTeamArr2[i2];
                if (liveMultiPkTeam != null) {
                    codedOutputByteBufferNano.writeMessage(5, liveMultiPkTeam);
                }
                i2++;
            }
        }
        boolean z = this.enableAdvanceEnd;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        boolean z2 = this.enableReopenMultiPk;
        if (z2) {
            codedOutputByteBufferNano.writeBool(7, z2);
        }
        int i3 = this.mode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i3);
        }
        int i4 = this.startWay;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i4);
        }
        boolean z3 = this.forbidPopCounterpartProfile;
        if (z3) {
            codedOutputByteBufferNano.writeBool(10, z3);
        }
        boolean z4 = this.hideScoreRelatedView;
        if (z4) {
            codedOutputByteBufferNano.writeBool(11, z4);
        }
        boolean z5 = this.enableShowContributorList;
        if (z5) {
            codedOutputByteBufferNano.writeBool(12, z5);
        }
        boolean z6 = this.enableShowMvp;
        if (z6) {
            codedOutputByteBufferNano.writeBool(13, z6);
        }
        LiveMultiPkReopen liveMultiPkReopen = this.reopen;
        if (liveMultiPkReopen != null) {
            codedOutputByteBufferNano.writeMessage(14, liveMultiPkReopen);
        }
        LiveMultiPkEndPopup liveMultiPkEndPopup = this.endPopUp;
        if (liveMultiPkEndPopup != null) {
            codedOutputByteBufferNano.writeMessage(15, liveMultiPkEndPopup);
        }
        LiveShopMessages.LiveInteractiveRoomShopCartStatus liveInteractiveRoomShopCartStatus = this.shopCartStatus;
        if (liveInteractiveRoomShopCartStatus != null) {
            codedOutputByteBufferNano.writeMessage(16, liveInteractiveRoomShopCartStatus);
        }
        LiveMultiPkContinuousWin liveMultiPkContinuousWin = this.continuousWin;
        if (liveMultiPkContinuousWin != null) {
            codedOutputByteBufferNano.writeMessage(17, liveMultiPkContinuousWin);
        }
        LiveMultiPkScoreRuleInfo liveMultiPkScoreRuleInfo = this.scoreRuleInfo;
        if (liveMultiPkScoreRuleInfo != null) {
            codedOutputByteBufferNano.writeMessage(18, liveMultiPkScoreRuleInfo);
        }
        LiveMultiPkInitialInfo liveMultiPkInitialInfo = this.initialInfo;
        if (liveMultiPkInitialInfo != null) {
            codedOutputByteBufferNano.writeMessage(19, liveMultiPkInitialInfo);
        }
        LiveMultiPkRightBottomInfo liveMultiPkRightBottomInfo = this.rightBottomInfo;
        if (liveMultiPkRightBottomInfo != null) {
            codedOutputByteBufferNano.writeMessage(20, liveMultiPkRightBottomInfo);
        }
        LiveMultiPkRightBottomInfo liveMultiPkRightBottomInfo2 = this.rightBottomInfoLite;
        if (liveMultiPkRightBottomInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(21, liveMultiPkRightBottomInfo2);
        }
        boolean z7 = this.enableShowContributorListLite;
        if (z7) {
            codedOutputByteBufferNano.writeBool(22, z7);
        }
        boolean z8 = this.disablePkNodeAnimation;
        if (z8) {
            codedOutputByteBufferNano.writeBool(23, z8);
        }
        LiveMultiPkContinueInviteInfo liveMultiPkContinueInviteInfo = this.continueInviteInfo;
        if (liveMultiPkContinueInviteInfo != null) {
            codedOutputByteBufferNano.writeMessage(24, liveMultiPkContinueInviteInfo);
        }
        CohesionPkInfo cohesionPkInfo = this.cohesionPkInfo;
        if (cohesionPkInfo != null) {
            codedOutputByteBufferNano.writeMessage(25, cohesionPkInfo);
        }
        long j2 = this.teamVersion;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(26, j2);
        }
        PkAttachGiftInfo pkAttachGiftInfo = this.pkAttachGiftInfo;
        if (pkAttachGiftInfo != null) {
            codedOutputByteBufferNano.writeMessage(27, pkAttachGiftInfo);
        }
        int i5 = this.modeV2;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(28, i5);
        }
        LiveMultiPkExtConfig liveMultiPkExtConfig = this.extConfig;
        if (liveMultiPkExtConfig != null) {
            codedOutputByteBufferNano.writeMessage(29, liveMultiPkExtConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.startUserId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.pkId);
        }
        LiveMultiPkTimeLine liveMultiPkTimeLine = this.timeLine;
        if (liveMultiPkTimeLine != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveMultiPkTimeLine);
        }
        int i = this.playType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        LiveMultiPkTeam[] liveMultiPkTeamArr = this.team;
        if (liveMultiPkTeamArr != null && liveMultiPkTeamArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTeam[] liveMultiPkTeamArr2 = this.team;
                if (i2 >= liveMultiPkTeamArr2.length) {
                    break;
                }
                LiveMultiPkTeam liveMultiPkTeam = liveMultiPkTeamArr2[i2];
                if (liveMultiPkTeam != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveMultiPkTeam);
                }
                i2++;
            }
        }
        boolean z = this.enableAdvanceEnd;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        boolean z2 = this.enableReopenMultiPk;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z2);
        }
        int i3 = this.mode;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i3);
        }
        int i4 = this.startWay;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i4);
        }
        boolean z3 = this.forbidPopCounterpartProfile;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z3);
        }
        boolean z4 = this.hideScoreRelatedView;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z4);
        }
        boolean z5 = this.enableShowContributorList;
        if (z5) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z5);
        }
        boolean z6 = this.enableShowMvp;
        if (z6) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(13, z6);
        }
        LiveMultiPkReopen liveMultiPkReopen = this.reopen;
        if (liveMultiPkReopen != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(14, liveMultiPkReopen);
        }
        LiveMultiPkEndPopup liveMultiPkEndPopup = this.endPopUp;
        if (liveMultiPkEndPopup != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(15, liveMultiPkEndPopup);
        }
        LiveShopMessages.LiveInteractiveRoomShopCartStatus liveInteractiveRoomShopCartStatus = this.shopCartStatus;
        if (liveInteractiveRoomShopCartStatus != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, liveInteractiveRoomShopCartStatus);
        }
        LiveMultiPkContinuousWin liveMultiPkContinuousWin = this.continuousWin;
        if (liveMultiPkContinuousWin != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, liveMultiPkContinuousWin);
        }
        LiveMultiPkScoreRuleInfo liveMultiPkScoreRuleInfo = this.scoreRuleInfo;
        if (liveMultiPkScoreRuleInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, liveMultiPkScoreRuleInfo);
        }
        LiveMultiPkInitialInfo liveMultiPkInitialInfo = this.initialInfo;
        if (liveMultiPkInitialInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, liveMultiPkInitialInfo);
        }
        LiveMultiPkRightBottomInfo liveMultiPkRightBottomInfo = this.rightBottomInfo;
        if (liveMultiPkRightBottomInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, liveMultiPkRightBottomInfo);
        }
        LiveMultiPkRightBottomInfo liveMultiPkRightBottomInfo2 = this.rightBottomInfoLite;
        if (liveMultiPkRightBottomInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, liveMultiPkRightBottomInfo2);
        }
        boolean z7 = this.enableShowContributorListLite;
        if (z7) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(22, z7);
        }
        boolean z8 = this.disablePkNodeAnimation;
        if (z8) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(23, z8);
        }
        LiveMultiPkContinueInviteInfo liveMultiPkContinueInviteInfo = this.continueInviteInfo;
        if (liveMultiPkContinueInviteInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, liveMultiPkContinueInviteInfo);
        }
        CohesionPkInfo cohesionPkInfo = this.cohesionPkInfo;
        if (cohesionPkInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, cohesionPkInfo);
        }
        long j2 = this.teamVersion;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(26, j2);
        }
        PkAttachGiftInfo pkAttachGiftInfo = this.pkAttachGiftInfo;
        if (pkAttachGiftInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, pkAttachGiftInfo);
        }
        int i5 = this.modeV2;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(28, i5);
        }
        LiveMultiPkExtConfig liveMultiPkExtConfig = this.extConfig;
        return liveMultiPkExtConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(29, liveMultiPkExtConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkStart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.startUserId = codedInputByteBufferNano.readUInt64();
                    break;
                case 18:
                    this.pkId = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    if (this.timeLine == null) {
                        this.timeLine = new LiveMultiPkTimeLine();
                    }
                    codedInputByteBufferNano.readMessage(this.timeLine);
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.playType = int32;
                        break;
                    }
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
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
                case 48:
                    this.enableAdvanceEnd = codedInputByteBufferNano.readBool();
                    break;
                case 56:
                    this.enableReopenMultiPk = codedInputByteBufferNano.readBool();
                    break;
                case 64:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3 && int322 != 4 && int322 != 5) {
                        break;
                    } else {
                        this.mode = int322;
                        break;
                    }
                case 72:
                    int int323 = codedInputByteBufferNano.readInt32();
                    switch (int323) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.startWay = int323;
                            break;
                    }
                case 80:
                    this.forbidPopCounterpartProfile = codedInputByteBufferNano.readBool();
                    break;
                case 88:
                    this.hideScoreRelatedView = codedInputByteBufferNano.readBool();
                    break;
                case 96:
                    this.enableShowContributorList = codedInputByteBufferNano.readBool();
                    break;
                case 104:
                    this.enableShowMvp = codedInputByteBufferNano.readBool();
                    break;
                case 114:
                    if (this.reopen == null) {
                        this.reopen = new LiveMultiPkReopen();
                    }
                    codedInputByteBufferNano.readMessage(this.reopen);
                    break;
                case 122:
                    if (this.endPopUp == null) {
                        this.endPopUp = new LiveMultiPkEndPopup();
                    }
                    codedInputByteBufferNano.readMessage(this.endPopUp);
                    break;
                case 130:
                    if (this.shopCartStatus == null) {
                        this.shopCartStatus = new LiveShopMessages.LiveInteractiveRoomShopCartStatus();
                    }
                    codedInputByteBufferNano.readMessage(this.shopCartStatus);
                    break;
                case 138:
                    if (this.continuousWin == null) {
                        this.continuousWin = new LiveMultiPkContinuousWin();
                    }
                    codedInputByteBufferNano.readMessage(this.continuousWin);
                    break;
                case 146:
                    if (this.scoreRuleInfo == null) {
                        this.scoreRuleInfo = new LiveMultiPkScoreRuleInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.scoreRuleInfo);
                    break;
                case 154:
                    if (this.initialInfo == null) {
                        this.initialInfo = new LiveMultiPkInitialInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.initialInfo);
                    break;
                case 162:
                    if (this.rightBottomInfo == null) {
                        this.rightBottomInfo = new LiveMultiPkRightBottomInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.rightBottomInfo);
                    break;
                case 170:
                    if (this.rightBottomInfoLite == null) {
                        this.rightBottomInfoLite = new LiveMultiPkRightBottomInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.rightBottomInfoLite);
                    break;
                case 176:
                    this.enableShowContributorListLite = codedInputByteBufferNano.readBool();
                    break;
                case 184:
                    this.disablePkNodeAnimation = codedInputByteBufferNano.readBool();
                    break;
                case 194:
                    if (this.continueInviteInfo == null) {
                        this.continueInviteInfo = new LiveMultiPkContinueInviteInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.continueInviteInfo);
                    break;
                case 202:
                    if (this.cohesionPkInfo == null) {
                        this.cohesionPkInfo = new CohesionPkInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.cohesionPkInfo);
                    break;
                case 208:
                    this.teamVersion = codedInputByteBufferNano.readUInt64();
                    break;
                case 218:
                    if (this.pkAttachGiftInfo == null) {
                        this.pkAttachGiftInfo = new PkAttachGiftInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.pkAttachGiftInfo);
                    break;
                case 224:
                    int int324 = codedInputByteBufferNano.readInt32();
                    if (int324 != 0 && int324 != 1 && int324 != 2 && int324 != 3 && int324 != 4 && int324 != 5) {
                        break;
                    } else {
                        this.modeV2 = int324;
                        break;
                    }
                case 234:
                    if (this.extConfig == null) {
                        this.extConfig = new LiveMultiPkExtConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.extConfig);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveMultiPkStart parseFrom(byte[] bArr) {
        return (LiveMultiPkStart) MessageNano.mergeFrom(new LiveMultiPkStart(), bArr);
    }

    public static LiveMultiPkStart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkStart().mergeFrom(codedInputByteBufferNano);
    }
}
