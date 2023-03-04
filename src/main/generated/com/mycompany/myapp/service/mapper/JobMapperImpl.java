package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Country;
import com.mycompany.myapp.domain.Department;
import com.mycompany.myapp.domain.Employee;
import com.mycompany.myapp.domain.Job;
import com.mycompany.myapp.domain.Location;
import com.mycompany.myapp.domain.Region;
import com.mycompany.myapp.domain.Task;
import com.mycompany.myapp.service.dto.CountryDTO;
import com.mycompany.myapp.service.dto.DepartmentDTO;
import com.mycompany.myapp.service.dto.EmployeeDTO;
import com.mycompany.myapp.service.dto.JobDTO;
import com.mycompany.myapp.service.dto.LocationDTO;
import com.mycompany.myapp.service.dto.RegionDTO;
import com.mycompany.myapp.service.dto.TaskDTO;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-07T18:53:29+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 18 (Oracle Corporation)"
)
@Component
public class JobMapperImpl implements JobMapper {

    @Override
    public List<Job> toEntity(List<JobDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<Job> list = new ArrayList<Job>(dtoList.size());
        for (JobDTO jobDTO : dtoList) {
            list.add(toEntity(jobDTO));
        }

        return list;
    }

    @Override
    public List<JobDTO> toDto(List<Job> entityList) {
        if (entityList == null) {
            return null;
        }

        List<JobDTO> list = new ArrayList<JobDTO>(entityList.size());
        for (Job job : entityList) {
            list.add(toDto(job));
        }

        return list;
    }

