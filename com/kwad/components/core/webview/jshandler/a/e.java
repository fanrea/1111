package com.kwad.components.core.webview.jshandler.a;

import android.content.Context;
import com.kwad.sdk.core.local.LocalWriteResult;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.h;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class e implements com.kwad.sdk.core.webview.c.a {
    private static SimpleDateFormat agK = new SimpleDateFormat("yyyyMMddHHmmss");
    private final WeakReference<Context> agJ;

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "saveImage";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }

    public e(Context context) {
        this.agJ = new WeakReference<>(context);
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(final String str, final com.kwad.sdk.core.webview.c.c cVar) {
        final Context context = this.agJ.get();
        if (context == null) {
            return;
        }
        h.execute(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a aVar = new a();
                    aVar.parseJson(new JSONObject(str));
                    com.kwad.sdk.core.d.c.d("SaveImageHandler", "saveImageData mime type: " + aVar.vq());
                    LocalWriteResult localWriteResultA = com.kwad.sdk.core.local.b.a(context, aVar.vq(), aVar.vp(), "ksad_image_" + e.agK.format(new Date()));
                    if (LocalWriteResult.SUCCESS.equals(localWriteResultA)) {
                        e.this.b(cVar);
                    } else if (LocalWriteResult.FAIL.equals(localWriteResultA)) {
                        e.this.a(cVar, "write error", -1);
                    } else {
                        e.this.a(cVar, "permission denied", -2);
                    }
                } catch (Throwable th) {
                    e.this.a(cVar, "error_" + th.getMessage(), -3);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifySuccess function callback: " + cVar);
        bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.2
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.a(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.sdk.core.webview.c.c cVar, final String str, final int i) {
        com.kwad.sdk.core.d.c.d("SaveImageHandler", "notifyError msg: " + str);
        bx.runOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.a.e.3
            @Override // java.lang.Runnable
            public final void run() {
                com.kwad.sdk.core.webview.c.c cVar2 = cVar;
                if (cVar2 != null) {
                    cVar2.onError(i, str);
                }
            }
        });
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public String agM;
        private byte[] agN;
        private String agO;

        @Override // com.kwad.sdk.core.response.a.a
        public void afterParseJson(JSONObject jSONObject) {
            super.afterParseJson(jSONObject);
            String[] strArrSplit = this.agM.split(";base64,");
            if (strArrSplit.length >= 2) {
                String str = strArrSplit[0];
                if (str.startsWith("data:")) {
                    this.agO = str.substring(5);
                }
                this.agN = com.kwad.sdk.core.a.c.ZZ().decode(strArrSplit[1]);
            }
        }

        public final byte[] vp() {
            return this.agN;
        }

        public final String vq() {
            return this.agO;
        }
    }
}
