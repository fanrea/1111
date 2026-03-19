package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichText;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkMissionStartConfig extends MessageNano {
    private static volatile LiveMultiPkMissionStartConfig[] _emptyArray;
    public int pkMissionType;
    public LiveCommentRichText.CommentTextSegment[] previewSubTip;
    public LiveCommentRichText.CommentTextSegment[] previewTip;

    public static LiveMultiPkMissionStartConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkMissionStartConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkMissionStartConfig() {
        clear();
    }

    public final LiveMultiPkMissionStartConfig clear() {
        this.pkMissionType = 0;
        this.previewTip = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.previewSubTip = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.pkMissionType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.previewTip;
        int i2 = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int i3 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.previewTip;
                if (i3 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i3];
                if (commentTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(2, commentTextSegment);
                }
                i3++;
            }
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.previewSubTip;
        if (commentTextSegmentArr3 != null && commentTextSegmentArr3.length > 0) {
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = this.previewSubTip;
                if (i2 >= commentTextSegmentArr4.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment2 = commentTextSegmentArr4[i2];
                if (commentTextSegment2 != null) {
                    codedOutputByteBufferNano.writeMessage(3, commentTextSegment2);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.pkMissionType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.previewTip;
        int i2 = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.previewTip;
                if (i3 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i3];
                if (commentTextSegment != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, commentTextSegment);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.previewSubTip;
        if (commentTextSegmentArr3 != null && commentTextSegmentArr3.length > 0) {
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = this.previewSubTip;
                if (i2 >= commentTextSegmentArr4.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment2 = commentTextSegmentArr4[i2];
                if (commentTextSegment2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, commentTextSegment2);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkMissionStartConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.pkMissionType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.previewTip;
                int length = commentTextSegmentArr == null ? 0 : commentTextSegmentArr.length;
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.previewTip, 0, commentTextSegmentArr2, 0, length);
                }
                while (length < commentTextSegmentArr2.length - 1) {
                    commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                this.previewTip = commentTextSegmentArr2;
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.previewSubTip;
                int length2 = commentTextSegmentArr3 == null ? 0 : commentTextSegmentArr3.length;
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.previewSubTip, 0, commentTextSegmentArr4, 0, length2);
                }
                while (length2 < commentTextSegmentArr4.length - 1) {
                    commentTextSegmentArr4[length2] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                commentTextSegmentArr4[length2] = new LiveCommentRichText.CommentTextSegment();
                codedInputByteBufferNano.readMessage(commentTextSegmentArr4[length2]);
                this.previewSubTip = commentTextSegmentArr4;
            }
        }
    }

    public static LiveMultiPkMissionStartConfig parseFrom(byte[] bArr) {
        return (LiveMultiPkMissionStartConfig) MessageNano.mergeFrom(new LiveMultiPkMissionStartConfig(), bArr);
    }

    public static LiveMultiPkMissionStartConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkMissionStartConfig().mergeFrom(codedInputByteBufferNano);
    }
}
