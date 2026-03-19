package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveGiftPanelRefresh extends MessageNano {
    private static volatile SCLiveGiftPanelRefresh[] _emptyArray;
    public int actionMode;
    public boolean disablePreloadMagicFaceResource;
    public boolean enableRefreshPanelTab;
    public boolean enableRefreshPanelUi;
    public long giftPanelMaxDelayMills;
    public int refreshMode;
    public int refreshTab;

    public static SCLiveGiftPanelRefresh[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveGiftPanelRefresh[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveGiftPanelRefresh() {
        clear();
    }

    public final SCLiveGiftPanelRefresh clear() {
        this.giftPanelMaxDelayMills = 0L;
        this.disablePreloadMagicFaceResource = false;
        this.refreshTab = 0;
        this.enableRefreshPanelUi = false;
        this.refreshMode = 0;
        this.enableRefreshPanelTab = false;
        this.actionMode = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        long j = this.giftPanelMaxDelayMills;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(1, j);
        }
        boolean z = this.disablePreloadMagicFaceResource;
        if (z) {
            codedOutputByteBufferNano.writeBool(2, z);
        }
        int i = this.refreshTab;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(3, i);
        }
        boolean z2 = this.enableRefreshPanelUi;
        if (z2) {
            codedOutputByteBufferNano.writeBool(4, z2);
        }
        int i2 = this.refreshMode;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(5, i2);
        }
        boolean z3 = this.enableRefreshPanelTab;
        if (z3) {
            codedOutputByteBufferNano.writeBool(6, z3);
        }
        int i3 = this.actionMode;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeUInt32(7, i3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        long j = this.giftPanelMaxDelayMills;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
        }
        boolean z = this.disablePreloadMagicFaceResource;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
        }
        int i = this.refreshTab;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
        }
        boolean z2 = this.enableRefreshPanelUi;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z2);
        }
        int i2 = this.refreshMode;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(5, i2);
        }
        boolean z3 = this.enableRefreshPanelTab;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z3);
        }
        int i3 = this.actionMode;
        return i3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveGiftPanelRefresh mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.giftPanelMaxDelayMills = codedInputByteBufferNano.readUInt64();
            } else if (tag == 16) {
                this.disablePreloadMagicFaceResource = codedInputByteBufferNano.readBool();
            } else if (tag == 24) {
                this.refreshTab = codedInputByteBufferNano.readUInt32();
            } else if (tag == 32) {
                this.enableRefreshPanelUi = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.refreshMode = codedInputByteBufferNano.readUInt32();
            } else if (tag == 48) {
                this.enableRefreshPanelTab = codedInputByteBufferNano.readBool();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.actionMode = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static SCLiveGiftPanelRefresh parseFrom(byte[] bArr) {
        return (SCLiveGiftPanelRefresh) MessageNano.mergeFrom(new SCLiveGiftPanelRefresh(), bArr);
    }

    public static SCLiveGiftPanelRefresh parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveGiftPanelRefresh().mergeFrom(codedInputByteBufferNano);
    }
}
