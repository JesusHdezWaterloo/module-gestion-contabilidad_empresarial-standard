/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain;

import com.root101.utils.clean.EntityDomainObjectValidated;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class InfoOperacionContableDomain extends EntityDomainObjectValidated {

    private Integer idInfoOperacionContable;

    @NotEmpty(message = "#msg.module.contabilidad.validation.info_operacion_documento_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.operacion_documento_largo#")
    private String documento;

    @NotEmpty(message = "#msg.module.contabilidad.validation.info_operacion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.info_operacion_nombre_largo#")
    private String nombre;

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_fecha_null#")
    private LocalDate fecha;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_tipo_op_null#")
    private TipoOperacionContableDomain tipoOperacionFk;

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_metodo_pago_null#")
    private FormaPagoDomain formaPagoFk;

    public InfoOperacionContableDomain() {
    }

    public InfoOperacionContableDomain(Integer idInfoOperacionContable) {
        this.idInfoOperacionContable = idInfoOperacionContable;
    }

    public InfoOperacionContableDomain(String documento, String nombre, LocalDate fecha, String descripcion, TipoOperacionContableDomain tipoOperacionFk, FormaPagoDomain formaPagoFk) {
        this.documento = documento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tipoOperacionFk = tipoOperacionFk;
        this.formaPagoFk = formaPagoFk;
        validate();
    }

    public TipoOperacionContableDomain getTipoOperacionFk() {
        return tipoOperacionFk;
    }

    public void setTipoOperacionFk(TipoOperacionContableDomain tipoOperacionFk) {
        this.tipoOperacionFk = tipoOperacionFk;
    }

    public Integer getIdInfoOperacionContable() {
        return idInfoOperacionContable;
    }

    public void setIdInfoOperacionContable(Integer idInfoOperacionContable) {
        this.idInfoOperacionContable = idInfoOperacionContable;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public FormaPagoDomain getFormaPagoFk() {
        return formaPagoFk;
    }

    public void setFormaPagoFk(FormaPagoDomain formaPagoFk) {
        this.formaPagoFk = formaPagoFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInfoOperacionContable != null ? idInfoOperacionContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoOperacionContableDomain)) {
            return false;
        }
        InfoOperacionContableDomain other = (InfoOperacionContableDomain) object;
        if ((this.idInfoOperacionContable == null && other.idInfoOperacionContable != null) || (this.idInfoOperacionContable != null && !this.idInfoOperacionContable.equals(other.idInfoOperacionContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return documento;
    }

}
