package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePuzzleUserInfo extends MessageNano {
    private static volatile LivePuzzleUserInfo[] _emptyArray;
    public int answerId;
    public int answerIdThisTime;
    public int countRecord;
    public String countRecordDescription;
    public boolean isPublish;
    public boolean isWin;
    public boolean isWinThisTime;
    public String liveStreamId;
    public UserInfos.UserInfo player;
    public String quickCommentRouter;
    public int roleType;
    public long[] thisTimeBeWonAuthorId;
    public int winNum;

    public static LivePuzzleUserInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePuzzleUserInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePuzzleUserInfo() {
        clear();
    }

    public final LivePuzzleUserInfo clear() {
        this.player = null;
        this.liveStreamId = "";
        this.quickCommentRouter = "";
        this.roleType = 0;
        this.isPublish = false;
        this.answerId = 0;
        this.countRecordDescription = "";
        this.countRecord = 0;
        this.isWin = false;
        this.isWinThisTime = false;
        this.answerIdThisTime = 0;
        this.winNum = 0;
        this.thisTimeBeWonAuthorId = WireFormatNano.EMPTY_LONG_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.player;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        if (!this.quickCommentRouter.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.quickCommentRouter);
        }
        int i = this.roleType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(4, i);
        }
        boolean z = this.isPublish;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        int i2 = this.answerId;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(6, i2);
        }
        if (!this.countRecordDescription.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.countRecordDescription);
        }
        int i3 = this.countRecord;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i3);
        }
        boolean z2 = this.isWin;
        if (z2) {
            codedOutputByteBufferNano.writeBool(9, z2);
        }
        boolean z3 = this.isWinThisTime;
        if (z3) {
            codedOutputByteBufferNano.writeBool(10, z3);
        }
        int i4 = this.answerIdThisTime;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(11, i4);
        }
        int i5 = this.winNum;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i5);
        }
        long[] jArr = this.thisTimeBeWonAuthorId;
        if (jArr != null && jArr.length > 0) {
            int i6 = 0;
            while (true) {
                long[] jArr2 = this.thisTimeBeWonAuthorId;
                if (i6 >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(13, jArr2[i6]);
                i6++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.player;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        if (!this.quickCommentRouter.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.quickCommentRouter);
        }
        int i = this.roleType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i);
        }
        boolean z = this.isPublish;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
        }
        int i2 = this.answerId;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i2);
        }
        if (!this.countRecordDescription.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.countRecordDescription);
        }
        int i3 = this.countRecord;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i3);
        }
        boolean z2 = this.isWin;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(9, z2);
        }
        boolean z3 = this.isWinThisTime;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(10, z3);
        }
        int i4 = this.answerIdThisTime;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(11, i4);
        }
        int i5 = this.winNum;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i5);
        }
        long[] jArr = this.thisTimeBeWonAuthorId;
        if (jArr == null || jArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int i6 = 0;
        int iComputeUInt64SizeNoTag = 0;
        while (true) {
            long[] jArr2 = this.thisTimeBeWonAuthorId;
            if (i6 < jArr2.length) {
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i6]);
                i6++;
            } else {
                return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
            }
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePuzzleUserInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.player == null) {
                        this.player = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.player);
                    break;
                case 18:
                    this.liveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.quickCommentRouter = codedInputByteBufferNano.readString();
                    break;
                case 32:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2 && int32 != 3) {
                        break;
                    } else {
                        this.roleType = int32;
                        break;
                    }
                    break;
                case 40:
                    this.isPublish = codedInputByteBufferNano.readBool();
                    break;
                case 48:
                    this.answerId = codedInputByteBufferNano.readUInt32();
                    break;
                case 58:
                    this.countRecordDescription = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.countRecord = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.isWin = codedInputByteBufferNano.readBool();
                    break;
                case 80:
                    this.isWinThisTime = codedInputByteBufferNano.readBool();
                    break;
                case 88:
                    this.answerIdThisTime = codedInputByteBufferNano.readUInt32();
                    break;
                case 96:
                    this.winNum = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 104);
                    long[] jArr = this.thisTimeBeWonAuthorId;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.thisTimeBeWonAuthorId, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.thisTimeBeWonAuthorId = jArr2;
                    break;
                case 106:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.thisTimeBeWonAuthorId;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.thisTimeBeWonAuthorId, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.thisTimeBeWonAuthorId = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LivePuzzleUserInfo parseFrom(byte[] bArr) {
        return (LivePuzzleUserInfo) MessageNano.mergeFrom(new LivePuzzleUserInfo(), bArr);
    }

    public static LivePuzzleUserInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePuzzleUserInfo().mergeFrom(codedInputByteBufferNano);
    }
}
