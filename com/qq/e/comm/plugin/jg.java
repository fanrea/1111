package com.qq.e.comm.plugin;

import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class jg extends u4<b> {
    private String G;

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new jg();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b b(e8 e8Var) {
        return new b(e8Var.d());
    }

    jg() {
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        str.hashCode();
        switch (str) {
            case "adModel":
                ((b) this.A).b((h4) cmVar.e(new JSONObject[0]));
                return true;
            case "navBar":
                ((b) this.A).b(cmVar.f(new JSONObject[0]) == 1);
                return true;
            case "allow3s":
                ((b) this.A).a(cmVar.f(new JSONObject[0]) == 1);
                return true;
            case "url":
                this.G = cmVar.toString();
                return true;
            case "listener":
                ((b) this.A).a((sh) cmVar.e(new JSONObject[0]));
                return true;
            default:
                return super.a(str, cmVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        super.M();
        if (this.t.a()) {
            ((b) A()).setWillNotDraw(false);
        }
        if (TextUtils.isEmpty(this.G)) {
            return;
        }
        ((b) this.A).a(this.G);
        this.G = null;
    }

    /* compiled from: A */
    static class b extends qq {
        private jm c;
        private Boolean d;
        private sh e;
        private Boolean f;

        public b(Context context) {
            super(context);
        }

        void b(h4 h4Var) {
            if (h4Var == null || this.c != null) {
                return;
            }
            a(h4Var);
        }

        private void a(h4 h4Var) {
            jm jmVarA = new qh(getContext(), h4Var, true).a();
            this.c = jmVarA;
            Boolean bool = this.d;
            if (bool != null) {
                jmVarA.b(bool.booleanValue());
            }
            sh shVar = this.e;
            if (shVar != null) {
                this.c.a(shVar);
            }
            Boolean bool2 = this.f;
            if (bool2 != null) {
                this.c.c(bool2.booleanValue());
            }
            addView(this.c.a());
        }

        /* compiled from: A */
        class a implements View.OnTouchListener {
            final /* synthetic */ View.OnTouchListener a;

            a(View.OnTouchListener onTouchListener) {
                this.a = onTouchListener;
            }

            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                view.onTouchEvent(motionEvent);
                return this.a.onTouch(b.this, motionEvent);
            }
        }

        @Override // android.view.View
        public void setOnTouchListener(View.OnTouchListener onTouchListener) {
            this.c.a().setOnTouchListener(new a(onTouchListener));
        }

        void b(boolean z) {
            jm jmVar = this.c;
            if (jmVar == null) {
                this.d = Boolean.valueOf(z);
            } else {
                jmVar.b(z);
            }
        }

        void a(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (this.c == null) {
                a((h4) null);
            }
            this.c.loadUrl(str);
        }

        void a(boolean z) {
            jm jmVar = this.c;
            if (jmVar == null) {
                this.f = Boolean.valueOf(z);
            } else {
                jmVar.c(z);
            }
        }

        void a(sh shVar) {
            jm jmVar = this.c;
            if (jmVar == null) {
                this.e = shVar;
            } else {
                jmVar.a(shVar);
            }
        }
    }
}
