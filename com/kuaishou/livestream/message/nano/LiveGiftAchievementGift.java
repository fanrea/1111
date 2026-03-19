package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftAchievementGift extends MessageNano {
    private static volatile LiveGiftAchievementGift[] _emptyArray;
    public LiveCdnNodeView[] giftIcon;
    public int giftId;
    public String giftName;
    public boolean lightOn;
    public int[] relationGiftIds;
    public int requiredCount;
    public String requiredCountDisplay;
    public int sentCount;
    public String sentCountDisplay;

    public static LiveGiftAchievementGift[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftAchievementGift[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftAchievementGift() {
        clear();
    }

    public final LiveGiftAchievementGift clear() {
        this.giftId = 0;
        this.giftName = "";
        this.giftIcon = LiveCdnNodeView.emptyArray();
        this.lightOn = false;
        this.requiredCount = 0;
        this.requiredCountDisplay = "";
        this.sentCount = 0;
        this.sentCountDisplay = "";
        this.relationGiftIds = WireFormatNano.EMPTY_INT_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.giftName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.giftName);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.giftIcon;
        int i2 = 0;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i3 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.giftIcon;
                if (i3 >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                if (liveCdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveCdnNodeView);
                }
                i3++;
            }
        }
        boolean z = this.lightOn;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        int i4 = this.requiredCount;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i4);
        }
        if (!this.requiredCountDisplay.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.requiredCountDisplay);
        }
        int i5 = this.sentCount;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i5);
        }
        if (!this.sentCountDisplay.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.sentCountDisplay);
        }
        int[] iArr = this.relationGiftIds;
        if (iArr != null && iArr.length > 0) {
            while (true) {
                int[] iArr2 = this.relationGiftIds;
                if (i2 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(9, iArr2[i2]);
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.giftName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.giftName);
        }
        LiveCdnNodeView[] liveCdnNodeViewArr = this.giftIcon;
        int i2 = 0;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.giftIcon;
                if (i3 >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i3];
                if (liveCdnNodeView != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, liveCdnNodeView);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        boolean z = this.lightOn;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        int i4 = this.requiredCount;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i4);
        }
        if (!this.requiredCountDisplay.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.requiredCountDisplay);
        }
        int i5 = this.sentCount;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(7, i5);
        }
        if (!this.sentCountDisplay.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.sentCountDisplay);
        }
        int[] iArr = this.relationGiftIds;
        if (iArr == null || iArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeUInt32SizeNoTag = 0;
        while (true) {
            int[] iArr2 = this.relationGiftIds;
            if (i2 < iArr2.length) {
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i2]);
                i2++;
            } else {
                return iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftAchievementGift mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.giftId = codedInputByteBufferNano.readUInt32();
                    break;
                case 18:
                    this.giftName = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.giftIcon;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.giftIcon, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.giftIcon = liveCdnNodeViewArr2;
                    break;
                case 32:
                    this.lightOn = codedInputByteBufferNano.readBool();
                    break;
                case 40:
                    this.requiredCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 50:
                    this.requiredCountDisplay = codedInputByteBufferNano.readString();
                    break;
                case 56:
                    this.sentCount = codedInputByteBufferNano.readUInt32();
                    break;
                case 66:
                    this.sentCountDisplay = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 72);
                    int[] iArr = this.relationGiftIds;
                    int length2 = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.relationGiftIds, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length - 1) {
                        iArr2[length2] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    this.relationGiftIds = iArr2;
                    break;
                case 74:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.relationGiftIds;
                    int length3 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.relationGiftIds, 0, iArr4, 0, length3);
                    }
                    while (length3 < iArr4.length) {
                        iArr4[length3] = codedInputByteBufferNano.readUInt32();
                        length3++;
                    }
                    this.relationGiftIds = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveGiftAchievementGift parseFrom(byte[] bArr) {
        return (LiveGiftAchievementGift) MessageNano.mergeFrom(new LiveGiftAchievementGift(), bArr);
    }

    public static LiveGiftAchievementGift parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftAchievementGift().mergeFrom(codedInputByteBufferNano);
    }
}
