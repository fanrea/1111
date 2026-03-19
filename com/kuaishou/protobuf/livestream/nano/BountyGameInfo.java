package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BountyGameInfo extends MessageNano {
    private static volatile BountyGameInfo[] _emptyArray;
    public boolean disableExpose;
    public BountyGameInitInfo initInfo;
    public BountyGameResultInfo resultInfo;
    public BountyGameTag tag;

    public static BountyGameInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BountyGameInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public BountyGameInfo() {
        clear();
    }

    public final BountyGameInfo clear() {
        this.initInfo = null;
        this.resultInfo = null;
        this.tag = null;
        this.disableExpose = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        BountyGameInitInfo bountyGameInitInfo = this.initInfo;
        if (bountyGameInitInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, bountyGameInitInfo);
        }
        BountyGameResultInfo bountyGameResultInfo = this.resultInfo;
        if (bountyGameResultInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, bountyGameResultInfo);
        }
        BountyGameTag bountyGameTag = this.tag;
        if (bountyGameTag != null) {
            codedOutputByteBufferNano.writeMessage(3, bountyGameTag);
        }
        boolean z = this.disableExpose;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        BountyGameInitInfo bountyGameInitInfo = this.initInfo;
        if (bountyGameInitInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bountyGameInitInfo);
        }
        BountyGameResultInfo bountyGameResultInfo = this.resultInfo;
        if (bountyGameResultInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bountyGameResultInfo);
        }
        BountyGameTag bountyGameTag = this.tag;
        if (bountyGameTag != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, bountyGameTag);
        }
        boolean z = this.disableExpose;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final BountyGameInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.initInfo == null) {
                    this.initInfo = new BountyGameInitInfo();
                }
                codedInputByteBufferNano.readMessage(this.initInfo);
            } else if (tag == 18) {
                if (this.resultInfo == null) {
                    this.resultInfo = new BountyGameResultInfo();
                }
                codedInputByteBufferNano.readMessage(this.resultInfo);
            } else if (tag == 26) {
                if (this.tag == null) {
                    this.tag = new BountyGameTag();
                }
                codedInputByteBufferNano.readMessage(this.tag);
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.disableExpose = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static BountyGameInfo parseFrom(byte[] bArr) {
        return (BountyGameInfo) MessageNano.mergeFrom(new BountyGameInfo(), bArr);
    }

    public static BountyGameInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new BountyGameInfo().mergeFrom(codedInputByteBufferNano);
    }
}
