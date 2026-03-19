package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCommentStyleConfigSignal extends MessageNano {
    private static volatile SCLiveCommentStyleConfigSignal[] _emptyArray;
    public long delayTimeWorkMs;
    public long showRightMarginDp;

    public static SCLiveCommentStyleConfigSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCommentStyleConfigSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCommentStyleConfigSignal() {
        clear();
    }

    public final SCLiveCommentStyleConfigSignal clear() {
        this.delayTimeWorkMs = 0L;
        this.showRightMarginDp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.delayTimeWorkMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        long j2 = this.showRightMarginDp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(2, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.delayTimeWorkMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        long j2 = this.showRightMarginDp;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(2, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCommentStyleConfigSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.delayTimeWorkMs = codedInputByteBufferNano.readInt64();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.showRightMarginDp = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static SCLiveCommentStyleConfigSignal parseFrom(byte[] bArr) {
        return (SCLiveCommentStyleConfigSignal) MessageNano.mergeFrom(new SCLiveCommentStyleConfigSignal(), bArr);
    }

    public static SCLiveCommentStyleConfigSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCommentStyleConfigSignal().mergeFrom(codedInputByteBufferNano);
    }
}
