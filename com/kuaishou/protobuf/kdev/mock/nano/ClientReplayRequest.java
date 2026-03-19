package com.kuaishou.protobuf.kdev.mock.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ClientReplayRequest extends MessageNano {
    public static final int OPERATION_FIELD_NUMBER = 5;
    public static final int RECORD_FIELD_NUMBER = 3;
    public static final int REPLAY_FIELD_NUMBER = 4;
    private static volatile ClientReplayRequest[] _emptyArray;
    private int dataCase_ = 0;
    private Object data_;
    public int payloadType;
    public long time;

    public final int getDataCase() {
        return this.dataCase_;
    }

    public final ClientReplayRequest clearData() {
        this.dataCase_ = 0;
        this.data_ = null;
        return this;
    }

    public static ClientReplayRequest[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new ClientReplayRequest[0];
                }
            }
        }
        return _emptyArray;
    }

    public final boolean hasRecord() {
        return this.dataCase_ == 3;
    }

    public final Record getRecord() {
        if (this.dataCase_ == 3) {
            return (Record) this.data_;
        }
        return null;
    }

    public final ClientReplayRequest setRecord(Record record) {
        if (record == null) {
            throw new NullPointerException();
        }
        this.dataCase_ = 3;
        this.data_ = record;
        return this;
    }

    public final boolean hasReplay() {
        return this.dataCase_ == 4;
    }

    public final Replay getReplay() {
        if (this.dataCase_ == 4) {
            return (Replay) this.data_;
        }
        return null;
    }

    public final ClientReplayRequest setReplay(Replay replay) {
        if (replay == null) {
            throw new NullPointerException();
        }
        this.dataCase_ = 4;
        this.data_ = replay;
        return this;
    }

    public final boolean hasOperation() {
        return this.dataCase_ == 5;
    }

    public final Operation getOperation() {
        if (this.dataCase_ == 5) {
            return (Operation) this.data_;
        }
        return null;
    }

    public final ClientReplayRequest setOperation(Operation operation) {
        if (operation == null) {
            throw new NullPointerException();
        }
        this.dataCase_ = 5;
        this.data_ = operation;
        return this;
    }

    public ClientReplayRequest() {
        clear();
    }

    public final ClientReplayRequest clear() {
        this.payloadType = 0;
        this.time = 0L;
        clearData();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.payloadType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (this.dataCase_ == 3) {
            codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.data_);
        }
        if (this.dataCase_ == 4) {
            codedOutputByteBufferNano.writeMessage(4, (MessageNano) this.data_);
        }
        if (this.dataCase_ == 5) {
            codedOutputByteBufferNano.writeMessage(5, (MessageNano) this.data_);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.payloadType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (this.dataCase_ == 3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.data_);
        }
        if (this.dataCase_ == 4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano) this.data_);
        }
        return this.dataCase_ == 5 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano) this.data_) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final ClientReplayRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4) {
                    this.payloadType = int32;
                }
            } else if (tag == 16) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                if (this.dataCase_ != 3) {
                    this.data_ = new Record();
                }
                codedInputByteBufferNano.readMessage((MessageNano) this.data_);
                this.dataCase_ = 3;
            } else if (tag == 34) {
                if (this.dataCase_ != 4) {
                    this.data_ = new Replay();
                }
                codedInputByteBufferNano.readMessage((MessageNano) this.data_);
                this.dataCase_ = 4;
            } else if (tag != 42) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.dataCase_ != 5) {
                    this.data_ = new Operation();
                }
                codedInputByteBufferNano.readMessage((MessageNano) this.data_);
                this.dataCase_ = 5;
            }
        }
    }

    public static ClientReplayRequest parseFrom(byte[] bArr) {
        return (ClientReplayRequest) MessageNano.mergeFrom(new ClientReplayRequest(), bArr);
    }

    public static ClientReplayRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new ClientReplayRequest().mergeFrom(codedInputByteBufferNano);
    }
}
