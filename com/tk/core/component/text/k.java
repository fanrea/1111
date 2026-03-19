package com.tk.core.component.text;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import com.kuaishou.tk.api.export.sdk.Callback;
import com.kuaishou.tk.export.INativeModule;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class k {
    private static final float afJ = Resources.getSystem().getDisplayMetrics().density;
    private final List<h> afK = new ArrayList();
    private final Map<i, JsValueRef<V8Function>> afL = new HashMap();
    private final List<i> afM = new ArrayList();
    private final List<a> afN = new ArrayList();
    private String mBundleId;
    private final Context mContext;
    private final String mRootDir;
    private int mVersionCode;

    static class a {
        Object afR;
        int bU;
        int vP;

        a(Object obj, int i, int i2) {
            this.afR = obj;
            this.vP = i;
            this.bU = i2;
        }
    }

    public k(Context context, String str, String str2, int i) {
        this.mContext = context;
        this.mRootDir = str;
        this.mBundleId = str2;
        this.mVersionCode = i;
    }

    public final void a(INativeModule iNativeModule) {
        if (iNativeModule instanceof h) {
            h hVar = (h) iNativeModule;
            hVar.pL();
            this.afK.add(hVar);
            i iVarA = i.a(hVar);
            if (iVarA == null) {
                return;
            }
            this.afM.add(iVarA);
        }
    }

    public final void n(List<i> list) {
        this.afM.addAll(list);
    }

    public final void rp() {
        this.afM.clear();
        this.afN.clear();
    }

    public final void ih() {
        for (h hVar : this.afK) {
            if (hVar != null) {
                hVar.pM();
            }
        }
        this.afK.clear();
        Iterator<Map.Entry<i, JsValueRef<V8Function>>> it = this.afL.entrySet().iterator();
        while (it.hasNext()) {
            ad.unRetainJsValue(it.next().getValue());
        }
        this.afL.clear();
    }

    public final CharSequence a(String str, final TextView textView, final com.tk.core.bridge.b bVar) {
        SpannableString spannableString = new SpannableString(str);
        for (final i iVar : this.afM) {
            switch (iVar.afz) {
                case "url":
                    URLSpan uRLSpan = new URLSpan(iVar.url);
                    spannableString.setSpan(uRLSpan, iVar.start, iVar.end, 17);
                    this.afN.add(new a(uRLSpan, iVar.start, iVar.end));
                    break;
                case "backgroundColor":
                    Integer numValueOf = Integer.valueOf(com.tk.core.o.r.parseColor(iVar.aei));
                    if (numValueOf != null) {
                        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(numValueOf.intValue());
                        spannableString.setSpan(backgroundColorSpan, iVar.start, iVar.end, 17);
                        this.afN.add(new a(backgroundColorSpan, iVar.start, iVar.end));
                        break;
                    } else {
                        break;
                    }
                case "foregroundColor":
                    Integer numValueOf2 = Integer.valueOf(com.tk.core.o.r.parseColor(iVar.aei));
                    if (numValueOf2 != null) {
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(numValueOf2.intValue());
                        spannableString.setSpan(foregroundColorSpan, iVar.start, iVar.end, 17);
                        this.afN.add(new a(foregroundColorSpan, iVar.start, iVar.end));
                        break;
                    } else {
                        break;
                    }
                case "absoluteSize":
                    c(spannableString, iVar);
                    break;
                case "textStyle":
                    b(spannableString, iVar);
                    break;
                case "strikeThrough":
                    StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
                    spannableString.setSpan(strikethroughSpan, iVar.start, iVar.end, 17);
                    this.afN.add(new a(strikethroughSpan, iVar.start, iVar.end));
                    break;
                case "underLine":
                    UnderlineSpan underlineSpan = new UnderlineSpan();
                    spannableString.setSpan(underlineSpan, iVar.start, iVar.end, 17);
                    this.afN.add(new a(underlineSpan, iVar.start, iVar.end));
                    break;
                case "image":
                    if (TextUtils.isEmpty(iVar.imageUrl)) {
                        break;
                    } else {
                        spannableString = d(spannableString, iVar);
                        if (iVar.imageUrl.startsWith(com.alipay.sdk.m.l.a.r)) {
                            a(a(iVar, textView), spannableString, iVar);
                            break;
                        } else {
                            a(cp(iVar.imageUrl), spannableString, iVar);
                            break;
                        }
                    }
                case "fontFamily":
                    a(spannableString, iVar);
                    c(spannableString, iVar);
                    b(spannableString, iVar);
                    break;
                case "click":
                    JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(iVar.afI, this);
                    if (jsValueRefRetainJsValue == null || !ad.isV8Valid(jsValueRefRetainJsValue.get())) {
                        break;
                    } else {
                        ad.unRetainJsValue(this.afL.get(iVar));
                        this.afL.put(iVar, jsValueRefRetainJsValue);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        ClickableSpan clickableSpan = new ClickableSpan() { // from class: com.tk.core.component.text.k.1
                            @Override // android.text.style.ClickableSpan
                            public final void onClick(View view) {
                                JsValueRef jsValueRef = (JsValueRef) k.this.afL.get(iVar);
                                if (jsValueRef == null) {
                                    return;
                                }
                                V8Function v8Function = (V8Function) jsValueRef.get();
                                if (ad.isV8Valid(v8Function)) {
                                    try {
                                        v8Function.call(null, new Object[0]);
                                    } catch (Throwable th) {
                                        com.tk.core.exception.a.a(bVar, th);
                                    }
                                }
                            }

                            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                            public final void updateDrawState(TextPaint textPaint) {
                                super.updateDrawState(textPaint);
                                if (iVar.aei != null) {
                                    textPaint.setColor(Color.parseColor(iVar.aei));
                                } else {
                                    textPaint.setColor(textView.getCurrentTextColor());
                                }
                                textPaint.setUnderlineText(false);
                            }
                        };
                        spannableString.setSpan(clickableSpan, iVar.start, iVar.end, 17);
                        this.afN.add(new a(clickableSpan, iVar.start, iVar.end));
                        break;
                    }
            }
        }
        return spannableString;
    }

    private void a(SpannableString spannableString, i iVar) {
        if (TextUtils.isEmpty(iVar.KS) || TextUtils.isEmpty(this.mRootDir)) {
            return;
        }
        Typeface typefaceA = com.tk.core.component.b.a(this.mContext, iVar.KS, 0, this.mRootDir.concat(iVar.KS), this.mBundleId, this.mVersionCode);
        if (typefaceA != null) {
            c cVar = new c(null, typefaceA);
            spannableString.setSpan(cVar, iVar.start, iVar.end, 17);
            this.afN.add(new a(cVar, iVar.start, iVar.end));
        }
    }

    private void b(SpannableString spannableString, i iVar) {
        int i;
        if ("bold".equals(iVar.afB)) {
            i = 1;
        } else if ("bold_italic".equals(iVar.afB)) {
            i = 3;
        } else {
            i = "italic".equals(iVar.afB) ? 2 : 0;
        }
        StyleSpan styleSpan = new StyleSpan(i);
        spannableString.setSpan(styleSpan, iVar.start, iVar.end, 17);
        this.afN.add(new a(styleSpan, iVar.start, iVar.end));
    }

    private void c(SpannableString spannableString, i iVar) {
        if (iVar.size <= 0) {
            return;
        }
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan((int) (iVar.size * afJ));
        spannableString.setSpan(absoluteSizeSpan, iVar.start, iVar.end, 17);
        this.afN.add(new a(absoluteSizeSpan, iVar.start, iVar.end));
    }

    private void a(final i iVar, final s sVar, final TextView textView) {
        com.tk.core.o.h.b(this.mContext, iVar.imageUrl, this.mBundleId, this.mRootDir, -1, -1, new Callback<BitmapDrawable>() { // from class: com.tk.core.component.text.k.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kuaishou.tk.api.export.sdk.Callback
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void callback(BitmapDrawable bitmapDrawable) {
                if (bitmapDrawable == null) {
                    com.tk.core.i.a.z("SpanModel", "fetchSpanBitmap fail: bitmap is null");
                    return;
                }
                bitmapDrawable.setBounds(0, 0, com.tk.core.o.o.eb(iVar.afC), com.tk.core.o.o.eb(iVar.afD));
                sVar.setBounds(0, 0, com.tk.core.o.o.eb(iVar.afC), com.tk.core.o.o.eb(iVar.afD));
                s sVar2 = sVar;
                sVar2.agy = bitmapDrawable;
                sVar2.invalidateSelf();
                textView.invalidate();
                com.tk.core.i.a.z("SpanModel", "fetchSpanBitmap successful");
            }

            @Override // com.kuaishou.tk.api.export.sdk.Callback
            public final void error(Throwable th) {
                com.tk.core.i.a.a("SpanModel", "fetchSpanBitmap", th);
            }
        });
    }

    private void a(Drawable drawable, SpannableString spannableString, i iVar) {
        if (drawable == null) {
            return;
        }
        com.tk.core.component.text.a aVar = new com.tk.core.component.text.a(drawable, "");
        aVar.aQ((iVar.afC < 0 || iVar.afD < 0) ? drawable.getIntrinsicWidth() : com.tk.core.o.o.eb(iVar.afC), (iVar.afC < 0 || iVar.afD < 0) ? drawable.getIntrinsicHeight() : com.tk.core.o.o.eb(iVar.afD)).J(com.tk.core.o.o.P(iVar.afF)).K(com.tk.core.o.o.P(iVar.afG)).L(com.tk.core.o.o.P(iVar.afE));
        spannableString.setSpan(aVar, iVar.index, iVar.index + 1, 17);
        this.afN.add(new a(aVar, iVar.index, iVar.index + 1));
    }

    private Drawable cp(String str) {
        return l.b(this.mContext, str, this.mRootDir);
    }

    private SpannableString d(SpannableString spannableString, i iVar) {
        String str;
        String string = spannableString.toString();
        int i = iVar.index;
        if (iVar.index <= 0) {
            str = "￼" + string;
        } else if (iVar.index > string.length()) {
            str = string + "￼";
        } else {
            for (a aVar : this.afN) {
                if ((aVar.afR instanceof ImageSpan) && iVar.index > aVar.vP) {
                    i++;
                }
            }
            str = string.substring(0, i) + "￼" + string.substring(i);
        }
        SpannableString spannableString2 = new SpannableString(str);
        if (this.afN.size() > 0) {
            for (a aVar2 : this.afN) {
                if (aVar2.afR instanceof ImageSpan) {
                    if (iVar.index <= aVar2.vP) {
                        aVar2.vP++;
                        aVar2.bU++;
                    } else {
                        iVar.index++;
                    }
                } else if (iVar.index > aVar2.vP && iVar.index < aVar2.bU) {
                    aVar2.bU++;
                } else if (iVar.index < aVar2.vP) {
                    aVar2.vP++;
                    aVar2.bU++;
                } else if (iVar.index == aVar2.vP) {
                    aVar2.vP++;
                    aVar2.bU++;
                } else if (iVar.index == aVar2.bU) {
                    aVar2.bU++;
                }
                spannableString2.setSpan(aVar2.afR, aVar2.vP, aVar2.bU, 17);
            }
        }
        return spannableString2;
    }

    private Drawable a(i iVar, TextView textView) {
        s sVar = new s();
        a(iVar, sVar, textView);
        return sVar;
    }
}
