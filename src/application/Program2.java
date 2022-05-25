package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {

	public static void main(String[] args) {
		
		
		System.out.println("Test #1 - Department -> findById");
		DepartmentDao daoDepartmentDao = DaoFactory.createDepartamentDao();
		Department department = daoDepartmentDao.findById(1);
		System.out.println(department);
		System.out.println();
		
		
		System.out.println("Test #2 - Department -> findByDepartment");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(7);
		department = daoDepartmentDao.findBySeller(seller);
		System.out.println(department);
		System.out.println();
		
		System.out.println("Test #3 - Department -> findAll");
		List<Department> listDepartment = new ArrayList<>();
		
		listDepartment = daoDepartmentDao.findAll();
		for(Department d:listDepartment) {
			System.out.println(d);
		}
		System.out.println();
		
		System.out.println("Test #4 - Department -> insert");
		department = new Department(null,"Marketing");
		daoDepartmentDao.insert(department);
		System.out.println("New department with Id: "+department.getId());
		System.out.println();
		
		System.out.println("Test #5 - Department -> update");
		department = new Department(department.getId(),"Marketing"+department.getId());
		daoDepartmentDao.update(department);
		System.out.println("Department updated.");
		System.out.println();
		
		System.out.println("Test #6 - Department -> delete");
		daoDepartmentDao.delete(department.getId());
		System.out.println("Department deleted.");
		System.out.println();
	}

}
