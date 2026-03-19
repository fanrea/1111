package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveArenaLineChatUserInfo extends MessageNano {
    private static volatile LiveArenaLineChatUserInfo[] _emptyArray;
    public String displayScore;
    public long endTime;
    public InteractiveChatWindowFrameColor frameColor;
    public String orderLabel;
    public int rank;
    public long score;
    public long startTime;
    public int status;
    public long userId;
    public UserInfos.UserInfo userInfo;

    @Retention(RetentionPolicy.SOURCE)
    public @interface UserStatus {
        public static final int PERFORMED = 1;
        public static final int PERFORMING = 2;
        public static final int UNKNOWN = 0;
        public static final int WAITING = 3;
    }

    public static LiveArenaLineChatUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveArenaLineChatUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveArenaLineChatUserInfo() {
        clear();
    }

    public final LiveArenaLineChatUserInfo clear() {
        this.userId = 0L;
        this.status = 0;
        this.score = 0L;
        this.displayScore = "";
        this.orderLabel = "";
        this.userInfo = null;
        this.startTime = 0L;
        this.endTime = 0L;
        this.rank = 0;
        this.frameColor = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.userId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        int i = this.status;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        long j2 = this.score;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j2);
        }
        if (!this.displayScore.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.displayScore);
        }
        if (!this.orderLabel.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.orderLabel);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(6, userInfo);
        }
        long j3 = this.startTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j3);
        }
        long j4 = this.endTime;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j4);
        }
        int i2 = this.rank;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(9, i2);
        }
        InteractiveChatWindowFrameColor interactiveChatWindowFrameColor = this.frameColor;
        if (interactiveChatWindowFrameColor != null) {
            codedOutputByteBufferNano.writeMessage(10, interactiveChatWindowFrameColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.userId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        int i = this.status;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        long j2 = this.score;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
        }
        if (!this.displayScore.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.displayScore);
        }
        if (!this.orderLabel.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.orderLabel);
        }
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, userInfo);
        }
        long j3 = this.startTime;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j3);
        }
        long j4 = this.endTime;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j4);
        }
        int i2 = this.rank;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(9, i2);
        }
        InteractiveChatWindowFrameColor interactiveChatWindowFrameColor = this.frameColor;
        return interactiveChatWindowFrameColor != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(10, interactiveChatWindowFrameColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveArenaLineChatUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.userId = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.status = int32;
                        break;
                    }
                    break;
                case 24:
                    this.score = codedInputByteBufferNano.readUInt64();
                    break;
                case 34:
                    this.displayScore = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.orderLabel = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    if (this.userInfo == null) {
                        this.userInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfo);
                    break;
                case 56:
                    this.startTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.endTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.rank = codedInputByteBufferNano.readUInt32();
                    break;
                case 82:
                    if (this.frameColor == null) {
                        this.frameColor = new InteractiveChatWindowFrameColor();
                    }
                    codedInputByteBufferNano.readMessage(this.frameColor);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveArenaLineChatUserInfo parseFrom(byte[] bArr) {
        return (LiveArenaLineChatUserInfo) MessageNano.mergeFrom(new LiveArenaLineChatUserInfo(), bArr);
    }

    public static LiveArenaLineChatUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveArenaLineChatUserInfo().mergeFrom(codedInputByteBufferNano);
    }
}
