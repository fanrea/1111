package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GzoneCommonNoticeButton extends MessageNano {
    private static volatile GzoneCommonNoticeButton[] _emptyArray;
    public String text;
    public String url;

    public static GzoneCommonNoticeButton[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneCommonNoticeButton[0];
                }
            }
        }
        return _emptyArray;
    }

    public GzoneCommonNoticeButton() {
        clear();
    }

    public final GzoneCommonNoticeButton clear() {
        this.text = "";
        this.url = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.text);
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.url);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.url) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GzoneCommonNoticeButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.url = codedInputByteBufferNano.readString();
            }
        }
    }

    public static GzoneCommonNoticeButton parseFrom(byte[] bArr) {
        return (GzoneCommonNoticeButton) MessageNano.mergeFrom(new GzoneCommonNoticeButton(), bArr);
    }

    public static GzoneCommonNoticeButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GzoneCommonNoticeButton().mergeFrom(codedInputByteBufferNano);
    }
}
