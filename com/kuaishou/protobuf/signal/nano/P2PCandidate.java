package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class P2PCandidate extends MessageNano {
    private static volatile P2PCandidate[] _emptyArray;
    public String interfaceName;
    public String ip;
    public int port;

    public static P2PCandidate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new P2PCandidate[0];
                }
            }
        }
        return _emptyArray;
    }

    public P2PCandidate() {
        clear();
    }

    public final P2PCandidate clear() {
        this.ip = "";
        this.port = 0;
        this.interfaceName = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.ip.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.ip);
        }
        int i = this.port;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        if (!this.interfaceName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.interfaceName);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.ip.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.ip);
        }
        int i = this.port;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        return !this.interfaceName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.interfaceName) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final P2PCandidate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.ip = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.port = codedInputByteBufferNano.readUInt32();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.interfaceName = codedInputByteBufferNano.readString();
            }
        }
    }

    public static P2PCandidate parseFrom(byte[] bArr) {
        return (P2PCandidate) MessageNano.mergeFrom(new P2PCandidate(), bArr);
    }

    public static P2PCandidate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new P2PCandidate().mergeFrom(codedInputByteBufferNano);
    }
}
