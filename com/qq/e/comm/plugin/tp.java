package com.qq.e.comm.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.text.style.BulletSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mobads.container.rewardvideo.RemoteRewardActivity;
import com.qq.e.comm.pi.ACTD;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.rr;
import com.qq.e.comm.plugin.wp;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tp implements ACTD, View.OnClickListener {
    private final Activity a;
    private String b;
    private h4 c;
    private i3 d;
    private ImageView e;
    private TextView f;
    private up g;
    private up h;
    private up i;
    private up j;
    private View m;
    private View n;
    private TextView o;
    private View p;
    private Future<hw> q;

    private FrameLayout b() {
        FrameLayout frameLayout = new FrameLayout(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        jm jmVarA = new qh(this.a, this.c).a();
        jmVarA.loadUrl(this.d.d());
        View viewA = jmVarA.a();
        this.p = viewA;
        frameLayout.addView(viewA, layoutParams);
        jm jmVarA2 = new qh(this.a, this.c).a();
        jmVarA2.loadUrl(this.d.c());
        View viewA2 = jmVarA2.a();
        this.n = viewA2;
        frameLayout.addView(viewA2, layoutParams);
        jm jmVarA3 = new qh(this.a, this.c).a();
        jmVarA3.loadUrl(this.d.h());
        View viewA3 = jmVarA3.a();
        this.m = viewA3;
        frameLayout.addView(viewA3, layoutParams);
        TextView textView = new TextView(this.a);
        this.o = textView;
        textView.setBackgroundColor(-1);
        this.o.setText("权限信息获取中...");
        this.o.setTextColor(-13421773);
        this.o.setMovementMethod(new ScrollingMovementMethod());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        int iA = yu.a((Context) this.a, 4);
        this.o.setPadding(iA, 0, iA, 0);
        frameLayout.addView(this.o, layoutParams2);
        this.q = sr.a().a(new cu(this.d.g(), aw.a.GET, (byte[]) null), rr.a.Mid, new a());
        return frameLayout;
    }

    private ViewGroup c() {
        RelativeLayout relativeLayout = new RelativeLayout(this.a);
        TextView textView = new TextView(this.a);
        this.f = textView;
        textView.setId(4660);
        this.f.setTextColor(-13421773);
        this.f.setTextSize(2, 16.0f);
        this.f.setTypeface(Typeface.defaultFromStyle(1));
        this.f.setEllipsize(TextUtils.TruncateAt.END);
        this.f.setText(this.d.a());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.topMargin = yu.a((Context) this.a, 20);
        relativeLayout.addView(this.f, layoutParams);
        ImageView imageView = new ImageView(this.a);
        this.e = imageView;
        imageView.setId(4661);
        this.e.setImageBitmap(gw.a("iVBORw0KGgoAAAANSUhEUgAAABIAAAAfCAYAAADqUJ2JAAAAAXNSR0IArs4c6QAAAERlWElmTU0AKgAAAAgAAYdpAAQAAAABAAAAGgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAEqADAAQAAAABAAAAHwAAAABiOXbkAAABU0lEQVRIDaXVO07DQBAGYO/aQrKUzgXKCUJjGruDIhGi4AAWB6Cl5Qacgysg0SCakCI0ll1QUtgtVK7oItn8Q7JWovgxu7tFxrZ2vo2lGY/rGK4kSU58378Kw/CnKIqNNHGiKJqWZfmJ3LeqqlZkaEOECCHekXtGANZp0zRCC1IIEmdbw9kg3gNu2FAX4rrubZZlL4SKnTwY+pA0TZ9V4ijEQQgbhLjIIKSD9EK6SCdkghxBpsgBZIO0kC1CkKQuRlzulz1V7H6x0caxJdHFc2xSDehIKR91ETpEBkHwgfhNN7Tqun7Aq15u7/i//5Udx/EMr0afhuku9RfxJs/zNZdqW8QWayE62QY7gGywI8gU64RMsF5IFxuEdLBRiIuxIA7GHkcYO1+YXwugqp0muH5F7V3QQWyINvdgT9qTtgsDUmtNWkLUon+G63MAd57nXdPzP9A5AGXXq8l4AAAAAElFTkSuQmCC"));
        this.e.setOnClickListener(this);
        int iA = yu.a((Context) this.a, 16);
        int iA2 = yu.a((Context) this.a, 10);
        int i = iA + (iA2 * 2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        this.e.setPadding(iA2, iA2, iA2, iA2);
        layoutParams2.topMargin = yu.a((Context) this.a, 12);
        layoutParams2.leftMargin = yu.a((Context) this.a, 6);
        relativeLayout.addView(this.e, layoutParams2);
        LinearLayout linearLayout = new LinearLayout(this.a);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = yu.a((Context) this.a, 20);
        layoutParams3.addRule(3, 4660);
        layoutParams3.addRule(14);
        linearLayout.setOrientation(0);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.weight = 1.0f;
        up upVar = new up(this.a, "权限详情");
        this.g = upVar;
        upVar.setId(4662);
        this.g.setOnClickListener(this);
        this.g.a(true);
        linearLayout.addView(this.g, layoutParams4);
        up upVar2 = new up(this.a, "隐私协议");
        this.h = upVar2;
        upVar2.setId(4663);
        this.h.setOnClickListener(this);
        linearLayout.addView(this.h, layoutParams4);
        up upVar3 = new up(this.a, "功能介绍");
        this.i = upVar3;
        upVar3.setId(4664);
        this.i.setOnClickListener(this);
        linearLayout.addView(this.i, layoutParams4);
        up upVar4 = new up(this.a, "备案信息");
        this.j = upVar4;
        upVar4.setId(4665);
        this.j.setOnClickListener(this);
        linearLayout.addView(this.j, layoutParams4);
        relativeLayout.addView(linearLayout, layoutParams3);
        return relativeLayout;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onPause() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onResume() {
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onStop() {
    }

    public tp(Activity activity) {
        this.a = activity;
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBeforeCreate(Bundle bundle) {
        this.a.requestWindowFeature(1);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onAfterCreate(Bundle bundle) {
        String stringExtra = this.a.getIntent().getStringExtra("objectId");
        this.b = stringExtra;
        h4 h4VarA = ((k1) zm.a(stringExtra, k1.class)).a();
        this.c = h4VarA;
        if (h4VarA == null) {
            zm.a(k1.class);
            this.a.finish();
            return;
        }
        if (h4VarA.o() != null) {
            i3 i3VarB = this.c.o().b();
            this.d = i3VarB;
            if (i3VarB != null) {
                d();
                return;
            }
        }
        b10.a(9130070, f5.a(this.c), 2);
        this.a.finish();
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onDestroy() {
        zm.b(this.b, k1.class);
    }

    @Override // com.qq.e.comm.pi.ACTD
    public void onBackPressed() {
        a();
    }

    private void d() {
        LinearLayout linearLayout = new LinearLayout(this.a);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setOrientation(1);
        ViewGroup viewGroupC = c();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = yu.a((Context) this.a, 1);
        linearLayout.addView(viewGroupC, layoutParams);
        View view = new View(this.a);
        view.setBackgroundColor(-3355444);
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        linearLayout.addView(b(), new LinearLayout.LayoutParams(-1, -1));
        this.a.setContentView(linearLayout, new ViewGroup.LayoutParams(-1, -1));
    }

    /* compiled from: A */
    class a implements qr {
        a() {
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, Exception exc) {
            tp.this.a("获取权限信息失败:" + exc.getMessage());
        }

        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
            int iA = hwVar.a();
            if (iA == 200) {
                try {
                    tp.this.a(new JSONObject(hwVar.c()));
                    return;
                } catch (IOException | JSONException e) {
                    tp.this.a("获取权限信息回包解析失败:" + e.getMessage());
                    return;
                }
            }
            tp.this.a("获取权限信息网络失败错误码:" + iA);
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ String a;

        b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            tp.this.o.setText(this.a);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ SpannableStringBuilder a;

        c(SpannableStringBuilder spannableStringBuilder) {
            this.a = spannableStringBuilder;
        }

        @Override // java.lang.Runnable
        public void run() {
            tp.this.o.setText(this.a);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case 4661:
                a();
                break;
            case 4662:
                this.g.a(true);
                this.h.a(false);
                this.i.a(false);
                this.o.setVisibility(0);
                this.m.setVisibility(8);
                this.n.setVisibility(8);
                this.j.a(false);
                this.p.setVisibility(8);
                break;
            case 4663:
                this.g.a(false);
                this.h.a(true);
                this.i.a(false);
                this.o.setVisibility(8);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                this.j.a(false);
                this.p.setVisibility(8);
                break;
            case 4664:
                this.g.a(false);
                this.h.a(false);
                this.i.a(true);
                this.o.setVisibility(8);
                this.m.setVisibility(8);
                this.n.setVisibility(0);
                this.j.a(false);
                this.p.setVisibility(8);
                break;
            case 4665:
                this.g.a(false);
                this.o.setVisibility(8);
                this.h.a(false);
                this.m.setVisibility(8);
                this.i.a(false);
                this.n.setVisibility(8);
                this.j.a(true);
                this.p.setVisibility(0);
                break;
        }
    }

    private void a() {
        this.a.finish();
        h4 h4Var = this.c;
        if (h4Var == null) {
            return;
        }
        Map<String, WeakReference<wp.b>> map = wp.b.l;
        WeakReference<wp.b> weakReference = map.get(h4Var.k0());
        if (weakReference != null) {
            wp.b bVar = weakReference.get();
            if (bVar != null) {
                bVar.k();
            }
            map.remove(this.c.k0());
        }
        Future<hw> future = this.q;
        if (future == null || future.isDone()) {
            return;
        }
        this.q.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        Iterator<String> itKeys = jSONObject.keys();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        int iA = yu.a((Context) this.a, 3);
        int iA2 = yu.a((Context) this.a, 20);
        int length = 0;
        while (itKeys.hasNext()) {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(itKeys.next());
            if (jSONObjectOptJSONObject != null) {
                int iOptInt = jSONObjectOptJSONObject.optInt("level");
                String strOptString = jSONObjectOptJSONObject.optString(RemoteRewardActivity.JSON_BANNER_DESC_ID);
                String strOptString2 = jSONObjectOptJSONObject.optString("title");
                if (iOptInt > 0 && !TextUtils.isEmpty(strOptString2)) {
                    spannableStringBuilder.append((CharSequence) (strOptString2 + '\n'));
                    int length2 = strOptString2.length() + length + 1;
                    spannableStringBuilder.setSpan(new BulletSpan(iA), length, length2, 33);
                    spannableStringBuilder.setSpan(new StyleSpan(1), length, length2, 33);
                    if (TextUtils.isEmpty(strOptString)) {
                        length = length2;
                    } else {
                        spannableStringBuilder.append((CharSequence) (strOptString + '\n'));
                        length = strOptString.length() + length2 + 1;
                        spannableStringBuilder.setSpan(new LeadingMarginSpan.Standard(iA2), length2, length, 33);
                    }
                }
            }
        }
        this.a.runOnUiThread(new c(spannableStringBuilder));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.a.runOnUiThread(new b(str));
    }
}
