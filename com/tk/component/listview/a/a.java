package com.tk.component.listview.a;

import android.support.v7.widget.al;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tk.core.component.e;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class a extends al.a<b> {
    protected boolean Ph;
    protected boolean Tj;
    protected JsValueRef<V8Function> Tk;
    protected JsValueRef<V8Function> Tl;
    protected JsValueRef<V8Function> Tm;
    protected int Tn;
    protected int To;
    private List<Integer> Tp;
    protected final List<JsValueRef<V8Object>> Tq;
    protected final List<Integer> Tr;
    protected volatile boolean mIsDestroy;
    protected final com.tk.core.bridge.b mTKJSContext;

    public a(com.tk.core.bridge.b bVar) {
        this(bVar, false);
    }

    public a(com.tk.core.bridge.b bVar, boolean z) {
        this.Tq = new ArrayList();
        this.Tr = new ArrayList();
        this.mTKJSContext = bVar;
        this.Ph = z;
    }

    public final void k(List<Integer> list) {
        this.Tp = list;
        notifyDataSetChanged();
    }

    public final void setIsHorizontal(boolean z) {
        if (this.Ph != z) {
            this.Tj = true;
            this.Ph = z;
            notifyDataSetChanged();
        }
    }

    public void cX(int i) {
        if (this.mIsDestroy) {
            return;
        }
        if (i < 0) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyDataSetChanged itemCount < 0"));
            return;
        }
        this.Tn = i;
        if (!this.Tr.isEmpty()) {
            this.Tr.clear();
        }
        if (nE()) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < this.Tn; i2++) {
                arrayList.add(Integer.valueOf(i2));
            }
            List<Integer> listL = l(arrayList);
            if (listL != null && !listL.isEmpty()) {
                this.Tr.addAll(listL);
            }
        }
        notifyDataSetChanged();
    }

    public final void cY(int i) {
        if (this.mIsDestroy) {
            return;
        }
        if (i < 0 || i > this.Tn) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemInserted position is " + i + ", and dataCount = " + this.Tn));
            return;
        }
        if (nE()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            List<Integer> listL = l(arrayList);
            if (listL != null && !listL.isEmpty() && i <= this.Tr.size()) {
                this.Tr.add(i, listL.get(0));
            }
        }
        this.Tn++;
        aE(i);
    }

    public final void aH(int i, int i2) {
        if (this.mIsDestroy) {
            return;
        }
        if (i2 <= 0) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemRangeInserted length is " + i2));
            return;
        }
        if (i < 0 || i > this.Tn) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemRangeInserted startPosition is " + i + ", and dataCount = " + this.Tn));
            return;
        }
        if (nE()) {
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < i2; i3++) {
                arrayList.add(Integer.valueOf(i + i3));
            }
            List<Integer> listL = l(arrayList);
            if (listL != null && !listL.isEmpty() && i <= this.Tr.size()) {
                this.Tr.addAll(i, listL);
            }
        }
        this.Tn += i2;
        ab(i, i2);
    }

    public final void cZ(int i) {
        if (this.mIsDestroy) {
            return;
        }
        if (i < 0 || i >= this.Tn) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemRemoved position is " + i + ", and dataCount = " + this.Tn));
            return;
        }
        if (!this.Tr.isEmpty() && i < this.Tr.size()) {
            this.Tr.remove(i);
        }
        this.Tn--;
        this.Tn = Math.max(0, this.Tn);
        aF(i);
    }

    public final void aI(int i, int i2) {
        int i3;
        int i4;
        if (this.mIsDestroy) {
            return;
        }
        if (i2 <= 0) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemRangeRemoved length is " + i2));
            return;
        }
        if (i < 0 || i >= (i3 = this.Tn) || (i4 = i + i2) > i3) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemRangeRemoved startPosition is " + i + ", and dataCount = " + this.Tn));
            return;
        }
        if (!this.Tr.isEmpty()) {
            for (int i5 = i4 - 1; i5 >= i; i5--) {
                if (i5 < this.Tr.size()) {
                    this.Tr.remove(i5);
                }
            }
        }
        this.Tn -= i2;
        this.Tn = Math.max(0, this.Tn);
        ac(i, i2);
    }

    public final void aJ(int i, int i2) {
        int i3;
        if (this.mIsDestroy) {
            return;
        }
        if (i < 0 || i >= (i3 = this.Tn)) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemMoved fromPosition is " + i + ", and dataCount = " + this.Tn));
            return;
        }
        if (i2 < 0 || i2 >= i3) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemMoved toPosition is " + i2 + ", and dataCount = " + this.Tn));
            return;
        }
        if (!this.Tr.isEmpty() && i < this.Tr.size()) {
            int iIntValue = this.Tr.remove(i).intValue();
            if (i2 <= this.Tr.size()) {
                this.Tr.add(i2, Integer.valueOf(iIntValue));
            }
        }
        aa(i, i2);
    }

    public final void nD() {
        if (this.mIsDestroy) {
            return;
        }
        this.Tn = 0;
        if (!this.Tr.isEmpty()) {
            this.Tr.clear();
        }
        notifyDataSetChanged();
    }

    public final void da(int i) {
        if (this.mIsDestroy) {
            return;
        }
        if (i < 0 || i >= this.Tn) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemChanged position is " + i + ", and dataCount = " + this.Tn));
            return;
        }
        if (nE()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Integer.valueOf(i));
            List<Integer> listL = l(arrayList);
            if (listL != null && !listL.isEmpty() && i < this.Tr.size()) {
                this.Tr.set(i, listL.get(0));
            }
        }
        aD(i);
    }

    public final void aK(int i, int i2) {
        int i3;
        if (this.mIsDestroy) {
            return;
        }
        if (i2 <= 0) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemRangeChanged length is " + i2));
            return;
        }
        if (i < 0 || i >= (i3 = this.Tn) || i + i2 > i3) {
            com.tk.core.exception.a.a(this.mTKJSContext, new IndexOutOfBoundsException("notifyItemRangeChanged startPosition is " + i + ", and dataCount = " + this.Tn));
            return;
        }
        if (nE()) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < i2; i4++) {
                arrayList.add(Integer.valueOf(i + i4));
            }
            List<Integer> listL = l(arrayList);
            if (listL != null && !this.Tr.isEmpty()) {
                for (int i5 = 0; i5 < listL.size(); i5++) {
                    int i6 = i + i5;
                    if (i6 >= 0 && i6 < this.Tr.size()) {
                        this.Tr.set(i6, listL.get(i5));
                    }
                }
            }
        }
        Z(i, i2);
    }

    public final void d(JsValueRef<V8Function> jsValueRef) {
        this.Tk = jsValueRef;
    }

    public final void e(JsValueRef<V8Function> jsValueRef) {
        this.Tl = jsValueRef;
    }

    public final void f(JsValueRef<V8Function> jsValueRef) {
        this.Tm = jsValueRef;
    }

    private List<Integer> l(List<Integer> list) {
        if (!nE()) {
            this.Tr.clear();
            return null;
        }
        try {
            V8Array v8Array = (V8Array) this.Tm.get().call(null, list);
            if (v8Array == null) {
                return null;
            }
            List<Integer> list2 = v8Array.getList();
            try {
                v8Array.setWeak();
            } catch (Throwable th) {
                com.tk.core.exception.a.a(this.mTKJSContext, th);
            }
            return list2;
        } catch (Throwable th2) {
            com.tk.core.exception.a.a(this.mTKJSContext, th2);
            return null;
        }
    }

    private boolean nE() {
        JsValueRef<V8Function> jsValueRef = this.Tm;
        return jsValueRef != null && ad.isV8Valid(jsValueRef.get());
    }

    @Override // android.support.v7.widget.al.a
    public int getItemViewType(int i) {
        List<Integer> list;
        if (i < this.Tr.size()) {
            return this.Tr.get(i).intValue();
        }
        if (!nE() && (list = this.Tp) != null && !list.isEmpty()) {
            return this.Tp.get(i % this.Tp.size()).intValue();
        }
        return super.getItemViewType(i);
    }

    @Override // android.support.v7.widget.al.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b b(ViewGroup viewGroup, int i) {
        if (this.mIsDestroy) {
            return new b(new FrameLayout(viewGroup.getContext()), this.To);
        }
        try {
            e eVar = (e) this.mTKJSContext.getNativeModule((V8Object) this.Tk.get().call(null, Integer.valueOf(i)));
            int i2 = this.To;
            this.To = i2 + 1;
            this.Tq.add(i2, ad.retainJsValue(eVar.getJsObj(), this));
            eVar.getView().setLayoutParams(nF());
            return new b(eVar.getView(), i2);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(this.mTKJSContext, th);
            return new b(new FrameLayout(viewGroup.getContext()), this.To);
        }
    }

    @Override // android.support.v7.widget.al.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(b bVar, int i) {
        JsValueRef<V8Function> jsValueRef;
        JsValueRef<V8Object> jsValueRef2;
        if (this.mIsDestroy || (jsValueRef = this.Tl) == null || !ad.isV8Valid(jsValueRef.get()) || (jsValueRef2 = this.Tq.get(bVar.index)) == null || !ad.isV8Valid(jsValueRef2.get())) {
            return;
        }
        aJ(bVar.vu);
        try {
            this.Tl.get().call(null, jsValueRef2.get(), Integer.valueOf(i), Integer.valueOf(getItemViewType(i)));
        } catch (Throwable th) {
            com.tk.core.exception.a.a(this.mTKJSContext, th);
        }
    }

    @Override // android.support.v7.widget.al.a
    public int getItemCount() {
        return this.Tn;
    }

    protected void aJ(View view) {
        ViewGroup.LayoutParams layoutParams;
        if (!this.Tj || view == null || (layoutParams = view.getLayoutParams()) == null) {
            return;
        }
        this.Tj = false;
        if (this.Ph) {
            layoutParams.width = -2;
            layoutParams.height = -1;
        } else {
            layoutParams.width = -1;
            layoutParams.height = -2;
        }
        view.requestLayout();
    }

    protected ViewGroup.LayoutParams nF() {
        if (this.Ph) {
            return new ViewGroup.LayoutParams(-2, -1);
        }
        return new ViewGroup.LayoutParams(-1, -2);
    }

    public final void onDestroy() {
        this.mIsDestroy = true;
    }

    public void nG() {
        Iterator<JsValueRef<V8Object>> it = this.Tq.iterator();
        while (it.hasNext()) {
            ad.unRetainJsValue(it.next());
        }
        this.Tq.clear();
        ad.unRetainJsValue(this.Tk);
        ad.unRetainJsValue(this.Tl);
        ad.unRetainJsValue(this.Tm);
    }
}
