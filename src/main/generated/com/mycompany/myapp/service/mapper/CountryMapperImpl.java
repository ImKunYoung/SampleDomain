package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Country;
import com.mycompany.myapp.domain.Region;
import com.mycompany.myapp.service.dto.CountryDTO;
import com.mycompany.myapp.service.dto.RegionDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T18:53:29+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public Country toEntity(CountryDTO dto) {
        if (dto == null) {
            return null;
        }

        Country country = new Country();

        country.setId(dto.getId());
        country.setCountryName(dto.getCountryName());
        country.region(regionDTOToRegion(dto.getRegion()));

        return country;
    }

    @Override
    public List<Country> toEntity(List<CountryDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Country> list = new ArrayList<Country>(dtoList.size());
        for (CountryDTO countryDTO : dtoList) {
            list.add(toEntity(countryDTO));
        }

        return list;
    }

    @Override
    public List<CountryDTO> toDto(List<Country> entityList) {
        if (entityList == null) {
            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>(entityList.size());
        for (Country country : entityList) {
            list.add(toDto(country));
        }

        return list;
    }

    @Override
    public void partialUpdate(Country entity, CountryDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getCountryName() != null) {
            entity.setCountryName(dto.getCountryName());
        }
        if (dto.getRegion() != null) {
            if (entity.getRegion() == null) {
                entity.region(new Region());
            }
            regionDTOToRegion1(dto.getRegion(), entity.getRegion());
        }
    }

    @Override
    public CountryDTO toDto(Country s) {
        if (s == null) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setRegion(toDtoRegionId(s.getRegion()));
        countryDTO.setId(s.getId());
        countryDTO.setCountryName(s.getCountryName());

        return countryDTO;
    }

    @Override
    public RegionDTO toDtoRegionId(Region region) {
        if (region == null) {
            return null;
        }

        RegionDTO regionDTO = new RegionDTO();

        regionDTO.setId(region.getId());

        return regionDTO;
    }

    protected Region regionDTOToRegion(RegionDTO regionDTO) {
        if (regionDTO == null) {
            return null;
        }

        Region region = new Region();

        region.setId(regionDTO.getId());
        region.setRegionName(regionDTO.getRegionName());

        return region;
    }

    protected void regionDTOToRegion1(RegionDTO regionDTO, Region mappingTarget) {
        if (regionDTO == null) {
            return;
        }

        if (regionDTO.getId() != null) {
            mappingTarget.setId(regionDTO.getId());
        }
        if (regionDTO.getRegionName() != null) {
            mappingTarget.setRegionName(regionDTO.getRegionName());
        }
    }
}
