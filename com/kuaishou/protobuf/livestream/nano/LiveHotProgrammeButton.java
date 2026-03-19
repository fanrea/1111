package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveHotProgrammeButton extends MessageNano {
    private static volatile LiveHotProgrammeButton[] _emptyArray;
    public String color;
    public String text;

    public static LiveHotProgrammeButton[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveHotProgrammeButton[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveHotProgrammeButton() {
        clear();
    }

    public final LiveHotProgrammeButton clear() {
        this.text = "";
        this.color = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.text);
        }
        if (!this.color.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.color);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        return !this.color.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.color) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveHotProgrammeButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.color = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveHotProgrammeButton parseFrom(byte[] bArr) {
        return (LiveHotProgrammeButton) MessageNano.mergeFrom(new LiveHotProgrammeButton(), bArr);
    }

    public static LiveHotProgrammeButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveHotProgrammeButton().mergeFrom(codedInputByteBufferNano);
    }
}
