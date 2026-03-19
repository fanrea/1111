package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024BulletPlayWatchTaskPullRequest extends MessageNano {
    private static volatile SCLiveCny2024BulletPlayWatchTaskPullRequest[] _emptyArray;
    public String bizInfo;
    public int nextActionType;
    public long requestLatestTimestamp;
    public String requestUri;

    public static SCLiveCny2024BulletPlayWatchTaskPullRequest[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024BulletPlayWatchTaskPullRequest[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024BulletPlayWatchTaskPullRequest() {
        clear();
    }

    public final SCLiveCny2024BulletPlayWatchTaskPullRequest clear() {
        this.requestLatestTimestamp = 0L;
        this.bizInfo = "";
        this.requestUri = "";
        this.nextActionType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.requestLatestTimestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.bizInfo.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.bizInfo);
        }
        if (!this.requestUri.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.requestUri);
        }
        int i = this.nextActionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.requestLatestTimestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.bizInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bizInfo);
        }
        if (!this.requestUri.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.requestUri);
        }
        int i = this.nextActionType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024BulletPlayWatchTaskPullRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.requestLatestTimestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.bizInfo = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.requestUri = codedInputByteBufferNano.readString();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.nextActionType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveCny2024BulletPlayWatchTaskPullRequest parseFrom(byte[] bArr) {
        return (SCLiveCny2024BulletPlayWatchTaskPullRequest) MessageNano.mergeFrom(new SCLiveCny2024BulletPlayWatchTaskPullRequest(), bArr);
    }

    public static SCLiveCny2024BulletPlayWatchTaskPullRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024BulletPlayWatchTaskPullRequest().mergeFrom(codedInputByteBufferNano);
    }
}
