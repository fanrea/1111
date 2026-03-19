package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class GzoneInteractiveCommentNotice extends MessageNano {
    private static volatile GzoneInteractiveCommentNotice[] _emptyArray;
    public String commentBgcolorL;
    public String commentBgcolorR;
    public String commentColor;
    public String commentText;
    public long displayDurationMs;
    public String id;
    public UserInfos.PicUrl[] roleHeadUrl;
    public String roleName;
    public int roleType;

    public static GzoneInteractiveCommentNotice[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new GzoneInteractiveCommentNotice[0];
                }
            }
        }
        return _emptyArray;
    }

    public GzoneInteractiveCommentNotice() {
        clear();
    }

    public final GzoneInteractiveCommentNotice clear() {
        this.roleType = 0;
        this.roleName = "";
        this.roleHeadUrl = UserInfos.PicUrl.emptyArray();
        this.commentText = "";
        this.commentColor = "";
        this.commentBgcolorL = "";
        this.commentBgcolorR = "";
        this.displayDurationMs = 0L;
        this.id = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.roleType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.roleName.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.roleName);
        }
        UserInfos.PicUrl[] picUrlArr = this.roleHeadUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.roleHeadUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i2++;
            }
        }
        if (!this.commentText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.commentText);
        }
        if (!this.commentColor.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.commentColor);
        }
        if (!this.commentBgcolorL.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.commentBgcolorL);
        }
        if (!this.commentBgcolorR.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.commentBgcolorR);
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(8, j);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.id);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.roleType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.roleName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.roleName);
        }
        UserInfos.PicUrl[] picUrlArr = this.roleHeadUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.roleHeadUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i2++;
            }
        }
        if (!this.commentText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.commentText);
        }
        if (!this.commentColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.commentColor);
        }
        if (!this.commentBgcolorL.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.commentBgcolorL);
        }
        if (!this.commentBgcolorR.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.commentBgcolorR);
        }
        long j = this.displayDurationMs;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(8, j);
        }
        return !this.id.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.id) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final GzoneInteractiveCommentNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.roleType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                this.roleName = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.roleHeadUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.roleHeadUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.roleHeadUrl = picUrlArr2;
            } else if (tag == 34) {
                this.commentText = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.commentColor = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                this.commentBgcolorL = codedInputByteBufferNano.readString();
            } else if (tag == 58) {
                this.commentBgcolorR = codedInputByteBufferNano.readString();
            } else if (tag == 64) {
                this.displayDurationMs = codedInputByteBufferNano.readUInt64();
            } else if (tag != 74) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.id = codedInputByteBufferNano.readString();
            }
        }
    }

    public static GzoneInteractiveCommentNotice parseFrom(byte[] bArr) {
        return (GzoneInteractiveCommentNotice) MessageNano.mergeFrom(new GzoneInteractiveCommentNotice(), bArr);
    }

    public static GzoneInteractiveCommentNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new GzoneInteractiveCommentNotice().mergeFrom(codedInputByteBufferNano);
    }
}
