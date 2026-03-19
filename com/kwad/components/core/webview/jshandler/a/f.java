package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import com.kwad.sdk.utils.o;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class f implements com.kwad.sdk.core.webview.c.a {
    private final WeakReference<Context> agJ;

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String text;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "setClipBoard";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public f(Context context) {
        this.agJ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        try {
            Context context = this.agJ.get() != null ? this.agJ.get() : null;
            if (context != null) {
                a aVar = new a();
                aVar.parseJson(new JSONObject(str));
                if (o.a(context, "ksad_landing_page", aVar.text)) {
                    cVar.a(null);
                } else {
                    cVar.onError(-1, "写入错误");
                }
            }
        } catch (Throwable unused) {
        }
    }
}
