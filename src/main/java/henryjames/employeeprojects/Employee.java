package henryjames.employeeprojects;

import java.util.Objects;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

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
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	private String technicalskill;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "EMPLOYEE_PROJECT_MAPPING", joinColumns = @JoinColumn(name="employee_id"),
										inverseJoinColumns = @JoinColumn(name="project_id"))
	private Set<Project> projects;
	
	public Employee() {
		
		
	}
	
	public Employee(String name, String techskill) {
		
		this.name = name;
		this.technicalskill = techskill;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechnicalskill() {
		return technicalskill;
	}

	public void setTechnicalskill(String technicalskill) {
		this.technicalskill = technicalskill;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", technicalskill=" + technicalskill + ", projects=" + projects
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, projects, technicalskill);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id && Objects.equals(name, other.name) && Objects.equals(projects, other.projects)
				&& Objects.equals(technicalskill, other.technicalskill);
	}
	
	
	
	

}
