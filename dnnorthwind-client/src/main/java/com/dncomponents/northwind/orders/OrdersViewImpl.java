package com.dncomponents.northwind.orders;

import com.dncomponents.UiField;
import com.dncomponents.client.components.ColumnConfig;
import com.dncomponents.client.components.Table;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.components.core.RendererContext;
import com.dncomponents.client.components.core.TemplateParser;
import com.dncomponents.client.components.tab.Tab;
import com.dncomponents.client.components.tab.TabItem;
import com.dncomponents.client.components.table.columnclasses.TableCellDate;
import com.dncomponents.client.components.table.columnclasses.rowexpandercolumn.ColumnRowExpander;
import com.dncomponents.client.components.table.footer.NumberFooterCell;
import com.dncomponents.client.components.table.header.filter.FilterPanelList;
import com.dncomponents.client.views.appview.AbstractView;
import com.dncomponents.northwind.dto.*;
import elemental2.core.JsNumber;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTemplateElement;
import elemental2.dom.Node;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.dncomponents.client.components.core.DnI18n.t;

public class OrdersViewImpl extends AbstractView<OrdersActivity> implements OrdersView {
    private static OrdersViewImpl instance;

    @UiField
    HTMLElement root;
    @UiField
    Table<OrderDTOWrapper> ordersTable;
    @UiField
    HTMLTemplateElement productPanelTemplate;
    @UiField
    HTMLTemplateElement shippingPanelTemplate;
    boolean firstInit = false;
    private List<CustomerDTOWrapper> customerDTOS;
    private List<EmployeeDTOWrapper> employeeDTOS;

    {
        HtmlBinder.get(OrdersViewImpl.class, this).bind();
    }

    private OrdersViewImpl() {
    }

    private static String round(Double r) {
        return new JsNumber(r).toFixed(2);
    }

    private static void setTextContent(RendererContext<OrderDetailDTOWrapper, Double> r, String text) {
        r.valuePanel.textContent = text;
    }

    public static OrdersViewImpl getInstance() {
        if (instance == null)
            instance = new OrdersViewImpl();
        return instance;
    }

    private Table<OrderDetailDTOWrapper> initOrderDetailsTable(List<OrderDetailDTOWrapper> data) {
        ColumnRowExpander<OrderDetailDTOWrapper> columnRowExpander = new ColumnRowExpander<>();
        columnRowExpander.setColumnWidth("40px");
        columnRowExpander.setRowDetailsRenderer((orderDetailDTO, valuePanel) ->
                valuePanel.appendChild(createProductPanel(orderDetailDTO.getProduct())));

        ColumnConfig<OrderDetailDTOWrapper, String> productNameColumn = new ColumnConfig.Builder<OrderDetailDTOWrapper, String>()
                .setFieldGetter(orderDetailDTO -> orderDetailDTO.getProduct().getProduct_name())
                .setColumnWidth("180px")
                .setName("Product Name")
                .build();

        ColumnConfig<OrderDetailDTOWrapper, Double> unitPriceColumn = new ColumnConfig.Builder<OrderDetailDTOWrapper, Double>()
                .setFieldGetter(orderDetailDTO -> orderDetailDTO.getUnit_price())
                .setColumnWidth("80px")
                .setCellRenderer(r -> setTextContent(r, "$" + round(r.value)))
                .setName("Unit Price")
                .build();

        ColumnConfig<OrderDetailDTOWrapper, Integer> quantityColumn = new ColumnConfig.Builder<OrderDetailDTOWrapper, Integer>()
                .setFieldGetter(orderDetailDTO -> orderDetailDTO.getQuantity())
                .setColumnWidth("80px")
                .setName("Quantity")
                .build();

        ColumnConfig<OrderDetailDTOWrapper, Double> discountColumn = new ColumnConfig.Builder<OrderDetailDTOWrapper, Double>()
                .setFieldGetter(orderDetailDTO -> orderDetailDTO.getDiscount())
                .setColumnWidth("80px")
                .setCellRenderer(r -> setTextContent(r, round(r.value * 100) + "%"))
                .setName("Discount")
                .build();

        ColumnConfig<OrderDetailDTOWrapper, Double> totalColumn = new ColumnConfig.Builder<OrderDetailDTOWrapper, Double>()
                .setFieldGetter(orderDetail -> {
                    Double total = orderDetail.getUnit_price() * new Double(orderDetail.getQuantity() + "");
                    if (orderDetail.getDiscount() != 0) {
                        total = total - (total * orderDetail.getDiscount());
                    }
                    return total;
                })
                .setCellRenderer(r -> setTextContent(r, "$" + round(r.value)))
                .setFooterCellFactory(() ->
                        new NumberFooterCell<>(NumberFooterCell.Types.SUM,
                                n -> "<b>$" + round(n.doubleValue()) + "</b>"))
                .setColumnWidth("80px")
                .setName("Total")
                .build();

        Table<OrderDetailDTOWrapper> table = new Table<>();
        table.addColumn(columnRowExpander, productNameColumn, unitPriceColumn, quantityColumn, discountColumn, totalColumn);
        table.setRowsData(data);
        table.drawData();
        return table;
    }

