package henryjames.employeeprojects;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private EmployeeRepository employeeRepo;
	
	@PostMapping("/createproject")
	public Project saveProject(@RequestBody Project entity) {
		
		return projectRepo.save(entity);
	}
	
	@GetMapping("/getproject/id/{projectId}")
	public Project getProject(@PathVariable int projectId) {
		
		return projectRepo.findById(projectId).orElse(null);
		
	}
	
	@GetMapping("/getallproject")
	public List<Project> getAllProject() {
		
		return projectRepo.findAll();
		
	}
	@PostMapping("/create-project/emps/{empIds}")
	public String projectAllotmentToEmployees(@PathVariable List<Integer> empIds, @RequestBody Project entity) {
		
		Project project = new Project(entity.getProjectname(), entity.getTechnologyUsed());
		
		Set<Employee> employees = new HashSet<>();
		
		for(Integer empId:empIds) {
			
			Employee temp= employeeRepo.findById(empId).orElse(null);
			
			if(temp != null) {
				employees.add(temp);
			}
			
		}
		
		project.setEmployees(employees);
		
		projectRepo.save(project);
		
		return "project creation was successful";
	}

}
