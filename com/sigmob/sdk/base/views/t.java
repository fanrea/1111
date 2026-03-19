package com.sigmob.sdk.base.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class t extends View {
    Paint a;
    private final float b;

    public t(Context context, float rating) {
        super(context);
        this.a = new Paint();
        this.b = rating;
    }

    private Path a(float outR, float inR) {
        Path path = new Path();
        path.moveTo(a(288) * outR, b(288) * outR);
        path.lineTo(a(108) * inR, b(108) * inR);
        path.lineTo(a(144) * outR, b(144) * outR);
        path.lineTo(a(180) * inR, b(180) * inR);
        path.lineTo(a(216) * outR, outR * b(216));
        path.lineTo(a(252) * inR, inR * b(252));
        path.close();
        return path;
    }

    private Path b(float outR, float inR) {
        Path path = new Path();
        path.moveTo(a(0) * outR, b(0) * outR);
        path.lineTo(a(36) * inR, b(36) * inR);
        path.lineTo(a(72) * outR, b(72) * outR);
        path.lineTo(a(108) * inR, b(108) * inR);
        path.lineTo(a(144) * outR, b(144) * outR);
        path.lineTo(a(180) * inR, b(180) * inR);
        path.lineTo(a(216) * outR, b(216) * outR);
        path.lineTo(a(252) * inR, b(252) * inR);
        path.lineTo(a(288) * outR, outR * b(288));
        path.lineTo(a(324) * inR, inR * b(324));
        path.close();
        return path;
    }

    float a(int num) {
        return (float) Math.cos((num * 3.141592653589793d) / 180.0d);
    }

    float b(int num) {
        return (float) Math.sin((num * 3.141592653589793d) / 180.0d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Path pathB;
        float f;
        super.onDraw(canvas);
        int height = getHeight();
        int i = (int) this.b;
        float f2 = height;
        float f3 = f2 / 3.0f;
        float fB = (b(18) * f3) / b(126);
        boolean z = true;
        this.a.setAntiAlias(true);
        this.a.setColor(Color.parseColor("#FFA500"));
        int i2 = i;
        while (true) {
            float f4 = 0.0f;
            if (i2 <= 0) {
                break;
            }
            if (z) {
                z = false;
                f = f3 + 2.0f;
                f4 = f2 / 2.0f;
            } else {
                canvas.rotate(18.0f);
                f = 2.2f * f3;
            }
            canvas.translate(f, f4);
            canvas.rotate(-18.0f);
            Path pathB2 = b(f3, fB);
            this.a.setStyle(Paint.Style.STROKE);
            canvas.drawPath(pathB2, this.a);
            this.a.setStyle(Paint.Style.FILL);
            canvas.drawPath(pathB2, this.a);
            i2--;
        }
        float f5 = this.b;
        float f6 = i;
        if (f5 > f6) {
            float f7 = (f5 - f6) + 0.25f;
            if (f7 >= 1.0f) {
                canvas.rotate(18.0f);
                canvas.translate(f3 * 2.2f, 0.0f);
                canvas.rotate(-18.0f);
                pathB = b(f3, fB);
                this.a.setStyle(Paint.Style.STROKE);
                this.a.setColor(Color.parseColor("#FFA500"));
                canvas.drawPath(pathB, this.a);
            } else {
                canvas.rotate(18.0f);
                if (f7 >= 0.5f) {
                    canvas.translate(f3 * 2.2f, 0.0f);
                    canvas.rotate(-18.0f);
                    Path pathB3 = b(f3, fB);
                    this.a.setColor(Color.parseColor("#FFA500"));
                    this.a.setStyle(Paint.Style.STROKE);
                    canvas.drawPath(pathB3, this.a);
                    pathB = a(f3, fB);
                    this.a.setColor(Color.parseColor("#FFA500"));
                } else {
                    canvas.translate(f3 * 2.2f, 0.0f);
                    canvas.rotate(-18.0f);
                    pathB = b(f3, fB);
                    this.a.setStyle(Paint.Style.STROKE);
                    this.a.setColor(Color.parseColor("#FFA500"));
                    canvas.drawPath(pathB, this.a);
                }
            }
            this.a.setStyle(Paint.Style.FILL);
            canvas.drawPath(pathB, this.a);
        }
        for (int i3 = (int) (5.0f - this.b); i3 > 0; i3--) {
            canvas.rotate(18.0f);
            canvas.translate(f3 * 2.2f, 0.0f);
            canvas.rotate(-18.0f);
            Path pathB4 = b(f3, fB);
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setColor(Color.parseColor("#FFA500"));
            canvas.drawPath(pathB4, this.a);
        }
    }
}
