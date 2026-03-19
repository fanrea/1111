package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftAchievement extends MessageNano {
    private static volatile LiveGiftAchievement[] _emptyArray;
    public long achievementId;
    public String desc;
    public String displayText;
    public LiveGiftAchievementGift[] gifts;
    public LiveCdnNodeView[] icon;
    public boolean lightOn;
    public String name;
    public int order;

    public static LiveGiftAchievement[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftAchievement[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftAchievement() {
        clear();
    }

    public final LiveGiftAchievement clear() {
        this.achievementId = 0L;
        this.order = 0;
        this.name = "";
        this.displayText = "";
        this.lightOn = false;
        this.icon = LiveCdnNodeView.emptyArray();
        this.desc = "";
        this.gifts = LiveGiftAchievementGift.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.achievementId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        int i = this.order;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        if (!this.name.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.name);
        }
        if (!this.displayText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.displayText);
        }
        boolean z = this.lightOn;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.icon;
        int i2 = 0;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i3 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.icon;
                if (i3 >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                if (liveCdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(6, liveCdnNodeView);
                }
                i3++;
            }
        }
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.desc);
        }
        LiveGiftAchievementGift[] liveGiftAchievementGiftArr = this.gifts;
        if (liveGiftAchievementGiftArr != null && liveGiftAchievementGiftArr.length > 0) {
            while (true) {
                LiveGiftAchievementGift[] liveGiftAchievementGiftArr2 = this.gifts;
                if (i2 >= liveGiftAchievementGiftArr2.length) {
                    break;
                }
                LiveGiftAchievementGift liveGiftAchievementGift = liveGiftAchievementGiftArr2[i2];
                if (liveGiftAchievementGift != null) {
                    codedOutputByteBufferNano.writeMessage(8, liveGiftAchievementGift);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.achievementId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        int i = this.order;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        if (!this.name.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.name);
        }
        if (!this.displayText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayText);
        }
        boolean z = this.lightOn;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.icon;
        int i2 = 0;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.icon;
                if (i3 >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                if (liveCdnNodeView != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(6, liveCdnNodeView);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.desc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.desc);
        }
        LiveGiftAchievementGift[] liveGiftAchievementGiftArr = this.gifts;
        if (liveGiftAchievementGiftArr != null && liveGiftAchievementGiftArr.length > 0) {
            while (true) {
                LiveGiftAchievementGift[] liveGiftAchievementGiftArr2 = this.gifts;
                if (i2 >= liveGiftAchievementGiftArr2.length) {
                    break;
                }
                LiveGiftAchievementGift liveGiftAchievementGift = liveGiftAchievementGiftArr2[i2];
                if (liveGiftAchievementGift != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveGiftAchievementGift);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftAchievement mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.achievementId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.order = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                this.name = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.displayText = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.lightOn = codedInputByteBufferNano.readBool();
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                LiveCdnNodeView[] liveCdnNodeViewArr = this.icon;
                int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.icon, 0, liveCdnNodeViewArr2, 0, length);
                }
                while (length < liveCdnNodeViewArr2.length - 1) {
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                this.icon = liveCdnNodeViewArr2;
            } else if (tag == 58) {
                this.desc = codedInputByteBufferNano.readString();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                LiveGiftAchievementGift[] liveGiftAchievementGiftArr = this.gifts;
                int length2 = liveGiftAchievementGiftArr == null ? 0 : liveGiftAchievementGiftArr.length;
                LiveGiftAchievementGift[] liveGiftAchievementGiftArr2 = new LiveGiftAchievementGift[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.gifts, 0, liveGiftAchievementGiftArr2, 0, length2);
                }
                while (length2 < liveGiftAchievementGiftArr2.length - 1) {
                    liveGiftAchievementGiftArr2[length2] = new LiveGiftAchievementGift();
                    codedInputByteBufferNano.readMessage(liveGiftAchievementGiftArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                liveGiftAchievementGiftArr2[length2] = new LiveGiftAchievementGift();
                codedInputByteBufferNano.readMessage(liveGiftAchievementGiftArr2[length2]);
                this.gifts = liveGiftAchievementGiftArr2;
            }
        }
    }

    public static LiveGiftAchievement parseFrom(byte[] bArr) {
        return (LiveGiftAchievement) MessageNano.mergeFrom(new LiveGiftAchievement(), bArr);
    }

    public static LiveGiftAchievement parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftAchievement().mergeFrom(codedInputByteBufferNano);
    }
}
