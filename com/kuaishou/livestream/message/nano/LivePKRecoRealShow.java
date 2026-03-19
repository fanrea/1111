package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePKRecoRealShow extends MessageNano {
    private static volatile LivePKRecoRealShow[] _emptyArray;
    public long authorId;
    public long llsid;
    public long recoId;
    public long[] userIdList;

    public static LivePKRecoRealShow[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePKRecoRealShow[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePKRecoRealShow() {
        clear();
    }

    public final LivePKRecoRealShow clear() {
        this.recoId = 0L;
        this.authorId = 0L;
        this.userIdList = WireFormatNano.EMPTY_LONG_ARRAY;
        this.llsid = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.recoId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long[] jArr = this.userIdList;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.userIdList;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i]);
                i++;
            }
        }
        long j3 = this.llsid;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(4, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.recoId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long[] jArr2 = this.userIdList;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.userIdList;
                if (i >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        long j3 = this.llsid;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(4, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePKRecoRealShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.recoId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                long[] jArr = this.userIdList;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.userIdList, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.userIdList = jArr2;
            } else if (tag == 26) {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.userIdList;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.userIdList, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.userIdList = jArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.llsid = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static LivePKRecoRealShow parseFrom(byte[] bArr) {
        return (LivePKRecoRealShow) MessageNano.mergeFrom(new LivePKRecoRealShow(), bArr);
    }

    public static LivePKRecoRealShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePKRecoRealShow().mergeFrom(codedInputByteBufferNano);
    }
}
