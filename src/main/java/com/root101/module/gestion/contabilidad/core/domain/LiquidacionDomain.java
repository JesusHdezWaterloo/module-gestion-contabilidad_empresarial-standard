/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.gestion.contabilidad.core.domain;

import com.root101.clean.core.exceptions.ValidationException;
import com.root101.clean.core.utils.SortBy;
import com.root101.clean.core.utils.validation.ValidationMessage;
import com.root101.clean.core.utils.validation.ValidationResult;
import com.root101.module.gestion.contabilidad.utils.MonedaHandler;
import com.root101.utils.clean.EntityDomainObjectValidated;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
@SortBy(priority = {"documento", "nombre"})
public class LiquidacionDomain extends EntityDomainObjectValidated implements DebitoCredito {

    private Integer idLiquidacion;

    @NotEmpty(message = "#msg.module.contabilidad.validation.info_operacion_documento_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.info_operacion_documento_largo#")
    private String documento;

    @NotEmpty(message = "#msg.module.contabilidad.validation.info_operacion_nombre_vacio#")
    @Size(max = 95, message = "#msg.module.contabilidad.validation.info_operacion_nombre_largo#")
    private String nombre;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.debito_negativo#")
    @Max(value = Long.MAX_VALUE, message = "#msg.module.contabilidad.validation.valor_muy_grande#")
    private BigDecimal debito;

    @PositiveOrZero(message = "#msg.module.contabilidad.validation.credito_negativo#")
    @Max(value = Long.MAX_VALUE, message = "#msg.module.contabilidad.validation.valor_muy_grande#")
    private BigDecimal credito;

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_fecha_null#")
    private LocalDate fecha;

    @Size(max = 495, message = "#msg.module.contabilidad.validation.descripcion_larga#")
    private String descripcion;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_cuenta_null#")
    private CuentaBancariaDomain cuentaFk;

    @NotNull(message = "#msg.module.contabilidad.validation.liquidacion_cuadre_null#")
    private CuadreDomain cuadreFk;

    public LiquidacionDomain() {
    }

    public LiquidacionDomain(Integer idOperacionBancaria) {
        this.idLiquidacion = idOperacionBancaria;
    }

    public LiquidacionDomain(String documento, String nombre, BigDecimal debito, BigDecimal credito, LocalDate fecha, String descripcion, CuentaBancariaDomain cuentaFk, CuadreDomain cuadreFk) {
        this.documento = documento;
        this.nombre = nombre;
        this.debito = debito;
        this.credito = credito;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cuentaFk = cuentaFk;
        this.cuadreFk = cuadreFk;
        validate();
    }

    public Integer getIdLiquidacion() {
        return idLiquidacion;
    }

    public void setIdLiquidacion(Integer idLiquidacion) {
        this.idLiquidacion = idLiquidacion;
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

    @Override
    public BigDecimal getDebito() {
        return debito;
    }

    @Override
    public void setDebito(BigDecimal debito) {
        this.debito = debito;
    }

    @Override
    public BigDecimal getCredito() {
        return credito;
    }

    @Override
    public void setCredito(BigDecimal credito) {
        this.credito = credito;
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

    public CuentaBancariaDomain getCuentaFk() {
        return cuentaFk;
    }

    public void setCuentaFk(CuentaBancariaDomain cuentaFk) {
        this.cuentaFk = cuentaFk;
    }

    public CuadreDomain getCuadreFk() {
        return cuadreFk;
    }

    public void setCuadreFk(CuadreDomain cuadreFk) {
        this.cuadreFk = cuadreFk;
        this.setCredito(MonedaHandler.venta(cuadreFk.getOperacionContableFk().getDebito(), cuadreFk.getOperacionContableFk().getCuentaFk().getMonedaFk(), getCuentaFk().getMonedaFk()));
        this.setDebito(MonedaHandler.venta(cuadreFk.getOperacionContableFk().getCredito(), cuadreFk.getOperacionContableFk().getCuentaFk().getMonedaFk(), getCuentaFk().getMonedaFk()));
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLiquidacion != null ? idLiquidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LiquidacionDomain)) {
            return false;
        }
        LiquidacionDomain other = (LiquidacionDomain) object;
        if ((this.idLiquidacion == null && other.idLiquidacion != null) || (this.idLiquidacion != null && !this.idLiquidacion.equals(other.idLiquidacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return documento;
    }

    @Override
    public ValidationResult validate() throws ValidationException {
        ValidationResult v = super.validate();
        BigDecimal debCuadre = MonedaHandler.venta(cuadreFk.getOperacionContableFk().getDebito(), cuadreFk.getOperacionContableFk().getCuentaFk().getMonedaFk(), getCuentaFk().getMonedaFk());
        BigDecimal credCuadre = MonedaHandler.venta(cuadreFk.getOperacionContableFk().getCredito(), cuadreFk.getOperacionContableFk().getCuentaFk().getMonedaFk(), getCuentaFk().getMonedaFk());
        if (debito.compareTo(credCuadre) != 0) {
            v.add(ValidationMessage.from("debito", "El débito de la operación y la liquidación tienen que coincidir para mantener el cuadre."));
        }
        if (credito.compareTo(debCuadre) != 0) {
            v.add(ValidationMessage.from("credito", "El crédito de la operación y la liquidación tienen que coincidir para mantener el cuadre."));
        }
        return v.throwException();
    }

}
