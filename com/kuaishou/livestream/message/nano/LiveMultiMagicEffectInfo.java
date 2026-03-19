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
public final class LiveMultiMagicEffectInfo extends MessageNano {
    private static volatile LiveMultiMagicEffectInfo[] _emptyArray;
    public int bizType;
    public String content;
    public String extraInfo;
    public UserInfos.UserInfo fromUserInfo;
    public int liveStreamType;
    public long magicFaceId;
    public int magicSubType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveMultiMagicEffectBiz {
        public static final int LIVE_WISH_LIGHT = 1;
        public static final int UNKNOWN_BIZ = 0;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveMultiMagicLiveStreamType {
        public static final int COMMON = 1;
        public static final int UNKNOWN_STREAM_TYPE = 0;
        public static final int WISH_LIVE_STREAM = 2;
    }

    public static LiveMultiMagicEffectInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiMagicEffectInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiMagicEffectInfo() {
        clear();
    }

    public final LiveMultiMagicEffectInfo clear() {
        this.bizType = 0;
        this.magicFaceId = 0L;
        this.magicSubType = 0;
        this.fromUserInfo = null;
        this.content = "";
        this.liveStreamType = 0;
        this.extraInfo = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.bizType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        long j = this.magicFaceId;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(2, j);
        }
        int i2 = this.magicSubType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        UserInfos.UserInfo userInfo = this.fromUserInfo;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, userInfo);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.content);
        }
        int i3 = this.liveStreamType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i3);
        }
        if (!this.extraInfo.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.extraInfo);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.bizType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        long j = this.magicFaceId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt64Size(2, j);
        }
        int i2 = this.magicSubType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        UserInfos.UserInfo userInfo = this.fromUserInfo;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, userInfo);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.content);
        }
        int i3 = this.liveStreamType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i3);
        }
        return !this.extraInfo.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.extraInfo) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiMagicEffectInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.bizType = int32;
                }
            } else if (tag == 16) {
                this.magicFaceId = codedInputByteBufferNano.readInt64();
            } else if (tag == 24) {
                this.magicSubType = codedInputByteBufferNano.readInt32();
            } else if (tag == 34) {
                if (this.fromUserInfo == null) {
                    this.fromUserInfo = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.fromUserInfo);
            } else if (tag == 42) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 48) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.liveStreamType = int322;
                }
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.extraInfo = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LiveMultiMagicEffectInfo parseFrom(byte[] bArr) {
        return (LiveMultiMagicEffectInfo) MessageNano.mergeFrom(new LiveMultiMagicEffectInfo(), bArr);
    }

    public static LiveMultiMagicEffectInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiMagicEffectInfo().mergeFrom(codedInputByteBufferNano);
    }
}
