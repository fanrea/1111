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
public final class LiveEffectResourceData extends MessageNano {
    private static volatile LiveEffectResourceData[] _emptyArray;
    public UserInfos.PicUrl[] cdnUrl;
    public int downloadSource;
    public LiveEffectImageConfig imageConfig;
    public String position;
    public int resType;
    public String resourceId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveDownLoadSource {
        public static final int CDN_PLATFORM = 2;
        public static final int OTHER_MAGIC_FACE_ID = 3;
        public static final int RESOURCE_CENTER = 1;
        public static final int UNKNOWN_SOURCE = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveEffectResourceType {
        public static final int IMAGE = 3;
        public static final int MP3 = 4;
        public static final int MP4 = 6;
        public static final int PNG = 5;
        public static final int TEXTURE = 1;
        public static final int UNKNOWN_RESOURCE_TYPE = 0;
        public static final int ZIP = 2;
    }

    public static LiveEffectResourceData[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveEffectResourceData[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveEffectResourceData() {
        clear();
    }

    public final LiveEffectResourceData clear() {
        this.position = "";
        this.resType = 0;
        this.cdnUrl = UserInfos.PicUrl.emptyArray();
        this.imageConfig = null;
        this.resourceId = "";
        this.downloadSource = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.position.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.position);
        }
        int i = this.resType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.cdnUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.cdnUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    codedOutputByteBufferNano.writeMessage(3, picUrl);
                }
                i2++;
            }
        }
        LiveEffectImageConfig liveEffectImageConfig = this.imageConfig;
        if (liveEffectImageConfig != null) {
            codedOutputByteBufferNano.writeMessage(4, liveEffectImageConfig);
        }
        if (!this.resourceId.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.resourceId);
        }
        int i3 = this.downloadSource;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.position.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.position);
        }
        int i = this.resType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.cdnUrl;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.cdnUrl;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl);
                }
                i2++;
            }
        }
        LiveEffectImageConfig liveEffectImageConfig = this.imageConfig;
        if (liveEffectImageConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveEffectImageConfig);
        }
        if (!this.resourceId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.resourceId);
        }
        int i3 = this.downloadSource;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(6, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveEffectResourceData mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.position = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                switch (int32) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        this.resType = int32;
                        break;
                }
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                UserInfos.PicUrl[] picUrlArr = this.cdnUrl;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.cdnUrl, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.cdnUrl = picUrlArr2;
            } else if (tag == 34) {
                if (this.imageConfig == null) {
                    this.imageConfig = new LiveEffectImageConfig();
                }
                codedInputByteBufferNano.readMessage(this.imageConfig);
            } else if (tag == 42) {
                this.resourceId = codedInputByteBufferNano.readString();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2 || int322 == 3) {
                    this.downloadSource = int322;
                }
            }
        }
    }

    public static LiveEffectResourceData parseFrom(byte[] bArr) {
        return (LiveEffectResourceData) MessageNano.mergeFrom(new LiveEffectResourceData(), bArr);
    }

    public static LiveEffectResourceData parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveEffectResourceData().mergeFrom(codedInputByteBufferNano);
    }
}
