package com.kwai.video.ksvodplayerkit;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface KSVodConstants {
    public static final int KSVOD_PLAYER_ERROR_EIO = -5002;
    public static final int KSVOD_PLAYER_ERROR_EMFILE = -5003;
    public static final int KSVOD_PLAYER_ERROR_EOF = -5013;
    public static final int KSVOD_PLAYER_ERROR_ETIMEDOUT = -5004;
    public static final int KSVOD_PLAYER_ERROR_EXIT = -5012;
    public static final int KSVOD_PLAYER_ERROR_HTTP_BAD_REQUEST = -5005;
    public static final int KSVOD_PLAYER_ERROR_HTTP_FORBIDDEN = -5007;
    public static final int KSVOD_PLAYER_ERROR_HTTP_NOT_FOUND = -5008;
    public static final int KSVOD_PLAYER_ERROR_HTTP_OTHER_4XX = -5009;
    public static final int KSVOD_PLAYER_ERROR_HTTP_SERVER_ERROR = -5010;
    public static final int KSVOD_PLAYER_ERROR_HTTP_UNAUTHORIZED = -5006;
    public static final int KSVOD_PLAYER_ERROR_INVALIDDATA = -5011;
    public static final int KSVOD_PLAYER_ERROR_NO_MEMORY = -5104;
    public static final int KSVOD_PLAYER_ERROR_PROTOCOL_NOT_FOUND = -5001;
    public static final int KSVOD_PLAYER_ERROR_READ_DATA_IO_TIMEOUT = -5101;
    public static final int KSVOD_PLAYER_ERROR_UNSUPPORT_ACODEC = -5103;
    public static final int KSVOD_PLAYER_ERROR_UNSUPPORT_VCODEC = -5102;
    public static final int KSVOD_PLAYER_EVENT_AUDIO_RENDERING_START = 10002;
    public static final int KSVOD_PLAYER_EVENT_BUFFERING_END = 702;
    public static final int KSVOD_PLAYER_EVENT_BUFFERING_START = 701;
    public static final int KSVOD_PLAYER_EVENT_VDIEO_RENDERING_START = 3;
    public static final int KSVOD_PLAYER_INFO_AUDIO_RENDERING_START_AFTER_SEEK = 10004;
    public static final int KSVOD_PLAYER_INFO_BAD_INTERLEAVING = 800;
    public static final int KSVOD_PLAYER_INFO_HOST_SWITCH_END = 10206;
    public static final int KSVOD_PLAYER_INFO_HOST_SWITCH_START = 10205;
    public static final int KSVOD_PLAYER_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int KSVOD_PLAYER_INFO_METADATA_UPDATE = 802;
    public static final int KSVOD_PLAYER_INFO_NETWORK_BANDWIDTH = 703;
    public static final int KSVOD_PLAYER_INFO_NOT_SEEKABLE = 801;
    public static final int KSVOD_PLAYER_INFO_PLAY_CAN_LOAD_NEXT = 10209;
    public static final int KSVOD_PLAYER_INFO_PLAY_FINISHED = 10208;
    public static final int KSVOD_PLAYER_INFO_PLAY_STARTED = 10207;
    public static final int KSVOD_PLAYER_INFO_PLAY_TO_END = 10101;
    public static final int KSVOD_PLAYER_INFO_RELOADED_VIDEO_RENDERING_START = 10104;
    public static final int KSVOD_PLAYER_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int KSVOD_PLAYER_INFO_TIMED_TEXT_ERROR = 900;
    public static final int KSVOD_PLAYER_INFO_UNSUPPORTED_SUBTITL = 901;
    public static final int KSVOD_PLAYER_INFO_VIDEO_RENDERING_START_AFTER_SEEK = 10003;
    public static final int KSVOD_PLAYER_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int KSVOD_PLAYER_PLAYBACK_STATE_CHANGED = 10103;
    public static final int KSVOD_PLAYER_PRELOAD_FINISH = 10105;
    public static final int KSVOD_PLAYER_STOP_REASON_CANCELLED = 2;
    public static final int KSVOD_PLAYER_STOP_REASON_CONTENT_LENGTH_INVALID = 6;
    public static final int KSVOD_PLAYER_STOP_REASON_END = 7;
    public static final int KSVOD_PLAYER_STOP_REASON_FAILED = 3;
    public static final int KSVOD_PLAYER_STOP_REASON_FINISHED = 1;
    public static final int KSVOD_PLAYER_STOP_REASON_NO_CONTENT_LENGTH = 5;
    public static final int KSVOD_PLAYER_STOP_REASON_TIMEOUT = 4;
    public static final int KSVOD_PLAYER_STOP_REASON_UNKNOWN = 0;
    public static final int KSVOD_TASK_FAIL_REASON_CREATETASKFAIL = -4;
    public static final int KSVOD_TASK_FAIL_REASON_OPENDATASOURCE = -2;
    public static final int KSVOD_TASK_FAIL_REASON_READFAIL = -3;
    public static final int KSVOD_TASK_FAIL_REASON_WRITRFAIL = -1;
    public static final int MP_STATE_ASYNC_PREPARING = 2;
    public static final int MP_STATE_COMPLETED = 6;
    public static final int MP_STATE_END = 9;
    public static final int MP_STATE_ERROR = 8;
    public static final int MP_STATE_IDLE = 0;
    public static final int MP_STATE_INITIALIZED = 1;
    public static final int MP_STATE_PAUSED = 5;
    public static final int MP_STATE_PREPARED = 3;
    public static final int MP_STATE_STARTED = 4;
    public static final int MP_STATE_STOPPED = 7;
    public static final int URL_TYPE_DEFAULT = 0;
    public static final int URL_TYPE_HLS_MANIFEST = 2;
    public static final int URL_TYPE_MULTIRATE_MANIFEST = 1;
    public static final int URL_TYPE_SHORT_VIDEO_MANIFEST = 3;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    public static final int VOD_QUALITY_1080P = 1;
    public static final int VOD_QUALITY_BIAOQING = 4;
    public static final int VOD_QUALITY_CHAOQING = 2;
    public static final int VOD_QUALITY_GAOQING = 3;
    public static final int VOD_QUALITY_UNSET = 0;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface DownloadStopReason {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface ExportTaskFailedReason {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface KSVodPlayerEventType {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface KSVopPlayerErrorType {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface ScalingMode {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface State {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface UrlType {
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public @interface VodQuality {
    }
}
