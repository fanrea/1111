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
public final class SCLiveHotspotRankShow extends MessageNano {
    private static volatile SCLiveHotspotRankShow[] _emptyArray;
    public int liveHotspotRankEntranceType;
    public LiveHotspotSimpleInfo[] rankInfo;
    public String text;
    public long timestamp;
    public String url;

    @Retention(RetentionPolicy.SOURCE)
    public @interface LiveHotspotRankEntranceType {
        public static final int LIVE_HOTSPOT_KEY_AUTHOR = 2;
        public static final int LIVE_HOTSPOT_RANK = 1;
        public static final int UNKNOWN_ENTRANCE_TYPE = 0;
    }

    public static SCLiveHotspotRankShow[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCLiveHotspotRankShow[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCLiveHotspotRankShow() {
        clear();
    }

    public final SCLiveHotspotRankShow clear() {
        this.liveHotspotRankEntranceType = 0;
        this.text = "";
        this.rankInfo = LiveHotspotSimpleInfo.emptyArray();
        this.url = "";
        this.timestamp = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        int i = this.liveHotspotRankEntranceType;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(1, i);
        }
        if (!this.text.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.text);
        }
        LiveHotspotSimpleInfo[] liveHotspotSimpleInfoArr = this.rankInfo;
        if (liveHotspotSimpleInfoArr != null && liveHotspotSimpleInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveHotspotSimpleInfo[] liveHotspotSimpleInfoArr2 = this.rankInfo;
                if (i2 >= liveHotspotSimpleInfoArr2.length) {
                    break;
                }
                LiveHotspotSimpleInfo liveHotspotSimpleInfo = liveHotspotSimpleInfoArr2[i2];
                if (liveHotspotSimpleInfo != null) {
                    codedOutputByteBufferNano.writeMessage(3, liveHotspotSimpleInfo);
                }
                i2++;
            }
        }
        if (!this.url.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.url);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        int i = this.liveHotspotRankEntranceType;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i);
        }
        if (!this.text.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.text);
        }
        LiveHotspotSimpleInfo[] liveHotspotSimpleInfoArr = this.rankInfo;
        if (liveHotspotSimpleInfoArr != null && liveHotspotSimpleInfoArr.length > 0) {
            int i2 = 0;
            while (true) {
                LiveHotspotSimpleInfo[] liveHotspotSimpleInfoArr2 = this.rankInfo;
                if (i2 >= liveHotspotSimpleInfoArr2.length) {
                    break;
                }
                LiveHotspotSimpleInfo liveHotspotSimpleInfo = liveHotspotSimpleInfoArr2[i2];
                if (liveHotspotSimpleInfo != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveHotspotSimpleInfo);
                }
                i2++;
            }
        }
        if (!this.url.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.url);
        }
        long j = this.timestamp;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCLiveHotspotRankShow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 8) {
                int int32 = codedInputByteBufferNano.readInt32();
                if (int32 == 0 || int32 == 1 || int32 == 2) {
                    this.liveHotspotRankEntranceType = int32;
                }
            } else if (tag == 18) {
                this.text = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                LiveHotspotSimpleInfo[] liveHotspotSimpleInfoArr = this.rankInfo;
                int length = liveHotspotSimpleInfoArr == null ? 0 : liveHotspotSimpleInfoArr.length;
                LiveHotspotSimpleInfo[] liveHotspotSimpleInfoArr2 = new LiveHotspotSimpleInfo[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.rankInfo, 0, liveHotspotSimpleInfoArr2, 0, length);
                }
                while (length < liveHotspotSimpleInfoArr2.length - 1) {
                    liveHotspotSimpleInfoArr2[length] = new LiveHotspotSimpleInfo();
                    codedInputByteBufferNano.readMessage(liveHotspotSimpleInfoArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                liveHotspotSimpleInfoArr2[length] = new LiveHotspotSimpleInfo();
                codedInputByteBufferNano.readMessage(liveHotspotSimpleInfoArr2[length]);
                this.rankInfo = liveHotspotSimpleInfoArr2;
            } else if (tag == 34) {
                this.url = codedInputByteBufferNano.readString();
            } else if (tag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.timestamp = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCLiveHotspotRankShow parseFrom(byte[] bArr) {
        return (SCLiveHotspotRankShow) MessageNano.mergeFrom(new SCLiveHotspotRankShow(), bArr);
    }

    public static SCLiveHotspotRankShow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCLiveHotspotRankShow().mergeFrom(codedInputByteBufferNano);
    }
}
