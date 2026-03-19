package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatSwitchBiz extends MessageNano {
    private static volatile SCInteractiveChatSwitchBiz[] _emptyArray;
    public InteractiveChatSwitchBizExtraInfo endExtraInfo;
    public InteractiveChatRoomInfo roomInfo;
    public InteractiveChatSwitchBizExtraInfo startExtraInfo;
    public long timestamp;
    public long version;

    public static SCInteractiveChatSwitchBiz[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatSwitchBiz[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatSwitchBiz() {
        clear();
    }

    public final SCInteractiveChatSwitchBiz clear() {
        this.roomInfo = null;
        this.endExtraInfo = null;
        this.startExtraInfo = null;
        this.timestamp = 0L;
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        InteractiveChatRoomInfo interactiveChatRoomInfo = this.roomInfo;
        if (interactiveChatRoomInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatRoomInfo);
        }
        InteractiveChatSwitchBizExtraInfo interactiveChatSwitchBizExtraInfo = this.endExtraInfo;
        if (interactiveChatSwitchBizExtraInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, interactiveChatSwitchBizExtraInfo);
        }
        InteractiveChatSwitchBizExtraInfo interactiveChatSwitchBizExtraInfo2 = this.startExtraInfo;
        if (interactiveChatSwitchBizExtraInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(3, interactiveChatSwitchBizExtraInfo2);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        long j2 = this.version;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
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
        InteractiveChatSwitchBizExtraInfo interactiveChatSwitchBizExtraInfo = this.endExtraInfo;
        if (interactiveChatSwitchBizExtraInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, interactiveChatSwitchBizExtraInfo);
        }
        InteractiveChatSwitchBizExtraInfo interactiveChatSwitchBizExtraInfo2 = this.startExtraInfo;
        if (interactiveChatSwitchBizExtraInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, interactiveChatSwitchBizExtraInfo2);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        long j2 = this.version;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatSwitchBiz mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                if (this.endExtraInfo == null) {
                    this.endExtraInfo = new InteractiveChatSwitchBizExtraInfo();
                }
                codedInputByteBufferNano.readMessage(this.endExtraInfo);
            } else if (tag == 26) {
                if (this.startExtraInfo == null) {
                    this.startExtraInfo = new InteractiveChatSwitchBizExtraInfo();
                }
                codedInputByteBufferNano.readMessage(this.startExtraInfo);
            } else if (tag == 32) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCInteractiveChatSwitchBiz parseFrom(byte[] bArr) {
        return (SCInteractiveChatSwitchBiz) MessageNano.mergeFrom(new SCInteractiveChatSwitchBiz(), bArr);
    }

    public static SCInteractiveChatSwitchBiz parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatSwitchBiz().mergeFrom(codedInputByteBufferNano);
    }
}
