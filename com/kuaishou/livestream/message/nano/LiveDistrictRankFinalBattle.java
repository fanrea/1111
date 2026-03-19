package com.kuaishou.livestream.message.nano;

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
public interface LiveDistrictRankFinalBattle {

    public static final class SCLiveBattlePopularityRank extends MessageNano {
        private static volatile SCLiveBattlePopularityRank[] _emptyArray;
        public long battleDistrictRankEndTime;
        public BattleDistrictRankFold battleDistrictRankFold;
        public BattleDistrictRankUnfold battleDistrictRankUnfold;
        public long nextUnfoldTime;
        public int popularityRankType;
        public boolean shouldClose;
        public long unfoldDuration;
        public long unfoldInterval;
        public String waitCountDownColor;
        public ContentWithStyle waitCountDownText;
        public ContentWithStyle waitDescribeText;
        public long waitDisplayEndDurationMs;
        public long waitEndTimestamp;
        public ContentWithStyle waitRemindText;

        public static SCLiveBattlePopularityRank[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBattlePopularityRank[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBattlePopularityRank() {
            clear();
        }

        public final SCLiveBattlePopularityRank clear() {
            this.battleDistrictRankEndTime = 0L;
            this.battleDistrictRankFold = null;
            this.battleDistrictRankUnfold = null;
            this.nextUnfoldTime = 0L;
            this.unfoldDuration = 0L;
            this.popularityRankType = 0;
            this.unfoldInterval = 0L;
            this.waitEndTimestamp = 0L;
            this.waitDescribeText = null;
            this.waitCountDownText = null;
            this.waitRemindText = null;
            this.waitDisplayEndDurationMs = 0L;
            this.waitCountDownColor = "";
            this.shouldClose = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.battleDistrictRankEndTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(1, j);
            }
            BattleDistrictRankFold battleDistrictRankFold = this.battleDistrictRankFold;
            if (battleDistrictRankFold != null) {
                codedOutputByteBufferNano.writeMessage(2, battleDistrictRankFold);
            }
            BattleDistrictRankUnfold battleDistrictRankUnfold = this.battleDistrictRankUnfold;
            if (battleDistrictRankUnfold != null) {
                codedOutputByteBufferNano.writeMessage(3, battleDistrictRankUnfold);
            }
            long j2 = this.nextUnfoldTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeInt64(4, j2);
            }
            long j3 = this.unfoldDuration;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeInt64(5, j3);
            }
            int i = this.popularityRankType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i);
            }
            long j4 = this.unfoldInterval;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeInt64(7, j4);
            }
            long j5 = this.waitEndTimestamp;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeInt64(8, j5);
            }
            ContentWithStyle contentWithStyle = this.waitDescribeText;
            if (contentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(9, contentWithStyle);
            }
            ContentWithStyle contentWithStyle2 = this.waitCountDownText;
            if (contentWithStyle2 != null) {
                codedOutputByteBufferNano.writeMessage(10, contentWithStyle2);
            }
            ContentWithStyle contentWithStyle3 = this.waitRemindText;
            if (contentWithStyle3 != null) {
                codedOutputByteBufferNano.writeMessage(11, contentWithStyle3);
            }
            long j6 = this.waitDisplayEndDurationMs;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeInt64(12, j6);
            }
            if (!this.waitCountDownColor.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.waitCountDownColor);
            }
            boolean z = this.shouldClose;
            if (z) {
                codedOutputByteBufferNano.writeBool(14, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.battleDistrictRankEndTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
            }
            BattleDistrictRankFold battleDistrictRankFold = this.battleDistrictRankFold;
            if (battleDistrictRankFold != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, battleDistrictRankFold);
            }
            BattleDistrictRankUnfold battleDistrictRankUnfold = this.battleDistrictRankUnfold;
            if (battleDistrictRankUnfold != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, battleDistrictRankUnfold);
            }
            long j2 = this.nextUnfoldTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j2);
            }
            long j3 = this.unfoldDuration;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
            }
            int i = this.popularityRankType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i);
            }
            long j4 = this.unfoldInterval;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j4);
            }
            long j5 = this.waitEndTimestamp;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j5);
            }
            ContentWithStyle contentWithStyle = this.waitDescribeText;
            if (contentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, contentWithStyle);
            }
            ContentWithStyle contentWithStyle2 = this.waitCountDownText;
            if (contentWithStyle2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, contentWithStyle2);
            }
            ContentWithStyle contentWithStyle3 = this.waitRemindText;
            if (contentWithStyle3 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, contentWithStyle3);
            }
            long j6 = this.waitDisplayEndDurationMs;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(12, j6);
            }
            if (!this.waitCountDownColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.waitCountDownColor);
            }
            boolean z = this.shouldClose;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(14, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBattlePopularityRank mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.battleDistrictRankEndTime = codedInputByteBufferNano.readInt64();
                        break;
                    case 18:
                        if (this.battleDistrictRankFold == null) {
                            this.battleDistrictRankFold = new BattleDistrictRankFold();
                        }
                        codedInputByteBufferNano.readMessage(this.battleDistrictRankFold);
                        break;
                    case 26:
                        if (this.battleDistrictRankUnfold == null) {
                            this.battleDistrictRankUnfold = new BattleDistrictRankUnfold();
                        }
                        codedInputByteBufferNano.readMessage(this.battleDistrictRankUnfold);
                        break;
                    case 32:
                        this.nextUnfoldTime = codedInputByteBufferNano.readInt64();
                        break;
                    case 40:
                        this.unfoldDuration = codedInputByteBufferNano.readInt64();
                        break;
                    case 48:
                        this.popularityRankType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 56:
                        this.unfoldInterval = codedInputByteBufferNano.readInt64();
                        break;
                    case 64:
                        this.waitEndTimestamp = codedInputByteBufferNano.readInt64();
                        break;
                    case 74:
                        if (this.waitDescribeText == null) {
                            this.waitDescribeText = new ContentWithStyle();
                        }
                        codedInputByteBufferNano.readMessage(this.waitDescribeText);
                        break;
                    case 82:
                        if (this.waitCountDownText == null) {
                            this.waitCountDownText = new ContentWithStyle();
                        }
                        codedInputByteBufferNano.readMessage(this.waitCountDownText);
                        break;
                    case 90:
                        if (this.waitRemindText == null) {
                            this.waitRemindText = new ContentWithStyle();
                        }
                        codedInputByteBufferNano.readMessage(this.waitRemindText);
                        break;
                    case 96:
                        this.waitDisplayEndDurationMs = codedInputByteBufferNano.readInt64();
                        break;
                    case 106:
                        this.waitCountDownColor = codedInputByteBufferNano.readString();
                        break;
                    case 112:
                        this.shouldClose = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveBattlePopularityRank parseFrom(byte[] bArr) {
            return (SCLiveBattlePopularityRank) MessageNano.mergeFrom(new SCLiveBattlePopularityRank(), bArr);
        }

        public static SCLiveBattlePopularityRank parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBattlePopularityRank().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBattleDistrictRank extends MessageNano {
        private static volatile SCLiveBattleDistrictRank[] _emptyArray;
        public long battleDistrictRankEndTime;
        public BattleDistrictRankFold battleDistrictRankFold;
        public BattleDistrictRankUnfold battleDistrictRankUnfold;
        public int jumpToSubTabId;
        public int jumpToTabId;
        public long nextUnfoldTime;
        public int rankRegionType;
        public boolean shouldClose;
        public long unfoldDuration;
        public long unfoldInterval;
        public String waitCountDownColor;
        public ContentWithStyle waitCountDownText;
        public ContentWithStyle waitDescribeText;
        public long waitDisplayEndDurationMs;
        public long waitEndTimestamp;
        public ContentWithStyle waitRemindText;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RankRegionType {
            public static final int CITY_RANK = 3;
            public static final int DISTRICT_RANK = 2;
            public static final int GLOBAL_RANK = 1;
            public static final int JUMP_BY_TAB_ID = 4;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveBattleDistrictRank[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBattleDistrictRank[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBattleDistrictRank() {
            clear();
        }

        public final SCLiveBattleDistrictRank clear() {
            this.battleDistrictRankEndTime = 0L;
            this.battleDistrictRankFold = null;
            this.battleDistrictRankUnfold = null;
            this.nextUnfoldTime = 0L;
            this.unfoldDuration = 0L;
            this.rankRegionType = 0;
            this.unfoldInterval = 0L;
            this.waitEndTimestamp = 0L;
            this.waitDescribeText = null;
            this.waitCountDownText = null;
            this.waitRemindText = null;
            this.waitDisplayEndDurationMs = 0L;
            this.waitCountDownColor = "";
            this.shouldClose = false;
            this.jumpToTabId = 0;
            this.jumpToSubTabId = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.battleDistrictRankEndTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(1, j);
            }
            BattleDistrictRankFold battleDistrictRankFold = this.battleDistrictRankFold;
            if (battleDistrictRankFold != null) {
                codedOutputByteBufferNano.writeMessage(2, battleDistrictRankFold);
            }
            BattleDistrictRankUnfold battleDistrictRankUnfold = this.battleDistrictRankUnfold;
            if (battleDistrictRankUnfold != null) {
                codedOutputByteBufferNano.writeMessage(3, battleDistrictRankUnfold);
            }
            long j2 = this.nextUnfoldTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeInt64(4, j2);
            }
            long j3 = this.unfoldDuration;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeInt64(5, j3);
            }
            int i = this.rankRegionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(6, i);
            }
            long j4 = this.unfoldInterval;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeInt64(7, j4);
            }
            long j5 = this.waitEndTimestamp;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeInt64(8, j5);
            }
            ContentWithStyle contentWithStyle = this.waitDescribeText;
            if (contentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(9, contentWithStyle);
            }
            ContentWithStyle contentWithStyle2 = this.waitCountDownText;
            if (contentWithStyle2 != null) {
                codedOutputByteBufferNano.writeMessage(10, contentWithStyle2);
            }
            ContentWithStyle contentWithStyle3 = this.waitRemindText;
            if (contentWithStyle3 != null) {
                codedOutputByteBufferNano.writeMessage(11, contentWithStyle3);
            }
            long j6 = this.waitDisplayEndDurationMs;
            if (j6 != 0) {
                codedOutputByteBufferNano.writeInt64(12, j6);
            }
            if (!this.waitCountDownColor.equals("")) {
                codedOutputByteBufferNano.writeString(13, this.waitCountDownColor);
            }
            boolean z = this.shouldClose;
            if (z) {
                codedOutputByteBufferNano.writeBool(14, z);
            }
            int i2 = this.jumpToTabId;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(15, i2);
            }
            int i3 = this.jumpToSubTabId;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(16, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.battleDistrictRankEndTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
            }
            BattleDistrictRankFold battleDistrictRankFold = this.battleDistrictRankFold;
            if (battleDistrictRankFold != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, battleDistrictRankFold);
            }
            BattleDistrictRankUnfold battleDistrictRankUnfold = this.battleDistrictRankUnfold;
            if (battleDistrictRankUnfold != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, battleDistrictRankUnfold);
            }
            long j2 = this.nextUnfoldTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j2);
            }
            long j3 = this.unfoldDuration;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(5, j3);
            }
            int i = this.rankRegionType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i);
            }
            long j4 = this.unfoldInterval;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(7, j4);
            }
            long j5 = this.waitEndTimestamp;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(8, j5);
            }
            ContentWithStyle contentWithStyle = this.waitDescribeText;
            if (contentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, contentWithStyle);
            }
            ContentWithStyle contentWithStyle2 = this.waitCountDownText;
            if (contentWithStyle2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, contentWithStyle2);
            }
            ContentWithStyle contentWithStyle3 = this.waitRemindText;
            if (contentWithStyle3 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, contentWithStyle3);
            }
            long j6 = this.waitDisplayEndDurationMs;
            if (j6 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(12, j6);
            }
            if (!this.waitCountDownColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(13, this.waitCountDownColor);
            }
            boolean z = this.shouldClose;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(14, z);
            }
            int i2 = this.jumpToTabId;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(15, i2);
            }
            int i3 = this.jumpToSubTabId;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(16, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBattleDistrictRank mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 8:
                        this.battleDistrictRankEndTime = codedInputByteBufferNano.readInt64();
                        break;
                    case 18:
                        if (this.battleDistrictRankFold == null) {
                            this.battleDistrictRankFold = new BattleDistrictRankFold();
                        }
                        codedInputByteBufferNano.readMessage(this.battleDistrictRankFold);
                        break;
                    case 26:
                        if (this.battleDistrictRankUnfold == null) {
                            this.battleDistrictRankUnfold = new BattleDistrictRankUnfold();
                        }
                        codedInputByteBufferNano.readMessage(this.battleDistrictRankUnfold);
                        break;
                    case 32:
                        this.nextUnfoldTime = codedInputByteBufferNano.readInt64();
                        break;
                    case 40:
                        this.unfoldDuration = codedInputByteBufferNano.readInt64();
                        break;
                    case 48:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3 && int32 != 4) {
                            break;
                        } else {
                            this.rankRegionType = int32;
                            break;
                        }
                    case 56:
                        this.unfoldInterval = codedInputByteBufferNano.readInt64();
                        break;
                    case 64:
                        this.waitEndTimestamp = codedInputByteBufferNano.readInt64();
                        break;
                    case 74:
                        if (this.waitDescribeText == null) {
                            this.waitDescribeText = new ContentWithStyle();
                        }
                        codedInputByteBufferNano.readMessage(this.waitDescribeText);
                        break;
                    case 82:
                        if (this.waitCountDownText == null) {
                            this.waitCountDownText = new ContentWithStyle();
                        }
                        codedInputByteBufferNano.readMessage(this.waitCountDownText);
                        break;
                    case 90:
                        if (this.waitRemindText == null) {
                            this.waitRemindText = new ContentWithStyle();
                        }
                        codedInputByteBufferNano.readMessage(this.waitRemindText);
                        break;
                    case 96:
                        this.waitDisplayEndDurationMs = codedInputByteBufferNano.readInt64();
                        break;
                    case 106:
                        this.waitCountDownColor = codedInputByteBufferNano.readString();
                        break;
                    case 112:
                        this.shouldClose = codedInputByteBufferNano.readBool();
                        break;
                    case 120:
                        this.jumpToTabId = codedInputByteBufferNano.readUInt32();
                        break;
                    case 128:
                        this.jumpToSubTabId = codedInputByteBufferNano.readUInt32();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveBattleDistrictRank parseFrom(byte[] bArr) {
            return (SCLiveBattleDistrictRank) MessageNano.mergeFrom(new SCLiveBattleDistrictRank(), bArr);
        }

        public static SCLiveBattleDistrictRank parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBattleDistrictRank().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class BattleDistrictRankFold extends MessageNano {
        private static volatile BattleDistrictRankFold[] _emptyArray;
        public UserInfos.PicUrl[] backgroundPicUrl;
        public FoldMessage[] foldMessage;
        public UserInfos.PicUrl[] unfoldPicUrl;
        public ContentWithStyle waitEndText;
        public UserInfos.PicUrl[] waitIconUrl;

        public static BattleDistrictRankFold[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new BattleDistrictRankFold[0];
                    }
                }
            }
            return _emptyArray;
        }

        public BattleDistrictRankFold() {
            clear();
        }

        public final BattleDistrictRankFold clear() {
            this.backgroundPicUrl = UserInfos.PicUrl.emptyArray();
            this.unfoldPicUrl = UserInfos.PicUrl.emptyArray();
            this.foldMessage = FoldMessage.emptyArray();
            this.waitEndText = null;
            this.waitIconUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.unfoldPicUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.unfoldPicUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl2);
                    }
                    i3++;
                }
            }
            FoldMessage[] foldMessageArr = this.foldMessage;
            if (foldMessageArr != null && foldMessageArr.length > 0) {
                int i4 = 0;
                while (true) {
                    FoldMessage[] foldMessageArr2 = this.foldMessage;
                    if (i4 >= foldMessageArr2.length) {
                        break;
                    }
                    FoldMessage foldMessage = foldMessageArr2[i4];
                    if (foldMessage != null) {
                        codedOutputByteBufferNano.writeMessage(3, foldMessage);
                    }
                    i4++;
                }
            }
            ContentWithStyle contentWithStyle = this.waitEndText;
            if (contentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(4, contentWithStyle);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.waitIconUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.waitIconUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl3);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.unfoldPicUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.unfoldPicUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(2, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            FoldMessage[] foldMessageArr = this.foldMessage;
            if (foldMessageArr != null && foldMessageArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    FoldMessage[] foldMessageArr2 = this.foldMessage;
                    if (i4 >= foldMessageArr2.length) {
                        break;
                    }
                    FoldMessage foldMessage = foldMessageArr2[i4];
                    if (foldMessage != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(3, foldMessage);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            ContentWithStyle contentWithStyle = this.waitEndText;
            if (contentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, contentWithStyle);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.waitIconUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.waitIconUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl3);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final BattleDistrictRankFold mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.backgroundPicUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.backgroundPicUrl = picUrlArr2;
                } else if (tag == 18) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr3 = this.unfoldPicUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.unfoldPicUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.unfoldPicUrl = picUrlArr4;
                } else if (tag == 26) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    FoldMessage[] foldMessageArr = this.foldMessage;
                    int length3 = foldMessageArr == null ? 0 : foldMessageArr.length;
                    FoldMessage[] foldMessageArr2 = new FoldMessage[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.foldMessage, 0, foldMessageArr2, 0, length3);
                    }
                    while (length3 < foldMessageArr2.length - 1) {
                        foldMessageArr2[length3] = new FoldMessage();
                        codedInputByteBufferNano.readMessage(foldMessageArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    foldMessageArr2[length3] = new FoldMessage();
                    codedInputByteBufferNano.readMessage(foldMessageArr2[length3]);
                    this.foldMessage = foldMessageArr2;
                } else if (tag == 34) {
                    if (this.waitEndText == null) {
                        this.waitEndText = new ContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.waitEndText);
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr5 = this.waitIconUrl;
                    int length4 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.waitIconUrl, 0, picUrlArr6, 0, length4);
                    }
                    while (length4 < picUrlArr6.length - 1) {
                        picUrlArr6[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr6[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                    this.waitIconUrl = picUrlArr6;
                }
            }
        }

        public static BattleDistrictRankFold parseFrom(byte[] bArr) {
            return (BattleDistrictRankFold) MessageNano.mergeFrom(new BattleDistrictRankFold(), bArr);
        }

        public static BattleDistrictRankFold parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new BattleDistrictRankFold().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class FoldMessage extends MessageNano {
        private static volatile FoldMessage[] _emptyArray;
        public UserInfos.PicUrl[] arrowUrl;
        public ContentWithStyle contentWithStyle;
        public UserInfos.PicUrl[] dynamicArrowUrl;
        public String extraInfo;
        public UserInfos.PicUrl[] iconUrl;

        public static FoldMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FoldMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FoldMessage() {
            clear();
        }

        public final FoldMessage clear() {
            this.iconUrl = UserInfos.PicUrl.emptyArray();
            this.contentWithStyle = null;
            this.arrowUrl = UserInfos.PicUrl.emptyArray();
            this.extraInfo = "";
            this.dynamicArrowUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            ContentWithStyle contentWithStyle = this.contentWithStyle;
            if (contentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(2, contentWithStyle);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.arrowUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.arrowUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl2);
                    }
                    i3++;
                }
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.extraInfo);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.dynamicArrowUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.dynamicArrowUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(5, picUrl3);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            ContentWithStyle contentWithStyle = this.contentWithStyle;
            if (contentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, contentWithStyle);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.arrowUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.arrowUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(3, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            if (!this.extraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extraInfo);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.dynamicArrowUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.dynamicArrowUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl3);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final FoldMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.iconUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.iconUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.iconUrl = picUrlArr2;
                } else if (tag == 18) {
                    if (this.contentWithStyle == null) {
                        this.contentWithStyle = new ContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.contentWithStyle);
                } else if (tag == 26) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr3 = this.arrowUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.arrowUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.arrowUrl = picUrlArr4;
                } else if (tag == 34) {
                    this.extraInfo = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    UserInfos.PicUrl[] picUrlArr5 = this.dynamicArrowUrl;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.dynamicArrowUrl, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.dynamicArrowUrl = picUrlArr6;
                }
            }
        }

        public static FoldMessage parseFrom(byte[] bArr) {
            return (FoldMessage) MessageNano.mergeFrom(new FoldMessage(), bArr);
        }

        public static FoldMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new FoldMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class BattleDistrictRankUnfold extends MessageNano {
        private static volatile BattleDistrictRankUnfold[] _emptyArray;
        public UserInfos.PicUrl[] backgroundPicUrl;
        public String countDownColor;
        public ContentWithStyle countDownText;
        public UserInfos.PicUrl[] foldPicUrl;
        public UserInfos.PicUrl[] iconUrl;
        public UnfoldMessage[] unfoldMessage;
        public ContentWithStyle waitEndText;
        public ContentWithStyle waitRemindText;

        public static BattleDistrictRankUnfold[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new BattleDistrictRankUnfold[0];
                    }
                }
            }
            return _emptyArray;
        }

        public BattleDistrictRankUnfold() {
            clear();
        }

        public final BattleDistrictRankUnfold clear() {
            this.backgroundPicUrl = UserInfos.PicUrl.emptyArray();
            this.foldPicUrl = UserInfos.PicUrl.emptyArray();
            this.unfoldMessage = UnfoldMessage.emptyArray();
            this.countDownText = null;
            this.countDownColor = "";
            this.iconUrl = UserInfos.PicUrl.emptyArray();
            this.waitEndText = null;
            this.waitRemindText = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.foldPicUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.foldPicUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl2);
                    }
                    i3++;
                }
            }
            UnfoldMessage[] unfoldMessageArr = this.unfoldMessage;
            if (unfoldMessageArr != null && unfoldMessageArr.length > 0) {
                int i4 = 0;
                while (true) {
                    UnfoldMessage[] unfoldMessageArr2 = this.unfoldMessage;
                    if (i4 >= unfoldMessageArr2.length) {
                        break;
                    }
                    UnfoldMessage unfoldMessage = unfoldMessageArr2[i4];
                    if (unfoldMessage != null) {
                        codedOutputByteBufferNano.writeMessage(3, unfoldMessage);
                    }
                    i4++;
                }
            }
            ContentWithStyle contentWithStyle = this.countDownText;
            if (contentWithStyle != null) {
                codedOutputByteBufferNano.writeMessage(4, contentWithStyle);
            }
            if (!this.countDownColor.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.countDownColor);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.iconUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.iconUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl3);
                    }
                    i++;
                }
            }
            ContentWithStyle contentWithStyle2 = this.waitEndText;
            if (contentWithStyle2 != null) {
                codedOutputByteBufferNano.writeMessage(7, contentWithStyle2);
            }
            ContentWithStyle contentWithStyle3 = this.waitRemindText;
            if (contentWithStyle3 != null) {
                codedOutputByteBufferNano.writeMessage(8, contentWithStyle3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.foldPicUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.foldPicUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(2, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UnfoldMessage[] unfoldMessageArr = this.unfoldMessage;
            if (unfoldMessageArr != null && unfoldMessageArr.length > 0) {
                int iComputeMessageSize3 = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UnfoldMessage[] unfoldMessageArr2 = this.unfoldMessage;
                    if (i4 >= unfoldMessageArr2.length) {
                        break;
                    }
                    UnfoldMessage unfoldMessage = unfoldMessageArr2[i4];
                    if (unfoldMessage != null) {
                        iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(3, unfoldMessage);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize3;
            }
            ContentWithStyle contentWithStyle = this.countDownText;
            if (contentWithStyle != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, contentWithStyle);
            }
            if (!this.countDownColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.countDownColor);
            }
            UserInfos.PicUrl[] picUrlArr5 = this.iconUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.iconUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl3);
                    }
                    i++;
                }
            }
            ContentWithStyle contentWithStyle2 = this.waitEndText;
            if (contentWithStyle2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, contentWithStyle2);
            }
            ContentWithStyle contentWithStyle3 = this.waitRemindText;
            return contentWithStyle3 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(8, contentWithStyle3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final BattleDistrictRankUnfold mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.backgroundPicUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.backgroundPicUrl = picUrlArr2;
                } else if (tag == 18) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr3 = this.foldPicUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.foldPicUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.foldPicUrl = picUrlArr4;
                } else if (tag == 26) {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UnfoldMessage[] unfoldMessageArr = this.unfoldMessage;
                    int length3 = unfoldMessageArr == null ? 0 : unfoldMessageArr.length;
                    UnfoldMessage[] unfoldMessageArr2 = new UnfoldMessage[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.unfoldMessage, 0, unfoldMessageArr2, 0, length3);
                    }
                    while (length3 < unfoldMessageArr2.length - 1) {
                        unfoldMessageArr2[length3] = new UnfoldMessage();
                        codedInputByteBufferNano.readMessage(unfoldMessageArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    unfoldMessageArr2[length3] = new UnfoldMessage();
                    codedInputByteBufferNano.readMessage(unfoldMessageArr2[length3]);
                    this.unfoldMessage = unfoldMessageArr2;
                } else if (tag == 34) {
                    if (this.countDownText == null) {
                        this.countDownText = new ContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.countDownText);
                } else if (tag == 42) {
                    this.countDownColor = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    UserInfos.PicUrl[] picUrlArr5 = this.iconUrl;
                    int length4 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.iconUrl, 0, picUrlArr6, 0, length4);
                    }
                    while (length4 < picUrlArr6.length - 1) {
                        picUrlArr6[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr6[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length4]);
                    this.iconUrl = picUrlArr6;
                } else if (tag == 58) {
                    if (this.waitEndText == null) {
                        this.waitEndText = new ContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.waitEndText);
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.waitRemindText == null) {
                        this.waitRemindText = new ContentWithStyle();
                    }
                    codedInputByteBufferNano.readMessage(this.waitRemindText);
                }
            }
        }

        public static BattleDistrictRankUnfold parseFrom(byte[] bArr) {
            return (BattleDistrictRankUnfold) MessageNano.mergeFrom(new BattleDistrictRankUnfold(), bArr);
        }

        public static BattleDistrictRankUnfold parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new BattleDistrictRankUnfold().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class UnfoldMessage extends MessageNano {
        private static volatile UnfoldMessage[] _emptyArray;
        public String extraInfo;
        public UserInfos.PicUrl[] infoShowPicUrl;
        public UnfoldSubMessage[] unfoldSubMessage;

        public static UnfoldMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UnfoldMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UnfoldMessage() {
            clear();
        }

        public final UnfoldMessage clear() {
            this.infoShowPicUrl = UserInfos.PicUrl.emptyArray();
            this.unfoldSubMessage = UnfoldSubMessage.emptyArray();
            this.extraInfo = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.infoShowPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.infoShowPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            UnfoldSubMessage[] unfoldSubMessageArr = this.unfoldSubMessage;
            if (unfoldSubMessageArr != null && unfoldSubMessageArr.length > 0) {
                while (true) {
                    UnfoldSubMessage[] unfoldSubMessageArr2 = this.unfoldSubMessage;
                    if (i >= unfoldSubMessageArr2.length) {
                        break;
                    }
                    UnfoldSubMessage unfoldSubMessage = unfoldSubMessageArr2[i];
                    if (unfoldSubMessage != null) {
                        codedOutputByteBufferNano.writeMessage(2, unfoldSubMessage);
                    }
                    i++;
                }
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.extraInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.infoShowPicUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.infoShowPicUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UnfoldSubMessage[] unfoldSubMessageArr = this.unfoldSubMessage;
            if (unfoldSubMessageArr != null && unfoldSubMessageArr.length > 0) {
                while (true) {
                    UnfoldSubMessage[] unfoldSubMessageArr2 = this.unfoldSubMessage;
                    if (i >= unfoldSubMessageArr2.length) {
                        break;
                    }
                    UnfoldSubMessage unfoldSubMessage = unfoldSubMessageArr2[i];
                    if (unfoldSubMessage != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, unfoldSubMessage);
                    }
                    i++;
                }
            }
            return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.extraInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final UnfoldMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.infoShowPicUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.infoShowPicUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.infoShowPicUrl = picUrlArr2;
                } else if (tag == 18) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UnfoldSubMessage[] unfoldSubMessageArr = this.unfoldSubMessage;
                    int length2 = unfoldSubMessageArr == null ? 0 : unfoldSubMessageArr.length;
                    UnfoldSubMessage[] unfoldSubMessageArr2 = new UnfoldSubMessage[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.unfoldSubMessage, 0, unfoldSubMessageArr2, 0, length2);
                    }
                    while (length2 < unfoldSubMessageArr2.length - 1) {
                        unfoldSubMessageArr2[length2] = new UnfoldSubMessage();
                        codedInputByteBufferNano.readMessage(unfoldSubMessageArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    unfoldSubMessageArr2[length2] = new UnfoldSubMessage();
                    codedInputByteBufferNano.readMessage(unfoldSubMessageArr2[length2]);
                    this.unfoldSubMessage = unfoldSubMessageArr2;
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraInfo = codedInputByteBufferNano.readString();
                }
            }
        }

        public static UnfoldMessage parseFrom(byte[] bArr) {
            return (UnfoldMessage) MessageNano.mergeFrom(new UnfoldMessage(), bArr);
        }

        public static UnfoldMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UnfoldMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class UnfoldSubMessage extends MessageNano {
        private static volatile UnfoldSubMessage[] _emptyArray;
        public UserInfos.PicUrl[] arrowUrl;
        public ContentWithStyle[] contentWithStyle;
        public UserInfos.PicUrl[] dynamicArrowUrl;

        public static UnfoldSubMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new UnfoldSubMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public UnfoldSubMessage() {
            clear();
        }

        public final UnfoldSubMessage clear() {
            this.contentWithStyle = ContentWithStyle.emptyArray();
            this.arrowUrl = UserInfos.PicUrl.emptyArray();
            this.dynamicArrowUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ContentWithStyle[] contentWithStyleArr = this.contentWithStyle;
            int i = 0;
            if (contentWithStyleArr != null && contentWithStyleArr.length > 0) {
                int i2 = 0;
                while (true) {
                    ContentWithStyle[] contentWithStyleArr2 = this.contentWithStyle;
                    if (i2 >= contentWithStyleArr2.length) {
                        break;
                    }
                    ContentWithStyle contentWithStyle = contentWithStyleArr2[i2];
                    if (contentWithStyle != null) {
                        codedOutputByteBufferNano.writeMessage(1, contentWithStyle);
                    }
                    i2++;
                }
            }
            UserInfos.PicUrl[] picUrlArr = this.arrowUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.arrowUrl;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.dynamicArrowUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.dynamicArrowUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl2);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ContentWithStyle[] contentWithStyleArr = this.contentWithStyle;
            int i = 0;
            if (contentWithStyleArr != null && contentWithStyleArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    ContentWithStyle[] contentWithStyleArr2 = this.contentWithStyle;
                    if (i2 >= contentWithStyleArr2.length) {
                        break;
                    }
                    ContentWithStyle contentWithStyle = contentWithStyleArr2[i2];
                    if (contentWithStyle != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, contentWithStyle);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr = this.arrowUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.arrowUrl;
                    if (i3 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i3];
                    if (picUrl != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.dynamicArrowUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.dynamicArrowUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl2);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final UnfoldSubMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    ContentWithStyle[] contentWithStyleArr = this.contentWithStyle;
                    int length = contentWithStyleArr == null ? 0 : contentWithStyleArr.length;
                    ContentWithStyle[] contentWithStyleArr2 = new ContentWithStyle[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.contentWithStyle, 0, contentWithStyleArr2, 0, length);
                    }
                    while (length < contentWithStyleArr2.length - 1) {
                        contentWithStyleArr2[length] = new ContentWithStyle();
                        codedInputByteBufferNano.readMessage(contentWithStyleArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    contentWithStyleArr2[length] = new ContentWithStyle();
                    codedInputByteBufferNano.readMessage(contentWithStyleArr2[length]);
                    this.contentWithStyle = contentWithStyleArr2;
                } else if (tag == 18) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr = this.arrowUrl;
                    int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.arrowUrl, 0, picUrlArr2, 0, length2);
                    }
                    while (length2 < picUrlArr2.length - 1) {
                        picUrlArr2[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    this.arrowUrl = picUrlArr2;
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr3 = this.dynamicArrowUrl;
                    int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.dynamicArrowUrl, 0, picUrlArr4, 0, length3);
                    }
                    while (length3 < picUrlArr4.length - 1) {
                        picUrlArr4[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr4[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                    this.dynamicArrowUrl = picUrlArr4;
                }
            }
        }

        public static UnfoldSubMessage parseFrom(byte[] bArr) {
            return (UnfoldSubMessage) MessageNano.mergeFrom(new UnfoldSubMessage(), bArr);
        }

        public static UnfoldSubMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new UnfoldSubMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ContentWithStyle extends MessageNano {
        private static volatile ContentWithStyle[] _emptyArray;
        public String color;
        public String content;

        public static ContentWithStyle[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ContentWithStyle[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ContentWithStyle() {
            clear();
        }

        public final ContentWithStyle clear() {
            this.content = "";
            this.color = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.content);
            }
            if (!this.color.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.color);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
            }
            return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ContentWithStyle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.content = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.color = codedInputByteBufferNano.readString();
                }
            }
        }

        public static ContentWithStyle parseFrom(byte[] bArr) {
            return (ContentWithStyle) MessageNano.mergeFrom(new ContentWithStyle(), bArr);
        }

        public static ContentWithStyle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ContentWithStyle().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveRankVisibleResetInfo extends MessageNano {
        private static volatile SCLiveRankVisibleResetInfo[] _emptyArray;
        public boolean districtRankBattleVisible;
        public boolean districtRankVisible;
        public boolean popularityRankBattleVisible;
        public boolean popularityRankVisible;

        public static SCLiveRankVisibleResetInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveRankVisibleResetInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveRankVisibleResetInfo() {
            clear();
        }

        public final SCLiveRankVisibleResetInfo clear() {
            this.districtRankVisible = false;
            this.districtRankBattleVisible = false;
            this.popularityRankVisible = false;
            this.popularityRankBattleVisible = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.districtRankVisible;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            boolean z2 = this.districtRankBattleVisible;
            if (z2) {
                codedOutputByteBufferNano.writeBool(2, z2);
            }
            boolean z3 = this.popularityRankVisible;
            if (z3) {
                codedOutputByteBufferNano.writeBool(3, z3);
            }
            boolean z4 = this.popularityRankBattleVisible;
            if (z4) {
                codedOutputByteBufferNano.writeBool(4, z4);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.districtRankVisible;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            boolean z2 = this.districtRankBattleVisible;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
            }
            boolean z3 = this.popularityRankVisible;
            if (z3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z3);
            }
            boolean z4 = this.popularityRankBattleVisible;
            return z4 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z4) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveRankVisibleResetInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.districtRankVisible = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.districtRankBattleVisible = codedInputByteBufferNano.readBool();
                } else if (tag == 24) {
                    this.popularityRankVisible = codedInputByteBufferNano.readBool();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.popularityRankBattleVisible = codedInputByteBufferNano.readBool();
                }
            }
        }

        public static SCLiveRankVisibleResetInfo parseFrom(byte[] bArr) {
            return (SCLiveRankVisibleResetInfo) MessageNano.mergeFrom(new SCLiveRankVisibleResetInfo(), bArr);
        }

        public static SCLiveRankVisibleResetInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveRankVisibleResetInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
