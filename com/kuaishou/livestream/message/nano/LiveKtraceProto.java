package com.kuaishou.livestream.message.nano;

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
public interface LiveKtraceProto {

    public static final class AppKTraceContextCarrier extends MessageNano {
        private static volatile AppKTraceContextCarrier[] _emptyArray;
        public Map<String, String> baggageItems;
        public String bizName;
        public AppKTraceId primaryTraceId;
        public boolean sampled;
        public AppKTraceId segmentId;
        public String serviceName;
        public int spanId;
        public AppKTraceUpstreamInfo upstreamInfo;
        public int version;

        public static AppKTraceContextCarrier[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppKTraceContextCarrier[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AppKTraceContextCarrier() {
            clear();
        }

        public final AppKTraceContextCarrier clear() {
            this.version = 0;
            this.primaryTraceId = null;
            this.segmentId = null;
            this.spanId = 0;
            this.serviceName = "";
            this.bizName = "";
            this.sampled = false;
            this.baggageItems = null;
            this.upstreamInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            int i = this.version;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            AppKTraceId appKTraceId = this.primaryTraceId;
            if (appKTraceId != null) {
                codedOutputByteBufferNano.writeMessage(2, appKTraceId);
            }
            AppKTraceId appKTraceId2 = this.segmentId;
            if (appKTraceId2 != null) {
                codedOutputByteBufferNano.writeMessage(3, appKTraceId2);
            }
            int i2 = this.spanId;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i2);
            }
            if (!this.serviceName.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.serviceName);
            }
            if (!this.bizName.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.bizName);
            }
            boolean z = this.sampled;
            if (z) {
                codedOutputByteBufferNano.writeBool(7, z);
            }
            Map<String, String> map = this.baggageItems;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 8, 9, 9);
            }
            AppKTraceUpstreamInfo appKTraceUpstreamInfo = this.upstreamInfo;
            if (appKTraceUpstreamInfo != null) {
                codedOutputByteBufferNano.writeMessage(9, appKTraceUpstreamInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.version;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            AppKTraceId appKTraceId = this.primaryTraceId;
            if (appKTraceId != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, appKTraceId);
            }
            AppKTraceId appKTraceId2 = this.segmentId;
            if (appKTraceId2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, appKTraceId2);
            }
            int i2 = this.spanId;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i2);
            }
            if (!this.serviceName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.serviceName);
            }
            if (!this.bizName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.bizName);
            }
            boolean z = this.sampled;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z);
            }
            Map<String, String> map = this.baggageItems;
            if (map != null) {
                iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 8, 9, 9);
            }
            AppKTraceUpstreamInfo appKTraceUpstreamInfo = this.upstreamInfo;
            return appKTraceUpstreamInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(9, appKTraceUpstreamInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AppKTraceContextCarrier mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.version = codedInputByteBufferNano.readUInt32();
                } else if (tag == 18) {
                    if (this.primaryTraceId == null) {
                        this.primaryTraceId = new AppKTraceId();
                    }
                    codedInputByteBufferNano.readMessage(this.primaryTraceId);
                } else if (tag == 26) {
                    if (this.segmentId == null) {
                        this.segmentId = new AppKTraceId();
                    }
                    codedInputByteBufferNano.readMessage(this.segmentId);
                } else if (tag == 32) {
                    this.spanId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 42) {
                    this.serviceName = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.bizName = codedInputByteBufferNano.readString();
                } else if (tag == 56) {
                    this.sampled = codedInputByteBufferNano.readBool();
                } else if (tag == 66) {
                    this.baggageItems = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.baggageItems, mapFactory, 9, 9, null, 10, 18);
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.upstreamInfo == null) {
                        this.upstreamInfo = new AppKTraceUpstreamInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.upstreamInfo);
                }
            }
        }

        public static AppKTraceContextCarrier parseFrom(byte[] bArr) {
            return (AppKTraceContextCarrier) MessageNano.mergeFrom(new AppKTraceContextCarrier(), bArr);
        }

        public static AppKTraceContextCarrier parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AppKTraceContextCarrier().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AppKTraceId extends MessageNano {
        private static volatile AppKTraceId[] _emptyArray;
        public int counter;
        public long serviceInstanceId;
        public int threadId;
        public long timestamp;
        public int version;

        public static AppKTraceId[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppKTraceId[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AppKTraceId() {
            clear();
        }

        public final AppKTraceId clear() {
            this.version = 0;
            this.serviceInstanceId = 0L;
            this.threadId = 0;
            this.timestamp = 0L;
            this.counter = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.version;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.serviceInstanceId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            int i2 = this.threadId;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i2);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            int i3 = this.counter;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(5, i3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.version;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.serviceInstanceId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            int i2 = this.threadId;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            int i3 = this.counter;
            return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(5, i3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AppKTraceId mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.version = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.serviceInstanceId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.threadId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.counter = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static AppKTraceId parseFrom(byte[] bArr) {
            return (AppKTraceId) MessageNano.mergeFrom(new AppKTraceId(), bArr);
        }

        public static AppKTraceId parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AppKTraceId().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AppKTraceUpstreamInfo extends MessageNano {
        private static volatile AppKTraceUpstreamInfo[] _emptyArray;
        public String hostname;
        public String ipString;
        public AppKTraceModelPb kws;

        public static AppKTraceUpstreamInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppKTraceUpstreamInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AppKTraceUpstreamInfo() {
            clear();
        }

        public final AppKTraceUpstreamInfo clear() {
            this.hostname = "";
            this.ipString = "";
            this.kws = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.hostname.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.hostname);
            }
            if (!this.ipString.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.ipString);
            }
            AppKTraceModelPb appKTraceModelPb = this.kws;
            if (appKTraceModelPb != null) {
                codedOutputByteBufferNano.writeMessage(3, appKTraceModelPb);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.hostname.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.hostname);
            }
            if (!this.ipString.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.ipString);
            }
            AppKTraceModelPb appKTraceModelPb = this.kws;
            return appKTraceModelPb != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, appKTraceModelPb) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AppKTraceUpstreamInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.hostname = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.ipString = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.kws == null) {
                        this.kws = new AppKTraceModelPb();
                    }
                    codedInputByteBufferNano.readMessage(this.kws);
                }
            }
        }

        public static AppKTraceUpstreamInfo parseFrom(byte[] bArr) {
            return (AppKTraceUpstreamInfo) MessageNano.mergeFrom(new AppKTraceUpstreamInfo(), bArr);
        }

        public static AppKTraceUpstreamInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AppKTraceUpstreamInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AppKTraceModelPb extends MessageNano {
        private static volatile AppKTraceModelPb[] _emptyArray;
        public String az;
        public String catalog;
        public String dc;
        public String deployType;
        public String group;
        public String laneId;
        public String productName;
        public String productVersion;
        public String region;
        public String serviceName;
        public String stage;
        public String version;

        public static AppKTraceModelPb[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppKTraceModelPb[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AppKTraceModelPb() {
            clear();
        }

        public final AppKTraceModelPb clear() {
            this.serviceName = "";
            this.stage = "";
            this.region = "";
            this.az = "";
            this.dc = "";
            this.version = "";
            this.catalog = "";
            this.deployType = "";
            this.productName = "";
            this.productVersion = "";
            this.laneId = "";
            this.group = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.serviceName.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.serviceName);
            }
            if (!this.stage.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.stage);
            }
            if (!this.region.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.region);
            }
            if (!this.az.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.az);
            }
            if (!this.dc.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.dc);
            }
            if (!this.version.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.version);
            }
            if (!this.catalog.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.catalog);
            }
            if (!this.deployType.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.deployType);
            }
            if (!this.productName.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.productName);
            }
            if (!this.productVersion.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.productVersion);
            }
            if (!this.laneId.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.laneId);
            }
            if (!this.group.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.group);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.serviceName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.serviceName);
            }
            if (!this.stage.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.stage);
            }
            if (!this.region.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.region);
            }
            if (!this.az.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.az);
            }
            if (!this.dc.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.dc);
            }
            if (!this.version.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.version);
            }
            if (!this.catalog.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.catalog);
            }
            if (!this.deployType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.deployType);
            }
            if (!this.productName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.productName);
            }
            if (!this.productVersion.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.productVersion);
            }
            if (!this.laneId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.laneId);
            }
            return !this.group.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.group) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AppKTraceModelPb mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.serviceName = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.stage = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.region = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.az = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.dc = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.version = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.catalog = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.deployType = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.productName = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.productVersion = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.laneId = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.group = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static AppKTraceModelPb parseFrom(byte[] bArr) {
            return (AppKTraceModelPb) MessageNano.mergeFrom(new AppKTraceModelPb(), bArr);
        }

        public static AppKTraceModelPb parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AppKTraceModelPb().mergeFrom(codedInputByteBufferNano);
        }
    }
}
