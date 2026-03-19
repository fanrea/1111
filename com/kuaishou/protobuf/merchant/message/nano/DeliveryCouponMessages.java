package com.kuaishou.protobuf.merchant.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface DeliveryCouponMessages {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CloseDeliveryCouponType {
        public static final int AUTHOR_CLOSE = 1;
        public static final int CLOSE_DELIVERY_TYPE_UNKNOWN = 0;
        public static final int RECEIVE_END = 2;
    }

    public static final class CurrentLiveDeliveryCouponStateSignal extends MessageNano {
        private static volatile CurrentLiveDeliveryCouponStateSignal[] _emptyArray;
        public DeliveryCouponInfo[] deliveryCouponInfo;
        public boolean needClientCheckReceive;
        public long signalTime;

        public static CurrentLiveDeliveryCouponStateSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CurrentLiveDeliveryCouponStateSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CurrentLiveDeliveryCouponStateSignal() {
            clear();
        }

        public final CurrentLiveDeliveryCouponStateSignal clear() {
            this.deliveryCouponInfo = DeliveryCouponInfo.emptyArray();
            this.needClientCheckReceive = false;
            this.signalTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            DeliveryCouponInfo[] deliveryCouponInfoArr = this.deliveryCouponInfo;
            if (deliveryCouponInfoArr != null && deliveryCouponInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    DeliveryCouponInfo[] deliveryCouponInfoArr2 = this.deliveryCouponInfo;
                    if (i >= deliveryCouponInfoArr2.length) {
                        break;
                    }
                    DeliveryCouponInfo deliveryCouponInfo = deliveryCouponInfoArr2[i];
                    if (deliveryCouponInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, deliveryCouponInfo);
                    }
                    i++;
                }
            }
            boolean z = this.needClientCheckReceive;
            if (z) {
                codedOutputByteBufferNano.writeBool(2, z);
            }
            long j = this.signalTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(3, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            DeliveryCouponInfo[] deliveryCouponInfoArr = this.deliveryCouponInfo;
            if (deliveryCouponInfoArr != null && deliveryCouponInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    DeliveryCouponInfo[] deliveryCouponInfoArr2 = this.deliveryCouponInfo;
                    if (i >= deliveryCouponInfoArr2.length) {
                        break;
                    }
                    DeliveryCouponInfo deliveryCouponInfo = deliveryCouponInfoArr2[i];
                    if (deliveryCouponInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, deliveryCouponInfo);
                    }
                    i++;
                }
            }
            boolean z = this.needClientCheckReceive;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
            }
            long j = this.signalTime;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(3, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CurrentLiveDeliveryCouponStateSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    DeliveryCouponInfo[] deliveryCouponInfoArr = this.deliveryCouponInfo;
                    int length = deliveryCouponInfoArr == null ? 0 : deliveryCouponInfoArr.length;
                    DeliveryCouponInfo[] deliveryCouponInfoArr2 = new DeliveryCouponInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.deliveryCouponInfo, 0, deliveryCouponInfoArr2, 0, length);
                    }
                    while (length < deliveryCouponInfoArr2.length - 1) {
                        deliveryCouponInfoArr2[length] = new DeliveryCouponInfo();
                        codedInputByteBufferNano.readMessage(deliveryCouponInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    deliveryCouponInfoArr2[length] = new DeliveryCouponInfo();
                    codedInputByteBufferNano.readMessage(deliveryCouponInfoArr2[length]);
                    this.deliveryCouponInfo = deliveryCouponInfoArr2;
                } else if (tag == 16) {
                    this.needClientCheckReceive = codedInputByteBufferNano.readBool();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.signalTime = codedInputByteBufferNano.readInt64();
                }
            }
        }

        public static CurrentLiveDeliveryCouponStateSignal parseFrom(byte[] bArr) {
            return (CurrentLiveDeliveryCouponStateSignal) MessageNano.mergeFrom(new CurrentLiveDeliveryCouponStateSignal(), bArr);
        }

        public static CurrentLiveDeliveryCouponStateSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CurrentLiveDeliveryCouponStateSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DeliveryCouponInfo extends MessageNano {
        private static volatile DeliveryCouponInfo[] _emptyArray;
        public CouponInfo couponInfo;
        public String deliveryId;
        public long endTime;
        public long startTime;

        public static DeliveryCouponInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeliveryCouponInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DeliveryCouponInfo() {
            clear();
        }

        public final DeliveryCouponInfo clear() {
            this.deliveryId = "";
            this.startTime = 0L;
            this.endTime = 0L;
            this.couponInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.deliveryId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.deliveryId);
            }
            long j = this.startTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(2, j);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeInt64(3, j2);
            }
            CouponInfo couponInfo = this.couponInfo;
            if (couponInfo != null) {
                codedOutputByteBufferNano.writeMessage(5, couponInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.deliveryId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.deliveryId);
            }
            long j = this.startTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
            }
            long j2 = this.endTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j2);
            }
            CouponInfo couponInfo = this.couponInfo;
            return couponInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, couponInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final DeliveryCouponInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.deliveryId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.startTime = codedInputByteBufferNano.readInt64();
                } else if (tag == 24) {
                    this.endTime = codedInputByteBufferNano.readInt64();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.couponInfo == null) {
                        this.couponInfo = new CouponInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.couponInfo);
                }
            }
        }

        public static DeliveryCouponInfo parseFrom(byte[] bArr) {
            return (DeliveryCouponInfo) MessageNano.mergeFrom(new DeliveryCouponInfo(), bArr);
        }

        public static DeliveryCouponInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DeliveryCouponInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CloseDeliveryCouponActionSignal extends MessageNano {
        private static volatile CloseDeliveryCouponActionSignal[] _emptyArray;
        public String deliveryId;
        public int deliveryType;

        public static CloseDeliveryCouponActionSignal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CloseDeliveryCouponActionSignal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CloseDeliveryCouponActionSignal() {
            clear();
        }

        public final CloseDeliveryCouponActionSignal clear() {
            this.deliveryId = "";
            this.deliveryType = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.deliveryId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.deliveryId);
            }
            int i = this.deliveryType;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.deliveryId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.deliveryId);
            }
            int i = this.deliveryType;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(2, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CloseDeliveryCouponActionSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.deliveryId = codedInputByteBufferNano.readString();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.deliveryType = int32;
                    }
                }
            }
        }

        public static CloseDeliveryCouponActionSignal parseFrom(byte[] bArr) {
            return (CloseDeliveryCouponActionSignal) MessageNano.mergeFrom(new CloseDeliveryCouponActionSignal(), bArr);
        }

        public static CloseDeliveryCouponActionSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CloseDeliveryCouponActionSignal().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CouponInfo extends MessageNano {
        private static volatile CouponInfo[] _emptyArray;
        public String couponName;
        public String couponPrice;
        public String deliveryNum;
        public String extraMap;
        public boolean isFollowReceive;
        public String notAllowedTip;
        public String receiveConditionTitle;
        public int sc;
        public int[] si;
        public String useConditionTitle;
        public String useRangeTitle;
        public String validPeriod;

        public static CouponInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CouponInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CouponInfo() {
            clear();
        }

        public final CouponInfo clear() {
            this.couponName = "";
            this.couponPrice = "";
            this.useConditionTitle = "";
            this.useRangeTitle = "";
            this.validPeriod = "";
            this.deliveryNum = "";
            this.receiveConditionTitle = "";
            this.isFollowReceive = false;
            this.notAllowedTip = "";
            this.sc = 0;
            this.si = WireFormatNano.EMPTY_INT_ARRAY;
            this.extraMap = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.couponName.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.couponName);
            }
            if (!this.couponPrice.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.couponPrice);
            }
            if (!this.useConditionTitle.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.useConditionTitle);
            }
            if (!this.useRangeTitle.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.useRangeTitle);
            }
            if (!this.validPeriod.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.validPeriod);
            }
            if (!this.deliveryNum.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.deliveryNum);
            }
            if (!this.receiveConditionTitle.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.receiveConditionTitle);
            }
            boolean z = this.isFollowReceive;
            if (z) {
                codedOutputByteBufferNano.writeBool(8, z);
            }
            if (!this.notAllowedTip.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.notAllowedTip);
            }
            int i = this.sc;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(10, i);
            }
            int[] iArr = this.si;
            if (iArr != null && iArr.length > 0) {
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.si;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(11, iArr2[i2]);
                    i2++;
                }
            }
            if (!this.extraMap.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.extraMap);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int[] iArr;
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.couponName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.couponName);
            }
            if (!this.couponPrice.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.couponPrice);
            }
            if (!this.useConditionTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.useConditionTitle);
            }
            if (!this.useRangeTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.useRangeTitle);
            }
            if (!this.validPeriod.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.validPeriod);
            }
            if (!this.deliveryNum.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.deliveryNum);
            }
            if (!this.receiveConditionTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.receiveConditionTitle);
            }
            boolean z = this.isFollowReceive;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(8, z);
            }
            if (!this.notAllowedTip.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.notAllowedTip);
            }
            int i = this.sc;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i);
            }
            int[] iArr2 = this.si;
            if (iArr2 != null && iArr2.length > 0) {
                int i2 = 0;
                int iComputeInt32SizeNoTag = 0;
                while (true) {
                    iArr = this.si;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr[i2]);
                    i2++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr.length * 1);
            }
            return !this.extraMap.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.extraMap) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CouponInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.couponName = codedInputByteBufferNano.readString();
                        break;
                    case 18:
                        this.couponPrice = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.useConditionTitle = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.useRangeTitle = codedInputByteBufferNano.readString();
                        break;
                    case 42:
                        this.validPeriod = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.deliveryNum = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.receiveConditionTitle = codedInputByteBufferNano.readString();
                        break;
                    case 64:
                        this.isFollowReceive = codedInputByteBufferNano.readBool();
                        break;
                    case 74:
                        this.notAllowedTip = codedInputByteBufferNano.readString();
                        break;
                    case 80:
                        this.sc = codedInputByteBufferNano.readInt32();
                        break;
                    case 88:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 88);
                        int[] iArr = this.si;
                        int length = iArr == null ? 0 : iArr.length;
                        int[] iArr2 = new int[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.si, 0, iArr2, 0, length);
                        }
                        while (length < iArr2.length - 1) {
                            iArr2[length] = codedInputByteBufferNano.readInt32();
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        iArr2[length] = codedInputByteBufferNano.readInt32();
                        this.si = iArr2;
                        break;
                    case 90:
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            codedInputByteBufferNano.readInt32();
                            i++;
                        }
                        codedInputByteBufferNano.rewindToPosition(position);
                        int[] iArr3 = this.si;
                        int length2 = iArr3 == null ? 0 : iArr3.length;
                        int[] iArr4 = new int[i + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.si, 0, iArr4, 0, length2);
                        }
                        while (length2 < iArr4.length) {
                            iArr4[length2] = codedInputByteBufferNano.readInt32();
                            length2++;
                        }
                        this.si = iArr4;
                        codedInputByteBufferNano.popLimit(iPushLimit);
                        break;
                    case 98:
                        this.extraMap = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static CouponInfo parseFrom(byte[] bArr) {
            return (CouponInfo) MessageNano.mergeFrom(new CouponInfo(), bArr);
        }

        public static CouponInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CouponInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
