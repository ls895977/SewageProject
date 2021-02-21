package com.sewageproject.base;
import android.util.Log;
import com.google.gson.Gson;
import org.jetbrains.annotations.NotNull;
import java.util.HashMap;
import java.util.Map;
import okhttp3.MediaType;
import okhttp3.RequestBody;

public class BaseModel  {

    Map<String, String> map = new HashMap<>();
    public Gson gson;
    public RequestBody parsJson(Map<String, String> map) {
        gson = gson == null ? new Gson() : gson;
        String json = gson.toJson(map);
        Log.e("aa", "------------json==" + json);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return body;
    }

    public RequestBody parsObjJson(Map<String, Object> map) {
        gson = gson == null ? new Gson() : gson;
        String json = gson.toJson(map);
        Log.e("aa", "------------json==" + json);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return body;
    }

    public RequestBody parsObjJson(@NotNull Object map) {
        gson = gson == null ? new Gson() : gson;
        String json = gson.toJson(map);
        Log.e("aa", "------------json==" + json);
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        return body;
    }
}
