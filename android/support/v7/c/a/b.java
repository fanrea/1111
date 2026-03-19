package android.support.v7.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class b extends Drawable implements Drawable.Callback {
    private AbstractC0014b eM;
    private Rect eN;
    private Drawable eO;
    private Drawable eP;
    private boolean eR;
    private Runnable eU;
    private long eV;
    private long eW;
    private a eX;
    private boolean mMutated;
    private int eQ = 255;
    private int eS = -1;
    private int eT = -1;

    b() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.eO;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.eP;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.eM.getChangingConfigurations();
    }

    private boolean az() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect constantPadding = this.eM.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            padding = (constantPadding.right | ((constantPadding.left | constantPadding.top) | constantPadding.bottom)) != 0;
        } else {
            Drawable drawable = this.eO;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (az()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.eO;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.eR && this.eQ == i) {
            return;
        }
        this.eR = true;
        this.eQ = i;
        Drawable drawable = this.eO;
        if (drawable != null) {
            if (this.eV == 0) {
                drawable.setAlpha(i);
            } else {
                k(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.eQ;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.eM.fw != z) {
            AbstractC0014b abstractC0014b = this.eM;
            abstractC0014b.fw = z;
            Drawable drawable = this.eO;
            if (drawable != null) {
                drawable.setDither(abstractC0014b.fw);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        AbstractC0014b abstractC0014b = this.eM;
        abstractC0014b.fC = true;
        if (abstractC0014b.fB != colorFilter) {
            this.eM.fB = colorFilter;
            Drawable drawable = this.eO;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        AbstractC0014b abstractC0014b = this.eM;
        abstractC0014b.fD = true;
        if (abstractC0014b.ay != colorStateList) {
            this.eM.ay = colorStateList;
            android.support.v4.graphics.drawable.a.a(this.eO, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        AbstractC0014b abstractC0014b = this.eM;
        abstractC0014b.fE = true;
        if (abstractC0014b.aB != mode) {
            this.eM.aB = mode;
            android.support.v4.graphics.drawable.a.a(this.eO, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.eP;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.eO;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.eM.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.eM.fA != z) {
            AbstractC0014b abstractC0014b = this.eM;
            abstractC0014b.fA = z;
            Drawable drawable = this.eO;
            if (drawable != null) {
                android.support.v4.graphics.drawable.a.a(drawable, abstractC0014b.fA);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.eM.fA;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.eP;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.eP = null;
            this.eT = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.eO;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.eR) {
                this.eO.setAlpha(this.eQ);
            }
        }
        if (this.eW != 0) {
            this.eW = 0L;
            z = true;
        }
        if (this.eV != 0) {
            this.eV = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.eO;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.a(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.eN;
        if (rect == null) {
            this.eN = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.eO;
        if (drawable != null) {
            android.support.v4.graphics.drawable.a.a(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.eN;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.eP;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.eO;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.eP;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.eO;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.eM.k(i, getCurrentIndex());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.eM.isConstantSize()) {
            return this.eM.getConstantWidth();
        }
        Drawable drawable = this.eO;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.eM.isConstantSize()) {
            return this.eM.getConstantHeight();
        }
        Drawable drawable = this.eO;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.eM.isConstantSize()) {
            return this.eM.getConstantMinimumWidth();
        }
        Drawable drawable = this.eO;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.eM.isConstantSize()) {
            return this.eM.getConstantMinimumHeight();
        }
        Drawable drawable = this.eO;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        AbstractC0014b abstractC0014b = this.eM;
        if (abstractC0014b != null) {
            abstractC0014b.aB();
        }
        if (drawable != this.eO || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.eO || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.eO || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.eP;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.eO;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.eO;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.eM.getOpacity();
    }

    final int getCurrentIndex() {
        return this.eS;
    }

    final boolean selectDrawable(int i) {
        if (i == this.eS) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.eM.fz > 0) {
            Drawable drawable = this.eP;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.eO;
            if (drawable2 != null) {
                this.eP = drawable2;
                this.eT = this.eS;
                this.eW = this.eM.fz + jUptimeMillis;
            } else {
                this.eP = null;
                this.eT = -1;
                this.eW = 0L;
            }
        } else {
            Drawable drawable3 = this.eO;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i >= 0 && i < this.eM.fg) {
            Drawable child = this.eM.getChild(i);
            this.eO = child;
            this.eS = i;
            if (child != null) {
                if (this.eM.fy > 0) {
                    this.eV = jUptimeMillis + this.eM.fy;
                }
                e(child);
            }
        } else {
            this.eO = null;
            this.eS = -1;
        }
        if (this.eV != 0 || this.eW != 0) {
            Runnable runnable = this.eU;
            if (runnable == null) {
                this.eU = new Runnable() { // from class: android.support.v7.c.a.b.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.k(true);
                        b.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(runnable);
            }
            k(true);
        }
        invalidateSelf();
        return true;
    }

    private void e(Drawable drawable) {
        if (this.eX == null) {
            this.eX = new a();
        }
        drawable.setCallback(this.eX.a(drawable.getCallback()));
        try {
            if (this.eM.fy <= 0 && this.eR) {
                drawable.setAlpha(this.eQ);
            }
            if (this.eM.fC) {
                drawable.setColorFilter(this.eM.fB);
            } else {
                if (this.eM.fD) {
                    android.support.v4.graphics.drawable.a.a(drawable, this.eM.ay);
                }
                if (this.eM.fE) {
                    android.support.v4.graphics.drawable.a.a(drawable, this.eM.aB);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.eM.fw);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.eM.fA);
            }
            Rect rect = this.eN;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.eX.aA());
        }
    }

    final void k(boolean z) {
        boolean z2;
        boolean z3 = true;
        this.eR = true;
        long jUptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable = this.eO;
        if (drawable != null) {
            long j = this.eV;
            if (j == 0) {
                z2 = false;
            } else if (j <= jUptimeMillis) {
                drawable.setAlpha(this.eQ);
                this.eV = 0L;
                z2 = false;
            } else {
                this.eO.setAlpha(((255 - (((int) ((j - jUptimeMillis) * 255)) / this.eM.fy)) * this.eQ) / 255);
                z2 = true;
            }
        } else {
            this.eV = 0L;
            z2 = false;
        }
        Drawable drawable2 = this.eP;
        if (drawable2 != null) {
            long j2 = this.eW;
            if (j2 == 0) {
                z3 = z2;
            } else if (j2 <= jUptimeMillis) {
                drawable2.setVisible(false, false);
                this.eP = null;
                this.eT = -1;
                this.eW = 0L;
                z3 = z2;
            } else {
                this.eP.setAlpha(((((int) ((j2 - jUptimeMillis) * 255)) / this.eM.fz) * this.eQ) / 255);
            }
        } else {
            this.eW = 0L;
            z3 = z2;
        }
        if (z && z3) {
            scheduleSelf(this.eU, jUptimeMillis + 16);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.eO;
    }

    final void b(Resources resources) {
        this.eM.b(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.eM.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.eM.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.eM.canConstantState()) {
            return null;
        }
        this.eM.aI = getChangingConfigurations();
        return this.eM;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            AbstractC0014b abstractC0014bAv = av();
            abstractC0014bAv.aw();
            a(abstractC0014bAv);
            this.mMutated = true;
        }
        return this;
    }

    AbstractC0014b av() {
        return this.eM;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v7.c.a.b$b, reason: collision with other inner class name */
    static abstract class AbstractC0014b extends Drawable.ConstantState {
        PorterDuff.Mode aB;
        int aI;
        ColorStateList ay;
        boolean fA;
        ColorFilter fB;
        boolean fC;
        boolean fD;
        boolean fE;
        final b fa;
        Resources fb;
        int fc;
        int fd;
        SparseArray<Drawable.ConstantState> fe;
        Drawable[] ff;
        int fg;
        boolean fh;
        boolean fi;
        Rect fj;
        boolean fk;
        boolean fl;
        int fm;
        int fn;
        int fo;
        int fp;
        boolean fq;
        int fr;
        boolean fs;
        boolean ft;
        boolean fu;
        boolean fv;
        boolean fw;
        int fx;
        int fy;
        int fz;
        boolean mMutated;

        AbstractC0014b(AbstractC0014b abstractC0014b, b bVar, Resources resources) {
            Resources resources2;
            this.fc = 160;
            this.fh = false;
            this.fk = false;
            this.fw = true;
            this.fy = 0;
            this.fz = 0;
            this.fa = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = abstractC0014b != null ? abstractC0014b.fb : null;
            }
            this.fb = resources2;
            this.fc = b.b(resources, abstractC0014b != null ? abstractC0014b.fc : 0);
            if (abstractC0014b != null) {
                this.aI = abstractC0014b.aI;
                this.fd = abstractC0014b.fd;
                this.fu = true;
                this.fv = true;
                this.fh = abstractC0014b.fh;
                this.fk = abstractC0014b.fk;
                this.fw = abstractC0014b.fw;
                this.mMutated = abstractC0014b.mMutated;
                this.fx = abstractC0014b.fx;
                this.fy = abstractC0014b.fy;
                this.fz = abstractC0014b.fz;
                this.fA = abstractC0014b.fA;
                this.fB = abstractC0014b.fB;
                this.fC = abstractC0014b.fC;
                this.ay = abstractC0014b.ay;
                this.aB = abstractC0014b.aB;
                this.fD = abstractC0014b.fD;
                this.fE = abstractC0014b.fE;
                if (abstractC0014b.fc == this.fc) {
                    if (abstractC0014b.fi) {
                        this.fj = new Rect(abstractC0014b.fj);
                        this.fi = true;
                    }
                    if (abstractC0014b.fl) {
                        this.fm = abstractC0014b.fm;
                        this.fn = abstractC0014b.fn;
                        this.fo = abstractC0014b.fo;
                        this.fp = abstractC0014b.fp;
                        this.fl = true;
                    }
                }
                if (abstractC0014b.fq) {
                    this.fr = abstractC0014b.fr;
                    this.fq = true;
                }
                if (abstractC0014b.fs) {
                    this.ft = abstractC0014b.ft;
                    this.fs = true;
                }
                Drawable[] drawableArr = abstractC0014b.ff;
                this.ff = new Drawable[drawableArr.length];
                this.fg = abstractC0014b.fg;
                SparseArray<Drawable.ConstantState> sparseArray = abstractC0014b.fe;
                if (sparseArray != null) {
                    this.fe = sparseArray.clone();
                } else {
                    this.fe = new SparseArray<>(this.fg);
                }
                int i = this.fg;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.fe.put(i2, constantState);
                        } else {
                            this.ff[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.ff = new Drawable[10];
            this.fg = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.aI | this.fd;
        }

        public final int addChild(Drawable drawable) {
            int i = this.fg;
            if (i >= this.ff.length) {
                growArray(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.fa);
            this.ff[i] = drawable;
            this.fg++;
            this.fd = drawable.getChangingConfigurations() | this.fd;
            aB();
            this.fj = null;
            this.fi = false;
            this.fl = false;
            this.fu = false;
            return i;
        }

        final void aB() {
            this.fq = false;
            this.fs = false;
        }

        final int getCapacity() {
            return this.ff.length;
        }

        private void aC() {
            SparseArray<Drawable.ConstantState> sparseArray = this.fe;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.ff[this.fe.keyAt(i)] = f(this.fe.valueAt(i).newDrawable(this.fb));
                }
                this.fe = null;
            }
        }

        private Drawable f(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.fx);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.fa);
            return drawableMutate;
        }

        public final int getChildCount() {
            return this.fg;
        }

        public final Drawable getChild(int i) {
            int iIndexOfKey;
            Drawable drawable = this.ff[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.fe;
            if (sparseArray == null || (iIndexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawableF = f(this.fe.valueAt(iIndexOfKey).newDrawable(this.fb));
            this.ff[i] = drawableF;
            this.fe.removeAt(iIndexOfKey);
            if (this.fe.size() == 0) {
                this.fe = null;
            }
            return drawableF;
        }

        final boolean k(int i, int i2) {
            int i3 = this.fg;
            Drawable[] drawableArr = this.ff;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.fx = i;
            return z;
        }

        final void b(Resources resources) {
            if (resources != null) {
                this.fb = resources;
                int iB = b.b(resources, this.fc);
                int i = this.fc;
                this.fc = iB;
                if (i != iB) {
                    this.fl = false;
                    this.fi = false;
                }
            }
        }

        final void applyTheme(Resources.Theme theme) {
            if (theme != null) {
                aC();
                int i = this.fg;
                Drawable[] drawableArr = this.ff;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.fd |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                b(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.fg;
            Drawable[] drawableArr = this.ff;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.fe.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        void aw() {
            int i = this.fg;
            Drawable[] drawableArr = this.ff;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.mMutated = true;
        }

        public final void setVariablePadding(boolean z) {
            this.fh = z;
        }

        public final Rect getConstantPadding() {
            if (this.fh) {
                return null;
            }
            if (this.fj != null || this.fi) {
                return this.fj;
            }
            aC();
            Rect rect = new Rect();
            int i = this.fg;
            Drawable[] drawableArr = this.ff;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.fi = true;
            this.fj = rect2;
            return rect2;
        }

        public final void setConstantSize(boolean z) {
            this.fk = z;
        }

        public final boolean isConstantSize() {
            return this.fk;
        }

        public final int getConstantWidth() {
            if (!this.fl) {
                computeConstantSize();
            }
            return this.fm;
        }

        public final int getConstantHeight() {
            if (!this.fl) {
                computeConstantSize();
            }
            return this.fn;
        }

        public final int getConstantMinimumWidth() {
            if (!this.fl) {
                computeConstantSize();
            }
            return this.fo;
        }

        public final int getConstantMinimumHeight() {
            if (!this.fl) {
                computeConstantSize();
            }
            return this.fp;
        }

        private void computeConstantSize() {
            this.fl = true;
            aC();
            int i = this.fg;
            Drawable[] drawableArr = this.ff;
            this.fn = -1;
            this.fm = -1;
            this.fp = 0;
            this.fo = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.fm) {
                    this.fm = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.fn) {
                    this.fn = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.fo) {
                    this.fo = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.fp) {
                    this.fp = minimumHeight;
                }
            }
        }

        public final void setEnterFadeDuration(int i) {
            this.fy = i;
        }

        public final void setExitFadeDuration(int i) {
            this.fz = i;
        }

        public final int getOpacity() {
            if (this.fq) {
                return this.fr;
            }
            aC();
            int i = this.fg;
            Drawable[] drawableArr = this.ff;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.fr = opacity;
            this.fq = true;
            return opacity;
        }

        public final boolean isStateful() {
            if (this.fs) {
                return this.ft;
            }
            aC();
            int i = this.fg;
            Drawable[] drawableArr = this.ff;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.ft = z;
            this.fs = true;
            return z;
        }

        public void growArray(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.ff, 0, drawableArr, 0, i);
            this.ff = drawableArr;
        }

        public final synchronized boolean canConstantState() {
            if (this.fu) {
                return this.fv;
            }
            aC();
            this.fu = true;
            int i = this.fg;
            Drawable[] drawableArr = this.ff;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.fv = false;
                    return false;
                }
            }
            this.fv = true;
            return true;
        }
    }

    protected void a(AbstractC0014b abstractC0014b) {
        this.eM = abstractC0014b;
        int i = this.eS;
        if (i >= 0) {
            this.eO = abstractC0014b.getChild(i);
            Drawable drawable = this.eO;
            if (drawable != null) {
                e(drawable);
            }
        }
        this.eT = -1;
        this.eP = null;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a implements Drawable.Callback {
        private Drawable.Callback eZ;

        @Override // android.graphics.drawable.Drawable.Callback
        public final void invalidateDrawable(Drawable drawable) {
        }

        a() {
        }

        public final a a(Drawable.Callback callback) {
            this.eZ = callback;
            return this;
        }

        public final Drawable.Callback aA() {
            Drawable.Callback callback = this.eZ;
            this.eZ = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.eZ;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.eZ;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    static int b(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
