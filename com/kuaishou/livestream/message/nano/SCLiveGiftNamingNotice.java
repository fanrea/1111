package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftNamingNotice extends MessageNano {
    private static volatile SCLiveGiftNamingNotice[] _emptyArray;
    public int achievementWallVersion;
    public long authorId;
    public LiveGiftNamingInfo[] info;
    public String liveStreamId;
    public long serverTime;
    public long targetUserId;

    public static SCLiveGiftNamingNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftNamingNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftNamingNotice() {
        clear();
    }

    public final SCLiveGiftNamingNotice clear() {
        this.serverTime = 0L;
        this.info = LiveGiftNamingInfo.emptyArray();
        this.authorId = 0L;
        this.liveStreamId = "";
        this.achievementWallVersion = 0;
        this.targetUserId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.serverTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        LiveGiftNamingInfo[] liveGiftNamingInfoArr = this.info;
        if (liveGiftNamingInfoArr != null && liveGiftNamingInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveGiftNamingInfo[] liveGiftNamingInfoArr2 = this.info;
                if (i >= liveGiftNamingInfoArr2.length) {
                    break;
                }
                LiveGiftNamingInfo liveGiftNamingInfo = liveGiftNamingInfoArr2[i];
                if (liveGiftNamingInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, liveGiftNamingInfo);
                }
                i++;
            }
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.liveStreamId);
        }
        int i2 = this.achievementWallVersion;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i2);
        }
        long j3 = this.targetUserId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
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
        LiveGiftNamingInfo[] liveGiftNamingInfoArr = this.info;
        if (liveGiftNamingInfoArr != null && liveGiftNamingInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveGiftNamingInfo[] liveGiftNamingInfoArr2 = this.info;
                if (i >= liveGiftNamingInfoArr2.length) {
                    break;
                }
                LiveGiftNamingInfo liveGiftNamingInfo = liveGiftNamingInfoArr2[i];
                if (liveGiftNamingInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveGiftNamingInfo);
                }
                i++;
            }
        }
        long j2 = this.authorId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.liveStreamId);
        }
        int i2 = this.achievementWallVersion;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i2);
        }
        long j3 = this.targetUserId;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftNamingNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.serverTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LiveGiftNamingInfo[] liveGiftNamingInfoArr = this.info;
                int length = liveGiftNamingInfoArr == null ? 0 : liveGiftNamingInfoArr.length;
                LiveGiftNamingInfo[] liveGiftNamingInfoArr2 = new LiveGiftNamingInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.info, 0, liveGiftNamingInfoArr2, 0, length);
                }
                while (length < liveGiftNamingInfoArr2.length - 1) {
                    liveGiftNamingInfoArr2[length] = new LiveGiftNamingInfo();
                    codedInputByteBufferNano.readMessage(liveGiftNamingInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveGiftNamingInfoArr2[length] = new LiveGiftNamingInfo();
                codedInputByteBufferNano.readMessage(liveGiftNamingInfoArr2[length]);
                this.info = liveGiftNamingInfoArr2;
            } else if (tag == 24) {
                this.authorId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.achievementWallVersion = codedInputByteBufferNano.readUInt32();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.targetUserId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveGiftNamingNotice parseFrom(byte[] bArr) {
        return (SCLiveGiftNamingNotice) MessageNano.mergeFrom(new SCLiveGiftNamingNotice(), bArr);
    }

    public static SCLiveGiftNamingNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftNamingNotice().mergeFrom(codedInputByteBufferNano);
    }
}
