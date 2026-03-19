package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
class p extends c<android.support.v4.a.a.a> implements Menu {
    p(Context context, android.support.v4.a.a.a aVar) {
        super(context, aVar);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return b(((android.support.v4.a.a.a) this.hi).add(charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return b(((android.support.v4.a.a.a) this.hi).add(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return b(((android.support.v4.a.a.a) this.hi).add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return b(((android.support.v4.a.a.a) this.hi).add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(((android.support.v4.a.a.a) this.hi).addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return a(((android.support.v4.a.a.a) this.hi).addSubMenu(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(((android.support.v4.a.a.a) this.hi).addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(((android.support.v4.a.a.a) this.hi).addSubMenu(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = ((android.support.v4.a.a.a) this.hi).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = b(menuItemArr2[i5]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        G(i);
        ((android.support.v4.a.a.a) this.hi).removeItem(i);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        F(i);
        ((android.support.v4.a.a.a) this.hi).removeGroup(i);
    }

    @Override // android.view.Menu
    public void clear() {
        bc();
        ((android.support.v4.a.a.a) this.hi).clear();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((android.support.v4.a.a.a) this.hi).setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        ((android.support.v4.a.a.a) this.hi).setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        ((android.support.v4.a.a.a) this.hi).setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return ((android.support.v4.a.a.a) this.hi).hasVisibleItems();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return b(((android.support.v4.a.a.a) this.hi).findItem(i));
    }

    @Override // android.view.Menu
    public int size() {
        return ((android.support.v4.a.a.a) this.hi).size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return b(((android.support.v4.a.a.a) this.hi).getItem(i));
    }

    @Override // android.view.Menu
    public void close() {
        ((android.support.v4.a.a.a) this.hi).close();
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((android.support.v4.a.a.a) this.hi).performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((android.support.v4.a.a.a) this.hi).isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return ((android.support.v4.a.a.a) this.hi).performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        ((android.support.v4.a.a.a) this.hi).setQwertyMode(z);
    }
}
