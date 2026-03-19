package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class JoinRoomParticipant extends MessageNano {
    private static volatile JoinRoomParticipant[] _emptyArray;
    public boolean isOwner;
    public String liveStreamId;
    public String participantId;

    public static JoinRoomParticipant[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new JoinRoomParticipant[0];
                }
            }
        }
        return _emptyArray;
    }

    public JoinRoomParticipant() {
        clear();
    }

    public final JoinRoomParticipant clear() {
        this.participantId = "";
        this.liveStreamId = "";
        this.isOwner = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.participantId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.participantId);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        boolean z = this.isOwner;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.participantId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.participantId);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        boolean z = this.isOwner;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final JoinRoomParticipant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.participantId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.isOwner = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static JoinRoomParticipant parseFrom(byte[] bArr) {
        return (JoinRoomParticipant) MessageNano.mergeFrom(new JoinRoomParticipant(), bArr);
    }

    public static JoinRoomParticipant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new JoinRoomParticipant().mergeFrom(codedInputByteBufferNano);
    }
}
