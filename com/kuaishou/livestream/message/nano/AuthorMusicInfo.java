package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AuthorMusicInfo extends MessageNano {
    private static volatile AuthorMusicInfo[] _emptyArray;
    public UserInfos.PicUrl[] imageUrl;
    public AuthorMusicLrcCdnProto[] lrcUrl;
    public String[] musicArtist;
    public String musicId;
    public String musicName;
    public int musicType;

    public static AuthorMusicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AuthorMusicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public AuthorMusicInfo() {
        clear();
    }

    public final AuthorMusicInfo clear() {
        this.musicId = "";
        this.musicType = 0;
        this.lrcUrl = AuthorMusicLrcCdnProto.emptyArray();
        this.imageUrl = UserInfos.PicUrl.emptyArray();
        this.musicName = "";
        this.musicArtist = WireFormatNano.EMPTY_STRING_ARRAY;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.musicId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.musicId);
        }
        int i = this.musicType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        AuthorMusicLrcCdnProto[] authorMusicLrcCdnProtoArr = this.lrcUrl;
        int i2 = 0;
        if (authorMusicLrcCdnProtoArr != null && authorMusicLrcCdnProtoArr.length > 0) {
            int i3 = 0;
            while (true) {
                AuthorMusicLrcCdnProto[] authorMusicLrcCdnProtoArr2 = this.lrcUrl;
                if (i3 >= authorMusicLrcCdnProtoArr2.length) {
                    break;
                }
                AuthorMusicLrcCdnProto authorMusicLrcCdnProto = authorMusicLrcCdnProtoArr2[i3];
                if (authorMusicLrcCdnProto != null) {
                    codedOutputByteBufferNano.writeMessage(3, authorMusicLrcCdnProto);
                }
                i3++;
            }
        }
        UserInfos.PicUrl[] picUrlArr = this.imageUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(4, picUrl);
                }
                i4++;
            }
        }
        if (!this.musicName.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.musicName);
        }
        String[] strArr = this.musicArtist;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.musicArtist;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.musicId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.musicId);
        }
        int i = this.musicType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        AuthorMusicLrcCdnProto[] authorMusicLrcCdnProtoArr = this.lrcUrl;
        int i2 = 0;
        if (authorMusicLrcCdnProtoArr != null && authorMusicLrcCdnProtoArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i3 = 0;
            while (true) {
                AuthorMusicLrcCdnProto[] authorMusicLrcCdnProtoArr2 = this.lrcUrl;
                if (i3 >= authorMusicLrcCdnProtoArr2.length) {
                    break;
                }
                AuthorMusicLrcCdnProto authorMusicLrcCdnProto = authorMusicLrcCdnProtoArr2[i3];
                if (authorMusicLrcCdnProto != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(3, authorMusicLrcCdnProto);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        UserInfos.PicUrl[] picUrlArr = this.imageUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize2 = iComputeSerializedSize;
            int i4 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                if (i4 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i4];
                if (picUrl != null) {
                    iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(4, picUrl);
                }
                i4++;
            }
            iComputeSerializedSize = iComputeMessageSize2;
        }
        if (!this.musicName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.musicName);
        }
        String[] strArr = this.musicArtist;
        if (strArr == null || strArr.length <= 0) {
            return iComputeSerializedSize;
        }
        int iComputeStringSizeNoTag = 0;
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.musicArtist;
            if (i2 >= strArr2.length) {
                return iComputeSerializedSize + iComputeStringSizeNoTag + (i5 * 1);
            }
            String str = strArr2[i2];
            if (str != null) {
                i5++;
                iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
            }
            i2++;
        }
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final AuthorMusicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.musicId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                    case 10:
                    case 11:
                        this.musicType = int32;
                        break;
                }
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                AuthorMusicLrcCdnProto[] authorMusicLrcCdnProtoArr = this.lrcUrl;
                int length = authorMusicLrcCdnProtoArr == null ? 0 : authorMusicLrcCdnProtoArr.length;
                AuthorMusicLrcCdnProto[] authorMusicLrcCdnProtoArr2 = new AuthorMusicLrcCdnProto[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.lrcUrl, 0, authorMusicLrcCdnProtoArr2, 0, length);
                }
                while (length < authorMusicLrcCdnProtoArr2.length - 1) {
                    authorMusicLrcCdnProtoArr2[length] = new AuthorMusicLrcCdnProto();
                    codedInputByteBufferNano.readMessage(authorMusicLrcCdnProtoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                authorMusicLrcCdnProtoArr2[length] = new AuthorMusicLrcCdnProto();
                codedInputByteBufferNano.readMessage(authorMusicLrcCdnProtoArr2[length]);
                this.lrcUrl = authorMusicLrcCdnProtoArr2;
            } else if (tag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                UserInfos.PicUrl[] picUrlArr = this.imageUrl;
                int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.imageUrl, 0, picUrlArr2, 0, length2);
                }
                while (length2 < picUrlArr2.length - 1) {
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                picUrlArr2[length2] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                this.imageUrl = picUrlArr2;
            } else if (tag == 42) {
                this.musicName = codedInputByteBufferNano.readString();
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                String[] strArr = this.musicArtist;
                int length3 = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength3 + length3];
                if (length3 != 0) {
                    System.arraycopy(this.musicArtist, 0, strArr2, 0, length3);
                }
                while (length3 < strArr2.length - 1) {
                    strArr2[length3] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length3++;
                }
                strArr2[length3] = codedInputByteBufferNano.readString();
                this.musicArtist = strArr2;
            }
        }
    }

    public static AuthorMusicInfo parseFrom(byte[] bArr) {
        return (AuthorMusicInfo) MessageNano.mergeFrom(new AuthorMusicInfo(), bArr);
    }

    public static AuthorMusicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new AuthorMusicInfo().mergeFrom(codedInputByteBufferNano);
    }
}
