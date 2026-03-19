package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ClickCommentNoticeEvent extends MessageNano {
    private static volatile ClickCommentNoticeEvent[] _emptyArray;
    public boolean fullScreen;
    public float heightPercent;
    public String url;
    public String webUrl;

    public static ClickCommentNoticeEvent[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ClickCommentNoticeEvent[0];
                }
            }
        }
        return _emptyArray;
    }

    public ClickCommentNoticeEvent() {
        clear();
    }

    public final ClickCommentNoticeEvent clear() {
        this.url = "";
        this.fullScreen = false;
        this.heightPercent = 0.0f;
        this.webUrl = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.url);
        }
        boolean z = this.fullScreen;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        if (Float.floatToIntBits(this.heightPercent) != Float.floatToIntBits(0.0f)) {
            codedOutputByteBufferNano.writeFloat(3, this.heightPercent);
        }
        if (!this.webUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.webUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.url.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.url);
        }
        boolean z = this.fullScreen;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        if (Float.floatToIntBits(this.heightPercent) != Float.floatToIntBits(0.0f)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeFloatSize(3, this.heightPercent);
        }
        return !this.webUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.webUrl) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ClickCommentNoticeEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.url = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.fullScreen = codedInputByteBufferNano.readBool();
            } else if (tag == 29) {
                this.heightPercent = codedInputByteBufferNano.readFloat();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.webUrl = codedInputByteBufferNano.readString();
            }
        }
    }

    public static ClickCommentNoticeEvent parseFrom(byte[] bArr) {
        return (ClickCommentNoticeEvent) MessageNano.mergeFrom(new ClickCommentNoticeEvent(), bArr);
    }

    public static ClickCommentNoticeEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ClickCommentNoticeEvent().mergeFrom(codedInputByteBufferNano);
    }
}
