package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCommonTopRightTkWidgetProto {

    public static final class SCLiveCommonTopRightTkWidget extends MessageNano {
        private static volatile SCLiveCommonTopRightTkWidget[] _emptyArray;
        public boolean canShow;
        public long serverTimestamp;
        public long showDeadline;
        public TkWidgetConfig tkConfig;

        public static SCLiveCommonTopRightTkWidget[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveCommonTopRightTkWidget[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveCommonTopRightTkWidget() {
            clear();
        }

        public final SCLiveCommonTopRightTkWidget clear() {
            this.tkConfig = null;
            this.canShow = false;
            this.showDeadline = 0L;
            this.serverTimestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            TkWidgetConfig tkWidgetConfig = this.tkConfig;
            if (tkWidgetConfig != null) {
                codedOutputByteBufferNano.writeMessage(1, tkWidgetConfig);
            }
            boolean z = this.canShow;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            long j = this.showDeadline;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            long j2 = this.serverTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            TkWidgetConfig tkWidgetConfig = this.tkConfig;
            if (tkWidgetConfig != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, tkWidgetConfig);
            }
            boolean z = this.canShow;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            long j = this.showDeadline;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            long j2 = this.serverTimestamp;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveCommonTopRightTkWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.tkConfig == null) {
                        this.tkConfig = new TkWidgetConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.tkConfig);
                } else if (tag == 16) {
                    this.canShow = codedInputByteBufferNano.readBool();
                } else if (tag == 24) {
                    this.showDeadline = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.serverTimestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveCommonTopRightTkWidget parseFrom(byte[] bArr) {
            return (SCLiveCommonTopRightTkWidget) MessageNano.mergeFrom(new SCLiveCommonTopRightTkWidget(), bArr);
        }

        public static SCLiveCommonTopRightTkWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveCommonTopRightTkWidget().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class TkWidgetConfig extends MessageNano {
        private static volatile TkWidgetConfig[] _emptyArray;
        public String activityId;
        public String arrangeMode;
        public String bizId;
        public int bizPriority;
        public String bundleId;
        public String data;
        public long layoutArea;
        public long layoutOrder;
        public long minBundleVer;
        public String pendantId;
        public boolean showAnimation;
        public String viewKey;

        @Retention(RetentionPolicy.SOURCE)
        public @interface BizPriority {
            public static final int HIGH = 1;
            public static final int LOW = 0;
        }

        public static TkWidgetConfig[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TkWidgetConfig[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TkWidgetConfig() {
            clear();
        }

        public final TkWidgetConfig clear() {
            this.activityId = "";
            this.arrangeMode = "";
            this.bizId = "";
            this.bizPriority = 0;
            this.bundleId = "";
            this.data = "";
            this.layoutArea = 0L;
            this.layoutOrder = 0L;
            this.minBundleVer = 0L;
            this.viewKey = "";
            this.pendantId = "";
            this.showAnimation = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.activityId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.activityId);
            }
            if (!this.arrangeMode.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.arrangeMode);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.bizId);
            }
            int i = this.bizPriority;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(4, i);
            }
            if (!this.bundleId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bundleId);
            }
            if (!this.data.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.data);
            }
            long j = this.layoutArea;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j);
            }
            long j2 = this.layoutOrder;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(8, j2);
            }
            long j3 = this.minBundleVer;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j3);
            }
            if (!this.viewKey.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.viewKey);
            }
            if (!this.pendantId.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.pendantId);
            }
            boolean z = this.showAnimation;
            if (z) {
                codedOutputByteBufferNano.writeBool(12, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.activityId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activityId);
            }
            if (!this.arrangeMode.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.arrangeMode);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.bizId);
            }
            int i = this.bizPriority;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
            }
            if (!this.bundleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.bundleId);
            }
            if (!this.data.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.data);
            }
            long j = this.layoutArea;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j);
            }
            long j2 = this.layoutOrder;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
            }
            long j3 = this.minBundleVer;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
            }
            if (!this.viewKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.viewKey);
            }
            if (!this.pendantId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.pendantId);
            }
            boolean z = this.showAnimation;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(12, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final TkWidgetConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.activityId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.arrangeMode = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.bizId = codedInputByteBufferNano.readString();
                        break;
                    case 32:
                        int int32 = codedInputByteBufferNano.readInt32();
                        if (int32 != 0 && int32 != 1) {
                            break;
                        } else {
                            this.bizPriority = int32;
                            break;
                        }
                        break;
                    case 42:
                        this.bundleId = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.data = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.layoutArea = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.layoutOrder = codedInputByteBufferNano.readUInt64();
                        break;
                    case 72:
                        this.minBundleVer = codedInputByteBufferNano.readUInt64();
                        break;
                    case 82:
                        this.viewKey = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.pendantId = codedInputByteBufferNano.readString();
                        break;
                    case 96:
                        this.showAnimation = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static TkWidgetConfig parseFrom(byte[] bArr) {
            return (TkWidgetConfig) MessageNano.mergeFrom(new TkWidgetConfig(), bArr);
        }

        public static TkWidgetConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new TkWidgetConfig().mergeFrom(codedInputByteBufferNano);
        }
    }
}
