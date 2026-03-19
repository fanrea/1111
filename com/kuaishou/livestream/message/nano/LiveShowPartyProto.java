package com.kuaishou.livestream.message.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import com.kuaishou.socket.nano.UserInfos;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface LiveShowPartyProto {

    public static final class SCLiveShowParySwitch extends MessageNano {
        private static volatile SCLiveShowParySwitch[] _emptyArray;
        public String liveStreamId;
        public LiveShowPartyEnd showPartyEnd;
        public LiveShowPartyStart showPartyStart;
        public long timestamp;
        public long version;

        public static SCLiveShowParySwitch[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShowParySwitch[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShowParySwitch() {
            clear();
        }

        public final SCLiveShowParySwitch clear() {
            this.liveStreamId = "";
            this.showPartyStart = null;
            this.showPartyEnd = null;
            this.version = 0L;
            this.timestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            LiveShowPartyStart liveShowPartyStart = this.showPartyStart;
            if (liveShowPartyStart != null) {
                codedOutputByteBufferNano.writeMessage(2, liveShowPartyStart);
            }
            LiveShowPartyEnd liveShowPartyEnd = this.showPartyEnd;
            if (liveShowPartyEnd != null) {
                codedOutputByteBufferNano.writeMessage(3, liveShowPartyEnd);
            }
            long j = this.version;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            LiveShowPartyStart liveShowPartyStart = this.showPartyStart;
            if (liveShowPartyStart != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, liveShowPartyStart);
            }
            LiveShowPartyEnd liveShowPartyEnd = this.showPartyEnd;
            if (liveShowPartyEnd != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, liveShowPartyEnd);
            }
            long j = this.version;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.timestamp;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShowParySwitch mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    if (this.showPartyStart == null) {
                        this.showPartyStart = new LiveShowPartyStart();
                    }
                    codedInputByteBufferNano.readMessage(this.showPartyStart);
                } else if (tag == 26) {
                    if (this.showPartyEnd == null) {
                        this.showPartyEnd = new LiveShowPartyEnd();
                    }
                    codedInputByteBufferNano.readMessage(this.showPartyEnd);
                } else if (tag == 32) {
                    this.version = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveShowParySwitch parseFrom(byte[] bArr) {
            return (SCLiveShowParySwitch) MessageNano.mergeFrom(new SCLiveShowParySwitch(), bArr);
        }

        public static SCLiveShowParySwitch parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShowParySwitch().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShowPartyStart extends MessageNano {
        private static volatile LiveShowPartyStart[] _emptyArray;
        public BundleInfo[] bundleInfo;
        public String extraInfoPb;
        public int playType;
        public String showPartyId;
        public String showPartyTitle;
        public String teamInfos;
        public String timeLine;

        public static LiveShowPartyStart[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShowPartyStart[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShowPartyStart() {
            clear();
        }

        public final LiveShowPartyStart clear() {
            this.showPartyId = "";
            this.playType = 0;
            this.teamInfos = "";
            this.timeLine = "";
            this.showPartyTitle = "";
            this.extraInfoPb = "";
            this.bundleInfo = BundleInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.showPartyId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            if (!this.teamInfos.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.teamInfos);
            }
            if (!this.timeLine.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.timeLine);
            }
            if (!this.showPartyTitle.equals("")) {
                codedOutputByteBufferNano.writeString(5, this.showPartyTitle);
            }
            if (!this.extraInfoPb.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.extraInfoPb);
            }
            BundleInfo[] bundleInfoArr = this.bundleInfo;
            if (bundleInfoArr != null && bundleInfoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    BundleInfo[] bundleInfoArr2 = this.bundleInfo;
                    if (i2 >= bundleInfoArr2.length) {
                        break;
                    }
                    BundleInfo bundleInfo = bundleInfoArr2[i2];
                    if (bundleInfo != null) {
                        codedOutputByteBufferNano.writeMessage(7, bundleInfo);
                    }
                    i2++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.showPartyId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            if (!this.teamInfos.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.teamInfos);
            }
            if (!this.timeLine.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(4, this.timeLine);
            }
            if (!this.showPartyTitle.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(5, this.showPartyTitle);
            }
            if (!this.extraInfoPb.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(6, this.extraInfoPb);
            }
            BundleInfo[] bundleInfoArr = this.bundleInfo;
            if (bundleInfoArr != null && bundleInfoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    BundleInfo[] bundleInfoArr2 = this.bundleInfo;
                    if (i2 >= bundleInfoArr2.length) {
                        break;
                    }
                    BundleInfo bundleInfo = bundleInfoArr2[i2];
                    if (bundleInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(7, bundleInfo);
                    }
                    i2++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShowPartyStart mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.showPartyId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.playType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.teamInfos = codedInputByteBufferNano.readString();
                } else if (tag == 34) {
                    this.timeLine = codedInputByteBufferNano.readString();
                } else if (tag == 42) {
                    this.showPartyTitle = codedInputByteBufferNano.readString();
                } else if (tag == 50) {
                    this.extraInfoPb = codedInputByteBufferNano.readString();
                } else if (tag != 58) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 58);
                    BundleInfo[] bundleInfoArr = this.bundleInfo;
                    int length = bundleInfoArr == null ? 0 : bundleInfoArr.length;
                    BundleInfo[] bundleInfoArr2 = new BundleInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.bundleInfo, 0, bundleInfoArr2, 0, length);
                    }
                    while (length < bundleInfoArr2.length - 1) {
                        bundleInfoArr2[length] = new BundleInfo();
                        codedInputByteBufferNano.readMessage(bundleInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    bundleInfoArr2[length] = new BundleInfo();
                    codedInputByteBufferNano.readMessage(bundleInfoArr2[length]);
                    this.bundleInfo = bundleInfoArr2;
                }
            }
        }

        public static LiveShowPartyStart parseFrom(byte[] bArr) {
            return (LiveShowPartyStart) MessageNano.mergeFrom(new LiveShowPartyStart(), bArr);
        }

        public static LiveShowPartyStart parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShowPartyStart().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class BundleInfo extends MessageNano {
        private static volatile BundleInfo[] _emptyArray;
        public String bundleId;
        public long bundleUniqueId;
        public String componentName;
        public int minBundleVersion;

        public static BundleInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new BundleInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public BundleInfo() {
            clear();
        }

        public final BundleInfo clear() {
            this.componentName = "";
            this.bundleId = "";
            this.minBundleVersion = 0;
            this.bundleUniqueId = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.componentName.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.componentName);
            }
            if (!this.bundleId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.bundleId);
            }
            int i = this.minBundleVersion;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            long j = this.bundleUniqueId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.componentName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.componentName);
            }
            if (!this.bundleId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.bundleId);
            }
            int i = this.minBundleVersion;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            long j = this.bundleUniqueId;
            return j != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(4, j) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final BundleInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.componentName = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.bundleId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.minBundleVersion = codedInputByteBufferNano.readUInt32();
                } else if (tag != 32) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.bundleUniqueId = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static BundleInfo parseFrom(byte[] bArr) {
            return (BundleInfo) MessageNano.mergeFrom(new BundleInfo(), bArr);
        }

        public static BundleInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new BundleInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveShowPartyTeamInfos extends MessageNano {
        private static volatile SCLiveShowPartyTeamInfos[] _emptyArray;
        public SCLiveShowPartyTeamInfo[] teams;

        public static SCLiveShowPartyTeamInfos[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShowPartyTeamInfos[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShowPartyTeamInfos() {
            clear();
        }

        public final SCLiveShowPartyTeamInfos clear() {
            this.teams = SCLiveShowPartyTeamInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr = this.teams;
            if (sCLiveShowPartyTeamInfoArr != null && sCLiveShowPartyTeamInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr2 = this.teams;
                    if (i >= sCLiveShowPartyTeamInfoArr2.length) {
                        break;
                    }
                    SCLiveShowPartyTeamInfo sCLiveShowPartyTeamInfo = sCLiveShowPartyTeamInfoArr2[i];
                    if (sCLiveShowPartyTeamInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, sCLiveShowPartyTeamInfo);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr = this.teams;
            if (sCLiveShowPartyTeamInfoArr != null && sCLiveShowPartyTeamInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr2 = this.teams;
                    if (i >= sCLiveShowPartyTeamInfoArr2.length) {
                        break;
                    }
                    SCLiveShowPartyTeamInfo sCLiveShowPartyTeamInfo = sCLiveShowPartyTeamInfoArr2[i];
                    if (sCLiveShowPartyTeamInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, sCLiveShowPartyTeamInfo);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShowPartyTeamInfos mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr = this.teams;
                    int length = sCLiveShowPartyTeamInfoArr == null ? 0 : sCLiveShowPartyTeamInfoArr.length;
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr2 = new SCLiveShowPartyTeamInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.teams, 0, sCLiveShowPartyTeamInfoArr2, 0, length);
                    }
                    while (length < sCLiveShowPartyTeamInfoArr2.length - 1) {
                        sCLiveShowPartyTeamInfoArr2[length] = new SCLiveShowPartyTeamInfo();
                        codedInputByteBufferNano.readMessage(sCLiveShowPartyTeamInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sCLiveShowPartyTeamInfoArr2[length] = new SCLiveShowPartyTeamInfo();
                    codedInputByteBufferNano.readMessage(sCLiveShowPartyTeamInfoArr2[length]);
                    this.teams = sCLiveShowPartyTeamInfoArr2;
                }
            }
        }

        public static SCLiveShowPartyTeamInfos parseFrom(byte[] bArr) {
            return (SCLiveShowPartyTeamInfos) MessageNano.mergeFrom(new SCLiveShowPartyTeamInfos(), bArr);
        }

        public static SCLiveShowPartyTeamInfos parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShowPartyTeamInfos().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveShowPartyTeamInfo extends MessageNano {
        private static volatile SCLiveShowPartyTeamInfo[] _emptyArray;
        public int rank;
        public int status;
        public int teamId;
        public LiveShowPartyTeamMember[] teamMember;
        public String teamName;
        public int teamScore;

        public static SCLiveShowPartyTeamInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShowPartyTeamInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShowPartyTeamInfo() {
            clear();
        }

        public final SCLiveShowPartyTeamInfo clear() {
            this.teamId = 0;
            this.status = 0;
            this.rank = 0;
            this.teamScore = 0;
            this.teamMember = LiveShowPartyTeamMember.emptyArray();
            this.teamName = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            int i = this.teamId;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(1, i);
            }
            int i2 = this.status;
            if (i2 != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i2);
            }
            int i3 = this.rank;
            if (i3 != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i3);
            }
            int i4 = this.teamScore;
            if (i4 != 0) {
                codedOutputByteBufferNano.writeUInt32(4, i4);
            }
            LiveShowPartyTeamMember[] liveShowPartyTeamMemberArr = this.teamMember;
            if (liveShowPartyTeamMemberArr != null && liveShowPartyTeamMemberArr.length > 0) {
                int i5 = 0;
                while (true) {
                    LiveShowPartyTeamMember[] liveShowPartyTeamMemberArr2 = this.teamMember;
                    if (i5 >= liveShowPartyTeamMemberArr2.length) {
                        break;
                    }
                    LiveShowPartyTeamMember liveShowPartyTeamMember = liveShowPartyTeamMemberArr2[i5];
                    if (liveShowPartyTeamMember != null) {
                        codedOutputByteBufferNano.writeMessage(5, liveShowPartyTeamMember);
                    }
                    i5++;
                }
            }
            if (!this.teamName.equals("")) {
                codedOutputByteBufferNano.writeString(6, this.teamName);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            int i = this.teamId;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
            }
            int i2 = this.status;
            if (i2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
            }
            int i3 = this.rank;
            if (i3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i3);
            }
            int i4 = this.teamScore;
            if (i4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(4, i4);
            }
            LiveShowPartyTeamMember[] liveShowPartyTeamMemberArr = this.teamMember;
            if (liveShowPartyTeamMemberArr != null && liveShowPartyTeamMemberArr.length > 0) {
                int i5 = 0;
                while (true) {
                    LiveShowPartyTeamMember[] liveShowPartyTeamMemberArr2 = this.teamMember;
                    if (i5 >= liveShowPartyTeamMemberArr2.length) {
                        break;
                    }
                    LiveShowPartyTeamMember liveShowPartyTeamMember = liveShowPartyTeamMemberArr2[i5];
                    if (liveShowPartyTeamMember != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, liveShowPartyTeamMember);
                    }
                    i5++;
                }
            }
            return !this.teamName.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(6, this.teamName) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShowPartyTeamInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.teamId = codedInputByteBufferNano.readUInt32();
                } else if (tag == 16) {
                    this.status = codedInputByteBufferNano.readUInt32();
                } else if (tag == 24) {
                    this.rank = codedInputByteBufferNano.readUInt32();
                } else if (tag == 32) {
                    this.teamScore = codedInputByteBufferNano.readUInt32();
                } else if (tag == 42) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 42);
                    LiveShowPartyTeamMember[] liveShowPartyTeamMemberArr = this.teamMember;
                    int length = liveShowPartyTeamMemberArr == null ? 0 : liveShowPartyTeamMemberArr.length;
                    LiveShowPartyTeamMember[] liveShowPartyTeamMemberArr2 = new LiveShowPartyTeamMember[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.teamMember, 0, liveShowPartyTeamMemberArr2, 0, length);
                    }
                    while (length < liveShowPartyTeamMemberArr2.length - 1) {
                        liveShowPartyTeamMemberArr2[length] = new LiveShowPartyTeamMember();
                        codedInputByteBufferNano.readMessage(liveShowPartyTeamMemberArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveShowPartyTeamMemberArr2[length] = new LiveShowPartyTeamMember();
                    codedInputByteBufferNano.readMessage(liveShowPartyTeamMemberArr2[length]);
                    this.teamMember = liveShowPartyTeamMemberArr2;
                } else if (tag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.teamName = codedInputByteBufferNano.readString();
                }
            }
        }

        public static SCLiveShowPartyTeamInfo parseFrom(byte[] bArr) {
            return (SCLiveShowPartyTeamInfo) MessageNano.mergeFrom(new SCLiveShowPartyTeamInfo(), bArr);
        }

        public static SCLiveShowPartyTeamInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShowPartyTeamInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShowPartyTeamMember extends MessageNano {
        private static volatile LiveShowPartyTeamMember[] _emptyArray;
        public LiveShowPartyGiftInfo giftInfo;
        public UserInfos.UserInfo player;
        public long score;

        public static LiveShowPartyTeamMember[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShowPartyTeamMember[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShowPartyTeamMember() {
            clear();
        }

        public final LiveShowPartyTeamMember clear() {
            this.player = null;
            this.score = 0L;
            this.giftInfo = null;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo userInfo = this.player;
            if (userInfo != null) {
                codedOutputByteBufferNano.writeMessage(1, userInfo);
            }
            long j = this.score;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j);
            }
            LiveShowPartyGiftInfo liveShowPartyGiftInfo = this.giftInfo;
            if (liveShowPartyGiftInfo != null) {
                codedOutputByteBufferNano.writeMessage(3, liveShowPartyGiftInfo);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo userInfo = this.player;
            if (userInfo != null) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
            }
            long j = this.score;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j);
            }
            LiveShowPartyGiftInfo liveShowPartyGiftInfo = this.giftInfo;
            return liveShowPartyGiftInfo != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(3, liveShowPartyGiftInfo) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShowPartyTeamMember mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    if (this.player == null) {
                        this.player = new UserInfos.UserInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.player);
                } else if (tag == 16) {
                    this.score = codedInputByteBufferNano.readUInt64();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    if (this.giftInfo == null) {
                        this.giftInfo = new LiveShowPartyGiftInfo();
                    }
                    codedInputByteBufferNano.readMessage(this.giftInfo);
                }
            }
        }

        public static LiveShowPartyTeamMember parseFrom(byte[] bArr) {
            return (LiveShowPartyTeamMember) MessageNano.mergeFrom(new LiveShowPartyTeamMember(), bArr);
        }

        public static LiveShowPartyTeamMember parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShowPartyTeamMember().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShowPartyEnd extends MessageNano {
        private static volatile LiveShowPartyEnd[] _emptyArray;
        public String extraInfoPb;
        public int playType;
        public String showPartyId;

        public static LiveShowPartyEnd[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShowPartyEnd[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShowPartyEnd() {
            clear();
        }

        public final LiveShowPartyEnd clear() {
            this.showPartyId = "";
            this.playType = 0;
            this.extraInfoPb = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.showPartyId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            if (!this.extraInfoPb.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.extraInfoPb);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.showPartyId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            return !this.extraInfoPb.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(3, this.extraInfoPb) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShowPartyEnd mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.showPartyId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.playType = codedInputByteBufferNano.readUInt32();
                } else if (tag != 26) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.extraInfoPb = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveShowPartyEnd parseFrom(byte[] bArr) {
            return (LiveShowPartyEnd) MessageNano.mergeFrom(new LiveShowPartyEnd(), bArr);
        }

        public static LiveShowPartyEnd parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShowPartyEnd().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShowPartyTimeLine extends MessageNano {
        private static volatile LiveShowPartyTimeLine[] _emptyArray;
        public long pkInfoScatterDurationMs;
        public long serverTime;
        public long startTime;
        public long voteDeadline;
        public long voteEndWaitDeadline;

        public static LiveShowPartyTimeLine[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShowPartyTimeLine[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShowPartyTimeLine() {
            clear();
        }

        public final LiveShowPartyTimeLine clear() {
            this.serverTime = 0L;
            this.startTime = 0L;
            this.voteDeadline = 0L;
            this.voteEndWaitDeadline = 0L;
            this.pkInfoScatterDurationMs = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.serverTime;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(2, j2);
            }
            long j3 = this.voteDeadline;
            if (j3 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j3);
            }
            long j4 = this.voteEndWaitDeadline;
            if (j4 != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j4);
            }
            long j5 = this.pkInfoScatterDurationMs;
            if (j5 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j5);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.serverTime;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            long j2 = this.startTime;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(2, j2);
            }
            long j3 = this.voteDeadline;
            if (j3 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j3);
            }
            long j4 = this.voteEndWaitDeadline;
            if (j4 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j4);
            }
            long j5 = this.pkInfoScatterDurationMs;
            return j5 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j5) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShowPartyTimeLine mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.serverTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 16) {
                    this.startTime = codedInputByteBufferNano.readUInt64();
                } else if (tag == 24) {
                    this.voteDeadline = codedInputByteBufferNano.readUInt64();
                } else if (tag == 32) {
                    this.voteEndWaitDeadline = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.pkInfoScatterDurationMs = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static LiveShowPartyTimeLine parseFrom(byte[] bArr) {
            return (LiveShowPartyTimeLine) MessageNano.mergeFrom(new LiveShowPartyTimeLine(), bArr);
        }

        public static LiveShowPartyTimeLine parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShowPartyTimeLine().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveShowPartyStatistic extends MessageNano {
        private static volatile SCLiveShowPartyStatistic[] _emptyArray;
        public String liveStreamId;
        public int playType;
        public String showPartyId;
        public long statisticVersion;
        public SCLiveShowPartyTeamInfo[] team;
        public long timestamp;
        public boolean voteEnd;

        public static SCLiveShowPartyStatistic[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShowPartyStatistic[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShowPartyStatistic() {
            clear();
        }

        public final SCLiveShowPartyStatistic clear() {
            this.liveStreamId = "";
            this.showPartyId = "";
            this.playType = 0;
            this.team = SCLiveShowPartyTeamInfo.emptyArray();
            this.voteEnd = false;
            this.timestamp = 0L;
            this.statisticVersion = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.liveStreamId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.liveStreamId);
            }
            if (!this.showPartyId.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(3, i);
            }
            SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr = this.team;
            if (sCLiveShowPartyTeamInfoArr != null && sCLiveShowPartyTeamInfoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr2 = this.team;
                    if (i2 >= sCLiveShowPartyTeamInfoArr2.length) {
                        break;
                    }
                    SCLiveShowPartyTeamInfo sCLiveShowPartyTeamInfo = sCLiveShowPartyTeamInfoArr2[i2];
                    if (sCLiveShowPartyTeamInfo != null) {
                        codedOutputByteBufferNano.writeMessage(4, sCLiveShowPartyTeamInfo);
                    }
                    i2++;
                }
            }
            boolean z = this.voteEnd;
            if (z) {
                codedOutputByteBufferNano.writeBool(5, z);
            }
            long j = this.timestamp;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(6, j);
            }
            long j2 = this.statisticVersion;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(7, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.liveStreamId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.liveStreamId);
            }
            if (!this.showPartyId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(3, i);
            }
            SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr = this.team;
            if (sCLiveShowPartyTeamInfoArr != null && sCLiveShowPartyTeamInfoArr.length > 0) {
                int i2 = 0;
                while (true) {
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr2 = this.team;
                    if (i2 >= sCLiveShowPartyTeamInfoArr2.length) {
                        break;
                    }
                    SCLiveShowPartyTeamInfo sCLiveShowPartyTeamInfo = sCLiveShowPartyTeamInfoArr2[i2];
                    if (sCLiveShowPartyTeamInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, sCLiveShowPartyTeamInfo);
                    }
                    i2++;
                }
            }
            boolean z = this.voteEnd;
            if (z) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(5, z);
            }
            long j = this.timestamp;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(6, j);
            }
            long j2 = this.statisticVersion;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(7, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShowPartyStatistic mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.liveStreamId = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.showPartyId = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.playType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 34) {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr = this.team;
                    int length = sCLiveShowPartyTeamInfoArr == null ? 0 : sCLiveShowPartyTeamInfoArr.length;
                    SCLiveShowPartyTeamInfo[] sCLiveShowPartyTeamInfoArr2 = new SCLiveShowPartyTeamInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.team, 0, sCLiveShowPartyTeamInfoArr2, 0, length);
                    }
                    while (length < sCLiveShowPartyTeamInfoArr2.length - 1) {
                        sCLiveShowPartyTeamInfoArr2[length] = new SCLiveShowPartyTeamInfo();
                        codedInputByteBufferNano.readMessage(sCLiveShowPartyTeamInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    sCLiveShowPartyTeamInfoArr2[length] = new SCLiveShowPartyTeamInfo();
                    codedInputByteBufferNano.readMessage(sCLiveShowPartyTeamInfoArr2[length]);
                    this.team = sCLiveShowPartyTeamInfoArr2;
                } else if (tag == 40) {
                    this.voteEnd = codedInputByteBufferNano.readBool();
                } else if (tag == 48) {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                } else if (tag != 56) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.statisticVersion = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveShowPartyStatistic parseFrom(byte[] bArr) {
            return (SCLiveShowPartyStatistic) MessageNano.mergeFrom(new SCLiveShowPartyStatistic(), bArr);
        }

        public static SCLiveShowPartyStatistic parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShowPartyStatistic().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveShowPartyGiftPkTeamInfoExtraInfo extends MessageNano {
        private static volatile SCLiveShowPartyGiftPkTeamInfoExtraInfo[] _emptyArray;
        public UserInfos.UserInfo[] richUser;

        public static SCLiveShowPartyGiftPkTeamInfoExtraInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShowPartyGiftPkTeamInfoExtraInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShowPartyGiftPkTeamInfoExtraInfo() {
            clear();
        }

        public final SCLiveShowPartyGiftPkTeamInfoExtraInfo clear() {
            this.richUser = UserInfos.UserInfo.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            UserInfos.UserInfo[] userInfoArr = this.richUser;
            if (userInfoArr != null && userInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.UserInfo[] userInfoArr2 = this.richUser;
                    if (i >= userInfoArr2.length) {
                        break;
                    }
                    UserInfos.UserInfo userInfo = userInfoArr2[i];
                    if (userInfo != null) {
                        codedOutputByteBufferNano.writeMessage(1, userInfo);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            UserInfos.UserInfo[] userInfoArr = this.richUser;
            if (userInfoArr != null && userInfoArr.length > 0) {
                int i = 0;
                while (true) {
                    UserInfos.UserInfo[] userInfoArr2 = this.richUser;
                    if (i >= userInfoArr2.length) {
                        break;
                    }
                    UserInfos.UserInfo userInfo = userInfoArr2[i];
                    if (userInfo != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, userInfo);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShowPartyGiftPkTeamInfoExtraInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
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
                    UserInfos.UserInfo[] userInfoArr = this.richUser;
                    int length = userInfoArr == null ? 0 : userInfoArr.length;
                    UserInfos.UserInfo[] userInfoArr2 = new UserInfos.UserInfo[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.richUser, 0, userInfoArr2, 0, length);
                    }
                    while (length < userInfoArr2.length - 1) {
                        userInfoArr2[length] = new UserInfos.UserInfo();
                        codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    userInfoArr2[length] = new UserInfos.UserInfo();
                    codedInputByteBufferNano.readMessage(userInfoArr2[length]);
                    this.richUser = userInfoArr2;
                }
            }
        }

        public static SCLiveShowPartyGiftPkTeamInfoExtraInfo parseFrom(byte[] bArr) {
            return (SCLiveShowPartyGiftPkTeamInfoExtraInfo) MessageNano.mergeFrom(new SCLiveShowPartyGiftPkTeamInfoExtraInfo(), bArr);
        }

        public static SCLiveShowPartyGiftPkTeamInfoExtraInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShowPartyGiftPkTeamInfoExtraInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShowPartyGiftInfo extends MessageNano {
        private static volatile LiveShowPartyGiftInfo[] _emptyArray;
        public LiveShowPartyPicUrl[] giftIcon;
        public long giftId;
        public String giftName;
        public long giftUnitPrice;

        public static LiveShowPartyGiftInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShowPartyGiftInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShowPartyGiftInfo() {
            clear();
        }

        public final LiveShowPartyGiftInfo clear() {
            this.giftId = 0L;
            this.giftName = "";
            this.giftUnitPrice = 0L;
            this.giftIcon = LiveShowPartyPicUrl.emptyArray();
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            long j = this.giftId;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(1, j);
            }
            if (!this.giftName.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.giftName);
            }
            long j2 = this.giftUnitPrice;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(3, j2);
            }
            LiveShowPartyPicUrl[] liveShowPartyPicUrlArr = this.giftIcon;
            if (liveShowPartyPicUrlArr != null && liveShowPartyPicUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveShowPartyPicUrl[] liveShowPartyPicUrlArr2 = this.giftIcon;
                    if (i >= liveShowPartyPicUrlArr2.length) {
                        break;
                    }
                    LiveShowPartyPicUrl liveShowPartyPicUrl = liveShowPartyPicUrlArr2[i];
                    if (liveShowPartyPicUrl != null) {
                        codedOutputByteBufferNano.writeMessage(4, liveShowPartyPicUrl);
                    }
                    i++;
                }
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            long j = this.giftId;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(1, j);
            }
            if (!this.giftName.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.giftName);
            }
            long j2 = this.giftUnitPrice;
            if (j2 != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(3, j2);
            }
            LiveShowPartyPicUrl[] liveShowPartyPicUrlArr = this.giftIcon;
            if (liveShowPartyPicUrlArr != null && liveShowPartyPicUrlArr.length > 0) {
                int i = 0;
                while (true) {
                    LiveShowPartyPicUrl[] liveShowPartyPicUrlArr2 = this.giftIcon;
                    if (i >= liveShowPartyPicUrlArr2.length) {
                        break;
                    }
                    LiveShowPartyPicUrl liveShowPartyPicUrl = liveShowPartyPicUrlArr2[i];
                    if (liveShowPartyPicUrl != null) {
                        iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, liveShowPartyPicUrl);
                    }
                    i++;
                }
            }
            return iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShowPartyGiftInfo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 8) {
                    this.giftId = codedInputByteBufferNano.readUInt64();
                } else if (tag == 18) {
                    this.giftName = codedInputByteBufferNano.readString();
                } else if (tag == 24) {
                    this.giftUnitPrice = codedInputByteBufferNano.readUInt64();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    int repeatedFieldArrayLength = WireFormatNano.getRepeatedFieldArrayLength(codedInputByteBufferNano, 34);
                    LiveShowPartyPicUrl[] liveShowPartyPicUrlArr = this.giftIcon;
                    int length = liveShowPartyPicUrlArr == null ? 0 : liveShowPartyPicUrlArr.length;
                    LiveShowPartyPicUrl[] liveShowPartyPicUrlArr2 = new LiveShowPartyPicUrl[repeatedFieldArrayLength + length];
                    if (length != 0) {
                        System.arraycopy(this.giftIcon, 0, liveShowPartyPicUrlArr2, 0, length);
                    }
                    while (length < liveShowPartyPicUrlArr2.length - 1) {
                        liveShowPartyPicUrlArr2[length] = new LiveShowPartyPicUrl();
                        codedInputByteBufferNano.readMessage(liveShowPartyPicUrlArr2[length]);
                        codedInputByteBufferNano.readTag();
                        length++;
                    }
                    liveShowPartyPicUrlArr2[length] = new LiveShowPartyPicUrl();
                    codedInputByteBufferNano.readMessage(liveShowPartyPicUrlArr2[length]);
                    this.giftIcon = liveShowPartyPicUrlArr2;
                }
            }
        }

        public static LiveShowPartyGiftInfo parseFrom(byte[] bArr) {
            return (LiveShowPartyGiftInfo) MessageNano.mergeFrom(new LiveShowPartyGiftInfo(), bArr);
        }

        public static LiveShowPartyGiftInfo parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShowPartyGiftInfo().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class LiveShowPartyPicUrl extends MessageNano {
        private static volatile LiveShowPartyPicUrl[] _emptyArray;
        public String cdn;
        public String ip;
        public String url;
        public String urlPattern;

        public static LiveShowPartyPicUrl[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LiveShowPartyPicUrl[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LiveShowPartyPicUrl() {
            clear();
        }

        public final LiveShowPartyPicUrl clear() {
            this.cdn = "";
            this.url = "";
            this.urlPattern = "";
            this.ip = "";
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.cdn.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.cdn);
            }
            if (!this.url.equals("")) {
                codedOutputByteBufferNano.writeString(2, this.url);
            }
            if (!this.urlPattern.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.urlPattern);
            }
            if (!this.ip.equals("")) {
                codedOutputByteBufferNano.writeString(4, this.ip);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.cdn.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.cdn);
            }
            if (!this.url.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(2, this.url);
            }
            if (!this.urlPattern.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.urlPattern);
            }
            return !this.ip.equals("") ? iComputeSerializedSize + CodedOutputByteBufferNano.computeStringSize(4, this.ip) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final LiveShowPartyPicUrl mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.cdn = codedInputByteBufferNano.readString();
                } else if (tag == 18) {
                    this.url = codedInputByteBufferNano.readString();
                } else if (tag == 26) {
                    this.urlPattern = codedInputByteBufferNano.readString();
                } else if (tag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.ip = codedInputByteBufferNano.readString();
                }
            }
        }

        public static LiveShowPartyPicUrl parseFrom(byte[] bArr) {
            return (LiveShowPartyPicUrl) MessageNano.mergeFrom(new LiveShowPartyPicUrl(), bArr);
        }

        public static LiveShowPartyPicUrl parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new LiveShowPartyPicUrl().mergeFrom(codedInputByteBufferNano);
        }
    }

    public static final class SCLiveShowPartyConfigUpdate extends MessageNano {
        private static volatile SCLiveShowPartyConfigUpdate[] _emptyArray;
        public long configVersion;
        public int playType;
        public String showPartyId;
        public long timestamp;
        public String widgetInfoConfig;

        public static SCLiveShowPartyConfigUpdate[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SCLiveShowPartyConfigUpdate[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SCLiveShowPartyConfigUpdate() {
            clear();
        }

        public final SCLiveShowPartyConfigUpdate clear() {
            this.showPartyId = "";
            this.playType = 0;
            this.widgetInfoConfig = "";
            this.configVersion = 0L;
            this.timestamp = 0L;
            this.cachedSize = -1;
            return this;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
            if (!this.showPartyId.equals("")) {
                codedOutputByteBufferNano.writeString(1, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                codedOutputByteBufferNano.writeUInt32(2, i);
            }
            if (!this.widgetInfoConfig.equals("")) {
                codedOutputByteBufferNano.writeString(3, this.widgetInfoConfig);
            }
            long j = this.configVersion;
            if (j != 0) {
                codedOutputByteBufferNano.writeUInt64(4, j);
            }
            long j2 = this.timestamp;
            if (j2 != 0) {
                codedOutputByteBufferNano.writeUInt64(5, j2);
            }
            super.writeTo(codedOutputByteBufferNano);
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final int computeSerializedSize() {
            int iComputeSerializedSize = super.computeSerializedSize();
            if (!this.showPartyId.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.showPartyId);
            }
            int i = this.playType;
            if (i != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i);
            }
            if (!this.widgetInfoConfig.equals("")) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.widgetInfoConfig);
            }
            long j = this.configVersion;
            if (j != 0) {
                iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(4, j);
            }
            long j2 = this.timestamp;
            return j2 != 0 ? iComputeSerializedSize + CodedOutputByteBufferNano.computeUInt64Size(5, j2) : iComputeSerializedSize;
        }

        @Override // com.google.protobuf.nano.MessageNano
        public final SCLiveShowPartyConfigUpdate mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
            while (true) {
                int tag = codedInputByteBufferNano.readTag();
                if (tag == 0) {
                    return this;
                }
                if (tag == 10) {
                    this.showPartyId = codedInputByteBufferNano.readString();
                } else if (tag == 16) {
                    this.playType = codedInputByteBufferNano.readUInt32();
                } else if (tag == 26) {
                    this.widgetInfoConfig = codedInputByteBufferNano.readString();
                } else if (tag == 32) {
                    this.configVersion = codedInputByteBufferNano.readUInt64();
                } else if (tag != 40) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                } else {
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                }
            }
        }

        public static SCLiveShowPartyConfigUpdate parseFrom(byte[] bArr) {
            return (SCLiveShowPartyConfigUpdate) MessageNano.mergeFrom(new SCLiveShowPartyConfigUpdate(), bArr);
        }

        public static SCLiveShowPartyConfigUpdate parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
            return new SCLiveShowPartyConfigUpdate().mergeFrom(codedInputByteBufferNano);
        }
    }
}
