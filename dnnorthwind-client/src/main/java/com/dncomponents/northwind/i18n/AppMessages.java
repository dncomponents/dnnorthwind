package com.dncomponents.northwind.i18n;

import com.dncomponents.I18n;
import com.dncomponents.client.components.core.DnI18e;
import com.dncomponents.client.components.core.I18nBinder;

@I18n
public class AppMessages extends DnI18e {

    private AppMessages() {
        I18nBinder.get(this.getClass(), this).bind();
    }

    private static AppMessages instance;

    public static AppMessages getInstance() {
        if (instance == null)
            instance = new AppMessages();
        return instance;
    }

}
