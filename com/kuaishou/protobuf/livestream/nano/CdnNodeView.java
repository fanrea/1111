package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class CdnNodeView extends MessageNano {
    private static volatile CdnNodeView[] _emptyArray;
    public String cdn;
    public String url;

    public static CdnNodeView[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new CdnNodeView[0];
                }
            }
        }
        return _emptyArray;
    }

    public CdnNodeView() {
        clear();
    }

    public final CdnNodeView clear() {
        this.cdn = "";
        this.url = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.cdn.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.cdn);
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.url);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.cdn.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
        }
        return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.url) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final CdnNodeView mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.cdn = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.url = codedInputByteBufferNano.readString();
            }
        }
    }

    public static CdnNodeView parseFrom(byte[] bArr) {
        return (CdnNodeView) MessageNano.mergeFrom(new CdnNodeView(), bArr);
    }

    public static CdnNodeView parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new CdnNodeView().mergeFrom(codedInputByteBufferNano);
    }
}
