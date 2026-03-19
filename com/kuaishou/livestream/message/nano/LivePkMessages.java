package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.ChatWishList;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePkMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface LivePkClientSource {
        public static final int BOTTOM_GUIDE_RANDOM_MATCH_TIP = 18;
        public static final int COMMENT_AREA_RANDOM_MATCH_TIP = 19;
        public static final int FRIEND_RESERVATION_COMMENT_NOTICE = 16;
        public static final int GLOBAL_PK_RECO_INVITE_COMMENT_NOTICE_V1 = 7;
        public static final int GLOBAL_PK_RECO_INVITE_COMMENT_NOTICE_V2 = 9;
        public static final int GLOBAL_PK_RECO_INVITE_GUIDE_POPUP_V1 = 8;
        public static final int GLOBAL_PK_RECO_INVITE_GUIDE_POPUP_V2 = 10;
        public static final int HOUR_DISTRICT_RANK_PAGE = 15;
        public static final int LINE_PANEL = 24;
        public static final int MULTI_LINE_PANEL = 22;
        public static final int OPERATION_PANEL_REMATCH_OTHERS = 20;
        public static final int OPERATION_PANEL_REOPEN = 21;
        public static final int PK_FRIEND_LIST_RESERVATION = 28;
        public static final int PK_MULTI_LIVE_GUIDE = 27;
        public static final int PK_PANEL = 14;
        public static final int PK_RANDOM_MATCH_INTERACTIVE_GUIDE = 26;
        public static final int PK_RANDOM_MATCH_INVITE = 25;
        public static final int PK_SELLING_PANEL = 23;
        public static final int RANDOM_MATCH_SOURCE_PK_AUTO_MATCH_AGAIN = 12;
        public static final int RANDOM_MATCH_SOURCE_PK_ENDED_IN_ADVANCE_PANEL = 11;
        public static final int RANDOM_MATCH_SOURCE_PK_END_DIALOG_BUTTON_CLICK = 5;
        public static final int RANDOM_MATCH_SOURCE_PK_END_PANEL = 6;
        public static final int RANDOM_MATCH_SOURCE_PK_END_VIEW_BUTTON_CLICK = 2;
        public static final int RANDOM_MATCH_SOURCE_PK_END_VIEW_TIMEOUT_AUTO_MATCH = 3;
        public static final int RANDOM_MATCH_SOURCE_PK_INVITE_PANEL = 1;
        public static final int RANDOM_MATCH_SOURCE_PK_PLAY_AGAIN_FAIL_AUTO_MATCH = 4;
        public static final int SEASON_GAME_PK_RANDOM_MATCH_KRN = 13;
        public static final int UNKNOWN_PK_CLIENT_SOURCE = 0;
        public static final int VOICE_ROBOT = 17;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PkFormatType {
        public static final int UNKNOWN_FORMAT_TYPE = 0;
        public static final int WIN_THREE_OUT_OF_FIVE = 2;
        public static final int WIN_TWO_OUT_OF_THREE = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PkReopenType {
        public static final int COMMON_PK_REOPEN_TYPE = 1;
        public static final int PK_COHESION = 3;
        public static final int PK_REVENGE = 2;
        public static final int UNKNOWN_PK_REOPEN_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PkType {
        public static final int COHESION = 9;
        public static final int INVITE = 1;
        public static final int MATCH = 2;
        public static final int MULTI_INVITE = 6;
        public static final int PK_SELLING_CPS = 8;
        public static final int RANK_GAME = 5;
        public static final int REOPEN = 3;
        public static final int REVENGE = 7;
        public static final int ROUND_FORMAT = 4;
        public static final int UNKNOWN_PK_TYPE = 0;
    }

    public static final class PkTopScoreUserDetailInfo extends MessageNano {
        private static volatile PkTopScoreUserDetailInfo[] _emptyArray;
        public UserInfos.UserInfo userInfo;

        public static PkTopScoreUserDetailInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PkTopScoreUserDetailInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PkTopScoreUserDetailInfo() {
            clear();
        }

        public final PkTopScoreUserDetailInfo clear() {
            this.userInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.userInfo;
            return userInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, userInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PkTopScoreUserDetailInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.userInfo == null) {
                        this.userInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfo);
                }
            }
        }

        public static PkTopScoreUserDetailInfo parseFrom(byte[] bArr) {
            return (PkTopScoreUserDetailInfo) MessageNano.mergeFrom(new PkTopScoreUserDetailInfo(), bArr);
        }

        public static PkTopScoreUserDetailInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PkTopScoreUserDetailInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class PkTopScoreUser extends MessageNano {
        private static volatile PkTopScoreUser[] _emptyArray;
        public long authorId;
        public PkTopScoreUserDetailInfo[] detailInfo;

        public static PkTopScoreUser[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PkTopScoreUser[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PkTopScoreUser() {
            clear();
        }

        public final PkTopScoreUser clear() {
            this.authorId = 0L;
            this.detailInfo = PkTopScoreUserDetailInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.authorId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr = this.detailInfo;
            if (pkTopScoreUserDetailInfoArr != null && pkTopScoreUserDetailInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr2 = this.detailInfo;
                    if (i >= pkTopScoreUserDetailInfoArr2.length) {
                        break;
                    }
                    PkTopScoreUserDetailInfo pkTopScoreUserDetailInfo = pkTopScoreUserDetailInfoArr2[i];
                    if (pkTopScoreUserDetailInfo != null) {
                        codedOutputByteBufferNano.writeMessage(2, pkTopScoreUserDetailInfo);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.authorId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr = this.detailInfo;
            if (pkTopScoreUserDetailInfoArr != null && pkTopScoreUserDetailInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr2 = this.detailInfo;
                    if (i >= pkTopScoreUserDetailInfoArr2.length) {
                        break;
                    }
                    PkTopScoreUserDetailInfo pkTopScoreUserDetailInfo = pkTopScoreUserDetailInfoArr2[i];
                    if (pkTopScoreUserDetailInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pkTopScoreUserDetailInfo);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PkTopScoreUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.authorId = codedInputByteBufferNano.readUInt64();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr = this.detailInfo;
                    int length = pkTopScoreUserDetailInfoArr == null ? 0 : pkTopScoreUserDetailInfoArr.length;
                    PkTopScoreUserDetailInfo[] pkTopScoreUserDetailInfoArr2 = new PkTopScoreUserDetailInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.detailInfo, 0, pkTopScoreUserDetailInfoArr2, 0, length);
                    }
                    while (length < pkTopScoreUserDetailInfoArr2.length - 1) {
                        pkTopScoreUserDetailInfoArr2[length] = new PkTopScoreUserDetailInfo();
                        codedInputByteBufferNano.readMessage(pkTopScoreUserDetailInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    pkTopScoreUserDetailInfoArr2[length] = new PkTopScoreUserDetailInfo();
                    codedInputByteBufferNano.readMessage(pkTopScoreUserDetailInfoArr2[length]);
                    this.detailInfo = pkTopScoreUserDetailInfoArr2;
                }
            }
        }

        public static PkTopScoreUser parseFrom(byte[] bArr) {
            return (PkTopScoreUser) MessageNano.mergeFrom(new PkTopScoreUser(), bArr);
        }

        public static PkTopScoreUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PkTopScoreUser().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class PkPlayerRoundStatistic extends MessageNano {
        private static volatile PkPlayerRoundStatistic[] _emptyArray;
        public int roundIndex;
        public long roundScore;

        public static PkPlayerRoundStatistic[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PkPlayerRoundStatistic[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PkPlayerRoundStatistic() {
            clear();
        }

        public final PkPlayerRoundStatistic clear() {
            this.roundScore = 0L;
            this.roundIndex = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.roundScore;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.roundIndex;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.roundScore;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.roundIndex;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PkPlayerRoundStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.roundScore = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.roundIndex = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static PkPlayerRoundStatistic parseFrom(byte[] bArr) {
            return (PkPlayerRoundStatistic) MessageNano.mergeFrom(new PkPlayerRoundStatistic(), bArr);
        }

        public static PkPlayerRoundStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PkPlayerRoundStatistic().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class PkRoundInfo extends MessageNano {
        private static volatile PkRoundInfo[] _emptyArray;
        public int formatType;
        public long roundDuration;
        public int roundIndex;
        public long voteDeadline;

        public static PkRoundInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PkRoundInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PkRoundInfo() {
            clear();
        }

        public final PkRoundInfo clear() {
            this.voteDeadline = 0L;
            this.roundIndex = 0;
            this.roundDuration = 0L;
            this.formatType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.voteDeadline;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            int i = this.roundIndex;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            long j2 = this.roundDuration;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i2 = this.formatType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(4, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.voteDeadline;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            int i = this.roundIndex;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            long j2 = this.roundDuration;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i2 = this.formatType;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PkRoundInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.voteDeadline = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.roundIndex = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.roundDuration = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.formatType = int32;
                    }
                }
            }
        }

        public static PkRoundInfo parseFrom(byte[] bArr) {
            return (PkRoundInfo) MessageNano.mergeFrom(new PkRoundInfo(), bArr);
        }

        public static PkRoundInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PkRoundInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LivePkGiftCritMoment extends MessageNano {
        private static volatile LivePkGiftCritMoment[] _emptyArray;
        public UserInfos.PicUrl[] countdownRuleHintPic;
        public long endTime;
        public String pkId;
        public long startTime;

        public static LivePkGiftCritMoment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LivePkGiftCritMoment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LivePkGiftCritMoment() {
            clear();
        }

        public final LivePkGiftCritMoment clear() {
            this.pkId = "";
            this.startTime = 0L;
            this.endTime = 0L;
            this.countdownRuleHintPic = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pkId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pkId);
            }
            long j = this.startTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            UserInfos.PicUrl[] picUrlArr = this.countdownRuleHintPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.countdownRuleHintPic;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, picUrl);
                    }
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
            long j = this.startTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            UserInfos.PicUrl[] picUrlArr = this.countdownRuleHintPic;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.countdownRuleHintPic;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LivePkGiftCritMoment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.pkId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.endTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    UserInfos.PicUrl[] picUrlArr = this.countdownRuleHintPic;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.countdownRuleHintPic, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.countdownRuleHintPic = picUrlArr2;
                }
            }
        }

        public static LivePkGiftCritMoment parseFrom(byte[] bArr) {
            return (LivePkGiftCritMoment) MessageNano.mergeFrom(new LivePkGiftCritMoment(), bArr);
        }

        public static LivePkGiftCritMoment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LivePkGiftCritMoment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCPkReopenInvite extends MessageNano {
        public static final int COHESION_GAME_INFO_FIELD_NUMBER = 9;
        private static volatile SCPkReopenInvite[] _emptyArray;
        public String acceptButtonText;
        public String noticeSubtitle;
        public String noticeTitle;
        public String pkId;
        public int reopenSource;
        public int reopenType;
        private int reopenTypeInfoCase_ = 0;
        private Object reopenTypeInfo_;
        public long timeoutMillis;
        public long waitReopenInfoTimeoutMillis;

        public final int getReopenTypeInfoCase() {
            return this.reopenTypeInfoCase_;
        }

        public final SCPkReopenInvite clearReopenTypeInfo() {
            this.reopenTypeInfoCase_ = 0;
            this.reopenTypeInfo_ = null;
            return this;
        }

        public static SCPkReopenInvite[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCPkReopenInvite[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasCohesionGameInfo() {
            return this.reopenTypeInfoCase_ == 9;
        }

        public final CohesionGameReopenInfo getCohesionGameInfo() {
            if (this.reopenTypeInfoCase_ == 9) {
                return (CohesionGameReopenInfo) this.reopenTypeInfo_;
            }
            return null;
        }

        public final SCPkReopenInvite setCohesionGameInfo(CohesionGameReopenInfo cohesionGameReopenInfo) {
            if (cohesionGameReopenInfo == null) {
                throw new NullPointerException();
            }
            this.reopenTypeInfoCase_ = 9;
            this.reopenTypeInfo_ = cohesionGameReopenInfo;
            return this;
        }

        public SCPkReopenInvite() {
            clear();
        }

        public final SCPkReopenInvite clear() {
            this.pkId = "";
            this.reopenSource = 0;
            this.timeoutMillis = 0L;
            this.waitReopenInfoTimeoutMillis = 0L;
            this.noticeTitle = "";
            this.noticeSubtitle = "";
            this.acceptButtonText = "";
            this.reopenType = 0;
            clearReopenTypeInfo();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pkId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pkId);
            }
            int i = this.reopenSource;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            long j = this.timeoutMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.waitReopenInfoTimeoutMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            if (!this.noticeTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.noticeTitle);
            }
            if (!this.noticeSubtitle.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.noticeSubtitle);
            }
            if (!this.acceptButtonText.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.acceptButtonText);
            }
            int i2 = this.reopenType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(8, i2);
            }
            if (this.reopenTypeInfoCase_ == 9) {
                codedOutputByteBufferNano.writeMessage(9, (MessageNano) this.reopenTypeInfo_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.pkId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
            }
            int i = this.reopenSource;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            long j = this.timeoutMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.waitReopenInfoTimeoutMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            if (!this.noticeTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.noticeTitle);
            }
            if (!this.noticeSubtitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.noticeSubtitle);
            }
            if (!this.acceptButtonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.acceptButtonText);
            }
            int i2 = this.reopenType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i2);
            }
            return this.reopenTypeInfoCase_ == 9 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, (MessageNano) this.reopenTypeInfo_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCPkReopenInvite mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.pkId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.reopenSource = codedInputByteBufferNano.readInt32();
                } else if (tag == 24) {
                    this.timeoutMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.waitReopenInfoTimeoutMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    this.noticeTitle = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.noticeSubtitle = codedInputByteBufferNano.readString();
                } else if (tag == 58) {
                    this.acceptButtonText = codedInputByteBufferNano.readString();
                } else if (tag == 64) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                        this.reopenType = int32;
                    }
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.reopenTypeInfoCase_ != 9) {
                        this.reopenTypeInfo_ = new CohesionGameReopenInfo();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.reopenTypeInfo_);
                    this.reopenTypeInfoCase_ = 9;
                }
            }
        }

        public static SCPkReopenInvite parseFrom(byte[] bArr) {
            return (SCPkReopenInvite) MessageNano.mergeFrom(new SCPkReopenInvite(), bArr);
        }

        public static SCPkReopenInvite parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCPkReopenInvite().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CohesionGameReopenInfo extends MessageNano {
        private static volatile CohesionGameReopenInfo[] _emptyArray;
        public String descTextPrefix;
        public String descTextSpecial;
        public String descTextSuffix;
        public GiftView[] gift;
        public String inviteRoute;

        public static CohesionGameReopenInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CohesionGameReopenInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CohesionGameReopenInfo() {
            clear();
        }

        public final CohesionGameReopenInfo clear() {
            this.gift = GiftView.emptyArray();
            this.descTextPrefix = "";
            this.descTextSpecial = "";
            this.descTextSuffix = "";
            this.inviteRoute = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            GiftView[] giftViewArr = this.gift;
            if (giftViewArr != null && giftViewArr.length > 0) {
                int i = 0;
                while (true) {
                    GiftView[] giftViewArr2 = this.gift;
                    if (i >= giftViewArr2.length) {
                        break;
                    }
                    GiftView giftView = giftViewArr2[i];
                    if (giftView != null) {
                        codedOutputByteBufferNano.writeMessage(1, giftView);
                    }
                    i++;
                }
            }
            if (!this.descTextPrefix.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.descTextPrefix);
            }
            if (!this.descTextSpecial.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.descTextSpecial);
            }
            if (!this.descTextSuffix.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.descTextSuffix);
            }
            if (!this.inviteRoute.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.inviteRoute);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            GiftView[] giftViewArr = this.gift;
            if (giftViewArr != null && giftViewArr.length > 0) {
                int i = 0;
                while (true) {
                    GiftView[] giftViewArr2 = this.gift;
                    if (i >= giftViewArr2.length) {
                        break;
                    }
                    GiftView giftView = giftViewArr2[i];
                    if (giftView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, giftView);
                    }
                    i++;
                }
            }
            if (!this.descTextPrefix.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.descTextPrefix);
            }
            if (!this.descTextSpecial.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.descTextSpecial);
            }
            if (!this.descTextSuffix.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.descTextSuffix);
            }
            return !this.inviteRoute.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.inviteRoute) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CohesionGameReopenInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    GiftView[] giftViewArr = this.gift;
                    int length = giftViewArr == null ? 0 : giftViewArr.length;
                    GiftView[] giftViewArr2 = new GiftView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.gift, 0, giftViewArr2, 0, length);
                    }
                    while (length < giftViewArr2.length - 1) {
                        giftViewArr2[length] = new GiftView();
                        codedInputByteBufferNano.readMessage(giftViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    giftViewArr2[length] = new GiftView();
                    codedInputByteBufferNano.readMessage(giftViewArr2[length]);
                    this.gift = giftViewArr2;
                } else if (tag == 18) {
                    this.descTextPrefix = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.descTextSpecial = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.descTextSuffix = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.inviteRoute = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CohesionGameReopenInfo parseFrom(byte[] bArr) {
            return (CohesionGameReopenInfo) MessageNano.mergeFrom(new CohesionGameReopenInfo(), bArr);
        }

        public static CohesionGameReopenInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CohesionGameReopenInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class GiftView extends MessageNano {
        private static volatile GiftView[] _emptyArray;
        public int id;
        public String name;
        public LiveCdnNodeView[] pic;
        public int unitPrice;

        public static GiftView[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GiftView[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GiftView() {
            clear();
        }

        public final GiftView clear() {
            this.id = 0;
            this.name = "";
            this.unitPrice = 0;
            this.pic = LiveCdnNodeView.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.id;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.name.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.name);
            }
            int i2 = this.unitPrice;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.pic;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i3 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.pic;
                    if (i3 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(4, liveCdnNodeView);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.id;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.name.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.name);
            }
            int i2 = this.unitPrice;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.pic;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i3 = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.pic;
                    if (i3 >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveCdnNodeView);
                    }
                    i3++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final GiftView mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.unitPrice = codedInputByteBufferNano.readUInt32();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.pic;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.pic, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.pic = liveCdnNodeViewArr2;
                }
            }
        }

        public static GiftView parseFrom(byte[] bArr) {
            return (GiftView) MessageNano.mergeFrom(new GiftView(), bArr);
        }

        public static GiftView parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new GiftView().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCPkReopenRespond extends MessageNano {
        private static volatile SCPkReopenRespond[] _emptyArray;
        public String pkId;
        public int status;
        public String tip;

        @Retention(RetentionPolicy.SOURCE)
        public @interface ReopenRespondStatus {
            public static final int REJECT = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCPkReopenRespond[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCPkReopenRespond[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCPkReopenRespond() {
            clear();
        }

        public final SCPkReopenRespond clear() {
            this.pkId = "";
            this.status = 0;
            this.tip = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pkId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pkId);
            }
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            if (!this.tip.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.tip);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.pkId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
            }
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            return !this.tip.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.tip) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCPkReopenRespond mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.pkId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.status = int32;
                    }
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.tip = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCPkReopenRespond parseFrom(byte[] bArr) {
            return (SCPkReopenRespond) MessageNano.mergeFrom(new SCPkReopenRespond(), bArr);
        }

        public static SCPkReopenRespond parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCPkReopenRespond().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCPkReopenInfo extends MessageNano {
        private static volatile SCPkReopenInfo[] _emptyArray;
        public String pkId;

        public static SCPkReopenInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCPkReopenInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCPkReopenInfo() {
            clear();
        }

        public final SCPkReopenInfo clear() {
            this.pkId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pkId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pkId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.pkId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.pkId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCPkReopenInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 10) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.pkId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCPkReopenInfo parseFrom(byte[] bArr) {
            return (SCPkReopenInfo) MessageNano.mergeFrom(new SCPkReopenInfo(), bArr);
        }

        public static SCPkReopenInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCPkReopenInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLivePkCohesionGiftSendCompletionNotice extends MessageNano {
        private static volatile SCLivePkCohesionGiftSendCompletionNotice[] _emptyArray;
        public long authorId;
        public int giftId;
        public String pkId;
        public long timestamp;
        public long userId;

        public static SCLivePkCohesionGiftSendCompletionNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLivePkCohesionGiftSendCompletionNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLivePkCohesionGiftSendCompletionNotice() {
            clear();
        }

        public final SCLivePkCohesionGiftSendCompletionNotice clear() {
            this.pkId = "";
            this.authorId = 0L;
            this.userId = 0L;
            this.giftId = 0;
            this.timestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pkId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pkId);
            }
            long j = this.authorId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.userId;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            int i = this.giftId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i);
            }
            long j3 = this.timestamp;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.pkId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
            }
            long j = this.authorId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.userId;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            int i = this.giftId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
            }
            long j3 = this.timestamp;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLivePkCohesionGiftSendCompletionNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.pkId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.authorId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.userId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.giftId = codedInputByteBufferNano.readUInt32();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLivePkCohesionGiftSendCompletionNotice parseFrom(byte[] bArr) {
            return (SCLivePkCohesionGiftSendCompletionNotice) MessageNano.mergeFrom(new SCLivePkCohesionGiftSendCompletionNotice(), bArr);
        }

        public static SCLivePkCohesionGiftSendCompletionNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLivePkCohesionGiftSendCompletionNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLivePkState extends MessageNano {
        private static volatile SCLivePkState[] _emptyArray;
        public String pkId;
        public PkPlayerState[] playerState;

        public static SCLivePkState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLivePkState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLivePkState() {
            clear();
        }

        public final SCLivePkState clear() {
            this.pkId = "";
            this.playerState = PkPlayerState.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.pkId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.pkId);
            }
            PkPlayerState[] pkPlayerStateArr = this.playerState;
            if (pkPlayerStateArr != null && pkPlayerStateArr.length > 0) {
                int i = 0;
                while (true) {
                    PkPlayerState[] pkPlayerStateArr2 = this.playerState;
                    if (i >= pkPlayerStateArr2.length) {
                        break;
                    }
                    PkPlayerState pkPlayerState = pkPlayerStateArr2[i];
                    if (pkPlayerState != null) {
                        codedOutputByteBufferNano.writeMessage(2, pkPlayerState);
                    }
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
            PkPlayerState[] pkPlayerStateArr = this.playerState;
            if (pkPlayerStateArr != null && pkPlayerStateArr.length > 0) {
                int i = 0;
                while (true) {
                    PkPlayerState[] pkPlayerStateArr2 = this.playerState;
                    if (i >= pkPlayerStateArr2.length) {
                        break;
                    }
                    PkPlayerState pkPlayerState = pkPlayerStateArr2[i];
                    if (pkPlayerState != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, pkPlayerState);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLivePkState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.pkId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    PkPlayerState[] pkPlayerStateArr = this.playerState;
                    int length = pkPlayerStateArr == null ? 0 : pkPlayerStateArr.length;
                    PkPlayerState[] pkPlayerStateArr2 = new PkPlayerState[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.playerState, 0, pkPlayerStateArr2, 0, length);
                    }
                    while (length < pkPlayerStateArr2.length - 1) {
                        pkPlayerStateArr2[length] = new PkPlayerState();
                        codedInputByteBufferNano.readMessage(pkPlayerStateArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    pkPlayerStateArr2[length] = new PkPlayerState();
                    codedInputByteBufferNano.readMessage(pkPlayerStateArr2[length]);
                    this.playerState = pkPlayerStateArr2;
                }
            }
        }

        public static SCLivePkState parseFrom(byte[] bArr) {
            return (SCLivePkState) MessageNano.mergeFrom(new SCLivePkState(), bArr);
        }

        public static SCLivePkState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLivePkState().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class PkPlayerState extends MessageNano {
        private static volatile PkPlayerState[] _emptyArray;
        public ChatWishList chatWishList;
        public boolean openWishList;
        public long playerId;

        public static PkPlayerState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PkPlayerState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PkPlayerState() {
            clear();
        }

        public final PkPlayerState clear() {
            this.playerId = 0L;
            this.openWishList = false;
            this.chatWishList = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.playerId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            boolean z = this.openWishList;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            ChatWishList chatWishList = this.chatWishList;
            if (chatWishList != null) {
                codedOutputByteBufferNano.writeMessage(3, chatWishList);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.playerId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            boolean z = this.openWishList;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            ChatWishList chatWishList = this.chatWishList;
            return chatWishList != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, chatWishList) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PkPlayerState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.playerId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.openWishList = codedInputByteBufferNano.readBool();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.chatWishList == null) {
                        this.chatWishList = new ChatWishList();
                    }
                    codedInputByteBufferNano.readMessage(this.chatWishList);
                }
            }
        }

        public static PkPlayerState parseFrom(byte[] bArr) {
            return (PkPlayerState) MessageNano.mergeFrom(new PkPlayerState(), bArr);
        }

        public static PkPlayerState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PkPlayerState().mergeFrom(codedInputByteBufferNano);
        }
    }
}
