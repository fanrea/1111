package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyToastFeed extends MessageNano {
    private static volatile LiveVoicePartyToastFeed[] _emptyArray;
    public String id;
    public String toastMsg;

    public static LiveVoicePartyToastFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyToastFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyToastFeed() {
        clear();
    }

    public final LiveVoicePartyToastFeed clear() {
        this.id = "";
        this.toastMsg = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.id);
        }
        if (!this.toastMsg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.toastMsg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
        }
        return !this.toastMsg.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.toastMsg) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyToastFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.toastMsg = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveVoicePartyToastFeed parseFrom(byte[] bArr) {
        return (LiveVoicePartyToastFeed) MessageNano.mergeFrom(new LiveVoicePartyToastFeed(), bArr);
    }

    public static LiveVoicePartyToastFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyToastFeed().mergeFrom(codedInputByteBufferNano);
    }
}
