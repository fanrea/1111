package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.a.d;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class av {
    private final Context mContext;
    private TypedValue mz;
    private final TypedArray vn;

    public static av a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new av(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static av a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new av(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public static av a(Context context, int i, int[] iArr) {
        return new av(context, context.obtainStyledAttributes(i, iArr));
    }

    private av(Context context, TypedArray typedArray) {
        this.mContext = context;
        this.vn = typedArray;
    }

    public final Drawable getDrawable(int i) {
        int resourceId;
        if (this.vn.hasValue(i) && (resourceId = this.vn.getResourceId(i, 0)) != 0) {
            return android.support.v7.b.a.a.a(this.mContext, resourceId);
        }
        return this.vn.getDrawable(i);
    }

    public final Typeface a(int i, int i2, d.a aVar) {
        int resourceId = this.vn.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.mz == null) {
            this.mz = new TypedValue();
        }
        return android.support.v4.content.a.d.a(this.mContext, resourceId, this.mz, i2, aVar);
    }

    public final CharSequence getText(int i) {
        return this.vn.getText(i);
    }

    public final String getString(int i) {
        return this.vn.getString(i);
    }

    public final boolean getBoolean(int i, boolean z) {
        return this.vn.getBoolean(i, z);
    }

    public final int getInt(int i, int i2) {
        return this.vn.getInt(i, i2);
    }

    public final float getFloat(int i, float f) {
        return this.vn.getFloat(i, -1.0f);
    }

    public final int getColor(int i, int i2) {
        return this.vn.getColor(i, i2);
    }

    public final ColorStateList getColorStateList(int i) {
        int resourceId;
        ColorStateList colorStateListB;
        return (!this.vn.hasValue(i) || (resourceId = this.vn.getResourceId(i, 0)) == 0 || (colorStateListB = android.support.v7.b.a.a.b(this.mContext, resourceId)) == null) ? this.vn.getColorStateList(i) : colorStateListB;
    }

    public final int getInteger(int i, int i2) {
        return this.vn.getInteger(i, i2);
    }

    public final int getDimensionPixelOffset(int i, int i2) {
        return this.vn.getDimensionPixelOffset(i, i2);
    }

    public final int getDimensionPixelSize(int i, int i2) {
        return this.vn.getDimensionPixelSize(i, i2);
    }

    public final int getLayoutDimension(int i, int i2) {
        return this.vn.getLayoutDimension(i, i2);
    }

    public final int getResourceId(int i, int i2) {
        return this.vn.getResourceId(i, i2);
    }

    public final CharSequence[] getTextArray(int i) {
        return this.vn.getTextArray(i);
    }

    public final boolean hasValue(int i) {
        return this.vn.hasValue(i);
    }

    public final void recycle() {
        this.vn.recycle();
    }
}
