package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkContinueInviteInfo extends MessageNano {
    private static volatile LiveMultiPkContinueInviteInfo[] _emptyArray;
    public long disableContinueInviteDurationAtPenalty;
    public boolean enableShowContinueInviteButton;

    public static LiveMultiPkContinueInviteInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkContinueInviteInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkContinueInviteInfo() {
        clear();
    }

    public final LiveMultiPkContinueInviteInfo clear() {
        this.enableShowContinueInviteButton = false;
        this.disableContinueInviteDurationAtPenalty = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.enableShowContinueInviteButton;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        long j = this.disableContinueInviteDurationAtPenalty;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.enableShowContinueInviteButton;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        long j = this.disableContinueInviteDurationAtPenalty;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkContinueInviteInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.enableShowContinueInviteButton = codedInputByteBufferNano.readBool();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.disableContinueInviteDurationAtPenalty = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveMultiPkContinueInviteInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkContinueInviteInfo) MessageNano.mergeFrom(new LiveMultiPkContinueInviteInfo(), bArr);
    }

    public static LiveMultiPkContinueInviteInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkContinueInviteInfo().mergeFrom(codedInputByteBufferNano);
    }
}
