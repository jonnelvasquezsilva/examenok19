package com.examen.examen19.service;

import com.examen.examen19.dao.EmpresaRepository;
import com.examen.examen19.entity.EmpresaEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EmpresaService {

    EmpresaEntity crearEmpresa(EmpresaEntity empresaEntity);
    EmpresaEntity buscarEmpresaPorId(Long id);
    List<EmpresaEntity> buscarTodasLasEmpresas();
    EmpresaEntity actualizarEmpresa(Long id, EmpresaEntity empresaEntity);
    EmpresaEntity borrarEmpresa(Long id);

}
