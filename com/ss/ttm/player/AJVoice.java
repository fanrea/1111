package com.ss.ttm.player;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.Build;
import android.os.ConditionVariable;
import android.os.SystemClock;
import com.component.feed.a;
import com.kuaishou.socket.nano.SocketMessages;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.C00oOOo;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.Util;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AJVoice implements AudioTrack.OnPlaybackPositionUpdateListener {
    private static final int DISCONTINGUNITY_MS = 200;
    private static final int ERROR_FORMAT_ILLEGAL = -12;
    private static final int ERROR_NULL_BUFFER = -10;
    private static final int ERROR_SIZE_ILLEGAL = -11;
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final int MAX_LATENCY_MS = 5000;
    private static final long MAX_PCM_BUFFER_DURATION_US = 750000;
    private static final int MIN_LATENCY_CHECK_MS = 500;
    private static final long MIN_PCM_BUFFER_DURATION_US = 250000;
    private static final int MS_UNIT = 1000;
    private static final int PCM_BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final long RELEASE_WORKAROUND_TIME_MS = 80;
    private static final int SDK_INT = Build.VERSION.SDK_INT;
    private static final int START_NO_SET = -1;
    private static final int S_FAIL = -1;
    private static final int S_OK = 0;
    private static final String TAG = "JAJVoice";
    private static final long TIME_UNSET = -9223372036854775807L;
    private static final int kNoSettingVolume = -1;
    private static String mDeviceName = null;
    private static boolean mNeedReleaseWorkAround = false;
    private AudioTrackPositionTracker audioTrackPositionTracker;
    private byte[] mMinBytes;
    private int mOutputPcmFrameSize;
    private long mRawPlaybackHeadWrapCount;
    private ConditionVariable mReleasingConditionVariable;
    private int mStartMediaTimeMs;
    private AudioTrack mAudioTrack = null;
    private TTPlayer mPlayer = null;
    private int mBlockSize = 2048;
    private int mSampleRate = 44100;
    private int mChannels = 2;
    private int mSampleBytes = 2;
    private int mSampleFormat = 0;
    private int mFrameSamples = 0;
    private AudioManager mAudioManager = null;
    private int mChannelsLayout = 0;
    private int mAudioFormat = 2;
    private float mLeftVolume = -1.0f;
    private int mMaxVolume = 0;
    private volatile boolean mStoped = true;
    private int mSerial = -1;
    private Method getLatencyMethod = null;
    private int mTrackBufferSize = 0;
    private int mLatencyMs = 0;
    private int mBufferSizeMs = 0;
    private long mLastGetLatencyMs = 0;
    private long mWrittenPcmBytes = 0;
    private long lastRawPlaybackHeadPosition = 0;
    private long forceResetWorkaroundTimeMs = -9223372036854775807L;
    private long mStartTime = 0;
    private int mStreamType = 3;
    private int mEnableAudioTrackSmoothClock = 0;
    private int mSessionId = -1;
    private int mContentType = -1;
    private ByteBuffer mPCMFrameBuffer = null;
    private boolean mUseDirectBuffer = false;
    private int mCalibrationType = 0;
    private AudioTrackPool mAudioTrackPool = null;
    private boolean mEnableAudioTrackPool = false;
    private boolean mForceReleaseAudioTrackByPool = false;
    private boolean mBufferSizeError = false;
    private long mNativeObject = 0;

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onMarkerReached(AudioTrack audioTrack) {
    }

    @Override // android.media.AudioTrack.OnPlaybackPositionUpdateListener
    public void onPeriodicNotification(AudioTrack audioTrack) {
    }

    public AJVoice() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AVLogger.InfoTrackLife(TAG, this, "JAJVoice#^");
        this.mStartMediaTimeMs = -1;
        if (mDeviceName == null) {
            String str = Build.DEVICE;
            mDeviceName = str;
            if (str.equals("OnePlus6T")) {
                AVLogger.Debug(TAG, this, "device need workaround");
                mNeedReleaseWorkAround = true;
            }
        }
    }

    public int open(long j, TTPlayer tTPlayer) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.mEnableAudioTrackPool) {
            this.mAudioTrackPool = AudioTrackPool.getInstance();
        }
        this.mNativeObject = j;
        AVLogger.Debug(TAG, this, String.format(Locale.US, "native object:%d", Long.valueOf(this.mNativeObject)));
        this.mPlayer = tTPlayer;
        int iReconfigure = reconfigure();
        if (iReconfigure == 0) {
            float f = this.mLeftVolume;
            if (f != -1.0f) {
                setVolume(f, f);
            }
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", null);
                } catch (NoSuchMethodException unused) {
                }
            }
        }
        return iReconfigure;
    }

    public void releaseTrack(AudioTrack audioTrack) throws IllegalAccessException, InterruptedException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (audioTrack == null) {
            return;
        }
        try {
            if (mNeedReleaseWorkAround) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.mStartTime;
                if (jElapsedRealtime <= RELEASE_WORKAROUND_TIME_MS) {
                    Thread.sleep(RELEASE_WORKAROUND_TIME_MS - jElapsedRealtime);
                }
            }
        } catch (Exception unused) {
        }
        try {
            audioTrack.release();
        } catch (Exception e) {
            AVLogger.Warn(TAG, this, "release in invalid state = " + e);
        }
    }

    public void close() throws IllegalAccessException, InterruptedException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.mEnableAudioTrackPool) {
            this.mAudioTrackPool.pushAudioTrackBack(this.mAudioTrack, this.mForceReleaseAudioTrackByPool, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, this.mSessionId, this.mContentType);
            this.mAudioTrack = null;
        }
        final AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            this.mAudioTrack = null;
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJVoice.1
                    @Override // java.lang.Runnable
                    public void run() throws IllegalAccessException, InterruptedException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                        AVLogger.Debug(AJVoice.TAG, this, "start release task");
                        AJVoice.this.releaseTrack(audioTrack);
                    }
                });
            } catch (Throwable th) {
                AVLogger.Warn(TAG, this, "create close thread fail = " + th);
                releaseTrack(audioTrack);
            }
        }
        AVLogger.InfoTrackLife(TAG, this, "JAJVoice#$");
    }

    public int start() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AVLogger.Debug(TAG, this, "start--->");
        if (this.mAudioTrack == null) {
            AVLogger.Error(TAG, this, "audiotrack start before created");
            return -2;
        }
        this.mStoped = false;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i, getPcmFrameSize(i, this.mChannels), this.mTrackBufferSize);
            }
            this.mAudioTrack.play();
            this.mSerial = -1;
            AVLogger.Debug(TAG, this, "end---->");
            if (mNeedReleaseWorkAround) {
                this.mStartTime = SystemClock.elapsedRealtime();
            }
            return 0;
        } catch (Throwable th) {
            AVLogger.Error(TAG, this, "audioTrack start failed = " + th);
            return -3;
        }
    }

    public void pause() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            this.mAudioTrack.pause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void resume() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                AudioTrack audioTrack = this.mAudioTrack;
                int i = this.mAudioFormat;
                audioTrackPositionTracker.setAudioTrack(audioTrack, i, getPcmFrameSize(i, this.mChannels), this.mTrackBufferSize);
                this.audioTrackPositionTracker.start();
            }
            this.mAudioTrack.play();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void flush() {
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.reset();
            }
            this.mStartMediaTimeMs = -1;
            if (this.mCalibrationType >= 1) {
                this.lastRawPlaybackHeadPosition = 0L;
                this.mRawPlaybackHeadWrapCount = 0L;
            }
            this.mAudioTrack.flush();
            if (this.mWrittenPcmBytes > 0) {
                this.mWrittenPcmBytes = 0L;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void stop() {
        AVLogger.Debug(TAG, this, a.e);
        if (this.mStoped) {
            return;
        }
        this.mStoped = true;
        try {
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker != null) {
                audioTrackPositionTracker.pause();
            }
            if (this.mEnableAudioTrackPool) {
                this.mAudioTrack.stop();
            } else {
                this.mAudioTrack.pause();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        AVLogger.Debug(TAG, this, a.e);
    }

    public int write(byte[] bArr, int i, int i2, int i3) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (bArr == null || bArr.length == 0) {
            AVLogger.Error(TAG, this, "buffer is nullpoint");
            return -10;
        }
        int iStart = 0;
        if (this.mStoped) {
            return 0;
        }
        if (this.mSerial != i3) {
            this.mSerial = i3;
            if (this.mWrittenPcmBytes > 0) {
                this.mAudioTrack.flush();
            }
        }
        try {
            int iWrite = this.mAudioTrack.write(bArr, i, i2);
            if (iWrite < 0) {
                AVLogger.Error(TAG, this, "write failed : ret: " + iWrite + ", size = " + i2);
                return iWrite;
            }
            this.mWrittenPcmBytes += iWrite;
            if (needsReset() && reset() == 0) {
                iStart = start();
            }
            return iStart == 0 ? iWrite : iStart;
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "write fail = " + e);
            e.printStackTrace();
            return -1;
        }
    }

    public int write(byte[] bArr, int i, int i2, int i3, long j) throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (bArr == null || bArr.length == 0) {
            AVLogger.Error(TAG, this, "buffer is nullpoint");
            return -10;
        }
        int iStart = 0;
        if (this.mStoped) {
            return 0;
        }
        if (this.mSerial != i3) {
            this.mSerial = i3;
            AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
            if (audioTrackPositionTracker == null || this.mReleasingConditionVariable == null) {
                if (this.mWrittenPcmBytes > 0) {
                    this.mAudioTrack.flush();
                }
            } else if (this.mWrittenPcmBytes > 0) {
                if (audioTrackPositionTracker.isPlaying()) {
                    this.mAudioTrack.pause();
                }
                this.audioTrackPositionTracker.reset();
                this.mStartMediaTimeMs = -1;
                this.mReleasingConditionVariable.close();
                this.mWrittenPcmBytes = 0L;
                final AudioTrack audioTrack = this.mAudioTrack;
                this.mAudioTrack = null;
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AJVoice.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AVLogger.Debug(AJVoice.TAG, this, "release old track");
                            audioTrack.flush();
                            audioTrack.release();
                            AVLogger.Debug(AJVoice.TAG, this, "release old track done");
                        } finally {
                            if (AJVoice.this.mReleasingConditionVariable != null) {
                                AJVoice.this.mReleasingConditionVariable.open();
                            }
                        }
                    }
                });
                this.mReleasingConditionVariable.block();
                reconfigure();
                start();
                this.mSerial = i3;
            }
        }
        int i4 = this.mStartMediaTimeMs;
        if (i4 == -1) {
            this.mStartMediaTimeMs = (int) Math.max(0L, j);
        } else {
            long writtenDurationMs = i4 + getWrittenDurationMs();
            if (Math.abs(writtenDurationMs - j) > FORCE_RESET_WORKAROUND_TIMEOUT_MS) {
                AVLogger.Error(TAG, this, "Discontinuity detected [expected " + writtenDurationMs + ", got " + j + "]");
                this.mStartMediaTimeMs = (int) (this.mStartMediaTimeMs + (j - writtenDurationMs));
            }
        }
        try {
            int iWrite = this.mAudioTrack.write(bArr, i, i2);
            if (iWrite < 0) {
                AVLogger.Error(TAG, this, "write failed : ret: " + iWrite + ", size = " + i2);
                return iWrite;
            }
            this.mWrittenPcmBytes += iWrite;
            if (needsReset() && reset() == 0) {
                iStart = start();
                this.mSerial = i3;
            }
            return iStart == 0 ? iWrite : iStart;
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "write fail = " + e);
            e.printStackTrace();
            return -1;
        }
    }

    public int write(ByteBuffer byteBuffer, int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (byteBuffer == null) {
            AVLogger.Error(TAG, this, "buffer is nullpoint");
            return -1;
        }
        if (this.mAudioTrack.write(byteBuffer, 0, byteBuffer.capacity()) != byteBuffer.capacity()) {
            return -1;
        }
        byteBuffer.flip();
        return 0;
    }

    public int write(int i, int i2, int i3) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int iWrite;
        int iStart = 0;
        if (this.mStoped) {
            return 0;
        }
        if (this.mSerial != i3) {
            this.mSerial = i3;
            if (this.mWrittenPcmBytes > 0) {
                this.mAudioTrack.flush();
            }
        }
        try {
            if (Util.SDK_INT >= 21) {
                iWrite = this.mAudioTrack.write(this.mPCMFrameBuffer, i2, 0);
            } else {
                this.mPCMFrameBuffer.get(this.mMinBytes, i, i2);
                iWrite = this.mAudioTrack.write(this.mMinBytes, 0, i2);
            }
            if (iWrite < 0) {
                AVLogger.Error(TAG, this, "write failed : ret: " + iWrite + ", size = " + i2);
                return iWrite;
            }
            this.mWrittenPcmBytes += iWrite;
            if (needsReset() && reset() == 0) {
                iStart = start();
            }
            this.mPCMFrameBuffer.clear();
            return iStart == 0 ? iWrite : iStart;
        } catch (Exception e) {
            AVLogger.Debug(TAG, this, "write fail = " + e);
            e.printStackTrace();
            return -1;
        }
    }

    public void setTrackVolume(float f, float f2) {
        AudioTrack audioTrack = this.mAudioTrack;
        if (audioTrack != null) {
            this.mForceReleaseAudioTrackByPool = true;
            if (SDK_INT < 21) {
                audioTrack.setStereoVolume(f, f2);
            } else {
                audioTrack.setVolume(f);
            }
        }
    }

    public void setVolume(float f, float f2) {
        AudioTrack audioTrack;
        try {
            int i = this.mMaxVolume;
            if (i < f) {
                f = i;
            }
            if (f2 == -1048575.0f && (audioTrack = this.mAudioTrack) != null) {
                this.mForceReleaseAudioTrackByPool = true;
                audioTrack.setStereoVolume(f, f2);
            } else {
                AudioManager audioManager = this.mAudioManager;
                if (audioManager != null) {
                    audioManager.setStreamVolume(this.mStreamType, (int) f, 0);
                }
            }
            this.mLeftVolume = f;
        } catch (Exception unused) {
        }
    }

    public float getVolume() {
        int streamMaxVolume;
        AudioManager audioManager;
        int streamVolume = 0;
        if (this.mPlayer == null || this.mLeftVolume != -1.0f || (audioManager = this.mAudioManager) == null) {
            streamMaxVolume = 0;
        } else {
            try {
                streamMaxVolume = audioManager.getStreamMaxVolume(this.mStreamType);
                try {
                    streamVolume = this.mAudioManager.getStreamVolume(this.mStreamType);
                } catch (Exception unused) {
                }
            } catch (Exception unused2) {
            }
        }
        if (streamVolume >= 0) {
            return streamVolume;
        }
        if (streamMaxVolume > 0) {
            return streamMaxVolume / 4;
        }
        return 10.0f;
    }

    public int getMaxVolume() {
        AVLogger.d("ttmn", "getMaxVolume:" + this.mMaxVolume);
        return this.mMaxVolume;
    }

    public void setSampleInfo(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mSampleRate = i2;
        this.mChannels = i3;
        this.mBlockSize = i4;
        this.mSampleBytes = i6;
        this.mSampleFormat = i;
        this.mFrameSamples = i5;
        AVLogger.Debug(TAG, this, "mBlockSize:" + this.mBlockSize);
    }

    public void setStreamType(int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AVLogger.Debug(TAG, this, "set Stream type : " + i);
        this.mStreamType = i;
        if (this.mPlayer != null && reset() == 0) {
            start();
        }
    }

    public void setSessionId(int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AVLogger.Debug(TAG, this, "setSessionId : " + i);
        this.mSessionId = i;
        if (this.mPlayer != null && reset() == 0) {
            start();
        }
    }

    public void setContentType(int i) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AVLogger.Debug(TAG, this, "setContentType contentType=" + i);
        this.mContentType = i;
        if (this.mPlayer != null && reset() == 0) {
            start();
        }
    }

    public int getSessionId() {
        AudioTrack audioTrack;
        int i = this.mSessionId;
        return (i != -1 || (audioTrack = this.mAudioTrack) == null) ? i : audioTrack.getAudioSessionId();
    }

    public int getUnderRunCount() {
        AudioTrack audioTrack;
        if (Build.VERSION.SDK_INT < 24 || (audioTrack = this.mAudioTrack) == null) {
            return -1;
        }
        return audioTrack.getUnderrunCount();
    }

    public void setUseDirectBuffer(boolean z) {
        AVLogger.Debug(TAG, this, "useDirectBuffer: " + z);
        this.mUseDirectBuffer = z;
    }

    public void setEnableAudioTrackPool(boolean z) {
        AVLogger.Debug(TAG, this, "enableAudioTrackPool: " + z);
        this.mEnableAudioTrackPool = z;
    }

    public void setCalibrationType(int i) {
        AVLogger.Debug(TAG, this, "type: " + i);
        this.mCalibrationType = i;
    }

    private int reconfigure() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        AudioManager audioManager = (AudioManager) this.mPlayer.getContext().getSystemService("audio");
        this.mAudioManager = audioManager;
        if (audioManager != null) {
            this.mMaxVolume = audioManager.getStreamMaxVolume(this.mStreamType);
        }
        int audioTrackChannelConfig = getAudioTrackChannelConfig(this.mChannels);
        this.mChannelsLayout = audioTrackChannelConfig;
        if (audioTrackChannelConfig == 0) {
            AVLogger.Debug(TAG, this, String.format(Locale.US, "not supoort channel:%d", Integer.valueOf(this.mChannels)));
            return -1;
        }
        int i = this.mSampleBytes;
        if (i == 1) {
            this.mAudioFormat = 3;
        } else {
            if (i != 2) {
                AVLogger.Debug(TAG, this, String.format(Locale.US, "not supoort format:%d", Integer.valueOf(this.mSampleBytes)));
                return -12;
            }
            this.mAudioFormat = 2;
        }
        int minBufferSize = AudioTrack.getMinBufferSize(this.mSampleRate, audioTrackChannelConfig, this.mAudioFormat);
        if (minBufferSize <= 0) {
            AVLogger.Error(TAG, this, "getMinBufferSize failed, trace: sampleRate = " + this.mSampleRate + ", mChannelsLayout = " + this.mChannelsLayout + ", mAudioFormat = " + this.mAudioFormat);
            return minBufferSize;
        }
        this.mTrackBufferSize = minBufferSize;
        int i2 = this.mCalibrationType > 1 ? this.mBlockSize : minBufferSize;
        if (!this.mUseDirectBuffer || Util.SDK_INT < 21) {
            try {
                this.mMinBytes = new byte[i2];
            } catch (OutOfMemoryError unused) {
                AVLogger.Error(TAG, this, "out of memory error when new audio buffer for audiotrack");
                return -10;
            }
        }
        if (this.mUseDirectBuffer && this.mPCMFrameBuffer == null) {
            try {
                this.mPCMFrameBuffer = ByteBuffer.allocateDirect(i2);
            } catch (Exception unused2) {
                AVLogger.Error(TAG, this, "out of memory error when new audio buffer for audiotrack");
                return -10;
            }
        }
        int pcmFrameSize = getPcmFrameSize(this.mAudioFormat, this.mChannels);
        this.mOutputPcmFrameSize = pcmFrameSize;
        this.mBufferSizeMs = ((this.mTrackBufferSize / pcmFrameSize) * 1000) / this.mSampleRate;
        AVLogger.Debug(TAG, this, String.format(Locale.US, "mNativeObject:%d,mBlockSize:%d,mSampleRate:%d,mChannels:%d,mSampBit:%d,minBufSize:%d,mFrameSamples:%d,format:%d", Long.valueOf(this.mNativeObject), Integer.valueOf(this.mBlockSize), Integer.valueOf(this.mSampleRate), Integer.valueOf(this.mChannelsLayout), Integer.valueOf(this.mSampleBytes), Integer.valueOf(minBufferSize), Integer.valueOf(this.mFrameSamples), Integer.valueOf(this.mAudioFormat)));
        this.mRawPlaybackHeadWrapCount = 0L;
        this.mBufferSizeError = false;
        return initAudioTrack();
    }

    private int initAudioTrack() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int bufferSizeInFrames;
        if (this.mEnableAudioTrackPool) {
            AudioTrack reuseAudioTrack = this.mAudioTrackPool.getReuseAudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, this.mSessionId, this.mContentType);
            if (reuseAudioTrack != null) {
                this.mAudioTrack = reuseAudioTrack;
            }
            AVLogger.Debug(TAG, this, "AudioTrackPool log: initAudioTrack, try get reuse AudioTrack: " + this.mAudioTrack);
        }
        if (this.mAudioTrack == null) {
            try {
                this.mAudioTrack = createAudioTrack();
                if (this.mEnableAudioTrackPool) {
                    AVLogger.Debug(TAG, this, "AudioTrackPool log: create new AudioTrack:" + this.mAudioTrack);
                }
            } catch (Throwable th) {
                AVLogger.Error(TAG, this, "create audio track failed ,detail = " + th);
                return -1;
            }
        }
        if (this.mCalibrationType > 1 && Build.VERSION.SDK_INT >= 23 && (bufferSizeInFrames = this.mAudioTrack.getBufferSizeInFrames() * this.mOutputPcmFrameSize) != this.mTrackBufferSize) {
            AVLogger.Error(TAG, this, "trackBufferSize error, mTrackBufferSize:" + this.mTrackBufferSize + ", actualBufferSize:" + bufferSizeInFrames);
        }
        if (this.mAudioTrack.getState() == 1) {
            return 0;
        }
        try {
            this.mAudioTrack.release();
        } catch (Throwable unused) {
        }
        this.mAudioTrack = null;
        AVLogger.Error(TAG, this, "create audiotrack but failed to initialize");
        return -3;
    }

    private int calTrackBufferSize(int i) {
        int i2 = i * 4;
        int pcmFrameSize = getPcmFrameSize(this.mAudioFormat, this.mChannels);
        long jDurationUsToBytes = durationUsToBytes(MIN_PCM_BUFFER_DURATION_US, this.mSampleRate, pcmFrameSize);
        long jDurationUsToBytes2 = durationUsToBytes(MAX_PCM_BUFFER_DURATION_US, this.mSampleRate, pcmFrameSize);
        long j = i2;
        if (j < jDurationUsToBytes) {
            i2 = (int) jDurationUsToBytes;
        } else if (j > jDurationUsToBytes2) {
            i2 = (int) jDurationUsToBytes2;
        }
        if (i2 >= i) {
            i = i2;
        }
        return (((i + pcmFrameSize) - 1) / pcmFrameSize) * pcmFrameSize;
    }

    protected static long durationUsToBytes(long j, int i, int i2) {
        return ((j * i) * i2) / 1000000;
    }

    private AudioTrack createAudioTrack() {
        if (Util.SDK_INT >= 26 && this.mCalibrationType == 3) {
            return createAudioTrackV26();
        }
        if (Util.SDK_INT >= 21 && this.mContentType != -1) {
            return createAudioTrackV21();
        }
        return createAudioTrackV9();
    }

    private AudioTrack createAudioTrackV9() {
        if (this.mSessionId == -1) {
            return new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, 1);
        }
        return new AudioTrack(this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, 1, this.mSessionId);
    }

    private AudioTrack createAudioTrackV21() {
        AudioAttributes.Builder builder = new AudioAttributes.Builder();
        builder.setLegacyStreamType(this.mStreamType);
        int i = this.mContentType;
        if (i != -1) {
            builder.setContentType(i);
        }
        AudioAttributes audioAttributesBuild = builder.build();
        AudioFormat audioFormatBuild = new AudioFormat.Builder().setChannelMask(this.mChannelsLayout).setEncoding(this.mAudioFormat).setSampleRate(this.mSampleRate).build();
        int i2 = this.mTrackBufferSize;
        int i3 = this.mSessionId;
        if (i3 == -1) {
            i3 = 0;
        }
        return new AudioTrack(audioAttributesBuild, audioFormatBuild, i2, 1, i3);
    }

    private AudioTrack createAudioTrackV26() {
        AudioTrack.Builder builder = new AudioTrack.Builder();
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setUsage(1);
        int i = this.mContentType;
        if (i == -1) {
            i = 3;
        }
        return builder.setAudioAttributes(usage.setContentType(i).setLegacyStreamType(this.mStreamType).build()).setAudioFormat(new AudioFormat.Builder().setEncoding(this.mAudioFormat).setSampleRate(this.mSampleRate).setChannelMask(this.mChannelsLayout).build()).setBufferSizeInBytes(this.mTrackBufferSize).build();
    }

    private int reset() throws IllegalStateException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        this.mWrittenPcmBytes = 0L;
        this.mLatencyMs = 0;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.mLastGetLatencyMs = 0L;
        this.lastRawPlaybackHeadPosition = 0L;
        this.mLeftVolume = -1.0f;
        if (this.mEnableAudioTrackPool) {
            AVLogger.Debug(TAG, this, "AudioTrackPool log: reset try pushback AudioTrack: " + this.mAudioTrack);
            this.mAudioTrack.stop();
            this.mAudioTrackPool.pushAudioTrackBack(this.mAudioTrack, this.mForceReleaseAudioTrackByPool, this.mStreamType, this.mSampleRate, this.mChannelsLayout, this.mAudioFormat, this.mTrackBufferSize, this.mSessionId, this.mContentType);
            this.mAudioTrack = null;
        } else {
            AudioTrack audioTrack = this.mAudioTrack;
            this.mAudioTrack = null;
            try {
                audioTrack.flush();
                audioTrack.release();
            } catch (Exception unused) {
            }
        }
        return reconfigure();
    }

    public int getCurrentPositionMs() {
        AudioTrackPositionTracker audioTrackPositionTracker = this.audioTrackPositionTracker;
        if (audioTrackPositionTracker != null) {
            return this.mStartMediaTimeMs + ((int) (audioTrackPositionTracker.getCurrentPositionUs(false) / 1000));
        }
        return 0;
    }

    public int getLatency() {
        if (this.mCalibrationType == 0) {
            getPlaybackHeadPosition();
        }
        if (this.getLatencyMethod != null) {
            long jNanoTime = System.nanoTime() / 1000000;
            if (jNanoTime - this.mLastGetLatencyMs > 500) {
                try {
                    int iIntValue = ((Integer) this.getLatencyMethod.invoke(this.mAudioTrack, null)).intValue();
                    this.mLatencyMs = iIntValue;
                    int iMax = Math.max(iIntValue, 0);
                    this.mLatencyMs = iMax;
                    if (iMax > 5000) {
                        AVLogger.Warn(TAG, this, "Ignoring impossibly large audio latency: " + this.mLatencyMs);
                        this.mLatencyMs = 0;
                    }
                } catch (Exception unused) {
                    this.getLatencyMethod = null;
                }
                this.mLastGetLatencyMs = jNanoTime;
            }
        }
        return this.mLatencyMs;
    }

    private boolean needsReset() {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && this.mWrittenPcmBytes > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    private long getPlaybackHeadPosition() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = C00oOOo.f362O8oO888 & this.mAudioTrack.getPlaybackHeadPosition();
        if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
            if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
            }
            return this.lastRawPlaybackHeadPosition;
        }
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition;
    }

    private long getPlaybackHeadPositionV2() {
        int playState = this.mAudioTrack.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = C00oOOo.f362O8oO888 & this.mAudioTrack.getPlaybackHeadPosition();
        if (Util.SDK_INT <= 29) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.mRawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.mRawPlaybackHeadWrapCount << 32);
    }

    private long getWrittenDurationMs() {
        return ((this.mWrittenPcmBytes / getPcmFrameSize(this.mAudioFormat, this.mChannels)) * 1000) / this.mSampleRate;
    }

    private long getPlaybackPositionMs() {
        return (getPlaybackHeadPosition() * 1000) / this.mSampleRate;
    }

    private long getPlaybackBytes() {
        return getPlaybackHeadPosition() * getPcmFrameSize(this.mAudioFormat, this.mChannels);
    }

    public int getAvailableBufferSize() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        int playbackHeadPositionV2 = (int) (this.mWrittenPcmBytes - (getPlaybackHeadPositionV2() * this.mOutputPcmFrameSize));
        if (this.mCalibrationType > 1 && Build.VERSION.SDK_INT >= 23) {
            int bufferSizeInFrames = this.mAudioTrack.getBufferSizeInFrames() * this.mOutputPcmFrameSize;
            if (bufferSizeInFrames != this.mTrackBufferSize && !this.mBufferSizeError) {
                AVLogger.Error(TAG, this, "trackBufferSize error, mTrackBufferSize:" + this.mTrackBufferSize + ", actualBufferSize:" + bufferSizeInFrames);
                this.mBufferSizeError = true;
            }
            return bufferSizeInFrames - playbackHeadPositionV2;
        }
        return this.mTrackBufferSize - playbackHeadPositionV2;
    }

    public int getEOSDelayMs() {
        return (int) ((getWrittenDurationMs() - getPlaybackPositionMs()) + (getLatency() > 0 ? this.mLatencyMs - this.mBufferSizeMs : 0L));
    }

    public static int getPcmFrameSize(int i, int i2) {
        if (i == 2) {
            return i2 * 2;
        }
        if (i == 3) {
            return i2;
        }
        throw new IllegalArgumentException();
    }

    public int getTrackBufferSize() {
        if (this.mCalibrationType > 1 && Build.VERSION.SDK_INT >= 23) {
            return this.mAudioTrack.getBufferSizeInFrames() * this.mOutputPcmFrameSize;
        }
        return this.mTrackBufferSize;
    }

    public ByteBuffer getPCMFrameBuffer() {
        return this.mPCMFrameBuffer;
    }

    public static int getAudioTrackChannelConfig(int i) {
        switch (i) {
            case 1:
                return 4;
            case 2:
                return 12;
            case 3:
                return 28;
            case 4:
                return 204;
            case 5:
                return 220;
            case 6:
                return 252;
            case 7:
                return SocketMessages.PayloadType.SC_LIVE_SMALL_PLAY_RIGHT_BOTTOM_PENDANT;
            case 8:
                return (Build.VERSION.SDK_INT < 23 && Build.VERSION.SDK_INT < 21) ? 0 : 6396;
            default:
                return 0;
        }
    }

    public void setAudioTrackSmoothClock(int i) {
        if (Util.SDK_INT >= 21) {
            this.mEnableAudioTrackSmoothClock = i;
            if (i > 0) {
                this.audioTrackPositionTracker = new AudioTrackPositionTracker(null);
                this.mReleasingConditionVariable = new ConditionVariable(true);
            }
        }
    }
}
