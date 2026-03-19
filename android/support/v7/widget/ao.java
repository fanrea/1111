package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.support.v7.widget.ac;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class ao extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {
    private static final Interpolator sL = new DecelerateInterpolator();
    private int ju;
    Runnable sE;
    ac sF;
    private Spinner sG;
    private boolean sH;
    int sI;
    int sJ;
    private int sK;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.sF.getChildCount();
        if (childCount > 1 && (mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            if (childCount > 2) {
                this.sI = (int) (View.MeasureSpec.getSize(i) * 0.4f);
            } else {
                this.sI = View.MeasureSpec.getSize(i) / 2;
            }
            this.sI = Math.min(this.sI, this.sJ);
        } else {
            this.sI = -1;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.ju, 1073741824);
        if (!z && this.sH) {
            this.sF.measure(0, iMakeMeasureSpec);
            if (this.sF.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                ep();
            } else {
                eq();
            }
        } else {
            eq();
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i, iMakeMeasureSpec);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setTabSelected(this.sK);
    }

    private boolean eo() {
        Spinner spinner = this.sG;
        return spinner != null && spinner.getParent() == this;
    }

    public final void setAllowCollapse(boolean z) {
        this.sH = z;
    }

    private void ep() {
        if (eo()) {
            return;
        }
        if (this.sG == null) {
            this.sG = er();
        }
        removeView(this.sF);
        addView(this.sG, new ViewGroup.LayoutParams(-2, -1));
        if (this.sG.getAdapter() == null) {
            this.sG.setAdapter((SpinnerAdapter) new a());
        }
        Runnable runnable = this.sE;
        if (runnable != null) {
            removeCallbacks(runnable);
            this.sE = null;
        }
        this.sG.setSelection(this.sK);
    }

    private boolean eq() {
        if (!eo()) {
            return false;
        }
        removeView(this.sG);
        addView(this.sF, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.sG.getSelectedItemPosition());
        return false;
    }

    public final void setTabSelected(int i) {
        this.sK = i;
        int childCount = this.sF.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.sF.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                aB(i);
            }
            i2++;
        }
        Spinner spinner = this.sG;
        if (spinner == null || i < 0) {
            return;
        }
        spinner.setSelection(i);
    }

    public final void setContentHeight(int i) {
        this.ju = i;
        requestLayout();
    }

    private Spinner er() {
        o oVar = new o(getContext(), null, a.C0010a.actionDropDownStyle);
        oVar.setLayoutParams(new ac.a(-2, -1));
        oVar.setOnItemSelectedListener(this);
        return oVar;
    }

    @Override // android.view.View
    protected final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        android.support.v7.view.a aVarC = android.support.v7.view.a.c(getContext());
        setContentHeight(aVarC.aH());
        this.sJ = aVarC.aI();
    }

    private void aB(int i) {
        final View childAt = this.sF.getChildAt(i);
        Runnable runnable = this.sE;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.sE = new Runnable() { // from class: android.support.v7.widget.ao.1
            @Override // java.lang.Runnable
            public final void run() {
                ao.this.smoothScrollTo(childAt.getLeft() - ((ao.this.getWidth() - childAt.getWidth()) / 2), 0);
                ao.this.sE = null;
            }
        };
        post(this.sE);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.sE;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.sE;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    final b a(a.b bVar, boolean z) {
        b bVar2 = new b(getContext(), bVar, true);
        bVar2.setBackgroundDrawable(null);
        bVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.ju));
        return bVar2;
    }

    class b extends LinearLayout {
        private TextView em;
        private ImageView hS;
        private View jM;
        private final int[] sO;
        private a.b sP;

        public b(Context context, a.b bVar, boolean z) {
            super(context, null, a.C0010a.actionBarTabStyle);
            this.sO = new int[]{R.attr.background};
            this.sP = bVar;
            av avVarA = av.a(context, null, this.sO, a.C0010a.actionBarTabStyle, 0);
            if (avVarA.hasValue(0)) {
                setBackgroundDrawable(avVarA.getDrawable(0));
            }
            avVarA.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public final void a(a.b bVar) {
            this.sP = bVar;
            update();
        }

        @Override // android.view.View
        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.b.class.getName());
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.b.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (ao.this.sI <= 0 || getMeasuredWidth() <= ao.this.sI) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(ao.this.sI, 1073741824), i2);
        }

        private void update() {
            a.b bVar = this.sP;
            View customView = bVar.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.jM = customView;
                TextView textView = this.em;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.hS;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.hS.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.jM;
            if (view != null) {
                removeView(view);
                this.jM = null;
            }
            Drawable icon = bVar.getIcon();
            CharSequence text = bVar.getText();
            if (icon != null) {
                if (this.hS == null) {
                    m mVar = new m(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    mVar.setLayoutParams(layoutParams);
                    addView(mVar, 0);
                    this.hS = mVar;
                }
                this.hS.setImageDrawable(icon);
                this.hS.setVisibility(0);
            } else {
                ImageView imageView2 = this.hS;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.hS.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(text);
            if (z) {
                if (this.em == null) {
                    q qVar = new q(getContext(), null, a.C0010a.actionBarTabTextStyle);
                    qVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    qVar.setLayoutParams(layoutParams2);
                    addView(qVar);
                    this.em = qVar;
                }
                this.em.setText(text);
                this.em.setVisibility(0);
            } else {
                TextView textView2 = this.em;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.em.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.hS;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.getContentDescription());
            }
            ax.a(this, z ? null : bVar.getContentDescription());
        }

        public final a.b es() {
            return this.sP;
        }
    }

    class a extends BaseAdapter {
        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        a() {
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return ao.this.sF.getChildCount();
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            return ((b) ao.this.sF.getChildAt(i)).es();
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return ao.this.a((a.b) getItem(i), true);
            }
            ((b) view).a((a.b) getItem(i));
            return view;
        }
    }
}
