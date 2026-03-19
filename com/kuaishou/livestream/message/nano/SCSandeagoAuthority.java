package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCSandeagoAuthority extends MessageNano {
    private static volatile SCSandeagoAuthority[] _emptyArray;
    public boolean authority;
    public String itemId;
    public String liveStreamId;

    public static SCSandeagoAuthority[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCSandeagoAuthority[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCSandeagoAuthority() {
        clear();
    }

    public final SCSandeagoAuthority clear() {
        this.liveStreamId = "";
        this.itemId = "";
        this.authority = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.itemId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.itemId);
        }
        boolean z = this.authority;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.itemId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.itemId);
        }
        boolean z = this.authority;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCSandeagoAuthority mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.itemId = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.authority = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCSandeagoAuthority parseFrom(byte[] bArr) {
        return (SCSandeagoAuthority) MessageNano.mergeFrom(new SCSandeagoAuthority(), bArr);
    }

    public static SCSandeagoAuthority parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCSandeagoAuthority().mergeFrom(codedInputByteBufferNano);
    }
}
