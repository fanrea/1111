package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichText;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkMissionEasterMomentResult extends MessageNano {
    private static volatile LiveMultiPkMissionEasterMomentResult[] _emptyArray;
    public boolean isPublish;
    public boolean isUpper;
    public LiveCommentRichText.CommentTextSegment[] publishTips;
    public LiveCommentRichText.CommentTextSegment[] upperTips;

    public static LiveMultiPkMissionEasterMomentResult[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkMissionEasterMomentResult[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkMissionEasterMomentResult() {
        clear();
    }

    public final LiveMultiPkMissionEasterMomentResult clear() {
        this.isPublish = false;
        this.upperTips = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.publishTips = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.isUpper = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isPublish;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.upperTips;
        int i = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.upperTips;
                if (i2 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i2];
                if (commentTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(2, commentTextSegment);
                }
                i2++;
            }
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.publishTips;
        if (commentTextSegmentArr3 != null && commentTextSegmentArr3.length > 0) {
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = this.publishTips;
                if (i >= commentTextSegmentArr4.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment2 = commentTextSegmentArr4[i];
                if (commentTextSegment2 != null) {
                    codedOutputByteBufferNano.writeMessage(3, commentTextSegment2);
                }
                i++;
            }
        }
        boolean z2 = this.isUpper;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isPublish;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.upperTips;
        int i = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.upperTips;
                if (i2 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i2];
                if (commentTextSegment != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, commentTextSegment);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.publishTips;
        if (commentTextSegmentArr3 != null && commentTextSegmentArr3.length > 0) {
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = this.publishTips;
                if (i >= commentTextSegmentArr4.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment2 = commentTextSegmentArr4[i];
                if (commentTextSegment2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, commentTextSegment2);
                }
                i++;
            }
        }
        boolean z2 = this.isUpper;
        return z2 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(4, z2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkMissionEasterMomentResult mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.isPublish = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.upperTips;
                int length = commentTextSegmentArr == null ? 0 : commentTextSegmentArr.length;
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.upperTips, 0, commentTextSegmentArr2, 0, length);
                }
                while (length < commentTextSegmentArr2.length - 1) {
                    commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                this.upperTips = commentTextSegmentArr2;
            } else if (tag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.publishTips;
                int length2 = commentTextSegmentArr3 == null ? 0 : commentTextSegmentArr3.length;
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.publishTips, 0, commentTextSegmentArr4, 0, length2);
                }
                while (length2 < commentTextSegmentArr4.length - 1) {
                    commentTextSegmentArr4[length2] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                commentTextSegmentArr4[length2] = new LiveCommentRichText.CommentTextSegment();
                codedInputByteBufferNano.readMessage(commentTextSegmentArr4[length2]);
                this.publishTips = commentTextSegmentArr4;
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.isUpper = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveMultiPkMissionEasterMomentResult parseFrom(byte[] bArr) {
        return (LiveMultiPkMissionEasterMomentResult) MessageNano.mergeFrom(new LiveMultiPkMissionEasterMomentResult(), bArr);
    }

    public static LiveMultiPkMissionEasterMomentResult parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkMissionEasterMomentResult().mergeFrom(codedInputByteBufferNano);
    }
}
