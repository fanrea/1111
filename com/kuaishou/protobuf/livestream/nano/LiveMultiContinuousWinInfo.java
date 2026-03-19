package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiContinuousWinInfo extends MessageNano {
    private static volatile LiveMultiContinuousWinInfo[] _emptyArray;
    public int continuousWinCount;
    public String continuousWinRouteUrl;

    public static LiveMultiContinuousWinInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiContinuousWinInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiContinuousWinInfo() {
        clear();
    }

    public final LiveMultiContinuousWinInfo clear() {
        this.continuousWinCount = 0;
        this.continuousWinRouteUrl = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.continuousWinCount;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.continuousWinRouteUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.continuousWinRouteUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.continuousWinCount;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        return !this.continuousWinRouteUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.continuousWinRouteUrl) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiContinuousWinInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.continuousWinCount = codedInputByteBufferNano.readUInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.continuousWinRouteUrl = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveMultiContinuousWinInfo parseFrom(byte[] bArr) {
        return (LiveMultiContinuousWinInfo) MessageNano.mergeFrom(new LiveMultiContinuousWinInfo(), bArr);
    }

    public static LiveMultiContinuousWinInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiContinuousWinInfo().mergeFrom(codedInputByteBufferNano);
    }
}
