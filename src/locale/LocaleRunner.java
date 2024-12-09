package locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {
    public static void main(String[] args) {
        Locale locale = new Locale("ru", "RU");
        System.out.println(Locale.getDefault());

        ResourceBundle translation = ResourceBundle.getBundle("translation", locale);
        System.out.println(translation.getString("page.login.password"));

    }
}
