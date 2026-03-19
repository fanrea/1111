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
public final class StatusChanged extends MessageNano {
    private static volatile StatusChanged[] _emptyArray;
    public int disconnectReason;
    public boolean isOwner;
    public String msg;
    public MultiHoming multiHoming;
    public int status;
    public int[] streamId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface CallStatus {
        public static final int CONNECTED = 2;
        public static final int IDLE = 1;
        public static final int UNKNOWN = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface DisconnectReason {
        public static final int CALLEE_BUSY = 6;
        public static final int CALLEE_NOT_FOUND = 7;
        public static final int HANGUP = 1;
        public static final int HANGUP_BY_PEER = 2;
        public static final int INVALID_REQUEST_PARAM = 11;
        public static final int KICKED_OFF = 10;
        public static final int LOST_CONNECTION = 4;
        public static final int NONE = 0;
        public static final int NOT_IN_ROOM = 9;
        public static final int NO_ANSWER = 3;
        public static final int ROOM_CLOSE = 5;
        public static final int ROOM_NOT_FOUND = 8;
        public static final int SERVER_ERROR = 12;
        public static final int SERVER_NODE_CHANGE = 14;
        public static final int TIME_OUT = 13;
    }

    public static StatusChanged[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new StatusChanged[0];
                }
            }
        }
        return _emptyArray;
    }

    public StatusChanged() {
        clear();
    }

    public final StatusChanged clear() {
        this.status = 0;
        this.disconnectReason = 0;
        this.msg = "";
        this.streamId = WireFormatNano.EMPTY_INT_ARRAY;
        this.isOwner = false;
        this.multiHoming = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.status;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.disconnectReason;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        if (!this.msg.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.msg);
        }
        int[] iArr = this.streamId;
        if (iArr != null && iArr.length > 0) {
            int i3 = 0;
            while (true) {
                int[] iArr2 = this.streamId;
                if (i3 >= iArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt32(4, iArr2[i3]);
                i3++;
            }
        }
        boolean z = this.isOwner;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        MultiHoming multiHoming = this.multiHoming;
        if (multiHoming != null) {
            codedOutputByteBufferNano.writeMessage(6, multiHoming);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int[] iArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.status;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.disconnectReason;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        if (!this.msg.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.msg);
        }
        int[] iArr2 = this.streamId;
        if (iArr2 != null && iArr2.length > 0) {
            int i3 = 0;
            int iComputeUInt32SizeNoTag = 0;
            while (true) {
                iArr = this.streamId;
                if (i3 >= iArr.length) {
                    break;
                }
                iComputeUInt32SizeNoTag += CodedOutputByteBufferNano.computeUInt32SizeNoTag(iArr[i3]);
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt32SizeNoTag + (iArr.length * 1);
        }
        boolean z = this.isOwner;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        MultiHoming multiHoming = this.multiHoming;
        return multiHoming != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, multiHoming) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final StatusChanged mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.status = int32;
                }
            } else if (tag == 16) {
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
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                        this.disconnectReason = int322;
                        break;
                }
            } else if (tag == 26) {
                this.msg = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                int[] iArr = this.streamId;
                int length = iArr == null ? 0 : iArr.length;
                int[] iArr2 = new int[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.streamId, 0, iArr2, 0, length);
                }
                while (length < iArr2.length - 1) {
                    iArr2[length] = codedInputByteBufferNano.readUInt32();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                iArr2[length] = codedInputByteBufferNano.readUInt32();
                this.streamId = iArr2;
            } else if (tag == 34) {
                int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                int position = codedInputByteBufferNano.getPosition();
                int i = 0;
                while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                    codedInputByteBufferNano.readUInt32();
                    i++;
                }
                codedInputByteBufferNano.rewindToPosition(position);
                int[] iArr3 = this.streamId;
                int length2 = iArr3 == null ? 0 : iArr3.length;
                int[] iArr4 = new int[i + length2];
                if (length2 != 0) {
                    System.arraycopy(this.streamId, 0, iArr4, 0, length2);
                }
                while (length2 < iArr4.length) {
                    iArr4[length2] = codedInputByteBufferNano.readUInt32();
                    length2++;
                }
                this.streamId = iArr4;
                codedInputByteBufferNano.popLimit(iPushLimit);
            } else if (tag == 40) {
                this.isOwner = codedInputByteBufferNano.readBool();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.multiHoming == null) {
                    this.multiHoming = new MultiHoming();
                }
                codedInputByteBufferNano.readMessage(this.multiHoming);
            }
        }
    }

    public static StatusChanged parseFrom(byte[] bArr) {
        return (StatusChanged) MessageNano.mergeFrom(new StatusChanged(), bArr);
    }

    public static StatusChanged parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new StatusChanged().mergeFrom(codedInputByteBufferNano);
    }
}
