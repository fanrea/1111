package com.bytedance.idl.api.serialize;

import com.bytedance.idl.api.serialize.json.ExcludeFieldStrategy;
import com.bytedance.idl.api.serialize.json.TypeAdapterFactoryContainer;
import com.bytedance.idl.api.serialize.json.a;
import com.bytedance.idl.api.serialize.json.b;
import com.bytedance.idl.api.serialize.json.c;
import com.bytedance.rpc.log.d;
import com.bytedance.rpc.serialize.SerializeType;
import com.bytedance.rpc.serialize.f;
import com.bytedance.rpc.serialize.h;
import com.bytedance.rpc.serialize.i;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.ConstructorConstructor;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class JsonSerializeFactory implements f {
    private a mAdapterFactoryFiller;
    private b mGsonBuilderFiller;
    private volatile Gson mGson = null;
    private final TypeAdapterFactoryContainer mTypeAdapterFactoryContainer = new TypeAdapterFactoryContainer();

    @Override // com.bytedance.rpc.serialize.f
    public boolean isReflectSupported() {
        return true;
    }

    public Gson getGson() {
        if (this.mGson == null) {
            synchronized (h.class) {
                if (this.mGson == null) {
                    GsonBuilder gsonBuilder = new GsonBuilder();
                    decorateGsonBuilder(gsonBuilder);
                    this.mGson = gsonBuilder.create();
                    if (this.mAdapterFactoryFiller != null) {
                        try {
                            Field declaredField = this.mGson.getClass().getDeclaredField("constructorConstructor");
                            declaredField.setAccessible(true);
                            fillFactory((ConstructorConstructor) declaredField.get(this.mGson));
                        } catch (Exception e) {
                            d.a(e);
                        }
                    }
                }
            }
        }
        return this.mGson;
    }

    private void fillFactory(ConstructorConstructor constructorConstructor) {
        if (this.mAdapterFactoryFiller != null) {
            ArrayList arrayList = new ArrayList();
            this.mAdapterFactoryFiller.a(constructorConstructor, arrayList);
            this.mAdapterFactoryFiller = null;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.mTypeAdapterFactoryContainer.addFactory((TypeAdapterFactory) it.next());
            }
        }
    }

    private void decorateGsonBuilder(GsonBuilder gsonBuilder) {
        b bVar = this.mGsonBuilderFiller;
        if (bVar != null) {
            bVar.a(gsonBuilder);
            this.mGsonBuilderFiller = null;
        }
        gsonBuilder.addSerializationExclusionStrategy(new ExcludeFieldStrategy(true));
        gsonBuilder.addDeserializationExclusionStrategy(new ExcludeFieldStrategy(false));
        gsonBuilder.registerTypeAdapterFactory(this.mTypeAdapterFactoryContainer);
    }

    @Override // com.bytedance.rpc.serialize.f
    public com.bytedance.rpc.serialize.d getDeserializer(com.bytedance.sdk.djx.proguard3.d.d dVar, Type type) {
        return new c(getGson(), dVar, type);
    }

    @Override // com.bytedance.rpc.serialize.f
    public i getSerializer(Object obj, SerializeType serializeType) {
        return new com.bytedance.idl.api.serialize.json.d(getGson(), obj, serializeType);
    }

    @Override // com.bytedance.rpc.serialize.f
    public SerializeType getSerializeType() {
        return SerializeType.JSON;
    }
}
