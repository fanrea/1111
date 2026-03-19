package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface Cny2024WarmupPray {

    public static final class SCLiveCny2024WarmupPrayTreasureBoxTokenReady extends MessageNano {
        private static volatile SCLiveCny2024WarmupPrayTreasureBoxTokenReady[] _emptyArray;
        public Map<String, String> extraMessage;
        public long ldRoomMaxRequestTokenTimeMs;
        public long ldRoomMinRequestTokenTimeMs;
        public long maxRequestTokenTimeMs;
        public int maxRetryCount;
        public long maxRetryIntervalMills;
        public long minRequestTokenTimeMs;

        public static SCLiveCny2024WarmupPrayTreasureBoxTokenReady[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024WarmupPrayTreasureBoxTokenReady[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024WarmupPrayTreasureBoxTokenReady() {
            clear();
        }

        public final SCLiveCny2024WarmupPrayTreasureBoxTokenReady clear() {
            this.minRequestTokenTimeMs = 0L;
            this.maxRequestTokenTimeMs = 0L;
            this.ldRoomMinRequestTokenTimeMs = 0L;
            this.ldRoomMaxRequestTokenTimeMs = 0L;
            this.maxRetryCount = 0;
            this.maxRetryIntervalMills = 0L;
            this.extraMessage = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            long j = this.minRequestTokenTimeMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.maxRequestTokenTimeMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.ldRoomMinRequestTokenTimeMs;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            long j4 = this.ldRoomMaxRequestTokenTimeMs;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j4);
            }
            int i = this.maxRetryCount;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i);
            }
            long j5 = this.maxRetryIntervalMills;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j5);
            }
            Map<String, String> map = this.extraMessage;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 7, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.minRequestTokenTimeMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.maxRequestTokenTimeMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.ldRoomMinRequestTokenTimeMs;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
            }
            long j4 = this.ldRoomMaxRequestTokenTimeMs;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j4);
            }
            int i = this.maxRetryCount;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i);
            }
            long j5 = this.maxRetryIntervalMills;
            if (j5 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j5);
            }
            Map<String, String> map = this.extraMessage;
            return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 7, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024WarmupPrayTreasureBoxTokenReady mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.minRequestTokenTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.maxRequestTokenTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.ldRoomMinRequestTokenTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.ldRoomMaxRequestTokenTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.maxRetryCount = codedInputByteBufferNano.readUInt32();
                } else if (tag == 48) {
                    this.maxRetryIntervalMills = codedInputByteBufferNano.readUInt64();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraMessage = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMessage, mapFactory, 9, 9, null, 10, 18);
                }
            }
        }

        public static SCLiveCny2024WarmupPrayTreasureBoxTokenReady parseFrom(byte[] bArr) {
            return (SCLiveCny2024WarmupPrayTreasureBoxTokenReady) MessageNano.mergeFrom(new SCLiveCny2024WarmupPrayTreasureBoxTokenReady(), bArr);
        }

        public static SCLiveCny2024WarmupPrayTreasureBoxTokenReady parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024WarmupPrayTreasureBoxTokenReady().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024WarmupPrayPullRequest extends MessageNano {
        private static volatile SCLiveCny2024WarmupPrayPullRequest[] _emptyArray;
        public String bizInfo;
        public long requestLatestTimestamp;
        public String requestUri;

        public static SCLiveCny2024WarmupPrayPullRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024WarmupPrayPullRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024WarmupPrayPullRequest() {
            clear();
        }

        public final SCLiveCny2024WarmupPrayPullRequest clear() {
            this.requestLatestTimestamp = 0L;
            this.bizInfo = "";
            this.requestUri = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.requestLatestTimestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.bizInfo.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bizInfo);
            }
            if (!this.requestUri.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.requestUri);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.requestLatestTimestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.bizInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bizInfo);
            }
            return !this.requestUri.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.requestUri) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024WarmupPrayPullRequest mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.requestLatestTimestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.bizInfo = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.requestUri = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveCny2024WarmupPrayPullRequest parseFrom(byte[] bArr) {
            return (SCLiveCny2024WarmupPrayPullRequest) MessageNano.mergeFrom(new SCLiveCny2024WarmupPrayPullRequest(), bArr);
        }

        public static SCLiveCny2024WarmupPrayPullRequest parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024WarmupPrayPullRequest().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024WarmupPrayTokenUpdate extends MessageNano {
        private static volatile SCLiveCny2024WarmupPrayTokenUpdate[] _emptyArray;
        public String tokenToast;

        public static SCLiveCny2024WarmupPrayTokenUpdate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024WarmupPrayTokenUpdate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024WarmupPrayTokenUpdate() {
            clear();
        }

        public final SCLiveCny2024WarmupPrayTokenUpdate clear() {
            this.tokenToast = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.tokenToast.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.tokenToast);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.tokenToast.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.tokenToast) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024WarmupPrayTokenUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.tokenToast = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveCny2024WarmupPrayTokenUpdate parseFrom(byte[] bArr) {
            return (SCLiveCny2024WarmupPrayTokenUpdate) MessageNano.mergeFrom(new SCLiveCny2024WarmupPrayTokenUpdate(), bArr);
        }

        public static SCLiveCny2024WarmupPrayTokenUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024WarmupPrayTokenUpdate().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveCny2024WarmupPrayWishDataUpdate extends MessageNano {
        private static volatile SCLiveCny2024WarmupPrayWishDataUpdate[] _emptyArray;
        public long maxScatterTimeMs;
        public long minScatterTimeMs;

        public static SCLiveCny2024WarmupPrayWishDataUpdate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCny2024WarmupPrayWishDataUpdate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCny2024WarmupPrayWishDataUpdate() {
            clear();
        }

        public final SCLiveCny2024WarmupPrayWishDataUpdate clear() {
            this.minScatterTimeMs = 0L;
            this.maxScatterTimeMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.minScatterTimeMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.maxScatterTimeMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.minScatterTimeMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.maxScatterTimeMs;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCny2024WarmupPrayWishDataUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.minScatterTimeMs = codedInputByteBufferNano.readUInt64();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxScatterTimeMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveCny2024WarmupPrayWishDataUpdate parseFrom(byte[] bArr) {
            return (SCLiveCny2024WarmupPrayWishDataUpdate) MessageNano.mergeFrom(new SCLiveCny2024WarmupPrayWishDataUpdate(), bArr);
        }

        public static SCLiveCny2024WarmupPrayWishDataUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCny2024WarmupPrayWishDataUpdate().mergeFrom(codedInputByteBufferNano);
        }
    }
}
