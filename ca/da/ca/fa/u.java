package ca.da.ca.fa;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: SimCountryLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class u extends c {
    public static volatile String f;
    public static AtomicBoolean g = new AtomicBoolean(false);
    public final Context e;

    public u(Context context) {
        super(true, false);
        this.e = context;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) {
        if (NetworkUtils.isTelephonyEnable()) {
            try {
                if (f == null && g.compareAndSet(false, true)) {
                    ca.da.ca.ja.r.a("SimCountryLoader do load sim country", (Throwable) null);
                    try {
                        f = ((TelephonyManager) this.e.getSystemService("phone")).getSimCountryIso();
                    } catch (Throwable unused) {
                    }
                    if (f == null) {
                        f = "";
                    }
                }
                h.a(jSONObject, "sim_region", f);
            } catch (Throwable unused2) {
            }
        }
        return true;
    }
}
