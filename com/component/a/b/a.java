package com.component.a.b;

import android.view.View;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.component.a.a.b;
import com.component.a.f.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public abstract class a implements k {
    protected final View a;
    protected View b;
    protected final l c = new l();
    protected final d d = new d();
    private final String e;

    public interface b extends n {
        com.component.a.f a();

        void a(j jVar);

        void a(j jVar, String str);
    }

    protected a(View view, String str) {
        this.a = view;
        this.e = str;
        this.b = view;
        this.c.b(com.sigmob.sdk.base.n.l, view);
        this.c.b(b.e.c, 0);
        this.c.b("timer", 0);
        this.d.b(b.e.c, 0);
    }

    public static List<a> a(View view, List<e.a> list) {
        ArrayList arrayList = new ArrayList();
        for (e.a aVar : list) {
            a aVarA = a(view, aVar.b());
            List<String> listA = aVarA.d.a();
            if (!aVar.c().isEmpty()) {
                listA = aVar.c();
            }
            d dVarA = d.a(listA, aVar.d());
            Iterator<String> it = dVarA.iterator();
            while (it.hasNext()) {
                String next = it.next();
                aVarA.d.b(next, dVarA.b(next));
            }
            arrayList.add(aVarA);
        }
        return arrayList;
    }

    public boolean a(b bVar) {
        if (this.d == null) {
            return true;
        }
        View view = null;
        if (this.d.b("target_id") instanceof String) {
            View viewA = bVar.a().a((String) this.d.b("target_id"));
            this.d.b("target_id", null);
            view = viewA;
        } else if (this.d.b("target_name") instanceof String) {
            View viewB = bVar.a().b((String) this.d.b("target_name"));
            this.d.b("target_name", null);
            view = viewB;
        }
        if (view != null) {
            this.b = view;
        }
        this.c.a(bVar);
        return this.d.a(this.c);
    }

    public String a() {
        return this.e;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.component.a.b.a a(android.view.View r1, java.lang.String r2) {
        /*
            int r0 = r2.hashCode()
            switch(r0) {
                case -1460548366: goto L3a;
                case -1337893252: goto L30;
                case -629915894: goto L26;
                case 3529469: goto L1c;
                case 1671672458: goto L12;
                case 1847372265: goto L8;
                default: goto L7;
            }
        L7:
            goto L44
        L8:
            java.lang.String r0 = "resume_video"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L7
            r0 = 3
            goto L45
        L12:
            java.lang.String r0 = "dismiss"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L7
            r0 = 1
            goto L45
        L1c:
            java.lang.String r0 = "show"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L7
            r0 = 0
            goto L45
        L26:
            java.lang.String r0 = "play_lottie"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L7
            r0 = 4
            goto L45
        L30:
            java.lang.String r0 = "stop_lottie"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L7
            r0 = 5
            goto L45
        L3a:
            java.lang.String r0 = "pause_video"
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L7
            r0 = 2
            goto L45
        L44:
            r0 = -1
        L45:
            switch(r0) {
                case 0: goto L6c;
                case 1: goto L66;
                case 2: goto L60;
                case 3: goto L5a;
                case 4: goto L54;
                case 5: goto L4e;
                default: goto L48;
            }
        L48:
            com.component.a.b.a$a r2 = new com.component.a.b.a$a
            r2.<init>(r1)
            return r2
        L4e:
            com.component.a.g.a.a r0 = new com.component.a.g.a.a
            r0.<init>(r1, r2)
            return r0
        L54:
            com.component.a.g.a.a r0 = new com.component.a.g.a.a
            r0.<init>(r1, r2)
            return r0
        L5a:
            com.component.a.g.a.c r0 = new com.component.a.g.a.c
            r0.<init>(r1, r2)
            return r0
        L60:
            com.component.a.g.a.c r0 = new com.component.a.g.a.c
            r0.<init>(r1, r2)
            return r0
        L66:
            com.component.a.g.a.b r0 = new com.component.a.g.a.b
            r0.<init>(r1, r2)
            return r0
        L6c:
            com.component.a.g.a.b r0 = new com.component.a.g.a.b
            r0.<init>(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.b.a.a(android.view.View, java.lang.String):com.component.a.b.a");
    }

    /* renamed from: com.component.a.b.a$a, reason: collision with other inner class name */
    public static class C0313a extends a {
        public C0313a(View view) {
            super(view, ILogConst.CACHE_PLAY_REASON_NULL);
        }

        @Override // com.component.a.b.k
        public void b(b bVar) {
        }
    }
}
