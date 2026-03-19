package com.kwad.components.offline.d;

import android.content.Context;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.ITkOfflineCompo;
import com.kwad.components.offline.api.tk.TKDownloadListener;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.components.offline.d.a.i;
import com.kwad.sdk.components.t;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class b implements com.kwad.components.core.p.a.e.c {
    private final ITkOfflineCompo bbM;

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    public b(ITkOfflineCompo iTkOfflineCompo) {
        this.bbM = iTkOfflineCompo;
    }

    @Override // com.kwad.sdk.components.b
    public final Class<b> getComponentsType() {
        return b.class;
    }

    @Override // com.kwad.sdk.components.b
    public final int priority() {
        return this.bbM.priority();
    }

    @Override // com.kwad.components.core.p.a.e.c
    public final ITkOfflineCompo.TKState getState() {
        return this.bbM.getState();
    }

    @Override // com.kwad.components.core.p.a.e.c
    public final t a(Context context, String str, int i, int i2, boolean z) {
        IOfflineCompoTachikomaContext context2 = this.bbM.getContext(context, str, i, i2, z);
        if (context2 == null) {
            return null;
        }
        return new i(context2);
    }

    @Override // com.kwad.components.core.p.a.e.c
    public final String getJsBaseDir(Context context, String str) {
        return this.bbM.getJsBaseDir(context, str);
    }

    public final void onConfigRefresh(Context context, JSONObject jSONObject) {
        this.bbM.onConfigRefresh(context, jSONObject);
    }

    @Override // com.kwad.components.core.p.a.e.c
    public final StyleTemplate checkStyleTemplateById(Context context, String str, String str2, String str3, int i) {
        return this.bbM.checkStyleTemplateById(context, str, str2, str3, i);
    }

    @Override // com.kwad.components.core.p.a.e.c
    public final void loadTkFileByTemplateId(Context context, String str, String str2, String str3, int i, TKDownloadListener tKDownloadListener) {
        this.bbM.loadTkFileByTemplateId(context, str, str2, str3, i, tKDownloadListener);
    }

    @Override // com.kwad.components.core.p.a.e.c
    public final void onDestroy() {
        this.bbM.onDestroy();
    }
}
