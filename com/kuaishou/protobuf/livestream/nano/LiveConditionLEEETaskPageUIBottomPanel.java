package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichText;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveConditionLEEETaskPageUIBottomPanel extends MessageNano {
    private static volatile LiveConditionLEEETaskPageUIBottomPanel[] _emptyArray;
    public UserInfos.PicUrl[] backgroundPic;
    public boolean enableShow;
    public UserInfos.PicUrl[] rightPic;
    public LiveCommentRichText.CommentTextSegment[] texts;

    public static LiveConditionLEEETaskPageUIBottomPanel[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveConditionLEEETaskPageUIBottomPanel[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveConditionLEEETaskPageUIBottomPanel() {
        clear();
    }

    public final LiveConditionLEEETaskPageUIBottomPanel clear() {
        this.texts = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.enableShow = false;
        this.rightPic = UserInfos.PicUrl.emptyArray();
        this.backgroundPic = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.texts;
        int i = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.texts;
                if (i2 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i2];
                if (commentTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(1, commentTextSegment);
                }
                i2++;
            }
        }
        boolean z = this.enableShow;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.rightPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.rightPic;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i3++;
            }
        }
        UserInfos.PicUrl[] picUrlArr3 = this.backgroundPic;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.backgroundPic;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(4, picUrl2);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.texts;
        int i = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.texts;
                if (i2 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i2];
                if (commentTextSegment != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, commentTextSegment);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        boolean z = this.enableShow;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.rightPic;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.rightPic;
                if (i3 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i3];
                if (picUrl != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        UserInfos.PicUrl[] picUrlArr3 = this.backgroundPic;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.backgroundPic;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, picUrl2);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveConditionLEEETaskPageUIBottomPanel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.texts;
                int length = commentTextSegmentArr == null ? 0 : commentTextSegmentArr.length;
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.texts, 0, commentTextSegmentArr2, 0, length);
                }
                while (length < commentTextSegmentArr2.length - 1) {
                    commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                this.texts = commentTextSegmentArr2;
            } else if (tag == 16) {
                this.enableShow = codedInputByteBufferNano.readBool();
            } else if (tag == 26) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.rightPic;
                int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.rightPic, 0, picUrlArr2, 0, length2);
                }
                while (length2 < picUrlArr2.length - 1) {
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr2[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                this.rightPic = picUrlArr2;
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserInfos.PicUrl[] picUrlArr3 = this.backgroundPic;
                int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.backgroundPic, 0, picUrlArr4, 0, length3);
                }
                while (length3 < picUrlArr4.length - 1) {
                    picUrlArr4[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                picUrlArr4[length3] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                this.backgroundPic = picUrlArr4;
            }
        }
    }

    public static LiveConditionLEEETaskPageUIBottomPanel parseFrom(byte[] bArr) {
        return (LiveConditionLEEETaskPageUIBottomPanel) MessageNano.mergeFrom(new LiveConditionLEEETaskPageUIBottomPanel(), bArr);
    }

    public static LiveConditionLEEETaskPageUIBottomPanel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveConditionLEEETaskPageUIBottomPanel().mergeFrom(codedInputByteBufferNano);
    }
}
