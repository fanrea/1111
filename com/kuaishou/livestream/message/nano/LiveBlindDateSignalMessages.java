package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveBlindDateSignalMessages {

    public static final class SCLiveBlindDateOpen extends MessageNano {
        private static volatile SCLiveBlindDateOpen[] _emptyArray;
        public long time;

        public static SCLiveBlindDateOpen[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateOpen[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateOpen() {
            clear();
        }

        public final SCLiveBlindDateOpen clear() {
            this.time = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.time;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.time;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateOpen mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.time = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveBlindDateOpen parseFrom(byte[] bArr) {
            return (SCLiveBlindDateOpen) MessageNano.mergeFrom(new SCLiveBlindDateOpen(), bArr);
        }

        public static SCLiveBlindDateOpen parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateOpen().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateClose extends MessageNano {
        private static volatile SCLiveBlindDateClose[] _emptyArray;
        public long time;

        public static SCLiveBlindDateClose[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateClose[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateClose() {
            clear();
        }

        public final SCLiveBlindDateClose clear() {
            this.time = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.time;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.time;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(1, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateClose mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag != 8) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.time = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveBlindDateClose parseFrom(byte[] bArr) {
            return (SCLiveBlindDateClose) MessageNano.mergeFrom(new SCLiveBlindDateClose(), bArr);
        }

        public static SCLiveBlindDateClose parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateClose().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateChatServiceNotice extends MessageNano {
        private static volatile SCLiveBlindDateChatServiceNotice[] _emptyArray;
        public String content;
        public String liveStreamId;
        public String title;

        public static SCLiveBlindDateChatServiceNotice[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateChatServiceNotice[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateChatServiceNotice() {
            clear();
        }

        public final SCLiveBlindDateChatServiceNotice clear() {
            this.liveStreamId = "";
            this.title = "";
            this.content = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.content);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            return !this.content.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.content) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateChatServiceNotice mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.content = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveBlindDateChatServiceNotice parseFrom(byte[] bArr) {
            return (SCLiveBlindDateChatServiceNotice) MessageNano.mergeFrom(new SCLiveBlindDateChatServiceNotice(), bArr);
        }

        public static SCLiveBlindDateChatServiceNotice parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateChatServiceNotice().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateChatServiceCall extends MessageNano {
        private static volatile SCLiveBlindDateChatServiceCall[] _emptyArray;
        public String content;
        public long countDownMillis;
        public String liveStreamId;
        public String sessionId;
        public String title;

        public static SCLiveBlindDateChatServiceCall[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateChatServiceCall[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateChatServiceCall() {
            clear();
        }

        public final SCLiveBlindDateChatServiceCall clear() {
            this.liveStreamId = "";
            this.sessionId = "";
            this.countDownMillis = 0L;
            this.title = "";
            this.content = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.sessionId);
            }
            long j = this.countDownMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.title);
            }
            if (!this.content.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.content);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.sessionId);
            }
            long j = this.countDownMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.title);
            }
            return !this.content.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(5, this.content) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateChatServiceCall mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.sessionId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.countDownMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 34) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.content = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveBlindDateChatServiceCall parseFrom(byte[] bArr) {
            return (SCLiveBlindDateChatServiceCall) MessageNano.mergeFrom(new SCLiveBlindDateChatServiceCall(), bArr);
        }

        public static SCLiveBlindDateChatServiceCall parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateChatServiceCall().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateChatServiceStart extends MessageNano {
        private static volatile SCLiveBlindDateChatServiceStart[] _emptyArray;
        public String liveStreamId;
        public LiveBlindDateChatServiceUser[] servingUser;
        public String sessionId;

        public static final class LiveBlindDateChatServiceUser extends MessageNano {
            private static volatile LiveBlindDateChatServiceUser[] _emptyArray;
            public String gender;
            public boolean paidServing;
            public long userId;

            public static LiveBlindDateChatServiceUser[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new LiveBlindDateChatServiceUser[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public LiveBlindDateChatServiceUser() {
                clear();
            }

            public final LiveBlindDateChatServiceUser clear() {
                this.userId = 0L;
                this.paidServing = false;
                this.gender = "";
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                long j = this.userId;
                if (j != 0) {
                    codedOutputByteBufferNano.writeUInt64(1, j);
                }
                boolean z = this.paidServing;
                if (z) {
                    codedOutputByteBufferNano.writeBool(2, z);
                }
                if (!this.gender.equals("")) {
                    codedOutputByteBufferNano.writeString(3, this.gender);
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                long j = this.userId;
                if (j != 0) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
                }
                boolean z = this.paidServing;
                if (z) {
                    iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(2, z);
                }
                return !this.gender.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.gender) : iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final LiveBlindDateChatServiceUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 8) {
                        this.userId = codedInputByteBufferNano.readUInt64();
                    } else if (tag == 16) {
                        this.paidServing = codedInputByteBufferNano.readBool();
                    } else if (tag != 26) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        this.gender = codedInputByteBufferNano.readString();
                    }
                }
            }

            public static LiveBlindDateChatServiceUser parseFrom(byte[] bArr) {
                return (LiveBlindDateChatServiceUser) MessageNano.mergeFrom(new LiveBlindDateChatServiceUser(), bArr);
            }

            public static LiveBlindDateChatServiceUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new LiveBlindDateChatServiceUser().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static SCLiveBlindDateChatServiceStart[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateChatServiceStart[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateChatServiceStart() {
            clear();
        }

        public final SCLiveBlindDateChatServiceStart clear() {
            this.liveStreamId = "";
            this.sessionId = "";
            this.servingUser = LiveBlindDateChatServiceUser.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.sessionId);
            }
            LiveBlindDateChatServiceUser[] liveBlindDateChatServiceUserArr = this.servingUser;
            if (liveBlindDateChatServiceUserArr != null && liveBlindDateChatServiceUserArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveBlindDateChatServiceUser[] liveBlindDateChatServiceUserArr2 = this.servingUser;
                    if (i >= liveBlindDateChatServiceUserArr2.length) {
                        break;
                    }
                    LiveBlindDateChatServiceUser liveBlindDateChatServiceUser = liveBlindDateChatServiceUserArr2[i];
                    if (liveBlindDateChatServiceUser != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveBlindDateChatServiceUser);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.sessionId);
            }
            LiveBlindDateChatServiceUser[] liveBlindDateChatServiceUserArr = this.servingUser;
            if (liveBlindDateChatServiceUserArr != null && liveBlindDateChatServiceUserArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveBlindDateChatServiceUser[] liveBlindDateChatServiceUserArr2 = this.servingUser;
                    if (i >= liveBlindDateChatServiceUserArr2.length) {
                        break;
                    }
                    LiveBlindDateChatServiceUser liveBlindDateChatServiceUser = liveBlindDateChatServiceUserArr2[i];
                    if (liveBlindDateChatServiceUser != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveBlindDateChatServiceUser);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateChatServiceStart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.sessionId = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveBlindDateChatServiceUser[] liveBlindDateChatServiceUserArr = this.servingUser;
                    int length = liveBlindDateChatServiceUserArr == null ? 0 : liveBlindDateChatServiceUserArr.length;
                    LiveBlindDateChatServiceUser[] liveBlindDateChatServiceUserArr2 = new LiveBlindDateChatServiceUser[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.servingUser, 0, liveBlindDateChatServiceUserArr2, 0, length);
                    }
                    while (length < liveBlindDateChatServiceUserArr2.length - 1) {
                        liveBlindDateChatServiceUserArr2[length] = new LiveBlindDateChatServiceUser();
                        codedInputByteBufferNano.readMessage(liveBlindDateChatServiceUserArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveBlindDateChatServiceUserArr2[length] = new LiveBlindDateChatServiceUser();
                    codedInputByteBufferNano.readMessage(liveBlindDateChatServiceUserArr2[length]);
                    this.servingUser = liveBlindDateChatServiceUserArr2;
                }
            }
        }

        public static SCLiveBlindDateChatServiceStart parseFrom(byte[] bArr) {
            return (SCLiveBlindDateChatServiceStart) MessageNano.mergeFrom(new SCLiveBlindDateChatServiceStart(), bArr);
        }

        public static SCLiveBlindDateChatServiceStart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateChatServiceStart().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateChatServiceEnd extends MessageNano {
        private static volatile SCLiveBlindDateChatServiceEnd[] _emptyArray;
        public String liveStreamId;
        public long[] paidServingUserId;
        public String sessionId;
        public boolean showReview;

        public static SCLiveBlindDateChatServiceEnd[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateChatServiceEnd[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateChatServiceEnd() {
            clear();
        }

        public final SCLiveBlindDateChatServiceEnd clear() {
            this.liveStreamId = "";
            this.sessionId = "";
            this.showReview = false;
            this.paidServingUserId = WireFormatNano.EMPTY_LONG_ARRAY;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.sessionId);
            }
            boolean z = this.showReview;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            long[] jArr = this.paidServingUserId;
            if (jArr != null && jArr.length > 0) {
                int i = 0;
                while (true) {
                    long[] jArr2 = this.paidServingUserId;
                    if (i >= jArr2.length) {
                        break;
                    }
                    codedOutputByteBufferNano.writeUInt64(4, jArr2[i]);
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.sessionId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.sessionId);
            }
            boolean z = this.showReview;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            long[] jArr = this.paidServingUserId;
            if (jArr == null || jArr.length <= 0) {
                return iComputeSerializedSize;
            }
            int i = 0;
            int iComputeUInt64SizeNoTag = 0;
            while (true) {
                long[] jArr2 = this.paidServingUserId;
                if (i < jArr2.length) {
                    iComputeUInt64SizeNoTag += CodedOutputByteBufferNano.computeUInt64SizeNoTag(jArr2[i]);
                    i++;
                } else {
                    return iComputeSerializedSize + iComputeUInt64SizeNoTag + (jArr2.length * 1);
                }
            }
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateChatServiceEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.sessionId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.showReview = codedInputByteBufferNano.readBool();
                } else if (tag == 32) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 32);
                    long[] jArr = this.paidServingUserId;
                    int length = jArr == null ? 0 : jArr.length;
                    long[] jArr2 = new long[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.paidServingUserId, 0, jArr2, 0, length);
                    }
                    while (length < jArr2.length - 1) {
                        jArr2[length] = codedInputByteBufferNano.readUInt64();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    jArr2[length] = codedInputByteBufferNano.readUInt64();
                    this.paidServingUserId = jArr2;
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int iPushLimit = codedInputByteBufferNano.pushLimit(codedInputByteBufferNano.readRawVarint32());
                    int position = codedInputByteBufferNano.getPosition();
                    int i = 0;
                    while (codedInputByteBufferNano.getBytesUntilLimit() > 0) {
                        codedInputByteBufferNano.readUInt64();
                        i++;
                    }
                    codedInputByteBufferNano.rewindToPosition(position);
                    long[] jArr3 = this.paidServingUserId;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    long[] jArr4 = new long[i + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.paidServingUserId, 0, jArr4, 0, length2);
                    }
                    while (length2 < jArr4.length) {
                        jArr4[length2] = codedInputByteBufferNano.readUInt64();
                        length2++;
                    }
                    this.paidServingUserId = jArr4;
                    codedInputByteBufferNano.popLimit(iPushLimit);
                }
            }
        }

        public static SCLiveBlindDateChatServiceEnd parseFrom(byte[] bArr) {
            return (SCLiveBlindDateChatServiceEnd) MessageNano.mergeFrom(new SCLiveBlindDateChatServiceEnd(), bArr);
        }

        public static SCLiveBlindDateChatServiceEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateChatServiceEnd().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateShowAudiencePendant extends MessageNano {
        private static volatile SCLiveBlindDateShowAudiencePendant[] _emptyArray;
        public String bizId;
        public String buttonLinkUrl;
        public String contentKey;
        public String guideDescription;
        public String highlightDescription;
        public String largeGuideDescription;
        public PendantImageInfo largeImgInfo;
        public String liveStreamId;
        public String pendantLinkUrl;
        public long pendantStyle;
        public PendantImageInfo smallImgInfo;
        public String topImgLinkUrl;

        public static final class PendantImageInfo extends MessageNano {
            private static volatile PendantImageInfo[] _emptyArray;
            public UserInfos.PicUrl[] backgroundImgUrl;
            public UserInfos.PicUrl[] buttonImgUrl;
            public UserInfos.PicUrl[] topImgUrl;

            public static PendantImageInfo[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new PendantImageInfo[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public PendantImageInfo() {
                clear();
            }

            public final PendantImageInfo clear() {
                this.backgroundImgUrl = UserInfos.PicUrl.emptyArray();
                this.topImgUrl = UserInfos.PicUrl.emptyArray();
                this.buttonImgUrl = UserInfos.PicUrl.emptyArray();
                this.cachedSize = -1;
                return this;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
                UserInfos.PicUrl[] picUrlArr = this.backgroundImgUrl;
                int i = 0;
                if (picUrlArr != null && picUrlArr.length > 0) {
                    int i2 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr2 = this.backgroundImgUrl;
                        if (i2 >= picUrlArr2.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl = picUrlArr2[i2];
                        if (picUrl != null) {
                            codedOutputByteBufferNano.writeMessage(1, picUrl);
                        }
                        i2++;
                    }
                }
                UserInfos.PicUrl[] picUrlArr3 = this.topImgUrl;
                if (picUrlArr3 != null && picUrlArr3.length > 0) {
                    int i3 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr4 = this.topImgUrl;
                        if (i3 >= picUrlArr4.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                        if (picUrl2 != null) {
                            codedOutputByteBufferNano.writeMessage(2, picUrl2);
                        }
                        i3++;
                    }
                }
                UserInfos.PicUrl[] picUrlArr5 = this.buttonImgUrl;
                if (picUrlArr5 != null && picUrlArr5.length > 0) {
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr6 = this.buttonImgUrl;
                        if (i >= picUrlArr6.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                        if (picUrl3 != null) {
                            codedOutputByteBufferNano.writeMessage(3, picUrl3);
                        }
                        i++;
                    }
                }
                super.writeTo(codedOutputByteBufferNano);
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final int computeSerializedSize() {
                int iComputeSerializedSize = super.computeSerializedSize();
                UserInfos.PicUrl[] picUrlArr = this.backgroundImgUrl;
                int i = 0;
                if (picUrlArr != null && picUrlArr.length > 0) {
                    int iComputeMessageSize = iComputeSerializedSize;
                    int i2 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr2 = this.backgroundImgUrl;
                        if (i2 >= picUrlArr2.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl = picUrlArr2[i2];
                        if (picUrl != null) {
                            iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                        }
                        i2++;
                    }
                    iComputeSerializedSize = iComputeMessageSize;
                }
                UserInfos.PicUrl[] picUrlArr3 = this.topImgUrl;
                if (picUrlArr3 != null && picUrlArr3.length > 0) {
                    int iComputeMessageSize2 = iComputeSerializedSize;
                    int i3 = 0;
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr4 = this.topImgUrl;
                        if (i3 >= picUrlArr4.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                        if (picUrl2 != null) {
                            iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(2, picUrl2);
                        }
                        i3++;
                    }
                    iComputeSerializedSize = iComputeMessageSize2;
                }
                UserInfos.PicUrl[] picUrlArr5 = this.buttonImgUrl;
                if (picUrlArr5 != null && picUrlArr5.length > 0) {
                    while (true) {
                        UserInfos.PicUrl[] picUrlArr6 = this.buttonImgUrl;
                        if (i >= picUrlArr6.length) {
                            break;
                        }
                        UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                        if (picUrl3 != null) {
                            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl3);
                        }
                        i++;
                    }
                }
                return iComputeSerializedSize;
            }

            @Override // com.google.protobuf.nano.MessageNano
            public final PendantImageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
                while (true) {
                    int tag = codedInputByteBufferNano.readTag();
                    if (tag == 0) {
                        return this;
                    }
                    if (tag == 10) {
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        UserInfos.PicUrl[] picUrlArr = this.backgroundImgUrl;
                        int length = picUrlArr == null ? 0 : picUrlArr.length;
                        UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.backgroundImgUrl, 0, picUrlArr2, 0, length);
                        }
                        while (length < picUrlArr2.length - 1) {
                            picUrlArr2[length] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        this.backgroundImgUrl = picUrlArr2;
                    } else if (tag == 18) {
                        int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                        UserInfos.PicUrl[] picUrlArr3 = this.topImgUrl;
                        int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                        UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                        if (length2 != 0) {
                            System.arraycopy(this.topImgUrl, 0, picUrlArr4, 0, length2);
                        }
                        while (length2 < picUrlArr4.length - 1) {
                            picUrlArr4[length2] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                            codedInputByteBufferNano.readTag();
                            length2++;
                        }
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        this.topImgUrl = picUrlArr4;
                    } else if (tag != 26) {
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                    } else {
                        int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                        UserInfos.PicUrl[] picUrlArr5 = this.buttonImgUrl;
                        int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                        UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                        if (length3 != 0) {
                            System.arraycopy(this.buttonImgUrl, 0, picUrlArr6, 0, length3);
                        }
                        while (length3 < picUrlArr6.length - 1) {
                            picUrlArr6[length3] = new UserInfos.PicUrl();
                            codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                            codedInputByteBufferNano.readTag();
                            length3++;
                        }
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        this.buttonImgUrl = picUrlArr6;
                    }
                }
            }

            public static PendantImageInfo parseFrom(byte[] bArr) {
                return (PendantImageInfo) MessageNano.mergeFrom(new PendantImageInfo(), bArr);
            }

            public static PendantImageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
                return new PendantImageInfo().mergeFrom(codedInputByteBufferNano);
            }
        }

        public static SCLiveBlindDateShowAudiencePendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateShowAudiencePendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateShowAudiencePendant() {
            clear();
        }

        public final SCLiveBlindDateShowAudiencePendant clear() {
            this.liveStreamId = "";
            this.pendantStyle = 0L;
            this.largeImgInfo = null;
            this.smallImgInfo = null;
            this.topImgLinkUrl = "";
            this.buttonLinkUrl = "";
            this.guideDescription = "";
            this.highlightDescription = "";
            this.contentKey = "";
            this.bizId = "";
            this.pendantLinkUrl = "";
            this.largeGuideDescription = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            long j = this.pendantStyle;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            PendantImageInfo pendantImageInfo = this.largeImgInfo;
            if (pendantImageInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, pendantImageInfo);
            }
            PendantImageInfo pendantImageInfo2 = this.smallImgInfo;
            if (pendantImageInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(4, pendantImageInfo2);
            }
            if (!this.topImgLinkUrl.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.topImgLinkUrl);
            }
            if (!this.buttonLinkUrl.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.buttonLinkUrl);
            }
            if (!this.guideDescription.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.guideDescription);
            }
            if (!this.highlightDescription.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.highlightDescription);
            }
            if (!this.contentKey.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.contentKey);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.bizId);
            }
            if (!this.pendantLinkUrl.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.pendantLinkUrl);
            }
            if (!this.largeGuideDescription.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.largeGuideDescription);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            long j = this.pendantStyle;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            PendantImageInfo pendantImageInfo = this.largeImgInfo;
            if (pendantImageInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, pendantImageInfo);
            }
            PendantImageInfo pendantImageInfo2 = this.smallImgInfo;
            if (pendantImageInfo2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, pendantImageInfo2);
            }
            if (!this.topImgLinkUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.topImgLinkUrl);
            }
            if (!this.buttonLinkUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.buttonLinkUrl);
            }
            if (!this.guideDescription.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.guideDescription);
            }
            if (!this.highlightDescription.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.highlightDescription);
            }
            if (!this.contentKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.contentKey);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.bizId);
            }
            if (!this.pendantLinkUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.pendantLinkUrl);
            }
            return !this.largeGuideDescription.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.largeGuideDescription) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateShowAudiencePendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.pendantStyle = codedInputByteBufferNano.readUInt64();
                        break;
                    case 26:
                        if (this.largeImgInfo == null) {
                            this.largeImgInfo = new PendantImageInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.largeImgInfo);
                        break;
                    case 34:
                        if (this.smallImgInfo == null) {
                            this.smallImgInfo = new PendantImageInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.smallImgInfo);
                        break;
                    case 42:
                        this.topImgLinkUrl = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.buttonLinkUrl = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.guideDescription = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.highlightDescription = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.contentKey = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.bizId = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.pendantLinkUrl = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.largeGuideDescription = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveBlindDateShowAudiencePendant parseFrom(byte[] bArr) {
            return (SCLiveBlindDateShowAudiencePendant) MessageNano.mergeFrom(new SCLiveBlindDateShowAudiencePendant(), bArr);
        }

        public static SCLiveBlindDateShowAudiencePendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateShowAudiencePendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateHideAudiencePendant extends MessageNano {
        private static volatile SCLiveBlindDateHideAudiencePendant[] _emptyArray;
        public String liveStreamId;

        public static SCLiveBlindDateHideAudiencePendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateHideAudiencePendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateHideAudiencePendant() {
            clear();
        }

        public final SCLiveBlindDateHideAudiencePendant clear() {
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateHideAudiencePendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveBlindDateHideAudiencePendant parseFrom(byte[] bArr) {
            return (SCLiveBlindDateHideAudiencePendant) MessageNano.mergeFrom(new SCLiveBlindDateHideAudiencePendant(), bArr);
        }

        public static SCLiveBlindDateHideAudiencePendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateHideAudiencePendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateTryUpdateAudiencePendant extends MessageNano {
        private static volatile SCLiveBlindDateTryUpdateAudiencePendant[] _emptyArray;
        public String bizId;
        public boolean delayRefresh;
        public String extraInfo;
        public String highlightDescription;
        public String liveStreamId;
        public long maxDelayMillis;
        public int version;

        public static SCLiveBlindDateTryUpdateAudiencePendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateTryUpdateAudiencePendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateTryUpdateAudiencePendant() {
            clear();
        }

        public final SCLiveBlindDateTryUpdateAudiencePendant clear() {
            this.liveStreamId = "";
            this.highlightDescription = "";
            this.delayRefresh = false;
            this.maxDelayMillis = 0L;
            this.bizId = "";
            this.extraInfo = "";
            this.version = 0;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.highlightDescription.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.highlightDescription);
            }
            boolean z = this.delayRefresh;
            if (z) {
                codedOutputByteBufferNano.writeBool(3, z);
            }
            long j = this.maxDelayMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.bizId);
            }
            if (!this.extraInfo.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.extraInfo);
            }
            int i = this.version;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(7, i);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.highlightDescription.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.highlightDescription);
            }
            boolean z = this.delayRefresh;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(3, z);
            }
            long j = this.maxDelayMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.bizId);
            }
            if (!this.extraInfo.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.extraInfo);
            }
            int i = this.version;
            return i != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt32Size(7, i) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateTryUpdateAudiencePendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.highlightDescription = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.delayRefresh = codedInputByteBufferNano.readBool();
                } else if (tag == 32) {
                    this.maxDelayMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    this.bizId = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.extraInfo = codedInputByteBufferNano.readString();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.version = codedInputByteBufferNano.readUInt32();
                }
            }
        }

        public static SCLiveBlindDateTryUpdateAudiencePendant parseFrom(byte[] bArr) {
            return (SCLiveBlindDateTryUpdateAudiencePendant) MessageNano.mergeFrom(new SCLiveBlindDateTryUpdateAudiencePendant(), bArr);
        }

        public static SCLiveBlindDateTryUpdateAudiencePendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateTryUpdateAudiencePendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateShowAuthorPendant extends MessageNano {
        private static volatile SCLiveBlindDateShowAuthorPendant[] _emptyArray;
        public String bizId;
        public String buttonLinkUrl;
        public String contentKey;
        public String guideDescription;
        public String highlightDescription;
        public String largeGuideDescription;
        public LiveBlindDatePendantImageInfo largeImgInfo;
        public String liveStreamId;
        public String pendantLinkUrl;
        public long pendantStyle;
        public LiveBlindDatePendantImageInfo smallImgInfo;
        public String topImgLinkUrl;

        public static SCLiveBlindDateShowAuthorPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateShowAuthorPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateShowAuthorPendant() {
            clear();
        }

        public final SCLiveBlindDateShowAuthorPendant clear() {
            this.liveStreamId = "";
            this.pendantStyle = 0L;
            this.largeImgInfo = null;
            this.smallImgInfo = null;
            this.topImgLinkUrl = "";
            this.buttonLinkUrl = "";
            this.guideDescription = "";
            this.highlightDescription = "";
            this.contentKey = "";
            this.bizId = "";
            this.pendantLinkUrl = "";
            this.largeGuideDescription = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            long j = this.pendantStyle;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            LiveBlindDatePendantImageInfo liveBlindDatePendantImageInfo = this.largeImgInfo;
            if (liveBlindDatePendantImageInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, liveBlindDatePendantImageInfo);
            }
            LiveBlindDatePendantImageInfo liveBlindDatePendantImageInfo2 = this.smallImgInfo;
            if (liveBlindDatePendantImageInfo2 != null) {
                codedOutputByteBufferNano.writeMessage(4, liveBlindDatePendantImageInfo2);
            }
            if (!this.topImgLinkUrl.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.topImgLinkUrl);
            }
            if (!this.buttonLinkUrl.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.buttonLinkUrl);
            }
            if (!this.guideDescription.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.guideDescription);
            }
            if (!this.highlightDescription.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.highlightDescription);
            }
            if (!this.contentKey.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.contentKey);
            }
            if (!this.bizId.equals("")) {
                codedOutputByteBufferNano.writeString(10, this.bizId);
            }
            if (!this.pendantLinkUrl.equals("")) {
                codedOutputByteBufferNano.writeString(11, this.pendantLinkUrl);
            }
            if (!this.largeGuideDescription.equals("")) {
                codedOutputByteBufferNano.writeString(12, this.largeGuideDescription);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            long j = this.pendantStyle;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            LiveBlindDatePendantImageInfo liveBlindDatePendantImageInfo = this.largeImgInfo;
            if (liveBlindDatePendantImageInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveBlindDatePendantImageInfo);
            }
            LiveBlindDatePendantImageInfo liveBlindDatePendantImageInfo2 = this.smallImgInfo;
            if (liveBlindDatePendantImageInfo2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveBlindDatePendantImageInfo2);
            }
            if (!this.topImgLinkUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.topImgLinkUrl);
            }
            if (!this.buttonLinkUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.buttonLinkUrl);
            }
            if (!this.guideDescription.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.guideDescription);
            }
            if (!this.highlightDescription.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.highlightDescription);
            }
            if (!this.contentKey.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.contentKey);
            }
            if (!this.bizId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.bizId);
            }
            if (!this.pendantLinkUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(11, this.pendantLinkUrl);
            }
            return !this.largeGuideDescription.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(12, this.largeGuideDescription) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateShowAuthorPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        this.liveStreamId = codedInputByteBufferNano.readString();
                        break;
                    case 16:
                        this.pendantStyle = codedInputByteBufferNano.readUInt64();
                        break;
                    case 26:
                        if (this.largeImgInfo == null) {
                            this.largeImgInfo = new LiveBlindDatePendantImageInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.largeImgInfo);
                        break;
                    case 34:
                        if (this.smallImgInfo == null) {
                            this.smallImgInfo = new LiveBlindDatePendantImageInfo();
                        }
                        codedInputByteBufferNano.readMessage(this.smallImgInfo);
                        break;
                    case 42:
                        this.topImgLinkUrl = codedInputByteBufferNano.readString();
                        break;
                    case 50:
                        this.buttonLinkUrl = codedInputByteBufferNano.readString();
                        break;
                    case 58:
                        this.guideDescription = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.highlightDescription = codedInputByteBufferNano.readString();
                        break;
                    case 74:
                        this.contentKey = codedInputByteBufferNano.readString();
                        break;
                    case 82:
                        this.bizId = codedInputByteBufferNano.readString();
                        break;
                    case 90:
                        this.pendantLinkUrl = codedInputByteBufferNano.readString();
                        break;
                    case 98:
                        this.largeGuideDescription = codedInputByteBufferNano.readString();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static SCLiveBlindDateShowAuthorPendant parseFrom(byte[] bArr) {
            return (SCLiveBlindDateShowAuthorPendant) MessageNano.mergeFrom(new SCLiveBlindDateShowAuthorPendant(), bArr);
        }

        public static SCLiveBlindDateShowAuthorPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateShowAuthorPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveBlindDatePendantImageInfo extends MessageNano {
        private static volatile LiveBlindDatePendantImageInfo[] _emptyArray;
        public UserInfos.PicUrl[] backgroundImgUrl;
        public UserInfos.PicUrl[] buttonImgUrl;
        public UserInfos.PicUrl[] topImgUrl;

        public static LiveBlindDatePendantImageInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveBlindDatePendantImageInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveBlindDatePendantImageInfo() {
            clear();
        }

        public final LiveBlindDatePendantImageInfo clear() {
            this.backgroundImgUrl = UserInfos.PicUrl.emptyArray();
            this.topImgUrl = UserInfos.PicUrl.emptyArray();
            this.buttonImgUrl = UserInfos.PicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.PicUrl[] picUrlArr = this.backgroundImgUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundImgUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        codedOutputByteBufferNano.writeMessage(1, picUrl);
                    }
                    i2++;
                }
            }
            UserInfos.PicUrl[] picUrlArr3 = this.topImgUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.topImgUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        codedOutputByteBufferNano.writeMessage(2, picUrl2);
                    }
                    i3++;
                }
            }
            UserInfos.PicUrl[] picUrlArr5 = this.buttonImgUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.buttonImgUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        codedOutputByteBufferNano.writeMessage(3, picUrl3);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.PicUrl[] picUrlArr = this.backgroundImgUrl;
            int i = 0;
            if (picUrlArr != null && picUrlArr.length > 0) {
                int iComputeMessageSize = iComputeSerializedSize;
                int i2 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr2 = this.backgroundImgUrl;
                    if (i2 >= picUrlArr2.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl = picUrlArr2[i2];
                    if (picUrl != null) {
                        iComputeMessageSize += CodedOutputByteBufferNano.computeMessageSize(1, picUrl);
                    }
                    i2++;
                }
                iComputeSerializedSize = iComputeMessageSize;
            }
            UserInfos.PicUrl[] picUrlArr3 = this.topImgUrl;
            if (picUrlArr3 != null && picUrlArr3.length > 0) {
                int iComputeMessageSize2 = iComputeSerializedSize;
                int i3 = 0;
                while (true) {
                    UserInfos.PicUrl[] picUrlArr4 = this.topImgUrl;
                    if (i3 >= picUrlArr4.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl2 = picUrlArr4[i3];
                    if (picUrl2 != null) {
                        iComputeMessageSize2 += CodedOutputByteBufferNano.computeMessageSize(2, picUrl2);
                    }
                    i3++;
                }
                iComputeSerializedSize = iComputeMessageSize2;
            }
            UserInfos.PicUrl[] picUrlArr5 = this.buttonImgUrl;
            if (picUrlArr5 != null && picUrlArr5.length > 0) {
                while (true) {
                    UserInfos.PicUrl[] picUrlArr6 = this.buttonImgUrl;
                    if (i >= picUrlArr6.length) {
                        break;
                    }
                    UserInfos.PicUrl picUrl3 = picUrlArr6[i];
                    if (picUrl3 != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, picUrl3);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveBlindDatePendantImageInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    UserInfos.PicUrl[] picUrlArr = this.backgroundImgUrl;
                    int length = picUrlArr == null ? 0 : picUrlArr.length;
                    UserInfos.PicUrl[] picUrlArr2 = new UserInfos.PicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.backgroundImgUrl, 0, picUrlArr2, 0, length);
                    }
                    while (length < picUrlArr2.length - 1) {
                        picUrlArr2[length] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    picUrlArr2[length] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr2[length]);
                    this.backgroundImgUrl = picUrlArr2;
                } else if (tag == 18) {
                    int repeatedFieldArrayLength2 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    UserInfos.PicUrl[] picUrlArr3 = this.topImgUrl;
                    int length2 = picUrlArr3 == null ? 0 : picUrlArr3.length;
                    UserInfos.PicUrl[] picUrlArr4 = new UserInfos.PicUrl[repeatedFieldArrayLength2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.topImgUrl, 0, picUrlArr4, 0, length2);
                    }
                    while (length2 < picUrlArr4.length - 1) {
                        picUrlArr4[length2] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                        codedInputByteBufferNano.readTag();
                        length2++;
                    }
                    picUrlArr4[length2] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr4[length2]);
                    this.topImgUrl = picUrlArr4;
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength3 = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    UserInfos.PicUrl[] picUrlArr5 = this.buttonImgUrl;
                    int length3 = picUrlArr5 == null ? 0 : picUrlArr5.length;
                    UserInfos.PicUrl[] picUrlArr6 = new UserInfos.PicUrl[repeatedFieldArrayLength3 + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.buttonImgUrl, 0, picUrlArr6, 0, length3);
                    }
                    while (length3 < picUrlArr6.length - 1) {
                        picUrlArr6[length3] = new UserInfos.PicUrl();
                        codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                        codedInputByteBufferNano.readTag();
                        length3++;
                    }
                    picUrlArr6[length3] = new UserInfos.PicUrl();
                    codedInputByteBufferNano.readMessage(picUrlArr6[length3]);
                    this.buttonImgUrl = picUrlArr6;
                }
            }
        }

        public static LiveBlindDatePendantImageInfo parseFrom(byte[] bArr) {
            return (LiveBlindDatePendantImageInfo) MessageNano.mergeFrom(new LiveBlindDatePendantImageInfo(), bArr);
        }

        public static LiveBlindDatePendantImageInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveBlindDatePendantImageInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBlindDateHideAuthorPendant extends MessageNano {
        private static volatile SCLiveBlindDateHideAuthorPendant[] _emptyArray;
        public String liveStreamId;

        public static SCLiveBlindDateHideAuthorPendant[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBlindDateHideAuthorPendant[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBlindDateHideAuthorPendant() {
            clear();
        }

        public final SCLiveBlindDateHideAuthorPendant clear() {
            this.liveStreamId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.liveStreamId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBlindDateHideAuthorPendant mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.liveStreamId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveBlindDateHideAuthorPendant parseFrom(byte[] bArr) {
            return (SCLiveBlindDateHideAuthorPendant) MessageNano.mergeFrom(new SCLiveBlindDateHideAuthorPendant(), bArr);
        }

        public static SCLiveBlindDateHideAuthorPendant parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBlindDateHideAuthorPendant().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveBlindDateShowFlow extends MessageNano {
        private static volatile LiveBlindDateShowFlow[] _emptyArray;
        public DisplayFlowStage displayFlow;
        public BlindDateFlowStage[] flowItem;

        public static LiveBlindDateShowFlow[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveBlindDateShowFlow[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveBlindDateShowFlow() {
            clear();
        }

        public final LiveBlindDateShowFlow clear() {
            this.flowItem = BlindDateFlowStage.emptyArray();
            this.displayFlow = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            BlindDateFlowStage[] blindDateFlowStageArr = this.flowItem;
            if (blindDateFlowStageArr != null && blindDateFlowStageArr.length > 0) {
                int i = 0;
                while (true) {
                    BlindDateFlowStage[] blindDateFlowStageArr2 = this.flowItem;
                    if (i >= blindDateFlowStageArr2.length) {
                        break;
                    }
                    BlindDateFlowStage blindDateFlowStage = blindDateFlowStageArr2[i];
                    if (blindDateFlowStage != null) {
                        codedOutputByteBufferNano.writeMessage(1, blindDateFlowStage);
                    }
                    i++;
                }
            }
            DisplayFlowStage displayFlowStage = this.displayFlow;
            if (displayFlowStage != null) {
                codedOutputByteBufferNano.writeMessage(2, displayFlowStage);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            BlindDateFlowStage[] blindDateFlowStageArr = this.flowItem;
            if (blindDateFlowStageArr != null && blindDateFlowStageArr.length > 0) {
                int i = 0;
                while (true) {
                    BlindDateFlowStage[] blindDateFlowStageArr2 = this.flowItem;
                    if (i >= blindDateFlowStageArr2.length) {
                        break;
                    }
                    BlindDateFlowStage blindDateFlowStage = blindDateFlowStageArr2[i];
                    if (blindDateFlowStage != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, blindDateFlowStage);
                    }
                    i++;
                }
            }
            DisplayFlowStage displayFlowStage = this.displayFlow;
            return displayFlowStage != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, displayFlowStage) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveBlindDateShowFlow mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    BlindDateFlowStage[] blindDateFlowStageArr = this.flowItem;
                    int length = blindDateFlowStageArr == null ? 0 : blindDateFlowStageArr.length;
                    BlindDateFlowStage[] blindDateFlowStageArr2 = new BlindDateFlowStage[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.flowItem, 0, blindDateFlowStageArr2, 0, length);
                    }
                    while (length < blindDateFlowStageArr2.length - 1) {
                        blindDateFlowStageArr2[length] = new BlindDateFlowStage();
                        codedInputByteBufferNano.readMessage(blindDateFlowStageArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    blindDateFlowStageArr2[length] = new BlindDateFlowStage();
                    codedInputByteBufferNano.readMessage(blindDateFlowStageArr2[length]);
                    this.flowItem = blindDateFlowStageArr2;
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.displayFlow == null) {
                        this.displayFlow = new DisplayFlowStage();
                    }
                    codedInputByteBufferNano.readMessage(this.displayFlow);
                }
            }
        }

        public static LiveBlindDateShowFlow parseFrom(byte[] bArr) {
            return (LiveBlindDateShowFlow) MessageNano.mergeFrom(new LiveBlindDateShowFlow(), bArr);
        }

        public static LiveBlindDateShowFlow parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveBlindDateShowFlow().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class DisplayFlowStage extends MessageNano {
        private static volatile DisplayFlowStage[] _emptyArray;
        public long startTime;
        public int status;

        public static DisplayFlowStage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DisplayFlowStage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DisplayFlowStage() {
            clear();
        }

        public final DisplayFlowStage clear() {
            this.status = 0;
            this.startTime = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            long j = this.startTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            long j = this.startTime;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(2, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final DisplayFlowStage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.status = codedInputByteBufferNano.readUInt32();
                } else if (tag != 16) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static DisplayFlowStage parseFrom(byte[] bArr) {
            return (DisplayFlowStage) MessageNano.mergeFrom(new DisplayFlowStage(), bArr);
        }

        public static DisplayFlowStage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new DisplayFlowStage().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class BlindDateFlowStage extends MessageNano {
        private static volatile BlindDateFlowStage[] _emptyArray;
        public String autoNextToast;
        public long maxTime;
        public long minTime;
        public String name;
        public long pushTime;
        public String pushToast;
        public String routerUrl;
        public int status;
        public int type;

        public static BlindDateFlowStage[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new BlindDateFlowStage[0];
                    }
                }
            }
            return _emptyArray;
        }

        public BlindDateFlowStage() {
            clear();
        }

        public final BlindDateFlowStage clear() {
            this.status = 0;
            this.type = 0;
            this.name = "";
            this.minTime = 0L;
            this.maxTime = 0L;
            this.pushTime = 0L;
            this.pushToast = "";
            this.autoNextToast = "";
            this.routerUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.status;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.type;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            if (!this.name.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.name);
            }
            long j = this.minTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.maxTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            long j3 = this.pushTime;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j3);
            }
            if (!this.pushToast.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.pushToast);
            }
            if (!this.autoNextToast.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.autoNextToast);
            }
            if (!this.routerUrl.equals("")) {
                codedOutputByteBufferNano.writeString(9, this.routerUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.status;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.type;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            if (!this.name.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.name);
            }
            long j = this.minTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.maxTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            long j3 = this.pushTime;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j3);
            }
            if (!this.pushToast.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.pushToast);
            }
            if (!this.autoNextToast.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.autoNextToast);
            }
            return !this.routerUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(9, this.routerUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final BlindDateFlowStage mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.status = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.type = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.name = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.minTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 40) {
                    this.maxTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 48) {
                    this.pushTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 58) {
                    this.pushToast = codedInputByteBufferNano.readString();
                } else if (tag == 66) {
                    this.autoNextToast = codedInputByteBufferNano.readString();
                } else if (tag != 74) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.routerUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static BlindDateFlowStage parseFrom(byte[] bArr) {
            return (BlindDateFlowStage) MessageNano.mergeFrom(new BlindDateFlowStage(), bArr);
        }

        public static BlindDateFlowStage parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new BlindDateFlowStage().mergeFrom(codedInputByteBufferNano);
        }
    }
}
