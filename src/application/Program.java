package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DBException;
import model.entities.Departament;

public class Program {

	
	public static void main(String[] args) {
		
		Departament departament = new Departament(1,"Books");
		System.out.println(departament);
		
	}
	
}
