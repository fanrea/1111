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
public final class SCLiveBulletCloudPlayOperationTypeNotice extends MessageNano {
    private static volatile SCLiveBulletCloudPlayOperationTypeNotice[] _emptyArray;
    public int operationType;
    public long timestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OperationType {
        public static final int AUDIENCE_JOIN = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveBulletCloudPlayOperationTypeNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletCloudPlayOperationTypeNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletCloudPlayOperationTypeNotice() {
        clear();
    }

    public final SCLiveBulletCloudPlayOperationTypeNotice clear() {
        this.operationType = 0;
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.operationType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.operationType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletCloudPlayOperationTypeNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.operationType = int32;
                }
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveBulletCloudPlayOperationTypeNotice parseFrom(byte[] bArr) {
        return (SCLiveBulletCloudPlayOperationTypeNotice) MessageNano.mergeFrom(new SCLiveBulletCloudPlayOperationTypeNotice(), bArr);
    }

    public static SCLiveBulletCloudPlayOperationTypeNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletCloudPlayOperationTypeNotice().mergeFrom(codedInputByteBufferNano);
    }
}
