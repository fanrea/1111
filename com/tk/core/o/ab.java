package com.tk.core.o;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class ab {
    private static float[] ajD;
    private static Matrix ajE;
    private static float[] ajF;

    private static Matrix sU() {
        if (ajE == null) {
            ajE = new Matrix();
        }
        return ajE;
    }

    private static float[] sV() {
        if (ajF == null) {
            ajF = new float[2];
        }
        return ajF;
    }

    private static float[] sW() {
        if (ajD == null) {
            ajD = new float[2];
        }
        return ajD;
    }

    private static boolean a(float f, float f2, ViewGroup viewGroup, View view, float[] fArr) {
        if (view.getVisibility() != 0) {
            return false;
        }
        float scrollX = (f + viewGroup.getScrollX()) - view.getLeft();
        float scrollY = (f2 + viewGroup.getScrollY()) - view.getTop();
        Matrix matrix = view.getMatrix();
        if (matrix != null && !matrix.isIdentity()) {
            float[] fArrSW = sW();
            fArrSW[0] = scrollX;
            fArrSW[1] = scrollY;
            Matrix matrixSU = sU();
            matrixSU.reset();
            matrix.invert(matrixSU);
            matrixSU.mapPoints(fArrSW);
            scrollX = fArrSW[0];
            scrollY = fArrSW[1];
        }
        if (scrollX < 0.0f || scrollX >= view.getRight() - view.getLeft() || scrollY < 0.0f || scrollY >= view.getBottom() - view.getTop()) {
            return false;
        }
        fArr[0] = scrollX;
        fArr[1] = scrollY;
        return true;
    }

    public static boolean a(float f, float f2, ViewGroup viewGroup) {
        while (true) {
            int childCount = viewGroup.getChildCount();
            com.tk.core.p.a.a aVar = viewGroup instanceof com.tk.core.p.a.a ? (com.tk.core.p.a.a) viewGroup : null;
            for (int i = childCount - 1; i >= 0; i--) {
                View childAt = viewGroup.getChildAt(aVar != null ? aVar.eg(i) : i);
                if (childAt != null) {
                    float[] fArrSV = sV();
                    if (a(f, f2, viewGroup, childAt, fArrSV)) {
                        if (bj(childAt)) {
                            return true;
                        }
                        if (!(childAt instanceof ViewGroup)) {
                            return false;
                        }
                        f = fArrSV[0];
                        f2 = fArrSV[1];
                        viewGroup = (ViewGroup) childAt;
                    }
                }
            }
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean bj(View view) {
        if (view instanceof EditText) {
            return true;
        }
        return (view instanceof com.tk.core.component.view.a) && ((com.tk.core.component.view.a) view).isEditable();
    }
}
