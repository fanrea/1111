package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LivePunishAnimationInfoSource extends MessageNano {
    private static volatile LivePunishAnimationInfoSource[] _emptyArray;
    public String maskColor;
    public LivePunishAnimationInfo[] punishAnimationInfo;
    public String punishAudioDefaultResource;
    public String punishAudioResource;
    public String punishDividerDefaultResource;
    public String punishDividerResource;

    public static LivePunishAnimationInfoSource[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LivePunishAnimationInfoSource[0];
                }
            }
        }
        return _emptyArray;
    }

    public LivePunishAnimationInfoSource() {
        clear();
    }

    public final LivePunishAnimationInfoSource clear() {
        this.punishAnimationInfo = LivePunishAnimationInfo.emptyArray();
        this.punishAudioResource = "";
        this.punishAudioDefaultResource = "";
        this.maskColor = "";
        this.punishDividerResource = "";
        this.punishDividerDefaultResource = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        LivePunishAnimationInfo[] livePunishAnimationInfoArr = this.punishAnimationInfo;
        if (livePunishAnimationInfoArr != null && livePunishAnimationInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LivePunishAnimationInfo[] livePunishAnimationInfoArr2 = this.punishAnimationInfo;
                if (i >= livePunishAnimationInfoArr2.length) {
                    break;
                }
                LivePunishAnimationInfo livePunishAnimationInfo = livePunishAnimationInfoArr2[i];
                if (livePunishAnimationInfo != null) {
                    codedOutputByteBufferNano.writeMessage(1, livePunishAnimationInfo);
                }
                i++;
            }
        }
        if (!this.punishAudioResource.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.punishAudioResource);
        }
        if (!this.punishAudioDefaultResource.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.punishAudioDefaultResource);
        }
        if (!this.maskColor.equals("")) {
            codedOutputByteBufferNano.writeString(5, this.maskColor);
        }
        if (!this.punishDividerResource.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.punishDividerResource);
        }
        if (!this.punishDividerDefaultResource.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.punishDividerDefaultResource);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        LivePunishAnimationInfo[] livePunishAnimationInfoArr = this.punishAnimationInfo;
        if (livePunishAnimationInfoArr != null && livePunishAnimationInfoArr.length > 0) {
            int i = 0;
            while (true) {
                LivePunishAnimationInfo[] livePunishAnimationInfoArr2 = this.punishAnimationInfo;
                if (i >= livePunishAnimationInfoArr2.length) {
                    break;
                }
                LivePunishAnimationInfo livePunishAnimationInfo = livePunishAnimationInfoArr2[i];
                if (livePunishAnimationInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, livePunishAnimationInfo);
                }
                i++;
            }
        }
        if (!this.punishAudioResource.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.punishAudioResource);
        }
        if (!this.punishAudioDefaultResource.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.punishAudioDefaultResource);
        }
        if (!this.maskColor.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.maskColor);
        }
        if (!this.punishDividerResource.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.punishDividerResource);
        }
        return !this.punishDividerDefaultResource.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.punishDividerDefaultResource) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LivePunishAnimationInfoSource mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                LivePunishAnimationInfo[] livePunishAnimationInfoArr = this.punishAnimationInfo;
                int length = livePunishAnimationInfoArr == null ? 0 : livePunishAnimationInfoArr.length;
                LivePunishAnimationInfo[] livePunishAnimationInfoArr2 = new LivePunishAnimationInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.punishAnimationInfo, 0, livePunishAnimationInfoArr2, 0, length);
                }
                while (length < livePunishAnimationInfoArr2.length - 1) {
                    livePunishAnimationInfoArr2[length] = new LivePunishAnimationInfo();
                    codedInputByteBufferNano.readMessage(livePunishAnimationInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                livePunishAnimationInfoArr2[length] = new LivePunishAnimationInfo();
                codedInputByteBufferNano.readMessage(livePunishAnimationInfoArr2[length]);
                this.punishAnimationInfo = livePunishAnimationInfoArr2;
            } else if (tag == 26) {
                this.punishAudioResource = codedInputByteBufferNano.readString();
            } else if (tag == 34) {
                this.punishAudioDefaultResource = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.maskColor = codedInputByteBufferNano.readString();
            } else if (tag == 50) {
                this.punishDividerResource = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.punishDividerDefaultResource = codedInputByteBufferNano.readString();
            }
        }
    }

    public static LivePunishAnimationInfoSource parseFrom(byte[] bArr) {
        return (LivePunishAnimationInfoSource) MessageNano.mergeFrom(new LivePunishAnimationInfoSource(), bArr);
    }

    public static LivePunishAnimationInfoSource parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LivePunishAnimationInfoSource().mergeFrom(codedInputByteBufferNano);
    }
}
