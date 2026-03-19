package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyMicSeatUserLevelUpEffects extends MessageNano {
    private static volatile LiveVoicePartyMicSeatUserLevelUpEffects[] _emptyArray;
    public LiveCdnNodeView[] material;
    public long userId;

    public static LiveVoicePartyMicSeatUserLevelUpEffects[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyMicSeatUserLevelUpEffects[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyMicSeatUserLevelUpEffects() {
        clear();
    }

    public final LiveVoicePartyMicSeatUserLevelUpEffects clear() {
        this.material = LiveCdnNodeView.emptyArray();
        this.userId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveCdnNodeView[] liveCdnNodeViewArr = this.material;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.material;
                if (i >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                if (liveCdnNodeView != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveCdnNodeView);
                }
                i++;
            }
        }
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveCdnNodeView[] liveCdnNodeViewArr = this.material;
        if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCdnNodeView[] liveCdnNodeViewArr2 = this.material;
                if (i >= liveCdnNodeViewArr2.length) {
                    break;
                }
                LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                if (liveCdnNodeView != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCdnNodeView);
                }
                i++;
            }
        }
        long j = this.userId;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyMicSeatUserLevelUpEffects mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LiveCdnNodeView[] liveCdnNodeViewArr = this.material;
                int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.material, 0, liveCdnNodeViewArr2, 0, length);
                }
                while (length < liveCdnNodeViewArr2.length - 1) {
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                this.material = liveCdnNodeViewArr2;
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.userId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveVoicePartyMicSeatUserLevelUpEffects parseFrom(byte[] bArr) {
        return (LiveVoicePartyMicSeatUserLevelUpEffects) MessageNano.mergeFrom(new LiveVoicePartyMicSeatUserLevelUpEffects(), bArr);
    }

    public static LiveVoicePartyMicSeatUserLevelUpEffects parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyMicSeatUserLevelUpEffects().mergeFrom(codedInputByteBufferNano);
    }
}
