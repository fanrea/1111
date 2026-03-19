package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveScoreLineChatTopProgressBarColorInfo extends MessageNano {
    private static volatile LiveScoreLineChatTopProgressBarColorInfo[] _emptyArray;
    public LiveScoreLineChatColorInfo blankBarDownColor;
    public LiveScoreLineChatColorInfo blankBarUpColor;
    public LiveScoreLineChatColorInfo scoreProgressColor;

    public static LiveScoreLineChatTopProgressBarColorInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveScoreLineChatTopProgressBarColorInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveScoreLineChatTopProgressBarColorInfo() {
        clear();
    }

    public final LiveScoreLineChatTopProgressBarColorInfo clear() {
        this.blankBarUpColor = null;
        this.blankBarDownColor = null;
        this.scoreProgressColor = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo = this.blankBarUpColor;
        if (liveScoreLineChatColorInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, liveScoreLineChatColorInfo);
        }
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo2 = this.blankBarDownColor;
        if (liveScoreLineChatColorInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(2, liveScoreLineChatColorInfo2);
        }
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo3 = this.scoreProgressColor;
        if (liveScoreLineChatColorInfo3 != null) {
            codedOutputByteBufferNano.writeMessage(3, liveScoreLineChatColorInfo3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo = this.blankBarUpColor;
        if (liveScoreLineChatColorInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveScoreLineChatColorInfo);
        }
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo2 = this.blankBarDownColor;
        if (liveScoreLineChatColorInfo2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveScoreLineChatColorInfo2);
        }
        LiveScoreLineChatColorInfo liveScoreLineChatColorInfo3 = this.scoreProgressColor;
        return liveScoreLineChatColorInfo3 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, liveScoreLineChatColorInfo3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveScoreLineChatTopProgressBarColorInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.blankBarUpColor == null) {
                    this.blankBarUpColor = new LiveScoreLineChatColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.blankBarUpColor);
            } else if (tag == 18) {
                if (this.blankBarDownColor == null) {
                    this.blankBarDownColor = new LiveScoreLineChatColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.blankBarDownColor);
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.scoreProgressColor == null) {
                    this.scoreProgressColor = new LiveScoreLineChatColorInfo();
                }
                codedInputByteBufferNano.readMessage(this.scoreProgressColor);
            }
        }
    }

    public static LiveScoreLineChatTopProgressBarColorInfo parseFrom(byte[] bArr) {
        return (LiveScoreLineChatTopProgressBarColorInfo) MessageNano.mergeFrom(new LiveScoreLineChatTopProgressBarColorInfo(), bArr);
    }

    public static LiveScoreLineChatTopProgressBarColorInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveScoreLineChatTopProgressBarColorInfo().mergeFrom(codedInputByteBufferNano);
    }
}
