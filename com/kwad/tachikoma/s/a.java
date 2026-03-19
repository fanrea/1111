package com.kwad.tachikoma.s;

import android.content.Context;
import android.media.SoundPool;
import android.os.Build;
import android.os.Vibrator;
import android.view.OrientationEventListener;
import com.kuaishou.tk.api.TKContext;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.tachikoma.g.b;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private Map<Integer, g> EH;
    private Map<String, String> EI;
    private TKContext EJ;
    private File EK;
    private SoundPool EL;
    private Vibrator EM;
    private OrientationEventListener EN;
    private g EO;
    private boolean mHasInit;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.EH = new HashMap();
    }

    public final void a(TKContext tKContext, String str) {
        if (this.mHasInit) {
            return;
        }
        this.EJ = tKContext;
        this.EK = new File(str);
        this.mHasInit = true;
    }

    public final void f(String str, V8Function v8Function) {
        g gVar = new g(v8Function, this.EJ.getContext());
        if (str.startsWith(com.alipay.sdk.m.l.a.r)) {
            OfflineHostProvider.getApi().async().execute(new AnonymousClass1(str, gVar));
        } else {
            a(new File(this.EK, str), gVar);
        }
    }

    /* renamed from: com.kwad.tachikoma.s.a$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ g BI;
        final /* synthetic */ String EP;

        AnonymousClass1(String str, g gVar) {
            this.EP = str;
            this.BI = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.kwad.tachikoma.g.b.il().a(a.this.EJ.getContext().getContext(), this.EP, new b.a() { // from class: com.kwad.tachikoma.s.a.1.1
                @Override // com.kwad.tachikoma.g.b.a
                public final void onSuccess(final String str) {
                    OfflineHostProvider.getApi().async().runOnUiThread(new Runnable() { // from class: com.kwad.tachikoma.s.a.1.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a(new File(str), AnonymousClass1.this.BI);
                        }
                    });
                }

                @Override // com.kwad.tachikoma.g.b.a
                public final void im() {
                    OfflineHostProvider.getApi().async().runOnUiThread(new Runnable() { // from class: com.kwad.tachikoma.s.a.1.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            a.this.a((File) null, AnonymousClass1.this.BI);
                        }
                    });
                }
            });
        }
    }

    public final int co(int i) {
        return iZ().play(i, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public final void cp(int i) {
        iZ().unload(i);
    }

    public final void cq(int i) {
        OfflineHostProvider.getApi().vibratorUtil().vibrate(this.EJ.getContext().getContext(), getVibrator(), i);
    }

    public final void iV() {
        OfflineHostProvider.getApi().vibratorUtil().cancelVibrate(this.EJ.getContext().getContext(), getVibrator());
    }

    public final void x(V8Function v8Function) {
        this.EO = new g(v8Function, pO());
        ja();
    }

    public final void iW() {
        jb();
        g gVar = this.EO;
        if (gVar != null) {
            gVar.destroy();
            this.EO = null;
        }
    }

    public static int iX() {
        return OfflineHostProvider.getApi().isOrientationPortrait() ? 1 : 3;
    }

    public final long M(boolean z) {
        return OfflineHostProvider.getApi().getSystemTimeInMs(getContext(), z);
    }

    public final Map<String, String> iY() {
        if (this.EI == null) {
            this.EI = new HashMap();
            this.EI.put("BRAND", Build.BRAND);
            this.EI.put("MODEL", Build.MODEL);
            this.EI.put("DISPLAY", Build.DISPLAY);
            this.EI.put("MANUFACTURER", Build.MANUFACTURER);
            this.EI.put("HARDWARE", Build.HARDWARE);
        }
        return this.EI;
    }

    public static String l(String str, String str2) {
        return OfflineHostProvider.getApi().systemProperty().get(str, str2);
    }

    public static int g(String str, int i) {
        return OfflineHostProvider.getApi().systemProperty().getInt(str, i);
    }

    public static long a(String str, long j) {
        return OfflineHostProvider.getApi().systemProperty().getLong(str, j);
    }

    public static boolean a(String str, boolean z) {
        return OfflineHostProvider.getApi().systemProperty().getBoolean(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, g gVar) {
        if (file != null) {
            this.EH.put(Integer.valueOf(iZ().load(file.getAbsolutePath(), 1)), gVar);
        } else if (gVar != null) {
            gVar.call(null, new Object[0]);
            gVar.destroy();
        }
    }

    private SoundPool iZ() {
        SoundPool soundPool;
        if (this.EL == null) {
            if (Build.VERSION.SDK_INT >= 21) {
                soundPool = new SoundPool.Builder().setMaxStreams(10).build();
            } else {
                soundPool = new SoundPool(10, 3, 1);
            }
            soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: com.kwad.tachikoma.s.a.2
                @Override // android.media.SoundPool.OnLoadCompleteListener
                public final void onLoadComplete(SoundPool soundPool2, int i, int i2) {
                    int i3 = i2 == 0 ? i : 0;
                    g gVar = (g) a.this.EH.get(Integer.valueOf(i));
                    if (gVar != null) {
                        gVar.call(null, Integer.valueOf(i3));
                        gVar.destroy();
                        a.this.EH.remove(Integer.valueOf(i));
                    }
                }
            });
            this.EL = soundPool;
        }
        return this.EL;
    }

    private Vibrator getVibrator() {
        Context context;
        if (this.EM == null && (context = this.EJ.getContext().getContext()) != null) {
            this.EM = (Vibrator) context.getSystemService("vibrator");
        }
        return this.EM;
    }

    private void ja() {
        if (this.EN == null) {
            this.EN = new OrientationEventListener(this.EJ.getContext().getContext()) { // from class: com.kwad.tachikoma.s.a.3
                @Override // android.view.OrientationEventListener
                public final void onOrientationChanged(int i) {
                    a.this.cr(i);
                }
            };
        }
        this.EN.enable();
    }

    private void jb() {
        OrientationEventListener orientationEventListener = this.EN;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cr(int i) {
        g gVar = this.EO;
        if (gVar != null) {
            gVar.call(null, Integer.valueOf(i));
        }
    }

    public final void destroy() {
        jb();
        SoundPool soundPool = this.EL;
        if (soundPool != null) {
            soundPool.release();
        }
        g gVar = this.EO;
        if (gVar != null) {
            gVar.destroy();
        }
    }
}
