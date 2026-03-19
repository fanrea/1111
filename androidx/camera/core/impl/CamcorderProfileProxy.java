package androidx.camera.core.impl;

import android.media.CamcorderProfile;
import com.pandora.common.Constants;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class CamcorderProfileProxy {
    public static int CODEC_PROFILE_NONE = -1;

    public abstract int getAudioBitRate();

    public abstract int getAudioChannels();

    public abstract int getAudioCodec();

    public abstract int getAudioSampleRate();

    public abstract int getDuration();

    public abstract int getFileFormat();

    public abstract int getQuality();

    public abstract int getVideoBitRate();

    public abstract int getVideoCodec();

    public abstract int getVideoFrameHeight();

    public abstract int getVideoFrameRate();

    public abstract int getVideoFrameWidth();

    public static CamcorderProfileProxy create(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        return new AutoValue_CamcorderProfileProxy(i, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12);
    }

    public static CamcorderProfileProxy fromCamcorderProfile(CamcorderProfile camcorderProfile) {
        return new AutoValue_CamcorderProfileProxy(camcorderProfile.duration, camcorderProfile.quality, camcorderProfile.fileFormat, camcorderProfile.videoCodec, camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, camcorderProfile.audioCodec, camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels);
    }

    public String getVideoCodecMimeType() {
        int videoCodec = getVideoCodec();
        if (videoCodec == 1) {
            return "video/3gpp";
        }
        if (videoCodec == 2) {
            return Constants.CodecType.VIDEO_H264;
        }
        if (videoCodec == 3) {
            return "video/mp4v-es";
        }
        if (videoCodec == 4) {
            return "video/x-vnd.on2.vp8";
        }
        if (videoCodec != 5) {
            return null;
        }
        return Constants.CodecType.VIDEO_H265;
    }

    public String getAudioCodecMimeType() {
        switch (getAudioCodec()) {
            case 1:
                return "audio/3gpp";
            case 2:
                return "audio/amr-wb";
            case 3:
            case 4:
            case 5:
                return "audio/mp4a-latm";
            case 6:
                return "audio/vorbis";
            case 7:
                return "audio/opus";
            default:
                return null;
        }
    }

    public int getRequiredAudioProfile() {
        int audioCodec = getAudioCodec();
        if (audioCodec == 3) {
            return 2;
        }
        if (audioCodec == 4) {
            return 5;
        }
        if (audioCodec != 5) {
            return CODEC_PROFILE_NONE;
        }
        return 39;
    }
}
