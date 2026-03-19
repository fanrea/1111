package com.ss.texturerender.math;

import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Quaternion {
    private double x0;
    private double x1;
    private double x2;
    private double x3;

    public Quaternion() {
        this.x2 = 0.0d;
        this.x1 = 0.0d;
        this.x0 = 0.0d;
        this.x3 = 1.0d;
    }

    public Quaternion(double d, double d2, double d3, double d4) {
        this.x0 = d;
        this.x1 = d2;
        this.x2 = d3;
        this.x3 = d4;
        normalize();
    }

    public Quaternion(float[] fArr) {
        double d;
        double d2;
        double d3;
        double d4;
        double d5 = fArr[0];
        double d6 = fArr[4];
        double d7 = fArr[8];
        double d8 = fArr[1];
        double d9 = fArr[5];
        double d10 = fArr[9];
        double d11 = fArr[2];
        double d12 = fArr[6];
        double d13 = fArr[10];
        double d14 = d5 + d9 + d13;
        if (d14 > 0.0d) {
            double dSqrt = Math.sqrt(d14 + 1.0d) * 2.0d;
            d3 = (d12 - d10) / dSqrt;
            d4 = (d7 - d11) / dSqrt;
            d2 = (d8 - d6) / dSqrt;
            d = 0.25d * dSqrt;
        } else {
            if ((d5 > d9) && (d5 > d13)) {
                double dSqrt2 = Math.sqrt(((d5 + 1.0d) - d9) - d13) * 2.0d;
                double d15 = (d12 - d10) / dSqrt2;
                double d16 = dSqrt2 * 0.25d;
                double d17 = (d6 + d8) / dSqrt2;
                double d18 = (d7 + d11) / dSqrt2;
                d4 = d17;
                d3 = d16;
                d2 = d18;
                d = d15;
            } else if (d9 > d13) {
                double dSqrt3 = Math.sqrt(((d9 + 1.0d) - d5) - d13) * 2.0d;
                double d19 = (d6 + d8) / dSqrt3;
                double d20 = dSqrt3 * 0.25d;
                double d21 = (d10 + d12) / dSqrt3;
                d = (d7 - d11) / dSqrt3;
                d4 = d20;
                d2 = d21;
                d3 = d19;
            } else {
                double dSqrt4 = Math.sqrt(((d13 + 1.0d) - d5) - d9) * 2.0d;
                double d22 = (d8 - d6) / dSqrt4;
                double d23 = (d7 + d11) / dSqrt4;
                double d24 = (d10 + d12) / dSqrt4;
                double d25 = dSqrt4 * 0.25d;
                d = d22;
                d2 = d25;
                d3 = d23;
                d4 = d24;
            }
        }
        this.x0 = d3;
        this.x1 = d4;
        this.x2 = d2;
        this.x3 = d;
        normalize();
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%.5f i + %.5f j + %.5f k + %.5f", Double.valueOf(this.x0), Double.valueOf(this.x1), Double.valueOf(this.x2), Double.valueOf(this.x3));
    }

    public double norm() {
        double d = this.x0;
        double d2 = this.x1;
        double d3 = (d * d) + (d2 * d2);
        double d4 = this.x2;
        double d5 = d3 + (d4 * d4);
        double d6 = this.x3;
        return Math.sqrt(d5 + (d6 * d6));
    }

    public boolean normalize() {
        double dNorm = norm();
        if (dNorm == 0.0d) {
            return false;
        }
        this.x0 /= dNorm;
        this.x1 /= dNorm;
        this.x2 /= dNorm;
        this.x3 /= dNorm;
        return true;
    }

    public Quaternion conjugate() {
        return new Quaternion(-this.x0, -this.x1, -this.x2, this.x3);
    }

    public Quaternion times(Quaternion quaternion) {
        double d = quaternion.x3;
        double d2 = this.x0;
        double d3 = quaternion.x0;
        double d4 = this.x3;
        double d5 = quaternion.x2;
        double d6 = this.x1;
        double d7 = (d * d2) + (d3 * d4) + (d5 * d6);
        double d8 = quaternion.x1;
        double d9 = this.x2;
        return new Quaternion(d7 - (d8 * d9), (((d * d6) + (d8 * d4)) + (d3 * d9)) - (d5 * d2), (((d * d9) + (d5 * d4)) + (d8 * d2)) - (d3 * d6), (((d * d4) - (d3 * d2)) - (d8 * d6)) - (d9 * d5));
    }

    public Quaternion inverse() {
        double d = this.x0;
        double d2 = this.x1;
        double d3 = this.x2;
        double d4 = this.x3;
        double d5 = (d * d) + (d2 * d2) + (d3 * d3) + (d4 * d4);
        return new Quaternion((-d) / d5, (-d2) / d5, (-d3) / d5, d4 / d5);
    }

    public Quaternion divides(Quaternion quaternion) {
        return times(quaternion.inverse());
    }

    public static Quaternion fromAxisAndAngle(Vector3d vector3d, double d) {
        if (!vector3d.normalize()) {
            return new Quaternion();
        }
        double d2 = d / 2.0d;
        double dSin = Math.sin(d2);
        return new Quaternion(vector3d.x * dSin, vector3d.y * dSin, vector3d.z * dSin, Math.cos(d2));
    }

    public Vector3d getAxis() {
        Vector3d vector3d = new Vector3d(this.x0, this.x1, this.x2);
        if (!vector3d.normalize()) {
            vector3d.set(1.0d, 0.0d, 0.0d);
        }
        return vector3d;
    }

    public double getAngle() {
        if (new Vector3d(this.x0, this.x1, this.x2).length() != 0.0d) {
            return Math.acos(this.x3) * 2.0d;
        }
        return 0.0d;
    }

    public static Quaternion rotateInto(Vector3d vector3d, Vector3d vector3d2) {
        Vector3d vector3dCross;
        double dSqrt = Math.sqrt(Vector3d.dot(vector3d, vector3d) * Vector3d.dot(vector3d2, vector3d2));
        double dDot = Vector3d.dot(vector3d, vector3d2) + dSqrt;
        if (dDot < dSqrt * 9.9999998245167E-14d) {
            dDot = 0.0d;
            vector3dCross = Math.abs(vector3d.x) > Math.abs(vector3d.z) ? new Vector3d(-vector3d.y, vector3d.x, 0.0d) : new Vector3d(0.0d, -vector3d.z, vector3d.y);
        } else {
            vector3dCross = Vector3d.cross(vector3d, vector3d2);
        }
        return new Quaternion(vector3dCross.x, vector3dCross.y, vector3dCross.z, dDot);
    }

    public static Vector3d applyToVector(Vector3d vector3d, Quaternion quaternion) {
        Vector3d vector3d2 = new Vector3d(quaternion.getX0(), quaternion.getX1(), quaternion.getX2());
        Vector3d vector3dScale = Vector3d.cross(vector3d2, vector3d).scale(2.0d);
        return Vector3d.add(Vector3d.add(vector3d, Vector3d.scale(vector3dScale, quaternion.getX3())), Vector3d.cross(vector3d2, vector3dScale));
    }

    public double getX0() {
        return this.x0;
    }

    public double getX1() {
        return this.x1;
    }

    public double getX2() {
        return this.x2;
    }

    public double getX3() {
        return this.x3;
    }
}
