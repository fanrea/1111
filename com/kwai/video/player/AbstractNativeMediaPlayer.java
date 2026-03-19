package com.kwai.video.player;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.kwai.video.player.IMediaPlayer;
import com.kwai.video.player.KsMediaPlayer;
import com.kwai.video.player.surface.DummySurface;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class AbstractNativeMediaPlayer extends AbstractMediaPlayer {
    private static final String TAG;
    private Surface mDummySurface;
    private EventHandler mEventHandler;
    private int mListenerContext;
    private long mNativeMediaDataSource;
    protected long mNativeMediaPlayer;
    private int mNativeSurfaceTexture;
    OnMediaCodecSelectListener mOnMediaCodecSelectListener;
    protected IMediaPlayer.OnLiveEventListener mOnLiveEventListener = null;
    protected KsMediaPlayer.OnAudioProcessPCMListener mOnAudioProcessPCMListener = null;
    protected IMediaPlayer.OnVideoRawDataListener mOnVideoRawDataListener = null;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public interface OnMediaCodecSelectListener {
        String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2);
    }

    protected abstract void enableVideoRawDataCallback(boolean z);

    protected abstract void initProcessPCMBuffer();

    protected abstract void onReceivePostEvent(Message message);

    static {
        KsMediaPlayerInitConfig.waitSoLibReady();
        TAG = AbstractNativeMediaPlayer.class.getName();
    }

    protected void initPlayer() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            this.mEventHandler = new EventHandler(this, looperMyLooper);
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            this.mEventHandler = new EventHandler(this, mainLooper);
        } else {
            this.mEventHandler = null;
        }
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void reset() {
        this.mEventHandler.removeCallbacksAndMessages(null);
    }

    private static void postEventFromNative(Object obj, int i, int i2, int i3, Object obj2) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        if (obj == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get()) == null) {
            return;
        }
        if (i == 200 && i2 == 2) {
            abstractNativeMediaPlayer.start();
        }
        EventHandler eventHandler = abstractNativeMediaPlayer.mEventHandler;
        if (eventHandler != null) {
            abstractNativeMediaPlayer.mEventHandler.sendMessage(eventHandler.obtainMessage(i, i2, i3, obj2));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class EventHandler extends Handler {
        private final WeakReference<AbstractNativeMediaPlayer> mWeakPlayer;

        EventHandler(AbstractNativeMediaPlayer abstractNativeMediaPlayer, Looper looper) {
            super(looper);
            this.mWeakPlayer = new WeakReference<>(abstractNativeMediaPlayer);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AbstractNativeMediaPlayer abstractNativeMediaPlayer = this.mWeakPlayer.get();
            if (abstractNativeMediaPlayer == null || abstractNativeMediaPlayer.mNativeMediaPlayer == 0) {
                Log.w("NativeMediaPlayer", "AbstractNativeMediaPlayer went away with unhandled events");
            } else {
                abstractNativeMediaPlayer.onReceivePostEvent(message);
            }
        }
    }

    @Override // com.kwai.video.player.AbstractMediaPlayer
    protected void resetListeners() {
        super.resetListeners();
        this.mOnLiveEventListener = null;
        this.mOnAudioProcessPCMListener = null;
        this.mOnVideoRawDataListener = null;
        this.mOnMediaCodecSelectListener = null;
    }

    public void setOnLiveEventListener(IMediaPlayer.OnLiveEventListener onLiveEventListener) {
        this.mOnLiveEventListener = onLiveEventListener;
    }

    private static void onLiveEventCallback(Object obj, byte[] bArr) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnLiveEventListener onLiveEventListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onLiveEventListener = abstractNativeMediaPlayer.mOnLiveEventListener) == null) {
            return;
        }
        onLiveEventListener.onLiveEventChange(bArr);
    }

    private static void postFftDataNative(Object obj, float[] fArr) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
            return;
        }
        abstractNativeMediaPlayer.notifyOnFftDataCapture(fArr);
    }

    public void setOnAudioProcessPCMAvailableListener(KsMediaPlayer.OnAudioProcessPCMListener onAudioProcessPCMListener) {
        this.mOnAudioProcessPCMListener = onAudioProcessPCMListener;
        initProcessPCMBuffer();
    }

    private static void onAudioProcessPCMReady(Object obj, ByteBuffer byteBuffer, long j, int i, int i2, int i3) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        KsMediaPlayer.OnAudioProcessPCMListener onAudioProcessPCMListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onAudioProcessPCMListener = abstractNativeMediaPlayer.mOnAudioProcessPCMListener) == null) {
            return;
        }
        onAudioProcessPCMListener.onAudioProcessPCMAvailable(abstractNativeMediaPlayer, byteBuffer, j, i2, i, i3);
    }

    @Override // com.kwai.video.player.IMediaPlayer
    public void setVideoRawDataListener(IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener) {
        this.mOnVideoRawDataListener = onVideoRawDataListener;
        if (onVideoRawDataListener == null) {
            enableVideoRawDataCallback(false);
        } else {
            enableVideoRawDataCallback(true);
        }
    }

    private static Surface getDummySurface(Object obj) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null) {
            return null;
        }
        DummySurface dummySurfaceNewInstanceV17 = DummySurface.newInstanceV17(null, false);
        abstractNativeMediaPlayer.mDummySurface = dummySurfaceNewInstanceV17;
        return dummySurfaceNewInstanceV17;
    }

    private static void releaseDummySurface(Object obj) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        Surface surface;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (surface = abstractNativeMediaPlayer.mDummySurface) == null) {
            return;
        }
        surface.release();
        abstractNativeMediaPlayer.mDummySurface = null;
    }

    private static void onVideoRawDataReady(Object obj, byte[] bArr, int i, int i2, int i3, int i4) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onVideoRawDataListener = abstractNativeMediaPlayer.mOnVideoRawDataListener) == null) {
            return;
        }
        onVideoRawDataListener.onVideoRawDataAvailable(abstractNativeMediaPlayer, bArr, i, i2, i3, i4);
    }

    private static void onVideoRawDataSize(Object obj, int i, int i2, int i3, int i4) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        IMediaPlayer.OnVideoRawDataListener onVideoRawDataListener;
        WeakReference weakReference = (WeakReference) obj;
        if (weakReference == null || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) weakReference.get()) == null || (onVideoRawDataListener = abstractNativeMediaPlayer.mOnVideoRawDataListener) == null) {
            return;
        }
        onVideoRawDataListener.onVideoRawDataSize(abstractNativeMediaPlayer, i, i2, i3, i4);
    }

    public void setOnMediaCodecSelectListener(OnMediaCodecSelectListener onMediaCodecSelectListener) {
        this.mOnMediaCodecSelectListener = onMediaCodecSelectListener;
    }

    private static String onSelectCodec(Object obj, String str, int i, int i2) {
        AbstractNativeMediaPlayer abstractNativeMediaPlayer;
        if (obj == null || !(obj instanceof WeakReference) || (abstractNativeMediaPlayer = (AbstractNativeMediaPlayer) ((WeakReference) obj).get()) == null) {
            return null;
        }
        OnMediaCodecSelectListener onMediaCodecSelectListener = abstractNativeMediaPlayer.mOnMediaCodecSelectListener;
        if (onMediaCodecSelectListener == null) {
            onMediaCodecSelectListener = DefaultMediaCodecSelector.sInstance;
        }
        return onMediaCodecSelectListener.onMediaCodecSelect(abstractNativeMediaPlayer, str, i, i2);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
    public static class DefaultMediaCodecSelector implements OnMediaCodecSelectListener {
        public static final DefaultMediaCodecSelector sInstance = new DefaultMediaCodecSelector();

        @Override // com.kwai.video.player.AbstractNativeMediaPlayer.OnMediaCodecSelectListener
        public String onMediaCodecSelect(IMediaPlayer iMediaPlayer, String str, int i, int i2) {
            String[] supportedTypes;
            KsMediaCodecInfo ksMediaCodecInfo;
            if (Build.VERSION.SDK_INT < 16 || TextUtils.isEmpty(str)) {
                return null;
            }
            Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "onSelectCodec: mime=%s, profile=%d, level=%d", str, Integer.valueOf(i), Integer.valueOf(i2)));
            ArrayList arrayList = new ArrayList();
            int codecCount = MediaCodecList.getCodecCount();
            for (int i3 = 0; i3 < codecCount; i3++) {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i3);
                Log.d(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "  found codec: %s", codecInfoAt.getName()));
                if (!codecInfoAt.isEncoder() && (supportedTypes = codecInfoAt.getSupportedTypes()) != null) {
                    for (String str2 : supportedTypes) {
                        if (!TextUtils.isEmpty(str2)) {
                            Log.d(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "    mime: %s", str2));
                            if (str2.equalsIgnoreCase(str) && (ksMediaCodecInfo = KsMediaCodecInfo.setupCandidate(codecInfoAt, str)) != null) {
                                arrayList.add(ksMediaCodecInfo);
                                Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "candidate codec: %s rank=%d", codecInfoAt.getName(), Integer.valueOf(ksMediaCodecInfo.mRank)));
                                ksMediaCodecInfo.dumpProfileLevels(str);
                            }
                        }
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            KsMediaCodecInfo ksMediaCodecInfo2 = (KsMediaCodecInfo) arrayList.get(0);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                KsMediaCodecInfo ksMediaCodecInfo3 = (KsMediaCodecInfo) it.next();
                if (ksMediaCodecInfo3.mRank > ksMediaCodecInfo2.mRank) {
                    ksMediaCodecInfo2 = ksMediaCodecInfo3;
                }
            }
            if (ksMediaCodecInfo2.mRank < 600) {
                Log.w(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "unaccetable codec: %s", ksMediaCodecInfo2.mCodecInfo.getName()));
                return null;
            }
            Log.i(AbstractNativeMediaPlayer.TAG, String.format(Locale.US, "selected codec: %s rank=%d", ksMediaCodecInfo2.mCodecInfo.getName(), Integer.valueOf(ksMediaCodecInfo2.mRank)));
            return ksMediaCodecInfo2.mCodecInfo.getName();
        }
    }
}
