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
public final class SCLivePartyPlayRoomLayoutUpdate extends MessageNano {
    private static volatile SCLivePartyPlayRoomLayoutUpdate[] _emptyArray;
    public long interactionHeight;
    public double operationLayoutRatio;
    public int operationLayoutStyle;
    public double operationWidthPercent;
    public long version;

    @Retention(RetentionPolicy.SOURCE)
    public @interface OperationLayoutStyle {
        public static final int HORIZONTAL = 2;
        public static final int UNKNOWN = 0;
        public static final int VERTICAL = 1;
    }

    public static SCLivePartyPlayRoomLayoutUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePartyPlayRoomLayoutUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePartyPlayRoomLayoutUpdate() {
        clear();
    }

    public final SCLivePartyPlayRoomLayoutUpdate clear() {
        this.operationLayoutStyle = 0;
        this.operationLayoutRatio = 0.0d;
        this.operationWidthPercent = 0.0d;
        this.interactionHeight = 0L;
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.operationLayoutStyle;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (Double.doubleToLongBits(this.operationLayoutRatio) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(2, this.operationLayoutRatio);
        }
        if (Double.doubleToLongBits(this.operationWidthPercent) != Double.doubleToLongBits(0.0d)) {
            codedOutputByteBufferNano.writeDouble(3, this.operationWidthPercent);
        }
        long j = this.interactionHeight;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.version;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.operationLayoutStyle;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (Double.doubleToLongBits(this.operationLayoutRatio) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(2, this.operationLayoutRatio);
        }
        if (Double.doubleToLongBits(this.operationWidthPercent) != Double.doubleToLongBits(0.0d)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(3, this.operationWidthPercent);
        }
        long j = this.interactionHeight;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.version;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePartyPlayRoomLayoutUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.operationLayoutStyle = int32;
                }
            } else if (tag == 17) {
                this.operationLayoutRatio = codedInputByteBufferNano.readDouble();
            } else if (tag == 25) {
                this.operationWidthPercent = codedInputByteBufferNano.readDouble();
            } else if (tag == 32) {
                this.interactionHeight = codedInputByteBufferNano.readUInt64();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLivePartyPlayRoomLayoutUpdate parseFrom(byte[] bArr) {
        return (SCLivePartyPlayRoomLayoutUpdate) MessageNano.mergeFrom(new SCLivePartyPlayRoomLayoutUpdate(), bArr);
    }

    public static SCLivePartyPlayRoomLayoutUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePartyPlayRoomLayoutUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
