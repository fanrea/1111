package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveRanklistPendant extends MessageNano {
    private static volatile SCLiveRanklistPendant[] _emptyArray;
    public String[] backgroundColor;
    public String displayRank;
    public boolean enable;
    public UserInfos.PicUrl[] iconPicUrl;
    public int logFirstRankType;
    public int logRankType;
    public String logSecondRankType;
    public int pendantId;
    public UserInfos.PicUrl[] refreshIconPicUrl;
    public int subTabId;
    public int tabId;

    public static SCLiveRanklistPendant[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveRanklistPendant[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveRanklistPendant() {
        clear();
    }

    public final SCLiveRanklistPendant clear() {
        this.enable = false;
        this.pendantId = 0;
        this.tabId = 0;
        this.subTabId = 0;
        this.displayRank = "";
        this.backgroundColor = WireFormatNano.EMPTY_STRING_ARRAY;
        this.iconPicUrl = UserInfos.PicUrl.emptyArray();
        this.logRankType = 0;
        this.logFirstRankType = 0;
        this.logSecondRankType = "";
        this.refreshIconPicUrl = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.enable;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        int i = this.pendantId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        int i2 = this.tabId;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i2);
        }
        int i3 = this.subTabId;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(4, i3);
        }
        if (!this.displayRank.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.displayRank);
        }
        String[] strArr = this.backgroundColor;
        int i4 = 0;
        if (strArr != null && strArr.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.backgroundColor;
                if (i5 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i5];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(6, str);
                }
                i5++;
            }
        }
        UserInfos.PicUrl[] picUrlArr = this.iconPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i6 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconPicUrl;
                if (i6 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i6];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(7, picUrl);
                }
                i6++;
            }
        }
        int i7 = this.logRankType;
        if (i7 != 0) {
            codedOutputByteBufferNano.writeUInt32(8, i7);
        }
        int i8 = this.logFirstRankType;
        if (i8 != 0) {
            codedOutputByteBufferNano.writeInt32(9, i8);
        }
        if (!this.logSecondRankType.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.logSecondRankType);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.refreshIconPicUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.refreshIconPicUrl;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    codedOutputByteBufferNano.writeMessage(11, picUrl2);
                }
                i4++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.enable;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        int i = this.pendantId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        int i2 = this.tabId;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i2);
        }
        int i3 = this.subTabId;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i3);
        }
        if (!this.displayRank.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.displayRank);
        }
        String[] strArr = this.backgroundColor;
        int i4 = 0;
        if (strArr != null && strArr.length > 0) {
            int i5 = 0;
            int iComputeStringSizeNoTag = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = this.backgroundColor;
                if (i5 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i5];
                if (str != null) {
                    i6++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i5++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i6 * 1);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i7 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconPicUrl;
                if (i7 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i7];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(7, picUrl);
                }
                i7++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        int i8 = this.logRankType;
        if (i8 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(8, i8);
        }
        int i9 = this.logFirstRankType;
        if (i9 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(9, i9);
        }
        if (!this.logSecondRankType.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.logSecondRankType);
        }
        UserInfos.PicUrl[] picUrlArr3 = this.refreshIconPicUrl;
        if (picUrlArr3 != null && picUrlArr3.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr4 = this.refreshIconPicUrl;
                if (i4 >= picUrlArr4.length) {
                    break;
                }
                UserInfos.PicUrl picUrl2 = picUrlArr4[i4];
                if (picUrl2 != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(11, picUrl2);
                }
                i4++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveRanklistPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.enable = codedInputByteBufferNano.readBool();
                    break;
                case 16:
                    this.pendantId = codedInputByteBufferNano.readUInt32();
                    break;
                case 24:
                    this.tabId = codedInputByteBufferNano.readUInt32();
                    break;
                case 32:
                    this.subTabId = codedInputByteBufferNano.readUInt32();
                    break;
                case 42:
                    this.displayRank = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    String[] strArr = this.backgroundColor;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.backgroundColor, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.backgroundColor = strArr2;
                    break;
                case 58:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    UserInfos.PicUrl[] picUrlArr = this.iconPicUrl;
                    int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.iconPicUrl, 0, picUrlArr2, 0, length2);
                    }
                    while (length2 < picUrlArr2.length - 1) {
                        picUrlArr2[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    this.iconPicUrl = picUrlArr2;
                    break;
                case 64:
                    this.logRankType = codedInputByteBufferNano.readUInt32();
                    break;
                case 72:
                    this.logFirstRankType = codedInputByteBufferNano.readInt32();
                    break;
                case 82:
                    this.logSecondRankType = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 90);
                    UserInfos.PicUrl[] picUrlArr3 = this.refreshIconPicUrl;
                    int length3 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.refreshIconPicUrl, 0, picUrlArr4, 0, length3);
                    }
                    while (length3 < picUrlArr4.length - 1) {
                        picUrlArr4[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr4[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length3]);
                    this.refreshIconPicUrl = picUrlArr4;
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveRanklistPendant parseFrom(byte[] bArr) {
        return (SCLiveRanklistPendant) MessageNano.mergeFrom(new SCLiveRanklistPendant(), bArr);
    }

    public static SCLiveRanklistPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveRanklistPendant().mergeFrom(codedInputByteBufferNano);
    }
}
