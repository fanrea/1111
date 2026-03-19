package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.a.a;
import android.support.v7.view.menu.m;
import android.support.v7.widget.ag;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class r extends k implements m, View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
    private static final int hj = a.g.abc_popup_menu_item_layout;
    private boolean hE;
    private m.a hF;
    ViewTreeObserver hG;
    private PopupWindow.OnDismissListener hH;
    private final g ha;
    private final int hl;
    private final int hm;
    private final boolean hn;
    final ViewTreeObserver.OnGlobalLayoutListener hr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.r.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (!r.this.isShowing() || r.this.jj.isModal()) {
                return;
            }
            View view = r.this.hx;
            if (view == null || !view.isShown()) {
                r.this.dismiss();
            } else {
                r.this.jj.show();
            }
        }
    };
    private final View.OnAttachStateChangeListener hs = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.r.2
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            if (r.this.hG != null) {
                if (!r.this.hG.isAlive()) {
                    r.this.hG = view.getViewTreeObserver();
                }
                r.this.hG.removeGlobalOnLayoutListener(r.this.hr);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private int hv = 0;
    private View hw;
    View hx;
    private final f jh;
    private final int ji;
    final ag jj;
    private boolean jk;
    private boolean jl;
    private int jm;
    private final Context mContext;

    @Override // android.support.v7.view.menu.k
    public final void a(g gVar) {
    }

    @Override // android.support.v7.view.menu.m
    public final boolean bb() {
        return false;
    }

    public r(Context context, g gVar, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.ha = gVar;
        this.hn = z;
        this.jh = new f(gVar, LayoutInflater.from(context), this.hn, hj);
        this.hl = i;
        this.hm = i2;
        Resources resources = context.getResources();
        this.ji = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.hw = view;
        this.jj = new ag(this.mContext, null, this.hl, this.hm);
        gVar.a(this, context);
    }

    @Override // android.support.v7.view.menu.k
    public final void setForceShowIcon(boolean z) {
        this.jh.setForceShowIcon(z);
    }

    @Override // android.support.v7.view.menu.k
    public final void setGravity(int i) {
        this.hv = i;
    }

    private boolean bN() {
        View view;
        if (isShowing()) {
            return true;
        }
        if (this.jk || (view = this.hw) == null) {
            return false;
        }
        this.hx = view;
        this.jj.setOnDismissListener(this);
        this.jj.setOnItemClickListener(this);
        this.jj.setModal(true);
        View view2 = this.hx;
        boolean z = this.hG == null;
        this.hG = view2.getViewTreeObserver();
        if (z) {
            this.hG.addOnGlobalLayoutListener(this.hr);
        }
        view2.addOnAttachStateChangeListener(this.hs);
        this.jj.setAnchorView(view2);
        this.jj.setDropDownGravity(this.hv);
        if (!this.jl) {
            this.jm = a(this.jh, null, this.mContext, this.ji);
            this.jl = true;
        }
        this.jj.setContentWidth(this.jm);
        this.jj.setInputMethodMode(2);
        this.jj.setEpicenterBounds(getEpicenterBounds());
        this.jj.show();
        ListView listView = this.jj.getListView();
        listView.setOnKeyListener(this);
        if (this.hE && this.ha.bw() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.mContext).inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            if (textView != null) {
                textView.setText(this.ha.bw());
            }
            frameLayout.setEnabled(false);
            listView.addHeaderView(frameLayout, null, false);
        }
        this.jj.setAdapter(this.jh);
        this.jj.show();
        return true;
    }

    @Override // android.support.v7.view.menu.q
    public final void show() {
        if (!bN()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // android.support.v7.view.menu.q
    public final void dismiss() {
        if (isShowing()) {
            this.jj.dismiss();
        }
    }

    @Override // android.support.v7.view.menu.q
    public final boolean isShowing() {
        return !this.jk && this.jj.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.jk = true;
        this.ha.close();
        ViewTreeObserver viewTreeObserver = this.hG;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.hG = this.hx.getViewTreeObserver();
            }
            this.hG.removeGlobalOnLayoutListener(this.hr);
            this.hG = null;
        }
        this.hx.removeOnAttachStateChangeListener(this.hs);
        PopupWindow.OnDismissListener onDismissListener = this.hH;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.support.v7.view.menu.m
    public final void l(boolean z) {
        this.jl = false;
        f fVar = this.jh;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.m
    public final void a(m.a aVar) {
        this.hF = aVar;
    }

    @Override // android.support.v7.view.menu.m
    public final boolean a(s sVar) {
        if (sVar.hasVisibleItems()) {
            l lVar = new l(this.mContext, sVar, this.hx, this.hn, this.hl, this.hm);
            lVar.b(this.hF);
            lVar.setForceShowIcon(k.d(sVar));
            lVar.setOnDismissListener(this.hH);
            this.hH = null;
            this.ha.p(false);
            int horizontalOffset = this.jj.getHorizontalOffset();
            int verticalOffset = this.jj.getVerticalOffset();
            if ((Gravity.getAbsoluteGravity(this.hv, android.support.v4.e.o.g(this.hw)) & 7) == 5) {
                horizontalOffset += this.hw.getWidth();
            }
            if (lVar.m(horizontalOffset, verticalOffset)) {
                m.a aVar = this.hF;
                if (aVar == null) {
                    return true;
                }
                aVar.e(sVar);
                return true;
            }
        }
        return false;
    }

    @Override // android.support.v7.view.menu.m
    public final void a(g gVar, boolean z) {
        if (gVar != this.ha) {
            return;
        }
        dismiss();
        m.a aVar = this.hF;
        if (aVar != null) {
            aVar.a(gVar, z);
        }
    }

    @Override // android.support.v7.view.menu.k
    public final void setAnchorView(View view) {
        this.hw = view;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // android.support.v7.view.menu.k
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.hH = onDismissListener;
    }

    @Override // android.support.v7.view.menu.q
    public final ListView getListView() {
        return this.jj.getListView();
    }

    @Override // android.support.v7.view.menu.k
    public final void setHorizontalOffset(int i) {
        this.jj.setHorizontalOffset(i);
    }

    @Override // android.support.v7.view.menu.k
    public final void setVerticalOffset(int i) {
        this.jj.setVerticalOffset(i);
    }

    @Override // android.support.v7.view.menu.k
    public final void m(boolean z) {
        this.hE = z;
    }
}
