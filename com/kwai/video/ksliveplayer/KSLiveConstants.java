package com.kwai.video.ksliveplayer;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public interface KSLiveConstants {
    public static final int KSLIVE_PLAYER_ERROR_EIO = -5002;
    public static final int KSLIVE_PLAYER_ERROR_EMFILE = -5003;
    public static final int KSLIVE_PLAYER_ERROR_EOF = -5013;
    public static final int KSLIVE_PLAYER_ERROR_ETIMEDOUT = -5004;
    public static final int KSLIVE_PLAYER_ERROR_EXIT = -5012;
    public static final int KSLIVE_PLAYER_ERROR_HTTP_BAD_REQUEST = -5005;
    public static final int KSLIVE_PLAYER_ERROR_HTTP_FORBIDDEN = -5007;
    public static final int KSLIVE_PLAYER_ERROR_HTTP_NOT_FOUND = -5008;
    public static final int KSLIVE_PLAYER_ERROR_HTTP_OTHER_4XX = -5009;
    public static final int KSLIVE_PLAYER_ERROR_HTTP_SERVER_ERROR = -5010;
    public static final int KSLIVE_PLAYER_ERROR_HTTP_UNAUTHORIZED = -5006;
    public static final int KSLIVE_PLAYER_ERROR_INVALIDDATA = -5011;
    public static final int KSLIVE_PLAYER_ERROR_NO_DATA_BUFFER_OVER_15_SEC_IN_ONE_MIN = 2;
    public static final int KSLIVE_PLAYER_ERROR_NO_DATA_EMPTY_BUFFER_OVER_1O_SEC = 1;
    public static final int KSLIVE_PLAYER_ERROR_NO_MEMORY = -5104;
    public static final int KSLIVE_PLAYER_ERROR_PROTOCOL_NOT_FOUND = -5001;
    public static final int KSLIVE_PLAYER_ERROR_READ_DATA_IO_TIMEOUT = -5101;
    public static final int KSLIVE_PLAYER_ERROR_UNSUPPORT_ACODEC = -5103;
    public static final int KSLIVE_PLAYER_ERROR_UNSUPPORT_VCODEC = -5102;
    public static final int KSLIVE_PLAYER_EVENT_AUDIO_RENDERING_START = 101;
    public static final int KSLIVE_PLAYER_EVENT_BUFFERING_END = 103;
    public static final int KSLIVE_PLAYER_EVENT_BUFFERING_START = 102;
    public static final int KSLIVE_PLAYER_EVENT_LIVE_TYPE_CHANGE = 104;
    public static final int KSLIVE_PLAYER_EVENT_RETRY_END = 106;
    public static final int KSLIVE_PLAYER_EVENT_RETRY_START = 105;
    public static final int KSLIVE_PLAYER_EVENT_VDIEO_RENDERING_START = 100;
    public static final int KSLive_MANIFEST_MEDIA_TYPE_AUDIO_ONLY = 3;
    public static final int KSLive_MANIFEST_MEDIA_TYPE_HYBRID = 1;
    public static final int KSLive_MANIFEST_MEDIA_TYPE_UNKNOWN = 0;
    public static final int KSLive_MANIFEST_MEDIA_TYPE_VIDEO_ONLY = 2;

    public @interface KSLiveManifestMediaType {
    }

    public @interface KSLivePlayerErrorType {
    }

    public @interface KSLivePlayerEventType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface VideoScaleMode {
        public static final int VIDEO_SCALING_MODE_NOSCALE_TO_FIT = 3;
        public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
        public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    }
}
