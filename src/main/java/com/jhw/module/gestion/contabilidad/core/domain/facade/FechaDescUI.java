/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain.facade;

import com.jhw.module.gestion.contabilidad.core.domain.FormaPagoDomain;
import com.jhw.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;
import com.root101.utils.clean.EntityDomainObjectValidated;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class FechaDescUI extends EntityDomainObjectValidated {

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_fecha_null#")
    private LocalDate fecha;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_metodo_pago_null#")
    private FormaPagoDomain pago;

    public FechaDescUI() {
    }

    public FechaDescUI(LocalDate fecha, FormaPagoDomain pago, String descripcion) {
        this.fecha = fecha;
        this.pago = pago;
        this.descripcion = descripcion;
        validate();
    }

    public FechaDescUI(InfoOperacionContableDomain info) {
        this.fecha = info.getFecha();
        this.pago = info.getFormaPagoFk();
        this.descripcion = info.getDescripcion();
        validate();
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public FormaPagoDomain getPago() {
        return pago;
    }

    public void setPago(FormaPagoDomain pago) {
        this.pago = pago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
