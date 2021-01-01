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
package com.root101.module.gestion.contabilidad.core.usecase_def;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import com.root101.module.gestion.contabilidad.core.domain.Cuenta;
import com.root101.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.root101.module.gestion.contabilidad.core.domain.TipoCuentaDomain;
import java.util.List;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public interface CuentaContableUseCase extends CRUDUseCase<CuentaContableDomain> {

    public List<Cuenta> findAllCuentas() throws Exception;

    public List<CuentaContableDomain> findAllCuenta(Integer idTipoCuenta) throws Exception;

    public List<CuentaContableDomain> findAllCuenta(TipoCuentaDomain tipo) throws Exception;

    public List<CuentaContableDomain> findAll(String text) throws Exception;

}