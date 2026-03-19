package lkxssdk.l;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.lingku.xuanshang.core.data.model.tagTaskInfo;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class r implements lkxssdk.y.b {
    public tagTaskInfo a;
    public BaseActivity b;
    public WebViewWrapper c;
    public boolean d;

    public static final class a {
        public static final r a = new r();
    }

    public final void a(String str) {
        WebViewWrapper webViewWrapper = this.c;
        if (webViewWrapper == null || webViewWrapper.getAty() == null || this.c.getAty().isFinishing()) {
            return;
        }
        lkxssdk.h0.c.b("callbackToWeb:" + str);
        this.c.a("wapDownTaskEvent", str);
    }

    @Override // lkxssdk.y.b
    public void a(lkxssdk.z.a aVar, lkxssdk.y.a aVar2) throws IllegalAccessException, JSONException, NoSuchFieldException, IllegalArgumentException {
        String str;
        if (aVar == null || aVar2 == null) {
            return;
        }
        lkxssdk.h0.c.b("errorType:" + aVar2.a);
        int i = aVar2.a;
        if (i != 8) {
            int i2 = 0;
            if (i == 1) {
                str = "下载地址不正确，请联系客服";
                i2 = 1;
            } else if (i == 9 || i == 4) {
                str = aVar2.b == 43 ? "当前网络需要验证才能使用" : "网络异常，请检查";
                i2 = 2;
            } else if (i == 2) {
                int i3 = aVar2.b;
                if (i3 == 22) {
                    i2 = 3;
                    str = "手机存储空间不足";
                } else if (i3 == 23) {
                    str = "无读写存储权限";
                    i2 = 4;
                } else {
                    str = "";
                }
            } else {
                i2 = 6;
                str = "错误码：" + aVar2.a + Config.replace + aVar2.b;
            }
            lkxssdk.m0.b.a().a(str, 1);
            if (i2 != 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 9);
                    jSONObject.put("err_code", i2);
                    jSONObject.put("err_msg", str);
                    a(jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override // lkxssdk.y.b
    public void b(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 6);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void c(lkxssdk.z.a aVar) {
    }

    @Override // lkxssdk.y.b
    public void d(lkxssdk.z.a aVar) {
    }

    @Override // lkxssdk.y.b
    public void e(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 4);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void f(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", -1);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void g(lkxssdk.z.a aVar) {
    }

    @Override // lkxssdk.y.b
    public void h(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 0);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void i(lkxssdk.z.a aVar) throws IllegalAccessException, JSONException, NoSuchFieldException, IllegalArgumentException {
        tagTaskInfo tagtaskinfo;
        if (!this.d && (tagtaskinfo = this.a) != null && !TextUtils.isEmpty(tagtaskinfo.toast)) {
            lkxssdk.m0.b.a().a(this.a.toast, 1);
        }
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 5);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void j(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 7);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void k(lkxssdk.z.a aVar) {
    }

    @Override // lkxssdk.y.b
    public void l(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 2);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void m(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 3);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    @Override // lkxssdk.y.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(lkxssdk.z.a r5, java.lang.String r6) throws org.json.JSONException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.IllegalArgumentException {
        /*
            r4 = this;
            if (r5 == 0) goto Le5
            com.lingku.xuanshang.core.data.model.tagTaskInfo r0 = r4.a
            java.lang.String r0 = r0.pkg
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L36
            org.json.JSONObject r6 = new org.json.JSONObject
            r6.<init>()
            java.lang.String r0 = "id"
            com.lingku.xuanshang.core.data.model.tagTaskInfo r1 = r4.a     // Catch: org.json.JSONException -> L32
            java.lang.String r1 = r1.id     // Catch: org.json.JSONException -> L32
            r6.put(r0, r1)     // Catch: org.json.JSONException -> L32
            java.lang.String r0 = "url"
            com.lingku.xuanshang.core.data.model.tagTaskInfo r1 = r4.a     // Catch: org.json.JSONException -> L32
            java.lang.String r1 = r1.url     // Catch: org.json.JSONException -> L32
            r6.put(r0, r1)     // Catch: org.json.JSONException -> L32
            java.lang.String r0 = "state"
            r1 = 10
            r6.put(r0, r1)     // Catch: org.json.JSONException -> L32
            java.lang.String r6 = r6.toString()     // Catch: org.json.JSONException -> L32
            r4.a(r6)     // Catch: org.json.JSONException -> L32
            goto L36
        L32:
            r6 = move-exception
            r6.printStackTrace()
        L36:
            boolean r6 = lkxssdk.a.a.a()
            if (r6 != 0) goto L3d
            goto L4e
        L3d:
            lkxssdk.w.j r6 = lkxssdk.w.j.a()
            lkxssdk.w.h r6 = r6.c
            r6.getClass()
            java.lang.String r0 = r5.b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L50
        L4e:
            r5 = 0
            goto L5e
        L50:
            java.lang.String r0 = r5.b
            java.lang.String r5 = r5.c
            java.lang.String r5 = r6.a(r0, r5)
            java.util.List<lkxssdk.w.g> r0 = r6.f
            lkxssdk.w.g r5 = r6.a(r5, r0)
        L5e:
            if (r5 == 0) goto Le5
            com.lingku.xuanshang.core.data.model.tagTaskInfo r6 = r4.a
            java.lang.String r0 = r6.name
            java.lang.String r6 = r6.pkg
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            lkxssdk.z.b r2 = r5.b
            java.lang.String r2 = r2.e
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = java.io.File.separator
            java.lang.StringBuilder r1 = r1.append(r2)
            lkxssdk.z.b r5 = r5.b
            java.lang.String r5 = r5.f
            java.lang.StringBuilder r5 = r1.append(r5)
            java.lang.String r5 = r5.toString()
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto Le5
            boolean r6 = lkxssdk.a.a.b(r6)
            if (r6 == 0) goto Le5
            java.io.File r6 = new java.io.File
            r6.<init>(r5)
            boolean r5 = r6.exists()
            if (r5 == 0) goto Le5
            java.util.Locale r5 = java.util.Locale.getDefault()
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            long r2 = r6.length()
            float r2 = (float) r2
            r3 = 1233125376(0x49800000, float:1048576.0)
            float r2 = r2 / r3
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            java.lang.String r2 = "%.1f"
            java.lang.String r5 = java.lang.String.format(r5, r2, r1)
            r6.delete()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r1 = "已删除《"
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.String r0 = "》APK安装包，节省 "
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.StringBuilder r5 = r6.append(r5)
            java.lang.String r6 = " M空间"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            lkxssdk.m0.b r6 = lkxssdk.m0.b.a()
            r6.a(r5, r3)
        Le5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.l.r.a(lkxssdk.z.a, java.lang.String):void");
    }

    @Override // lkxssdk.y.b
    public void a(lkxssdk.z.a aVar, long j, long j2) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 1);
                jSONObject.put("file_size", j);
                jSONObject.put("complete_size", j2);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // lkxssdk.y.b
    public void a(lkxssdk.z.a aVar) throws JSONException {
        if (aVar != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", aVar.a);
                jSONObject.put("url", aVar.b);
                jSONObject.put("state", 8);
                a(jSONObject.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}
