package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LivePlutusEnhanceModeProto {

    public static final class SCLivePlutusEnhanceModeView extends MessageNano {
        private static volatile SCLivePlutusEnhanceModeView[] _emptyArray;
        public String backGroundColor;
        public String bizType;
        public String contentText;
        public long displayDurationMs;
        public UserInfos.PicUrl[] iconUrls;
        public String routeUrl;

        public static SCLivePlutusEnhanceModeView[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLivePlutusEnhanceModeView[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLivePlutusEnhanceModeView() {
            clear();
        }

        public final SCLivePlutusEnhanceModeView clear() {
            this.backGroundColor = "";
            this.iconUrls = UserInfos.PicUrl.emptyArray();
            this.contentText = "";
            this.displayDurationMs = 0L;
            this.bizType = "";
            this.routeUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.backGroundColor.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.backGroundColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrls;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i++;
                }
            }
            if (!this.contentText.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.contentText);
            }
            long j = this.displayDurationMs;
            if (j != 0) {
                codedOutputByteBufferNano.writeInt64(4, j);
            }
            if (!this.bizType.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bizType);
            }
            if (!this.routeUrl.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.routeUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.backGroundColor.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.backGroundColor);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrls;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrls;
                    if (i >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i];
                    if (picUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i++;
                }
            }
            if (!this.contentText.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.contentText);
            }
            long j = this.displayDurationMs;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(4, j);
            }
            if (!this.bizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.bizType);
            }
            return !this.routeUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.routeUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLivePlutusEnhanceModeView mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.backGroundColor = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr = this.iconUrls;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.iconUrls, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.iconUrls = picUrlArr2;
                } else if (tag == 26) {
                    this.contentText = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.displayDurationMs = codedInputByteBufferNano.readInt64();
                } else if (tag == 42) {
                    this.bizType = codedInputByteBufferNano.readString();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.routeUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLivePlutusEnhanceModeView parseFrom(byte[] bArr) {
            return (SCLivePlutusEnhanceModeView) MessageNano.mergeFrom(new SCLivePlutusEnhanceModeView(), bArr);
        }

        public static SCLivePlutusEnhanceModeView parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLivePlutusEnhanceModeView().mergeFrom(codedInputByteBufferNano);
        }
    }
}
