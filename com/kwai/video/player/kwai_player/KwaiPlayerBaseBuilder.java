package com.kwai.video.player.kwai_player;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.hodor.util.Timber;
import com.kwai.video.player.kwai_player.KwaiPlayerBaseBuilder;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class KwaiPlayerBaseBuilder<T extends KwaiPlayerBaseBuilder<T>> {
    public static final String HEVC_DECODER_NAME_KS265 = "libks265dec";
    public static final String HEVC_DECODER_NAME_KVC = "libkvcdec";
    public static final String HEVC_DECODER_NAME_QY265 = "libqy265dec";
    private Context mContext;
    private ProductContext mProductContext;
    private boolean mUseOpenSLES = false;
    private Integer mOverlayFormat = null;
    private String mOverlayFormatString = null;
    private boolean mUseMediaCodecDummySurface = false;
    private int mUseHardwareDcoderFlag = 0;
    private boolean mUseLibfdkForAac = false;
    private String mHevcDcoderName = HEVC_DECODER_NAME_QY265;
    private boolean mStartOnPrepared = true;
    private boolean mAsyncStreamComponentOpen = false;
    private boolean mEnableVodAdaptive = false;
    protected boolean mUseNatvieCache = false;
    protected boolean mEnableSegmentCache = false;
    private int mVideoPictureQueueSize = 3;
    private boolean mEnableSoftwareDecodeLimit = false;
    private int mSoftwareDecodeWidthLimit = -1;
    private int mSoftwareDecodeHeightLimit = -1;
    private int mSoftwareDecodeFpsLimit = -1;
    private int mMediaCodecMaxNum = -1;
    private int mMediaCodecAvcHeightLimit = -1;
    private int mMediaCodecHevcHeightLimit = -1;
    private int mMediaCodecAvcWidthLimit = -1;
    private int mMediaCodecHevcWidthLimit = -1;
    private boolean mUseMediaCodecByteBuffer = false;
    private int mMaxBufferSizeMb = -1;
    private int mMaxBufferTimeMs = 120000;
    private int mMaxBufferTimeBspMs = -1;
    private int mFFmpegConnectionTimeoutSec = 5;
    private int mFFmpegDataReadTimeoutSec = 30;
    private int mFFmpegSocketSendBufferSize = -1;
    private int mFFmpegSocketRecvBufferSize = -1;
    private int mFadeinEndTimeMs = 0;
    private String mKs265DecExtraParams = null;
    private boolean mEnableModifyBlock = false;
    private boolean mEnableAvSyncOpt = false;
    private boolean mIsVR = false;
    private int mInteractiveMode = 0;
    private int mStereoType = 0;
    private int mAudioChannelMode = 0;

    protected abstract T self();

    public KwaiPlayerBaseBuilder(Context context) {
        this.mContext = context.getApplicationContext();
    }

    protected void applyTo(KwaiMediaPlayer kwaiMediaPlayer) {
        Timber.d("applyTo", new Object[0]);
        Context context = this.mContext;
        if (context != null) {
            kwaiMediaPlayer._setQy265Context(context);
            kwaiMediaPlayer.setContext(this.mContext);
        }
        kwaiMediaPlayer.setupAspectNativeCache(this.mUseNatvieCache);
        kwaiMediaPlayer.setEnableSegmentCache(this.mEnableSegmentCache);
        kwaiMediaPlayer.setOption(4, "opensles", this.mUseOpenSLES ? 1L : 0L);
        kwaiMediaPlayer.setOption(4, "start-on-prepared", this.mStartOnPrepared ? 1L : 0L);
        kwaiMediaPlayer.setOption(4, "async-stream-component-open", this.mAsyncStreamComponentOpen ? 1L : 0L);
        int i = this.mVideoPictureQueueSize;
        if (i > 3 && i <= 16) {
            kwaiMediaPlayer.setOption(4, "video-pictq-size", i);
        }
        int i2 = this.mMediaCodecMaxNum;
        if (i2 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-max-cnt", i2);
        }
        int i3 = this.mMediaCodecAvcHeightLimit;
        if (i3 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-avc-height-limit", i3);
        }
        int i4 = this.mMediaCodecHevcHeightLimit;
        if (i4 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-hevc-height-limit", i4);
        }
        int i5 = this.mMediaCodecAvcWidthLimit;
        if (i5 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-avc-width-limit", i5);
        }
        int i6 = this.mMediaCodecHevcWidthLimit;
        if (i6 > 0) {
            kwaiMediaPlayer.setOption(4, "mediacodec-hevc-width-limit", i6);
        }
        if (this.mUseMediaCodecByteBuffer) {
            kwaiMediaPlayer.setOption(4, "use-mediacodec-bytebuffer", 1L);
        }
        if (this.mEnableSoftwareDecodeLimit) {
            kwaiMediaPlayer.setOption(4, "enable-software-decode-limitation", 1L);
            int i7 = this.mSoftwareDecodeWidthLimit;
            if (i7 > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-width-limit", i7);
            }
            int i8 = this.mSoftwareDecodeHeightLimit;
            if (i8 > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-height-limit", i8);
            }
            int i9 = this.mSoftwareDecodeFpsLimit;
            if (i9 > 0) {
                kwaiMediaPlayer.setOption(4, "software-decode-fps-limit", i9);
            }
        }
        if (this.mOverlayFormat != null) {
            kwaiMediaPlayer.setOption(4, "overlay-format", r5.intValue());
        } else {
            String str = this.mOverlayFormatString;
            if (str != null) {
                kwaiMediaPlayer.setOption(4, "overlay-format", str);
            }
        }
        ProductContext productContext = this.mProductContext;
        if (productContext != null && !productContext.productContextJson.isEmpty()) {
            kwaiMediaPlayer.setOption(1, "product-context", this.mProductContext.productContextJson);
        }
        if (this.mUseLibfdkForAac) {
            kwaiMediaPlayer.setOption(4, "aac-libfdk", 1L);
        }
        int i10 = this.mFadeinEndTimeMs;
        if (i10 > 0) {
            kwaiMediaPlayer.setOption(4, "fade-in-end-time-ms", i10);
        }
        boolean z = this.mEnableModifyBlock;
        if (z) {
            kwaiMediaPlayer.setOption(4, "enable-modify-block", z ? 1L : 0L);
        }
        boolean z2 = this.mEnableAvSyncOpt;
        if (z2) {
            kwaiMediaPlayer.setOption(4, "enable-av-sync-opt", z2 ? 1L : 0L);
        }
        kwaiMediaPlayer.setHevcCodecName(this.mHevcDcoderName);
        kwaiMediaPlayer.setCodecFlag(this.mUseHardwareDcoderFlag);
        if (this.mUseMediaCodecDummySurface) {
            kwaiMediaPlayer.setOption(4, "use-mediacodec-dummy-surface", 1L);
        }
        if (!TextUtils.isEmpty(this.mKs265DecExtraParams)) {
            kwaiMediaPlayer.setOption(2, "ks265_params", this.mKs265DecExtraParams);
        }
        int i11 = this.mMaxBufferSizeMb;
        if (i11 > 0) {
            kwaiMediaPlayer._setBufferSize(i11);
        }
        kwaiMediaPlayer.setOption(4, "max-buffer-dur-ms", this.mMaxBufferTimeMs);
        int i12 = this.mMaxBufferTimeBspMs;
        if (i12 > 0) {
            kwaiMediaPlayer.setOption(4, "dcc.max-buffer-dur-bsp-ms", i12);
        }
        kwaiMediaPlayer._setConnectionTimeout(this.mFFmpegConnectionTimeoutSec);
        kwaiMediaPlayer._setTimeout(this.mFFmpegDataReadTimeoutSec);
        int i13 = this.mFFmpegSocketRecvBufferSize;
        if (i13 > 0) {
            kwaiMediaPlayer.setOption(1, "recv_buffer_size", i13);
        }
        int i14 = this.mFFmpegSocketSendBufferSize;
        if (i14 > 0) {
            kwaiMediaPlayer.setOption(1, "send_buffer_size", i14);
        }
        if (this.mIsVR) {
            kwaiMediaPlayer.setInteractiveMode(this.mInteractiveMode);
            kwaiMediaPlayer.setStereoType(this.mStereoType);
            kwaiMediaPlayer.setAudioChannelMode(this.mAudioChannelMode);
            kwaiMediaPlayer.setIsVR(this.mIsVR);
        }
    }

    public T setUseOpenSLES(boolean z) {
        this.mUseOpenSLES = z;
        return (T) self();
    }

    public T setProductContext(ProductContext productContext) {
        this.mProductContext = productContext;
        return (T) self();
    }

    public T setOverlayFormat(int i) {
        this.mOverlayFormat = Integer.valueOf(i);
        return (T) self();
    }

    public T setOverlayFormatString(String str) {
        this.mOverlayFormatString = str;
        return (T) self();
    }

    public T setUseMediaCodecDummySurface(boolean z) {
        this.mUseMediaCodecDummySurface = z;
        return (T) self();
    }

    public T setUseHardwareDcoderFlag(int i) {
        this.mUseHardwareDcoderFlag = i;
        return (T) self();
    }

    public T setLibfdkForAac(boolean z) {
        this.mUseLibfdkForAac = z;
        return (T) self();
    }

    public void setHevcDcoderName(String str) {
        this.mHevcDcoderName = str;
    }

    public T setStartOnPrepared(boolean z) {
        this.mStartOnPrepared = z;
        return (T) self();
    }

    public T setAsyncStreamOpen(boolean z) {
        this.mAsyncStreamComponentOpen = z;
        return (T) self();
    }

    public T setEnableVodAdaptive(boolean z) {
        this.mEnableVodAdaptive = z;
        return (T) self();
    }

    public T setUseNatvieCache(boolean z) {
        this.mUseNatvieCache = z;
        return (T) self();
    }

    public T setEnableSegmentCache(boolean z) {
        this.mEnableSegmentCache = z;
        return (T) self();
    }

    public T setVideoPictureQueueSize(int i) {
        this.mVideoPictureQueueSize = i;
        return (T) self();
    }

    public T setEnableSoftwareDecodeLimit(boolean z) {
        this.mEnableSoftwareDecodeLimit = z;
        return (T) self();
    }

    public T setSoftwareDecodeLimit(int i, int i2, int i3) {
        this.mSoftwareDecodeWidthLimit = i;
        this.mSoftwareDecodeHeightLimit = i2;
        this.mSoftwareDecodeFpsLimit = i3;
        return (T) self();
    }

    public T setMediaCodecMaxNum(int i) {
        this.mMediaCodecMaxNum = i;
        return (T) self();
    }

    public T setMediaCodecAvcHeightLimit(int i) {
        this.mMediaCodecAvcHeightLimit = i;
        return (T) self();
    }

    public T setMediaCodecHevcHeightLimit(int i) {
        this.mMediaCodecHevcHeightLimit = i;
        return (T) self();
    }

    public T setMediaCodecAvcWidthLimit(int i) {
        this.mMediaCodecAvcWidthLimit = i;
        return (T) self();
    }

    public T setMediaCodecHevcWidthLimit(int i) {
        this.mMediaCodecHevcWidthLimit = i;
        return (T) self();
    }

    public T setUseMediaCodecByteBuffer(boolean z) {
        this.mUseMediaCodecByteBuffer = z;
        return (T) self();
    }

    public T setMaxBufferSizeMb(int i) {
        this.mMaxBufferSizeMb = i;
        return (T) self();
    }

    public T setMaxBufferTimeMs(int i) {
        this.mMaxBufferTimeMs = i;
        return (T) self();
    }

    public T setMaxBufferTimeBspMs(int i) {
        this.mMaxBufferTimeBspMs = i;
        return (T) self();
    }

    public T setFFmpegConnectionTimeout(int i) {
        this.mFFmpegConnectionTimeoutSec = i;
        return (T) self();
    }

    public T setFFmpegDataReadTimeout(int i) {
        this.mFFmpegDataReadTimeoutSec = i;
        return (T) self();
    }

    public void setFFmpegSocketSendBufferSize(int i) {
        this.mFFmpegSocketSendBufferSize = i;
    }

    public void setFFmpegSocketRecvBufferSize(int i) {
        this.mFFmpegSocketRecvBufferSize = i;
    }

    public T setFadeinEndTimeMs(int i) {
        this.mFadeinEndTimeMs = i;
        return (T) self();
    }

    public T setKs265DecExtraParams(String str) {
        this.mKs265DecExtraParams = str;
        return (T) self();
    }

    public T setEnableModifyBlock(boolean z) {
        this.mEnableModifyBlock = z;
        return (T) self();
    }

    public T enableAvSyncOpt(boolean z) {
        this.mEnableAvSyncOpt = z;
        return (T) self();
    }

    public T setIsVR(boolean z) {
        this.mIsVR = z;
        return (T) self();
    }

    public T setInteractiveMode(int i) {
        this.mInteractiveMode = i;
        return (T) self();
    }

    public T setStereoType(int i) {
        this.mStereoType = i;
        return (T) self();
    }

    public T setAudioChannelMode(int i) {
        this.mAudioChannelMode = i;
        return (T) self();
    }
}
