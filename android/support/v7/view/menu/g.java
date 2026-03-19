package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.internal.view.SupportMenu;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class g implements android.support.v4.a.a.a {
    private static final int[] ik = {1, 4, 5, 3, 2, 0};
    private final Resources fK;
    CharSequence iA;
    Drawable iB;
    View iC;
    private h iK;
    private boolean iM;
    private boolean il;
    private boolean im;

    /* renamed from: io, reason: collision with root package name */
    private a f708io;
    private ContextMenu.ContextMenuInfo iz;
    private final Context mContext;
    private int iy = 0;
    private boolean iD = false;
    private boolean iE = false;
    private boolean iF = false;
    private boolean iG = false;
    private boolean iH = false;
    private ArrayList<h> iI = new ArrayList<>();
    private CopyOnWriteArrayList<WeakReference<m>> iJ = new CopyOnWriteArrayList<>();
    private boolean iL = false;
    private ArrayList<h> iq = new ArrayList<>();
    private ArrayList<h> ir = new ArrayList<>();
    private boolean iu = true;
    private ArrayList<h> iv = new ArrayList<>();
    private ArrayList<h> iw = new ArrayList<>();
    private boolean ix = true;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface a {
        boolean d(MenuItem menuItem);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface b {
        boolean d(h hVar);
    }

    public g bx() {
        return this;
    }

    public g(Context context) {
        this.mContext = context;
        this.fK = context.getResources();
        o(true);
    }

    public final void a(m mVar, Context context) {
        this.iJ.add(new WeakReference<>(mVar));
        mVar.a(context, this);
        this.ix = true;
    }

    public final void a(m mVar) {
        Iterator<WeakReference<m>> it = this.iJ.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null || mVar2 == mVar) {
                this.iJ.remove(next);
            }
        }
    }

    private void n(boolean z) {
        if (this.iJ.isEmpty()) {
            return;
        }
        bo();
        Iterator<WeakReference<m>> it = this.iJ.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.iJ.remove(next);
            } else {
                mVar.l(z);
            }
        }
        bp();
    }

    private boolean a(s sVar, m mVar) {
        if (this.iJ.isEmpty()) {
            return false;
        }
        boolean zA = mVar != null ? mVar.a(sVar) : false;
        Iterator<WeakReference<m>> it = this.iJ.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar2 = next.get();
            if (mVar2 == null) {
                this.iJ.remove(next);
            } else if (!zA) {
                zA = mVar2.a(sVar);
            }
        }
        return zA;
    }

    public void a(a aVar) {
        this.f708io = aVar;
    }

    private MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int iL = L(i3);
        h hVarA = a(i, i2, i3, iL, charSequence, this.iy);
        ContextMenu.ContextMenuInfo contextMenuInfo = this.iz;
        if (contextMenuInfo != null) {
            hVarA.a(contextMenuInfo);
        }
        ArrayList<h> arrayList = this.iq;
        arrayList.add(a(arrayList, iL), hVarA);
        q(true);
        return hVarA;
    }

    private h a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new h(this, i, i2, i3, i4, charSequence, i5);
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.fK.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.fK.getString(i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.fK.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        h hVar = (h) a(i, i2, i3, charSequence);
        s sVar = new s(this.mContext, this, hVar);
        hVar.b(sVar);
        return sVar;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.fK.getString(i4));
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.iL = z;
    }

    public boolean bl() {
        return this.iL;
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.mContext.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        a(J(i), true);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int iK = K(i);
        if (iK >= 0) {
            int size = this.iq.size() - iK;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || this.iq.get(iK).getGroupId() != i) {
                    break;
                }
                a(iK, false);
                i2 = i3;
            }
            q(true);
        }
    }

    private void a(int i, boolean z) {
        if (i < 0 || i >= this.iq.size()) {
            return;
        }
        this.iq.remove(i);
        if (z) {
            q(true);
        }
    }

    @Override // android.view.Menu
    public void clear() {
        h hVar = this.iK;
        if (hVar != null) {
            f(hVar);
        }
        this.iq.clear();
        q(true);
    }

    final void c(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.iq.size();
        bo();
        for (int i = 0; i < size; i++) {
            h hVar = this.iq.get(i);
            if (hVar.getGroupId() == groupId && hVar.bE() && hVar.isCheckable()) {
                hVar.s(hVar == menuItem);
            }
        }
        bp();
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.iq.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.iq.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.r(z2);
                hVar.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.iq.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.iq.get(i2);
            if (hVar.getGroupId() == i && hVar.t(z)) {
                z2 = true;
            }
        }
        if (z2) {
            q(true);
        }
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.iq.size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.iq.get(i2);
            if (hVar.getGroupId() == i) {
                hVar.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.iM) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.iq.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem menuItemFindItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = this.iq.get(i2);
            if (hVar.getItemId() == i) {
                return hVar;
            }
            if (hVar.hasSubMenu() && (menuItemFindItem = hVar.getSubMenu().findItem(i)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    private int J(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.iq.get(i2).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    private int K(int i) {
        return l(i, 0);
    }

    private int l(int i, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.iq.get(i3).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    @Override // android.view.Menu
    public int size() {
        return this.iq.size();
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.iq.get(i);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.il = z;
        q(false);
    }

    private static int L(int i) {
        int i2 = ((-65536) & i) >> 16;
        if (i2 >= 0) {
            int[] iArr = ik;
            if (i2 < iArr.length) {
                return (i & 65535) | (iArr[i2] << 16);
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean bm() {
        return this.il;
    }

    private void o(boolean z) {
        this.im = this.fK.getConfiguration().keyboard != 1 && android.support.v4.e.p.d(ViewConfiguration.get(this.mContext), this.mContext);
    }

    public boolean bn() {
        return this.im;
    }

    private Resources getResources() {
        return this.fK;
    }

    public final Context getContext() {
        return this.mContext;
    }

    boolean c(g gVar, MenuItem menuItem) {
        a aVar = this.f708io;
        return aVar != null && aVar.d(menuItem);
    }

    private static int a(ArrayList<h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size).getOrdering() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        h hVarA = a(i, keyEvent);
        boolean zA = hVarA != null ? a(hVarA, i2) : false;
        if ((i2 & 2) != 0) {
            p(true);
        }
        return zA;
    }

    private void a(List<h> list, int i, KeyEvent keyEvent) {
        boolean zBm = bm();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.iq.size();
            for (int i2 = 0; i2 < size; i2++) {
                h hVar = this.iq.get(i2);
                if (hVar.hasSubMenu()) {
                    ((g) hVar.getSubMenu()).a(list, i, keyEvent);
                }
                char alphabeticShortcut = zBm ? hVar.getAlphabeticShortcut() : hVar.getNumericShortcut();
                if (((modifiers & SupportMenu.SUPPORTED_MODIFIERS_MASK) == ((zBm ? hVar.getAlphabeticModifiers() : hVar.getNumericModifiers()) & SupportMenu.SUPPORTED_MODIFIERS_MASK)) && alphabeticShortcut != 0 && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (zBm && alphabeticShortcut == '\b' && i == 67)) && hVar.isEnabled())) {
                    list.add(hVar);
                }
            }
        }
    }

    private h a(int i, KeyEvent keyEvent) {
        char numericShortcut;
        ArrayList<h> arrayList = this.iI;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean zBm = bm();
        for (int i2 = 0; i2 < size; i2++) {
            h hVar = arrayList.get(i2);
            if (zBm) {
                numericShortcut = hVar.getAlphabeticShortcut();
            } else {
                numericShortcut = hVar.getNumericShortcut();
            }
            if ((numericShortcut == keyData.meta[0] && (metaState & 2) == 0) || ((numericShortcut == keyData.meta[2] && (metaState & 2) != 0) || (zBm && numericShortcut == '\b' && i == 67))) {
                return hVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    public final boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (m) null, i);
    }

    public final boolean a(MenuItem menuItem, m mVar, int i) {
        h hVar = (h) menuItem;
        if (hVar == null || !hVar.isEnabled()) {
            return false;
        }
        boolean zBA = hVar.bA();
        android.support.v4.e.c cVarD = hVar.D();
        boolean z = cVarD != null && cVarD.hasSubMenu();
        if (hVar.bK()) {
            zBA |= hVar.expandActionView();
            if (zBA) {
                p(true);
            }
        } else if (hVar.hasSubMenu() || z) {
            if ((i & 4) == 0) {
                p(false);
            }
            if (!hVar.hasSubMenu()) {
                hVar.b(new s(getContext(), this, hVar));
            }
            s sVar = (s) hVar.getSubMenu();
            if (z) {
                cVarD.onPrepareSubMenu(sVar);
            }
            zBA |= a(sVar, mVar);
            if (!zBA) {
                p(true);
            }
        } else if ((i & 1) == 0) {
            p(true);
        }
        return zBA;
    }

    public final void p(boolean z) {
        if (this.iH) {
            return;
        }
        this.iH = true;
        Iterator<WeakReference<m>> it = this.iJ.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.iJ.remove(next);
            } else {
                mVar.a(this, z);
            }
        }
        this.iH = false;
    }

    @Override // android.view.Menu
    public void close() {
        p(true);
    }

    public final void q(boolean z) {
        if (!this.iD) {
            if (z) {
                this.iu = true;
                this.ix = true;
            }
            n(z);
            return;
        }
        this.iE = true;
        if (z) {
            this.iF = true;
        }
    }

    private void bo() {
        if (this.iD) {
            return;
        }
        this.iD = true;
        this.iE = false;
        this.iF = false;
    }

    private void bp() {
        this.iD = false;
        if (this.iE) {
            this.iE = false;
            q(this.iF);
        }
    }

    final void bq() {
        this.iu = true;
        q(true);
    }

    final void br() {
        this.ix = true;
        q(true);
    }

    public final ArrayList<h> bs() {
        if (!this.iu) {
            return this.ir;
        }
        this.ir.clear();
        int size = this.iq.size();
        for (int i = 0; i < size; i++) {
            h hVar = this.iq.get(i);
            if (hVar.isVisible()) {
                this.ir.add(hVar);
            }
        }
        this.iu = false;
        this.ix = true;
        return this.ir;
    }

    public final void bt() {
        ArrayList<h> arrayListBs = bs();
        if (this.ix) {
            Iterator<WeakReference<m>> it = this.iJ.iterator();
            boolean zBb = false;
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.iJ.remove(next);
                } else {
                    zBb |= mVar.bb();
                }
            }
            if (zBb) {
                this.iv.clear();
                this.iw.clear();
                int size = arrayListBs.size();
                for (int i = 0; i < size; i++) {
                    h hVar = arrayListBs.get(i);
                    if (hVar.bG()) {
                        this.iv.add(hVar);
                    } else {
                        this.iw.add(hVar);
                    }
                }
            } else {
                this.iv.clear();
                this.iw.clear();
                this.iw.addAll(bs());
            }
            this.ix = false;
        }
    }

    public final ArrayList<h> bu() {
        bt();
        return this.iv;
    }

    public final ArrayList<h> bv() {
        bt();
        return this.iw;
    }

    public void clearHeader() {
        this.iB = null;
        this.iA = null;
        this.iC = null;
        q(false);
    }

    private void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = getResources();
        if (view != null) {
            this.iC = view;
            this.iA = null;
            this.iB = null;
        } else {
            if (i > 0) {
                this.iA = resources.getText(i);
            } else if (charSequence != null) {
                this.iA = charSequence;
            }
            if (i2 > 0) {
                this.iB = android.support.v4.content.a.a(getContext(), i2);
            } else if (drawable != null) {
                this.iB = drawable;
            }
            this.iC = null;
        }
        q(false);
    }

    protected final g c(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    protected final g M(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    protected final g g(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    protected final g N(int i) {
        a(0, null, i, null, null);
        return this;
    }

    protected final g v(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    public final CharSequence bw() {
        return this.iA;
    }

    final boolean by() {
        return this.iG;
    }

    public boolean e(h hVar) {
        boolean zB = false;
        if (this.iJ.isEmpty()) {
            return false;
        }
        bo();
        Iterator<WeakReference<m>> it = this.iJ.iterator();
        while (it.hasNext()) {
            WeakReference<m> next = it.next();
            m mVar = next.get();
            if (mVar == null) {
                this.iJ.remove(next);
            } else {
                zB = mVar.b(hVar);
                if (zB) {
                    break;
                }
            }
        }
        bp();
        if (zB) {
            this.iK = hVar;
        }
        return zB;
    }

    public boolean f(h hVar) {
        boolean zC = false;
        if (!this.iJ.isEmpty() && this.iK == hVar) {
            bo();
            Iterator<WeakReference<m>> it = this.iJ.iterator();
            while (it.hasNext()) {
                WeakReference<m> next = it.next();
                m mVar = next.get();
                if (mVar == null) {
                    this.iJ.remove(next);
                } else {
                    zC = mVar.c(hVar);
                    if (zC) {
                        break;
                    }
                }
            }
            bp();
            if (zC) {
                this.iK = null;
            }
        }
        return zC;
    }

    public final h bz() {
        return this.iK;
    }
}
