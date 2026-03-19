package com.ss.ttm.player;

import android.media.AudioTrack;
import com.ss.ttm.utils.AVLogger;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class AudioTrackPool {
    private static final String TAG = "AudioTrackPool";
    private static volatile AudioTrackPool instance;
    private AtomicInteger trackPoolSizeLimit = new AtomicInteger(1);
    private Queue<AudioTrackBuffer> trackPool = new LinkedBlockingQueue();

    private AudioTrackPool() {
        setAudioTrackPoolSize(TTPlayerConfiger.getValue(47, 1));
    }

    public static AudioTrackPool getInstance() {
        if (instance == null) {
            synchronized (AudioTrackPool.class) {
                if (instance == null) {
                    instance = new AudioTrackPool();
                    AVLogger.d(TAG, "AudioTrackPool log: Construct AudioTrackPool!");
                }
            }
        }
        return instance;
    }

    public AudioTrack getReuseAudioTrack(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        AudioTrackBuffer next;
        if (this.trackPool.isEmpty()) {
            AVLogger.Debug(TAG, this, "AudioTrackPool log: trackPool is empty!");
            return null;
        }
        synchronized (this) {
            Iterator<AudioTrackBuffer> it = this.trackPool.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (next.streamType == i && next.sampleRate == i2 && next.channelsLayout == i3 && next.audioFormat == i4 && next.trackBufferSize == i5 && next.sessionId == i6 && next.contentType == i7) {
                    break;
                }
            }
            if (next != null) {
                this.trackPool.remove(next);
                if (next.AudioTrack.getPlayState() == 1) {
                    AVLogger.Debug(TAG, this, "AudioTrackPool log: find best-matched AudioTrack: " + next.AudioTrack + " ,mContentType:" + i7 + " ,mStreamType:" + i + " ,mSampleRate:" + i2 + " ,mChannelsLayout:" + i3 + " ,mAudioFormat:" + i4 + " ,mTrackBufferSize:" + i5);
                    return next.AudioTrack;
                }
                releaseAudioTrack(next.AudioTrack);
            }
            AVLogger.Debug(TAG, this, "AudioTrackPool log: find best-matched AudioTrack fail,mContentType:" + i7 + " ,mStreamType:" + i + " ,mSampleRate:" + i2 + " ,mChannelsLayout:" + i3 + " ,mAudioFormat:" + i4 + " ,mTrackBufferSize:" + i5);
            return null;
        }
    }

    public void pushAudioTrackBack(AudioTrack audioTrack, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (audioTrack == null) {
            AVLogger.Debug(TAG, this, "AudioTrackPool log: audioTrack is null!");
            return;
        }
        if (z) {
            AVLogger.Debug(TAG, this, "AudioTrackPool log: force release AudioTrack:" + audioTrack);
            releaseAudioTrack(audioTrack);
            return;
        }
        synchronized (this) {
            if (audioTrack.getPlayState() != 1) {
                audioTrack.stop();
            }
            AudioTrackBuffer audioTrackBuffer = new AudioTrackBuffer(audioTrack, i, i2, i3, i4, i5, i6, i7);
            if (this.trackPool.size() < this.trackPoolSizeLimit.get()) {
                if (this.trackPool.offer(audioTrackBuffer)) {
                    AVLogger.Debug(TAG, this, "AudioTrackPool log: pushback AudioTrack success! AudioTrack: " + audioTrack + ", poolSize: " + this.trackPool.size() + ", mContentType:" + i7 + ", mStreamType:" + i + ", mSampleRate:" + i2 + ", mChannelsLayout:" + i3 + ", mAudioFormat:" + i4 + ", mTrackBufferSize:" + i5);
                }
            } else {
                AudioTrack audioTrack2 = this.trackPool.poll().AudioTrack;
                if (audioTrack2 != null) {
                    AVLogger.Debug(TAG, this, "AudioTrackPool log: start release AudioTrack! AudioTrack: " + audioTrack2);
                    releaseAudioTrack(audioTrack2);
                    if (this.trackPool.offer(audioTrackBuffer)) {
                        AVLogger.Debug(TAG, this, "AudioTrackPool log: pushback AudioTrack success! AudioTrack: " + audioTrack + ", poolSize: " + this.trackPool.size() + ", mContentType:" + i7 + ", mStreamType:" + i + ", mSampleRate:" + i2 + ", mChannelsLayout:" + i3 + ", mAudioFormat:" + i4 + ", mTrackBufferSize:" + i5);
                    }
                }
            }
        }
    }

    public void releaseAudioTrack(final AudioTrack audioTrack) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (audioTrack != null) {
            try {
                AVThreadPool.addTask(new Runnable() { // from class: com.ss.ttm.player.AudioTrackPool.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AVLogger.Debug(AudioTrackPool.TAG, this, "AudioTrackPool log: release AudioTrack task");
                        audioTrack.flush();
                        audioTrack.release();
                    }
                });
            } catch (Throwable th) {
                AVLogger.Error(TAG, this, "AudioTrackPool log: create close thread fail: " + th);
                audioTrack.flush();
                audioTrack.release();
            }
        }
    }

    public void setAudioTrackPoolSize(int i) {
        AVLogger.d(TAG, "AudioTrackPool log: set audioTrack pool size:" + i);
        this.trackPoolSizeLimit.set(i);
    }
}
