package com.futuremobile.wox.presentation.utiles;

import androidx.room.TypeConverter;


import com.futuremobile.wox.domain.model.Asset;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;
import java.util.ArrayList;

public class Converters {

   public static Gson gson = new Gson();

    @TypeConverter
    public static ArrayList<Asset> stringToSomeObjectList(String data) {
        ArrayList<Asset> listavacia= new ArrayList();
        if (data == null) {
            return listavacia;
        }

        Type listType = new TypeToken<ArrayList<Asset>>() {}.getType();

        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String someObjectListToString(ArrayList<Asset> someObjects) {
        return gson.toJson(someObjects);
    }

}
