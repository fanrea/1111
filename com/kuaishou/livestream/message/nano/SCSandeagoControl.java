package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCSandeagoControl extends MessageNano {
    private static volatile SCSandeagoControl[] _emptyArray;
    public boolean isOpen;
    public SandeagoItemInfo[] itemInfo;
    public String jumpUrl;
    public long maxSaleNum;

    public static SCSandeagoControl[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCSandeagoControl[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCSandeagoControl() {
        clear();
    }

    public final SCSandeagoControl clear() {
        this.isOpen = false;
        this.jumpUrl = "";
        this.maxSaleNum = 0L;
        this.itemInfo = SandeagoItemInfo.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.isOpen;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        if (!this.jumpUrl.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.jumpUrl);
        }
        long j = this.maxSaleNum;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(3, j);
        }
        SandeagoItemInfo[] sandeagoItemInfoArr = this.itemInfo;
        if (sandeagoItemInfoArr != null && sandeagoItemInfoArr.length > 0) {
            int i = 0;
            while (true) {
                SandeagoItemInfo[] sandeagoItemInfoArr2 = this.itemInfo;
                if (i >= sandeagoItemInfoArr2.length) {
                    break;
                }
                SandeagoItemInfo sandeagoItemInfo = sandeagoItemInfoArr2[i];
                if (sandeagoItemInfo != null) {
                    codedOutputByteBufferNano.writeMessage(4, sandeagoItemInfo);
                }
                i++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.isOpen;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        if (!this.jumpUrl.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.jumpUrl);
        }
        long j = this.maxSaleNum;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
        }
        SandeagoItemInfo[] sandeagoItemInfoArr = this.itemInfo;
        if (sandeagoItemInfoArr != null && sandeagoItemInfoArr.length > 0) {
            int i = 0;
            while (true) {
                SandeagoItemInfo[] sandeagoItemInfoArr2 = this.itemInfo;
                if (i >= sandeagoItemInfoArr2.length) {
                    break;
                }
                SandeagoItemInfo sandeagoItemInfo = sandeagoItemInfoArr2[i];
                if (sandeagoItemInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, sandeagoItemInfo);
                }
                i++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCSandeagoControl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.isOpen = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                this.jumpUrl = codedInputByteBufferNano.readString();
            } else if (tag == 24) {
                this.maxSaleNum = codedInputByteBufferNano.readUInt64();
            } else if (tag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                SandeagoItemInfo[] sandeagoItemInfoArr = this.itemInfo;
                int length = sandeagoItemInfoArr == null ? 0 : sandeagoItemInfoArr.length;
                SandeagoItemInfo[] sandeagoItemInfoArr2 = new SandeagoItemInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.itemInfo, 0, sandeagoItemInfoArr2, 0, length);
                }
                while (length < sandeagoItemInfoArr2.length - 1) {
                    sandeagoItemInfoArr2[length] = new SandeagoItemInfo();
                    codedInputByteBufferNano.readMessage(sandeagoItemInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                sandeagoItemInfoArr2[length] = new SandeagoItemInfo();
                codedInputByteBufferNano.readMessage(sandeagoItemInfoArr2[length]);
                this.itemInfo = sandeagoItemInfoArr2;
            }
        }
    }

    public static SCSandeagoControl parseFrom(byte[] bArr) {
        return (SCSandeagoControl) MessageNano.mergeFrom(new SCSandeagoControl(), bArr);
    }

    public static SCSandeagoControl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCSandeagoControl().mergeFrom(codedInputByteBufferNano);
    }
}
