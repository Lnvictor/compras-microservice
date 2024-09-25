package org.victorc.compras.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.victorc.compras.dto.CompraDTO;
import org.victorc.compras.entity.Compra;

@Mapper
public interface CompraMapper {
    final CompraMapper INSTANCE = Mappers.getMapper(CompraMapper.class);

    CompraDTO convertEntityToDto(Compra entity);

    @Mapping(target = "id", ignore = true)
    Compra convertDtoToEntity(CompraDTO dto);
}
