package com.dncomponents.northwind.suppliers;

import com.dncomponents.UiField;
import com.dncomponents.client.components.ColumnConfig;
import com.dncomponents.client.components.Table;
import com.dncomponents.client.components.core.HtmlBinder;
import com.dncomponents.client.components.core.events.AsyncCallBack;
import com.dncomponents.client.components.core.validation.Validators;
import com.dncomponents.client.components.core.validation.validators.EmailValidator;
import com.dncomponents.client.components.core.validation.validators.EmptyValidator;
import com.dncomponents.client.components.modal.Dialog;
import com.dncomponents.client.components.table.columnclasses.editcolumn.ColumnEdit;
import com.dncomponents.client.views.appview.AbstractView;
import com.dncomponents.northwind.dto.SupplierDTO;
import com.dncomponents.northwind.dto.SupplierDTOWrapper;
import elemental2.dom.HTMLElement;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.dncomponents.client.components.core.DnI18n.t;

public class SuppliersViewImpl extends AbstractView<SuppliersActivity> implements SuppliersView {

    private static SuppliersViewImpl instance;

    @UiField
    HTMLElement root;
    @UiField
    Table<SupplierDTOWrapper> suppliersTable;

    {
        HtmlBinder.get(SuppliersViewImpl.class, this).bind();
    }

    private SuppliersViewImpl() {
        //create
        suppliersTable.addRowAddedHandler(event ->
                presenter.addNewSupplier(event.getRow().getModel().unWrap(),
                        new AsyncCallBack<SupplierDTO>() {
                            @Override
                            public void onSuccess(SupplierDTO result) {
                                Dialog.show("Success", "Record added!");
                            }

                            @Override
                            public void onFailure(Throwable caught) {
                                Dialog.show("Error", caught.getMessage());
                                event.removeAddedRow();
                            }
                        }));
        //update
        suppliersTable.addRowValueChangedHandler(event ->
                presenter.updateSupplier(event.getRow().getModel().unWrap(),
                        new AsyncCallBack<SupplierDTO>() {
                            @Override
                            public void onSuccess(SupplierDTO result) {
                                Dialog.show("Success", "Record updated!");
                            }

                            @Override
                            public void onFailure(Throwable caught) {
                                Dialog.show("Error", caught.getMessage());
                                event.revertChanges();
                            }
                        }));

        //remove
        suppliersTable.addRowRemovedHandler(event -> {
            final Integer id = event.getRow().getModel().getSupplier_id();
            presenter.removeSupplier(id, new AsyncCallBack() {
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

    public static SuppliersViewImpl getInstance() {
        if (instance == null)
            instance = new SuppliersViewImpl();
        return instance;
    }

    private void init() {
        ColumnConfig<SupplierDTOWrapper, String> companyNameColumn = new ColumnConfig.Builder<SupplierDTOWrapper, String>()
                .setFieldGetter(dto -> dto.getCompany_name())
                .setFieldSetter((dto, s) -> dto.setCompany_name(s))
                .setClazz(String.class)
                .setEditable(true)
                .setColumnWidth("180px")
                .setValidator(new EmptyValidator<>())
                .setName(t("company"))
                .build();

        ColumnConfig<SupplierDTOWrapper, String> contactNameColumn = new ColumnConfig.Builder<SupplierDTOWrapper, String>()
                .setFieldGetter(dto -> dto.getContact_name())
                .setFieldSetter((dto, s) -> dto.setContact_name(s))
                .setColumnWidth("130px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("contact_name"))
                .build();
        ColumnConfig<SupplierDTOWrapper, String> emailColumn = new ColumnConfig.Builder<SupplierDTOWrapper, String>()
                .setFieldGetter(dto -> dto.getEmail())
                .setFieldSetter((dto, s) -> dto.setEmail(s))
                .setColumnWidth("130px")
                .setEditable(true)
                .setValidator(new Validators<String>()
                        .add(new EmptyValidator<>(), true)
                        .add(new EmailValidator()))
                .setClazz(String.class)
                .setName(t("email"))
                .build();

        ColumnConfig<SupplierDTOWrapper, String> addressColumn = new ColumnConfig.Builder<SupplierDTOWrapper, String>()
                .setFieldGetter(dto -> dto.getAddress())
                .setFieldSetter((dto, s) -> dto.setAddress(s))
                .setColumnWidth("150px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("address"))
                .build();

        ColumnConfig<SupplierDTOWrapper, String> cityColumn = new ColumnConfig.Builder<SupplierDTOWrapper, String>()
                .setFieldGetter(dto -> dto.getCity())
                .setFieldSetter((dto, s) -> dto.setCity(s))
                .setColumnWidth("80px")
                .setEditable(true)
                .setClazz(String.class)
                .setName(t("city"))
                .build();

        ColumnEdit<SupplierDTOWrapper> columnEdit = new ColumnEdit<>(SupplierDTOWrapper::new, false);
        columnEdit.setColumnWidth("90px");
        suppliersTable.addColumn(companyNameColumn, contactNameColumn, emailColumn, addressColumn, cityColumn, columnEdit);
        suppliersTable.setMultiSorting(true);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void setSuppliers(SupplierDTO[] suppliers) {
        suppliersTable.setRowsData(Arrays.asList(suppliers).stream()
                .map(s -> s.wrap())
                .collect(Collectors.toList()));
        suppliersTable.drawData();
    }

    @Override
    public HTMLElement asElement() {
        return root;
    }

}
