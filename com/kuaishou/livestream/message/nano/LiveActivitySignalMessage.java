package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.livestream.message.nano.LiveCommonNoticeMessages;
import com.kuaishou.socket.nano.UserInfos;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveActivitySignalMessage {

    public static final class LiveActivitySpecialAudienceRankInfo extends MessageNano {
        private static volatile LiveActivitySpecialAudienceRankInfo[] _emptyArray;
        public String activityId;
        public String activityType;
        public boolean autoExpandEnterRoom;
        public Map<String, String> extraMessage;
        public String liveStreamId;
        public String moreUrl;
        public String payScene;
        public int showCount;
        public LiveSpecialAudienceRankInfo[] specialAudienceRankInfo;

        public static LiveActivitySpecialAudienceRankInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivitySpecialAudienceRankInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivitySpecialAudienceRankInfo() {
            clear();
        }

        public final LiveActivitySpecialAudienceRankInfo clear() {
            this.liveStreamId = "";
            this.activityId = "";
            this.activityType = "";
            this.moreUrl = "";
            this.specialAudienceRankInfo = LiveSpecialAudienceRankInfo.emptyArray();
            this.payScene = "";
            this.extraMessage = null;
            this.autoExpandEnterRoom = false;
            this.showCount = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            if (!this.activityType.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.activityType);
            }
            if (!this.moreUrl.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.moreUrl);
            }
            LiveSpecialAudienceRankInfo[] liveSpecialAudienceRankInfoArr = this.specialAudienceRankInfo;
            if (liveSpecialAudienceRankInfoArr != null && liveSpecialAudienceRankInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveSpecialAudienceRankInfo[] liveSpecialAudienceRankInfoArr2 = this.specialAudienceRankInfo;
                    if (i >= liveSpecialAudienceRankInfoArr2.length) {
                        break;
                    }
                    LiveSpecialAudienceRankInfo liveSpecialAudienceRankInfo = liveSpecialAudienceRankInfoArr2[i];
                    if (liveSpecialAudienceRankInfo != null) {
                        codedOutputByteBufferNano.writeMessage(5, liveSpecialAudienceRankInfo);
                    }
                    i++;
                }
            }
            if (!this.payScene.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.payScene);
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 7, 9, 9);
            }
            boolean z = this.autoExpandEnterRoom;
            if (z) {
                codedOutputByteBufferNano.writeBool(8, z);
            }
            int i2 = this.showCount;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(9, i2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
            }
            if (!this.activityType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.activityType);
            }
            if (!this.moreUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.moreUrl);
            }
            LiveSpecialAudienceRankInfo[] liveSpecialAudienceRankInfoArr = this.specialAudienceRankInfo;
            if (liveSpecialAudienceRankInfoArr != null && liveSpecialAudienceRankInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveSpecialAudienceRankInfo[] liveSpecialAudienceRankInfoArr2 = this.specialAudienceRankInfo;
                    if (i >= liveSpecialAudienceRankInfoArr2.length) {
                        break;
                    }
                    LiveSpecialAudienceRankInfo liveSpecialAudienceRankInfo = liveSpecialAudienceRankInfoArr2[i];
                    if (liveSpecialAudienceRankInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveSpecialAudienceRankInfo);
                    }
                    i++;
                }
            }
            if (!this.payScene.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.payScene);
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 7, 9, 9);
            }
            boolean z = this.autoExpandEnterRoom;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
            }
            int i2 = this.showCount;
            return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(9, i2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivitySpecialAudienceRankInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.activityType = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.moreUrl = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LiveSpecialAudienceRankInfo[] liveSpecialAudienceRankInfoArr = this.specialAudienceRankInfo;
                    int length = liveSpecialAudienceRankInfoArr == null ? 0 : liveSpecialAudienceRankInfoArr.length;
                    LiveSpecialAudienceRankInfo[] liveSpecialAudienceRankInfoArr2 = new LiveSpecialAudienceRankInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.specialAudienceRankInfo, 0, liveSpecialAudienceRankInfoArr2, 0, length);
                    }
                    while (length < liveSpecialAudienceRankInfoArr2.length - 1) {
                        liveSpecialAudienceRankInfoArr2[length] = new LiveSpecialAudienceRankInfo();
                        codedInputByteBufferNano.readMessage(liveSpecialAudienceRankInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveSpecialAudienceRankInfoArr2[length] = new LiveSpecialAudienceRankInfo();
                    codedInputByteBufferNano.readMessage(liveSpecialAudienceRankInfoArr2[length]);
                    this.specialAudienceRankInfo = liveSpecialAudienceRankInfoArr2;
                } else if (tag == 50) {
                    this.payScene = codedInputByteBufferNano.readString();
                } else if (tag == 58) {
                    this.extraMessage = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMessage, mapFactory, 9, 9, null, 10, 18);
                } else if (tag == 64) {
                    this.autoExpandEnterRoom = codedInputByteBufferNano.readBool();
                } else if (tag != 72) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.showCount = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveActivitySpecialAudienceRankInfo parseFrom(byte[] bArr) {
            return (LiveActivitySpecialAudienceRankInfo) MessageNano.mergeFrom(new LiveActivitySpecialAudienceRankInfo(), bArr);
        }

        public static LiveActivitySpecialAudienceRankInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivitySpecialAudienceRankInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSpecialAudienceRankInfo extends MessageNano {
        private static volatile LiveSpecialAudienceRankInfo[] _emptyArray;
        public String popularity;
        public String popularityTitle;
        public int rankIndex;
        public UserInfos.UserInfo specialAudienceUser;
        public LiveSponsorRankInfo[] sponsorRank;

        public static LiveSpecialAudienceRankInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSpecialAudienceRankInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSpecialAudienceRankInfo() {
            clear();
        }

        public final LiveSpecialAudienceRankInfo clear() {
            this.specialAudienceUser = null;
            this.popularity = "";
            this.sponsorRank = LiveSponsorRankInfo.emptyArray();
            this.rankIndex = 0;
            this.popularityTitle = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.specialAudienceUser;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            if (!this.popularity.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.popularity);
            }
            LiveSponsorRankInfo[] liveSponsorRankInfoArr = this.sponsorRank;
            if (liveSponsorRankInfoArr != null && liveSponsorRankInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveSponsorRankInfo[] liveSponsorRankInfoArr2 = this.sponsorRank;
                    if (i >= liveSponsorRankInfoArr2.length) {
                        break;
                    }
                    LiveSponsorRankInfo liveSponsorRankInfo = liveSponsorRankInfoArr2[i];
                    if (liveSponsorRankInfo != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveSponsorRankInfo);
                    }
                    i++;
                }
            }
            int i2 = this.rankIndex;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            if (!this.popularityTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.popularityTitle);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.specialAudienceUser;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            if (!this.popularity.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.popularity);
            }
            LiveSponsorRankInfo[] liveSponsorRankInfoArr = this.sponsorRank;
            if (liveSponsorRankInfoArr != null && liveSponsorRankInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveSponsorRankInfo[] liveSponsorRankInfoArr2 = this.sponsorRank;
                    if (i >= liveSponsorRankInfoArr2.length) {
                        break;
                    }
                    LiveSponsorRankInfo liveSponsorRankInfo = liveSponsorRankInfoArr2[i];
                    if (liveSponsorRankInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveSponsorRankInfo);
                    }
                    i++;
                }
            }
            int i2 = this.rankIndex;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            return !this.popularityTitle.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.popularityTitle) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSpecialAudienceRankInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.specialAudienceUser == null) {
                        this.specialAudienceUser = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.specialAudienceUser);
                } else if (tag == 18) {
                    this.popularity = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveSponsorRankInfo[] liveSponsorRankInfoArr = this.sponsorRank;
                    int length = liveSponsorRankInfoArr == null ? 0 : liveSponsorRankInfoArr.length;
                    LiveSponsorRankInfo[] liveSponsorRankInfoArr2 = new LiveSponsorRankInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.sponsorRank, 0, liveSponsorRankInfoArr2, 0, length);
                    }
                    while (length < liveSponsorRankInfoArr2.length - 1) {
                        liveSponsorRankInfoArr2[length] = new LiveSponsorRankInfo();
                        codedInputByteBufferNano.readMessage(liveSponsorRankInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveSponsorRankInfoArr2[length] = new LiveSponsorRankInfo();
                    codedInputByteBufferNano.readMessage(liveSponsorRankInfoArr2[length]);
                    this.sponsorRank = liveSponsorRankInfoArr2;
                } else if (tag == 32) {
                    this.rankIndex = codedInputByteBufferNano.readUInt32();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.popularityTitle = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveSpecialAudienceRankInfo parseFrom(byte[] bArr) {
            return (LiveSpecialAudienceRankInfo) MessageNano.mergeFrom(new LiveSpecialAudienceRankInfo(), bArr);
        }

        public static LiveSpecialAudienceRankInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSpecialAudienceRankInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSponsorRankInfo extends MessageNano {
        private static volatile LiveSponsorRankInfo[] _emptyArray;
        public int rankIndex;
        public UserInfos.UserInfo sponsorUser;

        public static LiveSponsorRankInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSponsorRankInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSponsorRankInfo() {
            clear();
        }

        public final LiveSponsorRankInfo clear() {
            this.sponsorUser = null;
            this.rankIndex = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.sponsorUser;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            int i = this.rankIndex;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.sponsorUser;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            int i = this.rankIndex;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSponsorRankInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.sponsorUser == null) {
                        this.sponsorUser = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.sponsorUser);
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.rankIndex = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static LiveSponsorRankInfo parseFrom(byte[] bArr) {
            return (LiveSponsorRankInfo) MessageNano.mergeFrom(new LiveSponsorRankInfo(), bArr);
        }

        public static LiveSponsorRankInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSponsorRankInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityRankClearInfo extends MessageNano {
        private static volatile LiveActivityRankClearInfo[] _emptyArray;
        public String activityId;
        public String liveStreamId;

        public static LiveActivityRankClearInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityRankClearInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityRankClearInfo() {
            clear();
        }

        public final LiveActivityRankClearInfo clear() {
            this.liveStreamId = "";
            this.activityId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            return !this.activityId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.activityId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityRankClearInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.activityId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveActivityRankClearInfo parseFrom(byte[] bArr) {
            return (LiveActivityRankClearInfo) MessageNano.mergeFrom(new LiveActivityRankClearInfo(), bArr);
        }

        public static LiveActivityRankClearInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityRankClearInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveActivityPopUpInfo extends MessageNano {
        private static volatile LiveActivityPopUpInfo[] _emptyArray;
        public String activityId;
        public LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo animationPicInfo;
        public boolean displayFollowButton;
        public long followRequestMaxDelayMs;
        public UserInfos.PicUrl[] picUrl;
        public long timeoutMillis;
        public UserInfos.UserInfo user;

        public static LiveActivityPopUpInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveActivityPopUpInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveActivityPopUpInfo() {
            clear();
        }

        public final LiveActivityPopUpInfo clear() {
            this.activityId = "";
            this.picUrl = UserInfos.PicUrl.emptyArray();
            this.user = null;
            this.displayFollowButton = false;
            this.timeoutMillis = 0L;
            this.followRequestMaxDelayMs = 0L;
            this.animationPicInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.activityId);
            }
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i++;
                }
            }
            UserInfos.UserInfo userInfo = this.user;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, userInfo);
            }
            boolean z = this.displayFollowButton;
            if (z) {
                codedOutputByteBufferNano.writeBool(4, z);
            }
            long j = this.timeoutMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            long j2 = this.followRequestMaxDelayMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo liveActivityPopAnimationPicInfo = this.animationPicInfo;
            if (liveActivityPopAnimationPicInfo != null) {
                codedOutputByteBufferNano.writeMessage(7, liveActivityPopAnimationPicInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activityId);
            }
            UserInfos.PicUrl[] picUrlArr = this.picUrl;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.picUrl;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i++;
                }
            }
            UserInfos.UserInfo userInfo = this.user;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
            }
            boolean z = this.displayFollowButton;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
            }
            long j = this.timeoutMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
            }
            long j2 = this.followRequestMaxDelayMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo liveActivityPopAnimationPicInfo = this.animationPicInfo;
            return liveActivityPopAnimationPicInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(7, liveActivityPopAnimationPicInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveActivityPopUpInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr = this.picUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.picUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.picUrl = picUrlArr2;
                } else if (tag == 26) {
                    if (this.user == null) {
                        this.user = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.user);
                } else if (tag == 32) {
                    this.displayFollowButton = codedInputByteBufferNano.readBool();
                } else if (tag == 40) {
                    this.timeoutMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    this.followRequestMaxDelayMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.animationPicInfo == null) {
                        this.animationPicInfo = new LiveCommonNoticeMessages.LiveActivityPopAnimationPicInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.animationPicInfo);
                }
            }
        }

        public static LiveActivityPopUpInfo parseFrom(byte[] bArr) {
            return (LiveActivityPopUpInfo) MessageNano.mergeFrom(new LiveActivityPopUpInfo(), bArr);
        }

        public static LiveActivityPopUpInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveActivityPopUpInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSpecialAudienceRankExpandInfo extends MessageNano {
        private static volatile LiveSpecialAudienceRankExpandInfo[] _emptyArray;
        public String activityId;
        public long autoExpandDurationMillis;
        public String liveStreamId;

        public static LiveSpecialAudienceRankExpandInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSpecialAudienceRankExpandInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSpecialAudienceRankExpandInfo() {
            clear();
        }

        public final LiveSpecialAudienceRankExpandInfo clear() {
            this.liveStreamId = "";
            this.activityId = "";
            this.autoExpandDurationMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            long j = this.autoExpandDurationMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
            }
            long j = this.autoExpandDurationMillis;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSpecialAudienceRankExpandInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.activityId = codedInputByteBufferNano.readString();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.autoExpandDurationMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveSpecialAudienceRankExpandInfo parseFrom(byte[] bArr) {
            return (LiveSpecialAudienceRankExpandInfo) MessageNano.mergeFrom(new LiveSpecialAudienceRankExpandInfo(), bArr);
        }

        public static LiveSpecialAudienceRankExpandInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSpecialAudienceRankExpandInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSpecialAudienceRankShrinkInfo extends MessageNano {
        private static volatile LiveSpecialAudienceRankShrinkInfo[] _emptyArray;
        public String activityId;
        public String liveStreamId;

        public static LiveSpecialAudienceRankShrinkInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSpecialAudienceRankShrinkInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSpecialAudienceRankShrinkInfo() {
            clear();
        }

        public final LiveSpecialAudienceRankShrinkInfo clear() {
            this.liveStreamId = "";
            this.activityId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.activityId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            return !this.activityId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.activityId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSpecialAudienceRankShrinkInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.activityId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveSpecialAudienceRankShrinkInfo parseFrom(byte[] bArr) {
            return (LiveSpecialAudienceRankShrinkInfo) MessageNano.mergeFrom(new LiveSpecialAudienceRankShrinkInfo(), bArr);
        }

        public static LiveSpecialAudienceRankShrinkInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSpecialAudienceRankShrinkInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
