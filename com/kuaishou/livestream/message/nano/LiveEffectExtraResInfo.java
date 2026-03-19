package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveEffectExtraResInfo extends MessageNano {
    private static volatile LiveEffectExtraResInfo[] _emptyArray;
    public int bizResource;
    public int reqType;
    public LiveEffectResourceData[] resourceDataList;
    public long scatterDurationMs;
    public long seqId;
    public long timeoutDurationMs;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveEffectBizSource {
        public static final int LIVE_GIFT_EFFECT = 0;
        public static final int LIVE_RN = 1;
    }

    public static LiveEffectExtraResInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveEffectExtraResInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveEffectExtraResInfo() {
        clear();
    }

    public final LiveEffectExtraResInfo clear() {
        this.reqType = 0;
        this.timeoutDurationMs = 0L;
        this.resourceDataList = LiveEffectResourceData.emptyArray();
        this.bizResource = 0;
        this.seqId = 0L;
        this.scatterDurationMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.reqType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.timeoutDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        LiveEffectResourceData[] liveEffectResourceDataArr = this.resourceDataList;
        if (liveEffectResourceDataArr != null && liveEffectResourceDataArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveEffectResourceData[] liveEffectResourceDataArr2 = this.resourceDataList;
                if (i2 >= liveEffectResourceDataArr2.length) {
                    break;
                }
                LiveEffectResourceData liveEffectResourceData = liveEffectResourceDataArr2[i2];
                if (liveEffectResourceData != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveEffectResourceData);
                }
                i2++;
            }
        }
        int i3 = this.bizResource;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        long j2 = this.seqId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        long j3 = this.scatterDurationMs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.reqType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.timeoutDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        LiveEffectResourceData[] liveEffectResourceDataArr = this.resourceDataList;
        if (liveEffectResourceDataArr != null && liveEffectResourceDataArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveEffectResourceData[] liveEffectResourceDataArr2 = this.resourceDataList;
                if (i2 >= liveEffectResourceDataArr2.length) {
                    break;
                }
                LiveEffectResourceData liveEffectResourceData = liveEffectResourceDataArr2[i2];
                if (liveEffectResourceData != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveEffectResourceData);
                }
                i2++;
            }
        }
        int i3 = this.bizResource;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        long j2 = this.seqId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        long j3 = this.scatterDurationMs;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveEffectExtraResInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.reqType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.timeoutDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveEffectResourceData[] liveEffectResourceDataArr = this.resourceDataList;
                int length = liveEffectResourceDataArr == null ? 0 : liveEffectResourceDataArr.length;
                LiveEffectResourceData[] liveEffectResourceDataArr2 = new LiveEffectResourceData[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.resourceDataList, 0, liveEffectResourceDataArr2, 0, length);
                }
                while (length < liveEffectResourceDataArr2.length - 1) {
                    liveEffectResourceDataArr2[length] = new LiveEffectResourceData();
                    codedInputByteBufferNano.readMessage(liveEffectResourceDataArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveEffectResourceDataArr2[length] = new LiveEffectResourceData();
                codedInputByteBufferNano.readMessage(liveEffectResourceDataArr2[length]);
                this.resourceDataList = liveEffectResourceDataArr2;
            } else if (tag == 32) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.bizResource = int32;
                }
            } else if (tag == 40) {
                this.seqId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.scatterDurationMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveEffectExtraResInfo parseFrom(byte[] bArr) {
        return (LiveEffectExtraResInfo) MessageNano.mergeFrom(new LiveEffectExtraResInfo(), bArr);
    }

    public static LiveEffectExtraResInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveEffectExtraResInfo().mergeFrom(codedInputByteBufferNano);
    }
}
