package com.tk.core.component.c;

import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.framework.tachikoma.a;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.component.b;
import com.tk.core.component.c.b;
import com.tk.core.e.b;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.r;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class c extends com.tk.core.component.e<b> {
    public String KE;
    public String QM;
    private String acC;
    private String acD;
    private String acE;
    private int acH;
    private b.a acZ;
    public boolean adA;
    public String adB;
    public int adC;
    public String adD;
    public V8Function adE;
    public JsValueRef<V8Function> adF;
    public V8Function adG;
    public JsValueRef<V8Function> adH;
    public V8Function adI;
    public JsValueRef<V8Function> adJ;
    public V8Function adK;
    public JsValueRef<V8Function> adL;
    public V8Function adM;
    public JsValueRef<V8Function> adN;
    public V8Function adO;
    public JsValueRef<V8Function> adP;
    public V8Function adQ;
    public JsValueRef<V8Function> adR;
    public V8Function adS;
    public JsValueRef<V8Function> adT;
    public V8Function adU;
    public JsValueRef<V8Function> adV;
    protected final a ade;
    private String adf;
    private int adg;
    private int adh;
    private float adi;
    private int adj;
    private int adk;
    private boolean adl;
    private boolean adm;
    private boolean adn;
    private boolean ado;
    private ClipboardManager adp;
    private ClipboardManager.OnPrimaryClipChangedListener adq;
    private float adr;
    private float ads;
    public boolean adt;
    public boolean adu;
    public V8Function adv;
    public JsValueRef<V8Function> adw;
    private View.OnKeyListener adx;
    private View.OnFocusChangeListener ady;
    private TextView.OnEditorActionListener adz;
    public String value;
    private TextWatcher xe;

    protected boolean isSingleLine() {
        return true;
    }

    static /* synthetic */ int a(c cVar, int i) {
        cVar.adh = 0;
        return 0;
    }

    static /* synthetic */ boolean a(c cVar, boolean z) {
        cVar.ado = false;
        return false;
    }

    public final void ar(boolean z) {
        this.adu = z;
        setFocused(z);
    }

    public c(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.adf = "";
        this.adg = 0;
        this.adi = -1.0f;
        this.adk = -1;
        this.ado = false;
        this.adr = -1.0f;
        this.ads = -1.0f;
        this.xe = new TextWatcher() { // from class: com.tk.core.component.c.c.1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(final CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.adi < 0.0f) {
                    c cVar = c.this;
                    cVar.adi = cVar.pR().getYogaNode().getHeight().value;
                } else {
                    c.a(c.this, 0);
                }
                if (c.this.adi < 0.0f || Float.isNaN(c.this.adi)) {
                    c.this.adi = r2.getView().getMeasuredHeight();
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.1.1
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(charSequence.toString());
                            aVar.setState(1);
                        }
                    }
                });
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(final CharSequence charSequence, int i, int i2, int i3) {
                if (TextUtils.isEmpty(charSequence)) {
                    if (c.this.ads > 0.0f) {
                        c.this.getView().setTextSize(1, c.this.ads);
                    }
                } else if (c.this.adr > 0.0f) {
                    c.this.getView().setTextSize(1, c.this.adr);
                }
                if (c.this.ado) {
                    c.a(c.this, false);
                } else {
                    HashMap map = new HashMap();
                    map.put(com.alipay.sdk.m.p0.b.d, charSequence.toString());
                    HashMap map2 = new HashMap();
                    map2.put(TypedValues.AttributesType.S_TARGET, map);
                    map2.put("type", Config.INPUT_PART);
                    c cVar = c.this;
                    cVar.b(cVar.adJ, map2);
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.1.2
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(charSequence.toString());
                            aVar.setState(2);
                        }
                    }
                });
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(final Editable editable) {
                if (!c.this.isSingleLine()) {
                    int lineCount = c.this.getView().getLineCount();
                    if (lineCount == 0 || c.this.adg <= 0 || lineCount >= c.this.adj || lineCount < c.this.adh || lineCount >= c.this.adg) {
                        if (c.this.getView().getLineHeight() * lineCount > c.this.adi && c.this.adg > 0 && lineCount > c.this.adj && lineCount > c.this.adh && lineCount <= c.this.adg) {
                            c.this.pR().getYogaNode().dirty();
                            c.this.pR().getYogaNode().setMinHeight(c.this.adi);
                            c.this.pR().getYogaNode().setHeightAuto();
                            c.this.adj = lineCount;
                            c.this.ade.setLines(c.this.adj);
                            c.this.ade.setMinLines(c.this.adj);
                        }
                    } else {
                        c.this.pR().getYogaNode().dirty();
                        c.this.adj = lineCount;
                        c.this.ade.setLines(c.this.adj);
                        c.this.ade.setMinLines(c.this.adj);
                    }
                }
                if (c.this.adn) {
                    c.this.adn = false;
                    if (c.this.adR != null && ad.isV8Valid(c.this.adR.get())) {
                        HashMap map = new HashMap();
                        map.put(com.alipay.sdk.m.p0.b.d, c.this.rb());
                        HashMap map2 = new HashMap();
                        map2.put(TypedValues.AttributesType.S_TARGET, map);
                        map2.put("type", "paste");
                        c cVar = c.this;
                        cVar.b(cVar.adR, map2);
                    }
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.1.3
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(editable.toString());
                            aVar.setState(3);
                        }
                    }
                });
            }
        };
        this.adx = new View.OnKeyListener() { // from class: com.tk.core.component.c.c.2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    if (c.this.getView() == null || !TextUtils.isEmpty(c.this.getView().getText())) {
                        return false;
                    }
                    c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.2.1
                        @Override // com.tk.core.e.b.a
                        public final void a(com.tk.core.e.a.b bVar) {
                            if (bVar instanceof com.tk.core.e.c.a) {
                                com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                                aVar.bX(Config.INPUT_PART);
                                aVar.setText("");
                                aVar.setState(2);
                            }
                        }
                    });
                    return false;
                }
                if (i != 66 || keyEvent.getAction() != 0) {
                    return false;
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.2.2
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(c.this.getText());
                            aVar.setState(4);
                        }
                    }
                });
                return false;
            }
        };
        this.ady = new View.OnFocusChangeListener() { // from class: com.tk.core.component.c.c.3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    c cVar = c.this;
                    cVar.adt = true;
                    cVar.adu = true;
                    cVar.k(cVar.adF);
                } else {
                    c cVar2 = c.this;
                    cVar2.adt = false;
                    cVar2.adu = false;
                    cVar2.k(cVar2.adH);
                    String text = c.this.getText();
                    if (text != null && !text.equals(c.this.adf)) {
                        c.this.adf = text;
                        HashMap map = new HashMap();
                        map.put(com.alipay.sdk.m.p0.b.d, text);
                        HashMap map2 = new HashMap();
                        map2.put(TypedValues.AttributesType.S_TARGET, map);
                        map2.put("type", "change");
                        c cVar3 = c.this;
                        cVar3.b(cVar3.adL, map2);
                    }
                }
                if (c.this.adw == null || c.this.adw.get() == null || !ad.isV8Valid(c.this.adw.get())) {
                    return;
                }
                try {
                    c.this.adw.get().call(null, Boolean.valueOf(z));
                } catch (Throwable th) {
                    com.tk.core.exception.a.b(th, c.this.pP().pg());
                }
            }
        };
        this.adz = new TextView.OnEditorActionListener() { // from class: com.tk.core.component.c.c.4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                    z = i == 5;
                    String text = c.this.getText();
                    if (text != null && !text.equals(c.this.adf)) {
                        c.this.adf = text;
                        HashMap map = new HashMap();
                        map.put(com.alipay.sdk.m.p0.b.d, text);
                        HashMap map2 = new HashMap();
                        map2.put(TypedValues.AttributesType.S_TARGET, map);
                        map2.put("type", "change");
                        c cVar = c.this;
                        cVar.b(cVar.adL, map2);
                    }
                    if (c.this.isSingleLine()) {
                        HashMap map3 = new HashMap();
                        map3.put(com.alipay.sdk.m.p0.b.d, "Enter");
                        HashMap map4 = new HashMap();
                        map4.put(TypedValues.AttributesType.S_TARGET, map3);
                        map4.put("type", "keyPress");
                        c cVar2 = c.this;
                        cVar2.b(cVar2.adV, map4);
                        HashMap map5 = new HashMap();
                        if (text == null) {
                            text = "";
                        }
                        map5.put(com.alipay.sdk.m.p0.b.d, text);
                        HashMap map6 = new HashMap();
                        map6.put(TypedValues.AttributesType.S_TARGET, map5);
                        map6.put("type", "submit");
                        c cVar3 = c.this;
                        cVar3.b(cVar3.adT, map6);
                    }
                }
                return z;
            }
        };
        this.ade = new a(getView(), isSingleLine());
        qY();
    }

    public c(NativeModuleInitParams nativeModuleInitParams, boolean z) {
        super(nativeModuleInitParams, true);
        this.adf = "";
        this.adg = 0;
        this.adi = -1.0f;
        this.adk = -1;
        this.ado = false;
        this.adr = -1.0f;
        this.ads = -1.0f;
        this.xe = new TextWatcher() { // from class: com.tk.core.component.c.c.1
            @Override // android.text.TextWatcher
            public final void beforeTextChanged(final CharSequence charSequence, int i, int i2, int i3) {
                if (c.this.adi < 0.0f) {
                    c cVar = c.this;
                    cVar.adi = cVar.pR().getYogaNode().getHeight().value;
                } else {
                    c.a(c.this, 0);
                }
                if (c.this.adi < 0.0f || Float.isNaN(c.this.adi)) {
                    c.this.adi = r2.getView().getMeasuredHeight();
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.1.1
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(charSequence.toString());
                            aVar.setState(1);
                        }
                    }
                });
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(final CharSequence charSequence, int i, int i2, int i3) {
                if (TextUtils.isEmpty(charSequence)) {
                    if (c.this.ads > 0.0f) {
                        c.this.getView().setTextSize(1, c.this.ads);
                    }
                } else if (c.this.adr > 0.0f) {
                    c.this.getView().setTextSize(1, c.this.adr);
                }
                if (c.this.ado) {
                    c.a(c.this, false);
                } else {
                    HashMap map = new HashMap();
                    map.put(com.alipay.sdk.m.p0.b.d, charSequence.toString());
                    HashMap map2 = new HashMap();
                    map2.put(TypedValues.AttributesType.S_TARGET, map);
                    map2.put("type", Config.INPUT_PART);
                    c cVar = c.this;
                    cVar.b(cVar.adJ, map2);
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.1.2
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(charSequence.toString());
                            aVar.setState(2);
                        }
                    }
                });
            }

            @Override // android.text.TextWatcher
            public final void afterTextChanged(final Editable editable) {
                if (!c.this.isSingleLine()) {
                    int lineCount = c.this.getView().getLineCount();
                    if (lineCount == 0 || c.this.adg <= 0 || lineCount >= c.this.adj || lineCount < c.this.adh || lineCount >= c.this.adg) {
                        if (c.this.getView().getLineHeight() * lineCount > c.this.adi && c.this.adg > 0 && lineCount > c.this.adj && lineCount > c.this.adh && lineCount <= c.this.adg) {
                            c.this.pR().getYogaNode().dirty();
                            c.this.pR().getYogaNode().setMinHeight(c.this.adi);
                            c.this.pR().getYogaNode().setHeightAuto();
                            c.this.adj = lineCount;
                            c.this.ade.setLines(c.this.adj);
                            c.this.ade.setMinLines(c.this.adj);
                        }
                    } else {
                        c.this.pR().getYogaNode().dirty();
                        c.this.adj = lineCount;
                        c.this.ade.setLines(c.this.adj);
                        c.this.ade.setMinLines(c.this.adj);
                    }
                }
                if (c.this.adn) {
                    c.this.adn = false;
                    if (c.this.adR != null && ad.isV8Valid(c.this.adR.get())) {
                        HashMap map = new HashMap();
                        map.put(com.alipay.sdk.m.p0.b.d, c.this.rb());
                        HashMap map2 = new HashMap();
                        map2.put(TypedValues.AttributesType.S_TARGET, map);
                        map2.put("type", "paste");
                        c cVar = c.this;
                        cVar.b(cVar.adR, map2);
                    }
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.1.3
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(editable.toString());
                            aVar.setState(3);
                        }
                    }
                });
            }
        };
        this.adx = new View.OnKeyListener() { // from class: com.tk.core.component.c.c.2
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i == 67 && keyEvent.getAction() == 0) {
                    if (c.this.getView() == null || !TextUtils.isEmpty(c.this.getView().getText())) {
                        return false;
                    }
                    c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.2.1
                        @Override // com.tk.core.e.b.a
                        public final void a(com.tk.core.e.a.b bVar) {
                            if (bVar instanceof com.tk.core.e.c.a) {
                                com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                                aVar.bX(Config.INPUT_PART);
                                aVar.setText("");
                                aVar.setState(2);
                            }
                        }
                    });
                    return false;
                }
                if (i != 66 || keyEvent.getAction() != 0) {
                    return false;
                }
                c.this.a(Config.INPUT_PART, new b.a() { // from class: com.tk.core.component.c.c.2.2
                    @Override // com.tk.core.e.b.a
                    public final void a(com.tk.core.e.a.b bVar) {
                        if (bVar instanceof com.tk.core.e.c.a) {
                            com.tk.core.e.c.a aVar = (com.tk.core.e.c.a) bVar;
                            aVar.bX(Config.INPUT_PART);
                            aVar.setText(c.this.getText());
                            aVar.setState(4);
                        }
                    }
                });
                return false;
            }
        };
        this.ady = new View.OnFocusChangeListener() { // from class: com.tk.core.component.c.c.3
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z2) {
                if (z2) {
                    c cVar = c.this;
                    cVar.adt = true;
                    cVar.adu = true;
                    cVar.k(cVar.adF);
                } else {
                    c cVar2 = c.this;
                    cVar2.adt = false;
                    cVar2.adu = false;
                    cVar2.k(cVar2.adH);
                    String text = c.this.getText();
                    if (text != null && !text.equals(c.this.adf)) {
                        c.this.adf = text;
                        HashMap map = new HashMap();
                        map.put(com.alipay.sdk.m.p0.b.d, text);
                        HashMap map2 = new HashMap();
                        map2.put(TypedValues.AttributesType.S_TARGET, map);
                        map2.put("type", "change");
                        c cVar3 = c.this;
                        cVar3.b(cVar3.adL, map2);
                    }
                }
                if (c.this.adw == null || c.this.adw.get() == null || !ad.isV8Valid(c.this.adw.get())) {
                    return;
                }
                try {
                    c.this.adw.get().call(null, Boolean.valueOf(z2));
                } catch (Throwable th) {
                    com.tk.core.exception.a.b(th, c.this.pP().pg());
                }
            }
        };
        this.adz = new TextView.OnEditorActionListener() { // from class: com.tk.core.component.c.c.4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                    z = i == 5;
                    String text = c.this.getText();
                    if (text != null && !text.equals(c.this.adf)) {
                        c.this.adf = text;
                        HashMap map = new HashMap();
                        map.put(com.alipay.sdk.m.p0.b.d, text);
                        HashMap map2 = new HashMap();
                        map2.put(TypedValues.AttributesType.S_TARGET, map);
                        map2.put("type", "change");
                        c cVar = c.this;
                        cVar.b(cVar.adL, map2);
                    }
                    if (c.this.isSingleLine()) {
                        HashMap map3 = new HashMap();
                        map3.put(com.alipay.sdk.m.p0.b.d, "Enter");
                        HashMap map4 = new HashMap();
                        map4.put(TypedValues.AttributesType.S_TARGET, map3);
                        map4.put("type", "keyPress");
                        c cVar2 = c.this;
                        cVar2.b(cVar2.adV, map4);
                        HashMap map5 = new HashMap();
                        if (text == null) {
                            text = "";
                        }
                        map5.put(com.alipay.sdk.m.p0.b.d, text);
                        HashMap map6 = new HashMap();
                        map6.put(TypedValues.AttributesType.S_TARGET, map5);
                        map6.put("type", "submit");
                        c cVar3 = c.this;
                        cVar3.b(cVar3.adT, map6);
                    }
                }
                return z;
            }
        };
        this.ade = new a(getView(), isSingleLine());
        qY();
    }

    private void qY() {
        getView().addTextChangedListener(this.xe);
        getView().setOnKeyListener(this.adx);
        getView().setOnFocusChangeListener(this.ady);
        getView().setOnEditorActionListener(this.adz);
    }

    @Override // com.tk.core.component.e
    public final boolean mJ() {
        if (com.tk.core.component.e.qv()) {
            return true;
        }
        return (Build.VERSION.SDK_INT == 27 || Build.VERSION.SDK_INT == 30 || Build.VERSION.SDK_INT == 25) ? false : true;
    }

    @Override // com.tk.core.component.e
    public final boolean qr() {
        return !com.tk.core.component.e.qv();
    }

    @Override // com.tk.core.component.e
    public final void a(HashMap map) {
        f(map);
        super.a(map);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        if (z) {
            nj();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.core.component.c.c.5
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.nj();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nj() {
        ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener;
        if (pQ()) {
            getView().removeTextChangedListener(this.xe);
            getView().setOnKeyListener(null);
            getView().setOnEditorActionListener(null);
            if (this.acZ != null) {
                getView().setMenuOptionListener(null);
            }
        }
        ClipboardManager clipboardManager = this.adp;
        if (clipboardManager == null || (onPrimaryClipChangedListener = this.adq) == null) {
            return;
        }
        clipboardManager.removePrimaryClipChangedListener(onPrimaryClipChangedListener);
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        ad.unRetainJsValue(this.adw);
        ad.unRetainJsValue(this.adF);
        ad.unRetainJsValue(this.adH);
        ad.unRetainJsValue(this.adJ);
        ad.unRetainJsValue(this.adL);
        ad.unRetainJsValue(this.adN);
        ad.unRetainJsValue(this.adP);
        ad.unRetainJsValue(this.adR);
        ad.unRetainJsValue(this.adT);
        ad.unRetainJsValue(this.adV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.tk.core.component.e
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public b n(Context context) {
        b bVar;
        if (isSingleLine()) {
            bVar = new b(context);
        } else {
            bVar = new b(new ContextThemeWrapper(context, a.d.scrollbar_style));
        }
        bVar.setBackground(null);
        bVar.setIsSingleLine(isSingleLine());
        return bVar;
    }

    public final String getText() {
        return this.ade.getText();
    }

    public final void setText(String str) {
        this.KE = str;
        if (str == null) {
            str = "";
        }
        if (str.equals(this.ade.getText())) {
            return;
        }
        this.ado = true;
        this.ade.setText(this.KE);
    }

    public final void as(String str) {
        this.QM = str;
        this.ade.as(this.QM);
    }

    public final void setFocused(boolean z) {
        this.adt = z;
        this.ade.setFocused(this.adt);
    }

    public final void bX(String str) {
        this.ade.bX(str);
    }

    public final void aj(String str) {
        Integer numValueOf = Integer.valueOf(r.a(str, pP()));
        if (numValueOf == null) {
            return;
        }
        this.ade.setTextColor(numValueOf.intValue());
    }

    public final void cc(String str) {
        Integer numValueOf = Integer.valueOf(r.a(str, pP()));
        if (numValueOf == null) {
            return;
        }
        this.ade.dG(numValueOf.intValue());
    }

    public final void cd(String str) {
        Integer numValueOf = Integer.valueOf(r.a(str, pP()));
        if (numValueOf == null) {
            return;
        }
        this.ade.dH(numValueOf.intValue());
    }

    public final void al(String str) {
        this.ade.al(str);
    }

    public final void ak(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.acC)) {
            return;
        }
        this.acH++;
        this.acC = str;
        rd();
    }

    public final void bS(String str) {
        if (TextUtils.isEmpty(str) || str.equals(this.acD)) {
            return;
        }
        this.acD = str;
        rd();
    }

    public final void bT(String str) {
        String str2 = this.acE;
        if (str2 == null || !str2.equals(str)) {
            this.acE = str;
            rd();
        }
    }

    public final void H(float f) {
        if (this.adr == f) {
            return;
        }
        this.adr = f;
        if (TextUtils.isEmpty(getText())) {
            return;
        }
        getView().setTextSize(1, f);
    }

    public final void I(float f) {
        this.ads = f;
        if (TextUtils.isEmpty(getText())) {
            getView().setTextSize(1, f);
        }
    }

    public final void setMaxLength(int i) {
        this.ade.setMaxLength(i);
    }

    public final void ca(String str) {
        this.ade.ca(str);
    }

    public final void clear() {
        this.ade.setText("");
    }

    public final void clearFocus() {
        this.ade.setFocused(false);
    }

    public final void aI(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        ad.unRetainJsValue(this.adw);
        this.adv = v8Function;
        this.adw = jsValueRefRetainJsValue;
    }

    public final void qZ() {
        setFocused(true);
    }

    public final void ra() {
        setFocused(false);
    }

    public final void setValue(String str) {
        this.value = str;
        if (str == null) {
            str = "";
        }
        if (str.equals(this.ade.getText())) {
            return;
        }
        this.ado = true;
        this.ade.setText(str);
    }

    public final void setReadOnly(boolean z) {
        this.adA = z;
        if (z) {
            getView().removeTextChangedListener(this.xe);
            getView().setOnKeyListener(null);
            getView().setOnFocusChangeListener(null);
            getView().setOnEditorActionListener(null);
            this.ade.setKeyListener(null);
            getView().setTextIsSelectable(true);
            return;
        }
        getView().addTextChangedListener(this.xe);
        getView().setOnKeyListener(this.adx);
        getView().setOnFocusChangeListener(this.ady);
        getView().setOnEditorActionListener(this.adz);
        a aVar = this.ade;
        aVar.setKeyListener(aVar.getKeyListener());
    }

    public final void ce(String str) {
        this.adB = str;
        this.ade.bX(str);
    }

    public final void dI(int i) {
        this.adC = i;
        this.ade.setMaxLength(i);
    }

    public final void cf(String str) {
        this.adD = str;
        this.ade.ca(str);
    }

    public final void aJ(V8Function v8Function) {
        ad.unRetainJsValue(this.adF);
        this.adF = ad.retainJsValue(v8Function, this);
        this.adE = v8Function;
    }

    public final void aK(V8Function v8Function) {
        ad.unRetainJsValue(this.adH);
        this.adH = ad.retainJsValue(v8Function, this);
        this.adG = v8Function;
    }

    public final void aL(V8Function v8Function) {
        ad.unRetainJsValue(this.adJ);
        this.adJ = ad.retainJsValue(v8Function, this);
        this.adI = v8Function;
    }

    public final void aM(V8Function v8Function) {
        ad.unRetainJsValue(this.adL);
        this.adL = ad.retainJsValue(v8Function, this);
        this.adK = v8Function;
    }

    public final void aN(V8Function v8Function) {
        rc();
        ad.unRetainJsValue(this.adN);
        this.adN = ad.retainJsValue(v8Function, this);
        this.adM = v8Function;
    }

    public final void aO(V8Function v8Function) {
        rc();
        ad.unRetainJsValue(this.adP);
        this.adP = ad.retainJsValue(v8Function, this);
        this.adO = v8Function;
    }

    public final void aP(V8Function v8Function) {
        rc();
        ad.unRetainJsValue(this.adR);
        this.adR = ad.retainJsValue(v8Function, this);
        this.adQ = v8Function;
    }

    public final void aQ(V8Function v8Function) {
        ad.unRetainJsValue(this.adT);
        this.adT = ad.retainJsValue(v8Function, this);
        this.adS = v8Function;
    }

    public final void aR(V8Function v8Function) {
        ad.unRetainJsValue(this.adV);
        this.adV = ad.retainJsValue(v8Function, this);
        this.adU = v8Function;
        getView().setOnKeyPressRef(this.adV);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(JsValueRef<V8Function> jsValueRef) {
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            jsValueRef.get().call(null, new Object[0]);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JsValueRef<V8Function> jsValueRef, Object obj) {
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            return;
        }
        try {
            jsValueRef.get().call(null, obj);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(pO(), th);
        }
    }

    protected final void dJ(int i) {
        this.adg = i;
        int i2 = this.adk;
        if (i2 <= 0 || this.adg <= i2) {
            return;
        }
        this.adg = i2;
    }

    protected final void dK(int i) {
        this.adh = i;
        this.ade.setLines(i);
        this.ade.setMinLines(i);
    }

    protected final void setMaxLines(int i) {
        this.adk = i;
        int i2 = this.adk;
        if (i2 <= 0 || this.adg <= i2) {
            return;
        }
        this.adg = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String rb() {
        return (this.adp.getPrimaryClip() == null || this.adp.getPrimaryClip().getItemCount() <= 0 || this.adp.getPrimaryClip().getItemAt(0) == null || this.adp.getPrimaryClip().getItemAt(0).getText() == null) ? "" : this.adp.getPrimaryClip().getItemAt(0).getText().toString();
    }

    private void rc() {
        if (this.acZ == null) {
            this.acZ = new b.a() { // from class: com.tk.core.component.c.c.6
                @Override // com.tk.core.component.c.b.a
                public final void qV() {
                    c.this.adl = true;
                }

                @Override // com.tk.core.component.c.b.a
                public final void qW() {
                    c.this.adm = true;
                }

                @Override // com.tk.core.component.c.b.a
                public final void qX() {
                    c.this.adn = true;
                }
            };
            getView().setMenuOptionListener(this.acZ);
        }
        if (this.adq == null) {
            this.adq = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.tk.core.component.c.c.7
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    if (c.this.adl) {
                        c.this.adl = false;
                        if (c.this.adN != null && ad.isV8Valid(c.this.adN.get())) {
                            HashMap map = new HashMap();
                            map.put(com.alipay.sdk.m.p0.b.d, c.this.rb());
                            HashMap map2 = new HashMap();
                            map2.put(TypedValues.AttributesType.S_TARGET, map);
                            map2.put("type", "copy");
                            c cVar = c.this;
                            cVar.b(cVar.adN, map2);
                        }
                    }
                    if (c.this.adm) {
                        c.this.adm = false;
                        if (c.this.adP == null || !ad.isV8Valid(c.this.adP.get())) {
                            return;
                        }
                        HashMap map3 = new HashMap();
                        map3.put(com.alipay.sdk.m.p0.b.d, c.this.rb());
                        HashMap map4 = new HashMap();
                        map4.put(TypedValues.AttributesType.S_TARGET, map3);
                        map4.put("type", "cut");
                        c cVar2 = c.this;
                        cVar2.b(cVar2.adP, map4);
                    }
                }
            };
            this.adp = (ClipboardManager) getContext().getSystemService("clipboard");
            this.adp.addPrimaryClipChangedListener(this.adq);
        }
    }

    private void rd() {
        com.tk.core.component.b.a(getView(), this.acC, this.acD, this.acE, pn(), pR().getYogaNode(), pq(), getVersionCode(), this.acH, new b.a() { // from class: com.tk.core.component.c.c.8
            @Override // com.tk.core.component.b.a
            public final void a(Typeface typeface, int i, int i2) {
                if (c.this.pN() || c.this.acH != i2) {
                    return;
                }
                c.this.getView().setTypeface(typeface, i);
            }
        });
    }
}
