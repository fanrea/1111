package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveConditionAudienceRedPackSend extends MessageNano {
    private static volatile SCLiveConditionAudienceRedPackSend[] _emptyArray;
    public LiveConditionAudienceRedPackSendInfo[] audienceRedPackSendInfo;

    public static SCLiveConditionAudienceRedPackSend[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveConditionAudienceRedPackSend[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveConditionAudienceRedPackSend() {
        clear();
    }

    public final SCLiveConditionAudienceRedPackSend clear() {
        this.audienceRedPackSendInfo = LiveConditionAudienceRedPackSendInfo.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveConditionAudienceRedPackSendInfo[] liveConditionAudienceRedPackSendInfoArr = this.audienceRedPackSendInfo;
        if (liveConditionAudienceRedPackSendInfoArr != null && liveConditionAudienceRedPackSendInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveConditionAudienceRedPackSendInfo[] liveConditionAudienceRedPackSendInfoArr2 = this.audienceRedPackSendInfo;
                if (i >= liveConditionAudienceRedPackSendInfoArr2.length) {
                    break;
                }
                LiveConditionAudienceRedPackSendInfo liveConditionAudienceRedPackSendInfo = liveConditionAudienceRedPackSendInfoArr2[i];
                if (liveConditionAudienceRedPackSendInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveConditionAudienceRedPackSendInfo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveConditionAudienceRedPackSendInfo[] liveConditionAudienceRedPackSendInfoArr = this.audienceRedPackSendInfo;
        if (liveConditionAudienceRedPackSendInfoArr != null && liveConditionAudienceRedPackSendInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveConditionAudienceRedPackSendInfo[] liveConditionAudienceRedPackSendInfoArr2 = this.audienceRedPackSendInfo;
                if (i >= liveConditionAudienceRedPackSendInfoArr2.length) {
                    break;
                }
                LiveConditionAudienceRedPackSendInfo liveConditionAudienceRedPackSendInfo = liveConditionAudienceRedPackSendInfoArr2[i];
                if (liveConditionAudienceRedPackSendInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveConditionAudienceRedPackSendInfo);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveConditionAudienceRedPackSend mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                LiveConditionAudienceRedPackSendInfo[] liveConditionAudienceRedPackSendInfoArr = this.audienceRedPackSendInfo;
                int length = liveConditionAudienceRedPackSendInfoArr == null ? 0 : liveConditionAudienceRedPackSendInfoArr.length;
                LiveConditionAudienceRedPackSendInfo[] liveConditionAudienceRedPackSendInfoArr2 = new LiveConditionAudienceRedPackSendInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.audienceRedPackSendInfo, 0, liveConditionAudienceRedPackSendInfoArr2, 0, length);
                }
                while (length < liveConditionAudienceRedPackSendInfoArr2.length - 1) {
                    liveConditionAudienceRedPackSendInfoArr2[length] = new LiveConditionAudienceRedPackSendInfo();
                    codedInputByteBufferNano.readMessage(liveConditionAudienceRedPackSendInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveConditionAudienceRedPackSendInfoArr2[length] = new LiveConditionAudienceRedPackSendInfo();
                codedInputByteBufferNano.readMessage(liveConditionAudienceRedPackSendInfoArr2[length]);
                this.audienceRedPackSendInfo = liveConditionAudienceRedPackSendInfoArr2;
            }
        }
    }

    public static SCLiveConditionAudienceRedPackSend parseFrom(byte[] bArr) {
        return (SCLiveConditionAudienceRedPackSend) MessageNano.mergeFrom(new SCLiveConditionAudienceRedPackSend(), bArr);
    }

    public static SCLiveConditionAudienceRedPackSend parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveConditionAudienceRedPackSend().mergeFrom(codedInputByteBufferNano);
    }
}
