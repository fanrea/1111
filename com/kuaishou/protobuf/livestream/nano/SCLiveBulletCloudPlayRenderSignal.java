package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletCloudPlayRenderSignal extends MessageNano {
    private static volatile SCLiveBulletCloudPlayRenderSignal[] _emptyArray;
    public String messageData;
    public long timestamp;
    public long userId;

    public static SCLiveBulletCloudPlayRenderSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletCloudPlayRenderSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletCloudPlayRenderSignal() {
        clear();
    }

    public final SCLiveBulletCloudPlayRenderSignal clear() {
        this.userId = 0L;
        this.timestamp = 0L;
        this.messageData = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        if (!this.messageData.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.messageData);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        return !this.messageData.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.messageData) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletCloudPlayRenderSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.messageData = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveBulletCloudPlayRenderSignal parseFrom(byte[] bArr) {
        return (SCLiveBulletCloudPlayRenderSignal) MessageNano.mergeFrom(new SCLiveBulletCloudPlayRenderSignal(), bArr);
    }

    public static SCLiveBulletCloudPlayRenderSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletCloudPlayRenderSignal().mergeFrom(codedInputByteBufferNano);
    }
}
