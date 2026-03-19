package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class InteractiveChatWindowFrameColor extends MessageNano {
    private static volatile InteractiveChatWindowFrameColor[] _emptyArray;
    public String endColor;
    public String startColor;

    public static InteractiveChatWindowFrameColor[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatWindowFrameColor[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatWindowFrameColor() {
        clear();
    }

    public final InteractiveChatWindowFrameColor clear() {
        this.startColor = "";
        this.endColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.startColor.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.startColor);
        }
        if (!this.endColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.endColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.startColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.startColor);
        }
        return !this.endColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.endColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatWindowFrameColor mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.startColor = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.endColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static InteractiveChatWindowFrameColor parseFrom(byte[] bArr) {
        return (InteractiveChatWindowFrameColor) MessageNano.mergeFrom(new InteractiveChatWindowFrameColor(), bArr);
    }

    public static InteractiveChatWindowFrameColor parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatWindowFrameColor().mergeFrom(codedInputByteBufferNano);
    }
}
