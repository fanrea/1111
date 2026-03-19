package com.kwad.components.core.webview.tachikoma.a;

import android.content.DialogInterface;
import android.text.TextUtils;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.components.m;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import com.kwad.sdk.utils.bh;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.widget.i;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a implements m {
    private DialogInterface.OnDismissListener CO;
    private boolean aeA;
    private final boolean aeB;
    private boolean aeC;
    private List<com.kwad.components.core.e.d.c> aeD;
    private boolean aeE;
    protected final com.kwad.sdk.core.webview.b aen;
    private int aez;
    private com.kwad.sdk.core.webview.d.a.a gF;

    static /* synthetic */ boolean a(a aVar, com.kwad.sdk.core.webview.d.b.a aVar2) {
        return b(aVar2);
    }

    private a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z, int i, boolean z2, boolean z3) {
        this.aeA = false;
        this.aeD = new ArrayList();
        this.aeA = false;
        this.aen = bVar;
        this.aez = 0;
        if (cVar != null) {
            cVar.aM(1);
            this.aeD.add(cVar);
        }
        this.gF = aVar;
        this.aeB = false;
        this.aeE = false;
    }

    public a(com.kwad.sdk.core.webview.b bVar, com.kwad.components.core.e.d.c cVar, com.kwad.sdk.core.webview.d.a.a aVar, boolean z) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.aeC = true;
    }

    @Override // com.kwad.sdk.components.m
    public final Object call(Object... objArr) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        if (objArr != null) {
            try {
                if (objArr.length > 0) {
                    Object obj = objArr[0];
                    if (obj instanceof String) {
                        aVar.parseJson(new JSONObject((String) obj));
                    }
                }
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        if (this.aen.adx() && aVar.adTemplate == null) {
            return null;
        }
        if (this.aen.bLx && !aVar.bMt) {
            bx.runOnUiThread(new bh() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1
                @Override // com.kwad.sdk.utils.bh
                public final void doTask() {
                    AdTemplate adTemplate;
                    if (a.this.aen.bLy) {
                        if (aVar.adTemplate != null) {
                            adTemplate = aVar.adTemplate;
                            a.this.aeD.add(new com.kwad.components.core.e.d.c(adTemplate));
                        } else if (aVar.creativeId >= 0) {
                            adTemplate = com.kwad.sdk.core.response.b.e.b(a.this.aen.xc(), aVar.creativeId, aVar.adStyle);
                        } else {
                            adTemplate = a.this.aen.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.eV(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.eK(adTemplate);
                        }
                        com.kwad.components.core.e.d.c cVarQ = a.this.Q(aVar.creativeId);
                        if (a.this.CO != null && cVarQ != null) {
                            cVarQ.setOnDismissListener(a.this.CO);
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
                        com.kwad.components.core.e.d.a.a(a.this.a(new a.C0469a(a.this.aen.Vu.getContext()).aC(adTemplate).b(cVarQ).aq(strY).aq(a.a(a.this, aVar)).ar(a.this.aeA).c(a.this.aen.mReportExtData).aG(aVar.afF).aE(aVar.bMs).aF(aVar.oz).as(a.this.aeB || aVar.QV).aL(a.this.aez).an(a.this.aeE).au(a.this.aeC).ay(true).a(new a.b() { // from class: com.kwad.components.core.webview.tachikoma.a.a.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                if (a.this.gF == null || aVar.bMu) {
                                    return;
                                }
                                a.this.gF.a(aVar);
                            }
                        }), aVar, adTemplate));
                    }
                }
            });
        } else if (this.gF != null) {
            bx.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.tachikoma.a.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (a.this.gF == null || aVar.bMu) {
                        return;
                    }
                    a.this.gF.a(aVar);
                }
            });
        }
        return null;
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

    protected final a.C0469a a(a.C0469a c0469a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
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
            i iVar = this.aen.bLv;
            if (iVar != null) {
                c0469a.d(iVar.getTouchCoords());
            }
        }
        c0469a.a(null, null, null);
        return c0469a;
    }
}
