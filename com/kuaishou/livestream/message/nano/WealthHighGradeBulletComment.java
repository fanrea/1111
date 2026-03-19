package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveAudienceState;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class WealthHighGradeBulletComment extends MessageNano {
    private static volatile WealthHighGradeBulletComment[] _emptyArray;
    public String audioControlFileKey;
    public int audioType;
    public CdnUrl[] audioUrl;
    public String comment;
    public int displayType;
    public String extraInfo;
    public LiveAudienceState senderState;
    public UserInfos.UserInfo user;

    @Retention(RetentionPolicy.SOURCE)
    public @interface WealthHighGradeBulletCommentAudioType {
        public static final int AUDIO_CDN_URL = 1;
        public static final int AUDIO_CONTROL_FILE_KEY = 2;
        public static final int NO_AUDIO = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface WealthHighGradeBulletCommentDisplayType {
        public static final int DEFAULT = 0;
        public static final int SHADOW = 1;
    }

    public static final class CdnUrl extends MessageNano {
        private static volatile CdnUrl[] _emptyArray;
        public String cdn;
        public String url;

        public static CdnUrl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CdnUrl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CdnUrl() {
            clear();
        }

        public final CdnUrl clear() {
            this.cdn = "";
            this.url = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.cdn.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.cdn);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.url);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.cdn.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
            }
            return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.url) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CdnUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.cdn = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.url = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CdnUrl parseFrom(byte[] bArr) {
            return (CdnUrl) MessageNano.mergeFrom(new CdnUrl(), bArr);
        }

        public static CdnUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CdnUrl().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static WealthHighGradeBulletComment[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new WealthHighGradeBulletComment[0];
                }
            }
        }
        return _emptyArray;
    }

    public WealthHighGradeBulletComment() {
        clear();
    }

    public final WealthHighGradeBulletComment clear() {
        this.user = null;
        this.comment = "";
        this.senderState = null;
        this.extraInfo = "";
        this.displayType = 0;
        this.audioUrl = CdnUrl.emptyArray();
        this.audioType = 0;
        this.audioControlFileKey = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.comment.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.comment);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(3, liveAudienceState);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.extraInfo);
        }
        int i = this.displayType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        CdnUrl[] cdnUrlArr = this.audioUrl;
        if (cdnUrlArr != null && cdnUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                CdnUrl[] cdnUrlArr2 = this.audioUrl;
                if (i2 >= cdnUrlArr2.length) {
                    break;
                }
                CdnUrl cdnUrl = cdnUrlArr2[i2];
                if (cdnUrl != null) {
                    codedOutputByteBufferNano.writeMessage(6, cdnUrl);
                }
                i2++;
            }
        }
        int i3 = this.audioType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i3);
        }
        if (!this.audioControlFileKey.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.audioControlFileKey);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.comment.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.comment);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveAudienceState);
        }
        if (!this.extraInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.extraInfo);
        }
        int i = this.displayType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        CdnUrl[] cdnUrlArr = this.audioUrl;
        if (cdnUrlArr != null && cdnUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                CdnUrl[] cdnUrlArr2 = this.audioUrl;
                if (i2 >= cdnUrlArr2.length) {
                    break;
                }
                CdnUrl cdnUrl = cdnUrlArr2[i2];
                if (cdnUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, cdnUrl);
                }
                i2++;
            }
        }
        int i3 = this.audioType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i3);
        }
        return !this.audioControlFileKey.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.audioControlFileKey) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final WealthHighGradeBulletComment mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 18) {
                this.comment = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                if (this.senderState == null) {
                    this.senderState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.senderState);
            } else if (tag == 34) {
                this.extraInfo = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.displayType = int32;
                }
            } else if (tag == 50) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                CdnUrl[] cdnUrlArr = this.audioUrl;
                int length = cdnUrlArr == null ? 0 : cdnUrlArr.length;
                CdnUrl[] cdnUrlArr2 = new CdnUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.audioUrl, 0, cdnUrlArr2, 0, length);
                }
                while (length < cdnUrlArr2.length - 1) {
                    cdnUrlArr2[length] = new CdnUrl();
                    codedInputByteBufferNano.readMessage(cdnUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                cdnUrlArr2[length] = new CdnUrl();
                codedInputByteBufferNano.readMessage(cdnUrlArr2[length]);
                this.audioUrl = cdnUrlArr2;
            } else if (tag == 56) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.audioType = int322;
                }
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.audioControlFileKey = codedInputByteBufferNano.readString();
            }
        }
    }

    public static WealthHighGradeBulletComment parseFrom(byte[] bArr) {
        return (WealthHighGradeBulletComment) MessageNano.mergeFrom(new WealthHighGradeBulletComment(), bArr);
    }

    public static WealthHighGradeBulletComment parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new WealthHighGradeBulletComment().mergeFrom(codedInputByteBufferNano);
    }
}
