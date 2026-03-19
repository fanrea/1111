package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCCNY2023AppDegradeConfig extends MessageNano {
    private static volatile SCCNY2023AppDegradeConfig[] _emptyArray;
    public String degradeConfig;

    public static SCCNY2023AppDegradeConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCCNY2023AppDegradeConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCCNY2023AppDegradeConfig() {
        clear();
    }

    public final SCCNY2023AppDegradeConfig clear() {
        this.degradeConfig = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.degradeConfig.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.degradeConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        return !this.degradeConfig.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.degradeConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCCNY2023AppDegradeConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                this.degradeConfig = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCCNY2023AppDegradeConfig parseFrom(byte[] bArr) {
        return (SCCNY2023AppDegradeConfig) MessageNano.mergeFrom(new SCCNY2023AppDegradeConfig(), bArr);
    }

    public static SCCNY2023AppDegradeConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCCNY2023AppDegradeConfig().mergeFrom(codedInputByteBufferNano);
    }
}
