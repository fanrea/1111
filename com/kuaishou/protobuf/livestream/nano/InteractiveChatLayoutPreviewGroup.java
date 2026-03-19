package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveChatLayoutPreviewGroup extends MessageNano {
    private static volatile InteractiveChatLayoutPreviewGroup[] _emptyArray;
    public int groupId;
    public long[] userId;

    public static InteractiveChatLayoutPreviewGroup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatLayoutPreviewGroup[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatLayoutPreviewGroup() {
        clear();
    }

    public final InteractiveChatLayoutPreviewGroup clear() {
        this.userId = WireFormatNano.EMPTY_LONG_ARRAY;
        this.groupId = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long[] jArr = this.userId;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.userId;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(1, jArr2[i]);
                i++;
            }
        }
        int i2 = this.groupId;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        long[] jArr2 = this.userId;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.userId;
                if (i >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        int i2 = this.groupId;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatLayoutPreviewGroup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 8);
                long[] jArr = this.userId;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.userId, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.userId = jArr2;
            } else if (tag == 10) {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.userId;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.userId, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.userId = jArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.groupId = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static InteractiveChatLayoutPreviewGroup parseFrom(byte[] bArr) {
        return (InteractiveChatLayoutPreviewGroup) MessageNano.mergeFrom(new InteractiveChatLayoutPreviewGroup(), bArr);
    }

    public static InteractiveChatLayoutPreviewGroup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatLayoutPreviewGroup().mergeFrom(codedInputByteBufferNano);
    }
}
