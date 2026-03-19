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
public final class LiveGamePopupFeed extends MessageNano {
    private static volatile LiveGamePopupFeed[] _emptyArray;
    public long popupId;
    public long randomTime;
    public int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveGamePopupSourceType {
        public static final int KILL = 1;
        public static final int UNKNOWN = 0;
    }

    public static LiveGamePopupFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGamePopupFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGamePopupFeed() {
        clear();
    }

    public final LiveGamePopupFeed clear() {
        this.type = 0;
        this.popupId = 0L;
        this.randomTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.popupId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.randomTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.popupId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.randomTime;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGamePopupFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.type = int32;
                }
            } else if (tag == 16) {
                this.popupId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.randomTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveGamePopupFeed parseFrom(byte[] bArr) {
        return (LiveGamePopupFeed) MessageNano.mergeFrom(new LiveGamePopupFeed(), bArr);
    }

    public static LiveGamePopupFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGamePopupFeed().mergeFrom(codedInputByteBufferNano);
    }
}
