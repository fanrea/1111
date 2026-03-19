package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiLinePkWarmUpStartExtraInfo extends MessageNano {
    private static volatile LiveMultiLinePkWarmUpStartExtraInfo[] _emptyArray;
    public long warmUpEndDeadline;
    public long warmUpEndNotifyDeadline;
    public String warmUpToast;
    public int warmUpToastDuration;

    public static LiveMultiLinePkWarmUpStartExtraInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiLinePkWarmUpStartExtraInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiLinePkWarmUpStartExtraInfo() {
        clear();
    }

    public final LiveMultiLinePkWarmUpStartExtraInfo clear() {
        this.warmUpToast = "";
        this.warmUpToastDuration = 0;
        this.warmUpEndDeadline = 0L;
        this.warmUpEndNotifyDeadline = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.warmUpToast.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.warmUpToast);
        }
        int i = this.warmUpToastDuration;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        long j = this.warmUpEndDeadline;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.warmUpEndNotifyDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.warmUpToast.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.warmUpToast);
        }
        int i = this.warmUpToastDuration;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        long j = this.warmUpEndDeadline;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.warmUpEndNotifyDeadline;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiLinePkWarmUpStartExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.warmUpToast = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.warmUpToastDuration = codedInputByteBufferNano.readUInt32();
            } else if (tag == 24) {
                this.warmUpEndDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.warmUpEndNotifyDeadline = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiLinePkWarmUpStartExtraInfo parseFrom(byte[] bArr) {
        return (LiveMultiLinePkWarmUpStartExtraInfo) MessageNano.mergeFrom(new LiveMultiLinePkWarmUpStartExtraInfo(), bArr);
    }

    public static LiveMultiLinePkWarmUpStartExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiLinePkWarmUpStartExtraInfo().mergeFrom(codedInputByteBufferNano);
    }
}
