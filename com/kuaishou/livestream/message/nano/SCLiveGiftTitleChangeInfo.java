package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftTitleChangeInfo extends MessageNano {
    private static volatile SCLiveGiftTitleChangeInfo[] _emptyArray;
    public LiveGiftTitleInfo[] info;
    public String liveStreamId;
    public long serverTime;

    public static SCLiveGiftTitleChangeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftTitleChangeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftTitleChangeInfo() {
        clear();
    }

    public final SCLiveGiftTitleChangeInfo clear() {
        this.serverTime = 0L;
        this.liveStreamId = "";
        this.info = LiveGiftTitleInfo.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.serverTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        LiveGiftTitleInfo[] liveGiftTitleInfoArr = this.info;
        if (liveGiftTitleInfoArr != null && liveGiftTitleInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveGiftTitleInfo[] liveGiftTitleInfoArr2 = this.info;
                if (i >= liveGiftTitleInfoArr2.length) {
                    break;
                }
                LiveGiftTitleInfo liveGiftTitleInfo = liveGiftTitleInfoArr2[i];
                if (liveGiftTitleInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveGiftTitleInfo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.serverTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        LiveGiftTitleInfo[] liveGiftTitleInfoArr = this.info;
        if (liveGiftTitleInfoArr != null && liveGiftTitleInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveGiftTitleInfo[] liveGiftTitleInfoArr2 = this.info;
                if (i >= liveGiftTitleInfoArr2.length) {
                    break;
                }
                LiveGiftTitleInfo liveGiftTitleInfo = liveGiftTitleInfoArr2[i];
                if (liveGiftTitleInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveGiftTitleInfo);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftTitleChangeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.serverTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveGiftTitleInfo[] liveGiftTitleInfoArr = this.info;
                int length = liveGiftTitleInfoArr == null ? 0 : liveGiftTitleInfoArr.length;
                LiveGiftTitleInfo[] liveGiftTitleInfoArr2 = new LiveGiftTitleInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.info, 0, liveGiftTitleInfoArr2, 0, length);
                }
                while (length < liveGiftTitleInfoArr2.length - 1) {
                    liveGiftTitleInfoArr2[length] = new LiveGiftTitleInfo();
                    codedInputByteBufferNano.readMessage(liveGiftTitleInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveGiftTitleInfoArr2[length] = new LiveGiftTitleInfo();
                codedInputByteBufferNano.readMessage(liveGiftTitleInfoArr2[length]);
                this.info = liveGiftTitleInfoArr2;
            }
        }
    }

    public static SCLiveGiftTitleChangeInfo parseFrom(byte[] bArr) {
        return (SCLiveGiftTitleChangeInfo) MessageNano.mergeFrom(new SCLiveGiftTitleChangeInfo(), bArr);
    }

    public static SCLiveGiftTitleChangeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftTitleChangeInfo().mergeFrom(codedInputByteBufferNano);
    }
}
