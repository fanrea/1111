package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCLiveVoicePartyToast extends MessageNano {
    private static volatile SCLiveVoicePartyToast[] _emptyArray;
    public String content;
    public long displayDuration;
    public String id;
    public int level;
    public String liveStreamId;
    public long time;
    public String voicePartyId;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Level {
        public static final int ERROR = 3;
        public static final int INFO = 1;
        public static final int UNKNOWN = 0;
        public static final int WARN = 2;
    }

    public static SCLiveVoicePartyToast[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveVoicePartyToast[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveVoicePartyToast() {
        clear();
    }

    public final SCLiveVoicePartyToast clear() {
        this.id = "";
        this.time = 0L;
        this.content = "";
        this.displayDuration = 0L;
        this.level = 0;
        this.liveStreamId = "";
        this.voicePartyId = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.id.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.id);
        }
        long j = this.time;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(2, j);
        }
        if (!this.content.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.content);
        }
        long j2 = this.displayDuration;
        if (j2 != 0) {
            codedOutputByteBufferNano.writeUInt64(4, j2);
        }
        int i = this.level;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(6, this.liveStreamId);
        }
        if (!this.voicePartyId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.voicePartyId);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.id.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
        }
        long j = this.time;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
        }
        if (!this.content.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.content);
        }
        long j2 = this.displayDuration;
        if (j2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j2);
        }
        int i = this.level;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(5, i);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.liveStreamId);
        }
        return !this.voicePartyId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.voicePartyId) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveVoicePartyToast mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                this.id = codedInputByteBufferNano.readString();
            } else if (tag == 16) {
                this.time = codedInputByteBufferNano.readUInt64();
            } else if (tag == 26) {
                this.content = codedInputByteBufferNano.readString();
            } else if (tag == 32) {
                this.displayDuration = codedInputByteBufferNano.readUInt64();
            } else if (tag == 40) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2 || int32 == 3) {
                    this.level = int32;
                }
            } else if (tag == 50) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag != 58) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.voicePartyId = codedInputByteBufferNano.readString();
            }
        }
    }

    public static SCLiveVoicePartyToast parseFrom(byte[] bArr) {
        return (SCLiveVoicePartyToast) MessageNano.mergeFrom(new SCLiveVoicePartyToast(), bArr);
    }

    public static SCLiveVoicePartyToast parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveVoicePartyToast().mergeFrom(codedInputByteBufferNano);
    }
}
