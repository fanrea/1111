package com.kuaishou.kwaishop.link.protobuf.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BroadCastPayload extends MessageNano {
    private static volatile BroadCastPayload[] _emptyArray;
    public byte[] payload;
    public int sceneType;

    public static BroadCastPayload[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BroadCastPayload[0];
                }
            }
        }
        return _emptyArray;
    }

    public BroadCastPayload() {
        clear();
    }

    public final BroadCastPayload clear() {
        this.sceneType = 0;
        this.payload = WireFormatNano.EMPTY_BYTES;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.sceneType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(2, this.payload);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.sceneType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        return !Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES) ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBytesSize(2, this.payload) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final BroadCastPayload mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.sceneType = codedInputByteBufferNano.readInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.payload = codedInputByteBufferNano.readBytes();
            }
        }
    }

    public static BroadCastPayload parseFrom(byte[] bArr) {
        return (BroadCastPayload) MessageNano.mergeFrom(new BroadCastPayload(), bArr);
    }

    public static BroadCastPayload parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new BroadCastPayload().mergeFrom(codedInputByteBufferNano);
    }
}
