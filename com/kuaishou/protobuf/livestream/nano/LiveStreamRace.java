package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveStreamRace extends MessageNano {
    private static volatile LiveStreamRace[] _emptyArray;
    public long cost;
    public Network network;
    public long reraceCount;
    public Round[] round;
    public long startTime;
    public boolean success;
    public String tag;

    public static LiveStreamRace[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveStreamRace[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveStreamRace() {
        clear();
    }

    public final LiveStreamRace clear() {
        this.tag = "";
        this.network = null;
        this.round = Round.emptyArray();
        this.success = false;
        this.startTime = 0L;
        this.cost = 0L;
        this.reraceCount = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.tag.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.tag);
        }
        Network network = this.network;
        if (network != null) {
            codedOutputByteBufferNano.writeMessage(2, network);
        }
        Round[] roundArr = this.round;
        if (roundArr != null && roundArr.length > 0) {
            int i = 0;
            while (true) {
                Round[] roundArr2 = this.round;
                if (i >= roundArr2.length) {
                    break;
                }
                Round round = roundArr2[i];
                if (round != null) {
                    codedOutputByteBufferNano.writeMessage(6, round);
                }
                i++;
            }
        }
        boolean z = this.success;
        if (z) {
            codedOutputByteBufferNano.writeBool(7, z);
        }
        long j = this.startTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j);
        }
        long j2 = this.cost;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j2);
        }
        long j3 = this.reraceCount;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.tag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.tag);
        }
        Network network = this.network;
        if (network != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, network);
        }
        Round[] roundArr = this.round;
        if (roundArr != null && roundArr.length > 0) {
            int i = 0;
            while (true) {
                Round[] roundArr2 = this.round;
                if (i >= roundArr2.length) {
                    break;
                }
                Round round = roundArr2[i];
                if (round != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, round);
                }
                i++;
            }
        }
        boolean z = this.success;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
        }
        long j = this.startTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j);
        }
        long j2 = this.cost;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j2);
        }
        long j3 = this.reraceCount;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(10, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveStreamRace mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.tag = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                if (this.network == null) {
                    this.network = new Network();
                }
                codedInputByteBufferNano.readMessage(this.network);
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                Round[] roundArr = this.round;
                int length = roundArr == null ? 0 : roundArr.length;
                Round[] roundArr2 = new Round[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.round, 0, roundArr2, 0, length);
                }
                while (length < roundArr2.length - 1) {
                    roundArr2[length] = new Round();
                    codedInputByteBufferNano.readMessage(roundArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                roundArr2[length] = new Round();
                codedInputByteBufferNano.readMessage(roundArr2[length]);
                this.round = roundArr2;
            } else if (tag == 56) {
                this.success = codedInputByteBufferNano.readBool();
            } else if (tag == 64) {
                this.startTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 72) {
                this.cost = codedInputByteBufferNano.readUInt64();
            } else if (tag != 80) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.reraceCount = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveStreamRace parseFrom(byte[] bArr) {
        return (LiveStreamRace) MessageNano.mergeFrom(new LiveStreamRace(), bArr);
    }

    public static LiveStreamRace parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveStreamRace().mergeFrom(codedInputByteBufferNano);
    }
}
