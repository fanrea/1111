package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveVoicePartyMicSeatUserLevelUpNotice extends MessageNano {
    private static volatile LiveVoicePartyMicSeatUserLevelUpNotice[] _emptyArray;
    public int level;
    public LiveCdnNodeView[] material;
    public int subLevel;
    public String title;
    public String toast;

    public static LiveVoicePartyMicSeatUserLevelUpNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveVoicePartyMicSeatUserLevelUpNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveVoicePartyMicSeatUserLevelUpNotice() {
        clear();
    }

    public final LiveVoicePartyMicSeatUserLevelUpNotice clear() {
        this.material = LiveCdnNodeView.emptyArray();
        this.title = "";
        this.toast = "";
        this.level = 0;
        this.subLevel = 0;
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
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.title);
        }
        if (!this.toast.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.toast);
        }
        int i2 = this.level;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        int i3 = this.subLevel;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
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
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
        }
        if (!this.toast.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.toast);
        }
        int i2 = this.level;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i2);
        }
        int i3 = this.subLevel;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(5, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveVoicePartyMicSeatUserLevelUpNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
            } else if (tag == 18) {
                this.title = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.toast = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.level = codedInputByteBufferNano.readInt32();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.subLevel = codedInputByteBufferNano.readInt32();
            }
        }
    }

    public static LiveVoicePartyMicSeatUserLevelUpNotice parseFrom(byte[] bArr) {
        return (LiveVoicePartyMicSeatUserLevelUpNotice) MessageNano.mergeFrom(new LiveVoicePartyMicSeatUserLevelUpNotice(), bArr);
    }

    public static LiveVoicePartyMicSeatUserLevelUpNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveVoicePartyMicSeatUserLevelUpNotice().mergeFrom(codedInputByteBufferNano);
    }
}
