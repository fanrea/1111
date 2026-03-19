package android.support.v7.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.e.c;
import android.support.v7.a.a;
import android.support.v7.view.menu.n;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class h implements android.support.v4.a.a.b {
    private CharSequence gA;
    private char gB;
    private char gD;
    private Drawable gF;
    private MenuItem.OnMenuItemClickListener gH;
    private CharSequence gI;
    private CharSequence gJ;
    private final int gw;
    private final int gx;
    private final int gy;
    private CharSequence gz;
    g ha;
    private s iN;
    private Runnable iO;
    private int iQ;
    private View iR;
    private android.support.v4.e.c iS;
    private MenuItem.OnActionExpandListener iT;
    private ContextMenu.ContextMenuInfo iV;
    private final int mId;
    private Intent mIntent;
    private int gC = 4096;
    private int gE = 4096;
    private int gG = 0;
    private ColorStateList gK = null;
    private PorterDuff.Mode gL = null;
    private boolean gM = false;
    private boolean gN = false;
    private boolean iP = false;
    private int mFlags = 16;
    private boolean iU = false;

    h(g gVar, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.iQ = 0;
        this.ha = gVar;
        this.mId = i2;
        this.gw = i;
        this.gx = i3;
        this.gy = i4;
        this.gz = charSequence;
        this.iQ = i5;
    }

    public final boolean bA() {
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = this.gH;
        if (onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(this)) {
            return true;
        }
        g gVar = this.ha;
        if (gVar.c(gVar, this)) {
            return true;
        }
        Runnable runnable = this.iO;
        if (runnable != null) {
            runnable.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.ha.getContext().startActivity(this.mIntent);
                return true;
            } catch (ActivityNotFoundException e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        android.support.v4.e.c cVar = this.iS;
        return cVar != null && cVar.onPerformDefaultAction();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.mFlags |= 16;
        } else {
            this.mFlags &= -17;
        }
        this.ha.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.gw;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final int getItemId() {
        return this.mId;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.gx;
    }

    public final int getOrdering() {
        return this.gy;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.gD;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        if (this.gD == c) {
            return this;
        }
        this.gD = Character.toLowerCase(c);
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.gD == c && this.gE == i) {
            return this;
        }
        this.gD = Character.toLowerCase(c);
        this.gE = KeyEvent.normalizeMetaState(i);
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.gE;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.gB;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.gC;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        if (this.gB == c) {
            return this;
        }
        this.gB = c;
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        if (this.gB == c && this.gC == i) {
            return this;
        }
        this.gB = c;
        this.gC = KeyEvent.normalizeMetaState(i);
        this.ha.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.gB = c;
        this.gD = Character.toLowerCase(c2);
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.gB = c;
        this.gC = KeyEvent.normalizeMetaState(i);
        this.gD = Character.toLowerCase(c2);
        this.gE = KeyEvent.normalizeMetaState(i2);
        this.ha.q(false);
        return this;
    }

    final char bB() {
        return this.ha.bm() ? this.gD : this.gB;
    }

    final String bC() {
        char cBB = bB();
        if (cBB == 0) {
            return "";
        }
        Resources resources = this.ha.getContext().getResources();
        StringBuilder sb = new StringBuilder();
        if (ViewConfiguration.get(this.ha.getContext()).hasPermanentMenuKey()) {
            sb.append(resources.getString(a.h.abc_prepend_shortcut_label));
        }
        int i = this.ha.bm() ? this.gE : this.gC;
        a(sb, i, 65536, resources.getString(a.h.abc_menu_meta_shortcut_label));
        a(sb, i, 4096, resources.getString(a.h.abc_menu_ctrl_shortcut_label));
        a(sb, i, 2, resources.getString(a.h.abc_menu_alt_shortcut_label));
        a(sb, i, 1, resources.getString(a.h.abc_menu_shift_shortcut_label));
        a(sb, i, 4, resources.getString(a.h.abc_menu_sym_shortcut_label));
        a(sb, i, 8, resources.getString(a.h.abc_menu_function_shortcut_label));
        if (cBB == '\b') {
            sb.append(resources.getString(a.h.abc_menu_delete_shortcut_label));
        } else if (cBB == '\n') {
            sb.append(resources.getString(a.h.abc_menu_enter_shortcut_label));
        } else if (cBB == ' ') {
            sb.append(resources.getString(a.h.abc_menu_space_shortcut_label));
        } else {
            sb.append(cBB);
        }
        return sb.toString();
    }

    private static void a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    final boolean bD() {
        return this.ha.bn() && bB() != 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.iN;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.iN != null;
    }

    public final void b(s sVar) {
        this.iN = sVar;
        sVar.setHeaderTitle(getTitle());
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public final CharSequence getTitle() {
        return this.gz;
    }

    final CharSequence a(n.a aVar) {
        if (aVar.aU()) {
            return getTitleCondensed();
        }
        return getTitle();
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.gz = charSequence;
        this.ha.q(false);
        s sVar = this.iN;
        if (sVar != null) {
            sVar.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        return setTitle(this.ha.getContext().getString(i));
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.gA;
        if (charSequence == null) {
            charSequence = this.gz;
        }
        return (Build.VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.gA = charSequence;
        this.ha.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.gF;
        if (drawable != null) {
            return h(drawable);
        }
        if (this.gG == 0) {
            return null;
        }
        Drawable drawableA = android.support.v7.b.a.a.a(this.ha.getContext(), this.gG);
        this.gG = 0;
        this.gF = drawableA;
        return h(drawableA);
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.gG = 0;
        this.gF = drawable;
        this.iP = true;
        this.ha.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.gF = null;
        this.gG = i;
        this.iP = true;
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.gK = colorStateList;
        this.gM = true;
        this.iP = true;
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.gK;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.gL = mode;
        this.gN = true;
        this.iP = true;
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.gL;
    }

    private Drawable h(Drawable drawable) {
        if (drawable != null && this.iP && (this.gM || this.gN)) {
            drawable = android.support.v4.graphics.drawable.a.c(drawable).mutate();
            if (this.gM) {
                android.support.v4.graphics.drawable.a.a(drawable, this.gK);
            }
            if (this.gN) {
                android.support.v4.graphics.drawable.a.a(drawable, this.gL);
            }
            this.iP = false;
        }
        return drawable;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.mFlags & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 1 : 0) | (i & (-2));
        if (i != this.mFlags) {
            this.ha.q(false);
        }
        return this;
    }

    public final void r(boolean z) {
        this.mFlags = (z ? 4 : 0) | (this.mFlags & (-5));
    }

    public final boolean bE() {
        return (this.mFlags & 4) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.mFlags & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        if ((this.mFlags & 4) != 0) {
            this.ha.c(this);
        } else {
            s(z);
        }
        return this;
    }

    final void s(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 2 : 0) | (i & (-3));
        if (i != this.mFlags) {
            this.ha.q(false);
        }
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        android.support.v4.e.c cVar = this.iS;
        return (cVar == null || !cVar.overridesItemVisibility()) ? (this.mFlags & 8) == 0 : (this.mFlags & 8) == 0 && this.iS.isVisible();
    }

    final boolean t(boolean z) {
        int i = this.mFlags;
        this.mFlags = (z ? 0 : 8) | (i & (-9));
        return i != this.mFlags;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        if (t(z)) {
            this.ha.bq();
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.gH = onMenuItemClickListener;
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.gz;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    final void a(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.iV = contextMenuInfo;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.iV;
    }

    public final void bF() {
        this.ha.br();
    }

    public final boolean shouldShowIcon() {
        return this.ha.by();
    }

    public final boolean bG() {
        return (this.mFlags & 32) == 32;
    }

    public final boolean bH() {
        return (this.iQ & 1) == 1;
    }

    public final boolean bI() {
        return (this.iQ & 2) == 2;
    }

    public final void u(boolean z) {
        if (z) {
            this.mFlags |= 32;
        } else {
            this.mFlags &= -33;
        }
    }

    public final boolean bJ() {
        return (this.iQ & 4) == 4;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.iQ = i;
        this.ha.br();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v4.a.a.b, android.view.MenuItem
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public android.support.v4.a.a.b setActionView(View view) {
        int i;
        this.iR = view;
        this.iS = null;
        if (view != null && view.getId() == -1 && (i = this.mId) > 0) {
            view.setId(i);
        }
        this.ha.br();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v4.a.a.b, android.view.MenuItem
    /* renamed from: O, reason: merged with bridge method [inline-methods] */
    public android.support.v4.a.a.b setActionView(int i) {
        Context context = this.ha.getContext();
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final View getActionView() {
        View view = this.iR;
        if (view != null) {
            return view;
        }
        android.support.v4.e.c cVar = this.iS;
        if (cVar == null) {
            return null;
        }
        this.iR = cVar.onCreateActionView(this);
        return this.iR;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.support.v4.a.a.b
    public final android.support.v4.e.c D() {
        return this.iS;
    }

    @Override // android.support.v4.a.a.b
    public final android.support.v4.a.a.b a(android.support.v4.e.c cVar) {
        android.support.v4.e.c cVar2 = this.iS;
        if (cVar2 != null) {
            cVar2.reset();
        }
        this.iR = null;
        this.iS = cVar;
        this.ha.q(true);
        android.support.v4.e.c cVar3 = this.iS;
        if (cVar3 != null) {
            cVar3.a(new c.b() { // from class: android.support.v7.view.menu.h.1
                @Override // android.support.v4.e.c.b
                public final void Y() {
                    h.this.ha.bq();
                }
            });
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v4.a.a.b, android.view.MenuItem
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public android.support.v4.a.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final boolean expandActionView() {
        if (!bK()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.iT;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.ha.e(this);
        }
        return false;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.iQ & 8) == 0) {
            return false;
        }
        if (this.iR == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.iT;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.ha.f(this);
        }
        return false;
    }

    public final boolean bK() {
        android.support.v4.e.c cVar;
        if ((this.iQ & 8) != 0) {
            if (this.iR == null && (cVar = this.iS) != null) {
                this.iR = cVar.onCreateActionView(this);
            }
            if (this.iR != null) {
                return true;
            }
        }
        return false;
    }

    public final void v(boolean z) {
        this.iU = z;
        this.ha.q(false);
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.iU;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.iT = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    /* renamed from: a */
    public final android.support.v4.a.a.b setContentDescription(CharSequence charSequence) {
        this.gI = charSequence;
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.gI;
    }

    @Override // android.view.MenuItem
    /* renamed from: b */
    public final android.support.v4.a.a.b setTooltipText(CharSequence charSequence) {
        this.gJ = charSequence;
        this.ha.q(false);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.gJ;
    }
}
