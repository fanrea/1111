package com.tk.core.component.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d {
    private volatile boolean ZN;
    private TKViewBackgroundDrawable ahE;
    private StateListDrawable ahF;
    private Map<int[], Drawable> ahG;
    private int ahH = -1;
    private float[] ahI = new float[8];
    private float ahJ;
    private View cm;
    private Drawable mBackgroundImageDrawable;
    private com.tk.core.bridge.b mTKJSContext;

    public d(View view, com.tk.core.bridge.b bVar) {
        this.cm = view;
        this.mTKJSContext = bVar;
    }

    public final void destroy() {
        this.ZN = true;
        this.cm = null;
        if (ry() != null) {
            ry().destroy();
        }
    }

    private TKViewBackgroundDrawable ry() {
        if (this.ZN) {
            return null;
        }
        if (this.ahE == null) {
            this.ahE = new TKViewBackgroundDrawable(this.cm.getContext(), this.mTKJSContext);
            this.ahE.mDebugText = this.cm.getClass().getName();
            StateListDrawable stateListDrawable = this.ahF;
            if (stateListDrawable != null) {
                setBackgroundDrawable(stateListDrawable);
            } else {
                setBackgroundDrawable(this.ahE);
            }
        }
        return this.ahE;
    }

    private void setBackgroundDrawable(Drawable drawable) {
        LayerDrawable layerDrawable;
        if (this.ZN || drawable == null) {
            return;
        }
        b.a(this.cm, (Drawable) null);
        Drawable background = this.cm.getBackground();
        if (background == null) {
            Drawable drawable2 = this.mBackgroundImageDrawable;
            if (drawable2 == null) {
                b.a(this.cm, drawable);
                return;
            }
            if (drawable2 == drawable) {
                Drawable drawable3 = this.ahF;
                if (drawable3 == null && (drawable3 = this.ahE) == null) {
                    drawable3 = null;
                }
                if (drawable3 == null) {
                    b.a(this.cm, this.mBackgroundImageDrawable);
                    return;
                } else {
                    b.a(this.cm, new LayerDrawable(new Drawable[]{drawable3, this.mBackgroundImageDrawable}));
                    return;
                }
            }
            layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
        } else {
            Drawable drawable4 = this.mBackgroundImageDrawable;
            if (drawable4 == null) {
                layerDrawable = new LayerDrawable(new Drawable[]{background, drawable});
            } else if (drawable4 == drawable) {
                layerDrawable = new LayerDrawable(new Drawable[]{background, drawable});
            } else {
                layerDrawable = new LayerDrawable(new Drawable[]{background, drawable, drawable4});
            }
        }
        b.a(this.cm, layerDrawable);
    }

    public final void b(int[] iArr, int i) {
        if (this.ZN || iArr == null || iArr.length <= 0) {
            return;
        }
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy = ry();
        TKViewBackgroundDrawable tKViewBackgroundDrawableNewDrawable = tKViewBackgroundDrawableRy.newDrawable();
        tKViewBackgroundDrawableNewDrawable.setColor(i);
        this.ahF = new StateListDrawable();
        i(iArr);
        if (this.ahG == null) {
            this.ahG = new HashMap();
        }
        this.ahG.put(iArr, tKViewBackgroundDrawableNewDrawable);
        for (Map.Entry<int[], Drawable> entry : this.ahG.entrySet()) {
            if (entry != null) {
                int[] key = entry.getKey();
                Drawable value = entry.getValue();
                if (key != null && key.length > 0 && value != null) {
                    this.ahF.addState(key, value);
                }
            }
        }
        this.ahF.addState(StateSet.WILD_CARD, tKViewBackgroundDrawableRy);
        setBackgroundDrawable(this.ahF);
    }

    private void i(int[] iArr) {
        Map<int[], Drawable> map;
        if (iArr == null || iArr.length <= 0 || (map = this.ahG) == null || map.size() <= 0) {
            return;
        }
        Iterator<Map.Entry<int[], Drawable>> it = this.ahG.entrySet().iterator();
        while (it.hasNext()) {
            if (b(it.next().getKey(), iArr)) {
                it.remove();
                return;
            }
        }
    }

    private static boolean b(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null || iArr.length != iArr2.length) {
            return false;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public final void setBackgroundColor(int i) {
        if (this.ZN) {
            return;
        }
        if (i == 0 && this.ahE == null) {
            return;
        }
        this.ahH = i;
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy = ry();
        if (tKViewBackgroundDrawableRy != null) {
            tKViewBackgroundDrawableRy.setColor(i);
        }
    }

    public final void setBackgroundGradientColor(int i, int[] iArr, float[] fArr) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.setBackgroundGradientColor(i, iArr, fArr);
    }

    public final void setBorderWidth(int i, float f) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.setBorderWidth(i, f);
    }

    public final void setBorderColor(int i, int i2) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.setBorderColor(i, i2);
    }

    public final void setBorderRadius(float f) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.setRadius(f);
        this.ahJ = f;
    }

    public final void c(float f, int i) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.setRadius(f, i);
        float[] fArr = this.ahI;
        int i2 = (i % 4) * 2;
        fArr[i2] = f;
        fArr[i2 + 1] = f;
    }

    public final void setBorderStyle(int i, String str) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.setBorderStyle(i, str);
    }

    public final void setShadow(float f, float f2, float f3, int i) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.setShadow(f, f2, f3, i);
    }

    public final void updateBackgroundImage(Bitmap bitmap, String str, String str2) {
        TKViewBackgroundDrawable tKViewBackgroundDrawableRy;
        if (this.ZN || (tKViewBackgroundDrawableRy = ry()) == null) {
            return;
        }
        tKViewBackgroundDrawableRy.updateBackgroundImage(bitmap, str, str2);
    }
}
