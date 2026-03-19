package com.fc.tjcpl.sdk.view;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobstat.forbes.Config;
import com.fc.tjcpl.sdk.c.g;
import com.fc.tjcpl.sdk.c.h;
import com.fc.tjcpl.sdk.c.j;
import com.fc.tjcpl.sdk.l.e;
import com.fc.tjcpl.sdk.l.f;
import com.fc.tjcpl.sdk.n.f0;
import com.fc.tjcpl.sdk.n.g0;
import com.fc.tjcpl.sdk.n.i0;
import java.io.File;
import java.util.List;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class ViewDownloadBtn extends RelativeLayout {
    public ProgressBar a;
    public TextView b;
    public com.fc.tjcpl.sdk.a.a c;
    public StateListDrawable d;
    public Handler e;
    public String f;
    public String g;
    public b h;
    public Context i;
    public i0 j;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.fc.tjcpl.sdk.a.a aVar;
            ViewDownloadBtn viewDownloadBtn = ViewDownloadBtn.this;
            com.fc.tjcpl.sdk.a.a aVar2 = viewDownloadBtn.c;
            if (!aVar2.o) {
                i0 i0Var = viewDownloadBtn.j;
                if (i0Var != null) {
                    ((CustomViewContent) i0Var).a("PopupUnLogin", "");
                    return;
                }
                return;
            }
            int iH = com.fc.tjcpl.sdk.b.a.h(aVar2.h);
            if (iH != 0) {
                if (iH == 2) {
                    if (com.fc.tjcpl.sdk.b.a.h()) {
                        aVar = ViewDownloadBtn.this.c;
                        if (aVar.l != 1) {
                            return;
                        }
                    } else {
                        aVar = ViewDownloadBtn.this.c;
                        if (aVar.k != 1) {
                            return;
                        }
                    }
                    e.a(aVar.e, 2, aVar.b, aVar.d);
                    com.fc.tjcpl.sdk.b.a.k(ViewDownloadBtn.this.c.h);
                    ViewDownloadBtn.this.b.setClickable(false);
                    return;
                }
                if (iH == 8) {
                    com.fc.tjcpl.sdk.a.a aVar3 = ViewDownloadBtn.this.c;
                    e.a(aVar3.e, 6, aVar3.b, aVar3.d);
                    ViewDownloadBtn viewDownloadBtn2 = ViewDownloadBtn.this;
                    com.fc.tjcpl.sdk.b.a.a(viewDownloadBtn2.i, viewDownloadBtn2.c.g);
                    return;
                }
                if (iH == 10) {
                    ViewDownloadBtn viewDownloadBtn3 = ViewDownloadBtn.this;
                    com.fc.tjcpl.sdk.b.a.b(viewDownloadBtn3.i, viewDownloadBtn3.c.g);
                    return;
                } else if (iH != 5) {
                    if (iH != 6) {
                        return;
                    }
                    com.fc.tjcpl.sdk.b.a.i(ViewDownloadBtn.this.c.h);
                    return;
                }
            }
            com.fc.tjcpl.sdk.a.a aVar4 = ViewDownloadBtn.this.c;
            if (aVar4.c == 1) {
                if (iH == 5) {
                    e.a(aVar4.e, 3, aVar4.b, aVar4.d);
                }
                com.fc.tjcpl.sdk.b.a.l(ViewDownloadBtn.this.c.h);
                if (ViewDownloadBtn.this.a.getVisibility() != 0) {
                    ViewDownloadBtn.this.a.setVisibility(0);
                }
                ViewDownloadBtn.this.b.setClickable(false);
                ViewDownloadBtn.this.b.setBackgroundResource(0);
                return;
            }
            e.a(aVar4.e, 1, aVar4.b, aVar4.d);
            String str = ViewDownloadBtn.this.c.h;
            if (com.fc.tjcpl.sdk.b.a.a()) {
                h hVar = j.a().b;
                String strA = hVar.a(str, "");
                synchronized (hVar.h) {
                    g gVarA = hVar.a(strA, hVar.f);
                    if (gVarA != null) {
                        gVarA.i = null;
                    }
                }
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(ViewDownloadBtn.this.c.h));
                intent.setFlags(268435456);
                ViewDownloadBtn.this.i.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ViewDownloadBtn(Context context) {
        super(context);
        this.f = "#0086E1";
        this.g = "#0098FF";
        this.i = context;
        b();
        c();
    }

    public void a() {
        com.fc.tjcpl.sdk.b.a.b(this.h);
        if (com.fc.tjcpl.sdk.b.a.a()) {
            j.a().b.a.b.set(false);
        }
        com.fc.tjcpl.sdk.a.a aVar = this.c;
        if (aVar == null || aVar.c != 1) {
            return;
        }
        if (com.fc.tjcpl.sdk.b.a.h(aVar.h) == 2) {
            f.a().a("已暂停任务下载", 0);
        }
        com.fc.tjcpl.sdk.b.a.k(this.c.h);
    }

    public final void b() {
        this.e = new Handler();
        this.h = new b();
        setBackgroundColor(Color.parseColor("#FFFFFF"));
        int iA = com.fc.tjcpl.sdk.b.a.a(10.0f);
        int iA2 = com.fc.tjcpl.sdk.b.a.a(30.0f);
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.fc.tjcpl.sdk.b.a.a(0.5f));
        layoutParams.addRule(10);
        imageView.setBackgroundColor(Color.parseColor("#dddddd"));
        addView(imageView, layoutParams);
        ProgressBar progressBar = new ProgressBar(com.fc.tjcpl.sdk.b.a.b(), null, R.attr.progressBarStyleHorizontal);
        this.a = progressBar;
        progressBar.setMax(1000);
        this.a.setProgress(0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(iA2, iA, iA2, iA);
        addView(this.a, layoutParams2);
        TextView textView = new TextView(getContext());
        this.b = textView;
        textView.setText("开始任务");
        this.b.setGravity(17);
        this.b.setTextColor(-1);
        addView(this.b, layoutParams2);
        this.a.setVisibility(4);
        this.b.setOnClickListener(new a());
    }

    public final void c() {
        String str = this.f;
        String str2 = this.g;
        float fA = com.fc.tjcpl.sdk.b.a.a(5.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(fA);
        gradientDrawable.setColor(Color.parseColor(str));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(0);
        gradientDrawable2.setCornerRadius(fA);
        gradientDrawable2.setColor(Color.parseColor(str2));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable);
        stateListDrawable.addState(new int[]{-16842919}, gradientDrawable2);
        this.d = stateListDrawable;
        this.b.setBackground(stateListDrawable);
        ProgressBar progressBar = this.a;
        String str3 = this.f;
        String str4 = this.g;
        float fA2 = com.fc.tjcpl.sdk.b.a.a(5.0f);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setShape(0);
        gradientDrawable3.setCornerRadius(fA2);
        gradientDrawable3.setColor(Color.parseColor(str4));
        progressBar.setBackgroundDrawable(gradientDrawable3);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setShape(0);
        gradientDrawable4.setCornerRadius(fA2);
        gradientDrawable4.setColor(Color.parseColor(str3));
        progressBar.setProgressDrawable(new ClipDrawable(gradientDrawable4, 3, 1));
    }

    public void setData(com.fc.tjcpl.sdk.a.a aVar) {
        Handler handler;
        Runnable g0Var;
        List<String> list;
        setVisibility(0);
        this.c = aVar;
        if (aVar.a != 1) {
            this.b.setClickable(false);
            this.a.setVisibility(8);
            TextView textView = this.b;
            float fA = com.fc.tjcpl.sdk.b.a.a(5.0f);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(fA);
            gradientDrawable.setColor(Color.parseColor("#999999"));
            textView.setBackground(gradientDrawable);
            this.b.setText("暂时无法体验");
            return;
        }
        if (!aVar.t.equals(this.f) || !this.c.s.equals(this.g)) {
            com.fc.tjcpl.sdk.a.a aVar2 = this.c;
            this.f = aVar2.t;
            this.g = aVar2.s;
            c();
        }
        com.fc.tjcpl.sdk.b.a.a(this.h);
        this.b.setClickable(true);
        this.b.setBackground(this.d);
        this.a.setVisibility(8);
        this.a.setProgress(0);
        com.fc.tjcpl.sdk.a.a aVar3 = this.c;
        com.fc.tjcpl.sdk.f.a aVar4 = new com.fc.tjcpl.sdk.f.a(aVar3.h);
        aVar4.a = aVar3.e;
        aVar4.d = aVar3.g;
        if (aVar3.p && (list = aVar3.q) != null && list.size() > 0) {
            aVar4.e = this.c.q;
        }
        this.b.setText("下载");
        this.b.setClickable(true);
        com.fc.tjcpl.sdk.b.a.a(aVar4);
        com.fc.tjcpl.sdk.b.a.c(this.c.h);
        int iH = com.fc.tjcpl.sdk.b.a.h(this.c.h);
        if ((iH == 0 || iH == 5) && this.c.c == 1) {
            if (com.fc.tjcpl.sdk.b.a.h()) {
                if (this.c.j != 1) {
                    return;
                }
                handler = this.e;
                g0Var = new f0(this);
            } else {
                if (this.c.i != 1) {
                    return;
                }
                handler = this.e;
                g0Var = new g0(this);
            }
            handler.postDelayed(g0Var, 200L);
        }
    }

    public void setWebListener(i0 i0Var) {
        this.j = i0Var;
    }

    public class b implements com.fc.tjcpl.sdk.e.b {
        public b() {
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar) {
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar, com.fc.tjcpl.sdk.e.a aVar2) {
            int i;
            f fVarA;
            String string;
            StringBuilder sbAppend;
            f fVarA2;
            String str;
            if (aVar2 == null || (i = aVar2.a) == 8) {
                return;
            }
            if (i == 9 || i == 4) {
                fVarA = f.a();
                string = "请检查您的网络，如网络没有问题，请通过“在线客服”反馈该问题！";
            } else {
                if (i == 3) {
                    fVarA = f.a();
                    sbAppend = new StringBuilder().append("下载地址不可用_").append(aVar2.a).append(Config.replace);
                } else {
                    if (i == 2) {
                        int i2 = aVar2.b;
                        if (i2 == 22) {
                            fVarA2 = f.a();
                            str = "存储空间不足";
                        } else {
                            if (i2 != 23) {
                                return;
                            }
                            fVarA2 = f.a();
                            str = "无读写存储权限";
                        }
                        fVarA2.a(str, 0);
                        return;
                    }
                    fVarA = f.a();
                    sbAppend = new StringBuilder().append("下载失败，错误码：").append(aVar2.a).append(Config.replace);
                }
                string = sbAppend.append(aVar2.b).toString();
            }
            fVarA.a(string, 0);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void b(com.fc.tjcpl.sdk.f.a aVar) {
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void c(com.fc.tjcpl.sdk.f.a aVar) {
            ViewDownloadBtn viewDownloadBtn = ViewDownloadBtn.this;
            com.fc.tjcpl.sdk.a.a aVar2 = viewDownloadBtn.c;
            if (aVar2.c != 1 && aVar2.r == 1) {
                viewDownloadBtn.b.setText("重新下载");
            } else {
                viewDownloadBtn.b.setText("开始任务");
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void d(com.fc.tjcpl.sdk.f.a aVar) {
            com.fc.tjcpl.sdk.a.a aVar2 = ViewDownloadBtn.this.c;
            e.a(aVar2.e, 1, aVar2.b, aVar2.d);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void e(com.fc.tjcpl.sdk.f.a aVar) {
            ViewDownloadBtn.this.b.setText("暂停中");
            ViewDownloadBtn.this.b.setClickable(false);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void f(com.fc.tjcpl.sdk.f.a aVar) {
            ViewDownloadBtn.this.b.setText("点击卸载旧版本");
            ViewDownloadBtn.this.b.setClickable(true);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void g(com.fc.tjcpl.sdk.f.a aVar) {
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void h(com.fc.tjcpl.sdk.f.a aVar) {
            ViewDownloadBtn.this.a.setVisibility(4);
            ViewDownloadBtn.this.b.setText("继续任务");
            ViewDownloadBtn viewDownloadBtn = ViewDownloadBtn.this;
            viewDownloadBtn.b.setBackground(viewDownloadBtn.d);
            ViewDownloadBtn.this.b.setClickable(true);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void i(com.fc.tjcpl.sdk.f.a aVar) {
            ViewDownloadBtn.this.b.setClickable(true);
            ViewDownloadBtn viewDownloadBtn = ViewDownloadBtn.this;
            viewDownloadBtn.b.setBackground(viewDownloadBtn.d);
            ViewDownloadBtn viewDownloadBtn2 = ViewDownloadBtn.this;
            com.fc.tjcpl.sdk.a.a aVar2 = viewDownloadBtn2.c;
            if (aVar2.c == 1) {
                viewDownloadBtn2.b.setText("继续下载");
            } else if (aVar2.r == 1) {
                viewDownloadBtn2.b.setText("重新下载");
            } else {
                viewDownloadBtn2.b.setText("开始任务");
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void j(com.fc.tjcpl.sdk.f.a aVar) {
            com.fc.tjcpl.sdk.a.a aVar2 = ViewDownloadBtn.this.c;
            e.a(aVar2.e, 4, aVar2.b, aVar2.d);
            ViewDownloadBtn.this.a.setVisibility(4);
            ViewDownloadBtn.this.b.setText("安装");
            ViewDownloadBtn viewDownloadBtn = ViewDownloadBtn.this;
            viewDownloadBtn.b.setBackground(viewDownloadBtn.d);
            ViewDownloadBtn.this.b.setClickable(true);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void k(com.fc.tjcpl.sdk.f.a aVar) {
            ViewDownloadBtn.this.a.setVisibility(4);
            ViewDownloadBtn.this.b.setText("安装中");
            ViewDownloadBtn.this.b.setClickable(false);
            ViewDownloadBtn viewDownloadBtn = ViewDownloadBtn.this;
            viewDownloadBtn.b.setBackground(viewDownloadBtn.d);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void l(com.fc.tjcpl.sdk.f.a aVar) {
            ViewDownloadBtn.this.b.setText("验证中...");
            ViewDownloadBtn.this.b.setClickable(false);
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar, String str) throws Throwable {
            com.fc.tjcpl.sdk.a.a aVar2;
            if (TextUtils.isEmpty(str) || (aVar2 = ViewDownloadBtn.this.c) == null) {
                return;
            }
            if (str.equals(aVar2.g)) {
                com.fc.tjcpl.sdk.a.a aVar3 = ViewDownloadBtn.this.c;
                e.a(aVar3.e, 5, aVar3.b, aVar3.d);
                ViewDownloadBtn viewDownloadBtn = ViewDownloadBtn.this;
                viewDownloadBtn.getClass();
                boolean z = false;
                if (!com.fc.tjcpl.sdk.b.a.h() ? viewDownloadBtn.c.m == 1 : viewDownloadBtn.c.n == 1) {
                    z = true;
                }
                if (z) {
                    com.fc.tjcpl.sdk.a.a aVar4 = viewDownloadBtn.c;
                    e.a(aVar4.e, 6, aVar4.b, aVar4.d);
                    com.fc.tjcpl.sdk.b.a.a(viewDownloadBtn.i, str);
                }
            }
            g gVarB = com.fc.tjcpl.sdk.b.a.b(aVar);
            if (gVarB != null) {
                com.fc.tjcpl.sdk.a.a aVar5 = ViewDownloadBtn.this.c;
                e.a(aVar5.f, aVar5.g, gVarB.b.e + File.separator + gVarB.b.f);
            }
        }

        @Override // com.fc.tjcpl.sdk.e.b
        public void a(com.fc.tjcpl.sdk.f.a aVar, long j, long j2) {
            if (ViewDownloadBtn.this.a.getVisibility() != 0) {
                ViewDownloadBtn.this.a.setVisibility(0);
            }
            ViewDownloadBtn.this.a.setProgress(j > 0 ? (int) (((j2 * 1.0d) / j) * 1000.0d) : 0);
            ViewDownloadBtn.this.b.setText((j > 0 ? new StringBuilder().append("下载中").append(" ").append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(j2 / 1048576.0f))).append("MB/").append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(j / 1048576.0f))) : new StringBuilder().append("下载中").append("... ").append(String.format(Locale.getDefault(), "%.1f", Float.valueOf(j2 / 1048576.0f)))).append("MB").toString());
            ViewDownloadBtn.this.b.setClickable(true);
            ViewDownloadBtn.this.b.setBackgroundResource(0);
        }
    }
}
