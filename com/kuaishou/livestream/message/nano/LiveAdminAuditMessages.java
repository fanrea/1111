package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.protobuf.livestream.nano.LiveCdnNodeView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveAdminAuditMessages {

    public static final class SCLiveWarningMaskStatusChanged extends MessageNano {
        private static volatile SCLiveWarningMaskStatusChanged[] _emptyArray;
        public String bottomContent;
        public boolean displayMask;
        public LiveCdnNodeView[] imageCdnNodeView;
        public long timeout;
        public long timestamp;
        public String topContent;
        public String warningContent;

        public static SCLiveWarningMaskStatusChanged[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveWarningMaskStatusChanged[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveWarningMaskStatusChanged() {
            clear();
        }

        public final SCLiveWarningMaskStatusChanged clear() {
            this.displayMask = false;
            this.timeout = 0L;
            this.imageCdnNodeView = LiveCdnNodeView.emptyArray();
            this.warningContent = "";
            this.timestamp = 0L;
            this.topContent = "";
            this.bottomContent = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.displayMask;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            long j = this.timeout;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.imageCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.imageCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(3, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.warningContent.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.warningContent);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            if (!this.topContent.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.topContent);
            }
            if (!this.bottomContent.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.bottomContent);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.displayMask;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            long j = this.timeout;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            LiveCdnNodeView[] liveCdnNodeViewArr = this.imageCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.imageCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.warningContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.warningContent);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j2);
            }
            if (!this.topContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.topContent);
            }
            return !this.bottomContent.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(7, this.bottomContent) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveWarningMaskStatusChanged mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.displayMask = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    this.timeout = codedInputByteBufferNano.readUInt64();
                } else if (tag == 26) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 26);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.imageCdnNodeView;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.imageCdnNodeView, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.imageCdnNodeView = liveCdnNodeViewArr2;
                } else if (tag == 34) {
                    this.warningContent = codedInputByteBufferNano.readString();
                } else if (tag == 40) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag == 50) {
                    this.topContent = codedInputByteBufferNano.readString();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bottomContent = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveWarningMaskStatusChanged parseFrom(byte[] bArr) {
            return (SCLiveWarningMaskStatusChanged) MessageNano.mergeFrom(new SCLiveWarningMaskStatusChanged(), bArr);
        }

        public static SCLiveWarningMaskStatusChanged parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveWarningMaskStatusChanged().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveBanned extends MessageNano {
        private static volatile SCLiveBanned[] _emptyArray;
        public String banReason;
        public LiveCdnNodeView[] imageCdnNodeView;
        public String jumpUrl;

        public static SCLiveBanned[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBanned[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBanned() {
            clear();
        }

        public final SCLiveBanned clear() {
            this.imageCdnNodeView = LiveCdnNodeView.emptyArray();
            this.banReason = "";
            this.jumpUrl = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCdnNodeView[] liveCdnNodeViewArr = this.imageCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.imageCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.banReason.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.banReason);
            }
            if (!this.jumpUrl.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.jumpUrl);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCdnNodeView[] liveCdnNodeViewArr = this.imageCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.imageCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.banReason.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.banReason);
            }
            return !this.jumpUrl.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.jumpUrl) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBanned mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.imageCdnNodeView;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.imageCdnNodeView, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.imageCdnNodeView = liveCdnNodeViewArr2;
                } else if (tag == 18) {
                    this.banReason = codedInputByteBufferNano.readString();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.jumpUrl = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveBanned parseFrom(byte[] bArr) {
            return (SCLiveBanned) MessageNano.mergeFrom(new SCLiveBanned(), bArr);
        }

        public static SCLiveBanned parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBanned().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveWarningMaskStatusChangedAuthor extends MessageNano {
        private static volatile SCLiveWarningMaskStatusChangedAuthor[] _emptyArray;
        public AuditAudienceMask audienceMask;
        public boolean displayMask;
        public int type;
        public AuditAuthorMask waitingMask;
        public AuditAuthorMask warningMask;

        @Retention(RetentionPolicy.SOURCE)
        public @interface WarningMaskType {
            public static final int UNKNOWN = 0;
            public static final int WITHOUT_CONFIRM = 2;
            public static final int WITH_CONFIRM = 1;
        }

        public static SCLiveWarningMaskStatusChangedAuthor[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveWarningMaskStatusChangedAuthor[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveWarningMaskStatusChangedAuthor() {
            clear();
        }

        public final SCLiveWarningMaskStatusChangedAuthor clear() {
            this.displayMask = false;
            this.type = 0;
            this.warningMask = null;
            this.waitingMask = null;
            this.audienceMask = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.displayMask;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            int i = this.type;
            if (i != 0) {
                codedOutputByteBufferNano.writeInt32(2, i);
            }
            AuditAuthorMask auditAuthorMask = this.warningMask;
            if (auditAuthorMask != null) {
                codedOutputByteBufferNano.writeMessage(3, auditAuthorMask);
            }
            AuditAuthorMask auditAuthorMask2 = this.waitingMask;
            if (auditAuthorMask2 != null) {
                codedOutputByteBufferNano.writeMessage(4, auditAuthorMask2);
            }
            AuditAudienceMask auditAudienceMask = this.audienceMask;
            if (auditAudienceMask != null) {
                codedOutputByteBufferNano.writeMessage(5, auditAudienceMask);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.displayMask;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            int i = this.type;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
            }
            AuditAuthorMask auditAuthorMask = this.warningMask;
            if (auditAuthorMask != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, auditAuthorMask);
            }
            AuditAuthorMask auditAuthorMask2 = this.waitingMask;
            if (auditAuthorMask2 != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, auditAuthorMask2);
            }
            AuditAudienceMask auditAudienceMask = this.audienceMask;
            return auditAudienceMask != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(5, auditAudienceMask) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveWarningMaskStatusChangedAuthor mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.displayMask = codedInputByteBufferNano.readBool();
                } else if (tag == 16) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.type = int32;
                    }
                } else if (tag == 26) {
                    if (this.warningMask == null) {
                        this.warningMask = new AuditAuthorMask();
                    }
                    codedInputByteBufferNano.readMessage(this.warningMask);
                } else if (tag == 34) {
                    if (this.waitingMask == null) {
                        this.waitingMask = new AuditAuthorMask();
                    }
                    codedInputByteBufferNano.readMessage(this.waitingMask);
                } else if (tag != 42) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.audienceMask == null) {
                        this.audienceMask = new AuditAudienceMask();
                    }
                    codedInputByteBufferNano.readMessage(this.audienceMask);
                }
            }
        }

        public static SCLiveWarningMaskStatusChangedAuthor parseFrom(byte[] bArr) {
            return (SCLiveWarningMaskStatusChangedAuthor) MessageNano.mergeFrom(new SCLiveWarningMaskStatusChangedAuthor(), bArr);
        }

        public static SCLiveWarningMaskStatusChangedAuthor parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveWarningMaskStatusChangedAuthor().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveWarningMaskStatusChangedAudience extends MessageNano {
        private static volatile SCLiveWarningMaskStatusChangedAudience[] _emptyArray;
        public boolean displayMask;
        public AuditAudienceMask warningMask;

        public static SCLiveWarningMaskStatusChangedAudience[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveWarningMaskStatusChangedAudience[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveWarningMaskStatusChangedAudience() {
            clear();
        }

        public final SCLiveWarningMaskStatusChangedAudience clear() {
            this.displayMask = false;
            this.warningMask = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            boolean z = this.displayMask;
            if (z) {
                codedOutputByteBufferNano.writeBool(1, z);
            }
            AuditAudienceMask auditAudienceMask = this.warningMask;
            if (auditAudienceMask != null) {
                codedOutputByteBufferNano.writeMessage(2, auditAudienceMask);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            boolean z = this.displayMask;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
            }
            AuditAudienceMask auditAudienceMask = this.warningMask;
            return auditAudienceMask != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(2, auditAudienceMask) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveWarningMaskStatusChangedAudience mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.displayMask = codedInputByteBufferNano.readBool();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.warningMask == null) {
                        this.warningMask = new AuditAudienceMask();
                    }
                    codedInputByteBufferNano.readMessage(this.warningMask);
                }
            }
        }

        public static SCLiveWarningMaskStatusChangedAudience parseFrom(byte[] bArr) {
            return (SCLiveWarningMaskStatusChangedAudience) MessageNano.mergeFrom(new SCLiveWarningMaskStatusChangedAudience(), bArr);
        }

        public static SCLiveWarningMaskStatusChangedAudience parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveWarningMaskStatusChangedAudience().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AuditAuthorMask extends MessageNano {
        private static volatile AuditAuthorMask[] _emptyArray;
        public long buttonClickCountdownSecond;
        public String buttonContent;
        public long buttonCountdownSecond;
        public long buttonCountdownSecondV2;
        public String detail;
        public boolean displayStopPushButton;
        public String guidePageContent;
        public String guidePageUrl;
        public LiveCdnNodeView[] iconCdnNodeView;
        public String title;

        public static AuditAuthorMask[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AuditAuthorMask[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AuditAuthorMask() {
            clear();
        }

        public final AuditAuthorMask clear() {
            this.iconCdnNodeView = LiveCdnNodeView.emptyArray();
            this.title = "";
            this.detail = "";
            this.buttonContent = "";
            this.buttonCountdownSecond = 0L;
            this.buttonClickCountdownSecond = 0L;
            this.guidePageContent = "";
            this.guidePageUrl = "";
            this.buttonCountdownSecondV2 = 0L;
            this.displayStopPushButton = false;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.detail.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.detail);
            }
            if (!this.buttonContent.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.buttonContent);
            }
            long j = this.buttonCountdownSecond;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j);
            }
            long j2 = this.buttonClickCountdownSecond;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j2);
            }
            if (!this.guidePageContent.equals("")) {
                codedOutputByteBufferNano.writeString(7, this.guidePageContent);
            }
            if (!this.guidePageUrl.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.guidePageUrl);
            }
            long j3 = this.buttonCountdownSecondV2;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(9, j3);
            }
            boolean z = this.displayStopPushButton;
            if (z) {
                codedOutputByteBufferNano.writeBool(10, z);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.detail.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.detail);
            }
            if (!this.buttonContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.buttonContent);
            }
            long j = this.buttonCountdownSecond;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
            }
            long j2 = this.buttonClickCountdownSecond;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j2);
            }
            if (!this.guidePageContent.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.guidePageContent);
            }
            if (!this.guidePageUrl.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.guidePageUrl);
            }
            long j3 = this.buttonCountdownSecondV2;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(9, j3);
            }
            boolean z = this.displayStopPushButton;
            return z ? iComputeSerializedSize + CodedOutputByteBufferNano.computeBoolSize(10, z) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AuditAuthorMask mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                switch (tag) {
                    case 0:
                        return this;
                    case 10:
                        int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                        LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
                        int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                        LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                        if (length != 0) {
                            System.arraycopy(this.iconCdnNodeView, 0, liveCdnNodeViewArr2, 0, length);
                        }
                        while (length < liveCdnNodeViewArr2.length - 1) {
                            liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                            codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                            codedInputByteBufferNano.readTag();
                            length++;
                        }
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        this.iconCdnNodeView = liveCdnNodeViewArr2;
                        break;
                    case 18:
                        this.title = codedInputByteBufferNano.readString();
                        break;
                    case 26:
                        this.detail = codedInputByteBufferNano.readString();
                        break;
                    case 34:
                        this.buttonContent = codedInputByteBufferNano.readString();
                        break;
                    case 40:
                        this.buttonCountdownSecond = codedInputByteBufferNano.readUInt64();
                        break;
                    case 48:
                        this.buttonClickCountdownSecond = codedInputByteBufferNano.readUInt64();
                        break;
                    case 58:
                        this.guidePageContent = codedInputByteBufferNano.readString();
                        break;
                    case 66:
                        this.guidePageUrl = codedInputByteBufferNano.readString();
                        break;
                    case 72:
                        this.buttonCountdownSecondV2 = codedInputByteBufferNano.readUInt64();
                        break;
                    case 80:
                        this.displayStopPushButton = codedInputByteBufferNano.readBool();
                        break;
                    default:
                        if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                            return this;
                        }
                        break;
                }
            }
        }

        public static AuditAuthorMask parseFrom(byte[] bArr) {
            return (AuditAuthorMask) MessageNano.mergeFrom(new AuditAuthorMask(), bArr);
        }

        public static AuditAuthorMask parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AuditAuthorMask().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class AuditAudienceMask extends MessageNano {
        private static volatile AuditAudienceMask[] _emptyArray;
        public long delayMaxDuration;
        public String detail;
        public LiveCdnNodeView[] iconCdnNodeView;
        public String title;

        public static AuditAudienceMask[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AuditAudienceMask[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AuditAudienceMask() {
            clear();
        }

        public final AuditAudienceMask clear() {
            this.iconCdnNodeView = LiveCdnNodeView.emptyArray();
            this.title = "";
            this.detail = "";
            this.delayMaxDuration = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        codedOutputByteBufferNano.writeMessage(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            if (!this.detail.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.detail);
            }
            long j = this.delayMaxDuration;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
            if (liveCdnNodeViewArr != null && liveCdnNodeViewArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = this.iconCdnNodeView;
                    if (i >= liveCdnNodeViewArr2.length) {
                        break;
                    }
                    LiveCdnNodeView liveCdnNodeView = liveCdnNodeViewArr2[i];
                    if (liveCdnNodeView != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, liveCdnNodeView);
                    }
                    i++;
                }
            }
            if (!this.title.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.title);
            }
            if (!this.detail.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.detail);
            }
            long j = this.delayMaxDuration;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final AuditAudienceMask mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    LiveCdnNodeView[] liveCdnNodeViewArr = this.iconCdnNodeView;
                    int length = liveCdnNodeViewArr == null ? 0 : liveCdnNodeViewArr.length;
                    LiveCdnNodeView[] liveCdnNodeViewArr2 = new LiveCdnNodeView[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.iconCdnNodeView, 0, liveCdnNodeViewArr2, 0, length);
                    }
                    while (length < liveCdnNodeViewArr2.length - 1) {
                        liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                        codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveCdnNodeViewArr2[length] = new LiveCdnNodeView();
                    codedInputByteBufferNano.readMessage(liveCdnNodeViewArr2[length]);
                    this.iconCdnNodeView = liveCdnNodeViewArr2;
                } else if (tag == 18) {
                    this.title = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.detail = codedInputByteBufferNano.readString();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.delayMaxDuration = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static AuditAudienceMask parseFrom(byte[] bArr) {
            return (AuditAudienceMask) MessageNano.mergeFrom(new AuditAudienceMask(), bArr);
        }

        public static AuditAudienceMask parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new AuditAudienceMask().mergeFrom(codedInputByteBufferNano);
        }
    }
}
