package ca.da.ca.da;

import ca.da.ca.ja.r;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.applog.game.GameReportHelper;

/* compiled from: Register.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e extends a {
    public static final long[] f = {60000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};
    public static final long[] g = {180000, 180000, 360000, 360000, 540000, 540000, 720000, 720000};
    public static final long[] h = {ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT, 20000, 20000, 60000, 60000, 120000, 120000, 180000, 180000, 360000, 360000, 540000, 540000};

    public e(b bVar) {
        super(bVar, bVar.f.d.optLong("register_time", 0L));
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x021c  */
    @Override // ca.da.ca.da.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean c() throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 1224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ca.da.ca.da.e.c():boolean");
    }

    @Override // ca.da.ca.da.a
    public String d() {
        return GameReportHelper.REGISTER;
    }

    @Override // ca.da.ca.da.a
    public long[] e() {
        int iE = this.a.f.e();
        if (iE == 0) {
            return h;
        }
        if (iE == 1) {
            return g;
        }
        if (iE == 2) {
            return f;
        }
        r.a((Throwable) null);
        return g;
    }

    @Override // ca.da.ca.da.a
    public boolean g() {
        return true;
    }

    @Override // ca.da.ca.da.a
    public long h() {
        long j = this.a.f.f.getLong("bd_did_life_time", 0L);
        return j > 0 ? j : this.a.j.i ? 21600000L : 43200000L;
    }
}
