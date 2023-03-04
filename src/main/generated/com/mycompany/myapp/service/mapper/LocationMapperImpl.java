package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Country;
import com.mycompany.myapp.domain.Location;
import com.mycompany.myapp.domain.Region;
import com.mycompany.myapp.service.dto.CountryDTO;
import com.mycompany.myapp.service.dto.LocationDTO;
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
public class LocationMapperImpl implements LocationMapper {

    @Override
    public Location toEntity(LocationDTO dto) {
        if (dto == null) {
            return null;
        }

        Location location = new Location();

        location.setId(dto.getId());
        location.setStreetAddress(dto.getStreetAddress());
        location.setPostalCode(dto.getPostalCode());
        location.setCity(dto.getCity());
        location.setStateProvince(dto.getStateProvince());
        location.country(countryDTOToCountry(dto.getCountry()));

        return location;
    }

    @Override
    public List<Location> toEntity(List<LocationDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Location> list = new ArrayList<Location>(dtoList.size());
        for (LocationDTO locationDTO : dtoList) {
            list.add(toEntity(locationDTO));
        }

        return list;
    }

    @Override
    public List<LocationDTO> toDto(List<Location> entityList) {
        if (entityList == null) {
            return null;
        }

        List<LocationDTO> list = new ArrayList<LocationDTO>(entityList.size());
        for (Location location : entityList) {
            list.add(toDto(location));
        }

        return list;
    }

    @Override
    public void partialUpdate(Location entity, LocationDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getStreetAddress() != null) {
            entity.setStreetAddress(dto.getStreetAddress());
        }
        if (dto.getPostalCode() != null) {
            entity.setPostalCode(dto.getPostalCode());
        }
        if (dto.getCity() != null) {
            entity.setCity(dto.getCity());
        }
        if (dto.getStateProvince() != null) {
            entity.setStateProvince(dto.getStateProvince());
        }
        if (dto.getCountry() != null) {
            if (entity.getCountry() == null) {
                entity.country(new Country());
            }
            countryDTOToCountry1(dto.getCountry(), entity.getCountry());
        }
    }

    @Override
    public LocationDTO toDto(Location s) {
        if (s == null) {
            return null;
        }

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setCountry(toDtoCountryId(s.getCountry()));
        locationDTO.setId(s.getId());
        locationDTO.setStreetAddress(s.getStreetAddress());
        locationDTO.setPostalCode(s.getPostalCode());
        locationDTO.setCity(s.getCity());
        locationDTO.setStateProvince(s.getStateProvince());

        return locationDTO;
    }

    @Override
    public CountryDTO toDtoCountryId(Country country) {
        if (country == null) {
            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setId(country.getId());

        return countryDTO;
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

    protected Country countryDTOToCountry(CountryDTO countryDTO) {
        if (countryDTO == null) {
            return null;
        }

        Country country = new Country();

        country.setId(countryDTO.getId());
        country.setCountryName(countryDTO.getCountryName());
        country.region(regionDTOToRegion(countryDTO.getRegion()));

        return country;
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

    protected void countryDTOToCountry1(CountryDTO countryDTO, Country mappingTarget) {
        if (countryDTO == null) {
            return;
        }

        if (countryDTO.getId() != null) {
            mappingTarget.setId(countryDTO.getId());
        }
        if (countryDTO.getCountryName() != null) {
            mappingTarget.setCountryName(countryDTO.getCountryName());
        }
        if (countryDTO.getRegion() != null) {
            if (mappingTarget.getRegion() == null) {
                mappingTarget.region(new Region());
            }
            regionDTOToRegion1(countryDTO.getRegion(), mappingTarget.getRegion());
        }
    }
}
