package com.example.sqlex.mappers;

import com.example.sqlex.models.Laptop;
import com.example.sqlex.models.dto.LaptopDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface LaptopMapper {

    LaptopMapper INSTANCE = Mappers.getMapper(LaptopMapper.class);

    List<Laptop> toLaptop(List<LaptopDto> laptopDtos);

    List<LaptopDto> toLaptopDto(List<Laptop>laptops);

}
