/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.gestion.contabilidad.core.domain.facade;

import com.jhw.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.jhw.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import com.root101.utils.clean.EntityDomainObjectValidated;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class OperacionCuadreUI extends EntityDomainObjectValidated {

    private BigDecimal valor;

    @NotNull(message = "#msg.module.contabilidad.validation.cuenta_moneda_null#")
    private MonedaDomain moneda;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_cuenta_null#")
    private CuentaContableDomain cuenta;

    @NotNull(message = "#msg.module.contabilidad.validation.operacion_cuenta_null#")
    private CuentaContableDomain cuadre;

    @NotNull(message = "#msg.module.contabilidad.validation.info_operacion_tipo_op_null#")
    private TipoOperacionContableDomain tipoOp;

    public OperacionCuadreUI() {
    }

    public OperacionCuadreUI(BigDecimal valor, MonedaDomain moneda, CuentaContableDomain cuenta, CuentaContableDomain cuadre, TipoOperacionContableDomain tipoOp) {
        this.valor = valor;
        this.moneda = moneda;
        this.cuenta = cuenta;
        this.cuadre = cuadre;
        this.tipoOp = tipoOp;
        validate();
    }

    public OperacionCuadreUI(CuadreDomain cuadre) {
        this.valor = cuadre.getOperacionContableFk().getDebito().subtract(cuadre.getOperacionContableFk().getCredito());
        this.moneda = cuadre.getOperacionContableFk().getCuentaFk().getMonedaFk();
        this.cuenta = cuadre.getOperacionContableFk().getCuentaFk();
        this.cuadre = cuadre.getOperacionContableCuadreFk().getCuentaFk();
        this.tipoOp = cuadre.info().getTipoOperacionFk();
        validate();
    }

    public TipoOperacionContableDomain getTipoOp() {
        return tipoOp;
    }

    public void setTipoOp(TipoOperacionContableDomain tipoOp) {
        this.tipoOp = tipoOp;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public MonedaDomain getMoneda() {
        return moneda;
    }

    public void setMoneda(MonedaDomain moneda) {
        this.moneda = moneda;
    }

    public CuentaContableDomain getCuenta() {
        return cuenta;
    }

    public void setCuenta(CuentaContableDomain cuenta) {
        this.cuenta = cuenta;
    }

    public CuentaContableDomain getCuadre() {
        return cuadre;
    }

    public void setCuadre(CuentaContableDomain cuadre) {
        this.cuadre = cuadre;
    }
}
