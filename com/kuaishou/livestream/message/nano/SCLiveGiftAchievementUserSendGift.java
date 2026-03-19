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
public final class SCLiveGiftAchievementUserSendGift extends MessageNano {
    private static volatile SCLiveGiftAchievementUserSendGift[] _emptyArray;
    public int achievementRank;
    public String clickUrl;
    public String firstLineText;
    public UserInfos.PicUrl[] giftIcon;
    public String liveStreamId;
    public UserInfos.UserInfo namingUser;
    public int showType;
    public long userPoints;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ShowType {
        public static final int LIGHT_ON_GIFT = 1;
        public static final int ONLY_UNLOCK_LEVEL = 3;
        public static final int POINT = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveGiftAchievementUserSendGift[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftAchievementUserSendGift[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftAchievementUserSendGift() {
        clear();
    }

    public final SCLiveGiftAchievementUserSendGift clear() {
        this.namingUser = null;
        this.userPoints = 0L;
        this.firstLineText = "";
        this.achievementRank = 0;
        this.giftIcon = UserInfos.PicUrl.emptyArray();
        this.showType = 0;
        this.clickUrl = "";
        this.liveStreamId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.namingUser;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        long j = this.userPoints;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.firstLineText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.firstLineText);
        }
        int i = this.achievementRank;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.giftIcon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.giftIcon;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(5, picUrl);
                }
                i2++;
            }
        }
        int i3 = this.showType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        if (!this.clickUrl.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.clickUrl);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.liveStreamId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.namingUser;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        long j = this.userPoints;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.firstLineText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.firstLineText);
        }
        int i = this.achievementRank;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.giftIcon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.giftIcon;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl);
                }
                i2++;
            }
        }
        int i3 = this.showType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
        }
        if (!this.clickUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.clickUrl);
        }
        return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.liveStreamId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftAchievementUserSendGift mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.namingUser == null) {
                    this.namingUser = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.namingUser);
            } else if (tag == 16) {
                this.userPoints = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.firstLineText = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.achievementRank = codedInputByteBufferNano.readUInt32();
            } else if (tag == 42) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                UserInfos.PicUrl[] picUrlArr = this.giftIcon;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.giftIcon, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.giftIcon = picUrlArr2;
            } else if (tag == 48) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.showType = int32;
                }
            } else if (tag == 58) {
                this.clickUrl = codedInputByteBufferNano.readString();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.liveStreamId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveGiftAchievementUserSendGift parseFrom(byte[] bArr) {
        return (SCLiveGiftAchievementUserSendGift) MessageNano.mergeFrom(new SCLiveGiftAchievementUserSendGift(), bArr);
    }

    public static SCLiveGiftAchievementUserSendGift parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftAchievementUserSendGift().mergeFrom(codedInputByteBufferNano);
    }
}
