package com.tk.core.component.c;

import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.util.LinkedList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private static final InputFilter[] acP = new InputFilter[0];
    private final EditText acO;
    private boolean acQ;
    private C0818a acR = new C0818a(0);
    private int acS;
    private int acT;
    private KeyListener acU;

    public a(EditText editText, boolean z) {
        this.acQ = z;
        this.acO = editText;
        this.acO.setPadding(0, 0, 0, 0);
        if (z) {
            this.acO.setMaxLines(1);
            this.acO.setImeOptions(6);
        } else {
            this.acO.setSingleLine(false);
        }
        aP(z ? 131072 : 0, z ? 0 : 131072);
        this.acT = editText.getInputType();
        if (!this.acQ) {
            this.acO.addTextChangedListener(this.acR);
        }
        this.acU = this.acO.getKeyListener();
    }

    public final void setText(String str) {
        this.acO.setText(str);
        if (this.acO.hasFocus()) {
            EditText editText = this.acO;
            editText.setSelection(editText.getText().length());
        }
    }

    public final String getText() {
        return this.acO.getText().toString();
    }

    public final void as(String str) {
        this.acO.setHint(str);
    }

    public final void bX(String str) {
        if ("password".equals(str)) {
            aP(144, 128);
        } else {
            aP(15, bY(str));
        }
        if (this.acQ) {
            return;
        }
        this.acO.setSingleLine(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int bY(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1034364087(0xffffffffc258db49, float:-54.214146)
            r2 = 1
            r3 = 2
            if (r0 == r1) goto L2a
            r1 = 114715(0x1c01b, float:1.6075E-40)
            if (r0 == r1) goto L20
            r1 = 96619420(0x5c24b9c, float:1.8271447E-35)
            if (r0 == r1) goto L16
            goto L34
        L16:
            java.lang.String r0 = "email"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 0
            goto L35
        L20:
            java.lang.String r0 = "tel"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 2
            goto L35
        L2a:
            java.lang.String r0 = "number"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L34
            r5 = 1
            goto L35
        L34:
            r5 = -1
        L35:
            if (r5 == 0) goto L40
            if (r5 == r2) goto L42
            if (r5 == r3) goto L3e
            int r3 = r4.acT
            goto L42
        L3e:
            r3 = 3
            goto L42
        L40:
            r3 = 32
        L42:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.a.bY(java.lang.String):int");
    }

    public final void setTextColor(int i) {
        this.acO.setTextColor(i);
    }

    public final void dG(int i) {
        this.acO.setHintTextColor(i);
    }

    public final void dH(int i) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
        Class<?> type;
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i2 = declaredField.getInt(this.acO);
            if (i2 == 0) {
                return;
            }
            Drawable drawableA = android.support.v4.content.a.a(this.acO.getContext(), i2);
            drawableA.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            Drawable[] drawableArr = {drawableA, drawableA};
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(this.acO);
            if (Build.VERSION.SDK_INT < 16) {
                type = TextView.class;
            } else {
                Field declaredField3 = TextView.class.getDeclaredField("mEditor");
                declaredField3.setAccessible(true);
                type = declaredField3.getType();
            }
            if (Build.VERSION.SDK_INT >= 28) {
                Field declaredField4 = type.getDeclaredField("mDrawableForCursor");
                declaredField4.setAccessible(true);
                declaredField4.set(obj, drawableA);
            } else {
                Field declaredField5 = type.getDeclaredField("mCursorDrawable");
                declaredField5.setAccessible(true);
                declaredField5.set(obj, drawableArr);
            }
        } catch (IllegalAccessException | NoSuchFieldException unused) {
        }
    }

    public final void al(String str) {
        this.acO.setGravity(bZ(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int bZ(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            r1 = -1364013995(0xffffffffaeb2cc55, float:-8.1307995E-11)
            r2 = 1
            if (r0 == r1) goto L1a
            r1 = 108511772(0x677c21c, float:4.6598146E-35)
            if (r0 == r1) goto L10
            goto L24
        L10:
            java.lang.String r0 = "right"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L24
            r4 = 1
            goto L25
        L1a:
            java.lang.String r0 = "center"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L24
            r4 = 0
            goto L25
        L24:
            r4 = -1
        L25:
            if (r4 == 0) goto L3b
            if (r4 == r2) goto L32
            boolean r4 = r3.acQ
            if (r4 == 0) goto L30
            r4 = 19
            return r4
        L30:
            r4 = 3
            return r4
        L32:
            boolean r4 = r3.acQ
            if (r4 == 0) goto L39
            r4 = 21
            return r4
        L39:
            r4 = 5
            return r4
        L3b:
            boolean r4 = r3.acQ
            if (r4 == 0) goto L42
            r4 = 17
            return r4
        L42:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.a.bZ(java.lang.String):int");
    }

    public final void setMaxLength(int i) {
        InputFilter[] filters = this.acO.getFilters();
        InputFilter[] inputFilterArr = acP;
        if (i == 0) {
            if (filters.length > 0) {
                LinkedList linkedList = new LinkedList();
                for (int i2 = 0; i2 < filters.length; i2++) {
                    if (!(filters[i2] instanceof InputFilter.LengthFilter)) {
                        linkedList.add(filters[i2]);
                    }
                }
                if (!linkedList.isEmpty()) {
                    inputFilterArr = (InputFilter[]) linkedList.toArray(new InputFilter[linkedList.size()]);
                }
            }
        } else if (filters.length > 0) {
            boolean z = false;
            for (int i3 = 0; i3 < filters.length; i3++) {
                if (filters[i3] instanceof InputFilter.LengthFilter) {
                    filters[i3] = new InputFilter.LengthFilter(i);
                    z = true;
                }
            }
            if (z) {
                inputFilterArr = filters;
            } else {
                inputFilterArr = new InputFilter[filters.length + 1];
                System.arraycopy(filters, 0, inputFilterArr, 0, filters.length);
                filters[filters.length] = new InputFilter.LengthFilter(i);
            }
        } else {
            inputFilterArr = new InputFilter[]{new InputFilter.LengthFilter(i)};
        }
        this.acO.setFilters(inputFilterArr);
    }

    public final void setMaxLines(int i) {
        this.acR.setMaxLines(i);
    }

    public final void ca(String str) {
        this.acO.setImeOptions(cb(str));
        InputMethodManager inputMethodManager = (InputMethodManager) this.acO.getContext().getSystemService("input_method");
        if (inputMethodManager == null || !inputMethodManager.isActive()) {
            return;
        }
        inputMethodManager.restartInput(this.acO);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int cb(java.lang.String r5) {
        /*
            int r0 = r5.hashCode()
            r1 = -906336856(0xffffffffc9fa65a8, float:-2051253.0)
            r2 = 1
            r3 = 3
            r4 = 2
            if (r0 == r1) goto L39
            r1 = 3304(0xce8, float:4.63E-42)
            if (r0 == r1) goto L2f
            r1 = 3377907(0x338af3, float:4.733456E-39)
            if (r0 == r1) goto L25
            r1 = 3526536(0x35cf88, float:4.94173E-39)
            if (r0 == r1) goto L1b
            goto L43
        L1b:
            java.lang.String r0 = "send"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L43
            r5 = 2
            goto L44
        L25:
            java.lang.String r0 = "next"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L43
            r5 = 3
            goto L44
        L2f:
            java.lang.String r0 = "go"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L43
            r5 = 0
            goto L44
        L39:
            java.lang.String r0 = "search"
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L43
            r5 = 1
            goto L44
        L43:
            r5 = -1
        L44:
            if (r5 == 0) goto L53
            if (r5 == r2) goto L52
            if (r5 == r4) goto L50
            if (r5 == r3) goto L4e
            r5 = 6
            return r5
        L4e:
            r5 = 5
            return r5
        L50:
            r5 = 4
            return r5
        L52:
            return r3
        L53:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.c.a.cb(java.lang.String):int");
    }

    public final void setFocused(boolean z) {
        final InputMethodManager inputMethodManager = (InputMethodManager) this.acO.getContext().getSystemService("input_method");
        if (z) {
            this.acO.post(new Runnable() { // from class: com.tk.core.component.c.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.acO.requestFocus();
                    InputMethodManager inputMethodManager2 = inputMethodManager;
                    if (inputMethodManager2 != null) {
                        inputMethodManager2.showSoftInput(a.this.acO, 2);
                    }
                }
            });
        } else {
            this.acO.post(new Runnable() { // from class: com.tk.core.component.c.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    a.bb(a.this.acO);
                    a.this.acO.clearFocus();
                    InputMethodManager inputMethodManager2 = inputMethodManager;
                    if (inputMethodManager2 != null) {
                        inputMethodManager2.hideSoftInputFromWindow(a.this.acO.getWindowToken(), 0);
                    }
                }
            });
        }
    }

    /* renamed from: com.tk.core.component.c.a$a, reason: collision with other inner class name */
    class C0818a implements TextWatcher {
        String acX = "";
        boolean acY = false;
        int maxLines = 0;

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public C0818a(int i) {
        }

        public final void setMaxLines(int i) {
            this.maxLines = i;
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.acY = true;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable editable) {
            if (this.maxLines > 0) {
                int lineCount = a.this.acO.getLineCount();
                if (lineCount != 0 || this.acY) {
                    this.acY = false;
                    if (lineCount > this.maxLines) {
                        a.this.acO.removeTextChangedListener(this);
                        a.this.acO.setText(this.acX);
                        a.this.acO.addTextChangedListener(this);
                        a.this.acO.setSelection(this.acX.length());
                        return;
                    }
                    this.acX = editable != null ? editable.toString() : "";
                }
            }
        }
    }

    public final void setKeyListener(KeyListener keyListener) {
        this.acO.setKeyListener(keyListener);
    }

    public final KeyListener getKeyListener() {
        return this.acU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void bb(View view) {
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (Build.VERSION.SDK_INT >= 26) {
                viewGroup.setDefaultFocusHighlightEnabled(false);
            }
            viewGroup.setFocusable(true);
            viewGroup.setFocusableInTouchMode(true);
            viewGroup.requestFocus();
        }
    }

    public final void setLines(int i) {
        this.acO.setLines(i);
    }

    public final void setMinLines(int i) {
        this.acO.setMinLines(i);
    }

    private void aP(int i, int i2) {
        if (this.acS == 0) {
            this.acS = this.acO.getInputType();
        }
        this.acS = ((i ^ (-1)) & this.acS) | i2;
        this.acO.setInputType(this.acS);
    }
}
