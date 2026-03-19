package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class JoinRoom extends MessageNano {
    private static volatile JoinRoom[] _emptyArray;
    public String idc;
    public String msg;
    public JoinRoomParticipant[] participantInfo;
    public int strgtegy;
    public int type;

    public static JoinRoom[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new JoinRoom[0];
                }
            }
        }
        return _emptyArray;
    }

    public JoinRoom() {
        clear();
    }

    public final JoinRoom clear() {
        this.participantInfo = JoinRoomParticipant.emptyArray();
        this.msg = "";
        this.idc = "";
        this.strgtegy = 0;
        this.type = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        JoinRoomParticipant[] joinRoomParticipantArr = this.participantInfo;
        if (joinRoomParticipantArr != null && joinRoomParticipantArr.length > 0) {
            int i = 0;
            while (true) {
                JoinRoomParticipant[] joinRoomParticipantArr2 = this.participantInfo;
                if (i >= joinRoomParticipantArr2.length) {
                    break;
                }
                JoinRoomParticipant joinRoomParticipant = joinRoomParticipantArr2[i];
                if (joinRoomParticipant != null) {
                    codedOutputByteBufferNano.writeMessage(1, joinRoomParticipant);
                }
                i++;
            }
        }
        if (!this.msg.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.msg);
        }
        if (!this.idc.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.idc);
        }
        int i2 = this.strgtegy;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        int i3 = this.type;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        JoinRoomParticipant[] joinRoomParticipantArr = this.participantInfo;
        if (joinRoomParticipantArr != null && joinRoomParticipantArr.length > 0) {
            int i = 0;
            while (true) {
                JoinRoomParticipant[] joinRoomParticipantArr2 = this.participantInfo;
                if (i >= joinRoomParticipantArr2.length) {
                    break;
                }
                JoinRoomParticipant joinRoomParticipant = joinRoomParticipantArr2[i];
                if (joinRoomParticipant != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, joinRoomParticipant);
                }
                i++;
            }
        }
        if (!this.msg.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.msg);
        }
        if (!this.idc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.idc);
        }
        int i2 = this.strgtegy;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
        }
        int i3 = this.type;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final JoinRoom mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                JoinRoomParticipant[] joinRoomParticipantArr = this.participantInfo;
                int length = joinRoomParticipantArr == null ? 0 : joinRoomParticipantArr.length;
                JoinRoomParticipant[] joinRoomParticipantArr2 = new JoinRoomParticipant[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.participantInfo, 0, joinRoomParticipantArr2, 0, length);
                }
                while (length < joinRoomParticipantArr2.length - 1) {
                    joinRoomParticipantArr2[length] = new JoinRoomParticipant();
                    codedInputByteBufferNano.readMessage(joinRoomParticipantArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                joinRoomParticipantArr2[length] = new JoinRoomParticipant();
                codedInputByteBufferNano.readMessage(joinRoomParticipantArr2[length]);
                this.participantInfo = joinRoomParticipantArr2;
            } else if (tag == 18) {
                this.msg = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.idc = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.strgtegy = int32;
                }
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.type = int322;
                }
            }
        }
    }

    public static JoinRoom parseFrom(byte[] bArr) {
        return (JoinRoom) MessageNano.mergeFrom(new JoinRoom(), bArr);
    }

    public static JoinRoom parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new JoinRoom().mergeFrom(codedInputByteBufferNano);
    }
}