    @Override
    public void partialUpdate(Job entity, JobDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getJobTitle() != null) {
            entity.setJobTitle(dto.getJobTitle());
        }
        if (dto.getMinSalary() != null) {
            entity.setMinSalary(dto.getMinSalary());
        }
        if (dto.getMaxSalary() != null) {
            entity.setMaxSalary(dto.getMaxSalary());
        }
        if (entity.getTasks() != null) {
            Set<Task> set = taskDTOSetToTaskSet(dto.getTasks());
            if (set != null) {
                entity.getTasks().clear();
                entity.getTasks().addAll(set);
            }
        } else {
            Set<Task> set = taskDTOSetToTaskSet(dto.getTasks());
            if (set != null) {
                entity.tasks(set);
            }
        }
        if (dto.getEmployee() != null) {
            if (entity.getEmployee() == null) {
                entity.employee(new Employee());
            }
            employeeDTOToEmployee(dto.getEmployee(), entity.getEmployee());
        }
    }

    @Override
    public JobDTO toDto(Job s) {
        if (s == null) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();

        jobDTO.setTasks(toDtoTaskTitleSet(s.getTasks()));
        jobDTO.setEmployee(toDtoEmployeeId(s.getEmployee()));
        jobDTO.setId(s.getId());
        jobDTO.setJobTitle(s.getJobTitle());
        jobDTO.setMinSalary(s.getMinSalary());
        jobDTO.setMaxSalary(s.getMaxSalary());

        return jobDTO;
    }

    @Override
    public Job toEntity(JobDTO jobDTO) {
        if (jobDTO == null) {
            return null;
        }

        Job job = new Job();

        job.setId(jobDTO.getId());
        job.setJobTitle(jobDTO.getJobTitle());
        job.setMinSalary(jobDTO.getMinSalary());
        job.setMaxSalary(jobDTO.getMaxSalary());
        job.tasks(taskDTOSetToTaskSet(jobDTO.getTasks()));
        job.employee(employeeDTOToEmployee1(jobDTO.getEmployee()));

        return job;
    }

    @Override
    public TaskDTO toDtoTaskTitle(Task task) {
        if (task == null) {
            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());

        return taskDTO;
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

    protected Task taskDTOToTask(TaskDTO taskDTO) {
        if (taskDTO == null) {
            return null;
        }

        Task task = new Task();

        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());

        return task;
    }

    protected Set<Task> taskDTOSetToTaskSet(Set<TaskDTO> set) {
        if (set == null) {
            return null;
        }

        Set<Task> set1 = new LinkedHashSet<Task>(Math.max((int) (set.size() / .75f) + 1, 16));
        for (TaskDTO taskDTO : set) {
            set1.add(taskDTOToTask(taskDTO));
        }

        return set1;
    }

    protected void regionDTOToRegion(RegionDTO regionDTO, Region mappingTarget) {
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

    protected void countryDTOToCountry(CountryDTO countryDTO, Country mappingTarget) {
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
            regionDTOToRegion(countryDTO.getRegion(), mappingTarget.getRegion());
        }
    }

    protected void locationDTOToLocation(LocationDTO locationDTO, Location mappingTarget) {
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
            countryDTOToCountry(locationDTO.getCountry(), mappingTarget.getCountry());
        }
    }

    protected void departmentDTOToDepartment(DepartmentDTO departmentDTO, Department mappingTarget) {
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
            locationDTOToLocation(departmentDTO.getLocation(), mappingTarget.getLocation());
        }
    }

    protected void employeeDTOToEmployee(EmployeeDTO employeeDTO, Employee mappingTarget) {
        if (employeeDTO == null) {
            return;
        }

        if (employeeDTO.getId() != null) {
            mappingTarget.setId(employeeDTO.getId());
        }
        if (employeeDTO.getFirstName() != null) {
            mappingTarget.setFirstName(employeeDTO.getFirstName());
        }
        if (employeeDTO.getLastName() != null) {
            mappingTarget.setLastName(employeeDTO.getLastName());
        }
        if (employeeDTO.getEmail() != null) {
            mappingTarget.setEmail(employeeDTO.getEmail());
        }
        if (employeeDTO.getPhoneNumber() != null) {
            mappingTarget.setPhoneNumber(employeeDTO.getPhoneNumber());
        }
        if (employeeDTO.getHireDate() != null) {
            mappingTarget.setHireDate(employeeDTO.getHireDate());
        }
        if (employeeDTO.getSalary() != null) {
            mappingTarget.setSalary(employeeDTO.getSalary());
        }
        if (employeeDTO.getCommissionPct() != null) {
            mappingTarget.setCommissionPct(employeeDTO.getCommissionPct());
        }
        if (employeeDTO.getManager() != null) {
            if (mappingTarget.getManager() == null) {
                mappingTarget.manager(new Employee());
            }
            employeeDTOToEmployee(employeeDTO.getManager(), mappingTarget.getManager());
        }
        if (employeeDTO.getDepartment() != null) {
            if (mappingTarget.getDepartment() == null) {
                mappingTarget.department(new Department());
            }
            departmentDTOToDepartment(employeeDTO.getDepartment(), mappingTarget.getDepartment());
        }
    }

    protected Region regionDTOToRegion1(RegionDTO regionDTO) {
        if (regionDTO == null) {
            return null;
        }

        Region region = new Region();

        region.setId(regionDTO.getId());
        region.setRegionName(regionDTO.getRegionName());

        return region;
    }

    protected Country countryDTOToCountry1(CountryDTO countryDTO) {
        if (countryDTO == null) {
            return null;
        }

        Country country = new Country();

        country.setId(countryDTO.getId());
        country.setCountryName(countryDTO.getCountryName());
        country.region(regionDTOToRegion1(countryDTO.getRegion()));

        return country;
    }

    protected Location locationDTOToLocation1(LocationDTO locationDTO) {
        if (locationDTO == null) {
            return null;
        }

        Location location = new Location();

        location.setId(locationDTO.getId());
        location.setStreetAddress(locationDTO.getStreetAddress());
        location.setPostalCode(locationDTO.getPostalCode());
        location.setCity(locationDTO.getCity());
        location.setStateProvince(locationDTO.getStateProvince());
        location.country(countryDTOToCountry1(locationDTO.getCountry()));

        return location;
    }

    protected Department departmentDTOToDepartment1(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            return null;
        }

        Department department = new Department();

        department.setId(departmentDTO.getId());
        department.setDepartmentName(departmentDTO.getDepartmentName());
        department.location(locationDTOToLocation1(departmentDTO.getLocation()));

        return department;
    }

    protected Employee employeeDTOToEmployee1(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }

        Employee employee = new Employee();

        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setHireDate(employeeDTO.getHireDate());
        employee.setSalary(employeeDTO.getSalary());
        employee.setCommissionPct(employeeDTO.getCommissionPct());
        employee.manager(employeeDTOToEmployee1(employeeDTO.getManager()));
        employee.department(departmentDTOToDepartment1(employeeDTO.getDepartment()));

        return employee;
    }
}
