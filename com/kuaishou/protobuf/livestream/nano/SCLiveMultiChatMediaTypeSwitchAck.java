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
public final class SCLiveMultiChatMediaTypeSwitchAck extends MessageNano {
    private static volatile SCLiveMultiChatMediaTypeSwitchAck[] _emptyArray;
    public String liveStreamId;
    public int result;
    public int targetType;
    public long timestamp;
    public String userSessionId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AckType {
        public static final int ACCEPT = 1;
        public static final int REJECT = 2;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveMultiChatMediaTypeSwitchAck[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiChatMediaTypeSwitchAck[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiChatMediaTypeSwitchAck() {
        clear();
    }

    public final SCLiveMultiChatMediaTypeSwitchAck clear() {
        this.liveStreamId = "";
        this.userSessionId = "";
        this.result = 0;
        this.timestamp = 0L;
        this.targetType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        if (!this.userSessionId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.userSessionId);
        }
        int i = this.result;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        int i2 = this.targetType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        if (!this.userSessionId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.userSessionId);
        }
        int i = this.result;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        int i2 = this.targetType;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiChatMediaTypeSwitchAck mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.userSessionId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.result = int32;
                }
            } else if (tag == 32) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.targetType = int322;
                }
            }
        }
    }

    public static SCLiveMultiChatMediaTypeSwitchAck parseFrom(byte[] bArr) {
        return (SCLiveMultiChatMediaTypeSwitchAck) MessageNano.mergeFrom(new SCLiveMultiChatMediaTypeSwitchAck(), bArr);
    }

    public static SCLiveMultiChatMediaTypeSwitchAck parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiChatMediaTypeSwitchAck().mergeFrom(codedInputByteBufferNano);
    }
}
