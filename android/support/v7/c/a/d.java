package android.support.v7.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.a.e;
import android.support.v7.a.a;
import android.support.v7.c.a.b;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class d extends b {
    private a fF;
    private boolean mMutated;

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    d() {
        this(null, null);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        int iC = this.fF.c(iArr);
        if (iC < 0) {
            iC = this.fF.c(StateSet.WILD_CARD);
        }
        return selectDrawable(iC) || zOnStateChange;
    }

    public void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayA = e.a(resources, theme, attributeSet, a.j.StateListDrawable);
        setVisible(typedArrayA.getBoolean(a.j.StateListDrawable_android_visible, true), true);
        a(typedArrayA);
        b(resources);
        typedArrayA.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    private void a(TypedArray typedArray) {
        a aVar = this.fF;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.aI |= typedArray.getChangingConfigurations();
        }
        aVar.fh = typedArray.getBoolean(a.j.StateListDrawable_android_variablePadding, aVar.fh);
        aVar.fk = typedArray.getBoolean(a.j.StateListDrawable_android_constantSize, aVar.fk);
        aVar.fy = typedArray.getInt(a.j.StateListDrawable_android_enterFadeDuration, aVar.fy);
        aVar.fz = typedArray.getInt(a.j.StateListDrawable_android_exitFadeDuration, aVar.fz);
        aVar.fw = typedArray.getBoolean(a.j.StateListDrawable_android_dither, aVar.fw);
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        a aVar = this.fF;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next2 == 3) {
                return;
            }
            if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                TypedArray typedArrayA = e.a(resources, theme, attributeSet, a.j.StateListDrawableItem);
                int resourceId = typedArrayA.getResourceId(a.j.StateListDrawableItem_android_drawable, -1);
                Drawable drawableA = resourceId > 0 ? android.support.v7.b.a.a.a(context, resourceId) : null;
                typedArrayA.recycle();
                int[] iArrA = a(attributeSet);
                if (drawableA == null) {
                    do {
                        next = xmlPullParser.next();
                    } while (next == 4);
                    if (next != 2) {
                        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        drawableA = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                    } else {
                        drawableA = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                    }
                }
                aVar.a(iArrA, drawableA);
            }
        }
    }

    static int[] a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (attributeNameResource != 0 && attributeNameResource != 16842960 && attributeNameResource != 16843161) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.fF.aw();
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.c.a.b
    /* renamed from: au, reason: merged with bridge method [inline-methods] */
    public a av() {
        return new a(this.fF, this, null);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a extends b.AbstractC0014b {
        int[][] fG;

        a(a aVar, d dVar, Resources resources) {
            super(aVar, dVar, resources);
            if (aVar != null) {
                this.fG = aVar.fG;
            } else {
                this.fG = new int[getCapacity()][];
            }
        }

        @Override // android.support.v7.c.a.b.AbstractC0014b
        void aw() {
            int[][] iArr = this.fG;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.fG;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.fG = iArr2;
        }

        final int a(int[] iArr, Drawable drawable) {
            int iAddChild = addChild(drawable);
            this.fG[iAddChild] = iArr;
            return iAddChild;
        }

        final int c(int[] iArr) {
            int[][] iArr2 = this.fG;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new d(this, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new d(this, resources);
        }

        @Override // android.support.v7.c.a.b.AbstractC0014b
        public final void growArray(int i, int i2) {
            super.growArray(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.fG, 0, iArr, 0, i);
            this.fG = iArr;
        }
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    @Override // android.support.v7.c.a.b
    protected void a(b.AbstractC0014b abstractC0014b) {
        super.a(abstractC0014b);
        if (abstractC0014b instanceof a) {
            this.fF = (a) abstractC0014b;
        }
    }

    d(a aVar, Resources resources) {
        a(new a(aVar, this, resources));
        onStateChange(getState());
    }

    d(a aVar) {
    }
}
