package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ServerNodeChanged extends MessageNano {
    private static volatile ServerNodeChanged[] _emptyArray;
    public String msg;
    public Participant[] newParticipantInfo;

    public static ServerNodeChanged[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ServerNodeChanged[0];
                }
            }
        }
        return _emptyArray;
    }

    public ServerNodeChanged() {
        clear();
    }

    public final ServerNodeChanged clear() {
        this.newParticipantInfo = Participant.emptyArray();
        this.msg = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        Participant[] participantArr = this.newParticipantInfo;
        if (participantArr != null && participantArr.length > 0) {
            int i = 0;
            while (true) {
                Participant[] participantArr2 = this.newParticipantInfo;
                if (i >= participantArr2.length) {
                    break;
                }
                Participant participant = participantArr2[i];
                if (participant != null) {
                    codedOutputByteBufferNano.writeMessage(1, participant);
                }
                i++;
            }
        }
        if (!this.msg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.msg);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Participant[] participantArr = this.newParticipantInfo;
        if (participantArr != null && participantArr.length > 0) {
            int i = 0;
            while (true) {
                Participant[] participantArr2 = this.newParticipantInfo;
                if (i >= participantArr2.length) {
                    break;
                }
                Participant participant = participantArr2[i];
                if (participant != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, participant);
                }
                i++;
            }
        }
        return !this.msg.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.msg) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ServerNodeChanged mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Participant[] participantArr = this.newParticipantInfo;
                int length = participantArr == null ? 0 : participantArr.length;
                Participant[] participantArr2 = new Participant[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.newParticipantInfo, 0, participantArr2, 0, length);
                }
                while (length < participantArr2.length - 1) {
                    participantArr2[length] = new Participant();
                    codedInputByteBufferNano.readMessage(participantArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                participantArr2[length] = new Participant();
                codedInputByteBufferNano.readMessage(participantArr2[length]);
                this.newParticipantInfo = participantArr2;
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.msg = codedInputByteBufferNano.readString();
            }
        }
    }

    public static ServerNodeChanged parseFrom(byte[] bArr) {
        return (ServerNodeChanged) MessageNano.mergeFrom(new ServerNodeChanged(), bArr);
    }

    public static ServerNodeChanged parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ServerNodeChanged().mergeFrom(codedInputByteBufferNano);
    }
}
