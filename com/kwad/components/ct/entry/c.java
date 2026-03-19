package com.kwad.components.ct.entry;

import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.u.p;
import com.kwad.components.ct.request.f;
import com.kwad.components.ct.request.k;
import com.kwad.components.ct.request.l;
import com.kwad.components.ct.response.model.CtAdResultData;
import com.kwad.sdk.api.KsEntryElement;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bx;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class c {
    public static void loadEntryElement(KsScene ksScene, final KsLoadManager.EntryElementListener<KsEntryElement> entryElementListener, boolean z) {
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        p.tH().b(sceneImplCovert, "loadEntryElement");
        final k.a aVar = new k.a();
        aVar.anZ.add(new ImpInfo(sceneImplCovert));
        com.kwad.components.ct.request.a.a aVar2 = new com.kwad.components.ct.request.a.a();
        aVar2.contentType = 1;
        aVar2.aUW = z ? 1 : 0;
        aVar.aUG = aVar2;
        l.a(aVar, new f() { // from class: com.kwad.components.ct.entry.c.1
            @Override // com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.ct.entry.c.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.kwad.sdk.core.d.c.d("KsCtEntryLoadManager", "loadEntryElement onError:" + String.format("code:%s__msg:%s", Integer.valueOf(i), str));
                        entryElementListener.onError(i, str);
                    }
                });
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.components.core.request.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void b(final CtAdResultData ctAdResultData) {
                if (ctAdResultData.entryInfo != null) {
                    final b bVar = new b();
                    bVar.a(aVar);
                    bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.ct.entry.c.1.2
                        @Override // java.lang.Runnable
                        public final void run() {
                            bVar.a(ctAdResultData.entryInfo);
                            entryElementListener.onEntryLoad(bVar);
                        }
                    });
                }
            }
        });
    }
}
