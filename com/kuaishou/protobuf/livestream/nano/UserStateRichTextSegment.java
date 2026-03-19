package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichText;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class UserStateRichTextSegment extends MessageNano {
    public static final int BADGE_SEGMENT_FIELD_NUMBER = 2;
    public static final int ICON_SEGMENT_FIELD_NUMBER = 1;
    private static volatile UserStateRichTextSegment[] _emptyArray;
    private int entryCase_ = 0;
    private Object entry_;

    public final int getEntryCase() {
        return this.entryCase_;
    }

    public final UserStateRichTextSegment clearEntry() {
        this.entryCase_ = 0;
        this.entry_ = null;
        return this;
    }

    public static UserStateRichTextSegment[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new UserStateRichTextSegment[0];
                }
            }
        }
        return _emptyArray;
    }

    public final boolean hasIconSegment() {
        return this.entryCase_ == 1;
    }

    public final LiveCommentRichText.CommentIconSegment getIconSegment() {
        if (this.entryCase_ == 1) {
            return (LiveCommentRichText.CommentIconSegment) this.entry_;
        }
        return null;
    }

    public final UserStateRichTextSegment setIconSegment(LiveCommentRichText.CommentIconSegment commentIconSegment) {
        if (commentIconSegment == null) {
            throw new NullPointerException();
        }
        this.entryCase_ = 1;
        this.entry_ = commentIconSegment;
        return this;
    }

    public final boolean hasBadgeSegment() {
        return this.entryCase_ == 2;
    }

    public final LiveCommentRichText.CommentBadgeSegment getBadgeSegment() {
        if (this.entryCase_ == 2) {
            return (LiveCommentRichText.CommentBadgeSegment) this.entry_;
        }
        return null;
    }

    public final UserStateRichTextSegment setBadgeSegment(LiveCommentRichText.CommentBadgeSegment commentBadgeSegment) {
        if (commentBadgeSegment == null) {
            throw new NullPointerException();
        }
        this.entryCase_ = 2;
        this.entry_ = commentBadgeSegment;
        return this;
    }

    public UserStateRichTextSegment() {
        clear();
    }

    public final UserStateRichTextSegment clear() {
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
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (this.entryCase_ == 1) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, (MessageNano) this.entry_);
        }
        return this.entryCase_ == 2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, (MessageNano) this.entry_) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final UserStateRichTextSegment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.entryCase_ != 1) {
                    this.entry_ = new LiveCommentRichText.CommentIconSegment();
                }
                codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                this.entryCase_ = 1;
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.entryCase_ != 2) {
                    this.entry_ = new LiveCommentRichText.CommentBadgeSegment();
                }
                codedInputByteBufferNano.readMessage((MessageNano) this.entry_);
                this.entryCase_ = 2;
            }
        }
    }

    public static UserStateRichTextSegment parseFrom(byte[] bArr) {
        return (UserStateRichTextSegment) MessageNano.mergeFrom(new UserStateRichTextSegment(), bArr);
    }

    public static UserStateRichTextSegment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new UserStateRichTextSegment().mergeFrom(codedInputByteBufferNano);
    }
}
