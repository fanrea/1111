package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveConditionAudienceRedPackUpdate extends MessageNano {
    private static volatile SCLiveConditionAudienceRedPackUpdate[] _emptyArray;
    public LiveConditionAudienceRedPackUpdateInfo[] audienceRedPackUpdateInfo;

    public static SCLiveConditionAudienceRedPackUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveConditionAudienceRedPackUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveConditionAudienceRedPackUpdate() {
        clear();
    }

    public final SCLiveConditionAudienceRedPackUpdate clear() {
        this.audienceRedPackUpdateInfo = LiveConditionAudienceRedPackUpdateInfo.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveConditionAudienceRedPackUpdateInfo[] liveConditionAudienceRedPackUpdateInfoArr = this.audienceRedPackUpdateInfo;
        if (liveConditionAudienceRedPackUpdateInfoArr != null && liveConditionAudienceRedPackUpdateInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveConditionAudienceRedPackUpdateInfo[] liveConditionAudienceRedPackUpdateInfoArr2 = this.audienceRedPackUpdateInfo;
                if (i >= liveConditionAudienceRedPackUpdateInfoArr2.length) {
                    break;
                }
                LiveConditionAudienceRedPackUpdateInfo liveConditionAudienceRedPackUpdateInfo = liveConditionAudienceRedPackUpdateInfoArr2[i];
                if (liveConditionAudienceRedPackUpdateInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveConditionAudienceRedPackUpdateInfo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveConditionAudienceRedPackUpdateInfo[] liveConditionAudienceRedPackUpdateInfoArr = this.audienceRedPackUpdateInfo;
        if (liveConditionAudienceRedPackUpdateInfoArr != null && liveConditionAudienceRedPackUpdateInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveConditionAudienceRedPackUpdateInfo[] liveConditionAudienceRedPackUpdateInfoArr2 = this.audienceRedPackUpdateInfo;
                if (i >= liveConditionAudienceRedPackUpdateInfoArr2.length) {
                    break;
                }
                LiveConditionAudienceRedPackUpdateInfo liveConditionAudienceRedPackUpdateInfo = liveConditionAudienceRedPackUpdateInfoArr2[i];
                if (liveConditionAudienceRedPackUpdateInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveConditionAudienceRedPackUpdateInfo);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveConditionAudienceRedPackUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LiveConditionAudienceRedPackUpdateInfo[] liveConditionAudienceRedPackUpdateInfoArr = this.audienceRedPackUpdateInfo;
                int length = liveConditionAudienceRedPackUpdateInfoArr == null ? 0 : liveConditionAudienceRedPackUpdateInfoArr.length;
                LiveConditionAudienceRedPackUpdateInfo[] liveConditionAudienceRedPackUpdateInfoArr2 = new LiveConditionAudienceRedPackUpdateInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.audienceRedPackUpdateInfo, 0, liveConditionAudienceRedPackUpdateInfoArr2, 0, length);
                }
                while (length < liveConditionAudienceRedPackUpdateInfoArr2.length - 1) {
                    liveConditionAudienceRedPackUpdateInfoArr2[length] = new LiveConditionAudienceRedPackUpdateInfo();
                    codedInputByteBufferNano.readMessage(liveConditionAudienceRedPackUpdateInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveConditionAudienceRedPackUpdateInfoArr2[length] = new LiveConditionAudienceRedPackUpdateInfo();
                codedInputByteBufferNano.readMessage(liveConditionAudienceRedPackUpdateInfoArr2[length]);
                this.audienceRedPackUpdateInfo = liveConditionAudienceRedPackUpdateInfoArr2;
            }
        }
    }

    public static SCLiveConditionAudienceRedPackUpdate parseFrom(byte[] bArr) {
        return (SCLiveConditionAudienceRedPackUpdate) MessageNano.mergeFrom(new SCLiveConditionAudienceRedPackUpdate(), bArr);
    }

    public static SCLiveConditionAudienceRedPackUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveConditionAudienceRedPackUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
