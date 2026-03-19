package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyOpMicSeatUpdatableInfo extends MessageNano {
    private static volatile LiveVoicePartyOpMicSeatUpdatableInfo[] _emptyArray;
    public int micSeatId;
    public boolean micSeatMute;
    public boolean noVideo;
    public long userId;
    public boolean userMute;

    public static LiveVoicePartyOpMicSeatUpdatableInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyOpMicSeatUpdatableInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyOpMicSeatUpdatableInfo() {
        clear();
    }

    public final LiveVoicePartyOpMicSeatUpdatableInfo clear() {
        this.micSeatId = 0;
        this.userId = 0L;
        this.userMute = false;
        this.micSeatMute = false;
        this.noVideo = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.micSeatId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        boolean z = this.userMute;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        boolean z2 = this.micSeatMute;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        boolean z3 = this.noVideo;
        if (z3) {
            codedOutputByteBufferNano.writeBool(5, z3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.micSeatId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        boolean z = this.userMute;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        boolean z2 = this.micSeatMute;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
        }
        boolean z3 = this.noVideo;
        return z3 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyOpMicSeatUpdatableInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.micSeatId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.userId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.userMute = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                this.micSeatMute = codedInputByteBufferNano.readBool();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.noVideo = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveVoicePartyOpMicSeatUpdatableInfo parseFrom(byte[] bArr) {
        return (LiveVoicePartyOpMicSeatUpdatableInfo) MessageNano.mergeFrom(new LiveVoicePartyOpMicSeatUpdatableInfo(), bArr);
    }

    public static LiveVoicePartyOpMicSeatUpdatableInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyOpMicSeatUpdatableInfo().mergeFrom(codedInputByteBufferNano);
    }
}
