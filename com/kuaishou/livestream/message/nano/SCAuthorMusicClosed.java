package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCAuthorMusicClosed extends MessageNano {
    private static volatile SCAuthorMusicClosed[] _emptyArray;
    public String liveStreamId;
    public int sequence;

    public static SCAuthorMusicClosed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCAuthorMusicClosed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCAuthorMusicClosed() {
        clear();
    }

    public final SCAuthorMusicClosed clear() {
        this.liveStreamId = "";
        this.sequence = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.sequence;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.sequence;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCAuthorMusicClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.sequence = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCAuthorMusicClosed parseFrom(byte[] bArr) {
        return (SCAuthorMusicClosed) MessageNano.mergeFrom(new SCAuthorMusicClosed(), bArr);
    }

    public static SCAuthorMusicClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCAuthorMusicClosed().mergeFrom(codedInputByteBufferNano);
    }
}
