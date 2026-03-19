package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024IndicatorPendantSignal extends MessageNano {
    private static volatile SCLiveCny2024IndicatorPendantSignal[] _emptyArray;
    public String activityId;
    public int bizStatus;
    public String bizType;
    public long livestreamId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IndicatorPendantStatus {
        public static final int CLOSE = 2;
        public static final int OPEN = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveCny2024IndicatorPendantSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024IndicatorPendantSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024IndicatorPendantSignal() {
        clear();
    }

    public final SCLiveCny2024IndicatorPendantSignal clear() {
        this.livestreamId = 0L;
        this.activityId = "";
        this.bizType = "";
        this.bizStatus = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.livestreamId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.activityId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.activityId);
        }
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.bizType);
        }
        int i = this.bizStatus;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.livestreamId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.activityId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.activityId);
        }
        if (!this.bizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.bizType);
        }
        int i = this.bizStatus;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024IndicatorPendantSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.livestreamId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.activityId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.bizType = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.bizStatus = int32;
                }
            }
        }
    }

    public static SCLiveCny2024IndicatorPendantSignal parseFrom(byte[] bArr) {
        return (SCLiveCny2024IndicatorPendantSignal) MessageNano.mergeFrom(new SCLiveCny2024IndicatorPendantSignal(), bArr);
    }

    public static SCLiveCny2024IndicatorPendantSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024IndicatorPendantSignal().mergeFrom(codedInputByteBufferNano);
    }
}
