package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentAction;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichText;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveCommentRichTextMessage {

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommentRichTextBizType {
        public static final int AUDIENCE_RED_PACK = 2;
        public static final int CNY_2024_WARMUP_PRAY_WISH_COMMENT = 6;
        public static final int FAMILY_TOGETHER_RED_PACK = 3;
        public static final int HOT_PROGRAMME_COMMENT = 4;
        public static final int LIVE_LOCAL_LIFE_AI_INTELLIGENCE_COMMENT = 8;
        public static final int LIVE_LOCAL_LIFE_ORDER_COMMENT = 7;
        public static final int LIVE_MERCHANT_INTERACTIVE = 5;
        public static final int POPULARITY_RANK_RED_PACK = 1;
        public static final int UNKNOWN_RICH_TEXT_BIZ_TYPE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CommentRichTextLiveScene {
        public static final int DEFAULT_SCENE = 0;
        public static final int LITE_LIVE = 2;
        public static final int NORMAL_LIVE = 1;
    }

    public static final class CommentRichTextSegment extends MessageNano {
        public static final int BADGE_SEGMENT_FIELD_NUMBER = 5;
        public static final int GIFT_SEGMENT_FIELD_NUMBER = 3;
        public static final int ICON_SEGMENT_FIELD_NUMBER = 2;
        public static final int IMAGE_SEGMENT_FIELD_NUMBER = 4;
        public static final int TEXT_SEGMENT_FIELD_NUMBER = 1;
        private static volatile CommentRichTextSegment[] _emptyArray;
        private int entryCase_ = 0;
        private Object entry_;

        public final int getEntryCase() {
            return this.entryCase_;
        }

        public final CommentRichTextSegment clearEntry() {
            this.entryCase_ = 0;
            this.entry_ = null;
            return this;
        }

        public static CommentRichTextSegment[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentRichTextSegment[0];
                    }
                }
            }
            return _emptyArray;
        }

        public final boolean hasTextSegment() {
            return this.entryCase_ == 1;
        }

        public final LiveCommentRichText.CommentTextSegment getTextSegment() {
            if (this.entryCase_ == 1) {
                return (LiveCommentRichText.CommentTextSegment) this.entry_;
            }
            return null;
        }

        public final CommentRichTextSegment setTextSegment(LiveCommentRichText.CommentTextSegment commentTextSegment) {
            if (commentTextSegment == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 1;
            this.entry_ = commentTextSegment;
            return this;
        }

        public final boolean hasIconSegment() {
            return this.entryCase_ == 2;
        }

        public final LiveCommentRichText.CommentIconSegment getIconSegment() {
            if (this.entryCase_ == 2) {
                return (LiveCommentRichText.CommentIconSegment) this.entry_;
            }
            return null;
        }

        public final CommentRichTextSegment setIconSegment(LiveCommentRichText.CommentIconSegment commentIconSegment) {
            if (commentIconSegment == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 2;
            this.entry_ = commentIconSegment;
            return this;
        }

        public final boolean hasGiftSegment() {
            return this.entryCase_ == 3;
        }

        public final LiveCommentRichText.CommentGiftSegment getGiftSegment() {
            if (this.entryCase_ == 3) {
                return (LiveCommentRichText.CommentGiftSegment) this.entry_;
            }
            return null;
        }

        public final CommentRichTextSegment setGiftSegment(LiveCommentRichText.CommentGiftSegment commentGiftSegment) {
            if (commentGiftSegment == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 3;
            this.entry_ = commentGiftSegment;
            return this;
        }

        public final boolean hasImageSegment() {
            return this.entryCase_ == 4;
        }

        public final LiveCommentRichText.CommentImageSegment getImageSegment() {
            if (this.entryCase_ == 4) {
                return (LiveCommentRichText.CommentImageSegment) this.entry_;
            }
            return null;
        }

        public final CommentRichTextSegment setImageSegment(LiveCommentRichText.CommentImageSegment commentImageSegment) {
            if (commentImageSegment == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 4;
            this.entry_ = commentImageSegment;
            return this;
        }

        public final boolean hasBadgeSegment() {
            return this.entryCase_ == 5;
        }

        public final LiveCommentRichText.CommentBadgeSegment getBadgeSegment() {
            if (this.entryCase_ == 5) {
                return (LiveCommentRichText.CommentBadgeSegment) this.entry_;
            }
            return null;
        }

        public final CommentRichTextSegment setBadgeSegment(LiveCommentRichText.CommentBadgeSegment commentBadgeSegment) {
            if (commentBadgeSegment == null) {
                throw new NullPointerException();
            }
            this.entryCase_ = 5;
            this.entry_ = commentBadgeSegment;
            return this;
        }

        public CommentRichTextSegment() {
            clear();
        }

        public final CommentRichTextSegment clear() {
            clearEntry();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (this.entryCase_ == 1) {
                codedOutputByteBufferNano.writeMessage(1, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 2) {
                codedOutputByteBufferNano.writeMessage(2, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 3) {
                codedOutputByteBufferNano.writeMessage(3, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 4) {
                codedOutputByteBufferNano.writeMessage(4, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 5) {
                codedOutputByteBufferNano.writeMessage(5, (MessageNano) this.entry_);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (this.entryCase_ == 1) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 3) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, (MessageNano) this.entry_);
            }
            if (this.entryCase_ == 4) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, (MessageNano) this.entry_);
            }
            return this.entryCase_ == 5 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, (MessageNano) this.entry_) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentRichTextSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.entryCase_ != 1) {
                        this.entry_ = new LiveCommentRichText.CommentTextSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 1;
                } else if (tag == 18) {
                    if (this.entryCase_ != 2) {
                        this.entry_ = new LiveCommentRichText.CommentIconSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 2;
                } else if (tag == 26) {
                    if (this.entryCase_ != 3) {
                        this.entry_ = new LiveCommentRichText.CommentGiftSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 3;
                } else if (tag == 34) {
                    if (this.entryCase_ != 4) {
                        this.entry_ = new LiveCommentRichText.CommentImageSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 4;
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.entryCase_ != 5) {
                        this.entry_ = new LiveCommentRichText.CommentBadgeSegment();
                    }
                    codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                    this.entryCase_ = 5;
                }
            }
        }

        public static CommentRichTextSegment parseFrom(byte[] bArr) {
            return (CommentRichTextSegment) MessageNano.mergeFrom(new CommentRichTextSegment(), bArr);
        }

        public static CommentRichTextSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentRichTextSegment().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class CommentRichTextMessage extends MessageNano {
        private static volatile CommentRichTextMessage[] _emptyArray;
        public int bizType;
        public String deviceHash;
        public LiveFeedBackground feedBackground;
        public boolean forceNonDisposable;
        public boolean forceShowInCommentList;
        public String id;
        public LiveCommentAction.Action longPressAction;
        public CommentRichTextSegment[] segment;
        public long serverTimestamp;
        public long sortRank;
        public LiveCommentAction.Action tapAction;
        public int[] targetScenes;
        public long userId;

        public static CommentRichTextMessage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentRichTextMessage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentRichTextMessage() {
            clear();
        }

        public final CommentRichTextMessage clear() {
            this.id = "";
            this.userId = 0L;
            this.serverTimestamp = 0L;
            this.deviceHash = "";
            this.sortRank = 0L;
            this.bizType = 0;
            this.segment = CommentRichTextSegment.emptyArray();
            this.feedBackground = null;
            this.tapAction = null;
            this.longPressAction = null;
            this.forceShowInCommentList = false;
            this.forceNonDisposable = false;
            this.targetScenes = WireFormatNano.EMPTY_INT_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            long j = this.userId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.serverTimestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            if (!this.deviceHash.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.deviceHash);
            }
            long j3 = this.sortRank;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j3);
            }
            int i = this.bizType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(6, i);
            }
            CommentRichTextSegment[] commentRichTextSegmentArr = this.segment;
            int i2 = 0;
            if (commentRichTextSegmentArr != null && commentRichTextSegmentArr.length > 0) {
                int i3 = 0;
                while (true) {
                    CommentRichTextSegment[] commentRichTextSegmentArr2 = this.segment;
                    if (i3 >= commentRichTextSegmentArr2.length) {
                        break;
                    }
                    CommentRichTextSegment commentRichTextSegment = commentRichTextSegmentArr2[i3];
                    if (commentRichTextSegment != null) {
                        codedOutputByteBufferNano.writeMessage(7, commentRichTextSegment);
                    }
                    i3++;
                }
            }
            LiveFeedBackground liveFeedBackground = this.feedBackground;
            if (liveFeedBackground != null) {
                codedOutputByteBufferNano.writeMessage(8, liveFeedBackground);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                codedOutputByteBufferNano.writeMessage(9, action);
            }
            LiveCommentAction.Action action2 = this.longPressAction;
            if (action2 != null) {
                codedOutputByteBufferNano.writeMessage(10, action2);
            }
            boolean z = this.forceShowInCommentList;
            if (z) {
                codedOutputByteBufferNano.writeBool(11, z);
            }
            boolean z2 = this.forceNonDisposable;
            if (z2) {
                codedOutputByteBufferNano.writeBool(12, z2);
            }
            int[] iArr = this.targetScenes;
            if (iArr != null && iArr.length > 0) {
                while (true) {
                    int[] iArr2 = this.targetScenes;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeInt32(13, iArr2[i2]);
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            long j = this.userId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.serverTimestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            if (!this.deviceHash.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.deviceHash);
            }
            long j3 = this.sortRank;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
            }
            int i = this.bizType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(6, i);
            }
            CommentRichTextSegment[] commentRichTextSegmentArr = this.segment;
            int i2 = 0;
            if (commentRichTextSegmentArr != null && commentRichTextSegmentArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    CommentRichTextSegment[] commentRichTextSegmentArr2 = this.segment;
                    if (i3 >= commentRichTextSegmentArr2.length) {
                        break;
                    }
                    CommentRichTextSegment commentRichTextSegment = commentRichTextSegmentArr2[i3];
                    if (commentRichTextSegment != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(7, commentRichTextSegment);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            LiveFeedBackground liveFeedBackground = this.feedBackground;
            if (liveFeedBackground != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, liveFeedBackground);
            }
            LiveCommentAction.Action action = this.tapAction;
            if (action != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, action);
            }
            LiveCommentAction.Action action2 = this.longPressAction;
            if (action2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(10, action2);
            }
            boolean z = this.forceShowInCommentList;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(11, z);
            }
            boolean z2 = this.forceNonDisposable;
            if (z2) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(12, z2);
            }
            int[] iArr = this.targetScenes;
            if (iArr == null || iArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int iComputeInt32SizeNoTag = 0;
            while (true) {
                int[] iArr2 = this.targetScenes;
                if (i2 < iArr2.length) {
                    iComputeInt32SizeNoTag += CodedOutputByteBufferNano.computeInt32SizeNoTag(iArr2[i2]);
                    i2++;
                } else {
                    return iComputeSerializedSize + iComputeInt32SizeNoTag + (iArr2.length * 1);
                }
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentRichTextMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.id = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.userId = codedInputByteBufferNano.readUInt64();
                        break;
                    case 24:
                        this.serverTimestamp = codedInputByteBufferNano.readUInt64();
                        break;
                    case 34:
                        this.deviceHash = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.sortRank = codedInputByteBufferNano.readUInt64();
                        break;
                    case 48:
                        this.bizType = codedInputByteBufferNano.readUInt32();
                        break;
                    case 58:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                        CommentRichTextSegment[] commentRichTextSegmentArr = this.segment;
                        int length = commentRichTextSegmentArr == null ? 0 : commentRichTextSegmentArr.length;
                        CommentRichTextSegment[] commentRichTextSegmentArr2 = new CommentRichTextSegment[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.segment, 0, commentRichTextSegmentArr2, 0, length);
                        }
                        while (length < commentRichTextSegmentArr2.length - 1) {
                            commentRichTextSegmentArr2[length] = new CommentRichTextSegment();
                            codedInputByteBufferNano.readMessage(commentRichTextSegmentArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        commentRichTextSegmentArr2[length] = new CommentRichTextSegment();
                        codedInputByteBufferNano.readMessage(commentRichTextSegmentArr2[length]);
                        this.segment = commentRichTextSegmentArr2;
                        break;
                    case 66:
                        if (this.feedBackground == null) {
                            this.feedBackground = new LiveFeedBackground();
                        }
                        codedInputByteBufferNano.readMessage(this.feedBackground);
                        break;
                    case 74:
                        if (this.tapAction == null) {
                            this.tapAction = new LiveCommentAction.Action();
                        }
                        codedInputByteBufferNano.readMessage(this.tapAction);
                        break;
                    case 82:
                        if (this.longPressAction == null) {
                            this.longPressAction = new LiveCommentAction.Action();
                        }
                        codedInputByteBufferNano.readMessage(this.longPressAction);
                        break;
                    case 88:
                        this.forceShowInCommentList = codedInputByteBufferNano.readBool();
                        break;
                    case 96:
                        this.forceNonDisposable = codedInputByteBufferNano.readBool();
                        break;
                    case 104:
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 104);
                        int[] iArr = new int[repeatedFieldArrayLength2];
                        int i = 0;
                        for (int i2 = 0; i2 < repeatedFieldArrayLength2; i2++) {
                            if (i2 != 0) {
                                codedInputByteBufferNano.readTag();
                            }
                            int int32 = codedInputByteBufferNano.readInt32();
                            if (int32 == 0 || int32 == 1 || int32 == 2) {
                                iArr[i] = int32;
                                i++;
                            }
                        }
                        if (i == 0) {
                            break;
                        } else {
                            int[] iArr2 = this.targetScenes;
                            int length2 = iArr2 == null ? 0 : iArr2.length;
                            if (length2 == 0 && i == repeatedFieldArrayLength2) {
                                this.targetScenes = iArr;
                                break;
                            } else {
                                int[] iArr3 = new int[length2 + i];
                                if (length2 != 0) {
                                    System.arraycopy(this.targetScenes, 0, iArr3, 0, length2);
                                }
                                System.arraycopy(iArr, 0, iArr3, length2, i);
                                this.targetScenes = iArr3;
                                break;
                            }
                        }
                        break;
                    case 106:
                        int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                        int position = codedInputByteBufferNano.getPosition();
                        int i3 = 0;
                        while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                            int int322 = codedInputByteBufferNano.readInt32();
                            if (int322 == 0 || int322 == 1 || int322 == 2) {
                                i3++;
                            }
                        }
                        if (i3 != 0) {
                            codedInputByteBufferNano.rewindToPosition(position);
                            int[] iArr4 = this.targetScenes;
                            int length3 = iArr4 == null ? 0 : iArr4.length;
                            int[] iArr5 = new int[i3 + length3];
                            if (length3 != 0) {
                                System.arraycopy(this.targetScenes, 0, iArr5, 0, length3);
                            }
                            while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                                int int323 = codedInputByteBufferNano.readInt32();
                                if (int323 == 0 || int323 == 1 || int323 == 2) {
                                    iArr5[length3] = int323;
                                    length3++;
                                }
                            }
                            this.targetScenes = iArr5;
                        }
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

        public static CommentRichTextMessage parseFrom(byte[] bArr) {
            return (CommentRichTextMessage) MessageNano.mergeFrom(new CommentRichTextMessage(), bArr);
        }

        public static CommentRichTextMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentRichTextMessage().mergeFrom(codedInputByteBufferNano);
        }
    }
}
