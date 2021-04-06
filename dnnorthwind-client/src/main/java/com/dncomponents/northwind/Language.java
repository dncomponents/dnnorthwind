package com.dncomponents.northwind;

import com.dncomponents.client.components.core.DnI18e;
import com.dncomponents.client.components.core.entities.ItemId;
import com.dncomponents.client.components.dropdown.DropDown;
import com.dncomponents.northwind.i18n.AppMessages;
import com.dncomponents.northwind.i18n.AppMessages_de;
import elemental2.dom.DomGlobal;
import elemental2.webstorage.Storage;
import elemental2.webstorage.WebStorageWindow;

public class Language {

    static Storage storage = WebStorageWindow.of(DomGlobal.window).localStorage;
    private static String LANGUAGE = "language";

    public static void addToDropdown(DropDown<ItemId> languageDd) {
        final String language = getLanguage();
        if (language != null)
            languageDd.setButtonContent(language);
        languageDd.addSelectionHandler(event -> {
                    final String id = event.getSelectedItem().getUserObject().getId();
                    storage.setItem(LANGUAGE, id);
                    languageDd.setButtonContent(id);
                    DomGlobal.location.reload();
                }
        );
    }

    private static String getLanguage() {
        return storage.getItem(LANGUAGE);
    }

    public static void setLanguage() {
        String language = getLanguage();
        if (language == null || language.equals("english")) {
            DnI18e.set(AppMessages.getInstance()); //default language
        } else if (language.equals("german")) {
            DnI18e.set(AppMessages_de.getInstance()); //use this for german translation
        }
    }

}
