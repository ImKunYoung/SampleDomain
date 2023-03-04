package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Country;
import com.mycompany.myapp.domain.Department;
import com.mycompany.myapp.domain.Location;
import com.mycompany.myapp.domain.Region;
import com.mycompany.myapp.service.dto.CountryDTO;
import com.mycompany.myapp.service.dto.DepartmentDTO;
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
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public Department toEntity(DepartmentDTO dto) {
        if (dto == null) {
            return null;
        }

        Department department = new Department();

        department.setId(dto.getId());
        department.setDepartmentName(dto.getDepartmentName());
        department.location(locationDTOToLocation(dto.getLocation()));

        return department;
    }

    @Override
    public List<Department> toEntity(List<DepartmentDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Department> list = new ArrayList<Department>(dtoList.size());
        for (DepartmentDTO departmentDTO : dtoList) {
            list.add(toEntity(departmentDTO));
        }

        return list;
    }

    @Override
    public List<DepartmentDTO> toDto(List<Department> entityList) {
        if (entityList == null) {
            return null;
        }

        List<DepartmentDTO> list = new ArrayList<DepartmentDTO>(entityList.size());
        for (Department department : entityList) {
            list.add(toDto(department));
        }

        return list;
    }

    @Override
    public void partialUpdate(Department entity, DepartmentDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getDepartmentName() != null) {
            entity.setDepartmentName(dto.getDepartmentName());
        }
        if (dto.getLocation() != null) {
            if (entity.getLocation() == null) {
                entity.location(new Location());
            }
            locationDTOToLocation1(dto.getLocation(), entity.getLocation());
        }
    }

    @Override
    public DepartmentDTO toDto(Department s) {
        if (s == null) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setLocation(toDtoLocationId(s.getLocation()));
        departmentDTO.setId(s.getId());
        departmentDTO.setDepartmentName(s.getDepartmentName());

        return departmentDTO;
    }

    @Override
    public LocationDTO toDtoLocationId(Location location) {
        if (location == null) {
            return null;
        }

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setId(location.getId());

        return locationDTO;
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

    protected Location locationDTOToLocation(LocationDTO locationDTO) {
        if (locationDTO == null) {
            return null;
        }

        Location location = new Location();

        location.setId(locationDTO.getId());
        location.setStreetAddress(locationDTO.getStreetAddress());
        location.setPostalCode(locationDTO.getPostalCode());
        location.setCity(locationDTO.getCity());
        location.setStateProvince(locationDTO.getStateProvince());
        location.country(countryDTOToCountry(locationDTO.getCountry()));

        return location;
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

    protected void locationDTOToLocation1(LocationDTO locationDTO, Location mappingTarget) {
        if (locationDTO == null) {
            return;
        }

        if (locationDTO.getId() != null) {
            mappingTarget.setId(locationDTO.getId());
        }
        if (locationDTO.getStreetAddress() != null) {
            mappingTarget.setStreetAddress(locationDTO.getStreetAddress());
        }
        if (locationDTO.getPostalCode() != null) {
            mappingTarget.setPostalCode(locationDTO.getPostalCode());
        }
        if (locationDTO.getCity() != null) {
            mappingTarget.setCity(locationDTO.getCity());
        }
        if (locationDTO.getStateProvince() != null) {
            mappingTarget.setStateProvince(locationDTO.getStateProvince());
        }
        if (locationDTO.getCountry() != null) {
            if (mappingTarget.getCountry() == null) {
                mappingTarget.country(new Country());
            }
            countryDTOToCountry1(locationDTO.getCountry(), mappingTarget.getCountry());
        }
    }
}
