package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	
	public static void main(String[] args) throws ParseException {
	
		SimpleDateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Test #1 - Seller -> findById");
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Seller seller = sellerDao.findById(3);
		System.out.println(seller+"");
		System.out.println();
		
		System.out.println("Test #2 - Seller -> findByDepartment");
		List<Seller> list = sellerDao.findByDepartment(2);
		for(Seller s:list) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("Test #3 - Seller -> findAll");
		list = sellerDao.findAll();
		for(Seller s:list) {
			System.out.println(s);
		}
		System.out.println();
		
		System.out.println("Test #4 - Seller -> insert");
		Department department = new Department(2, null);
		Seller newSeller = new Seller(
				null,"Juliana"
				,"juliana@test.com",sdf.parse("05/02/1994")
				,4000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("new seller created: "+ newSeller.getId());
		System.out.println();
		
		System.out.println("Test #5 - Seller -> update");
		newSeller.setBaseSalary(4500.00);
		newSeller.setName(newSeller.getName()+newSeller.getId());
		sellerDao.update(newSeller);
		
		System.out.println("Test #6 - Seller -> delete");
		sellerDao.delete(newSeller.getId());
		
		
	}
	
}
 