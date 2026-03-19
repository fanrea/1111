package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCommentRichTextMessage;
import com.kuaishou.protobuf.livestream.nano.LiveUiMarkLabel;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftNamingDisplayInfo extends MessageNano {
    private static volatile LiveGiftNamingDisplayInfo[] _emptyArray;
    public String actionUrl;
    public String buttonActionUrl;
    public String buttonText;
    public UserInfos.PicUrl[] icon;
    public LiveUiMarkLabel markLabel;
    public UserInfos.PicUrl[] rightIcon;
    public LiveCommentRichTextMessage.CommentRichTextMessage text;

    public static LiveGiftNamingDisplayInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftNamingDisplayInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftNamingDisplayInfo() {
        clear();
    }

    public final LiveGiftNamingDisplayInfo clear() {
        this.actionUrl = "";
        this.icon = UserInfos.PicUrl.emptyArray();
        this.markLabel = null;
        this.text = null;
        this.buttonText = "";
        this.rightIcon = UserInfos.PicUrl.emptyArray();
        this.buttonActionUrl = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.actionUrl.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.actionUrl);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(2, picUrl);
                }
                i2++;
            }
        }
        LiveUiMarkLabel liveUiMarkLabel = this.markLabel;
        if (liveUiMarkLabel != null) {
            codedOutputByteBufferNano.writeMessage(3, liveUiMarkLabel);
        }
        LiveCommentRichTextMessage.CommentRichTextMessage commentRichTextMessage = this.text;
        if (commentRichTextMessage != null) {
            codedOutputByteBufferNano.writeMessage(4, commentRichTextMessage);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.buttonText);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.rightIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.rightIcon;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(6, picUrl2);
                }
                i++;
            }
        }
        if (!this.buttonActionUrl.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.buttonActionUrl);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.actionUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.actionUrl);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        LiveUiMarkLabel liveUiMarkLabel = this.markLabel;
        if (liveUiMarkLabel != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveUiMarkLabel);
        }
        LiveCommentRichTextMessage.CommentRichTextMessage commentRichTextMessage = this.text;
        if (commentRichTextMessage != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, commentRichTextMessage);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.buttonText);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.rightIcon;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.rightIcon;
                if (i >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl2);
                }
                i++;
            }
        }
        return !this.buttonActionUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.buttonActionUrl) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftNamingDisplayInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.actionUrl = codedInputByteBufferNano.readString();
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserInfos.PicUrl[] picUrlArr = this.icon;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.icon = picUrlArr2;
            } else if (tag == 26) {
                if (this.markLabel == null) {
                    this.markLabel = new LiveUiMarkLabel();
                }
                codedInputByteBufferNano.readMessage(this.markLabel);
            } else if (tag == 34) {
                if (this.text == null) {
                    this.text = new LiveCommentRichTextMessage.CommentRichTextMessage();
                }
                codedInputByteBufferNano.readMessage(this.text);
            } else if (tag == 42) {
                this.buttonText = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                UserInfos.PicUrl[] picUrlArr3 = this.rightIcon;
                int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.rightIcon, 0, picUrlArr4, 0, length2);
                }
                while (length2 < picUrlArr4.length - 1) {
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr4[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                this.rightIcon = picUrlArr4;
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.buttonActionUrl = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveGiftNamingDisplayInfo parseFrom(byte[] bArr) {
        return (LiveGiftNamingDisplayInfo) MessageNano.mergeFrom(new LiveGiftNamingDisplayInfo(), bArr);
    }

    public static LiveGiftNamingDisplayInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftNamingDisplayInfo().mergeFrom(codedInputByteBufferNano);
    }
}
