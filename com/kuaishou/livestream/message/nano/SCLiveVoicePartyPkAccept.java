package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyPkAccept extends MessageNano {
    private static volatile SCLiveVoicePartyPkAccept[] _emptyArray;
    public boolean enableVideoPk;
    public String pkId;

    public static SCLiveVoicePartyPkAccept[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyPkAccept[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyPkAccept() {
        clear();
    }

    public final SCLiveVoicePartyPkAccept clear() {
        this.pkId = "";
        this.enableVideoPk = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.pkId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.pkId);
        }
        boolean z = this.enableVideoPk;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.pkId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.pkId);
        }
        boolean z = this.enableVideoPk;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(2, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyPkAccept mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.pkId = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enableVideoPk = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCLiveVoicePartyPkAccept parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyPkAccept) MessageNano.mergeFrom(new SCLiveVoicePartyPkAccept(), bArr);
    }

    public static SCLiveVoicePartyPkAccept parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyPkAccept().mergeFrom(codedInputByteBufferNano);
    }
}
