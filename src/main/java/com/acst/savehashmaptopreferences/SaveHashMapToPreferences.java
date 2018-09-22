package com.acst.savehashmaptopreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Created by samuelbeck on 6/30/16.
 */
public class SaveHashMapToPreferences {


    public static void saveHashmap(HashMap<String, ArrayList<String>> map, String hasMapName, Context context) {
        Gson gson = new Gson();
        String hashMapString = gson.toJson(map);

        //save in shared prefs
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(hasMapName, hashMapString).apply();

    }

    public static HashMap<String, ArrayList<String>> getHashmap(String hashMapName, Context context) {
        //get from shared prefs
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String storedHashMapString = prefs.getString(hashMapName, null);
        java.lang.reflect.Type type = new TypeToken<HashMap<String, ArrayList<String>>>(){}.getType();
        return gson.fromJson(storedHashMapString, type);
    }

    public static void removeItemFromHashMap(String hashMapName, String item, Context context) {

        HashMap<String, ArrayList<String>> map = getHashmap(hashMapName, context);
        if (map != null) {
            map.remove(item);
            SaveHashMapToPreferences.saveHashmap(map, hashMapName, context);
        }
    }

    public static void addItemToHashMap(String hashMapName, String itemId, ArrayList<String> items, Context context) {
        HashMap<String, ArrayList<String>> map = getHashmap(hashMapName, context);
        if (map == null) {
            map = new HashMap<String, ArrayList<String>>();
        }
        map.put(itemId, items);
        saveHashmap(map, hashMapName, context);
    }


    public static void savePlainStringStringHashmap(HashMap<String, String> map, String name, Context context) {
        Gson gson = new Gson();
        String hashMapString = gson.toJson(map);

        //save in shared prefs
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.edit().putString(name, hashMapString).apply();

    }

    public static HashMap<String, String> getPlainStringStringHashmap(String name, Context context) {
        //get from shared prefs
        Gson gson = new Gson();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String storedHashMapString = prefs.getString(name, null);
        java.lang.reflect.Type type = new TypeToken<HashMap<String, String>>(){}.getType();
        return gson.fromJson(storedHashMapString, type);

    }

    public static void removeItemFromPlainStringStringHashMap(String hashMapName, String item, Context context) {

        HashMap<String, String> map = getPlainStringStringHashmap(hashMapName, context);
        if (map != null) {
            map.remove(item);
            SaveHashMapToPreferences.savePlainStringStringHashmap(map, hashMapName, context);
        }
    }

    public static void addItemToPlainStringStringHashMap(String hashMapName, String itemId, String item, Context context) {
        HashMap<String, String> map = getPlainStringStringHashmap(hashMapName, context);
        if (map == null) {
            map = new HashMap<String, String>();
        }
        map.put(itemId, item);
        savePlainStringStringHashmap(map, hashMapName, context);
    }

}
