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
public final class LiveRichTextUserState extends MessageNano {
    private static volatile LiveRichTextUserState[] _emptyArray;
    public Map<Integer, LiveFeedBackground> feedBackground;
    public UserStateRichTextSegment[] userStateSegment;

    public static LiveRichTextUserState[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveRichTextUserState[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveRichTextUserState() {
        clear();
    }

    public final LiveRichTextUserState clear() {
        this.userStateSegment = UserStateRichTextSegment.emptyArray();
        this.feedBackground = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        UserStateRichTextSegment[] userStateRichTextSegmentArr = this.userStateSegment;
        if (userStateRichTextSegmentArr != null && userStateRichTextSegmentArr.length > 0) {
            int i = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr2 = this.userStateSegment;
                if (i >= userStateRichTextSegmentArr2.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment = userStateRichTextSegmentArr2[i];
                if (userStateRichTextSegment != null) {
                    codedOutputByteBufferNano.writeMessage(1, userStateRichTextSegment);
                }
                i++;
            }
        }
        Map<Integer, LiveFeedBackground> map = this.feedBackground;
        if (map != null) {
            InternalNano.serializeMapField(codedOutputByteBufferNano, map, 2, 5, 11);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        UserStateRichTextSegment[] userStateRichTextSegmentArr = this.userStateSegment;
        if (userStateRichTextSegmentArr != null && userStateRichTextSegmentArr.length > 0) {
            int i = 0;
            while (true) {
                UserStateRichTextSegment[] userStateRichTextSegmentArr2 = this.userStateSegment;
                if (i >= userStateRichTextSegmentArr2.length) {
                    break;
                }
                UserStateRichTextSegment userStateRichTextSegment = userStateRichTextSegmentArr2[i];
                if (userStateRichTextSegment != null) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userStateRichTextSegment);
                }
                i++;
            }
        }
        Map<Integer, LiveFeedBackground> map = this.feedBackground;
        return map != null ? iComputeSerializedSize + InternalNano.computeMapFieldSize(map, 2, 5, 11) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveRichTextUserState mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        MapFactories.MapFactory mapFactory = MapFactories.getMapFactory();
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag == 10) {
                int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                UserStateRichTextSegment[] userStateRichTextSegmentArr = this.userStateSegment;
                int length = userStateRichTextSegmentArr == null ? 0 : userStateRichTextSegmentArr.length;
                UserStateRichTextSegment[] userStateRichTextSegmentArr2 = new UserStateRichTextSegment[repeatedFieldArrayLength + length];
                if (length != 0) {
                    System.arraycopy(this.userStateSegment, 0, userStateRichTextSegmentArr2, 0, length);
                }
                while (length < userStateRichTextSegmentArr2.length - 1) {
                    userStateRichTextSegmentArr2[length] = new UserStateRichTextSegment();
                    codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr2[length]);
                    codedInputByteBufferNano.readTag();
                    length++;
                }
                userStateRichTextSegmentArr2[length] = new UserStateRichTextSegment();
                codedInputByteBufferNano.readMessage(userStateRichTextSegmentArr2[length]);
                this.userStateSegment = userStateRichTextSegmentArr2;
            } else if (tag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
                this.feedBackground = InternalNano.mergeMapEntry(codedInputByteBufferNano, this.feedBackground, mapFactory, 5, 11, new LiveFeedBackground(), 8, 18);
            }
        }
    }

    public static LiveRichTextUserState parseFrom(byte[] bArr) {
        return (LiveRichTextUserState) MessageNano.mergeFrom(new LiveRichTextUserState(), bArr);
    }

    public static LiveRichTextUserState parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveRichTextUserState().mergeFrom(codedInputByteBufferNano);
    }
}
