package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.music.nano.MusicProto;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class KtvMusicInfo extends MessageNano {
    private static volatile KtvMusicInfo[] _emptyArray;
    public MusicOrderLrcCdnProto[] lrcUrl;
    public String[] musicArtist;
    public MusicProto.MusicIdentity musicId;
    public String musicIdStr;
    public String musicName;
    public int musicType;

    public static KtvMusicInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new KtvMusicInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public KtvMusicInfo() {
        clear();
    }

    public final KtvMusicInfo clear() {
        this.musicId = null;
        this.lrcUrl = MusicOrderLrcCdnProto.emptyArray();
        this.musicName = "";
        this.musicArtist = WireFormatNano.EMPTY_STRING_ARRAY;
        this.musicIdStr = "";
        this.musicType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        MusicProto.MusicIdentity musicIdentity = this.musicId;
        if (musicIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, musicIdentity);
        }
        MusicOrderLrcCdnProto[] musicOrderLrcCdnProtoArr = this.lrcUrl;
        int i = 0;
        if (musicOrderLrcCdnProtoArr != null && musicOrderLrcCdnProtoArr.length > 0) {
            int i2 = 0;
            while (true) {
                MusicOrderLrcCdnProto[] musicOrderLrcCdnProtoArr2 = this.lrcUrl;
                if (i2 >= musicOrderLrcCdnProtoArr2.length) {
                    break;
                }
                MusicOrderLrcCdnProto musicOrderLrcCdnProto = musicOrderLrcCdnProtoArr2[i2];
                if (musicOrderLrcCdnProto != null) {
                    codedOutputByteBufferNano.writeMessage(2, musicOrderLrcCdnProto);
                }
                i2++;
            }
        }
        if (!this.musicName.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.musicName);
        }
        String[] strArr = this.musicArtist;
        if (strArr != null && strArr.length > 0) {
            while (true) {
                String[] strArr2 = this.musicArtist;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i++;
            }
        }
        if (!this.musicIdStr.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.musicIdStr);
        }
        int i3 = this.musicType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        MusicProto.MusicIdentity musicIdentity = this.musicId;
        if (musicIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, musicIdentity);
        }
        MusicOrderLrcCdnProto[] musicOrderLrcCdnProtoArr = this.lrcUrl;
        int i = 0;
        if (musicOrderLrcCdnProtoArr != null && musicOrderLrcCdnProtoArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                MusicOrderLrcCdnProto[] musicOrderLrcCdnProtoArr2 = this.lrcUrl;
                if (i2 >= musicOrderLrcCdnProtoArr2.length) {
                    break;
                }
                MusicOrderLrcCdnProto musicOrderLrcCdnProto = musicOrderLrcCdnProtoArr2[i2];
                if (musicOrderLrcCdnProto != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, musicOrderLrcCdnProto);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        if (!this.musicName.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.musicName);
        }
        String[] strArr = this.musicArtist;
        if (strArr != null && strArr.length > 0) {
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.musicArtist;
                if (i >= strArr2.length) {
                    break;
                }
                String str = strArr2[i];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
        }
        if (!this.musicIdStr.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.musicIdStr);
        }
        int i4 = this.musicType;
        return i4 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i4) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final KtvMusicInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.musicId == null) {
                    this.musicId = new MusicProto.MusicIdentity();
                }
                codedInputByteBufferNano.readMessage(this.musicId);
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                MusicOrderLrcCdnProto[] musicOrderLrcCdnProtoArr = this.lrcUrl;
                int length = musicOrderLrcCdnProtoArr == null ? 0 : musicOrderLrcCdnProtoArr.length;
                MusicOrderLrcCdnProto[] musicOrderLrcCdnProtoArr2 = new MusicOrderLrcCdnProto[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.lrcUrl, 0, musicOrderLrcCdnProtoArr2, 0, length);
                }
                while (length < musicOrderLrcCdnProtoArr2.length - 1) {
                    musicOrderLrcCdnProtoArr2[length] = new MusicOrderLrcCdnProto();
                    codedInputByteBufferNano.readMessage(musicOrderLrcCdnProtoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                musicOrderLrcCdnProtoArr2[length] = new MusicOrderLrcCdnProto();
                codedInputByteBufferNano.readMessage(musicOrderLrcCdnProtoArr2[length]);
                this.lrcUrl = musicOrderLrcCdnProtoArr2;
            } else if (tag == 26) {
                this.musicName = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                String[] strArr = this.musicArtist;
                int length2 = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.musicArtist, 0, strArr2, 0, length2);
                }
                while (length2 < strArr2.length - 1) {
                    strArr2[length2] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                strArr2[length2] = codedInputByteBufferNano.readString();
                this.musicArtist = strArr2;
            } else if (tag == 42) {
                this.musicIdStr = codedInputByteBufferNano.readString();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
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
            }
        }
    }

    public static KtvMusicInfo parseFrom(byte[] bArr) {
        return (KtvMusicInfo) MessageNano.mergeFrom(new KtvMusicInfo(), bArr);
    }

    public static KtvMusicInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new KtvMusicInfo().mergeFrom(codedInputByteBufferNano);
    }
}
