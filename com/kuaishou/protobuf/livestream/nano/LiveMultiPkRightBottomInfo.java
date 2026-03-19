package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveMultiPkRightBottomInfo extends MessageNano {
    private static volatile LiveMultiPkRightBottomInfo[] _emptyArray;
    public boolean disableShowFollowButton;
    public boolean disableShowMuteIcon;
    public boolean disableShowUserName;

    public static LiveMultiPkRightBottomInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveMultiPkRightBottomInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveMultiPkRightBottomInfo() {
        clear();
    }

    public final LiveMultiPkRightBottomInfo clear() {
        this.disableShowMuteIcon = false;
        this.disableShowUserName = false;
        this.disableShowFollowButton = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.disableShowMuteIcon;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        boolean z2 = this.disableShowUserName;
        if (z2) {
            codedOutputByteBufferNano.writeBool(2, z2);
        }
        boolean z3 = this.disableShowFollowButton;
        if (z3) {
            codedOutputByteBufferNano.writeBool(3, z3);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.disableShowMuteIcon;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        boolean z2 = this.disableShowUserName;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
        }
        boolean z3 = this.disableShowFollowButton;
        return z3 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(3, z3) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveMultiPkRightBottomInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.disableShowMuteIcon = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.disableShowUserName = codedInputByteBufferNano.readBool();
            } else if (tag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.disableShowFollowButton = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static LiveMultiPkRightBottomInfo parseFrom(byte[] bArr) {
        return (LiveMultiPkRightBottomInfo) MessageNano.mergeFrom(new LiveMultiPkRightBottomInfo(), bArr);
    }

    public static LiveMultiPkRightBottomInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveMultiPkRightBottomInfo().mergeFrom(codedInputByteBufferNano);
    }
}
