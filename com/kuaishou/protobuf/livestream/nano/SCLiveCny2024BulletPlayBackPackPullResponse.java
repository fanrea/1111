package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024BulletPlayBackPackPullResponse extends MessageNano {
    private static volatile SCLiveCny2024BulletPlayBackPackPullResponse[] _emptyArray;
    public String data;
    public int nextActionType;
    public long timestamp;

    public static SCLiveCny2024BulletPlayBackPackPullResponse[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024BulletPlayBackPackPullResponse[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024BulletPlayBackPackPullResponse() {
        clear();
    }

    public final SCLiveCny2024BulletPlayBackPackPullResponse clear() {
        this.nextActionType = 0;
        this.timestamp = 0L;
        this.data = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.nextActionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        if (!this.data.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.data);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.nextActionType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
        }
        return !this.data.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.data) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024BulletPlayBackPackPullResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.nextActionType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.timestamp = codedInputByteBufferNano.readInt64();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.data = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveCny2024BulletPlayBackPackPullResponse parseFrom(byte[] bArr) {
        return (SCLiveCny2024BulletPlayBackPackPullResponse) MessageNano.mergeFrom(new SCLiveCny2024BulletPlayBackPackPullResponse(), bArr);
    }

    public static SCLiveCny2024BulletPlayBackPackPullResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024BulletPlayBackPackPullResponse().mergeFrom(codedInputByteBufferNano);
    }
}
