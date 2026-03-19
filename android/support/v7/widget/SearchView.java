package android.support.v7.widget;

import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.a.a;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.ttm.utils.AVLogger;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class SearchView extends ac implements android.support.v7.view.b {
    static final a tG = new a();
    private final View.OnClickListener mOnClickListener;
    final SearchAutoComplete sQ;
    private final View sR;
    private final View sS;
    private final View sT;
    final ImageView sU;
    final ImageView sV;
    final ImageView sW;
    final ImageView sX;
    private final View sY;
    private f sZ;
    private CharSequence tA;
    private CharSequence tB;
    private boolean tC;
    private int tD;
    SearchableInfo tE;
    private Bundle tF;
    private final Runnable tH;
    private Runnable tI;
    private final WeakHashMap<String, Drawable.ConstantState> tJ;
    View.OnKeyListener tK;
    private final TextView.OnEditorActionListener tL;
    private final AdapterView.OnItemClickListener tM;
    private final AdapterView.OnItemSelectedListener tN;
    private TextWatcher tO;
    private Rect ta;
    private Rect tb;
    private int[] tc;
    private int[] td;
    private final ImageView te;
    private final Drawable tf;
    private final int tg;
    private final int th;
    private final Intent ti;
    private final Intent tj;
    private final CharSequence tk;
    private c tl;
    private b tm;
    View.OnFocusChangeListener tn;
    private d tp;
    private View.OnClickListener tq;
    private boolean tr;
    private boolean ts;
    android.support.v4.widget.c tt;
    private boolean tu;
    private CharSequence tv;
    private boolean tw;
    private boolean tx;
    private int ty;
    private boolean tz;

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface b {
        boolean onClose();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface c {
        boolean eJ();
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public interface d {
        boolean eK();

        boolean eL();
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.C0010a.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ta = new Rect();
        this.tb = new Rect();
        this.tc = new int[2];
        this.td = new int[2];
        this.tH = new Runnable() { // from class: android.support.v7.widget.SearchView.1
            @Override // java.lang.Runnable
            public final void run() {
                SearchView.this.ey();
            }
        };
        this.tI = new Runnable() { // from class: android.support.v7.widget.SearchView.3
            @Override // java.lang.Runnable
            public final void run() {
                if (SearchView.this.tt == null || !(SearchView.this.tt instanceof aq)) {
                    return;
                }
                SearchView.this.tt.changeCursor(null);
            }
        };
        this.tJ = new WeakHashMap<>();
        this.mOnClickListener = new View.OnClickListener() { // from class: android.support.v7.widget.SearchView.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
                if (view == SearchView.this.sU) {
                    SearchView.this.eE();
                    return;
                }
                if (view == SearchView.this.sW) {
                    SearchView.this.eD();
                    return;
                }
                if (view == SearchView.this.sV) {
                    SearchView.this.eB();
                } else if (view == SearchView.this.sX) {
                    SearchView.this.eF();
                } else if (view == SearchView.this.sQ) {
                    SearchView.this.eI();
                }
            }
        };
        this.tK = new View.OnKeyListener() { // from class: android.support.v7.widget.SearchView.7
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
                if (SearchView.this.tE == null) {
                    return false;
                }
                if (SearchView.this.sQ.isPopupShowing() && SearchView.this.sQ.getListSelection() != -1) {
                    return SearchView.this.b(i2, keyEvent);
                }
                if (SearchView.this.sQ.isEmpty() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i2 != 66) {
                    return false;
                }
                view.cancelLongPress();
                SearchView searchView = SearchView.this;
                searchView.b(0, null, searchView.sQ.getText().toString());
                return true;
            }
        };
        this.tL = new TextView.OnEditorActionListener() { // from class: android.support.v7.widget.SearchView.8
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
                SearchView.this.eB();
                return true;
            }
        };
        this.tM = new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.SearchView.9
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.aC(i2);
            }
        };
        this.tN = new AdapterView.OnItemSelectedListener() { // from class: android.support.v7.widget.SearchView.10
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onNothingSelected(AdapterView<?> adapterView) {
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                SearchView.this.aD(i2);
            }
        };
        this.tO = new TextWatcher() { // from class: android.support.v7.widget.SearchView.2
            @Override // android.text.TextWatcher
            public final void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                SearchView.this.g(charSequence);
            }
        };
        av avVarA = av.a(context, attributeSet, a.j.SearchView, i, 0);
        LayoutInflater.from(context).inflate(avVarA.getResourceId(a.j.SearchView_layout, a.g.abc_search_view), (ViewGroup) this, true);
        this.sQ = (SearchAutoComplete) findViewById(a.f.search_src_text);
        this.sQ.setSearchView(this);
        this.sR = findViewById(a.f.search_edit_frame);
        this.sS = findViewById(a.f.search_plate);
        this.sT = findViewById(a.f.submit_area);
        this.sU = (ImageView) findViewById(a.f.search_button);
        this.sV = (ImageView) findViewById(a.f.search_go_btn);
        this.sW = (ImageView) findViewById(a.f.search_close_btn);
        this.sX = (ImageView) findViewById(a.f.search_voice_btn);
        this.te = (ImageView) findViewById(a.f.search_mag_icon);
        android.support.v4.e.o.a(this.sS, avVarA.getDrawable(a.j.SearchView_queryBackground));
        android.support.v4.e.o.a(this.sT, avVarA.getDrawable(a.j.SearchView_submitBackground));
        this.sU.setImageDrawable(avVarA.getDrawable(a.j.SearchView_searchIcon));
        this.sV.setImageDrawable(avVarA.getDrawable(a.j.SearchView_goIcon));
        this.sW.setImageDrawable(avVarA.getDrawable(a.j.SearchView_closeIcon));
        this.sX.setImageDrawable(avVarA.getDrawable(a.j.SearchView_voiceIcon));
        this.te.setImageDrawable(avVarA.getDrawable(a.j.SearchView_searchIcon));
        this.tf = avVarA.getDrawable(a.j.SearchView_searchHintIcon);
        ax.a(this.sU, getResources().getString(a.h.abc_searchview_description_search));
        this.tg = avVarA.getResourceId(a.j.SearchView_suggestionRowLayout, a.g.abc_search_dropdown_item_icons_2line);
        this.th = avVarA.getResourceId(a.j.SearchView_commitIcon, 0);
        this.sU.setOnClickListener(this.mOnClickListener);
        this.sW.setOnClickListener(this.mOnClickListener);
        this.sV.setOnClickListener(this.mOnClickListener);
        this.sX.setOnClickListener(this.mOnClickListener);
        this.sQ.setOnClickListener(this.mOnClickListener);
        this.sQ.addTextChangedListener(this.tO);
        this.sQ.setOnEditorActionListener(this.tL);
        this.sQ.setOnItemClickListener(this.tM);
        this.sQ.setOnItemSelectedListener(this.tN);
        this.sQ.setOnKeyListener(this.tK);
        this.sQ.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: android.support.v7.widget.SearchView.4
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z) {
                if (SearchView.this.tn != null) {
                    SearchView.this.tn.onFocusChange(SearchView.this, z);
                }
            }
        });
        setIconifiedByDefault(avVarA.getBoolean(a.j.SearchView_iconifiedByDefault, true));
        int dimensionPixelSize = avVarA.getDimensionPixelSize(a.j.SearchView_android_maxWidth, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.tk = avVarA.getText(a.j.SearchView_defaultQueryHint);
        this.tv = avVarA.getText(a.j.SearchView_queryHint);
        int i2 = avVarA.getInt(a.j.SearchView_android_imeOptions, -1);
        if (i2 != -1) {
            setImeOptions(i2);
        }
        int i3 = avVarA.getInt(a.j.SearchView_android_inputType, -1);
        if (i3 != -1) {
            setInputType(i3);
        }
        setFocusable(avVarA.getBoolean(a.j.SearchView_android_focusable, true));
        avVarA.recycle();
        this.ti = new Intent("android.speech.action.WEB_SEARCH");
        this.ti.addFlags(268435456);
        this.ti.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        this.tj = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.tj.addFlags(268435456);
        this.sY = findViewById(this.sQ.getDropDownAnchor());
        View view = this.sY;
        if (view != null) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: android.support.v7.widget.SearchView.5
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view2, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
                    SearchView.this.eH();
                }
            });
        }
        B(this.tr);
        ez();
    }

    int getSuggestionRowLayout() {
        return this.tg;
    }

    int getSuggestionCommitIconResId() {
        return this.th;
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.tE = searchableInfo;
        if (this.tE != null) {
            eA();
            ez();
        }
        this.tz = et();
        if (this.tz) {
            this.sQ.setPrivateImeOptions("nm");
        }
        B(isIconified());
    }

    public void setAppSearchData(Bundle bundle) {
        this.tF = bundle;
    }

    public void setImeOptions(int i) {
        this.sQ.setImeOptions(i);
    }

    public int getImeOptions() {
        return this.sQ.getImeOptions();
    }

    public void setInputType(int i) {
        this.sQ.setInputType(i);
    }

    public int getInputType() {
        return this.sQ.getInputType();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i, Rect rect) {
        if (this.tx || !isFocusable()) {
            return false;
        }
        if (!isIconified()) {
            boolean zRequestFocus = this.sQ.requestFocus(i, rect);
            if (zRequestFocus) {
                B(false);
            }
            return zRequestFocus;
        }
        return super.requestFocus(i, rect);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.tx = true;
        super.clearFocus();
        this.sQ.clearFocus();
        this.sQ.setImeVisibility(false);
        this.tx = false;
    }

    public void setOnQueryTextListener(c cVar) {
        this.tl = cVar;
    }

    public void setOnCloseListener(b bVar) {
        this.tm = bVar;
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.tn = onFocusChangeListener;
    }

    public void setOnSuggestionListener(d dVar) {
        this.tp = dVar;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.tq = onClickListener;
    }

    public CharSequence getQuery() {
        return this.sQ.getText();
    }

    private void setQuery(CharSequence charSequence, boolean z) {
        this.sQ.setText(charSequence);
        SearchAutoComplete searchAutoComplete = this.sQ;
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.tB = charSequence;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.tv = charSequence;
        ez();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.tv;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.tE;
        if (searchableInfo != null && searchableInfo.getHintId() != 0) {
            return getContext().getText(this.tE.getHintId());
        }
        return this.tk;
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.tr == z) {
            return;
        }
        this.tr = z;
        B(z);
        ez();
    }

    public void setIconified(boolean z) {
        if (z) {
            eD();
        } else {
            eE();
        }
    }

    private boolean isIconified() {
        return this.ts;
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.tu = z;
        B(isIconified());
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.tw = z;
        android.support.v4.widget.c cVar = this.tt;
        if (cVar instanceof aq) {
            ((aq) cVar).bh(z ? 2 : 1);
        }
    }

    public void setSuggestionsAdapter(android.support.v4.widget.c cVar) {
        this.tt = cVar;
        this.sQ.setAdapter(this.tt);
    }

    public android.support.v4.widget.c getSuggestionsAdapter() {
        return this.tt;
    }

    public void setMaxWidth(int i) {
        this.ty = i;
        requestLayout();
    }

    public int getMaxWidth() {
        return this.ty;
    }

    @Override // android.support.v7.widget.ac, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        if (isIconified()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i4 = this.ty;
            size = i4 > 0 ? Math.min(i4, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.ty;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i3 = this.ty) > 0) {
            size = Math.min(i3, size);
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.support.v7.widget.ac, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            a(this.sQ, this.ta);
            this.tb.set(this.ta.left, 0, this.ta.right, i4 - i2);
            f fVar = this.sZ;
            if (fVar == null) {
                this.sZ = new f(this.tb, this.ta, this.sQ);
                setTouchDelegate(this.sZ);
            } else {
                fVar.a(this.tb, this.ta);
            }
        }
    }

    private void a(View view, Rect rect) {
        view.getLocationInWindow(this.tc);
        getLocationInWindow(this.td);
        int[] iArr = this.tc;
        int i = iArr[1];
        int[] iArr2 = this.td;
        int i2 = i - iArr2[1];
        int i3 = iArr[0] - iArr2[0];
        rect.set(i3, i2, view.getWidth() + i3, view.getHeight() + i2);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_width);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(a.d.abc_search_view_preferred_height);
    }

    private void B(boolean z) {
        this.ts = z;
        int i = z ? 0 : 8;
        boolean z2 = !TextUtils.isEmpty(this.sQ.getText());
        this.sU.setVisibility(i);
        C(z2);
        this.sR.setVisibility(z ? 8 : 0);
        this.te.setVisibility((this.te.getDrawable() == null || this.tr) ? 8 : 0);
        ew();
        D(!z2);
        ev();
    }

    private boolean et() {
        SearchableInfo searchableInfo = this.tE;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent intent = null;
            if (this.tE.getVoiceSearchLaunchWebSearch()) {
                intent = this.ti;
            } else if (this.tE.getVoiceSearchLaunchRecognizer()) {
                intent = this.tj;
            }
            if (intent != null && getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                return true;
            }
        }
        return false;
    }

    private boolean eu() {
        return (this.tu || this.tz) && !isIconified();
    }

    private void C(boolean z) {
        this.sV.setVisibility((this.tu && eu() && hasFocus() && (z || !this.tz)) ? 0 : 8);
    }

    private void ev() {
        this.sT.setVisibility((eu() && (this.sV.getVisibility() == 0 || this.sX.getVisibility() == 0)) ? 0 : 8);
    }

    private void ew() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.sQ.getText());
        if (!z2 && (!this.tr || this.tC)) {
            z = false;
        }
        this.sW.setVisibility(z ? 0 : 8);
        Drawable drawable = this.sW.getDrawable();
        if (drawable != null) {
            drawable.setState(z2 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void ex() {
        post(this.tH);
    }

    final void ey() {
        int[] iArr = this.sQ.hasFocus() ? FOCUSED_STATE_SET : EMPTY_STATE_SET;
        Drawable background = this.sS.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.sT.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        removeCallbacks(this.tH);
        post(this.tI);
        super.onDetachedFromWindow();
    }

    final void e(CharSequence charSequence) {
        setQuery(charSequence);
    }

    final boolean b(int i, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.tE != null && this.tt != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i == 66 || i == 84 || i == 61) {
                return aC(this.sQ.getListSelection());
            }
            if (i == 21 || i == 22) {
                this.sQ.setSelection(i == 21 ? 0 : this.sQ.length());
                this.sQ.setListSelection(0);
                this.sQ.clearListSelection();
                tG.a(this.sQ, true);
                return true;
            }
            if (i != 19 || this.sQ.getListSelection() == 0) {
                return false;
            }
        }
        return false;
    }

    private CharSequence f(CharSequence charSequence) {
        if (!this.tr || this.tf == null) {
            return charSequence;
        }
        double textSize = this.sQ.getTextSize();
        Double.isNaN(textSize);
        int i = (int) (textSize * 1.25d);
        this.tf.setBounds(0, 0, i, i);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.tf), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void ez() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.sQ;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(f(queryHint));
    }

    private void eA() {
        this.sQ.setThreshold(this.tE.getSuggestThreshold());
        this.sQ.setImeOptions(this.tE.getImeOptions());
        int inputType = this.tE.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.tE.getSuggestAuthority() != null) {
                inputType = inputType | 65536 | 524288;
            }
        }
        this.sQ.setInputType(inputType);
        android.support.v4.widget.c cVar = this.tt;
        if (cVar != null) {
            cVar.changeCursor(null);
        }
        if (this.tE.getSuggestAuthority() != null) {
            this.tt = new aq(getContext(), this, this.tE, this.tJ);
            this.sQ.setAdapter(this.tt);
            ((aq) this.tt).bh(this.tw ? 2 : 1);
        }
    }

    private void D(boolean z) {
        int i;
        if (this.tz && !isIconified() && z) {
            i = 0;
            this.sV.setVisibility(8);
        } else {
            i = 8;
        }
        this.sX.setVisibility(i);
    }

    final void g(CharSequence charSequence) {
        Editable text = this.sQ.getText();
        this.tB = text;
        boolean z = !TextUtils.isEmpty(text);
        C(z);
        D(!z);
        ew();
        ev();
        if (this.tl != null && !TextUtils.equals(charSequence, this.tA)) {
            charSequence.toString();
        }
        this.tA = charSequence.toString();
    }

    final void eB() {
        Editable text = this.sQ.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        c cVar = this.tl;
        if (cVar != null) {
            text.toString();
            if (cVar.eJ()) {
                return;
            }
        }
        if (this.tE != null) {
            b(0, null, text.toString());
        }
        this.sQ.setImeVisibility(false);
        eC();
    }

    private void eC() {
        this.sQ.dismissDropDown();
    }

    final void eD() {
        if (TextUtils.isEmpty(this.sQ.getText())) {
            if (this.tr) {
                b bVar = this.tm;
                if (bVar == null || !bVar.onClose()) {
                    clearFocus();
                    B(true);
                    return;
                }
                return;
            }
            return;
        }
        this.sQ.setText("");
        this.sQ.requestFocus();
        this.sQ.setImeVisibility(true);
    }

    final void eE() {
        B(false);
        this.sQ.requestFocus();
        this.sQ.setImeVisibility(true);
        View.OnClickListener onClickListener = this.tq;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    final void eF() {
        SearchableInfo searchableInfo = this.tE;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(a(this.ti, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(b(this.tj, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    final void eG() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        B(isIconified());
        ex();
        if (this.sQ.hasFocus()) {
            eI();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ex();
    }

    @Override // android.support.v7.view.b
    public final void onActionViewCollapsed() {
        setQuery("", false);
        clearFocus();
        B(true);
        this.sQ.setImeOptions(this.tD);
        this.tC = false;
    }

    @Override // android.support.v7.view.b
    public final void onActionViewExpanded() {
        if (this.tC) {
            return;
        }
        this.tC = true;
        this.tD = this.sQ.getImeOptions();
        this.sQ.setImeOptions(this.tD | AVLogger.LEVEL_LOG_INFO);
        this.sQ.setText("");
        setIconified(false);
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class e extends android.support.v4.e.a {
        public static final Parcelable.Creator<e> CREATOR = new Parcelable.ClassLoaderCreator<e>() { // from class: android.support.v7.widget.SearchView.e.1
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return e(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public final /* synthetic */ e createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return c(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object[] newArray(int i) {
                return aF(i);
            }

            private static e c(Parcel parcel, ClassLoader classLoader) {
                return new e(parcel, classLoader);
            }

            private static e e(Parcel parcel) {
                return new e(parcel, null);
            }

            private static e[] aF(int i) {
                return new e[i];
            }
        };
        boolean tT;

        e(Parcelable parcelable) {
            super(parcelable);
        }

        public e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.tT = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        @Override // android.support.v4.e.a, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.tT));
        }

        public final String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.tT + com.alipay.sdk.m.u.i.d;
        }
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        eVar.tT = isIconified();
        return eVar;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof e)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        B(eVar.tT);
        requestLayout();
    }

    final void eH() {
        int i;
        if (this.sY.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.sS.getPaddingLeft();
            Rect rect = new Rect();
            boolean zAh = bd.ah(this);
            int dimensionPixelSize = this.tr ? resources.getDimensionPixelSize(a.d.abc_dropdownitem_icon_width) + resources.getDimensionPixelSize(a.d.abc_dropdownitem_text_padding_left) : 0;
            this.sQ.getDropDownBackground().getPadding(rect);
            if (zAh) {
                i = -rect.left;
            } else {
                i = paddingLeft - (rect.left + dimensionPixelSize);
            }
            this.sQ.setDropDownHorizontalOffset(i);
            this.sQ.setDropDownWidth((((this.sY.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    final boolean aC(int i) {
        d dVar = this.tp;
        if (dVar != null && dVar.eL()) {
            return false;
        }
        a(i, 0, (String) null);
        this.sQ.setImeVisibility(false);
        eC();
        return true;
    }

    final boolean aD(int i) {
        d dVar = this.tp;
        if (dVar != null && dVar.eK()) {
            return false;
        }
        aE(i);
        return true;
    }

    private void aE(int i) {
        Editable text = this.sQ.getText();
        Cursor cursor = this.tt.getCursor();
        if (cursor == null) {
            return;
        }
        if (cursor.moveToPosition(i)) {
            CharSequence charSequenceConvertToString = this.tt.convertToString(cursor);
            if (charSequenceConvertToString != null) {
                setQuery(charSequenceConvertToString);
                return;
            } else {
                setQuery(text);
                return;
            }
        }
        setQuery(text);
    }

    private boolean a(int i, int i2, String str) {
        Cursor cursor = this.tt.getCursor();
        if (cursor == null || !cursor.moveToPosition(i)) {
            return false;
        }
        a(a(cursor, 0, (String) null));
        return true;
    }

    private void a(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e2) {
            Log.e("SearchView", "Failed launch activity: " + intent, e2);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.sQ.setText(charSequence);
        this.sQ.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    final void b(int i, String str, String str2) {
        getContext().startActivity(a("android.intent.action.SEARCH", null, null, str2, 0, null));
    }

    private Intent a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.tB);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.tF;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.tE.getSearchActivity());
        return intent;
    }

    private static Intent a(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    private Intent b(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.tF;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    private Intent a(Cursor cursor, int i, String str) {
        int position;
        String strA;
        try {
            String strA2 = aq.a(cursor, "suggest_intent_action");
            if (strA2 == null) {
                strA2 = this.tE.getSuggestIntentAction();
            }
            if (strA2 == null) {
                strA2 = "android.intent.action.SEARCH";
            }
            String str2 = strA2;
            String strA3 = aq.a(cursor, "suggest_intent_data");
            if (strA3 == null) {
                strA3 = this.tE.getSuggestIntentData();
            }
            if (strA3 != null && (strA = aq.a(cursor, "suggest_intent_data_id")) != null) {
                strA3 = strA3 + "/" + Uri.encode(strA);
            }
            return a(str2, strA3 == null ? null : Uri.parse(strA3), aq.a(cursor, "suggest_intent_extra_data"), aq.a(cursor, "suggest_intent_query"), i, str);
        } catch (RuntimeException e2) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e2);
            return null;
        }
    }

    final void eI() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        tG.a(this.sQ);
        tG.b(this.sQ);
    }

    static boolean i(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class f extends TouchDelegate {
        private final View tZ;
        private final Rect ua;
        private final Rect ub;
        private final Rect uc;
        private final int ud;
        private boolean ue;

        public f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.ud = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.ua = new Rect();
            this.uc = new Rect();
            this.ub = new Rect();
            a(rect, rect2);
            this.tZ = view;
        }

        public final void a(Rect rect, Rect rect2) {
            this.ua.set(rect);
            this.uc.set(rect);
            Rect rect3 = this.uc;
            int i = this.ud;
            rect3.inset(-i, -i);
            this.ub.set(rect2);
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
        @Override // android.view.TouchDelegate
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final boolean onTouchEvent(android.view.MotionEvent r8) {
            /*
                r7 = this;
                float r0 = r8.getX()
                int r0 = (int) r0
                float r1 = r8.getY()
                int r1 = (int) r1
                int r2 = r8.getAction()
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L2e
                if (r2 == r4) goto L20
                if (r2 == r3) goto L20
                r6 = 3
                if (r2 == r6) goto L1b
                goto L3a
            L1b:
                boolean r2 = r7.ue
                r7.ue = r5
                goto L3b
            L20:
                boolean r2 = r7.ue
                if (r2 == 0) goto L3b
                android.graphics.Rect r6 = r7.uc
                boolean r6 = r6.contains(r0, r1)
                if (r6 != 0) goto L3b
                r4 = 0
                goto L3b
            L2e:
                android.graphics.Rect r2 = r7.ua
                boolean r2 = r2.contains(r0, r1)
                if (r2 == 0) goto L3a
                r7.ue = r4
                r2 = 1
                goto L3b
            L3a:
                r2 = 0
            L3b:
                if (r2 == 0) goto L70
                if (r4 == 0) goto L5b
                android.graphics.Rect r2 = r7.ub
                boolean r2 = r2.contains(r0, r1)
                if (r2 != 0) goto L5b
                android.view.View r0 = r7.tZ
                int r0 = r0.getWidth()
                int r0 = r0 / r3
                float r0 = (float) r0
                android.view.View r1 = r7.tZ
                int r1 = r1.getHeight()
                int r1 = r1 / r3
                float r1 = (float) r1
                r8.setLocation(r0, r1)
                goto L6a
            L5b:
                android.graphics.Rect r2 = r7.ub
                int r2 = r2.left
                int r0 = r0 - r2
                float r0 = (float) r0
                android.graphics.Rect r2 = r7.ub
                int r2 = r2.top
                int r1 = r1 - r2
                float r1 = (float) r1
                r8.setLocation(r0, r1)
            L6a:
                android.view.View r0 = r7.tZ
                boolean r5 = r0.dispatchTouchEvent(r8)
            L70:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    public static class SearchAutoComplete extends android.support.v7.widget.f {
        private int tU;
        private SearchView tV;
        private boolean tW;
        final Runnable tX;

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        protected void replaceText(CharSequence charSequence) {
        }

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, a.C0010a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.tX = new Runnable() { // from class: android.support.v7.widget.SearchView.SearchAutoComplete.1
                @Override // java.lang.Runnable
                public final void run() {
                    SearchAutoComplete.this.eM();
                }
            };
            this.tU = getThreshold();
        }

        @Override // android.view.View
        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        void setSearchView(SearchView searchView) {
            this.tV = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.tU = i;
        }

        final boolean isEmpty() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z);
            if (z && this.tV.hasFocus() && getVisibility() == 0) {
                this.tW = true;
                if (SearchView.i(getContext())) {
                    SearchView.tG.a(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        protected void onFocusChanged(boolean z, int i, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z, i, rect);
            this.tV.eG();
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.tU <= 0 || super.enoughToFilter();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.tV.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i2 = configuration.screenHeightDp;
            if (i >= 960 && i2 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i2 < 480) ? 160 : 192;
            }
            return 192;
        }

        @Override // android.support.v7.widget.f, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.tW) {
                removeCallbacks(this.tX);
                post(this.tX);
            }
            return inputConnectionOnCreateInputConnection;
        }

        final void eM() {
            if (this.tW) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.tW = false;
            }
        }

        void setImeVisibility(boolean z) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z) {
                this.tW = false;
                removeCallbacks(this.tX);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (inputMethodManager.isActive(this)) {
                    this.tW = false;
                    removeCallbacks(this.tX);
                    inputMethodManager.showSoftInput(this, 0);
                    return;
                }
                this.tW = true;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static class a {
        private Method tQ;
        private Method tR;
        private Method tS;

        a() {
            try {
                this.tQ = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.tQ.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                this.tR = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.tR.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                this.tS = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.tS.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        final void a(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.tQ;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        final void b(AutoCompleteTextView autoCompleteTextView) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.tR;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        final void a(AutoCompleteTextView autoCompleteTextView, boolean z) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            Method method = this.tS;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }
}
