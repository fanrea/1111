package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MissionResult extends MessageNano {
    private static volatile MissionResult[] _emptyArray;
    public LiveMultiPkMissionEasterMomentConfig easterMomentConfig;
    public int result;

    public static MissionResult[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MissionResult[0];
                }
            }
        }
        return _emptyArray;
    }

    public MissionResult() {
        clear();
    }

    public final MissionResult clear() {
        this.result = 0;
        this.easterMomentConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.result;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        LiveMultiPkMissionEasterMomentConfig liveMultiPkMissionEasterMomentConfig = this.easterMomentConfig;
        if (liveMultiPkMissionEasterMomentConfig != null) {
            codedOutputByteBufferNano.writeMessage(2, liveMultiPkMissionEasterMomentConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.result;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        LiveMultiPkMissionEasterMomentConfig liveMultiPkMissionEasterMomentConfig = this.easterMomentConfig;
        return liveMultiPkMissionEasterMomentConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, liveMultiPkMissionEasterMomentConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MissionResult mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.result = int32;
                }
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.easterMomentConfig == null) {
                    this.easterMomentConfig = new LiveMultiPkMissionEasterMomentConfig();
                }
                codedInputByteBufferNano.readMessage(this.easterMomentConfig);
            }
        }
    }

    public static MissionResult parseFrom(byte[] bArr) {
        return (MissionResult) MessageNano.mergeFrom(new MissionResult(), bArr);
    }

    public static MissionResult parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MissionResult().mergeFrom(codedInputByteBufferNano);
    }
}
