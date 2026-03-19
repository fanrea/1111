package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveThanksRedPackMessages {

    public static final class RedPackAwardAmountInfo extends MessageNano {
        private static volatile RedPackAwardAmountInfo[] _emptyArray;
        public double awardAmount;
        public String displayAwardAmount;
        public String displayAwardAmountUnit;
        public String displayUnit;

        public static RedPackAwardAmountInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackAwardAmountInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackAwardAmountInfo() {
            clear();
        }

        public final RedPackAwardAmountInfo clear() {
            this.awardAmount = 0.0d;
            this.displayAwardAmount = "";
            this.displayUnit = "";
            this.displayAwardAmountUnit = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (Double.doubleToLongBits(this.awardAmount) != Double.doubleToLongBits(0.0d)) {
                codedOutputByteBufferNano.writeDouble(1, this.awardAmount);
            }
            if (!this.displayAwardAmount.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.displayAwardAmount);
            }
            if (!this.displayUnit.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.displayUnit);
            }
            if (!this.displayAwardAmountUnit.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.displayAwardAmountUnit);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (Double.doubleToLongBits(this.awardAmount) != Double.doubleToLongBits(0.0d)) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeDoubleSize(1, this.awardAmount);
            }
            if (!this.displayAwardAmount.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.displayAwardAmount);
            }
            if (!this.displayUnit.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.displayUnit);
            }
            return !this.displayAwardAmountUnit.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.displayAwardAmountUnit) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackAwardAmountInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 9) {
                    this.awardAmount = codedInputByteBufferNano.readDouble();
                } else if (tag == 18) {
                    this.displayAwardAmount = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.displayUnit = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.displayAwardAmountUnit = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedPackAwardAmountInfo parseFrom(byte[] bArr) {
            return (RedPackAwardAmountInfo) MessageNano.mergeFrom(new RedPackAwardAmountInfo(), bArr);
        }

        public static RedPackAwardAmountInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackAwardAmountInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class RedPackCommonInfo extends MessageNano {
        private static volatile RedPackCommonInfo[] _emptyArray;
        public RedPackAwardAmountInfo awardAmountInfo;
        public String desc;
        public String id;
        public long openTime;

        public static RedPackCommonInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RedPackCommonInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RedPackCommonInfo() {
            clear();
        }

        public final RedPackCommonInfo clear() {
            this.id = "";
            this.awardAmountInfo = null;
            this.openTime = 0L;
            this.desc = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.id);
            }
            RedPackAwardAmountInfo redPackAwardAmountInfo = this.awardAmountInfo;
            if (redPackAwardAmountInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, redPackAwardAmountInfo);
            }
            long j = this.openTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j);
            }
            if (!this.desc.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.desc);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.id);
            }
            RedPackAwardAmountInfo redPackAwardAmountInfo = this.awardAmountInfo;
            if (redPackAwardAmountInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, redPackAwardAmountInfo);
            }
            long j = this.openTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j);
            }
            return !this.desc.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.desc) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final RedPackCommonInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.id = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.awardAmountInfo == null) {
                        this.awardAmountInfo = new RedPackAwardAmountInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.awardAmountInfo);
                } else if (tag == 24) {
                    this.openTime = codedInputByteBufferNano.readUInt64();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.desc = codedInputByteBufferNano.readString();
                }
            }
        }

        public static RedPackCommonInfo parseFrom(byte[] bArr) {
            return (RedPackCommonInfo) MessageNano.mergeFrom(new RedPackCommonInfo(), bArr);
        }

        public static RedPackCommonInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new RedPackCommonInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class ThanksRedPackInfo extends MessageNano {
        private static volatile ThanksRedPackInfo[] _emptyArray;
        public RedPackCommonInfo commonInfo;
        public long maxAdvanceRequestThanksRollUserMillis;
        public long maxDelayRequestThanksAwardUserMillis;
        public long terminateTimeoutMillis;

        public static ThanksRedPackInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ThanksRedPackInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ThanksRedPackInfo() {
            clear();
        }

        public final ThanksRedPackInfo clear() {
            this.commonInfo = null;
            this.maxAdvanceRequestThanksRollUserMillis = 0L;
            this.terminateTimeoutMillis = 0L;
            this.maxDelayRequestThanksAwardUserMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RedPackCommonInfo redPackCommonInfo = this.commonInfo;
            if (redPackCommonInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, redPackCommonInfo);
            }
            long j = this.maxAdvanceRequestThanksRollUserMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.terminateTimeoutMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            long j3 = this.maxDelayRequestThanksAwardUserMillis;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RedPackCommonInfo redPackCommonInfo = this.commonInfo;
            if (redPackCommonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, redPackCommonInfo);
            }
            long j = this.maxAdvanceRequestThanksRollUserMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.terminateTimeoutMillis;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            long j3 = this.maxDelayRequestThanksAwardUserMillis;
            return j3 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final ThanksRedPackInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.commonInfo == null) {
                        this.commonInfo = new RedPackCommonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.commonInfo);
                } else if (tag == 16) {
                    this.maxAdvanceRequestThanksRollUserMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.terminateTimeoutMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxDelayRequestThanksAwardUserMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static ThanksRedPackInfo parseFrom(byte[] bArr) {
            return (ThanksRedPackInfo) MessageNano.mergeFrom(new ThanksRedPackInfo(), bArr);
        }

        public static ThanksRedPackInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new ThanksRedPackInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MillionRedPackInfo extends MessageNano {
        private static volatile MillionRedPackInfo[] _emptyArray;
        public RedPackCommonInfo commonInfo;
        public long maxAdvanceRequestMillionRollUserMillis;
        public long maxDelayRequestMillionAwardUserMillis;

        public static MillionRedPackInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MillionRedPackInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MillionRedPackInfo() {
            clear();
        }

        public final MillionRedPackInfo clear() {
            this.commonInfo = null;
            this.maxAdvanceRequestMillionRollUserMillis = 0L;
            this.maxDelayRequestMillionAwardUserMillis = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            RedPackCommonInfo redPackCommonInfo = this.commonInfo;
            if (redPackCommonInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, redPackCommonInfo);
            }
            long j = this.maxAdvanceRequestMillionRollUserMillis;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            long j2 = this.maxDelayRequestMillionAwardUserMillis;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            RedPackCommonInfo redPackCommonInfo = this.commonInfo;
            if (redPackCommonInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, redPackCommonInfo);
            }
            long j = this.maxAdvanceRequestMillionRollUserMillis;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            long j2 = this.maxDelayRequestMillionAwardUserMillis;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(3, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MillionRedPackInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.commonInfo == null) {
                        this.commonInfo = new RedPackCommonInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.commonInfo);
                } else if (tag == 16) {
                    this.maxAdvanceRequestMillionRollUserMillis = codedInputByteBufferNano.readUInt64();
                } else if (tag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.maxDelayRequestMillionAwardUserMillis = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static MillionRedPackInfo parseFrom(byte[] bArr) {
            return (MillionRedPackInfo) MessageNano.mergeFrom(new MillionRedPackInfo(), bArr);
        }

        public static MillionRedPackInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MillionRedPackInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCThanksRedPackWidget extends MessageNano {
        private static volatile SCThanksRedPackWidget[] _emptyArray;
        public MillionRedPackInfo millionRedPack;
        public ThanksRedPackInfo thanksRedPack;

        public static SCThanksRedPackWidget[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCThanksRedPackWidget[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCThanksRedPackWidget() {
            clear();
        }

        public final SCThanksRedPackWidget clear() {
            this.thanksRedPack = null;
            this.millionRedPack = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            ThanksRedPackInfo thanksRedPackInfo = this.thanksRedPack;
            if (thanksRedPackInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, thanksRedPackInfo);
            }
            MillionRedPackInfo millionRedPackInfo = this.millionRedPack;
            if (millionRedPackInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, millionRedPackInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            ThanksRedPackInfo thanksRedPackInfo = this.thanksRedPack;
            if (thanksRedPackInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, thanksRedPackInfo);
            }
            MillionRedPackInfo millionRedPackInfo = this.millionRedPack;
            return millionRedPackInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, millionRedPackInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCThanksRedPackWidget mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.thanksRedPack == null) {
                        this.thanksRedPack = new ThanksRedPackInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.thanksRedPack);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.millionRedPack == null) {
                        this.millionRedPack = new MillionRedPackInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.millionRedPack);
                }
            }
        }

        public static SCThanksRedPackWidget parseFrom(byte[] bArr) {
            return (SCThanksRedPackWidget) MessageNano.mergeFrom(new SCThanksRedPackWidget(), bArr);
        }

        public static SCThanksRedPackWidget parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCThanksRedPackWidget().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCThanksRedPackTerminate extends MessageNano {
        private static volatile SCThanksRedPackTerminate[] _emptyArray;
        public String thanksRedPackId;

        public static SCThanksRedPackTerminate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCThanksRedPackTerminate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCThanksRedPackTerminate() {
            clear();
        }

        public final SCThanksRedPackTerminate clear() {
            this.thanksRedPackId = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.thanksRedPackId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.thanksRedPackId);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            return !this.thanksRedPackId.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(1, this.thanksRedPackId) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCThanksRedPackTerminate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    this.thanksRedPackId = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCThanksRedPackTerminate parseFrom(byte[] bArr) {
            return (SCThanksRedPackTerminate) MessageNano.mergeFrom(new SCThanksRedPackTerminate(), bArr);
        }

        public static SCThanksRedPackTerminate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCThanksRedPackTerminate().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MillionRedPackAwardUser extends MessageNano {
        private static volatile MillionRedPackAwardUser[] _emptyArray;
        public RedPackAwardAmountInfo awardAmountInfo;
        public UserInfos.UserInfo userInfo;

        public static MillionRedPackAwardUser[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MillionRedPackAwardUser[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MillionRedPackAwardUser() {
            clear();
        }

        public final MillionRedPackAwardUser clear() {
            this.userInfo = null;
            this.awardAmountInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            RedPackAwardAmountInfo redPackAwardAmountInfo = this.awardAmountInfo;
            if (redPackAwardAmountInfo != null) {
                codedOutputByteBufferNano.writeMessage(2, redPackAwardAmountInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.userInfo;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            RedPackAwardAmountInfo redPackAwardAmountInfo = this.awardAmountInfo;
            return redPackAwardAmountInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, redPackAwardAmountInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MillionRedPackAwardUser mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.userInfo == null) {
                        this.userInfo = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.userInfo);
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.awardAmountInfo == null) {
                        this.awardAmountInfo = new RedPackAwardAmountInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.awardAmountInfo);
                }
            }
        }

        public static MillionRedPackAwardUser parseFrom(byte[] bArr) {
            return (MillionRedPackAwardUser) MessageNano.mergeFrom(new MillionRedPackAwardUser(), bArr);
        }

        public static MillionRedPackAwardUser parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MillionRedPackAwardUser().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class MillionRedPackAwardInfo extends MessageNano {
        private static volatile MillionRedPackAwardInfo[] _emptyArray;
        public MillionRedPackAwardUser awardAuthor;
        public MillionRedPackAwardUser awardInvitee;
        public MillionRedPackAwardUser awardInviter;

        public static MillionRedPackAwardInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new MillionRedPackAwardInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public MillionRedPackAwardInfo() {
            clear();
        }

        public final MillionRedPackAwardInfo clear() {
            this.awardAuthor = null;
            this.awardInviter = null;
            this.awardInvitee = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            MillionRedPackAwardUser millionRedPackAwardUser = this.awardAuthor;
            if (millionRedPackAwardUser != null) {
                codedOutputByteBufferNano.writeMessage(1, millionRedPackAwardUser);
            }
            MillionRedPackAwardUser millionRedPackAwardUser2 = this.awardInviter;
            if (millionRedPackAwardUser2 != null) {
                codedOutputByteBufferNano.writeMessage(2, millionRedPackAwardUser2);
            }
            MillionRedPackAwardUser millionRedPackAwardUser3 = this.awardInvitee;
            if (millionRedPackAwardUser3 != null) {
                codedOutputByteBufferNano.writeMessage(3, millionRedPackAwardUser3);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            MillionRedPackAwardUser millionRedPackAwardUser = this.awardAuthor;
            if (millionRedPackAwardUser != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, millionRedPackAwardUser);
            }
            MillionRedPackAwardUser millionRedPackAwardUser2 = this.awardInviter;
            if (millionRedPackAwardUser2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, millionRedPackAwardUser2);
            }
            MillionRedPackAwardUser millionRedPackAwardUser3 = this.awardInvitee;
            return millionRedPackAwardUser3 != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, millionRedPackAwardUser3) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final MillionRedPackAwardInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.awardAuthor == null) {
                        this.awardAuthor = new MillionRedPackAwardUser();
                    }
                    codedInputByteBufferNano.readMessage(this.awardAuthor);
                } else if (tag == 18) {
                    if (this.awardInviter == null) {
                        this.awardInviter = new MillionRedPackAwardUser();
                    }
                    codedInputByteBufferNano.readMessage(this.awardInviter);
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.awardInvitee == null) {
                        this.awardInvitee = new MillionRedPackAwardUser();
                    }
                    codedInputByteBufferNano.readMessage(this.awardInvitee);
                }
            }
        }

        public static MillionRedPackAwardInfo parseFrom(byte[] bArr) {
            return (MillionRedPackAwardInfo) MessageNano.mergeFrom(new MillionRedPackAwardInfo(), bArr);
        }

        public static MillionRedPackAwardInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new MillionRedPackAwardInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCMillionRedPackTerminate extends MessageNano {
        private static volatile SCMillionRedPackTerminate[] _emptyArray;
        public MillionRedPackAwardInfo[] awardInfo;
        public String millionRedPackId;

        public static SCMillionRedPackTerminate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCMillionRedPackTerminate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCMillionRedPackTerminate() {
            clear();
        }

        public final SCMillionRedPackTerminate clear() {
            this.millionRedPackId = "";
            this.awardInfo = MillionRedPackAwardInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.millionRedPackId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.millionRedPackId);
            }
            MillionRedPackAwardInfo[] millionRedPackAwardInfoArr = this.awardInfo;
            if (millionRedPackAwardInfoArr != null && millionRedPackAwardInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    MillionRedPackAwardInfo[] millionRedPackAwardInfoArr2 = this.awardInfo;
                    if (i >= millionRedPackAwardInfoArr2.length) {
                        break;
                    }
                    MillionRedPackAwardInfo millionRedPackAwardInfo = millionRedPackAwardInfoArr2[i];
                    if (millionRedPackAwardInfo != null) {
                        codedOutputByteBufferNano.writeMessage(2, millionRedPackAwardInfo);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.millionRedPackId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.millionRedPackId);
            }
            MillionRedPackAwardInfo[] millionRedPackAwardInfoArr = this.awardInfo;
            if (millionRedPackAwardInfoArr != null && millionRedPackAwardInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    MillionRedPackAwardInfo[] millionRedPackAwardInfoArr2 = this.awardInfo;
                    if (i >= millionRedPackAwardInfoArr2.length) {
                        break;
                    }
                    MillionRedPackAwardInfo millionRedPackAwardInfo = millionRedPackAwardInfoArr2[i];
                    if (millionRedPackAwardInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, millionRedPackAwardInfo);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCMillionRedPackTerminate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.millionRedPackId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 18);
                    MillionRedPackAwardInfo[] millionRedPackAwardInfoArr = this.awardInfo;
                    int length = millionRedPackAwardInfoArr == null ? 0 : millionRedPackAwardInfoArr.length;
                    MillionRedPackAwardInfo[] millionRedPackAwardInfoArr2 = new MillionRedPackAwardInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.awardInfo, 0, millionRedPackAwardInfoArr2, 0, length);
                    }
                    while (length < millionRedPackAwardInfoArr2.length - 1) {
                        millionRedPackAwardInfoArr2[length] = new MillionRedPackAwardInfo();
                        codedInputByteBufferNano.readMessage(millionRedPackAwardInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    millionRedPackAwardInfoArr2[length] = new MillionRedPackAwardInfo();
                    codedInputByteBufferNano.readMessage(millionRedPackAwardInfoArr2[length]);
                    this.awardInfo = millionRedPackAwardInfoArr2;
                }
            }
        }

        public static SCMillionRedPackTerminate parseFrom(byte[] bArr) {
            return (SCMillionRedPackTerminate) MessageNano.mergeFrom(new SCMillionRedPackTerminate(), bArr);
        }

        public static SCMillionRedPackTerminate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCMillionRedPackTerminate().mergeFrom(codedInputByteBufferNano);
        }
    }
}
