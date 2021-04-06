package com.dncomponents.northwind.products;

import com.dncomponents.UiField;
import com.dncomponents.client.components.ColumnConfig;
import com.dncomponents.client.components.Table;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.components.core.validation.validators.EmptyValidator;
import com.dncomponents.client.components.modal.Dialog;
import com.dncomponents.client.components.table.columnclasses.editcolumn.ColumnEdit;
import com.dncomponents.client.views.appview.AbstractView;
import com.dncomponents.northwind.dto.ProductDTO;
import elemental2.dom.HTMLElement;

import java.util.Arrays;

import static com.dncomponents.client.components.core.DnI18e.t;

public class ProductsViewImpl extends AbstractView<ProductsActivity> implements ProductsView {
    private static ProductsViewImpl instance;

    @UiField
    HTMLElement root;
    @UiField
    Table<ProductDTO> productsTable;

    {
        HtmlBinder.get(ProductsViewImpl.class, this).bind();
    }

    public ProductsViewImpl() {
        //create
        productsTable.addRowAddedHandler(event -> {
            presenter.addNewProduct(event.getRow().getModel(), new AsyncCallBack<ProductDTO>() {
                @Override
                public void onSuccess(ProductDTO result) {
                    event.updateModel(result);
                    Dialog.show("Success", "Record added!");
                }

                @Override
                public void onFailure(Throwable caught) {
                    Dialog.show("Error", caught.getMessage());
                    event.removeAddedRow();
                }
            });
        });
        //update
        productsTable.addRowValueChangedHandler(event ->
                presenter.updateProduct(event.getRow().getModel(), new AsyncCallBack<ProductDTO>() {
                    @Override
                    public void onSuccess(ProductDTO result) {
                        Dialog.show("Success", "Record updated!");
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        Dialog.show("Error", caught.getMessage());
                        event.revertChanges();
                    }
                }));
        //remove
        productsTable.addRowRemovedHandler(event -> {
            final Integer id = event.getRow().getModel().getProduct_id();
            presenter.removeProduct(id, new AsyncCallBack() {
                @Override
                public void onSuccess(Object result) {
                    Dialog.show("Success", "Record removed!");
                }

                @Override
                public void onFailure(Throwable caught) {
                    Dialog.show("Error", caught.getMessage());
                    event.revertDeletedRow();
                }
            });
        });
        init();
    }

    public static ProductsViewImpl getInstance() {
        if (instance == null)
            instance = new ProductsViewImpl();
        return instance;
    }

    private void init() {
        ColumnConfig<ProductDTO, String> productNameColumn = new ColumnConfig.Builder<ProductDTO, String>()
                .setFieldGetter(productDTO -> productDTO.getProduct_name())
                .setFieldSetter((productDTO, s) -> productDTO.setProduct_name(s))
                .setClazz(String.class)
                .setEditable(true)
                .setColumnWidth("200px")
                .setValidator(new EmptyValidator<>())
                .setName(t("product_name"))
                .build();

        ColumnConfig<ProductDTO, String> quantityColumn = new ColumnConfig.Builder<ProductDTO, String>()
                .setFieldGetter(productDTO -> productDTO.getQuantity_per_unit())
                .setFieldSetter((productDTO, s) -> productDTO.setQuantity_per_unit(s))
                .setColumnWidth("140px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("quantity"))
                .build();

        ColumnConfig<ProductDTO, Double> unitPriceColumn = new ColumnConfig.Builder<ProductDTO, Double>()
                .setFieldGetter(productDTO -> productDTO.getUnit_price())
                .setFieldSetter((productDTO, s) -> productDTO.setUnit_price(s))
                .setColumnWidth("100px")
                .setEditable(true)
                .setClazz(Double.class)
                .setName(t("unit_price"))
                .build();

        ColumnConfig<ProductDTO, Integer> unitInStockColumn = new ColumnConfig.Builder<ProductDTO, Integer>()
                .setFieldGetter(productDTO -> productDTO.getUnits_in_stock())
                .setFieldSetter((productDTO, s) -> productDTO.setUnits_in_stock(s))
                .setColumnWidth("100px")
                .setEditable(true)
                .setClazz(Integer.class)
                .setName(t("units_in_stock"))
                .build();

        ColumnConfig<ProductDTO, Boolean> discontinuedColumn = new ColumnConfig.Builder<ProductDTO, Boolean>()
                .setFieldGetter(productDTO -> productDTO.getDiscontinued())
                .setFieldSetter((productDTO, s) -> productDTO.setDiscontinued(s))
                .setColumnWidth("100px")
                .setEditable(true)
                .setValidator(new EmptyValidator<>())
                .setClazz(Boolean.class)
                .setName(t("discontinued"))
                .build();

        ColumnEdit<ProductDTO> columnEdit = new ColumnEdit<>(ProductDTO::new, false);
        columnEdit.setColumnWidth("90px");
        productsTable.addColumn(productNameColumn, quantityColumn,
                unitPriceColumn, unitInStockColumn, discontinuedColumn, columnEdit);
        productsTable.setMultiSorting(true);
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

    @Override
    public void showError(String message) {
        Dialog.show("Error", message);
    }

    @Override
    public void setProducts(ProductDTO[] products) {
        productsTable.setRowsData(Arrays.asList(products));
        productsTable.drawData();
    }

}
