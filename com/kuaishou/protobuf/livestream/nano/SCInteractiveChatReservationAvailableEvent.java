package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatReservationAvailableEvent extends MessageNano {
    private static volatile SCInteractiveChatReservationAvailableEvent[] _emptyArray;
    public String bizExtraInfo;
    public int bizType;
    public int eventType;
    public String reservationId;
    public long reservedUserId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventType {
        public static final int APPLY = 2;
        public static final int CALL = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCInteractiveChatReservationAvailableEvent[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatReservationAvailableEvent[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatReservationAvailableEvent() {
        clear();
    }

    public final SCInteractiveChatReservationAvailableEvent clear() {
        this.eventType = 0;
        this.bizType = 0;
        this.reservedUserId = 0L;
        this.reservationId = "";
        this.bizExtraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.eventType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.bizType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        long j = this.reservedUserId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.reservationId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.reservationId);
        }
        if (!this.bizExtraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.bizExtraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.eventType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.bizType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        long j = this.reservedUserId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.reservationId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.reservationId);
        }
        return !this.bizExtraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.bizExtraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatReservationAvailableEvent mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.eventType = int32;
                }
            } else if (tag == 16) {
                this.bizType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 24) {
                this.reservedUserId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.reservationId = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizExtraInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCInteractiveChatReservationAvailableEvent parseFrom(byte[] bArr) {
        return (SCInteractiveChatReservationAvailableEvent) MessageNano.mergeFrom(new SCInteractiveChatReservationAvailableEvent(), bArr);
    }

    public static SCInteractiveChatReservationAvailableEvent parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatReservationAvailableEvent().mergeFrom(codedInputByteBufferNano);
    }
}
