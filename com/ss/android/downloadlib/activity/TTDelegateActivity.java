package com.ss.android.downloadlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.sigmob.sdk.base.n;
import com.ss.android.d.d.hc.k;
import com.ss.android.d.d.hc.v;
import com.ss.android.d.d.u.b;
import com.ss.android.downloadlib.addownload.d.u;
import com.ss.android.downloadlib.addownload.e;
import com.ss.android.downloadlib.addownload.hc.an;
import com.ss.android.downloadlib.addownload.mq;
import com.ss.android.downloadlib.guide.install.d;
import com.ss.android.downloadlib.h.gb;
import com.ss.android.downloadlib.h.uo;
import com.ss.android.downloadlib.tc;
import com.ss.android.hc.d.hc.hc;
import com.ss.android.socialbase.downloader.downloader.h;
import com.ss.android.socialbase.downloader.h.b;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class TTDelegateActivity extends Activity {
    private static d c;
    private hc b;
    protected Intent d = null;
    private boolean hc;

    public static void d(String str, String[] strArr) {
        Intent intent = new Intent(mq.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 1);
        intent.putExtra("permission_id_key", str);
        intent.putExtra("permission_content_key", strArr);
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intent);
        }
    }

    public static void d(String str, com.ss.android.hc.d.hc.d dVar) {
        Intent intentB = b(dVar);
        intentB.addFlags(268435456);
        intentB.putExtra("type", 2);
        intentB.putExtra("open_url", str);
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intentB);
        }
    }

    public static void hc(String str, com.ss.android.hc.d.hc.d dVar) {
        Intent intentB = b(dVar);
        intentB.addFlags(268435456);
        intentB.putExtra("type", 11);
        intentB.putExtra(n.p, str);
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intentB);
        }
    }

    public static void d(com.ss.android.hc.d.hc.d dVar) {
        Intent intentB = b(dVar);
        intentB.addFlags(268435456);
        intentB.putExtra("type", 4);
        intentB.putExtra("model_id", dVar.hc());
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intentB);
        }
    }

    public static void d(com.ss.android.hc.d.hc.d dVar, d dVar2) {
        Intent intentB = b(dVar);
        intentB.addFlags(268435456);
        intentB.putExtra("type", 9);
        c = dVar2;
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intentB);
        }
    }

    public static void d(long j) {
        Intent intent = new Intent(mq.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 10);
        intent.putExtra("app_info_id", j);
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intent);
        }
    }

    public static void d(String str, long j, String str2, JSONObject jSONObject) {
        Intent intent = new Intent(mq.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 12);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        intent.putExtra("param", str2);
        intent.putExtra("ext_json", jSONObject.toString());
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intent);
        }
    }

    public static void d(String str, long j, String str2) {
        Intent intent = new Intent(mq.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 13);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        intent.putExtra("need_comment", str2);
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intent);
        }
    }

    public static void hc(String str, long j, String str2) {
        Intent intent = new Intent(mq.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 14);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        intent.putExtra("market_app_id", str2);
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intent);
        }
    }

    public static void d(String str, long j) {
        Intent intent = new Intent(mq.getContext(), (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 15);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intent);
        }
    }

    public static void d(Context context, String str, long j) {
        Intent intent = new Intent(context, (Class<?>) TTDelegateActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("type", 16);
        intent.putExtra(n.p, str);
        intent.putExtra("model_id", j);
        if (context != null) {
            context.startActivity(intent);
        }
    }

    private static Intent b(com.ss.android.hc.d.hc.d dVar) {
        return new Intent(mq.getContext(), (Class<?>) TTDelegateActivity.class);
    }

    public static void hc(com.ss.android.hc.d.hc.d dVar) {
        d(dVar, 5, "", "", "", "");
    }

    public static void d(com.ss.android.hc.d.hc.d dVar, String str) {
        d(dVar, 19, "", "", "", str);
    }

    public static void d(com.ss.android.hc.d.hc.d dVar, String str, String str2, String str3) {
        d(dVar, 8, str, str2, str3, "");
    }

    public static void d(com.ss.android.hc.d.hc.d dVar, String str, String str2, String str3, String str4) {
        d(dVar, 21, str, str2, str3, str4);
    }

    public static void hc(com.ss.android.hc.d.hc.d dVar, String str, String str2, String str3) {
        d(dVar, 7, str, str2, str3, "");
    }

    public static void hc(com.ss.android.hc.d.hc.d dVar, String str, String str2, String str3, String str4) {
        d(dVar, 20, str, str2, str3, str4);
    }

    private static void d(com.ss.android.hc.d.hc.d dVar, int i, String str, String str2, String str3, String str4) {
        Intent intentB = b(dVar);
        intentB.addFlags(268435456);
        intentB.putExtra("type", i);
        if (!TextUtils.isEmpty(str2)) {
            intentB.putExtra("positive_button_text", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intentB.putExtra("negative_button_text", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            intentB.putExtra("delete_button_text", str4);
        }
        if (!TextUtils.isEmpty(str)) {
            intentB.putExtra("message_text", str);
        }
        intentB.putExtra("model_id", dVar.hc());
        if (mq.getContext() != null) {
            mq.getContext().startActivity(intentB);
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) throws JSONException {
        super.onCreate(bundle);
        hc();
        this.d = getIntent();
        mq.hc(this);
        d();
    }

    private void hc() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) throws JSONException {
        super.onNewIntent(intent);
        setIntent(intent);
        this.d = intent;
        mq.hc(this);
        d();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        mq.u().d(this, i, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onStop() {
        hc hcVar;
        b bVarHc;
        super.onStop();
        if (!this.hc || (hcVar = this.b) == null) {
            return;
        }
        if (!TextUtils.isEmpty(hcVar.ey())) {
            bVarHc = tc.d(mq.getContext()).d(this.b.ey(), null, true);
        } else {
            bVarHc = tc.d(mq.getContext()).hc(this.b.d());
        }
        if (bVarHc == null || bVarHc.js() < bVarHc.mb() || isFinishing()) {
            return;
        }
        finish();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    protected void d() throws JSONException {
        Intent intent = this.d;
        if (intent != null) {
            switch (intent.getIntExtra("type", 0)) {
                case 1:
                    hc(this.d.getStringExtra("permission_id_key"), this.d.getStringArrayExtra("permission_content_key"));
                    break;
                case 2:
                    d(this.d.getStringExtra("open_url"));
                    break;
                case 3:
                case 6:
                case 17:
                case 18:
                default:
                    com.ss.android.socialbase.appdownloader.b.d((Activity) this);
                    break;
                case 4:
                    hc(this.d.getLongExtra("model_id", 0L));
                    break;
                case 5:
                    d(this.d.getLongExtra("model_id", 0L), "");
                    break;
                case 7:
                case 8:
                case 20:
                case 21:
                    b();
                    break;
                case 9:
                    d dVar = c;
                    if (dVar != null) {
                        dVar.d();
                    }
                    com.ss.android.socialbase.appdownloader.b.d((Activity) this);
                    break;
                case 10:
                    b(this.d.getLongExtra("app_info_id", 0L));
                    break;
                case 11:
                    hc(this.d.getStringExtra(n.p));
                    break;
                case 12:
                    gb.d(this, this.d.getStringExtra(n.p), this.d.getLongExtra("model_id", 0L), this.d.getStringExtra("param"), this.d.getStringExtra("ext_json"));
                    com.ss.android.socialbase.appdownloader.b.d((Activity) this);
                    break;
                case 13:
                    gb.d(this, this.d.getStringExtra(n.p), this.d.getLongExtra("model_id", 0L), this.d.getStringExtra("need_comment"));
                    com.ss.android.socialbase.appdownloader.b.d((Activity) this);
                    break;
                case 14:
                    gb.hc(this, this.d.getStringExtra(n.p), this.d.getLongExtra("model_id", 0L), this.d.getStringExtra("market_app_id"));
                    com.ss.android.socialbase.appdownloader.b.d((Activity) this);
                    break;
                case 15:
                    gb.d(this, this.d.getStringExtra(n.p), this.d.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.b.d((Activity) this);
                    break;
                case 16:
                    gb.hc(this, this.d.getStringExtra(n.p), this.d.getLongExtra("model_id", 0L));
                    com.ss.android.socialbase.appdownloader.b.d((Activity) this);
                    break;
                case 19:
                    d(this.d.getLongExtra("model_id", 0L), this.d.getStringExtra("delete_button_text"));
                    break;
            }
            this.d = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 442
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.activity.TTDelegateActivity.b():void");
    }

    private void d(long j, String str) throws JSONException {
        if (e.d() == null) {
            return;
        }
        hc hcVarC = an.d().c(j);
        if (hcVarC != null) {
            b bVarGb = h.hc(mq.getContext()).gb(hcVarC.rf());
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("time_after_click", Long.valueOf(System.currentTimeMillis() - hcVarC.yn()));
                jSONObject.putOpt("click_download_size", Long.valueOf(hcVarC.l()));
                if (bVarGb != null) {
                    jSONObject.putOpt("download_length", Long.valueOf(bVarGb.js()));
                    jSONObject.putOpt("download_percent", Long.valueOf(bVarGb.js() / bVarGb.mb()));
                    jSONObject.putOpt("download_apk_size", Long.valueOf(bVarGb.mb()));
                    jSONObject.putOpt("download_current_bytes", Integer.valueOf((int) (bVarGb.js() / 1048576)));
                    jSONObject.putOpt("download_total_bytes", Integer.valueOf((int) (bVarGb.mb() / 1048576)));
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.mq.d(e);
            }
            if (!TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.c.d.d().d("cancel_pause_reserve_wifi_dialog_show", jSONObject, hcVarC);
            } else {
                com.ss.android.downloadlib.c.d.d().hc("pause_reserve_wifi_dialog_show", jSONObject, hcVarC);
            }
        }
        u.d dVarD = new u.d(this).d(false).d(e.d());
        if (!TextUtils.isEmpty(str)) {
            dVarD.c(str).d(e.hc());
        }
        dVarD.d().show();
        this.hc = true;
        this.b = hcVarC;
    }

    private void hc(final String str, String[] strArr) {
        if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
            com.ss.android.socialbase.appdownloader.b.d((Activity) this);
            return;
        }
        v vVar = new v() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.1
            private WeakReference<Activity> b;

            {
                this.b = new WeakReference<>(TTDelegateActivity.this);
            }

            @Override // com.ss.android.d.d.hc.v
            public void d() {
                com.ss.android.downloadlib.h.tc.d(str);
                com.ss.android.socialbase.appdownloader.b.d(this.b.get());
            }

            @Override // com.ss.android.d.d.hc.v
            public void d(String str2) {
                com.ss.android.downloadlib.h.tc.d(str, str2);
                com.ss.android.socialbase.appdownloader.b.d(this.b.get());
            }
        };
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                mq.u().d(this, strArr, vVar);
                return;
            } catch (Exception e) {
                mq.jh().d(e, "requestPermission");
            }
        }
        vVar.d();
    }

    private void d(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.putExtra("open_url", str);
            intent.addFlags(268435456);
            if (com.ss.android.socialbase.downloader.uo.d.b().d("fix_app_link_flag")) {
                intent.addFlags(67108864);
            }
            intent.putExtra("start_only_for_android", true);
            startActivity(intent);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        } finally {
            com.ss.android.socialbase.appdownloader.b.d((Activity) this);
        }
    }

    private void hc(String str) {
        Intent intentH = uo.h(this, str);
        if (intentH == null) {
            return;
        }
        try {
            intentH.addFlags(268435456);
            intentH.putExtra("start_only_for_android", true);
            startActivity(intentH);
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.mq.d(e);
        } finally {
            com.ss.android.socialbase.appdownloader.b.d((Activity) this);
        }
    }

    private void hc(long j) throws JSONException {
        final hc hcVarC = an.d().c(j);
        if (hcVarC == null) {
            com.ss.android.downloadlib.u.b.d().d("showOpenAppDialogInner nativeModel null");
            com.ss.android.socialbase.appdownloader.b.d((Activity) this);
            return;
        }
        k kVarB = mq.b();
        b.d dVarD = new b.d(this).d("已安装完成");
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(hcVarC.tr()) ? "刚刚下载的应用" : hcVarC.tr();
        kVarB.hc(dVarD.hc(String.format("%1$s已安装完成，是否立即打开？", objArr)).b("打开").c("取消").d(false).d(uo.c(this, hcVarC.u())).d(new b.hc() { // from class: com.ss.android.downloadlib.activity.TTDelegateActivity.2
            @Override // com.ss.android.d.d.u.b.hc
            public void d(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.hc.d.hc(hcVarC);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.b.d((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.d.d.u.b.hc
            public void hc(DialogInterface dialogInterface) {
                com.ss.android.downloadlib.c.d.d().hc("market_openapp_cancel", hcVarC);
                TTDelegateActivity tTDelegateActivity = TTDelegateActivity.this;
                if (tTDelegateActivity != null && !tTDelegateActivity.isFinishing()) {
                    dialogInterface.dismiss();
                }
                com.ss.android.socialbase.appdownloader.b.d((Activity) TTDelegateActivity.this);
            }

            @Override // com.ss.android.d.d.u.b.hc
            public void b(DialogInterface dialogInterface) {
                com.ss.android.socialbase.appdownloader.b.d((Activity) TTDelegateActivity.this);
            }
        }).d(2).d());
        com.ss.android.downloadlib.c.d.d().hc("market_openapp_window_show", hcVarC);
    }

    private void b(long j) {
        new com.ss.android.downloadlib.addownload.compliance.d(this, j).show();
    }
}
