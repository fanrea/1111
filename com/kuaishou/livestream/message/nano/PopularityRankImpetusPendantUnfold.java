package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PopularityRankImpetusPendantUnfold extends MessageNano {
    private static volatile PopularityRankImpetusPendantUnfold[] _emptyArray;
    public UserInfos.PicUrl[] backgroundPicUrl;
    public ImpetusPendantContentWithStyle countDownText;
    public PopularityRankImpetusPendantTitleInfo titleInfo;
    public ImpetusPendantUnfoldMessage[] unfoldMessage;

    public static PopularityRankImpetusPendantUnfold[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PopularityRankImpetusPendantUnfold[0];
                }
            }
        }
        return _emptyArray;
    }

    public PopularityRankImpetusPendantUnfold() {
        clear();
    }

    public final PopularityRankImpetusPendantUnfold clear() {
        this.backgroundPicUrl = UserInfos.PicUrl.emptyArray();
        this.unfoldMessage = ImpetusPendantUnfoldMessage.emptyArray();
        this.countDownText = null;
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
        ImpetusPendantUnfoldMessage[] impetusPendantUnfoldMessageArr = this.unfoldMessage;
        if (impetusPendantUnfoldMessageArr != null && impetusPendantUnfoldMessageArr.length > 0) {
            while (true) {
                ImpetusPendantUnfoldMessage[] impetusPendantUnfoldMessageArr2 = this.unfoldMessage;
                if (i >= impetusPendantUnfoldMessageArr2.length) {
                    break;
                }
                ImpetusPendantUnfoldMessage impetusPendantUnfoldMessage = impetusPendantUnfoldMessageArr2[i];
                if (impetusPendantUnfoldMessage != null) {
                    codedOutputByteBufferNano.writeMessage(2, impetusPendantUnfoldMessage);
                }
                i++;
            }
        }
        ImpetusPendantContentWithStyle impetusPendantContentWithStyle = this.countDownText;
        if (impetusPendantContentWithStyle != null) {
            codedOutputByteBufferNano.writeMessage(3, impetusPendantContentWithStyle);
        }
        PopularityRankImpetusPendantTitleInfo popularityRankImpetusPendantTitleInfo = this.titleInfo;
        if (popularityRankImpetusPendantTitleInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, popularityRankImpetusPendantTitleInfo);
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
        ImpetusPendantUnfoldMessage[] impetusPendantUnfoldMessageArr = this.unfoldMessage;
        if (impetusPendantUnfoldMessageArr != null && impetusPendantUnfoldMessageArr.length > 0) {
            while (true) {
                ImpetusPendantUnfoldMessage[] impetusPendantUnfoldMessageArr2 = this.unfoldMessage;
                if (i >= impetusPendantUnfoldMessageArr2.length) {
                    break;
                }
                ImpetusPendantUnfoldMessage impetusPendantUnfoldMessage = impetusPendantUnfoldMessageArr2[i];
                if (impetusPendantUnfoldMessage != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, impetusPendantUnfoldMessage);
                }
                i++;
            }
        }
        ImpetusPendantContentWithStyle impetusPendantContentWithStyle = this.countDownText;
        if (impetusPendantContentWithStyle != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, impetusPendantContentWithStyle);
        }
        PopularityRankImpetusPendantTitleInfo popularityRankImpetusPendantTitleInfo = this.titleInfo;
        return popularityRankImpetusPendantTitleInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(4, popularityRankImpetusPendantTitleInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final PopularityRankImpetusPendantUnfold mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                ImpetusPendantUnfoldMessage[] impetusPendantUnfoldMessageArr = this.unfoldMessage;
                int length2 = impetusPendantUnfoldMessageArr == null ? 0 : impetusPendantUnfoldMessageArr.length;
                ImpetusPendantUnfoldMessage[] impetusPendantUnfoldMessageArr2 = new ImpetusPendantUnfoldMessage[repeatedFieldArrayLength2 + length2];
                if (length2 != 0) {
                    System.arraycopy(this.unfoldMessage, 0, impetusPendantUnfoldMessageArr2, 0, length2);
                }
                while (length2 < impetusPendantUnfoldMessageArr2.length - 1) {
                    impetusPendantUnfoldMessageArr2[length2] = new ImpetusPendantUnfoldMessage();
                    codedInputByteBufferNano.readMessage(impetusPendantUnfoldMessageArr2[length2]);
                    codedInputByteBufferNano.readTag();
                    length2++;
                }
                impetusPendantUnfoldMessageArr2[length2] = new ImpetusPendantUnfoldMessage();
                codedInputByteBufferNano.readMessage(impetusPendantUnfoldMessageArr2[length2]);
                this.unfoldMessage = impetusPendantUnfoldMessageArr2;
            } else if (tag == 26) {
                if (this.countDownText == null) {
                    this.countDownText = new ImpetusPendantContentWithStyle();
                }
                codedInputByteBufferNano.readMessage(this.countDownText);
            } else if (tag != 34) {
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

    public static PopularityRankImpetusPendantUnfold parseFrom(byte[] bArr) {
        return (PopularityRankImpetusPendantUnfold) MessageNano.mergeFrom(new PopularityRankImpetusPendantUnfold(), bArr);
    }

    public static PopularityRankImpetusPendantUnfold parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new PopularityRankImpetusPendantUnfold().mergeFrom(codedInputByteBufferNano);
    }
}
