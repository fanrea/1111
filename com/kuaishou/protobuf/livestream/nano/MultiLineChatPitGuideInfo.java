package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class MultiLineChatPitGuideInfo extends MessageNano {
    private static volatile MultiLineChatPitGuideInfo[] _emptyArray;
    public int inviteeSourceType;
    public String inviteeUserInfo;

    public static MultiLineChatPitGuideInfo[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new MultiLineChatPitGuideInfo[0];
                }
            }
        }
        return _emptyArray;
    }

    public MultiLineChatPitGuideInfo() {
        clear();
    }

    public final MultiLineChatPitGuideInfo clear() {
        this.inviteeUserInfo = "";
        this.inviteeSourceType = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.inviteeUserInfo.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.inviteeUserInfo);
        }
        int i = this.inviteeSourceType;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.inviteeUserInfo.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.inviteeUserInfo);
        }
        int i = this.inviteeSourceType;
        return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(2, i) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final MultiLineChatPitGuideInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.inviteeUserInfo = codedInputByteBufferNano.readString();
            } else if (tag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.inviteeSourceType = codedInputByteBufferNano.readUInt32();
            }
        }
    }

    public static MultiLineChatPitGuideInfo parseFrom(byte[] bArr) {
        return (MultiLineChatPitGuideInfo) MessageNano.mergeFrom(new MultiLineChatPitGuideInfo(), bArr);
    }

    public static MultiLineChatPitGuideInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new MultiLineChatPitGuideInfo().mergeFrom(codedInputByteBufferNano);
    }
}
