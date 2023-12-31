package com.example.application.views.viento;

import com.example.Utils.Util;
import com.example.application.views.MainLayout;
import com.example.models.Cuerda;
import com.example.models.Producto;
import com.example.models.Viento;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;

import java.util.ArrayList;
import java.util.List;

@PageTitle("Viento")
@Route(value = "viento", layout = MainLayout.class)
@Uses(Icon.class)
public class VientoView extends Composite<VerticalLayout> {

    private Viento vientoEditable;
    VerticalLayout layoutColumn2 = new VerticalLayout();
    HorizontalLayout layoutRow = new HorizontalLayout();
    TextField textField = new TextField();
    TextField textField2 = new TextField();
    HorizontalLayout layoutRow2 = new HorizontalLayout();
    TextField textField3 = new TextField();
    TextField textField4 = new TextField();
    HorizontalLayout layoutRow3 = new HorizontalLayout();
    TextField textField5 = new TextField();
    TextField textField6 = new TextField();
    HorizontalLayout layoutRow4 = new HorizontalLayout();
    TextField textField7 = new TextField();
    ComboBox comboBox = new ComboBox();
    HorizontalLayout layoutRow5 = new HorizontalLayout();
    Button guardar = new Button();
    Button cancelar = new Button();


    public VientoView() {
        Producto producto = Util.getProductoEditable();
        if(producto != null) {
            rellenarFormularioConDatosProducto(producto);
        }

        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        layoutColumn2.setWidth("100%");
        layoutColumn2.getStyle().set("flex-grow", "1");
        layoutRow.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");

        textField.setLabel("Nombre");
        textField.setWidth("380px");
        textField.setRequired(true);
        textField.setErrorMessage("Campo Obligatorio");
        textField2.setLabel("Codigo");
        textField2.setWidth("380px");
        textField2.setRequired(true);
        textField2.setErrorMessage("Campo Obligatorio");
        layoutRow2.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        textField3.setLabel("Precio");
        textField3.setWidth("380px");
        textField3.setRequired(true);
        textField3.setErrorMessage("Campo Obligatorio");
        textField4.setLabel("Stock");
        textField4.setWidth("380px");
        textField4.setRequired(true);
        textField4.setErrorMessage("Campo Obligatorio");
        layoutRow3.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        textField5.setLabel("Marca");
        textField5.setWidth("380px");
        textField5.setRequired(true);
        textField5.setErrorMessage("Campo Obligatorio");
        textField6.setLabel("Color");
        textField6.setWidth("380px");
        textField6.setRequired(true);
        textField6.setErrorMessage("Campo Obligatorio");
        layoutRow4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        textField7.setLabel("Material");
        textField7.setWidth("380px");
        textField7.setRequired(true);
        textField7.setErrorMessage("Campo Obligatorio");

        comboBox.setLabel("Gama");
        comboBox.setWidth("380px");
        setComboBoxSampleData(comboBox);
        comboBox.setRequired(true);
        comboBox.setErrorMessage("Campo Obligatorio");

        layoutRow5.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow5);
        layoutRow5.addClassName(Gap.MEDIUM);
        layoutRow5.setWidth("100%");
        layoutRow5.getStyle().set("flex-grow", "1");

        guardar.setText("Guardar");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        guardar.addClickListener(event -> {

            // Obtener los valores de los campos y guardar en la lista de productos

            if (!textField.isEmpty() && !textField2.isEmpty() && !textField3.isEmpty()
                    && !textField4.isEmpty() && !textField5.isEmpty() && !textField6.isEmpty()
                    && !textField7.isEmpty() && !comboBox.isEmpty()
            ){
                String nombre = textField.getValue();
                String codigo = textField2.getValue();
                double precio = Float.parseFloat(textField3.getValue());
                Integer stock = Integer.valueOf(textField4.getValue());
                String marca = textField5.getValue();
                String color = textField6.getValue();
                String material = textField7.getValue();
                SampleItem selectedItem = (SampleItem) comboBox.getValue();
                String gama = selectedItem != null ? selectedItem.label() : null;

                if (vientoEditable == null) {
                    vientoEditable = new Viento();
                    Viento viento = new Viento();

                    // Validar que los campos no estén vacíos antes de guardar
                    vientoEditable.setNombre(nombre);
                    vientoEditable.setCodigo(codigo);
                    vientoEditable.setPrecio(precio);
                    vientoEditable.setStock(stock);
                    vientoEditable.setMarca(marca);
                    vientoEditable.setColor(color);
                    vientoEditable.setMaterial(material);
                    vientoEditable.setCalidad(gama);
                    vientoEditable.setCategoria("Viento");
                    Util.listaProducto.add(vientoEditable);



                }
                if (Util.listaProducto.contains(producto)) {
                    Util.listaProducto.remove(producto);
                }

                getUI().ifPresent(ui -> ui.navigate("instrumento"));
                // Navegar a la vista de productos después de guardar

           getUI().ifPresent(ui -> ui.navigate("instrumento"));

            }else{
                Notification.show("Debe llenar todos los campos");
            }

        });

        cancelar.setText("Cancelar");
        cancelar.setWidth("min-content");
        cancelar.addClickListener(event -> {
            UI.getCurrent().navigate("instrumento");
                });

        getContent().add(layoutColumn2);
        layoutColumn2.add(layoutRow);
        layoutRow.add(textField);
        layoutRow.add(textField2);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(textField3);
        layoutRow2.add(textField4);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(textField5);
        layoutRow3.add(textField6);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(textField7);
        layoutRow4.add(comboBox);
        layoutColumn2.add(layoutRow5);
        layoutRow5.add(guardar);
        layoutRow5.add(cancelar);

    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("alta", "Alta", null));
        sampleItems.add(new SampleItem("media", "Media", null));
        sampleItems.add(new SampleItem("baja", "Baja", Boolean.TRUE));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    public void setVientoEditable(Viento viento) {
        this.vientoEditable = viento;
        rellenarFormularioConDatos();

    }

    private void rellenarFormularioConDatos() {
        if (vientoEditable != null) {
            textField.setValue(vientoEditable.getNombre());
            textField2.setValue(vientoEditable.getCodigo());
            textField3.setValue(String.valueOf(vientoEditable.getPrecio()));
            textField4.setValue(String.valueOf(vientoEditable.getStock()));
            textField5.setValue(vientoEditable.getMarca());
            textField6.setValue(vientoEditable.getColor());
            textField7.setValue(vientoEditable.getMaterial());

        }
    }
    private void rellenarFormularioConDatosProducto( Producto producto) {

        textField.setValue(producto.getNombre());
        textField2.setValue(producto.getCodigo());
        textField3.setValue(String.valueOf(producto.getPrecio()));
        textField4.setValue(String.valueOf(producto.getStock()));
        textField5.setValue(producto.getMarca());
        textField6.setValue(producto.getColor());
        textField7.setValue(vientoEditable.getMaterial());
    }
}

