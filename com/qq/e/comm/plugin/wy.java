package com.qq.e.comm.plugin;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class wy {
    private static float a(List<PointF> list, List<PointF> list2) {
        if (list == null || list2 == null) {
            return -1.0f;
        }
        int iMin = Math.min(list.size(), list2.size());
        if (iMin >= 20) {
            iMin = 20;
        }
        return a(list, list2, iMin);
    }

    private static float a(List<PointF> list, List<PointF> list2, int i) {
        return a(a(a(list, i)), a(a(list2, i)));
    }

    private static float a(float[] fArr, float[] fArr2) {
        if (fArr.length != fArr2.length || fArr.length == 0 || fArr2.length == 0) {
            return -1.0f;
        }
        double d = 0.0d;
        double dPow = 0.0d;
        double dPow2 = 0.0d;
        for (int i = 0; i < fArr.length; i++) {
            float f = fArr[i];
            double d2 = fArr2[i] * f;
            Double.isNaN(d2);
            d += d2;
            dPow += Math.pow(f, 2.0d);
            dPow2 += Math.pow(fArr2[i], 2.0d);
        }
        return (float) (d / (Math.sqrt(dPow) * Math.sqrt(dPow2)));
    }

    private static float a(PointF pointF, PointF pointF2) {
        return (float) Math.hypot(pointF.x - pointF2.x, pointF.y - pointF2.y);
    }

    public static float a(List<PointF> list, List<PointF> list2, boolean z) {
        float fA = a(list, list2);
        if (!z) {
            return fA;
        }
        Collections.reverse(list);
        return Math.max(fA, a(list, list2));
    }

    private static List<PointF> a(List<PointF> list, double d) {
        double d2;
        double d3;
        int size = list.size();
        int i = 1;
        if (size <= 1 || d < 1.0d) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        PointF pointF = list.get(0);
        arrayList.add(new PointF(pointF.x, pointF.y));
        double d4 = 0.0d;
        while (i < size) {
            PointF pointF2 = list.get(i);
            double dHypot = Math.hypot(pointF2.x - pointF.x, pointF2.y - pointF.y);
            double d5 = dHypot + d4;
            while (d5 >= d) {
                if (d5 == d) {
                    pointF = new PointF(pointF2.x, pointF2.y);
                    d2 = d4;
                    d3 = dHypot;
                    d5 = 0.0d;
                } else {
                    double d6 = (d - d4) / dHypot;
                    float f = pointF.x;
                    d2 = d4;
                    double d7 = f;
                    d3 = dHypot;
                    double d8 = pointF2.x - f;
                    Double.isNaN(d8);
                    Double.isNaN(d7);
                    double d9 = d7 + (d8 * d6);
                    float f2 = pointF.y;
                    double d10 = f2;
                    double d11 = pointF2.y - f2;
                    Double.isNaN(d11);
                    Double.isNaN(d10);
                    pointF = new PointF((float) d9, (float) (d10 + (d11 * d6)));
                    d5 -= d;
                }
                arrayList.add(pointF);
                d4 = d2;
                dHypot = d3;
            }
            i++;
            pointF = pointF2;
            d4 = d5;
        }
        return arrayList;
    }

    private static List<PointF> a(List<PointF> list, int i) {
        int size;
        if (i <= 1 || i == (size = list.size())) {
            return list;
        }
        PointF pointF = list.get(0);
        double d = 0.0d;
        for (int i2 = 1; i2 < size; i2++) {
            double dA = a(pointF, list.get(i2));
            Double.isNaN(dA);
            d += dA;
            pointF = list.get(i2);
        }
        double d2 = i - 1;
        Double.isNaN(d2);
        List<PointF> listA = a(list, d / d2);
        if (listA.size() < i) {
            PointF pointF2 = list.get(size - 1);
            listA.add(new PointF(pointF2.x, pointF2.y));
        }
        return listA;
    }

    private static float[] a(List<PointF> list) {
        float[] fArr = new float[list.size() * 2];
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        for (int i = 1; i < list.size(); i++) {
            int i2 = i * 2;
            int i3 = i - 1;
            fArr[i2] = list.get(i).x - list.get(i3).x;
            fArr[i2 + 1] = list.get(i).y - list.get(i3).y;
        }
        return fArr;
    }
}
