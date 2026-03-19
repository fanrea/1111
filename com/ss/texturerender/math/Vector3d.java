package com.ss.texturerender.math;

import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Vector3d {
    public double x;
    public double y;
    public double z;

    public Vector3d() {
    }

    public Vector3d(double d, double d2, double d3) {
        set(d, d2, d3);
    }

    public Vector3d(Vector3d vector3d) {
        this.x = vector3d.x;
        this.y = vector3d.y;
        this.z = vector3d.z;
    }

    public Vector3d(float[] fArr) {
        double d = fArr[0];
        float f = fArr[4];
        float f2 = fArr[8];
        double d2 = fArr[1];
        double d3 = fArr[5];
        double d4 = fArr[9];
        double d5 = fArr[2];
        double d6 = fArr[6];
        double d7 = fArr[10];
        double dSqrt = Math.sqrt((d * d) + (d2 * d2));
        if (!(dSqrt < 1.0E-6d)) {
            this.x = Math.atan2(d6, d7);
            this.y = Math.atan2(-d5, dSqrt);
            this.z = Math.atan2(d2, d);
        } else {
            this.x = Math.atan2(-d4, d3);
            this.y = Math.atan2(-d5, dSqrt);
            this.z = 0.0d;
        }
        this.x = (this.x * 180.0d) / 3.141592653589793d;
        this.y = (this.y * 180.0d) / 3.141592653589793d;
        this.z = (this.z * 180.0d) / 3.141592653589793d;
    }

    public void set(double d, double d2, double d3) {
        this.x = d;
        this.y = d2;
        this.z = d3;
    }

    public void setComponent(int i, double d) {
        if (i == 0) {
            this.x = d;
        } else if (i == 1) {
            this.y = d;
        } else {
            this.z = d;
        }
    }

    public void setZero() {
        this.z = 0.0d;
        this.y = 0.0d;
        this.x = 0.0d;
    }

    public void set(Vector3d vector3d) {
        this.x = vector3d.x;
        this.y = vector3d.y;
        this.z = vector3d.z;
    }

    public Vector3d sub(Vector3d vector3d) {
        return new Vector3d(this.x - vector3d.x, this.y - vector3d.y, this.z - vector3d.z);
    }

    public Vector3d scale(double d) {
        this.x *= d;
        this.y *= d;
        this.z *= d;
        return this;
    }

    public Vector3d devide(double d) {
        this.x /= d;
        this.y /= d;
        this.z /= d;
        return this;
    }

    public boolean normalize() {
        double length = length();
        if (length == 0.0d) {
            return false;
        }
        scale(1.0d / length);
        return true;
    }

    public static double dot(Vector3d vector3d, Vector3d vector3d2) {
        return (vector3d.x * vector3d2.x) + (vector3d.y * vector3d2.y) + (vector3d.z * vector3d2.z);
    }

    public double length() {
        double d = this.x;
        double d2 = this.y;
        double d3 = (d * d) + (d2 * d2);
        double d4 = this.z;
        return Math.sqrt(d3 + (d4 * d4));
    }

    public boolean sameValues(Vector3d vector3d) {
        return this.x == vector3d.x && this.y == vector3d.y && this.z == vector3d.z;
    }

    public static void add(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3) {
        vector3d3.set(vector3d.x + vector3d2.x, vector3d.y + vector3d2.y, vector3d.z + vector3d2.z);
    }

    public static Vector3d add(Vector3d vector3d, Vector3d vector3d2) {
        return new Vector3d(vector3d.x + vector3d2.x, vector3d.y + vector3d2.y, vector3d.z + vector3d2.z);
    }

    public static Vector3d scale(Vector3d vector3d, double d) {
        return new Vector3d(vector3d.x * d, vector3d.y * d, vector3d.z * d);
    }

    public static void sub(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3) {
        vector3d3.set(vector3d.x - vector3d2.x, vector3d.y - vector3d2.y, vector3d.z - vector3d2.z);
    }

    public static Vector3d cross(Vector3d vector3d, Vector3d vector3d2) {
        double d = vector3d.y;
        double d2 = vector3d2.z;
        double d3 = vector3d.z;
        double d4 = vector3d2.y;
        double d5 = (d * d2) - (d3 * d4);
        double d6 = vector3d2.x;
        double d7 = vector3d.x;
        return new Vector3d(d5, (d3 * d6) - (d2 * d7), (d7 * d4) - (d * d6));
    }

    public static void cross(Vector3d vector3d, Vector3d vector3d2, Vector3d vector3d3) {
        double d = vector3d.y;
        double d2 = vector3d2.z;
        double d3 = vector3d.z;
        double d4 = vector3d2.y;
        double d5 = vector3d2.x;
        double d6 = vector3d.x;
        vector3d3.set((d * d2) - (d3 * d4), (d3 * d5) - (d2 * d6), (d6 * d4) - (d * d5));
    }

    public static void ortho(Vector3d vector3d, Vector3d vector3d2) {
        int iLargestAbsComponent = largestAbsComponent(vector3d) - 1;
        if (iLargestAbsComponent < 0) {
            iLargestAbsComponent = 2;
        }
        vector3d2.setZero();
        vector3d2.setComponent(iLargestAbsComponent, 1.0d);
        cross(vector3d, vector3d2, vector3d2);
        vector3d2.normalize();
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%+5f %+05f %+05f", Double.valueOf(this.x), Double.valueOf(this.y), Double.valueOf(this.z));
    }

    public static int largestAbsComponent(Vector3d vector3d) {
        double dAbs = Math.abs(vector3d.x);
        double dAbs2 = Math.abs(vector3d.y);
        double dAbs3 = Math.abs(vector3d.z);
        return dAbs > dAbs2 ? dAbs > dAbs3 ? 0 : 2 : dAbs2 > dAbs3 ? 1 : 2;
    }
}
