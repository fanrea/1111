package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MapFactories;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class SCInteractiveChatInfoUpdate extends MessageNano {
    private static volatile SCInteractiveChatInfoUpdate[] _emptyArray;
    public InteractiveChatBizIdentity bizIdentity;
    public String liveStreamId;
    public Map<String, Boolean> muteState;
    public String sessionId;
    public Map<String, InteractiveChatUserCommonInfo> userCommonInfos;
    public long version;

    public static SCInteractiveChatInfoUpdate[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new SCInteractiveChatInfoUpdate[0];
                }
            }
        }
        return _emptyArray;
    }

    public SCInteractiveChatInfoUpdate() {
        clear();
    }

    public final SCInteractiveChatInfoUpdate clear() {
        this.bizIdentity = null;
        this.liveStreamId = "";
        this.muteState = null;
        this.sessionId = "";
        this.userCommonInfos = null;
        this.version = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            codedOutputByteBufferNano.writeMessage(1, interactiveChatBizIdentity);
        }
        if (!this.liveStreamId.equals("")) {
            codedOutputByteBufferNano.writeString(2, this.liveStreamId);
        }
        Map<String, Boolean> map = this.muteState;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 3, 9, 8);
        }
        if (!this.sessionId.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.sessionId);
        }
        Map<String, InteractiveChatUserCommonInfo> map2 = this.userCommonInfos;
        if (map2 != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map2, 5, 9, 11);
        }
        long j = this.version;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(6, j);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        InteractiveChatBizIdentity interactiveChatBizIdentity = this.bizIdentity;
        if (interactiveChatBizIdentity != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, interactiveChatBizIdentity);
        }
        if (!this.liveStreamId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.liveStreamId);
        }
        Map<String, Boolean> map = this.muteState;
        if (map != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map, 3, 9, 8);
        }
        if (!this.sessionId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.sessionId);
        }
        Map<String, InteractiveChatUserCommonInfo> map2 = this.userCommonInfos;
        if (map2 != null) {
            iComputeSerializedSize += InternalNano.computeMapFieldSize(map2, 5, 9, 11);
        }
        long j = this.version;
        return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(6, j) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final SCInteractiveChatInfoUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                if (this.bizIdentity == null) {
                    this.bizIdentity = new InteractiveChatBizIdentity();
                }
                codedInputByteBufferNano.readMessage(this.bizIdentity);
            } else if (tag == 18) {
                this.liveStreamId = codedInputByteBufferNano.readString();
            } else if (tag == 26) {
                this.muteState = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.muteState, mapFactory, 9, 8, null, 10, 16);
            } else if (tag == 34) {
                this.sessionId = codedInputByteBufferNano.readString();
            } else if (tag == 42) {
                this.userCommonInfos = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.userCommonInfos, mapFactory, 9, 11, new InteractiveChatUserCommonInfo(), 10, 18);
            } else if (tag != 48) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.version = codedInputByteBufferNano.readUInt64();
            }
        }
    }

    public static SCInteractiveChatInfoUpdate parseFrom(byte[] bArr) {
        return (SCInteractiveChatInfoUpdate) MessageNano.mergeFrom(new SCInteractiveChatInfoUpdate(), bArr);
    }

    public static SCInteractiveChatInfoUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new SCInteractiveChatInfoUpdate().mergeFrom(codedInputByteBufferNano);
    }
}
