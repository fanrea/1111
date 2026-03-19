package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveCommonEffectRouteInfo extends MessageNano {
    private static volatile LiveCommonEffectRouteInfo[] _emptyArray;
    public String actionUrl;
    public LiveCommonEffectInfo effectInfo;
    public long maxDelayMillis;

    public static LiveCommonEffectRouteInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCommonEffectRouteInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCommonEffectRouteInfo() {
        clear();
    }

    public final LiveCommonEffectRouteInfo clear() {
        this.effectInfo = null;
        this.actionUrl = "";
        this.maxDelayMillis = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveCommonEffectInfo liveCommonEffectInfo = this.effectInfo;
        if (liveCommonEffectInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, liveCommonEffectInfo);
        }
        if (!this.actionUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.actionUrl);
        }
        long j = this.maxDelayMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveCommonEffectInfo liveCommonEffectInfo = this.effectInfo;
        if (liveCommonEffectInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCommonEffectInfo);
        }
        if (!this.actionUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.actionUrl);
        }
        long j = this.maxDelayMillis;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCommonEffectRouteInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.effectInfo == null) {
                    this.effectInfo = new LiveCommonEffectInfo();
                }
                codedInputByteBufferNano.readMessage(this.effectInfo);
            } else if (tag == 18) {
                this.actionUrl = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.maxDelayMillis = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveCommonEffectRouteInfo parseFrom(byte[] bArr) {
        return (LiveCommonEffectRouteInfo) MessageNano.mergeFrom(new LiveCommonEffectRouteInfo(), bArr);
    }

    public static LiveCommonEffectRouteInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCommonEffectRouteInfo().mergeFrom(codedInputByteBufferNano);
    }
}
