package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SidList extends MessageNano {
    private static volatile SidList[] _emptyArray;
    public int[] sid;

    public static SidList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SidList[0];
                }
            }
        }
        return _emptyArray;
    }

    public SidList() {
        clear();
    }

    public final SidList clear() {
        this.sid = WireFormatNano.EMPTY_INT_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int[] iArr = this.sid;
        if (iArr != null && iArr.length > 0) {
            int i = 0;
            while (true) {
                int[] iArr2 = this.sid;
                if (i >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(1, iArr2[i]);
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int[] iArr = this.sid;
        if (iArr == null || iArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int i = 0;
        int iComputeUInt32SizeNoTag = 0;
        while (true) {
            int[] iArr2 = this.sid;
            if (i < iArr2.length) {
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr2[i]);
                i++;
            } else {
                return iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SidList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                int[] iArr = this.sid;
                int length = iArr == null ? 0 : iArr.length;
                int[] iArr2 = new int[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.sid, 0, iArr2, 0, length);
                }
                while (length < iArr2.length - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.sid = iArr2;
            } else if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.sid;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int[] iArr4 = new int[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.sid, 0, iArr4, 0, length2);
                }
                while (length2 < iArr4.length) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.sid = iArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            }
        }
    }

    public static SidList parseFrom(byte[] bArr) {
        return (SidList) MessageNano.mergeFrom(new SidList(), bArr);
    }

    public static SidList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SidList().mergeFrom(codedInputByteBufferNano);
    }
}
