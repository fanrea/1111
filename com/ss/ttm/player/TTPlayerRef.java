package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.os.Handler;
import android.os.RemoteException;
import android.view.Surface;
import com.ss.ttm.player.MediaPlayer;
import com.ss.ttm.utils.AVLogger;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TTPlayerRef extends ITTPlayerRef implements IPlayerNotifyer {
    private static final String TAG = "TTPlayerRef";
    private static String mAppPath = null;
    private static String mLoadErr = null;
    private static boolean mLoadSoSuccess = false;
    private TTPlayerClient mClient;
    private Context mContext;
    private long mId = System.currentTimeMillis();
    private TTPlayer mPlayer;

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getType() {
        return 1;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setCacheFile(String str, int i) {
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected boolean isValid() {
        return this.mPlayer != null;
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected int getLifeId() {
        return this.mPlayer.getIntOption(35, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0020 A[Catch: all -> 0x00af, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:9:0x0013, B:12:0x001a, B:13:0x0020, B:15:0x0024, B:17:0x0028, B:18:0x0060, B:23:0x007d, B:28:0x008c, B:29:0x00a6, B:27:0x0088, B:30:0x00a7, B:31:0x00ae, B:24:0x0082, B:19:0x006a), top: B:41:0x0003, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0024 A[Catch: all -> 0x00af, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:9:0x0013, B:12:0x001a, B:13:0x0020, B:15:0x0024, B:17:0x0028, B:18:0x0060, B:23:0x007d, B:28:0x008c, B:29:0x00a6, B:27:0x0088, B:30:0x00a7, B:31:0x00ae, B:24:0x0082, B:19:0x006a), top: B:41:0x0003, inners: #0, #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a7 A[Catch: all -> 0x00af, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:7:0x000d, B:9:0x0013, B:12:0x001a, B:13:0x0020, B:15:0x0024, B:17:0x0028, B:18:0x0060, B:23:0x007d, B:28:0x008c, B:29:0x00a6, B:27:0x0088, B:30:0x00a7, B:31:0x00ae, B:24:0x0082, B:19:0x006a), top: B:41:0x0003, inners: #0, #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final synchronized com.ss.ttm.player.TTPlayerRef create(com.ss.ttm.player.TTPlayerClient r8, android.content.Context r9, int r10, int r11) {
        /*
            java.lang.Class<com.ss.ttm.player.TTPlayerRef> r0 = com.ss.ttm.player.TTPlayerRef.class
            monitor-enter(r0)
            java.lang.String r1 = com.ss.ttm.player.TTPlayerRef.mAppPath     // Catch: java.lang.Throwable -> Laf
            if (r1 != 0) goto L20
            java.lang.String r1 = com.ss.ttm.player.TTPlayerConfiger.getAppFileCachePath(r9)     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayerRef.mAppPath = r1     // Catch: java.lang.Throwable -> Laf
            java.lang.String r1 = com.ss.ttm.player.TTPlayer.getAppPath()     // Catch: java.lang.UnsatisfiedLinkError -> L19 java.lang.Throwable -> Laf
            if (r1 != 0) goto L20
            java.lang.String r1 = com.ss.ttm.player.TTPlayerRef.mAppPath     // Catch: java.lang.UnsatisfiedLinkError -> L19 java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayer.setTempFileDir(r1)     // Catch: java.lang.UnsatisfiedLinkError -> L19 java.lang.Throwable -> Laf
            goto L20
        L19:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayerRef.mLoadErr = r1     // Catch: java.lang.Throwable -> Laf
        L20:
            java.lang.String r1 = com.ss.ttm.player.TTPlayerRef.mLoadErr     // Catch: java.lang.Throwable -> Laf
            if (r1 != 0) goto La7
            boolean r1 = com.ss.ttm.player.TTPlayerRef.mLoadSoSuccess     // Catch: java.lang.Throwable -> Laf
            if (r1 != 0) goto L60
            r1 = 1015(0x3f7, float:1.422E-42)
            r2 = 31
            r3 = 0
            int r2 = com.ss.ttm.player.TTPlayerConfiger.getValue(r2, r3)     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayer.setGlobalIntOptionForKey(r1, r2)     // Catch: java.lang.Throwable -> Laf
            r1 = 1016(0x3f8, float:1.424E-42)
            r2 = 32
            int r2 = com.ss.ttm.player.TTPlayerConfiger.getValue(r2, r3)     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayer.setGlobalIntOptionForKey(r1, r2)     // Catch: java.lang.Throwable -> Laf
            r1 = 1356(0x54c, float:1.9E-42)
            r2 = 44
            int r2 = com.ss.ttm.player.TTPlayerConfiger.getValue(r2, r3)     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayer.setGlobalIntOptionForKey(r1, r2)     // Catch: java.lang.Throwable -> Laf
            r1 = 1357(0x54d, float:1.902E-42)
            r2 = 45
            int r2 = com.ss.ttm.player.TTPlayerConfiger.getValue(r2, r3)     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayer.setGlobalIntOptionForKey(r1, r2)     // Catch: java.lang.Throwable -> Laf
            r1 = 1358(0x54e, float:1.903E-42)
            r2 = 46
            int r2 = com.ss.ttm.player.TTPlayerConfiger.getValue(r2, r3)     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayer.setGlobalIntOptionForKey(r1, r2)     // Catch: java.lang.Throwable -> Laf
        L60:
            r1 = 1
            com.ss.ttm.player.TTPlayerRef.mLoadSoSuccess = r1     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayerRef r1 = new com.ss.ttm.player.TTPlayerRef     // Catch: java.lang.Throwable -> Laf
            r1.<init>(r9)     // Catch: java.lang.Throwable -> Laf
            r1.mClient = r8     // Catch: java.lang.Throwable -> Laf
            com.ss.ttm.player.TTPlayer r8 = new com.ss.ttm.player.TTPlayer     // Catch: java.lang.Throwable -> L7c
            long r4 = r1.mId     // Catch: java.lang.Throwable -> L7c
            r2 = r8
            r3 = r9
            r6 = r10
            r7 = r11
            r2.<init>(r3, r4, r6, r7)     // Catch: java.lang.Throwable -> L7c
            r1.mPlayer = r8     // Catch: java.lang.Throwable -> L7c
            r8.setNotifyer(r1)     // Catch: java.lang.Throwable -> L7c
            monitor-exit(r0)
            return r1
        L7c:
            r8 = move-exception
            java.lang.StringBuffer r9 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> Laf
            r9.<init>()     // Catch: java.lang.Throwable -> Laf
            java.lang.String r10 = com.ss.ttm.player.TTPlayerLibraryLoader.getErrorInfo()     // Catch: java.lang.Throwable -> L87
            goto L8c
        L87:
            r10 = move-exception
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Throwable -> Laf
        L8c:
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Laf
            java.lang.StringBuffer r8 = r9.append(r8)     // Catch: java.lang.Throwable -> Laf
            java.lang.String r11 = ",player:"
            java.lang.StringBuffer r8 = r8.append(r11)     // Catch: java.lang.Throwable -> Laf
            r8.append(r10)     // Catch: java.lang.Throwable -> Laf
            java.lang.RuntimeException r8 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> Laf
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> Laf
            r8.<init>(r9)     // Catch: java.lang.Throwable -> Laf
            throw r8     // Catch: java.lang.Throwable -> Laf
        La7:
            java.lang.UnsatisfiedLinkError r8 = new java.lang.UnsatisfiedLinkError     // Catch: java.lang.Throwable -> Laf
            java.lang.String r9 = com.ss.ttm.player.TTPlayerRef.mLoadErr     // Catch: java.lang.Throwable -> Laf
            r8.<init>(r9)     // Catch: java.lang.Throwable -> Laf
            throw r8     // Catch: java.lang.Throwable -> Laf
        Laf:
            r8 = move-exception
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.ttm.player.TTPlayerRef.create(com.ss.ttm.player.TTPlayerClient, android.content.Context, int, int):com.ss.ttm.player.TTPlayerRef");
    }

    public static void setGlobalIntOptionForKey(int i, int i2) {
        if (i == 1015) {
            TTPlayerConfiger.setValue(31, i2);
        } else if (i == 1016) {
            TTPlayerConfiger.setValue(32, i2);
        } else {
            switch (i) {
                case 1356:
                    TTPlayerConfiger.setValue(44, i2);
                    break;
                case 1357:
                    TTPlayerConfiger.setValue(45, i2);
                    break;
                case 1358:
                    TTPlayerConfiger.setValue(46, i2);
                    break;
                case MediaPlayer.MEDIA_PLAYER_OPTION_GS_AUDIOTRACK_POOL_SIZE /* 1359 */:
                    TTPlayerConfiger.setValue(47, i2);
                    break;
            }
        }
        if (mLoadSoSuccess) {
            TTPlayer.setGlobalIntOptionForKey(i, i2);
        }
    }

    public TTPlayerRef(Context context) {
        this.mContext = context;
    }

    public long getNativeObject() {
        return this.mPlayer.getNativePlayer();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prevClose() {
        this.mPlayer.prevClose();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void close() {
        this.mPlayer.close();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void release() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        TTPlayer tTPlayer = this.mPlayer;
        this.mPlayer = null;
        String str = TAG;
        AVLogger.d(str, "release native player start");
        tTPlayer.release();
        AVLogger.d(str, "release native player end");
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void start() {
        this.mPlayer.start();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void pause() {
        this.mPlayer.pause();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void reset() {
        this.mPlayer.reset();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void stop() {
        this.mPlayer.stop();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void prepare() {
        this.mPlayer.prepare();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setDataSource(String str) {
        this.mPlayer.setDataSource(str);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setDataSourceFd(int i) {
        this.mPlayer.setDataSourceFd(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setDataSource(IMediaDataSource iMediaDataSource) throws IllegalStateException, SecurityException, IllegalArgumentException {
        this.mPlayer.setDataSource(iMediaDataSource);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setLooping(int i) {
        this.mPlayer.setLooping(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setVolume(float f, float f2) {
        this.mPlayer.setVolume(f, f2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void mouseEvent(int i, int i2, int i3) {
        this.mPlayer.mouseEvent(i, i2, i3);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void rotateCamera(float f, float f2) {
        this.mPlayer.rotateCamera(f, f2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int i) {
        this.mPlayer.seekTo(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void seekTo(int i, int i2) {
        this.mPlayer.seekTo(i, i2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int getIntOption(int i, int i2) {
        return this.mPlayer.getIntOption(i, i2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurface(Surface surface) {
        this.mPlayer.setVideoSurface(surface);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setSurfaceTimeOut(Surface surface, int i) {
        this.mPlayer.setVideoSurfaceTimeOut(surface, i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setNotifyState(long j) {
        this.mPlayer.setNotifyerState(j);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOption(int i, int i2) {
        try {
            return this.mPlayer.setIntOption(i, i2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOption(int i, String str) {
        return this.mPlayer.setStringOption(i, str);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getStringOption(int i) {
        return this.mPlayer.getStringOption(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public String getSubtitleContent(int i) {
        return this.mPlayer.getSubtitleContent(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOption(int i, long j) {
        return this.mPlayer.setLongOption(i, j);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public long getLongOption(int i, long j) {
        return this.mPlayer.getLongOption(i, j);
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handlePlayerNotify(long j, int i, int i2, int i3, String str) {
        this.mClient.onPlayerNotify(i, i2, i3, str);
    }

    @Override // com.ss.ttm.player.IPlayerNotifyer
    public void handleErrorNotify(long j, int i, int i2, String str) {
        this.mClient.onPlayLogInfo(i, i2, str);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void takeScreenshot() {
        this.mPlayer.takeScreenshot();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener) {
        this.mPlayer.setOnScreenshotListener(onScreenshotListener);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void switchStream(int i, int i2) {
        this.mPlayer.switchStream(i, i2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setLoadControl(LoadControl loadControl) {
        this.mPlayer.setLoadControl(loadControl);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setMaskInfo(MaskInfo maskInfo) {
        this.mPlayer.setMaskInfo(maskInfo);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setAIBarrageInfo(MaskInfo maskInfo) {
        this.mPlayer.setAIBarrageInfo(maskInfo);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setSubInfo(SubInfo subInfo) {
        this.mPlayer.setSubInfo(subInfo);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setABRStrategy(ABRStrategy aBRStrategy) {
        this.mPlayer.setABRStrategy(aBRStrategy);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setTraitObject(int i, TraitObject traitObject) {
        this.mPlayer.setTraitObject(i, traitObject);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setFrameMetadataListener(FrameMetadataListener frameMetadataListener) {
        this.mPlayer.setFrameMetadataListener(frameMetadataListener);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setStrategyParamsTransport(StrategyParamsTransport strategyParamsTransport) {
        this.mPlayer.setStrategyParamsTransport(strategyParamsTransport);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setMediaTransport(MediaTransport mediaTransport) {
        this.mPlayer.setMediaTransport(mediaTransport);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setAudioProcessor(AudioProcessor audioProcessor) {
        this.mPlayer.setAudioProcessor(audioProcessor);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected int setFloatOption(int i, float f) {
        return this.mPlayer.setFloatOption(i, f);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected int setDoubleOption(int i, double d) {
        return this.mPlayer.setDoubleOption(i, d);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected float getFloatOption(int i, float f) {
        return this.mPlayer.getFloatOption(i, f);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected double getDoubleOption(int i, double d) {
        return this.mPlayer.getDoubleOption(i, d);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected void setupMediaCodec() {
        this.mPlayer.setupMediaCodec();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected Object getObjectOption(int i) {
        return this.mPlayer.getObjectValue(i);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    protected MediaPlayer.TrackInfo[] getTrackInfo() {
        return this.mPlayer.getTrackInfo();
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setIntOptionArray(int[] iArr, int[] iArr2) {
        return this.mPlayer.setIntOptionArray(iArr, iArr2);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setLongOptionArray(int[] iArr, long[] jArr) {
        return this.mPlayer.setLongOptionArray(iArr, jArr);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setFloatOptionArray(int[] iArr, float[] fArr) {
        return this.mPlayer.setFloatOptionArray(iArr, fArr);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public int setStringOptionArray(int[] iArr, String[] strArr) {
        return this.mPlayer.setStringOptionArray(iArr, strArr);
    }

    @Override // com.ss.ttm.player.ITTPlayerRef
    public void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler) {
        this.mPlayer.setOnImageAvailableListener(onImageAvailableListener, handler);
    }
}
