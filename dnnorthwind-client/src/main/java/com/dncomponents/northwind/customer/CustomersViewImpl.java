package com.dncomponents.northwind.customer;

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
import com.dncomponents.northwind.dto.CustomerDTO;
import com.dncomponents.northwind.dto.CustomerDTOWrapper;
import elemental2.dom.HTMLElement;

import java.util.Arrays;
import java.util.stream.Collectors;


public class CustomersViewImpl extends AbstractView<CustomersActivity> implements CustomersView {
    private static CustomersViewImpl instance;

    @UiField
    HTMLElement root;
    @UiField
    Table<CustomerDTOWrapper> customersTable;

    {
        HtmlBinder.get(CustomersViewImpl.class, this).bind();
    }

    public CustomersViewImpl() {
        customersTable.addCellValueChangedHandler(event ->
                presenter.updateModel(event.getCell().getModel().unWrap(),
                        new AsyncCallBack<CustomerDTO>() {
                            @Override
                            public void onSuccess(CustomerDTO result) {
                                Dialog.show("Success", "Record updated!");
                            }

                            @Override
                            public void onFailure(Throwable caught) {
                                Dialog.show("Error", caught.getMessage());
                                event.revertChanges();
                            }
                        }));
        //create
        customersTable.addRowAddedHandler(event ->
                presenter.addNewCustomer(event.getRow().getModel().unWrap(),
                        new AsyncCallBack<CustomerDTO>() {
                            @Override
                            public void onSuccess(CustomerDTO result) {
                                Dialog.show("Success", "Record added!");
                            }

                            @Override
                            public void onFailure(Throwable caught) {
                                Dialog.show("Error", caught.getMessage());
                                event.removeAddedRow();
                            }
                        }));
        //update
        customersTable.addRowValueChangedHandler(event -> presenter.updateModel(event.getRow().getModel().unWrap(),
                new AsyncCallBack<CustomerDTO>() {
                    @Override
                    public void onSuccess(CustomerDTO result) {
                        Dialog.show("Success", "Record updated!");
                    }

                    @Override
                    public void onFailure(Throwable caught) {
                        Dialog.show("Error", caught.getMessage());
                        event.revertChanges();
                    }
                }));

        //remove
        customersTable.addRowRemovedHandler(event -> {
            final Integer id = event.getRow().getModel().getCustomer_id();
            presenter.removeCustomer(id, new AsyncCallBack() {
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

    public static CustomersViewImpl getInstance() {
        if (instance == null)
            instance = new CustomersViewImpl();
        return instance;
    }

    private void init() {
        ColumnConfig<CustomerDTOWrapper, String> companyColumn = new ColumnConfig.Builder<CustomerDTOWrapper, String>()
                .setFieldGetter(customerDTO -> customerDTO.getCompany_name())
                .setFieldSetter((customerDTO, s) -> customerDTO.setCompany_name(s))
                .setClazz(String.class)
                .setColumnWidth("250px")
                .setEditable(true)
                .setValidator(new EmptyValidator<>())
                .setName("Company Name")
                .build();

        ColumnConfig<CustomerDTOWrapper, String> contactNameColumn = new ColumnConfig.Builder<CustomerDTOWrapper, String>()
                .setFieldGetter(customerDTO -> customerDTO.getContact_name())
                .setFieldSetter((customerDTO, s) -> customerDTO.setContact_name(s))
                .setColumnWidth("180px")
                .setEditable(true)
                .setClazz(String.class)
                .setName("Contact Name")
                .build();

        ColumnConfig<CustomerDTOWrapper, String> contactTitleColumn = new ColumnConfig.Builder<CustomerDTOWrapper, String>()
                .setFieldGetter(customerDTO -> customerDTO.getContact_title())
                .setFieldSetter((customerDTO, s) -> customerDTO.setContact_title(s))
                .setColumnWidth("180px")
                .setEditable(true)
                .setClazz(String.class)
                .setName("Contact title")
                .build();

        ColumnConfig<CustomerDTOWrapper, String> addressColumn = new ColumnConfig.Builder<CustomerDTOWrapper, String>()
                .setFieldGetter(customerDTO -> customerDTO.getAddress())
                .setFieldSetter((customerDTO, s) -> customerDTO.setAddress(s))
                .setColumnWidth("250px")
                .setEditable(true)
                .setClazz(String.class)
                .setName("Address")
                .build();

        ColumnConfig<CustomerDTOWrapper, String> countryColumn = new ColumnConfig.Builder<CustomerDTOWrapper, String>()
                .setFieldGetter(customerDTO -> customerDTO.getCountry())
                .setFieldSetter((customerDTO, s) -> customerDTO.setCountry(s))
                .setColumnWidth("150px")
                .setEditable(true)
                .setClazz(String.class)
                .setName("Country")
                .build();

        ColumnConfig<CustomerDTOWrapper, String> cityColumn = new ColumnConfig.Builder<CustomerDTOWrapper, String>()
                .setFieldGetter(customerDTO -> customerDTO.getCity())
                .setFieldSetter((customerDTO, s) -> customerDTO.setCity(s))
                .setColumnWidth("150px")
                .setEditable(true)
                .setClazz(String.class)
                .setName("City")
                .build();

        ColumnConfig<CustomerDTOWrapper, String> emailColumn = new ColumnConfig.Builder<CustomerDTOWrapper, String>()
                .setFieldGetter(customerDTO -> customerDTO.getEmail())
                .setFieldSetter((customerDTO, s) -> customerDTO.setEmail(s))
                .setName("Email")
                .setColumnWidth("220px")
                .setEditable(true)
                .setValidator(new Validators<String>()
                        .add(new EmptyValidator<>(), true)
                        .add(new EmailValidator()))
                .setClazz(String.class)
                .build();

        ColumnEdit<CustomerDTOWrapper> columnEdit = new ColumnEdit<>(CustomerDTOWrapper::new, false);
        columnEdit.setColumnWidth("90px");
        customersTable.setCellEditMode(true);
        customersTable.addColumn(companyColumn, contactNameColumn, emailColumn,
                contactNameColumn, contactTitleColumn, addressColumn, countryColumn, cityColumn
        );
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
    public void setCustomers(CustomerDTO[] customers) {
        customersTable.setRowsData(Arrays.asList(customers).stream()
                .map(c -> c.wrap())
                .collect(Collectors.toList())
        );
        customersTable.drawData();
    }

}
