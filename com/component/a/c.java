package com.component.a;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.mobads.container.o.j;
import com.component.a.a;
import com.component.a.a.q;
import com.component.a.a.r;
import com.component.a.a.s;
import com.component.a.i.f;
import com.component.a.i.w;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class c {
    private static final int a = 1001;
    private final w b;
    private a.AbstractC0311a c;
    private Rect d;

    public c(w wVar) {
        this.b = wVar;
    }

    private int a(int i) {
        if (this.b != null) {
            return this.b.a();
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View a(android.content.Context r4, com.component.a.f.e r5) {
        /*
            r3 = this;
            com.component.a.a$a r0 = r3.c
            r1 = 0
            if (r0 == 0) goto L1b
            com.component.a.f.d r0 = new com.component.a.f.d
            java.lang.String r2 = "prepare"
            r0.<init>(r1, r2, r5)
            com.component.a.a$a r2 = r3.c
            boolean r2 = r2.a(r0)
            if (r2 == 0) goto L1a
            android.view.View r1 = r0.e()
            goto L1b
        L1a:
            return r1
        L1b:
            android.graphics.Rect r0 = r3.d
            if (r0 != 0) goto L26
            r0 = 1
            android.graphics.Rect r0 = com.component.a.i.a.a(r4, r0)
            r3.d = r0
        L26:
            if (r1 != 0) goto L2c
            android.view.View r1 = r3.b(r4, r5)
        L2c:
            r3.a(r1, r5)
            boolean r0 = r1 instanceof com.component.a.c.b
            if (r0 == 0) goto L39
            r0 = r1
            com.component.a.c.b r0 = (com.component.a.c.b) r0
            r3.a(r4, r0, r5)
        L39:
            boolean r4 = r1 instanceof com.component.a.c.c
            if (r4 == 0) goto L4e
            r4 = r1
            com.component.a.c.c r4 = (com.component.a.c.c) r4
            com.component.a.i.f r0 = r4.getLifeCycle()
            if (r0 != 0) goto L4e
            com.component.a.i.f r0 = new com.component.a.i.f
            r0.<init>(r5)
            r4.setLifeCycle(r0)
        L4e:
            com.component.a.a$a r4 = r3.c
            if (r4 == 0) goto L61
            if (r1 == 0) goto L61
            com.component.a.a$a r4 = r3.c
            com.component.a.f.d r0 = new com.component.a.f.d
            java.lang.String r2 = "create"
            r0.<init>(r1, r2, r5)
            android.view.View r1 = r4.b(r0)
        L61:
            com.component.a.a$a r4 = r3.c
            if (r4 == 0) goto L9c
            if (r1 == 0) goto L9c
            com.component.a.c$a r4 = new com.component.a.c$a
            com.component.a.a$a r0 = r3.c
            r4.<init>(r0, r5)
            boolean r0 = r1 instanceof com.component.a.d.c
            if (r0 == 0) goto L84
            r0 = r1
            com.component.a.d.c r0 = (com.component.a.d.c) r0
            boolean r2 = r0.p()
            if (r2 == 0) goto L84
            com.component.a.d r2 = new com.component.a.d
            r2.<init>(r3, r5)
            r0.a(r2)
            goto L93
        L84:
            java.lang.String r0 = ""
            java.lang.String r5 = r5.q(r0)
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L93
            r1.setOnClickListener(r4)
        L93:
            com.component.a.i.f r5 = com.component.a.i.f.a(r1)
            if (r5 == 0) goto L9c
            r5.a(r4)
        L9c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.c.a(android.content.Context, com.component.a.f.e):android.view.View");
    }

    public static class a extends f.a implements View.OnClickListener {
        private final a.AbstractC0311a a;
        private final com.component.a.f.e b;
        private long c = -1;
        private MotionEvent d = null;
        private MotionEvent e = null;

        public a(a.AbstractC0311a abstractC0311a, com.component.a.f.e eVar) {
            this.a = abstractC0311a;
            this.b = eVar;
        }

        @Override // com.component.a.i.f.a
        public void a(MotionEvent motionEvent, boolean z) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.c = -1L;
                    this.d = MotionEvent.obtainNoHistory(motionEvent);
                    break;
                case 1:
                    if (z) {
                        this.c = motionEvent.getDownTime();
                        this.e = MotionEvent.obtainNoHistory(motionEvent);
                        break;
                    }
                    break;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.a != null) {
                com.component.a.f.d dVar = new com.component.a.f.d(view, "click", this.b);
                View viewA = j.a(view);
                if (viewA == null) {
                    viewA = com.component.a.i.f.a(view, this.c);
                }
                dVar.a(viewA, 0, this.d, this.e);
                this.a.c(dVar);
            }
        }
    }

    private void a(Context context, com.component.a.c.b bVar, com.component.a.f.e eVar) {
        List<com.component.a.f.e> listO = eVar.o();
        if (bVar != null && listO != null && listO.size() > 0) {
            for (int i = 0; i < listO.size(); i++) {
                com.component.a.f.e eVar2 = listO.get(i);
                View viewA = a(context, eVar2);
                if (viewA != null) {
                    bVar.a(viewA, eVar2, a(i + 1001));
                }
            }
        }
    }

    public c a(a.AbstractC0311a abstractC0311a) {
        this.c = abstractC0311a;
        return this;
    }

    private View b(Context context, com.component.a.f.e eVar) {
        switch (e.a[eVar.e().ordinal()]) {
            case 1:
                return new q(context, eVar);
            case 2:
                return new com.component.a.a.e().a(context, eVar);
            case 3:
                return new com.component.a.a.d(context, eVar);
            case 4:
                return new r(context, eVar);
            case 5:
                return new com.component.a.a.f(context, eVar);
            case 6:
                return new com.component.a.d.a(context, eVar);
            case 7:
                return new com.component.a.d.e(context, eVar);
            case 8:
                return new s().a(context, eVar);
            default:
                return new com.component.a.d.c(context, eVar);
        }
    }

    private void a(View view, com.component.a.f.e eVar) {
        if (view != null) {
            switch (eVar.e(-2)) {
                case -1:
                    view.setVisibility(8);
                    break;
                case 0:
                    view.setVisibility(4);
                    break;
                case 1:
                    view.setVisibility(0);
                    break;
            }
        }
    }
}
