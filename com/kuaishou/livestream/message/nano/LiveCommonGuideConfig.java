package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveCommonGuideConfig extends MessageNano {
    private static volatile LiveCommonGuideConfig[] _emptyArray;
    public String belongArea;
    public String bizFrequencyKey;
    public String commonGuideBizType;
    public String commonGuideSubBizType;
    public int cooldownTimeMs;
    public boolean disableGlobalFrequency;
    public boolean enableInterrupt;
    public int priority;
    public String subBizFrequencyKey;

    public static LiveCommonGuideConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCommonGuideConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCommonGuideConfig() {
        clear();
    }

    public final LiveCommonGuideConfig clear() {
        this.commonGuideBizType = "";
        this.commonGuideSubBizType = "";
        this.priority = 0;
        this.enableInterrupt = false;
        this.subBizFrequencyKey = "";
        this.bizFrequencyKey = "";
        this.disableGlobalFrequency = false;
        this.cooldownTimeMs = 0;
        this.belongArea = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.commonGuideBizType.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.commonGuideBizType);
        }
        if (!this.commonGuideSubBizType.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.commonGuideSubBizType);
        }
        int i = this.priority;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        boolean z = this.enableInterrupt;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        if (!this.subBizFrequencyKey.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.subBizFrequencyKey);
        }
        if (!this.bizFrequencyKey.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.bizFrequencyKey);
        }
        boolean z2 = this.disableGlobalFrequency;
        if (z2) {
            codedOutputByteBufferNano.writeBool(7, z2);
        }
        int i2 = this.cooldownTimeMs;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i2);
        }
        if (!this.belongArea.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.belongArea);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.commonGuideBizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.commonGuideBizType);
        }
        if (!this.commonGuideSubBizType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.commonGuideSubBizType);
        }
        int i = this.priority;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        boolean z = this.enableInterrupt;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z);
        }
        if (!this.subBizFrequencyKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.subBizFrequencyKey);
        }
        if (!this.bizFrequencyKey.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.bizFrequencyKey);
        }
        boolean z2 = this.disableGlobalFrequency;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(7, z2);
        }
        int i2 = this.cooldownTimeMs;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i2);
        }
        return !this.belongArea.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.belongArea) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCommonGuideConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.commonGuideBizType = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.commonGuideSubBizType = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.priority = codedInputByteBufferNano.readInt32();
            } else if (tag == 32) {
                this.enableInterrupt = codedInputByteBufferNano.readBool();
            } else if (tag == 42) {
                this.subBizFrequencyKey = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                this.bizFrequencyKey = codedInputByteBufferNano.readString();
            } else if (tag == 56) {
                this.disableGlobalFrequency = codedInputByteBufferNano.readBool();
            } else if (tag == 64) {
                this.cooldownTimeMs = codedInputByteBufferNano.readInt32();
            } else if (tag != 74) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.belongArea = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveCommonGuideConfig parseFrom(byte[] bArr) {
        return (LiveCommonGuideConfig) MessageNano.mergeFrom(new LiveCommonGuideConfig(), bArr);
    }

    public static LiveCommonGuideConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCommonGuideConfig().mergeFrom(codedInputByteBufferNano);
    }
}
