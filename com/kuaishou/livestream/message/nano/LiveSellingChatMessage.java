package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveSellingChatMessage {

    public static final class SCLiveSellingChatIndicator extends MessageNano {
        private static volatile SCLiveSellingChatIndicator[] _emptyArray;
        public String bizId;
        public int bizType;
        public SCSellingChatContentMessage[] content;
        public SCSellingChatRichTextMessage[] title;

        public static final class SCSellingChatContentMessage extends MessageNano {
            private static volatile SCSellingChatContentMessage[] _emptyArray;
            public SCSellingChatRichTextMessage[] spanText;

            public static SCSellingChatContentMessage[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new SCSellingChatContentMessage[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public SCSellingChatContentMessage() {
                clear();
            }

            public final SCSellingChatContentMessage clear() {
                this.spanText = SCSellingChatRichTextMessage.emptyArray();
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr = this.spanText;
                if (sCSellingChatRichTextMessageArr != null && sCSellingChatRichTextMessageArr.length > 0) {
                    int i = 0;
                    while (true) {
                        SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr2 = this.spanText;
                        if (i >= sCSellingChatRichTextMessageArr2.length) {
                            break;
                        }
                        SCSellingChatRichTextMessage sCSellingChatRichTextMessage = sCSellingChatRichTextMessageArr2[i];
                        if (sCSellingChatRichTextMessage != null) {
                            codedOutputByteBufferNano.writeMessage(1, sCSellingChatRichTextMessage);
                        }
                        i++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr = this.spanText;
                if (sCSellingChatRichTextMessageArr != null && sCSellingChatRichTextMessageArr.length > 0) {
                    int i = 0;
                    while (true) {
                        SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr2 = this.spanText;
                        if (i >= sCSellingChatRichTextMessageArr2.length) {
                            break;
                        }
                        SCSellingChatRichTextMessage sCSellingChatRichTextMessage = sCSellingChatRichTextMessageArr2[i];
                        if (sCSellingChatRichTextMessage != null) {
                            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sCSellingChatRichTextMessage);
                        }
                        i++;
                    }
                }
                return iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final SCSellingChatContentMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr = this.spanText;
                        int length = sCSellingChatRichTextMessageArr == null ? 0 : sCSellingChatRichTextMessageArr.length;
                        SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr2 = new SCSellingChatRichTextMessage[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.spanText, 0, sCSellingChatRichTextMessageArr2, 0, length);
                        }
                        while (length < sCSellingChatRichTextMessageArr2.length - 1) {
                            sCSellingChatRichTextMessageArr2[length] = new SCSellingChatRichTextMessage();
                            codedInputByteBufferNano.readMessage(sCSellingChatRichTextMessageArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        sCSellingChatRichTextMessageArr2[length] = new SCSellingChatRichTextMessage();
                        codedInputByteBufferNano.readMessage(sCSellingChatRichTextMessageArr2[length]);
                        this.spanText = sCSellingChatRichTextMessageArr2;
                    }
                }
            }

            public static SCSellingChatContentMessage parseFrom(byte[] bArr) {
                return (SCSellingChatContentMessage) MessageNano.mergeFrom(new SCSellingChatContentMessage(), bArr);
            }

            public static SCSellingChatContentMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new SCSellingChatContentMessage().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static final class SCSellingChatRichTextMessage extends MessageNano {
            private static volatile SCSellingChatRichTextMessage[] _emptyArray;
            public int fontFamily;
            public int fontSize;
            public String text;
            public String textColor;

            public static SCSellingChatRichTextMessage[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new SCSellingChatRichTextMessage[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public SCSellingChatRichTextMessage() {
                clear();
            }

            public final SCSellingChatRichTextMessage clear() {
                this.textColor = "";
                this.text = "";
                this.fontSize = 0;
                this.fontFamily = 0;
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                if (!this.textColor.equals("")) {
                    codedOutputByteBufferNano.writeString(1, this.textColor);
                }
                if (!this.text.equals("")) {
                    codedOutputByteBufferNano.writeString(2, this.text);
                }
                int i = this.fontSize;
                if (i != 0) {
                    codedOutputByteBufferNano.writeUInt32(3, i);
                }
                int i2 = this.fontFamily;
                if (i2 != 0) {
                    codedOutputByteBufferNano.writeInt32(4, i2);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                if (!this.textColor.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.textColor);
                }
                if (!this.text.equals("")) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
                }
                int i = this.fontSize;
                if (i != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
                }
                int i2 = this.fontFamily;
                return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final SCSellingChatRichTextMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        this.textColor = codedInputByteBufferNano.readString();
                    } else if (tag == 18) {
                        this.text = codedInputByteBufferNano.readString();
                    } else if (tag == 24) {
                        this.fontSize = codedInputByteBufferNano.readUInt32();
                    } else if (tag != 32) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3 || int32 == 4 || int32 == 5) {
                            this.fontFamily = int32;
                        }
                    }
                }
            }

            public static SCSellingChatRichTextMessage parseFrom(byte[] bArr) {
                return (SCSellingChatRichTextMessage) MessageNano.mergeFrom(new SCSellingChatRichTextMessage(), bArr);
            }

            public static SCSellingChatRichTextMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new SCSellingChatRichTextMessage().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static SCLiveSellingChatIndicator[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveSellingChatIndicator[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveSellingChatIndicator() {
            clear();
        }

        public final SCLiveSellingChatIndicator clear() {
            this.bizType = 0;
            this.bizId = "";
            this.title = SCSellingChatRichTextMessage.emptyArray();
            this.content = SCSellingChatContentMessage.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bizId);
            }
            SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr = this.title;
            int i2 = 0;
            if (sCSellingChatRichTextMessageArr != null && sCSellingChatRichTextMessageArr.length > 0) {
                int i3 = 0;
                while (true) {
                    SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr2 = this.title;
                    if (i3 >= sCSellingChatRichTextMessageArr2.length) {
                        break;
                    }
                    SCSellingChatRichTextMessage sCSellingChatRichTextMessage = sCSellingChatRichTextMessageArr2[i3];
                    if (sCSellingChatRichTextMessage != null) {
                        codedOutputByteBufferNano.writeMessage(3, sCSellingChatRichTextMessage);
                    }
                    i3++;
                }
            }
            SCSellingChatContentMessage[] sCSellingChatContentMessageArr = this.content;
            if (sCSellingChatContentMessageArr != null && sCSellingChatContentMessageArr.length > 0) {
                while (true) {
                    SCSellingChatContentMessage[] sCSellingChatContentMessageArr2 = this.content;
                    if (i2 >= sCSellingChatContentMessageArr2.length) {
                        break;
                    }
                    SCSellingChatContentMessage sCSellingChatContentMessage = sCSellingChatContentMessageArr2[i2];
                    if (sCSellingChatContentMessage != null) {
                        codedOutputByteBufferNano.writeMessage(4, sCSellingChatContentMessage);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bizId);
            }
            SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr = this.title;
            int i2 = 0;
            if (sCSellingChatRichTextMessageArr != null && sCSellingChatRichTextMessageArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr2 = this.title;
                    if (i3 >= sCSellingChatRichTextMessageArr2.length) {
                        break;
                    }
                    SCSellingChatRichTextMessage sCSellingChatRichTextMessage = sCSellingChatRichTextMessageArr2[i3];
                    if (sCSellingChatRichTextMessage != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, sCSellingChatRichTextMessage);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            SCSellingChatContentMessage[] sCSellingChatContentMessageArr = this.content;
            if (sCSellingChatContentMessageArr != null && sCSellingChatContentMessageArr.length > 0) {
                while (true) {
                    SCSellingChatContentMessage[] sCSellingChatContentMessageArr2 = this.content;
                    if (i2 >= sCSellingChatContentMessageArr2.length) {
                        break;
                    }
                    SCSellingChatContentMessage sCSellingChatContentMessage = sCSellingChatContentMessageArr2[i2];
                    if (sCSellingChatContentMessage != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, sCSellingChatContentMessage);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveSellingChatIndicator mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.bizType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr = this.title;
                    int length = sCSellingChatRichTextMessageArr == null ? 0 : sCSellingChatRichTextMessageArr.length;
                    SCSellingChatRichTextMessage[] sCSellingChatRichTextMessageArr2 = new SCSellingChatRichTextMessage[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.title, 0, sCSellingChatRichTextMessageArr2, 0, length);
                    }
                    while (length < sCSellingChatRichTextMessageArr2.length - 1) {
                        sCSellingChatRichTextMessageArr2[length] = new SCSellingChatRichTextMessage();
                        codedInputByteBufferNano.readMessage(sCSellingChatRichTextMessageArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sCSellingChatRichTextMessageArr2[length] = new SCSellingChatRichTextMessage();
                    codedInputByteBufferNano.readMessage(sCSellingChatRichTextMessageArr2[length]);
                    this.title = sCSellingChatRichTextMessageArr2;
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    SCSellingChatContentMessage[] sCSellingChatContentMessageArr = this.content;
                    int length2 = sCSellingChatContentMessageArr == null ? 0 : sCSellingChatContentMessageArr.length;
                    SCSellingChatContentMessage[] sCSellingChatContentMessageArr2 = new SCSellingChatContentMessage[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.content, 0, sCSellingChatContentMessageArr2, 0, length2);
                    }
                    while (length2 < sCSellingChatContentMessageArr2.length - 1) {
                        sCSellingChatContentMessageArr2[length2] = new SCSellingChatContentMessage();
                        codedInputByteBufferNano.readMessage(sCSellingChatContentMessageArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    sCSellingChatContentMessageArr2[length2] = new SCSellingChatContentMessage();
                    codedInputByteBufferNano.readMessage(sCSellingChatContentMessageArr2[length2]);
                    this.content = sCSellingChatContentMessageArr2;
                }
            }
        }

        public static SCLiveSellingChatIndicator parseFrom(byte[] bArr) {
            return (SCLiveSellingChatIndicator) MessageNano.mergeFrom(new SCLiveSellingChatIndicator(), bArr);
        }

        public static SCLiveSellingChatIndicator parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveSellingChatIndicator().mergeFrom(codedInputByteBufferNano);
        }
    }
}
