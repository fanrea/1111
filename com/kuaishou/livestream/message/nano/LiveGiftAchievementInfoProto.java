package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveGiftAchievementInfoProto {

    public static final class SCLiveGiftAchievementInfo extends MessageNano {
        private static volatile SCLiveGiftAchievementInfo[] _emptyArray;
        public int animStyle;
        public String biz;
        public long delayDurationMs;
        public long id;
        public UserInfos.PicUrl[] imageUrl;
        public UserInfos.PicUrl[] imageUrlNew;
        public int priority;
        public String routerUrl;
        public long showDurationMs;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveAuthorReinforceAnimStyle {
            public static final int SLIDE_WITH_SHIMMER = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveGiftAchievementInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveGiftAchievementInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveGiftAchievementInfo() {
            clear();
        }

        public final SCLiveGiftAchievementInfo clear() {
            this.id = 0L;
            this.biz = "";
            this.priority = 0;
            this.delayDurationMs = 0L;
            this.showDurationMs = 0L;
            this.animStyle = 0;
            this.imageUrl = UserInfos.PicUrl.emptyArray();
            this.routerUrl = "";
            this.imageUrlNew = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.id;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.biz.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.biz);
            }
            int i = this.priority;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            long j2 = this.delayDurationMs;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j2);
            }
            long j3 = this.showDurationMs;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j3);
            }
            int i2 = this.animStyle;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(6, i2);
            }
            UserInfos.PicUrl[] picUrlArr = this.imageUrl;
            int i3 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                    if (i4 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i4];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(7, picUrl);
                    }
                    i4++;
                }
            }
            if (!this.routerUrl.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.routerUrl);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.imageUrlNew;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.imageUrlNew;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(9, picUrl2);
                    }
                    i3++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.id;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.biz.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.biz);
            }
            int i = this.priority;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            long j2 = this.delayDurationMs;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
            }
            long j3 = this.showDurationMs;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j3);
            }
            int i2 = this.animStyle;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i2);
            }
            UserInfos.PicUrl[] picUrlArr = this.imageUrl;
            int i3 = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i4 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.imageUrl;
                    if (i4 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i4];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(7, picUrl);
                    }
                    i4++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            if (!this.routerUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.routerUrl);
            }
            UserInfos.PicUrl[] picUrlArr3 = this.imageUrlNew;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.imageUrlNew;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(9, picUrl2);
                    }
                    i3++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveGiftAchievementInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.id = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.biz = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.priority = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.delayDurationMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.showDurationMs = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1) {
                        this.animStyle = int32;
                    }
                } else if (tag == 58) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    UserInfos.PicUrl[] picUrlArr = this.imageUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.imageUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.imageUrl = picUrlArr2;
                } else if (tag == 66) {
                    this.routerUrl = codedInputByteBufferNano.readString();
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 74);
                    UserInfos.PicUrl[] picUrlArr3 = this.imageUrlNew;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.imageUrlNew, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.imageUrlNew = picUrlArr4;
                }
            }
        }

        public static SCLiveGiftAchievementInfo parseFrom(byte[] bArr) {
            return (SCLiveGiftAchievementInfo) MessageNano.mergeFrom(new SCLiveGiftAchievementInfo(), bArr);
        }

        public static SCLiveGiftAchievementInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveGiftAchievementInfo().mergeFrom(codedInputByteBufferNano);
        }
    }
}
