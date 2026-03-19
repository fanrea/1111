package com.qq.e.comm.plugin;

import android.util.Pair;
import com.qq.e.comm.plugin.an;
import com.qq.e.comm.plugin.aw;
import com.qq.e.comm.plugin.s20;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetConfig;
import com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.http2.Header;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ev implements an {
    private aw b;
    private TnetQuicRequest c;
    private URL d;
    private fv e;
    private boolean f;
    private TnetConfig g;
    private volatile String l;
    private volatile boolean m;
    private int a = 10;
    private final CountDownLatch h = new CountDownLatch(1);
    private int i = 0;
    private int j = 0;
    private final AtomicBoolean k = new AtomicBoolean(false);

    /* compiled from: A */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[aw.a.values().length];
            a = iArr;
            try {
                iArr[aw.a.POST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[aw.a.GET.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: A */
    class a extends TnetQuicRequest.Callback {
        final /* synthetic */ long a;

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onHeaderRecv(String str) throws Exception {
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onNetworkLinked() throws Exception {
        }

        a(long j) {
            this.a = j;
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onConnect(int i) throws Exception {
            ev.this.e = null;
            ev.this.f = false;
            ev.this.c();
            if (b.a[ev.this.b.o().ordinal()] != 1) {
                ev.this.c.sendRequest(new byte[0], 0, true);
                return;
            }
            byte[] bArrC = ev.this.b.c();
            if (bArrC == null || bArrC.length <= 0) {
                ev.this.b();
            } else {
                ev.this.c.sendRequest(bArrC, bArrC.length, true);
            }
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onDataRecv(byte[] bArr) throws Exception {
            if (ev.this.e == null) {
                ev evVar = ev.this;
                evVar.e = new fv(evVar.b.j());
            }
            try {
                ev.this.e.a(bArr);
            } catch (Exception e) {
                e.toString();
                if (as.a(ev.this.e.a())) {
                    ev.this.a(this.a, 7);
                } else {
                    ev.this.a(this.a, 2);
                }
                ev.this.b();
            }
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onComplete(int i) throws Exception {
            if (i != 0) {
                ev.this.a(this.a, i + 40);
            } else {
                ev evVar = ev.this;
                evVar.f = evVar.e.e();
                if (!ev.this.f) {
                    ev.this.a(this.a, 3);
                }
            }
            ev.this.b();
        }

        @Override // com.tencent.qqlive.modules.vb.tquic.impl.TnetQuicRequest.Callback
        public void onClose(int i, String str) throws Exception {
            ev.this.b();
        }
    }

    private void c(String str) {
        if (this.m) {
            aj.b().b(str);
        }
    }

    private boolean b(an.a aVar) {
        s20.h hVarM;
        return (aVar == null || aVar.a() == null || (hVarM = aVar.a().m()) == null || hVarM == s20.h.AD_REQ || this.j > 1) ? false : true;
    }

    private void d() {
        aw awVar = this.b;
        if (awVar == null) {
            return;
        }
        s20.h hVarM = awVar.m();
        if ((hVarM == s20.h.CLICK_CGI_REQ || hVarM == s20.h.EXPOSURE_CGI_REQ) && a()) {
            t20.a(9130080, this.i);
        }
    }

    private boolean a() {
        return this.i > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        aw awVar = this.b;
        if (awVar == null || this.c == null || this.d == null) {
            return;
        }
        for (Map.Entry<String, String> entry : awVar.q().entrySet()) {
            this.c.addHeaders(entry.getKey(), entry.getValue());
        }
        this.c.addHeaders(r30.b(), r30.a());
        this.c.addHeaders("Accept-Encoding", "gzip");
        if (this.d.getPath() != null) {
            String path = this.d.getPath();
            if (this.d.getQuery() != null) {
                path = this.d.getPath() + "?" + this.d.getQuery();
            }
            this.c.addHeaders(Header.TARGET_PATH_UTF8, path);
        }
    }

    private InetAddress b(String str) throws Exception {
        InetAddress inetAddress;
        InetAddress[] allByName = InetAddress.getAllByName(str);
        int length = allByName.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                inetAddress = null;
                break;
            }
            inetAddress = allByName[i];
            if (inetAddress instanceof Inet4Address) {
                break;
            }
            i++;
        }
        return (inetAddress != null || allByName.length <= 0) ? inetAddress : allByName[0];
    }

    private void a(String str) {
        if (this.m) {
            aj.b().a(str);
        }
    }

    private hw c(an.a aVar) throws JSONException {
        hw hwVarA = null;
        if (aVar != null && aVar.a() != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                d();
                hwVarA = aVar.a(this.b);
            } catch (Exception unused) {
            }
            if (a(aVar.a(), hwVarA)) {
                b(jCurrentTimeMillis);
            } else {
                a(jCurrentTimeMillis, 0);
            }
        }
        return hwVarA;
    }

    private void b(aw awVar) {
        if (awVar != null) {
            s20.h hVarM = awVar.m();
            int i = s20.a().c() ? 1 : 2;
            this.j = s20.a().b(hVarM, awVar.l());
            this.i = (i * 10000) + (this.j * 1000) + ((s20.a().b(hVarM) ? 1 : 0) * 100) + ((hVarM == null ? 0 : hVarM.b()) * 10);
        }
    }

    private void a(boolean z) {
        if (this.c == null || !this.k.compareAndSet(true, false)) {
            return;
        }
        if (r1.d().f().a("rdtc", 0) > 0) {
            this.c.destroy();
        } else {
            if (!z || r1.d().f().a("irdtc", 0) <= 0) {
                return;
            }
            this.c.destroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.h.getCount() > 0) {
            this.h.countDown();
        }
    }

    private Pair<Integer, Integer> a(aw awVar) {
        if (this.j > 1 && awVar != null && awVar.m() != s20.h.AD_REQ) {
            if (this.j < 4 && awVar.m() == s20.h.CLICK_CGI_REQ && awVar.l() == e2.SPLASH.d()) {
                int iG = awVar.g() > 0 ? awVar.g() : 30000;
                return new Pair<>(Integer.valueOf(iG), Integer.valueOf(iG + (awVar.b() > 0 ? awVar.b() : 30000)));
            }
            return new Pair<>(Integer.valueOf(this.j * 1000), Integer.valueOf(this.j * 2000));
        }
        return new Pair<>(4000, 8000);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0132  */
    @Override // com.qq.e.comm.plugin.an
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.qq.e.comm.plugin.hw a(com.qq.e.comm.plugin.an.a r9) throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.ev.a(com.qq.e.comm.plugin.an$a):com.qq.e.comm.plugin.hw");
    }

    private void b(long j) {
        aw awVar = this.b;
        if (awVar == null) {
            return;
        }
        s20.h hVarM = awVar.m();
        if (hVarM == s20.h.AD_REQ) {
            t20.a(9130019);
        } else if ((hVarM == s20.h.CLICK_CGI_REQ || hVarM == s20.h.EXPOSURE_CGI_REQ) && a()) {
            t20.a(9130081, this.i, (int) (System.currentTimeMillis() - j));
        }
    }

    private boolean a(aw awVar, hw hwVar) {
        if (awVar == null || hwVar == null) {
            return false;
        }
        int iA = hwVar.a();
        if (iA == 200 || iA == 204) {
            return true;
        }
        s20.h hVarM = awVar.m();
        return hVarM != null && hVarM == s20.h.CLICK_CGI_REQ && as.a(iA) && !awVar.j();
    }

    private void a(long j) throws JSONException {
        aw awVar = this.b;
        if (awVar == null) {
            return;
        }
        s20.h hVarM = awVar.m();
        if (hVarM == s20.h.AD_REQ) {
            t20.a(9130017);
            return;
        }
        if ((hVarM == s20.h.CLICK_CGI_REQ || hVarM == s20.h.EXPOSURE_CGI_REQ) && a()) {
            ja jaVar = new ja();
            jaVar.a("data", this.b.e());
            t20.a(9130083, this.i, (int) (System.currentTimeMillis() - j), jaVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, int i) throws JSONException {
        aw awVar = this.b;
        if (awVar == null) {
            return;
        }
        s20.h hVarM = awVar.m();
        if (hVarM == s20.h.AD_REQ) {
            t20.b(9130016, i);
            return;
        }
        if ((hVarM == s20.h.CLICK_CGI_REQ || hVarM == s20.h.EXPOSURE_CGI_REQ) && a()) {
            ja jaVar = new ja();
            jaVar.a("data", this.b.e());
            t20.a(9130082, this.i + i, (int) (System.currentTimeMillis() - j), jaVar);
        }
    }
}
