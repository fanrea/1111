package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveModuleShieldConfigSignal extends MessageNano {
    private static volatile SCLiveModuleShieldConfigSignal[] _emptyArray;
    public LiveOperationModuleConfig[] shieldModuleConfig;

    public static SCLiveModuleShieldConfigSignal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveModuleShieldConfigSignal[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveModuleShieldConfigSignal() {
        clear();
    }

    public final SCLiveModuleShieldConfigSignal clear() {
        this.shieldModuleConfig = LiveOperationModuleConfig.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveOperationModuleConfig[] liveOperationModuleConfigArr = this.shieldModuleConfig;
        if (liveOperationModuleConfigArr != null && liveOperationModuleConfigArr.length > 0) {
            int i = 0;
            while (true) {
                LiveOperationModuleConfig[] liveOperationModuleConfigArr2 = this.shieldModuleConfig;
                if (i >= liveOperationModuleConfigArr2.length) {
                    break;
                }
                LiveOperationModuleConfig liveOperationModuleConfig = liveOperationModuleConfigArr2[i];
                if (liveOperationModuleConfig != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveOperationModuleConfig);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveOperationModuleConfig[] liveOperationModuleConfigArr = this.shieldModuleConfig;
        if (liveOperationModuleConfigArr != null && liveOperationModuleConfigArr.length > 0) {
            int i = 0;
            while (true) {
                LiveOperationModuleConfig[] liveOperationModuleConfigArr2 = this.shieldModuleConfig;
                if (i >= liveOperationModuleConfigArr2.length) {
                    break;
                }
                LiveOperationModuleConfig liveOperationModuleConfig = liveOperationModuleConfigArr2[i];
                if (liveOperationModuleConfig != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveOperationModuleConfig);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveModuleShieldConfigSignal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveOperationModuleConfig[] liveOperationModuleConfigArr = this.shieldModuleConfig;
                int length = liveOperationModuleConfigArr == null ? 0 : liveOperationModuleConfigArr.length;
                LiveOperationModuleConfig[] liveOperationModuleConfigArr2 = new LiveOperationModuleConfig[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.shieldModuleConfig, 0, liveOperationModuleConfigArr2, 0, length);
                }
                while (length < liveOperationModuleConfigArr2.length - 1) {
                    liveOperationModuleConfigArr2[length] = new LiveOperationModuleConfig();
                    codedInputByteBufferNano.readMessage(liveOperationModuleConfigArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveOperationModuleConfigArr2[length] = new LiveOperationModuleConfig();
                codedInputByteBufferNano.readMessage(liveOperationModuleConfigArr2[length]);
                this.shieldModuleConfig = liveOperationModuleConfigArr2;
            }
        }
    }

    public static SCLiveModuleShieldConfigSignal parseFrom(byte[] bArr) {
        return (SCLiveModuleShieldConfigSignal) MessageNano.mergeFrom(new SCLiveModuleShieldConfigSignal(), bArr);
    }

    public static SCLiveModuleShieldConfigSignal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveModuleShieldConfigSignal().mergeFrom(codedInputByteBufferNano);
    }
}
