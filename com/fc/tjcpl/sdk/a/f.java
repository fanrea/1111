package com.fc.tjcpl.sdk.a;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.fc.tjcpl.sdk.c.a;
import com.fc.tjcpl.sdk.c.j;
import com.fc.tjcpl.sdk.view.CustomViewContent;
import com.fc.tjcpl.sdk.view.ViewDownloadBtn;
import com.kuaishou.socket.nano.SocketMessages;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class f extends Fragment {
    public String a;
    public Handler b;
    public String c;
    public String d;
    public String e;
    public String f;
    public CustomViewContent g;
    public Context h;
    public LinearLayout i;
    public TextView j;
    public TextView k;
    public boolean l;
    public boolean m;
    public String n;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            f.this.b();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.l = true;
            com.fc.tjcpl.sdk.b.a.b(f.this.h.getApplicationContext());
        }
    }

    public final void a() throws Throwable {
        boolean zMkdirs;
        StringBuilder sbAppend = new StringBuilder().append(this.h.getExternalFilesDir("TJDownload").getAbsolutePath());
        String str = File.separator;
        this.n = sbAppend.append(str).append(PointCategory.APP).toString();
        File file = new File(this.n);
        if (!file.exists() ? !file.mkdirs() : !file.canWrite()) {
            this.n = "";
            zMkdirs = true;
        } else {
            this.n = this.h.getFilesDir().getAbsolutePath() + str + "TJDownload" + str + PointCategory.APP;
            File file2 = new File(this.n);
            zMkdirs = !file2.exists() ? file2.mkdirs() : file2.canWrite();
        }
        if (!zMkdirs) {
            this.i.setVisibility(0);
            this.j.setText("需打开【读写手机存储】权限才能开始任务，请进入“权限管理”设置,如设置后仍无法访问，请重启应用");
            this.k.setText("立即设置");
            this.k.setOnClickListener(new h(this));
            return;
        }
        a.C0359a c0359aA = new a.C0359a(this.h.getApplicationContext()).b(2).c(1).a(10000);
        c0359aA.i = true;
        c0359aA.h = false;
        com.fc.tjcpl.sdk.c.a aVar = new com.fc.tjcpl.sdk.c.a(c0359aA);
        j jVarA = j.a();
        if (jVarA.a == null) {
            jVarA.a = aVar;
            jVarA.b = new com.fc.tjcpl.sdk.c.h(aVar);
        }
        CustomViewContent customViewContent = this.g;
        Uri.Builder builderBuildUpon = Uri.parse("https://app.91taojin.com.cn/").buildUpon();
        if (Build.VERSION.SDK_INT >= 29) {
            com.fc.tjcpl.sdk.b.a.a(builderBuildUpon, this.a, this.c, this.d, this.e);
        } else {
            com.fc.tjcpl.sdk.b.a.a(builderBuildUpon, this.a, "", "", "");
        }
        customViewContent.b.loadUrl(builderBuildUpon.build().toString());
    }

    public final void b() throws Throwable {
        try {
            this.f = com.fc.tjcpl.sdk.b.a.d();
        } catch (Exception unused) {
            this.f = "";
        }
        if (!TextUtils.isEmpty(this.f)) {
            a();
            return;
        }
        this.i.setVisibility(0);
        this.j.setText("需打开【获取手机信息】权限才能开始任务\n请进入“权限管理”设置");
        this.k.setText("立即设置");
        this.k.setOnClickListener(new b());
    }

    public final void c() throws Throwable {
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a();
            return;
        }
        if (!(i < 23 || this.h.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0)) {
            requestPermissions(new String[]{"android.permission.READ_PHONE_STATE"}, SocketMessages.PayloadType.SC_LIVE_OFFICIAL_PROGRAMME_DUMP_AUDIENCE);
            return;
        }
        this.i.setVisibility(8);
        if (!this.m) {
            b();
        } else {
            this.m = false;
            this.b.postDelayed(new a(), 500L);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        super.onActivityResult(i, i2, intent);
        com.fc.tjcpl.sdk.i.c.a("fragment onActivityResult");
        this.g.a(i, i2, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.h = getContext();
        getActivity();
        if (getArguments() != null) {
            this.a = getArguments().getString("taskId", "");
            String string = getArguments().getString("oaid", "");
            this.c = string;
            if (TextUtils.isEmpty(string)) {
                this.c = "";
            }
            this.d = "";
            this.e = "";
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(com.fc.tjcpl.sdk.b.a.a(layoutInflater.getContext(), "layout", "tj_fragment"), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        CustomViewContent customViewContent = this.g;
        if (customViewContent != null) {
            customViewContent.j = true;
            ViewDownloadBtn viewDownloadBtn = customViewContent.f;
            if (viewDownloadBtn != null && viewDownloadBtn.getVisibility() == 0) {
                customViewContent.f.a();
            }
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) throws Throwable {
        TextView textView;
        String str;
        super.onRequestPermissionsResult(i, strArr, iArr);
        com.fc.tjcpl.sdk.i.c.a("onRequestPermissionsResult");
        if (i != 1110 || iArr.length <= 0) {
            return;
        }
        if (iArr[0] == 0) {
            c();
            return;
        }
        boolean zShouldShowRequestPermissionRationale = shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE");
        this.i.setVisibility(0);
        TextView textView2 = this.j;
        if (zShouldShowRequestPermissionRationale) {
            textView2.setText("需打开【获取手机信息】权限才能开始任务\n请“允许”授权");
            textView = this.k;
            str = "立即授权";
        } else {
            textView2.setText("需打开【获取手机信息】权限才能开始任务\n请进入“权限管理”设置");
            textView = this.k;
            str = "立即设置";
        }
        textView.setText(str);
        this.k.setOnClickListener(new g(this, zShouldShowRequestPermissionRationale));
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        if (this.l) {
            this.m = true;
            this.l = false;
            c();
        } else {
            CustomViewContent customViewContent = this.g;
            if (customViewContent != null) {
                customViewContent.b();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws Throwable {
        super.onViewCreated(view, bundle);
        this.b = new Handler();
        Context applicationContext = this.h.getApplicationContext();
        com.fc.tjcpl.sdk.b.a.a(applicationContext == null ? com.fc.tjcpl.sdk.b.a.c() : (Application) applicationContext.getApplicationContext());
        com.fc.tjcpl.sdk.h.h.a();
        LinearLayout linearLayout = (LinearLayout) view.findViewById(com.fc.tjcpl.sdk.b.a.a(this.h, "id", "tj_permission_ll"));
        this.i = linearLayout;
        linearLayout.setVisibility(8);
        this.j = (TextView) view.findViewById(com.fc.tjcpl.sdk.b.a.a(this.h, "id", "tj_permission_tv"));
        this.k = (TextView) view.findViewById(com.fc.tjcpl.sdk.b.a.a(this.h, "id", "tj_set_btn"));
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(com.fc.tjcpl.sdk.b.a.a(this.h, "id", "tj_fragment_rl"));
        CustomViewContent customViewContent = new CustomViewContent(new com.fc.tjcpl.sdk.n.a(this));
        this.g = customViewContent;
        customViewContent.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.addView(this.g, 0);
        if (com.fc.tjcpl.sdk.b.a.f()) {
            c();
        } else {
            com.fc.tjcpl.sdk.l.f.a().a("请先初始化SDK", 1);
        }
    }
}
