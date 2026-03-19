package android.support.v7.widget;

import android.R;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.a.a;
import android.support.v7.app.a;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.djx.core.log.T2WLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
final class aq extends android.support.v4.widget.j implements View.OnClickListener {
    private boolean mClosed;
    private final SearchableInfo tE;
    private final WeakHashMap<String, Drawable.ConstantState> tJ;
    private final SearchView tV;
    private final SearchManager uP;
    private final Context uQ;
    private final int uR;
    private int uS;
    private ColorStateList uT;
    private int uU;
    private int uV;
    private int uW;
    private int uX;
    private int uY;
    private int uZ;

    @Override // android.support.v4.widget.c, android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    public aq(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.mClosed = false;
        this.uS = 1;
        this.uU = -1;
        this.uV = -1;
        this.uW = -1;
        this.uX = -1;
        this.uY = -1;
        this.uZ = -1;
        this.uP = (SearchManager) this.mContext.getSystemService(T2WLog.SCENE_SEARCH);
        this.tV = searchView;
        this.tE = searchableInfo;
        this.uR = searchView.getSuggestionCommitIconResId();
        this.uQ = context;
        this.tJ = weakHashMap;
    }

    public final void bh(int i) {
        this.uS = i;
    }

    @Override // android.support.v4.widget.c, android.support.v4.widget.d.a
    public final Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.tV.getVisibility() == 0 && this.tV.getWindowVisibility() == 0) {
            try {
                Cursor cursorA = a(this.tE, string, 50);
                if (cursorA != null) {
                    cursorA.getCount();
                    return cursorA;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        a(getCursor());
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        a(getCursor());
    }

    private static void a(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // android.support.v4.widget.c, android.support.v4.widget.d.a
    public final void changeCursor(Cursor cursor) {
        if (this.mClosed) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.changeCursor(cursor);
            if (cursor != null) {
                this.uU = cursor.getColumnIndex("suggest_text_1");
                this.uV = cursor.getColumnIndex("suggest_text_2");
                this.uW = cursor.getColumnIndex("suggest_text_2_url");
                this.uX = cursor.getColumnIndex("suggest_icon_1");
                this.uY = cursor.getColumnIndex("suggest_icon_2");
                this.uZ = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // android.support.v4.widget.j, android.support.v4.widget.c
    public final View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        viewNewView.setTag(new a(viewNewView));
        ((ImageView) viewNewView.findViewById(a.f.edit_query)).setImageResource(this.uR);
        return viewNewView;
    }

    /* renamed from: android.support.v7.widget.aq$1, reason: invalid class name */
    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ View wc;

        AnonymousClass1(View view) {
            this.wc = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            aq.this.smoothScrollTo(this.wc.getLeft() - ((aq.this.getWidth() - this.wc.getWidth()) / 2), 0);
            aq.this.vU = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex
 */
    static final class a {
        public final TextView va;
        public final TextView vb;
        public final ImageView vc;
        public final ImageView vd;
        public final ImageView ve;

        public a(View view) {
            this.va = (TextView) view.findViewById(R.id.text1);
            this.vb = (TextView) view.findViewById(R.id.text2);
            this.vc = (ImageView) view.findViewById(R.id.icon1);
            this.vd = (ImageView) view.findViewById(R.id.icon2);
            this.ve = (ImageView) view.findViewById(a.f.edit_query);
        }
    }

    @Override // android.support.v4.widget.c
    public final void a(View view, Cursor cursor) {
        CharSequence charSequenceA;
        a aVar = (a) view.getTag();
        int i = this.uZ;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.va != null) {
            a(aVar.va, a(cursor, this.uU));
        }
        if (aVar.vb != null) {
            String strA = a(cursor, this.uW);
            if (strA != null) {
                charSequenceA = h((CharSequence) strA);
            } else {
                charSequenceA = a(cursor, this.uV);
            }
            if (TextUtils.isEmpty(charSequenceA)) {
                if (aVar.va != null) {
                    aVar.va.setSingleLine(false);
                    aVar.va.setMaxLines(2);
                }
            } else if (aVar.va != null) {
                aVar.va.setSingleLine(true);
                aVar.va.setMaxLines(1);
            }
            a(aVar.vb, charSequenceA);
        }
        if (aVar.vc != null) {
            a(aVar.vc, b(cursor), 4);
        }
        if (aVar.vd != null) {
            a(aVar.vd, c(cursor), 8);
        }
        int i3 = this.uS;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            aVar.ve.setVisibility(0);
            aVar.ve.setTag(aVar.va.getText());
            aVar.ve.setOnClickListener(this);
            return;
        }
        aVar.ve.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.tV.e((CharSequence) tag);
        }
    }

    private CharSequence h(CharSequence charSequence) {
        if (this.uT == null) {
            TypedValue typedValue = new TypedValue();
            this.mContext.getTheme().resolveAttribute(a.C0010a.textColorSearchUrl, typedValue, true);
            this.uT = this.mContext.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.uT, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private static void a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private Drawable b(Cursor cursor) throws NumberFormatException, IOException {
        int i = this.uX;
        if (i == -1) {
            return null;
        }
        Drawable drawableG = g(cursor.getString(i));
        return drawableG != null ? drawableG : fj();
    }

    private Drawable c(Cursor cursor) {
        int i = this.uY;
        if (i == -1) {
            return null;
        }
        return g(cursor.getString(i));
    }

    private static void a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
    class b extends LinearLayout {
        private TextView eS;
        private ImageView iz;
        private View kp;
        private final int[] we;
        private a.b wf;

        public b(Context context, a.b bVar, boolean z) {
            super(context, null, a.C0010a.actionBarTabStyle);
            this.we = new int[]{R.attr.background};
            this.wf = bVar;
            ay ayVarA = ay.a(context, null, this.we, a.C0010a.actionBarTabStyle, 0);
            if (ayVarA.hasValue(0)) {
                setBackgroundDrawable(ayVarA.getDrawable(0));
            }
            ayVarA.recycle();
            if (z) {
                setGravity(8388627);
            }
            update();
        }

        public final void a(a.b bVar) {
            this.wf = bVar;
            update();
        }

        @Override // android.view.View
        public final void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(a.b.class.getName());
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(a.b.class.getName());
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (aq.this.vY <= 0 || getMeasuredWidth() <= aq.this.vY) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(aq.this.vY, 1073741824), i2);
        }

        private void update() {
            a.b bVar = this.wf;
            View customView = bVar.getCustomView();
            if (customView != null) {
                ViewParent parent = customView.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(customView);
                    }
                    addView(customView);
                }
                this.kp = customView;
                TextView textView = this.eS;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.iz;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.iz.setImageDrawable(null);
                    return;
                }
                return;
            }
            View view = this.kp;
            if (view != null) {
                removeView(view);
                this.kp = null;
            }
            Drawable icon = bVar.getIcon();
            CharSequence text = bVar.getText();
            if (icon != null) {
                if (this.iz == null) {
                    m mVar = new m(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    mVar.setLayoutParams(layoutParams);
                    addView(mVar, 0);
                    this.iz = mVar;
                }
                this.iz.setImageDrawable(icon);
                this.iz.setVisibility(0);
            } else {
                ImageView imageView2 = this.iz;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.iz.setImageDrawable(null);
                }
            }
            boolean z = !TextUtils.isEmpty(text);
            if (z) {
                if (this.eS == null) {
                    q qVar = new q(getContext(), null, a.C0010a.actionBarTabTextStyle);
                    qVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    qVar.setLayoutParams(layoutParams2);
                    addView(qVar);
                    this.eS = qVar;
                }
                this.eS.setText(text);
                this.eS.setVisibility(0);
            } else {
                TextView textView2 = this.eS;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.eS.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.iz;
            if (imageView3 != null) {
                imageView3.setContentDescription(bVar.getContentDescription());
            }
            ba.a(this, z ? null : bVar.getContentDescription());
        }

        public final a.b fU() {
            return this.wf;
        }
    }

    @Override // android.support.v4.widget.c, android.support.v4.widget.d.a
    public final CharSequence convertToString(Cursor cursor) {
        String strA;
        String strA2;
        if (cursor == null) {
            return null;
        }
        String strA3 = a(cursor, "suggest_intent_query");
        if (strA3 != null) {
            return strA3;
        }
        if (this.tE.shouldRewriteQueryFromData() && (strA2 = a(cursor, "suggest_intent_data")) != null) {
            return strA2;
        }
        if (!this.tE.shouldRewriteQueryFromText() || (strA = a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strA;
    }

    @Override // android.support.v4.widget.c, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewNewView = newView(this.mContext, this.dx, viewGroup);
            if (viewNewView != null) {
                ((a) viewNewView.getTag()).va.setText(e.toString());
            }
            return viewNewView;
        }
    }

    @Override // android.support.v4.widget.c, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewNewDropDownView = newDropDownView(this.mContext, this.dx, viewGroup);
            if (viewNewDropDownView != null) {
                ((a) viewNewDropDownView.getTag()).va.setText(e.toString());
            }
            return viewNewDropDownView;
        }
    }

    private Drawable g(String str) throws NumberFormatException, IOException {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.uQ.getPackageName() + "/" + i;
            Drawable drawableH = h(str2);
            if (drawableH != null) {
                return drawableH;
            }
            Drawable drawableA = android.support.v4.content.a.a(this.uQ, i);
            a(str2, drawableA);
            return drawableA;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableH2 = h(str);
            if (drawableH2 != null) {
                return drawableH2;
            }
            Drawable drawableA2 = a(Uri.parse(str));
            a(str, drawableA2);
            return drawableA2;
        }
    }

    private Drawable a(Uri uri) throws IOException {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return b(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.uQ.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
            }
        } catch (FileNotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e2.getMessage());
        return null;
    }

    private Drawable h(String str) {
        Drawable.ConstantState constantState = this.tJ.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    private void a(String str, Drawable drawable) {
        if (drawable != null) {
            this.tJ.put(str, drawable.getConstantState());
        }
    }

    private Drawable fj() throws PackageManager.NameNotFoundException {
        Drawable drawableA = a(this.tE.getSearchActivity());
        return drawableA != null ? drawableA : this.mContext.getPackageManager().getDefaultActivityIcon();
    }

    private Drawable a(ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (this.tJ.containsKey(strFlattenToShortString)) {
            Drawable.ConstantState constantState = this.tJ.get(strFlattenToShortString);
            if (constantState == null) {
                return null;
            }
            return constantState.newDrawable(this.uQ.getResources());
        }
        Drawable activityIcon = getActivityIcon(componentName);
        this.tJ.put(strFlattenToShortString, activityIcon != null ? activityIcon.getConstantState() : null);
        return activityIcon;
    }

    private Drawable getActivityIcon(ComponentName componentName) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = this.mContext.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    private static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    private Drawable b(Uri uri) throws PackageManager.NameNotFoundException, NumberFormatException, FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.mContext.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (identifier == 0) {
                throw new FileNotFoundException("No resource found for: " + uri);
            }
            return resourcesForApplication.getDrawable(identifier);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    private Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        builderFragment.appendQueryParameter("limit", "50");
        return this.mContext.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr, null);
    }
}
