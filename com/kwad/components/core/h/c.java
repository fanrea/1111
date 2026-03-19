package com.kwad.components.core.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.kwad.components.core.h.a;
import com.kwad.components.core.video.k;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c implements ImageLoadingListener {
    private b St;
    private a Su;
    private long Sx;
    private long lP;
    private int Sv = 1;
    private int Sw = 16;
    private List<k> Sy = new CopyOnWriteArrayList();

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.Su = aVar;
        aVar.a(new a.InterfaceC0470a() { // from class: com.kwad.components.core.h.c.1
            private boolean Sz = false;
            private boolean SA = false;

            @Override // com.kwad.components.core.h.a.InterfaceC0470a
            public final void D(final long j) {
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onTimerProgress: " + j);
                if (j == 0) {
                    qv();
                }
                c.this.lP = j;
                c.this.b(new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.h.c.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* renamed from: e, reason: merged with bridge method [inline-methods] */
                    public void accept(k kVar) {
                        kVar.onMediaPlayProgress(c.this.Sx, j);
                    }
                });
                if (c.this.lP < c.this.Sx || c.this.Sx <= 0) {
                    return;
                }
                mj();
            }

            private void mj() {
                if (this.Sz) {
                    return;
                }
                c.this.b(new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.h.c.1.2
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(k kVar) {
                        e(kVar);
                    }

                    private static void e(k kVar) {
                        kVar.onMediaPlayCompleted();
                    }
                });
                this.Sz = true;
            }

            private void qv() {
                if (this.SA) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onFirstFrame: ");
                this.SA = true;
                c.this.b(new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.h.c.1.3
                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(k kVar) {
                        e(kVar);
                    }

                    private static void e(k kVar) {
                        kVar.onMediaPlayStart();
                    }
                });
            }
        });
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.St == null) {
            this.St = new b(context);
        }
        return this.St;
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        b bVar = this.St;
        if (bVar != null) {
            bVar.setRadius(f, f2, f3, f4);
        }
    }

    public final void setURLs(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String str = list.get(0);
        b bVar = this.St;
        if (bVar != null) {
            bVar.a(str, this);
        }
    }

    public final void E(long j) {
        this.Sx = j;
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.St;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setVerticalGravity(int i) {
        this.Sw = com.kwad.components.core.b.c.aB(i);
        qu();
    }

    public final void setHorizontalGravity(int i) {
        this.Sw = com.kwad.components.core.b.c.aC(i);
        qu();
    }

    public final void play() {
        a aVar = this.Su;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void pause() {
        a aVar = this.Su;
        if (aVar != null) {
            aVar.pause();
        }
        b(new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.h.c.2
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(k kVar) {
                e(kVar);
            }

            private static void e(k kVar) {
                kVar.onMediaPlayPaused();
            }
        });
    }

    public final void resume() {
        a aVar = this.Su;
        if (aVar != null) {
            aVar.resume();
            b(new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.h.c.3
                @Override // com.kwad.sdk.g.a
                public final /* synthetic */ void accept(k kVar) {
                    e(kVar);
                }

                private static void e(k kVar) {
                    kVar.onMediaPlaying();
                }
            });
        }
    }

    public final void stop() {
        a aVar = this.Su;
        if (aVar != null) {
            aVar.stop();
        }
    }

    public final void skipToEnd() {
        b(new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.h.c.4
            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(k kVar) {
                e(kVar);
            }

            private static void e(k kVar) {
                kVar.onMediaPlayCompleted();
            }
        });
    }

    public final long getPlayDuration() {
        return this.lP;
    }

    public final void c(k kVar) {
        if (kVar != null) {
            this.Sy.add(kVar);
        }
    }

    public final void d(k kVar) {
        if (kVar != null) {
            this.Sy.remove(kVar);
        }
    }

    public final void destroy() {
        this.Sy.clear();
        b bVar = this.St;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.St.getParent()).removeView(this.St);
        }
        this.St = null;
        a aVar = this.Su;
        if (aVar != null) {
            aVar.destroy();
            this.Su = null;
        }
    }

    public final void setSpeed(float f) {
        a aVar = this.Su;
        if (aVar != null) {
            aVar.setSpeed(f);
        }
    }

    private void qu() {
        b bVar = this.St;
        if (bVar != null) {
            bVar.setImageGravity(this.Sv | this.Sw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void b(com.kwad.sdk.g.a<k> aVar) {
        List<k> list;
        if (aVar == null || (list = this.Sy) == null) {
            return;
        }
        Iterator<k> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, final FailReason failReason) {
        b(new com.kwad.sdk.g.a<k>() { // from class: com.kwad.components.core.h.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public void accept(k kVar) {
                kVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    /* renamed from: com.kwad.components.core.h.c$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private static int a(FailReason.FailType failType) {
        int i = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i == 1) {
            return -2;
        }
        if (i == 2) {
            return -3;
        }
        if (i != 3) {
            return i != 4 ? -1 : -5;
        }
        return -4;
    }
}
