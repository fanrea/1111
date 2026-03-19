package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveSmallPlayRightBottomPendant extends MessageNano {
    private static volatile SCLiveSmallPlayRightBottomPendant[] _emptyArray;
    public boolean canShow;
    public long serverTime;
    public SmallPlayRightBottomPendantTkConfig tkConfig;

    public static SCLiveSmallPlayRightBottomPendant[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveSmallPlayRightBottomPendant[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveSmallPlayRightBottomPendant() {
        clear();
    }

    public final SCLiveSmallPlayRightBottomPendant clear() {
        this.canShow = false;
        this.serverTime = 0L;
        this.tkConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.canShow;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.serverTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        SmallPlayRightBottomPendantTkConfig smallPlayRightBottomPendantTkConfig = this.tkConfig;
        if (smallPlayRightBottomPendantTkConfig != null) {
            codedOutputByteBufferNano.writeMessage(3, smallPlayRightBottomPendantTkConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.canShow;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.serverTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        SmallPlayRightBottomPendantTkConfig smallPlayRightBottomPendantTkConfig = this.tkConfig;
        return smallPlayRightBottomPendantTkConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, smallPlayRightBottomPendantTkConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveSmallPlayRightBottomPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.canShow = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.serverTime = codedInputByteBufferNano.readUInt64();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.tkConfig == null) {
                    this.tkConfig = new SmallPlayRightBottomPendantTkConfig();
                }
                codedInputByteBufferNano.readMessage(this.tkConfig);
            }
        }
    }

    public static SCLiveSmallPlayRightBottomPendant parseFrom(byte[] bArr) {
        return (SCLiveSmallPlayRightBottomPendant) MessageNano.mergeFrom(new SCLiveSmallPlayRightBottomPendant(), bArr);
    }

    public static SCLiveSmallPlayRightBottomPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveSmallPlayRightBottomPendant().mergeFrom(codedInputByteBufferNano);
    }
}
