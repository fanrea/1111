package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLivePartyPlayAppClose extends MessageNano {
    private static volatile SCLivePartyPlayAppClose[] _emptyArray;
    public String closeNotice;
    public String roomCode;

    public static SCLivePartyPlayAppClose[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePartyPlayAppClose[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePartyPlayAppClose() {
        clear();
    }

    public final SCLivePartyPlayAppClose clear() {
        this.closeNotice = "";
        this.roomCode = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.closeNotice.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.closeNotice);
        }
        if (!this.roomCode.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roomCode);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.closeNotice.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.closeNotice);
        }
        return !this.roomCode.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.roomCode) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePartyPlayAppClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.closeNotice = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.roomCode = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLivePartyPlayAppClose parseFrom(byte[] bArr) {
        return (SCLivePartyPlayAppClose) MessageNano.mergeFrom(new SCLivePartyPlayAppClose(), bArr);
    }

    public static SCLivePartyPlayAppClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePartyPlayAppClose().mergeFrom(codedInputByteBufferNano);
    }
}
