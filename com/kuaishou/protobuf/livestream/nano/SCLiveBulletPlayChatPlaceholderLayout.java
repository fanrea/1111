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
public final class SCLiveBulletPlayChatPlaceholderLayout extends MessageNano {
    private static volatile SCLiveBulletPlayChatPlaceholderLayout[] _emptyArray;
    public BulletPlayChatPlaceholderLayoutConfig config;
    public long placeholderChatId;
    public int status;
    public long timestamp;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BulletPlayChatStatus {
        public static final int CLOSE = 2;
        public static final int OPEN = 1;
        public static final int UNKNOWN = 0;
    }

    public static SCLiveBulletPlayChatPlaceholderLayout[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveBulletPlayChatPlaceholderLayout[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveBulletPlayChatPlaceholderLayout() {
        clear();
    }

    public final SCLiveBulletPlayChatPlaceholderLayout clear() {
        this.status = 0;
        this.config = null;
        this.timestamp = 0L;
        this.placeholderChatId = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.status;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        BulletPlayChatPlaceholderLayoutConfig bulletPlayChatPlaceholderLayoutConfig = this.config;
        if (bulletPlayChatPlaceholderLayoutConfig != null) {
            codedOutputByteBufferNano.writeMessage(2, bulletPlayChatPlaceholderLayoutConfig);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        long j2 = this.placeholderChatId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.status;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        BulletPlayChatPlaceholderLayoutConfig bulletPlayChatPlaceholderLayoutConfig = this.config;
        if (bulletPlayChatPlaceholderLayoutConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bulletPlayChatPlaceholderLayoutConfig);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        long j2 = this.placeholderChatId;
        return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveBulletPlayChatPlaceholderLayout mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.status = int32;
                }
            } else if (tag == 18) {
                if (this.config == null) {
                    this.config = new BulletPlayChatPlaceholderLayoutConfig();
                }
                codedInputByteBufferNano.readMessage(this.config);
            } else if (tag == 24) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.placeholderChatId = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveBulletPlayChatPlaceholderLayout parseFrom(byte[] bArr) {
        return (SCLiveBulletPlayChatPlaceholderLayout) MessageNano.mergeFrom(new SCLiveBulletPlayChatPlaceholderLayout(), bArr);
    }

    public static SCLiveBulletPlayChatPlaceholderLayout parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveBulletPlayChatPlaceholderLayout().mergeFrom(codedInputByteBufferNano);
    }
}
