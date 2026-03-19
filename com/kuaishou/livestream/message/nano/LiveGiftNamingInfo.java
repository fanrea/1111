package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftNamingInfo extends MessageNano {
    private static volatile LiveGiftNamingInfo[] _emptyArray;
    public LiveGiftNamingDisplayInfo displayInfo;
    public int giftId;
    public boolean lightOn;
    public UserInfos.UserInfo namingUser;
    public int type;

    public static LiveGiftNamingInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftNamingInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftNamingInfo() {
        clear();
    }

    public final LiveGiftNamingInfo clear() {
        this.type = 0;
        this.giftId = 0;
        this.namingUser = null;
        this.displayInfo = null;
        this.lightOn = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.type;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.giftId;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        UserInfos.UserInfo userInfo = this.namingUser;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, userInfo);
        }
        LiveGiftNamingDisplayInfo liveGiftNamingDisplayInfo = this.displayInfo;
        if (liveGiftNamingDisplayInfo != null) {
            codedOutputByteBufferNano.writeMessage(4, liveGiftNamingDisplayInfo);
        }
        boolean z = this.lightOn;
        if (z) {
            codedOutputByteBufferNano.writeBool(5, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.type;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.giftId;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        UserInfos.UserInfo userInfo = this.namingUser;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, userInfo);
        }
        LiveGiftNamingDisplayInfo liveGiftNamingDisplayInfo = this.displayInfo;
        if (liveGiftNamingDisplayInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveGiftNamingDisplayInfo);
        }
        boolean z = this.lightOn;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(5, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftNamingInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.type = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                if (this.namingUser == null) {
                    this.namingUser = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.namingUser);
            } else if (tag == 34) {
                if (this.displayInfo == null) {
                    this.displayInfo = new LiveGiftNamingDisplayInfo();
                }
                codedInputByteBufferNano.readMessage(this.displayInfo);
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.lightOn = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveGiftNamingInfo parseFrom(byte[] bArr) {
        return (LiveGiftNamingInfo) MessageNano.mergeFrom(new LiveGiftNamingInfo(), bArr);
    }

    public static LiveGiftNamingInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftNamingInfo().mergeFrom(codedInputByteBufferNano);
    }
}
