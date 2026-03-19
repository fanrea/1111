package cn.net.shoot.sharetracesdk.c;

import android.content.ClipData;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import cn.net.shoot.sharetracesdk.AppData;
import cn.net.shoot.sharetracesdk.ShareTraceInstallListener;
import cn.net.shoot.sharetracesdk.e.f;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.sigmob.sdk.base.mta.PointCategory;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public static volatile d b;
    public final ExecutorService a = Executors.newSingleThreadExecutor();

    public static class a implements Runnable {
        public final long a;
        public final c b;

        public a(long j, c cVar) {
            this.a = j;
            this.b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = cn.net.shoot.sharetracesdk.f.a.c().c;
            String strA = d.a();
            HashMap map = new HashMap();
            map.put("ci", cn.net.shoot.sharetracesdk.a.a.a("share_trace_client_id"));
            map.put("t", String.valueOf(System.currentTimeMillis() - this.a));
            c cVar = this.b;
            map.put("ms", (cVar.a != 200 || TextUtils.isEmpty(cVar.c)) ? "0" : "1");
            map.put("cd", String.valueOf(this.b.a));
            c cVar2 = this.b;
            map.put("msg", cVar2.a == 200 ? "success" : cVar2.b);
            try {
                cn.net.shoot.sharetracesdk.a.a.a(map, (HttpURLConnection) new URL(strA + String.format("/api/trace/client/state/%s", str)).openConnection(), ILogConst.PLAY_SOURCE_DEFAULT);
            } catch (Exception e) {
                Log.e("ShareTrace", "report state http post error. error msg=" + e.getMessage());
            }
        }
    }

    public static /* synthetic */ String a() {
        return TextUtils.isEmpty(cn.net.shoot.sharetracesdk.f.a.c().g) ? cn.net.shoot.sharetracesdk.f.a.c().d ? "https://api.sharetrace.com".replace("api", "apitest") : "https://api.sharetrace.com" : cn.net.shoot.sharetracesdk.f.a.c().g;
    }

    public static d b() {
        if (b == null) {
            synchronized (d.class) {
                if (b == null) {
                    b = new d();
                }
            }
        }
        return b;
    }

    public synchronized void a(ShareTraceInstallListener shareTraceInstallListener) {
        this.a.execute(new b(shareTraceInstallListener));
    }

    public static class b implements Runnable {
        public final ShareTraceInstallListener a;

        public class a implements f {
            public final /* synthetic */ HashMap a;
            public final /* synthetic */ long b;

            public a(HashMap map, long j) {
                this.a = map;
                this.b = j;
            }

            @Override // cn.net.shoot.sharetracesdk.e.f
            public void a(c cVar) throws JSONException {
                String str;
                String string;
                String str2 = "Network is response data is " + cVar;
                if (cVar.a == 200) {
                    if (TextUtils.isEmpty(cVar.c)) {
                        cn.net.shoot.sharetracesdk.f.a.c().getClass();
                        str = PointCategory.INIT;
                    } else {
                        cn.net.shoot.sharetracesdk.f.a aVarC = cn.net.shoot.sharetracesdk.f.a.c();
                        String str3 = cVar.c;
                        aVarC.getClass();
                        str = str3;
                    }
                    cn.net.shoot.sharetracesdk.a.a.a("share_trace_init", str);
                    if (cVar.d != null) {
                        cn.net.shoot.sharetracesdk.f.a aVarC2 = cn.net.shoot.sharetracesdk.f.a.c();
                        AppData appData = cVar.d;
                        if (appData == null) {
                            string = "{}";
                        } else {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("params_data", appData.getParamsData());
                                jSONObject.put("channel", appData.getChannel());
                                string = jSONObject.toString();
                            } catch (Exception e) {
                                Log.e("ShareTrace", "app data to json error. err=" + e.getMessage());
                                string = "";
                            }
                        }
                        aVarC2.getClass();
                        cn.net.shoot.sharetracesdk.a.a.a("share_trace_app_data", string);
                    }
                    if (!TextUtils.isEmpty((CharSequence) this.a.get("clip"))) {
                        cn.net.shoot.sharetracesdk.b.a aVarD = cn.net.shoot.sharetracesdk.b.a.d();
                        aVarD.getClass();
                        try {
                            if (aVarD.a != null) {
                                if (Build.VERSION.SDK_INT >= 16) {
                                    aVarD.a.setPrimaryClip(ClipData.newHtmlText("", "", null));
                                } else {
                                    aVarD.a.setText(null);
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    Log.e("ShareTrace", "获取安装参数失败，错误信息：" + cVar.b);
                }
                cn.net.shoot.sharetracesdk.c.a aVarA = cn.net.shoot.sharetracesdk.c.a.a();
                if (aVarA.d != null) {
                    aVarA.c.clear();
                    aVarA.d.unregisterActivityLifecycleCallbacks(aVarA.a);
                }
                b.this.a(cVar);
                cn.net.shoot.sharetracesdk.f.b.a(new a(this.b, cVar));
            }
        }

        /* renamed from: cn.net.shoot.sharetracesdk.c.d$b$b, reason: collision with other inner class name */
        public class RunnableC0042b implements Runnable {
            public final /* synthetic */ c a;

            public RunnableC0042b(c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = this.a;
                int i = cVar.a;
                if (i != 200) {
                    b.this.a.onError(i, cVar.b);
                    return;
                }
                ShareTraceInstallListener shareTraceInstallListener = b.this.a;
                AppData appData = cVar.d;
                if (appData == null) {
                    appData = new AppData();
                }
                shareTraceInstallListener.onInstall(appData);
            }
        }

        public b(ShareTraceInstallListener shareTraceInstallListener) {
            this.a = shareTraceInstallListener;
        }

        public final void a(c cVar) {
            cn.net.shoot.sharetracesdk.f.a.c().b.post(new RunnableC0042b(cVar));
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (cn.net.shoot.sharetracesdk.f.a.c().b()) {
                    HashMap<String, String> mapA = cn.net.shoot.sharetracesdk.c.b.b().a();
                    String str = "report params:" + mapA.toString();
                    String strReplaceAll = UUID.randomUUID().toString().replaceAll("-", "");
                    cn.net.shoot.sharetracesdk.a.a.a("share_trace_client_id", strReplaceAll);
                    mapA.put("ci", strReplaceAll);
                    cn.net.shoot.sharetracesdk.a.a.a(d.a() + String.format("/api/trace/client/report/%s", cn.net.shoot.sharetracesdk.f.a.c().c), mapA, new a(mapA, System.currentTimeMillis()));
                    return;
                }
                String strA = cn.net.shoot.sharetracesdk.a.a.a("share_trace_init");
                String str2 = "Get tid from cache. tid is " + strA;
                cn.net.shoot.sharetracesdk.f.a.c().getClass();
                AppData appDataB = cn.net.shoot.sharetracesdk.a.a.b(cn.net.shoot.sharetracesdk.a.a.a("share_trace_app_data"));
                String str3 = "Get appData from cache. appData is " + appDataB.toString();
                c cVar = new c();
                cVar.c = strA;
                cVar.d = appDataB;
                cVar.a = 200;
                a(cVar);
            } catch (Exception e) {
                Log.e("ShareTrace", "trace report error . msg =" + e.getMessage());
                c cVar2 = new c();
                cVar2.a = -1;
                cVar2.b = "unknown error : " + e.getMessage();
                a(cVar2);
            }
        }
    }
}
