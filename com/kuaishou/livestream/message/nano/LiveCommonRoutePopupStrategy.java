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
public final class LiveCommonRoutePopupStrategy extends MessageNano {
    private static volatile LiveCommonRoutePopupStrategy[] _emptyArray;
    public long minIntervalMs;
    public int pendingStrategy;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PendingStrategy {
        public static final int QUEUE = 1;
        public static final int STACK = 2;
        public static final int UNKNOWN = 0;
    }

    public static LiveCommonRoutePopupStrategy[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCommonRoutePopupStrategy[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCommonRoutePopupStrategy() {
        clear();
    }

    public final LiveCommonRoutePopupStrategy clear() {
        this.pendingStrategy = 0;
        this.minIntervalMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.pendingStrategy;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.minIntervalMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.pendingStrategy;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.minIntervalMs;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCommonRoutePopupStrategy mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.pendingStrategy = int32;
                }
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.minIntervalMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveCommonRoutePopupStrategy parseFrom(byte[] bArr) {
        return (LiveCommonRoutePopupStrategy) MessageNano.mergeFrom(new LiveCommonRoutePopupStrategy(), bArr);
    }

    public static LiveCommonRoutePopupStrategy parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCommonRoutePopupStrategy().mergeFrom(codedInputByteBufferNano);
    }
}
