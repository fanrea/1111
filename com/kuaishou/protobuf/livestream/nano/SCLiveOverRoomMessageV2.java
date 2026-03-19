package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveOverRoomMessageV2 extends MessageNano {
    private static volatile SCLiveOverRoomMessageV2[] _emptyArray;
    public int bizType;
    public long delayTimeMs;
    public long[] disableAuthor;
    public int[] disableLiveStreamType;
    public LiveOverRoomMessageDisplayInfo displayInfo;
    public LiveOverRoomMessageDisplayInfoOld displayInfoOld;
    public String messageId;
    public int messageType;
    public int[] onlyEnableLiveStreamType;

    public static SCLiveOverRoomMessageV2[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveOverRoomMessageV2[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveOverRoomMessageV2() {
        clear();
    }

    public final SCLiveOverRoomMessageV2 clear() {
        this.disableLiveStreamType = WireFormatNano.EMPTY_INT_ARRAY;
        this.onlyEnableLiveStreamType = WireFormatNano.EMPTY_INT_ARRAY;
        this.disableAuthor = WireFormatNano.EMPTY_LONG_ARRAY;
        this.displayInfo = null;
        this.bizType = 0;
        this.displayInfoOld = null;
        this.messageId = "";
        this.messageType = 0;
        this.delayTimeMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int[] iArr = this.disableLiveStreamType;
        int i = 0;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.disableLiveStreamType;
                if (i2 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(1, iArr2[i2]);
                i2++;
            }
        }
        int[] iArr3 = this.onlyEnableLiveStreamType;
        if (iArr3 != null && iArr3.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr4 = this.onlyEnableLiveStreamType;
                if (i3 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(2, iArr4[i3]);
                i3++;
            }
        }
        long[] jArr = this.disableAuthor;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.disableAuthor;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i]);
                i++;
            }
        }
        LiveOverRoomMessageDisplayInfo liveOverRoomMessageDisplayInfo = this.displayInfo;
        if (liveOverRoomMessageDisplayInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, liveOverRoomMessageDisplayInfo);
        }
        int i4 = this.bizType;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i4);
        }
        LiveOverRoomMessageDisplayInfoOld liveOverRoomMessageDisplayInfoOld = this.displayInfoOld;
        if (liveOverRoomMessageDisplayInfoOld != null) {
            codedOutputByteBufferNano.writeMessage(10, liveOverRoomMessageDisplayInfoOld);
        }
        if (!this.messageId.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.messageId);
        }
        int i5 = this.messageType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(12, i5);
        }
        long j = this.delayTimeMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(13, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int[] iArr;
        int[] iArr2;
        int iComputeSerializedSize = super.computeSerializedSize();
        int[] iArr3 = this.disableLiveStreamType;
        int i = 0;
        if (iArr3 != null && iArr3.length > 0) {
            int i2 = 0;
            int iComputeUInt32SizeNoTag = 0;
            while (true) {
                iArr2 = this.disableLiveStreamType;
                if (i2 >= iArr2.length) {
                    break;
                }
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i2]);
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr2.length * 1);
        }
        int[] iArr4 = this.onlyEnableLiveStreamType;
        if (iArr4 != null && iArr4.length > 0) {
            int i3 = 0;
            int iComputeUInt32SizeNoTag2 = 0;
            while (true) {
                iArr = this.onlyEnableLiveStreamType;
                if (i3 >= iArr.length) {
                    break;
                }
                iComputeUInt32SizeNoTag2 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag2 + (iArr.length * 1);
        }
        long[] jArr2 = this.disableAuthor;
        if (jArr2 != null && jArr2.length > 0) {
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.disableAuthor;
                if (i >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        LiveOverRoomMessageDisplayInfo liveOverRoomMessageDisplayInfo = this.displayInfo;
        if (liveOverRoomMessageDisplayInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveOverRoomMessageDisplayInfo);
        }
        int i4 = this.bizType;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i4);
        }
        LiveOverRoomMessageDisplayInfoOld liveOverRoomMessageDisplayInfoOld = this.displayInfoOld;
        if (liveOverRoomMessageDisplayInfoOld != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, liveOverRoomMessageDisplayInfoOld);
        }
        if (!this.messageId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.messageId);
        }
        int i5 = this.messageType;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(12, i5);
        }
        long j = this.delayTimeMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(13, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveOverRoomMessageV2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                    int[] iArr = this.disableLiveStreamType;
                    int length = iArr == null ? 0 : iArr.length;
                    int[] iArr2 = new int[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.disableLiveStreamType, 0, iArr2, 0, length);
                    }
                    while (length < iArr2.length - 1) {
                        iArr2[length] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    this.disableLiveStreamType = iArr2;
                    break;
                case 10:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    int[] iArr3 = this.disableLiveStreamType;
                    int length2 = iArr3 == null ? 0 : iArr3.length;
                    int[] iArr4 = new int[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.disableLiveStreamType, 0, iArr4, 0, length2);
                    }
                    while (length2 < iArr4.length) {
                        iArr4[length2] = codedInputByteBufferNano.readUInt32();
                        length2++;
                    }
                    this.disableLiveStreamType = iArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                case 16:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 16);
                    int[] iArr5 = this.onlyEnableLiveStreamType;
                    int length3 = iArr5 == null ? 0 : iArr5.length;
                    int[] iArr6 = new int[repeatedFieldArrayLength2 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.onlyEnableLiveStreamType, 0, iArr6, 0, length3);
                    }
                    while (length3 < iArr6.length - 1) {
                        iArr6[length3] = codedInputByteBufferNano.readUInt32();
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    iArr6[length3] = codedInputByteBufferNano.readUInt32();
                    this.onlyEnableLiveStreamType = iArr6;
                    break;
                case 18:
                    int iPushLimit2 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position2 = codedInputByteBufferNano.getPosition();
                    int i2 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt32();
                        i2++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position2);
                    int[] iArr7 = this.onlyEnableLiveStreamType;
                    int length4 = iArr7 == null ? 0 : iArr7.length;
                    int[] iArr8 = new int[i2 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.onlyEnableLiveStreamType, 0, iArr8, 0, length4);
                    }
                    while (length4 < iArr8.length) {
                        iArr8[length4] = codedInputByteBufferNano.readUInt32();
                        length4++;
                    }
                    this.onlyEnableLiveStreamType = iArr8;
                    codedInputByteBufferNano.popLimit(iPushLimit2);
                    break;
                case 24:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                    long[] jArr = this.disableAuthor;
                    int length5 = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength3 + length5];
                    if (length5 != 0) {
                        System.arraycopy(this.disableAuthor, 0, jArr2, 0, length5);
                    }
                    while (length5 < jArr2.length - 1) {
                        jArr2[length5] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length5++;
                    }
                    jArr2[length5] = codedInputByteBufferNano.readUInt64();
                    this.disableAuthor = jArr2;
                    break;
                case 26:
                    int iPushLimit3 = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position3 = codedInputByteBufferNano.getPosition();
                    int i3 = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i3++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position3);
                    long[] jArr3 = this.disableAuthor;
                    int length6 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i3 + length6];
                    if (length6 != 0) {
                        System.arraycopy(this.disableAuthor, 0, jArr4, 0, length6);
                    }
                    while (length6 < jArr4.length) {
                        jArr4[length6] = codedInputByteBufferNano.readUInt64();
                        length6++;
                    }
                    this.disableAuthor = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit3);
                    break;
                case 34:
                    if (this.displayInfo == null) {
                        this.displayInfo = new LiveOverRoomMessageDisplayInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.displayInfo);
                    break;
                case 40:
                    int int32 = codedInputByteBufferNano.readInt32();
                    switch (int32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                            this.bizType = int32;
                            break;
                    }
                case 82:
                    if (this.displayInfoOld == null) {
                        this.displayInfoOld = new LiveOverRoomMessageDisplayInfoOld();
                    }
                    codedInputByteBufferNano.readMessage(this.displayInfoOld);
                    break;
                case 90:
                    this.messageId = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2 && int322 != 3) {
                        break;
                    } else {
                        this.messageType = int322;
                        break;
                    }
                case 104:
                    this.delayTimeMs = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveOverRoomMessageV2 parseFrom(byte[] bArr) {
        return (SCLiveOverRoomMessageV2) MessageNano.mergeFrom(new SCLiveOverRoomMessageV2(), bArr);
    }

    public static SCLiveOverRoomMessageV2 parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveOverRoomMessageV2().mergeFrom(codedInputByteBufferNano);
    }
}
