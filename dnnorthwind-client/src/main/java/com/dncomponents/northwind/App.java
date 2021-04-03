package com.dncomponents.northwind;

import com.dncomponents.bootstrap.client.BootstrapUi;
import com.dncomponents.client.components.core.AppTemplates;
import com.dncomponents.client.components.core.DnI18e;
import com.dncomponents.client.dom.History;
import com.dncomponents.client.views.Ui;
import com.dncomponents.northwind.i18n.AppMessages;
import com.dncomponents.northwind.i18n.AppMessages_de;
import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.WebStorageWindow;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
        AppTemplates.register();
        Ui.setDebug(true);
        Ui.set(new BootstrapUi());
        String language = WebStorageWindow.of(DomGlobal.window).localStorage.getItem("language");
        if (language == null || language.equals("english")) {
            DnI18e.set(AppMessages.getInstance()); //default language
        } else if (language.equals("german")) {
            DnI18e.set(AppMessages_de.getInstance()); //use this for german translation
        }
        MainApp main = new MainApp();
        DomGlobal.document.body.appendChild(main.asElement());
        History.fireCurrentHistoryState();
    }

}
