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
public final class LiveJobPendantAnimateIconInfo extends MessageNano {
    private static volatile LiveJobPendantAnimateIconInfo[] _emptyArray;
    public String animateIconResourceKey;
    public long animateInterval;
    public int animateTimes;
    public int iconType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
        public static final int LOTTIE = 1;
        public static final int NORMAL = 3;
        public static final int UNKNOWN = 0;
        public static final int WEBP = 2;
    }

    public static LiveJobPendantAnimateIconInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveJobPendantAnimateIconInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveJobPendantAnimateIconInfo() {
        clear();
    }

    public final LiveJobPendantAnimateIconInfo clear() {
        this.iconType = 0;
        this.animateTimes = 0;
        this.animateInterval = 0L;
        this.animateIconResourceKey = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.iconType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        int i2 = this.animateTimes;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        long j = this.animateInterval;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(3, j);
        }
        if (!this.animateIconResourceKey.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.animateIconResourceKey);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.iconType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        int i2 = this.animateTimes;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i2);
        }
        long j = this.animateInterval;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
        }
        return !this.animateIconResourceKey.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.animateIconResourceKey) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveJobPendantAnimateIconInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.iconType = int32;
                }
            } else if (tag == 16) {
                this.animateTimes = codedInputByteBufferNano.readInt32();
            } else if (tag == 24) {
                this.animateInterval = codedInputByteBufferNano.readInt64();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.animateIconResourceKey = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveJobPendantAnimateIconInfo parseFrom(byte[] bArr) {
        return (LiveJobPendantAnimateIconInfo) MessageNano.mergeFrom(new LiveJobPendantAnimateIconInfo(), bArr);
    }

    public static LiveJobPendantAnimateIconInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveJobPendantAnimateIconInfo().mergeFrom(codedInputByteBufferNano);
    }
}
