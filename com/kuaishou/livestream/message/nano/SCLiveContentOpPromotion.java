package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveContentOpPromotion extends MessageNano {
    private static volatile SCLiveContentOpPromotion[] _emptyArray;
    public String content;
    public String liveStreamId;
    public int operation;
    public int showSeconds;
    public int status;
    public String taskId;

    public static SCLiveContentOpPromotion[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveContentOpPromotion[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveContentOpPromotion() {
        clear();
    }

    public final SCLiveContentOpPromotion clear() {
        this.operation = 0;
        this.taskId = "";
        this.liveStreamId = "";
        this.status = 0;
        this.content = "";
        this.showSeconds = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.operation;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.taskId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.taskId);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.liveStreamId);
        }
        int i2 = this.status;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i2);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.content);
        }
        int i3 = this.showSeconds;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.operation;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.taskId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.taskId);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
        }
        int i2 = this.status;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.content);
        }
        int i3 = this.showSeconds;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(6, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveContentOpPromotion mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.operation = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                this.taskId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.status = codedInputByteBufferNano.readUInt32();
            } else if (tag == 42) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.showSeconds = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveContentOpPromotion parseFrom(byte[] bArr) {
        return (SCLiveContentOpPromotion) MessageNano.mergeFrom(new SCLiveContentOpPromotion(), bArr);
    }

    public static SCLiveContentOpPromotion parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveContentOpPromotion().mergeFrom(codedInputByteBufferNano);
    }
}
