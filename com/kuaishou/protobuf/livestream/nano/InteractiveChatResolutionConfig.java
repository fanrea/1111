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
public final class InteractiveChatResolutionConfig extends MessageNano {
    private static volatile InteractiveChatResolutionConfig[] _emptyArray;
    public int bitRateLevel;
    public int height;
    public int level;
    public long userId;
    public int width;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BitRateLevel {
        public static final int BIT_RATE_LEVEL_1 = 1;
        public static final int BIT_RATE_LEVEL_2 = 2;
        public static final int BIT_RATE_LEVEL_3 = 3;
        public static final int BIT_RATE_LEVEL_4 = 4;
        public static final int UNKNOWN_BIT_RATE_LEVEL = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ResolutionLevel {
        public static final int HIGH = 3;
        public static final int LOW = 1;
        public static final int MIDDLE = 2;
        public static final int UNKNOWN = 0;
        public static final int XHIGH = 4;
    }

    public static InteractiveChatResolutionConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new InteractiveChatResolutionConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public InteractiveChatResolutionConfig() {
        clear();
    }

    public final InteractiveChatResolutionConfig clear() {
        this.width = 0;
        this.height = 0;
        this.level = 0;
        this.userId = 0L;
        this.bitRateLevel = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.width;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.height;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        int i3 = this.level;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        int i4 = this.bitRateLevel;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i4);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.width;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.height;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        int i3 = this.level;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
        }
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        int i4 = this.bitRateLevel;
        return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i4) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final InteractiveChatResolutionConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.width = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.height = codedInputByteBufferNano.readUInt32();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.level = int32;
                }
            } else if (tag == 32) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3 || int322 == 4) {
                    this.bitRateLevel = int322;
                }
            }
        }
    }

    public static InteractiveChatResolutionConfig parseFrom(byte[] bArr) {
        return (InteractiveChatResolutionConfig) MessageNano.mergeFrom(new InteractiveChatResolutionConfig(), bArr);
    }

    public static InteractiveChatResolutionConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new InteractiveChatResolutionConfig().mergeFrom(codedInputByteBufferNano);
    }
}
