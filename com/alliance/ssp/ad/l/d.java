package com.alliance.ssp.ad.l;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alliance.ssp.ad.R;
import com.alliance.ssp.ad.bean.Material;
import com.alliance.ssp.ad.o0.r;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: SixElementDecorator.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class d {
    public int a;
    public ViewGroup b;
    public Context c;
    public Material d;
    public c e;
    public boolean f;
    public int g;
    public View h;
    public FrameLayout i;
    public RelativeLayout j;
    public TextView k;
    public SpannableString l;

    /* compiled from: SixElementDecorator.java */
    public class a extends ClickableSpan {
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            c cVar = d.this.e;
            if (cVar == null) {
                int i = com.alliance.ssp.ad.o0.l.a;
                return;
            }
            int i2 = this.a;
            if (i2 == 1) {
                cVar.c(view);
            } else if (i2 == 2) {
                cVar.a(view);
            } else {
                if (i2 != 3) {
                    return;
                }
                cVar.b(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
            textPaint.clearShadowLayer();
        }
    }

    /* compiled from: SixElementDecorator.java */
    public interface c {
        void a(View view);

        void b(View view);

        void c(View view);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public final void a(int i, int i2, int i3) {
        this.l.setSpan(new a(i), i2, i3, 17);
    }

    public d() {
    }

    /* compiled from: SixElementDecorator.java */
    public static class b {
        public d a;

        public b() {
            if (this.a == null) {
                this.a = new d(null);
            }
        }

        public b a(ViewGroup viewGroup, int i, boolean z, int i2) {
            d dVar = this.a;
            dVar.f = z;
            dVar.b = viewGroup;
            dVar.a = i;
            dVar.g = i2;
            return this;
        }

        public d a() throws JSONException, PackageManager.NameNotFoundException, IOException {
            d dVar = this.a;
            if (dVar.b == null) {
                int i = com.alliance.ssp.ad.o0.l.a;
            } else {
                int i2 = com.alliance.ssp.ad.o0.l.a;
                try {
                    int i3 = dVar.a;
                    if (i3 == 1) {
                        View viewInflate = LayoutInflater.from(dVar.c).inflate(R.layout.layout_nmssp_style_sixelement_screen, (ViewGroup) null, false);
                        dVar.h = viewInflate;
                        dVar.i = (FrameLayout) viewInflate.findViewById(R.id.xml_six_element_fl_background);
                        dVar.k = (TextView) dVar.h.findViewById(R.id.xml_six_element_tv_text);
                        FrameLayout frameLayout = dVar.i;
                        GradientDrawable gradientDrawable = new GradientDrawable();
                        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                        gradientDrawable.setColors(new int[]{Color.parseColor("#00000000"), Color.parseColor("#80000000")});
                        frameLayout.setBackground(gradientDrawable);
                    } else if (i3 == 2) {
                        View viewInflate2 = LayoutInflater.from(dVar.c).inflate(R.layout.layout_nmssp_style_sixelement_content, (ViewGroup) null, false);
                        dVar.h = viewInflate2;
                        dVar.j = (RelativeLayout) viewInflate2.findViewById(R.id.xml_six_element_fl_background);
                        dVar.k = (TextView) dVar.h.findViewById(R.id.xml_six_element_tv_text);
                    }
                } catch (Exception e) {
                    e.getMessage();
                    int i4 = com.alliance.ssp.ad.o0.l.a;
                    new com.alliance.ssp.ad.d0.f().a(0, 0, "004", com.alliance.ssp.ad.a.a.a(e, com.alliance.ssp.ad.a.b.a("SixElementDecorator 001: ")), e);
                }
                if (dVar.h != null && dVar.k != null && (dVar.i != null || dVar.j != null)) {
                    Material material = dVar.d;
                    if (material != null && (!r.a(material.getApkname()) || !r.a(dVar.d.getAppPublisher()) || !r.a(dVar.d.getVersionName()) || !r.a(dVar.d.getAppIntro()) || !r.a(dVar.d.getPermissionUrl()) || !r.a(dVar.d.getPrivacyUrl()))) {
                        String str = "";
                        if (dVar.d.getApkname() != null && !dVar.d.getApkname().isEmpty()) {
                            str = "应用名称: " + dVar.d.getApkname();
                        }
                        if (dVar.d.getVersionName() != null && !dVar.d.getVersionName().isEmpty()) {
                            str = str + " | 应用版本: " + dVar.d.getVersionName();
                        }
                        if (dVar.d.getAppPublisher() != null && !dVar.d.getAppPublisher().isEmpty()) {
                            str = str + " | 开发者: " + dVar.d.getAppPublisher();
                        }
                        String str2 = " | 功能列表";
                        String str3 = str.length() > dVar.g ? " | 功能列表" : "\n功能列表";
                        if (dVar.f) {
                            dVar.k.setMaxEms(95);
                        } else {
                            str2 = str3;
                        }
                        dVar.l = new SpannableString(str + str2 + " | 隐私权限 | 隐私协议");
                        int length = str.length();
                        int length2 = str2.length() + str.length();
                        dVar.a(1, length, length2);
                        int i5 = length2 + 7;
                        dVar.a(2, length2, i5);
                        dVar.a(3, i5, i5 + 7);
                        TextView textView = dVar.k;
                        if (textView != null) {
                            textView.setMovementMethod(LinkMovementMethod.getInstance());
                            dVar.k.setText(dVar.l);
                            dVar.k.setTextSize(9);
                        }
                    }
                    dVar.b.addView(dVar.h);
                }
            }
            return this.a;
        }
    }
}
