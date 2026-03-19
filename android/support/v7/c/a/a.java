package android.support.v7.c.a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.d.l;
import android.support.v7.a.a;
import android.support.v7.c.a.b;
import android.support.v7.c.a.d;
import android.util.AttributeSet;
import android.util.StateSet;
import com.kwai.video.player.KsMediaMeta;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class a extends android.support.v7.c.a.d {
    private static final String LOGTAG = a.class.getSimpleName();
    private f eA;
    private int eB;
    private int eC;
    private b ez;
    private boolean mMutated;

    @Override // android.support.v7.c.a.d, android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // android.support.v7.c.a.d, android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public a() {
        this(null, null);
    }

    a(b bVar, Resources resources) {
        super(null);
        this.eB = -1;
        this.eC = -1;
        a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public static a a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        a aVar = new a();
        aVar.b(context, resources, xmlPullParser, attributeSet, theme);
        return aVar;
    }

    @Override // android.support.v7.c.a.d
    public final void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayA = android.support.v4.content.a.e.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableCompat);
        setVisible(typedArrayA.getBoolean(a.j.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(typedArrayA);
        b(resources);
        typedArrayA.recycle();
        c(context, resources, xmlPullParser, attributeSet, theme);
        init();
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.eA != null && (visible || z2)) {
            if (z) {
                this.eA.start();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        f fVar = this.eA;
        if (fVar != null) {
            fVar.stop();
            this.eA = null;
            selectDrawable(this.eB);
            this.eB = -1;
            this.eC = -1;
        }
    }

    @Override // android.support.v7.c.a.d, android.support.v7.c.a.b, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iB = this.ez.b(iArr);
        boolean z = iB != getCurrentIndex() && (C(iB) || selectDrawable(iB));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    private boolean C(int i) {
        int currentIndex;
        int iG;
        f c0013a;
        f fVar = this.eA;
        if (fVar != null) {
            if (i == this.eB) {
                return true;
            }
            if (i == this.eC && fVar.ax()) {
                fVar.reverse();
                this.eB = this.eC;
                this.eC = i;
                return true;
            }
            currentIndex = this.eB;
            fVar.stop();
        } else {
            currentIndex = getCurrentIndex();
        }
        this.eA = null;
        this.eC = -1;
        this.eB = -1;
        b bVar = this.ez;
        int iD = bVar.D(currentIndex);
        int iD2 = bVar.D(i);
        if (iD2 == 0 || iD == 0 || (iG = bVar.g(iD, iD2)) < 0) {
            return false;
        }
        boolean zI = bVar.i(iD, iD2);
        selectDrawable(iG);
        AnimatedVectorDrawableCompat current = getCurrent();
        if (current instanceof AnimationDrawable) {
            c0013a = new d((AnimationDrawable) current, bVar.h(iD, iD2), zI);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            c0013a = new c(current);
        } else {
            if (current instanceof Animatable) {
                c0013a = new C0013a((Animatable) current);
            }
            return false;
        }
        c0013a.start();
        this.eA = c0013a;
        this.eC = currentIndex;
        this.eB = i;
        return true;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static abstract class f {
        public boolean ax() {
            return false;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();

        private f() {
        }

        /* synthetic */ f(byte b) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v7.c.a.a$a, reason: collision with other inner class name */
    static class C0013a extends f {
        private final Animatable eD;

        C0013a(Animatable animatable) {
            super((byte) 0);
            this.eD = animatable;
        }

        @Override // android.support.v7.c.a.a.f
        public final void start() {
            this.eD.start();
        }

        @Override // android.support.v7.c.a.a.f
        public final void stop() {
            this.eD.stop();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class d extends f {
        private final ObjectAnimator eH;
        private final boolean eI;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super((byte) 0);
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(eVar.ay());
            objectAnimatorOfInt.setInterpolator(eVar);
            this.eI = z2;
            this.eH = objectAnimatorOfInt;
        }

        @Override // android.support.v7.c.a.a.f
        public final boolean ax() {
            return this.eI;
        }

        @Override // android.support.v7.c.a.a.f
        public final void start() {
            this.eH.start();
        }

        @Override // android.support.v7.c.a.a.f
        public final void reverse() {
            this.eH.reverse();
        }

        @Override // android.support.v7.c.a.a.f
        public final void stop() {
            this.eH.cancel();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class c extends f {
        private final AnimatedVectorDrawableCompat eG;

        c(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super((byte) 0);
            this.eG = animatedVectorDrawableCompat;
        }

        @Override // android.support.v7.c.a.a.f
        public final void start() {
            this.eG.start();
        }

        @Override // android.support.v7.c.a.a.f
        public final void stop() {
            this.eG.stop();
        }
    }

    private void a(TypedArray typedArray) {
        b bVar = this.ez;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.aI |= typedArray.getChangingConfigurations();
        }
        bVar.setVariablePadding(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_variablePadding, bVar.fh));
        bVar.setConstantSize(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_constantSize, bVar.fk));
        bVar.setEnterFadeDuration(typedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.fy));
        bVar.setExitFadeDuration(typedArray.getInt(a.j.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.fz));
        setDither(typedArray.getBoolean(a.j.AnimatedStateListDrawableCompat_android_dither, bVar.fw));
    }

    private void init() {
        onStateChange(getState());
    }

    private void c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    private int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayA = android.support.v4.content.a.e.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableA = resourceId3 > 0 ? android.support.v7.b.a.a.a(context, resourceId3) : null;
        boolean z = typedArrayA.getBoolean(a.j.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayA.recycle();
        if (drawableA == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableA = AnimatedVectorDrawableCompat.createFromXmlInner(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableA = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableA = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableA == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        return this.ez.a(resourceId, resourceId2, drawableA, z);
    }

    private int e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayA = android.support.v4.content.a.e.a(resources, theme, attributeSet, a.j.AnimatedStateListDrawableItem);
        int resourceId = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayA.getResourceId(a.j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableA = resourceId2 > 0 ? android.support.v7.b.a.a.a(context, resourceId2) : null;
        typedArrayA.recycle();
        int[] iArrA = a(attributeSet);
        if (drawableA == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableA = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableA = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableA = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableA == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        return this.ez.a(iArrA, drawableA, resourceId);
    }

    @Override // android.support.v7.c.a.d, android.support.v7.c.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mMutated && super.mutate() == this) {
            this.ez.aw();
            this.mMutated = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v7.c.a.d, android.support.v7.c.a.b
    /* renamed from: at, reason: merged with bridge method [inline-methods] */
    public b av() {
        return new b(this.ez, this, null);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class b extends d.a {
        android.support.v4.d.e<Long> eE;
        l<Integer> eF;

        private static long j(int i, int i2) {
            return i2 | (i << 32);
        }

        b(b bVar, a aVar, Resources resources) {
            super(bVar, aVar, resources);
            if (bVar != null) {
                this.eE = bVar.eE;
                this.eF = bVar.eF;
            } else {
                this.eE = new android.support.v4.d.e<>();
                this.eF = new l<>();
            }
        }

        @Override // android.support.v7.c.a.d.a, android.support.v7.c.a.b.AbstractC0014b
        final void aw() {
            this.eE = this.eE.clone();
            this.eF = this.eF.clone();
        }

        final int a(int i, int i2, Drawable drawable, boolean z) {
            int iAddChild = super.addChild(drawable);
            long j = j(i, i2);
            long j2 = z ? KsMediaMeta.AV_CH_SURROUND_DIRECT_LEFT : 0L;
            long j3 = iAddChild;
            this.eE.append(j, Long.valueOf(j3 | j2));
            if (z) {
                this.eE.append(j(i2, i), Long.valueOf(KsMediaMeta.AV_CH_WIDE_RIGHT | j3 | j2));
            }
            return iAddChild;
        }

        final int a(int[] iArr, Drawable drawable, int i) {
            int iA = super.a(iArr, drawable);
            this.eF.put(iA, Integer.valueOf(i));
            return iA;
        }

        final int b(int[] iArr) {
            int iC = super.c(iArr);
            return iC >= 0 ? iC : super.c(StateSet.WILD_CARD);
        }

        final int D(int i) {
            if (i < 0) {
                return 0;
            }
            return this.eF.get(i, 0).intValue();
        }

        final int g(int i, int i2) {
            return (int) this.eE.get(j(i, i2), -1L).longValue();
        }

        final boolean h(int i, int i2) {
            return (this.eE.get(j(i, i2), -1L).longValue() & KsMediaMeta.AV_CH_WIDE_RIGHT) != 0;
        }

        final boolean i(int i, int i2) {
            return (this.eE.get(j(i, i2), -1L).longValue() & KsMediaMeta.AV_CH_SURROUND_DIRECT_LEFT) != 0;
        }

        @Override // android.support.v7.c.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable() {
            return new a(this, null);
        }

        @Override // android.support.v7.c.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public final Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }
    }

    @Override // android.support.v7.c.a.d, android.support.v7.c.a.b
    protected final void a(b.AbstractC0014b abstractC0014b) {
        super.a(abstractC0014b);
        if (abstractC0014b instanceof b) {
            this.ez = (b) abstractC0014b;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class e implements TimeInterpolator {
        private int[] eJ;
        private int eK;
        private int eL;

        e(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        private int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.eK = numberOfFrames;
            int[] iArr = this.eJ;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.eJ = new int[numberOfFrames];
            }
            int[] iArr2 = this.eJ;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.eL = i;
            return i;
        }

        final int ay() {
            return this.eL;
        }

        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            int i = (int) ((f * this.eL) + 0.5f);
            int i2 = this.eK;
            int[] iArr = this.eJ;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.eL : 0.0f);
        }
    }
}