    private Node createProductPanel(ProductDTO product) {
        TemplateParser t = new TemplateParser(productPanelTemplate, true);
        t.getHTMLElement("inStockLbl").textContent = product.getUnits_in_stock() + "";
        t.getHTMLElement("inOrderLbl").textContent = product.getUnits_on_order() + "";
        t.getHTMLElement("reorderLbl").textContent = product.getReorder_level() + "";
        t.getHTMLElement("quantityPerUnitLbl").textContent = product.getQuantity_per_unit() + "";
        return t.getCloned();
    }

    private Node createShippingPanel(CustomerDTOWrapper dto) {
        TemplateParser t = new TemplateParser(shippingPanelTemplate, true);
        t.getHTMLElement("name").textContent = dto.getCompany_name() + "";
        t.getHTMLElement("country").textContent = dto.getCountry() + "";
        t.getHTMLElement("city").textContent = dto.getCity() + "";
        t.getHTMLElement("address").textContent = dto.getAddress() + "";
        t.getHTMLElement("postalCode").textContent = dto.getPostal_code() + "";
        return t.getCloned();
    }

    private void init() {
        ColumnRowExpander<OrderDTOWrapper> columnRowExpander = new ColumnRowExpander<>();
        columnRowExpander.setColumnWidth("40px");
        columnRowExpander.setRowDetailsRenderer((orderDTO, valuePanel) -> {
            Tab tab = new Tab();
            TabItem tabItem = new TabItem(tab);
            tabItem.setTitle(t("products"));
            TabItem<Object> tabItem2 = new TabItem(tab);
            tabItem2.setTitle(t("shipping_details"));
            tab.addItem(tabItem);
            tab.addItem(tabItem2);
            final HTMLElement table = initOrderDetailsTable(orderDTO.getOrderDetails()).asElement();
            tabItem.setContent(se -> se.appendChild(table));
            final Node shippingPanel = createShippingPanel(orderDTO.getCustomer());
            tabItem2.setContent(se -> se.appendChild(shippingPanel));
            valuePanel.classList.add("px-3");
            valuePanel.appendChild(tab.asElement());
        });

        ColumnConfig<OrderDTOWrapper, Integer> idColumn = new ColumnConfig.Builder<OrderDTOWrapper, Integer>()
                .setFieldGetter(orderDTO -> orderDTO.getOrder_id())
                .setClazz(Integer.class)
                .setColumnWidth("80px")
                .setName("Id")
                .build();

        ColumnConfig<OrderDTOWrapper, Date> orderDateColumn = new ColumnConfig.Builder<OrderDTOWrapper, Date>()
                .setFieldGetter(orderDTO -> orderDTO.getOrder_date())
                .setColumnWidth("80px")
                .setClazz(String.class)
                .setCellFactory(c -> new TableCellDate<>())
                .setName(t("order_date"))
                .build();

        ColumnConfig<OrderDTOWrapper, CustomerDTOWrapper> customerColumn = new ColumnConfig.Builder<OrderDTOWrapper, CustomerDTOWrapper>()
                .setFieldGetter(orderDTO -> orderDTO.getCustomer())
                .setColumnWidth("180px")
                .setCellRenderer(r -> r.valuePanel.innerHTML = r.value.getCompany_name())
                .setName(t("customer"))
                .setFilterPanelFactory(() -> new FilterPanelList(customerDTOS))
                .build();

        ColumnConfig<OrderDTOWrapper, EmployeeDTOWrapper> employeeColumn = new ColumnConfig.Builder<OrderDTOWrapper, EmployeeDTOWrapper>()
                .setFieldGetter(orderDTO -> orderDTO.getEmployee())
                .setColumnWidth("150px")
                .setCellRenderer(r -> r.valuePanel.innerHTML = r.value.toString())
                .setName(t("employee"))
                .setFilterPanelFactory(() -> new FilterPanelList(employeeDTOS))
                .build();

        ColumnConfig<OrderDTOWrapper, String> shipCountryColumn = new ColumnConfig.Builder<OrderDTOWrapper, String>()
                .setFieldGetter(orderDTO -> orderDTO.getShip_country())
                .setColumnWidth("80px")
                .setClazz(String.class)
                .setName(t("ship_country"))
                .build();

        ordersTable.setMultiSorting(true);
        ordersTable.setScrollHeight("600px");
        ordersTable.addColumn(columnRowExpander, idColumn, orderDateColumn,
                customerColumn, employeeColumn, shipCountryColumn);
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void setOrders(OrderDTO[] orders) {
        final List<OrderDTOWrapper> orderDTOS = Arrays.asList(orders).stream()
                .map(o -> o.wrap())
                .collect(Collectors.toList());

        customerDTOS = orderDTOS.stream()
                .map(orderDTO -> orderDTO.getCustomer())
                .distinct()
                .collect(Collectors.toList());

        employeeDTOS = orderDTOS.stream()
                .map(orderDTO -> orderDTO.getEmployee())
                .distinct()
                .collect(Collectors.toList());

        if (!firstInit) {
            init();
            firstInit = true;
        }
        ordersTable.setRowsData(orderDTOS);
        ordersTable.drawData();

    }

}
