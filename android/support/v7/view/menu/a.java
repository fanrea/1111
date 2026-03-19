package android.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class a implements android.support.v4.a.a.b {
    private CharSequence gA;
    private char gB;
    private char gD;
    private Drawable gF;
    private MenuItem.OnMenuItemClickListener gH;
    private CharSequence gI;
    private CharSequence gJ;
    private CharSequence gz;
    private Context mContext;
    private Intent mIntent;
    private int gC = 4096;
    private int gE = 4096;
    private int gG = 0;
    private ColorStateList gK = null;
    private PorterDuff.Mode gL = null;
    private boolean gM = false;
    private boolean gN = false;
    private int mFlags = 16;
    private final int mId = R.id.home;
    private final int gw = 0;
    private final int gx = 0;
    private final int gy = 0;

    @Override // android.support.v4.a.a.b
    public final android.support.v4.e.c D() {
        return null;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final void setShowAsAction(int i) {
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final /* synthetic */ MenuItem setActionView(int i) {
        return aR();
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final /* synthetic */ MenuItem setActionView(View view) {
        return aQ();
    }

    public a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.mContext = context;
        this.gz = charSequence;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.gD;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.gE;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.gw;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.gF;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.mIntent;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.mId;
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
    public final int getOrder() {
        return this.gy;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.gz;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.gA;
        return charSequence != null ? charSequence : this.gz;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.mFlags & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.mFlags & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.mFlags & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.mFlags & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        this.gD = Character.toLowerCase(c);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.gD = Character.toLowerCase(c);
        this.gE = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.mFlags = (z ? 1 : 0) | (this.mFlags & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.mFlags = (z ? 2 : 0) | (this.mFlags & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.mFlags = (z ? 16 : 0) | (this.mFlags & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.gF = drawable;
        this.gG = 0;
        aS();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.gG = i;
        this.gF = android.support.v4.content.a.a(this.mContext, i);
        aS();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        this.gB = c;
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        this.gB = c;
        this.gC = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.gH = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.gB = c;
        this.gD = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.gB = c;
        this.gC = KeyEvent.normalizeMetaState(i);
        this.gD = Character.toLowerCase(c2);
        this.gE = KeyEvent.normalizeMetaState(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.gz = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.gz = this.mContext.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.gA = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        this.mFlags = (this.mFlags & 8) | (z ? 0 : 8);
        return this;
    }

    private static android.support.v4.a.a.b aQ() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    private static android.support.v4.a.a.b aR() {
        throw new UnsupportedOperationException();
    }

    @Override // android.support.v4.a.a.b
    public final android.support.v4.a.a.b a(android.support.v4.e.c cVar) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.support.v4.a.a.b, android.view.MenuItem
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public android.support.v4.a.a.b setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final android.support.v4.a.a.b setContentDescription(CharSequence charSequence) {
        this.gI = charSequence;
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.gI;
    }

    @Override // android.view.MenuItem
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final android.support.v4.a.a.b setTooltipText(CharSequence charSequence) {
        this.gJ = charSequence;
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.gJ;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.gK = colorStateList;
        this.gM = true;
        aS();
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
        aS();
        return this;
    }

    @Override // android.support.v4.a.a.b, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.gL;
    }

    private void aS() {
        if (this.gF != null) {
            if (this.gM || this.gN) {
                this.gF = android.support.v4.graphics.drawable.a.c(this.gF);
                this.gF = this.gF.mutate();
                if (this.gM) {
                    android.support.v4.graphics.drawable.a.a(this.gF, this.gK);
                }
                if (this.gN) {
                    android.support.v4.graphics.drawable.a.a(this.gF, this.gL);
                }
            }
        }
    }
}
