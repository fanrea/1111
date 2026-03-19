package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class TheaterEpisodePhotoCdnProto extends MessageNano {
    private static volatile TheaterEpisodePhotoCdnProto[] _emptyArray;
    public String cdn;
    public boolean isFreeTrafficCdn;
    public String url;

    public static TheaterEpisodePhotoCdnProto[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new TheaterEpisodePhotoCdnProto[0];
                }
            }
        }
        return _emptyArray;
    }

    public TheaterEpisodePhotoCdnProto() {
        clear();
    }

    public final TheaterEpisodePhotoCdnProto clear() {
        this.cdn = "";
        this.url = "";
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
        boolean z = this.isFreeTrafficCdn;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
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
        boolean z = this.isFreeTrafficCdn;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final TheaterEpisodePhotoCdnProto mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.cdn = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.url = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.isFreeTrafficCdn = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static TheaterEpisodePhotoCdnProto parseFrom(byte[] bArr) {
        return (TheaterEpisodePhotoCdnProto) MessageNano.mergeFrom(new TheaterEpisodePhotoCdnProto(), bArr);
    }

    public static TheaterEpisodePhotoCdnProto parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new TheaterEpisodePhotoCdnProto().mergeFrom(codedInputByteBufferNano);
    }
}
