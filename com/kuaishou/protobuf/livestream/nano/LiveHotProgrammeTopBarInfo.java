package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveHotProgrammeTopBarInfo extends MessageNano {
    private static volatile LiveHotProgrammeTopBarInfo[] _emptyArray;
    public long enterRoomDelayShowMs;
    public long showDurationMs;
    public String text;

    public static LiveHotProgrammeTopBarInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveHotProgrammeTopBarInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveHotProgrammeTopBarInfo() {
        clear();
    }

    public final LiveHotProgrammeTopBarInfo clear() {
        this.text = "";
        this.showDurationMs = 0L;
        this.enterRoomDelayShowMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.text);
        }
        long j = this.showDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        long j2 = this.enterRoomDelayShowMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
        }
        long j = this.showDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        long j2 = this.enterRoomDelayShowMs;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveHotProgrammeTopBarInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.showDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enterRoomDelayShowMs = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveHotProgrammeTopBarInfo parseFrom(byte[] bArr) {
        return (LiveHotProgrammeTopBarInfo) MessageNano.mergeFrom(new LiveHotProgrammeTopBarInfo(), bArr);
    }

    public static LiveHotProgrammeTopBarInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveHotProgrammeTopBarInfo().mergeFrom(codedInputByteBufferNano);
    }
}
