package com.kuaishou.protobuf.signal.nano;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public @interface SignalType {
    public static final int HANG_UP = 2;
    public static final int HEART_BEAT = 16;
    public static final int JOIN_ROOM = 9;
    public static final int KICK_OFF = 5;
    public static final int LOG_SALVAGE = 23;
    public static final int MAKE_CALL = 1;
    public static final int MIGRATE_ROOM = 22;
    public static final int PING = 15;
    public static final int QUERY_ROOM_STATUS = 8;
    public static final int REPORT_P2P_CANDIDATE = 17;
    public static final int REPORT_ROOM_CONFIG = 21;
    public static final int SERVER_NODE_CHANGED = 7;
    public static final int SERVER_UNAVAILABLE = 6;
    public static final int SIGNAL_TYPE_UNKNOWN = 0;
    public static final int START_VOICE_PARTY = 12;
    public static final int STATUS_CHANGED = 3;
    public static final int STOP_JOIN_ROOM = 10;
    public static final int STOP_VOICE_PARTY = 13;
    public static final int UPDATE_JOIN_ROOM_INFO = 11;
    public static final int UPDATE_P2P_PEER_CANDIDATE = 18;
    public static final int UPDATE_PARTICIPANT_LIST = 4;
    public static final int UPDATE_PUSH_STREAM_CONFIG = 25;
    public static final int UPDATE_ROOM_CONFIG = 19;
    public static final int UPDATE_VOICE_PARTY_PARTICIPANTS = 14;
    public static final int UPLOAD_ROOM_CONFIG = 20;
    public static final int YUV_DUMP = 24;
}
