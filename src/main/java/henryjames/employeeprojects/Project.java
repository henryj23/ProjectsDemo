package henryjames.employeeprojects;

import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String projectname;
	
	private String technologyUsed;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_PROJECT_MAPPING", joinColumns = @JoinColumn(name="project_id"),
										inverseJoinColumns = @JoinColumn(name="employee_id"))
	private Set<Employee> employees;
	
	public Project() {
		
		
	}
	
	
	public Project(String project, String technology) {
		
		this.projectname = project;
		this.technologyUsed = technology;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getProjectname() {
		return projectname;
	}


	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}


	public String getTechnologyUsed() {
		return technologyUsed;
	}


	public void setTechnologyUsed(String technologyUsed) {
		this.technologyUsed = technologyUsed;
	}


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Project [id=" + id + ", projectname=" + projectname + ", technologyUsed=" + technologyUsed
				+ ", employees=" + employees + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(employees, id, projectname, technologyUsed);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		return Objects.equals(employees, other.employees) && id == other.id
				&& Objects.equals(projectname, other.projectname)
				&& Objects.equals(technologyUsed, other.technologyUsed);
	}
	
	


}
