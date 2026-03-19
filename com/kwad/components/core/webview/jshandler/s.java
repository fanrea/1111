package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import com.bytedance.applog.aggregation.MetricsSQLiteCacheKt;
import com.kwad.sdk.utils.bj;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class s implements SensorEventListener, com.kwad.sdk.core.webview.c.a {
    private Map<Integer, com.kwad.sdk.core.webview.c.c> aeq = new ConcurrentHashMap();

    @Override // com.kwad.sdk.core.webview.c.a
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.aeq.put(Integer.valueOf(aVar.type), cVar);
            a(aVar.type, aVar.aet, cVar);
            return;
        }
        cVar.onError(-1, "data is empty");
    }

    private void a(int i, int i2, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.utils.bj.apC().a(i, i2, this, new bj.b() { // from class: com.kwad.components.core.webview.jshandler.s.1
            @Override // com.kwad.sdk.utils.bj.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.bj.apC().c(this);
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        com.kwad.sdk.core.webview.c.c cVar = this.aeq.get(Integer.valueOf(type));
        if (cVar != null) {
            ArrayList<Float> arrayList = new ArrayList<>();
            for (int i = 0; i < sensorEvent.values.length; i++) {
                arrayList.add(Float.valueOf(sensorEvent.values[i]));
            }
            a aVar = new a();
            aVar.aeu = arrayList;
            aVar.timestamp = sensorEvent.timestamp;
            aVar.accuracy = sensorEvent.accuracy;
            cVar.a(aVar);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    public static class a extends com.kwad.sdk.core.response.a.a {
        public int accuracy;
        public int aet;
        public ArrayList<Float> aeu;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i = this.type;
            if (i != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "type", i);
            }
            int i2 = this.aet;
            if (i2 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, MetricsSQLiteCacheKt.METRICS_INTERVAL, i2);
            }
            long j = this.timestamp;
            if (j != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, com.alipay.sdk.m.t.a.k, j);
            }
            int i3 = this.accuracy;
            if (i3 != 0) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "accuracy", i3);
            }
            if (!this.aeu.isEmpty()) {
                com.kwad.sdk.utils.aa.putValue(jSONObject, "values", this.aeu);
            }
            return jSONObject;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(JSONObject jSONObject) {
            if (jSONObject == null || jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.aet = jSONObject.optInt(MetricsSQLiteCacheKt.METRICS_INTERVAL);
            this.timestamp = jSONObject.optLong(com.alipay.sdk.m.t.a.k);
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (jSONArrayOptJSONArray == null) {
                this.aeu = arrayList;
                return;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                try {
                    Object obj = jSONArrayOptJSONArray.get(i);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.aeu = arrayList;
        }
    }
}
