package com.ss.ttm.player;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ImageReader;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface MediaPlayer {
    public static final int AE_CLIMITER = 1;
    public static final int AE_COMPRESSOR = 0;
    public static final int AUDIO_MASTER = 0;
    public static final int AVCOL_PRI_BT2020 = 9;
    public static final int AVCOL_PRI_BT709 = 1;
    public static final int AVCOL_PRI_UNSPECIFIED = 2;
    public static final int AVCOL_SPC_BT2020_CL = 10;
    public static final int AVCOL_SPC_BT2020_NCL = 9;
    public static final int AVCOL_SPC_BT709 = 1;
    public static final int AVCOL_SPC_UNSPECIFIED = 2;
    public static final int AVCOL_TRC_ARIB_STD_B67 = 18;
    public static final int AVCOL_TRC_BT709 = 1;
    public static final int AVCOL_TRC_SMPTE2084 = 16;
    public static final int AVCOL_TRC_UNSPECIFIED = 2;
    public static final int AVSeekTypeAny = 0;
    public static final int AVSeekTypeBackWard = 1;
    public static final int CACHE_LOADER = 4;
    public static final int CONSTRAST_IMAGE_ENHANCEMENT = 1;
    public static final int DEFAULT_IMAGE_ENHANCEMENT = 0;
    public static final int DISABLE_DECODE_EXTERN_INFO = 0;
    public static final int DISABLE_TEST_NET_SPEED_VALUE = -1;
    public static final int ENABLE_DECODE_EXTERN_INFO = 1;
    public static final int ENABLE_TEST_NET_SPEED_INTERVAL_VALUE = 1;
    public static final int ENABLE_TEST_NET_SPEED_VALUE = 0;
    public static final int FFMPEG_LOG_DEBUG = 48;
    public static final int FFMPEG_LOG_ERROR = 16;
    public static final int FFMPEG_LOG_TRACE = 56;
    public static final int FRC_DEFAULT = 1;
    public static final int FRC_DISABLE = 0;
    public static final int FRC_HIGH = 3;
    public static final int FRC_MEDIUM = 2;
    public static final int HTTP_LOADER = 0;
    public static final int IMAGE_LAYOUT_ASPECT_FILL = 2;
    public static final int IMAGE_LAYOUT_ASPECT_FIT = 0;
    public static final int IMAGE_LAYOUT_FROM_LEFT_UP = 3;
    public static final int IMAGE_LAYOUT_TO_FILL = 1;
    public static final int IS_EXO_PLAYER = 5;
    public static final int IS_FREEDOM_PLAYER = 6;
    public static final int IS_LIVE_PLAY = 0;
    public static final int IS_OS_PLAYER = 0;
    public static final int IS_TT_IPC_PLAYER = 2;
    public static final int IS_TT_LITE_IPC_PLAYER = 4;
    public static final int IS_TT_LITE_PLAYER = 3;
    public static final int IS_TT_PLAYER = 1;
    public static final int IS_VOD_PLAY = 1;
    public static final int IsBreakpadCrashValue = 1;
    public static final int IsSimpleCrashValue = 0;
    public static final int LANCZOS_SCALE_VALUE = 1;
    public static final int LINEAR_SCALE_VALUE = 0;
    public static final int MEDIA_EXTERN_INFO_STREAM_INFO = 19;
    public static final int MEDIA_INFO_ABR_GET_PREDICT = -268435434;
    public static final int MEDIA_INFO_AUDIO_DECODE_STALL = -268435439;
    public static final int MEDIA_INFO_AUDIO_DEMUX_STALL = -268435441;
    public static final int MEDIA_INFO_AUDIO_PTS_BACK = -268435437;
    public static final int MEDIA_INFO_AUDIO_RENDER_STALL = 251658250;
    public static final int MEDIA_INFO_AUDIO_RENDER_START = 251658252;
    public static final int MEDIA_INFO_AVOUTSYNC_END = -268435406;
    public static final int MEDIA_INFO_AVOUTSYNC_START = -268435407;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BARRAGE_MASK_INFO = -268435392;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_BUFFER_RECVED = 251658242;
    public static final int MEDIA_INFO_DECODER_START = -268435404;
    public static final int MEDIA_INFO_DEVICE_OPENED = 251658245;
    public static final int MEDIA_INFO_DUMMY_PLAYER_SESSON_STOP = 16777217;
    public static final int MEDIA_INFO_EXO_FIRST_FRAME = 4;
    public static final int MEDIA_INFO_FIRST_AVSYNC_FRAME = -268435386;
    public static final int MEDIA_INFO_FIRST_FRAME_AFTER_SEEK = 251658248;
    public static final int MEDIA_INFO_FORMATER_START = -268435405;
    public static final int MEDIA_INFO_HTTP_REDIRECT = 251658241;
    public static final int MEDIA_INFO_INFO_ID_CHANGED = -268435436;
    public static final int MEDIA_INFO_LIVE_FIRST_FRAME_AFTER_SURFACE_CHANGE = -268435387;
    public static final int MEDIA_INFO_LIVE_HURRY_SKIP_END = 68;
    public static final int MEDIA_INFO_LIVE_VIDEO_RENDER_START = -268435389;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_POSITION_UPDATE = -268435438;
    public static final int MEDIA_INFO_PREBUFFERING_START = -268435408;
    public static final int MEDIA_INFO_PRECISE_PAUSED = -268435435;
    public static final int MEDIA_INFO_REFRESH_SURFACE = -268435385;
    public static final int MEDIA_INFO_RENDER_EXCEPTION = -268435383;
    public static final int MEDIA_INFO_ROTATION_CHANGED = 251658243;
    public static final int MEDIA_INFO_RTC_AUDIO_DECODE_STALL = -268435423;
    public static final int MEDIA_INFO_RTC_EVENT_NOTIFY = 43;
    public static final int MEDIA_INFO_RTC_LOG_INFO = 44;
    public static final int MEDIA_INFO_RTC_TRACE_INFO = 40;
    public static final int MEDIA_INFO_RTC_VIDEO_DECODE_STALL = -268435424;
    public static final int MEDIA_INFO_SAR_CHANGED = 251658246;
    public static final int MEDIA_INFO_SILENCE_DETECTED = 251658253;
    public static final int MEDIA_INFO_SOCKET_CONNECTRED = 251658240;
    public static final int MEDIA_INFO_SPEED_CHANGED = 251658247;
    public static final int MEDIA_INFO_SPSPPS_INFO = 33;
    public static final int MEDIA_INFO_STREAM_CHANGED = 251658244;
    public static final int MEDIA_INFO_SUBTITLE_INFO = -268435391;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_ABNORMAL_OCCURED = -268435384;
    public static final int MEDIA_INFO_VIDEO_DECODE_STALL = -268435440;
    public static final int MEDIA_INFO_VIDEO_DEMUX_STALL = -268435442;
    public static final int MEDIA_INFO_VIDEO_READY_FOR_DISPLAY = -268435390;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_RENDER_STALL = 251658251;
    public static final int MEDIA_INFO_VIDEO_SECOND_FRAME = -268435388;
    public static final int MEDIA_INFO_VIDEO_STREAM_BITRATE_CHANGED = 251658249;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;
    public static final int MEDIA_NO_AVRENDER_END = -268435402;
    public static final int MEDIA_NO_AVRENDER_START = -268435403;
    public static final int MEDIA_PLAYER_AAC_CODEC_ID = 2;
    public static final int MEDIA_PLAYER_ADAPTIVE_WORK_AROUND_MODE = 254;
    public static final int MEDIA_PLAYER_ANR_CRASH_VALUE = 0;
    public static final int MEDIA_PLAYER_AUDIO_DECODER_WRITE_ERROR = -499978;
    public static final int MEDIA_PLAYER_AUDIO_TRACK_ENABLE_OPTION = 61;
    public static final int MEDIA_PLAYER_AUDIO_TRACK_VOICE_VALUE = 1;
    public static final int MEDIA_PLAYER_AUTO_TEST_CHANGED_TYPR_VALUE = 0;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_FFMPEG = 0;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_ID = 1;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_JX = 2;
    public static final int MEDIA_PLAYER_BYTEVC1_CODEC_KSY = 1;
    public static final int MEDIA_PLAYER_BYTEVC2_CODEC_ID = 33;
    public static final int MEDIA_PLAYER_CRASHED_ERROR = -2139062143;
    public static final int MEDIA_PLAYER_CRASH_SIMPLE_VALUE = 1;
    public static final int MEDIA_PLAYER_DECRYPTION_KEY = 64;
    public static final int MEDIA_PLAYER_DECRYPTION_KEY_IS_NULL_ERROR = -499973;
    public static final int MEDIA_PLAYER_DEFAULT_RENDER = 49;
    public static final int MEDIA_PLAYER_DEFAULT_VOICE = 48;
    public static final int MEDIA_PLAYER_DRM_DECRYPT_FAILED = -499698;
    public static final int MEDIA_PLAYER_DRM_OPEN_FAILED = -499699;
    public static final int MEDIA_PLAYER_DUMMY_VOICE_VALUE = 2;
    public static final int MEDIA_PLAYER_EGL_VER_2 = 2;
    public static final int MEDIA_PLAYER_EGL_VER_3 = 3;
    public static final int MEDIA_PLAYER_EXTERN_VOICE_VALUE = 3;
    public static final int MEDIA_PLAYER_H264_CODEC_ID = 0;
    public static final int MEDIA_PLAYER_HIJACK_MEDIA_TYPE_ERROR = -499970;
    public static final int MEDIA_PLAYER_HIJACK_VID_ERROR = -499972;
    public static final int MEDIA_PLAYER_HTTP_BAD_REQUEST_ERROR = -499899;
    public static final int MEDIA_PLAYER_HTTP_CONTENT_TYPE_IS_NOT_VALID_ERROR = -499891;
    public static final int MEDIA_PLAYER_HTTP_FORBIDEN_ERROR = -499897;
    public static final int MEDIA_PLAYER_HTTP_NOT_FOUND_ERROR = -499896;
    public static final int MEDIA_PLAYER_HTTP_OTHER_4xx_ERROR = -499894;
    public static final int MEDIA_PLAYER_HTTP_REDIRECT_ERROR = -499890;
    public static final int MEDIA_PLAYER_HTTP_SERVER_ERROR_ERROR = -499893;
    public static final int MEDIA_PLAYER_HTTP_UNAUTHORIZED_ERROR = -499898;
    public static final int MEDIA_PLAYER_HURRY_CATCH_TIME_VALUE = 0;
    public static final int MEDIA_PLAYER_HURRY_SKIP_TIME_VALUE = 1;
    public static final int MEDIA_PLAYER_INVALID_INPUT_DATA_ERROR = -499985;
    public static final int MEDIA_PLAYER_IS_MOBILE_NETWORK = 1;
    public static final int MEDIA_PLAYER_IS_OTHER_NETWORK = 2;
    public static final int MEDIA_PLAYER_IS_WIFI_NETWORK = 0;
    public static final int MEDIA_PLAYER_LLASH_SWITCH_PERFORMED = 85;
    public static final int MEDIA_PLAYER_MEDIACODEC_DEVICE = 4;
    public static final int MEDIA_PLAYER_MP3_CODEC_ID = 3;
    public static final int MEDIA_PLAYER_NATIVEWINDOW_DEVICE = 1;
    public static final int MEDIA_PLAYER_NDK_CRASH_VALUE = 2;
    public static final int MEDIA_PLAYER_NONE_ERROR = 0;
    public static final int MEDIA_PLAYER_NOSETTING_RENDER_VALUE = 3;
    public static final int MEDIA_PLAYER_OPENGL_DEVICE = 0;
    public static final int MEDIA_PLAYER_OPEN_DECODER_ERROR = -499996;
    public static final int MEDIA_PLAYER_OPEN_DEVICE_ERROR = -499989;
    public static final int MEDIA_PLAYER_OPEN_OUTER_ERROR = -499993;
    public static final int MEDIA_PLAYER_OPEN_OUTLET_ERROR = -499992;
    public static final int MEDIA_PLAYER_OPTION_3XX_HAPPEN_TIME = 586;
    public static final int MEDIA_PLAYER_OPTION_ABNORMAL_DETECT_INTERVAL = 42302;
    public static final int MEDIA_PLAYER_OPTION_ABNORMAL_DETECT_STRATEGY = 42303;
    public static final int MEDIA_PLAYER_OPTION_ABR_ABI_VERSION = 831;
    public static final int MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE = 174;
    public static final int MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED = 175;
    public static final int MEDIA_PLAYER_OPTION_ABR_AVREAGE_BITRATE_DIFF = 610;
    public static final int MEDIA_PLAYER_OPTION_ABR_DECISION_INFO_CALLBACK = 1017;
    public static final int MEDIA_PLAYER_OPTION_ABR_DECISION_INFO_RECORD_MAX_COUNT = 1018;
    public static final int MEDIA_PLAYER_OPTION_ABR_DOWNLOAD_VIDEO_BITRATE = 601;
    public static final int MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE = 650;
    public static final int MEDIA_PLAYER_OPTION_ABR_HIGH_THRESHOLD = 178;
    public static final int MEDIA_PLAYER_OPTION_ABR_HURRY_THRESHOLD = 176;
    public static final int MEDIA_PLAYER_OPTION_ABR_LOW_THRESHOLD = 177;
    public static final int MEDIA_PLAYER_OPTION_ABR_PREDICT_VIDEO_BITRATE = 600;
    public static final int MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT = 179;
    public static final int MEDIA_PLAYER_OPTION_ABR_PROBE_MODE = 678;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_ABR_STREAM_INFO = 147;
    public static final int MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT = 173;
    public static final int MEDIA_PLAYER_OPTION_ABR_SWITCH_DELAY_TIME = 577;
    public static final int MEDIA_PLAYER_OPTION_ABR_SWITCH_TONEW = 579;
    public static final int MEDIA_PLAYER_OPTION_ABR_SWITCH_WASTE_BYTE = 578;
    public static final int MEDIA_PLAYER_OPTION_ACCURATE_LAYOUT = 253;
    public static final int MEDIA_PLAYER_OPTION_ADDITION_SUB_INFO = 1600;
    public static final int MEDIA_PLAYER_OPTION_ADVANCE_CHECK_BUFFERING_END = 313;
    public static final int MEDIA_PLAYER_OPTION_AE_CONFIG_JSON = 1158;
    public static final int MEDIA_PLAYER_OPTION_AE_DEVICE_PLAY_ABILITY = 1160;
    public static final int MEDIA_PLAYER_OPTION_AE_GRAPH_CONFIG = 1162;
    public static final int MEDIA_PLAYER_OPTION_AE_LOOKAHEAD_TIME = 1152;
    public static final int MEDIA_PLAYER_OPTION_AE_LU_END = 1155;
    public static final int MEDIA_PLAYER_OPTION_AE_LU_RANG = 1153;
    public static final int MEDIA_PLAYER_OPTION_AE_LU_START = 1154;
    public static final int MEDIA_PLAYER_OPTION_AE_MAX_MOM_LU = 1156;
    public static final int MEDIA_PLAYER_OPTION_AE_MAX_SHORTERM_LU = 1157;
    public static final int MEDIA_PLAYER_OPTION_AE_RELEASE_TIME = 1151;
    public static final int MEDIA_PLAYER_OPTION_AE_SRC_LUFS = 644;
    public static final int MEDIA_PLAYER_OPTION_AE_SRC_PEAK = 646;
    public static final int MEDIA_PLAYER_OPTION_AE_TAR_LUFS = 645;
    public static final int MEDIA_PLAYER_OPTION_AE_VOLUME_INFO_JSON = 1161;
    public static final int MEDIA_PLAYER_OPTION_AE_VOLUMINFO_VER = 1159;
    public static final int MEDIA_PLAYER_OPTION_AI_BARRAGE_URL = 750;
    public static final int MEDIA_PLAYER_OPTION_ALLOW_ALL_EXTENSIONS = 50501;
    public static final int MEDIA_PLAYER_OPTION_ALOG_WRITE_FUNC_ADDR = 231;
    public static final int MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC = 348;
    public static final int MEDIA_PLAYER_OPTION_ANRENDER_REFRESH_SURFACE = 42016;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_APPID = 512;
    public static final int MEDIA_PLAYER_OPTION_ASYNC_INIT_CODEC = 181;
    public static final int MEDIA_PLAYER_OPTION_ASYNC_MANAGE_RESOURCE = 1038;
    public static final int MEDIA_PLAYER_OPTION_ASYNC_SET_WINDOW = 1316;
    public static final int MEDIA_PLAYER_OPTION_AUDIOPTS_MS_CORRECTION_EXTENSION = 598;
    public static final int MEDIA_PLAYER_OPTION_AUDIOTRACK_CONTENTTYPE = 1744;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_BUFFER_LENGTH = 73;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CACHED_NUM = 1058;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CHANNEL_CTL = 989;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CHECK_INFO = 203;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CODEC = 479;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CODEC_ID = 140;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CODEC_PROFILE = 402;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_CURRENT_DOWNLOAD_INDEX = 519;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_AND_GRAPH_MERGE = 1338;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_BUFLEN = 603;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_DB_VALUE = 10102;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_ERROR = 222;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_OPENED_TIME = 632;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DECODER_START_TIME = 631;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DNS_START_TIME = 623;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_DOWNLOAD_BYTES = 637;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_KNEE = 671;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_MODEL_PATH = 1163;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREDELAY = 306;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_PREGAIN = 303;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_RATIO = 305;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_THRESHOLD = 304;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_EFFECT_TYPE = 643;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_FIRST_LIVE_FRAME_RENDER_TIME = 698;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_FIRST_LIVE_PACKET_READ_TIME = 696;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME = 269;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_GRAPH_REFACTOR = 1337;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_HIT_CDN_CACHE = 723;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_HTTPX_CACHED = 955;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_HTTP_OPEN_START_TIME = 588;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_HTTP_REQ_FINSIH_TIME = 273;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME = 275;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_LIVE_CONNECT_TIME = 694;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_LIVE_OPEN_TIME = 692;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_OUTLET_DB_VALUE = 10100;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_PROCESSOR_ADDR = 251;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RANGE_SIZE = 244;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RANGE_TIME = 260;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RATE = 468;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RENDER_STALL_THRESHOLD = 321;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_REND_FIRST_FRAME_TIME = 628;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_RMS_MONITOR_ENABLE = 10101;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_SAVED_HOST_TIME = 267;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_SOCKET_CREATE_SUCCESS_TIME = 590;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_STREAM_DURATION = 525;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_SWITCH_CACHE_TIME = 271;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TIMESCALE_ENABLE = 460;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TIME_FOR_CDN = 727;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TIME_TO_SOURCE = 725;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TOTAL_CACHED_LEN = 639;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TRANS_OPEN_START_TIME = 589;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_TRAN_CONNECT_TIME = 268;
    public static final int MEDIA_PLAYER_OPTION_AUDIO_USE_DIRECT_BUFFER = 1039;
    public static final int MEDIA_PLAYER_OPTION_AUTO_AUDIO_DEVICE_DETECTION = 1743;
    public static final int MEDIA_PLAYER_OPTION_AUTO_DISCONNECTED_CPU = 1310;
    public static final int MEDIA_PLAYER_OPTION_AUTO_ROTATION = 33;
    public static final int MEDIA_PLAYER_OPTION_AVFORMAT_OPEN_TIME = 624;
    public static final int MEDIA_PLAYER_OPTION_AVG_DOWNLOAD_BITRATE = 615;
    public static final int MEDIA_PLAYER_OPTION_AVG_PLAY_BITRATE = 614;
    public static final int MEDIA_PLAYER_OPTION_AVG_VIDEO_BUFFER_LENGTH = 616;
    public static final int MEDIA_PLAYER_OPTION_AVNOSYNC_REPORT_THRES = 461;
    public static final int MEDIA_PLAYER_OPTION_AVOUTSYNC_MAX_DIFF = 526;
    public static final int MEDIA_PLAYER_OPTION_AVPH_DNS_PARSE_TIMEOUT = 656;
    public static final int MEDIA_PLAYER_OPTION_AVPH_PARAMS = 941;
    public static final int MEDIA_PLAYER_OPTION_AVPTS_DIFF_LIST = 825;
    public static final int MEDIA_PLAYER_OPTION_AVSYNC_DURATION_MS = 845;
    public static final int MEDIA_PLAYER_OPTION_AVSYNC_INTERRUPT_ENABLE = 855;
    public static final int MEDIA_PLAYER_OPTION_AVSYNC_REFINED = 1005;
    public static final int MEDIA_PLAYER_OPTION_AVUNSYNC_DIFF_MS = 841;
    public static final int MEDIA_PLAYER_OPTION_AVUNSYNC_DURATION_MS = 842;
    public static final int MEDIA_PLAYER_OPTION_AVUNSYNC_INFO = 844;
    public static final int MEDIA_PLAYER_OPTION_AV_NO_SYNC_THRESHOLD = 347;
    public static final int MEDIA_PLAYER_OPTION_AV_RENDER_SERIES = 846;
    public static final int MEDIA_PLAYER_OPTION_BACKGROUND_STATUS = 658;
    public static final int MEDIA_PLAYER_OPTION_BANDWIDTH_ESTIMATION_LOWER_BOUND_IN_BITS_PER_SECOND = 42029;
    public static final int MEDIA_PLAYER_OPTION_BANDWIDTH_ESTIMATION_SAMPLES_STANDARD_DEVIATION = 1137;
    public static final int MEDIA_PLAYER_OPTION_BANDWIDTH_ESTIMATION_UPPER_BOUND_IN_BITS_PER_SECOND = 42028;
    public static final int MEDIA_PLAYER_OPTION_BANDWIDTH_ESTIMATION_WINDOW_LENGTH_IN_MILLISECONDS = 42030;
    public static final int MEDIA_PLAYER_OPTION_BARRAGE_MASKURL = 612;
    public static final int MEDIA_PLAYER_OPTION_BASEPLAYER_AUDIO_BUFLEN = 605;
    public static final int MEDIA_PLAYER_OPTION_BASEPLAYER_VIDEO_BUFLEN = 604;
    public static final int MEDIA_PLAYER_OPTION_BIT_DEPTH = 1082;
    public static final int MEDIA_PLAYER_OPTION_BIT_RATE = 171;
    public static final int MEDIA_PLAYER_OPTION_BOX_DEMUXER = 477;
    public static final int MEDIA_PLAYER_OPTION_BT601_CLOSE_CODECASYNC = 595;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_BEFORE_FIRST_FRAME = 211;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_DATA_OF_MILLISECONDS = 86;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_END_IGNORE_VIDEO = 310;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_START_IDL_TIME = 1066;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_THRESHOLD_SIZE = 758;
    public static final int MEDIA_PLAYER_OPTION_BUFFERING_TIMEOUT = 81;
    public static final int MEDIA_PLAYER_OPTION_BUFS_WHEN_BUFFER_START = 609;
    public static final int MEDIA_PLAYER_OPTION_BYTEVC1_CODEC_TYPE = 67;
    public static final int MEDIA_PLAYER_OPTION_BYTEVC1_SW_FORBIDDEN = 399;
    public static final int MEDIA_PLAYER_OPTION_BYTEVC2_LOW_LATENCY = 581;
    public static final int MEDIA_PLAYER_OPTION_BYTEVC2_NALSIZE_CHECK = 592;
    public static final int MEDIA_PLAYER_OPTION_CACHE_AJFRAME_FIELD = 830;
    public static final int MEDIA_PLAYER_OPTION_CACHE_DIR = 34;
    public static final int MEDIA_PLAYER_OPTION_CACHE_HIT = 1251;
    public static final int MEDIA_PLAYER_OPTION_CACHE_OPEN_END_TIME = 1253;
    public static final int MEDIA_PLAYER_OPTION_CACHE_OPEN_START_TIME = 1252;
    public static final int MEDIA_PLAYER_OPTION_CACHE_READ_EOF_TIME = 1254;
    public static final int MEDIA_PLAYER_OPTION_CALIBRATION_AUDIO_PTS = 1043;
    public static final int MEDIA_PLAYER_OPTION_CALIBRATION_AUDIO_TYPE = 1311;
    public static final int MEDIA_PLAYER_OPTION_CATCHUP_SPEED = 80;
    public static final int MEDIA_PLAYER_OPTION_CELLULAT_NET_ID = 1029;
    public static final int MEDIA_PLAYER_OPTION_CERT_VERIFY_DETAIL = 1080;
    public static final int MEDIA_PLAYER_OPTION_CERT_VERIFY_FAILED = 1081;
    public static final int MEDIA_PLAYER_OPTION_CHANGE_REC_BUFFER_SPEED = 1046;
    public static final int MEDIA_PLAYER_OPTION_CHANNELS = 553;
    public static final int MEDIA_PLAYER_OPTION_CLIP_HEAACV2_FIRSTPTS_PACKET = 557;
    public static final int MEDIA_PLAYER_OPTION_CLOCK_RESUME_RESET_EOF = 224;
    public static final int MEDIA_PLAYER_OPTION_CLOSE_CODECPOOL = 1040;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_FIRSTSEG_CONNECT_TIME = 453;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_HIT_PUSH = 721;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_MAX_SEQ_NO = 718;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_MIN_SEQ_NO = 716;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_REQUEST_LOG = 691;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_REQ_SEQ_NO = 720;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_REQ_SEQ_NO_SERIES = 1100;
    public static final int MEDIA_PLAYER_OPTION_CMAF_AUDIO_REQ_SEQ_NO_SERIES_RESET = 1102;
    public static final int MEDIA_PLAYER_OPTION_CMAF_CONNECT_TIME = 452;
    public static final int MEDIA_PLAYER_OPTION_CMAF_HTTP_REQ_FINISH_TIME = 455;
    public static final int MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME = 456;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_CACHED = 1109;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_DNS_TIME = 457;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_PACKET_RECV_TIME = 451;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_PRELOAD_SUCC = 1108;
    public static final int MEDIA_PLAYER_OPTION_CMAF_MPD_SOCKET_CONNECT_TIME = 450;
    public static final int MEDIA_PLAYER_OPTION_CMAF_PARAMS = 689;
    public static final int MEDIA_PLAYER_OPTION_CMAF_SEGMENT_SYNC_THRESHOLD = 683;
    public static final int MEDIA_PLAYER_OPTION_CMAF_SEG_NUM_DIFF_THRESHOLD = 687;
    public static final int MEDIA_PLAYER_OPTION_CMAF_SKIP_FIND_AUDIO_STREAM_INFO = 96;
    public static final int MEDIA_PLAYER_OPTION_CMAF_START_SEGMENT_OFFSET = 684;
    public static final int MEDIA_PLAYER_OPTION_CMAF_START_SEQ_DIFF = 688;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VERSION = 685;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_FIRSTSEG_CONNECT_TIME = 454;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_HIT_PUSH = 722;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_MAX_SEQ_NO = 717;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_MIN_SEQ_NO = 715;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_REQUEST_LOG = 690;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_REQ_SEQ_NO = 719;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_REQ_SEQ_NO_SERIES = 1101;
    public static final int MEDIA_PLAYER_OPTION_CMAF_VIDEO_REQ_SEQ_NO_SERIES_RESET = 1103;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_CODECPOOL_RESPONSE = 1331;
    public static final int MEDIA_PLAYER_OPTION_CODECPOOL_SUPPORT_DYNAMIC_EXTEND = 1329;
    public static final int MEDIA_PLAYER_OPTION_CODECPOOL_VERSION = 1344;
    public static final int MEDIA_PLAYER_OPTION_CODEC_AND_SURFACE_REUSE = 1007;
    public static final int MEDIA_PLAYER_OPTION_CODEC_FB_ERR_SOLVER_ENABLE = 50500;
    public static final int MEDIA_PLAYER_OPTION_CODEC_FROM_POOL = 1042;
    public static final int MEDIA_PLAYER_OPTION_CODEC_HISTORY_LENGTH = 1347;
    public static final int MEDIA_PLAYER_OPTION_CODEC_MAX_USED_COUNT = 1348;
    public static final int MEDIA_PLAYER_OPTION_CODEC_STOP_TIMEOUT = 952;
    public static final int MEDIA_PLAYER_OPTION_COLOR_PRIMARIES = 911;
    public static final int MEDIA_PLAYER_OPTION_COLOR_SPACE = 910;
    public static final int MEDIA_PLAYER_OPTION_COLOR_TRC = 912;
    public static final int MEDIA_PLAYER_OPTION_CRASH_INFO = 5001;
    public static final int MEDIA_PLAYER_OPTION_CRASH_TEST = 22;
    public static final int MEDIA_PLAYER_OPTION_CRASH_TYPE = 26;
    public static final int MEDIA_PLAYER_OPTION_CREATE_AUDIOTRACK_EARLY = 1325;
    public static final int MEDIA_PLAYER_OPTION_CURRENT_VOLUME = 53;
    public static final int MEDIA_PLAYER_OPTION_DANGER_BUFFER_THRESHOLD = 294;
    public static final int MEDIA_PLAYER_OPTION_DATASPACE = 1087;
    public static final int MEDIA_PLAYER_OPTION_DECODERRENDER_CLEAR_SURFACE = 4003;
    public static final int MEDIA_PLAYER_OPTION_DECODERRENDER_CONTINUE_RETRY = 4002;
    public static final int MEDIA_PLAYER_OPTION_DECODERRENDER_VC2PRE_CREATE_RENDER = 4007;
    public static final int MEDIA_PLAYER_OPTION_DECODERRENDER_VC2RENDER_LATENCY = 4006;
    public static final int MEDIA_PLAYER_OPTION_DECODER_DROP_FRAME = 93;
    public static final int MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD = 363;
    public static final int MEDIA_PLAYER_OPTION_DECODE_AAC_THROUGH_FDKAAC = 1901;
    public static final int MEDIA_PLAYER_OPTION_DECODE_EXTERN_INFO = 52;
    public static final int MEDIA_PLAYER_OPTION_DECODE_FIRST_AUDIO_FRAME_TIME = 78;
    public static final int MEDIA_PLAYER_OPTION_DECODE_FIRST_VIDEO_FRAME_TIME = 77;
    public static final int MEDIA_PLAYER_OPTION_DECODE_SECOND_VIDEO_FRAME_TIME = 161;
    public static final int MEDIA_PLAYER_OPTION_DEC_CREATE_TIME = 626;
    public static final int MEDIA_PLAYER_OPTION_DEFAULT_AUDIO_BITRATE = 131;
    public static final int MEDIA_PLAYER_OPTION_DEFAULT_VIDEO_BITRATE = 130;
    public static final int MEDIA_PLAYER_OPTION_DELAY_BUFFERING_UPDATE = 263;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_BEGIN_TIME = 621;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_CREATE_TIME = 625;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD = 362;
    public static final int MEDIA_PLAYER_OPTION_DEMUXER_VIDEO_STACK_SIZE = 530;
    public static final int MEDIA_PLAYER_OPTION_DEQUEUE_OUTPUTBUFFER_COUNT = 1353;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_ACCURATE_START = 133;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM = 651;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_HWDEC_SEAMLESS = 279;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_LOOPER_TIMEOUT = 247;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_MC_REUSE = 401;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_PLAYER_STAYAWAKE = 5003;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_RESET_SYSTEM_VOLUME = 98;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_SHORT_SEEK = 201;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_SPILT_VOICE_WRITE = 564;
    public static final int MEDIA_PLAYER_OPTION_DISABLE_VC2_RECYCLE = 40096;
    public static final int MEDIA_PLAYER_OPTION_DISCARD_CODEC_STRATEGY1 = 1345;
    public static final int MEDIA_PLAYER_OPTION_DISCARD_CODEC_STRATEGY2 = 1346;
    public static final int MEDIA_PLAYER_OPTION_DISCONNECTED_CPU_TRACK = 1320;
    public static final int MEDIA_PLAYER_OPTION_DNS_START_TIME = 622;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_DIALOG_ENHANCE = 703;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_END_POINTER = 701;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_MIX_LEVEL = 706;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_PRESENTATION_ID = 705;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_REF_LEVEL = 704;
    public static final int MEDIA_PLAYER_OPTION_DOLBY_VIRTUALIZER = 702;
    public static final int MEDIA_PLAYER_OPTION_DOWNLOAD_SPEED = 63;
    public static final int MEDIA_PLAYER_OPTION_DRM_CLOSE_ROOT_CHECK = 209;
    public static final int MEDIA_PLAYER_OPTION_DRM_DOWNGRADE = 208;
    public static final int MEDIA_PLAYER_OPTION_DRM_TYPE = 206;
    public static final int MEDIA_PLAYER_OPTION_DROP_AUDIO_COST_TIME = 346;
    public static final int MEDIA_PLAYER_OPTION_DROP_AUDIO_PTS = 345;
    public static final int MEDIA_PLAYER_OPTION_DROP_FRAME_THRESHOLD = 50301;
    public static final int MEDIA_PLAYER_OPTION_DUMMYSURFACE_FORBID = 1034;
    public static final int MEDIA_PLAYER_OPTION_DUMMY_Player_SESSION_DESCRIPTION = 10000;
    public static final int MEDIA_PLAYER_OPTION_DUMMY_VOICE_SLEEP = 539;
    public static final int MEDIA_PLAYER_OPTION_DURATION_OF_START_AUTO_SPEED = 980;
    public static final int MEDIA_PLAYER_OPTION_DYNAMIC_DROPPING_CHECK_COUNT = 1014;
    public static final int MEDIA_PLAYER_OPTION_DYNAMIC_FRAME_DROPPING_CHECK_PERIOD = 1012;
    public static final int MEDIA_PLAYER_OPTION_DYNAMIC_FRAME_DROPPING_MULTIPLE = 1011;
    public static final int MEDIA_PLAYER_OPTION_DYNAMIC_THREAD_PRIORITY_VALUE = 568;
    public static final int MEDIA_PLAYER_OPTION_EANABLE_DROPPING_DTS_ROLLBACK = 148;
    public static final int MEDIA_PLAYER_OPTION_EGL_NEED_WORKAROUND = 183;
    public static final int MEDIA_PLAYER_OPTION_EMBELLISH_VOLUME_TIME = 64;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AI_BARRAGE = 751;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_ASYNC = 262;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_ASYNC_DOWNLOAD = 1079;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_ASYNC_PROBE = 1094;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AUDIOMEM_INTERGRATION = 673;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AUDIOTRACK_SMOOTH_CLOCK = 563;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AUDIO_EFFECT = 302;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AUDIO_SEEKING_NO_ACCURATE = 1902;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_AVPH_DNS_PARSE = 655;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_BARRAGE_MASK = 613;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_BIT_DEPTH = 1083;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_BUFFERING_LOWERCAPACITY = 674;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL = 296;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CACHE_INFO = 1084;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CACHE_SEI = 334;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CHANGE_START_PLAY_BUFFER = 988;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CHECK_DROP_TIME_COST = 1077;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT = 317;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CHECK_UNBIND_AUDIOPROCESSOR = 1092;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CLOSE_MEDIA_CODEC_RENDER_WHENRESET = 1091;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CMAF_FAST_MODE = 611;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CMAF_OPTIMIZE_RETRY = 680;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CMAF_SKIP_INIT_SECTION = 681;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CMAF_UPDATE_CMAF_ASYNC = 682;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CODEC_RECYCLE = 1052;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CORRECT_REAL_CLOCK = 42004;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CPPBYTEVC1CODEC_OPT = 580;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_CPPBYTEVC2CODEC_OPT = 591;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR = 172;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEBUG_UI_NOTIFY = 556;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DECODERRENDER_VC2RENDER_LATENCY = 4005;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL = 361;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DECODE_MULTI_SEI = 372;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE = 648;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEINTERLACE = 1004;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_RECYCLE = 1051;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_RW_LOCK = 679;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEMUXER_STALL = 360;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DEMUX_NONBLOCK_READ = 560;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DOWNGRADE_ASYNCCODEC = 675;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_DYNAMIC_FRAME_DROPPING = 1010;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_ENABLE_EXPIRED_LICENSE = 514;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FALLBACK_SW_DEC = 257;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FAST_STOP = 1050;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FILTER_RECYCLE = 1053;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FLUSH_SEEK = 823;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FLV_ABR = 324;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FLV_AUDIO_TAG_FOR_SPEED = 1131;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FLV_DUMMY_ABR = 42076;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FLV_TAG_BASED_SPEED = 1130;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FRAG_RANGE = 242;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_FRAME_DTS_CHECK = 640;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_GET_CACHE_TIMESTAMP = 292;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_HCHIP_ADAPTIVE_WORKAROUND = 575;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_HEAAVV2_PTS_MS_CORRECTION = 573;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_HLS_ABR = 180;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_HWDROPFRAME_WHENAVOUTSYNCING = 1056;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_HWDROPFRAME_WHENVOISINDROPSTATE = 1055;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_AVNOSYNC = 667;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_IGNORE_BACKGROUND_RENDERSTALL = 657;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_IMAGE_SCALE = 470;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_INDEX_CACHE = 241;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_KEYFRAME_GET_STRATEGY_PREDICT_BITRATE = 1300;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_LIVE_PRELOAD = 686;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT = 370;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_MCHIP_SKIP_ADAPTIVE_WORKAROUND = 576;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_MEDIACODEC_PIPELINE_CTL = 1333;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_MEDIA_CODEC_DEATH_CHECK = 1326;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_MEDIA_CODEC_FAIR_MUTEX = 1072;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_MEDIA_CODEC_RENDER_CLEAR_SURFACE = 1090;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_MP4_CHECK = 666;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_NATIVE_YV12_RENDER = 542;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_RENDER_EXCEPTION = 42049;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_NOTIFY_SEI_IMMEDIATELY_BEFORE_FIRSTFRAME = 649;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPEN_TIMEOUT = 291;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_ASYNC_DOWNLOAD = 1096;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_DASH_SEEK = 42005;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_HWDEC2SWDEC = 1332;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_INACCURATE_START = 761;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_IO = 1086;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_LIVE_PTS_ROLLBACK = 1097;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_MP4_ABR = 1071;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_PRERENDER = 1076;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_RADIO_MODE = 1098;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_SEEK_CLK = 762;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPTIMIZE_VOLUME2 = 1099;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OPT_SUB_SEARCH = 829;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_OUTLET_DROP_LIMIT = 149;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PIXEL_FORMAT_FULL_RANGE = 42100;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PLAYER_RECYCLE = 1054;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PREDEMUX = 587;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PRELOAD_GEAR = 756;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PREVENT_DTS_BACK = 641;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PRE_RENDER_BUFFERING_UPDATE = 571;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PROTOCOL_DOWNGRADE = 938;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION = 368;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_QCOM_LOW_LATENCY = 215;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_QCOM_VPP = 212;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_RANGE_OPTIMIZE = 1074;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_RECEIVE_BINARY_SEI = 670;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_REFRESH_BY_TIME = 299;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_RENDER_STALL = 323;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_RTCPLAY = 800;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_R_LOW_LATENCY = 597;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SEEK_BUFFERING = 677;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SEEK_EXACT = 515;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT = 248;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SET_AUDIO_PROCESSOR_AFTER_PLAY = 1073;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SHARP = 189;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SKIP_AUDIO_EFFECT = 1150;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM = 653;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG = 652;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SKIP_ON_BUFFERING_END = 1067;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SOLOPLAY = 185;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_STALL_COUNTER = 380;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_START_PLAY_SYNC = 1317;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_START_TIME_SKIP_AVSKIPSERIAL = 1013;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SUB = 618;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SUBTITLE_LAZY_LOADING = 1602;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SUBTITLE_SENSE_BUFFERING = 1601;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SUB_CPU_PROTECTION = 42023;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_SUB_TRY_OPT_LOGIC = 42025;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_TCP_FAST_OPEN = 316;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_THIRDPARTY_PROTOCOL = 1025;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_THREAD_PRIORITY = 561;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_THREAD_SAFE_REF = 870;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_UNSYNC_INFO = 843;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VC1_BLOCKLIST = 574;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VC1_RECYCLE = 40098;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VC2_HEAACV2_SAMPLENUMBER_ADAPTER = 42400;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VIDEO_FRAME_META_CALLBACK = 333;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VIDEO_MPD_REFRESH = 642;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VIDEO_SOFTWARE_DECODER_FIRST = 1745;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VIDEO_TIMESTAMP_MONOTONIC = 558;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER = 284;
    public static final int MEDIA_PLAYER_OPTION_ENABLE_XHEAAC_SUPPORT = 1900;
    public static final int MEDIA_PLAYER_OPTION_ENBALE_MEDIACODEC_SYNC_CLOSE = 676;
    public static final int MEDIA_PLAYER_OPTION_ENGINE_RETRY = 1349;
    public static final int MEDIA_PLAYER_OPTION_ERROR_CODE = 5000;
    public static final int MEDIA_PLAYER_OPTION_ESTIMATED_BANDWIDTH_AVERAGE = 1135;
    public static final int MEDIA_PLAYER_OPTION_ESTIMATED_BANDWIDTH_IN_BITS_PER_SECOND = 1134;
    public static final int MEDIA_PLAYER_OPTION_ESTIMATED_BANDWIDTH_STANDARD_DEVIATION = 1136;
    public static final int MEDIA_PLAYER_OPTION_EXTEND_CODEC_NUMS = 1330;
    public static final int MEDIA_PLAYER_OPTION_EXTERN_VOICE_OUTPUT_FORMAT = 42026;
    public static final int MEDIA_PLAYER_OPTION_FALLBACK_IN_MAX_INSTANCE_ERR = 1355;
    public static final int MEDIA_PLAYER_OPTION_FASTOPEN_LIVE_STREAM = 220;
    public static final int MEDIA_PLAYER_OPTION_FEED_IN_BEFORE_DECODED = 754;
    public static final int MEDIA_PLAYER_OPTION_FEED_PACKET_UNTIL_EMPTY = 559;
    public static final int MEDIA_PLAYER_OPTION_FILEPLAY_NO_BUFFRING = 551;
    public static final int MEDIA_PLAYER_OPTION_FILE_FORMAT = 516;
    public static final int MEDIA_PLAYER_OPTION_FILE_SIZE = 517;
    public static final int MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_DURATION = 537;
    public static final int MEDIA_PLAYER_OPTION_FIND_STREAM_INFO_PROBE_SIZE = 536;
    public static final int MEDIA_PLAYER_OPTION_FIRST_PACKET_TIME = 70;
    public static final int MEDIA_PLAYER_OPTION_FIRST_VIDEO_SEND_OUTLET_TIME = 459;
    public static final int MEDIA_PLAYER_OPTION_FIX_SPEED_FILTER_PTS_SHIFT = 1078;
    public static final int MEDIA_PLAYER_OPTION_FLUSH_WHEN_SETSURFACE = 1321;
    public static final int MEDIA_PLAYER_OPTION_FLV_SPEED_UPDATE_INT_MS = 1132;
    public static final int MEDIA_PLAYER_OPTION_FLV_TAG_BASED_SPEED = 1133;
    public static final int MEDIA_PLAYER_OPTION_FORBID_BUFFERING_VDEC_NOT_FINISHED = 1035;
    public static final int MEDIA_PLAYER_OPTION_FORBID_FALLBACK_NATIVERENDER = 4001;
    public static final int MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC = 550;
    public static final int MEDIA_PLAYER_OPTION_FORMATER_AUDIO_QUEUE_SIZE = 531;
    public static final int MEDIA_PLAYER_OPTION_FORMATER_CREATE_TIME = 620;
    public static final int MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_THRESH = 1312;
    public static final int MEDIA_PLAYER_OPTION_FORMATER_REC_BUFFER_TYPE = 1341;
    public static final int MEDIA_PLAYER_OPTION_FORMATER_SLEEP_DURATION = 42072;
    public static final int MEDIA_PLAYER_OPTION_FRAME_DROPPING_DTS_MAX_DIFF = 635;
    public static final int MEDIA_PLAYER_OPTION_FRAME_DROPPING_TERMINATED_DTS = 633;
    public static final int MEDIA_PLAYER_OPTION_FRAME_NUMS_IN_MEDIACODEC = 1334;
    public static final int MEDIA_PLAYER_OPTION_FRC_LEVEL = 285;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_CODEC_NAME = 158;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPENED_TIME = 163;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME = 156;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_DURATION = 965;
    public static final int MEDIA_PLAYER_OPTION_GET_AUDIO_PROCESS_TIME = 964;
    public static final int MEDIA_PLAYER_OPTION_GET_CLOCK_DIFF = 152;
    public static final int MEDIA_PLAYER_OPTION_GET_CONTAINER_FPS = 151;
    public static final int MEDIA_PLAYER_OPTION_GET_CUR_UI_FPS = 283;
    public static final int MEDIA_PLAYER_OPTION_GET_DROP_COUNT = 153;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_POS = 342;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_AUDIO_PTS = 344;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_POS = 341;
    public static final int MEDIA_PLAYER_OPTION_GET_FIRST_VIDEO_PTS = 343;
    public static final int MEDIA_PLAYER_OPTION_GET_HW_CODEC_EXCEPTION = 188;
    public static final int MEDIA_PLAYER_OPTION_GET_HW_CODEC_NAME = 187;
    public static final int MEDIA_PLAYER_OPTION_GET_IPLAYER_VERSION = 903;
    public static final int MEDIA_PLAYER_OPTION_GET_LOW_UI_FPS = 282;
    public static final int MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS = 654;
    public static final int MEDIA_PLAYER_OPTION_GET_MAX_SAMPLE_POS_BACK_DIFF = 665;
    public static final int MEDIA_PLAYER_OPTION_GET_NETWORK_CONNECT_COUNT = 469;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAYER_HOLDER = 902;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAYER_READ_STATE = 759;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAYER_REQ_OFFSET = 757;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAY_PREPARED_TIME = 307;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAY_STARTED_TIME = 308;
    public static final int MEDIA_PLAYER_OPTION_GET_PLAY_WASTE_DATA = 240;
    public static final int MEDIA_PLAYER_OPTION_GET_RES_HEADERS = 335;
    public static final int MEDIA_PLAYER_OPTION_GET_SESSIONID = 961;
    public static final int MEDIA_PLAYER_OPTION_GET_STREAM_INFO_FIND_END_TIME = 338;
    public static final int MEDIA_PLAYER_OPTION_GET_UNDERRUN_COUNT = 959;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS = 186;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME = 157;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPENED_TIME = 162;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME = 155;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_END_TIME = 337;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME = 336;
    public static final int MEDIA_PLAYER_OPTION_GET_VIDEO_OUTPUT_FPS = 150;
    public static final int MEDIA_PLAYER_OPTION_GIVEBACK_CODEC_EARLY = 1047;
    public static final int MEDIA_PLAYER_OPTION_GS_AUDIOTRACK_POOL_SIZE = 1359;
    public static final int MEDIA_PLAYER_OPTION_GS_ENABLE_GLOBAL_MUTE_FEATURE = 1015;
    public static final int MEDIA_PLAYER_OPTION_GS_GLOBAL_MUTE = 1016;
    public static final int MEDIA_PLAYER_OPTION_HANDLE_AUDIO_EXTRADATA = 287;
    public static final int MEDIA_PLAYER_OPTION_HARDWARECODEC_FLUSH_CLOSE = 593;
    public static final int MEDIA_PLAYER_OPTION_HARDWARE_DECODE_ENABLE = 59;
    public static final int MEDIA_PLAYER_OPTION_HEADSET_CHANGED_MSG = 4011;
    public static final int MEDIA_PLAYER_OPTION_HEAD_POASE = 3012;
    public static final int MEDIA_PLAYER_OPTION_HIJACK_CODE = 204;
    public static final int MEDIA_PLAYER_OPTION_HIJACK_EXIT = 246;
    public static final int MEDIA_PLAYER_OPTION_HLS_SUB_DEMUXER_PROBE_TYPE = 1070;
    public static final int MEDIA_PLAYER_OPTION_HOST_CACHE_MILLSEC = 41;
    public static final int MEDIA_PLAYER_OPTION_HOST_IP_ADDR = 71;
    public static final int MEDIA_PLAYER_OPTION_HTTP2_AUDIO_REUSED = 1105;
    public static final int MEDIA_PLAYER_OPTION_HTTP2_CONTEXT_START_COST = 945;
    public static final int MEDIA_PLAYER_OPTION_HTTP2_PARAMS = 944;
    public static final int MEDIA_PLAYER_OPTION_HTTP2_REUSED = 947;
    public static final int MEDIA_PLAYER_OPTION_HTTPX_AUDIO_RACE_RESULT = 1107;
    public static final int MEDIA_PLAYER_OPTION_HTTPX_NEGOTIATE_PROTOCOL = 951;
    public static final int MEDIA_PLAYER_OPTION_HTTPX_PUSHED_STREAM_COUNT = 957;
    public static final int MEDIA_PLAYER_OPTION_HTTPX_PUSH_URL_LIST = 956;
    public static final int MEDIA_PLAYER_OPTION_HTTPX_RACE_RESULT = 950;
    public static final int MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET = 290;
    public static final int MEDIA_PLAYER_OPTION_HTTP_HEADERS = 20;
    public static final int MEDIA_PLAYER_OPTION_HTTP_KEEP_ORIGIN_HOST = 1303;
    public static final int MEDIA_PLAYER_OPTION_HTTP_LOADER_TYPE = 14;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_HTTP_LOAD_PER_PERCENT = 18;
    public static final int MEDIA_PLAYER_OPTION_HTTP_OPEN_START_TIME = 583;
    public static final int MEDIA_PLAYER_OPTION_HTTP_RECEIVE_HEADER = 30;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_HTTP_RECONNECT = 7;
    public static final int MEDIA_PLAYER_OPTION_HTTP_RECONNECT_DELAY_MAX = 8;
    public static final int MEDIA_PLAYER_OPTION_HTTP_REDIRECT = 32;
    public static final int MEDIA_PLAYER_OPTION_HTTP_REQ_FINSIH_TIME = 821;
    public static final int MEDIA_PLAYER_OPTION_HTTP_RES_FINSIH_TIME = 822;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_HTTP_TIMEOUT = 9;
    public static final int MEDIA_PLAYER_OPTION_HTTP_USER_AGENT = 1021;
    public static final int MEDIA_PLAYER_OPTION_HURRY_CACHE_TYPE = 1064;
    public static final int MEDIA_PLAYER_OPTION_HURRY_DELAY_INC_THRESHOLD = 1401;
    public static final int MEDIA_PLAYER_OPTION_HURRY_INTERVAL = 1060;
    public static final int MEDIA_PLAYER_OPTION_HURRY_MILLISECOND = 397;
    public static final int MEDIA_PLAYER_OPTION_HURRY_ONCE_MAX = 1061;
    public static final int MEDIA_PLAYER_OPTION_HURRY_SKIP_START = 1062;
    public static final int MEDIA_PLAYER_OPTION_HURRY_START_MS = 1062;
    public static final int MEDIA_PLAYER_OPTION_HURRY_STOP_TYPE = 1065;
    public static final int MEDIA_PLAYER_OPTION_HURRY_TIME = 15;
    public static final int MEDIA_PLAYER_OPTION_HURRY_TYPE = 84;
    public static final int MEDIA_PLAYER_OPTION_HW_CONTROL_BY_OPPO = 184;
    public static final int MEDIA_PLAYER_OPTION_HW_DEC_DROP_NON_REF = 252;
    public static final int MEDIA_PLAYER_OPTION_HW_DYNAMICDROPPING_CHECKCOUNT = 50306;
    public static final int MEDIA_PLAYER_OPTION_HW_DYNAMICFRAMEDROPPING_CHECKPERIOD = 50305;
    public static final int MEDIA_PLAYER_OPTION_HW_DYNAMICFRAMEDROPPING_MULTIPLE = 50304;
    public static final int MEDIA_PLAYER_OPTION_HW_ENABLE_DYNAMICFRAMEDROPPING = 50303;
    public static final int MEDIA_PLAYER_OPTION_HW_SETMAXFPS = 50302;
    public static final int MEDIA_PLAYER_OPTION_IGNORE_AUDIO_RENDER_EOS_DELAYMS = 664;
    public static final int MEDIA_PLAYER_OPTION_IGNORE_SURFACE_CREATED = 1036;
    public static final int MEDIA_PLAYER_OPTION_IMAGE_ENHANCEMENT = 37;
    public static final int MEDIA_PLAYER_OPTION_IMAGE_LAYOUT = 36;
    public static final int MEDIA_PLAYER_OPTION_IMAGE_SCALE = 38;
    public static final int MEDIA_PLAYER_OPTION_IS_AUDIO_EFFECT_ENABLED = 541;
    public static final int MEDIA_PLAYER_OPTION_IS_MASTER_PLAYER = 1721;
    public static final int MEDIA_PLAYER_OPTION_IS_TILE_PLAYER = 3009;
    public static final int MEDIA_PLAYER_OPTION_IS_TOO_LARGE_AV_DIFF = 349;
    public static final int MEDIA_PLAYER_OPTION_IS_VPP_LEVEL = 213;
    public static final int MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY = 194;
    public static final int MEDIA_PLAYER_OPTION_KEEP_FORMAT_THREAD_ALIVE = 293;
    public static final int MEDIA_PLAYER_OPTION_LAST_AUDIO_DECODE_TIME = 367;
    public static final int MEDIA_PLAYER_OPTION_LAST_AUDIO_DEMUX_TIME = 365;
    public static final int MEDIA_PLAYER_OPTION_LAST_AUDIO_RENDER_TIME = 319;
    public static final int MEDIA_PLAYER_OPTION_LAST_VIDEO_DECODE_TIME = 366;
    public static final int MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME = 364;
    public static final int MEDIA_PLAYER_OPTION_LAST_VIDEO_RENDER_TIME = 320;
    public static final int MEDIA_PLAYER_OPTION_LATENCYTIME = 567;
    public static final int MEDIA_PLAYER_OPTION_LAZY_SEEK = 146;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_LICENSE_DIR = 510;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_LICENSE_FILENAME = 511;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_CURRENT_BITRATE = 931;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_ENABLE_BANDWIDTH_STRATEGY = 937;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_PREDICT_BITRATE = 963;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_REQUEST_URL = 933;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_STREAM_INFO = 147;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_BUFFER_THRESHOLD = 936;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_CLOSE_IO_COST = 549;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_COST = 930;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_FIND_STREAM_INFO_COST = 932;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_PREV_AUDIO_BUFFER = 935;
    public static final int MEDIA_PLAYER_OPTION_LIVE_ABR_SWITCH_PREV_VIDEO_BUFFER = 934;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_ERROR_EXIT = 714;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_READ_RETRY_COUNT = 713;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_STREAM_INFO = 710;
    public static final int MEDIA_PLAYER_OPTION_LIVE_AVPH_VIDEO_DIFF_THRESHOLD = 711;
    public static final int MEDIA_PLAYER_OPTION_LIVE_OPEN_END_TIME = 1256;
    public static final int MEDIA_PLAYER_OPTION_LIVE_OPEN_START_TIME = 1255;
    public static final int MEDIA_PLAYER_OPTION_LIVE_PRELOAD_CONFIG = 1258;
    public static final int MEDIA_PLAYER_OPTION_LIVE_READ_FIRST_PKT_TIME = 1257;
    public static final int MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP = 812;
    public static final int MEDIA_PLAYER_OPTION_LIVE_START_INDEX = 298;
    public static final int MEDIA_PLAYER_OPTION_LIVE_STREAM_MAX_CACHE_SECONDS = 198;
    public static final int MEDIA_PLAYER_OPTION_LIVE_STREAM_SESSION_ID = 811;
    public static final int MEDIA_PLAYER_OPTION_LLASH_REQUEST_PARAMS = 1139;
    public static final int MEDIA_PLAYER_OPTION_LLASH_TARGET_BITRATE_WITH_32_BITS_SUFFIX = 1138;
    public static final int MEDIA_PLAYER_OPTION_LOADER_TYPE = 200;
    public static final int MEDIA_PLAYER_OPTION_LOG_LEVEL = 984;
    public static final int MEDIA_PLAYER_OPTION_LOG_LEVEL_PERCISE = 1501;
    public static final int MEDIA_PLAYER_OPTION_LOOP_COUNT = 193;
    public static final int MEDIA_PLAYER_OPTION_LOOP_END_TIME = 138;
    public static final int MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO = 195;
    public static final int MEDIA_PLAYER_OPTION_LOOP_START_TIME = 137;
    public static final int MEDIA_PLAYER_OPTION_LOWER_AUDIOMEM_CAPACITY = 4009;
    public static final int MEDIA_PLAYER_OPTION_MASK_DELAY_LOADING = 1800;
    public static final int MEDIA_PLAYER_OPTION_MASK_DOWNLOAD_SIZE = 1801;
    public static final int MEDIA_PLAYER_OPTION_MASK_HEADER_LEN = 1803;
    public static final int MEDIA_PLAYER_OPTION_MASK_RANGE_OPT = 1802;
    public static final int MEDIA_PLAYER_OPTION_MASK_STREAM_OPENED_TIME = 852;
    public static final int MEDIA_PLAYER_OPTION_MASK_STREAM_OPEN_TIME = 851;
    public static final int MEDIA_PLAYER_OPTION_MASTER_M3U8_OPTIMIZE_ENABLE = 101;
    public static final int MEDIA_PLAYER_OPTION_MASTER_TYPE = 13;
    public static final int MEDIA_PLAYER_OPTION_MAX_AV_POS_GAP = 606;
    public static final int MEDIA_PLAYER_OPTION_MAX_BUFFERING_DATA_OF_MILLISECONDS = 110;
    public static final int MEDIA_PLAYER_OPTION_MAX_CACHE_SECONDS = 24;
    public static final int MEDIA_PLAYER_OPTION_MAX_CODEC_NUMS_IN_POOL = 1041;
    public static final int MEDIA_PLAYER_OPTION_MAX_DROP_FRAME_COST = 1069;
    public static final int MEDIA_PLAYER_OPTION_MAX_FRAME_NUMS_IN_MEDIACODEC = 1339;
    public static final int MEDIA_PLAYER_OPTION_MAX_VOLUME = 54;
    public static final int MEDIA_PLAYER_OPTION_MCMONITOR_QUEUE_SIZE = 1354;
    public static final int MEDIA_PLAYER_OPTION_MC_MAX_HEIGHT = 1009;
    public static final int MEDIA_PLAYER_OPTION_MC_MAX_WIDTH = 1008;
    public static final int MEDIA_PLAYER_OPTION_MC_RENDER_HANDLE_SAR = 1336;
    public static final int MEDIA_PLAYER_OPTION_MDAT_POS = 608;
    public static final int MEDIA_PLAYER_OPTION_MDL_SEEK_REOPEN = 570;
    public static final int MEDIA_PLAYER_OPTION_MEDIACODEC_ASYNC_ENABLE = 1000;
    public static final int MEDIA_PLAYER_OPTION_MEDIACODEC_DROP_NONREF = 216;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_ACCUMULATE_DOWNLOAD_BYTES = 476;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_AUTO_RECOVERY = 91;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_DEATH_CHECK_INTERVAL_MS = 1327;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_DEATH_TIMEOUT_MS = 1328;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME = 164;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_RENDER = 88;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_SIDE_DATA = 132;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_CODEC_SYNC_MODE = 90;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_COMMENT = 47;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_DOWNLOAD_BYTES = 45;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FILE_KEY = 17;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FILE_LOADED_SIZE = 21;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FILE_MAX_CACHE_SIZE = 19;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_FORMAT = 44;
    public static final int MEDIA_PLAYER_OPTION_MEDIA_PLAY_BYTES = 46;
    public static final int MEDIA_PLAYER_OPTION_META_DATA_INFO = 142;
    public static final int MEDIA_PLAYER_OPTION_MIN_AUDIO_FRAME_SZIE = 752;
    public static final int MEDIA_PLAYER_OPTION_MIN_BUFFER_MS_STOP_DROP = 1068;
    public static final int MEDIA_PLAYER_OPTION_MIN_FRAME_DURATION = 55;
    public static final int MEDIA_PLAYER_OPTION_MIN_VIDEO_FRAME_SZIE = 753;
    public static final int MEDIA_PLAYER_OPTION_MOCK_FIRST_LAGGING_TIME = 1738;
    public static final int MEDIA_PLAYER_OPTION_MOCK_LAGGING_END_TIME = 1739;
    public static final int MEDIA_PLAYER_OPTION_MOCK_MAX_LAGGING_CNT = 1734;
    public static final int MEDIA_PLAYER_OPTION_MOCK_MIN_LAGGING_INTERVAL = 1736;
    public static final int MEDIA_PLAYER_OPTION_MOCK_Single_LAGGING_DUR = 1735;
    public static final int MEDIA_PLAYER_OPTION_MOCK_TRIGGER_LAGGING_RATIO = 1737;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_MODULE_ID = 513;
    public static final int MEDIA_PLAYER_OPTION_MODULE_NAME = 509;
    public static final int MEDIA_PLAYER_OPTION_MOOV_POS = 607;
    public static final int MEDIA_PLAYER_OPTION_MULTISTREAM_FAST_PLAY_BUFFER_THRESHOLD = 1730;
    public static final int MEDIA_PLAYER_OPTION_MULTISTREAM_FORBID_PLAY_SPEED_CHANGE = 1729;
    public static final int MEDIA_PLAYER_OPTION_MULTISTREAM_OUT_OF_SYNC_THRESHOLD = 1726;
    public static final int MEDIA_PLAYER_OPTION_MULTISTREAM_RESYNC_THRESHOLD = 1725;
    public static final int MEDIA_PLAYER_OPTION_MULTISTREAM_SHOULD_CHECK_BUFFER_STATE = 1728;
    public static final int MEDIA_PLAYER_OPTION_MULTISTREAM_SYNC_THRESHOLD = 1724;
    public static final int MEDIA_PLAYER_OPTION_MULTI_AUDIO_TRACK_ENABLE = 42017;
    public static final int MEDIA_PLAYER_OPTION_NEED_CHECK_DROP_AUDIO = 340;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_AUTO_RECONNECT = 7;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_CLASS = 962;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_RECONNECT_COUNT = 538;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_TIMEOUT = 9;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_TRY_COUNT = 230;
    public static final int MEDIA_PLAYER_OPTION_NETWORK_TYPE = 39;
    public static final int MEDIA_PLAYER_OPTION_NOTIFY_ALL_SEI_THRESHOLD = 369;
    public static final int MEDIA_PLAYER_OPTION_NOTIFY_COMPLETED_IMMEDIATELY = 659;
    public static final int MEDIA_PLAYER_OPTION_NOTIFY_DEAD_LOCK = 301;
    public static final int MEDIA_PLAYER_OPTION_NO_AV_SYNC = 820;
    public static final int MEDIA_PLAYER_OPTION_NO_BUFFERING_UPDATE = 552;
    public static final int MEDIA_PLAYER_OPTION_NO_VARENDER_THRESHOLD = 981;
    public static final int MEDIA_PLAYER_OPTION_ONLY_DECODER_SEI = 2;
    public static final int MEDIA_PLAYER_OPTION_ONLY_PLAY_AUDIO_FOR_BOTH_STREAM = 1020;
    public static final int MEDIA_PLAYER_OPTION_OPEN_FAIL_TRY_AGINE = 82;
    public static final int MEDIA_PLAYER_OPTION_OPEN_INPUT_TIME = 970;
    public static final int MEDIA_PLAYER_OPTION_OPEN_RAISR = 89;
    public static final int MEDIA_PLAYER_OPTION_OPEN_SUB_RETRY_TIMES = 853;
    public static final int MEDIA_PLAYER_OPTION_OPEN_VOICE_IN_PREPARE = 827;
    public static final int MEDIA_PLAYER_OPTION_OPT_AUDIORENDERTIME_REPORT = 594;
    public static final int MEDIA_PLAYER_OPTION_OPT_REUSE_OF_SUB_DETACHING = 854;
    public static final int MEDIA_PLAYER_OPTION_OPT_SUB_FIRST_LOAD_TIME = 828;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_CREATE_TIME = 627;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_DROP_FRAME_TYPE = 92;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_FORBID_DROP_FRAME_VALUE = 0;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_HURRY_DROP = 2;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_LIMIT_MAX_FRAME_RATE_DROP_VALUE = 1;
    public static final int MEDIA_PLAYER_OPTION_OUTLET_THREAD_OPTIMIZE = 42027;
    public static final int MEDIA_PLAYER_OPTION_OUTPUT_LOG = 223;
    public static final int MEDIA_PLAYER_OPTION_OUT_OF_SYNC_WHEN_MASTER_REMOVED = 1727;
    public static final int MEDIA_PLAYER_OPTION_OUT_OF_SYNC_WHEN_PROGRESS_AHEAD = 1732;
    public static final int MEDIA_PLAYER_OPTION_OUT_OF_SYNC_WHEN_PROGRESS_DELAYED = 1731;
    public static final int MEDIA_PLAYER_OPTION_PANO_VIDEO_TYPE = 3011;
    public static final int MEDIA_PLAYER_OPTION_PLAYER_DBEUG_STATE = 474;
    public static final int MEDIA_PLAYER_OPTION_PLAYER_ID = 1722;
    public static final int MEDIA_PLAYER_OPTION_PLAYER_LIB_NAME = 1095;
    public static final int MEDIA_PLAYER_OPTION_PLAYER_SLEEP_DURATION = 42073;
    public static final int MEDIA_PLAYER_OPTION_PLAY_LOG_INFO = 5002;
    public static final int MEDIA_PLAYER_OPTION_PLAY_SPEED_EXTEND_ENABLE = 99;
    public static final int MEDIA_PLAYER_OPTION_PLAY_SPLIT_STREAM = 87;
    public static final int MEDIA_PLAYER_OPTION_PLAY_TYPE = 325;
    public static final int MEDIA_PLAYER_OPTION_POSITION_UPDATE_INTERVAL = 647;
    public static final int MEDIA_PLAYER_OPTION_POST_PREPARE = 276;
    public static final int MEDIA_PLAYER_OPTION_PREFER_NEAREST_MAX_POS_OFFSET = 985;
    public static final int MEDIA_PLAYER_OPTION_PREFER_NEAREST_SAMPLE = 95;
    public static final int MEDIA_PLAYER_OPTION_PRELOAD_GEAR = 755;
    public static final int MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS = 286;
    public static final int MEDIA_PLAYER_OPTION_PREPARE_DECODE_ONLY = 1063;
    public static final int MEDIA_PLAYER_OPTION_PREPROCESS_AUDIO_EFFECT_TYPE = 42110;
    public static final int MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE = 196;
    public static final int MEDIA_PLAYER_OPTION_PRE_RENDER_BUFFERING_UPDATE_PRECENTAGE = 572;
    public static final int MEDIA_PLAYER_OPTION_PRIMING_WORK_AROUND = 371;
    public static final int MEDIA_PLAYER_OPTION_PRIV_CODEC_NAME = 1002;
    public static final int MEDIA_PLAYER_OPTION_PROTOCOL_RETRY_TIMES = 939;
    public static final int MEDIA_PLAYER_OPTION_QUERY_ADAPTIVE_PLAYBACK = 1313;
    public static final int MEDIA_PLAYER_OPTION_QUERY_WINSIZE = 982;
    public static final int MEDIA_PLAYER_OPTION_QUEUE_INPUTBUFFER_COUNT = 1352;
    public static final int MEDIA_PLAYER_OPTION_QUEUE_MAX_FULL = 379;
    public static final int MEDIA_PLAYER_OPTION_QUIC_AUDIO_CHLO_COUNT = 1106;
    public static final int MEDIA_PLAYER_OPTION_QUIC_AUDIO_CONFIG_CACHED = 1104;
    public static final int MEDIA_PLAYER_OPTION_QUIC_CHLO_COUNT = 352;
    public static final int MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED = 351;
    public static final int MEDIA_PLAYER_OPTION_QUIC_CONFIG_OPTIMIZE = 927;
    public static final int MEDIA_PLAYER_OPTION_QUIC_CONNECTION_ID = 1024;
    public static final int MEDIA_PLAYER_OPTION_QUIC_ENABLE_CERT_VERIFY = 354;
    public static final int MEDIA_PLAYER_OPTION_QUIC_ENABLE_MTU_DISCOVERY = 357;
    public static final int MEDIA_PLAYER_OPTION_QUIC_ENABLE_UNRELIABLE = 396;
    public static final int MEDIA_PLAYER_OPTION_QUIC_FIFO_SIZE = 1006;
    public static final int MEDIA_PLAYER_OPTION_QUIC_FIX_PROCESS_TIMER = 921;
    public static final int MEDIA_PLAYER_OPTION_QUIC_FIX_STREAM_FIN_AND_RST = 924;
    public static final int MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE = 920;
    public static final int MEDIA_PLAYER_OPTION_QUIC_INIT_MTU = 356;
    public static final int MEDIA_PLAYER_OPTION_QUIC_INIT_RTT = 388;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_ACK_DELAY = 393;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSIONS = 389;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_CRYPTO_RETRANSMISSION_TIME_MS = 390;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSIONS = 391;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS = 392;
    public static final int MEDIA_PLAYER_OPTION_QUIC_MIN_RECEIVED_BEFORE_ACK_DECIMATION = 394;
    public static final int MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT = 355;
    public static final int MEDIA_PLAYER_OPTION_QUIC_PAD_HELLO = 395;
    public static final int MEDIA_PLAYER_OPTION_QUIC_PARAMS = 940;
    public static final int MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_MODE = 923;
    public static final int MEDIA_PLAYER_OPTION_QUIC_READ_BLOCK_TIMEOUT = 922;
    public static final int MEDIA_PLAYER_OPTION_QUIC_REJ_COUNT = 948;
    public static final int MEDIA_PLAYER_OPTION_QUIC_REJ_REASONS = 949;
    public static final int MEDIA_PLAYER_OPTION_QUIC_REPORT_INFO = 953;
    public static final int MEDIA_PLAYER_OPTION_QUIC_SCFG_ADDRESS = 353;
    public static final int MEDIA_PLAYER_OPTION_QUIC_SESSION_RECEIVED_WINDOW = 928;
    public static final int MEDIA_PLAYER_OPTION_QUIC_STREAM_RECEIVED_WINDOW = 929;
    public static final int MEDIA_PLAYER_OPTION_QUIC_TIMER_VERSION = 926;
    public static final int MEDIA_PLAYER_OPTION_QUIC_VERSION = 925;
    public static final int MEDIA_PLAYER_OPTION_RANGE_MODE = 258;
    public static final int MEDIA_PLAYER_OPTION_READ_CACHE_MODE = 289;
    public static final int MEDIA_PLAYER_OPTION_READ_MODE = 277;
    public static final int MEDIA_PLAYER_OPTION_REAL_STREAM_FORMAT = 1250;
    public static final int MEDIA_PLAYER_OPTION_REAL_TIME_META_DATA_INFO = 1500;
    public static final int MEDIA_PLAYER_OPTION_RECEIVE_FIRST_AUDIO_FRAME_TIME = 76;
    public static final int MEDIA_PLAYER_OPTION_RECEIVE_FIRST_AUDIO_PACKET_TIME = 1951;
    public static final int MEDIA_PLAYER_OPTION_RECEIVE_FIRST_VIDEO_FRAME_TIME = 75;
    public static final int MEDIA_PLAYER_OPTION_RECEIVE_FIRST_VIDEO_PACKET_TIME = 1950;
    public static final int MEDIA_PLAYER_OPTION_REDIRECT_URL = 596;
    public static final int MEDIA_PLAYER_OPTION_REFRESH_HANDLER = 1301;
    public static final int MEDIA_PLAYER_OPTION_RENDER_DEVICE = 139;
    public static final int MEDIA_PLAYER_OPTION_RENDER_ERR_NO_VIDEO = 467;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_200 = 381;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_300 = 382;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_400 = 383;
    public static final int MEDIA_PLAYER_OPTION_RENDER_STALL_500 = 384;
    public static final int MEDIA_PLAYER_OPTION_REND_FIRST_FRAME_TIME = 210;
    public static final int MEDIA_PLAYER_OPTION_REPORT_CCFB_TAG_IN_SHLO = 1209;
    public static final int MEDIA_PLAYER_OPTION_REPORT_CCRE_TAG_IN_CHLO = 1204;
    public static final int MEDIA_PLAYER_OPTION_REPORT_CCTK_FRAME_DATA = 1210;
    public static final int MEDIA_PLAYER_OPTION_REPORT_CCTK_TAG_IN_CHLO = 1207;
    public static final int MEDIA_PLAYER_OPTION_REPORT_FIRST_AVSYNC_FRAME = 475;
    public static final int MEDIA_PLAYER_OPTION_REPORT_FIRST_FRAME_FRAME_BUFFER_ONLY = 582;
    public static final int MEDIA_PLAYER_OPTION_REPORT_IRTT_TAG_IN_CHLO = 1206;
    public static final int MEDIA_PLAYER_OPTION_REPORT_JCCO_TAG_IN_CHLO = 1211;
    public static final int MEDIA_PLAYER_OPTION_REPORT_NTYP_TAG_IN_CHLO = 1208;
    public static final int MEDIA_PLAYER_OPTION_REPORT_SSR_TAG_IN_CHLO = 1205;
    public static final int MEDIA_PLAYER_OPTION_RESET_WHEN_REUSE = 1302;
    public static final int MEDIA_PLAYER_OPTION_REUSE_SOCKET = 154;
    public static final int MEDIA_PLAYER_OPTION_ROTATION = 555;
    public static final int MEDIA_PLAYER_OPTION_RTC_ANSWER_RECV_TIME = 808;
    public static final int MEDIA_PLAYER_OPTION_RTC_CUSTOM_LOG = 819;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER = 816;
    public static final int MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS = 814;
    public static final int MEDIA_PLAYER_OPTION_RTC_ENABLE_PLUGIN_LOAD = 885;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_RTC_ENABLE_RTC_UNINIT_LOCK_FREE = 882;
    public static final int MEDIA_PLAYER_OPTION_RTC_FALLBACK_THRESHLOD = 813;
    public static final int MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE = 880;
    public static final int MEDIA_PLAYER_OPTION_RTC_HARDWARE_DECODE_WITH_OES = 883;
    public static final int MEDIA_PLAYER_OPTION_RTC_ICE_CONNECTED_TIME = 834;
    public static final int MEDIA_PLAYER_OPTION_RTC_INITED_TIME = 806;
    public static final int MEDIA_PLAYER_OPTION_RTC_MAX_JITTER_BUFFER_DELAY = 881;
    public static final int MEDIA_PLAYER_OPTION_RTC_MAX_RECONNECT_COUNT = 803;
    public static final int MEDIA_PLAYER_OPTION_RTC_MIN_JITTER_BUFFER = 815;
    public static final int MEDIA_PLAYER_OPTION_RTC_OFFER_SEND_TIME = 807;
    public static final int MEDIA_PLAYER_OPTION_RTC_PARAMS_JSON = 817;
    public static final int MEDIA_PLAYER_OPTION_RTC_PLAY_TIMEINFO = 847;
    public static final int MEDIA_PLAYER_OPTION_RTC_PLUGIN_CLASS_PATH_NAME = 886;
    public static final int MEDIA_PLAYER_OPTION_RTC_PLUGIN_PACKAGE_NAME = 887;
    public static final int MEDIA_PLAYER_OPTION_RTC_PRELOADING = 832;
    public static final int MEDIA_PLAYER_OPTION_RTC_PRELOAD_RESULT = 833;
    public static final int MEDIA_PLAYER_OPTION_RTC_PROFILE_CONFIG = 818;
    public static final int MEDIA_PLAYER_OPTION_RTC_RECONNECT_INTERVAL = 804;
    public static final int MEDIA_PLAYER_OPTION_RTC_START_TIME = 809;
    public static final int MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_ENABLE = 802;
    public static final int MEDIA_PLAYER_OPTION_RTC_STATS_REPORT_INTERVAL = 805;
    public static final int MEDIA_PLAYER_OPTION_RTC_STAT_INFO = 810;
    public static final int MEDIA_PLAYER_OPTION_RTC_STOP_INFO = 884;
    public static final int MEDIA_PLAYER_OPTION_RTC_VENDOR_TYPE = 801;
    public static final int MEDIA_PLAYER_OPTION_RTM_DATA_ICE_CONNECT_START_TIME = 840;
    public static final int MEDIA_PLAYER_OPTION_RTM_DNS_TIME = 836;
    public static final int MEDIA_PLAYER_OPTION_RTM_SIGNAL_ANSWER_UPDATED_TIME = 839;
    public static final int MEDIA_PLAYER_OPTION_RTM_SIGNAL_OFFER_CREATED_TIME = 835;
    public static final int MEDIA_PLAYER_OPTION_RTM_SIGNAL_TRANSPORT_CONNECTED_TIME = 837;
    public static final int MEDIA_PLAYER_OPTION_RTM_TLS_HANDSHAKE_TIME = 838;
    public static final int MEDIA_PLAYER_OPTION_SAMPLE_RATE = 554;
    public static final int MEDIA_PLAYER_OPTION_SAVED_HOST_TIME = 68;
    public static final int MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD = 295;
    public static final int MEDIA_PLAYER_OPTION_SEEK_END_ENABLE = 143;
    public static final int MEDIA_PLAYER_OPTION_SEEK_TIMECOST_INFO = 481;
    public static final int MEDIA_PLAYER_OPTION_SERVER_IP = 1201;
    public static final int MEDIA_PLAYER_OPTION_SETTING_CODEC_NAME = 1003;
    public static final int MEDIA_PLAYER_OPTION_SETTING_RENDER_TYPE = 56;
    public static final int MEDIA_PLAYER_OPTION_SET_AUDIO_DEVICE_TYPE = 378;
    public static final int MEDIA_PLAYER_OPTION_SET_AUDIO_INFO_ID = 660;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_MAXDURATION = 329;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_PROBESIZE = 328;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUDIO_QUERY = 376;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_EXIT = 712;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_AUTO_REOPEN = 332;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_MAX_AV_DIFF = 331;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_OPEN_VIDEO_FIRST = 330;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_MAXDURATION = 327;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_PROBESIZE = 326;
    public static final int MEDIA_PLAYER_OPTION_SET_AVPH_VIDEO_QUERY = 377;
    public static final int MEDIA_PLAYER_OPTION_SET_CHECK_SILENCE_INTERVAL = 339;
    public static final int MEDIA_PLAYER_OPTION_SET_CODECFRAMESDROP = 1057;
    public static final int MEDIA_PLAYER_OPTION_SET_DEFAULT_AUDIO_INFO_ID = 662;
    public static final int MEDIA_PLAYER_OPTION_SET_DEFAULT_CODEC_ID = 182;
    public static final int MEDIA_PLAYER_OPTION_SET_DEFAULT_VIDEO_INFO_ID = 663;
    public static final int MEDIA_PLAYER_OPTION_SET_EGL_VER = 256;
    public static final int MEDIA_PLAYER_OPTION_SET_FFMPEG_LOG_LEVEL = 281;
    public static final int MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_MS_GAPS = 374;
    public static final int MEDIA_PLAYER_OPTION_SET_FORCE_DECODE_SWITCH = 373;
    public static final int MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS = 375;
    public static final int MEDIA_PLAYER_OPTION_SET_FRAMES_DROP = 159;
    public static final int MEDIA_PLAYER_OPTION_SET_HLSPROXY_PROTOCOL_HANDLE = 502;
    public static final int MEDIA_PLAYER_OPTION_SET_KSY_FRAME_WAIT = 192;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BANDWIDTH_DOWN_PARAMETER = 998;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_BITRATE_4UP_CEILING = 544;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_ENHANCE = 533;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CHECK_INTERVAL = 534;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_CLOSE_IO_IMMEDIATELY = 548;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_COUNTER_THRESHOLD = 996;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_ENABLE_STARTUP_BITRATE = 546;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_METHOD = 535;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD = 543;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_PID_KD = 995;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_PID_KI = 994;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_PID_KP = 993;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_REBUFF_PENALTY = 990;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SAFE_BUFFER = 992;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SHOULD_USE_PENALIZED = 999;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_STARTUP_DOWNLOAD_SPEED = 547;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SWITCH_ACTION = 545;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SWITCH_DOWN_BUFFER_THRESHOLD = 1023;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_SWITCH_NUMBER_THRESHOLD = 1022;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_TARGET_BUFFER = 991;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_ABR_UPGRADE_TIME_THRESHOLD = 997;
    public static final int MEDIA_PLAYER_OPTION_SET_LIVE_PROTOCOL_HANDLE = 501;
    public static final int MEDIA_PLAYER_OPTION_SET_LLASH_FAST_OPEN = 532;
    public static final int MEDIA_PLAYER_OPTION_SET_MAX_FPS = 134;
    public static final int MEDIA_PLAYER_OPTION_SET_MDL_PROTOCOL_HANDLE = 500;
    public static final int MEDIA_PLAYER_OPTION_SET_MEDIA_ID = 901;
    public static final int MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY = 197;
    public static final int MEDIA_PLAYER_OPTION_SET_PCDN_AND_FLV_ADAPT_ENABLE = 783;
    public static final int MEDIA_PLAYER_OPTION_SET_PCDN_ENABLE = 780;
    public static final int MEDIA_PLAYER_OPTION_SET_PCDN_H2P_CACHE = 782;
    public static final int MEDIA_PLAYER_OPTION_SET_PCDN_WATCH_THRESHOLD = 781;
    public static final int MEDIA_PLAYER_OPTION_SET_PIPE_DECLARE_LENGTH = 136;
    public static final int MEDIA_PLAYER_OPTION_SET_PIPE_START_OFFSET = 135;
    public static final int MEDIA_PLAYER_OPTION_SET_PRECISE_CACHE = 904;
    public static final int MEDIA_PLAYER_OPTION_SET_PRECISE_PAUSE_PTS = 668;
    public static final int MEDIA_PLAYER_OPTION_SET_RADIO_MODE = 261;
    public static final int MEDIA_PLAYER_OPTION_SET_SESSIONID = 960;
    public static final int MEDIA_PLAYER_OPTION_SET_SURFACE_RETRY_COUNT = 1044;
    public static final int MEDIA_PLAYER_OPTION_SET_SURFACE_RETRY_INTERVAL = 1045;
    public static final int MEDIA_PLAYER_OPTION_SET_TRACK_VOLUME = 94;
    public static final int MEDIA_PLAYER_OPTION_SET_UNSUPPORT_SAMPLERATE = 111;
    public static final int MEDIA_PLAYER_OPTION_SET_VIDEO_INFO_ID = 661;
    public static final int MEDIA_PLAYER_OPTION_SIDX_AUDIO_WINDOW_SIZE = 523;
    public static final int MEDIA_PLAYER_OPTION_SIDX_INFOS = 521;
    public static final int MEDIA_PLAYER_OPTION_SIDX_VIDEO_WINDOW_SIZE = 522;
    public static final int MEDIA_PLAYER_OPTION_SINGLE_MEDIA_CODEC = 1037;
    public static final int MEDIA_PLAYER_OPTION_SINGLE_PLAY_DOWNLOAD_BYTES = 145;
    public static final int MEDIA_PLAYER_OPTION_SKIP_AUDIO_GRAPH = 199;
    public static final int MEDIA_PLAYER_OPTION_SKIP_BUFFERING_BEFORE_FIRST_FRAME = 1085;
    public static final int MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT = 297;
    public static final int MEDIA_PLAYER_OPTION_SKIP_FIND_STREAM_INFO = 96;
    public static final int MEDIA_PLAYER_OPTION_SLOW_PLAY_MILLISECOND = 398;
    public static final int MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED = 191;
    public static final int MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME = 190;
    public static final int MEDIA_PLAYER_OPTION_SMOOTH_DELAYED_SEC = 40;
    public static final int MEDIA_PLAYER_OPTION_SOCKET_CREATE_SUCCESS_TIME = 585;
    public static final int MEDIA_PLAYER_OPTION_SOCKET_ERR_CODE = 466;
    public static final int MEDIA_PLAYER_OPTION_SOCKET_ERR_TYPE = 465;
    public static final int MEDIA_PLAYER_OPTION_SOCKET_RECV_BUFFER_SIZE = 25;
    public static final int MEDIA_PLAYER_OPTION_SPADE = 144;
    public static final int MEDIA_PLAYER_OPTION_SPADE_EXPIRE_TIME = 471;
    public static final int MEDIA_PLAYER_OPTION_SPADE_LOCAL_TIME = 472;
    public static final int MEDIA_PLAYER_OPTION_SPADE_UNIONINFO = 462;
    public static final int MEDIA_PLAYER_OPTION_SPEEDX_DROP = 358;
    public static final int MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT = 359;
    public static final int MEDIA_PLAYER_OPTION_SSR_ALWAYS = 1202;
    public static final int MEDIA_PLAYER_OPTION_START_DIRECTLLY_AFTER_PREPARED = 311;
    public static final int MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_THRES = 309;
    public static final int MEDIA_PLAYER_OPTION_START_PLAY_BUFFER_WAIT_TIME = 760;
    public static final int MEDIA_PLAYER_OPTION_START_PLAY_TIME = 100;
    public static final int MEDIA_PLAYER_OPTION_STOP_CLOSE_IO = 672;
    public static final int MEDIA_PLAYER_OPTION_STOP_SOURCE_ASYNC = 278;
    public static final int MEDIA_PLAYER_OPTION_STRATEGY_PARAMS_CALLBACK = 1019;
    public static final int MEDIA_PLAYER_OPTION_STREAM_FORMAT = 315;
    public static final int MEDIA_PLAYER_OPTION_STREAM_TRACK_INFO = 473;
    public static final int MEDIA_PLAYER_OPTION_STREAM_VOICE_DB_ENABLE = 987;
    public static final int MEDIA_PLAYER_OPTION_STREAM_VOICE_DB_VALUE = 986;
    public static final int MEDIA_PLAYER_OPTION_SUBTITLE_DOWNLOAD_SIZE = 856;
    public static final int MEDIA_PLAYER_OPTION_SUB_CPU_PROTECTION_GAP = 42024;
    public static final int MEDIA_PLAYER_OPTION_SUB_FIRST_LOAD_TIME = 850;
    public static final int MEDIA_PLAYER_OPTION_SUB_PATH_INFO = 617;
    public static final int MEDIA_PLAYER_OPTION_SUGGEST_SENDING_RATE = 1203;
    public static final int MEDIA_PLAYER_OPTION_SUPER_RES_FXAA_OPTION = 166;
    public static final int MEDIA_PLAYER_OPTION_SUPER_RES_OPTION = 165;
    public static final int MEDIA_PLAYER_OPTION_SUPER_RES_STRENGTH_OPTION = 167;
    public static final int MEDIA_PLAYER_OPTION_SWITCH_SUBID = 619;
    public static final int MEDIA_PLAYER_OPTION_SYNCHRONIZATION_GROUP_ID = 1720;
    public static final int MEDIA_PLAYER_OPTION_SYNCHRONIZER_RENDERING_PTS_DIFF = 1723;
    public static final int MEDIA_PLAYER_OPTION_SYNC_GROUP_STAT_INFO = 1733;
    public static final int MEDIA_PLAYER_OPTION_SYS_ERROR_CODE = 31;
    public static final int MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS = 518;
    public static final int MEDIA_PLAYER_OPTION_TEST_ACTION = 83;
    public static final int MEDIA_PLAYER_OPTION_TEST_NET_SPEED = 79;
    public static final int MEDIA_PLAYER_OPTION_TEST_NET_SPEED_DIFF = 66;
    public static final int MEDIA_PLAYER_OPTION_TEST_WINDOW_CHNAGE_TYPE = 85;
    public static final int MEDIA_PLAYER_OPTION_TFO_FALL_BACK_TIME = 318;
    public static final int MEDIA_PLAYER_OPTION_THIRDPARTY_AVDICTIONARY_PTR = 1028;
    public static final int MEDIA_PLAYER_OPTION_THIRDPARTY_PROTOCOL_NAME = 1027;
    public static final int MEDIA_PLAYER_OPTION_THIRDPARTY_PROTOCOL_PTR = 1026;
    public static final int MEDIA_PLAYER_OPTION_THREADNAME_TWO_CHAR_PAD = 1075;
    public static final int MEDIA_PLAYER_OPTION_THREAD_PRIORITY_VALUE = 562;
    public static final int MEDIA_PLAYER_OPTION_THREAD_RUN_REFACTOR = 1335;
    public static final int MEDIA_PLAYER_OPTION_THREAD_TIDS = 1804;
    public static final int MEDIA_PLAYER_OPTION_TILE_HEAD_ROTATE_DELAY = 3010;
    public static final int MEDIA_PLAYER_OPTION_TIME_BAR_PERCENTAGE = 312;
    public static final int MEDIA_PLAYER_OPTION_TLS_LOG = 480;
    public static final int MEDIA_PLAYER_OPTION_TOKEN_URL_TEMPLATE = 207;
    public static final int MEDIA_PLAYER_OPTION_TO_DECODE_FIRST_AUDIO_FRAME_TIME = 1953;
    public static final int MEDIA_PLAYER_OPTION_TO_DECODE_FIRST_VIDEO_FRAME_TIME = 1952;
    public static final int MEDIA_PLAYER_OPTION_TRANS_OPEN_START_TIME = 584;
    public static final int MEDIA_PLAYER_OPTION_TRAN_CONNECT_TIME = 69;
    public static final int MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_ENABLE = 942;
    public static final int MEDIA_PLAYER_OPTION_TTMP_DNS_PARSE_TIMEOUT = 943;
    public static final int MEDIA_PLAYER_OPTION_TTQUIC_SDK_VERSION = 946;
    public static final int MEDIA_PLAYER_OPTION_TT_HLS_DRM = 250;
    public static final int MEDIA_PLAYER_OPTION_TT_HLS_DRM_TOKEN = 249;
    public static final int MEDIA_PLAYER_OPTION_UDP_REAL_SPEED = 983;
    public static final int MEDIA_PLAYER_OPTION_UNBIND_AUDIO_PROCESSOR_STATUS = 1093;
    public static final int MEDIA_PLAYER_OPTION_UPDATE_TIMESTAMP_MODE = 288;
    public static final int MEDIA_PLAYER_OPTION_USER_EXIT_TIME = 1340;
    public static final int MEDIA_PLAYER_OPTION_USE_CODEC_POOL = 400;
    public static final int MEDIA_PLAYER_OPTION_USE_MEDIA_CODEC_AUDIO = 97;

    @Deprecated
    public static final int MEDIA_PLAYER_OPTION_USE_TARGET_WINDOW = 42001;
    public static final int MEDIA_PLAYER_OPTION_VALID_HTTP_CONTENT = 29;
    public static final int MEDIA_PLAYER_OPTION_VC2_THREAD_NUM = 4010;
    public static final int MEDIA_PLAYER_OPTION_VC2_WPP_MODE = 4008;
    public static final int MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN = 280;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_BUFFER_LENGTH = 72;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CACHED_NUM = 1059;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CHECK_INFO = 202;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CODEC = 478;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CODEC_ID = 141;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CODEC_PROFILE = 403;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_CURRENT_DOWNLOAD_INDEX = 520;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_BUFLEN = 602;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_ERROR = 221;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_OPENED_TIME = 630;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_OUTFPS_LIST = 824;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500 = 387;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500 = 386;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_STACK = 160;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME = 629;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DEMUXER_STALL_500 = 385;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_DOWNLOAD_BYTES = 636;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_FIRST_LIVE_FRAME_RENDER_TIME = 699;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_FIRST_LIVE_PACKET_READ_TIME = 697;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_FIRST_PACKET_TIME = 266;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HIT_CDN_CACHE = 724;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HTTPX_CACHED = 954;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME = 272;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HTTP_RES_FINSIH_TIME = 274;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_HW_ERR_REASON = 540;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_ID = 205;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_LINE_STRIDE = 569;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_LIVE_CONNECT_TIME = 695;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_LIVE_OPEN_TIME = 693;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE = 826;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_PARAM_SEND_OUTLET_TIME = 458;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RANGE_SIZE = 243;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME = 259;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RENDER_ERROR = 245;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_COUNT = 849;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_DIFF_LIST = 848;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_RENDER_STALL_THRESHOLD = 322;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_SAVED_HOST_TIME = 264;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_SECOND_FRAME = 1049;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_STREAM_DURATION = 524;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_SWITCH_CACHE_TIME = 270;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_TIME_FOR_CDN = 728;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_TIME_TO_SOURCE = 726;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_TOTAL_CACHED_LEN = 638;
    public static final int MEDIA_PLAYER_OPTION_VIDEO_TRAN_CONNECT_TIME = 265;
    public static final int MEDIA_PLAYER_OPTION_VIEW_HEIGHT = 464;
    public static final int MEDIA_PLAYER_OPTION_VIEW_WIDTH = 463;
    public static final int MEDIA_PLAYER_OPTION_VOICE_STREAM_TYPE = 255;
    public static final int MEDIA_PLAYER_OPTION_VR_SET_FOV_PREDICTOR_HANDLE = 3008;
    public static final int MEDIA_PLAYER_OPTION_WAITING_CODEC = 1048;
    public static final int MEDIA_PLAYER_OPTION_WAIT_TIME_AFTER_FIRST_FRAME = 314;
    public static final int MEDIA_PLAYER_PANO_RENDER_VALUE = 1;
    public static final int MEDIA_PLAYER_PCMS16LE_CODEC_ID = 4;
    public static final int MEDIA_PLAYER_PLAN_RENDER_VALUE = 0;
    public static final int MEDIA_PLAYER_SAVE_FILE_MODE_TYPE = 58;
    public static final int MEDIA_PLAYER_SETTING_CODEC_ERROR = -499998;
    public static final int MEDIA_PLAYER_SETTING_IS_NULL_ERROR = -499999;
    public static final int MEDIA_PLAYER_SETTING_OUTER_ERROR = -499995;
    public static final int MEDIA_PLAYER_SETTING_OUTLET_ERROR = -499994;
    public static final int MEDIA_PLAYER_SETTING_URI_IS_ERROR = -499987;
    public static final int MEDIA_PLAYER_SETTING_URI_IS_NULL_ERROR = -499988;
    public static final int MEDIA_PLAYER_SLES_VOICE_VALUE = 0;
    public static final int MEDIA_PLAYER_START_DECODER_ERROR = -499997;
    public static final int MEDIA_PLAYER_START_OUTLET_ERROR = -499990;
    public static final int MEDIA_PLAYER_START_OUTPUTER_ERROR = -499991;
    public static final int[] MEDIA_PLAYER_SUPPORT_SAMPLERATES = TTPlayerKeys.SupportSampleRates;
    public static final int MEDIA_PLAYER_TCP_FAILED_TO_RESOLVE_HOSTNAME_ERROR = -499799;
    public static final int MEDIA_PLAYER_TCP_READ_NETWORK_TIMEOUT_ERROR = -499793;
    public static final int MEDIA_PLAYER_TCP_RECEIVE_DATA_FAILED_ERROR = -499794;
    public static final int MEDIA_PLAYER_TCP_SEND_DATA_FAILED_ERROR = -499795;
    public static final int MEDIA_PLAYER_TCP_WRITE_NETWORK_TIMEOUT_ERROR = -499792;
    public static final int MEDIA_PLAYER_TEST_SURFACE_CHANGED_VALUE = 2;
    public static final int MEDIA_PLAYER_TEST_VIEW_CHANGED_VALUE = 1;
    public static final int MEDIA_PLAYER_URL_IS_NOT_MP4_ERROR = -499986;
    public static final int MEDIA_PLAYER_VIDEO_DECODER_WRITE_ERROR = -499977;
    public static final int MEDIA_PLAYER_VIDEO_TRACK_ENABLE_OPTION = 62;
    public static final int MEDIA_PLAYER_VR_RENDER_VALUE = 2;
    public static final int MEDIA_QUICU_FRAME_DROP = 59;
    public static final int MEDIA_QUIC_ALOG_REPORT = 63;
    public static final int MEDIA_STARTTIME_NO_VIDEO_FRAME = -268435401;
    public static final int MEIDA_PLAYER_OPTION_IGNORE_DIRECTLY_BUFFERING = 566;
    public static final int MEIDA_PLAYER_OPTION_NATIVE_RENDER_ROTATION_ADAPT = 565;
    public static final int MouseDown = 1;
    public static final int MouseMove = 2;
    public static final int MouseUp = 3;
    public static final int NEAREST_SCALE_VALUE = 2;
    public static final int NHTTP_LOADER = 1;
    public static final int NOT_SAVE_FILE_MODE = 0;
    public static final int OPEN_FILE_MODE = 1;
    public static final int PANO_AUTO_ROTATION_DISABLE = 0;
    public static final int PANO_AUTO_ROTATION_ENABLE = 1;
    public static final int PANO_VIDEO_TYPE_BEAC_3D_TOP_AND_BOTTOM_180 = 2;
    public static final int PANO_VIDEO_TYPE_BEAC_3D_TOP_AND_BOTTOM_360 = 1;
    public static final int PANO_VIDEO_TYPE_ERP_2D_360 = 0;
    public static final int PANO_VIDEO_TYPE_ERP_3D_TOP_AND_BOTTOM_180 = 3;
    public static final int PanoIsGestureControl = 1;
    public static final int PanoIsSensorControl = 0;
    public static final int REAL_MASTER = 1;
    public static final int REPLACE_FILE_MODE = 0;
    public static final int SAVE_FILE_MODE = 1;
    public static final int TestANRCrashValue = 0;
    public static final int TestNativeCrashValue = 2;
    public static final int TestSimpleCrashValue = 1;
    public static final int VIDEO_MASTER = 2;
    public static final int VIEW_ROTATION_LEFT = 1;
    public static final int VIEW_ROTATION_NONE = 0;
    public static final int VIEW_ROTATION_OPTION = 23;
    public static final int VIEW_ROTATION_RIGHT = 2;

    public interface OnBufferingUpdateListener {
        void onBufferingUpdate(MediaPlayer mediaPlayer, int i);
    }

    public interface OnCompletionListener {
        void onCompletion(MediaPlayer mediaPlayer);
    }

    public interface OnErrorListener {
        boolean onError(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface OnExternInfoListener {
        void onExternInfo(MediaPlayer mediaPlayer, int i, String str);

        default void onExternInfo2(MediaPlayer mediaPlayer, int i, int i2, String str) {
        }
    }

    public interface OnInfoListener {
        boolean onInfo(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface OnLogListener {
        void onLogInfo(MediaPlayer mediaPlayer, String str);
    }

    public interface OnPreparedListener {
        void onPrepared(MediaPlayer mediaPlayer);
    }

    public interface OnScreenshotListener {
        void onTakeScreenShotCompletion(Bitmap bitmap);
    }

    public interface OnSeekCompleteListener {
        void onSeekComplete(MediaPlayer mediaPlayer);
    }

    public interface OnVideoSizeChangedListener {
        void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    public interface onSARChangedListener {
        void onSARChanged(MediaPlayer mediaPlayer, int i, int i2);
    }

    void deselectTrack(int i);

    int getCurrentPosition();

    String getDataSource();

    int getDuration();

    float getFloatOption(int i, float f);

    int getIntOption(int i, int i2);

    long getLongOption(int i, long j);

    int getPlayerType();

    int getSelectedTrack(int i);

    String getStringOption(int i);

    TrackInfo[] getTrackInfo();

    int getVideoHeight();

    int getVideoType();

    int getVideoWidth();

    boolean isLooping();

    boolean isMute();

    boolean isOSPlayer();

    boolean isPlaying();

    void mouseEvent(int i, int i2, int i3);

    void pause();

    void prepare();

    void prepareAsync();

    @Deprecated
    void prevClose();

    void release();

    void releaseAsync();

    void reset();

    void rotateCamera(float f, float f2);

    void seekTo(int i);

    void selectTrack(int i);

    void setCacheFile(String str, int i);

    void setDataSource(Context context, Uri uri) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    void setDataSource(IMediaDataSource iMediaDataSource) throws IOException, IllegalArgumentException;

    void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException;

    void setDataSource(String str) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException;

    void setDisplay(SurfaceHolder surfaceHolder);

    int setFloatOption(int i, float f);

    default void setFloatOptionArray(int[] iArr, float[] fArr) {
    }

    void setIntOption(int i, int i2);

    default void setIntOptionArray(int[] iArr, int[] iArr2) {
    }

    void setIsMute(boolean z);

    long setLongOption(int i, long j);

    default void setLongOptionArray(int[] iArr, long[] jArr) {
    }

    void setLooping(boolean z);

    void setMediaTransport(MediaTransport mediaTransport);

    void setOnBufferingUpdateListener(OnBufferingUpdateListener onBufferingUpdateListener);

    void setOnCompletionListener(OnCompletionListener onCompletionListener);

    void setOnErrorListener(OnErrorListener onErrorListener);

    void setOnExternInfoListener(OnExternInfoListener onExternInfoListener);

    default void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
    }

    void setOnInfoListener(OnInfoListener onInfoListener);

    void setOnLogListener(OnLogListener onLogListener);

    void setOnPreparedListener(OnPreparedListener onPreparedListener);

    void setOnSARChangedListener(onSARChangedListener onsarchangedlistener);

    void setOnSeekCompleteListener(OnSeekCompleteListener onSeekCompleteListener);

    void setOnVideoSizeChangedListener(OnVideoSizeChangedListener onVideoSizeChangedListener);

    void setPanoVideoControlModel(int i);

    void setPlaybackParams(PlaybackParams playbackParams);

    void setScreenOnWhilePlaying(boolean z);

    void setStringOption(int i, String str);

    default void setStringOptionArray(int[] iArr, String[] strArr) {
    }

    void setSurface(Surface surface);

    default void setSurfaceTimeOut(Surface surface, int i) {
    }

    default void setTraitObject(int i, TraitObject traitObject) {
    }

    void setVolume(float f, float f2);

    void setWakeMode(Context context, int i);

    void start();

    void stop();

    void switchStream(int i, int i2);

    void takeScreenshot(OnScreenshotListener onScreenshotListener);

    public static class TrackInfo {
        public static final int MEDIA_TRACK_TYPE_AUDIO = 2;
        public static final int MEDIA_TRACK_TYPE_METADATA = 5;
        public static final int MEDIA_TRACK_TYPE_SUBTITLE = 4;
        public static final int MEDIA_TRACK_TYPE_TIMEDTEXT = 3;
        public static final int MEDIA_TRACK_TYPE_UNKNOWN = 0;
        public static final int MEDIA_TRACK_TYPE_VIDEO = 1;
        private MediaFormat mFormat;
        private String mLanguage;
        private int mStreamType;

        public TrackInfo(int i, MediaFormat mediaFormat) {
            this.mFormat = mediaFormat;
            this.mStreamType = 0;
            if (i == 1) {
                this.mStreamType = 2;
            } else if (i == 0) {
                this.mStreamType = 1;
            } else if (i == 2) {
                this.mStreamType = 4;
            }
            this.mLanguage = "zh-cn";
        }

        public TrackInfo(MediaPlayer.TrackInfo trackInfo) {
            this.mStreamType = trackInfo.getTrackType();
            this.mLanguage = trackInfo.getLanguage();
            int i = this.mStreamType;
            if (i == 2) {
                this.mFormat = MediaFormat.createAudioFormat(trackInfo.getFormat());
            } else if (i == 1) {
                this.mFormat = MediaFormat.createVideoFormat(trackInfo.getFormat());
            } else if (i == 4) {
                this.mFormat = MediaFormat.createSubtitleFormat(trackInfo.getFormat());
            }
        }

        public int getTrackType() {
            return this.mStreamType;
        }

        public MediaFormat getFormat() {
            return this.mFormat;
        }

        public String getLanguage() {
            return this.mLanguage;
        }
    }
}
