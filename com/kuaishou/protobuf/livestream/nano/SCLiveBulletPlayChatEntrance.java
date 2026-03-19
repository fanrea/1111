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
public final class SCLiveBulletPlayChatEntrance extends MessageNano {
    private static volatile SCLiveBulletPlayChatEntrance[] _emptyArray;
    public String entranceName;
    public int entranceStatus;
    public long timestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BulletPlayChatEntranceStatus {
        public static final int CLOSE = 2;
        public static final int OPEN = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveBulletPlayChatEntrance[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletPlayChatEntrance[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletPlayChatEntrance() {
        clear();
    }

    public final SCLiveBulletPlayChatEntrance clear() {
        this.entranceStatus = 0;
        this.entranceName = "";
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.entranceStatus;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.entranceName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.entranceName);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.entranceStatus;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.entranceName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.entranceName);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletPlayChatEntrance mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.entranceStatus = int32;
                }
            } else if (tag == 18) {
                this.entranceName = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readInt64();
            }
        }
    }

    public static SCLiveBulletPlayChatEntrance parseFrom(byte[] bArr) {
        return (SCLiveBulletPlayChatEntrance) MessageNano.mergeFrom(new SCLiveBulletPlayChatEntrance(), bArr);
    }

    public static SCLiveBulletPlayChatEntrance parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletPlayChatEntrance().mergeFrom(codedInputByteBufferNano);
    }
}
