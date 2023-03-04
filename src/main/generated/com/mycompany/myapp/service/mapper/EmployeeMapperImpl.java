package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Country;
import com.mycompany.myapp.domain.Department;
import com.mycompany.myapp.domain.Employee;
import com.mycompany.myapp.domain.Location;
import com.mycompany.myapp.domain.Region;
import com.mycompany.myapp.service.dto.CountryDTO;
import com.mycompany.myapp.service.dto.DepartmentDTO;
import com.mycompany.myapp.service.dto.EmployeeDTO;
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
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId(dto.getId());
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setPhoneNumber(dto.getPhoneNumber());
        employee.setHireDate(dto.getHireDate());
        employee.setSalary(dto.getSalary());
        employee.setCommissionPct(dto.getCommissionPct());
        employee.manager(toEntity(dto.getManager()));
        employee.department(departmentDTOToDepartment(dto.getDepartment()));

        return employee;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Employee> list = new ArrayList<Employee>(dtoList.size());
        for (EmployeeDTO employeeDTO : dtoList) {
            list.add(toEntity(employeeDTO));
        }

        return list;
    }

    @Override
    public List<EmployeeDTO> toDto(List<Employee> entityList) {
        if (entityList == null) {
            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>(entityList.size());
        for (Employee employee : entityList) {
            list.add(toDto(employee));
        }

        return list;
    }

    @Override
    public void partialUpdate(Employee entity, EmployeeDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getFirstName() != null) {
            entity.setFirstName(dto.getFirstName());
        }
        if (dto.getLastName() != null) {
            entity.setLastName(dto.getLastName());
        }
        if (dto.getEmail() != null) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getPhoneNumber() != null) {
            entity.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getHireDate() != null) {
            entity.setHireDate(dto.getHireDate());
        }
        if (dto.getSalary() != null) {
            entity.setSalary(dto.getSalary());
        }
        if (dto.getCommissionPct() != null) {
            entity.setCommissionPct(dto.getCommissionPct());
        }
        if (dto.getManager() != null) {
            entity.manager(toEntity(dto.getManager()));
        }
        if (dto.getDepartment() != null) {
            if (entity.getDepartment() == null) {
                entity.department(new Department());
            }
            departmentDTOToDepartment1(dto.getDepartment(), entity.getDepartment());
        }
    }

    @Override
    public EmployeeDTO toDto(Employee s) {
        if (s == null) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setManager(toDtoEmployeeId(s.getManager()));
        employeeDTO.setDepartment(toDtoDepartmentId(s.getDepartment()));
        employeeDTO.setId(s.getId());
        employeeDTO.setFirstName(s.getFirstName());
        employeeDTO.setLastName(s.getLastName());
        employeeDTO.setEmail(s.getEmail());
        employeeDTO.setPhoneNumber(s.getPhoneNumber());
        employeeDTO.setHireDate(s.getHireDate());
        employeeDTO.setSalary(s.getSalary());
        employeeDTO.setCommissionPct(s.getCommissionPct());

        return employeeDTO;
    }

    @Override
    public EmployeeDTO toDtoEmployeeId(Employee employee) {
        if (employee == null) {
            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setId(employee.getId());

        return employeeDTO;
    }

    @Override
    public DepartmentDTO toDtoDepartmentId(Department department) {
        if (department == null) {
            return null;
        }

        DepartmentDTO departmentDTO = new DepartmentDTO();

        departmentDTO.setId(department.getId());

        return departmentDTO;
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

    protected Department departmentDTOToDepartment(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            return null;
        }

        Department department = new Department();

        department.setId(departmentDTO.getId());
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.location(locationDTOToLocation(departmentDTO.getLocation()));

        return department;
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

    protected void departmentDTOToDepartment1(DepartmentDTO departmentDTO, Department mappingTarget) {
        if (departmentDTO == null) {
            return;
        }

        if (departmentDTO.getId() != null) {
            mappingTarget.setId(departmentDTO.getId());
        }
        if (departmentDTO.getDepartmentName() != null) {
            mappingTarget.setDepartmentName(departmentDTO.getDepartmentName());
        }
        if (departmentDTO.getLocation() != null) {
            if (mappingTarget.getLocation() == null) {
                mappingTarget.location(new Location());
            }
            locationDTOToLocation1(departmentDTO.getLocation(), mappingTarget.getLocation());
        }
    }
}
