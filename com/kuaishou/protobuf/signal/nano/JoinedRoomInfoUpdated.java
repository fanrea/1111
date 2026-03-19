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
public final class JoinedRoomInfoUpdated extends MessageNano {
    private static volatile JoinedRoomInfoUpdated[] _emptyArray;
    public int closeReason;
    public String idc;
    public String mediaConfig;
    public String mediaConfig4G;
    public String mediaConfigKey;
    public String message;
    public Participant[] participant;
    public int status;
    public int strategy;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseReason {
        public static final int ALREADY_IN_CALL = 9;
        public static final int HANGUP = 1;
        public static final int HANGUP_BY_PEER = 2;
        public static final int INVALID_REQUEST_PARAM = 6;
        public static final int KICKED_OFF = 10;
        public static final int LOST_CONNECTION = 3;
        public static final int NONE = 0;
        public static final int ROOM_CLOSE = 4;
        public static final int ROOM_NOT_FOUND = 5;
        public static final int SERVER_ERROR = 7;
        public static final int TIME_OUT = 8;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface JoinRoomStatus {
        public static final int CLOSED = 1;
        public static final int CONNECTED = 2;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface P2PMode {
        public static final int CONNECTIVITY_TEST_ONLY = 1;
        public static final int GREY_TEST_ONLY = 3;
        public static final int LIVE_CHAT_ONLY = 2;
        public static final int NO_MODE = 0;
    }

    public static JoinedRoomInfoUpdated[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new JoinedRoomInfoUpdated[0];
                }
            }
        }
        return _emptyArray;
    }

    public JoinedRoomInfoUpdated() {
        clear();
    }

    public final JoinedRoomInfoUpdated clear() {
        this.status = 0;
        this.message = "";
        this.participant = Participant.emptyArray();
        this.closeReason = 0;
        this.strategy = 0;
        this.type = 0;
        this.mediaConfigKey = "";
        this.mediaConfig = "";
        this.idc = "";
        this.mediaConfig4G = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.status;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.message.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.message);
        }
        Participant[] participantArr = this.participant;
        if (participantArr != null && participantArr.length > 0) {
            int i2 = 0;
            while (true) {
                Participant[] participantArr2 = this.participant;
                if (i2 >= participantArr2.length) {
                    break;
                }
                Participant participant = participantArr2[i2];
                if (participant != null) {
                    codedOutputByteBufferNano.writeMessage(3, participant);
                }
                i2++;
            }
        }
        int i3 = this.closeReason;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        int i4 = this.strategy;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i4);
        }
        int i5 = this.type;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i5);
        }
        if (!this.mediaConfigKey.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.mediaConfigKey);
        }
        if (!this.mediaConfig.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.mediaConfig);
        }
        if (!this.idc.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.idc);
        }
        if (!this.mediaConfig4G.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.mediaConfig4G);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.status;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.message.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.message);
        }
        Participant[] participantArr = this.participant;
        if (participantArr != null && participantArr.length > 0) {
            int i2 = 0;
            while (true) {
                Participant[] participantArr2 = this.participant;
                if (i2 >= participantArr2.length) {
                    break;
                }
                Participant participant = participantArr2[i2];
                if (participant != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, participant);
                }
                i2++;
            }
        }
        int i3 = this.closeReason;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        int i4 = this.strategy;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i4);
        }
        int i5 = this.type;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i5);
        }
        if (!this.mediaConfigKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.mediaConfigKey);
        }
        if (!this.mediaConfig.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.mediaConfig);
        }
        if (!this.idc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.idc);
        }
        return !this.mediaConfig4G.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.mediaConfig4G) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final JoinedRoomInfoUpdated mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.status = int32;
                        break;
                    }
                case 18:
                    this.message = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
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
                    break;
                case 32:
                    int int322 = codedInputByteBufferNano.readInt32();
                    switch (int322) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            this.closeReason = int322;
                            break;
                    }
                case 40:
                    int int323 = codedInputByteBufferNano.readInt32();
                    if (int323 != 0 && int323 != 1 && int323 != 2) {
                        break;
                    } else {
                        this.strategy = int323;
                        break;
                    }
                    break;
                case 48:
                    int int324 = codedInputByteBufferNano.readInt32();
                    if (int324 != 0 && int324 != 1 && int324 != 2) {
                        break;
                    } else {
                        this.type = int324;
                        break;
                    }
                case 58:
                    this.mediaConfigKey = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.mediaConfig = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.idc = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.mediaConfig4G = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static JoinedRoomInfoUpdated parseFrom(byte[] bArr) {
        return (JoinedRoomInfoUpdated) MessageNano.mergeFrom(new JoinedRoomInfoUpdated(), bArr);
    }

    public static JoinedRoomInfoUpdated parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new JoinedRoomInfoUpdated().mergeFrom(codedInputByteBufferNano);
    }
}
