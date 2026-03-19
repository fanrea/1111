package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLteQosGrabToken extends MessageNano {
    private static volatile SCLteQosGrabToken[] _emptyArray;
    public long authorId;
    public String grabTokenUrl;
    public String liveStreamId;
    public boolean needToken;

    public static SCLteQosGrabToken[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLteQosGrabToken[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLteQosGrabToken() {
        clear();
    }

    public final SCLteQosGrabToken clear() {
        this.liveStreamId = "";
        this.authorId = 0L;
        this.needToken = false;
        this.grabTokenUrl = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        boolean z = this.needToken;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        if (!this.grabTokenUrl.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.grabTokenUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        boolean z = this.needToken;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        return !this.grabTokenUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.grabTokenUrl) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLteQosGrabToken mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.needToken = codedInputByteBufferNano.readBool();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.grabTokenUrl = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLteQosGrabToken parseFrom(byte[] bArr) {
        return (SCLteQosGrabToken) MessageNano.mergeFrom(new SCLteQosGrabToken(), bArr);
    }

    public static SCLteQosGrabToken parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLteQosGrabToken().mergeFrom(codedInputByteBufferNano);
    }
}
