package lkxssdk.j;

import android.app.Application;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.fendasz.moku.planet.utils.QqUtils;
import com.lingku.xuanshang.core.data.model.tagReqPermissionModel;
import com.lingku.xuanshang.core.data.model.tagTaskInfo;
import com.lingku.xuanshang.core.data.model.tagUploadFileData;
import com.lingku.xuanshang.core.ui.WebActvity;
import com.lingku.xuanshang.core.ui.base.BaseActivity;
import com.lingku.xuanshang.core.ui.imagepicker.PickerActivity;
import com.lingku.xuanshang.core.ui.webview.WebViewWrapper;
import com.lingku.xuanshang.xutils.http.RequestParams;
import com.lingku.xuanshang.xutils.x;
import com.luck.picture.lib.config.SelectMimeType;
import com.sigmob.sdk.base.n;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Stack;
import lkxssdk.e.i;
import lkxssdk.e.p;
import lkxssdk.e.s;
import lkxssdk.e.t;
import lkxssdk.l.b;
import lkxssdk.l.b.a;
import lkxssdk.l.e;
import lkxssdk.l.f;
import lkxssdk.l.k;
import lkxssdk.l.l;
import lkxssdk.l.q;
import lkxssdk.l.r;
import lkxssdk.w.g;
import lkxssdk.w.h;
import lkxssdk.w.j;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a {
    public WebViewWrapper a;
    public Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: lkxssdk.j.a$a, reason: collision with other inner class name */
    public class C0844a implements f.a {
        public final /* synthetic */ lkxssdk.k.a a;

        public C0844a(a aVar, lkxssdk.k.a aVar2) {
            this.a = aVar2;
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ int a;

        public b(int i) {
            this.a = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a == 0) {
                a.this.a.getAty().getWindow().addFlags(8192);
            } else {
                a.this.a.getAty().getWindow().clearFlags(8192);
            }
        }
    }

    public class c extends Thread {
        public final /* synthetic */ JSONObject a;

        public c(a aVar, JSONObject jSONObject) {
            this.a = jSONObject;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            super.run();
            try {
                JSONArray jSONArrayOptJSONArray = this.a.optJSONArray("dataArr");
                if (jSONArrayOptJSONArray != null) {
                    String str = lkxssdk.a.a.d().getExternalFilesDir(".XSWData").getAbsolutePath() + File.separator + "web";
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                        String strOptString = jSONObject.optString("id");
                        String strOptString2 = jSONObject.optString("data");
                        if (!TextUtils.isEmpty(strOptString)) {
                            String str2 = str + File.separator + lkxssdk.a0.c.a(strOptString);
                            if (TextUtils.isEmpty(strOptString2)) {
                                lkxssdk.m.c.a(lkxssdk.m.c.a(str2));
                            } else {
                                lkxssdk.m.b.a(lkxssdk.m.c.a(str2), strOptString2, false);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class d extends Thread {
        public final /* synthetic */ JSONObject a;
        public final /* synthetic */ lkxssdk.k.a b;

        public d(a aVar, JSONObject jSONObject, lkxssdk.k.a aVar2) {
            this.a = jSONObject;
            this.b = aVar2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            super.run();
            try {
                JSONArray jSONArrayOptJSONArray = this.a.optJSONArray("idArr");
                if (jSONArrayOptJSONArray != null) {
                    String str = lkxssdk.a.a.d().getExternalFilesDir(".XSWData").getAbsolutePath() + File.separator + "web";
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String string = jSONArrayOptJSONArray.getString(i);
                        String str2 = "";
                        if (!TextUtils.isEmpty(string)) {
                            String strA = lkxssdk.m.b.a(str + File.separator + lkxssdk.a0.c.a(string));
                            if (!TextUtils.isEmpty(strA)) {
                                str2 = strA;
                            }
                        }
                        jSONArray.put(str2);
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("contentArr", jSONArray);
                    lkxssdk.h0.c.b(jSONObject);
                    this.b.b(jSONObject.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a(WebViewWrapper webViewWrapper) {
        this.a = webViewWrapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Object obj, lkxssdk.k.a aVar) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("apk_url", "");
            int iOptInt = jSONObjectA.optInt("action", 1);
            if (TextUtils.isEmpty(strOptString)) {
                g();
                return;
            }
            if (lkxssdk.l.b.a == null) {
                synchronized (lkxssdk.l.b.class) {
                    if (lkxssdk.l.b.a == null) {
                        lkxssdk.l.b.a = new lkxssdk.l.b();
                    }
                }
            }
            lkxssdk.l.b bVar = lkxssdk.l.b.a;
            if (iOptInt == 2) {
                b.a aVar2 = bVar.d;
                if (aVar2 != null) {
                    lkxssdk.a.a.b(aVar2);
                }
                if (TextUtils.isEmpty(strOptString)) {
                    return;
                }
                lkxssdk.a.a.i(strOptString);
                return;
            }
            if (bVar.d == null) {
                bVar.d = bVar.new a();
            }
            bVar.e = new Handler(Looper.getMainLooper());
            bVar.b = strOptString;
            bVar.c = aVar;
            lkxssdk.z.a aVar3 = new lkxssdk.z.a(strOptString);
            aVar3.d = lkxssdk.a.a.d().getPackageName();
            aVar3.f = true;
            lkxssdk.a.a.a(bVar.d);
            lkxssdk.a.a.a(aVar3);
            lkxssdk.a.a.c(bVar.b);
            bVar.e.postDelayed(new lkxssdk.l.a(bVar), 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("url");
            int iOptInt = jSONObject.optInt("animType", 1);
            int iOptInt2 = jSONObject.optInt("showNav", 1);
            int iOptInt3 = jSONObject.optInt("backAction", 0);
            Bundle bundle = new Bundle();
            bundle.putString("url", strOptString);
            bundle.putInt("showNav", iOptInt2);
            bundle.putInt("backAction", iOptInt3);
            lkxssdk.a.a.a(this.a.getAty(), (Class<?>) WebActvity.class, iOptInt, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b() {
        this.a.getAty().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            tagTaskInfo tagtaskinfo = (tagTaskInfo) lkxssdk.l0.a.a(jSONObjectA, tagTaskInfo.class);
            if (tagtaskinfo == null || TextUtils.isEmpty(tagtaskinfo.id) || TextUtils.isEmpty(tagtaskinfo.url) || TextUtils.isEmpty(tagtaskinfo.pkg)) {
                g();
            } else {
                r rVar = r.a.a;
                BaseActivity aty = this.a.getAty();
                WebViewWrapper webViewWrapper = this.a;
                rVar.b = aty;
                rVar.c = webViewWrapper;
                rVar.d = false;
                lkxssdk.a.a.a(rVar);
                tagTaskInfo tagtaskinfo2 = rVar.a;
                if (tagtaskinfo2 != null && !tagtaskinfo2.url.equals(tagtaskinfo.url)) {
                    lkxssdk.a.a.i(rVar.a.url);
                }
                rVar.a = tagtaskinfo;
                lkxssdk.z.a aVar = new lkxssdk.z.a(tagtaskinfo.url);
                aVar.a = tagtaskinfo.id;
                aVar.d = tagtaskinfo.pkg;
                aVar.g = tagtaskinfo.install_auto != 1;
                List<String> list = tagtaskinfo.file_md5;
                if (list != null && list.size() > 0) {
                    aVar.e = tagtaskinfo.file_md5;
                }
                lkxssdk.a.a.a(aVar);
                lkxssdk.a.a.c(tagtaskinfo.url);
            }
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        this.a.getAty().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }

    public static /* synthetic */ void b(JSONObject jSONObject) {
        try {
            lkxssdk.i0.b.a().a(15, jSONObject.optInt("clearCache", 0), 0, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        Context context = this.a.getContext();
        if (context != null) {
            try {
                Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
                launchIntentForPackage.setFlags(268435456);
                context.startActivity(launchIntentForPackage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            try {
                lkxssdk.a.a.a(this.a.getAty(), Color.parseColor(jSONObjectA.optString(TypedValues.Custom.S_COLOR)));
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        intent.setFlags(268435456);
        this.a.getAty().startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        try {
            Intent launchIntentForPackage = this.a.getAty().getPackageManager().getLaunchIntentForPackage("com.tencent.mm");
            launchIntentForPackage.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            this.a.getAty().startActivity(launchIntentForPackage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(JSONObject jSONObject, lkxssdk.k.a aVar) {
        String strOptString = jSONObject.optString("pic", "");
        if (TextUtils.isEmpty(strOptString)) {
            g();
            return;
        }
        WebViewWrapper webViewWrapper = this.a;
        if (webViewWrapper.k == null) {
            webViewWrapper.k = new q(webViewWrapper.a);
        }
        q qVar = webViewWrapper.k;
        qVar.a = strOptString;
        qVar.e = aVar;
        qVar.d = true;
        lkxssdk.j0.d.a(qVar.b, new l(qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.a.a(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Object obj) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("id", "");
            String strOptString2 = jSONObjectA.optString("url", "");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                r rVar = r.a.a;
                if (rVar.b == null) {
                    return;
                }
                lkxssdk.a.a.b(rVar);
                if (lkxssdk.a.a.g(strOptString2) == 2) {
                    lkxssdk.m0.b.a().a("已暂停任务下载", 0);
                }
                lkxssdk.a.a.i(strOptString2);
                if (lkxssdk.a.a.a()) {
                    j.a().c.a.b.set(false);
                    return;
                }
                return;
            }
        }
        g();
    }

    public final JSONObject a(Object obj) {
        if (obj == null || obj.toString().equals(ILogConst.CACHE_PLAY_REASON_NULL)) {
            return null;
        }
        try {
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void g() {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda10
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                lkxssdk.m0.b.a().a("交互数据错误", 0);
            }
        });
    }

    @JavascriptInterface
    public void natAddDownloadTask(final Object obj) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda20
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(obj);
            }
        });
    }

    @JavascriptInterface
    public void natAliPayH5(Object obj, lkxssdk.k.a<String> aVar) {
    }

    @JavascriptInterface
    public void natAllowLongClickPic(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            int iOptInt = jSONObjectA.optInt("allow", 1);
            this.a.o = iOptInt == 1;
        }
    }

    @JavascriptInterface
    public int natAppIsInstalled(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA == null) {
            return 0;
        }
        String strOptString = jSONObjectA.optString("package", "");
        if (TextUtils.isEmpty(strOptString)) {
            return 0;
        }
        return lkxssdk.a.a.b(strOptString) ? 1 : 0;
    }

    @JavascriptInterface
    public void natAppUpdate2(final Object obj, final lkxssdk.k.a<String> aVar) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda21
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(obj, aVar);
            }
        });
    }

    @JavascriptInterface
    public void natChoosePic(Object obj, final lkxssdk.k.a<String> aVar) {
        final JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(jSONObjectA, aVar);
                }
            });
        }
    }

    @JavascriptInterface
    public void natChooseVideo(Object obj, final lkxssdk.k.a<String> aVar) {
        final JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda13
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(jSONObjectA, aVar);
                }
            });
        }
    }

    @JavascriptInterface
    public void natClearNativeData(Object obj) {
        lkxssdk.l0.f.a().b.edit().clear().apply();
    }

    @JavascriptInterface
    public int natCopyText(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA == null) {
            return 0;
        }
        String strOptString = jSONObjectA.optString("text", "");
        try {
            ClipboardManager clipboardManager = (ClipboardManager) this.a.getContext().getSystemService("clipboard");
            ClipData clipDataNewPlainText = ClipData.newPlainText("text", strOptString);
            if (clipboardManager == null) {
                return 0;
            }
            clipboardManager.setPrimaryClip(clipDataNewPlainText);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @JavascriptInterface
    public void natDeviceInfo(Object obj, lkxssdk.k.a<String> aVar) throws JSONException, UnsupportedEncodingException {
        boolean z;
        int iOptInt;
        boolean z2;
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            iOptInt = jSONObjectA.optInt("dataType", -1);
            z2 = jSONObjectA.optInt("notNeedId", 0) == 1;
            z = jSONObjectA.optInt("notEncrypt", 0) == 1;
        } else {
            z = false;
            iOptInt = 0;
            z2 = false;
        }
        BaseActivity aty = this.a.getAty();
        f fVar = new f(aty, new C0844a(this, aVar));
        fVar.c = z;
        if (iOptInt != 1 && iOptInt != 2) {
            if (iOptInt == 0) {
                z2 = false;
            }
            if (z2) {
                fVar.a(0);
                return;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 29) {
                if (!TextUtils.isEmpty(lkxssdk.a.a.d)) {
                    fVar.a(-1);
                    return;
                }
            } else if (!lkxssdk.j0.d.a(aty.getApplication(), "android.permission.READ_PHONE_STATE")) {
                if (i >= 23) {
                    fVar.a(fVar.a.shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE") ? -8 : -9);
                    return;
                }
                return;
            }
            fVar.a(1);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(n.p, fVar.a.getPackageName());
            jSONObject.put("app_ver_code", lkxssdk.a.a.e(fVar.a.getApplication().getPackageName()).d);
            jSONObject.put("app_ver", lkxssdk.a.a.e(fVar.a.getApplication().getPackageName()).c);
            jSONObject.put("channel_id", (Object) null);
            jSONObject.put("is_tablet", lkxssdk.l0.a.f() ? "1" : "0");
            jSONObject.put("app_unique", lkxssdk.l0.a.e());
            if (iOptInt != 1) {
                jSONObject.put("android_id", lkxssdk.l0.a.a());
                jSONObject.put("mobile_model", Build.MODEL);
                jSONObject.put("sys_ver", Build.VERSION.RELEASE);
                jSONObject.put("sys_ver_int", String.valueOf(Build.VERSION.SDK_INT));
                jSONObject.put("screen_resolution", lkxssdk.b.a.b + "x" + lkxssdk.b.a.a);
                jSONObject.put("screen_size", lkxssdk.l0.a.a(fVar.a, lkxssdk.b.a.a, lkxssdk.b.a.b));
                jSONObject.put("manufacturer", Build.MANUFACTURER);
            }
            jSONObject.put("id_state", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        lkxssdk.h0.c.b("tag", "device info:" + jSONObject.toString());
        boolean z3 = fVar.c;
        String string = jSONObject.toString();
        if (!z3) {
            string = lkxssdk.a.a.d(string);
        }
        f.a aVar2 = fVar.b;
        if (aVar2 != null) {
            lkxssdk.h0.c.a("device info:" + string);
            ((C0844a) aVar2).a.b(string);
        }
    }

    @JavascriptInterface
    public void natEmulatorCheck(Object obj, lkxssdk.k.a<String> aVar) {
        new lkxssdk.i.b(aVar).b();
    }

    @JavascriptInterface
    public void natExitAPP(Object obj) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a();
            }
        });
    }

    @JavascriptInterface
    public void natExitWebView(Object obj) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String natGetClipboardText(java.lang.Object r6) {
        /*
            r5 = this;
            com.lingku.xuanshang.core.ui.webview.WebViewWrapper r0 = r5.a
            android.content.Context r0 = r0.getContext()
            java.lang.String r1 = "clipboard"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.content.ClipboardManager r0 = (android.content.ClipboardManager) r0
            r1 = 0
            java.lang.String r2 = ""
            if (r0 == 0) goto L48
            android.content.ClipData r0 = r0.getPrimaryClip()
            if (r0 == 0) goto L48
            int r3 = r0.getItemCount()
            if (r3 <= 0) goto L48
            android.content.ClipData$Item r0 = r0.getItemAt(r1)
            java.lang.CharSequence r0 = r0.getText()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "剪贴板数据："
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r0)
            java.lang.String r3 = r3.toString()
            lkxssdk.h0.c.b(r3)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L48
            goto L49
        L48:
            r0 = r2
        L49:
            org.json.JSONObject r6 = r5.a(r6)
            if (r6 == 0) goto L89
            java.lang.String r3 = "filter"
            java.lang.String r3 = r6.optString(r3, r2)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            if (r4 != 0) goto L62
            boolean r6 = r0.contains(r3)
            if (r6 != 0) goto L89
            return r2
        L62:
            java.lang.String r3 = "filters"
            org.json.JSONArray r6 = r6.optJSONArray(r3)
            if (r6 == 0) goto L89
            int r3 = r6.length()
            if (r3 <= 0) goto L89
            r3 = r1
        L71:
            int r4 = r6.length()
            if (r3 >= r4) goto L86
            java.lang.String r4 = r6.optString(r3)
            boolean r4 = r0.contains(r4)
            if (r4 == 0) goto L83
            r1 = 1
            goto L86
        L83:
            int r3 = r3 + 1
            goto L71
        L86:
            if (r1 != 0) goto L89
            goto L8a
        L89:
            r2 = r0
        L8a:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "natGetClipboardText:"
            java.lang.StringBuilder r6 = r6.append(r0)
            java.lang.StringBuilder r6 = r6.append(r2)
            java.lang.String r6 = r6.toString()
            lkxssdk.h0.c.b(r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.j.a.natGetClipboardText(java.lang.Object):java.lang.String");
    }

    @JavascriptInterface
    public void natGetDataFromFile(Object obj, lkxssdk.k.a<String> aVar) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            new d(this, jSONObjectA, aVar).start();
        }
    }

    @JavascriptInterface
    public String natGetDataFromNative(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("key", "");
            if (!TextUtils.isEmpty(strOptString)) {
                lkxssdk.h0.c.b("native Data:" + lkxssdk.l0.f.a().b.getString(strOptString, ""));
                return lkxssdk.l0.f.a().b.getString(strOptString, "");
            }
        }
        return "";
    }

    @JavascriptInterface
    public int natGetNetworkType(Object obj) {
        return lkxssdk.a.a.f().ordinal();
    }

    @JavascriptInterface
    public int natGetTaskState(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("id", "");
            String strOptString2 = jSONObjectA.optString("url", "");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                int iG = lkxssdk.a.a.g(strOptString2);
                if (iG == -1) {
                    return -1;
                }
                if (iG == 0) {
                    return 0;
                }
                if (iG == 2) {
                    return 1;
                }
                if (iG == 51) {
                    return 2;
                }
                switch (iG) {
                }
                return -1;
            }
        }
        g();
        return -1;
    }

    @JavascriptInterface
    public void natGetWechatCode(Object obj, lkxssdk.k.a<String> aVar) {
    }

    @JavascriptInterface
    public void natGetWechatInfo(Object obj, lkxssdk.k.a<String> aVar) {
    }

    @JavascriptInterface
    public void natLoginInfo(Object obj) {
    }

    @JavascriptInterface
    public int natOpenApp(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA == null) {
            return 0;
        }
        final String strOptString = jSONObjectA.optString("package", "");
        if (TextUtils.isEmpty(strOptString) || !lkxssdk.a.a.b(strOptString)) {
            return 0;
        }
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.a(strOptString);
            }
        });
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    @android.webkit.JavascriptInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int natOpenBrowser(java.lang.Object r5) {
        /*
            r4 = this;
            org.json.JSONObject r5 = r4.a(r5)
            r0 = 0
            if (r5 == 0) goto L4b
            java.lang.String r1 = "url"
            java.lang.String r2 = ""
            java.lang.String r5 = r5.optString(r1, r2)
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L4b
            android.content.Intent r1 = new android.content.Intent     // Catch: java.lang.Exception -> L46
            java.lang.String r2 = "android.intent.action.VIEW"
            android.net.Uri r3 = android.net.Uri.parse(r5)     // Catch: java.lang.Exception -> L46
            r1.<init>(r2, r3)     // Catch: java.lang.Exception -> L46
            com.lingku.xuanshang.core.ui.webview.WebViewWrapper r2 = r4.a     // Catch: java.lang.Exception -> L46
            com.lingku.xuanshang.core.ui.base.BaseActivity r2 = r2.getAty()     // Catch: java.lang.Exception -> L46
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch: java.lang.Exception -> L46
            java.util.List r1 = r2.queryIntentActivities(r1, r0)     // Catch: java.lang.Exception -> L46
            int r1 = r1.size()     // Catch: java.lang.Exception -> L46
            if (r1 <= 0) goto L40
            android.os.Handler r1 = r4.b     // Catch: java.lang.Exception -> L46
            lkxssdk.j.a$$ExternalSyntheticLambda5 r2 = new lkxssdk.j.a$$ExternalSyntheticLambda5     // Catch: java.lang.Exception -> L46
            r2.<init>()     // Catch: java.lang.Exception -> L46
            r1.post(r2)     // Catch: java.lang.Exception -> L46
            r5 = 1
            return r5
        L40:
            java.lang.String r5 = "xxxxxx"
            lkxssdk.h0.c.b(r5)     // Catch: java.lang.Exception -> L46
            goto L4e
        L46:
            r5 = move-exception
            r5.printStackTrace()
            goto L4e
        L4b:
            r4.g()
        L4e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lkxssdk.j.a.natOpenBrowser(java.lang.Object):int");
    }

    @JavascriptInterface
    public int natOpenQQ(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA == null) {
            return 0;
        }
        final String strOptString = jSONObjectA.optString("url", "");
        if (TextUtils.isEmpty(strOptString) || !lkxssdk.a.a.b(QqUtils.PACKAGENAME_QQ)) {
            return 0;
        }
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(strOptString);
            }
        });
        return 1;
    }

    @JavascriptInterface
    public void natOpenWebView(Object obj) {
        final JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(jSONObjectA);
                }
            });
        }
    }

    @JavascriptInterface
    public int natOpenWechat(Object obj) {
        if (!lkxssdk.a.a.b("com.tencent.mm")) {
            return 0;
        }
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda4
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c();
            }
        });
        return 1;
    }

    @JavascriptInterface
    public int natOpenWechatScan(Object obj) {
        if (!lkxssdk.a.a.b("com.tencent.mm")) {
            return 0;
        }
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda15
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d();
            }
        });
        return 1;
    }

    @JavascriptInterface
    public void natReqPermission(Object obj, final lkxssdk.k.a<String> aVar) {
        final JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda18
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.c(jSONObjectA, aVar);
                }
            });
        }
    }

    @JavascriptInterface
    public void natRestartApp(Object obj) {
        final JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda14
                @Override // java.lang.Runnable
                public final void run() {
                    a.b(jSONObjectA);
                }
            });
        }
    }

    @JavascriptInterface
    public void natSaveDataToFile(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            new c(this, jSONObjectA).start();
        }
    }

    @JavascriptInterface
    public void natSaveDataToNative(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("key", "");
            String strOptString2 = jSONObjectA.optString(com.alipay.sdk.m.p0.b.d, "");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            lkxssdk.l0.f.a().b.edit().putString(strOptString, strOptString2).apply();
        }
    }

    @JavascriptInterface
    public void natSaveWebPic(Object obj, final lkxssdk.k.a<String> aVar) {
        lkxssdk.h0.c.b("picData:" + obj.toString());
        final JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda19
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.d(jSONObjectA, aVar);
                }
            });
        }
    }

    @JavascriptInterface
    public void natScreenshot(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new b(jSONObjectA.optInt("isSupport", 1)));
        }
    }

    @JavascriptInterface
    public void natShare(Object obj, lkxssdk.k.a<String> aVar) {
    }

    @JavascriptInterface
    public void natShowToast(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            final String strOptString = jSONObjectA.optString("msg", "");
            final int iOptInt = jSONObjectA.optInt("duration", 0);
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda17
                @Override // java.lang.Runnable
                public final void run() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                    lkxssdk.m0.b.a().a(strOptString, iOptInt);
                }
            });
        }
    }

    @JavascriptInterface
    public void natStatusbarColor(final Object obj) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda12
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.c(obj);
            }
        });
    }

    @JavascriptInterface
    public int natSystemVersionInt(Object obj) {
        return Build.VERSION.SDK_INT;
    }

    @JavascriptInterface
    public void natTaskOperate(final Object obj) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda11
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.d(obj);
            }
        });
    }

    @JavascriptInterface
    public void natTaskStop(final Object obj) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda16
            @Override // java.lang.Runnable
            public final void run() throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                this.f$0.e(obj);
            }
        });
    }

    @JavascriptInterface
    public void natThirdApps(Object obj, lkxssdk.k.a<String> aVar) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            new lkxssdk.l.d(new e(this.a.getAty(), aVar), jSONObjectA.optBoolean("ignoreRecord", false)).start();
        }
    }

    @JavascriptInterface
    public void natUninstallApp(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("package", "");
            if (TextUtils.isEmpty(strOptString)) {
                return;
            }
            lkxssdk.a.a.a(this.a.getAty(), strOptString);
        }
    }

    @JavascriptInterface
    public void natUploadVideo(Object obj, final lkxssdk.k.a<String> aVar) {
        final JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() throws JSONException, UnsupportedEncodingException {
                    this.f$0.e(jSONObjectA, aVar);
                }
            });
        }
    }

    @JavascriptInterface
    public void natUserAgreement(Object obj) {
        lkxssdk.l0.f.a().b.getInt("agreeUserAgreement", 0);
        lkxssdk.l0.f.a().b.edit().putInt("agreeUserAgreement", 1).apply();
    }

    @JavascriptInterface
    public void natWebReload(Object obj) {
        this.b.post(new Runnable() { // from class: lkxssdk.j.a$$ExternalSyntheticLambda9
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        });
    }

    @JavascriptInterface
    public void natWechatPay(Object obj, lkxssdk.k.a<String> aVar) {
    }

    @JavascriptInterface
    public void natWechatPayH5(Object obj, lkxssdk.k.a<String> aVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject, lkxssdk.k.a aVar) {
        tagReqPermissionModel tagreqpermissionmodel = (tagReqPermissionModel) lkxssdk.l0.a.a(jSONObject, tagReqPermissionModel.class);
        WebViewWrapper webViewWrapper = this.a;
        int[] iArr = tagreqpermissionmodel.reqType;
        boolean z = tagreqpermissionmodel.toSet;
        if (webViewWrapper.m == null) {
            webViewWrapper.m = new k(webViewWrapper.a);
        }
        k kVar = webViewWrapper.m;
        kVar.a = iArr;
        kVar.b = aVar;
        if (!z) {
            kVar.a();
            return;
        }
        kVar.c = true;
        if (iArr[0] != 3) {
            lkxssdk.j0.d.c(kVar.e.getApplication());
            return;
        }
        Application application = kVar.e.getApplication();
        String str = lkxssdk.j0.c.a;
        Intent intent = new Intent();
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("android.provider.extra.APP_PACKAGE", application.getPackageName());
        } else if (i >= 21) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            intent.putExtra("app_package", application.getPackageName());
            intent.putExtra("app_uid", application.getApplicationInfo().uid);
        } else {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", application.getPackageName(), null));
        }
        intent.setFlags(268435456);
        try {
            application.startActivity(intent);
        } catch (Exception unused) {
            Intent intentA = lkxssdk.j0.c.a(application);
            intentA.setFlags(268435456);
            application.startActivity(intentA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Object obj) {
        JSONObject jSONObjectA = a(obj);
        if (jSONObjectA != null) {
            String strOptString = jSONObjectA.optString("id", "");
            String strOptString2 = jSONObjectA.optString("url", "");
            if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                r rVar = r.a.a;
                int iG = lkxssdk.a.a.g(strOptString2);
                if (iG != 0) {
                    if (iG == 8) {
                        BaseActivity baseActivity = rVar.b;
                        String str = rVar.a.pkg;
                        if (baseActivity != null) {
                            try {
                                baseActivity.startActivity(baseActivity.getPackageManager().getLaunchIntentForPackage(str));
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                        return;
                    }
                    if (iG == 10) {
                        lkxssdk.a.a.a(rVar.b, rVar.a.pkg);
                        return;
                    }
                    if (iG != 5) {
                        if (iG != 6) {
                            return;
                        }
                        rVar.d = true;
                        if (lkxssdk.a.a.a()) {
                            h hVar = j.a().c;
                            String strA = hVar.a(strOptString2, "");
                            synchronized (hVar.h) {
                                g gVarA = hVar.a(strA, hVar.f);
                                if (gVarA != null) {
                                    gVarA.i();
                                }
                            }
                            return;
                        }
                        return;
                    }
                }
                lkxssdk.a.a.j(strOptString2);
                return;
            }
        }
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(JSONObject jSONObject, lkxssdk.k.a aVar) throws JSONException, UnsupportedEncodingException {
        WebViewWrapper webViewWrapper = this.a;
        if (webViewWrapper.n == null) {
            webViewWrapper.n = new t(webViewWrapper.a);
        }
        t tVar = webViewWrapper.n;
        tVar.getClass();
        tagUploadFileData taguploadfiledata = (tagUploadFileData) lkxssdk.l0.a.a(jSONObject, tagUploadFileData.class);
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(Config.INPUT_DEF_PKG, tVar.a.getPackageName());
            jSONObject2.put(Config.INPUT_DEF_VERSION, lkxssdk.a.a.e(tVar.a.getPackageName()).c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String strD = lkxssdk.a.a.d(jSONObject2.toString());
        RequestParams requestParams = new RequestParams(taguploadfiledata.uploadUrl);
        requestParams.addBodyParameter("param", strD);
        requestParams.setMultipart(true);
        int length = taguploadfiledata.filePathArr.length;
        int i = 0;
        while (i < length) {
            String str = taguploadfiledata.filePathArr[i];
            i++;
            requestParams.addBodyParameter(n.z + i, new File(str), SelectMimeType.SYSTEM_VIDEO, str.substring(str.lastIndexOf("/")));
        }
        x.http().post(requestParams, new s(tVar, length, aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject, lkxssdk.k.a aVar) {
        WebViewWrapper webViewWrapper = this.a;
        if (webViewWrapper.n == null) {
            webViewWrapper.n = new t(webViewWrapper.a);
        }
        t tVar = webViewWrapper.n;
        tVar.c = true;
        tVar.b = aVar;
        int iOptInt = jSONObject.optInt("quality", 1);
        int iOptInt2 = jSONObject.optInt("chooseVideoMaxTime", 0);
        int iOptInt3 = jSONObject.optInt("takeVideoMaxTime", 0);
        int iOptInt4 = jSONObject.optInt("videoNumber", 1);
        i iVarB = i.b();
        iVarB.l = false;
        iVarB.k = iOptInt;
        iVarB.j = iOptInt3;
        iVarB.d = iOptInt4;
        iVarB.i = iOptInt2;
        iVarB.h = true;
        iVarB.e = 2;
        lkxssdk.a.a.a(tVar.a, (Class<?>) PickerActivity.class, 50000, 1, (Bundle) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, lkxssdk.k.a aVar) {
        WebViewWrapper webViewWrapper = this.a;
        if (webViewWrapper.n == null) {
            webViewWrapper.n = new t(webViewWrapper.a);
        }
        t tVar = webViewWrapper.n;
        tVar.c = true;
        tVar.b = aVar;
        int iOptInt = jSONObject.optInt("maxSideLength", 0);
        int iOptInt2 = jSONObject.optInt("maxKb", 0);
        int iOptInt3 = jSONObject.optInt("picNumber", 1);
        int iOptInt4 = jSONObject.optInt("cropType", 0);
        if (iOptInt3 > 1) {
            iOptInt4 = 0;
        }
        int iOptInt5 = jSONObject.optInt("detectQR", 0);
        int iOptInt6 = jSONObject.optInt("showCamera", 1);
        long jOptLong = jSONObject.optLong("filterTime", 0L);
        i iVarB = i.b();
        iVarB.l = true;
        iVarB.f = iOptInt;
        iVarB.g = iOptInt2;
        iVarB.d = iOptInt3;
        iVarB.h = iOptInt6 == 1;
        iVarB.c = iOptInt4;
        iVarB.b = jOptLong;
        iVarB.m = iOptInt5 == 1;
        iVarB.e = 3;
        lkxssdk.a.a.a(tVar.a, (Class<?>) PickerActivity.class, 50000, 1, (Bundle) null);
        String strOptString = jSONObject.optString("waterUrl", "");
        tVar.e = strOptString;
        if (!TextUtils.isEmpty(strOptString)) {
            if (!tVar.e.contains("empty.png")) {
                lkxssdk.a.a.a(tVar.e, (View) null, new p(tVar));
                return;
            }
            tVar.e = null;
        }
        tVar.d = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.a.getAty().getClass();
        while (true) {
            Stack<BaseActivity> stack = lkxssdk.d.a.a;
            if (stack == null || stack.isEmpty()) {
                break;
            }
            BaseActivity baseActivityLastElement = lkxssdk.d.a.a.lastElement();
            Stack<BaseActivity> stack2 = lkxssdk.d.a.a;
            if (stack2 != null && stack2.contains(baseActivityLastElement)) {
                lkxssdk.d.a.a.remove(baseActivityLastElement);
            }
            baseActivityLastElement.a();
        }
        BaseActivity baseActivity = BaseActivity.a;
        if (baseActivity != null) {
            baseActivity.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        BaseActivity aty = this.a.getAty();
        if (aty != null) {
            try {
                aty.startActivity(aty.getPackageManager().getLaunchIntentForPackage(str));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
