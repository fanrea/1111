package com.kuaishou.protobuf.signal.nano;

import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class Signal extends MessageNano {
    private static volatile Signal[] _emptyArray;
    public int biz;
    public String callId;
    public String calleeId;
    public String callerId;
    public int from;
    public Hangup hangup;
    public HeartBeat heartBeat;
    public String host;
    public JoinRoom joinRoom;
    public JoinedRoomInfoUpdated joinedRoomInfoUpdated;
    public KickOff kickOff;
    public LogSalvage logSalvage;
    public MakeCall makeCall;
    public MigrateRoom migrateRoom;
    public UpdateParticipantList participants;
    public Ping ping;
    public QueryRoomStatus queryRoomStatus;
    public ReportP2PCandidate reportP2PCandidate;
    public ReportRoomConfig reportRoomConfig;
    public ServerNodeChanged serverNodeChanged;
    public ServerUnavailable serverUnavailable;
    public int signalType;
    public StatusChanged statusChanged;
    public StopJoinRoom stopJoinRoom;
    public long timestamp;
    public int to;
    public UpdateP2PPeerCandidate updateP2PPeerCandidate;
    public UpdatePushStreamConfig updatePushStreamConfig;
    public UpdateRoomConfig updateRoomConfig;
    public UpdateVoicePartyParticipants updateVoicePartyParticipants;
    public UploadRoomConfig uploadRoomConfig;
    public String version;
    public YUVDump yuvDump;

    public static Signal[] emptyArray() {
        if (_emptyArray == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (_emptyArray == null) {
                    _emptyArray = new Signal[0];
                }
            }
        }
        return _emptyArray;
    }

    public Signal() {
        clear();
    }

    public final Signal clear() {
        this.version = "";
        this.from = 0;
        this.to = 0;
        this.signalType = 0;
        this.timestamp = 0L;
        this.biz = 0;
        this.callerId = "";
        this.calleeId = "";
        this.callId = "";
        this.host = "";
        this.makeCall = null;
        this.hangup = null;
        this.statusChanged = null;
        this.participants = null;
        this.kickOff = null;
        this.serverUnavailable = null;
        this.serverNodeChanged = null;
        this.queryRoomStatus = null;
        this.joinRoom = null;
        this.stopJoinRoom = null;
        this.joinedRoomInfoUpdated = null;
        this.updateVoicePartyParticipants = null;
        this.ping = null;
        this.heartBeat = null;
        this.reportP2PCandidate = null;
        this.updateP2PPeerCandidate = null;
        this.updateRoomConfig = null;
        this.uploadRoomConfig = null;
        this.reportRoomConfig = null;
        this.migrateRoom = null;
        this.logSalvage = null;
        this.yuvDump = null;
        this.updatePushStreamConfig = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws CodedOutputByteBufferNano.OutOfSpaceException {
        if (!this.version.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.version);
        }
        int i = this.from;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        int i2 = this.to;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(3, i2);
        }
        int i3 = this.signalType;
        if (i3 != 0) {
            codedOutputByteBufferNano.writeInt32(4, i3);
        }
        long j = this.timestamp;
        if (j != 0) {
            codedOutputByteBufferNano.writeUInt64(5, j);
        }
        int i4 = this.biz;
        if (i4 != 0) {
            codedOutputByteBufferNano.writeInt32(6, i4);
        }
        if (!this.callerId.equals("")) {
            codedOutputByteBufferNano.writeString(7, this.callerId);
        }
        if (!this.calleeId.equals("")) {
            codedOutputByteBufferNano.writeString(8, this.calleeId);
        }
        if (!this.callId.equals("")) {
            codedOutputByteBufferNano.writeString(9, this.callId);
        }
        if (!this.host.equals("")) {
            codedOutputByteBufferNano.writeString(10, this.host);
        }
        MakeCall makeCall = this.makeCall;
        if (makeCall != null) {
            codedOutputByteBufferNano.writeMessage(16, makeCall);
        }
        Hangup hangup = this.hangup;
        if (hangup != null) {
            codedOutputByteBufferNano.writeMessage(17, hangup);
        }
        StatusChanged statusChanged = this.statusChanged;
        if (statusChanged != null) {
            codedOutputByteBufferNano.writeMessage(18, statusChanged);
        }
        UpdateParticipantList updateParticipantList = this.participants;
        if (updateParticipantList != null) {
            codedOutputByteBufferNano.writeMessage(19, updateParticipantList);
        }
        KickOff kickOff = this.kickOff;
        if (kickOff != null) {
            codedOutputByteBufferNano.writeMessage(20, kickOff);
        }
        ServerUnavailable serverUnavailable = this.serverUnavailable;
        if (serverUnavailable != null) {
            codedOutputByteBufferNano.writeMessage(21, serverUnavailable);
        }
        ServerNodeChanged serverNodeChanged = this.serverNodeChanged;
        if (serverNodeChanged != null) {
            codedOutputByteBufferNano.writeMessage(22, serverNodeChanged);
        }
        QueryRoomStatus queryRoomStatus = this.queryRoomStatus;
        if (queryRoomStatus != null) {
            codedOutputByteBufferNano.writeMessage(23, queryRoomStatus);
        }
        JoinRoom joinRoom = this.joinRoom;
        if (joinRoom != null) {
            codedOutputByteBufferNano.writeMessage(24, joinRoom);
        }
        StopJoinRoom stopJoinRoom = this.stopJoinRoom;
        if (stopJoinRoom != null) {
            codedOutputByteBufferNano.writeMessage(25, stopJoinRoom);
        }
        JoinedRoomInfoUpdated joinedRoomInfoUpdated = this.joinedRoomInfoUpdated;
        if (joinedRoomInfoUpdated != null) {
            codedOutputByteBufferNano.writeMessage(26, joinedRoomInfoUpdated);
        }
        UpdateVoicePartyParticipants updateVoicePartyParticipants = this.updateVoicePartyParticipants;
        if (updateVoicePartyParticipants != null) {
            codedOutputByteBufferNano.writeMessage(27, updateVoicePartyParticipants);
        }
        Ping ping = this.ping;
        if (ping != null) {
            codedOutputByteBufferNano.writeMessage(28, ping);
        }
        HeartBeat heartBeat = this.heartBeat;
        if (heartBeat != null) {
            codedOutputByteBufferNano.writeMessage(29, heartBeat);
        }
        ReportP2PCandidate reportP2PCandidate = this.reportP2PCandidate;
        if (reportP2PCandidate != null) {
            codedOutputByteBufferNano.writeMessage(30, reportP2PCandidate);
        }
        UpdateP2PPeerCandidate updateP2PPeerCandidate = this.updateP2PPeerCandidate;
        if (updateP2PPeerCandidate != null) {
            codedOutputByteBufferNano.writeMessage(31, updateP2PPeerCandidate);
        }
        UpdateRoomConfig updateRoomConfig = this.updateRoomConfig;
        if (updateRoomConfig != null) {
            codedOutputByteBufferNano.writeMessage(32, updateRoomConfig);
        }
        UploadRoomConfig uploadRoomConfig = this.uploadRoomConfig;
        if (uploadRoomConfig != null) {
            codedOutputByteBufferNano.writeMessage(33, uploadRoomConfig);
        }
        ReportRoomConfig reportRoomConfig = this.reportRoomConfig;
        if (reportRoomConfig != null) {
            codedOutputByteBufferNano.writeMessage(34, reportRoomConfig);
        }
        MigrateRoom migrateRoom = this.migrateRoom;
        if (migrateRoom != null) {
            codedOutputByteBufferNano.writeMessage(35, migrateRoom);
        }
        LogSalvage logSalvage = this.logSalvage;
        if (logSalvage != null) {
            codedOutputByteBufferNano.writeMessage(36, logSalvage);
        }
        YUVDump yUVDump = this.yuvDump;
        if (yUVDump != null) {
            codedOutputByteBufferNano.writeMessage(37, yUVDump);
        }
        UpdatePushStreamConfig updatePushStreamConfig = this.updatePushStreamConfig;
        if (updatePushStreamConfig != null) {
            codedOutputByteBufferNano.writeMessage(38, updatePushStreamConfig);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int iComputeSerializedSize = super.computeSerializedSize();
        if (!this.version.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.version);
        }
        int i = this.from;
        if (i != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(2, i);
        }
        int i2 = this.to;
        if (i2 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i2);
        }
        int i3 = this.signalType;
        if (i3 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(4, i3);
        }
        long j = this.timestamp;
        if (j != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeUInt64Size(5, j);
        }
        int i4 = this.biz;
        if (i4 != 0) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(6, i4);
        }
        if (!this.callerId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(7, this.callerId);
        }
        if (!this.calleeId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(8, this.calleeId);
        }
        if (!this.callId.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(9, this.callId);
        }
        if (!this.host.equals("")) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeStringSize(10, this.host);
        }
        MakeCall makeCall = this.makeCall;
        if (makeCall != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(16, makeCall);
        }
        Hangup hangup = this.hangup;
        if (hangup != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(17, hangup);
        }
        StatusChanged statusChanged = this.statusChanged;
        if (statusChanged != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(18, statusChanged);
        }
        UpdateParticipantList updateParticipantList = this.participants;
        if (updateParticipantList != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(19, updateParticipantList);
        }
        KickOff kickOff = this.kickOff;
        if (kickOff != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(20, kickOff);
        }
        ServerUnavailable serverUnavailable = this.serverUnavailable;
        if (serverUnavailable != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(21, serverUnavailable);
        }
        ServerNodeChanged serverNodeChanged = this.serverNodeChanged;
        if (serverNodeChanged != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(22, serverNodeChanged);
        }
        QueryRoomStatus queryRoomStatus = this.queryRoomStatus;
        if (queryRoomStatus != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(23, queryRoomStatus);
        }
        JoinRoom joinRoom = this.joinRoom;
        if (joinRoom != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(24, joinRoom);
        }
        StopJoinRoom stopJoinRoom = this.stopJoinRoom;
        if (stopJoinRoom != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(25, stopJoinRoom);
        }
        JoinedRoomInfoUpdated joinedRoomInfoUpdated = this.joinedRoomInfoUpdated;
        if (joinedRoomInfoUpdated != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(26, joinedRoomInfoUpdated);
        }
        UpdateVoicePartyParticipants updateVoicePartyParticipants = this.updateVoicePartyParticipants;
        if (updateVoicePartyParticipants != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(27, updateVoicePartyParticipants);
        }
        Ping ping = this.ping;
        if (ping != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(28, ping);
        }
        HeartBeat heartBeat = this.heartBeat;
        if (heartBeat != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(29, heartBeat);
        }
        ReportP2PCandidate reportP2PCandidate = this.reportP2PCandidate;
        if (reportP2PCandidate != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(30, reportP2PCandidate);
        }
        UpdateP2PPeerCandidate updateP2PPeerCandidate = this.updateP2PPeerCandidate;
        if (updateP2PPeerCandidate != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(31, updateP2PPeerCandidate);
        }
        UpdateRoomConfig updateRoomConfig = this.updateRoomConfig;
        if (updateRoomConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(32, updateRoomConfig);
        }
        UploadRoomConfig uploadRoomConfig = this.uploadRoomConfig;
        if (uploadRoomConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(33, uploadRoomConfig);
        }
        ReportRoomConfig reportRoomConfig = this.reportRoomConfig;
        if (reportRoomConfig != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(34, reportRoomConfig);
        }
        MigrateRoom migrateRoom = this.migrateRoom;
        if (migrateRoom != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(35, migrateRoom);
        }
        LogSalvage logSalvage = this.logSalvage;
        if (logSalvage != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(36, logSalvage);
        }
        YUVDump yUVDump = this.yuvDump;
        if (yUVDump != null) {
            iComputeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(37, yUVDump);
        }
        UpdatePushStreamConfig updatePushStreamConfig = this.updatePushStreamConfig;
        return updatePushStreamConfig != null ? iComputeSerializedSize + CodedOutputByteBufferNano.computeMessageSize(38, updatePushStreamConfig) : iComputeSerializedSize;
    }

    @Override // com.google.protobuf.nano.MessageNano
    public final Signal mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws InvalidProtocolBufferNanoException {
        while (true) {
            int tag = codedInputByteBufferNano.readTag();
            switch (tag) {
                case 0:
                    return this;
                case 10:
                    this.version = codedInputByteBufferNano.readString();
                    break;
                case 16:
                    int int32 = codedInputByteBufferNano.readInt32();
                    if (int32 != 0 && int32 != 1 && int32 != 2) {
                        break;
                    } else {
                        this.from = int32;
                        break;
                    }
                    break;
                case 24:
                    int int322 = codedInputByteBufferNano.readInt32();
                    if (int322 != 0 && int322 != 1 && int322 != 2) {
                        break;
                    } else {
                        this.to = int322;
                        break;
                    }
                    break;
                case 32:
                    int int323 = codedInputByteBufferNano.readInt32();
                    switch (int323) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            this.signalType = int323;
                            break;
                    }
                case 40:
                    this.timestamp = codedInputByteBufferNano.readUInt64();
                    break;
                case 48:
                    int int324 = codedInputByteBufferNano.readInt32();
                    switch (int324) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            this.biz = int324;
                            break;
                    }
                case 58:
                    this.callerId = codedInputByteBufferNano.readString();
                    break;
                case 66:
                    this.calleeId = codedInputByteBufferNano.readString();
                    break;
                case 74:
                    this.callId = codedInputByteBufferNano.readString();
                    break;
                case 82:
                    this.host = codedInputByteBufferNano.readString();
                    break;
                case 130:
                    if (this.makeCall == null) {
                        this.makeCall = new MakeCall();
                    }
                    codedInputByteBufferNano.readMessage(this.makeCall);
                    break;
                case 138:
                    if (this.hangup == null) {
                        this.hangup = new Hangup();
                    }
                    codedInputByteBufferNano.readMessage(this.hangup);
                    break;
                case 146:
                    if (this.statusChanged == null) {
                        this.statusChanged = new StatusChanged();
                    }
                    codedInputByteBufferNano.readMessage(this.statusChanged);
                    break;
                case 154:
                    if (this.participants == null) {
                        this.participants = new UpdateParticipantList();
                    }
                    codedInputByteBufferNano.readMessage(this.participants);
                    break;
                case 162:
                    if (this.kickOff == null) {
                        this.kickOff = new KickOff();
                    }
                    codedInputByteBufferNano.readMessage(this.kickOff);
                    break;
                case 170:
                    if (this.serverUnavailable == null) {
                        this.serverUnavailable = new ServerUnavailable();
                    }
                    codedInputByteBufferNano.readMessage(this.serverUnavailable);
                    break;
                case 178:
                    if (this.serverNodeChanged == null) {
                        this.serverNodeChanged = new ServerNodeChanged();
                    }
                    codedInputByteBufferNano.readMessage(this.serverNodeChanged);
                    break;
                case 186:
                    if (this.queryRoomStatus == null) {
                        this.queryRoomStatus = new QueryRoomStatus();
                    }
                    codedInputByteBufferNano.readMessage(this.queryRoomStatus);
                    break;
                case 194:
                    if (this.joinRoom == null) {
                        this.joinRoom = new JoinRoom();
                    }
                    codedInputByteBufferNano.readMessage(this.joinRoom);
                    break;
                case 202:
                    if (this.stopJoinRoom == null) {
                        this.stopJoinRoom = new StopJoinRoom();
                    }
                    codedInputByteBufferNano.readMessage(this.stopJoinRoom);
                    break;
                case 210:
                    if (this.joinedRoomInfoUpdated == null) {
                        this.joinedRoomInfoUpdated = new JoinedRoomInfoUpdated();
                    }
                    codedInputByteBufferNano.readMessage(this.joinedRoomInfoUpdated);
                    break;
                case 218:
                    if (this.updateVoicePartyParticipants == null) {
                        this.updateVoicePartyParticipants = new UpdateVoicePartyParticipants();
                    }
                    codedInputByteBufferNano.readMessage(this.updateVoicePartyParticipants);
                    break;
                case 226:
                    if (this.ping == null) {
                        this.ping = new Ping();
                    }
                    codedInputByteBufferNano.readMessage(this.ping);
                    break;
                case 234:
                    if (this.heartBeat == null) {
                        this.heartBeat = new HeartBeat();
                    }
                    codedInputByteBufferNano.readMessage(this.heartBeat);
                    break;
                case 242:
                    if (this.reportP2PCandidate == null) {
                        this.reportP2PCandidate = new ReportP2PCandidate();
                    }
                    codedInputByteBufferNano.readMessage(this.reportP2PCandidate);
                    break;
                case 250:
                    if (this.updateP2PPeerCandidate == null) {
                        this.updateP2PPeerCandidate = new UpdateP2PPeerCandidate();
                    }
                    codedInputByteBufferNano.readMessage(this.updateP2PPeerCandidate);
                    break;
                case 258:
                    if (this.updateRoomConfig == null) {
                        this.updateRoomConfig = new UpdateRoomConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.updateRoomConfig);
                    break;
                case 266:
                    if (this.uploadRoomConfig == null) {
                        this.uploadRoomConfig = new UploadRoomConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.uploadRoomConfig);
                    break;
                case 274:
                    if (this.reportRoomConfig == null) {
                        this.reportRoomConfig = new ReportRoomConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.reportRoomConfig);
                    break;
                case 282:
                    if (this.migrateRoom == null) {
                        this.migrateRoom = new MigrateRoom();
                    }
                    codedInputByteBufferNano.readMessage(this.migrateRoom);
                    break;
                case 290:
                    if (this.logSalvage == null) {
                        this.logSalvage = new LogSalvage();
                    }
                    codedInputByteBufferNano.readMessage(this.logSalvage);
                    break;
                case 298:
                    if (this.yuvDump == null) {
                        this.yuvDump = new YUVDump();
                    }
                    codedInputByteBufferNano.readMessage(this.yuvDump);
                    break;
                case 306:
                    if (this.updatePushStreamConfig == null) {
                        this.updatePushStreamConfig = new UpdatePushStreamConfig();
                    }
                    codedInputByteBufferNano.readMessage(this.updatePushStreamConfig);
                    break;
                default:
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, tag)) {
                        return this;
                    }
                    break;
            }
        }
    }

    public static Signal parseFrom(byte[] bArr) {
        return (Signal) MessageNano.mergeFrom(new Signal(), bArr);
    }

    public static Signal parseFrom(CodedInputByteBufferNano codedInputByteBufferNano) {
        return new Signal().mergeFrom(codedInputByteBufferNano);
    }
}
