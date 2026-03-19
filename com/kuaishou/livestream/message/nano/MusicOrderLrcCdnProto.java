package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MusicOrderLrcCdnProto extends MessageNano {
    private static volatile MusicOrderLrcCdnProto[] _emptyArray;
    public String cdn;
    public String ip;
    public boolean isFreeTrafficCdn;
    public String url;
    public String urlPattern;

    public static MusicOrderLrcCdnProto[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MusicOrderLrcCdnProto[0];
                }
            }
        }
        return _emptyArray;
    }

    public MusicOrderLrcCdnProto() {
        clear();
    }

    public final MusicOrderLrcCdnProto clear() {
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
    public final MusicOrderLrcCdnProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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

    public static MusicOrderLrcCdnProto parseFrom(byte[] bArr) {
        return (MusicOrderLrcCdnProto) MessageNano.mergeFrom(new MusicOrderLrcCdnProto(), bArr);
    }

    public static MusicOrderLrcCdnProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MusicOrderLrcCdnProto().mergeFrom(codedInputByteBufferNano);
    }
}
