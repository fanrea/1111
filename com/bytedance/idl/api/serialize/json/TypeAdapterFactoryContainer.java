package com.bytedance.idl.api.serialize.json;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class TypeAdapterFactoryContainer implements TypeAdapterFactory {
    private final List<TypeAdapterFactory> mFactories = new ArrayList();

    public void addFactory(TypeAdapterFactory typeAdapterFactory) {
        this.mFactories.add(typeAdapterFactory);
    }

    @Override // com.google.gson.TypeAdapterFactory
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
        Iterator<TypeAdapterFactory> it = this.mFactories.iterator();
        while (it.hasNext()) {
            TypeAdapter<T> typeAdapterCreate = it.next().create(gson, typeToken);
            if (typeAdapterCreate != null) {
                return typeAdapterCreate;
            }
        }
        return null;
    }
}
