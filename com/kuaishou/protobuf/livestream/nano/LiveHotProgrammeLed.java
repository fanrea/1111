package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichTextMessage;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveHotProgrammeLed extends MessageNano {
    private static volatile LiveHotProgrammeLed[] _emptyArray;
    public LiveHotProgrammeLebAnimationInfo animationInfo;
    public int enhanceIndex;
    public long enterRoomDelayShowMs;
    public long itemId;
    public LiveCommentRichTextMessage.CommentRichTextSegment[] richContext;
    public long showDeadlineTimeMs;
    public int showDurationMs;
    public int spiltIndex;
    public String[] text;
    public UserInfos.UserInfo userInfo;

    public static LiveHotProgrammeLed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveHotProgrammeLed[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveHotProgrammeLed() {
        clear();
    }

    public final LiveHotProgrammeLed clear() {
        this.userInfo = null;
        this.text = WireFormatNano.EMPTY_STRING_ARRAY;
        this.spiltIndex = 0;
        this.showDurationMs = 0;
        this.showDeadlineTimeMs = 0L;
        this.itemId = 0L;
        this.richContext = LiveCommentRichTextMessage.CommentRichTextSegment.emptyArray();
        this.enhanceIndex = 0;
        this.animationInfo = null;
        this.enterRoomDelayShowMs = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        String[] strArr = this.text;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.text;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(2, str);
                }
                i2++;
            }
        }
        int i3 = this.spiltIndex;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i3);
        }
        int i4 = this.showDurationMs;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i4);
        }
        long j = this.showDeadlineTimeMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        long j2 = this.itemId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr = this.richContext;
        if (commentRichTextSegmentArr != null && commentRichTextSegmentArr.length > 0) {
            while (true) {
                LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr2 = this.richContext;
                if (i >= commentRichTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichTextMessage.CommentRichTextSegment commentRichTextSegment = commentRichTextSegmentArr2[i];
                if (commentRichTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(7, commentRichTextSegment);
                }
                i++;
            }
        }
        int i5 = this.enhanceIndex;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeInt32(8, i5);
        }
        LiveHotProgrammeLebAnimationInfo liveHotProgrammeLebAnimationInfo = this.animationInfo;
        if (liveHotProgrammeLebAnimationInfo != null) {
            codedOutputByteBufferNano.writeMessage(9, liveHotProgrammeLebAnimationInfo);
        }
        long j3 = this.enterRoomDelayShowMs;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(10, j3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.userInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        String[] strArr = this.text;
        int i = 0;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.text;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
        }
        int i4 = this.spiltIndex;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i4);
        }
        int i5 = this.showDurationMs;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i5);
        }
        long j = this.showDeadlineTimeMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        long j2 = this.itemId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
        }
        LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr = this.richContext;
        if (commentRichTextSegmentArr != null && commentRichTextSegmentArr.length > 0) {
            while (true) {
                LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr2 = this.richContext;
                if (i >= commentRichTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichTextMessage.CommentRichTextSegment commentRichTextSegment = commentRichTextSegmentArr2[i];
                if (commentRichTextSegment != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, commentRichTextSegment);
                }
                i++;
            }
        }
        int i6 = this.enhanceIndex;
        if (i6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(8, i6);
        }
        LiveHotProgrammeLebAnimationInfo liveHotProgrammeLebAnimationInfo = this.animationInfo;
        if (liveHotProgrammeLebAnimationInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, liveHotProgrammeLebAnimationInfo);
        }
        long j3 = this.enterRoomDelayShowMs;
        return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(10, j3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveHotProgrammeLed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    if (this.userInfo == null) {
                        this.userInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfo);
                    break;
                case 18:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    String[] strArr = this.text;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.text, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.text = strArr2;
                    break;
                case 24:
                    this.spiltIndex = codedInputByteBufferNano.readInt32();
                    break;
                case 32:
                    this.showDurationMs = codedInputByteBufferNano.readUInt32();
                    break;
                case 40:
                    this.showDeadlineTimeMs = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    this.itemId = codedInputByteBufferNano.readUInt64();
                    break;
                case 58:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr = this.richContext;
                    int length2 = commentRichTextSegmentArr == null ? 0 : commentRichTextSegmentArr.length;
                    LiveCommentRichTextMessage.CommentRichTextSegment[] commentRichTextSegmentArr2 = new LiveCommentRichTextMessage.CommentRichTextSegment[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.richContext, 0, commentRichTextSegmentArr2, 0, length2);
                    }
                    while (length2 < commentRichTextSegmentArr2.length - 1) {
                        commentRichTextSegmentArr2[length2] = new LiveCommentRichTextMessage.CommentRichTextSegment();
                        codedInputByteBufferNano.readMessage(commentRichTextSegmentArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    commentRichTextSegmentArr2[length2] = new LiveCommentRichTextMessage.CommentRichTextSegment();
                    codedInputByteBufferNano.readMessage(commentRichTextSegmentArr2[length2]);
                    this.richContext = commentRichTextSegmentArr2;
                    break;
                case 64:
                    this.enhanceIndex = codedInputByteBufferNano.readInt32();
                    break;
                case 74:
                    if (this.animationInfo == null) {
                        this.animationInfo = new LiveHotProgrammeLebAnimationInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.animationInfo);
                    break;
                case 80:
                    this.enterRoomDelayShowMs = codedInputByteBufferNano.readUInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveHotProgrammeLed parseFrom(byte[] bArr) {
        return (LiveHotProgrammeLed) MessageNano.mergeFrom(new LiveHotProgrammeLed(), bArr);
    }

    public static LiveHotProgrammeLed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveHotProgrammeLed().mergeFrom(codedInputByteBufferNano);
    }
}
