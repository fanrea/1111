package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.a.a;
import android.support.v7.view.menu.m;
import android.support.v7.widget.af;
import android.support.v7.widget.ag;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class e extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int hj = a.g.abc_cascading_menu_item_layout;
    private boolean hA;
    private int hB;
    private int hC;
    private boolean hE;
    private m.a hF;
    ViewTreeObserver hG;
    private PopupWindow.OnDismissListener hH;
    boolean hI;
    private final int hk;
    private final int hl;
    private final int hm;
    private final boolean hn;
    final Handler ho;
    private View hw;
    View hx;
    private boolean hz;
    private final Context mContext;
    private final List<g> hp = new ArrayList();
    final List<a> hq = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener hr = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.view.menu.e.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            if (!e.this.isShowing() || e.this.hq.size() <= 0 || e.this.hq.get(0).hO.isModal()) {
                return;
            }
            View view = e.this.hx;
            if (view == null || !view.isShown()) {
                e.this.dismiss();
                return;
            }
            Iterator<a> it = e.this.hq.iterator();
            while (it.hasNext()) {
                it.next().hO.show();
            }
        }
    };
    private final View.OnAttachStateChangeListener hs = new View.OnAttachStateChangeListener() { // from class: android.support.v7.view.menu.e.2
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            if (e.this.hG != null) {
                if (!e.this.hG.isAlive()) {
                    e.this.hG = view.getViewTreeObserver();
                }
                e.this.hG.removeGlobalOnLayoutListener(e.this.hr);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    private final af ht = new af() { // from class: android.support.v7.view.menu.e.3
        @Override // android.support.v7.widget.af
        public final void a(g gVar, MenuItem menuItem) {
            e.this.ho.removeCallbacksAndMessages(gVar);
        }

        @Override // android.support.v7.widget.af
        public final void b(final g gVar, final MenuItem menuItem) {
            e.this.ho.removeCallbacksAndMessages(null);
            int size = e.this.hq.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == e.this.hq.get(i).hP) {
                    break;
                } else {
                    i++;
                }
            }
            if (i == -1) {
                return;
            }
            int i2 = i + 1;
            final a aVar = i2 < e.this.hq.size() ? e.this.hq.get(i2) : null;
            e.this.ho.postAtTime(new Runnable() { // from class: android.support.v7.view.menu.e.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (aVar != null) {
                        e.this.hI = true;
                        aVar.hP.p(false);
                        e.this.hI = false;
                    }
                    if (menuItem.isEnabled() && menuItem.hasSubMenu()) {
                        gVar.a(menuItem, 4);
                    }
                }
            }, gVar, SystemClock.uptimeMillis() + 200);
        }
    };
    private int hu = 0;
    private int hv = 0;
    private boolean hD = false;
    private int hy = be();

    @Override // android.support.v7.view.menu.m
    public final boolean bb() {
        return false;
    }

    @Override // android.support.v7.view.menu.k
    protected final boolean bf() {
        return false;
    }

    public e(Context context, View view, int i, int i2, boolean z) {
        this.mContext = context;
        this.hw = view;
        this.hl = i;
        this.hm = i2;
        this.hn = z;
        Resources resources = context.getResources();
        this.hk = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(a.d.abc_config_prefDialogWidth));
        this.ho = new Handler();
    }

    @Override // android.support.v7.view.menu.k
    public final void setForceShowIcon(boolean z) {
        this.hD = z;
    }

    private ag bd() {
        ag agVar = new ag(this.mContext, null, this.hl, this.hm);
        agVar.setHoverListener(this.ht);
        agVar.setOnItemClickListener(this);
        agVar.setOnDismissListener(this);
        agVar.setAnchorView(this.hw);
        agVar.setDropDownGravity(this.hv);
        agVar.setModal(true);
        agVar.setInputMethodMode(2);
        return agVar;
    }

    @Override // android.support.v7.view.menu.q
    public final void show() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (isShowing()) {
            return;
        }
        Iterator<g> it = this.hp.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        this.hp.clear();
        this.hx = this.hw;
        if (this.hx != null) {
            boolean z = this.hG == null;
            this.hG = this.hx.getViewTreeObserver();
            if (z) {
                this.hG.addOnGlobalLayoutListener(this.hr);
            }
            this.hx.addOnAttachStateChangeListener(this.hs);
        }
    }

    @Override // android.support.v7.view.menu.q
    public final void dismiss() {
        int size = this.hq.size();
        if (size > 0) {
            a[] aVarArr = (a[]) this.hq.toArray(new a[size]);
            for (int i = size - 1; i >= 0; i--) {
                a aVar = aVarArr[i];
                if (aVar.hO.isShowing()) {
                    aVar.hO.dismiss();
                }
            }
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    private int be() {
        return android.support.v4.e.o.g(this.hw) == 1 ? 0 : 1;
    }

    private int H(int i) {
        List<a> list = this.hq;
        ListView listView = list.get(list.size() - 1).getListView();
        int[] iArr = new int[2];
        listView.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.hx.getWindowVisibleDisplayFrame(rect);
        return this.hy == 1 ? (iArr[0] + listView.getWidth()) + i > rect.right ? 0 : 1 : iArr[0] - i < 0 ? 1 : 0;
    }

    @Override // android.support.v7.view.menu.k
    public final void a(g gVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        gVar.a(this, this.mContext);
        if (isShowing()) {
            b(gVar);
        } else {
            this.hp.add(gVar);
        }
    }

    private void b(g gVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        a aVar;
        View viewA;
        int i;
        int i2;
        int i3;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.mContext);
        f fVar = new f(gVar, layoutInflaterFrom, this.hn, hj);
        if (!isShowing() && this.hD) {
            fVar.setForceShowIcon(true);
        } else if (isShowing()) {
            fVar.setForceShowIcon(k.d(gVar));
        }
        int iA = a(fVar, null, this.mContext, this.hk);
        ag agVarBd = bd();
        agVarBd.setAdapter(fVar);
        agVarBd.setContentWidth(iA);
        agVarBd.setDropDownGravity(this.hv);
        if (this.hq.size() > 0) {
            List<a> list = this.hq;
            aVar = list.get(list.size() - 1);
            viewA = a(aVar, gVar);
        } else {
            aVar = null;
            viewA = null;
        }
        if (viewA != null) {
            agVarBd.setTouchModal(false);
            agVarBd.o(null);
            int iH = H(iA);
            boolean z = iH == 1;
            this.hy = iH;
            if (Build.VERSION.SDK_INT >= 26) {
                agVarBd.setAnchorView(viewA);
                i2 = 0;
                i = 0;
            } else {
                int[] iArr = new int[2];
                this.hw.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                viewA.getLocationOnScreen(iArr2);
                if ((this.hv & 7) == 5) {
                    iArr[0] = iArr[0] + this.hw.getWidth();
                    iArr2[0] = iArr2[0] + viewA.getWidth();
                }
                i = iArr2[0] - iArr[0];
                i2 = iArr2[1] - iArr[1];
            }
            if ((this.hv & 5) == 5) {
                if (!z) {
                    iA = viewA.getWidth();
                    i3 = i - iA;
                }
                i3 = i + iA;
            } else {
                if (z) {
                    iA = viewA.getWidth();
                    i3 = i + iA;
                }
                i3 = i - iA;
            }
            agVarBd.setHorizontalOffset(i3);
            agVarBd.setOverlapAnchor(true);
            agVarBd.setVerticalOffset(i2);
        } else {
            if (this.hz) {
                agVarBd.setHorizontalOffset(this.hB);
            }
            if (this.hA) {
                agVarBd.setVerticalOffset(this.hC);
            }
            agVarBd.setEpicenterBounds(getEpicenterBounds());
        }
        this.hq.add(new a(agVarBd, gVar, this.hy));
        agVarBd.show();
        ListView listView = agVarBd.getListView();
        listView.setOnKeyListener(this);
        if (aVar == null && this.hE && gVar.bw() != null) {
            FrameLayout frameLayout = (FrameLayout) layoutInflaterFrom.inflate(a.g.abc_popup_menu_header_item_layout, (ViewGroup) listView, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.bw());
            listView.addHeaderView(frameLayout, null, false);
            agVarBd.show();
        }
    }

    private static MenuItem a(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = gVar.getItem(i);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View a(a aVar, g gVar) {
        f fVar;
        int headersCount;
        int firstVisiblePosition;
        MenuItem menuItemA = a(aVar.hP, gVar);
        if (menuItemA == null) {
            return null;
        }
        ListView listView = aVar.getListView();
        ListAdapter adapter = listView.getAdapter();
        int i = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            headersCount = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i >= count) {
                i = -1;
                break;
            }
            if (menuItemA == fVar.getItem(i)) {
                break;
            }
            i++;
        }
        if (i != -1 && (firstVisiblePosition = (i + headersCount) - listView.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < listView.getChildCount()) {
            return listView.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    @Override // android.support.v7.view.menu.q
    public final boolean isShowing() {
        return this.hq.size() > 0 && this.hq.get(0).hO.isShowing();
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        a aVar;
        int size = this.hq.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                aVar = null;
                break;
            }
            aVar = this.hq.get(i);
            if (!aVar.hO.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (aVar != null) {
            aVar.hP.p(false);
        }
    }

    @Override // android.support.v7.view.menu.m
    public final void l(boolean z) {
        Iterator<a> it = this.hq.iterator();
        while (it.hasNext()) {
            a(it.next().getListView().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // android.support.v7.view.menu.m
    public final void a(m.a aVar) {
        this.hF = aVar;
    }

    @Override // android.support.v7.view.menu.m
    public final boolean a(s sVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        for (a aVar : this.hq) {
            if (sVar == aVar.hP) {
                aVar.getListView().requestFocus();
                return true;
            }
        }
        if (!sVar.hasVisibleItems()) {
            return false;
        }
        a((g) sVar);
        m.a aVar2 = this.hF;
        if (aVar2 != null) {
            aVar2.e(sVar);
        }
        return true;
    }

    private int c(g gVar) {
        int size = this.hq.size();
        for (int i = 0; i < size; i++) {
            if (gVar == this.hq.get(i).hP) {
                return i;
            }
        }
        return -1;
    }

    @Override // android.support.v7.view.menu.m
    public final void a(g gVar, boolean z) {
        int iC = c(gVar);
        if (iC < 0) {
            return;
        }
        int i = iC + 1;
        if (i < this.hq.size()) {
            this.hq.get(i).hP.p(false);
        }
        a aVarRemove = this.hq.remove(iC);
        aVarRemove.hP.a(this);
        if (this.hI) {
            aVarRemove.hO.p(null);
            aVarRemove.hO.setAnimationStyle(0);
        }
        aVarRemove.hO.dismiss();
        int size = this.hq.size();
        if (size > 0) {
            this.hy = this.hq.get(size - 1).position;
        } else {
            this.hy = be();
        }
        if (size != 0) {
            if (z) {
                this.hq.get(0).hP.p(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.hF;
        if (aVar != null) {
            aVar.a(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.hG;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.hG.removeGlobalOnLayoutListener(this.hr);
            }
            this.hG = null;
        }
        this.hx.removeOnAttachStateChangeListener(this.hs);
        this.hH.onDismiss();
    }

    @Override // android.support.v7.view.menu.k
    public final void setGravity(int i) {
        if (this.hu != i) {
            this.hu = i;
            this.hv = android.support.v4.e.d.getAbsoluteGravity(i, android.support.v4.e.o.g(this.hw));
        }
    }

    @Override // android.support.v7.view.menu.k
    public final void setAnchorView(View view) {
        if (this.hw != view) {
            this.hw = view;
            this.hv = android.support.v4.e.d.getAbsoluteGravity(this.hu, android.support.v4.e.o.g(this.hw));
        }
    }

    @Override // android.support.v7.view.menu.k
    public final void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.hH = onDismissListener;
    }

    @Override // android.support.v7.view.menu.q
    public final ListView getListView() {
        if (this.hq.isEmpty()) {
            return null;
        }
        return this.hq.get(r0.size() - 1).getListView();
    }

    @Override // android.support.v7.view.menu.k
    public final void setHorizontalOffset(int i) {
        this.hz = true;
        this.hB = i;
    }

    @Override // android.support.v7.view.menu.k
    public final void setVerticalOffset(int i) {
        this.hA = true;
        this.hC = i;
    }

    @Override // android.support.v7.view.menu.k
    public final void m(boolean z) {
        this.hE = z;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a {
        public final ag hO;
        public final g hP;
        public final int position;

        public a(ag agVar, g gVar, int i) {
            this.hO = agVar;
            this.hP = gVar;
            this.position = i;
        }

        public final ListView getListView() {
            return this.hO.getListView();
        }
    }
}
