package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCRevenueDeliveryFlowDiversionControl extends MessageNano {
    private static volatile SCRevenueDeliveryFlowDiversionControl[] _emptyArray;
    public long[] blockedAuthorId;
    public long originAuthorId;
    public String originLiveStreamId;
    public int status;

    @Retention(RetentionPolicy.SOURCE)
    public @interface RevenueDeliveryFlowDiversionStatus {
        public static final int ALLOW_FLOW_DIVERSION = 1;
        public static final int BLOCK_FLOW_DIVERSION = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCRevenueDeliveryFlowDiversionControl[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCRevenueDeliveryFlowDiversionControl[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCRevenueDeliveryFlowDiversionControl() {
        clear();
    }

    public final SCRevenueDeliveryFlowDiversionControl clear() {
        this.originAuthorId = 0L;
        this.originLiveStreamId = "";
        this.blockedAuthorId = WireFormatNano.EMPTY_LONG_ARRAY;
        this.status = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.originAuthorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.originLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.originLiveStreamId);
        }
        long[] jArr = this.blockedAuthorId;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.blockedAuthorId;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(3, jArr2[i]);
                i++;
            }
        }
        int i2 = this.status;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.originAuthorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.originLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.originLiveStreamId);
        }
        long[] jArr2 = this.blockedAuthorId;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.blockedAuthorId;
                if (i >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        int i2 = this.status;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCRevenueDeliveryFlowDiversionControl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.originAuthorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.originLiveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 24);
                long[] jArr = this.blockedAuthorId;
                int length = jArr == null ? 0 : jArr.length;
                long[] jArr2 = new long[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.blockedAuthorId, 0, jArr2, 0, length);
                }
                while (length < jArr2.length - 1) {
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                jArr2[length] = codedInputByteBufferNano.readUInt64();
                this.blockedAuthorId = jArr2;
            } else if (tag == 26) {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt64();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                long[] jArr3 = this.blockedAuthorId;
                int length2 = jArr3 == null ? 0 : jArr3.length;
                long[] jArr4 = new long[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.blockedAuthorId, 0, jArr4, 0, length2);
                }
                while (length2 < jArr4.length) {
                    jArr4[length2] = codedInputByteBufferNano.readUInt64();
                    length2++;
                }
                this.blockedAuthorId = jArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.status = int32;
                }
            }
        }
    }

    public static SCRevenueDeliveryFlowDiversionControl parseFrom(byte[] bArr) {
        return (SCRevenueDeliveryFlowDiversionControl) MessageNano.mergeFrom(new SCRevenueDeliveryFlowDiversionControl(), bArr);
    }

    public static SCRevenueDeliveryFlowDiversionControl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCRevenueDeliveryFlowDiversionControl().mergeFrom(codedInputByteBufferNano);
    }
}
