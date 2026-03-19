package com.kwad.sdk.core.video.a;

import android.content.Context;
import android.media.TimedText;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.io.FileDescriptor;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface c {

    public interface a {
        void aQ(int i);
    }

    public interface b {
        void qY();
    }

    /* renamed from: com.kwad.sdk.core.video.a.c$c, reason: collision with other inner class name */
    public interface InterfaceC0592c {
        boolean n(int i, int i2);
    }

    public interface d {
        boolean o(int i, int i2);
    }

    public interface e {
        void a(c cVar);
    }

    public interface f {
        void ua();
    }

    public interface g {
        void qZ();
    }

    public interface h {
        void a(TimedText timedText);
    }

    public interface i {
        void m(int i, int i2);
    }

    void a(com.kwad.sdk.contentalliance.a.a.b bVar);

    void a(a aVar);

    void a(b bVar);

    void a(InterfaceC0592c interfaceC0592c);

    void a(f fVar);

    void a(g gVar);

    void a(h hVar);

    void a(i iVar);

    void b(e eVar);

    void c(d dVar);

    int getAudioSessionId();

    String getCurrentPlayingUrl();

    long getCurrentPosition();

    String getDataSource();

    long getDuration();

    int getMediaPlayerType();

    int getVideoHeight();

    int getVideoWidth();

    boolean isLooping();

    boolean isPlaying();

    void pause();

    boolean prepareAsync();

    void release();

    void reset();

    void seekTo(long j);

    void setAudioStreamType(int i2);

    void setDataSource(Context context, Uri uri);

    void setDataSource(Context context, Uri uri, Map<String, String> map);

    void setDataSource(FileDescriptor fileDescriptor);

    void setDataSource(String str);

    void setDisplay(SurfaceHolder surfaceHolder);

    void setLooping(boolean z);

    void setScreenOnWhilePlaying(boolean z);

    void setSpeed(float f2);

    void setSurface(Surface surface);

    void setVolume(float f2, float f3);

    void start();

    void stop();

    boolean uv();
}
