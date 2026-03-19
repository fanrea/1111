package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveGiftPanelSubItem extends MessageNano {
    private static volatile LiveGiftPanelSubItem[] _emptyArray;
    public boolean hasSubGiftSendAuthority;
    public LiveGiftPanelItemDisplay itemDisplayView;
    public LiveGiftPromptInfo itemPromptInfo;
    public int itemType;
    public String jumpLink;
    public LiveGiftPromptInfo sendPromptInfo;

    public static LiveGiftPanelSubItem[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveGiftPanelSubItem[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveGiftPanelSubItem() {
        clear();
    }

    public final LiveGiftPanelSubItem clear() {
        this.hasSubGiftSendAuthority = false;
        this.sendPromptInfo = null;
        this.itemType = 0;
        this.jumpLink = "";
        this.itemDisplayView = null;
        this.itemPromptInfo = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.hasSubGiftSendAuthority;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        LiveGiftPromptInfo liveGiftPromptInfo = this.sendPromptInfo;
        if (liveGiftPromptInfo != null) {
            codedOutputByteBufferNano.writeMessage(2, liveGiftPromptInfo);
        }
        int i = this.itemType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        if (!this.jumpLink.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.jumpLink);
        }
        LiveGiftPanelItemDisplay liveGiftPanelItemDisplay = this.itemDisplayView;
        if (liveGiftPanelItemDisplay != null) {
            codedOutputByteBufferNano.writeMessage(5, liveGiftPanelItemDisplay);
        }
        LiveGiftPromptInfo liveGiftPromptInfo2 = this.itemPromptInfo;
        if (liveGiftPromptInfo2 != null) {
            codedOutputByteBufferNano.writeMessage(6, liveGiftPromptInfo2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.hasSubGiftSendAuthority;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        LiveGiftPromptInfo liveGiftPromptInfo = this.sendPromptInfo;
        if (liveGiftPromptInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveGiftPromptInfo);
        }
        int i = this.itemType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        if (!this.jumpLink.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.jumpLink);
        }
        LiveGiftPanelItemDisplay liveGiftPanelItemDisplay = this.itemDisplayView;
        if (liveGiftPanelItemDisplay != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveGiftPanelItemDisplay);
        }
        LiveGiftPromptInfo liveGiftPromptInfo2 = this.itemPromptInfo;
        return liveGiftPromptInfo2 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(6, liveGiftPromptInfo2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveGiftPanelSubItem mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.hasSubGiftSendAuthority = codedInputByteBufferNano.readBool();
            } else if (tag == 18) {
                if (this.sendPromptInfo == null) {
                    this.sendPromptInfo = new LiveGiftPromptInfo();
                }
                codedInputByteBufferNano.readMessage(this.sendPromptInfo);
            } else if (tag == 24) {
                this.itemType = codedInputByteBufferNano.readUInt32();
            } else if (tag == 34) {
                this.jumpLink = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                if (this.itemDisplayView == null) {
                    this.itemDisplayView = new LiveGiftPanelItemDisplay();
                }
                codedInputByteBufferNano.readMessage(this.itemDisplayView);
            } else if (tag != 50) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                if (this.itemPromptInfo == null) {
                    this.itemPromptInfo = new LiveGiftPromptInfo();
                }
                codedInputByteBufferNano.readMessage(this.itemPromptInfo);
            }
        }
    }

    public static LiveGiftPanelSubItem parseFrom(byte[] bArr) {
        return (LiveGiftPanelSubItem) MessageNano.mergeFrom(new LiveGiftPanelSubItem(), bArr);
    }

    public static LiveGiftPanelSubItem parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveGiftPanelSubItem().mergeFrom(codedInputByteBufferNano);
    }
}
