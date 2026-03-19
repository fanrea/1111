package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UnifiedNotificationResource extends MessageNano {
    public static final int PC_TASK_COMPLETION_POPUP_FIELD_NUMBER = 1;
    private static volatile UnifiedNotificationResource[] _emptyArray;
    private int resourceCase_ = 0;
    private Object resource_;

    public final int getResourceCase() {
        return this.resourceCase_;
    }

    public final UnifiedNotificationResource clearResource() {
        this.resourceCase_ = 0;
        this.resource_ = null;
        return this;
    }

    public static UnifiedNotificationResource[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UnifiedNotificationResource[0];
                }
            }
        }
        return _emptyArray;
    }

    public final boolean hasPcTaskCompletionPopup() {
        return this.resourceCase_ == 1;
    }

    public final PcTaskCompletionPopup getPcTaskCompletionPopup() {
        if (this.resourceCase_ == 1) {
            return (PcTaskCompletionPopup) this.resource_;
        }
        return null;
    }

    public final UnifiedNotificationResource setPcTaskCompletionPopup(PcTaskCompletionPopup pcTaskCompletionPopup) {
        if (pcTaskCompletionPopup == null) {
            throw new NullPointerException();
        }
        this.resourceCase_ = 1;
        this.resource_ = pcTaskCompletionPopup;
        return this;
    }

    public UnifiedNotificationResource() {
        clear();
    }

    public final UnifiedNotificationResource clear() {
        clearResource();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (this.resourceCase_ == 1) {
            codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.resource_);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return this.resourceCase_ == 1 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.resource_) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final UnifiedNotificationResource mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.resourceCase_ != 1) {
                    this.resource_ = new PcTaskCompletionPopup();
                }
                codedInputByteBufferNano.readMessage((MessageNano) this.resource_);
                this.resourceCase_ = 1;
            }
        }
    }

    public static UnifiedNotificationResource parseFrom(byte[] bArr) {
        return (UnifiedNotificationResource) MessageNano.mergeFrom(new UnifiedNotificationResource(), bArr);
    }

    public static UnifiedNotificationResource parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new UnifiedNotificationResource().mergeFrom(codedInputByteBufferNano);
    }
}
