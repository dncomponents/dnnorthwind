package com.dncomponents.northwind.i18n;

import com.dncomponents.I18n;
import com.dncomponents.client.components.core.DnI18n;
import com.dncomponents.client.components.core.I18nBinder;

@I18n
public class AppMessages extends DnI18n {

    private static AppMessages instance;

    private AppMessages() {
        I18nBinder.get(this.getClass(), this).bind();
    }

    public static AppMessages getInstance() {
        if (instance == null)
            instance = new AppMessages();
        return instance;
    }

}
