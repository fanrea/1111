package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Round extends MessageNano {
    private static volatile Round[] _emptyArray;
    public long[] barrier;
    public long cost;
    public Horse[] horse;
    public int policy;
    public long startTime;
    public boolean success;
    public String tag;
    public long timeout;

    public static Round[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Round[0];
                }
            }
        }
        return _emptyArray;
    }

    public Round() {
        clear();
    }

    public final Round clear() {
        this.policy = 0;
        this.timeout = 0L;
        this.barrier = WireFormatNano.EMPTY_LONG_ARRAY;
        this.tag = "";
        this.horse = Horse.emptyArray();
        this.success = false;
        this.startTime = 0L;
        this.cost = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.policy;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.timeout;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long[] jArr = this.barrier;
        int i2 = 0;
        if (jArr != null && jArr.length > 0) {
            int i3 = 0;
            while (true) {
                long[] jArr2 = this.barrier;
                if (i3 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i3]);
                i3++;
            }
        }
        if (!this.tag.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.tag);
        }
        Horse[] horseArr = this.horse;
        if (horseArr != null && horseArr.length > 0) {
            while (true) {
                Horse[] horseArr2 = this.horse;
                if (i2 >= horseArr2.length) {
                    break;
                }
                Horse horse = horseArr2[i2];
                if (horse != null) {
                    codedOutputByteBufferNano.writeMessage(6, horse);
                }
                i2++;
            }
        }
        boolean z = this.success;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        long j2 = this.startTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        long j3 = this.cost;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.policy;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.timeout;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long[] jArr2 = this.barrier;
        int i2 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i3 = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.barrier;
                if (i3 >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i3]);
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        if (!this.tag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.tag);
        }
        Horse[] horseArr = this.horse;
        if (horseArr != null && horseArr.length > 0) {
            while (true) {
                Horse[] horseArr2 = this.horse;
                if (i2 >= horseArr2.length) {
                    break;
                }
                Horse horse = horseArr2[i2];
                if (horse != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, horse);
                }
                i2++;
            }
        }
        boolean z = this.success;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        long j2 = this.startTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        long j3 = this.cost;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Round mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.policy = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.timeout = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                long[] jArr = this.barrier;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.barrier, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.barrier = jArr2;
            } else if (tag == 26) {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.barrier;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.barrier, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.barrier = jArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            } else if (tag == 34) {
                this.tag = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                Horse[] horseArr = this.horse;
                int length3 = horseArr == null ? 0 : horseArr.length;
                Horse[] horseArr2 = new Horse[repeatedFieldArrayLength2 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.horse, 0, horseArr2, 0, length3);
                }
                while (length3 < horseArr2.length - 1) {
                    horseArr2[length3] = new Horse();
                    codedInputByteBufferNano.readMessage(horseArr2[length3]);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                horseArr2[length3] = new Horse();
                codedInputByteBufferNano.readMessage(horseArr2[length3]);
                this.horse = horseArr2;
            } else if (tag == 56) {
                this.success = codedInputByteBufferNano.readBool();
            } else if (tag == 64) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (tag != 72) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.cost = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static Round parseFrom(byte[] bArr) {
        return (Round) MessageNano.mergeFrom(new Round(), bArr);
    }

    public static Round parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Round().mergeFrom(codedInputByteBufferNano);
    }
}
