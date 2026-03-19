package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiLinePkPrepareStartExtraInfo extends MessageNano {
    private static volatile LiveMultiLinePkPrepareStartExtraInfo[] _emptyArray;
    public long forbidInviteDurationMsBeforeDeadline;
    public int joinType;
    public long prepareEndDeadline;
    public long prepareEndNotifyDeadline;

    public static LiveMultiLinePkPrepareStartExtraInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiLinePkPrepareStartExtraInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiLinePkPrepareStartExtraInfo() {
        clear();
    }

    public final LiveMultiLinePkPrepareStartExtraInfo clear() {
        this.prepareEndDeadline = 0L;
        this.prepareEndNotifyDeadline = 0L;
        this.forbidInviteDurationMsBeforeDeadline = 0L;
        this.joinType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.prepareEndDeadline;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.prepareEndNotifyDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.forbidInviteDurationMsBeforeDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        int i = this.joinType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.prepareEndDeadline;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.prepareEndNotifyDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.forbidInviteDurationMsBeforeDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        int i = this.joinType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(4, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiLinePkPrepareStartExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.prepareEndDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.prepareEndNotifyDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.forbidInviteDurationMsBeforeDeadline = codedInputByteBufferNano.readUInt64();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.joinType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static LiveMultiLinePkPrepareStartExtraInfo parseFrom(byte[] bArr) {
        return (LiveMultiLinePkPrepareStartExtraInfo) MessageNano.mergeFrom(new LiveMultiLinePkPrepareStartExtraInfo(), bArr);
    }

    public static LiveMultiLinePkPrepareStartExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiLinePkPrepareStartExtraInfo().mergeFrom(codedInputByteBufferNano);
    }
}
