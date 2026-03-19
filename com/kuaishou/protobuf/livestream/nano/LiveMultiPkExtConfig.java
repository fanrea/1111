package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkExtConfig extends MessageNano {
    private static volatile LiveMultiPkExtConfig[] _emptyArray;
    public LiveMultiPkQuickGiftPanelConfig quickGiftPanelConfig;

    public static LiveMultiPkExtConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkExtConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkExtConfig() {
        clear();
    }

    public final LiveMultiPkExtConfig clear() {
        this.quickGiftPanelConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveMultiPkQuickGiftPanelConfig liveMultiPkQuickGiftPanelConfig = this.quickGiftPanelConfig;
        if (liveMultiPkQuickGiftPanelConfig != null) {
            codedOutputByteBufferNano.writeMessage(1, liveMultiPkQuickGiftPanelConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveMultiPkQuickGiftPanelConfig liveMultiPkQuickGiftPanelConfig = this.quickGiftPanelConfig;
        return liveMultiPkQuickGiftPanelConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveMultiPkQuickGiftPanelConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkExtConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.quickGiftPanelConfig == null) {
                    this.quickGiftPanelConfig = new LiveMultiPkQuickGiftPanelConfig();
                }
                codedInputByteBufferNano.readMessage(this.quickGiftPanelConfig);
            }
        }
    }

    public static LiveMultiPkExtConfig parseFrom(byte[] bArr) {
        return (LiveMultiPkExtConfig) MessageNano.mergeFrom(new LiveMultiPkExtConfig(), bArr);
    }

    public static LiveMultiPkExtConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkExtConfig().mergeFrom(codedInputByteBufferNano);
    }
}
