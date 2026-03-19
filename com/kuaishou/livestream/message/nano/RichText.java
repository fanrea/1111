package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class RichText extends MessageNano {
    private static volatile RichText[] _emptyArray;
    public String color;
    public String text;

    public static RichText[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new RichText[0];
                }
            }
        }
        return _emptyArray;
    }

    public RichText() {
        clear();
    }

    public final RichText clear() {
        this.text = "";
        this.color = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.text);
        }
        if (!this.color.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.color);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final RichText mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.color = codedInputByteBufferNano.readString();
            }
        }
    }

    public static RichText parseFrom(byte[] bArr) {
        return (RichText) MessageNano.mergeFrom(new RichText(), bArr);
    }

    public static RichText parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new RichText().mergeFrom(codedInputByteBufferNano);
    }
}
