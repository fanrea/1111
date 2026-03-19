package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveCustomizationCommentConfig extends MessageNano {
    private static volatile LiveCustomizationCommentConfig[] _emptyArray;
    public LiveCustomizationCommentSpeedConfig audienceSpeed;

    public static LiveCustomizationCommentConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCustomizationCommentConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCustomizationCommentConfig() {
        clear();
    }

    public final LiveCustomizationCommentConfig clear() {
        this.audienceSpeed = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveCustomizationCommentSpeedConfig liveCustomizationCommentSpeedConfig = this.audienceSpeed;
        if (liveCustomizationCommentSpeedConfig != null) {
            codedOutputByteBufferNano.writeMessage(1, liveCustomizationCommentSpeedConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveCustomizationCommentSpeedConfig liveCustomizationCommentSpeedConfig = this.audienceSpeed;
        return liveCustomizationCommentSpeedConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(1, liveCustomizationCommentSpeedConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCustomizationCommentConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.audienceSpeed == null) {
                    this.audienceSpeed = new LiveCustomizationCommentSpeedConfig();
                }
                codedInputByteBufferNano.readMessage(this.audienceSpeed);
            }
        }
    }

    public static LiveCustomizationCommentConfig parseFrom(byte[] bArr) {
        return (LiveCustomizationCommentConfig) MessageNano.mergeFrom(new LiveCustomizationCommentConfig(), bArr);
    }

    public static LiveCustomizationCommentConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCustomizationCommentConfig().mergeFrom(codedInputByteBufferNano);
    }
}
