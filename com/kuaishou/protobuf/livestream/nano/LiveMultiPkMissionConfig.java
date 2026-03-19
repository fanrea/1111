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
public final class LiveMultiPkMissionConfig extends MessageNano {
    private static volatile LiveMultiPkMissionConfig[] _emptyArray;
    public long currentCount;
    public LiveCommentRichText.CommentTextSegment[] leftTitleTip;
    public long missionMomentEasterEndTime;
    public long missionMomentEasterEndTimeoutTime;
    public long missionMomentEndTime;
    public long missionMomentStartTime;
    public int pkMissionType;
    public UserInfos.PicUrl[] processWebp;
    public LiveCommentRichText.CommentTextSegment[] progressDetailText;
    public UserInfos.PicUrl[] startWebp;
    public long targetCount;
    public String tipClickContent;
    public int toastLimitTimes;

    public static LiveMultiPkMissionConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkMissionConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkMissionConfig() {
        clear();
    }

    public final LiveMultiPkMissionConfig clear() {
        this.missionMomentStartTime = 0L;
        this.missionMomentEndTime = 0L;
        this.missionMomentEasterEndTime = 0L;
        this.missionMomentEasterEndTimeoutTime = 0L;
        this.progressDetailText = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.leftTitleTip = LiveCommentRichText.CommentTextSegment.emptyArray();
        this.targetCount = 0L;
        this.currentCount = 0L;
        this.tipClickContent = "";
        this.startWebp = UserInfos.PicUrl.emptyArray();
        this.processWebp = UserInfos.PicUrl.emptyArray();
        this.pkMissionType = 0;
        this.toastLimitTimes = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.missionMomentStartTime;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        long j2 = this.missionMomentEndTime;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j2);
        }
        long j3 = this.missionMomentEasterEndTime;
        if (j3 != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j3);
        }
        long j4 = this.missionMomentEasterEndTimeoutTime;
        if (j4 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j4);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.progressDetailText;
        int i = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.progressDetailText;
                if (i2 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i2];
                if (commentTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(5, commentTextSegment);
                }
                i2++;
            }
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.leftTitleTip;
        if (commentTextSegmentArr3 != null && commentTextSegmentArr3.length > 0) {
            int i3 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = this.leftTitleTip;
                if (i3 >= commentTextSegmentArr4.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment2 = commentTextSegmentArr4[i3];
                if (commentTextSegment2 != null) {
                    codedOutputByteBufferNano.writeMessage(6, commentTextSegment2);
                }
                i3++;
            }
        }
        long j5 = this.targetCount;
        if (j5 != 0) {
            codedOutputByteBufferNano.writeUInt64(7, j5);
        }
        long j6 = this.currentCount;
        if (j6 != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j6);
        }
        if (!this.tipClickContent.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.tipClickContent);
        }
        UserInfos.PicUrl[] picUrlArr = this.startWebp;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.startWebp;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(10, picUrl);
                }
                i4++;
            }
        }
        UserInfos.PicUrl[] picUrlArr3 = this.processWebp;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.processWebp;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(11, picUrl2);
                }
                i++;
            }
        }
        int i5 = this.pkMissionType;
        if (i5 != 0) {
            codedOutputByteBufferNano.writeUInt32(12, i5);
        }
        int i6 = this.toastLimitTimes;
        if (i6 != 0) {
            codedOutputByteBufferNano.writeUInt32(13, i6);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.missionMomentStartTime;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        long j2 = this.missionMomentEndTime;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
        }
        long j3 = this.missionMomentEasterEndTime;
        if (j3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
        }
        long j4 = this.missionMomentEasterEndTimeoutTime;
        if (j4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j4);
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.progressDetailText;
        int i = 0;
        if (commentTextSegmentArr != null && commentTextSegmentArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = this.progressDetailText;
                if (i2 >= commentTextSegmentArr2.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment = commentTextSegmentArr2[i2];
                if (commentTextSegment != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(5, commentTextSegment);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.leftTitleTip;
        if (commentTextSegmentArr3 != null && commentTextSegmentArr3.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = this.leftTitleTip;
                if (i3 >= commentTextSegmentArr4.length) {
                    break;
                }
                LiveCommentRichText.CommentTextSegment commentTextSegment2 = commentTextSegmentArr4[i3];
                if (commentTextSegment2 != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(6, commentTextSegment2);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        long j5 = this.targetCount;
        if (j5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(7, j5);
        }
        long j6 = this.currentCount;
        if (j6 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j6);
        }
        if (!this.tipClickContent.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.tipClickContent);
        }
        UserInfos.PicUrl[] picUrlArr = this.startWebp;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize3 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.startWebp;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    iComputeMessageSize3 += CodedOutputByteBufferNano.computeMessageSize(10, picUrl);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize3;
        }
        UserInfos.PicUrl[] picUrlArr3 = this.processWebp;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.processWebp;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, picUrl2);
                }
                i++;
            }
        }
        int i5 = this.pkMissionType;
        if (i5 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(12, i5);
        }
        int i6 = this.toastLimitTimes;
        return i6 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(13, i6) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkMissionConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.missionMomentStartTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 16:
                    this.missionMomentEndTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 24:
                    this.missionMomentEasterEndTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 32:
                    this.missionMomentEasterEndTimeoutTime = codedInputByteBufferNano.readUInt64();
                    break;
                case 42:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr = this.progressDetailText;
                    int length = commentTextSegmentArr == null ? 0 : commentTextSegmentArr.length;
                    LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr2 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.progressDetailText, 0, commentTextSegmentArr2, 0, length);
                    }
                    while (length < commentTextSegmentArr2.length - 1) {
                        commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                        codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    commentTextSegmentArr2[length] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr2[length]);
                    this.progressDetailText = commentTextSegmentArr2;
                    break;
                case 50:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr3 = this.leftTitleTip;
                    int length2 = commentTextSegmentArr3 == null ? 0 : commentTextSegmentArr3.length;
                    LiveCommentRichText.CommentTextSegment[] commentTextSegmentArr4 = new LiveCommentRichText.CommentTextSegment[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.leftTitleTip, 0, commentTextSegmentArr4, 0, length2);
                    }
                    while (length2 < commentTextSegmentArr4.length - 1) {
                        commentTextSegmentArr4[length2] = new LiveCommentRichText.CommentTextSegment();
                        codedInputByteBufferNano.readMessage(commentTextSegmentArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    commentTextSegmentArr4[length2] = new LiveCommentRichText.CommentTextSegment();
                    codedInputByteBufferNano.readMessage(commentTextSegmentArr4[length2]);
                    this.leftTitleTip = commentTextSegmentArr4;
                    break;
                case 56:
                    this.targetCount = codedInputByteBufferNano.readUInt64();
                    break;
                case 64:
                    this.currentCount = codedInputByteBufferNano.readUInt64();
                    break;
                case 74:
                    this.tipClickContent = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 82);
                    UserInfos.PicUrl[] picUrlArr = this.startWebp;
                    int length3 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.startWebp, 0, picUrlArr2, 0, length3);
                    }
                    while (length3 < picUrlArr2.length - 1) {
                        picUrlArr2[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr2[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length3]);
                    this.startWebp = picUrlArr2;
                    break;
                case 90:
                    int repeatedFieldArrayLength4 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    UserInfos.PicUrl[] picUrlArr3 = this.processWebp;
                    int length4 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength4 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.processWebp, 0, picUrlArr4, 0, length4);
                    }
                    while (length4 < picUrlArr4.length - 1) {
                        picUrlArr4[length4] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length4]);
                        codedInputByteBufferNano.readTag();
                        length4++;
                    }
                    picUrlArr4[length4] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length4]);
                    this.processWebp = picUrlArr4;
                    break;
                case 96:
                    this.pkMissionType = codedInputByteBufferNano.readUInt32();
                    break;
                case 104:
                    this.toastLimitTimes = codedInputByteBufferNano.readUInt32();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveMultiPkMissionConfig parseFrom(byte[] bArr) {
        return (LiveMultiPkMissionConfig) MessageNano.mergeFrom(new LiveMultiPkMissionConfig(), bArr);
    }

    public static LiveMultiPkMissionConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkMissionConfig().mergeFrom(codedInputByteBufferNano);
    }
}
