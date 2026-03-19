package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRevenueActivityInfoShakeActivity extends MessageNano {
    private static volatile SCLiveRevenueActivityInfoShakeActivity[] _emptyArray;
    public String activityId;
    public boolean enable;
    public SCLiveRevenueActivityInfoShakeActivityConfig shakeActivityConfig;
    public long shakeMinIntervalMs;

    public static SCLiveRevenueActivityInfoShakeActivity[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRevenueActivityInfoShakeActivity[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRevenueActivityInfoShakeActivity() {
        clear();
    }

    public final SCLiveRevenueActivityInfoShakeActivity clear() {
        this.activityId = "";
        this.enable = false;
        this.shakeMinIntervalMs = 0L;
        this.shakeActivityConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.activityId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.activityId);
        }
        boolean z = this.enable;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        long j = this.shakeMinIntervalMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        SCLiveRevenueActivityInfoShakeActivityConfig sCLiveRevenueActivityInfoShakeActivityConfig = this.shakeActivityConfig;
        if (sCLiveRevenueActivityInfoShakeActivityConfig != null) {
            codedOutputByteBufferNano.writeMessage(4, sCLiveRevenueActivityInfoShakeActivityConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.activityId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.activityId);
        }
        boolean z = this.enable;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        long j = this.shakeMinIntervalMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        SCLiveRevenueActivityInfoShakeActivityConfig sCLiveRevenueActivityInfoShakeActivityConfig = this.shakeActivityConfig;
        return sCLiveRevenueActivityInfoShakeActivityConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, sCLiveRevenueActivityInfoShakeActivityConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRevenueActivityInfoShakeActivity mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.activityId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.enable = codedInputByteBufferNano.readBool();
            } else if (tag == 24) {
                this.shakeMinIntervalMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.shakeActivityConfig == null) {
                    this.shakeActivityConfig = new SCLiveRevenueActivityInfoShakeActivityConfig();
                }
                codedInputByteBufferNano.readMessage(this.shakeActivityConfig);
            }
        }
    }

    public static SCLiveRevenueActivityInfoShakeActivity parseFrom(byte[] bArr) {
        return (SCLiveRevenueActivityInfoShakeActivity) MessageNano.mergeFrom(new SCLiveRevenueActivityInfoShakeActivity(), bArr);
    }

    public static SCLiveRevenueActivityInfoShakeActivity parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRevenueActivityInfoShakeActivity().mergeFrom(codedInputByteBufferNano);
    }
}
