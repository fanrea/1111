package com.sigmob.sdk.videocache;

import android.content.Context;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;
import com.czhj.volley.toolbox.StringUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class x {
    private static x a;
    private final ExecutorService b = Executors.newFixedThreadPool(8);
    private final Map<String, WeakReference<a>> c = new HashMap();
    private Context d;

    private static class a implements Runnable {
        private String a;
        private AtomicBoolean b = new AtomicBoolean(false);

        public a(String url) {
            this.a = url;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:60:0x009d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:71:? A[SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r7v2 */
        /* JADX WARN: Type inference failed for: r7v4, types: [java.net.HttpURLConnection] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(java.lang.String r7) throws java.lang.Throwable {
            /*
                r6 = this;
                r0 = 0
                r1 = 1
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
                r3.<init>(r7)     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
                java.net.URLConnection r7 = r3.openConnection()     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch: java.lang.Throwable -> L60 java.lang.Exception -> L63
                r3 = 5000(0x1388, float:7.006E-42)
                r7.setConnectTimeout(r3)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                r7.setReadTimeout(r3)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                r7.connect()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                r3 = 1024(0x400, float:1.435E-42)
                byte[] r3 = new byte[r3]     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                java.io.InputStream r0 = r7.getInputStream()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
            L21:
                int r4 = r0.read(r3)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                r5 = -1
                if (r4 == r5) goto L3f
                java.util.concurrent.atomic.AtomicBoolean r4 = r6.b     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                boolean r4 = r4.get()     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                if (r4 == 0) goto L21
                java.lang.String r3 = "cancelPreLoadVideo，取消网络请求，成功（正在下载数据），url = %s"
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                java.lang.String r5 = r6.a     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                r4[r2] = r5     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                com.czhj.sdk.logger.SigmobLog.d(r3)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
            L3f:
                java.lang.String r3 = "preloadVideo，网络文件，成功，url = %s"
                java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                java.lang.String r5 = r6.a     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                r4[r2] = r5     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                com.czhj.sdk.logger.SigmobLog.i(r3)     // Catch: java.lang.Exception -> L5e java.lang.Throwable -> L90
                if (r0 == 0) goto L58
                r0.close()     // Catch: java.lang.Exception -> L54
                goto L58
            L54:
                r0 = move-exception
                r0.printStackTrace()
            L58:
                if (r7 == 0) goto L8f
                r7.disconnect()     // Catch: java.lang.Exception -> L8b
                goto L8f
            L5e:
                r3 = move-exception
                goto L65
            L60:
                r1 = move-exception
                r7 = r0
                goto L91
            L63:
                r3 = move-exception
                r7 = r0
            L65:
                java.lang.String r4 = "preloadVideo，网络文件，失败，msg = %s，url = %s"
                r5 = 2
                java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L90
                java.lang.String r3 = r3.getMessage()     // Catch: java.lang.Throwable -> L90
                r5[r2] = r3     // Catch: java.lang.Throwable -> L90
                java.lang.String r2 = r6.a     // Catch: java.lang.Throwable -> L90
                r5[r1] = r2     // Catch: java.lang.Throwable -> L90
                java.lang.String r1 = java.lang.String.format(r4, r5)     // Catch: java.lang.Throwable -> L90
                com.czhj.sdk.logger.SigmobLog.e(r1)     // Catch: java.lang.Throwable -> L90
                if (r0 == 0) goto L85
                r0.close()     // Catch: java.lang.Exception -> L81
                goto L85
            L81:
                r0 = move-exception
                r0.printStackTrace()
            L85:
                if (r7 == 0) goto L8f
                r7.disconnect()     // Catch: java.lang.Exception -> L8b
                goto L8f
            L8b:
                r7 = move-exception
                r7.printStackTrace()
            L8f:
                return
            L90:
                r1 = move-exception
            L91:
                if (r0 == 0) goto L9b
                r0.close()     // Catch: java.lang.Exception -> L97
                goto L9b
            L97:
                r0 = move-exception
                r0.printStackTrace()
            L9b:
                if (r7 == 0) goto La5
                r7.disconnect()     // Catch: java.lang.Exception -> La1
                goto La5
            La1:
                r7 = move-exception
                r7.printStackTrace()
            La5:
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.videocache.x.a.a(java.lang.String):void");
        }

        public void a(boolean cancel) {
            this.b.set(cancel);
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            if (this.b.get()) {
                SigmobLog.i(String.format("cancelPreLoadVideo，取消网络请求，成功（未下载数据），url = %s", this.a));
            } else {
                a(this.a);
            }
        }
    }

    private x(Context context) {
        this.d = context;
    }

    public static synchronized x a(Context context) {
        if (a == null && context != null) {
            a = new x(context.getApplicationContext());
        }
        return a;
    }

    public void a(String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        String url2 = StringUtil.getUrl(url);
        if (!url2.startsWith(com.alipay.sdk.m.l.a.r)) {
            SigmobLog.d(String.format("preloadVideo，本地文件：ulr = %s", url2));
            return;
        }
        SigmobLog.d(String.format("preloadVideo，网络文件，开始下载：ulr = %s", url2));
        a aVar = new a(url2);
        this.c.put(url2, new WeakReference<>(aVar));
        this.b.execute(aVar);
    }

    public void b(String url) {
        WeakReference<a> weakReference;
        a aVar;
        SigmobLog.d(String.format("cancelPreLoadVideo，ulr = %s", url));
        if (this.c == null || TextUtils.isEmpty(url) || (weakReference = this.c.get(url)) == null || (aVar = weakReference.get()) == null) {
            return;
        }
        SigmobLog.d(String.format("cancelPreLoadVideo，取消网络请求，ulr = %s", url));
        aVar.a(true);
    }
}
