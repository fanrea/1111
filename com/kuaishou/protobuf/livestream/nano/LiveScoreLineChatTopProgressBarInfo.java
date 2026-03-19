package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatTopProgressBarInfo extends MessageNano {
    private static volatile LiveScoreLineChatTopProgressBarInfo[] _emptyArray;
    public LiveScoreLineChatTopProgressBarColorInfo leftColorInfo;
    public LiveScoreLineChatTopProgressBarColorInfo rightColorInfo;

    public static LiveScoreLineChatTopProgressBarInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatTopProgressBarInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatTopProgressBarInfo() {
        clear();
    }

    public final LiveScoreLineChatTopProgressBarInfo clear() {
        this.leftColorInfo = null;
        this.rightColorInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveScoreLineChatTopProgressBarColorInfo liveScoreLineChatTopProgressBarColorInfo = this.leftColorInfo;
        if (liveScoreLineChatTopProgressBarColorInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, liveScoreLineChatTopProgressBarColorInfo);
        }
        LiveScoreLineChatTopProgressBarColorInfo liveScoreLineChatTopProgressBarColorInfo2 = this.rightColorInfo;
        if (liveScoreLineChatTopProgressBarColorInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, liveScoreLineChatTopProgressBarColorInfo2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveScoreLineChatTopProgressBarColorInfo liveScoreLineChatTopProgressBarColorInfo = this.leftColorInfo;
        if (liveScoreLineChatTopProgressBarColorInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveScoreLineChatTopProgressBarColorInfo);
        }
        LiveScoreLineChatTopProgressBarColorInfo liveScoreLineChatTopProgressBarColorInfo2 = this.rightColorInfo;
        return liveScoreLineChatTopProgressBarColorInfo2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, liveScoreLineChatTopProgressBarColorInfo2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatTopProgressBarInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.leftColorInfo == null) {
                    this.leftColorInfo = new LiveScoreLineChatTopProgressBarColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.leftColorInfo);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.rightColorInfo == null) {
                    this.rightColorInfo = new LiveScoreLineChatTopProgressBarColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.rightColorInfo);
            }
        }
    }

    public static LiveScoreLineChatTopProgressBarInfo parseFrom(byte[] bArr) {
        return (LiveScoreLineChatTopProgressBarInfo) MessageNano.mergeFrom(new LiveScoreLineChatTopProgressBarInfo(), bArr);
    }

    public static LiveScoreLineChatTopProgressBarInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatTopProgressBarInfo().mergeFrom(codedInputByteBufferNano);
    }
}
