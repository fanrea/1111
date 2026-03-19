package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveBulletPlayStatus extends MessageNano {
    private static volatile SCLiveBulletPlayStatus[] _emptyArray;
    public InteractiveChatLayoutConfig layoutConfig;
    public int playPlatform;
    public int playStatus;
    public String roomCode;
    public long timestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayPlatform {
        public static final int CLIENT = 0;
        public static final int CLOUD = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayStatus {
        public static final int CLOSE = 0;
        public static final int OPEN = 1;
    }

    public static SCLiveBulletPlayStatus[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletPlayStatus[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletPlayStatus() {
        clear();
    }

    public final SCLiveBulletPlayStatus clear() {
        this.roomCode = "";
        this.playStatus = 0;
        this.playPlatform = 0;
        this.layoutConfig = null;
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.roomCode.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.roomCode);
        }
        int i = this.playStatus;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        int i2 = this.playPlatform;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        InteractiveChatLayoutConfig interactiveChatLayoutConfig = this.layoutConfig;
        if (interactiveChatLayoutConfig != null) {
            codedOutputByteBufferNano.writeMessage(4, interactiveChatLayoutConfig);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.roomCode.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.roomCode);
        }
        int i = this.playStatus;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        int i2 = this.playPlatform;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        InteractiveChatLayoutConfig interactiveChatLayoutConfig = this.layoutConfig;
        if (interactiveChatLayoutConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, interactiveChatLayoutConfig);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletPlayStatus mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.roomCode = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.playStatus = int32;
                }
            } else if (tag == 24) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1) {
                    this.playPlatform = int322;
                }
            } else if (tag == 34) {
                if (this.layoutConfig == null) {
                    this.layoutConfig = new InteractiveChatLayoutConfig();
                }
                codedInputByteBufferNano.readMessage(this.layoutConfig);
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveBulletPlayStatus parseFrom(byte[] bArr) {
        return (SCLiveBulletPlayStatus) MessageNano.mergeFrom(new SCLiveBulletPlayStatus(), bArr);
    }

    public static SCLiveBulletPlayStatus parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletPlayStatus().mergeFrom(codedInputByteBufferNano);
    }
}
