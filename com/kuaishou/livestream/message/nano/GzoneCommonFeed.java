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
public final class GzoneCommonFeed extends MessageNano {
    private static volatile GzoneCommonFeed[] _emptyArray;
    public int bizType;
    public CommentFeedButton button;
    public String content;
    public String extra;
    public String id;
    public LiveAudienceState senderState;
    public int type;
    public UserInfos.UserInfo user;

    public static final class CommentFeedButton extends MessageNano {
        private static volatile CommentFeedButton[] _emptyArray;
        public String text;
        public String url;

        public static CommentFeedButton[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CommentFeedButton[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CommentFeedButton() {
            clear();
        }

        public final CommentFeedButton clear() {
            this.text = "";
            this.url = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.url);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            return !this.url.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.url) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final CommentFeedButton mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.url = codedInputByteBufferNano.readString();
                }
            }
        }

        public static CommentFeedButton parseFrom(byte[] bArr) {
            return (CommentFeedButton) MessageNano.mergeFrom(new CommentFeedButton(), bArr);
        }

        public static CommentFeedButton parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new CommentFeedButton().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static GzoneCommonFeed[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneCommonFeed[0];
                }
            }
        }
        return _emptyArray;
    }

    public GzoneCommonFeed() {
        clear();
    }

    public final GzoneCommonFeed clear() {
        this.type = 0;
        this.bizType = 0;
        this.user = null;
        this.senderState = null;
        this.button = null;
        this.content = "";
        this.extra = "";
        this.id = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.bizType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, userInfo);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            codedOutputByteBufferNano.writeMessage(4, liveAudienceState);
        }
        CommentFeedButton commentFeedButton = this.button;
        if (commentFeedButton != null) {
            codedOutputByteBufferNano.writeMessage(5, commentFeedButton);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.content);
        }
        if (!this.extra.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.extra);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.id);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.bizType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        UserInfos.UserInfo userInfo = this.user;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
        }
        LiveAudienceState liveAudienceState = this.senderState;
        if (liveAudienceState != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveAudienceState);
        }
        CommentFeedButton commentFeedButton = this.button;
        if (commentFeedButton != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, commentFeedButton);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.content);
        }
        if (!this.extra.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.extra);
        }
        return !this.id.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.id) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GzoneCommonFeed mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.bizType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                if (this.user == null) {
                    this.user = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.user);
            } else if (tag == 34) {
                if (this.senderState == null) {
                    this.senderState = new LiveAudienceState();
                }
                codedInputByteBufferNano.readMessage(this.senderState);
            } else if (tag == 42) {
                if (this.button == null) {
                    this.button = new CommentFeedButton();
                }
                codedInputByteBufferNano.readMessage(this.button);
            } else if (tag == 50) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 58) {
                this.extra = codedInputByteBufferNano.readString();
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.id = codedInputByteBufferNano.readString();
            }
        }
    }

    public static GzoneCommonFeed parseFrom(byte[] bArr) {
        return (GzoneCommonFeed) MessageNano.mergeFrom(new GzoneCommonFeed(), bArr);
    }

    public static GzoneCommonFeed parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GzoneCommonFeed().mergeFrom(codedInputByteBufferNano);
    }
}
