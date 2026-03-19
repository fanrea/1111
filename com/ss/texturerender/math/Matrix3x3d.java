package com.ss.texturerender.math;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Matrix3x3d {
    public double[] m;

    public Matrix3x3d() {
        this.m = new double[9];
    }

    public Matrix3x3d(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.m = new double[]{d, d2, d3, d4, d5, d6, d7, d8, d9};
    }

    public Matrix3x3d(Matrix3x3d matrix3x3d) {
        this.m = new double[]{dArr[0], dArr[1], dArr[2], dArr[3], dArr[4], dArr[5], dArr[6], dArr[7], dArr[8]};
        double[] dArr = matrix3x3d.m;
    }

    public void set(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double[] dArr = this.m;
        dArr[0] = d;
        dArr[1] = d2;
        dArr[2] = d3;
        dArr[3] = d4;
        dArr[4] = d5;
        dArr[5] = d6;
        dArr[6] = d7;
        dArr[7] = d8;
        dArr[8] = d9;
    }

    public void set(Matrix3x3d matrix3x3d) {
        double[] dArr = this.m;
        double[] dArr2 = matrix3x3d.m;
        dArr[0] = dArr2[0];
        dArr[1] = dArr2[1];
        dArr[2] = dArr2[2];
        dArr[3] = dArr2[3];
        dArr[4] = dArr2[4];
        dArr[5] = dArr2[5];
        dArr[6] = dArr2[6];
        dArr[7] = dArr2[7];
        dArr[8] = dArr2[8];
    }

    public void setZero() {
        double[] dArr = this.m;
        dArr[8] = 0.0d;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[5] = 0.0d;
        dArr[4] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[0] = 0.0d;
    }

    public Matrix3x3d setIdentity() {
        double[] dArr = this.m;
        dArr[7] = 0.0d;
        dArr[6] = 0.0d;
        dArr[5] = 0.0d;
        dArr[3] = 0.0d;
        dArr[2] = 0.0d;
        dArr[1] = 0.0d;
        dArr[8] = 1.0d;
        dArr[4] = 1.0d;
        dArr[0] = 1.0d;
        return this;
    }

    public void setSameDiagonal(double d) {
        double[] dArr = this.m;
        dArr[8] = d;
        dArr[4] = d;
        dArr[0] = d;
    }

    public double get(int i, int i2) {
        return this.m[(i * 3) + i2];
    }

    public void set(int i, int i2, double d) {
        this.m[(i * 3) + i2] = d;
    }

    public void getColumn(int i, Vector3d vector3d) {
        vector3d.x = this.m[i];
        vector3d.y = this.m[i + 3];
        vector3d.z = this.m[i + 6];
    }

    public void setColumn(int i, Vector3d vector3d) {
        this.m[i] = vector3d.x;
        this.m[i + 3] = vector3d.y;
        this.m[i + 6] = vector3d.z;
    }

    public void scale(double d) {
        double[] dArr = this.m;
        dArr[0] = dArr[0] * d;
        dArr[1] = dArr[1] * d;
        dArr[2] = dArr[2] * d;
        dArr[3] = dArr[3] * d;
        dArr[4] = dArr[4] * d;
        dArr[5] = dArr[5] * d;
        dArr[6] = dArr[6] * d;
        dArr[7] = dArr[7] * d;
        dArr[8] = dArr[8] * d;
    }

    public Matrix3x3d mult(double d) {
        Matrix3x3d matrix3x3d = new Matrix3x3d();
        for (int i = 0; i < 9; i++) {
            matrix3x3d.m[i] = this.m[i] * d;
        }
        return matrix3x3d;
    }

    public void plusEquals(Matrix3x3d matrix3x3d) {
        double[] dArr = this.m;
        double d = dArr[0];
        double[] dArr2 = matrix3x3d.m;
        dArr[0] = d + dArr2[0];
        dArr[1] = dArr[1] + dArr2[1];
        dArr[2] = dArr[2] + dArr2[2];
        dArr[3] = dArr[3] + dArr2[3];
        dArr[4] = dArr[4] + dArr2[4];
        dArr[5] = dArr[5] + dArr2[5];
        dArr[6] = dArr[6] + dArr2[6];
        dArr[7] = dArr[7] + dArr2[7];
        dArr[8] = dArr[8] + dArr2[8];
    }

    public void minusEquals(Matrix3x3d matrix3x3d) {
        double[] dArr = this.m;
        double d = dArr[0];
        double[] dArr2 = matrix3x3d.m;
        dArr[0] = d - dArr2[0];
        dArr[1] = dArr[1] - dArr2[1];
        dArr[2] = dArr[2] - dArr2[2];
        dArr[3] = dArr[3] - dArr2[3];
        dArr[4] = dArr[4] - dArr2[4];
        dArr[5] = dArr[5] - dArr2[5];
        dArr[6] = dArr[6] - dArr2[6];
        dArr[7] = dArr[7] - dArr2[7];
        dArr[8] = dArr[8] - dArr2[8];
    }

    public Matrix3x3d transpose() {
        Matrix3x3d matrix3x3d = new Matrix3x3d();
        double[] dArr = this.m;
        double d = dArr[1];
        double d2 = dArr[2];
        double d3 = dArr[5];
        double[] dArr2 = matrix3x3d.m;
        dArr2[0] = dArr[0];
        dArr2[1] = dArr[3];
        dArr2[2] = dArr[6];
        dArr2[3] = d;
        dArr2[4] = dArr[4];
        dArr2[5] = dArr[7];
        dArr2[6] = d2;
        dArr2[7] = d3;
        dArr2[8] = dArr[8];
        return matrix3x3d;
    }

    public static void add(Matrix3x3d matrix3x3d, Matrix3x3d matrix3x3d2, Matrix3x3d matrix3x3d3) {
        double[] dArr = matrix3x3d3.m;
        double[] dArr2 = matrix3x3d.m;
        double d = dArr2[0];
        double[] dArr3 = matrix3x3d2.m;
        dArr[0] = d + dArr3[0];
        dArr[1] = dArr2[1] + dArr3[1];
        dArr[2] = dArr2[2] + dArr3[2];
        dArr[3] = dArr2[3] + dArr3[3];
        dArr[4] = dArr2[4] + dArr3[4];
        dArr[5] = dArr2[5] + dArr3[5];
        dArr[6] = dArr2[6] + dArr3[6];
        dArr[7] = dArr2[7] + dArr3[7];
        dArr[8] = dArr2[8] + dArr3[8];
    }

    public static void mult(Matrix3x3d matrix3x3d, Matrix3x3d matrix3x3d2, Matrix3x3d matrix3x3d3) {
        double[] dArr = matrix3x3d.m;
        double d = dArr[0];
        double[] dArr2 = matrix3x3d2.m;
        double d2 = dArr2[0];
        double d3 = dArr[1];
        double d4 = dArr2[3];
        double d5 = dArr[2];
        double d6 = dArr2[6];
        double d7 = (d * d2) + (d3 * d4) + (d5 * d6);
        double d8 = dArr2[1];
        double d9 = dArr2[4];
        double d10 = dArr2[7];
        double d11 = (d * d8) + (d3 * d9) + (d5 * d10);
        double d12 = dArr2[2];
        double d13 = dArr2[5];
        double d14 = dArr2[8];
        double d15 = (d * d12) + (d3 * d13) + (d5 * d14);
        double d16 = dArr[3];
        double d17 = dArr[4];
        double d18 = dArr[5];
        double d19 = (d16 * d2) + (d17 * d4) + (d18 * d6);
        double d20 = (d16 * d8) + (d17 * d9) + (d18 * d10);
        double d21 = (d16 * d12) + (d17 * d13) + (d18 * d14);
        double d22 = dArr[6];
        double d23 = dArr[7];
        double d24 = dArr[8];
        matrix3x3d3.set(d7, d11, d15, d19, d20, d21, (d2 * d22) + (d4 * d23) + (d6 * d24), (d8 * d22) + (d9 * d23) + (d10 * d24), (d22 * d12) + (d23 * d13) + (d24 * d14));
    }

    public static Matrix3x3d mult(Matrix3x3d matrix3x3d, Matrix3x3d matrix3x3d2) {
        double[] dArr = matrix3x3d.m;
        double d = dArr[0];
        double[] dArr2 = matrix3x3d2.m;
        double d2 = dArr2[0];
        double d3 = dArr[1];
        double d4 = dArr2[3];
        double d5 = dArr[2];
        double d6 = dArr2[6];
        double d7 = (d * d2) + (d3 * d4) + (d5 * d6);
        double d8 = dArr2[1];
        double d9 = dArr2[4];
        double d10 = dArr2[7];
        double d11 = (d * d8) + (d3 * d9) + (d5 * d10);
        double d12 = dArr2[2];
        double d13 = dArr2[5];
        double d14 = dArr2[8];
        double d15 = (d * d12) + (d3 * d13) + (d5 * d14);
        double d16 = dArr[3];
        double d17 = dArr[4];
        double d18 = dArr[5];
        double d19 = (d16 * d2) + (d17 * d4) + (d18 * d6);
        double d20 = (d16 * d8) + (d17 * d9) + (d18 * d10);
        double d21 = (d16 * d12) + (d17 * d13) + (d18 * d14);
        double d22 = dArr[6];
        double d23 = dArr[7];
        double d24 = dArr[8];
        return new Matrix3x3d(d7, d11, d15, d19, d20, d21, (d2 * d22) + (d4 * d23) + (d6 * d24), (d8 * d22) + (d9 * d23) + (d10 * d24), (d22 * d12) + (d23 * d13) + (d24 * d14));
    }

    public static void mult(Matrix3x3d matrix3x3d, Vector3d vector3d, Vector3d vector3d2) {
        double d = (matrix3x3d.m[0] * vector3d.x) + (matrix3x3d.m[1] * vector3d.y) + (matrix3x3d.m[2] * vector3d.z);
        double d2 = (matrix3x3d.m[3] * vector3d.x) + (matrix3x3d.m[4] * vector3d.y) + (matrix3x3d.m[5] * vector3d.z);
        double d3 = (matrix3x3d.m[6] * vector3d.x) + (matrix3x3d.m[7] * vector3d.y) + (matrix3x3d.m[8] * vector3d.z);
        vector3d2.x = d;
        vector3d2.y = d2;
        vector3d2.z = d3;
    }

    public double determinant() {
        return ((get(0, 0) * ((get(1, 1) * get(2, 2)) - (get(2, 1) * get(1, 2)))) - (get(0, 1) * ((get(1, 0) * get(2, 2)) - (get(1, 2) * get(2, 0))))) + (get(0, 2) * ((get(1, 0) * get(2, 1)) - (get(1, 1) * get(2, 0))));
    }

    public boolean invert(Matrix3x3d matrix3x3d) {
        double dDeterminant = determinant();
        if (dDeterminant == 0.0d) {
            return false;
        }
        double d = 1.0d / dDeterminant;
        double[] dArr = this.m;
        double d2 = dArr[4];
        double d3 = dArr[8];
        double d4 = dArr[7];
        double d5 = dArr[5];
        double d6 = dArr[1];
        double d7 = dArr[2];
        double d8 = dArr[3];
        double d9 = dArr[6];
        double d10 = dArr[0];
        matrix3x3d.set(((d2 * d3) - (d4 * d5)) * d, (-((d6 * d3) - (d7 * d4))) * d, ((d6 * d5) - (d7 * d2)) * d, (-((d8 * d3) - (d5 * d9))) * d, ((d3 * d10) - (d7 * d9)) * d, (-((d5 * d10) - (d7 * d8))) * d, ((d8 * d4) - (d9 * d2)) * d, (-((d4 * d10) - (d9 * d6))) * d, ((d10 * d2) - (d8 * d6)) * d);
        return true;
    }

    public double maxNorm() {
        double dAbs = Math.abs(this.m[0]);
        int i = 1;
        while (true) {
            double[] dArr = this.m;
            if (i >= dArr.length) {
                return dAbs;
            }
            dAbs = Math.max(dAbs, Math.abs(dArr[i]));
            i++;
        }
    }

    public static Matrix3x3d rotationMatrix3x3(Quaternion quaternion) {
        double x0 = quaternion.getX0() * quaternion.getX0();
        double x1 = quaternion.getX1() * quaternion.getX1();
        double x2 = quaternion.getX2() * quaternion.getX2();
        double x3 = quaternion.getX3() * quaternion.getX3();
        double x02 = quaternion.getX0() * quaternion.getX1();
        double x03 = quaternion.getX0() * quaternion.getX2();
        double x12 = quaternion.getX1() * quaternion.getX2();
        double x04 = quaternion.getX0() * quaternion.getX3();
        double x13 = quaternion.getX1() * quaternion.getX3();
        double d = x02 * 2.0d;
        double x22 = quaternion.getX2() * quaternion.getX3() * 2.0d;
        double d2 = x03 * 2.0d;
        double d3 = x13 * 2.0d;
        double d4 = -x0;
        double d5 = x12 * 2.0d;
        double d6 = x04 * 2.0d;
        return new Matrix3x3d(((x0 - x1) - x2) + x3, d - x22, d2 + d3, d + x22, ((d4 + x1) - x2) + x3, d5 - d6, d2 - d3, d5 + d6, (d4 - x1) + x2 + x3);
    }

    public static void matrixToColumnArray(Matrix3x3d matrix3x3d, float[] fArr) {
        fArr[0] = (float) matrix3x3d.get(0, 0);
        fArr[4] = (float) matrix3x3d.get(0, 1);
        fArr[8] = (float) matrix3x3d.get(0, 2);
        fArr[1] = (float) matrix3x3d.get(1, 0);
        fArr[5] = (float) matrix3x3d.get(1, 1);
        fArr[9] = (float) matrix3x3d.get(1, 2);
        fArr[2] = (float) matrix3x3d.get(2, 0);
        fArr[6] = (float) matrix3x3d.get(2, 1);
        fArr[10] = (float) matrix3x3d.get(2, 2);
        fArr[11] = 0.0f;
        fArr[7] = 0.0f;
        fArr[3] = 0.0f;
        fArr[14] = 0.0f;
        fArr[13] = 0.0f;
        fArr[12] = 0.0f;
        fArr[15] = 1.0f;
    }

    public double toEulerPitch() {
        return Math.asin(-this.m[5]);
    }

    public double toEulerYaw() {
        double[] dArr = this.m;
        return Math.atan2(dArr[2], dArr[8]);
    }

    public double toEulerRoll() {
        double[] dArr = this.m;
        return Math.atan2(dArr[3], dArr[4]);
    }
}
