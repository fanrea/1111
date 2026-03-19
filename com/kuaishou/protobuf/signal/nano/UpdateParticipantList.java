package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UpdateParticipantList extends MessageNano {
    private static volatile UpdateParticipantList[] _emptyArray;
    public String msg;
    public Participant[] participant;
    public int updateType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UpdateType {
        public static final int DIFF_ADD = 1;
        public static final int DIFF_DELETE = 2;
        public static final int DIFF_MODIFY = 3;
        public static final int FULL = 0;
    }

    public static UpdateParticipantList[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UpdateParticipantList[0];
                }
            }
        }
        return _emptyArray;
    }

    public UpdateParticipantList() {
        clear();
    }

    public final UpdateParticipantList clear() {
        this.participant = Participant.emptyArray();
        this.msg = "";
        this.updateType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        Participant[] participantArr = this.participant;
        if (participantArr != null && participantArr.length > 0) {
            int i = 0;
            while (true) {
                Participant[] participantArr2 = this.participant;
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
        int i2 = this.updateType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        Participant[] participantArr = this.participant;
        if (participantArr != null && participantArr.length > 0) {
            int i = 0;
            while (true) {
                Participant[] participantArr2 = this.participant;
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
        if (!this.msg.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.msg);
        }
        int i2 = this.updateType;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final UpdateParticipantList mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                Participant[] participantArr = this.participant;
                int length = participantArr == null ? 0 : participantArr.length;
                Participant[] participantArr2 = new Participant[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.participant, 0, participantArr2, 0, length);
                }
                while (length < participantArr2.length - 1) {
                    participantArr2[length] = new Participant();
                    codedInputByteBufferNano.readMessage(participantArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                participantArr2[length] = new Participant();
                codedInputByteBufferNano.readMessage(participantArr2[length]);
                this.participant = participantArr2;
            } else if (tag == 18) {
                this.msg = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.updateType = int32;
                }
            }
        }
    }

    public static UpdateParticipantList parseFrom(byte[] bArr) {
        return (UpdateParticipantList) MessageNano.mergeFrom(new UpdateParticipantList(), bArr);
    }

    public static UpdateParticipantList parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new UpdateParticipantList().mergeFrom(codedInputByteBufferNano);
    }
}
