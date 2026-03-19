package lkxssdk.l;

import android.os.Handler;
import com.baidu.mobstat.forbes.Config;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class b {
    public static b a;
    public String b;
    public lkxssdk.k.a<String> c;
    public a d;
    public Handler e;

    public static void a(b bVar, String str) {
        if (bVar.c != null) {
            lkxssdk.h0.c.b("callbackToWeb:" + str);
            bVar.c.a(str);
        }
    }

    public class a implements lkxssdk.y.b {
        public a() {
        }

        @Override // lkxssdk.y.b
        public void a(lkxssdk.z.a aVar) {
        }

        @Override // lkxssdk.y.b
        public void a(lkxssdk.z.a aVar, String str) {
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
                        b.a(b.this, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // lkxssdk.y.b
        public void b(lkxssdk.z.a aVar) {
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
                    b.a(b.this, jSONObject.toString());
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
                    b.a(b.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // lkxssdk.y.b
        public void g(lkxssdk.z.a aVar) {
        }

        @Override // lkxssdk.y.b
        public void h(lkxssdk.z.a aVar) {
        }

        @Override // lkxssdk.y.b
        public void i(lkxssdk.z.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 5);
                    b.a(b.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // lkxssdk.y.b
        public void j(lkxssdk.z.a aVar) {
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
                    b.a(b.this, jSONObject.toString());
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
                    b.a(b.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
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
                    b.a(b.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
