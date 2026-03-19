package com.qq.e.comm.plugin;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r20 implements xj {
    private final int a;
    private final int b;
    private final Path c = new Path();
    private final Paint d;

    @Override // com.qq.e.comm.plugin.xj
    public void a(Canvas canvas, int i, int i2) {
    }

    private r20(int i, JSONObject jSONObject) {
        this.a = i;
        this.b = jSONObject.optInt("tvfo", 0);
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.STROKE);
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("tvd");
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) > 0) {
            int length = length % 2 != 0 ? length + 1 : length;
            float[] fArr = new float[length];
            for (int i2 = 0; i2 < length; i2++) {
                fArr[i2] = t30.c(jSONArrayOptJSONArray.opt(i2)).a(new JSONObject[0]);
            }
            this.d.setPathEffect(new DashPathEffect(fArr, 0.0f));
        } else {
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStrokeJoin(Paint.Join.ROUND);
        }
        if (jSONObject.opt("tvs") != null) {
            this.d.setStrokeWidth(t30.c(r7).a(new JSONObject[0]));
        }
        String strOptString = jSONObject.optString("tvc");
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        this.d.setColor(v30.b(t30.c((Object) strOptString)));
    }

    @Override // com.qq.e.comm.plugin.xj
    public void b(Canvas canvas, int i, int i2) {
        if (this.a == 1) {
            canvas.drawPath(this.c, this.d);
        }
    }

    public void c(View view, MotionEvent motionEvent) {
        if (this.a == 1) {
            this.c.moveTo(motionEvent.getX(), motionEvent.getY());
        }
    }

    public static r20 a(JSONObject jSONObject) {
        int iOptInt = jSONObject.optInt("tvt", 0);
        if (iOptInt == 0) {
            return null;
        }
        return new r20(iOptInt, jSONObject);
    }

    public void b(View view, MotionEvent motionEvent) {
        if (this.a == 1) {
            this.c.lineTo(motionEvent.getX(), motionEvent.getY());
            view.invalidate();
        }
    }

    public void a(View view, MotionEvent motionEvent) {
        if (-1 == this.b) {
            return;
        }
        this.c.reset();
        view.invalidate();
    }
}
