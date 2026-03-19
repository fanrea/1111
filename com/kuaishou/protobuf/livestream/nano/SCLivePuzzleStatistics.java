package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLivePuzzleStatistics extends MessageNano {
    private static volatile SCLivePuzzleStatistics[] _emptyArray;
    public String puzzleLineChatId;
    public LivePuzzleUserInfo[] puzzleUser;
    public long roomOwnerId;
    public int status;
    public long time;
    public long version;

    public static SCLivePuzzleStatistics[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLivePuzzleStatistics[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLivePuzzleStatistics() {
        clear();
    }

    public final SCLivePuzzleStatistics clear() {
        this.puzzleLineChatId = "";
        this.puzzleUser = LivePuzzleUserInfo.emptyArray();
        this.time = 0L;
        this.version = 0L;
        this.status = 0;
        this.roomOwnerId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.puzzleLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.puzzleLineChatId);
        }
        LivePuzzleUserInfo[] livePuzzleUserInfoArr = this.puzzleUser;
        if (livePuzzleUserInfoArr != null && livePuzzleUserInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LivePuzzleUserInfo[] livePuzzleUserInfoArr2 = this.puzzleUser;
                if (i >= livePuzzleUserInfoArr2.length) {
                    break;
                }
                LivePuzzleUserInfo livePuzzleUserInfo = livePuzzleUserInfoArr2[i];
                if (livePuzzleUserInfo != null) {
                    codedOutputByteBufferNano.writeMessage(2, livePuzzleUserInfo);
                }
                i++;
            }
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.version;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        int i2 = this.status;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i2);
        }
        long j3 = this.roomOwnerId;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.puzzleLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.puzzleLineChatId);
        }
        LivePuzzleUserInfo[] livePuzzleUserInfoArr = this.puzzleUser;
        if (livePuzzleUserInfoArr != null && livePuzzleUserInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LivePuzzleUserInfo[] livePuzzleUserInfoArr2 = this.puzzleUser;
                if (i >= livePuzzleUserInfoArr2.length) {
                    break;
                }
                LivePuzzleUserInfo livePuzzleUserInfo = livePuzzleUserInfoArr2[i];
                if (livePuzzleUserInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, livePuzzleUserInfo);
                }
                i++;
            }
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.version;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        int i2 = this.status;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i2);
        }
        long j3 = this.roomOwnerId;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLivePuzzleStatistics mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.puzzleLineChatId = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LivePuzzleUserInfo[] livePuzzleUserInfoArr = this.puzzleUser;
                int length = livePuzzleUserInfoArr == null ? 0 : livePuzzleUserInfoArr.length;
                LivePuzzleUserInfo[] livePuzzleUserInfoArr2 = new LivePuzzleUserInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.puzzleUser, 0, livePuzzleUserInfoArr2, 0, length);
                }
                while (length < livePuzzleUserInfoArr2.length - 1) {
                    livePuzzleUserInfoArr2[length] = new LivePuzzleUserInfo();
                    codedInputByteBufferNano.readMessage(livePuzzleUserInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                livePuzzleUserInfoArr2[length] = new LivePuzzleUserInfo();
                codedInputByteBufferNano.readMessage(livePuzzleUserInfoArr2[length]);
                this.puzzleUser = livePuzzleUserInfoArr2;
            } else if (tag == 24) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 32) {
                this.version = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.status = int32;
                }
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.roomOwnerId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLivePuzzleStatistics parseFrom(byte[] bArr) {
        return (SCLivePuzzleStatistics) MessageNano.mergeFrom(new SCLivePuzzleStatistics(), bArr);
    }

    public static SCLivePuzzleStatistics parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLivePuzzleStatistics().mergeFrom(codedInputByteBufferNano);
    }
}
