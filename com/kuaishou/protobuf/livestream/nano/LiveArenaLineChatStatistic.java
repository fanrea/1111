package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveArenaLineChatStatistic extends MessageNano {
    private static volatile LiveArenaLineChatStatistic[] _emptyArray;
    public boolean ended;
    public long freeChatEndTime;
    public long freeChatStartTime;
    public long hostUserId;
    public LiveArenaLineChatUserInfo[] orderList;
    public long version;
    public long winnerUserId;

    public static LiveArenaLineChatStatistic[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveArenaLineChatStatistic[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveArenaLineChatStatistic() {
        clear();
    }

    public final LiveArenaLineChatStatistic clear() {
        this.orderList = LiveArenaLineChatUserInfo.emptyArray();
        this.ended = false;
        this.winnerUserId = 0L;
        this.hostUserId = 0L;
        this.version = 0L;
        this.freeChatStartTime = 0L;
        this.freeChatEndTime = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveArenaLineChatUserInfo[] liveArenaLineChatUserInfoArr = this.orderList;
        if (liveArenaLineChatUserInfoArr != null && liveArenaLineChatUserInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveArenaLineChatUserInfo[] liveArenaLineChatUserInfoArr2 = this.orderList;
                if (i >= liveArenaLineChatUserInfoArr2.length) {
                    break;
                }
                LiveArenaLineChatUserInfo liveArenaLineChatUserInfo = liveArenaLineChatUserInfoArr2[i];
                if (liveArenaLineChatUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, liveArenaLineChatUserInfo);
                }
                i++;
            }
        }
        boolean z = this.ended;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        long j = this.winnerUserId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.hostUserId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        long j3 = this.version;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j3);
        }
        long j4 = this.freeChatStartTime;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j4);
        }
        long j5 = this.freeChatEndTime;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j5);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveArenaLineChatUserInfo[] liveArenaLineChatUserInfoArr = this.orderList;
        if (liveArenaLineChatUserInfoArr != null && liveArenaLineChatUserInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LiveArenaLineChatUserInfo[] liveArenaLineChatUserInfoArr2 = this.orderList;
                if (i >= liveArenaLineChatUserInfoArr2.length) {
                    break;
                }
                LiveArenaLineChatUserInfo liveArenaLineChatUserInfo = liveArenaLineChatUserInfoArr2[i];
                if (liveArenaLineChatUserInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveArenaLineChatUserInfo);
                }
                i++;
            }
        }
        boolean z = this.ended;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        long j = this.winnerUserId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.hostUserId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        long j3 = this.version;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
        }
        long j4 = this.freeChatStartTime;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j4);
        }
        long j5 = this.freeChatEndTime;
        return j5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j5) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveArenaLineChatStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LiveArenaLineChatUserInfo[] liveArenaLineChatUserInfoArr = this.orderList;
                int length = liveArenaLineChatUserInfoArr == null ? 0 : liveArenaLineChatUserInfoArr.length;
                LiveArenaLineChatUserInfo[] liveArenaLineChatUserInfoArr2 = new LiveArenaLineChatUserInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.orderList, 0, liveArenaLineChatUserInfoArr2, 0, length);
                }
                while (length < liveArenaLineChatUserInfoArr2.length - 1) {
                    liveArenaLineChatUserInfoArr2[length] = new LiveArenaLineChatUserInfo();
                    codedInputByteBufferNano.readMessage(liveArenaLineChatUserInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveArenaLineChatUserInfoArr2[length] = new LiveArenaLineChatUserInfo();
                codedInputByteBufferNano.readMessage(liveArenaLineChatUserInfoArr2[length]);
                this.orderList = liveArenaLineChatUserInfoArr2;
            } else if (tag == 16) {
                this.ended = codedInputByteBufferNano.readBool();
            } else if (tag == 24) {
                this.winnerUserId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 32) {
                this.hostUserId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                this.version = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                this.freeChatStartTime = codedInputByteBufferNano.readUInt64();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.freeChatEndTime = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static LiveArenaLineChatStatistic parseFrom(byte[] bArr) {
        return (LiveArenaLineChatStatistic) MessageNano.mergeFrom(new LiveArenaLineChatStatistic(), bArr);
    }

    public static LiveArenaLineChatStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveArenaLineChatStatistic().mergeFrom(codedInputByteBufferNano);
    }
}
