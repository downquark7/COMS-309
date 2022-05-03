package user_data;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {
    //public static String USERNAME_KEY;


    public static final String USERNAME_KEY = "username";
    //    private static final String APP_SHARED_PREFS = UserPreferences.class.getSimpleName(); //  Name of the file -.xml
    private static final String APP_SHARED_PREFS = UserPreferences.class.getSimpleName(); //  Name of the file -.xml

    private SharedPreferences _sharedPrefs;
    private SharedPreferences.Editor _prefsEditor;

    public UserPreferences(Context context) {
        this._sharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        this._prefsEditor = _sharedPrefs.edit();
    }

    public String getBody() {
        return _sharedPrefs.getString(USERNAME_KEY, "");
    }

    public void saveBody(String text) {
        _prefsEditor.putString(USERNAME_KEY, text);
        _prefsEditor.commit();
    }
}
