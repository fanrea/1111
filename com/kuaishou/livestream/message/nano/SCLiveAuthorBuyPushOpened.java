package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveAuthorBuyPushOpened extends MessageNano {
    private static volatile SCLiveAuthorBuyPushOpened[] _emptyArray;
    public String liveStreamId;
    public String orderId;

    public static SCLiveAuthorBuyPushOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveAuthorBuyPushOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveAuthorBuyPushOpened() {
        clear();
    }

    public final SCLiveAuthorBuyPushOpened clear() {
        this.liveStreamId = "";
        this.orderId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.orderId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.orderId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        return !this.orderId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.orderId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveAuthorBuyPushOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.orderId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveAuthorBuyPushOpened parseFrom(byte[] bArr) {
        return (SCLiveAuthorBuyPushOpened) MessageNano.mergeFrom(new SCLiveAuthorBuyPushOpened(), bArr);
    }

    public static SCLiveAuthorBuyPushOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveAuthorBuyPushOpened().mergeFrom(codedInputByteBufferNano);
    }
}
