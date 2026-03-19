package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveMultiLineChatPitGuide extends MessageNano {
    private static volatile SCLiveMultiLineChatPitGuide[] _emptyArray;
    public long authorId;
    public long displayDurationMs;
    public long displayIntervalMs;
    public long displayTimes;
    public MultiLineChatPitGuideInfo[] guideInfo;
    public String liveStreamId;
    public String multiLineChatId;
    public long timestamp;
    public String userSession;

    public static SCLiveMultiLineChatPitGuide[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveMultiLineChatPitGuide[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveMultiLineChatPitGuide() {
        clear();
    }

    public final SCLiveMultiLineChatPitGuide clear() {
        this.multiLineChatId = "";
        this.liveStreamId = "";
        this.authorId = 0L;
        this.userSession = "";
        this.timestamp = 0L;
        this.guideInfo = MultiLineChatPitGuideInfo.emptyArray();
        this.displayIntervalMs = 0L;
        this.displayDurationMs = 0L;
        this.displayTimes = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.multiLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.multiLineChatId);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        long j = this.authorId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.userSession.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.userSession);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        MultiLineChatPitGuideInfo[] multiLineChatPitGuideInfoArr = this.guideInfo;
        if (multiLineChatPitGuideInfoArr != null && multiLineChatPitGuideInfoArr.length > 0) {
            int i = 0;
            while (true) {
                MultiLineChatPitGuideInfo[] multiLineChatPitGuideInfoArr2 = this.guideInfo;
                if (i >= multiLineChatPitGuideInfoArr2.length) {
                    break;
                }
                MultiLineChatPitGuideInfo multiLineChatPitGuideInfo = multiLineChatPitGuideInfoArr2[i];
                if (multiLineChatPitGuideInfo != null) {
                    codedOutputByteBufferNano.writeMessage(6, multiLineChatPitGuideInfo);
                }
                i++;
            }
        }
        long j3 = this.displayIntervalMs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        long j4 = this.displayDurationMs;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j4);
        }
        long j5 = this.displayTimes;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.multiLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.multiLineChatId);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        long j = this.authorId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.userSession.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.userSession);
        }
        long j2 = this.timestamp;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        MultiLineChatPitGuideInfo[] multiLineChatPitGuideInfoArr = this.guideInfo;
        if (multiLineChatPitGuideInfoArr != null && multiLineChatPitGuideInfoArr.length > 0) {
            int i = 0;
            while (true) {
                MultiLineChatPitGuideInfo[] multiLineChatPitGuideInfoArr2 = this.guideInfo;
                if (i >= multiLineChatPitGuideInfoArr2.length) {
                    break;
                }
                MultiLineChatPitGuideInfo multiLineChatPitGuideInfo = multiLineChatPitGuideInfoArr2[i];
                if (multiLineChatPitGuideInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, multiLineChatPitGuideInfo);
                }
                i++;
            }
        }
        long j3 = this.displayIntervalMs;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        long j4 = this.displayDurationMs;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
        }
        long j5 = this.displayTimes;
        return j5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(9, j5) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveMultiLineChatPitGuide mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.multiLineChatId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.userSession = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                MultiLineChatPitGuideInfo[] multiLineChatPitGuideInfoArr = this.guideInfo;
                int length = multiLineChatPitGuideInfoArr == null ? 0 : multiLineChatPitGuideInfoArr.length;
                MultiLineChatPitGuideInfo[] multiLineChatPitGuideInfoArr2 = new MultiLineChatPitGuideInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.guideInfo, 0, multiLineChatPitGuideInfoArr2, 0, length);
                }
                while (length < multiLineChatPitGuideInfoArr2.length - 1) {
                    multiLineChatPitGuideInfoArr2[length] = new MultiLineChatPitGuideInfo();
                    codedInputByteBufferNano.readMessage(multiLineChatPitGuideInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                multiLineChatPitGuideInfoArr2[length] = new MultiLineChatPitGuideInfo();
                codedInputByteBufferNano.readMessage(multiLineChatPitGuideInfoArr2[length]);
                this.guideInfo = multiLineChatPitGuideInfoArr2;
            } else if (tag == 56) {
                this.displayIntervalMs = codedInputByteBufferNano.readUInt64();
            } else if (tag == 64) {
                this.displayDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 72) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.displayTimes = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveMultiLineChatPitGuide parseFrom(byte[] bArr) {
        return (SCLiveMultiLineChatPitGuide) MessageNano.mergeFrom(new SCLiveMultiLineChatPitGuide(), bArr);
    }

    public static SCLiveMultiLineChatPitGuide parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveMultiLineChatPitGuide().mergeFrom(codedInputByteBufferNano);
    }
}
