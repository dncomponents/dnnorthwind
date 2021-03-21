package com.dncomponents.northwind;

import com.dncomponents.UiField;
import com.dncomponents.client.components.AbstractCellComponent;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.components.core.entities.ItemId;
import com.dncomponents.client.components.sidemenu.SideMenu;
import com.dncomponents.client.dom.History;
import com.dncomponents.client.views.IsElement;
import com.dncomponents.client.views.appview.AcceptsOneElement;
import com.dncomponents.client.views.appview.PlaceManager;
import com.dncomponents.northwind.customer.CustomersPlace;
import com.dncomponents.northwind.dashboard.DashboardPlace;
import com.dncomponents.northwind.employees.EmployeesPlace;
import com.dncomponents.northwind.orders.OrdersPlace;
import com.dncomponents.northwind.products.ProductsPlace;
import com.dncomponents.northwind.suppliers.SuppliersPlace;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;

public class MainApp implements AcceptsOneElement {

    @UiField
    static HTMLElement contentWrapper;
    @UiField
    public SideMenu<ItemId> side;
    PlaceManager placeManager = new PlaceManager(this);
    HtmlBinder binder = HtmlBinder.get(MainApp.class, this);

    public MainApp() {
        binder.bind();
        init();
        side.setPlaceManager(placeManager);
        side.expandAll(true);
    }

    private void init() {
        placeManager.register(CustomersPlace.CustomersPlaceRegister.instance);
        placeManager.register(EmployeesPlace.EmployeesPlaceRegister.instance);
        placeManager.register(OrdersPlace.OrdersPlaceRegister.instance);
        placeManager.register(DashboardPlace.DashboardPlaceRegister.instance);
        placeManager.register(ProductsPlace.ProductsPlaceRegister.instance);
        placeManager.register(SuppliersPlace.SuppliersPlaceRegister.instance);
        placeManager.setHomePlace(DashboardPlace.class);
        History.fireCurrentHistoryState();
    }

    @Override
    public void setElement(IsElement element) {
        contentWrapper.innerHTML = "";
        contentWrapper.appendChild(element.asElement());
        AbstractCellComponent.resetScrollOnPage(contentWrapper);
    }

    public Node asElement() {
        return binder.getTemplate().getCloned();
    }

}
