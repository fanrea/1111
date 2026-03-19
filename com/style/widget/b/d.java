package com.style.widget.b;

import android.content.Context;
import android.view.View;
import com.baidu.mobads.container.util.bs;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class d extends bs {
    private float g;
    private int h;

    public d(Context context, a aVar) {
        super(context, aVar);
        this.g = aVar.a;
        this.h = aVar.b;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.g >= 0.0f && this.g <= 1.0f) {
            int height = (int) (getHeight() * this.g);
            if (height == 0 && this.g >= 0.5f) {
                height = 500;
            }
            if (getHeight() > 0) {
                this.d = height;
                this.a = height;
                this.b = height;
                this.c = height;
                setBackgroundDrawable(a(this.e, this.f));
                this.g = -1.0f;
            }
        }
    }

    public static class a extends bs.a {
        private float a = -1.0f;
        private int b = 0;

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public a a(int i) {
            super.a(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public a b(int i) {
            super.b(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(String str) {
            super.a(str);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public a c(int i) {
            super.c(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public a d(int i) {
            super.d(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public a e(int i) {
            super.e(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public a f(int i) {
            super.f(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a g(int i) {
            super.g(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public a h(int i) {
            super.h(i);
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public a a(View.OnClickListener onClickListener) {
            super.a(onClickListener);
            return this;
        }

        public a a(float f) {
            this.a = f;
            return this;
        }

        public a q(int i) {
            this.b = i;
            return this;
        }

        @Override // com.baidu.mobads.container.util.bs.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d a(Context context) {
            return new d(context, this);
        }
    }
}
