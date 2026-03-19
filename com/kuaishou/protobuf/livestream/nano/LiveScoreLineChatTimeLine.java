package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatTimeLine extends MessageNano {
    private static volatile LiveScoreLineChatTimeLine[] _emptyArray;
    public long exceedDeadlineBuffer;
    public long penaltyDeadline;
    public long voteDeadline;

    public static LiveScoreLineChatTimeLine[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatTimeLine[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatTimeLine() {
        clear();
    }

    public final LiveScoreLineChatTimeLine clear() {
        this.voteDeadline = 0L;
        this.penaltyDeadline = 0L;
        this.exceedDeadlineBuffer = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.voteDeadline;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.penaltyDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.exceedDeadlineBuffer;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.voteDeadline;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.penaltyDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.exceedDeadlineBuffer;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatTimeLine mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.voteDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.penaltyDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.exceedDeadlineBuffer = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveScoreLineChatTimeLine parseFrom(byte[] bArr) {
        return (LiveScoreLineChatTimeLine) MessageNano.mergeFrom(new LiveScoreLineChatTimeLine(), bArr);
    }

    public static LiveScoreLineChatTimeLine parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatTimeLine().mergeFrom(codedInputByteBufferNano);
    }
}
