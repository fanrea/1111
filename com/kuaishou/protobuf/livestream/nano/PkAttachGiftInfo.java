package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class PkAttachGiftInfo extends MessageNano {
    private static volatile PkAttachGiftInfo[] _emptyArray;
    public boolean enableDefaultSelectNotNotify;
    public int giftId;
    public String giftToken;
    public String notNotifyText;
    public String recoGiftLlsid;
    public String[] sendGiftMsgKeys;

    public static PkAttachGiftInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new PkAttachGiftInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public PkAttachGiftInfo() {
        clear();
    }

    public final PkAttachGiftInfo clear() {
        this.giftId = 0;
        this.giftToken = "";
        this.recoGiftLlsid = "";
        this.sendGiftMsgKeys = WireFormatNano.EMPTY_STRING_ARRAY;
        this.notNotifyText = "";
        this.enableDefaultSelectNotNotify = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.giftId;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        if (!this.giftToken.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.giftToken);
        }
        if (!this.recoGiftLlsid.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.recoGiftLlsid);
        }
        String[] strArr = this.sendGiftMsgKeys;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.sendGiftMsgKeys;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    codedOutputByteBufferNano.writeString(4, str);
                }
                i2++;
            }
        }
        if (!this.notNotifyText.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.notNotifyText);
        }
        boolean z = this.enableDefaultSelectNotNotify;
        if (z) {
            codedOutputByteBufferNano.writeBool(6, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.giftId;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        if (!this.giftToken.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.giftToken);
        }
        if (!this.recoGiftLlsid.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.recoGiftLlsid);
        }
        String[] strArr = this.sendGiftMsgKeys;
        if (strArr != null && strArr.length > 0) {
            int i2 = 0;
            int iComputeStringSizeNoTag = 0;
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.sendGiftMsgKeys;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                if (str != null) {
                    i3++;
                    iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                }
                i2++;
            }
            iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i3 * 1);
        }
        if (!this.notNotifyText.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.notNotifyText);
        }
        boolean z = this.enableDefaultSelectNotNotify;
        return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(6, z) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final PkAttachGiftInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.giftId = codedInputByteBufferNano.readUInt32();
            } else if (tag == 18) {
                this.giftToken = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.recoGiftLlsid = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                String[] strArr = this.sendGiftMsgKeys;
                int length = strArr == null ? 0 : strArr.length;
                String[] strArr2 = new String[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.sendGiftMsgKeys, 0, strArr2, 0, length);
                }
                while (length < strArr2.length - 1) {
                    strArr2[length] = codedInputByteBufferNano.readString();
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                strArr2[length] = codedInputByteBufferNano.readString();
                this.sendGiftMsgKeys = strArr2;
            } else if (tag == 42) {
                this.notNotifyText = codedInputByteBufferNano.readString();
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.enableDefaultSelectNotNotify = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static PkAttachGiftInfo parseFrom(byte[] bArr) {
        return (PkAttachGiftInfo) MessageNano.mergeFrom(new PkAttachGiftInfo(), bArr);
    }

    public static PkAttachGiftInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new PkAttachGiftInfo().mergeFrom(codedInputByteBufferNano);
    }
}
