package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletCloudPlayOperationCloseConnect extends MessageNano {
    private static volatile SCLiveBulletCloudPlayOperationCloseConnect[] _emptyArray;
    public String closeReason;
    public long timestamp;

    public static SCLiveBulletCloudPlayOperationCloseConnect[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletCloudPlayOperationCloseConnect[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletCloudPlayOperationCloseConnect() {
        clear();
    }

    public final SCLiveBulletCloudPlayOperationCloseConnect clear() {
        this.timestamp = 0L;
        this.closeReason = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.closeReason.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.closeReason);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        return !this.closeReason.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.closeReason) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletCloudPlayOperationCloseConnect mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.closeReason = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveBulletCloudPlayOperationCloseConnect parseFrom(byte[] bArr) {
        return (SCLiveBulletCloudPlayOperationCloseConnect) MessageNano.mergeFrom(new SCLiveBulletCloudPlayOperationCloseConnect(), bArr);
    }

    public static SCLiveBulletCloudPlayOperationCloseConnect parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletCloudPlayOperationCloseConnect().mergeFrom(codedInputByteBufferNano);
    }
}
