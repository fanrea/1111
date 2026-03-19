package com.fc.tjcpl.sdk.n;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class e0 {
    public com.fc.tjcpl.sdk.a.a a;
    public com.fc.tjcpl.sdk.n.a b;
    public a c = new a();
    public Handler d = new Handler(Looper.getMainLooper());
    public boolean e;
    public i0 f;

    public static final class b {
        public static final e0 a = new e0();
    }

    public static void a(e0 e0Var, String str) {
        com.fc.tjcpl.sdk.n.a aVar = e0Var.b;
        if (aVar == null || aVar.a() == null || e0Var.b.a().isFinishing()) {
            return;
        }
        com.fc.tjcpl.sdk.i.c.a("callbackToWeb:" + str);
        ((CustomViewContent) e0Var.f).a("wapDownTaskEvent", str);
    }

    public void a(String str) {
        com.fc.tjcpl.sdk.a.a aVar;
        int iH = com.fc.tjcpl.sdk.b.a.h(str);
        com.fc.tjcpl.sdk.i.c.a("taskBtnClick:" + iH);
        if (iH != 0) {
            if (iH == 2) {
                if (com.fc.tjcpl.sdk.b.a.h()) {
                    aVar = this.a;
                    if (aVar.l != 1) {
                        return;
                    }
                } else {
                    aVar = this.a;
                    if (aVar.k != 1) {
                        return;
                    }
                }
                com.fc.tjcpl.sdk.l.e.a(aVar.e, 2, aVar.b, aVar.d);
                com.fc.tjcpl.sdk.b.a.k(str);
                return;
            }
            if (iH == 8) {
                com.fc.tjcpl.sdk.a.a aVar2 = this.a;
                com.fc.tjcpl.sdk.l.e.a(aVar2.e, 6, aVar2.b, aVar2.d);
                com.fc.tjcpl.sdk.b.a.a(com.fc.tjcpl.sdk.b.a.b(), this.a.g);
                return;
            } else if (iH == 10) {
                com.fc.tjcpl.sdk.b.a.b(com.fc.tjcpl.sdk.b.a.b(), this.a.g);
                return;
            } else if (iH != 5) {
                if (iH != 6) {
                    return;
                }
                com.fc.tjcpl.sdk.b.a.i(str);
                return;
            }
        }
        if (iH == 5) {
            com.fc.tjcpl.sdk.a.a aVar3 = this.a;
            com.fc.tjcpl.sdk.l.e.a(aVar3.e, 3, aVar3.b, aVar3.d);
        }
        com.fc.tjcpl.sdk.b.a.l(str);
    }

    public class a implements com.fc.tjcpl.sdk.e.b {
        public a() {
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar) {
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar, com.fc.tjcpl.sdk.e.a aVar2) throws JSONException {
            String str;
            if (aVar == null || aVar2 == null) {
                return;
            }
            com.fc.tjcpl.sdk.i.c.a("errorType:" + aVar2.a);
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
                com.fc.tjcpl.sdk.l.f.a().a(str, 1);
                if (i2 != 0) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", aVar.a);
                        jSONObject.put("url", aVar.b);
                        jSONObject.put("state", 9);
                        jSONObject.put("err_code", i2);
                        jSONObject.put("err_msg", str);
                        e0.a(e0.this, jSONObject.toString());
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void b(com.fc.tjcpl.sdk.f.a aVar) {
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void c(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", -1);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void d(com.fc.tjcpl.sdk.f.a aVar) {
            if (aVar != null) {
                com.fc.tjcpl.sdk.a.a aVar2 = e0.this.a;
                com.fc.tjcpl.sdk.l.e.a(aVar2.e, 1, aVar2.b, aVar2.d);
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void e(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 2);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void f(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 8);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void g(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 0);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void h(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 7);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void i(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 3);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void j(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            com.fc.tjcpl.sdk.a.a aVar2 = e0.this.a;
            com.fc.tjcpl.sdk.l.e.a(aVar2.e, 4, aVar2.b, aVar2.d);
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 4);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void k(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 5);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void l(com.fc.tjcpl.sdk.f.a aVar) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 6);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar, String str) throws Throwable {
            com.fc.tjcpl.sdk.a.a aVar2;
            if (TextUtils.isEmpty(str) || (aVar2 = e0.this.a) == null) {
                return;
            }
            if (str.equals(aVar2.g)) {
                com.fc.tjcpl.sdk.a.a aVar3 = e0.this.a;
                com.fc.tjcpl.sdk.l.e.a(aVar3.e, 5, aVar3.b, aVar3.d);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", e0.this.a.e);
                    jSONObject.put("url", e0.this.a.h);
                    jSONObject.put("state", 10);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                e0 e0Var = e0.this;
                e0Var.getClass();
                boolean z = false;
                if (!com.fc.tjcpl.sdk.b.a.h() ? e0Var.a.m == 1 : e0Var.a.n == 1) {
                    z = true;
                }
                if (z) {
                    com.fc.tjcpl.sdk.a.a aVar4 = e0Var.a;
                    com.fc.tjcpl.sdk.l.e.a(aVar4.e, 6, aVar4.b, aVar4.d);
                    com.fc.tjcpl.sdk.b.a.a(com.fc.tjcpl.sdk.b.a.b(), str);
                }
            }
            com.fc.tjcpl.sdk.c.g gVarB = com.fc.tjcpl.sdk.b.a.b(aVar);
            if (gVarB != null) {
                com.fc.tjcpl.sdk.a.a aVar5 = e0.this.a;
                com.fc.tjcpl.sdk.l.e.a(aVar5.f, aVar5.g, gVarB.b.e + File.separator + gVarB.b.f);
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar, long j, long j2) throws JSONException {
            if (aVar != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", aVar.a);
                    jSONObject.put("url", aVar.b);
                    jSONObject.put("state", 1);
                    jSONObject.put("file_size", j);
                    jSONObject.put("complete_size", j2);
                    e0.a(e0.this, jSONObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
