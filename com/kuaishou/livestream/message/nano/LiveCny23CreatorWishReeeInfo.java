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
public final class LiveCny23CreatorWishReeeInfo extends MessageNano {
    private static volatile LiveCny23CreatorWishReeeInfo[] _emptyArray;
    public String buttonKwailink;
    public String buttonText;
    public long count;
    public String desc;
    public UserInfos.PicUrl[] icon;
    public long reeFen;
    public int reeeType;
    public String tip;
    public String tipKwailink;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ReeeType {
        public static final int REAL_GIFT = 2;
        public static final int REE = 1;
        public static final int UNKNOWN = 0;
    }

    public static LiveCny23CreatorWishReeeInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveCny23CreatorWishReeeInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveCny23CreatorWishReeeInfo() {
        clear();
    }

    public final LiveCny23CreatorWishReeeInfo clear() {
        this.reeeType = 0;
        this.icon = UserInfos.PicUrl.emptyArray();
        this.reeFen = 0L;
        this.desc = "";
        this.count = 0L;
        this.tip = "";
        this.tipKwailink = "";
        this.buttonText = "";
        this.buttonKwailink = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.reeeType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
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
        long j = this.reeFen;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        if (!this.desc.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.desc);
        }
        long j2 = this.count;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j2);
        }
        if (!this.tip.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.tip);
        }
        if (!this.tipKwailink.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.tipKwailink);
        }
        if (!this.buttonText.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.buttonText);
        }
        if (!this.buttonKwailink.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.buttonKwailink);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.reeeType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        UserInfos.PicUrl[] picUrlArr = this.icon;
        if (picUrlArr != null && picUrlArr.length > 0) {
            int i2 = 0;
            while (true) {
                UserInfos.PicUrl[] picUrlArr2 = this.icon;
                if (i2 >= picUrlArr2.length) {
                    break;
                }
                UserInfos.PicUrl picUrl = picUrlArr2[i2];
                if (picUrl != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, picUrl);
                }
                i2++;
            }
        }
        long j = this.reeFen;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        if (!this.desc.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.desc);
        }
        long j2 = this.count;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
        }
        if (!this.tip.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.tip);
        }
        if (!this.tipKwailink.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.tipKwailink);
        }
        if (!this.buttonText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.buttonText);
        }
        return !this.buttonKwailink.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.buttonKwailink) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveCny23CreatorWishReeeInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.reeeType = int32;
                }
            } else if (tag == 18) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                UserInfos.PicUrl[] picUrlArr = this.icon;
                int length = picUrlArr == null ? 0 : picUrlArr.length;
                UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.icon, 0, picUrlArr2, 0, length);
                }
                while (length < picUrlArr2.length - 1) {
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                picUrlArr2[length] = new UserInfos.PicUrl();
                codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                this.icon = picUrlArr2;
            } else if (tag == 24) {
                this.reeFen = codedInputByteBufferNano.readUInt64();
            } else if (tag == 34) {
                this.desc = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.count = codedInputByteBufferNano.readUInt64();
            } else if (tag == 50) {
                this.tip = codedInputByteBufferNano.readString();
            } else if (tag == 58) {
                this.tipKwailink = codedInputByteBufferNano.readString();
            } else if (tag == 66) {
                this.buttonText = codedInputByteBufferNano.readString();
            } else if (tag != 74) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.buttonKwailink = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveCny23CreatorWishReeeInfo parseFrom(byte[] bArr) {
        return (LiveCny23CreatorWishReeeInfo) MessageNano.mergeFrom(new LiveCny23CreatorWishReeeInfo(), bArr);
    }

    public static LiveCny23CreatorWishReeeInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveCny23CreatorWishReeeInfo().mergeFrom(codedInputByteBufferNano);
    }
}
