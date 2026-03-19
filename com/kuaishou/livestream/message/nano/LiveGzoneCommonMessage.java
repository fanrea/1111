package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveGzoneCommonMessage {

    public static final class GzoneCommonNotificationMessage extends MessageNano {
        private static volatile GzoneCommonNotificationMessage[] _emptyArray;
        public int bizType;
        public String content;
        public String extra;
        public String liveStreamId;
        public int type;

        public static GzoneCommonNotificationMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GzoneCommonNotificationMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GzoneCommonNotificationMessage() {
            clear();
        }

        public final GzoneCommonNotificationMessage clear() {
            this.type = 0;
            this.bizType = 0;
            this.liveStreamId = "";
            this.content = "";
            this.extra = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.liveStreamId);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.content);
            }
            if (!this.extra.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.extra);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.bizType;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.liveStreamId);
            }
            if (!this.content.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.content);
            }
            return !this.extra.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.extra) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final GzoneCommonNotificationMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.type = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.bizType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.content = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extra = codedInputByteBufferNano.readString();
                }
            }
        }

        public static GzoneCommonNotificationMessage parseFrom(byte[] bArr) {
            return (GzoneCommonNotificationMessage) MessageNano.mergeFrom(new GzoneCommonNotificationMessage(), bArr);
        }

        public static GzoneCommonNotificationMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new GzoneCommonNotificationMessage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCGzoneActivityLiveMarkMessage extends MessageNano {
        private static volatile SCGzoneActivityLiveMarkMessage[] _emptyArray;
        public int bizId;
        public long endTime;
        public String ext;
        public long startTime;

        public static SCGzoneActivityLiveMarkMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCGzoneActivityLiveMarkMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCGzoneActivityLiveMarkMessage() {
            clear();
        }

        public final SCGzoneActivityLiveMarkMessage clear() {
            this.bizId = 0;
            this.startTime = 0L;
            this.endTime = 0L;
            this.ext = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.bizId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.startTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            if (!this.ext.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.ext);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.bizId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.startTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            return !this.ext.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.ext) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCGzoneActivityLiveMarkMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.bizId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.endTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.ext = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCGzoneActivityLiveMarkMessage parseFrom(byte[] bArr) {
            return (SCGzoneActivityLiveMarkMessage) MessageNano.mergeFrom(new SCGzoneActivityLiveMarkMessage(), bArr);
        }

        public static SCGzoneActivityLiveMarkMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCGzoneActivityLiveMarkMessage().mergeFrom(codedInputByteBufferNano);
        }
    }
}
