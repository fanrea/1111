package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePuzzleLineChatStartInfo extends MessageNano {
    private static volatile LivePuzzleLineChatStartInfo[] _emptyArray;
    public LivePuzzleAnswerInfo[] answerInfo;
    public String answererConfirmKrnUrl;
    public long autoChooseAnswerDeadline;
    public String playRoleUrl;
    public String puzzleHeaderPath;
    public String puzzleLineChatId;
    public String puzzleLineChatName;
    public int puzzleType;
    public long queryStatisticsDeadline;
    public String questionerConfirmKrnUrl;
    public LivePuzzleLineChatResourceInfo resourceInfo;
    public long roomOwnerId;
    public Map<Long, Integer> userRoleInfo;

    public static LivePuzzleLineChatStartInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePuzzleLineChatStartInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePuzzleLineChatStartInfo() {
        clear();
    }

    public final LivePuzzleLineChatStartInfo clear() {
        this.puzzleLineChatId = "";
        this.puzzleType = 0;
        this.userRoleInfo = null;
        this.roomOwnerId = 0L;
        this.answerInfo = LivePuzzleAnswerInfo.emptyArray();
        this.questionerConfirmKrnUrl = "";
        this.answererConfirmKrnUrl = "";
        this.autoChooseAnswerDeadline = 0L;
        this.queryStatisticsDeadline = 0L;
        this.puzzleHeaderPath = "";
        this.resourceInfo = null;
        this.puzzleLineChatName = "";
        this.playRoleUrl = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.puzzleLineChatId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.puzzleLineChatId);
        }
        int i = this.puzzleType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        Map<Long, Integer> map = this.userRoleInfo;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 3, 4, 14);
        }
        long j = this.roomOwnerId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j);
        }
        LivePuzzleAnswerInfo[] livePuzzleAnswerInfoArr = this.answerInfo;
        if (livePuzzleAnswerInfoArr != null && livePuzzleAnswerInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LivePuzzleAnswerInfo[] livePuzzleAnswerInfoArr2 = this.answerInfo;
                if (i2 >= livePuzzleAnswerInfoArr2.length) {
                    break;
                }
                LivePuzzleAnswerInfo livePuzzleAnswerInfo = livePuzzleAnswerInfoArr2[i2];
                if (livePuzzleAnswerInfo != null) {
                    codedOutputByteBufferNano.writeMessage(5, livePuzzleAnswerInfo);
                }
                i2++;
            }
        }
        if (!this.questionerConfirmKrnUrl.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.questionerConfirmKrnUrl);
        }
        if (!this.answererConfirmKrnUrl.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.answererConfirmKrnUrl);
        }
        long j2 = this.autoChooseAnswerDeadline;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j2);
        }
        long j3 = this.queryStatisticsDeadline;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(9, j3);
        }
        if (!this.puzzleHeaderPath.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.puzzleHeaderPath);
        }
        LivePuzzleLineChatResourceInfo livePuzzleLineChatResourceInfo = this.resourceInfo;
        if (livePuzzleLineChatResourceInfo != null) {
            codedOutputByteBufferNano.writeMessage(11, livePuzzleLineChatResourceInfo);
        }
        if (!this.puzzleLineChatName.equals("")) {
            codedOutputByteBufferNano.writeString(12, this.puzzleLineChatName);
        }
        if (!this.playRoleUrl.equals("")) {
            codedOutputByteBufferNano.writeString(13, this.playRoleUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.puzzleLineChatId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.puzzleLineChatId);
        }
        int i = this.puzzleType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        Map<Long, Integer> map = this.userRoleInfo;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 3, 4, 14);
        }
        long j = this.roomOwnerId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
        }
        LivePuzzleAnswerInfo[] livePuzzleAnswerInfoArr = this.answerInfo;
        if (livePuzzleAnswerInfoArr != null && livePuzzleAnswerInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LivePuzzleAnswerInfo[] livePuzzleAnswerInfoArr2 = this.answerInfo;
                if (i2 >= livePuzzleAnswerInfoArr2.length) {
                    break;
                }
                LivePuzzleAnswerInfo livePuzzleAnswerInfo = livePuzzleAnswerInfoArr2[i2];
                if (livePuzzleAnswerInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, livePuzzleAnswerInfo);
                }
                i2++;
            }
        }
        if (!this.questionerConfirmKrnUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.questionerConfirmKrnUrl);
        }
        if (!this.answererConfirmKrnUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.answererConfirmKrnUrl);
        }
        long j2 = this.autoChooseAnswerDeadline;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j2);
        }
        long j3 = this.queryStatisticsDeadline;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
        }
        if (!this.puzzleHeaderPath.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.puzzleHeaderPath);
        }
        LivePuzzleLineChatResourceInfo livePuzzleLineChatResourceInfo = this.resourceInfo;
        if (livePuzzleLineChatResourceInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, livePuzzleLineChatResourceInfo);
        }
        if (!this.puzzleLineChatName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(12, this.puzzleLineChatName);
        }
        return !this.playRoleUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(13, this.playRoleUrl) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePuzzleLineChatStartInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.puzzleLineChatId = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1) {
                        break;
                    } else {
                        this.puzzleType = int32;
                        break;
                    }
                    break;
                case 26:
                    this.userRoleInfo = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.userRoleInfo, mapFactory, 4, 14, null, 8, 16);
                    break;
                case 32:
                    this.roomOwnerId = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LivePuzzleAnswerInfo[] livePuzzleAnswerInfoArr = this.answerInfo;
                    int length = livePuzzleAnswerInfoArr == null ? 0 : livePuzzleAnswerInfoArr.length;
                    LivePuzzleAnswerInfo[] livePuzzleAnswerInfoArr2 = new LivePuzzleAnswerInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.answerInfo, 0, livePuzzleAnswerInfoArr2, 0, length);
                    }
                    while (length < livePuzzleAnswerInfoArr2.length - 1) {
                        livePuzzleAnswerInfoArr2[length] = new LivePuzzleAnswerInfo();
                        codedInputByteBufferNano.readMessage(livePuzzleAnswerInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    livePuzzleAnswerInfoArr2[length] = new LivePuzzleAnswerInfo();
                    codedInputByteBufferNano.readMessage(livePuzzleAnswerInfoArr2[length]);
                    this.answerInfo = livePuzzleAnswerInfoArr2;
                    break;
                case 50:
                    this.questionerConfirmKrnUrl = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.answererConfirmKrnUrl = codedInputByteBufferNano.readString();
                    break;
                case 64:
                    this.autoChooseAnswerDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 72:
                    this.queryStatisticsDeadline = codedInputByteBufferNano.readUInt64();
                    break;
                case 82:
                    this.puzzleHeaderPath = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    if (this.resourceInfo == null) {
                        this.resourceInfo = new LivePuzzleLineChatResourceInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.resourceInfo);
                    break;
                case 98:
                    this.puzzleLineChatName = codedInputByteBufferNano.readString();
                    break;
                case 106:
                    this.playRoleUrl = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LivePuzzleLineChatStartInfo parseFrom(byte[] bArr) {
        return (LivePuzzleLineChatStartInfo) MessageNano.mergeFrom(new LivePuzzleLineChatStartInfo(), bArr);
    }

    public static LivePuzzleLineChatStartInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePuzzleLineChatStartInfo().mergeFrom(codedInputByteBufferNano);
    }
}
