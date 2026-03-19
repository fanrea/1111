package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftAchievementLightOnNotice extends MessageNano {
    private static volatile SCLiveGiftAchievementLightOnNotice[] _emptyArray;
    public int achievementRank;
    public String clickUrl;
    public String firstLineText;
    public UserInfos.PicUrl[] giftIcon;
    public UserInfos.PicUrl[] icon;
    public String liveStreamId;
    public String secondLineText;

    public static SCLiveGiftAchievementLightOnNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftAchievementLightOnNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftAchievementLightOnNotice() {
        clear();
    }

    public final SCLiveGiftAchievementLightOnNotice clear() {
        this.icon = UserInfos.PicUrl.emptyArray();
        this.firstLineText = "";
        this.secondLineText = "";
        this.achievementRank = 0;
        this.giftIcon = UserInfos.PicUrl.emptyArray();
        this.clickUrl = "";
        this.liveStreamId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
        if (!this.firstLineText.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.firstLineText);
        }
        if (!this.secondLineText.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.secondLineText);
        }
        int i3 = this.achievementRank;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.giftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.giftIcon;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(5, picUrl2);
                }
                i++;
            }
        }
        if (!this.clickUrl.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.clickUrl);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.liveStreamId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
        if (!this.firstLineText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.firstLineText);
        }
        if (!this.secondLineText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.secondLineText);
        }
        int i3 = this.achievementRank;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.giftIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.giftIcon;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, picUrl2);
                }
                i++;
            }
        }
        if (!this.clickUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.clickUrl);
        }
        return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.liveStreamId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftAchievementLightOnNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
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
            } else if (tag == 18) {
                this.firstLineText = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.secondLineText = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.achievementRank = codedInputByteBufferNano.readUInt32();
            } else if (tag == 42) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                UserInfos.PicUrl[] picUrlArr3 = this.giftIcon;
                int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.giftIcon, 0, picUrlArr4, 0, length2);
                }
                while (length2 < picUrlArr4.length - 1) {
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr4[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                this.giftIcon = picUrlArr4;
            } else if (tag == 50) {
                this.clickUrl = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.liveStreamId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveGiftAchievementLightOnNotice parseFrom(byte[] bArr) {
        return (SCLiveGiftAchievementLightOnNotice) MessageNano.mergeFrom(new SCLiveGiftAchievementLightOnNotice(), bArr);
    }

    public static SCLiveGiftAchievementLightOnNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftAchievementLightOnNotice().mergeFrom(codedInputByteBufferNano);
    }
}
