package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveStreamPlatformNotification extends MessageNano {
    private static volatile SCLiveStreamPlatformNotification[] _emptyArray;
    public int bizType;
    public UnifiedNotificationResource[] resourceList;
    public int resourceSites;
    public long userId;

    public static SCLiveStreamPlatformNotification[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveStreamPlatformNotification[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveStreamPlatformNotification() {
        clear();
    }

    public final SCLiveStreamPlatformNotification clear() {
        this.userId = 0L;
        this.bizType = 0;
        this.resourceSites = 0;
        this.resourceList = UnifiedNotificationResource.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(1, j);
        }
        int i = this.bizType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        int i2 = this.resourceSites;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        UnifiedNotificationResource[] unifiedNotificationResourceArr = this.resourceList;
        if (unifiedNotificationResourceArr != null && unifiedNotificationResourceArr.length > 0) {
            int i3 = 0;
            while (true) {
                UnifiedNotificationResource[] unifiedNotificationResourceArr2 = this.resourceList;
                if (i3 >= unifiedNotificationResourceArr2.length) {
                    break;
                }
                UnifiedNotificationResource unifiedNotificationResource = unifiedNotificationResourceArr2[i3];
                if (unifiedNotificationResource != null) {
                    codedOutputByteBufferNano.writeMessage(4, unifiedNotificationResource);
                }
                i3++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(1, j);
        }
        int i = this.bizType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        int i2 = this.resourceSites;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        UnifiedNotificationResource[] unifiedNotificationResourceArr = this.resourceList;
        if (unifiedNotificationResourceArr != null && unifiedNotificationResourceArr.length > 0) {
            int i3 = 0;
            while (true) {
                UnifiedNotificationResource[] unifiedNotificationResourceArr2 = this.resourceList;
                if (i3 >= unifiedNotificationResourceArr2.length) {
                    break;
                }
                UnifiedNotificationResource unifiedNotificationResource = unifiedNotificationResourceArr2[i3];
                if (unifiedNotificationResource != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, unifiedNotificationResource);
                }
                i3++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveStreamPlatformNotification mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.userId = codedInputByteBufferNano.readInt64();
            } else if (tag == 16) {
                this.bizType = codedInputByteBufferNano.readInt32();
            } else if (tag == 24) {
                this.resourceSites = codedInputByteBufferNano.readInt32();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UnifiedNotificationResource[] unifiedNotificationResourceArr = this.resourceList;
                int length = unifiedNotificationResourceArr == null ? 0 : unifiedNotificationResourceArr.length;
                UnifiedNotificationResource[] unifiedNotificationResourceArr2 = new UnifiedNotificationResource[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.resourceList, 0, unifiedNotificationResourceArr2, 0, length);
                }
                while (length < unifiedNotificationResourceArr2.length - 1) {
                    unifiedNotificationResourceArr2[length] = new UnifiedNotificationResource();
                    codedInputByteBufferNano.readMessage(unifiedNotificationResourceArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                unifiedNotificationResourceArr2[length] = new UnifiedNotificationResource();
                codedInputByteBufferNano.readMessage(unifiedNotificationResourceArr2[length]);
                this.resourceList = unifiedNotificationResourceArr2;
            }
        }
    }

    public static SCLiveStreamPlatformNotification parseFrom(byte[] bArr) {
        return (SCLiveStreamPlatformNotification) MessageNano.mergeFrom(new SCLiveStreamPlatformNotification(), bArr);
    }

    public static SCLiveStreamPlatformNotification parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveStreamPlatformNotification().mergeFrom(codedInputByteBufferNano);
    }
}
