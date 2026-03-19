package io.netty.util.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class TypeParameterMatcher {
    private static final TypeParameterMatcher NOOP = new NoOpTypeParameterMatcher();
    private static final Object TEST_OBJECT = new Object();

    public abstract boolean match(Object obj);

    public static TypeParameterMatcher get(Class<?> cls) {
        Map<Class<?>, TypeParameterMatcher> mapTypeParameterMatcherGetCache = InternalThreadLocalMap.get().typeParameterMatcherGetCache();
        TypeParameterMatcher typeParameterMatcherGenerate = mapTypeParameterMatcherGetCache.get(cls);
        if (typeParameterMatcherGenerate == null) {
            if (cls == Object.class) {
                typeParameterMatcherGenerate = NOOP;
            } else if (PlatformDependent.hasJavassist()) {
                try {
                    typeParameterMatcherGenerate = JavassistTypeParameterMatcherGenerator.generate(cls);
                    typeParameterMatcherGenerate.match(TEST_OBJECT);
                } catch (Exception | IllegalAccessError unused) {
                    typeParameterMatcherGenerate = null;
                }
            }
            if (typeParameterMatcherGenerate == null) {
                typeParameterMatcherGenerate = new ReflectiveMatcher(cls);
            }
            mapTypeParameterMatcherGetCache.put(cls, typeParameterMatcherGenerate);
        }
        return typeParameterMatcherGenerate;
    }

    public static TypeParameterMatcher find(Object obj, Class<?> cls, String str) {
        Map<Class<?>, Map<String, TypeParameterMatcher>> mapTypeParameterMatcherFindCache = InternalThreadLocalMap.get().typeParameterMatcherFindCache();
        Class<?> cls2 = obj.getClass();
        Map<String, TypeParameterMatcher> map = mapTypeParameterMatcherFindCache.get(cls2);
        if (map == null) {
            map = new HashMap<>();
            mapTypeParameterMatcherFindCache.put(cls2, map);
        }
        TypeParameterMatcher typeParameterMatcher = map.get(str);
        if (typeParameterMatcher != null) {
            return typeParameterMatcher;
        }
        TypeParameterMatcher typeParameterMatcher2 = get(find0(obj, cls, str));
        map.put(str, typeParameterMatcher2);
        return typeParameterMatcher2;
    }

    private static Class<?> find0(Object obj, Class<?> cls, String str) {
        Class<?> cls2 = obj.getClass();
        String name = str;
        Class<?> cls3 = cls;
        do {
            Class<?> superclass = cls2;
            while (superclass.getSuperclass() != cls3) {
                superclass = superclass.getSuperclass();
                if (superclass == null) {
                    return fail(cls2, name);
                }
            }
            int i = -1;
            TypeVariable<Class<? super Object>>[] typeParameters = superclass.getSuperclass().getTypeParameters();
            int i2 = 0;
            while (true) {
                if (i2 >= typeParameters.length) {
                    break;
                }
                if (name.equals(typeParameters[i2].getName())) {
                    i = i2;
                    break;
                }
                i2++;
            }
            if (i < 0) {
                throw new IllegalStateException("unknown type parameter '" + name + "': " + cls3);
            }
            Type genericSuperclass = superclass.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return Object.class;
            }
            Type rawType = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[i];
            if (rawType instanceof ParameterizedType) {
                rawType = ((ParameterizedType) rawType).getRawType();
            }
            if (rawType instanceof Class) {
                return (Class) rawType;
            }
            if (rawType instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) rawType).getGenericComponentType();
                if (genericComponentType instanceof ParameterizedType) {
                    genericComponentType = ((ParameterizedType) genericComponentType).getRawType();
                }
                if (genericComponentType instanceof Class) {
                    return Array.newInstance((Class<?>) genericComponentType, 0).getClass();
                }
            }
            if (rawType instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) rawType;
                if (!(typeVariable.getGenericDeclaration() instanceof Class)) {
                    return Object.class;
                }
                cls3 = (Class) typeVariable.getGenericDeclaration();
                name = typeVariable.getName();
            } else {
                return fail(cls2, name);
            }
        } while (cls3.isAssignableFrom(cls2));
        return Object.class;
    }

    private static Class<?> fail(Class<?> cls, String str) {
        throw new IllegalStateException("cannot determine the type of the type parameter '" + str + "': " + cls);
    }

    static final class ReflectiveMatcher extends TypeParameterMatcher {
        private final Class<?> type;

        ReflectiveMatcher(Class<?> cls) {
            this.type = cls;
        }

        @Override // io.netty.util.internal.TypeParameterMatcher
        public final boolean match(Object obj) {
            return this.type.isInstance(obj);
        }
    }

    protected TypeParameterMatcher() {
    }
}
