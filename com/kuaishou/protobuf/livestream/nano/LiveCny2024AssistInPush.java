package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCny2024AssistInPush {

    public static final class SCLiveActivityAssistInPushWithAck extends MessageNano {
        private static volatile SCLiveActivityAssistInPushWithAck[] _emptyArray;
        public String ackUri;
        public long biz;
        public String body;
        public String buttonText;
        public String buttonUri;
        public String contentUrl;
        public String iconUri;
        public String liveStreamId;
        public String messageId;
        public boolean onlyActivityRoom;
        public String title;

        public static SCLiveActivityAssistInPushWithAck[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveActivityAssistInPushWithAck[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveActivityAssistInPushWithAck() {
            clear();
        }

        public final SCLiveActivityAssistInPushWithAck clear() {
            this.messageId = "";
            this.liveStreamId = "";
            this.biz = 0L;
            this.title = "";
            this.body = "";
            this.iconUri = "";
            this.buttonText = "";
            this.buttonUri = "";
            this.ackUri = "";
            this.onlyActivityRoom = false;
            this.contentUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.messageId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.messageId);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.liveStreamId);
            }
            long j = this.biz;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.title);
            }
            if (!this.body.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.body);
            }
            if (!this.iconUri.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.iconUri);
            }
            if (!this.buttonText.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.buttonText);
            }
            if (!this.buttonUri.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.buttonUri);
            }
            if (!this.ackUri.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.ackUri);
            }
            boolean z = this.onlyActivityRoom;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            if (!this.contentUrl.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.contentUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.messageId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.messageId);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
            }
            long j = this.biz;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.title);
            }
            if (!this.body.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.body);
            }
            if (!this.iconUri.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.iconUri);
            }
            if (!this.buttonText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.buttonText);
            }
            if (!this.buttonUri.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.buttonUri);
            }
            if (!this.ackUri.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.ackUri);
            }
            boolean z = this.onlyActivityRoom;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z);
            }
            return !this.contentUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.contentUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveActivityAssistInPushWithAck mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.messageId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 24:
                        this.biz = codedInputByteBufferNano.readUInt64();
                        break;
                    case 34:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.body = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.iconUri = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.buttonText = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.buttonUri = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.ackUri = codedInputByteBufferNano.readString();
                        break;
                    case 80:
                        this.onlyActivityRoom = codedInputByteBufferNano.readBool();
                        break;
                    case 90:
                        this.contentUrl = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveActivityAssistInPushWithAck parseFrom(byte[] bArr) {
            return (SCLiveActivityAssistInPushWithAck) MessageNano.mergeFrom(new SCLiveActivityAssistInPushWithAck(), bArr);
        }

        public static SCLiveActivityAssistInPushWithAck parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveActivityAssistInPushWithAck().mergeFrom(codedInputByteBufferNano);
        }
    }
}
