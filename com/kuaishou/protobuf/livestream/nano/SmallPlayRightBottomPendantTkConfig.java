package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SmallPlayRightBottomPendantTkConfig extends MessageNano {
    private static volatile SmallPlayRightBottomPendantTkConfig[] _emptyArray;
    public String bizData;
    public String bizId;
    public String bundleId;
    public long minBundleVer;
    public String viewKey;

    public static SmallPlayRightBottomPendantTkConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SmallPlayRightBottomPendantTkConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public SmallPlayRightBottomPendantTkConfig() {
        clear();
    }

    public final SmallPlayRightBottomPendantTkConfig clear() {
        this.viewKey = "";
        this.bundleId = "";
        this.minBundleVer = 0L;
        this.bizData = "";
        this.bizId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.viewKey.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.viewKey);
        }
        if (!this.bundleId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.bundleId);
        }
        long j = this.minBundleVer;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.bizData.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.bizData);
        }
        if (!this.bizId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.bizId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.viewKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.viewKey);
        }
        if (!this.bundleId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bundleId);
        }
        long j = this.minBundleVer;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.bizData.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bizData);
        }
        return !this.bizId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.bizId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SmallPlayRightBottomPendantTkConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.viewKey = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.bundleId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.minBundleVer = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.bizData = codedInputByteBufferNano.readString();
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.bizId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SmallPlayRightBottomPendantTkConfig parseFrom(byte[] bArr) {
        return (SmallPlayRightBottomPendantTkConfig) MessageNano.mergeFrom(new SmallPlayRightBottomPendantTkConfig(), bArr);
    }

    public static SmallPlayRightBottomPendantTkConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SmallPlayRightBottomPendantTkConfig().mergeFrom(codedInputByteBufferNano);
    }
}
