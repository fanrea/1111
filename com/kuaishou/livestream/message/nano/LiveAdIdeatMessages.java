package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAdIdeatMessages {

    public static final class SCLiveIdeatCommentBroadcast extends MessageNano {
        private static volatile SCLiveIdeatCommentBroadcast[] _emptyArray;
        public String bizType;
        public String businessParams;
        public UserInfos.PicUrl[] iconUrl;
        public String jumpUrl;
        public UserInfos.PicUrl[] refreshIconUrl;
        public String text;

        public static SCLiveIdeatCommentBroadcast[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveIdeatCommentBroadcast[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveIdeatCommentBroadcast() {
            clear();
        }

        public final SCLiveIdeatCommentBroadcast clear() {
            this.text = "";
            this.iconUrl = UserInfos.PicUrl.emptyArray();
            this.jumpUrl = "";
            this.bizType = "";
            this.businessParams = "";
            this.refreshIconUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.text.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.text);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl);
                    }
                    i2++;
                }
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.jumpUrl);
            }
            if (!this.bizType.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.bizType);
            }
            if (!this.businessParams.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.businessParams);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.refreshIconUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.refreshIconUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(6, picUrl2);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.text.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.text);
            }
            UserInfos.PicUrl[] picUrlArr = this.iconUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.iconUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.jumpUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl);
            }
            if (!this.bizType.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.bizType);
            }
            if (!this.businessParams.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.businessParams);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.refreshIconUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.refreshIconUrl;
                    if (i >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, picUrl2);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveIdeatCommentBroadcast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.text = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr = this.iconUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.iconUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.iconUrl = picUrlArr2;
                } else if (tag == 26) {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.bizType = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.businessParams = codedInputByteBufferNano.readString();
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 50);
                    UserInfos.PicUrl[] picUrlArr3 = this.refreshIconUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.refreshIconUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.refreshIconUrl = picUrlArr4;
                }
            }
        }

        public static SCLiveIdeatCommentBroadcast parseFrom(byte[] bArr) {
            return (SCLiveIdeatCommentBroadcast) MessageNano.mergeFrom(new SCLiveIdeatCommentBroadcast(), bArr);
        }

        public static SCLiveIdeatCommentBroadcast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveIdeatCommentBroadcast().mergeFrom(codedInputByteBufferNano);
        }
    }
}
