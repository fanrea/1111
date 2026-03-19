package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.e.c;
import android.support.v7.a.a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.m;
import android.support.v7.view.menu.n;
import android.support.v7.widget.ActionMenuView;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import java.util.ArrayList;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class c extends android.support.v7.view.menu.b implements c.a {
    private int kA;
    private int kB;
    private int kC;
    private boolean kD;
    private boolean kE;
    private boolean kF;
    private boolean kG;
    private int kH;
    private final SparseBooleanArray kI;
    private View kJ;
    e kK;
    a kL;
    RunnableC0017c kM;
    private b kN;
    final f kO;
    int kP;
    d kv;
    private Drawable kw;
    private boolean kx;
    private boolean ky;
    private boolean kz;

    public c(Context context) {
        super(context, a.g.abc_action_menu_layout, a.g.abc_action_menu_item_layout);
        this.kI = new SparseBooleanArray();
        this.kO = new f();
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.m
    public final void a(Context context, android.support.v7.view.menu.g gVar) {
        super.a(context, gVar);
        Resources resources = context.getResources();
        android.support.v7.view.a aVarC = android.support.v7.view.a.c(context);
        if (!this.kz) {
            this.ky = aVarC.aE();
        }
        if (!this.kF) {
            this.kA = aVarC.aF();
        }
        if (!this.kD) {
            this.kC = aVarC.aD();
        }
        int measuredWidth = this.kA;
        if (this.ky) {
            if (this.kv == null) {
                this.kv = new d(this.gZ);
                if (this.kx) {
                    this.kv.setImageDrawable(this.kw);
                    this.kw = null;
                    this.kx = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.kv.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.kv.getMeasuredWidth();
        } else {
            this.kv = null;
        }
        this.kB = measuredWidth;
        this.kH = (int) (resources.getDisplayMetrics().density * 56.0f);
        this.kJ = null;
    }

    public final void bZ() {
        if (!this.kD) {
            this.kC = android.support.v7.view.a.c(this.mContext).aD();
        }
        if (this.ha != null) {
            this.ha.q(true);
        }
    }

    public final void w(boolean z) {
        this.ky = true;
        this.kz = true;
    }

    public final void setExpandedActionViewsExclusive(boolean z) {
        this.kG = z;
    }

    public final void setOverflowIcon(Drawable drawable) {
        d dVar = this.kv;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.kx = true;
            this.kw = drawable;
        }
    }

    public final Drawable getOverflowIcon() {
        d dVar = this.kv;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.kx) {
            return this.kw;
        }
        return null;
    }

    @Override // android.support.v7.view.menu.b
    public final View a(android.support.v7.view.menu.h hVar, View view, ViewGroup viewGroup) {
        View actionView = hVar.getActionView();
        if (actionView == null || hVar.bK()) {
            actionView = super.a(hVar, view, viewGroup);
        }
        actionView.setVisibility(hVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // android.support.v7.view.menu.b
    public final void a(android.support.v7.view.menu.h hVar, n.a aVar) {
        aVar.a(hVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.hf);
        if (this.kN == null) {
            this.kN = new b();
        }
        actionMenuItemView.setPopupCallback(this.kN);
    }

    @Override // android.support.v7.view.menu.b
    public final boolean a(android.support.v7.view.menu.h hVar) {
        return hVar.bG();
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.m
    public final void l(boolean z) {
        super.l(z);
        ((View) this.hf).requestLayout();
        boolean z2 = false;
        if (this.ha != null) {
            ArrayList<android.support.v7.view.menu.h> arrayListBu = this.ha.bu();
            int size = arrayListBu.size();
            for (int i = 0; i < size; i++) {
                android.support.v4.e.c cVarD = arrayListBu.get(i).D();
                if (cVarD != null) {
                    cVarD.a(this);
                }
            }
        }
        ArrayList<android.support.v7.view.menu.h> arrayListBv = this.ha != null ? this.ha.bv() : null;
        if (this.ky && arrayListBv != null) {
            int size2 = arrayListBv.size();
            if (size2 == 1) {
                z2 = !arrayListBv.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.kv == null) {
                this.kv = new d(this.gZ);
            }
            ViewGroup viewGroup = (ViewGroup) this.kv.getParent();
            if (viewGroup != this.hf) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.kv);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.hf;
                actionMenuView.addView(this.kv, actionMenuView.ce());
            }
        } else {
            d dVar = this.kv;
            if (dVar != null && dVar.getParent() == this.hf) {
                ((ViewGroup) this.hf).removeView(this.kv);
            }
        }
        ((ActionMenuView) this.hf).setOverflowReserved(this.ky);
    }

    @Override // android.support.v7.view.menu.b
    public final boolean a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.kv) {
            return false;
        }
        return super.a(viewGroup, i);
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.m
    public final boolean a(android.support.v7.view.menu.s sVar) {
        boolean z = false;
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        android.support.v7.view.menu.s sVar2 = sVar;
        while (sVar2.bP() != this.ha) {
            sVar2 = (android.support.v7.view.menu.s) sVar2.bP();
        }
        View viewE = e(sVar2.getItem());
        if (viewE == null) {
            return false;
        }
        this.kP = sVar.getItem().getItemId();
        int size = sVar.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                break;
            }
            MenuItem item = sVar.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i++;
        }
        this.kL = new a(this.mContext, sVar, viewE);
        this.kL.setForceShowIcon(z);
        this.kL.show();
        super.a(sVar);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View e(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.hf;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public final boolean showOverflowMenu() {
        if (!this.ky || isOverflowMenuShowing() || this.ha == null || this.hf == null || this.kM != null || this.ha.bv().isEmpty()) {
            return false;
        }
        this.kM = new RunnableC0017c(new e(this.mContext, this.ha, this.kv, true));
        ((View) this.hf).post(this.kM);
        super.a((android.support.v7.view.menu.s) null);
        return true;
    }

    public final boolean hideOverflowMenu() {
        if (this.kM != null && this.hf != null) {
            ((View) this.hf).removeCallbacks(this.kM);
            this.kM = null;
            return true;
        }
        e eVar = this.kK;
        if (eVar == null) {
            return false;
        }
        eVar.dismiss();
        return true;
    }

    public final boolean ca() {
        return hideOverflowMenu() | cb();
    }

    public final boolean cb() {
        a aVar = this.kL;
        if (aVar == null) {
            return false;
        }
        aVar.dismiss();
        return true;
    }

    public final boolean isOverflowMenuShowing() {
        e eVar = this.kK;
        return eVar != null && eVar.isShowing();
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.m
    public final boolean bb() {
        ArrayList<android.support.v7.view.menu.h> arrayListBs;
        int size;
        int i;
        int iA;
        int i2;
        c cVar = this;
        int i3 = 0;
        if (cVar.ha != null) {
            arrayListBs = cVar.ha.bs();
            size = arrayListBs.size();
        } else {
            arrayListBs = null;
            size = 0;
        }
        int i4 = cVar.kC;
        int i5 = cVar.kB;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) cVar.hf;
        int i6 = i4;
        boolean z = false;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            android.support.v7.view.menu.h hVar = arrayListBs.get(i9);
            if (hVar.bI()) {
                i7++;
            } else if (hVar.bH()) {
                i8++;
            } else {
                z = true;
            }
            if (cVar.kG && hVar.isActionViewExpanded()) {
                i6 = 0;
            }
        }
        if (cVar.ky && (z || i8 + i7 > i6)) {
            i6--;
        }
        int i10 = i6 - i7;
        SparseBooleanArray sparseBooleanArray = cVar.kI;
        sparseBooleanArray.clear();
        if (cVar.kE) {
            int i11 = cVar.kH;
            iA = i5 / i11;
            i = i11 + ((i5 % i11) / iA);
        } else {
            i = 0;
            iA = 0;
        }
        int i12 = i5;
        int i13 = 0;
        int i14 = 0;
        while (i13 < size) {
            android.support.v7.view.menu.h hVar2 = arrayListBs.get(i13);
            if (hVar2.bI()) {
                View viewA = cVar.a(hVar2, cVar.kJ, viewGroup);
                if (cVar.kJ == null) {
                    cVar.kJ = viewA;
                }
                if (cVar.kE) {
                    iA -= ActionMenuView.a(viewA, i, iA, iMakeMeasureSpec, i3);
                } else {
                    viewA.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                }
                int measuredWidth = viewA.getMeasuredWidth();
                i12 -= measuredWidth;
                if (i14 != 0) {
                    measuredWidth = i14;
                }
                int groupId = hVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                hVar2.u(true);
                i2 = size;
                i14 = measuredWidth;
            } else if (hVar2.bH()) {
                int groupId2 = hVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i10 > 0 || z2) && i12 > 0 && (!cVar.kE || iA > 0);
                boolean z4 = z3;
                if (z3) {
                    View viewA2 = cVar.a(hVar2, cVar.kJ, viewGroup);
                    i2 = size;
                    if (cVar.kJ == null) {
                        cVar.kJ = viewA2;
                    }
                    if (cVar.kE) {
                        int iA2 = ActionMenuView.a(viewA2, i, iA, iMakeMeasureSpec, 0);
                        iA -= iA2;
                        if (iA2 == 0) {
                            z4 = false;
                        }
                    } else {
                        viewA2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    }
                    int measuredWidth2 = viewA2.getMeasuredWidth();
                    i12 -= measuredWidth2;
                    if (i14 == 0) {
                        i14 = measuredWidth2;
                    }
                    z3 = z4 & (!cVar.kE ? i12 + i14 <= 0 : i12 < 0);
                } else {
                    i2 = size;
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i15 = 0; i15 < i13; i15++) {
                        android.support.v7.view.menu.h hVar3 = arrayListBs.get(i15);
                        if (hVar3.getGroupId() == groupId2) {
                            if (hVar3.bG()) {
                                i10++;
                            }
                            hVar3.u(false);
                        }
                    }
                }
                if (z3) {
                    i10--;
                }
                hVar2.u(z3);
            } else {
                i2 = size;
                hVar2.u(false);
                i13++;
                i3 = 0;
                cVar = this;
                size = i2;
            }
            i13++;
            i3 = 0;
            cVar = this;
            size = i2;
        }
        return true;
    }

    @Override // android.support.v7.view.menu.b, android.support.v7.view.menu.m
    public final void a(android.support.v7.view.menu.g gVar, boolean z) {
        ca();
        super.a(gVar, z);
    }

    @Override // android.support.v4.e.c.a
    public final void i(boolean z) {
        if (z) {
            super.a((android.support.v7.view.menu.s) null);
        } else if (this.ha != null) {
            this.ha.p(false);
        }
    }

    public final void a(ActionMenuView actionMenuView) {
        this.hf = actionMenuView;
        actionMenuView.f(this.ha);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class d extends m implements ActionMenuView.a {
        private final float[] kS;

        @Override // android.support.v7.widget.ActionMenuView.a
        public final boolean aW() {
            return false;
        }

        @Override // android.support.v7.widget.ActionMenuView.a
        public final boolean aX() {
            return false;
        }

        public d(Context context) {
            super(context, null, a.C0010a.actionOverflowButtonStyle);
            this.kS = new float[2];
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            ax.a(this, getContentDescription());
            setOnTouchListener(new z(this) { // from class: android.support.v7.widget.c.d.1
                @Override // android.support.v7.widget.z
                public final android.support.v7.view.menu.q aY() {
                    if (c.this.kK == null) {
                        return null;
                    }
                    return c.this.kK.bM();
                }

                @Override // android.support.v7.widget.z
                public final boolean aZ() {
                    c.this.showOverflowMenu();
                    return true;
                }

                @Override // android.support.v7.widget.z
                public final boolean cc() {
                    if (c.this.kM != null) {
                        return false;
                    }
                    c.this.hideOverflowMenu();
                    return true;
                }
            });
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.showOverflowMenu();
            return true;
        }

        @Override // android.widget.ImageView
        protected final boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                android.support.v4.graphics.drawable.a.a(background, paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class e extends android.support.v7.view.menu.l {
        public e(Context context, android.support.v7.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, true, a.C0010a.actionOverflowMenuStyle);
            setGravity(GravityCompat.END);
            b(c.this.kO);
        }

        @Override // android.support.v7.view.menu.l
        public final void onDismiss() {
            if (c.this.ha != null) {
                c.this.ha.close();
            }
            c.this.kK = null;
            super.onDismiss();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a extends android.support.v7.view.menu.l {
        public a(Context context, android.support.v7.view.menu.s sVar, View view) {
            super(context, sVar, view, false, a.C0010a.actionOverflowMenuStyle);
            if (!((android.support.v7.view.menu.h) sVar.getItem()).bG()) {
                setAnchorView(c.this.kv == null ? (View) c.this.hf : c.this.kv);
            }
            b(c.this.kO);
        }

        @Override // android.support.v7.view.menu.l
        public final void onDismiss() {
            c cVar = c.this;
            cVar.kL = null;
            cVar.kP = 0;
            super.onDismiss();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class f implements m.a {
        f() {
        }

        @Override // android.support.v7.view.menu.m.a
        public final boolean e(android.support.v7.view.menu.g gVar) {
            if (gVar == null) {
                return false;
            }
            c.this.kP = ((android.support.v7.view.menu.s) gVar).getItem().getItemId();
            m.a aVarBa = c.this.ba();
            if (aVarBa != null) {
                return aVarBa.e(gVar);
            }
            return false;
        }

        @Override // android.support.v7.view.menu.m.a
        public final void a(android.support.v7.view.menu.g gVar, boolean z) {
            if (gVar instanceof android.support.v7.view.menu.s) {
                gVar.bx().p(false);
            }
            m.a aVarBa = c.this.ba();
            if (aVarBa != null) {
                aVarBa.a(gVar, z);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    /* renamed from: android.support.v7.widget.c$c, reason: collision with other inner class name */
    class RunnableC0017c implements Runnable {
        private e kR;

        public RunnableC0017c(e eVar) {
            this.kR = eVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = (View) c.this.hf;
            if (view != null && view.getWindowToken() != null && this.kR.bN()) {
                c.this.kK = this.kR;
            }
            c.this.kM = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // android.support.v7.view.menu.ActionMenuItemView.b
        public final android.support.v7.view.menu.q aY() {
            if (c.this.kL != null) {
                return c.this.kL.bM();
            }
            return null;
        }
    }
}
