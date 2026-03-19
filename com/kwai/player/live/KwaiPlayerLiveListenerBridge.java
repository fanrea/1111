package com.kwai.player.live;

import com.kwai.video.player.IKwaiMediaPlayer;
import java.lang.ref.WeakReference;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KwaiPlayerLiveListenerBridge {
    private static IKwaiMediaPlayer.OnLiveInterActiveListener getListener(Object obj) {
        if (obj == null) {
            return null;
        }
        return (IKwaiMediaPlayer.OnLiveInterActiveListener) ((WeakReference) obj).get();
    }

    public static void onVideoFrameRender(Object obj, long j) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener = getListener(obj);
        if (listener != null) {
            listener.onVideoFrameRender(j);
        }
    }

    public static void onParseAdSei(Object obj, long j, int i, String str) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener = getListener(obj);
        if (listener != null) {
            listener.onParseAdSei(j, i, str);
        }
    }

    public static void onTsptInfo(Object obj, byte[] bArr, int i) {
        IKwaiMediaPlayer.OnLiveInterActiveListener listener = getListener(obj);
        if (listener != null) {
            listener.onTsptInfo(bArr, i);
        }
    }
}
