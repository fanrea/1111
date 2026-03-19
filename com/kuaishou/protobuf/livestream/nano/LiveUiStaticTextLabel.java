package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveUiStaticTextLabel extends MessageNano {
    private static volatile LiveUiStaticTextLabel[] _emptyArray;
    public LiveUiText text;

    public static LiveUiStaticTextLabel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveUiStaticTextLabel[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveUiStaticTextLabel() {
        clear();
    }

    public final LiveUiStaticTextLabel clear() {
        this.text = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveUiText liveUiText = this.text;
        if (liveUiText != null) {
            codedOutputByteBufferNano.writeMessage(1, liveUiText);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveUiText liveUiText = this.text;
        return liveUiText != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveUiText) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveUiStaticTextLabel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.text == null) {
                    this.text = new LiveUiText();
                }
                codedInputByteBufferNano.readMessage(this.text);
            }
        }
    }

    public static LiveUiStaticTextLabel parseFrom(byte[] bArr) {
        return (LiveUiStaticTextLabel) MessageNano.mergeFrom(new LiveUiStaticTextLabel(), bArr);
    }

    public static LiveUiStaticTextLabel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveUiStaticTextLabel().mergeFrom(codedInputByteBufferNano);
    }
}
