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
package com.root101.module.gestion.contabilidad.core.domain.facade;

import com.root101.clean.core.domain.VolatileDomainObject;
import com.root101.module.gestion.contabilidad.core.domain.CuadreDomain;
import com.root101.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.root101.module.gestion.contabilidad.core.domain.FormaPagoDomain;
import com.root101.module.gestion.contabilidad.core.domain.InfoOperacionContableDomain;
import com.root101.module.gestion.contabilidad.core.domain.MonedaDomain;
import com.root101.module.gestion.contabilidad.core.domain.OperacionContableDomain;
import com.root101.module.gestion.contabilidad.core.domain.TipoOperacionContableDomain;
import com.root101.module.gestion.contabilidad.utils.MonedaHandler;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class CuadreUI extends VolatileDomainObject {

    private DocNombreUI docNombre;
    private OperacionCuadreUI op;
    private FechaDescUI fechaDesc;

    public CuadreUI() {
    }

    public CuadreUI(DocNombreUI docNombre, OperacionCuadreUI op, FechaDescUI fechaDesc) {
        this.docNombre = docNombre;
        this.op = op;
        this.fechaDesc = fechaDesc;
    }

    public CuadreDomain buildCuadre() {
        CuadreDomain cuadreNew = new CuadreDomain();
        BigDecimal valorConvertidoCuenta = MonedaHandler.venta(getValor(), getMoneda(), getCuenta().getMonedaFk());

        BigDecimal debito1 = BigDecimal.ZERO;
        BigDecimal credito1 = BigDecimal.ZERO;
        if (valorConvertidoCuenta.compareTo(BigDecimal.ZERO) >= 0) {
            valorConvertidoCuenta = valorConvertidoCuenta.abs();
            if (getCuenta().getTipoCuentaFk().getDebitoCredito()) {//debito
                debito1 = valorConvertidoCuenta;
            } else {
                credito1 = valorConvertidoCuenta;
            }
        } else {// si es neg lo invierto            
            valorConvertidoCuenta = valorConvertidoCuenta.abs();
            if (getCuenta().getTipoCuentaFk().getDebitoCredito()) {//debito
                credito1 = valorConvertidoCuenta;
            } else {
                debito1 = valorConvertidoCuenta;
            }
        }

        cuadreNew.setOperacionContableFk(new OperacionContableDomain(debito1, credito1, getCuenta(), getInfo()));

        //debito y credito invertido para mantener equilibrio
        BigDecimal debito2 = MonedaHandler.compra(credito1, getCuenta().getMonedaFk(), getCuentaCuadre().getMonedaFk());
        BigDecimal credito2 = MonedaHandler.compra(debito1, getCuenta().getMonedaFk(), getCuentaCuadre().getMonedaFk());
        cuadreNew.setOperacionContableCuadreFk(new OperacionContableDomain(debito2, credito2, getCuentaCuadre(), getInfo()));

        cuadreNew.setLiquidada(false);

        cuadreNew.validate();
        return cuadreNew;
    }

    public InfoOperacionContableDomain getInfo() {
        return new InfoOperacionContableDomain(
                getDocumento(),
                getNombre(),
                getFecha(),
                getDescripcion(),
                getTipoOp(),
                getFormaPagoFk());
    }

    public TipoOperacionContableDomain getTipoOp() {
        return op.getTipoOp();
    }

    public BigDecimal getValor() {
        return op.getValor();
    }

    public MonedaDomain getMoneda() {
        return op.getMoneda();
    }

    public CuentaContableDomain getCuenta() {
        return op.getCuenta();
    }

    public CuentaContableDomain getCuentaCuadre() {
        return op.getCuadre();
    }

    public String getDocumento() {
        return docNombre.getDocumento();
    }

    public String getNombre() {
        return docNombre.getNombre();
    }

    public LocalDate getFecha() {
        return fechaDesc.getFecha();
    }

    public String getDescripcion() {
        return fechaDesc.getDescripcion();
    }

    public FormaPagoDomain getFormaPagoFk() {
        return fechaDesc.getPago();
    }

}
