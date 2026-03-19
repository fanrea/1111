package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Network extends MessageNano {
    private static volatile Network[] _emptyArray;
    public String bssid;
    public String isp;
    public int type;

    public static Network[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Network[0];
                }
            }
        }
        return _emptyArray;
    }

    public Network() {
        clear();
    }

    public final Network clear() {
        this.type = 0;
        this.isp = "";
        this.bssid = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.isp.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.isp);
        }
        if (!this.bssid.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.bssid);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.isp.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.isp);
        }
        return !this.bssid.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.bssid) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Network mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        this.type = int32;
                        break;
                }
            } else if (tag == 18) {
                this.isp = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bssid = codedInputByteBufferNano.readString();
            }
        }
    }

    public static Network parseFrom(byte[] bArr) {
        return (Network) MessageNano.mergeFrom(new Network(), bArr);
    }

    public static Network parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Network().mergeFrom(codedInputByteBufferNano);
    }
}
