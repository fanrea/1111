package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CloseSessionPayload extends MessageNano {
    private static volatile CloseSessionPayload[] _emptyArray;
    public int reason;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseReason {
        public static final int NONE = 0;
        public static final int ROOM_NOT_FOUND = 1;
    }

    public static CloseSessionPayload[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CloseSessionPayload[0];
                }
            }
        }
        return _emptyArray;
    }

    public CloseSessionPayload() {
        clear();
    }

    public final CloseSessionPayload clear() {
        this.reason = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.reason;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.reason;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(1, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final CloseSessionPayload mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.reason = int32;
                }
            }
        }
    }

    public static CloseSessionPayload parseFrom(byte[] bArr) {
        return (CloseSessionPayload) MessageNano.mergeFrom(new CloseSessionPayload(), bArr);
    }

    public static CloseSessionPayload parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new CloseSessionPayload().mergeFrom(codedInputByteBufferNano);
    }
}
