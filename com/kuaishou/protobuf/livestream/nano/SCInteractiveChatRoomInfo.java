package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatRoomInfo extends MessageNano {
    private static volatile SCInteractiveChatRoomInfo[] _emptyArray;
    public String extraInfoPb;
    public InteractiveChatRoomInfo roomInfo;
    public long timestamp;

    public static SCInteractiveChatRoomInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatRoomInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatRoomInfo() {
        clear();
    }

    public final SCInteractiveChatRoomInfo clear() {
        this.roomInfo = null;
        this.extraInfoPb = "";
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatRoomInfo interactiveChatRoomInfo = this.roomInfo;
        if (interactiveChatRoomInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatRoomInfo);
        }
        if (!this.extraInfoPb.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.extraInfoPb);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveChatRoomInfo interactiveChatRoomInfo = this.roomInfo;
        if (interactiveChatRoomInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveChatRoomInfo);
        }
        if (!this.extraInfoPb.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.extraInfoPb);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatRoomInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.roomInfo == null) {
                    this.roomInfo = new InteractiveChatRoomInfo();
                }
                codedInputByteBufferNano.readMessage(this.roomInfo);
            } else if (tag == 18) {
                this.extraInfoPb = codedInputByteBufferNano.readString();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCInteractiveChatRoomInfo parseFrom(byte[] bArr) {
        return (SCInteractiveChatRoomInfo) MessageNano.mergeFrom(new SCInteractiveChatRoomInfo(), bArr);
    }

    public static SCInteractiveChatRoomInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatRoomInfo().mergeFrom(codedInputByteBufferNano);
    }
}
