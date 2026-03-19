package com.baidu.mobads.container.landingpage;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.util.bn;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobstat.forbes.Config;
import com.kwai.middleware.azeroth.network.NetworkDefine;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class XDLJsInterface {
    public static final String JAVASCRIPT_PREFIX = "javascript:";
    public static final String TAG = "DLJsInterface";
    static final String a = "javascript:(function(){baidu.mobads.Sdk.natFireEvent('%s', '%s')})()";
    private Context b;
    private com.baidu.mobads.container.ax c;
    private String e;
    private bq f = bq.a();
    private Handler d = new Handler(Looper.getMainLooper());

    public XDLJsInterface(com.baidu.mobads.container.ax axVar, Context context, String str) {
        this.b = context.getApplicationContext();
        this.c = axVar;
        this.e = str;
    }

    public boolean handleShouldOverrideUrlLoading(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        com.baidu.mobads.container.bridge.y yVarB = com.baidu.mobads.container.bridge.y.b(uri.getHost());
        try {
            try {
                try {
                } catch (Throwable th) {
                    try {
                        a(yVarB);
                    } catch (Exception e) {
                        bq.a().a(e);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                bq.a().b(e2);
                a(yVarB);
            }
        } catch (Exception e3) {
            bq.a().a(e3);
        }
        if (!com.baidu.mobads.container.bridge.w.d.equals(scheme)) {
            a(yVarB);
            return false;
        }
        runCommand(yVarB, uri);
        try {
            a(yVarB);
            return true;
        } catch (Exception e4) {
            bq.a().a(e4);
            return true;
        }
    }

    private void a(com.baidu.mobads.container.bridge.y yVar) {
        executeJavaScript("window.mobadssdkbridge.nativeCallComplete(" + JSONObject.quote(yVar.b()) + ")");
    }

    protected void runCommand(com.baidu.mobads.container.bridge.y yVar, Uri uri) throws JSONException {
        String queryParameter = uri.getQueryParameter(Config.INPUT_DEF_PKG);
        com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.f.b(queryParameter);
        String queryParameter2 = uri.getQueryParameter(NetworkDefine.PARAM_TOKEN);
        switch (aw.a[yVar.ordinal()]) {
            case 1:
                if (bVarB != null) {
                    bVarB.b(true);
                    bVarB.a(4);
                    break;
                }
                break;
            case 2:
                getDownloadStatus(queryParameter2, queryParameter);
                break;
            case 3:
                a(uri.getQueryParameter("json"));
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00e9 A[Catch: Exception -> 0x0148, TryCatch #1 {Exception -> 0x0148, blocks: (B:3:0x0012, B:6:0x0041, B:35:0x00e3, B:37:0x00e9, B:38:0x00ed, B:34:0x00da), top: B:46:0x0012 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.container.landingpage.XDLJsInterface.a(java.lang.String):void");
    }

    public void executeJavaScript(String str) {
        if (this.c != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                try {
                    if (!str.startsWith("javascript:")) {
                        str = "javascript:" + str;
                    }
                    if (com.baidu.mobads.container.util.x.a(this.b).a() < 19) {
                        this.c.loadUrl(str);
                        return;
                    } else {
                        this.c.evaluateJavascript(str, new at(this));
                        return;
                    }
                } catch (Exception e) {
                    bq.a().b(e);
                    return;
                }
            }
            this.d.post(new au(this, str));
            return;
        }
        bq.a().d("webview is null");
    }

    public void getDownloadStatus(String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            if (com.baidu.mobads.container.util.j.b(this.b, str2)) {
                jSONObject.put("status", 103);
                fireEvent(str, jSONObject.toString());
                return;
            }
            String string = this.b.getSharedPreferences(com.baidu.mobads.container.util.j.a, 0).getString(str2 + com.baidu.mobads.container.components.command.j.b + bn.a().a(this.b), null);
            if (string != null) {
                int i = new JSONObject(string).getInt("dl");
                b.a[] aVarArrValues = b.a.values();
                b.a aVar = b.a.NONE;
                for (int i2 = 0; i2 < aVarArrValues.length; i2++) {
                    if (aVarArrValues[i2].b() == i) {
                        aVar = aVarArrValues[i2];
                    }
                }
                if (aVar == b.a.COMPLETED) {
                    jSONObject.put("status", 102);
                    fireEvent(str, jSONObject.toString());
                    return;
                }
            }
            com.baidu.mobads.container.components.e.b bVarB = com.baidu.mobads.container.f.b(str2);
            if (bVarB != null) {
                int iH = (int) bVarB.h();
                b.a aVarI = bVarB.i();
                jSONObject.put("status", iH);
                if (aVarI == b.a.PAUSED) {
                    jSONObject.put("isPaused", 1);
                } else {
                    jSONObject.put("isPaused", 0);
                }
                if (aVarI == b.a.ERROR) {
                    jSONObject.put("status", 104);
                }
                fireEvent(str, jSONObject.toString());
                return;
            }
            jSONObject.put("status", 101);
            fireEvent(str, jSONObject.toString());
        } catch (Exception e) {
            bq.a().a(TAG, e.getMessage());
        }
    }

    private String b(String str) {
        return str.replace("'", "\\'").replace("\"", "\\\"");
    }

    protected void fireEvent(String str, String str2) {
        Handler handler;
        av avVar;
        if (str == null) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            try {
                String strB = b(str2);
                handler = this.c.getHandler();
                avVar = new av(this, str, strB);
            } catch (Exception e) {
                bq.a().a(TAG, e.getMessage());
                handler = this.c.getHandler();
                avVar = new av(this, str, str2);
            }
            handler.post(avVar);
        } catch (Throwable th) {
            this.c.getHandler().post(new av(this, str, str2));
            throw th;
        }
    }
}
