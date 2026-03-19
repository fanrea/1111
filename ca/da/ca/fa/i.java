package ca.da.ca.fa;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.bytedance.apm.common.utility.NetworkUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: DeviceParamsLoader.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class i extends c {
    public static volatile String g;
    public static volatile String h;
    public static AtomicBoolean i = new AtomicBoolean(false);
    public final Context e;
    public final h f;

    public i(Context context, h hVar) {
        super(false, false);
        this.e = context;
        this.f = hVar;
    }

    @Override // ca.da.ca.fa.c
    public boolean a(JSONObject jSONObject) {
        if (NetworkUtils.isTelephonyEnable()) {
            try {
                if (g == null || h == null) {
                    if (i.compareAndSet(false, true)) {
                        TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService("phone");
                        ca.da.ca.ja.r.a("DeviceParamsLoader do load operator", (Throwable) null);
                        if (telephonyManager != null) {
                            g = telephonyManager.getNetworkOperatorName();
                            h = telephonyManager.getNetworkOperator();
                        } else {
                            g = "";
                            h = "";
                        }
                    } else {
                        g = "";
                        h = "";
                    }
                    h.a(jSONObject, "carrier", g);
                    h.a(jSONObject, "mcc_mnc", h);
                }
            } catch (Throwable unused) {
                g = "";
                h = "";
                try {
                    h.a(jSONObject, "carrier", g);
                    h.a(jSONObject, "mcc_mnc", h);
                } catch (Throwable unused2) {
                }
            }
        }
        try {
            h.a(jSONObject, "clientudid", ((ca.da.ca.ja.f) this.f.g).a());
            h.a(jSONObject, "openudid", ((ca.da.ca.ja.f) this.f.g).a(false));
            j.a(this.e);
        } catch (Throwable unused3) {
        }
        return true;
    }
}
