package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.view.menu.g;
import android.support.v7.view.menu.m;
import android.support.v7.widget.ActionMenuView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class Toolbar extends ViewGroup {
    private Context jr;
    private ActionMenuView js;
    private boolean jw;
    private boolean jx;
    private int kV;
    private m.a kX;
    private g.a kY;
    private int qc;
    private int vA;
    private int vB;
    private int vC;
    private int vD;
    private am vE;
    private int vF;
    private int vG;
    private CharSequence vH;
    private CharSequence vI;
    private int vJ;
    private int vK;
    private final ArrayList<View> vL;
    private final ArrayList<View> vM;
    private final int[] vN;
    c vO;
    private final ActionMenuView.e vP;
    private aw vQ;
    private android.support.v7.widget.c vR;
    private a vS;
    private boolean vT;
    private final Runnable vU;
    private TextView vo;
    private TextView vp;
    private ImageButton vq;
    private ImageView vr;
    private Drawable vs;
    private CharSequence vt;
    ImageButton vu;
    View vv;
    private int vw;
    private int vx;
    int vy;
    private int vz;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface c {
        boolean fv();
    }

    @Override // android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return fr();
    }

    @Override // android.view.ViewGroup
    protected /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return c(layoutParams);
    }

    public Toolbar(Context context) {
        this(context, null);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0010a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qc = 8388627;
        this.vL = new ArrayList<>();
        this.vM = new ArrayList<>();
        this.vN = new int[2];
        this.vP = new ActionMenuView.e() { // from class: android.support.v7.widget.Toolbar.1
            @Override // android.support.v7.widget.ActionMenuView.e
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (Toolbar.this.vO != null) {
                    return Toolbar.this.vO.fv();
                }
                return false;
            }
        };
        this.vU = new Runnable() { // from class: android.support.v7.widget.Toolbar.2
            @Override // java.lang.Runnable
            public final void run() {
                Toolbar.this.showOverflowMenu();
            }
        };
        av avVarA = av.a(getContext(), attributeSet, a.j.Toolbar, i, 0);
        this.vw = avVarA.getResourceId(a.j.Toolbar_titleTextAppearance, 0);
        this.vx = avVarA.getResourceId(a.j.Toolbar_subtitleTextAppearance, 0);
        this.qc = avVarA.getInteger(a.j.Toolbar_android_gravity, this.qc);
        this.vy = avVarA.getInteger(a.j.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = avVarA.getDimensionPixelOffset(a.j.Toolbar_titleMargin, 0);
        dimensionPixelOffset = avVarA.hasValue(a.j.Toolbar_titleMargins) ? avVarA.getDimensionPixelOffset(a.j.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.vD = dimensionPixelOffset;
        this.vC = dimensionPixelOffset;
        this.vB = dimensionPixelOffset;
        this.vA = dimensionPixelOffset;
        int dimensionPixelOffset2 = avVarA.getDimensionPixelOffset(a.j.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.vA = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = avVarA.getDimensionPixelOffset(a.j.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.vB = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = avVarA.getDimensionPixelOffset(a.j.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.vC = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = avVarA.getDimensionPixelOffset(a.j.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.vD = dimensionPixelOffset5;
        }
        this.vz = avVarA.getDimensionPixelSize(a.j.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = avVarA.getDimensionPixelOffset(a.j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = avVarA.getDimensionPixelOffset(a.j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = avVarA.getDimensionPixelSize(a.j.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = avVarA.getDimensionPixelSize(a.j.Toolbar_contentInsetRight, 0);
        fu();
        this.vE.N(dimensionPixelSize, dimensionPixelSize2);
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            this.vE.M(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.vF = avVarA.getDimensionPixelOffset(a.j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.vG = avVarA.getDimensionPixelOffset(a.j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.vs = avVarA.getDrawable(a.j.Toolbar_collapseIcon);
        this.vt = avVarA.getText(a.j.Toolbar_collapseContentDescription);
        CharSequence text = avVarA.getText(a.j.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = avVarA.getText(a.j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.jr = getContext();
        setPopupTheme(avVarA.getResourceId(a.j.Toolbar_popupTheme, 0));
        Drawable drawable = avVarA.getDrawable(a.j.Toolbar_navigationIcon);
        if (drawable != null) {
            setNavigationIcon(drawable);
        }
        CharSequence text3 = avVarA.getText(a.j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawable2 = avVarA.getDrawable(a.j.Toolbar_logo);
        if (drawable2 != null) {
            setLogo(drawable2);
        }
        CharSequence text4 = avVarA.getText(a.j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (avVarA.hasValue(a.j.Toolbar_titleTextColor)) {
            setTitleTextColor(avVarA.getColor(a.j.Toolbar_titleTextColor, -1));
        }
        if (avVarA.hasValue(a.j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(avVarA.getColor(a.j.Toolbar_subtitleTextColor, -1));
        }
        avVarA.recycle();
    }

    public void setPopupTheme(int i) {
        if (this.kV != i) {
            this.kV = i;
            if (i == 0) {
                this.jr = getContext();
            } else {
                this.jr = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.kV;
    }

    public int getTitleMarginStart() {
        return this.vA;
    }

    public void setTitleMarginStart(int i) {
        this.vA = i;
        requestLayout();
    }

    public int getTitleMarginTop() {
        return this.vC;
    }

    public void setTitleMarginTop(int i) {
        this.vC = i;
        requestLayout();
    }

    public int getTitleMarginEnd() {
        return this.vB;
    }

    public void setTitleMarginEnd(int i) {
        this.vB = i;
        requestLayout();
    }

    public int getTitleMarginBottom() {
        return this.vD;
    }

    public void setTitleMarginBottom(int i) {
        this.vD = i;
        requestLayout();
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i);
        }
        fu();
        this.vE.A(i == 1);
    }

    public void setLogo(int i) {
        setLogo(android.support.v7.b.a.a.a(getContext(), i));
    }

    private boolean isOverflowMenuShowing() {
        ActionMenuView actionMenuView = this.js;
        return actionMenuView != null && actionMenuView.isOverflowMenuShowing();
    }

    public final boolean showOverflowMenu() {
        ActionMenuView actionMenuView = this.js;
        return actionMenuView != null && actionMenuView.showOverflowMenu();
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            fk();
            if (!af(this.vr)) {
                b(this.vr, true);
            }
        } else {
            ImageView imageView = this.vr;
            if (imageView != null && af(imageView)) {
                removeView(this.vr);
                this.vM.remove(this.vr);
            }
        }
        ImageView imageView2 = this.vr;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public Drawable getLogo() {
        ImageView imageView = this.vr;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            fk();
        }
        ImageView imageView = this.vr;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.vr;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    private void fk() {
        if (this.vr == null) {
            this.vr = new m(getContext());
        }
    }

    public final void collapseActionView() {
        a aVar = this.vS;
        android.support.v7.view.menu.h hVar = aVar == null ? null : aVar.vW;
        if (hVar != null) {
            hVar.collapseActionView();
        }
    }

    public CharSequence getTitle() {
        return this.vH;
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.vo == null) {
                Context context = getContext();
                this.vo = new q(context);
                this.vo.setSingleLine();
                this.vo.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.vw;
                if (i != 0) {
                    this.vo.setTextAppearance(context, i);
                }
                int i2 = this.vJ;
                if (i2 != 0) {
                    this.vo.setTextColor(i2);
                }
            }
            if (!af(this.vo)) {
                b(this.vo, true);
            }
        } else {
            TextView textView = this.vo;
            if (textView != null && af(textView)) {
                removeView(this.vo);
                this.vM.remove(this.vo);
            }
        }
        TextView textView2 = this.vo;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.vH = charSequence;
    }

    public CharSequence getSubtitle() {
        return this.vI;
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.vp == null) {
                Context context = getContext();
                this.vp = new q(context);
                this.vp.setSingleLine();
                this.vp.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.vx;
                if (i != 0) {
                    this.vp.setTextAppearance(context, i);
                }
                int i2 = this.vK;
                if (i2 != 0) {
                    this.vp.setTextColor(i2);
                }
            }
            if (!af(this.vp)) {
                b(this.vp, true);
            }
        } else {
            TextView textView = this.vp;
            if (textView != null && af(textView)) {
                removeView(this.vp);
                this.vM.remove(this.vp);
            }
        }
        TextView textView2 = this.vp;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.vI = charSequence;
    }

    public final void setTitleTextAppearance(Context context, int i) {
        this.vw = i;
        TextView textView = this.vo;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public final void setSubtitleTextAppearance(Context context, int i) {
        this.vx = i;
        TextView textView = this.vp;
        if (textView != null) {
            textView.setTextAppearance(context, i);
        }
    }

    public void setTitleTextColor(int i) {
        this.vJ = i;
        TextView textView = this.vo;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public void setSubtitleTextColor(int i) {
        this.vK = i;
        TextView textView = this.vp;
        if (textView != null) {
            textView.setTextColor(i);
        }
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.vq;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            fn();
        }
        ImageButton imageButton = this.vq;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(android.support.v7.b.a.a.a(getContext(), i));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            fn();
            if (!af(this.vq)) {
                b(this.vq, true);
            }
        } else {
            ImageButton imageButton = this.vq;
            if (imageButton != null && af(imageButton)) {
                removeView(this.vq);
                this.vM.remove(this.vq);
            }
        }
        ImageButton imageButton2 = this.vq;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.vq;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        fn();
        this.vq.setOnClickListener(onClickListener);
    }

    public Menu getMenu() {
        fl();
        return this.js.getMenu();
    }

    public void setOverflowIcon(Drawable drawable) {
        fl();
        this.js.setOverflowIcon(drawable);
    }

    public Drawable getOverflowIcon() {
        fl();
        return this.js.getOverflowIcon();
    }

    private void fl() {
        fm();
        if (this.js.cf() == null) {
            android.support.v7.view.menu.g gVar = (android.support.v7.view.menu.g) this.js.getMenu();
            if (this.vS == null) {
                this.vS = new a();
            }
            this.js.setExpandedActionViewsExclusive(true);
            gVar.a(this.vS, this.jr);
        }
    }

    private void fm() {
        if (this.js == null) {
            this.js = new ActionMenuView(getContext());
            this.js.setPopupTheme(this.kV);
            this.js.setOnMenuItemClickListener(this.vP);
            this.js.a(this.kX, this.kY);
            b bVarFr = fr();
            bVarFr.gravity = 8388613 | (this.vy & 112);
            this.js.setLayoutParams(bVarFr);
            b(this.js, false);
        }
    }

    private MenuInflater getMenuInflater() {
        return new android.support.v7.view.d(getContext());
    }

    public void setOnMenuItemClickListener(c cVar) {
        this.vO = cVar;
    }

    public final void setContentInsetsRelative(int i, int i2) {
        fu();
        this.vE.M(i, i2);
    }

    public int getContentInsetStart() {
        am amVar = this.vE;
        if (amVar != null) {
            return amVar.getStart();
        }
        return 0;
    }

    public int getContentInsetEnd() {
        am amVar = this.vE;
        if (amVar != null) {
            return amVar.getEnd();
        }
        return 0;
    }

    public int getContentInsetLeft() {
        am amVar = this.vE;
        if (amVar != null) {
            return amVar.getLeft();
        }
        return 0;
    }

    public int getContentInsetRight() {
        am amVar = this.vE;
        if (amVar != null) {
            return amVar.getRight();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.vF;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.vF) {
            this.vF = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getContentInsetEndWithActions() {
        int i = this.vG;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.vG) {
            this.vG = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.vF, 0));
        }
        return getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        android.support.v7.view.menu.g gVarCf;
        ActionMenuView actionMenuView = this.js;
        if ((actionMenuView == null || (gVarCf = actionMenuView.cf()) == null || !gVarCf.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.vG, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (android.support.v4.e.o.g(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (android.support.v4.e.o.g(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    private void fn() {
        if (this.vq == null) {
            this.vq = new k(getContext(), null, a.C0010a.toolbarNavigationButtonStyle);
            b bVarFr = fr();
            bVarFr.gravity = 8388611 | (this.vy & 112);
            this.vq.setLayoutParams(bVarFr);
        }
    }

    final void fo() {
        if (this.vu == null) {
            this.vu = new k(getContext(), null, a.C0010a.toolbarNavigationButtonStyle);
            this.vu.setImageDrawable(this.vs);
            this.vu.setContentDescription(this.vt);
            b bVarFr = fr();
            bVarFr.gravity = 8388611 | (this.vy & 112);
            bVarFr.vX = 2;
            this.vu.setLayoutParams(bVarFr);
            this.vu.setOnClickListener(new View.OnClickListener() { // from class: android.support.v7.widget.Toolbar.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Toolbar.this.collapseActionView();
                }
            });
        }
    }

    private void b(View view, boolean z) {
        b bVarC;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            bVarC = fr();
        } else if (!checkLayoutParams(layoutParams)) {
            bVarC = c(layoutParams);
        } else {
            bVarC = (b) layoutParams;
        }
        bVarC.vX = 1;
        if (z && this.vv != null) {
            view.setLayoutParams(bVarC);
            this.vM.add(view);
        } else {
            addView(view, bVarC);
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        d dVar = new d(super.onSaveInstanceState());
        a aVar = this.vS;
        if (aVar != null && aVar.vW != null) {
            dVar.vY = this.vS.vW.getItemId();
        }
        dVar.vZ = isOverflowMenuShowing();
        return dVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof d)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d dVar = (d) parcelable;
        super.onRestoreInstanceState(dVar.getSuperState());
        ActionMenuView actionMenuView = this.js;
        android.support.v7.view.menu.g gVarCf = actionMenuView != null ? actionMenuView.cf() : null;
        if (dVar.vY != 0 && this.vS != null && gVarCf != null && (menuItemFindItem = gVarCf.findItem(dVar.vY)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (dVar.vZ) {
            fp();
        }
    }

    private void fp() {
        removeCallbacks(this.vU);
        post(this.vU);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.vU);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.jw = false;
        }
        if (!this.jw) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.jw = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.jw = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.jx = false;
        }
        if (!this.jx) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.jx = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.jx = false;
        }
        return true;
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + 0, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private int a(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i5) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + iMax + i2, marginLayoutParams.width), getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    private boolean fq() {
        if (!this.vT) {
            return false;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (ac(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        char c2;
        char c3;
        int measuredWidth;
        int iMax;
        int iCombineMeasuredStates;
        int measuredWidth2;
        int iCombineMeasuredStates2;
        int iMax2;
        int measuredHeight;
        int[] iArr = this.vN;
        if (bd.ah(this)) {
            c2 = 1;
            c3 = 0;
        } else {
            c2 = 0;
            c3 = 1;
        }
        if (ac(this.vq)) {
            a(this.vq, i, 0, i2, 0, this.vz);
            measuredWidth = this.vq.getMeasuredWidth() + ad(this.vq);
            iMax = Math.max(0, this.vq.getMeasuredHeight() + ae(this.vq));
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.vq.getMeasuredState());
        } else {
            measuredWidth = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (ac(this.vu)) {
            a(this.vu, i, 0, i2, 0, this.vz);
            measuredWidth = this.vu.getMeasuredWidth() + ad(this.vu);
            iMax = Math.max(iMax, this.vu.getMeasuredHeight() + ae(this.vu));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.vu.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, measuredWidth) + 0;
        iArr[c2] = Math.max(0, currentContentInsetStart - measuredWidth);
        if (ac(this.js)) {
            a(this.js, i, iMax3, i2, 0, this.vz);
            measuredWidth2 = this.js.getMeasuredWidth() + ad(this.js);
            iMax = Math.max(iMax, this.js.getMeasuredHeight() + ae(this.js));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.js.getMeasuredState());
        } else {
            measuredWidth2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax4 = iMax3 + Math.max(currentContentInsetEnd, measuredWidth2);
        iArr[c3] = Math.max(0, currentContentInsetEnd - measuredWidth2);
        if (ac(this.vv)) {
            iMax4 += a(this.vv, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.vv.getMeasuredHeight() + ae(this.vv));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.vv.getMeasuredState());
        }
        if (ac(this.vr)) {
            iMax4 += a(this.vr, i, iMax4, i2, 0, iArr);
            iMax = Math.max(iMax, this.vr.getMeasuredHeight() + ae(this.vr));
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.vr.getMeasuredState());
        }
        int childCount = getChildCount();
        int iMax5 = iMax;
        int iA = iMax4;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (((b) childAt.getLayoutParams()).vX == 0 && ac(childAt)) {
                iA += a(childAt, i, iA, i2, 0, iArr);
                iMax5 = Math.max(iMax5, childAt.getMeasuredHeight() + ae(childAt));
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
            }
        }
        int i4 = this.vC + this.vD;
        int i5 = this.vA + this.vB;
        if (ac(this.vo)) {
            a(this.vo, i, iA + i5, i2, i4, iArr);
            int measuredWidth3 = this.vo.getMeasuredWidth() + ad(this.vo);
            measuredHeight = this.vo.getMeasuredHeight() + ae(this.vo);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.vo.getMeasuredState());
            iMax2 = measuredWidth3;
        } else {
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
            measuredHeight = 0;
        }
        if (ac(this.vp)) {
            iMax2 = Math.max(iMax2, a(this.vp, i, iA + i5, i2, measuredHeight + i4, iArr));
            measuredHeight += this.vp.getMeasuredHeight() + ae(this.vp);
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.vp.getMeasuredState());
        }
        int iMax6 = Math.max(iMax5, measuredHeight);
        int paddingLeft = iA + iMax2 + getPaddingLeft() + getPaddingRight();
        int paddingTop = iMax6 + getPaddingTop() + getPaddingBottom();
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, iCombineMeasuredStates2 << 16);
        if (fq()) {
            iResolveSizeAndState2 = 0;
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x02a5 A[LOOP:0: B:104:0x02a3->B:105:0x02a5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x02c7 A[LOOP:1: B:107:0x02c5->B:108:0x02c7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0301 A[LOOP:2: B:116:0x02ff->B:117:0x0301, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x022b  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onLayout(boolean r19, int r20, int r21, int r22, int r23) throws java.lang.NoSuchFieldException {
        /*
            Method dump skipped, instructions count: 790
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    private static int a(List<View> list, int[] iArr) {
        int i = iArr[0];
        int i2 = iArr[1];
        int size = list.size();
        int i3 = i2;
        int i4 = i;
        int i5 = 0;
        int measuredWidth = 0;
        while (i5 < size) {
            View view = list.get(i5);
            b bVar = (b) view.getLayoutParams();
            int i6 = bVar.leftMargin - i4;
            int i7 = bVar.rightMargin - i3;
            int iMax = Math.max(0, i6);
            int iMax2 = Math.max(0, i7);
            int iMax3 = Math.max(0, -i6);
            int iMax4 = Math.max(0, -i7);
            measuredWidth += iMax + view.getMeasuredWidth() + iMax2;
            i5++;
            i3 = iMax4;
            i4 = iMax3;
        }
        return measuredWidth;
    }

    private int a(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.leftMargin - iArr[0];
        int iMax = i + Math.max(0, i3);
        iArr[0] = Math.max(0, -i3);
        int i4 = i(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, i4, iMax + measuredWidth, view.getMeasuredHeight() + i4);
        return iMax + measuredWidth + bVar.rightMargin;
    }

    private int b(View view, int i, int[] iArr, int i2) {
        b bVar = (b) view.getLayoutParams();
        int i3 = bVar.rightMargin - iArr[1];
        int iMax = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int i4 = i(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, i4, iMax, view.getMeasuredHeight() + i4);
        return iMax - (measuredWidth + bVar.leftMargin);
    }

    private int i(View view, int i) {
        b bVar = (b) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int iBi = bi(bVar.gravity);
        if (iBi == 48) {
            return getPaddingTop() - i2;
        }
        if (iBi == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - bVar.bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        if (iMax < bVar.topMargin) {
            iMax = bVar.topMargin;
        } else {
            int i3 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            if (i3 < bVar.bottomMargin) {
                iMax = Math.max(0, iMax - (bVar.bottomMargin - i3));
            }
        }
        return paddingTop + iMax;
    }

    private int bi(int i) {
        int i2 = i & 112;
        return (i2 == 16 || i2 == 48 || i2 == 80) ? i2 : this.qc & 112;
    }

    private void a(List<View> list, int i) {
        boolean z = android.support.v4.e.o.g(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = android.support.v4.e.d.getAbsoluteGravity(i, android.support.v4.e.o.g(this));
        list.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
                if (bVar.vX == 0 && ac(childAt) && bj(bVar.gravity) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i3 = childCount - 1; i3 >= 0; i3--) {
            View childAt2 = getChildAt(i3);
            b bVar2 = (b) childAt2.getLayoutParams();
            if (bVar2.vX == 0 && ac(childAt2) && bj(bVar2.gravity) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    private int bj(int i) {
        int iG = android.support.v4.e.o.g(this);
        int absoluteGravity = android.support.v4.e.d.getAbsoluteGravity(i, iG) & 7;
        return (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) ? absoluteGravity : iG == 1 ? 5 : 3;
    }

    private boolean ac(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private static int ad(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return android.support.v4.e.e.a(marginLayoutParams) + android.support.v4.e.e.b(marginLayoutParams);
    }

    private static int ae(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.view.ViewGroup
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    private static b c(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof b) {
            return new b((b) layoutParams);
        }
        if (layoutParams instanceof a.C0011a) {
            return new b((a.C0011a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    protected static b fr() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof b);
    }

    public t getWrapper() {
        if (this.vQ == null) {
            this.vQ = new aw(this, true);
        }
        return this.vQ;
    }

    final void fs() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (((b) childAt.getLayoutParams()).vX != 2 && childAt != this.js) {
                removeViewAt(childCount);
                this.vM.add(childAt);
            }
        }
    }

    final void ft() {
        for (int size = this.vM.size() - 1; size >= 0; size--) {
            addView(this.vM.get(size));
        }
        this.vM.clear();
    }

    private boolean af(View view) {
        return view.getParent() == this || this.vM.contains(view);
    }

    public void setCollapsible(boolean z) {
        this.vT = z;
        requestLayout();
    }

    private void fu() {
        if (this.vE == null) {
            this.vE = new am();
        }
    }

    android.support.v7.widget.c getOuterActionMenuPresenter() {
        return this.vR;
    }

    Context getPopupContext() {
        return this.jr;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class b extends a.C0011a {
        int vX;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.vX = 0;
        }

        public b(int i, int i2) {
            super(-2, -2);
            this.vX = 0;
            this.gravity = 8388627;
        }

        public b(b bVar) {
            super((a.C0011a) bVar);
            this.vX = 0;
            this.vX = bVar.vX;
        }

        public b(a.C0011a c0011a) {
            super(c0011a);
            this.vX = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.vX = 0;
            c(marginLayoutParams);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.vX = 0;
        }

        private void c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            this.leftMargin = marginLayoutParams.leftMargin;
            this.topMargin = marginLayoutParams.topMargin;
            this.rightMargin = marginLayoutParams.rightMargin;
            this.bottomMargin = marginLayoutParams.bottomMargin;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class d extends android.support.v4.e.a {
        public static final Parcelable.Creator<d> CREATOR = new Parcelable.ClassLoaderCreator<d>() { // from class: android.support.v7.widget.Toolbar.d.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return h(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ d createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return d(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return bk(i);
            }

            private static d d(Parcel parcel, ClassLoader classLoader) {
                return new d(parcel, classLoader);
            }

            private static d h(Parcel parcel) {
                return new d(parcel, null);
            }

            private static d[] bk(int i) {
                return new d[i];
            }
        };
        int vY;
        boolean vZ;

        public d(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.vY = parcel.readInt();
            this.vZ = parcel.readInt() != 0;
        }

        public d(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.support.v4.e.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.vY);
            parcel.writeInt(this.vZ ? 1 : 0);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a implements android.support.v7.view.menu.m {
        android.support.v7.view.menu.g ha;
        android.support.v7.view.menu.h vW;

        @Override // android.support.v7.view.menu.m
        public final void a(android.support.v7.view.menu.g gVar, boolean z) {
        }

        @Override // android.support.v7.view.menu.m
        public final void a(m.a aVar) {
        }

        @Override // android.support.v7.view.menu.m
        public final boolean a(android.support.v7.view.menu.s sVar) {
            return false;
        }

        @Override // android.support.v7.view.menu.m
        public final boolean bb() {
            return false;
        }

        a() {
        }

        @Override // android.support.v7.view.menu.m
        public final void a(Context context, android.support.v7.view.menu.g gVar) {
            android.support.v7.view.menu.h hVar;
            android.support.v7.view.menu.g gVar2 = this.ha;
            if (gVar2 != null && (hVar = this.vW) != null) {
                gVar2.f(hVar);
            }
            this.ha = gVar;
        }

        @Override // android.support.v7.view.menu.m
        public final void l(boolean z) {
            if (this.vW != null) {
                android.support.v7.view.menu.g gVar = this.ha;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        }
                        if (this.ha.getItem(i) == this.vW) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (z2) {
                    return;
                }
                c(this.vW);
            }
        }

        @Override // android.support.v7.view.menu.m
        public final boolean b(android.support.v7.view.menu.h hVar) {
            Toolbar.this.fo();
            ViewParent parent = Toolbar.this.vu.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.vu);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.vu);
            }
            Toolbar.this.vv = hVar.getActionView();
            this.vW = hVar;
            ViewParent parent2 = Toolbar.this.vv.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.vv);
                }
                b bVarFr = Toolbar.fr();
                bVarFr.gravity = 8388611 | (Toolbar.this.vy & 112);
                bVarFr.vX = 2;
                Toolbar.this.vv.setLayoutParams(bVarFr);
                Toolbar toolbar4 = Toolbar.this;
                toolbar4.addView(toolbar4.vv);
            }
            Toolbar.this.fs();
            Toolbar.this.requestLayout();
            hVar.v(true);
            if (Toolbar.this.vv instanceof android.support.v7.view.b) {
                ((android.support.v7.view.b) Toolbar.this.vv).onActionViewExpanded();
            }
            return true;
        }

        @Override // android.support.v7.view.menu.m
        public final boolean c(android.support.v7.view.menu.h hVar) {
            if (Toolbar.this.vv instanceof android.support.v7.view.b) {
                ((android.support.v7.view.b) Toolbar.this.vv).onActionViewCollapsed();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.vv);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.vu);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.vv = null;
            toolbar3.ft();
            this.vW = null;
            Toolbar.this.requestLayout();
            hVar.v(false);
            return true;
        }
    }
}
