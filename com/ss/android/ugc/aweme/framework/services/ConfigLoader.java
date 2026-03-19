package com.ss.android.ugc.aweme.framework.services;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
class ConfigLoader {
    private static final String[] DIRS = {"services/", "services/AwemeLive/", "services/AwemeIM/", "services/AwemeReactNative/", "services/AwemePush/", "services/AwemeShare/", "services/AwemeMain/", "services/AwemePlugin/", "services/SdkDebugger/", "services/AwemeMusic/", "services/AwemeVideo/", "services/AwemeFramework/", "services/AwemeCommerce/"};
    private static final Map<String, List<CacheItem>> CLASSES = Collections.synchronizedMap(new LinkedHashMap());

    ConfigLoader() {
    }

    private static void addCache(String str, String str2) {
        String[] strArrSplit = str2.split("\n");
        ArrayList arrayList = new ArrayList();
        for (String str3 : strArrSplit) {
            arrayList.add(CacheItem.fromConfig(str3));
        }
        CLASSES.put(str, arrayList);
    }

    public static <T> Iterator<T> iterator(Class<T> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        return new ConfigIterator(loadClasses(cls, classLoader), cls, classLoader);
    }

    private static <T> List<CacheItem> loadClasses(Class<T> cls, ClassLoader classLoader) {
        Map<String, List<CacheItem>> map = CLASSES;
        synchronized (map) {
            List<CacheItem> list = map.get(cls.getName());
            if (list != null) {
                return list;
            }
            List<CacheItem> linkedList = new LinkedList<>();
            for (String str : DIRS) {
                Enumeration<URL> urls = getUrls(cls, classLoader, str);
                while (urls != null && urls.hasMoreElements()) {
                    linkedList.addAll(parseSafely(urls.nextElement()));
                }
            }
            Map<String, List<CacheItem>> map2 = CLASSES;
            synchronized (map2) {
                if (!map2.containsKey(cls.getName())) {
                    map2.put(cls.getName(), linkedList);
                } else {
                    linkedList = map2.get(cls.getName());
                }
            }
            return linkedList;
        }
    }

    private static Enumeration<URL> getUrls(Class cls, ClassLoader classLoader, String str) {
        String str2 = str + cls.getName();
        if (classLoader == null) {
            try {
                return ClassLoader.getSystemResources(str2);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        try {
            return classLoader.getResources(str2);
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static List<CacheItem> parseSafely(URL url) throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            try {
                return parse(url);
            } catch (ConcurrentModificationException e) {
                if (i < 2) {
                    try {
                        Thread.sleep(2L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                } else {
                    throw e;
                }
            }
        }
        return new LinkedList();
    }

    private static List<CacheItem> parse(URL url) throws Throwable {
        InputStream inputStreamOpenStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        IOException e;
        LinkedList linkedList = new LinkedList();
        BufferedReader bufferedReader2 = null;
        try {
            inputStreamOpenStream = url.openStream();
            try {
                inputStreamReader = new InputStreamReader(inputStreamOpenStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (IOException e2) {
                    bufferedReader = null;
                    e = e2;
                } catch (Throwable th) {
                    th = th;
                    closeQuietly(bufferedReader2);
                    closeQuietly(inputStreamReader);
                    closeQuietly(inputStreamOpenStream);
                    throw th;
                }
            } catch (IOException e3) {
                bufferedReader = null;
                e = e3;
                inputStreamReader = null;
            } catch (Throwable th2) {
                th = th2;
                inputStreamReader = null;
            }
        } catch (IOException e4) {
            inputStreamReader = null;
            bufferedReader = null;
            e = e4;
            inputStreamOpenStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStreamOpenStream = null;
            inputStreamReader = null;
        }
        try {
            try {
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    CacheItem cacheItemFromConfig = CacheItem.fromConfig(line);
                    if (cacheItemFromConfig != null) {
                        linkedList.add(cacheItemFromConfig);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader2 = bufferedReader;
                closeQuietly(bufferedReader2);
                closeQuietly(inputStreamReader);
                closeQuietly(inputStreamOpenStream);
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            e.printStackTrace();
            closeQuietly(bufferedReader);
            closeQuietly(inputStreamReader);
            closeQuietly(inputStreamOpenStream);
            return linkedList;
        }
        closeQuietly(bufferedReader);
        closeQuietly(inputStreamReader);
        closeQuietly(inputStreamOpenStream);
        return linkedList;
    }

    private static void closeQuietly(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class CacheItem {
        public Object cacheService;
        public final String className;
        public final boolean persistence;

        public CacheItem(String str, boolean z) {
            this.className = str;
            this.persistence = z;
        }

        public static CacheItem fromConfig(String str) {
            if (str == null || "".equals(str)) {
                return null;
            }
            String[] strArrSplit = str.split(":");
            return new CacheItem(strArrSplit[0], strArrSplit.length > 1 ? Boolean.parseBoolean(strArrSplit[1]) : false);
        }
    }

    private static class ConfigIterator<T> implements Iterator<T> {
        private Class mClass;
        private ClassLoader mClassLoader;
        private List<CacheItem> mClasses;
        private int mIndex = 0;

        public ConfigIterator(List<CacheItem> list, Class<T> cls, ClassLoader classLoader) {
            this.mClassLoader = classLoader;
            this.mClass = cls;
            this.mClasses = list;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            List<CacheItem> list = this.mClasses;
            return list != null && this.mIndex < list.size();
        }

        @Override // java.util.Iterator
        public T next() {
            CacheItem cacheItem = this.mClasses.get(this.mIndex);
            this.mIndex++;
            synchronized (cacheItem) {
                if (cacheItem.persistence && cacheItem.cacheService != null) {
                    return (T) cacheItem.cacheService;
                }
                if (cacheItem.persistence) {
                    cacheItem.cacheService = newService(cacheItem);
                    return (T) cacheItem.cacheService;
                }
                return newService(cacheItem);
            }
        }

        private T newService(CacheItem cacheItem) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            try {
                Class<?> cls = Class.forName(cacheItem.className, false, this.mClassLoader);
                if (!this.mClass.isAssignableFrom(cls)) {
                    throw new RuntimeException(new ClassCastException("source: " + cls.getName() + ", dest: " + this.mClass.getName()));
                }
                try {
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
                    declaredConstructor.setAccessible(true);
                    return (T) declaredConstructor.newInstance(new Object[0]);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException(e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException(e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException(e4);
                }
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException(e5);
            }
        }
    }
}
