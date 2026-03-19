package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class AryaCapabilities extends MessageNano {
    private static volatile AryaCapabilities[] _emptyArray;
    public boolean packedMuteStatus;
    public boolean supportAudioCtrlMsg;
    public boolean supportDiffRoster;
    public boolean supportH264Nack;
    public boolean supportH265Decode;
    public boolean supportMuteStatusV3;
    public boolean supportNetworkQuality;

    public static AryaCapabilities[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new AryaCapabilities[0];
                }
            }
        }
        return _emptyArray;
    }

    public AryaCapabilities() {
        clear();
    }

    public final AryaCapabilities clear() {
        this.packedMuteStatus = false;
        this.supportNetworkQuality = false;
        this.supportMuteStatusV3 = false;
        this.supportDiffRoster = false;
        this.supportAudioCtrlMsg = false;
        this.supportH264Nack = false;
        this.supportH265Decode = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        boolean z = this.packedMuteStatus;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        boolean z2 = this.supportNetworkQuality;
        if (z2) {
            codedOutputByteBufferNano.writeBool(2, z2);
        }
        boolean z3 = this.supportMuteStatusV3;
        if (z3) {
            codedOutputByteBufferNano.writeBool(3, z3);
        }
        boolean z4 = this.supportDiffRoster;
        if (z4) {
            codedOutputByteBufferNano.writeBool(4, z4);
        }
        boolean z5 = this.supportAudioCtrlMsg;
        if (z5) {
            codedOutputByteBufferNano.writeBool(5, z5);
        }
        boolean z6 = this.supportH264Nack;
        if (z6) {
            codedOutputByteBufferNano.writeBool(6, z6);
        }
        boolean z7 = this.supportH265Decode;
        if (z7) {
            codedOutputByteBufferNano.writeBool(7, z7);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        boolean z = this.packedMuteStatus;
        if (z) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        boolean z2 = this.supportNetworkQuality;
        if (z2) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z2);
        }
        boolean z3 = this.supportMuteStatusV3;
        if (z3) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z3);
        }
        boolean z4 = this.supportDiffRoster;
        if (z4) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(4, z4);
        }
        boolean z5 = this.supportAudioCtrlMsg;
        if (z5) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z5);
        }
        boolean z6 = this.supportH264Nack;
        if (z6) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z6);
        }
        boolean z7 = this.supportH265Decode;
        return z7 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(7, z7) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final AryaCapabilities mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                this.packedMuteStatus = codedInputByteBufferNano.readBool();
            } else if (tag == 16) {
                this.supportNetworkQuality = codedInputByteBufferNano.readBool();
            } else if (tag == 24) {
                this.supportMuteStatusV3 = codedInputByteBufferNano.readBool();
            } else if (tag == 32) {
                this.supportDiffRoster = codedInputByteBufferNano.readBool();
            } else if (tag == 40) {
                this.supportAudioCtrlMsg = codedInputByteBufferNano.readBool();
            } else if (tag == 48) {
                this.supportH264Nack = codedInputByteBufferNano.readBool();
            } else if (tag != 56) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.supportH265Decode = codedInputByteBufferNano.readBool();
            }
        }
    }

    public static AryaCapabilities parseFrom(byte[] bArr) {
        return (AryaCapabilities) MessageNano.mergeFrom(new AryaCapabilities(), bArr);
    }

    public static AryaCapabilities parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new AryaCapabilities().mergeFrom(codedInputByteBufferNano);
    }
}
