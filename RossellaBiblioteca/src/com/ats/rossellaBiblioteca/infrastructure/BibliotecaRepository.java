package com.ats.rossellaBiblioteca.infrastructure;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ats.rossellaBiblioteca.domain.Author;
import com.ats.rossellaBiblioteca.domain.Book;


public class BibliotecaRepository {
	public final static String USER_NAME = "BIBLIOTECA";
	public final static String PASSWORD = "BIBLIOTECA";
	public final static String URL = "jdbc:oracle:thin:@10.10.10.38:1521:orcl";
	public final static String INSERT_BOOK= "INSERT INTO BOOK (ID, ISBN, TITLE, DESCRIPTION, PRICE, NUM_PAGES, CATEGORY, PUBLISHER) VALUES (BOOK_SEQUENCE.NEXTVAL,?, ?, ?, ?, ?, ?, ?)";
	public final static String ALL_AUTHORS = "SELECT NAME, LASTNAME FROM AUTHOR";
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);

		}
	}
	
	public Book save(Book toInsert) throws DataException {

		try (Connection conn = DriverManager.getConnection(URL, USER_NAME,
				PASSWORD);
				PreparedStatement st = conn.prepareStatement(INSERT_BOOK);) {

			st.setString(1, toInsert.getIsbn());
			st.setString(2, toInsert.getTitle());
			st.setString(3, toInsert.getDescription());
			st.setDouble(4, toInsert.getPrice());
			st.setInt(5, toInsert.getNumPages());
			st.setString(6, toInsert.getCategory());
			st.setString(7, toInsert.getPublisher());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

		return toInsert;

	}
	
	public Collection<Author> allCourses() throws DataException {
		// List<Course> list=new ArrayList<Course>();
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME,
				PASSWORD);
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(ALL_AUTHORS);) {
			List<Author> result = marshalAuthors(rs);

			System.out
					.println(" NomeAutore     CognomeAutore     ");
			for (Author au : result) {
				System.out.println(au.getName() + " " + au.getLastName() );
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

	}

	private List<Author> marshalAuthors(ResultSet rs) throws SQLException {
		List<Author> result = new ArrayList<Author>();
		while (rs.next()) {
			Author au = new Author(rs.getInt("ID"), rs.getString("NAME"),
					rs.getString("LASTNAME"), rs.getDate("BIRTHDATE"),
					rs.getString("SEX"), rs.getString("PHONE_NUMBER"), rs.getString("ADDRESS"));
			result.add(au);
		}

		return result;
	}
	
	

}
