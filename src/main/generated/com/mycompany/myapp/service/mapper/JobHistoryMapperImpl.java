package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.Country;
import com.mycompany.myapp.domain.Department;
import com.mycompany.myapp.domain.Employee;
import com.mycompany.myapp.domain.Job;
import com.mycompany.myapp.domain.JobHistory;
import com.mycompany.myapp.domain.Location;
import com.mycompany.myapp.domain.Region;
import com.mycompany.myapp.domain.Task;
import com.mycompany.myapp.service.dto.CountryDTO;
import com.mycompany.myapp.service.dto.DepartmentDTO;
import com.mycompany.myapp.service.dto.EmployeeDTO;
import com.mycompany.myapp.service.dto.JobDTO;
import com.mycompany.myapp.service.dto.JobHistoryDTO;
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
public class JobHistoryMapperImpl implements JobHistoryMapper {

    @Override
    public JobHistory toEntity(JobHistoryDTO dto) {
        if (dto == null) {
            return null;
        }

        JobHistory jobHistory = new JobHistory();

        jobHistory.setId(dto.getId());
        jobHistory.setStartDate(dto.getStartDate());
        jobHistory.setEndDate(dto.getEndDate());
        jobHistory.setLanguage(dto.getLanguage());
        jobHistory.job(jobDTOToJob(dto.getJob()));
        jobHistory.department(departmentDTOToDepartment(dto.getDepartment()));
        jobHistory.employee(employeeDTOToEmployee(dto.getEmployee()));

        return jobHistory;
    }

    @Override
    public List<JobHistory> toEntity(List<JobHistoryDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }

        List<JobHistory> list = new ArrayList<JobHistory>(dtoList.size());
        for (JobHistoryDTO jobHistoryDTO : dtoList) {
            list.add(toEntity(jobHistoryDTO));
        }

        return list;
    }

    @Override
    public List<JobHistoryDTO> toDto(List<JobHistory> entityList) {
        if (entityList == null) {
            return null;
        }

        List<JobHistoryDTO> list = new ArrayList<JobHistoryDTO>(entityList.size());
        for (JobHistory jobHistory : entityList) {
            list.add(toDto(jobHistory));
        }

        return list;
    }

    @Override
    public void partialUpdate(JobHistory entity, JobHistoryDTO dto) {
        if (dto == null) {
            return;
        }

        if (dto.getId() != null) {
            entity.setId(dto.getId());
        }
        if (dto.getStartDate() != null) {
            entity.setStartDate(dto.getStartDate());
        }
        if (dto.getEndDate() != null) {
            entity.setEndDate(dto.getEndDate());
        }
        if (dto.getLanguage() != null) {
            entity.setLanguage(dto.getLanguage());
        }
        if (dto.getJob() != null) {
            if (entity.getJob() == null) {
                entity.job(new Job());
            }
            jobDTOToJob1(dto.getJob(), entity.getJob());
        }
        if (dto.getDepartment() != null) {
            if (entity.getDepartment() == null) {
                entity.department(new Department());
            }
            departmentDTOToDepartment1(dto.getDepartment(), entity.getDepartment());
        }
        if (dto.getEmployee() != null) {
            if (entity.getEmployee() == null) {
                entity.employee(new Employee());
            }
            employeeDTOToEmployee1(dto.getEmployee(), entity.getEmployee());
        }
    }

    @Override
    public JobHistoryDTO toDto(JobHistory s) {
        if (s == null) {
            return null;
        }

        JobHistoryDTO jobHistoryDTO = new JobHistoryDTO();

        jobHistoryDTO.setJob(toDtoJobId(s.getJob()));
        jobHistoryDTO.setDepartment(toDtoDepartmentId(s.getDepartment()));
        jobHistoryDTO.setEmployee(toDtoEmployeeId(s.getEmployee()));
        jobHistoryDTO.setId(s.getId());
        jobHistoryDTO.setStartDate(s.getStartDate());
        jobHistoryDTO.setEndDate(s.getEndDate());
        jobHistoryDTO.setLanguage(s.getLanguage());

        return jobHistoryDTO;
    }

    @Override
    public JobDTO toDtoJobId(Job job) {
        if (job == null) {
            return null;
        }

        JobDTO jobDTO = new JobDTO();

        jobDTO.setId(job.getId());

        return jobDTO;
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

    protected Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {
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
        employee.manager(employeeDTOToEmployee(employeeDTO.getManager()));
        employee.department(departmentDTOToDepartment(employeeDTO.getDepartment()));

        return employee;
    }

    protected Job jobDTOToJob(JobDTO jobDTO) {
        if (jobDTO == null) {
            return null;
        }

        Job job = new Job();

        job.setId(jobDTO.getId());
        job.setJobTitle(jobDTO.getJobTitle());
        job.setMinSalary(jobDTO.getMinSalary());
        job.setMaxSalary(jobDTO.getMaxSalary());
        job.tasks(taskDTOSetToTaskSet(jobDTO.getTasks()));
        job.employee(employeeDTOToEmployee(jobDTO.getEmployee()));

        return job;
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

    protected void employeeDTOToEmployee1(EmployeeDTO employeeDTO, Employee mappingTarget) {
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
            employeeDTOToEmployee1(employeeDTO.getManager(), mappingTarget.getManager());
        }
        if (employeeDTO.getDepartment() != null) {
            if (mappingTarget.getDepartment() == null) {
                mappingTarget.department(new Department());
            }
            departmentDTOToDepartment1(employeeDTO.getDepartment(), mappingTarget.getDepartment());
        }
    }

    protected void jobDTOToJob1(JobDTO jobDTO, Job mappingTarget) {
        if (jobDTO == null) {
            return;
        }

        if (jobDTO.getId() != null) {
            mappingTarget.setId(jobDTO.getId());
        }
        if (jobDTO.getJobTitle() != null) {
            mappingTarget.setJobTitle(jobDTO.getJobTitle());
        }
        if (jobDTO.getMinSalary() != null) {
            mappingTarget.setMinSalary(jobDTO.getMinSalary());
        }
        if (jobDTO.getMaxSalary() != null) {
            mappingTarget.setMaxSalary(jobDTO.getMaxSalary());
        }
        if (mappingTarget.getTasks() != null) {
            Set<Task> set = taskDTOSetToTaskSet(jobDTO.getTasks());
            if (set != null) {
                mappingTarget.getTasks().clear();
                mappingTarget.getTasks().addAll(set);
            }
        } else {
            Set<Task> set = taskDTOSetToTaskSet(jobDTO.getTasks());
            if (set != null) {
                mappingTarget.tasks(set);
            }
        }
        if (jobDTO.getEmployee() != null) {
            if (mappingTarget.getEmployee() == null) {
                mappingTarget.employee(new Employee());
            }
            employeeDTOToEmployee1(jobDTO.getEmployee(), mappingTarget.getEmployee());
        }
    }
}
