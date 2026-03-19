package com.component.a.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.ab;
import com.baidu.mobads.container.util.animation.j;
import com.baidu.mobads.container.util.bq;
import com.baidu.mobstat.forbes.Config;
import com.component.a.d.b;
import com.component.a.i.n;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a extends c {
    public static final int a = 0;
    public static final int b = 1;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private String j;
    private int k;
    private int l;

    public a(Context context, com.component.a.f.e eVar) throws JSONException {
        super(context, eVar);
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        String str = j.e;
        this.j = j.e;
        this.k = 0;
        if (eVar == null || eVar.o().isEmpty()) {
            return;
        }
        this.d = eVar.h(0);
        this.e = eVar.g(0);
        this.f = eVar.f(0);
        this.i = ab.a(context, eVar.i(0));
        this.j = this.e == 1 ? j.g : str;
        this.k = this.e == 1 ? 1 : 0;
        this.l = this.e == 1 ? 1 : 4;
        this.g = ab.a(context, eVar.j(0));
        this.h = ab.a(context, eVar.k(0));
        int[] iArr = new int[4];
        iArr[this.k] = this.g;
        iArr[this.k + 2] = this.h;
        setPadding(iArr[0], iArr[1], iArr[2], iArr[3]);
        List<com.component.a.f.e> listO = eVar.o();
        int size = listO.size();
        if (size > 0) {
            com.component.a.f.e eVar2 = listO.get(0);
            JSONObject jSONObjectF = eVar2.f();
            String strL = eVar2.l("");
            String strA = n.a((CharSequence) strL, "#\\d+$");
            String strReplaceAll = strL.replaceAll("#\\d+$", "").replaceAll("_\\d+$", "");
            JSONArray jSONArrayOptJSONArray = eVar.f().optJSONArray("child_view");
            for (int i = 1; i < this.f; i++) {
                if (i < size) {
                    n.a(listO.get(i).f(), jSONObjectF, false);
                } else {
                    JSONObject jSONObjectC = n.c(jSONObjectF.toString());
                    n.b(jSONObjectC, "id", strReplaceAll + Config.replace + i + strA);
                    if (jSONArrayOptJSONArray != null) {
                        try {
                            jSONArrayOptJSONArray.put(i, jSONObjectC);
                        } catch (JSONException e) {
                            bq.a().a(e);
                        }
                    }
                }
            }
            if (this.f < size) {
                JSONArray jSONArray = new JSONArray();
                for (int i2 = 0; i2 < this.f; i2++) {
                    if (jSONArrayOptJSONArray != null) {
                        try {
                            jSONArray.put(i2, jSONArrayOptJSONArray.opt(i2));
                        } catch (JSONException e2) {
                            bq.a().a(e2);
                        }
                    }
                }
                n.b(eVar.f(), "child_view", jSONArray);
            }
            eVar.a();
        }
    }

    @Override // com.component.a.d.c, com.component.a.c.b
    public void a(View view, com.component.a.f.e eVar, int i) {
        if (view != null && eVar != null) {
            int childCount = getChildCount();
            JSONObject jSONObjectF = eVar.f();
            if (childCount == 0) {
                n.b(jSONObjectF, "gravity", Integer.valueOf(eVar.c(this.l) | this.l));
            } else if (childCount > 0) {
                n.b(jSONObjectF, this.j, getChildAt(childCount - 1).getTag());
                a(jSONObjectF, this.k, ab.b(getContext(), this.i));
            }
            super.a(view, eVar, i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0018 A[Catch: all -> 0x0026, TRY_LEAVE, TryCatch #0 {all -> 0x0026, blocks: (B:4:0x0008, B:6:0x000f, B:7:0x0018), top: B:13:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(org.json.JSONObject r5, int r6, int r7) {
        /*
            r4 = this;
            java.lang.String r0 = "margins"
            org.json.JSONArray r1 = com.component.a.i.n.b(r5, r0)
            if (r1 == 0) goto L18
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L26
            r3 = 4
            if (r2 < r3) goto L18
            int r5 = r1.optInt(r6)     // Catch: java.lang.Throwable -> L26
            int r5 = r5 + r7
            r1.put(r6, r5)     // Catch: java.lang.Throwable -> L26
            goto L25
        L18:
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L26
            java.lang.String r2 = "[0,0,0,0]"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L26
            r1.put(r6, r7)     // Catch: java.lang.Throwable -> L26
            r5.put(r0, r1)     // Catch: java.lang.Throwable -> L26
        L25:
            goto L2e
        L26:
            r5 = move-exception
            com.baidu.mobads.container.util.bq r6 = com.baidu.mobads.container.util.bq.a()
            r6.a(r5)
        L2e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.component.a.d.a.a(org.json.JSONObject, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.component.a.d.c
    protected void a(int i, int i2) {
        b.C0314b c0314bA;
        if (this.d == 1) {
            super.a(i, i2);
            return;
        }
        int size = (View.MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (View.MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        int childCount = size2 - (this.i * (getChildCount() - 1));
        int childCount2 = size - (this.i * (getChildCount() - 1));
        int childCount3 = getChildCount();
        for (int i3 = 0; i3 < childCount3; i3++) {
            View childAt = getChildAt(i3);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof b.c) && (c0314bA = ((b.c) layoutParams).a()) != null) {
                b.C0314b c0314b = new b.C0314b();
                c0314b.a = c0314bA.a;
                c0314b.b = c0314bA.b;
                if (this.e == 1) {
                    c0314bA.b = 1.0f / this.f;
                } else {
                    c0314bA.a = 1.0f / this.f;
                }
                this.c.a(size, size2, childAt, c0314bA);
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    if (this.e == 1 && childCount > 0) {
                        c0314bA.a(layoutParams, size, childCount);
                    } else if (childCount2 > 0) {
                        c0314bA.a(layoutParams, childCount2, size2);
                    }
                    c0314bA.a(childAt, (ViewGroup.MarginLayoutParams) layoutParams, size, size2);
                } else {
                    c0314bA.a(layoutParams, size, size2);
                }
                c0314bA.a = c0314b.a;
                c0314bA.b = c0314b.b;
            }
        }
    }
}
