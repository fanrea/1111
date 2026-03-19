package com.fc.tjcpl.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RelativeLayout;
import com.fc.tjcpl.sdk.a.b;
import com.fc.tjcpl.sdk.a.c;
import com.fc.tjcpl.sdk.a.d;
import com.fc.tjcpl.sdk.c.a;
import com.fc.tjcpl.sdk.c.j;
import com.fc.tjcpl.sdk.h.h;
import com.fc.tjcpl.sdk.l.e;
import com.fc.tjcpl.sdk.n.o;
import com.fc.tjcpl.sdk.n.y;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.fc.tjcpl.sdk.view.ViewDownloadBtn;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TJActivity extends Activity {
    public static final /* synthetic */ int k = 0;
    public CustomViewContent a;
    public boolean b;
    public String c;
    public Handler d;
    public String e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public String j;

    public static void a(TJActivity tJActivity) throws Throwable {
        tJActivity.getClass();
        try {
            tJActivity.h = com.fc.tjcpl.sdk.b.a.d();
        } catch (Exception unused) {
            tJActivity.h = "";
        }
        if (!TextUtils.isEmpty(tJActivity.h)) {
            tJActivity.a();
            return;
        }
        y yVar = new y(tJActivity);
        yVar.a(11, new b(tJActivity, yVar));
        yVar.a(false);
        yVar.b(false);
        yVar.a("需打开【获取手机信息】权限才能开始任务，请进入“权限管理”设置。");
        yVar.b("离开");
        yVar.c("立即设置");
        yVar.b(Color.parseColor("#079AFF"));
        yVar.b();
    }

    public final void b() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a();
            return;
        }
        String[] strArr = {"android.permission.READ_PHONE_STATE"};
        a aVar = new a();
        if (i >= 23) {
            ArrayList arrayList = new ArrayList();
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i2 = 0;
            while (true) {
                boolean z = true;
                if (i2 >= 1) {
                    break;
                }
                String str = strArr[i2];
                Context applicationContext = getApplicationContext();
                if (Build.VERSION.SDK_INT >= 23 && applicationContext.checkSelfPermission(str) != 0) {
                    z = false;
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
                i2++;
            }
            if (arrayList2.size() != 0) {
                com.fc.tjcpl.sdk.k.b bVar = new com.fc.tjcpl.sdk.k.b();
                Bundle bundle = new Bundle();
                bundle.putInt("request_code", 110);
                bundle.putStringArrayList("request_permissions", arrayList2);
                bVar.setArguments(bundle);
                bVar.a = aVar;
                getFragmentManager().beginTransaction().add(bVar, getClass().getName()).commit();
                return;
            }
        }
        aVar.a();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        this.a.a(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        if (!com.fc.tjcpl.sdk.b.a.f()) {
            finish();
            return;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(67108864);
        }
        this.d = new Handler();
        Intent intent = getIntent();
        this.c = intent.getStringExtra("taskId");
        String stringExtra = intent.getStringExtra("oaid");
        this.e = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            this.e = "";
        }
        this.f = "";
        this.g = "";
        Context applicationContext = getApplicationContext();
        com.fc.tjcpl.sdk.b.a.a(applicationContext == null ? com.fc.tjcpl.sdk.b.a.c() : (Application) applicationContext.getApplicationContext());
        h.a();
        CustomViewContent customViewContent = new CustomViewContent(new com.fc.tjcpl.sdk.n.a(this));
        this.a = customViewContent;
        customViewContent.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        setContentView(this.a);
        e.a(this, Color.parseColor("#ffffff"));
        b();
        TJListener tJListener = com.fc.tjcpl.sdk.b.a.f;
        if (tJListener != null) {
            tJListener.onShow();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TJListener tJListener = com.fc.tjcpl.sdk.b.a.f;
        if (tJListener != null) {
            tJListener.onClose();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        CustomViewContent customViewContent = this.a;
        if (!customViewContent.e || customViewContent.c.getVisibility() == 0) {
            TJActivity tJActivity = customViewContent.a.a;
            if (tJActivity != null) {
                tJActivity.a(true);
            }
        } else {
            customViewContent.b.callHandler("RouteBack", "", new o(customViewContent));
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRestart() {
        super.onRestart();
        this.a.b();
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.b) {
            this.i = true;
            this.b = false;
            b();
        }
    }

    public final void a() throws Throwable {
        boolean zMkdirs;
        StringBuilder sbAppend;
        String str;
        StringBuilder sbAppend2 = new StringBuilder().append(getApplicationContext().getExternalFilesDir("TJDownload").getAbsolutePath());
        String str2 = File.separator;
        this.j = sbAppend2.append(str2).append(PointCategory.APP).toString();
        File file = new File(this.j);
        if (!file.exists() ? !file.mkdirs() : !file.canWrite()) {
            this.j = "";
            zMkdirs = true;
        } else {
            this.j = getApplicationContext().getFilesDir().getAbsolutePath() + str2 + "TJDownload" + str2 + PointCategory.APP;
            File file2 = new File(this.j);
            zMkdirs = !file2.exists() ? file2.mkdirs() : file2.canWrite();
        }
        if (!zMkdirs) {
            y yVar = new y(this);
            yVar.a(11, new c(this, yVar));
            yVar.a(false);
            yVar.b(false);
            yVar.a("需打开【读写手机存储】权限才能开始任务，请进入“权限管理”设置,如设置后仍无法访问，请重启应用。");
            yVar.b("离开");
            yVar.c("立即设置");
            yVar.b(Color.parseColor("#079AFF"));
            yVar.b();
            return;
        }
        a.C0359a c0359aA = new a.C0359a(getApplicationContext()).b(2).c(1).a(10000);
        c0359aA.i = true;
        c0359aA.h = false;
        if (!TextUtils.isEmpty(this.j)) {
            String str3 = this.j;
            if (TextUtils.isEmpty(str3)) {
                com.fc.tjcpl.sdk.i.c.a("AppLoaderConfiguration", "设置的保存目录：null");
            } else {
                File file3 = new File(str3);
                if (file3.exists()) {
                    sbAppend = new StringBuilder().append("创建保存目录：").append(str3);
                    str = " 已存在";
                } else if (file3.mkdirs()) {
                    sbAppend = new StringBuilder().append("创建保存目录：").append(str3);
                    str = " success";
                } else {
                    sbAppend = new StringBuilder().append("创建保存目录：").append(str3);
                    str = " fail";
                }
                com.fc.tjcpl.sdk.i.c.a("AppLoaderConfiguration", sbAppend.append(str).toString());
                c0359aA.b = str3;
            }
        }
        com.fc.tjcpl.sdk.c.a aVar = new com.fc.tjcpl.sdk.c.a(c0359aA);
        j jVarA = j.a();
        if (jVarA.a == null) {
            jVarA.a = aVar;
            jVarA.b = new com.fc.tjcpl.sdk.c.h(aVar);
        }
        CustomViewContent customViewContent = this.a;
        Uri.Builder builderBuildUpon = Uri.parse("https://app.91taojin.com.cn/").buildUpon();
        if (Build.VERSION.SDK_INT >= 29) {
            com.fc.tjcpl.sdk.b.a.a(builderBuildUpon, this.c, this.e, this.f, this.g);
        } else {
            com.fc.tjcpl.sdk.b.a.a(builderBuildUpon, this.c, "", "", "");
        }
        customViewContent.b.loadUrl(builderBuildUpon.build().toString());
    }

    public class a implements com.fc.tjcpl.sdk.k.a {

        /* renamed from: com.fc.tjcpl.sdk.TJActivity$a$a, reason: collision with other inner class name */
        public class RunnableC0358a implements Runnable {
            public RunnableC0358a() {
            }

            @Override // java.lang.Runnable
            public void run() throws Throwable {
                TJActivity.a(TJActivity.this);
            }
        }

        public a() {
        }

        public void a(List<String> list, boolean z) {
            if (z) {
                TJActivity tJActivity = TJActivity.this;
                int i = TJActivity.k;
                tJActivity.getClass();
                y yVar = new y(tJActivity);
                yVar.a(11, new com.fc.tjcpl.sdk.a.e(tJActivity, yVar));
                yVar.a(false);
                yVar.b(false);
                yVar.a("需打开【获取手机信息】权限才能开始任务，请进入“权限管理”设置。");
                yVar.b("取消");
                yVar.c("立即设置");
                yVar.b(Color.parseColor("#079AFF"));
                yVar.b();
                return;
            }
            TJActivity tJActivity2 = TJActivity.this;
            int i2 = TJActivity.k;
            tJActivity2.getClass();
            y yVar2 = new y(tJActivity2);
            yVar2.a(11, new d(tJActivity2, yVar2));
            yVar2.a(false);
            yVar2.b(false);
            yVar2.a("需打开【获取手机信息】权限才能开始任务，请“允许”授权。");
            yVar2.b("取消");
            yVar2.c("立即授权");
            yVar2.b(Color.parseColor("#079AFF"));
            yVar2.b();
        }

        public void a() {
            TJActivity tJActivity = TJActivity.this;
            if (!tJActivity.i) {
                TJActivity.a(tJActivity);
            } else {
                tJActivity.i = false;
                TJActivity.this.d.postDelayed(new RunnableC0358a(), 500L);
            }
        }
    }

    public void a(boolean z) {
        CustomViewContent customViewContent = this.a;
        customViewContent.j = true;
        ViewDownloadBtn viewDownloadBtn = customViewContent.f;
        if (viewDownloadBtn != null && viewDownloadBtn.getVisibility() == 0) {
            customViewContent.f.a();
        }
        finish();
    }
}
