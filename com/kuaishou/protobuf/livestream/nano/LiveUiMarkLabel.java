package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveUiMarkLabel extends MessageNano {
    private static volatile LiveUiMarkLabel[] _emptyArray;
    public LiveUiStaticTextLabel staticTextLabel;

    public static LiveUiMarkLabel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveUiMarkLabel[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveUiMarkLabel() {
        clear();
    }

    public final LiveUiMarkLabel clear() {
        this.staticTextLabel = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveUiStaticTextLabel liveUiStaticTextLabel = this.staticTextLabel;
        if (liveUiStaticTextLabel != null) {
            codedOutputByteBufferNano.writeMessage(1, liveUiStaticTextLabel);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveUiStaticTextLabel liveUiStaticTextLabel = this.staticTextLabel;
        return liveUiStaticTextLabel != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveUiStaticTextLabel) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveUiMarkLabel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.staticTextLabel == null) {
                    this.staticTextLabel = new LiveUiStaticTextLabel();
                }
                codedInputByteBufferNano.readMessage(this.staticTextLabel);
            }
        }
    }

    public static LiveUiMarkLabel parseFrom(byte[] bArr) {
        return (LiveUiMarkLabel) MessageNano.mergeFrom(new LiveUiMarkLabel(), bArr);
    }

    public static LiveUiMarkLabel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveUiMarkLabel().mergeFrom(codedInputByteBufferNano);
    }
}
