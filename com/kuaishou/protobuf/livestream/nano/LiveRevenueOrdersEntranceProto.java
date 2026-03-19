package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveRevenueOrdersEntranceProto {

    public static final class LiveRevenueOrdersEntrance extends MessageNano {
        private static volatile LiveRevenueOrdersEntrance[] _emptyArray;
        public boolean canShow;
        public long serverTime;
        public LiveRevenueOrdersEntranceTkConfig tkConfig;

        public static LiveRevenueOrdersEntrance[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueOrdersEntrance[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueOrdersEntrance() {
            clear();
        }

        public final LiveRevenueOrdersEntrance clear() {
            this.canShow = false;
            this.serverTime = 0L;
            this.tkConfig = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.canShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            long j = this.serverTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            LiveRevenueOrdersEntranceTkConfig liveRevenueOrdersEntranceTkConfig = this.tkConfig;
            if (liveRevenueOrdersEntranceTkConfig != null) {
                codedOutputByteBufferNano.writeMessage(3, liveRevenueOrdersEntranceTkConfig);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.canShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            long j = this.serverTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            LiveRevenueOrdersEntranceTkConfig liveRevenueOrdersEntranceTkConfig = this.tkConfig;
            return liveRevenueOrdersEntranceTkConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, liveRevenueOrdersEntranceTkConfig) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueOrdersEntrance mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.canShow = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.tkConfig == null) {
                        this.tkConfig = new LiveRevenueOrdersEntranceTkConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.tkConfig);
                }
            }
        }

        public static LiveRevenueOrdersEntrance parseFrom(byte[] bArr) {
            return (LiveRevenueOrdersEntrance) MessageNano.mergeFrom(new LiveRevenueOrdersEntrance(), bArr);
        }

        public static LiveRevenueOrdersEntrance parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueOrdersEntrance().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveRevenueOrdersEntranceTkConfig extends MessageNano {
        private static volatile LiveRevenueOrdersEntranceTkConfig[] _emptyArray;
        public String bizData;
        public String bizId;
        public String bundleId;
        public int minBundleVer;
        public String viewKey;

        public static LiveRevenueOrdersEntranceTkConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveRevenueOrdersEntranceTkConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveRevenueOrdersEntranceTkConfig() {
            clear();
        }

        public final LiveRevenueOrdersEntranceTkConfig clear() {
            this.viewKey = "";
            this.bundleId = "";
            this.minBundleVer = 0;
            this.bizData = "";
            this.bizId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.viewKey.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.viewKey);
            }
            if (!this.bundleId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bundleId);
            }
            int i = this.minBundleVer;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            if (!this.bizData.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.bizData);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bizId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.viewKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.viewKey);
            }
            if (!this.bundleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bundleId);
            }
            int i = this.minBundleVer;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            if (!this.bizData.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bizData);
            }
            return !this.bizId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.bizId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveRevenueOrdersEntranceTkConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.viewKey = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.bundleId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.minBundleVer = codedInputByteBufferNano.readUInt32();
                } else if (tag == 34) {
                    this.bizData = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bizId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveRevenueOrdersEntranceTkConfig parseFrom(byte[] bArr) {
            return (LiveRevenueOrdersEntranceTkConfig) MessageNano.mergeFrom(new LiveRevenueOrdersEntranceTkConfig(), bArr);
        }

        public static LiveRevenueOrdersEntranceTkConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveRevenueOrdersEntranceTkConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
