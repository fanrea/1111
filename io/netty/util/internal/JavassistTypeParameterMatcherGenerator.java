package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Method;
import javassist.ClassClassPath;
import javassist.ClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import okhttp3.HttpUrl;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class JavassistTypeParameterMatcherGenerator {
    private static final ClassPool classPool;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) JavassistTypeParameterMatcherGenerator.class);

    static {
        ClassPool classPool2 = new ClassPool(true);
        classPool = classPool2;
        classPool2.appendClassPath(new ClassClassPath(NoOpTypeParameterMatcher.class));
    }

    public static void appendClassPath(ClassPath classPath) {
        classPool.appendClassPath(classPath);
    }

    public static void appendClassPath(String str) {
        classPool.appendClassPath(str);
    }

    public static ClassPool classPool() {
        return classPool;
    }

    public static TypeParameterMatcher generate(Class<?> cls) {
        ClassLoader contextClassLoader = PlatformDependent.getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = PlatformDependent.getSystemClassLoader();
        }
        return generate(cls, contextClassLoader);
    }

    public static TypeParameterMatcher generate(Class<?> cls, ClassLoader classLoader) throws NoSuchMethodException, SecurityException {
        String strTypeName = typeName(cls);
        String str = "io.netty.util.internal.__matchers__." + strTypeName + "Matcher";
        try {
            try {
                try {
                    return (TypeParameterMatcher) Class.forName(str, true, classLoader).newInstance();
                } catch (Exception unused) {
                    CtClass andRename = classPool.getAndRename(NoOpTypeParameterMatcher.class.getName(), str);
                    andRename.setModifiers(andRename.getModifiers() | 16);
                    andRename.getDeclaredMethod("match").setBody("{ return $1 instanceof " + strTypeName + "; }");
                    byte[] bytecode = andRename.toBytecode();
                    andRename.detach();
                    Method declaredMethod = ClassLoader.class.getDeclaredMethod("defineClass", String.class, byte[].class, Integer.TYPE, Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    Class cls2 = (Class) declaredMethod.invoke(classLoader, str, bytecode, 0, Integer.valueOf(bytecode.length));
                    if (cls != Object.class) {
                        logger.debug("Generated: {}", cls2.getName());
                    }
                    return (TypeParameterMatcher) cls2.newInstance();
                }
            } catch (RuntimeException e) {
                throw e;
            }
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    private static String typeName(Class<?> cls) {
        if (cls.isArray()) {
            return typeName(cls.getComponentType()) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return cls.getName();
    }

    private JavassistTypeParameterMatcherGenerator() {
    }
}
