package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CommentNoticeButton extends MessageNano {
    private static volatile CommentNoticeButton[] _emptyArray;
    public float heightPercent;
    public String text;
    public String url;
    public String webUrl;

    public static CommentNoticeButton[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CommentNoticeButton[0];
                }
            }
        }
        return _emptyArray;
    }

    public CommentNoticeButton() {
        clear();
    }

    public final CommentNoticeButton clear() {
        this.text = "";
        this.url = "";
        this.webUrl = "";
        this.heightPercent = 0.0f;
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
        if (!this.webUrl.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.webUrl);
        }
        if (Float.floatToIntBits(this.heightPercent) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(4, this.heightPercent);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        if (!this.url.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.url);
        }
        if (!this.webUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.webUrl);
        }
        return Float.floatToIntBits(this.heightPercent) != Float.floatToIntBits(0.0f) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeFloatSize(4, this.heightPercent) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final CommentNoticeButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.url = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.webUrl = codedInputByteBufferNano.readString();
            } else if (tag != 37) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.heightPercent = codedInputByteBufferNano.readFloat();
            }
        }
    }

    public static CommentNoticeButton parseFrom(byte[] bArr) {
        return (CommentNoticeButton) MessageNano.mergeFrom(new CommentNoticeButton(), bArr);
    }

    public static CommentNoticeButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new CommentNoticeButton().mergeFrom(codedInputByteBufferNano);
    }
}
