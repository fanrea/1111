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
public final class MultiHoming extends MessageNano {
    private static volatile MultiHoming[] _emptyArray;
    public boolean isMultiHoming;
    public int multiHomingMode;
    public SidList[] multiHomingSid;

    @Retention(RetentionPolicy.SOURCE)
    public @interface MultiHomingMode {
        public static final int CLIENT_MULTI_HOMING = 1;
        public static final int HYBRID_MULTI_HOMING = 3;
        public static final int NON_MULTI_HOMING = 0;
        public static final int SERVER_MULTI_HOMING = 2;
    }

    public static MultiHoming[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MultiHoming[0];
                }
            }
        }
        return _emptyArray;
    }

    public MultiHoming() {
        clear();
    }

    public final MultiHoming clear() {
        this.isMultiHoming = false;
        this.multiHomingSid = SidList.emptyArray();
        this.multiHomingMode = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isMultiHoming;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        SidList[] sidListArr = this.multiHomingSid;
        if (sidListArr != null && sidListArr.length > 0) {
            int i = 0;
            while (true) {
                SidList[] sidListArr2 = this.multiHomingSid;
                if (i >= sidListArr2.length) {
                    break;
                }
                SidList sidList = sidListArr2[i];
                if (sidList != null) {
                    codedOutputByteBufferNano.writeMessage(2, sidList);
                }
                i++;
            }
        }
        int i2 = this.multiHomingMode;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isMultiHoming;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        SidList[] sidListArr = this.multiHomingSid;
        if (sidListArr != null && sidListArr.length > 0) {
            int i = 0;
            while (true) {
                SidList[] sidListArr2 = this.multiHomingSid;
                if (i >= sidListArr2.length) {
                    break;
                }
                SidList sidList = sidListArr2[i];
                if (sidList != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, sidList);
                }
                i++;
            }
        }
        int i2 = this.multiHomingMode;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(3, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MultiHoming mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.isMultiHoming = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                SidList[] sidListArr = this.multiHomingSid;
                int length = sidListArr == null ? 0 : sidListArr.length;
                SidList[] sidListArr2 = new SidList[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.multiHomingSid, 0, sidListArr2, 0, length);
                }
                while (length < sidListArr2.length - 1) {
                    sidListArr2[length] = new SidList();
                    codedInputByteBufferNano.readMessage(sidListArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                sidListArr2[length] = new SidList();
                codedInputByteBufferNano.readMessage(sidListArr2[length]);
                this.multiHomingSid = sidListArr2;
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.multiHomingMode = int32;
                }
            }
        }
    }

    public static MultiHoming parseFrom(byte[] bArr) {
        return (MultiHoming) MessageNano.mergeFrom(new MultiHoming(), bArr);
    }

    public static MultiHoming parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MultiHoming().mergeFrom(codedInputByteBufferNano);
    }
}
