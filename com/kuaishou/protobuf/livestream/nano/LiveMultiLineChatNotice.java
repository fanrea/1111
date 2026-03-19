package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiLineChatNotice extends MessageNano {
    private static volatile LiveMultiLineChatNotice[] _emptyArray;
    public String content;
    public long displayDuration;

    public static LiveMultiLineChatNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiLineChatNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiLineChatNotice() {
        clear();
    }

    public final LiveMultiLineChatNotice clear() {
        this.content = "";
        this.displayDuration = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.content);
        }
        long j = this.displayDuration;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
        }
        long j = this.displayDuration;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiLineChatNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayDuration = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiLineChatNotice parseFrom(byte[] bArr) {
        return (LiveMultiLineChatNotice) MessageNano.mergeFrom(new LiveMultiLineChatNotice(), bArr);
    }

    public static LiveMultiLineChatNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiLineChatNotice().mergeFrom(codedInputByteBufferNano);
    }
}
