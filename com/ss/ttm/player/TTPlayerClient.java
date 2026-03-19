package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.baidu.mobads.sdk.internal.ca;
import com.kuaishou.tk.api.export.sdk.UriUtils;
import com.ss.ttm.net.AVResolver;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVErrorInfo;
import com.ss.ttm.utils.AVLogger;
import com.ss.ttm.utils.AVTime;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TTPlayerClient extends MediaPlayerClient implements Handler.Callback, ISurfaceListener {
    public static final int KEY_IS_CONFIG_PARAMS_OPTION = 100;
    private static final String TAG = "TTPlayerClient";
    private String mBufferingInfo;
    private TTSurfaceCallback mCallback;
    private int mCodecAndSurfaceReuse;
    private HashMap<Integer, Integer> mConfigParams;
    private boolean mConnectedCpu;
    private Context mContext;
    private int mCrashType;
    private StringBuilder mCrashedInfo;
    private int mDisablePlayerStayAwake;
    private int mErrorCode;
    private Handler mHandler;
    private int mIgnoreSurfaceCreated;
    private MediaPlayer.OnLogListener mLogListener;
    private int mMediaCodecStopTimeOutMs;
    private MediaPlayer.OnBufferingUpdateListener mOnBufferingUpdateListener;
    private MediaPlayer.OnCompletionListener mOnCompletionListener;
    private MediaPlayer.OnErrorListener mOnErrorListener;
    private MediaPlayer.OnExternInfoListener mOnExternInfoListener;
    private MediaPlayer.OnInfoListener mOnInfoListener;
    private MediaPlayer.OnPreparedListener mOnPreparedListener;
    private MediaPlayer.onSARChangedListener mOnSARChangedListener;
    private MediaPlayer.OnSeekCompleteListener mOnSeekCompleteListener;
    private MediaPlayer.OnVideoSizeChangedListener mOnVideoSizeChangedListener;
    private ITTPlayerRef mPlayer;
    private final ReentrantReadWriteLock.ReadLock mReadLock;
    private final ReentrantReadWriteLock mReadWritedLock;
    private volatile boolean mRealsedSurface;
    private int mRtcPlay;
    private boolean mScreenOnWhilePlaying;
    private boolean mStayAwake;
    private SurfaceHolder mSurfaceHolder;
    private String mUri;
    private String mVoiceInfo;
    private PowerManager.WakeLock mWakeLock;
    private MediaPlayer mWrapper;
    private final ReentrantReadWriteLock.WriteLock mWriteLock;
    private boolean mSeekComplete = true;
    private LinkedList<String> mLogInfo = new LinkedList<>();
    private int mPlayLifeId = -1;
    private final Object mHandlerLocker = new Object();
    private final ReentrantLock mReentrantLock = new ReentrantLock();
    private final ReentrantLock mReentrantLockInRtc = new ReentrantLock();

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getSelectedTrack(int i) {
        if (i == 2) {
            return 1;
        }
        if (i == 1) {
            return 0;
        }
        return i == 4 ? 2 : -1;
    }

    static {
        TTVersion.saveVersionInfo();
    }

    public static synchronized TTPlayerClient create(MediaPlayer mediaPlayer, Context context) {
        return create(mediaPlayer, context, null);
    }

    public static synchronized TTPlayerClient create(MediaPlayer mediaPlayer, Context context, HashMap<Integer, Integer> map) {
        TTVersion.saveVersionInfo();
        TTPlayerClient tTPlayerClient = new TTPlayerClient(context, map);
        ITTPlayerRef iTTPlayerRefCreate = ITTPlayerRef.create(context, tTPlayerClient, map);
        if (iTTPlayerRefCreate == null) {
            return null;
        }
        tTPlayerClient.mPlayer = iTTPlayerRefCreate;
        tTPlayerClient.mWrapper = mediaPlayer;
        return tTPlayerClient;
    }

    public static void setGlobalIntOptionForKey(int i, int i2) {
        ITTPlayerRef.setGlobalIntOptionForKey(i, i2);
    }

    public static long getDemuxerFactory(int i) {
        return TTPlayer.getDemuxerFactory(i);
    }

    private TTPlayerClient(Context context, HashMap<Integer, Integer> map) {
        this.mRealsedSurface = false;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.mReadWritedLock = reentrantReadWriteLock;
        this.mReadLock = reentrantReadWriteLock.readLock();
        this.mWriteLock = reentrantReadWriteLock.writeLock();
        this.mErrorCode = 0;
        this.mRtcPlay = 0;
        this.mCrashedInfo = new StringBuilder(1024);
        this.mCrashType = -1;
        this.mDisablePlayerStayAwake = 0;
        this.mMediaCodecStopTimeOutMs = -1;
        this.mCodecAndSurfaceReuse = 0;
        this.mIgnoreSurfaceCreated = 0;
        this.mConnectedCpu = false;
        this.mConfigParams = map;
        this.mRealsedSurface = false;
        this.mCallback = new TTSurfaceCallback(this);
        this.mContext = context;
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(this);
        } else {
            this.mHandler = new Handler(Looper.getMainLooper(), this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isValid() {
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        return iTTPlayerRef != null && iTTPlayerRef.isValid();
    }

    protected void updateLifeId() {
        try {
            this.mReentrantLock.lock();
            this.mPlayLifeId = this.mPlayer.getLifeId();
            AVLogger.d(TAG, "reset.mPlayLifeId" + this.mPlayLifeId);
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    @Deprecated
    public void prevClose() {
        String str = TAG;
        AVLogger.d(str, "prev close start");
        this.mRealsedSurface = true;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.mCallback);
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.prevClose();
            }
            this.mReadLock.unlock();
            AVLogger.d(str, "prev close end");
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void releaseAsync() {
        String str = TAG;
        AVLogger.d(str, "prev close start");
        this.mRealsedSurface = true;
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.mCallback);
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.prevClose();
            }
            this.mReadLock.unlock();
            AVLogger.d(str, "prev close end");
            new Thread(new Runnable() { // from class: com.ss.ttm.player.TTPlayerClient.1
                @Override // java.lang.Runnable
                public void run() {
                    TTPlayerClient.this.release();
                }
            }).start();
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    public void close() {
        String str = TAG;
        AVLogger.d(str, "close start");
        this.mRealsedSurface = true;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.close();
            }
            this.mReadLock.unlock();
            AVLogger.d(str, "close end");
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void release() {
        String playerErrorInfo;
        stayAwake(false);
        updateSurfaceScreenOn();
        this.mWriteLock.lock();
        try {
            ITTPlayerRef iTTPlayerRef = this.mPlayer;
            this.mPlayer = null;
            this.mPlayLifeId = -1;
            if (iTTPlayerRef != null) {
                iTTPlayerRef.release();
            }
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder != null) {
                surfaceHolder.removeCallback(this.mCallback);
                this.mSurfaceHolder = null;
                this.mRealsedSurface = true;
            }
            synchronized (this.mHandlerLocker) {
                Handler handler = this.mHandler;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                    this.mHandler = null;
                }
            }
            if (this.mLogListener != null && (playerErrorInfo = getPlayerErrorInfo()) != null && playerErrorInfo.length() > 0) {
                this.mLogListener.onLogInfo(this.mWrapper, playerErrorInfo);
            }
            this.mContext = null;
            AVLogger.d(TAG, "release end");
        } finally {
            this.mWriteLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void start() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.start();
                updateLifeId();
                this.mRtcPlay = this.mPlayer.getIntOption(800, 0);
            }
            this.mReadLock.unlock();
            stayAwake(true);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void pause() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.pause();
            }
            this.mReadLock.unlock();
            stayAwake(false);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void reset() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.reset();
                SurfaceHolder surfaceHolder = this.mSurfaceHolder;
                if (surfaceHolder != null && this.mCodecAndSurfaceReuse == 0) {
                    this.mPlayer.setSurfaceTimeOut(surfaceHolder.getSurface(), 0);
                }
                this.mHandler.removeCallbacksAndMessages(null);
                this.mErrorCode = 0;
                this.mLogInfo.clear();
                updateLifeId();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void stop() {
        SurfaceHolder surfaceHolder;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                if (this.mConnectedCpu && this.mCodecAndSurfaceReuse == 1 && (surfaceHolder = this.mSurfaceHolder) != null) {
                    surfaceHolder.removeCallback(this.mCallback);
                    this.mSurfaceHolder = null;
                    this.mPlayer.setSurfaceTimeOut(null, 0);
                    this.mConnectedCpu = false;
                    AVLogger.Warn(TAG, this, "testlog: mConnected Cpu " + this.mConnectedCpu);
                }
                this.mPlayer.stop();
            }
            this.mReadLock.unlock();
            stayAwake(false);
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepare() {
        prepareAsync();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void prepareAsync() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mErrorCode = 0;
                this.mLogInfo.clear();
                if (this.mRealsedSurface) {
                    this.mPlayer.setSurfaceTimeOut(this.mSurfaceHolder.getSurface(), 0);
                    this.mRealsedSurface = false;
                }
                this.mPlayer.prepare();
                updateLifeId();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void takeScreenshot(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        if (this.mPlayer == null || onScreenshotListener == null) {
            return;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(15L);
                this.mPlayer.setOnScreenshotListener(onScreenshotListener);
                this.mPlayer.takeScreenshot();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void switchStream(int i, int i2) {
        if (this.mPlayer != null) {
            this.mReadLock.lock();
            try {
                if (isValid()) {
                    this.mPlayer.switchStream(i, i2);
                }
            } finally {
                this.mReadLock.unlock();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getCurrentPosition() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(2, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoHeight() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(4, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoWidth() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(3, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getDuration() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(1, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDisplay(SurfaceHolder surfaceHolder) {
        SurfaceHolder surfaceHolder2;
        if (this.mCodecAndSurfaceReuse != 0 && (surfaceHolder2 = this.mSurfaceHolder) == surfaceHolder && surfaceHolder2 != null) {
            AVLogger.d(TAG, "surfaceholder already setted");
            return;
        }
        SurfaceHolder surfaceHolder3 = this.mSurfaceHolder;
        if (surfaceHolder3 != null) {
            surfaceHolder3.removeCallback(this.mCallback);
        }
        this.mSurfaceHolder = surfaceHolder;
        Surface surface = null;
        if (surfaceHolder != null) {
            surfaceHolder.addCallback(this.mCallback);
            surface = this.mSurfaceHolder.getSurface();
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, 0);
            }
            this.mReadLock.unlock();
            updateSurfaceScreenOn();
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(Context context, Uri uri, Map<String, String> map) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (uri == null) {
            return;
        }
        setDataSource(context, uri);
        if (map == null || map.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\r\n");
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setStringOption(20, sb.toString());
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005b  */
    @Override // com.ss.ttm.player.MediaPlayerClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setDataSource(android.content.Context r3, android.net.Uri r4) throws java.lang.IllegalStateException, java.io.IOException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            r2 = this;
            if (r4 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r4.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2f
            java.lang.String r0 = r4.getAuthority()
            java.lang.String r1 = "settings"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L2f
            int r4 = android.media.RingtoneManager.getDefaultType(r4)
            android.net.Uri r4 = android.media.RingtoneManager.getActualDefaultRingtoneUri(r3, r4)
            if (r4 == 0) goto L27
            goto L2f
        L27:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.String r4 = "Can't resolve default ringtone"
            r3.<init>(r4)
            throw r3
        L2f:
            r0 = 0
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L56 java.lang.SecurityException -> L59
            java.lang.String r1 = "r"
            android.content.res.AssetFileDescriptor r0 = r3.openAssetFileDescriptor(r4, r1)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L56 java.lang.SecurityException -> L59
            if (r0 != 0) goto L42
            if (r0 == 0) goto L41
            r0.close()
        L41:
            return
        L42:
            java.io.FileDescriptor r3 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L56 java.lang.SecurityException -> L59
            r2.setDataSource(r3)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L56 java.lang.SecurityException -> L59
            if (r0 == 0) goto L4e
            r0.close()
        L4e:
            return
        L4f:
            r3 = move-exception
            if (r0 == 0) goto L55
            r0.close()
        L55:
            throw r3
        L56:
            if (r0 == 0) goto L5e
            goto L5b
        L59:
            if (r0 == 0) goto L5e
        L5b:
            r0.close()
        L5e:
            java.lang.String r3 = r4.toString()
            r2.setDataSource(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTPlayerClient.setDataSource(android.content.Context, android.net.Uri):void");
    }

    public void setDataSource(FileDescriptor fileDescriptor) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(fileDescriptor);
        try {
            ITTPlayerRef iTTPlayerRef = this.mPlayer;
            if (iTTPlayerRef != null) {
                iTTPlayerRef.setDataSourceFd(parcelFileDescriptorDup.getFd());
            }
        } finally {
            if (parcelFileDescriptorDup != null) {
                parcelFileDescriptorDup.close();
            }
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) throws IllegalStateException, IOException, IllegalArgumentException {
        setDataSource(fileDescriptor);
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLongOption(135, j);
                this.mPlayer.setLongOption(136, j2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(String str) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException {
        if (str.toLowerCase(Locale.US).indexOf("://") <= 0) {
            this.mUri = UriUtils.FILE_PREFIX + str;
        } else {
            this.mUri = str;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setDataSource(this.mUri);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalStateException, SecurityException, IOException, IllegalArgumentException {
        if (iMediaDataSource == null) {
            throw new IllegalArgumentException("null mediadatasource pointer.");
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setDataSource(iMediaDataSource);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getDataSource() {
        return this.mUri;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isPlaying() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(6, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isLooping() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(5, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLooping(boolean z) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLooping(z ? 1 : 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setVolume(float f, float f2) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setVolume(f, f2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void mouseEvent(int i, int i2, int i3) {
        int i4 = 2;
        if (i == 0) {
            i4 = 1;
        } else if (i == 1) {
            i4 = 3;
        } else if (i != 2) {
            i4 = 0;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.mouseEvent(i4, i2, i3);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void rotateCamera(float f, float f2) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.rotateCamera(f, f2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int i, int i2) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mSeekComplete = false;
                this.mPlayer.seekTo(i, i2);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void seekTo(int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mSeekComplete = false;
                this.mPlayer.seekTo(i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getIntOption(int i, int i2) {
        if (i == 5000) {
            return this.mErrorCode;
        }
        if (i == 26) {
            return this.mCrashType;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                i2 = this.mPlayer.getIntOption(i, i2);
            }
            return i2;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOption(int i, int i2) {
        if (i == 1301) {
            if (Looper.myLooper() != null) {
                this.mHandler = new Handler(this);
            } else {
                this.mHandler = new Handler(Looper.getMainLooper(), this);
            }
            return 0;
        }
        if (i == 41) {
            AVResolver.HOST_MAX_CACHE_TIME = i2;
            return 0;
        }
        if (i == 5003) {
            this.mDisablePlayerStayAwake = i2;
            return 0;
        }
        if (i == 952) {
            this.mMediaCodecStopTimeOutMs = i2;
            return 0;
        }
        if (i == 1007) {
            this.mCodecAndSurfaceReuse = i2;
        } else if (i == 1036) {
            this.mIgnoreSurfaceCreated = i2;
        } else if (i == 984) {
            if (i2 == 0) {
                i2 = 0;
            } else if (i2 == 1) {
                i2 = 16777216;
            } else if (i2 == 2) {
                i2 = AVLogger.LEVEL_LOG_INFO;
            } else if (i2 == 3 || i2 == 4) {
                i2 = 34603008;
            } else if (i2 == 5) {
                i2 = AVLogger.LEVEL_LOG_WARN;
            } else if (i2 == 6) {
                i2 = 67108864;
            }
            AVLogger.setLogLevel(i2);
        } else if (i == 1501) {
            AVLogger.setLogLevel(i2);
        }
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setIntOption(i, i2) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOption(int i, String str) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setStringOption(i, str) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getStringOption(int i) {
        if (i == 5001) {
            return getPlayerCrashedInfo();
        }
        if (i == 5002) {
            LinkedList<String> linkedList = this.mLogInfo;
            if (linkedList == null || linkedList.size() == 0) {
                return null;
            }
            return getPlayerErrorInfo();
        }
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getStringOption(i) : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOption(int i, long j) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setLongOption(i, j) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public long getLongOption(int i, long j) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                j = this.mPlayer.getLongOption(i, j);
            }
            return j;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public float getFloatOption(int i, float f) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                f = this.mPlayer.getFloatOption(i, f);
            }
            return f;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOption(int i, float f) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setFloatOption(i, f) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public Object getObjectOption(int i) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getObjectOption(i) : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setIntOptionArray(int[] iArr, int[] iArr2) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setIntOptionArray(iArr, iArr2) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setLongOptionArray(int[] iArr, long[] jArr) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setLongOptionArray(iArr, jArr) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setFloatOptionArray(int[] iArr, float[] fArr) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setFloatOptionArray(iArr, fArr) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int setStringOptionArray(int[] iArr, String[] strArr) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.setStringOptionArray(iArr, strArr) : -1;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getVideoType() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getIntOption(11, 0) : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPanoVideoControlModel(int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setIntOption(11, i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public boolean isMute() {
        this.mReadLock.lock();
        try {
            boolean z = false;
            if (isValid()) {
                if (this.mPlayer.getIntOption(12, 0) == 1) {
                    z = true;
                }
            }
            return z;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setIsMute(boolean z) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setIntOption(12, z ? 1 : 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurface(Surface surface) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSurfaceTimeOut(Surface surface, int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(surface, i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setCacheFile(String str, int i) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setCacheFile(str, i);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setScreenOnWhilePlaying(boolean z) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        if (this.mScreenOnWhilePlaying != z) {
            if (z && this.mSurfaceHolder == null) {
                AVLogger.Warn(TAG, this, "setScreenOnWhilePlaying(true) is ineffective without a SurfaceHolder");
            }
            this.mScreenOnWhilePlaying = z;
            updateSurfaceScreenOn();
        }
    }

    public void updateSurfaceScreenOn() {
        SurfaceHolder surfaceHolder = this.mSurfaceHolder;
        if (surfaceHolder == null || this.mDisablePlayerStayAwake != 0) {
            return;
        }
        surfaceHolder.setKeepScreenOn(this.mScreenOnWhilePlaying && this.mStayAwake);
    }

    private void stayAwake(boolean z) {
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (z && !wakeLock.isHeld()) {
                this.mWakeLock.acquire();
            } else if (!z && this.mWakeLock.isHeld()) {
                this.mWakeLock.release();
            }
        }
        this.mStayAwake = z;
        updateSurfaceScreenOn();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setWakeMode(Context context, int i) {
        boolean z;
        PowerManager.WakeLock wakeLock = this.mWakeLock;
        if (wakeLock != null) {
            if (wakeLock.isHeld()) {
                z = true;
                this.mWakeLock.release();
            } else {
                z = false;
            }
            this.mWakeLock = null;
        } else {
            z = false;
        }
        PowerManager.WakeLock wakeLockNewWakeLock = ((PowerManager) context.getSystemService("power")).newWakeLock(i | 536870912, TTPlayerClient.class.getName());
        this.mWakeLock = wakeLockNewWakeLock;
        if (wakeLockNewWakeLock != null) {
            wakeLockNewWakeLock.setReferenceCounted(false);
            if (z) {
                this.mWakeLock.acquire();
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void handleNotify(int i, int i2, int i3, String str) {
        if (i2 != 0) {
            if (i2 == 12) {
                AVLogger.d(TAG, "handleNotify -------------->>>>>>>update seek complete:what:" + i2 + ",parameter:" + i3);
                sendSeekCompleted(i);
                return;
            }
            if (i2 == 13) {
                String str2 = TAG;
                AVLogger.d(str2, "handleNotify -------------->>>>>>>Completed:what:" + i2 + ",parameter:" + i3);
                stayAwake(false);
                AVLogger.d(str2, "life:" + i + ",plifeId:" + this.mPlayLifeId);
                sendSeekCompleted(i);
                sendCompletioned(i);
                return;
            }
            if (i2 != 84) {
                if (i2 != 85) {
                    switch (i2) {
                        case 0:
                        case 45:
                            break;
                        case 32:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                        case 41:
                        case 42:
                        case 47:
                        case 49:
                        case 82:
                        case 1000:
                            break;
                        case 33:
                        case 40:
                        case 43:
                        case 44:
                            break;
                        case 20000:
                            AVLogger.d(TAG, "handleNotify -------------->>>>>>>Completed:what:" + i2 + ",parameter:" + i3);
                            if (this.mErrorCode == -2139062143) {
                                return;
                            }
                            this.mErrorCode = -2139062143;
                            this.mWriteLock.lock();
                            try {
                                ITTPlayerRef iTTPlayerRef = this.mPlayer;
                                if (iTTPlayerRef != null) {
                                    this.mPlayer = null;
                                    iTTPlayerRef.invalid();
                                    this.mWriteLock.unlock();
                                    HashMap<Integer, Integer> map = this.mConfigParams;
                                    if (map != null && map.get(100).intValue() == 1) {
                                        this.mConfigParams.put(7, 1);
                                    } else {
                                        TTPlayerConfiger.setValue(7, true);
                                    }
                                    stayAwake(false);
                                    sendSeekCompleted(i);
                                    sendErrorInfo(i3, i);
                                    sendCompletioned(i);
                                    return;
                                }
                                return;
                            } finally {
                                this.mWriteLock.unlock();
                            }
                        default:
                            switch (i2) {
                                case 2:
                                    if (this.mOnPreparedListener != null) {
                                        AVLogger.d(TAG, "handleNotify --------------->>>>>>Prepared:what:" + i2 + ",parameter:" + i3);
                                        this.mOnPreparedListener.onPrepared(this.mWrapper);
                                        return;
                                    }
                                    return;
                                case 3:
                                    if (i3 == 100) {
                                        AVLogger.d(TAG, "handleNotify -------------->>>>>>>update buffer:what:" + i2 + ",parameter:" + i3);
                                    }
                                    MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener = this.mOnBufferingUpdateListener;
                                    if (onBufferingUpdateListener != null) {
                                        onBufferingUpdateListener.onBufferingUpdate(this.mWrapper, i3);
                                        return;
                                    }
                                    return;
                                case 4:
                                case 5:
                                case 7:
                                case 8:
                                case 9:
                                case 10:
                                    break;
                                case 6:
                                    MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener = this.mOnVideoSizeChangedListener;
                                    if (onVideoSizeChangedListener != null) {
                                        onVideoSizeChangedListener.onVideoSizeChanged(this.mWrapper, 65535 & i3, i3 >> 16);
                                        return;
                                    }
                                    return;
                                default:
                                    switch (i2) {
                                        case 19:
                                            break;
                                        case 20:
                                        case 21:
                                        case 22:
                                        case 24:
                                        case 25:
                                        case 26:
                                        case 27:
                                        case 28:
                                        case 29:
                                        case 30:
                                            break;
                                        case 23:
                                            int i4 = 65535 & i3;
                                            int i5 = i3 >> 16;
                                            AVLogger.d(TAG, "handleNotify --------------->>>>>>IsSARChange:what:" + i2 + ",num:" + i4 + ",den:" + i5);
                                            MediaPlayer.onSARChangedListener onsarchangedlistener = this.mOnSARChangedListener;
                                            if (onsarchangedlistener != null) {
                                                onsarchangedlistener.onSARChanged(this.mWrapper, i4, i5);
                                                return;
                                            }
                                            return;
                                        default:
                                            switch (i2) {
                                                default:
                                                    switch (i2) {
                                                        case 57:
                                                        case 58:
                                                            break;
                                                        case 59:
                                                            break;
                                                        default:
                                                            switch (i2) {
                                                                case 61:
                                                                case 62:
                                                                    break;
                                                                case 63:
                                                                    break;
                                                                default:
                                                                    switch (i2) {
                                                                        case 65:
                                                                        case 66:
                                                                        case 67:
                                                                            break;
                                                                        case 68:
                                                                            break;
                                                                        default:
                                                                            switch (i2) {
                                                                                case 70:
                                                                                case 71:
                                                                                case 72:
                                                                                    break;
                                                                                case 73:
                                                                                    this.mConnectedCpu = true;
                                                                                    notifyInfo(i2, i3);
                                                                                    return;
                                                                                default:
                                                                                    return;
                                                                            }
                                                                    }
                                                            }
                                                    }
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                    notifyInfo(i2, i3);
                                                    return;
                                            }
                                    }
                            }
                    }
                }
                onExternInfo(i2, i3, str);
                return;
            }
            notifyInfo(i2, i3);
            return;
        }
        String str3 = TAG;
        AVLogger.d(str3, "handleNotify -------------->>>>>>>Error:what:" + i2 + ",parameter:" + i3);
        stayAwake(false);
        if (i3 == -499989) {
            HashMap<Integer, Integer> map2 = this.mConfigParams;
            if (map2 != null && map2.get(100).intValue() == 1) {
                this.mConfigParams.put(8, 1);
            } else {
                TTPlayerConfiger.setValue(8, true);
            }
        }
        AVLogger.d(str3, "life:" + i + ",plifeId:" + this.mPlayLifeId);
        sendSeekCompleted(i);
        sendErrorInfo(i3, i);
    }

    private void onExternInfo(int i, int i2, String str) {
        if (this.mRtcPlay != 0) {
            try {
                this.mReentrantLockInRtc.lock();
                MediaPlayer.OnExternInfoListener onExternInfoListener = this.mOnExternInfoListener;
                if (onExternInfoListener != null && str != null) {
                    onExternInfoListener.onExternInfo(this.mWrapper, i, str);
                    this.mOnExternInfoListener.onExternInfo2(this.mWrapper, i, i2, str);
                }
                return;
            } finally {
                this.mReentrantLockInRtc.unlock();
            }
        }
        MediaPlayer.OnExternInfoListener onExternInfoListener2 = this.mOnExternInfoListener;
        if (onExternInfoListener2 == null || str == null) {
            return;
        }
        onExternInfoListener2.onExternInfo(this.mWrapper, i, str);
        this.mOnExternInfoListener.onExternInfo2(this.mWrapper, i, i2, str);
    }

    private void notifyInfo(int i, int i2) {
        if (this.mOnInfoListener == null) {
            return;
        }
        int i3 = -1;
        if (i == 4) {
            AVLogger.d(TAG, "handleNotify --------------->>>>>>info buffering  start:what:" + i + "");
            i3 = 701;
        } else if (i == 5) {
            AVLogger.d(TAG, "handleNotify --------------->>>>>>info buffering  end:what:" + i + "");
            i3 = 702;
        } else if (i == 41) {
            AVLogger.d(TAG, "handleNotify --------------->>>>>>info rtc video decode stall:what:" + i + "");
            i3 = -268435424;
        } else if (i == 42) {
            AVLogger.d(TAG, "handleNotify --------------->>>>>>info rtc audio decode stall:what:" + i + "");
            i3 = -268435423;
        } else if (i == 57) {
            i3 = MediaPlayer.MEDIA_NO_AVRENDER_START;
        } else if (i == 58) {
            i3 = MediaPlayer.MEDIA_NO_AVRENDER_END;
        } else if (i == 61) {
            i3 = MediaPlayer.MEDIA_STARTTIME_NO_VIDEO_FRAME;
        } else if (i != 62) {
            switch (i) {
                case 7:
                    AVLogger.d(TAG, "handleNotify --------------->>>>>>info rendering start:what:" + i + "");
                    i3 = 3;
                    break;
                case 8:
                    i3 = 801;
                    break;
                case 9:
                    i3 = 802;
                    break;
                case 10:
                    i3 = 901;
                    break;
                default:
                    switch (i) {
                        case 20:
                            i3 = 251658243;
                            break;
                        case 21:
                            i3 = 251658244;
                            break;
                        case 22:
                            i3 = 251658245;
                            break;
                        case 23:
                            i3 = 251658246;
                            break;
                        case 24:
                            i3 = 251658247;
                            break;
                        case 25:
                            i3 = 251658248;
                            break;
                        case 26:
                            i3 = 251658249;
                            break;
                        case 27:
                            AVLogger.d(TAG, "handleNotify --------------->>>>>>info video render stall:what:" + i + "");
                            i3 = 251658250;
                            break;
                        case 28:
                            AVLogger.d(TAG, "handleNotify --------------->>>>>>info audio render stall:what:" + i + "");
                            i3 = 251658251;
                            break;
                        case 29:
                            AVLogger.d(TAG, "handleNotify --------------->>>>>>info audio rendering start:what:" + i + "");
                            i3 = 251658252;
                            break;
                        case 30:
                            AVLogger.d(TAG, "handleNotify --------------->>>>>>info ready for display:what:" + i + "");
                            i3 = -268435390;
                            break;
                        case 32:
                            i3 = 251658253;
                            break;
                        case 47:
                            AVLogger.d(TAG, "handleNotify --------------->>>>>>info preBuffering  start:what:" + i + "");
                            i3 = -268435408;
                            break;
                        case 82:
                            i3 = MediaPlayer.MEDIA_INFO_VIDEO_ABNORMAL_OCCURED;
                            break;
                        case 84:
                            i3 = MediaPlayer.MEDIA_INFO_RENDER_EXCEPTION;
                            break;
                        case 1000:
                            i3 = 16777217;
                            break;
                        default:
                            switch (i) {
                                case 34:
                                    AVLogger.d(TAG, "handleNotify --------------->>>>>>info video demuxer stall:what:" + i + "");
                                    i3 = -268435442;
                                    break;
                                case 35:
                                    AVLogger.d(TAG, "handleNotify --------------->>>>>>info audio demuxer stall:what:" + i + "");
                                    i3 = -268435441;
                                    break;
                                case 36:
                                    AVLogger.d(TAG, "handleNotify --------------->>>>>>info video decode stall:what:" + i + "");
                                    i3 = -268435440;
                                    break;
                                case 37:
                                    AVLogger.d(TAG, "handleNotify --------------->>>>>>info audio decode stall:what:" + i + "");
                                    i3 = -268435439;
                                    break;
                                case 38:
                                    i3 = -268435438;
                                    break;
                                case 39:
                                    AVLogger.d(TAG, "handleNotify --------------->>>>>>info audio pts back:what:" + i + "");
                                    i3 = -268435437;
                                    break;
                                default:
                                    switch (i) {
                                        case 49:
                                            i3 = -268435392;
                                            break;
                                        case 50:
                                            i3 = -268435391;
                                            break;
                                        case 51:
                                            i3 = -268435407;
                                            break;
                                        case 52:
                                            i3 = -268435406;
                                            break;
                                        case 53:
                                            AVLogger.d(TAG, "handleNotify --------------->>>>>>formater start:what:" + i + "");
                                            i3 = -268435405;
                                            break;
                                        case 54:
                                            AVLogger.d(TAG, "handleNotify --------------->>>>>>decoder start:what:" + i + "");
                                            i3 = -268435404;
                                            break;
                                        default:
                                            switch (i) {
                                                case 65:
                                                    i3 = MediaPlayer.MEDIA_INFO_PRECISE_PAUSED;
                                                    break;
                                                case 66:
                                                    i3 = MediaPlayer.MEDIA_INFO_ABR_GET_PREDICT;
                                                    break;
                                                case 67:
                                                    i3 = MediaPlayer.MEDIA_INFO_LIVE_VIDEO_RENDER_START;
                                                    break;
                                                default:
                                                    switch (i) {
                                                        case 70:
                                                            i3 = MediaPlayer.MEDIA_INFO_VIDEO_SECOND_FRAME;
                                                            break;
                                                        case 71:
                                                            i3 = MediaPlayer.MEDIA_INFO_LIVE_FIRST_FRAME_AFTER_SURFACE_CHANGE;
                                                            break;
                                                        case 72:
                                                            i3 = MediaPlayer.MEDIA_INFO_FIRST_AVSYNC_FRAME;
                                                            break;
                                                        case 73:
                                                            i3 = MediaPlayer.MEDIA_INFO_REFRESH_SURFACE;
                                                            break;
                                                    }
                                            }
                                    }
                            }
                    }
            }
        } else {
            i3 = MediaPlayer.MEDIA_INFO_INFO_ID_CHANGED;
        }
        this.mOnInfoListener.onInfo(this.mWrapper, i3, i2);
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnLogListener(MediaPlayer.OnLogListener onLogListener) {
        this.mLogListener = onLogListener;
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnBufferingUpdateListener(MediaPlayer.OnBufferingUpdateListener onBufferingUpdateListener) {
        this.mOnBufferingUpdateListener = onBufferingUpdateListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(3L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
        this.mOnCompletionListener = onCompletionListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(13L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnErrorListener(MediaPlayer.OnErrorListener onErrorListener) {
        this.mOnErrorListener = onErrorListener;
        long[] jArr = {0, 45};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 2; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnInfoListener(MediaPlayer.OnInfoListener onInfoListener) {
        this.mOnInfoListener = onInfoListener;
        long[] jArr = {1, 4, 5, 7, 8, 9, 10, 21, 22, 20, 24, 25, 26, 28, 27, 29, 32, 34, 35, 36, 37, 38, 39, 41, 42, 50, 49, 47, 51, 52, 53, 54, 30, 57, 58, 61, 62, 65, 66, 67, 70, 71, 72, 73, 82, 84};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 46; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnExternInfoListener(MediaPlayer.OnExternInfoListener onExternInfoListener) {
        this.mOnExternInfoListener = onExternInfoListener;
        long[] jArr = {63, 59, 19, 33, 40, 43, 44, 68, 85};
        this.mReadLock.lock();
        try {
            if (isValid()) {
                for (int i = 0; i < 9; i++) {
                    this.mPlayer.setNotifyState(jArr[i]);
                }
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setFrameMetadataListener(frameMetadataListener);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setStrategyParamsTransport(StrategyParamsTransport strategyParamsTransport) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setStrategyParamsTransport(strategyParamsTransport);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnPreparedListener(MediaPlayer.OnPreparedListener onPreparedListener) {
        this.mOnPreparedListener = onPreparedListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(2L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSeekCompleteListener(MediaPlayer.OnSeekCompleteListener onSeekCompleteListener) {
        this.mOnSeekCompleteListener = onSeekCompleteListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(12L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnVideoSizeChangedListener(MediaPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.mOnVideoSizeChangedListener = onVideoSizeChangedListener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(6L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnSARChangedListener(MediaPlayer.onSARChangedListener onsarchangedlistener) {
        this.mOnSARChangedListener = onsarchangedlistener;
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setNotifyState(23L);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setLoadControl(LoadControl loadControl) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setLoadControl(loadControl);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMaskInfo(MaskInfo maskInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setMaskInfo(maskInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAIBarrageInfo(MaskInfo maskInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setAIBarrageInfo(maskInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public String getSubtitleContent(int i) {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getSubtitleContent(i) : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setSubInfo(SubInfo subInfo) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSubInfo(subInfo);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setMediaTransport(MediaTransport mediaTransport) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setMediaTransport(mediaTransport);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setAudioProcessor(audioProcessor);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setABRStrategy(ABRStrategy aBRStrategy) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setABRStrategy(aBRStrategy);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setTraitObject(int i, TraitObject traitObject) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setTraitObject(i, traitObject);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setupMediaCodec() {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setupMediaCodec();
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    protected void onPlayLogInfo(int i, int i2, String str) {
        if (i == 2) {
            if (i2 == 1) {
                this.mVoiceInfo = str;
                return;
            } else {
                if (i2 == 0) {
                    this.mBufferingInfo = str;
                    return;
                }
                return;
            }
        }
        if (i == 0) {
            this.mErrorCode = i2;
        }
        if (str != null) {
            if (this.mLogInfo.size() > 40) {
                this.mLogInfo.removeFirst();
            }
            this.mLogInfo.addLast(String.format(Locale.US, "%s&&time:%d", str, Long.valueOf(System.currentTimeMillis())));
        }
    }

    private void sendSeekCompleted(int i) {
        MediaPlayer.OnSeekCompleteListener onSeekCompleteListener;
        if (this.mSeekComplete || (onSeekCompleteListener = this.mOnSeekCompleteListener) == null) {
            return;
        }
        this.mSeekComplete = true;
        if (i >= this.mPlayLifeId) {
            onSeekCompleteListener.onSeekComplete(this.mWrapper);
        }
    }

    private void sendCompletioned(int i) {
        try {
            this.mReentrantLock.lock();
            MediaPlayer.OnCompletionListener onCompletionListener = this.mOnCompletionListener;
            if (onCompletionListener != null && i >= this.mPlayLifeId) {
                onCompletionListener.onCompletion(this.mWrapper);
            }
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    private void sendErrorInfo(int i, int i2) {
        try {
            this.mReentrantLock.lock();
            MediaPlayer.OnErrorListener onErrorListener = this.mOnErrorListener;
            if (onErrorListener != null && i2 >= this.mPlayLifeId) {
                int i3 = this.mErrorCode;
                if (i3 != 0) {
                    i = i3;
                } else if (i == 0) {
                    i = -1048575;
                }
                onErrorListener.onError(this.mWrapper, i, 0);
            }
        } finally {
            if (this.mReentrantLock.isLocked()) {
                this.mReentrantLock.unlock();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 3) {
            AVLogger.d(TAG, "handleMessage send message prev.thread id:" + Thread.currentThread().getId());
        }
        handleNotify(message.arg2, message.what, message.arg1, message.obj instanceof String ? (String) message.obj : null);
        if (message.what == 3) {
            return true;
        }
        AVLogger.d(TAG, "handleMessage send message after.thread id:" + Thread.currentThread().getId());
        return true;
    }

    public void onPlayerNotify(int i, int i2, int i3, String str) {
        if (i2 != 3) {
            AVLogger.d(TAG, "onPlayerNotify send message start .thread id:" + Thread.currentThread().getId());
        }
        synchronized (this.mHandlerLocker) {
            if (this.mHandler == null) {
                AVLogger.d(TAG, "onPlayerNotify send message play is null:thread id" + Thread.currentThread().getId());
                return;
            }
            if (i2 == 40 && str != null) {
                handleNotify(i, i2, i3, str);
                return;
            }
            if (i2 != 3) {
                AVLogger.d(TAG, "onPlayerNotify send message prev.thread id:" + Thread.currentThread().getId());
            }
            Message messageObtainMessage = this.mHandler.obtainMessage(i2, i3, i);
            messageObtainMessage.obj = str;
            messageObtainMessage.sendToTarget();
            if (i2 != 3) {
                AVLogger.d(TAG, "onPlayerNotify send message after.thread id:" + Thread.currentThread().getId());
            }
        }
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceCreated(SurfaceHolder surfaceHolder) {
        AVLogger.d(TAG, "onSurfaceCreated");
        this.mSurfaceHolder = surfaceHolder;
        if (this.mRealsedSurface || this.mIgnoreSurfaceCreated == 1) {
            return;
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                SurfaceHolder surfaceHolder2 = this.mSurfaceHolder;
                if (surfaceHolder != surfaceHolder2) {
                    if (surfaceHolder2 != null) {
                        surfaceHolder2.removeCallback(this.mCallback);
                    }
                    this.mSurfaceHolder = surfaceHolder;
                    if (surfaceHolder != null) {
                        surfaceHolder.addCallback(this.mCallback);
                    }
                }
                this.mPlayer.setSurfaceTimeOut(surfaceHolder.getSurface(), 0);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceChanged(SurfaceHolder surfaceHolder) {
        AVLogger.d(TAG, "surface is change");
    }

    @Override // com.ss.ttm.player.ISurfaceListener
    public void onSurfaceDestroyed(SurfaceHolder surfaceHolder) throws ExecutionException, IllegalAccessException, InterruptedException, TimeoutException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        String str = TAG;
        AVLogger.d(str, "surface is destory");
        if (this.mRealsedSurface) {
            AVLogger.d(str, "TTIPMediaPlayer player is will release");
            return;
        }
        if (this.mMediaCodecStopTimeOutMs > 0) {
            try {
                AVThreadPool.addTask(new Callable<String>() { // from class: com.ss.ttm.player.TTPlayerClient.2
                    @Override // java.util.concurrent.Callable
                    public String call() throws IllegalAccessException, InterruptedException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
                        try {
                            TTPlayerClient.this.mReadLock.lockInterruptibly();
                            try {
                                if (TTPlayerClient.this.isValid()) {
                                    TTPlayerClient.this.mPlayer.setSurfaceTimeOut(null, 0);
                                }
                                TTPlayerClient.this.mReadLock.unlock();
                                return ca.k;
                            } catch (Throwable th) {
                                TTPlayerClient.this.mReadLock.unlock();
                                throw th;
                            }
                        } catch (InterruptedException unused) {
                            AVLogger.Error(TTPlayerClient.TAG, this, "mPlayer setsurface null failed.");
                            return ca.k;
                        }
                    }
                }).get(this.mMediaCodecStopTimeOutMs, TimeUnit.MILLISECONDS);
                return;
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                AVLogger.Error(TAG, this, "set surface time out");
                return;
            }
        }
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setSurfaceTimeOut(null, 0);
            }
            this.mReadLock.unlock();
            AVLogger.d(str, "TTIPMediaPlayer player set surface");
        } catch (Throwable th) {
            this.mReadLock.unlock();
            throw th;
        }
    }

    private String getPlayerCrashedInfo() throws Throwable {
        Context context;
        String crashFileContext;
        String crashFileContext2;
        int value = TTPlayerConfiger.getValue(18, 1);
        StringBuilder sb = new StringBuilder();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef == null) {
            context = this.mContext;
        } else {
            context = iTTPlayerRef.getContext();
        }
        if (context == null) {
            return "context is null";
        }
        if (value > 1) {
            String strExistsCrashFilePath = TTCrashUtil.existsCrashFilePath(context);
            if (strExistsCrashFilePath != null && (crashFileContext2 = TTCrashUtil.getCrashFileContext(context, strExistsCrashFilePath, sb)) != null) {
                TTCrashUtil.deleteCrashFile(this.mContext, strExistsCrashFilePath);
                this.mCrashType = 1;
                if (TTPlayerConfiger.getValue(5, false)) {
                    AVLogger.d(TAG, "<TTPlayerIPClient,getCrashedInfo>find breakpad file");
                }
                return crashFileContext2;
            }
            AVErrorInfo.setupPhoneInfo(context, sb);
        }
        String value2 = TTPlayerConfiger.getValue(19, (String) null);
        if (value2 != null && (crashFileContext = TTCrashUtil.getCrashFileContext(this.mContext, value2, sb)) != null) {
            TTCrashUtil.deleteCrashFile(this.mContext, value2);
            this.mCrashType = 1;
            if (TTPlayerConfiger.getValue(5, false)) {
                AVLogger.d(TAG, "<TTPlayerIPClient,getCrashedInfo>find breakpad file");
            }
            return crashFileContext;
        }
        sb.append("\ncreate time:" + AVTime.getFormatNow());
        sb.append("\nport version:").append(value);
        sb.append("\nstart service info:").append(TTPlayerConfiger.getValue(16, "not find service start info"));
        sb.append("\nstop service info:").append(TTPlayerConfiger.getValue(12, "not find service stop info"));
        sb.append("\ncrash:").append(TTPlayerConfiger.getValue(7, false));
        sb.append("\nsdk info:").append(TTPlayerConfiger.getValue(15, "not find sdk info"));
        sb.append("\ntimeout count:").append(TTPlayerConfiger.getValue(10, -1));
        sb.append("\nforeground:").append(TTPlayerConfiger.getValue(21, -1));
        sb.append("\non screen:").append(TTPlayerConfiger.getValue(22, -1));
        sb.append("\n battery info:").append(TTPlayerConfiger.getValue(23, "not find"));
        sb.append("\nurl:").append(this.mUri);
        sb.append("\ncrash:\r\n").append((CharSequence) this.mCrashedInfo);
        this.mCrashType = 0;
        if (value > 1) {
            if (TTPlayerConfiger.getValue(5, false)) {
                AVLogger.d(TAG, "<TTPlayerIPClient,getCrashedInfo>" + sb.toString());
            }
            return TTCrashUtil.getBase64SampleCrash(sb.toString());
        }
        return sb.toString();
    }

    protected void onCrashedInfo(String str) {
        if (this.mCrashedInfo.length() < 1024) {
            this.mCrashedInfo.append(str).append("\n");
        }
    }

    private String getPlayerErrorInfo() throws Throwable {
        try {
            StringBuilder sb = new StringBuilder();
            LinkedList<String> linkedList = this.mLogInfo;
            if ((linkedList != null && linkedList.size() > 0) || this.mBufferingInfo != null || this.mVoiceInfo != null) {
                AVErrorInfo.setupErrorInfo(this.mContext, sb, "error", "play error", this.mUri);
                Iterator<String> it = this.mLogInfo.iterator();
                while (it.hasNext()) {
                    sb.append(it.next()).append("\n");
                }
                String str = this.mBufferingInfo;
                if (str != null) {
                    sb.append(str).append("\n");
                    this.mBufferingInfo = null;
                }
                String str2 = this.mVoiceInfo;
                if (str2 != null) {
                    sb.append(str2).append("\n");
                    this.mVoiceInfo = null;
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public int getType() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getType() : 0;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setPlaybackParams(PlaybackParams playbackParams) {
        this.mReadLock.lock();
        try {
            if (isValid() && playbackParams != null && playbackParams.getSpeed() != -1.0f) {
                this.mPlayer.setFloatOption(60, playbackParams.getSpeed());
            }
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void selectTrack(int i) {
        this.mReadLock.lock();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef != null && i == 0) {
            iTTPlayerRef.setIntOption(261, 0);
        }
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void deselectTrack(int i) {
        this.mReadLock.lock();
        ITTPlayerRef iTTPlayerRef = this.mPlayer;
        if (iTTPlayerRef != null && i == 0) {
            iTTPlayerRef.setIntOption(261, 1);
        } else if (iTTPlayerRef != null) {
            iTTPlayerRef.setIntOption(65, (i << 8) | 0);
        }
        this.mReadLock.unlock();
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public MediaPlayer.TrackInfo[] getTrackInfo() {
        this.mReadLock.lock();
        try {
            return isValid() ? this.mPlayer.getTrackInfo() : null;
        } finally {
            this.mReadLock.unlock();
        }
    }

    @Override // com.ss.ttm.player.MediaPlayerClient
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        this.mReadLock.lock();
        try {
            if (isValid()) {
                this.mPlayer.setOnImageAvailableListener(onImageAvailableListener, handler);
            }
        } finally {
            this.mReadLock.unlock();
        }
    }
}
