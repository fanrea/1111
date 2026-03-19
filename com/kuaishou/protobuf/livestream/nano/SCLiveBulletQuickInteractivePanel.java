package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletQuickInteractivePanel extends MessageNano {
    private static volatile SCLiveBulletQuickInteractivePanel[] _emptyArray;
    public int bizPriority;
    public String bundleId;
    public String commonGuideSubBizType;
    public String componentName;
    public String data;
    public String kdsType;
    public int minBundleVersion;
    public int panelStatus;
    public int priority;
    public long timestamp;
    public boolean validInLite;
    public String viewKey;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BulletQuickInteractivePanelStatus {
        public static final int BULLET_QUICK_INTERACTIVE_PANEL_STATUS_CLOSE = 2;
        public static final int BULLET_QUICK_INTERACTIVE_PANEL_STATUS_OPEN = 1;
        public static final int BULLET_QUICK_INTERACTIVE_PANEL_STATUS_UNKNOWN = 0;
    }

    public static SCLiveBulletQuickInteractivePanel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletQuickInteractivePanel[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletQuickInteractivePanel() {
        clear();
    }

    public final SCLiveBulletQuickInteractivePanel clear() {
        this.kdsType = "";
        this.bundleId = "";
        this.viewKey = "";
        this.componentName = "";
        this.priority = 0;
        this.timestamp = 0L;
        this.commonGuideSubBizType = "";
        this.data = "";
        this.panelStatus = 0;
        this.minBundleVersion = 0;
        this.bizPriority = 0;
        this.validInLite = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.kdsType.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.kdsType);
        }
        if (!this.bundleId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.bundleId);
        }
        if (!this.viewKey.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.viewKey);
        }
        if (!this.componentName.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.componentName);
        }
        int i = this.priority;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(6, j);
        }
        if (!this.commonGuideSubBizType.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.commonGuideSubBizType);
        }
        if (!this.data.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.data);
        }
        int i2 = this.panelStatus;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i2);
        }
        int i3 = this.minBundleVersion;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(10, i3);
        }
        int i4 = this.bizPriority;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(11, i4);
        }
        boolean z = this.validInLite;
        if (z) {
            codedOutputByteBufferNano.writeBool(12, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.kdsType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.kdsType);
        }
        if (!this.bundleId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bundleId);
        }
        if (!this.viewKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.viewKey);
        }
        if (!this.componentName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.componentName);
        }
        int i = this.priority;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j);
        }
        if (!this.commonGuideSubBizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.commonGuideSubBizType);
        }
        if (!this.data.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.data);
        }
        int i2 = this.panelStatus;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i2);
        }
        int i3 = this.minBundleVersion;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(10, i3);
        }
        int i4 = this.bizPriority;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(11, i4);
        }
        boolean z = this.validInLite;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(12, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletQuickInteractivePanel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.kdsType = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.bundleId = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.viewKey = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.componentName = codedInputByteBufferNano.readString();
                    break;
                case 40:
                    this.priority = codedInputByteBufferNano.readInt32();
                    break;
                case 48:
                    this.timestamp = codedInputByteBufferNano.readInt64();
                    break;
                case 58:
                    this.commonGuideSubBizType = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.data = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.panelStatus = int32;
                        break;
                    }
                case 80:
                    this.minBundleVersion = codedInputByteBufferNano.readInt32();
                    break;
                case 88:
                    this.bizPriority = codedInputByteBufferNano.readInt32();
                    break;
                case 96:
                    this.validInLite = codedInputByteBufferNano.readBool();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveBulletQuickInteractivePanel parseFrom(byte[] bArr) {
        return (SCLiveBulletQuickInteractivePanel) MessageNano.mergeFrom(new SCLiveBulletQuickInteractivePanel(), bArr);
    }

    public static SCLiveBulletQuickInteractivePanel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletQuickInteractivePanel().mergeFrom(codedInputByteBufferNano);
    }
}
