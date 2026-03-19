package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftSendPromptOkAction extends MessageNano {
    private static volatile LiveGiftSendPromptOkAction[] _emptyArray;
    public int actionType;
    public String link;

    public static LiveGiftSendPromptOkAction[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftSendPromptOkAction[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftSendPromptOkAction() {
        clear();
    }

    public final LiveGiftSendPromptOkAction clear() {
        this.actionType = 0;
        this.link = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.actionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.link.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.link);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.actionType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        return !this.link.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.link) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftSendPromptOkAction mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.actionType = codedInputByteBufferNano.readUInt32();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.link = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveGiftSendPromptOkAction parseFrom(byte[] bArr) {
        return (LiveGiftSendPromptOkAction) MessageNano.mergeFrom(new LiveGiftSendPromptOkAction(), bArr);
    }

    public static LiveGiftSendPromptOkAction parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftSendPromptOkAction().mergeFrom(codedInputByteBufferNano);
    }
}
