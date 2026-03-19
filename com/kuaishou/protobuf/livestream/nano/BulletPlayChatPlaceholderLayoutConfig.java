package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class BulletPlayChatPlaceholderLayoutConfig extends MessageNano {
    private static volatile BulletPlayChatPlaceholderLayoutConfig[] _emptyArray;
    public BulletPlayCanvasSize canvasSize;
    public BulletPlayChatWindow[] windowInfo;

    public static BulletPlayChatPlaceholderLayoutConfig[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new BulletPlayChatPlaceholderLayoutConfig[0];
                }
            }
        }
        return _emptyArray;
    }

    public BulletPlayChatPlaceholderLayoutConfig() {
        clear();
    }

    public final BulletPlayChatPlaceholderLayoutConfig clear() {
        this.canvasSize = null;
        this.windowInfo = BulletPlayChatWindow.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        BulletPlayCanvasSize bulletPlayCanvasSize = this.canvasSize;
        if (bulletPlayCanvasSize != null) {
            codedOutputByteBufferNano.writeMessage(1, bulletPlayCanvasSize);
        }
        BulletPlayChatWindow[] bulletPlayChatWindowArr = this.windowInfo;
        if (bulletPlayChatWindowArr != null && bulletPlayChatWindowArr.length > 0) {
            int i = 0;
            while (true) {
                BulletPlayChatWindow[] bulletPlayChatWindowArr2 = this.windowInfo;
                if (i >= bulletPlayChatWindowArr2.length) {
                    break;
                }
                BulletPlayChatWindow bulletPlayChatWindow = bulletPlayChatWindowArr2[i];
                if (bulletPlayChatWindow != null) {
                    codedOutputByteBufferNano.writeMessage(2, bulletPlayChatWindow);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        BulletPlayCanvasSize bulletPlayCanvasSize = this.canvasSize;
        if (bulletPlayCanvasSize != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, bulletPlayCanvasSize);
        }
        BulletPlayChatWindow[] bulletPlayChatWindowArr = this.windowInfo;
        if (bulletPlayChatWindowArr != null && bulletPlayChatWindowArr.length > 0) {
            int i = 0;
            while (true) {
                BulletPlayChatWindow[] bulletPlayChatWindowArr2 = this.windowInfo;
                if (i >= bulletPlayChatWindowArr2.length) {
                    break;
                }
                BulletPlayChatWindow bulletPlayChatWindow = bulletPlayChatWindowArr2[i];
                if (bulletPlayChatWindow != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, bulletPlayChatWindow);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final BulletPlayChatPlaceholderLayoutConfig mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.canvasSize == null) {
                    this.canvasSize = new BulletPlayCanvasSize();
                }
                codedInputByteBufferNano.readMessage(this.canvasSize);
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                BulletPlayChatWindow[] bulletPlayChatWindowArr = this.windowInfo;
                int length = bulletPlayChatWindowArr == null ? 0 : bulletPlayChatWindowArr.length;
                BulletPlayChatWindow[] bulletPlayChatWindowArr2 = new BulletPlayChatWindow[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.windowInfo, 0, bulletPlayChatWindowArr2, 0, length);
                }
                while (length < bulletPlayChatWindowArr2.length - 1) {
                    bulletPlayChatWindowArr2[length] = new BulletPlayChatWindow();
                    codedInputByteBufferNano.readMessage(bulletPlayChatWindowArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                bulletPlayChatWindowArr2[length] = new BulletPlayChatWindow();
                codedInputByteBufferNano.readMessage(bulletPlayChatWindowArr2[length]);
                this.windowInfo = bulletPlayChatWindowArr2;
            }
        }
    }

    public static BulletPlayChatPlaceholderLayoutConfig parseFrom(byte[] bArr) {
        return (BulletPlayChatPlaceholderLayoutConfig) MessageNano.mergeFrom(new BulletPlayChatPlaceholderLayoutConfig(), bArr);
    }

    public static BulletPlayChatPlaceholderLayoutConfig parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new BulletPlayChatPlaceholderLayoutConfig().mergeFrom(codedInputByteBufferNano);
    }
}
