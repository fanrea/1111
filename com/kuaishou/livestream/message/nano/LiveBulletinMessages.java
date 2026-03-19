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
public interface LiveBulletinMessages {

    public static final class SCLiveBulletin extends MessageNano {
        private static volatile SCLiveBulletin[] _emptyArray;
        public boolean autoCreate;
        public String bizType;
        public String bulletin;
        public long bulletinId;
        public String id;
        public LiveReservationLiteModel liveReservation;
        public int reason;
        public String[] tag;

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveBulletinStatus {
            public static final int AUDIT_DELETED = 3;
            public static final int BULLETIN_STATUS_UNKNOWN = 0;
            public static final int DELETED = 2;
            public static final int NEW = 1;
        }

        @Retention(RetentionPolicy.SOURCE)
        public @interface LiveBulletinUpdateReason {
            public static final int AUDITED_REJECT = 2;
            public static final int AUTHOR_EDIT = 1;
            public static final int UNKNOWN = 0;
        }

        public static SCLiveBulletin[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveBulletin[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveBulletin() {
            clear();
        }

        public final SCLiveBulletin clear() {
            this.tag = WireFormatNano.EMPTY_STRING_ARRAY;
            this.bulletin = "";
            this.reason = 0;
            this.bulletinId = 0L;
            this.id = "";
            this.autoCreate = false;
            this.liveReservation = null;
            this.bizType = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            String[] strArr = this.tag;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                while (true) {
                    String[] strArr2 = this.tag;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        codedOutputByteBufferNano.writeString(1, str);
                    }
                    i++;
                }
            }
            if (!this.bulletin.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bulletin);
            }
            int i2 = this.reason;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeInt32(3, i2);
            }
            long j = this.bulletinId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            if (!this.id.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.id);
            }
            boolean z = this.autoCreate;
            if (z) {
                codedOutputByteBufferNano.writeBool(6, z);
            }
            LiveReservationLiteModel liveReservationLiteModel = this.liveReservation;
            if (liveReservationLiteModel != null) {
                codedOutputByteBufferNano.writeMessage(7, liveReservationLiteModel);
            }
            if (!this.bizType.equals("")) {
                codedOutputByteBufferNano.writeString(8, this.bizType);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            String[] strArr = this.tag;
            if (strArr != null && strArr.length > 0) {
                int i = 0;
                int iComputeStringSizeNoTag = 0;
                int i2 = 0;
                while (true) {
                    String[] strArr2 = this.tag;
                    if (i >= strArr2.length) {
                        break;
                    }
                    String str = strArr2[i];
                    if (str != null) {
                        i2++;
                        iComputeStringSizeNoTag += CodedOutputByteBufferNano.computeStringSizeNoTag(str);
                    }
                    i++;
                }
                iComputeSerializedSize = iComputeSerializedSize + iComputeStringSizeNoTag + (i2 * 1);
            }
            if (!this.bulletin.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bulletin);
            }
            int i3 = this.reason;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i3);
            }
            long j = this.bulletinId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            if (!this.id.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.id);
            }
            boolean z = this.autoCreate;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(6, z);
            }
            LiveReservationLiteModel liveReservationLiteModel = this.liveReservation;
            if (liveReservationLiteModel != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, liveReservationLiteModel);
            }
            return !this.bizType.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(8, this.bizType) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveBulletin mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 10);
                    String[] strArr = this.tag;
                    int length = strArr == null ? 0 : strArr.length;
                    String[] strArr2 = new String[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.tag, 0, strArr2, 0, length);
                    }
                    while (length < strArr2.length - 1) {
                        strArr2[length] = codedInputByteBufferNano.readString();
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    strArr2[length] = codedInputByteBufferNano.readString();
                    this.tag = strArr2;
                } else if (tag == 18) {
                    this.bulletin = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 == 0 || int32 == 1 || int32 == 2) {
                        this.reason = int32;
                    }
                } else if (tag == 32) {
                    this.bulletinId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 42) {
                    this.id = codedInputByteBufferNano.readString();
                } else if (tag == 48) {
                    this.autoCreate = codedInputByteBufferNano.readBool();
                } else if (tag == 58) {
                    if (this.liveReservation == null) {
                        this.liveReservation = new LiveReservationLiteModel();
                    }
                    codedInputByteBufferNano.readMessage(this.liveReservation);
                } else if (tag != 66) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bizType = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveBulletin parseFrom(byte[] bArr) {
            return (SCLiveBulletin) MessageNano.mergeFrom(new SCLiveBulletin(), bArr);
        }

        public static SCLiveBulletin parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveBulletin().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveReservationLiteModel extends MessageNano {
        private static volatile LiveReservationLiteModel[] _emptyArray;
        public String reservationId;
        public String title;

        public static LiveReservationLiteModel[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveReservationLiteModel[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveReservationLiteModel() {
            clear();
        }

        public final LiveReservationLiteModel clear() {
            this.reservationId = "";
            this.title = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.reservationId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.reservationId);
            }
            if (!this.title.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.title);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.reservationId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.reservationId);
            }
            return !this.title.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(2, this.title) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveReservationLiteModel mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.reservationId = codedInputByteBufferNano.readString();
                } else if (tag != 18) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.title = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveReservationLiteModel parseFrom(byte[] bArr) {
            return (LiveReservationLiteModel) MessageNano.mergeFrom(new LiveReservationLiteModel(), bArr);
        }

        public static LiveReservationLiteModel parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveReservationLiteModel().mergeFrom(codedInputByteBufferNano);
        }
    }
}
