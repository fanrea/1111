package com.kuaishou.protobuf.merchant.message.nano;

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
public interface LiveRoomPushCouponMessage {

    public static final class PushCouponInfo extends MessageNano {
        private static volatile PushCouponInfo[] _emptyArray;
        public long activitySessionEndTime;
        public String activitySessionId;
        public long activitySessionStartTime;
        public int activityType;
        public int channelType;
        public String couponDisplayTitle;
        public String couponId;
        public long couponPrice;
        public long expireTime;
        public Map<String, String> extraMap;
        public String jumpUrl;
        public int status;
        public int type;
        public String useConditionTitle;
        public String useRangeTitle;

        public static PushCouponInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PushCouponInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PushCouponInfo() {
            clear();
        }

        public final PushCouponInfo clear() {
            this.activitySessionId = "";
            this.couponId = "";
            this.couponDisplayTitle = "";
            this.couponPrice = 0L;
            this.useConditionTitle = "";
            this.useRangeTitle = "";
            this.expireTime = 0L;
            this.type = 0;
            this.status = 0;
            this.jumpUrl = "";
            this.activityType = 0;
            this.channelType = 0;
            this.activitySessionStartTime = 0L;
            this.activitySessionEndTime = 0L;
            this.extraMap = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
            if (!this.activitySessionId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.activitySessionId);
            }
            if (!this.couponId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.couponId);
            }
            if (!this.couponDisplayTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.couponDisplayTitle);
            }
            long j = this.couponPrice;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (!this.useConditionTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.useConditionTitle);
            }
            if (!this.useRangeTitle.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.useRangeTitle);
            }
            long j2 = this.expireTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j2);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(8, i);
            }
            int i2 = this.status;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(9, i2);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.jumpUrl);
            }
            int i3 = this.activityType;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(11, i3);
            }
            int i4 = this.channelType;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(12, i4);
            }
            long j3 = this.activitySessionStartTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(13, j3);
            }
            long j4 = this.activitySessionEndTime;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(14, j4);
            }
            Map<String, String> map = this.extraMap;
            if (map != null) {
                InternalNano.serializeMapField(codedOutputByteBufferNano, map, 15, 9, 9);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.activitySessionId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activitySessionId);
            }
            if (!this.couponId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.couponId);
            }
            if (!this.couponDisplayTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.couponDisplayTitle);
            }
            long j = this.couponPrice;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (!this.useConditionTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.useConditionTitle);
            }
            if (!this.useRangeTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.useRangeTitle);
            }
            long j2 = this.expireTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j2);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i);
            }
            int i2 = this.status;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i2);
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.jumpUrl);
            }
            int i3 = this.activityType;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i3);
            }
            int i4 = this.channelType;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i4);
            }
            long j3 = this.activitySessionStartTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(13, j3);
            }
            long j4 = this.activitySessionEndTime;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(14, j4);
            }
            Map<String, String> map = this.extraMap;
            return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 15, 9, 9) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final PushCouponInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.activitySessionId = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.couponId = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.couponDisplayTitle = codedInputByteBufferNano.readString();
                        break;
                    case 32:
                        this.couponPrice = codedInputByteBufferNano.readUInt64();
                        break;
                    case 42:
                        this.useConditionTitle = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.useRangeTitle = codedInputByteBufferNano.readString();
                        break;
                    case 56:
                        this.expireTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 64:
                        this.type = codedInputByteBufferNano.readUInt32();
                        break;
                    case 72:
                        this.status = codedInputByteBufferNano.readUInt32();
                        break;
                    case 82:
                        this.jumpUrl = codedInputByteBufferNano.readString();
                        break;
                    case 88:
                        this.activityType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 96:
                        this.channelType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 104:
                        this.activitySessionStartTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 112:
                        this.activitySessionEndTime = codedInputByteBufferNano.readUInt64();
                        break;
                    case 122:
                        this.extraMap = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.extraMap, mapFactory, 9, 9, null, 10, 18);
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static PushCouponInfo parseFrom(byte[] bArr) {
            return (PushCouponInfo) MessageNano.mergeFrom(new PushCouponInfo(), bArr);
        }

        public static PushCouponInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new PushCouponInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLivePushCoupon extends MessageNano {
        private static volatile SCKwaishopLivePushCoupon[] _emptyArray;
        public PushCouponInfo couponInfo;
        public int sceneType;

        public static SCKwaishopLivePushCoupon[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLivePushCoupon[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLivePushCoupon() {
            clear();
        }

        public final SCKwaishopLivePushCoupon clear() {
            this.sceneType = 0;
            this.couponInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.sceneType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(1, i);
            }
            PushCouponInfo pushCouponInfo = this.couponInfo;
            if (pushCouponInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, pushCouponInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.sceneType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
            }
            PushCouponInfo pushCouponInfo = this.couponInfo;
            return pushCouponInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, pushCouponInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLivePushCoupon mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.sceneType = codedInputByteBufferNano.readInt32();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.couponInfo == null) {
                        this.couponInfo = new PushCouponInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.couponInfo);
                }
            }
        }

        public static SCKwaishopLivePushCoupon parseFrom(byte[] bArr) {
            return (SCKwaishopLivePushCoupon) MessageNano.mergeFrom(new SCKwaishopLivePushCoupon(), bArr);
        }

        public static SCKwaishopLivePushCoupon parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLivePushCoupon().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCKwaishopLiveSkyFallPendantDestroy extends MessageNano {
        private static volatile SCKwaishopLiveSkyFallPendantDestroy[] _emptyArray;
        public String buyerCouponId;

        public static SCKwaishopLiveSkyFallPendantDestroy[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCKwaishopLiveSkyFallPendantDestroy[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCKwaishopLiveSkyFallPendantDestroy() {
            clear();
        }

        public final SCKwaishopLiveSkyFallPendantDestroy clear() {
            this.buyerCouponId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.buyerCouponId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.buyerCouponId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.buyerCouponId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.buyerCouponId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCKwaishopLiveSkyFallPendantDestroy mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.buyerCouponId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCKwaishopLiveSkyFallPendantDestroy parseFrom(byte[] bArr) {
            return (SCKwaishopLiveSkyFallPendantDestroy) MessageNano.mergeFrom(new SCKwaishopLiveSkyFallPendantDestroy(), bArr);
        }

        public static SCKwaishopLiveSkyFallPendantDestroy parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCKwaishopLiveSkyFallPendantDestroy().mergeFrom(codedInputByteBufferNano);
        }
    }
}
