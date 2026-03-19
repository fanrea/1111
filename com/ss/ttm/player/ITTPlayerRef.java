package com.ss.ttm.player;

import android.content.Context;
import android.media.ImageReader;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import com.ss.ttm.player.MediaPlayer;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class ITTPlayerRef {
    protected abstract void close();

    protected abstract Context getContext();

    protected abstract double getDoubleOption(int i, double d);

    protected abstract float getFloatOption(int i, float f);

    protected abstract int getIntOption(int i, int i2);

    protected abstract int getLifeId();

    protected abstract long getLongOption(int i, long j);

    protected abstract Object getObjectOption(int i);

    protected abstract String getStringOption(int i);

    protected abstract String getSubtitleContent(int i);

    protected abstract MediaPlayer.TrackInfo[] getTrackInfo();

    protected abstract int getType();

    protected void invalid() {
    }

    protected abstract boolean isValid();

    protected abstract void mouseEvent(int i, int i2, int i3);

    protected abstract void pause();

    protected abstract void prepare();

    protected abstract void prevClose();

    protected abstract void release();

    protected abstract void reset();

    protected abstract void rotateCamera(float f, float f2);

    protected abstract void seekTo(int i);

    protected abstract void seekTo(int i, int i2);

    protected abstract void setABRStrategy(ABRStrategy aBRStrategy);

    protected abstract void setAIBarrageInfo(MaskInfo maskInfo);

    protected abstract void setAudioProcessor(AudioProcessor audioProcessor);

    protected abstract void setCacheFile(String str, int i);

    protected abstract void setDataSource(IMediaDataSource iMediaDataSource);

    protected abstract void setDataSource(String str);

    protected abstract void setDataSourceFd(int i);

    protected abstract int setDoubleOption(int i, double d);

    protected abstract int setFloatOption(int i, float f);

    public int setFloatOptionArray(int[] iArr, float[] fArr) {
        return -1;
    }

    protected abstract void setFrameMetadataListener(FrameMetadataListener frameMetadataListener);

    protected abstract int setIntOption(int i, int i2);

    public int setIntOptionArray(int[] iArr, int[] iArr2) {
        return -1;
    }

    protected abstract void setLoadControl(LoadControl loadControl);

    protected abstract int setLongOption(int i, long j);

    public int setLongOptionArray(int[] iArr, long[] jArr) {
        return -1;
    }

    protected abstract void setLooping(int i);

    protected abstract void setMaskInfo(MaskInfo maskInfo);

    protected abstract void setMediaTransport(MediaTransport mediaTransport);

    protected abstract void setNotifyState(long j);

    protected abstract void setOnImageAvailableListener(ImageReader.OnImageAvailableListener onImageAvailableListener, Handler handler);

    protected abstract void setOnScreenshotListener(MediaPlayer.OnScreenshotListener onScreenshotListener);

    protected abstract void setStrategyParamsTransport(StrategyParamsTransport strategyParamsTransport);

    protected abstract int setStringOption(int i, String str);

    public int setStringOptionArray(int[] iArr, String[] strArr) {
        return -1;
    }

    protected abstract void setSubInfo(SubInfo subInfo);

    @Deprecated
    protected abstract void setSurface(Surface surface);

    protected abstract void setSurfaceTimeOut(Surface surface, int i);

    protected abstract void setTraitObject(int i, TraitObject traitObject);

    protected abstract void setVolume(float f, float f2);

    protected abstract void setupMediaCodec();

    protected abstract void start();

    protected abstract void stop();

    protected abstract void switchStream(int i, int i2);

    protected abstract void takeScreenshot();

    public static synchronized ITTPlayerRef create(Context context, TTPlayerClient tTPlayerClient, HashMap<Integer, Integer> map) {
        TTPlayerRef tTPlayerRefCreate;
        Integer num = 0;
        Integer.valueOf(0);
        tTPlayerRefCreate = TTPlayerRef.create(tTPlayerClient, context, (map == null || map.get(33) == null) ? 1 : map.get(33).intValue(), (map == null || map.get(43) == null) ? 0 : map.get(43).intValue());
        if (tTPlayerRefCreate != null && TTPlayerConfiger.isPrintInfo()) {
            Log.i("ttplayer", "---------->ttplayer on<------------");
        }
        if (tTPlayerRefCreate == null) {
            Log.i("ttplayer", TTPlayerConfiger.getValue(16, "not find start service info."));
            if (map != null) {
                num = map.get(100);
            }
            if (map != null && num != null && num.intValue() == 1) {
                if (map.get(7).intValue() == 0 && map.get(10).intValue() < 3) {
                    map.put(7, 1);
                }
            } else if (!TTPlayerConfiger.getValue(7, false) && TTPlayerConfiger.getValue(10, 0) < 3) {
                TTPlayerConfiger.setValue(7, true);
            }
        }
        return tTPlayerRefCreate;
    }

    public static void setGlobalIntOptionForKey(int i, int i2) {
        TTPlayerRef.setGlobalIntOptionForKey(i, i2);
    }
}
