package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftPanelRefreshRoomVipInfo extends MessageNano {
    private static volatile SCLiveGiftPanelRefreshRoomVipInfo[] _emptyArray;
    public long requestMaxDelayMills;

    public static SCLiveGiftPanelRefreshRoomVipInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftPanelRefreshRoomVipInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftPanelRefreshRoomVipInfo() {
        clear();
    }

    public final SCLiveGiftPanelRefreshRoomVipInfo clear() {
        this.requestMaxDelayMills = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.requestMaxDelayMills;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.requestMaxDelayMills;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftPanelRefreshRoomVipInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 8) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.requestMaxDelayMills = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveGiftPanelRefreshRoomVipInfo parseFrom(byte[] bArr) {
        return (SCLiveGiftPanelRefreshRoomVipInfo) MessageNano.mergeFrom(new SCLiveGiftPanelRefreshRoomVipInfo(), bArr);
    }

    public static SCLiveGiftPanelRefreshRoomVipInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftPanelRefreshRoomVipInfo().mergeFrom(codedInputByteBufferNano);
    }
}
