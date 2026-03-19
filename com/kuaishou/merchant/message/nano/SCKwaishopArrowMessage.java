package com.kuaishou.merchant.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCKwaishopArrowMessage extends MessageNano {
    private static volatile SCKwaishopArrowMessage[] _emptyArray;
    public int arrowType;
    public String authorId;
    public String expTag;
    public UserInfos.PicUrl[] itemCdnImgUrl;
    public String itemDesc;
    public String itemId;
    public String itemTitle;
    public String purchaseCopywriting;
    public String serverExpTag;
    public String targetLiveStreamId;
    public String[] targetLiveStreamImg;

    public static SCKwaishopArrowMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCKwaishopArrowMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCKwaishopArrowMessage() {
        clear();
    }

    public final SCKwaishopArrowMessage clear() {
        this.arrowType = 0;
        this.targetLiveStreamId = "";
        this.targetLiveStreamImg = WireFormatNano.EMPTY_STRING_ARRAY;
        this.authorId = "";
        this.itemId = "";
        this.itemTitle = "";
        this.itemDesc = "";
        this.itemCdnImgUrl = UserInfos.PicUrl.emptyArray();
        this.purchaseCopywriting = "";
        this.serverExpTag = "";
        this.expTag = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.arrowType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.targetLiveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.targetLiveStreamId);
        }
        String[] strArr = this.targetLiveStreamImg;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.targetLiveStreamImg;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(3, str);
                }
                i3++;
            }
        }
        if (!this.authorId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.authorId);
        }
        if (!this.itemId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.itemId);
        }
        if (!this.itemTitle.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.itemTitle);
        }
        if (!this.itemDesc.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.itemDesc);
        }
        UserInfos.PicUrl[] picUrlArr = this.itemCdnImgUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.itemCdnImgUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(8, picUrl);
                }
                i2++;
            }
        }
        if (!this.purchaseCopywriting.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.purchaseCopywriting);
        }
        if (!this.serverExpTag.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.serverExpTag);
        }
        if (!this.expTag.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.expTag);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.arrowType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.targetLiveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.targetLiveStreamId);
        }
        String[] strArr = this.targetLiveStreamImg;
        int i2 = 0;
        if (strArr != null && strArr.length > 0) {
            int i3 = 0;
            int iComputeStringSizeNoTag = 0;
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.targetLiveStreamImg;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i3];
                if (str != null) {
                    i4++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i3++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i4 * 1);
        }
        if (!this.authorId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.authorId);
        }
        if (!this.itemId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.itemId);
        }
        if (!this.itemTitle.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.itemTitle);
        }
        if (!this.itemDesc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.itemDesc);
        }
        UserInfos.PicUrl[] picUrlArr = this.itemCdnImgUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.itemCdnImgUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, picUrl);
                }
                i2++;
            }
        }
        if (!this.purchaseCopywriting.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.purchaseCopywriting);
        }
        if (!this.serverExpTag.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.serverExpTag);
        }
        return !this.expTag.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(11, this.expTag) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCKwaishopArrowMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.arrowType = int32;
                        break;
                    }
                    break;
                case 18:
                    this.targetLiveStreamId = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    String[] strArr = this.targetLiveStreamImg;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.targetLiveStreamImg, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.targetLiveStreamImg = strArr2;
                    break;
                case 34:
                    this.authorId = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.itemId = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    this.itemTitle = codedInputByteBufferNano.readString();
                    break;
                case 58:
                    this.itemDesc = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 66);
                    UserInfos.PicUrl[] picUrlArr = this.itemCdnImgUrl;
                    int length2 = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.itemCdnImgUrl, 0, picUrlArr2, 0, length2);
                    }
                    while (length2 < picUrlArr2.length - 1) {
                        picUrlArr2[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr2[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length2]);
                    this.itemCdnImgUrl = picUrlArr2;
                    break;
                case 74:
                    this.purchaseCopywriting = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.serverExpTag = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.expTag = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCKwaishopArrowMessage parseFrom(byte[] bArr) {
        return (SCKwaishopArrowMessage) MessageNano.mergeFrom(new SCKwaishopArrowMessage(), bArr);
    }

    public static SCKwaishopArrowMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCKwaishopArrowMessage().mergeFrom(codedInputByteBufferNano);
    }
}
