package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PopularityRankImpetusPendantTitleInfo extends MessageNano {
    private static volatile PopularityRankImpetusPendantTitleInfo[] _emptyArray;
    public UserInfos.PicUrl[] iconPicUrl;
    public boolean tailWaitCountTime;
    public ImpetusPendantContentWithStyle titleText;

    public static PopularityRankImpetusPendantTitleInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PopularityRankImpetusPendantTitleInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public PopularityRankImpetusPendantTitleInfo() {
        clear();
    }

    public final PopularityRankImpetusPendantTitleInfo clear() {
        this.titleText = null;
        this.tailWaitCountTime = false;
        this.iconPicUrl = UserInfos.PicUrl.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        ImpetusPendantContentWithStyle impetusPendantContentWithStyle = this.titleText;
        if (impetusPendantContentWithStyle != null) {
            codedOutputByteBufferNano.writeMessage(1, impetusPendantContentWithStyle);
        }
        boolean z = this.tailWaitCountTime;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconPicUrl;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        ImpetusPendantContentWithStyle impetusPendantContentWithStyle = this.titleText;
        if (impetusPendantContentWithStyle != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, impetusPendantContentWithStyle);
        }
        boolean z = this.tailWaitCountTime;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        UserInfos.PicUrl[] picUrlArr = this.iconPicUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.iconPicUrl;
                if (i >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final PopularityRankImpetusPendantTitleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.titleText == null) {
                    this.titleText = new ImpetusPendantContentWithStyle();
                }
                codedInputByteBufferNano.readMessage(this.titleText);
            } else if (tag == 16) {
                this.tailWaitCountTime = codedInputByteBufferNano.readBool();
            } else if (tag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.iconPicUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.iconPicUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.iconPicUrl = picUrlArr2;
            }
        }
    }

    public static PopularityRankImpetusPendantTitleInfo parseFrom(byte[] bArr) {
        return (PopularityRankImpetusPendantTitleInfo) MessageNano.mergeFrom(new PopularityRankImpetusPendantTitleInfo(), bArr);
    }

    public static PopularityRankImpetusPendantTitleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new PopularityRankImpetusPendantTitleInfo().mergeFrom(codedInputByteBufferNano);
    }
}
