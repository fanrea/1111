package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftAchievementNoticeUser extends MessageNano {
    private static volatile SCLiveGiftAchievementNoticeUser[] _emptyArray;
    public int achievementRank;
    public String clickUrl;
    public String firstLineText;
    public UserInfos.PicUrl[] icon;
    public int left;
    public String liveStreamId;
    public int right;
    public String secondLineText;

    public static SCLiveGiftAchievementNoticeUser[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftAchievementNoticeUser[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftAchievementNoticeUser() {
        clear();
    }

    public final SCLiveGiftAchievementNoticeUser clear() {
        this.left = 0;
        this.right = 0;
        this.icon = UserInfos.PicUrl.emptyArray();
        this.firstLineText = "";
        this.secondLineText = "";
        this.achievementRank = 0;
        this.clickUrl = "";
        this.liveStreamId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.left;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.right;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i3++;
            }
        }
        if (!this.firstLineText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.firstLineText);
        }
        if (!this.secondLineText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.secondLineText);
        }
        int i4 = this.achievementRank;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i4);
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
        int i = this.left;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.right;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i3++;
            }
        }
        if (!this.firstLineText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.firstLineText);
        }
        if (!this.secondLineText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.secondLineText);
        }
        int i4 = this.achievementRank;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i4);
        }
        if (!this.clickUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.clickUrl);
        }
        return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.liveStreamId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftAchievementNoticeUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.left = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.right = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.icon;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.icon = picUrlArr2;
            } else if (tag == 34) {
                this.firstLineText = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.secondLineText = codedInputByteBufferNano.readString();
            } else if (tag == 48) {
                this.achievementRank = codedInputByteBufferNano.readUInt32();
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

    public static SCLiveGiftAchievementNoticeUser parseFrom(byte[] bArr) {
        return (SCLiveGiftAchievementNoticeUser) MessageNano.mergeFrom(new SCLiveGiftAchievementNoticeUser(), bArr);
    }

    public static SCLiveGiftAchievementNoticeUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftAchievementNoticeUser().mergeFrom(codedInputByteBufferNano);
    }
}
