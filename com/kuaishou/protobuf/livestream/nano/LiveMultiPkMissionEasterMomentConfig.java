package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichText;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkMissionEasterMomentConfig extends MessageNano {
    private static volatile LiveMultiPkMissionEasterMomentConfig[] _emptyArray;
    public long easterMomentEndTime;
    public long easterMomentEndTimeoutTime;
    public long easterMomentStartTime;
    public LiveCommentRichText.CommentTextSegment[] easterTips;

    public static LiveMultiPkMissionEasterMomentConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkMissionEasterMomentConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkMissionEasterMomentConfig() {
        clear();
    }

    public final LiveMultiPkMissionEasterMomentConfig clear() {
        this.easterMomentStartTime = 0L;
        this.easterMomentEndTime = 0L;
        this.easterMomentEndTimeoutTime = 0L;
        this.easterTips = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.easterMomentStartTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.easterMomentEndTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.easterMomentEndTimeoutTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.easterTips;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.easterTips;
                if (i >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i];
                if (commentTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(4, commentTextSegment);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.easterMomentStartTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.easterMomentEndTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.easterMomentEndTimeoutTime;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.easterTips;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int i = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.easterTips;
                if (i >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i];
                if (commentTextSegment != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, commentTextSegment);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkMissionEasterMomentConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.easterMomentStartTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.easterMomentEndTime = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.easterMomentEndTimeoutTime = codedInputByteBufferNano.readUInt64();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.easterTips;
                int length = commentTextSegmentArr == null ? 0 : commentTextSegmentArr.length;
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.easterTips, 0, commentTextSegmentArr2, 0, length);
                }
                while (length < commentTextSegmentArr2.length - 1) {
                    commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                this.easterTips = commentTextSegmentArr2;
            }
        }
    }

    public static LiveMultiPkMissionEasterMomentConfig parseFrom(byte[] bArr) {
        return (LiveMultiPkMissionEasterMomentConfig) MessageNano.mergeFrom(new LiveMultiPkMissionEasterMomentConfig(), bArr);
    }

    public static LiveMultiPkMissionEasterMomentConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkMissionEasterMomentConfig().mergeFrom(codedInputByteBufferNano);
    }
}
