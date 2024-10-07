package com.android.scientificcalci;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class CalculationHistoryManager {
    private static final String PREF_NAME = "CalculationHistory";
    private static final String HISTORY_KEY = "history";
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public CalculationHistoryManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
    }

    public void addHistory(String calculation) {
        List<String> history = getHistory();
        history.add(calculation);
        saveHistory(history);
    }

    public List<String> getHistory() {
        String historyJson = sharedPreferences.getString(HISTORY_KEY, null);
        Type type = new TypeToken<List<String>>(){}.getType();
        return gson.fromJson(historyJson, type);
    }

    private void saveHistory(List<String> history) {
        String historyJson = gson.toJson(history);
        sharedPreferences.edit().putString(HISTORY_KEY, historyJson).apply();
    }

    public void clearHistory() {
        sharedPreferences.edit().remove(HISTORY_KEY).apply();
    }
}

