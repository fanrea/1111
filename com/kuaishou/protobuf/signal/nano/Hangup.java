package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Hangup extends MessageNano {
    private static volatile Hangup[] _emptyArray;
    public String liveChatRoomId;
    public String livePkRoomId;
    public String reason;
    public String voicePartyRoomId;

    public static Hangup[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Hangup[0];
                }
            }
        }
        return _emptyArray;
    }

    public Hangup() {
        clear();
    }

    public final Hangup clear() {
        this.reason = "";
        this.livePkRoomId = "";
        this.liveChatRoomId = "";
        this.voicePartyRoomId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.reason.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.reason);
        }
        if (!this.livePkRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.livePkRoomId);
        }
        if (!this.liveChatRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.liveChatRoomId);
        }
        if (!this.voicePartyRoomId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.voicePartyRoomId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.reason.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.reason);
        }
        if (!this.livePkRoomId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.livePkRoomId);
        }
        if (!this.liveChatRoomId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveChatRoomId);
        }
        return !this.voicePartyRoomId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.voicePartyRoomId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Hangup mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.reason = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.livePkRoomId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.liveChatRoomId = codedInputByteBufferNano.readString();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.voicePartyRoomId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static Hangup parseFrom(byte[] bArr) {
        return (Hangup) MessageNano.mergeFrom(new Hangup(), bArr);
    }

    public static Hangup parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Hangup().mergeFrom(codedInputByteBufferNano);
    }
}
