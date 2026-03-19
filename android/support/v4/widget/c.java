package android.support.v4.widget;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.support.v4.widget.d;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class c extends BaseAdapter implements d.a, Filterable {
    protected DataSetObserver dA;
    protected d dB;
    protected FilterQueryProvider dC;
    protected boolean dv;
    protected boolean dw;
    protected Cursor dx;
    protected int dy;
    protected a dz;
    protected Context mContext;

    public abstract void a(View view, Cursor cursor);

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public abstract View newView(Context context, Cursor cursor, ViewGroup viewGroup);

    public c(Context context, Cursor cursor, boolean z) {
        a(context, cursor, z ? 1 : 2);
    }

    private void a(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.dw = true;
        } else {
            this.dw = false;
        }
        boolean z = cursor != null;
        this.dx = cursor;
        this.dv = z;
        this.mContext = context;
        this.dy = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.dz = new a();
            this.dA = new b();
        } else {
            this.dz = null;
            this.dA = null;
        }
        if (z) {
            a aVar = this.dz;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.dA;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    @Override // android.support.v4.widget.d.a
    public final Cursor getCursor() {
        return this.dx;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.dv || (cursor = this.dx) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.dv || (cursor = this.dx) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.dx;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.dv && (cursor = this.dx) != null && cursor.moveToPosition(i)) {
            return this.dx.getLong(this.dy);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.dv) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.dx.moveToPosition(i)) {
            throw new IllegalStateException("couldn't move cursor to position " + i);
        }
        if (view == null) {
            view = newView(this.mContext, this.dx, viewGroup);
        }
        a(view, this.dx);
        return view;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.dv) {
            return null;
        }
        this.dx.moveToPosition(i);
        if (view == null) {
            view = newDropDownView(this.mContext, this.dx, viewGroup);
        }
        a(view, this.dx);
        return view;
    }

    public View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return newView(context, cursor, viewGroup);
    }

    @Override // android.support.v4.widget.d.a
    public void changeCursor(Cursor cursor) {
        Cursor cursorSwapCursor = swapCursor(cursor);
        if (cursorSwapCursor != null) {
            cursorSwapCursor.close();
        }
    }

    private Cursor swapCursor(Cursor cursor) {
        Cursor cursor2 = this.dx;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            a aVar = this.dz;
            if (aVar != null) {
                cursor2.unregisterContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.dA;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.dx = cursor;
        if (cursor != null) {
            a aVar2 = this.dz;
            if (aVar2 != null) {
                cursor.registerContentObserver(aVar2);
            }
            DataSetObserver dataSetObserver2 = this.dA;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.dy = cursor.getColumnIndexOrThrow("_id");
            this.dv = true;
            notifyDataSetChanged();
        } else {
            this.dy = -1;
            this.dv = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }

    @Override // android.support.v4.widget.d.a
    public CharSequence convertToString(Cursor cursor) {
        return cursor == null ? "" : cursor.toString();
    }

    @Override // android.support.v4.widget.d.a
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        FilterQueryProvider filterQueryProvider = this.dC;
        if (filterQueryProvider != null) {
            return filterQueryProvider.runQuery(charSequence);
        }
        return this.dx;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.dB == null) {
            this.dB = new d(this);
        }
        return this.dB;
    }

    protected final void onContentChanged() {
        Cursor cursor;
        if (!this.dw || (cursor = this.dx) == null || cursor.isClosed()) {
            return;
        }
        this.dv = this.dx.requery();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class a extends ContentObserver {
        @Override // android.database.ContentObserver
        public final boolean deliverSelfNotifications() {
            return true;
        }

        a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z) {
            c.this.onContentChanged();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    class b extends DataSetObserver {
        b() {
        }

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            c cVar = c.this;
            cVar.dv = true;
            cVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            c cVar = c.this;
            cVar.dv = false;
            cVar.notifyDataSetInvalidated();
        }
    }
}
