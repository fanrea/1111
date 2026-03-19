package com.kuaishou.protobuf.livestream.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class LiveUserStateDisplaySegments extends MessageNano {
    private static volatile LiveUserStateDisplaySegments[] _emptyArray;
    public UserStateRichTextSegment[] userStateSegment;

    public static LiveUserStateDisplaySegments[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new LiveUserStateDisplaySegments[0];
                }
            }
        }
        return _emptyArray;
    }

    public LiveUserStateDisplaySegments() {
        clear();
    }

    public final LiveUserStateDisplaySegments clear() {
        this.userStateSegment = UserStateRichTextSegment.emptyArray();
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
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
        return iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final LiveUserStateDisplaySegments mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            if (tag == 0) {
                return this;
            }
            if (tag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                    return this;
                }
            } else {
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
            }
        }
    }

    public static LiveUserStateDisplaySegments parseFrom(byte[] bArr) {
        return (LiveUserStateDisplaySegments) MessageNano.mergeFrom(new LiveUserStateDisplaySegments(), bArr);
    }

    public static LiveUserStateDisplaySegments parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new LiveUserStateDisplaySegments().mergeFrom(codedInputByteBufferNano);
    }
}
