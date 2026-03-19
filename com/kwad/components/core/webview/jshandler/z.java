package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bx;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class z implements com.kwad.sdk.core.webview.c.a {
    private DialogInterface.OnDismissListener CO;
    private boolean aeA;
    private final boolean aeB;
    private boolean aeC;
    private List<com.kwad.components.core.e.d.c> aeD;
    private boolean aeE;
    protected final com.kwad.sdk.core.webview.b aen;
    private int aez;
    private com.kwad.sdk.core.webview.d.a.a gF;

    protected void Y(int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "clickAction";
    }

    protected void kv() {
    }

    static /* synthetic */ boolean a(z zVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.aeA = false;
        this.aeD = new ArrayList();
        this.aeA = z;
        this.aen = bVar;
        this.aez = i;
        if (cVar != null) {
            cVar.aM(1);
            this.aeD.add(cVar);
        }
        this.gF = aVar;
        this.aeB = z2;
        this.aeE = z3;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.CO = onDismissListener;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, 0, false, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.aeC = true;
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, int i, boolean z) {
        this(bVar, cVar, null, false, 2, z, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, int i) {
        this(bVar, cVar, aVar, false, 1, false, false);
    }

    public z(com.kwad.sdk.core.webview.b bVar, List<com.kwad.components.core.e.d.c> list, com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.aeD.addAll(list);
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
        if (this.aen.adx() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.aen.bLx && !aVar.bMt) {
            bx.runOnUiThread(new com.kwad.sdk.utils.bh() { // from class: com.kwad.components.core.webview.jshandler.z.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    AdTemplate adTemplate;
                    if (z.this.aen.bLy) {
                        if (aVar.adTemplate != null) {
                            adTemplate = aVar.adTemplate;
                            z.this.aeD.add(new com.kwad.components.core.e.d.c(adTemplate));
                        } else if (aVar.creativeId >= 0) {
                            adTemplate = com.kwad.sdk.core.response.b.e.b(z.this.aen.xc(), aVar.creativeId, aVar.adStyle);
                        } else {
                            adTemplate = z.this.aen.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.eV(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.eK(adTemplate);
                        }
                        com.kwad.components.core.e.d.c cVarQ = z.this.Q(aVar.creativeId);
                        if (z.this.CO != null && cVarQ != null) {
                            cVarQ.setOnDismissListener(z.this.CO);
                        }
                        String strY = null;
                        if (!TextUtils.isEmpty(aVar.Rj)) {
                            try {
                                strY = com.kwad.components.core.e.b.a.y(Long.parseLong(aVar.Rj));
                            } catch (Exception unused) {
                                strY = aVar.Rj;
                            }
                        } else if (adTemplate != null && adTemplate.tkLiveShopItemInfo != null) {
                            strY = adTemplate.tkLiveShopItemInfo.itemId;
                        }
                        z.this.Y(com.kwad.components.core.e.d.a.a(z.this.a(new a.C0469a(z.this.aen.Vu.getContext()).aC(adTemplate).b(cVarQ).aq(strY).aq(z.a(z.this, aVar)).ar(z.this.aeA).c(z.this.aen.mReportExtData).aG(aVar.afF).aE(aVar.bMs).aF(aVar.oz).as(z.this.aeB || aVar.QV).aL(z.this.aez).an(z.this.aeE).au(z.this.aeC).ay(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.z.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                z.this.kv();
                                if (z.this.gF == null || aVar.bMu) {
                                    return;
                                }
                                z.this.gF.a(aVar);
                            }
                        }), aVar, adTemplate)));
                    }
                }
            });
        } else if (this.gF != null) {
            bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.z.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (z.this.gF == null || aVar.bMu) {
                        return;
                    }
                    z.this.gF.a(aVar);
                }
            });
        }
        cVar.a(null);
    }

    protected a.C0469a a(a.C0469a c0469a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        if (aVar.afG != null && !TextUtils.isEmpty(aVar.afG.QX)) {
            c0469a.ar(aVar.afG.QX);
        }
        if (aVar.afG != null && aVar.afG.aja != 0) {
            c0469a.aJ(aVar.afG.aja);
        }
        if (com.kwad.sdk.core.response.b.e.fe(adTemplate) && aVar.afG != null && aVar.afG.bMw != null) {
            aj.a aVar2 = new aj.a();
            aVar2.q((float) aVar.afG.bMw.x, (float) aVar.afG.bMw.y);
            aVar2.p((float) aVar.afG.bMw.x, (float) aVar.afG.bMw.y);
            aVar2.ac(aVar.afG.bMw.width, aVar.afG.bMw.height);
            c0469a.d(aVar2);
        } else {
            com.kwad.sdk.widget.i iVar = this.aen.bLv;
            if (iVar != null) {
                c0469a.d(iVar.getTouchCoords());
            }
        }
        c0469a.a(null, null, null);
        return c0469a;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.gF = null;
    }

    protected final com.kwad.components.core.e.d.c Q(long j) {
        List<com.kwad.components.core.e.d.c> list = this.aeD;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.aeD.get(0);
        }
        for (com.kwad.components.core.e.d.c cVar : this.aeD) {
            if (com.kwad.sdk.core.response.b.e.eV(cVar.pQ()) == j) {
                return cVar;
            }
        }
        return null;
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.afF == 1;
    }
}
