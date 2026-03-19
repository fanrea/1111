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
public final class SCLiveToolPlayCustomisePanel extends MessageNano {
    private static volatile SCLiveToolPlayCustomisePanel[] _emptyArray;
    public String bizType;
    public String contentData;
    public long countdownTimeMs;
    public String extraInfo;
    public String interactiveAppInfo;
    public String jumpUrl;
    public int panelStatus;
    public String panelUrl;
    public int priority;
    public long scatterTimeMs;
    public long timestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveToolPlayCustomisePanelStatus {
        public static final int PANEL_STATUS_CLOSE = 2;
        public static final int PANEL_STATUS_OPEN = 1;
        public static final int PANEL_STATUS_UNKNOWN = 0;
        public static final int PANEL_STATUS_UPDATE = 3;
    }

    public static SCLiveToolPlayCustomisePanel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveToolPlayCustomisePanel[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveToolPlayCustomisePanel() {
        clear();
    }

    public final SCLiveToolPlayCustomisePanel clear() {
        this.bizType = "";
        this.priority = 0;
        this.timestamp = 0L;
        this.contentData = "";
        this.interactiveAppInfo = "";
        this.scatterTimeMs = 0L;
        this.panelUrl = "";
        this.jumpUrl = "";
        this.panelStatus = 0;
        this.countdownTimeMs = 0L;
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.bizType.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.bizType);
        }
        int i = this.priority;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(3, j);
        }
        if (!this.contentData.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.contentData);
        }
        if (!this.interactiveAppInfo.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.interactiveAppInfo);
        }
        long j2 = this.scatterTimeMs;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeInt64(6, j2);
        }
        if (!this.panelUrl.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.panelUrl);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.jumpUrl);
        }
        int i2 = this.panelStatus;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i2);
        }
        long j3 = this.countdownTimeMs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeInt64(10, j3);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.bizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.bizType);
        }
        int i = this.priority;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(3, j);
        }
        if (!this.contentData.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.contentData);
        }
        if (!this.interactiveAppInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.interactiveAppInfo);
        }
        long j2 = this.scatterTimeMs;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(6, j2);
        }
        if (!this.panelUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.panelUrl);
        }
        if (!this.jumpUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.jumpUrl);
        }
        int i2 = this.panelStatus;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i2);
        }
        long j3 = this.countdownTimeMs;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(10, j3);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveToolPlayCustomisePanel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.bizType = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    this.priority = codedInputByteBufferNano.readInt32();
                    break;
                case 24:
                    this.timestamp = codedInputByteBufferNano.readInt64();
                    break;
                case 34:
                    this.contentData = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.interactiveAppInfo = codedInputByteBufferNano.readString();
                    break;
                case 48:
                    this.scatterTimeMs = codedInputByteBufferNano.readInt64();
                    break;
                case 58:
                    this.panelUrl = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.jumpUrl = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.panelStatus = int32;
                        break;
                    }
                case 80:
                    this.countdownTimeMs = codedInputByteBufferNano.readInt64();
                    break;
                case 90:
                    this.extraInfo = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveToolPlayCustomisePanel parseFrom(byte[] bArr) {
        return (SCLiveToolPlayCustomisePanel) MessageNano.mergeFrom(new SCLiveToolPlayCustomisePanel(), bArr);
    }

    public static SCLiveToolPlayCustomisePanel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveToolPlayCustomisePanel().mergeFrom(codedInputByteBufferNano);
    }
}
