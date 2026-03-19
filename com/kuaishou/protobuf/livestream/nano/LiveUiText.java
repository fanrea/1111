package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveUiText extends MessageNano {
    private static volatile LiveUiText[] _emptyArray;
    public String textColor;
    public String textContent;

    public static LiveUiText[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveUiText[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveUiText() {
        clear();
    }

    public final LiveUiText clear() {
        this.textContent = "";
        this.textColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.textContent.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.textContent);
        }
        if (!this.textColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.textColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.textContent.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.textContent);
        }
        return !this.textColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.textColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveUiText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.textContent = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.textColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveUiText parseFrom(byte[] bArr) {
        return (LiveUiText) MessageNano.mergeFrom(new LiveUiText(), bArr);
    }

    public static LiveUiText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveUiText().mergeFrom(codedInputByteBufferNano);
    }
}
