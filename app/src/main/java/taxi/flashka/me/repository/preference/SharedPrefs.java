package taxi.flashka.me.repository.preference;

import android.content.Context;

public final class SharedPrefs {

    private static final String
            APP_SETTINGS = "APP_SETTINGS",
            TOKEN = "TOKEN";

    private static String token;

    private static final SharedPrefs sharedPrefs = new SharedPrefs();

    private SharedPrefs() {

    }

    public static SharedPrefs getInstance() {
        return sharedPrefs;
    }

    public String getToken(Context context) {
        if (token == null) {
            token = context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE).getString(TOKEN, "");
        }
        return token;
    }

    public void setToken(Context context, String token) {
        SharedPrefs.token = null;
        context.getSharedPreferences(APP_SETTINGS, Context.MODE_PRIVATE).edit()
                .putString(TOKEN, token).apply();
    }

}
