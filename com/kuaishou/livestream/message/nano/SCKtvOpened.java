package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKtvOpened extends MessageNano {
    private static volatile SCKtvOpened[] _emptyArray;
    public boolean disableApplaud;
    public boolean fromEnterRoom;
    public String ktvId;
    public String liveStreamId;
    public String voicePartyId;

    public static SCKtvOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKtvOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKtvOpened() {
        clear();
    }

    public final SCKtvOpened clear() {
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.ktvId = "";
        this.disableApplaud = false;
        this.fromEnterRoom = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.voicePartyId);
        }
        if (!this.ktvId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.ktvId);
        }
        boolean z = this.disableApplaud;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        boolean z2 = this.fromEnterRoom;
        if (z2) {
            codedOutputByteBufferNano.writeBool(5, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.voicePartyId);
        }
        if (!this.ktvId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.ktvId);
        }
        boolean z = this.disableApplaud;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        boolean z2 = this.fromEnterRoom;
        return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKtvOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.voicePartyId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.ktvId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.disableApplaud = codedInputByteBufferNano.readBool();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.fromEnterRoom = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static SCKtvOpened parseFrom(byte[] bArr) {
        return (SCKtvOpened) MessageNano.mergeFrom(new SCKtvOpened(), bArr);
    }

    public static SCKtvOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKtvOpened().mergeFrom(codedInputByteBufferNano);
    }
}
