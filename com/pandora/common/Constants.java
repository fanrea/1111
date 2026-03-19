package com.pandora.common;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Constants {
    public static final String KEY_AUDIO_DECODER_TYPE = "audio_encoder_type";
    public static final String KEY_AUDIO_ENCODER_TYPE = "audio_encoder_type";
    public static final String KEY_MODULE_ID = "module_id";
    public static final String KEY_VIDEO_CAPTURE_HEIGHT = "video_capture_height";
    public static final String KEY_VIDEO_CAPTURE_WIDTH = "video_capture_width";
    public static final String KEY_VIDEO_DECODER_TYPE = "video_decoder_type";
    public static final String KEY_VIDEO_ENCODER_HEIGHT = "video_encoder_height";
    public static final String KEY_VIDEO_ENCODER_TYPE = "video_encoder_type";
    public static final String KEY_VIDEO_ENCODER_WIDTH = "video_encoder_width";

    public static class AppRegion {
        public static final String AMERICA = "amercia";
        public static final String CHINA = "china";
        public static final String MYA = "mya";
        public static final String SINGAPORE = "singapore";
    }

    public static class CodecType {
        public static final String AUDIO_AAC = "audio/aac";
        public static final String VIDEO_H264 = "video/avc";
        public static final String VIDEO_H265 = "video/hevc";
    }

    public static class ModuleID {
        public static final int MODULE_EDITOR = 4;
        public static final int MODULE_LIVE_PULL = 3;
        public static final int MODULE_LIVE_PUSH = 2;
        public static final int MODULE_UPLOAD = 1;
        public static final int MODULE_VOD = 0;
    }

    public static class SDKRegion {
        public static final String CN = "CN";
        public static final String GLOBAL = "GLOBAL";
    }

    public class APPLog {
        public static final String APP_CHANNEL = "appchannel";
        public static final String APP_CLASS_NAME = "com.bytedance.applog.AppLog";
        public static final String APP_ID = "appid";
        public static final String APP_NAME = "appname";
        public static final String APP_REGION = "region";
        public static final String APP_REGION_AMERICA = "amercia";
        public static final String APP_REGION_CHINA = "china";
        public static final String APP_REGION_SINGAPORE = "singapore";
        public static final String APP_VERSION = "appversion";
        public static final String DEFAULT_VOD_TOP_HOST = "vod.bytedanceapi.com";
        public static final String DEVICE_ID = "did";

        public APPLog() {
        }
    }
}
