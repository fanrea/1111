package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveAudienceState;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GzoneCommentLotteryFeed extends MessageNano {
    private static volatile GzoneCommentLotteryFeed[] _emptyArray;
    public String content;
    public String deviceHash;
    public UserInfos.PicUrl[] iconUrls;
    public String id;
    public long time;
    public UserInfos.UserInfo user;
    public LiveAudienceState userState;

    public static GzoneCommentLotteryFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneCommentLotteryFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public GzoneCommentLotteryFeed() {
        clear();
    }

    public final GzoneCommentLotteryFeed clear() {
        this.id = "";
        this.user = null;
        this.deviceHash = "";
        this.userState = null;
        this.time = 0L;
        this.content = "";
        this.iconUrls = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.id);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, userInfo);
        }
        if (!this.deviceHash.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(4, liveAudienceState);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.content);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrls;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrls;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl);
                }
                i++;
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
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, userInfo);
        }
        if (!this.deviceHash.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.deviceHash);
        }
        LiveAudienceState liveAudienceState = this.userState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveAudienceState);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.content);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconUrls;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconUrls;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, picUrl);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GzoneCommentLotteryFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 26) {
                this.deviceHash = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                if (this.userState == null) {
                    this.userState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.userState);
            } else if (tag == 40) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                UserInfos.PicUrl[] picUrlArr = this.iconUrls;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.iconUrls, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.iconUrls = picUrlArr2;
            }
        }
    }

    public static GzoneCommentLotteryFeed parseFrom(byte[] bArr) {
        return (GzoneCommentLotteryFeed) MessageNano.mergeFrom(new GzoneCommentLotteryFeed(), bArr);
    }

    public static GzoneCommentLotteryFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GzoneCommentLotteryFeed().mergeFrom(codedInputByteBufferNano);
    }
}
