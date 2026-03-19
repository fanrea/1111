package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftAchievementUpdateNotice extends MessageNano {
    private static volatile SCLiveGiftAchievementUpdateNotice[] _emptyArray;
    public String achievementWallUrl;
    public LiveGiftAchievement[] achievements;
    public long authorId;
    public String liveStreamId;
    public long weekNo;

    public static SCLiveGiftAchievementUpdateNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftAchievementUpdateNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftAchievementUpdateNotice() {
        clear();
    }

    public final SCLiveGiftAchievementUpdateNotice clear() {
        this.achievementWallUrl = "";
        this.weekNo = 0L;
        this.achievements = LiveGiftAchievement.emptyArray();
        this.authorId = 0L;
        this.liveStreamId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.achievementWallUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.achievementWallUrl);
        }
        long j = this.weekNo;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        LiveGiftAchievement[] liveGiftAchievementArr = this.achievements;
        if (liveGiftAchievementArr != null && liveGiftAchievementArr.length > 0) {
            int i = 0;
            while (true) {
                LiveGiftAchievement[] liveGiftAchievementArr2 = this.achievements;
                if (i >= liveGiftAchievementArr2.length) {
                    break;
                }
                LiveGiftAchievement liveGiftAchievement = liveGiftAchievementArr2[i];
                if (liveGiftAchievement != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveGiftAchievement);
                }
                i++;
            }
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.liveStreamId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.achievementWallUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.achievementWallUrl);
        }
        long j = this.weekNo;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        LiveGiftAchievement[] liveGiftAchievementArr = this.achievements;
        if (liveGiftAchievementArr != null && liveGiftAchievementArr.length > 0) {
            int i = 0;
            while (true) {
                LiveGiftAchievement[] liveGiftAchievementArr2 = this.achievements;
                if (i >= liveGiftAchievementArr2.length) {
                    break;
                }
                LiveGiftAchievement liveGiftAchievement = liveGiftAchievementArr2[i];
                if (liveGiftAchievement != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveGiftAchievement);
                }
                i++;
            }
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.liveStreamId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftAchievementUpdateNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.achievementWallUrl = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.weekNo = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveGiftAchievement[] liveGiftAchievementArr = this.achievements;
                int length = liveGiftAchievementArr == null ? 0 : liveGiftAchievementArr.length;
                LiveGiftAchievement[] liveGiftAchievementArr2 = new LiveGiftAchievement[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.achievements, 0, liveGiftAchievementArr2, 0, length);
                }
                while (length < liveGiftAchievementArr2.length - 1) {
                    liveGiftAchievementArr2[length] = new LiveGiftAchievement();
                    codedInputByteBufferNano.readMessage(liveGiftAchievementArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveGiftAchievementArr2[length] = new LiveGiftAchievement();
                codedInputByteBufferNano.readMessage(liveGiftAchievementArr2[length]);
                this.achievements = liveGiftAchievementArr2;
            } else if (tag == 32) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.liveStreamId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveGiftAchievementUpdateNotice parseFrom(byte[] bArr) {
        return (SCLiveGiftAchievementUpdateNotice) MessageNano.mergeFrom(new SCLiveGiftAchievementUpdateNotice(), bArr);
    }

    public static SCLiveGiftAchievementUpdateNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftAchievementUpdateNotice().mergeFrom(codedInputByteBufferNano);
    }
}
