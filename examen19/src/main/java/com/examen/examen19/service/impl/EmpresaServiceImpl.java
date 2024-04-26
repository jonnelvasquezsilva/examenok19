package com.examen.examen19.service.impl;

import com.examen.examen19.constants.Constants;
import com.examen.examen19.dao.EmpresaRepository;
import com.examen.examen19.entity.EmpresaEntity;
import com.examen.examen19.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.aspectj.apache.bcel.classfile.ConstantString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public EmpresaEntity crearEmpresa(EmpresaEntity empresaEntity) {
        empresaEntity.setUsua_crea(Constants.AUDIT_ADMIN);
        empresaEntity.setDate_create(LocalDateTime.now());
       return empresaRepository.save(empresaEntity);
    }

    public EmpresaEntity buscarEmpresaPorId(Long id) {
        return empresaRepository.findById(id).orElse(null);
    }

    public List<EmpresaEntity> buscarTodasLasEmpresas() {
        return empresaRepository.findAll();
    }

    public EmpresaEntity actualizarEmpresa(Long id, EmpresaEntity empresaEntity) {

        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            EmpresaEntity empresa = empresaRecuperada.get();
            empresa.setRazonSocial(empresaEntity.getRazonSocial());
            empresa.setTipoDocumento((empresaEntity.getTipoDocumento()));
            empresa.setNumeroDocumento((empresaEntity.getNumeroDocumento()));
            empresa.setCondicion(empresaEntity.getCondicion());
            empresa.setDireccion(empresaEntity.getDireccion());
            empresa.setDistrito(empresaEntity.getDistrito());
            empresa.setProvincia(empresaEntity.getProvincia());
            empresa.setDepartamento(empresaEntity.getDepartamento());
            empresa.setEsAgenteRetencion(empresaEntity.getEsAgenteRetencion());
            empresa.setUsua_modif(Constants.AUDIT_ADMIN);
            empresa.setDate_modif(LocalDateTime.now());
            return empresaRepository.save(empresa);
        }
        return null;
    }
    @Override
    public EmpresaEntity borrarEmpresa(Long id) {
        Optional<EmpresaEntity> empresaRecuperada = empresaRepository.findById(id);
        if(empresaRecuperada.isPresent()){
            empresaRecuperada.get().setCondicion("INACTIVO");
            empresaRecuperada.get().setUsua_delet(Constants.AUDIT_ADMIN);
            empresaRecuperada.get().setDate_delet(LocalDateTime.now());
            return empresaRepository.save(empresaRecuperada.get());
        }
        return null;
    }

}
