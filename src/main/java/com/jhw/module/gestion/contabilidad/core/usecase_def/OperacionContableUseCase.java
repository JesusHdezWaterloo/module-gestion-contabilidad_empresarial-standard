package com.jhw.module.gestion.contabilidad.core.usecase_def;

import com.root101.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.CuentaContableDomain;
import com.jhw.module.gestion.contabilidad.core.domain.OperacionContableDomain;
import java.util.List;

public interface OperacionContableUseCase extends CRUDUseCase<OperacionContableDomain> {

    public List<OperacionContableDomain> findAll(Integer idCuentaContable) throws Exception;

    public List<OperacionContableDomain> findAll(CuentaContableDomain cuenta) throws Exception;

}
