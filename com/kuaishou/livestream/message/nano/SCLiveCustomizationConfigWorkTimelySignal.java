package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCustomizationConfigWorkTimelySignal extends MessageNano {
    private static volatile SCLiveCustomizationConfigWorkTimelySignal[] _emptyArray;
    public long authorId;
    public LiveCustomizationCommentConfig comment;
    public LiveCustomizationShareConfig share;

    public static SCLiveCustomizationConfigWorkTimelySignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCustomizationConfigWorkTimelySignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCustomizationConfigWorkTimelySignal() {
        clear();
    }

    public final SCLiveCustomizationConfigWorkTimelySignal clear() {
        this.authorId = 0L;
        this.comment = null;
        this.share = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        LiveCustomizationCommentConfig liveCustomizationCommentConfig = this.comment;
        if (liveCustomizationCommentConfig != null) {
            codedOutputByteBufferNano.writeMessage(2, liveCustomizationCommentConfig);
        }
        LiveCustomizationShareConfig liveCustomizationShareConfig = this.share;
        if (liveCustomizationShareConfig != null) {
            codedOutputByteBufferNano.writeMessage(3, liveCustomizationShareConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        LiveCustomizationCommentConfig liveCustomizationCommentConfig = this.comment;
        if (liveCustomizationCommentConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveCustomizationCommentConfig);
        }
        LiveCustomizationShareConfig liveCustomizationShareConfig = this.share;
        return liveCustomizationShareConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, liveCustomizationShareConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCustomizationConfigWorkTimelySignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.authorId = codedInputByteBufferNano.readInt64();
            } else if (tag == 18) {
                if (this.comment == null) {
                    this.comment = new LiveCustomizationCommentConfig();
                }
                codedInputByteBufferNano.readMessage(this.comment);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.share == null) {
                    this.share = new LiveCustomizationShareConfig();
                }
                codedInputByteBufferNano.readMessage(this.share);
            }
        }
    }

    public static SCLiveCustomizationConfigWorkTimelySignal parseFrom(byte[] bArr) {
        return (SCLiveCustomizationConfigWorkTimelySignal) MessageNano.mergeFrom(new SCLiveCustomizationConfigWorkTimelySignal(), bArr);
    }

    public static SCLiveCustomizationConfigWorkTimelySignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCustomizationConfigWorkTimelySignal().mergeFrom(codedInputByteBufferNano);
    }
}
