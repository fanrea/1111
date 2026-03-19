package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePunishAnimationInfo extends MessageNano {
    private static volatile LivePunishAnimationInfo[] _emptyArray;
    public int maskAlphaPercent;
    public int maskAnimationAlphaPercent;
    public int maxPercent;
    public int minPercent;
    public String punishAnimationResource;
    public String punishDefaultResource;
    public String windowBorderColor;

    public static LivePunishAnimationInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePunishAnimationInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePunishAnimationInfo() {
        clear();
    }

    public final LivePunishAnimationInfo clear() {
        this.minPercent = 0;
        this.maxPercent = 0;
        this.punishAnimationResource = "";
        this.punishDefaultResource = "";
        this.maskAlphaPercent = 0;
        this.maskAnimationAlphaPercent = 0;
        this.windowBorderColor = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.minPercent;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.maxPercent;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        if (!this.punishAnimationResource.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.punishAnimationResource);
        }
        if (!this.punishDefaultResource.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.punishDefaultResource);
        }
        int i3 = this.maskAlphaPercent;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(5, i3);
        }
        int i4 = this.maskAnimationAlphaPercent;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        if (!this.windowBorderColor.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.windowBorderColor);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.minPercent;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.maxPercent;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        if (!this.punishAnimationResource.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.punishAnimationResource);
        }
        if (!this.punishDefaultResource.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.punishDefaultResource);
        }
        int i3 = this.maskAlphaPercent;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i3);
        }
        int i4 = this.maskAnimationAlphaPercent;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        return !this.windowBorderColor.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.windowBorderColor) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePunishAnimationInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.minPercent = codedInputByteBufferNano.readUInt32();
            } else if (tag == 16) {
                this.maxPercent = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                this.punishAnimationResource = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.punishDefaultResource = codedInputByteBufferNano.readString();
            } else if (tag == 40) {
                this.maskAlphaPercent = codedInputByteBufferNano.readInt32();
            } else if (tag == 48) {
                this.maskAnimationAlphaPercent = codedInputByteBufferNano.readInt32();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.windowBorderColor = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LivePunishAnimationInfo parseFrom(byte[] bArr) {
        return (LivePunishAnimationInfo) MessageNano.mergeFrom(new LivePunishAnimationInfo(), bArr);
    }

    public static LivePunishAnimationInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePunishAnimationInfo().mergeFrom(codedInputByteBufferNano);
    }
}
