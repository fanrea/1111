package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class VoiceNotificationPlainTextMessage extends MessageNano {
    private static volatile VoiceNotificationPlainTextMessage[] _emptyArray;
    public String backgroundColor;
    public String content;
    public String textColor;

    public static VoiceNotificationPlainTextMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new VoiceNotificationPlainTextMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public VoiceNotificationPlainTextMessage() {
        clear();
    }

    public final VoiceNotificationPlainTextMessage clear() {
        this.content = "";
        this.textColor = "";
        this.backgroundColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.content);
        }
        if (!this.textColor.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.textColor);
        }
        if (!this.backgroundColor.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.backgroundColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.content);
        }
        if (!this.textColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.textColor);
        }
        return !this.backgroundColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.backgroundColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final VoiceNotificationPlainTextMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.textColor = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.backgroundColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static VoiceNotificationPlainTextMessage parseFrom(byte[] bArr) {
        return (VoiceNotificationPlainTextMessage) MessageNano.mergeFrom(new VoiceNotificationPlainTextMessage(), bArr);
    }

    public static VoiceNotificationPlainTextMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new VoiceNotificationPlainTextMessage().mergeFrom(codedInputByteBufferNano);
    }
}
