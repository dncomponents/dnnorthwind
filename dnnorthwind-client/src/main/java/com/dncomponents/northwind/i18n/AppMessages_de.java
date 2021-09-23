package com.dncomponents.northwind.i18n;

import com.dncomponents.I18n;
import com.dncomponents.client.components.core.DnI18n;
import com.dncomponents.client.components.core.I18nBinder;

@I18n
public class AppMessages_de extends DnI18n {

    private static AppMessages_de instance;

    private AppMessages_de() {
        I18nBinder.get(this.getClass(), this).bind();
        setFallback(AppMessages.getInstance());
    }

    public static AppMessages_de getInstance() {
        if (instance == null)
            instance = new AppMessages_de();
        return instance;
    }
}
