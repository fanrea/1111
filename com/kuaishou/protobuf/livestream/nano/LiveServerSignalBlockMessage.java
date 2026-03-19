package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveServerSignalBlockMessage extends MessageNano {
    private static volatile LiveServerSignalBlockMessage[] _emptyArray;
    public LiveServerSignalBlockConfigMessage[] signalBlockConfig;
    public long timestamp;

    public static LiveServerSignalBlockMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveServerSignalBlockMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveServerSignalBlockMessage() {
        clear();
    }

    public final LiveServerSignalBlockMessage clear() {
        this.signalBlockConfig = LiveServerSignalBlockConfigMessage.emptyArray();
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveServerSignalBlockConfigMessage[] liveServerSignalBlockConfigMessageArr = this.signalBlockConfig;
        if (liveServerSignalBlockConfigMessageArr != null && liveServerSignalBlockConfigMessageArr.length > 0) {
            int i = 0;
            while (true) {
                LiveServerSignalBlockConfigMessage[] liveServerSignalBlockConfigMessageArr2 = this.signalBlockConfig;
                if (i >= liveServerSignalBlockConfigMessageArr2.length) {
                    break;
                }
                LiveServerSignalBlockConfigMessage liveServerSignalBlockConfigMessage = liveServerSignalBlockConfigMessageArr2[i];
                if (liveServerSignalBlockConfigMessage != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveServerSignalBlockConfigMessage);
                }
                i++;
            }
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveServerSignalBlockConfigMessage[] liveServerSignalBlockConfigMessageArr = this.signalBlockConfig;
        if (liveServerSignalBlockConfigMessageArr != null && liveServerSignalBlockConfigMessageArr.length > 0) {
            int i = 0;
            while (true) {
                LiveServerSignalBlockConfigMessage[] liveServerSignalBlockConfigMessageArr2 = this.signalBlockConfig;
                if (i >= liveServerSignalBlockConfigMessageArr2.length) {
                    break;
                }
                LiveServerSignalBlockConfigMessage liveServerSignalBlockConfigMessage = liveServerSignalBlockConfigMessageArr2[i];
                if (liveServerSignalBlockConfigMessage != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveServerSignalBlockConfigMessage);
                }
                i++;
            }
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveServerSignalBlockMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LiveServerSignalBlockConfigMessage[] liveServerSignalBlockConfigMessageArr = this.signalBlockConfig;
                int length = liveServerSignalBlockConfigMessageArr == null ? 0 : liveServerSignalBlockConfigMessageArr.length;
                LiveServerSignalBlockConfigMessage[] liveServerSignalBlockConfigMessageArr2 = new LiveServerSignalBlockConfigMessage[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.signalBlockConfig, 0, liveServerSignalBlockConfigMessageArr2, 0, length);
                }
                while (length < liveServerSignalBlockConfigMessageArr2.length - 1) {
                    liveServerSignalBlockConfigMessageArr2[length] = new LiveServerSignalBlockConfigMessage();
                    codedInputByteBufferNano.readMessage(liveServerSignalBlockConfigMessageArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveServerSignalBlockConfigMessageArr2[length] = new LiveServerSignalBlockConfigMessage();
                codedInputByteBufferNano.readMessage(liveServerSignalBlockConfigMessageArr2[length]);
                this.signalBlockConfig = liveServerSignalBlockConfigMessageArr2;
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveServerSignalBlockMessage parseFrom(byte[] bArr) {
        return (LiveServerSignalBlockMessage) MessageNano.mergeFrom(new LiveServerSignalBlockMessage(), bArr);
    }

    public static LiveServerSignalBlockMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveServerSignalBlockMessage().mergeFrom(codedInputByteBufferNano);
    }
}
