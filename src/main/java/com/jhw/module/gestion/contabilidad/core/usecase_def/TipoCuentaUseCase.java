package com.jhw.module.gestion.contabilidad.core.usecase_def;

import com.clean.core.app.usecase.CRUDUseCase;
import com.jhw.module.gestion.contabilidad.core.domain.TipoCuentaDomain;
import java.util.List;

public interface TipoCuentaUseCase extends CRUDUseCase<TipoCuentaDomain> {

    public List<TipoCuentaDomain> findAllEquivalent(Integer idTipoCuenta) throws Exception;

    public List<TipoCuentaDomain> findAllEquivalent(TipoCuentaDomain tipoCuenta) throws Exception;

}
