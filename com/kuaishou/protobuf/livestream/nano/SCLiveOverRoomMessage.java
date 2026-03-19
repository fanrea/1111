package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveOverRoomMessage extends MessageNano {
    private static volatile SCLiveOverRoomMessage[] _emptyArray;
    public long[] disableAuthor;
    public int[] disableLiveStreamType;
    public byte[] messagePayload;
    public int messageType;
    public int[] onlyEnableLiveStreamType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
        public static final int SHOP_HOT_ITEM = 1;
        public static final int SHOP_ONE_YUAN = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveOverRoomMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveOverRoomMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveOverRoomMessage() {
        clear();
    }

    public final SCLiveOverRoomMessage clear() {
        this.messageType = 0;
        this.messagePayload = WireFormatNano.EMPTY_BYTES;
        this.disableLiveStreamType = WireFormatNano.EMPTY_INT_ARRAY;
        this.onlyEnableLiveStreamType = WireFormatNano.EMPTY_INT_ARRAY;
        this.disableAuthor = WireFormatNano.EMPTY_LONG_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.messageType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!Arrays.equals(this.messagePayload, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.messagePayload);
        }
        int[] iArr = this.disableLiveStreamType;
        int i2 = 0;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.disableLiveStreamType;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(3, iArr2[i3]);
                i3++;
            }
        }
        int[] iArr3 = this.onlyEnableLiveStreamType;
        if (iArr3 != null && iArr3.length > 0) {
            int i4 = 0;
            while (true) {
                int[] iArr4 = this.onlyEnableLiveStreamType;
                if (i4 >= iArr4.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(4, iArr4[i4]);
                i4++;
            }
        }
        long[] jArr = this.disableAuthor;
        if (jArr != null && jArr.length > 0) {
            while (true) {
                long[] jArr2 = this.disableAuthor;
                if (i2 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(5, jArr2[i2]);
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int[] iArr;
        int[] iArr2;
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.messageType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!Arrays.equals(this.messagePayload, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.messagePayload);
        }
        int[] iArr3 = this.disableLiveStreamType;
        int i2 = 0;
        if (iArr3 != null && iArr3.length > 0) {
            int i3 = 0;
            int iComputeUInt32SizeNoTag = 0;
            while (true) {
                iArr2 = this.disableLiveStreamType;
                if (i3 >= iArr2.length) {
                    break;
                }
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i3]);
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr2.length * 1);
        }
        int[] iArr4 = this.onlyEnableLiveStreamType;
        if (iArr4 != null && iArr4.length > 0) {
            int i4 = 0;
            int iComputeUInt32SizeNoTag2 = 0;
            while (true) {
                iArr = this.onlyEnableLiveStreamType;
                if (i4 >= iArr.length) {
                    break;
                }
                iComputeUInt32SizeNoTag2 += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i4]);
                i4++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag2 + (iArr.length * 1);
        }
        long[] jArr = this.disableAuthor;
        if (jArr == null || jArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeUInt64SizeNoTag = 0;
        while (true) {
            long[] jArr2 = this.disableAuthor;
            if (i2 < jArr2.length) {
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i2]);
                i2++;
            } else {
                return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveOverRoomMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.messageType = int32;
                }
            } else if (tag == 18) {
                this.messagePayload = codedInputByteBufferNano.readBytes();
            } else if (tag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
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
            } else if (tag == 26) {
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
            } else if (tag == 32) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
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
            } else if (tag == 34) {
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
            } else if (tag == 40) {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 40);
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
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
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
            }
        }
    }

    public static SCLiveOverRoomMessage parseFrom(byte[] bArr) {
        return (SCLiveOverRoomMessage) MessageNano.mergeFrom(new SCLiveOverRoomMessage(), bArr);
    }

    public static SCLiveOverRoomMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveOverRoomMessage().mergeFrom(codedInputByteBufferNano);
    }
}
