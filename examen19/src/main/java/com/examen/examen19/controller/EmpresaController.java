package com.examen.examen19.controller;

import com.examen.examen19.entity.EmpresaEntity;
import com.examen.examen19.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/empresas")

@Tag(
    name="API DE MANTENIMIENTO DE EMPRESAS",
        description = "Esta api permite implementar todos los métodos de un CRUD para el mantenimiento de empresas"

)


public class EmpresaController
{
    @Autowired
    private EmpresaService empresaService;

    @PostMapping("/crear")
    @Operation(
            summary = "Guardar una empresa en base de datos",
            description = "Para usar este endpoint debes enviar un objeto empresa, la cual " +
                    "se guardará en base de datos, previa validación."

    )
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description =  "Empresa creada correctamente",   content= @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "400", description =  "Se ha registrado un error al crear una empresa",   content= @Content(mediaType = "application/json") )
    })

    public ResponseEntity<EmpresaEntity> crearEmpresa(@RequestBody EmpresaEntity EmpresaEntity) {
        return ResponseEntity.ok(empresaService.crearEmpresa(EmpresaEntity));
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar una empresa por ID",
            description = "Para usar este endpoint debes enviar el id de la empresa que deseas obtener información."

    )

    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description =  "Búsqueda Exitosa",   content= @Content(mediaType = "application/json") ),
            @ApiResponse(responseCode = "400", description =  "No se pudo encontrar",   content= @Content(mediaType = "application/json") )
    })


    public ResponseEntity<EmpresaEntity> buscarEmpresaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(empresaService.buscarEmpresaPorId(id));
    }

    @GetMapping("/todos")

    @Operation(
            summary = "Obtener la data de todas las empresas registradas",
            description = "Mediante este endpoint podrás obtener toda la información de las empresas registradas"
    )

    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description =  "Se han entregado los datos correctamente",   content= @Content(mediaType = "application/json") ),
            @ApiResponse(responseCode = "400", description =  "Se ha registrado un error",   content= @Content(mediaType = "application/json") )
    })
    public ResponseEntity<List<EmpresaEntity>> buscarTodasLasEmpresas() {
        return ResponseEntity.ok(empresaService.buscarTodasLasEmpresas());
    }

    @PutMapping("/actualizar/{id}")

    @Operation(
            summary = "Actualizar datos de una empresa",
            description = "Para actualizar los datos de una empresa, mediante el enlace envías el ID de la empresa que deseas actualizar y luego enviar los campos a cambiar. "

    )

    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description =  "Se actualizaron los datos correctamente",   content= @Content(mediaType = "application/json") ),
            @ApiResponse(responseCode = "400", description =  "Se ha registrado un error",   content= @Content(mediaType = "application/json") )
    })


    public ResponseEntity<EmpresaEntity> actualizarEmpresa(@PathVariable Long id, @RequestBody EmpresaEntity EmpresaEntity) {
        return ResponseEntity.ok(empresaService.actualizarEmpresa(id, EmpresaEntity));
    }

    @DeleteMapping("/eliminar/{id}")

    @Operation(
            summary = "Desactivar una empresa",
            description = "Para desactivar una empresa, se necesita conocer el ID para proceder a buscar dentro de la base de datos y en seguida desactivarla. "

    )

    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description =  "Empresa desactivada con éxito",   content= @Content(mediaType = "application/json") ),
            @ApiResponse(responseCode = "400", description =  "ERROR! Hubo un problema",   content= @Content(mediaType = "application/json") )
    })

    public ResponseEntity<EmpresaEntity> eliminarEmpresa(@PathVariable Long id) {
       // return ResponseEntity.noContent().build();
        return ResponseEntity.ok(empresaService.borrarEmpresa(id));
    }


}
