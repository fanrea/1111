package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveEntrustClosed extends MessageNano {
    private static volatile SCLiveEntrustClosed[] _emptyArray;
    public String liveStreamId;
    public String msg;

    public static SCLiveEntrustClosed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveEntrustClosed[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveEntrustClosed() {
        clear();
    }

    public final SCLiveEntrustClosed clear() {
        this.liveStreamId = "";
        this.msg = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.msg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.msg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        return !this.msg.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.msg) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveEntrustClosed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.msg = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveEntrustClosed parseFrom(byte[] bArr) {
        return (SCLiveEntrustClosed) MessageNano.mergeFrom(new SCLiveEntrustClosed(), bArr);
    }

    public static SCLiveEntrustClosed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveEntrustClosed().mergeFrom(codedInputByteBufferNano);
    }
}
