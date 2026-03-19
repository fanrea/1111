package com.style.widget;

import android.content.Context;
import android.widget.TextView;
import com.baidu.mobads.container.components.a;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ac {
    public static final int a = 1000;

    public static TextView a(Context context, a aVar) {
        com.baidu.mobads.container.components.a aVarA = new com.baidu.mobads.container.components.a(context).b(aVar.m).b(aVar.i).a(aVar.j).a(aVar.a);
        aVarA.setPadding(com.baidu.mobads.container.util.ab.a(context, 10.0f), 0, com.baidu.mobads.container.util.ab.a(context, 10.0f), 0);
        aVarA.setText(aVar.f);
        aVarA.setTextColor(aVar.g);
        aVarA.setTextSize(aVar.h);
        if (aVar.k > 0) {
            aVarA.a(aVar.k * 1000);
            aVarA.a(aVar.l);
        }
        return aVarA;
    }

    public static TextView b(Context context, a aVar) {
        com.baidu.mobads.container.components.a aVarA = new com.baidu.mobads.container.components.a(context).b(aVar.i).a(aVar.j).a(aVar.d).c(aVar.e).e(aVar.b).f(aVar.c).a(aVar.a);
        aVarA.setText(aVar.f);
        aVarA.setTextColor(aVar.g);
        aVarA.setTextSize(aVar.h);
        if (aVar.k > 0) {
            aVarA.a(aVar.k * 1000);
            aVarA.a(aVar.l);
        }
        return aVarA;
    }

    public static class a {
        a.b a = a.b.TEXT_CD;
        int b = -16776961;
        int c = 8;
        int d = -16777216;
        int e = 2;
        String f = "";
        int g = -1;
        float h = 10.0f;
        int i = -16777216;
        float j = 0.5f;
        int k = 0;
        boolean l = false;
        float m = 0.5f;

        public a a(a.b bVar) {
            this.a = bVar;
            return this;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a b(int i) {
            this.c = i;
            return this;
        }

        public a c(int i) {
            this.d = i;
            return this;
        }

        public a d(int i) {
            this.e = i;
            return this;
        }

        public a a(String str) {
            this.f = str;
            return this;
        }

        public a e(int i) {
            this.g = i;
            return this;
        }

        public a a(float f) {
            this.h = f;
            return this;
        }

        public a f(int i) {
            this.i = i;
            return this;
        }

        public a b(float f) {
            this.j = f;
            return this;
        }

        public a g(int i) {
            this.k = i;
            return this;
        }

        public a a(boolean z) {
            this.l = z;
            return this;
        }

        public a c(float f) {
            this.m = f;
            return this;
        }
    }
}
