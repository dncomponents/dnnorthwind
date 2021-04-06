package com.dncomponents.northwind;

import com.dncomponents.bootstrap.client.BootstrapUi;
import com.dncomponents.client.components.core.AppTemplates;
import com.dncomponents.client.dom.History;
import com.dncomponents.client.views.Ui;
import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;

import static com.dncomponents.northwind.Language.setLanguage;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class App implements EntryPoint {

    @Override
    public void onModuleLoad() {
        AppTemplates.register();
        Ui.setDebug(true);
        Ui.set(new BootstrapUi());
        setLanguage();
        MainApp main = new MainApp();
        DomGlobal.document.body.appendChild(main.asElement());
        History.fireCurrentHistoryState();
    }

}
