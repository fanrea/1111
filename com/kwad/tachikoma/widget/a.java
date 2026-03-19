package com.kwad.tachikoma.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.al;
import android.support.v7.widget.u;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.framework.tachikoma.a;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends com.tk.core.component.e<FrameLayout> {
    private LinearLayoutManager FE;
    private c FF;
    private final long FG;
    private JsValueRef<V8Function> FH;
    private JsValueRef<V8Function> FI;
    private int FJ;
    private al.n FK;
    private InterfaceC0642a FL;
    private al pD;

    /* renamed from: com.kwad.tachikoma.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0642a {
        void ct(int i);
    }

    static /* synthetic */ boolean a(a aVar, JsValueRef jsValueRef) {
        return a((JsValueRef<V8Function>) jsValueRef);
    }

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.FG = 500L;
    }

    public final void P(String str) {
        if (str == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < length; i++) {
                arrayList.add(b.a(jSONArray.getJSONObject(i)));
            }
            this.FF.g(arrayList);
        } catch (Exception e2) {
            com.kwad.tachikoma.e.log().d("TKLiveProductListView", "updateList error: " + e2.getMessage());
        }
    }

    public final void h(String str, int i) {
        if (str == null) {
            return;
        }
        try {
            this.FF.a(b.a(new JSONObject(str)), i);
        } catch (Exception e2) {
            com.kwad.tachikoma.e.log().d("TKLiveProductListView", "updateItem error: " + e2.getMessage());
        }
    }

    public final void i(String str, final int i) {
        if (str == null) {
            return;
        }
        try {
            this.FF.b(b.a(new JSONObject(str)), i);
            this.pD.postDelayed(new Runnable() { // from class: com.kwad.tachikoma.widget.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.pD.smoothScrollToPosition(i);
                }
            }, 300L);
        } catch (Exception e2) {
            com.kwad.tachikoma.e.log().d("TKLiveProductListView", "insertItem error: " + e2.getMessage());
        }
    }

    public final void removeItem(int i) {
        try {
            this.FF.removeItem(i);
        } catch (Exception e2) {
            com.kwad.tachikoma.e.log().d("TKLiveProductListView", "removeItem error: " + e2.getMessage());
        }
    }

    public final void I(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.FH);
        this.FH = jsValueRefRetainJsValue;
    }

    public final void J(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.FI);
        this.FI = jsValueRefRetainJsValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.support.v7.widget.al, android.view.View] */
    @Override // com.tk.core.component.e
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public FrameLayout n(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        jg();
        v(context);
        frameLayout.addView((View) this.pD, -1, -1);
        return frameLayout;
    }

    private void jg() {
        this.FJ = 4;
        this.FK = new al.n() { // from class: com.kwad.tachikoma.widget.a.2
            private int FO = 0;

            @Override // android.support.v7.widget.al.n
            public final void c(al alVar, int i) throws Throwable {
                super.c(alVar, i);
                if (i != 0 || this.FO <= 0 || a.this.FE == null || a.this.FF == null) {
                    return;
                }
                a aVar = a.this;
                if (a.a(aVar, aVar.FH)) {
                    int iDy = a.this.FE.dy();
                    int itemCount = a.this.FF.getItemCount() - 1;
                    if (alVar.canScrollHorizontally(1) || iDy != itemCount) {
                        return;
                    }
                    ((V8Function) a.this.FH.get()).call(null, new Object[0]);
                }
            }

            @Override // android.support.v7.widget.al.n
            public final void a(al alVar, int i, int i2) {
                super.a(alVar, i, i2);
                this.FO = i;
            }
        };
        this.FL = new InterfaceC0642a() { // from class: com.kwad.tachikoma.widget.a.3
            @Override // com.kwad.tachikoma.widget.a.InterfaceC0642a
            public final void ct(int i) throws Throwable {
                if (a.this.FI != null) {
                    ((V8Function) a.this.FI.get()).call(null, Integer.valueOf(i));
                }
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11, types: [android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.al$i] */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.support.v7.widget.al$f, android.support.v7.widget.u] */
    private void v(Context context) {
        Context contextWrapContextIfNeed = com.kwad.tachikoma.e.hP().hQ().wrapper().wrapContextIfNeed(context);
        this.pD = new al(contextWrapContextIfNeed);
        this.pD.a(new e(com.kwad.tachikoma.t.e.a(contextWrapContextIfNeed, this.FJ)));
        this.FF = new c(contextWrapContextIfNeed, this.FL);
        this.pD.setAdapter(this.FF);
        this.pD.setOnScrollListener(this.FK);
        ?? uVar = new u();
        uVar.g(500L);
        uVar.i(500L);
        uVar.f(500L);
        uVar.h(500L);
        this.pD.setItemAnimator(uVar);
        this.FE = new LinearLayoutManager(0, false);
        this.pD.setLayoutManager(this.FE);
    }

    private static boolean a(JsValueRef<V8Function> jsValueRef) {
        return (jsValueRef == null || jsValueRef.get() == null || jsValueRef.get().isReleased()) ? false : true;
    }

    static class d extends al.x implements View.OnClickListener {
        private InterfaceC0642a FV;
        private RoundAngleImageView FX;
        private TextView FY;
        private TextView FZ;
        private TextView Ga;

        public d(View view, InterfaceC0642a interfaceC0642a, boolean z, boolean z2, int i) {
            super(view);
            this.FV = interfaceC0642a;
            this.FX = (RoundAngleImageView) view.findViewById(a.b.ksad_product_item_img);
            this.FX.setRadius(i);
            View viewFindViewById = view.findViewById(a.b.ksad_product_item_detail);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(z ? 0 : 8);
            }
            View viewFindViewById2 = view.findViewById(a.b.ksad_product_item_current_label);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(z2 ? 0 : 8);
            }
            this.FY = (TextView) view.findViewById(a.b.ksad_product_item_name);
            this.FZ = (TextView) view.findViewById(a.b.ksad_product_item_desc);
            this.Ga = (TextView) view.findViewById(a.b.ksad_product_item_price);
            view.setOnClickListener(this);
        }

        public final void f(b bVar) {
            TextView textView;
            TextView textView2;
            if (bVar.FT != null && this.FX != null) {
                OfflineHostProvider.getApi().imageLoader().loadImage(this.FX, bVar.FT);
            }
            if (bVar.FQ != null && (textView2 = this.FY) != null) {
                textView2.setText(bVar.FQ);
            }
            if (bVar.FR != null && (textView = this.FZ) != null) {
                textView.setText(bVar.FR);
            }
            String str = bVar.FS;
            if (TextUtils.isEmpty(str) || this.Ga == null) {
                return;
            }
            if (str.startsWith("¥")) {
                new SpannableString(str).setSpan(new AbsoluteSizeSpan(8, true), 0, 1, 17);
            } else {
                this.Ga.setText(bVar.FS);
            }
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int iFv = fv();
            InterfaceC0642a interfaceC0642a = this.FV;
            if (interfaceC0642a != null) {
                interfaceC0642a.ct(iFv);
            }
        }
    }

    static class b {
        private int FP = 2;
        private String FQ;
        private String FR;
        private String FS;
        private String FT;

        b() {
        }

        public static b a(JSONObject jSONObject) {
            b bVar = new b();
            try {
                bVar.FQ = jSONObject.optString("productName");
                bVar.FR = jSONObject.optString("productDesc");
                bVar.FS = jSONObject.optString("productPrice");
                bVar.FT = jSONObject.optString("imgUrl");
                bVar.FP = jSONObject.optInt("itemType");
            } catch (Exception e) {
                com.kwad.tachikoma.e.log().d("TKLiveProductListView", "ItemData newInstance error: " + e.getMessage());
            }
            return bVar;
        }
    }

    static class c extends al.a<d> {
        private List<b> FU = new ArrayList();
        private InterfaceC0642a FV;
        private int FW;
        private Context mContext;

        public c(Context context, InterfaceC0642a interfaceC0642a) {
            this.mContext = context;
            this.FV = interfaceC0642a;
            this.FW = com.kwad.tachikoma.t.e.a(context, 4.0f);
        }

        public final void g(List<b> list) {
            this.FU.clear();
            this.FU.addAll(list);
            notifyDataSetChanged();
        }

        public final void a(b bVar, int i) {
            if (i < 0 || i >= this.FU.size() || bVar == null) {
                return;
            }
            this.FU.set(i, bVar);
            aD(i);
        }

        public final void b(b bVar, int i) {
            if (i < 0 || i >= this.FU.size() || bVar == null) {
                return;
            }
            this.FU.add(i, bVar);
            aE(i);
        }

        public final void removeItem(int i) {
            if (i < 0 || i >= this.FU.size()) {
                return;
            }
            this.FU.remove(i);
            aF(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.support.v7.widget.al.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public d b(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new d(e(viewGroup, a.c.ksad_live_product_item), this.FV, false, true, this.FW);
            }
            if (i == 2) {
                return new d(e(viewGroup, a.c.ksad_live_product_item), this.FV, false, false, this.FW);
            }
            if (i == 4) {
                return new d(e(viewGroup, a.c.ksad_live_product_item), this.FV, true, false, this.FW);
            }
            if (i == 5) {
                return new d(e(viewGroup, a.c.ksad_live_product_see_more), this.FV, false, false, this.FW);
            }
            return new d(e(viewGroup, a.c.ksad_live_product_item), this.FV, true, true, this.FW);
        }

        @Override // android.support.v7.widget.al.a
        public final int getItemViewType(int i) {
            return this.FU.get(i).FP;
        }

        private static View e(ViewGroup viewGroup, int i) {
            return LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // android.support.v7.widget.al.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(d dVar, int i) {
            dVar.f(this.FU.get(i));
        }

        @Override // android.support.v7.widget.al.a
        public final int getItemCount() {
            return this.FU.size();
        }
    }

    static class e extends al.h {
        private int Dw;

        public e(int i) {
            this.Dw = i;
        }

        @Override // android.support.v7.widget.al.h
        public final void a(Rect rect, View view, al alVar, al.u uVar) {
            if (alVar.W(view) != 0) {
                rect.left = this.Dw;
            }
        }
    }
}
