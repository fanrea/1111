package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveRevenueDeliverySellingChatInfo extends MessageNano {
    private static volatile LiveRevenueDeliverySellingChatInfo[] _emptyArray;
    public int billingType;

    public static LiveRevenueDeliverySellingChatInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveRevenueDeliverySellingChatInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveRevenueDeliverySellingChatInfo() {
        clear();
    }

    public final LiveRevenueDeliverySellingChatInfo clear() {
        this.billingType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.billingType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.billingType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(1, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveRevenueDeliverySellingChatInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.billingType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LiveRevenueDeliverySellingChatInfo parseFrom(byte[] bArr) {
        return (LiveRevenueDeliverySellingChatInfo) MessageNano.mergeFrom(new LiveRevenueDeliverySellingChatInfo(), bArr);
    }

    public static LiveRevenueDeliverySellingChatInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveRevenueDeliverySellingChatInfo().mergeFrom(codedInputByteBufferNano);
    }
}
