package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PopularityRankImpetusPendantFold extends MessageNano {
    private static volatile PopularityRankImpetusPendantFold[] _emptyArray;
    public UserInfos.PicUrl[] backgroundPicUrl;
    public ImpetusPendantContentWithStyle[] foldMessage;
    public PopularityRankImpetusPendantTitleInfo titleInfo;

    public static PopularityRankImpetusPendantFold[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PopularityRankImpetusPendantFold[0];
                }
            }
        }
        return _emptyArray;
    }

    public PopularityRankImpetusPendantFold() {
        clear();
    }

    public final PopularityRankImpetusPendantFold clear() {
        this.backgroundPicUrl = UserInfos.PicUrl.emptyArray();
        this.foldMessage = ImpetusPendantContentWithStyle.emptyArray();
        this.titleInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(1, picUrl);
                }
                i2++;
            }
        }
        ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr = this.foldMessage;
        if (impetusPendantContentWithStyleArr != null && impetusPendantContentWithStyleArr.length > 0) {
            while (true) {
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr2 = this.foldMessage;
                if (i >= impetusPendantContentWithStyleArr2.length) {
                    break;
                }
                ImpetusPendantContentWithStyle impetusPendantContentWithStyle = impetusPendantContentWithStyleArr2[i];
                if (impetusPendantContentWithStyle != null) {
                    codedOutputByteBufferNano.writeMessage(2, impetusPendantContentWithStyle);
                }
                i++;
            }
        }
        PopularityRankImpetusPendantTitleInfo popularityRankImpetusPendantTitleInfo = this.titleInfo;
        if (popularityRankImpetusPendantTitleInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, popularityRankImpetusPendantTitleInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
        int i = 0;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int iComputeMessageSize = iComputeSerializedSize;
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.backgroundPicUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeMessageSize;
        }
        ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr = this.foldMessage;
        if (impetusPendantContentWithStyleArr != null && impetusPendantContentWithStyleArr.length > 0) {
            while (true) {
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr2 = this.foldMessage;
                if (i >= impetusPendantContentWithStyleArr2.length) {
                    break;
                }
                ImpetusPendantContentWithStyle impetusPendantContentWithStyle = impetusPendantContentWithStyleArr2[i];
                if (impetusPendantContentWithStyle != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, impetusPendantContentWithStyle);
                }
                i++;
            }
        }
        PopularityRankImpetusPendantTitleInfo popularityRankImpetusPendantTitleInfo = this.titleInfo;
        return popularityRankImpetusPendantTitleInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, popularityRankImpetusPendantTitleInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final PopularityRankImpetusPendantFold mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                UserInfos.PicUrl[] picUrlArr = this.backgroundPicUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.backgroundPicUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.backgroundPicUrl = picUrlArr2;
            } else if (tag == 18) {
                int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr = this.foldMessage;
                int length2 = impetusPendantContentWithStyleArr == null ? 0 : impetusPendantContentWithStyleArr.length;
                ImpetusPendantContentWithStyle[] impetusPendantContentWithStyleArr2 = new ImpetusPendantContentWithStyle[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.foldMessage, 0, impetusPendantContentWithStyleArr2, 0, length2);
                }
                while (length2 < impetusPendantContentWithStyleArr2.length - 1) {
                    impetusPendantContentWithStyleArr2[length2] = new ImpetusPendantContentWithStyle();
                    codedInputByteBufferNano.readMessage(impetusPendantContentWithStyleArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                impetusPendantContentWithStyleArr2[length2] = new ImpetusPendantContentWithStyle();
                codedInputByteBufferNano.readMessage(impetusPendantContentWithStyleArr2[length2]);
                this.foldMessage = impetusPendantContentWithStyleArr2;
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.titleInfo == null) {
                    this.titleInfo = new PopularityRankImpetusPendantTitleInfo();
                }
                codedInputByteBufferNano.readMessage(this.titleInfo);
            }
        }
    }

    public static PopularityRankImpetusPendantFold parseFrom(byte[] bArr) {
        return (PopularityRankImpetusPendantFold) MessageNano.mergeFrom(new PopularityRankImpetusPendantFold(), bArr);
    }

    public static PopularityRankImpetusPendantFold parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new PopularityRankImpetusPendantFold().mergeFrom(codedInputByteBufferNano);
    }
}
