package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveEntrustOpened extends MessageNano {
    private static volatile SCLiveEntrustOpened[] _emptyArray;
    public String liveStreamId;
    public String msg;

    public static SCLiveEntrustOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveEntrustOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveEntrustOpened() {
        clear();
    }

    public final SCLiveEntrustOpened clear() {
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
    public final SCLiveEntrustOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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

    public static SCLiveEntrustOpened parseFrom(byte[] bArr) {
        return (SCLiveEntrustOpened) MessageNano.mergeFrom(new SCLiveEntrustOpened(), bArr);
    }

    public static SCLiveEntrustOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveEntrustOpened().mergeFrom(codedInputByteBufferNano);
    }
}
