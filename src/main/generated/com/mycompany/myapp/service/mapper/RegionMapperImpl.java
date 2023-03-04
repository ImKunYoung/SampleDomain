package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Region;
import com.mycompany.myapp.service.dto.RegionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T18:53:28+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class RegionMapperImpl implements RegionMapper {

    @Override
    public Region toEntity(RegionDTO dto) {
        if (dto == null) {
            return null;
        }

        Region region = new Region();

        region.setId(dto.getId());
        region.setRegionName(dto.getRegionName());

        return region;
    }

    @Override
    public RegionDTO toDto(Region entity) {
        if (entity == null) {
            return null;
        }

        RegionDTO regionDTO = new RegionDTO();

        regionDTO.setId(entity.getId());
        regionDTO.setRegionName(entity.getRegionName());

        return regionDTO;
    }

    @Override
    public List<Region> toEntity(List<RegionDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Region> list = new ArrayList<Region>(dtoList.size());
        for (RegionDTO regionDTO : dtoList) {
            list.add(toEntity(regionDTO));
        }

        return list;
    }

    @Override
    public List<RegionDTO> toDto(List<Region> entityList) {
        if (entityList == null) {
            return null;
        }

        List<RegionDTO> list = new ArrayList<RegionDTO>(entityList.size());
        for (Region region : entityList) {
            list.add(toDto(region));
        }

        return list;
    }

    @Override
    public void partialUpdate(Region entity, RegionDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getRegionName() != null) {
            entity.setRegionName(dto.getRegionName());
        }
    }
}
