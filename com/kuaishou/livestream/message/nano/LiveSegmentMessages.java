package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveSegmentMessages {

    public static final class LiveSegmentReplayFeed extends MessageNano {
        private static volatile LiveSegmentReplayFeed[] _emptyArray;
        public int compressionType;
        public long liveOffsetTime;
        public byte[] payload;

        @Retention(RetentionPolicy.SOURCE)
        public @interface CompressionType {
            public static final int GZIP = 2;
            public static final int NONE = 1;
            public static final int UNKNOWN = 0;
        }

        public static LiveSegmentReplayFeed[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSegmentReplayFeed[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSegmentReplayFeed() {
            clear();
        }

        public final LiveSegmentReplayFeed clear() {
            this.compressionType = 0;
            this.payload = WireFormatNano.EMPTY_BYTES;
            this.liveOffsetTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.compressionType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
                codedOutputByteBufferNano.writeBytes(2, this.payload);
            }
            long j = this.liveOffsetTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.compressionType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            if (!Arrays.equals(this.payload, WireFormatNano.EMPTY_BYTES)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(2, this.payload);
            }
            long j = this.liveOffsetTime;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSegmentReplayFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.compressionType = int32;
                    }
                } else if (tag == 18) {
                    this.payload = codedInputByteBufferNano.readBytes();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.liveOffsetTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveSegmentReplayFeed parseFrom(byte[] bArr) {
            return (LiveSegmentReplayFeed) MessageNano.mergeFrom(new LiveSegmentReplayFeed(), bArr);
        }

        public static LiveSegmentReplayFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSegmentReplayFeed().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSegmentFeedInfo extends MessageNano {
        private static volatile LiveSegmentFeedInfo[] _emptyArray;
        public LiveSegmentReplayFeed feed;
        public long segmentOffsetTime;

        public static LiveSegmentFeedInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSegmentFeedInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSegmentFeedInfo() {
            clear();
        }

        public final LiveSegmentFeedInfo clear() {
            this.feed = null;
            this.segmentOffsetTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveSegmentReplayFeed liveSegmentReplayFeed = this.feed;
            if (liveSegmentReplayFeed != null) {
                codedOutputByteBufferNano.writeMessage(1, liveSegmentReplayFeed);
            }
            long j = this.segmentOffsetTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveSegmentReplayFeed liveSegmentReplayFeed = this.feed;
            if (liveSegmentReplayFeed != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveSegmentReplayFeed);
            }
            long j = this.segmentOffsetTime;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSegmentFeedInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.feed == null) {
                        this.feed = new LiveSegmentReplayFeed();
                    }
                    codedInputByteBufferNano.readMessage(this.feed);
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.segmentOffsetTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveSegmentFeedInfo parseFrom(byte[] bArr) {
            return (LiveSegmentFeedInfo) MessageNano.mergeFrom(new LiveSegmentFeedInfo(), bArr);
        }

        public static LiveSegmentFeedInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSegmentFeedInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveSegmentFeedInfoResponse extends MessageNano {
        private static volatile LiveSegmentFeedInfoResponse[] _emptyArray;
        public String cursor;
        public LiveSegmentFeedInfo[] feedInfo;

        public static LiveSegmentFeedInfoResponse[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveSegmentFeedInfoResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveSegmentFeedInfoResponse() {
            clear();
        }

        public final LiveSegmentFeedInfoResponse clear() {
            this.feedInfo = LiveSegmentFeedInfo.emptyArray();
            this.cursor = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveSegmentFeedInfo[] liveSegmentFeedInfoArr = this.feedInfo;
            if (liveSegmentFeedInfoArr != null && liveSegmentFeedInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveSegmentFeedInfo[] liveSegmentFeedInfoArr2 = this.feedInfo;
                    if (i >= liveSegmentFeedInfoArr2.length) {
                        break;
                    }
                    LiveSegmentFeedInfo liveSegmentFeedInfo = liveSegmentFeedInfoArr2[i];
                    if (liveSegmentFeedInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveSegmentFeedInfo);
                    }
                    i++;
                }
            }
            if (!this.cursor.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.cursor);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveSegmentFeedInfo[] liveSegmentFeedInfoArr = this.feedInfo;
            if (liveSegmentFeedInfoArr != null && liveSegmentFeedInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveSegmentFeedInfo[] liveSegmentFeedInfoArr2 = this.feedInfo;
                    if (i >= liveSegmentFeedInfoArr2.length) {
                        break;
                    }
                    LiveSegmentFeedInfo liveSegmentFeedInfo = liveSegmentFeedInfoArr2[i];
                    if (liveSegmentFeedInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveSegmentFeedInfo);
                    }
                    i++;
                }
            }
            return !this.cursor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.cursor) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveSegmentFeedInfoResponse mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    LiveSegmentFeedInfo[] liveSegmentFeedInfoArr = this.feedInfo;
                    int length = liveSegmentFeedInfoArr == null ? 0 : liveSegmentFeedInfoArr.length;
                    LiveSegmentFeedInfo[] liveSegmentFeedInfoArr2 = new LiveSegmentFeedInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.feedInfo, 0, liveSegmentFeedInfoArr2, 0, length);
                    }
                    while (length < liveSegmentFeedInfoArr2.length - 1) {
                        liveSegmentFeedInfoArr2[length] = new LiveSegmentFeedInfo();
                        codedInputByteBufferNano.readMessage(liveSegmentFeedInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveSegmentFeedInfoArr2[length] = new LiveSegmentFeedInfo();
                    codedInputByteBufferNano.readMessage(liveSegmentFeedInfoArr2[length]);
                    this.feedInfo = liveSegmentFeedInfoArr2;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.cursor = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveSegmentFeedInfoResponse parseFrom(byte[] bArr) {
            return (LiveSegmentFeedInfoResponse) MessageNano.mergeFrom(new LiveSegmentFeedInfoResponse(), bArr);
        }

        public static LiveSegmentFeedInfoResponse parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveSegmentFeedInfoResponse().mergeFrom(codedInputByteBufferNano);
        }
    }
}
