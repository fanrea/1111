package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class RangeInfo extends MessageNano {
    private static volatile RangeInfo[] _emptyArray;
    public int rangeHigher;
    public int rangeLower;
    public int rangeMod;
    public long[] whiteList;

    public static RangeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RangeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public RangeInfo() {
        clear();
    }

    public final RangeInfo clear() {
        this.rangeLower = 0;
        this.rangeHigher = 0;
        this.rangeMod = 0;
        this.whiteList = WireFormatNano.EMPTY_LONG_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.rangeLower;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.rangeHigher;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        int i3 = this.rangeMod;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        long[] jArr = this.whiteList;
        if (jArr != null && jArr.length > 0) {
            int i4 = 0;
            while (true) {
                long[] jArr2 = this.whiteList;
                if (i4 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeInt64(4, jArr2[i4]);
                i4++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.rangeLower;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.rangeHigher;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        int i3 = this.rangeMod;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        long[] jArr = this.whiteList;
        if (jArr == null || jArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int i4 = 0;
        int iComputeInt64SizeNoTag = 0;
        while (true) {
            long[] jArr2 = this.whiteList;
            if (i4 < jArr2.length) {
                iComputeInt64SizeNoTag += CodedOutputByteBufferNano.computeInt64SizeNoTag(jArr2[i4]);
                i4++;
            } else {
                return iComputeSerializedSize + iComputeInt64SizeNoTag + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final RangeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.rangeLower = codedInputByteBufferNano.readInt32();
            } else if (tag == 16) {
                this.rangeHigher = codedInputByteBufferNano.readInt32();
            } else if (tag == 24) {
                this.rangeMod = codedInputByteBufferNano.readInt32();
            } else if (tag == 32) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                long[] jArr = this.whiteList;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.whiteList, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = codedInputByteBufferNano.readInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readInt64();
                this.whiteList = jArr2;
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readInt64();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.whiteList;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.whiteList, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = codedInputByteBufferNano.readInt64();
                    length2++;
                }
                this.whiteList = jArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            }
        }
    }

    public static RangeInfo parseFrom(byte[] bArr) {
        return (RangeInfo) MessageNano.mergeFrom(new RangeInfo(), bArr);
    }

    public static RangeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new RangeInfo().mergeFrom(codedInputByteBufferNano);
    }
}
