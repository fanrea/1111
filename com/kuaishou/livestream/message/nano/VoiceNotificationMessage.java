package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class VoiceNotificationMessage extends MessageNano {
    private static volatile VoiceNotificationMessage[] _emptyArray;
    public byte[] content;
    public boolean enableVoiceNotification;
    public String extension;
    public String id;
    public int messageBizType;
    public int messageType;
    public UserInfos.UserInfo sender;
    public long timestamp;

    public static VoiceNotificationMessage[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new VoiceNotificationMessage[0];
                }
            }
        }
        return _emptyArray;
    }

    public VoiceNotificationMessage() {
        clear();
    }

    public final VoiceNotificationMessage clear() {
        this.sender = null;
        this.id = "";
        this.messageType = 0;
        this.content = WireFormatNano.EMPTY_BYTES;
        this.timestamp = 0L;
        this.enableVoiceNotification = false;
        this.messageBizType = 0;
        this.extension = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        UserInfos.UserInfo userInfo = this.sender;
        if (userInfo != null) {
            codedOutputByteBufferNano.writeMessage(1, userInfo);
        }
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.id);
        }
        int i = this.messageType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        if (!Arrays.equals(this.content, WireFormatNano.EMPTY_BYTES)) {
            codedOutputByteBufferNano.writeBytes(4, this.content);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        boolean z = this.enableVoiceNotification;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        int i2 = this.messageBizType;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(7, i2);
        }
        if (!this.extension.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.extension);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserInfos.UserInfo userInfo = this.sender;
        if (userInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
        }
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.id);
        }
        int i = this.messageType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        if (!Arrays.equals(this.content, WireFormatNano.EMPTY_BYTES)) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBytesSize(4, this.content);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        boolean z = this.enableVoiceNotification;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
        }
        int i2 = this.messageBizType;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(7, i2);
        }
        return !this.extension.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.extension) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final VoiceNotificationMessage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.sender == null) {
                    this.sender = new UserInfos.UserInfo();
                }
                codedInputByteBufferNano.readMessage(this.sender);
            } else if (tag == 18) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1) {
                    this.messageType = int32;
                }
            } else if (tag == 34) {
                this.content = codedInputByteBufferNano.readBytes();
            } else if (tag == 40) {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            } else if (tag == 48) {
                this.enableVoiceNotification = codedInputByteBufferNano.readBool();
            } else if (tag == 56) {
                int int322 = codedInputByteBufferNano.readInt32();
                if (int322 == 0 || int322 == 1 || int322 == 2) {
                    this.messageBizType = int322;
                }
            } else if (tag != 66) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.extension = codedInputByteBufferNano.readString();
            }
        }
    }

    public static VoiceNotificationMessage parseFrom(byte[] bArr) {
        return (VoiceNotificationMessage) MessageNano.mergeFrom(new VoiceNotificationMessage(), bArr);
    }

    public static VoiceNotificationMessage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new VoiceNotificationMessage().mergeFrom(codedInputByteBufferNano);
    }
}
