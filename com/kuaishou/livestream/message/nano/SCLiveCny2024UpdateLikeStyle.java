package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.cny2023.message.nano.CnyCdnDegradeProto;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveCny2024UpdateLikeStyle extends MessageNano {
    private static volatile SCLiveCny2024UpdateLikeStyle[] _emptyArray;
    public CnyCdnDegradeProto.DegradablePicUrl avatarLottieBack;
    public CnyCdnDegradeProto.DegradablePicUrl avatarLottieFront;
    public long delayLoadTimeIntervalMillis;
    public CnyCdnDegradeProto.DegradablePicUrl heartImg;
    public boolean hideAvatarLottie;
    public String likeEndColor;
    public String likeFinishedText;
    public DegradableLiveLikeImg likeImg;
    public String likeStartColor;
    public CnyCdnDegradeProto.DegradablePicUrl lottieImg;
    public CnyCdnDegradeProto.DegradablePicUrl thumbUpLottie;
    public CnyCdnDegradeProto.DegradablePicUrl topBarHeartLottie;

    public static SCLiveCny2024UpdateLikeStyle[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveCny2024UpdateLikeStyle[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveCny2024UpdateLikeStyle() {
        clear();
    }

    public final SCLiveCny2024UpdateLikeStyle clear() {
        this.hideAvatarLottie = false;
        this.thumbUpLottie = null;
        this.topBarHeartLottie = null;
        this.avatarLottieBack = null;
        this.avatarLottieFront = null;
        this.heartImg = null;
        this.likeImg = null;
        this.lottieImg = null;
        this.likeStartColor = "";
        this.likeEndColor = "";
        this.likeFinishedText = "";
        this.delayLoadTimeIntervalMillis = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.hideAvatarLottie;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.thumbUpLottie;
        if (degradablePicUrl != null) {
            codedOutputByteBufferNano.writeMessage(2, degradablePicUrl);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl2 = this.topBarHeartLottie;
        if (degradablePicUrl2 != null) {
            codedOutputByteBufferNano.writeMessage(3, degradablePicUrl2);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl3 = this.avatarLottieBack;
        if (degradablePicUrl3 != null) {
            codedOutputByteBufferNano.writeMessage(4, degradablePicUrl3);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl4 = this.avatarLottieFront;
        if (degradablePicUrl4 != null) {
            codedOutputByteBufferNano.writeMessage(5, degradablePicUrl4);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl5 = this.heartImg;
        if (degradablePicUrl5 != null) {
            codedOutputByteBufferNano.writeMessage(6, degradablePicUrl5);
        }
        DegradableLiveLikeImg degradableLiveLikeImg = this.likeImg;
        if (degradableLiveLikeImg != null) {
            codedOutputByteBufferNano.writeMessage(7, degradableLiveLikeImg);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl6 = this.lottieImg;
        if (degradablePicUrl6 != null) {
            codedOutputByteBufferNano.writeMessage(8, degradablePicUrl6);
        }
        if (!this.likeStartColor.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.likeStartColor);
        }
        if (!this.likeEndColor.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.likeEndColor);
        }
        if (!this.likeFinishedText.equals("")) {
            codedOutputByteBufferNano.writeString(11, this.likeFinishedText);
        }
        long j = this.delayLoadTimeIntervalMillis;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(12, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.hideAvatarLottie;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl = this.thumbUpLottie;
        if (degradablePicUrl != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, degradablePicUrl);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl2 = this.topBarHeartLottie;
        if (degradablePicUrl2 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, degradablePicUrl2);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl3 = this.avatarLottieBack;
        if (degradablePicUrl3 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, degradablePicUrl3);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl4 = this.avatarLottieFront;
        if (degradablePicUrl4 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, degradablePicUrl4);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl5 = this.heartImg;
        if (degradablePicUrl5 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, degradablePicUrl5);
        }
        DegradableLiveLikeImg degradableLiveLikeImg = this.likeImg;
        if (degradableLiveLikeImg != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, degradableLiveLikeImg);
        }
        CnyCdnDegradeProto.DegradablePicUrl degradablePicUrl6 = this.lottieImg;
        if (degradablePicUrl6 != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(8, degradablePicUrl6);
        }
        if (!this.likeStartColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.likeStartColor);
        }
        if (!this.likeEndColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.likeEndColor);
        }
        if (!this.likeFinishedText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.likeFinishedText);
        }
        long j = this.delayLoadTimeIntervalMillis;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt64Size(12, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveCny2024UpdateLikeStyle mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 8:
                    this.hideAvatarLottie = codedInputByteBufferNano.readBool();
                    break;
                case 18:
                    if (this.thumbUpLottie == null) {
                        this.thumbUpLottie = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.thumbUpLottie);
                    break;
                case 26:
                    if (this.topBarHeartLottie == null) {
                        this.topBarHeartLottie = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.topBarHeartLottie);
                    break;
                case 34:
                    if (this.avatarLottieBack == null) {
                        this.avatarLottieBack = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.avatarLottieBack);
                    break;
                case 42:
                    if (this.avatarLottieFront == null) {
                        this.avatarLottieFront = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.avatarLottieFront);
                    break;
                case 50:
                    if (this.heartImg == null) {
                        this.heartImg = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.heartImg);
                    break;
                case 58:
                    if (this.likeImg == null) {
                        this.likeImg = new DegradableLiveLikeImg();
                    }
                    codedInputByteBufferNano.readMessage(this.likeImg);
                    break;
                case 66:
                    if (this.lottieImg == null) {
                        this.lottieImg = new CnyCdnDegradeProto.DegradablePicUrl();
                    }
                    codedInputByteBufferNano.readMessage(this.lottieImg);
                    break;
                case 74:
                    this.likeStartColor = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.likeEndColor = codedInputByteBufferNano.readString();
                    break;
                case 90:
                    this.likeFinishedText = codedInputByteBufferNano.readString();
                    break;
                case 96:
                    this.delayLoadTimeIntervalMillis = codedInputByteBufferNano.readInt64();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static SCLiveCny2024UpdateLikeStyle parseFrom(byte[] bArr) {
        return (SCLiveCny2024UpdateLikeStyle) MessageNano.mergeFrom(new SCLiveCny2024UpdateLikeStyle(), bArr);
    }

    public static SCLiveCny2024UpdateLikeStyle parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveCny2024UpdateLikeStyle().mergeFrom(codedInputByteBufferNano);
    }
}
