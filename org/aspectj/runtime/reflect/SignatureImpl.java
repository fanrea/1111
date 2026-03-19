package org.aspectj.runtime.reflect;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import kotlin.text.Typography;
import okhttp3.HttpUrl;
import org.aspectj.lang.Signature;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public abstract class SignatureImpl implements Signature {
    public static final String INNER_SEP = ":";
    public static final char SEP = '-';
    private static boolean useCache = true;
    public Class declaringType;
    public String declaringTypeName;
    public ClassLoader lookupClassLoader;
    public int modifiers;
    public String name;
    public Cache stringCache;
    private String stringRep;
    public static String[] EMPTY_STRING_ARRAY = new String[0];
    public static Class[] EMPTY_CLASS_ARRAY = new Class[0];

    public interface Cache {
        String get(int i);

        void set(int i, String str);
    }

    public static final class CacheImpl implements Cache {
        private SoftReference toStringCacheRef;

        public CacheImpl() {
            makeCache();
        }

        private String[] array() {
            return (String[]) this.toStringCacheRef.get();
        }

        private String[] makeCache() {
            String[] strArr = new String[3];
            this.toStringCacheRef = new SoftReference(strArr);
            return strArr;
        }

        @Override // org.aspectj.runtime.reflect.SignatureImpl.Cache
        public String get(int i) {
            String[] strArrArray = array();
            if (strArrArray == null) {
                return null;
            }
            return strArrArray[i];
        }

        @Override // org.aspectj.runtime.reflect.SignatureImpl.Cache
        public void set(int i, String str) {
            String[] strArrArray = array();
            if (strArrArray == null) {
                strArrArray = makeCache();
            }
            strArrArray[i] = str;
        }
    }

    public SignatureImpl(int i, String str, Class cls) {
        this.lookupClassLoader = null;
        this.modifiers = i;
        this.name = str;
        this.declaringType = cls;
    }

    public SignatureImpl(String str) {
        this.modifiers = -1;
        this.lookupClassLoader = null;
        this.stringRep = str;
    }

    private ClassLoader getLookupClassLoader() {
        if (this.lookupClassLoader == null) {
            this.lookupClassLoader = getClass().getClassLoader();
        }
        return this.lookupClassLoader;
    }

    public static boolean getUseCache() {
        return useCache;
    }

    public static void setUseCache(boolean z) {
        useCache = z;
    }

    public void addFullTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(fullTypeName(clsArr[i]));
        }
    }

    public void addShortTypeNames(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(shortTypeName(clsArr[i]));
        }
    }

    public void addTypeArray(StringBuffer stringBuffer, Class[] clsArr) {
        addFullTypeNames(stringBuffer, clsArr);
    }

    public abstract String createToString(StringMaker stringMaker);

    public int extractInt(int i) {
        return Integer.parseInt(extractString(i), 16);
    }

    public String extractString(int i) {
        int iIndexOf = this.stringRep.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = iIndexOf + 1;
            iIndexOf = this.stringRep.indexOf(45, i2);
            i = i3;
        }
        if (iIndexOf == -1) {
            iIndexOf = this.stringRep.length();
        }
        return this.stringRep.substring(i2, iIndexOf);
    }

    public String[] extractStrings(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(extractString(i), ":");
        int iCountTokens = stringTokenizer.countTokens();
        String[] strArr = new String[iCountTokens];
        for (int i2 = 0; i2 < iCountTokens; i2++) {
            strArr[i2] = stringTokenizer.nextToken();
        }
        return strArr;
    }

    public Class extractType(int i) {
        return Factory.makeClass(extractString(i), getLookupClassLoader());
    }

    public Class[] extractTypes(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(extractString(i), ":");
        int iCountTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[iCountTokens];
        for (int i2 = 0; i2 < iCountTokens; i2++) {
            clsArr[i2] = Factory.makeClass(stringTokenizer.nextToken(), getLookupClassLoader());
        }
        return clsArr;
    }

    public String fullTypeName(Class cls) {
        return cls == null ? "ANONYMOUS" : cls.isArray() ? new StringBuffer().append(fullTypeName(cls.getComponentType())).append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI).toString() : cls.getName().replace(Typography.dollar, '.');
    }

    @Override // org.aspectj.lang.Signature
    public Class getDeclaringType() {
        if (this.declaringType == null) {
            this.declaringType = extractType(2);
        }
        return this.declaringType;
    }

    @Override // org.aspectj.lang.Signature
    public String getDeclaringTypeName() {
        if (this.declaringTypeName == null) {
            this.declaringTypeName = getDeclaringType().getName();
        }
        return this.declaringTypeName;
    }

    @Override // org.aspectj.lang.Signature
    public int getModifiers() {
        if (this.modifiers == -1) {
            this.modifiers = extractInt(0);
        }
        return this.modifiers;
    }

    @Override // org.aspectj.lang.Signature
    public String getName() {
        if (this.name == null) {
            this.name = extractString(1);
        }
        return this.name;
    }

    public void setLookupClassLoader(ClassLoader classLoader) {
        this.lookupClassLoader = classLoader;
    }

    public String shortTypeName(Class cls) {
        return cls == null ? "ANONYMOUS" : cls.isArray() ? new StringBuffer().append(shortTypeName(cls.getComponentType())).append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI).toString() : stripPackageName(cls.getName()).replace(Typography.dollar, '.');
    }

    public String stripPackageName(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    @Override // org.aspectj.lang.Signature
    public final String toLongString() {
        return toString(StringMaker.longStringMaker);
    }

    @Override // org.aspectj.lang.Signature
    public final String toShortString() {
        return toString(StringMaker.shortStringMaker);
    }

    @Override // org.aspectj.lang.Signature
    public final String toString() {
        return toString(StringMaker.middleStringMaker);
    }

    public String toString(StringMaker stringMaker) {
        String strCreateToString;
        if (useCache) {
            Cache cache = this.stringCache;
            if (cache == null) {
                try {
                    this.stringCache = new CacheImpl();
                } catch (Throwable unused) {
                    useCache = false;
                }
                strCreateToString = null;
            } else {
                strCreateToString = cache.get(stringMaker.cacheOffset);
            }
        } else {
            strCreateToString = null;
        }
        if (strCreateToString == null) {
            strCreateToString = createToString(stringMaker);
        }
        if (useCache) {
            this.stringCache.set(stringMaker.cacheOffset, strCreateToString);
        }
        return strCreateToString;
    }
}
