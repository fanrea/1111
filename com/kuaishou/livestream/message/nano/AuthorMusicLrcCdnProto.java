package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AuthorMusicLrcCdnProto extends MessageNano {
    private static volatile AuthorMusicLrcCdnProto[] _emptyArray;
    public String cdn;
    public String ip;
    public boolean isFreeTrafficCdn;
    public String url;
    public String urlPattern;

    public static AuthorMusicLrcCdnProto[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AuthorMusicLrcCdnProto[0];
                }
            }
        }
        return _emptyArray;
    }

    public AuthorMusicLrcCdnProto() {
        clear();
    }

    public final AuthorMusicLrcCdnProto clear() {
        this.cdn = "";
        this.url = "";
        this.ip = "";
        this.urlPattern = "";
        this.isFreeTrafficCdn = false;
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
        if (!this.ip.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.ip);
        }
        if (!this.urlPattern.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.urlPattern);
        }
        boolean z = this.isFreeTrafficCdn;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.cdn.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
        }
        if (!this.url.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.url);
        }
        if (!this.ip.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.ip);
        }
        if (!this.urlPattern.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.urlPattern);
        }
        boolean z = this.isFreeTrafficCdn;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final AuthorMusicLrcCdnProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.cdn = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.url = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.ip = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.urlPattern = codedInputByteBufferNano.readString();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.isFreeTrafficCdn = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static AuthorMusicLrcCdnProto parseFrom(byte[] bArr) {
        return (AuthorMusicLrcCdnProto) MessageNano.mergeFrom(new AuthorMusicLrcCdnProto(), bArr);
    }

    public static AuthorMusicLrcCdnProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new AuthorMusicLrcCdnProto().mergeFrom(codedInputByteBufferNano);
    }
}
