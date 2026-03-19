package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkQuickGiftPanelConfig extends MessageNano {
    private static volatile LiveMultiPkQuickGiftPanelConfig[] _emptyArray;
    public long bufferBeforeEnd;
    public int[] giftIdBlackList;
    public String giftToken;
    public long[] giftTypeWhiteList;
    public int[] panelItemTypeWhiteList;
    public LiveMultiPkTimePeriod[] timePeriods;
    public int topN;

    public static LiveMultiPkQuickGiftPanelConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkQuickGiftPanelConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkQuickGiftPanelConfig() {
        clear();
    }

    public final LiveMultiPkQuickGiftPanelConfig clear() {
        this.timePeriods = LiveMultiPkTimePeriod.emptyArray();
        this.bufferBeforeEnd = 0L;
        this.panelItemTypeWhiteList = WireFormatNano.EMPTY_INT_ARRAY;
        this.topN = 0;
        this.giftToken = "";
        this.giftIdBlackList = WireFormatNano.EMPTY_INT_ARRAY;
        this.giftTypeWhiteList = WireFormatNano.EMPTY_LONG_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveMultiPkTimePeriod[] liveMultiPkTimePeriodArr = this.timePeriods;
        int i = 0;
        if (liveMultiPkTimePeriodArr != null && liveMultiPkTimePeriodArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveMultiPkTimePeriod[] liveMultiPkTimePeriodArr2 = this.timePeriods;
                if (i2 >= liveMultiPkTimePeriodArr2.length) {
                    break;
                }
                LiveMultiPkTimePeriod liveMultiPkTimePeriod = liveMultiPkTimePeriodArr2[i2];
                if (liveMultiPkTimePeriod != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveMultiPkTimePeriod);
                }
                i2++;
            }
        }
        long j = this.bufferBeforeEnd;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        int[] iArr = this.panelItemTypeWhiteList;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.panelItemTypeWhiteList;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(3, iArr2[i3]);
                i3++;
            }
        }
        int i4 = this.topN;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i4);
        }
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.giftToken);
        }
        int[] iArr3 = this.giftIdBlackList;
        if (iArr3 != null && iArr3.length > 0) {
            int i5 = 0;
            while (true) {
                int[] iArr4 = this.giftIdBlackList;
                if (i5 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(6, iArr4[i5]);
                i5++;
            }
        }
        long[] jArr = this.giftTypeWhiteList;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.giftTypeWhiteList;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(7, jArr2[i]);
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int[] iArr;
        int[] iArr2;
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveMultiPkTimePeriod[] liveMultiPkTimePeriodArr = this.timePeriods;
        int i = 0;
        if (liveMultiPkTimePeriodArr != null && liveMultiPkTimePeriodArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                LiveMultiPkTimePeriod[] liveMultiPkTimePeriodArr2 = this.timePeriods;
                if (i2 >= liveMultiPkTimePeriodArr2.length) {
                    break;
                }
                LiveMultiPkTimePeriod liveMultiPkTimePeriod = liveMultiPkTimePeriodArr2[i2];
                if (liveMultiPkTimePeriod != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, liveMultiPkTimePeriod);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        long j = this.bufferBeforeEnd;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        int[] iArr3 = this.panelItemTypeWhiteList;
        if (iArr3 != null && iArr3.length > 0) {
            int i3 = 0;
            int iComputeUInt32SizeNoTag = 0;
            while (true) {
                iArr2 = this.panelItemTypeWhiteList;
                if (i3 >= iArr2.length) {
                    break;
                }
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i3]);
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr2.length * 1);
        }
        int i4 = this.topN;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
        }
        if (!this.giftToken.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.giftToken);
        }
        int[] iArr4 = this.giftIdBlackList;
        if (iArr4 != null && iArr4.length > 0) {
            int i5 = 0;
            int iComputeUInt32SizeNoTag2 = 0;
            while (true) {
                iArr = this.giftIdBlackList;
                if (i5 >= iArr.length) {
                    break;
                }
                iComputeUInt32SizeNoTag2 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i5]);
                i5++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag2 + (iArr.length * 1);
        }
        long[] jArr = this.giftTypeWhiteList;
        if (jArr == null || jArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeUInt64SizeNoTag = 0;
        while (true) {
            long[] jArr2 = this.giftTypeWhiteList;
            if (i < jArr2.length) {
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i]);
                i++;
            } else {
                return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkQuickGiftPanelConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    LiveMultiPkTimePeriod[] liveMultiPkTimePeriodArr = this.timePeriods;
                    int length = liveMultiPkTimePeriodArr == null ? 0 : liveMultiPkTimePeriodArr.length;
                    LiveMultiPkTimePeriod[] liveMultiPkTimePeriodArr2 = new LiveMultiPkTimePeriod[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.timePeriods, 0, liveMultiPkTimePeriodArr2, 0, length);
                    }
                    while (length < liveMultiPkTimePeriodArr2.length - 1) {
                        liveMultiPkTimePeriodArr2[length] = new LiveMultiPkTimePeriod();
                        codedInputByteBufferNano.readMessage(liveMultiPkTimePeriodArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveMultiPkTimePeriodArr2[length] = new LiveMultiPkTimePeriod();
                    codedInputByteBufferNano.readMessage(liveMultiPkTimePeriodArr2[length]);
                    this.timePeriods = liveMultiPkTimePeriodArr2;
                    break;
                case 16:
                    this.bufferBeforeEnd = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    int[] iArr = this.panelItemTypeWhiteList;
                    int length2 = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.panelItemTypeWhiteList, 0, iArr2, 0, length2);
                    }
                    while (length2 < iArr2.length - 1) {
                        iArr2[length2] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    iArr2[length2] = codedInputByteBufferNano.readUInt32();
                    this.panelItemTypeWhiteList = iArr2;
                    break;
                case 26:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.panelItemTypeWhiteList;
                    int length3 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.panelItemTypeWhiteList, 0, iArr4, 0, length3);
                    }
                    while (length3 < iArr4.length) {
                        iArr4[length3] = codedInputByteBufferNano.readUInt32();
                        length3++;
                    }
                    this.panelItemTypeWhiteList = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                case 32:
                    this.topN = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.giftToken = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 48);
                    int[] iArr5 = this.giftIdBlackList;
                    int length4 = iArr5 == null ? 0 : iArr5.length;
                    int[] iArr6 = new int[repeatedFieldArrayLength3 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.giftIdBlackList, 0, iArr6, 0, length4);
                    }
                    while (length4 < iArr6.length - 1) {
                        iArr6[length4] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    iArr6[length4] = codedInputByteBufferNano.readUInt32();
                    this.giftIdBlackList = iArr6;
                    break;
                case 50:
                    int iPushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i2 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i2++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.giftIdBlackList;
                    int length5 = iArr7 == null ? 0 : iArr7.length;
                    int[] iArr8 = new int[i2 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.giftIdBlackList, 0, iArr8, 0, length5);
                    }
                    while (length5 < iArr8.length) {
                        iArr8[length5] = codedInputByteBufferNano.readUInt32();
                        length5++;
                    }
                    this.giftIdBlackList = iArr8;
                    codedInputByteBufferNano.popLimit(iPushLimit2);
                    break;
                case 56:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 56);
                    long[] jArr = this.giftTypeWhiteList;
                    int length6 = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength4 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.giftTypeWhiteList, 0, jArr2, 0, length6);
                    }
                    while (length6 < jArr2.length - 1) {
                        jArr2[length6] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length6++;
                    }
                    jArr2[length6] = codedInputByteBufferNano.readUInt64();
                    this.giftTypeWhiteList = jArr2;
                    break;
                case 58:
                    int iPushLimit3 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position3 = codedInputByteBufferNano.getPosition();
                    int i3 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i3++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position3);
                    long[] jArr3 = this.giftTypeWhiteList;
                    int length7 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i3 + length7];
                    if (length7 != 0) {
                        System.arraycopy(this.giftTypeWhiteList, 0, jArr4, 0, length7);
                    }
                    while (length7 < jArr4.length) {
                        jArr4[length7] = codedInputByteBufferNano.readUInt64();
                        length7++;
                    }
                    this.giftTypeWhiteList = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit3);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveMultiPkQuickGiftPanelConfig parseFrom(byte[] bArr) {
        return (LiveMultiPkQuickGiftPanelConfig) MessageNano.mergeFrom(new LiveMultiPkQuickGiftPanelConfig(), bArr);
    }

    public static LiveMultiPkQuickGiftPanelConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkQuickGiftPanelConfig().mergeFrom(codedInputByteBufferNano);
    }
}
