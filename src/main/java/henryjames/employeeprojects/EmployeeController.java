package henryjames.employeeprojects;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

@Autowired
private EmployeeRepository employeeRepo;

@Autowired
private ProjectRepository projectRepo;

@PostMapping("/create-employee")
public Employee createEmployee(@RequestBody Employee employee) {
    
    return employeeRepo.save(employee);
}

@GetMapping("/get-employee/id/{id}")
public Employee getEmployee(@PathVariable int id) {
    
    return employeeRepo.findById(id).orElse(null);
}

@GetMapping("/get-all-employee")
public List<Employee> getAllEmployee() {
    
    return employeeRepo.findAll();
}

@PostMapping("/create-employee-for-project/id/{projectId}")
public String createEmployeeForProject(@RequestBody Employee entity, @PathVariable int projectId) {
    
    
    Employee employee=  employeeRepo.save(entity);
    
    System.out.println("Fetching existing project with id:"+ projectId);
    
    Project project=  projectRepo.findById(projectId).orElse(null);
    
    Set<Employee> emps = new HashSet<>();
    
    emps.add(employee);
    
    Set<Employee> existing = project.getEmployees();
    
    Set<Project> projects = new HashSet<>();
    
    projects.add(project);
    
    employee.setProjects(projects);
    
    employeeRepo.save(employee);
    
    
    
/**
if(!existing.isEmpty()) {

        emps.addAll(existing);
    }
    
    String response = "";
    
    if(project !=null) {
        
        project.setEmployees(emps);
        
        projectRepo.save(project);
        
        System.out.println("Project updated with employees allocation.");
        
        response = "Project update successful!!";
        
        
    } else {
        
        
        response = "Project does not exist.";
    }
**/    
    return "New employee created and project assigned.";
    
    
    
}


@DeleteMapping("/delete-all")
public String deleteAll() {
    
    employeeRepo.deleteAll();
    
    return "Success";
}
}