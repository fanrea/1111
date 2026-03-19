package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024BulletPlayShareInfo extends MessageNano {
    private static volatile SCLiveCny2024BulletPlayShareInfo[] _emptyArray;
    public String bizType;
    public long expireTime;

    public static SCLiveCny2024BulletPlayShareInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024BulletPlayShareInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024BulletPlayShareInfo() {
        clear();
    }

    public final SCLiveCny2024BulletPlayShareInfo clear() {
        this.bizType = "";
        this.expireTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.bizType);
        }
        long j = this.expireTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.bizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizType);
        }
        long j = this.expireTime;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024BulletPlayShareInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.bizType = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.expireTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveCny2024BulletPlayShareInfo parseFrom(byte[] bArr) {
        return (SCLiveCny2024BulletPlayShareInfo) MessageNano.mergeFrom(new SCLiveCny2024BulletPlayShareInfo(), bArr);
    }

    public static SCLiveCny2024BulletPlayShareInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024BulletPlayShareInfo().mergeFrom(codedInputByteBufferNano);
    }
}
