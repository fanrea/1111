package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class m1 implements SensorEventListener {
    private static volatile m1 d;
    private int b;
    private SensorManager hc;
    private int c = 0;
    private float[] u = new float[3];
    private ArrayList an = new ArrayList();

    static {
        new DecimalFormat((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28ecfe", new byte[]{115, 116, 70}));
        d = null;
    }

    private m1(Context context) {
        this.hc = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            this.hc = (SensorManager) applicationContext.getSystemService((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "79826e", new byte[]{com.sigmob.sdk.archives.tar.e.M, 62, 69, 85, 6, 96}));
        }
    }

    private synchronized void c() {
        try {
            SensorManager sensorManager = this.hc;
            if (sensorManager != null) {
                if (this.b == 0) {
                    if (!this.hc.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.b++;
            }
        } catch (Exception unused) {
        }
    }

    public static m1 d(Context context) {
        if (d == null) {
            synchronized (m1.class) {
                if (d == null) {
                    d = new m1(context);
                }
            }
        }
        return d;
    }

    private synchronized void u() {
        try {
            SensorManager sensorManager = this.hc;
            if (sensorManager != null) {
                int i = this.b - 1;
                this.b = i;
                if (i == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
            com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "2ba200", new byte[]{com.sigmob.sdk.archives.tar.e.H, 115, 17, 121, 26});
        }
    }

    public final synchronized String b() {
        StringBuilder sb = new StringBuilder();
        int size = this.an.size();
        if (size <= 0) {
            return null;
        }
        try {
            ArrayList arrayList = this.an;
            int i = size - 50;
            if (i <= 0) {
                i = 0;
            }
            List<JSONArray> listSubList = arrayList.subList(i, size);
            if (listSubList.size() > 0) {
                for (JSONArray jSONArray : listSubList) {
                    if (jSONArray != null) {
                        sb.append(jSONArray.get(0).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28f2c7", new byte[]{111}));
                        sb.append(jSONArray.get(1).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "f414bd", new byte[]{59}));
                        sb.append(jSONArray.get(2).toString());
                        sb.append((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "98efac", new byte[]{com.sigmob.sdk.archives.tar.e.L}));
                    }
                }
            }
            if (sb.length() > 0) {
                sb.delete(sb.length() - 1, sb.length());
            }
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public final JSONArray d() {
        char c;
        JSONArray jSONArray;
        BigDecimal bigDecimal;
        try {
            c = pble.d() != null ? (char) 1 : (char) 0;
        } catch (Throwable unused) {
            c = 65535;
        }
        if (c != 1) {
            return null;
        }
        c();
        try {
            try {
                synchronized (this) {
                    int i = 0;
                    while (this.c == 0 && i < 10) {
                        i++;
                        wait(1000L);
                    }
                }
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.u[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.u[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.u[2]);
            } catch (Exception unused2) {
                com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d1d471", new byte[]{102, 32, 20, 127, 15});
                jSONArray = new JSONArray();
                jSONArray.put(new BigDecimal(this.u[0]).setScale(2, 4));
                jSONArray.put(new BigDecimal(this.u[1]).setScale(2, 4));
                bigDecimal = new BigDecimal(this.u[2]);
            }
            jSONArray.put(bigDecimal.setScale(2, 4));
            u();
            this.c = 0;
            return jSONArray;
        } catch (Throwable th) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(new BigDecimal(this.u[0]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.u[1]).setScale(2, 4));
            jSONArray2.put(new BigDecimal(this.u[2]).setScale(2, 4));
            u();
            this.c = 0;
            throw th;
        }
    }

    public final synchronized void hc() {
        JSONArray jSONArrayD = d();
        if (jSONArrayD == null) {
            return;
        }
        this.an.add(jSONArrayD);
        try {
            int size = this.an.size();
            if (size > 100) {
                ArrayList arrayList = new ArrayList(this.an.subList(size - 50, size));
                this.an.clear();
                this.an = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        this.u = sensorEvent.values;
        this.c = 1;
    }
}
