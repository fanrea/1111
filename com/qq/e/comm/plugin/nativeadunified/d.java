package com.qq.e.comm.plugin.nativeadunified;

import android.text.TextUtils;
import com.qq.e.comm.plugin.apkmanager.l;
import com.qq.e.comm.plugin.callback.biz.JumpOutBizCallback;
import com.qq.e.comm.plugin.callback.biz.LPCallback;
import com.qq.e.comm.plugin.h10;
import com.qq.e.comm.plugin.h4;
import com.qq.e.comm.plugin.l3;
import com.qq.e.comm.plugin.ms;
import com.qq.e.comm.plugin.ns;
import com.qq.e.comm.plugin.os;
import com.qq.e.comm.plugin.r1;
import com.qq.e.comm.plugin.x5;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class d implements os {
    public static final /* synthetic */ int g = 0;
    private final boolean b;
    private String d;
    private Map<String, Object> e;
    private g f;
    private final ns a = new ns();
    private boolean c = false;

    /* compiled from: A */
    public interface g {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        g gVar = this.f;
        if (gVar != null) {
            gVar.a();
        }
    }

    private void d() {
        JumpOutBizCallback jumpOutBizCallback = (JumpOutBizCallback) x5.b(this.d, JumpOutBizCallback.class);
        jumpOutBizCallback.h().a(new c(this));
        jumpOutBizCallback.d().a(new C0715d(this));
        jumpOutBizCallback.x().a(new e(this));
        jumpOutBizCallback.a0().a(new f(this));
    }

    private void e() {
        LPCallback lPCallback = (LPCallback) x5.b(this.d, LPCallback.class);
        lPCallback.o().a(new a(this));
        lPCallback.onClose().a(new b(this));
    }

    @Override // com.qq.e.comm.plugin.os
    public boolean k() {
        return this.c;
    }

    private boolean b() {
        return this.b;
    }

    public d(h4 h4Var) {
        this.b = r1.d().f().a("nudei", h4Var.y0(), 0) == 0;
        if (b()) {
            return;
        }
        this.d = h4Var.s0();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(3);
        this.e = concurrentHashMap;
        concurrentHashMap.put("task_action", a(h4Var));
        e();
        d();
    }

    /* compiled from: A */
    class a extends ms<Void> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r3) {
            d.this.e.put("jump_type", "INTERNAL");
            d.this.e.put("navigation_action", "NAVIGATE");
            d.this.c();
            int i = d.g;
        }

        a(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class b extends ms<Void> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Void r3) {
            d.this.e.put("jump_type", "INTERNAL");
            d.this.e.put("navigation_action", "RETURN");
            d.this.c();
            int i = d.g;
        }

        b(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class c extends ms<Integer> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            d.this.e.put("jump_type", "EXTERNAL");
            d.this.e.put("navigation_action", "NAVIGATE");
            d.this.c();
            int i = d.g;
        }

        c(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.nativeadunified.d$d, reason: collision with other inner class name */
    class C0715d extends ms<Integer> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            d.this.e.put("jump_type", "EXTERNAL");
            d.this.e.put("navigation_action", "RETURN");
            d.this.c();
            int i = d.g;
        }

        C0715d(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class e extends ms<Integer> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            int i = d.g;
        }

        e(os osVar) {
            super(osVar);
        }
    }

    /* compiled from: A */
    class f extends ms<Integer> {
        @Override // com.qq.e.comm.plugin.ms
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            int i = d.g;
        }

        f(os osVar) {
            super(osVar);
        }
    }

    private String a(h4 h4Var) {
        l3 l3VarO = h4Var.o();
        if (l3VarO == null) {
            return "3";
        }
        String strE = l3VarO.e();
        if (TextUtils.isEmpty(strE)) {
            return "3";
        }
        int iB = l.e().b(strE);
        return h10.f(iB) ? "3" : h10.d(iB) ? "2" : "1";
    }

    public void a(g gVar) {
        if (b()) {
            return;
        }
        this.f = gVar;
    }

    public void a(Map<String, Object> map) {
        if (b()) {
            return;
        }
        map.putAll(this.e);
    }

    public void a() {
        this.c = true;
        x5.c(this.d, LPCallback.class);
        x5.c(this.d, JumpOutBizCallback.class);
    }

    @Override // com.qq.e.comm.plugin.os
    public ns i() {
        return this.a;
    }
}
