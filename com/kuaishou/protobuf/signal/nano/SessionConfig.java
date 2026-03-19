package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SessionConfig extends MessageNano {
    private static volatile SessionConfig[] _emptyArray;
    public String callId;
    public String mediaConfig;

    public static SessionConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SessionConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public SessionConfig() {
        clear();
    }

    public final SessionConfig clear() {
        this.callId = "";
        this.mediaConfig = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.callId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.callId);
        }
        if (!this.mediaConfig.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.mediaConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.callId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.callId);
        }
        return !this.mediaConfig.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.mediaConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SessionConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.callId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.mediaConfig = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SessionConfig parseFrom(byte[] bArr) {
        return (SessionConfig) MessageNano.mergeFrom(new SessionConfig(), bArr);
    }

    public static SessionConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SessionConfig().mergeFrom(codedInputByteBufferNano);
    }
}
