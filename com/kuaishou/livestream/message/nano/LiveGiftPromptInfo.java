package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftPromptInfo extends MessageNano {
    private static volatile LiveGiftPromptInfo[] _emptyArray;
    public String cancelText;
    public String clickToast;
    public String description;
    public String key;
    public long[] liveGiftBackgroundColor;
    public String liveGiftDescription;
    public String liveGiftRuleUrl;
    public LiveGiftSendPromptOkAction okAction;
    public String okText;
    public String title;

    public static LiveGiftPromptInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftPromptInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftPromptInfo() {
        clear();
    }

    public final LiveGiftPromptInfo clear() {
        this.key = "";
        this.title = "";
        this.description = "";
        this.okText = "";
        this.cancelText = "";
        this.okAction = null;
        this.liveGiftDescription = "";
        this.liveGiftRuleUrl = "";
        this.liveGiftBackgroundColor = WireFormatNano.EMPTY_LONG_ARRAY;
        this.clickToast = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.key.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.key);
        }
        if (!this.title.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.title);
        }
        if (!this.description.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.description);
        }
        if (!this.okText.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.okText);
        }
        if (!this.cancelText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.cancelText);
        }
        LiveGiftSendPromptOkAction liveGiftSendPromptOkAction = this.okAction;
        if (liveGiftSendPromptOkAction != null) {
            codedOutputByteBufferNano.writeMessage(6, liveGiftSendPromptOkAction);
        }
        if (!this.liveGiftDescription.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.liveGiftDescription);
        }
        if (!this.liveGiftRuleUrl.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.liveGiftRuleUrl);
        }
        long[] jArr = this.liveGiftBackgroundColor;
        if (jArr != null && jArr.length > 0) {
            int i = 0;
            while (true) {
                long[] jArr2 = this.liveGiftBackgroundColor;
                if (i >= jArr2.length) {
                    break;
                }
                codedOutputByteBufferNano.writeUInt64(9, jArr2[i]);
                i++;
            }
        }
        if (!this.clickToast.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.clickToast);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        long[] jArr;
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.key.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.key);
        }
        if (!this.title.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
        }
        if (!this.description.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.description);
        }
        if (!this.okText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.okText);
        }
        if (!this.cancelText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.cancelText);
        }
        LiveGiftSendPromptOkAction liveGiftSendPromptOkAction = this.okAction;
        if (liveGiftSendPromptOkAction != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(6, liveGiftSendPromptOkAction);
        }
        if (!this.liveGiftDescription.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.liveGiftDescription);
        }
        if (!this.liveGiftRuleUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.liveGiftRuleUrl);
        }
        long[] jArr2 = this.liveGiftBackgroundColor;
        if (jArr2 != null && jArr2.length > 0) {
            int i = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                jArr = this.liveGiftBackgroundColor;
                if (i >= jArr.length) {
                    break;
                }
                iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr[i]);
                i++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr.length * 1);
        }
        return !this.clickToast.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(10, this.clickToast) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftPromptInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.key = codedInputByteBufferNano.readString();
                    break;
                case 18:
                    this.title = codedInputByteBufferNano.readString();
                    break;
                case 26:
                    this.description = codedInputByteBufferNano.readString();
                    break;
                case 34:
                    this.okText = codedInputByteBufferNano.readString();
                    break;
                case 42:
                    this.cancelText = codedInputByteBufferNano.readString();
                    break;
                case 50:
                    if (this.okAction == null) {
                        this.okAction = new LiveGiftSendPromptOkAction();
                    }
                    codedInputByteBufferNano.readMessage(this.okAction);
                    break;
                case 58:
                    this.liveGiftDescription = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.liveGiftRuleUrl = codedInputByteBufferNano.readString();
                    break;
                case 72:
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 72);
                    long[] jArr = this.liveGiftBackgroundColor;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.liveGiftBackgroundColor, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.liveGiftBackgroundColor = jArr2;
                    break;
                case 74:
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.liveGiftBackgroundColor;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.liveGiftBackgroundColor, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.liveGiftBackgroundColor = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                    break;
                case 82:
                    this.clickToast = codedInputByteBufferNano.readString();
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static LiveGiftPromptInfo parseFrom(byte[] bArr) {
        return (LiveGiftPromptInfo) MessageNano.mergeFrom(new LiveGiftPromptInfo(), bArr);
    }

    public static LiveGiftPromptInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftPromptInfo().mergeFrom(codedInputByteBufferNano);
    }
}
