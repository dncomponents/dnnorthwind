package com.dncomponents.northwind.i18n;

import com.dncomponents.I18n;
import com.dncomponents.client.components.core.DnI18e;
import com.dncomponents.client.components.core.I18nBinder;

@I18n
public class AppMessages_de extends DnI18e {

    private AppMessages_de() {
        I18nBinder.get(this.getClass(), this).bind();
    }

    private static AppMessages_de instance;

    public static AppMessages_de getInstance() {
        if (instance == null)
            instance = new AppMessages_de();
        return instance;
    }
}
