package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCAuthorMusicOpened extends MessageNano {
    private static volatile SCAuthorMusicOpened[] _emptyArray;
    public String liveStreamId;
    public AuthorMusicInfo musicInfo;
    public int sequence;
    public int source;

    public static SCAuthorMusicOpened[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCAuthorMusicOpened[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCAuthorMusicOpened() {
        clear();
    }

    public final SCAuthorMusicOpened clear() {
        this.liveStreamId = "";
        this.sequence = 0;
        this.musicInfo = null;
        this.source = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.liveStreamId);
        }
        int i = this.sequence;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i);
        }
        AuthorMusicInfo authorMusicInfo = this.musicInfo;
        if (authorMusicInfo != null) {
            codedOutputByteBufferNano.writeMessage(3, authorMusicInfo);
        }
        int i2 = this.source;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
        }
        int i = this.sequence;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
        }
        AuthorMusicInfo authorMusicInfo = this.musicInfo;
        if (authorMusicInfo != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, authorMusicInfo);
        }
        int i2 = this.source;
        return i2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeInt32Size(4, i2) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCAuthorMusicOpened mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.sequence = codedInputByteBufferNano.readUInt32();
            } else if (tag == 26) {
                if (this.musicInfo == null) {
                    this.musicInfo = new AuthorMusicInfo();
                }
                codedInputByteBufferNano.readMessage(this.musicInfo);
            } else if (tag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.source = int32;
                }
            }
        }
    }

    public static SCAuthorMusicOpened parseFrom(byte[] bArr) {
        return (SCAuthorMusicOpened) MessageNano.mergeFrom(new SCAuthorMusicOpened(), bArr);
    }

    public static SCAuthorMusicOpened parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCAuthorMusicOpened().mergeFrom(codedInputByteBufferNano);
    }
}
