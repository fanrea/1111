package com.kwad.components.core.u;

import android.content.Context;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.utils.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static volatile a aas;
    private com.kwad.sdk.utils.i aao;
    private List<WeakReference<OfflineOnAudioConflictListener>> aap = new ArrayList();
    private boolean aaq = false;
    private boolean aar = false;

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.aar = true;
        return true;
    }

    private a(Context context) {
        init(context);
    }

    public static a aC(Context context) {
        if (aas == null) {
            synchronized (a.class) {
                if (aas == null) {
                    aas = new a(context.getApplicationContext());
                }
            }
        }
        return aas;
    }

    private void init(Context context) {
        this.aaq = false;
        com.kwad.sdk.utils.i iVar = new com.kwad.sdk.utils.i(context);
        this.aao = iVar;
        iVar.c(new i.a() { // from class: com.kwad.components.core.u.a.1
            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeOccupied() {
                Iterator it = a.this.aap.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeOccupied();
                        } else {
                            it.remove();
                        }
                    }
                }
                a.a(a.this, true);
            }

            @Override // com.kwad.sdk.utils.i.a
            public final void onAudioBeReleased() {
                Iterator it = a.this.aap.iterator();
                while (it.hasNext()) {
                    WeakReference weakReference = (WeakReference) it.next();
                    if (weakReference == null) {
                        it.remove();
                    } else {
                        OfflineOnAudioConflictListener offlineOnAudioConflictListener = (OfflineOnAudioConflictListener) weakReference.get();
                        if (offlineOnAudioConflictListener != null) {
                            offlineOnAudioConflictListener.onAudioBeReleased();
                        } else {
                            it.remove();
                        }
                    }
                }
            }
        });
    }

    public final void a(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        this.aap.add(new WeakReference<>(offlineOnAudioConflictListener));
    }

    public final void b(OfflineOnAudioConflictListener offlineOnAudioConflictListener) {
        Iterator<WeakReference<OfflineOnAudioConflictListener>> it = this.aap.iterator();
        while (it.hasNext()) {
            WeakReference<OfflineOnAudioConflictListener> next = it.next();
            if (next == null || next.get() == offlineOnAudioConflictListener) {
                it.remove();
            }
        }
    }

    public final boolean aS(boolean z) {
        com.kwad.sdk.utils.i iVar = this.aao;
        if (iVar == null) {
            return false;
        }
        if (!z && this.aaq) {
            return false;
        }
        this.aaq = true;
        this.aar = false;
        return iVar.anK();
    }

    public final boolean to() {
        return this.aar;
    }

    public final void aT(boolean z) {
        this.aar = false;
    }

    public final boolean tp() {
        return this.aaq;
    }
}
