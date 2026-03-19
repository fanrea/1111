package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftPanelItem extends MessageNano {
    private static volatile LiveGiftPanelItem[] _emptyArray;
    public long defaultSelectedGiftId;
    public boolean enableClosePanelAfterSend;
    public LiveGiftPanelItemDisplay itemDisplayView;
    public long itemId;
    public int itemType;
    public boolean replaceable;
    public LiveGiftPanelSubItem[] subItems;

    public static LiveGiftPanelItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftPanelItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftPanelItem() {
        clear();
    }

    public final LiveGiftPanelItem clear() {
        this.itemType = 0;
        this.itemId = 0L;
        this.replaceable = false;
        this.itemDisplayView = null;
        this.enableClosePanelAfterSend = false;
        this.defaultSelectedGiftId = 0L;
        this.subItems = LiveGiftPanelSubItem.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.itemType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        long j = this.itemId;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        boolean z = this.replaceable;
        if (z) {
            codedOutputByteBufferNano.writeBool(3, z);
        }
        LiveGiftPanelItemDisplay liveGiftPanelItemDisplay = this.itemDisplayView;
        if (liveGiftPanelItemDisplay != null) {
            codedOutputByteBufferNano.writeMessage(4, liveGiftPanelItemDisplay);
        }
        boolean z2 = this.enableClosePanelAfterSend;
        if (z2) {
            codedOutputByteBufferNano.writeBool(5, z2);
        }
        long j2 = this.defaultSelectedGiftId;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j2);
        }
        LiveGiftPanelSubItem[] liveGiftPanelSubItemArr = this.subItems;
        if (liveGiftPanelSubItemArr != null && liveGiftPanelSubItemArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveGiftPanelSubItem[] liveGiftPanelSubItemArr2 = this.subItems;
                if (i2 >= liveGiftPanelSubItemArr2.length) {
                    break;
                }
                LiveGiftPanelSubItem liveGiftPanelSubItem = liveGiftPanelSubItemArr2[i2];
                if (liveGiftPanelSubItem != null) {
                    codedOutputByteBufferNano.writeMessage(7, liveGiftPanelSubItem);
                }
                i2++;
            }
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.itemType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        long j = this.itemId;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        boolean z = this.replaceable;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
        }
        LiveGiftPanelItemDisplay liveGiftPanelItemDisplay = this.itemDisplayView;
        if (liveGiftPanelItemDisplay != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveGiftPanelItemDisplay);
        }
        boolean z2 = this.enableClosePanelAfterSend;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z2);
        }
        long j2 = this.defaultSelectedGiftId;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
        }
        LiveGiftPanelSubItem[] liveGiftPanelSubItemArr = this.subItems;
        if (liveGiftPanelSubItemArr != null && liveGiftPanelSubItemArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveGiftPanelSubItem[] liveGiftPanelSubItemArr2 = this.subItems;
                if (i2 >= liveGiftPanelSubItemArr2.length) {
                    break;
                }
                LiveGiftPanelSubItem liveGiftPanelSubItem = liveGiftPanelSubItemArr2[i2];
                if (liveGiftPanelSubItem != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveGiftPanelSubItem);
                }
                i2++;
            }
        }
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftPanelItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.itemType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.itemId = codedInputByteBufferNano.readUInt64();
            } else if (tag == 24) {
                this.replaceable = codedInputByteBufferNano.readBool();
            } else if (tag == 34) {
                if (this.itemDisplayView == null) {
                    this.itemDisplayView = new LiveGiftPanelItemDisplay();
                }
                codedInputByteBufferNano.readMessage(this.itemDisplayView);
            } else if (tag == 40) {
                this.enableClosePanelAfterSend = codedInputByteBufferNano.readBool();
            } else if (tag == 48) {
                this.defaultSelectedGiftId = codedInputByteBufferNano.readUInt64();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                LiveGiftPanelSubItem[] liveGiftPanelSubItemArr = this.subItems;
                int length = liveGiftPanelSubItemArr == null ? 0 : liveGiftPanelSubItemArr.length;
                LiveGiftPanelSubItem[] liveGiftPanelSubItemArr2 = new LiveGiftPanelSubItem[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.subItems, 0, liveGiftPanelSubItemArr2, 0, length);
                }
                while (length < liveGiftPanelSubItemArr2.length - 1) {
                    liveGiftPanelSubItemArr2[length] = new LiveGiftPanelSubItem();
                    codedInputByteBufferNano.readMessage(liveGiftPanelSubItemArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveGiftPanelSubItemArr2[length] = new LiveGiftPanelSubItem();
                codedInputByteBufferNano.readMessage(liveGiftPanelSubItemArr2[length]);
                this.subItems = liveGiftPanelSubItemArr2;
            }
        }
    }

    public static LiveGiftPanelItem parseFrom(byte[] bArr) {
        return (LiveGiftPanelItem) MessageNano.mergeFrom(new LiveGiftPanelItem(), bArr);
    }

    public static LiveGiftPanelItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftPanelItem().mergeFrom(codedInputByteBufferNano);
    }
}
