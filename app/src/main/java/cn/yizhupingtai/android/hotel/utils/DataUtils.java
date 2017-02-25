package cn.yizhupingtai.android.hotel.utils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by Administrator on 2017-2-25.
 */
public class DataUtils {

    public static  <T> T getData(Object o,Class clazz){
        Gson gson = new Gson();
        T t = (T) gson.fromJson(gson.toJson(o),clazz);
        return t;
    }
    public static <T> T getListOfOnlyData(Object o ,Class clazz){
        ArrayList<Map<?,?>> al = (ArrayList<Map<?, ?>>) o;
        if (al == null){
            throw new RuntimeException("参数不正确,解析的 不是 数组对象");
        }
        Gson gson = new Gson();
        int size = al.size();
        for (int i = 0; i < size; i++) {
            Map<?,?> map =al.get(i);
            T t = (T) gson.fromJson(gson.toJson(map),clazz);
            return t;
        }
      return null;
    }


    public static <T>ArrayList<T> getListData(Object o ,Class clazz){
        ArrayList<Map<?,?>> al = (ArrayList<Map<?, ?>>) o;
        if (al == null){
            throw new RuntimeException("参数不正确,解析的 不是 数组对象");
        }
        Gson gson = new Gson();
        int size = al.size();
        ArrayList<T> resultAl = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Map<?,?> map =al.get(i);
            T t = (T) gson.fromJson(gson.toJson(map),clazz);
            resultAl.add(t);
        }
        return resultAl;
    }

    public static <T>LinkedList<T> getLinkedData(Object o , Class clazz){
        ArrayList<Map<?,?>> al = (ArrayList<Map<?, ?>>) o;
        if (al == null){
            throw new RuntimeException("参数不正确,解析的 不是 数组对象");
        }
        Gson gson = new Gson();
        int size = al.size();
        LinkedList<T> resultAl = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            Map<?,?> map =al.get(i);
            T t = (T) gson.fromJson(gson.toJson(map),clazz);
            resultAl.add(t);
        }
        return resultAl;
    }

}
