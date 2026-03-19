package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";
    ConstraintSet mDefaultConstraintSet;
    int mDefaultState = -1;
    int mCurrentStateId = -1;
    int mCurrentConstraintNumber = -1;
    private SparseArray<State> mStateList = new SparseArray<>();
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;

    public StateSet(Context context, XmlPullParser parser) throws XmlPullParserException, IOException {
        load(context, parser);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void load(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r9 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r10.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L10:
            if (r3 >= r1) goto L25
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L22
            int r5 = r9.mDefaultState
            int r4 = r0.getResourceId(r4, r5)
            r9.mDefaultState = r4
        L22:
            int r3 = r3 + 1
            goto L10
        L25:
            r0.recycle()
            r0 = 0
            int r1 = r11.getEventType()     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
        L2d:
            r3 = 1
            if (r1 == r3) goto La8
            if (r1 == 0) goto L97
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r1 == r6) goto L47
            if (r1 == r5) goto L3c
            goto L9a
        L3c:
            java.lang.String r1 = r11.getName()     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            boolean r1 = r4.equals(r1)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            if (r1 == 0) goto L9a
            return
        L47:
            java.lang.String r1 = r11.getName()     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            r7 = -1
            int r8 = r1.hashCode()     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            switch(r8) {
                case 80204913: goto L6f;
                case 1301459538: goto L65;
                case 1382829617: goto L5e;
                case 1901439077: goto L54;
                default: goto L53;
            }     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
        L53:
            goto L79
        L54:
            java.lang.String r3 = "Variant"
            boolean r1 = r1.equals(r3)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            if (r1 == 0) goto L79
            r3 = r5
            goto L7a
        L5e:
            boolean r1 = r1.equals(r4)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            if (r1 == 0) goto L79
            goto L7a
        L65:
            java.lang.String r3 = "LayoutDescription"
            boolean r1 = r1.equals(r3)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            if (r1 == 0) goto L79
            r3 = r2
            goto L7a
        L6f:
            java.lang.String r3 = "State"
            boolean r1 = r1.equals(r3)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            if (r1 == 0) goto L79
            r3 = r6
            goto L7a
        L79:
            r3 = r7
        L7a:
            if (r3 == r6) goto L8a
            if (r3 == r5) goto L7f
            goto L9a
        L7f:
            androidx.constraintlayout.widget.StateSet$Variant r1 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            r1.<init>(r10, r11)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            if (r0 == 0) goto L9a
            r0.add(r1)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            goto L9a
        L8a:
            androidx.constraintlayout.widget.StateSet$State r0 = new androidx.constraintlayout.widget.StateSet$State     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            r0.<init>(r10, r11)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r1 = r9.mStateList     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            int r3 = r0.mId     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            r1.put(r3, r0)     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            goto L9a
        L97:
            r11.getName()     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
        L9a:
            int r1 = r11.next()     // Catch: java.io.IOException -> L9f org.xmlpull.v1.XmlPullParserException -> La4
            goto L2d
        L9f:
            r10 = move-exception
            r10.printStackTrace()
            goto La8
        La4:
            r10 = move-exception
            r10.printStackTrace()
        La8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public boolean needsToChange(int id, float width, float height) {
        int i = this.mCurrentStateId;
        if (i != id) {
            return true;
        }
        State stateValueAt = id == -1 ? this.mStateList.valueAt(0) : this.mStateList.get(i);
        return (this.mCurrentConstraintNumber == -1 || !stateValueAt.mVariants.get(this.mCurrentConstraintNumber).match(width, height)) && this.mCurrentConstraintNumber != stateValueAt.findMatch(width, height);
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int id, int width, int height) {
        return updateConstraints(-1, id, width, height);
    }

    public int convertToConstraintSet(int currentConstrainSettId, int stateId, float width, float height) {
        State state = this.mStateList.get(stateId);
        if (state == null) {
            return stateId;
        }
        if (width == -1.0f || height == -1.0f) {
            if (state.mConstraintID == currentConstrainSettId) {
                return currentConstrainSettId;
            }
            Iterator<Variant> it = state.mVariants.iterator();
            while (it.hasNext()) {
                if (currentConstrainSettId == it.next().mConstraintID) {
                    return currentConstrainSettId;
                }
            }
            return state.mConstraintID;
        }
        Variant variant = null;
        Iterator<Variant> it2 = state.mVariants.iterator();
        while (it2.hasNext()) {
            Variant next = it2.next();
            if (next.match(width, height)) {
                if (currentConstrainSettId == next.mConstraintID) {
                    return currentConstrainSettId;
                }
                variant = next;
            }
        }
        if (variant != null) {
            return variant.mConstraintID;
        }
        return state.mConstraintID;
    }

    public int updateConstraints(int currentId, int id, float width, float height) {
        State stateValueAt;
        int iFindMatch;
        if (currentId != id) {
            State state = this.mStateList.get(id);
            if (state == null) {
                return -1;
            }
            int iFindMatch2 = state.findMatch(width, height);
            return iFindMatch2 == -1 ? state.mConstraintID : state.mVariants.get(iFindMatch2).mConstraintID;
        }
        if (id == -1) {
            stateValueAt = this.mStateList.valueAt(0);
        } else {
            stateValueAt = this.mStateList.get(this.mCurrentStateId);
        }
        if (stateValueAt == null) {
            return -1;
        }
        return ((this.mCurrentConstraintNumber == -1 || !stateValueAt.mVariants.get(currentId).match(width, height)) && currentId != (iFindMatch = stateValueAt.findMatch(width, height))) ? iFindMatch == -1 ? stateValueAt.mConstraintID : stateValueAt.mVariants.get(iFindMatch).mConstraintID : currentId;
    }

    static class State {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        ArrayList<Variant> mVariants = new ArrayList<>();

        public State(Context context, XmlPullParser parser) throws Resources.NotFoundException {
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.State_android_id) {
                    this.mId = typedArrayObtainStyledAttributes.getResourceId(index, this.mId);
                } else if (index == R.styleable.State_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        void add(Variant size) {
            this.mVariants.add(size);
        }

        public int findMatch(float width, float height) {
            for (int i = 0; i < this.mVariants.size(); i++) {
                if (this.mVariants.get(i).match(width, height)) {
                    return i;
                }
            }
            return -1;
        }
    }

    static class Variant {
        int mConstraintID;
        int mId;
        boolean mIsLayout;
        float mMaxHeight;
        float mMaxWidth;
        float mMinHeight;
        float mMinWidth;

        public Variant(Context context, XmlPullParser parser) throws Resources.NotFoundException {
            this.mMinWidth = Float.NaN;
            this.mMinHeight = Float.NaN;
            this.mMaxWidth = Float.NaN;
            this.mMaxHeight = Float.NaN;
            this.mConstraintID = -1;
            this.mIsLayout = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Variant_constraints) {
                    this.mConstraintID = typedArrayObtainStyledAttributes.getResourceId(index, this.mConstraintID);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.mConstraintID);
                    context.getResources().getResourceName(this.mConstraintID);
                    if ("layout".equals(resourceTypeName)) {
                        this.mIsLayout = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.mMaxHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxHeight);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.mMinHeight = typedArrayObtainStyledAttributes.getDimension(index, this.mMinHeight);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.mMaxWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMaxWidth);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.mMinWidth = typedArrayObtainStyledAttributes.getDimension(index, this.mMinWidth);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        boolean match(float widthDp, float heightDp) {
            if (!Float.isNaN(this.mMinWidth) && widthDp < this.mMinWidth) {
                return false;
            }
            if (!Float.isNaN(this.mMinHeight) && heightDp < this.mMinHeight) {
                return false;
            }
            if (Float.isNaN(this.mMaxWidth) || widthDp <= this.mMaxWidth) {
                return Float.isNaN(this.mMaxHeight) || heightDp <= this.mMaxHeight;
            }
            return false;
        }
    }
}
