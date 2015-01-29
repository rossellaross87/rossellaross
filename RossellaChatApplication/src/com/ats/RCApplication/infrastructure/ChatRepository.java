package com.ats.RCApplication.infrastructure;

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

import com.ats.RCApplication.domain.Informazioni;
import com.ats.RCApplication.domain.Messaggi;
import com.ats.RCApplication.domain.Segnalazione;
import com.ats.RCApplication.domain.Utente;

public class ChatRepository {
	public final static String USER_NAME = "adminProj";
	public final static String PASSWORD = "adminProj";
	public final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	public static final String INSERT_Utente = "INSERT INTO utenti (ID_UTENTE, USER_NAME, PASSWORD) VALUES (USER_SEQUENCE.NEXTVAL,?, ?)";
	public static final String INSERT_INFORMAZIONI = "INSERT INTO INFORMAZIONI (ID_INFO, NAME, LASTNAME, CITY, SEX, COUNTRY, HEIGHT, LOOK, RELATIONSHIP, EDUCATION, JOB, HOBBIES, ID_UT_ACCOUNT, AGE) VALUES (INFORMATION_SEQUENCE.NEXTVAL,?, ?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String SELECT_LAST_USER_INSERTED = "select decode (CONT,null,0,CONT) as IDU from (SELECT MAX(ID_UTENTE) AS CONT FROM utenti )  t1";
	public static final String DELETE_USER_INSERTED = "delete from utenti where USER_NAME = ? ";
	public static final String SELECT_USER_BY_USER_NAME = "select * from utenti where USER_NAME = ? ";
	public static final String SELECT_USER_BY_UN_AND_PW = "SELECT * from utenti WHERE USER_NAME=? AND PASSWORD=? ";
	public static final String SELECT_INFORMATION_BY_USER = "SELECT * FROM INFORMAZIONI WHERE ID_UT_ACCOUNT = ?";
	public static final String UPDATE_INFORMATION_BY_USER = "UPDATE INFORMAZIONI SET NAME = ?,LASTNAME=?, CITY=?, SEX=?, COUNTRY=?, HEIGHT=?, LOOK =?, RELATIONSHIP=?, EDUCATION=?, JOB=?, HOBBIES=?, AGE=? WHERE ID_UT_ACCOUNT=?";
	public static final String DELETE = "UPDATE UTENTI SET ISBANNED = 1 WHERE ID_UTENTE =?";
	public static final String UPDATE_PWD = "update utenti set password = ? where ID_UTENTE = ?";
	public static final String ALL_USERS = "SELECT * FROM UTENTI WHERE ISADMIN = 0 AND ISBANNED =0 order by user_name ";
	public static final String SELECT_USER_BY_ID = "select * from UTENTI where id_utente = ?";
	public static final String SELECT_USER_BY_USER_NAME_LIKE = "select * from utenti where user_name like lower(?) or user_name like ? or user_name like initcap(?) and isadmin=0 and isbanned=0 order by user_name";
	public static final String SELECT_USERS_BY_CITY_LIKE = "select * from utenti u join informazioni i on u.id_utente=i.id_ut_account where city like ? or city like upper(?) or city like initcap(?) and isadmin=0 and isbanned=0 order by user_name";
	public static final String SELECT_USERS_BY_SEX = "select * from utenti u join informazioni i on u.id_utente=i.id_ut_account where SEX=? and isadmin=0 and isbanned=0 order by user_name";
	public static final String SELECT_USERS_BY_RELATIONSHIP = "select * from utenti u join informazioni i on u.id_utente=i.id_ut_account where relationship = ? and isadmin=0 and isbanned=0 order by user_name";
	public static final String SELECT_USERS_BY_AGE = "select * from utenti u join informazioni i on u.id_utente=i.id_ut_account where age between ? and ? and isadmin=0 and isbanned=0 order by user_name";
	public static final String BAN_USER = "insert into segnalazioni values (BAN_SEQUENCE.NEXTVAL, ?, ?,to_date(?, 'dd/MM/yyyy HH24:mi:ss'))";
	public static final String INSERT_MESSAGE="insert into messaggi values (message_sequence.nextval,?, ?, ?, SYSDATE) ";
	public static final String SELECT_CONVERSATION3 = "select * from messaggi where (id_sender = ? and id_receiver=?) or (id_sender = ? and id_receiver=?) order by date_msg desc";
	public static final String SELECT_CONVERSATION2  =	" select * " +
														" from " +
														" ( " +
														" select ID_MESSAGE, ID_SENDER, ID_RECEIVER, TEXT, DATE_MSG from messaggi where (id_sender = ? and id_receiver= ?) " +
														" UNION " +
														" select ID_MESSAGE, ID_RECEIVER, ID_SENDER, TEXT, DATE_MSG  from messaggi where (id_sender = ? and id_receiver= ?) " +
														" )  tab order by DATE_MSG desc ";
	public static final String SELECT_CONVERSATION = "select m.id_message, m.id_sender, u.user_name UNS, m.id_receiver, t.user_name UNR, m.date_msg, m.text " +
													"	from messaggi m " +
													"	join utenti u on u.id_utente = m.id_sender " +
													"	join utenti t on t.id_utente = m.id_receiver " +
													"	where (m.id_sender = ? and m.id_receiver= ? ) or (m.id_sender = ? and m.id_receiver=  ? ) " +
													"	order by date_msg desc";
	public static final String ALL_USERS_FOR_ADMIN = "select * from utenti where isadmin=0";
	public static final String ALL_BANS = "select * from segnalazioni";
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage(), e);

		}
	}
	public int result;

	public int searchLastIdUserInserted() throws SQLException, DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(SELECT_LAST_USER_INSERTED);) {

			while (rs.next()) {
				result = rs.getInt("CONT");
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

		return result;
	}

	public Informazioni getInformationByUserID(int userID) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(SELECT_INFORMATION_BY_USER);) {
			st.setInt(1, userID);
			try (ResultSet rs = st.executeQuery();) {
				Informazioni info = null;

				if (rs.next()) {

					String name = rs.getString("NAME");
					String lastName = rs.getString("LASTNAME");
					String city = rs.getString("CITY");
					String sex = rs.getString("SEX");
					String country = rs.getString("COUNTRY");
					Double height = rs.getDouble("HEIGHT");
					String look = rs.getString("LOOK");
					String relationship = rs.getString("RELATIONSHIP");
					String education = rs.getString("EDUCATION");
					String job = rs.getString("JOB");
					String hobbies = rs.getString("HOBBIES");
					Integer age = rs.getInt("AGE");

					info = new Informazioni(name, lastName, city, sex, country, height, look, relationship, education, job, hobbies, userID, age);

				}

				return info;

			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new DataException(e.getMessage(), e);
		}

	}
	
	public Collection<Utente> getUsersByAge(int ageMin, int ageMax) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
				PreparedStatement st = conn.prepareStatement(SELECT_USERS_BY_AGE);

		) {
			st.setInt(1, ageMin);
			st.setInt(2, ageMax);

			try (ResultSet rs = st.executeQuery();) {
				List<Utente> result = marshalUtente(rs);
				return result;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}


	public Collection<Utente> getUsersByRelationship(String relationship) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(SELECT_USERS_BY_RELATIONSHIP);

		) {
			st.setString(1, relationship);

			try (ResultSet rs = st.executeQuery();) {
				List<Utente> result = marshalUtente(rs);
				return result;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public Collection<Utente> getUsersBySex(String sex) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(SELECT_USERS_BY_SEX);

		) {
			st.setString(1, sex);

			try (ResultSet rs = st.executeQuery();) {
				List<Utente> result = marshalUtente(rs);
				return result;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public Collection<Utente> getUsersByUserName(String userName) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(SELECT_USER_BY_USER_NAME);

		) {
			st.setString(1, userName);

			try (ResultSet rs = st.executeQuery();) {
				List<Utente> result = marshalUtente(rs);
				return result;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public Collection<Utente> getUsersByUserCityLike(String cityLike) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(SELECT_USERS_BY_CITY_LIKE);

		) {

			st.setString(1, cityLike + "%");
			st.setString(2, cityLike + "%");
			st.setString(3, cityLike + "%");

			try (ResultSet rs = st.executeQuery();) {
				List<Utente> result = marshalUserName(rs);
				return result;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public Collection<Utente> getUsersByUserNameLike(String userNameLike) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(SELECT_USER_BY_USER_NAME_LIKE);

		) {

			st.setString(1, userNameLike + "%");
			st.setString(2, userNameLike + "%");
			st.setString(3, userNameLike + "%");

			try (ResultSet rs = st.executeQuery();) {
				List<Utente> result = marshalUserName(rs);
				return result;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}
	
	public Collection<Messaggi> getConversation(int idSender, int idReceiver) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
				PreparedStatement st = conn.prepareStatement(SELECT_CONVERSATION);

		) {
			st.setInt(1, idSender);
			st.setInt(2, idReceiver);
			st.setInt(3, idReceiver);
			st.setInt(4, idSender);

			try (ResultSet rs = st.executeQuery();) {
				List<Messaggi> result = marshalMessages(rs);
				return result;

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	private List<Messaggi> marshalMessages(ResultSet rs) throws SQLException {
		List<Messaggi> result = new ArrayList<Messaggi>();
		while (rs.next()) {
			Messaggi m = new Messaggi(rs.getInt("ID_MESSAGE"), rs.getInt("ID_SENDER"), rs.getInt("ID_RECEIVER"), rs.getString("TEXT"), rs.getString("DATE_MSG"));
			
			m.setUserReceiver(rs.getString("UNR"));
			m.setUserSender(rs.getString("UNS"));
			
			
			result.add(m);
		}

		return result;
	}

	public void update(Informazioni toUpdate, int idUser) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(UPDATE_INFORMATION_BY_USER);) {

			st.setString(1, toUpdate.getName());
			st.setString(2, toUpdate.getLastName());
			st.setString(3, toUpdate.getCity());
			st.setString(4, toUpdate.getSex());
			st.setString(5, toUpdate.getCountry());
			st.setDouble(6, toUpdate.getHeight());
			st.setString(7, toUpdate.getLook());
			st.setString(8, toUpdate.getRelationship());
			st.setString(9, toUpdate.getEducation());
			st.setString(10, toUpdate.getJob());
			st.setString(11, toUpdate.getHobbies());
			st.setInt(12, toUpdate.getAge());
			st.setInt(13, idUser);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new DataException(e.getMessage(), e);
		}

	}

	public void updatePwd(Utente toUpdate, String newPwd) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(UPDATE_PWD);) {
			st.setString(1, newPwd);
			st.setInt(2, toUpdate.getId());

			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new DataException(e.getMessage(), e);
		}

	}

	public void deleteUser(int idUser) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
				PreparedStatement st = conn.prepareStatement(DELETE);) {

			st.setInt(1, idUser);
			st.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new DataException(e.getMessage(), e);
		}

	}

	public Utente getUsersById(int id) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
				PreparedStatement st = conn.prepareStatement(SELECT_USER_BY_ID);

		) {
			st.setInt(1, id);

			try (ResultSet rs = st.executeQuery();) {
				Utente utente = null;
				if (rs.next()) {
					boolean isAdmin = false;
					if (rs.getInt("ISADMIN") == 1)
						isAdmin = true;

					// boolean isBanned = false;
					// if(rs.getInt(5)== 1)
					// isBanned = true;

					boolean isBanned = rs.getInt("ISBANNED") == 1 ? true : false;

					utente = new Utente(rs.getInt("ID_UTENTE"), rs.getString("USER_NAME"), rs.getString("PASSWORD"), isAdmin, isBanned);
				}
				return utente;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public Utente getUsersByUserNameAndPassword(String userName, String password) throws DataException {
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(SELECT_USER_BY_UN_AND_PW);

		) {
			st.setString(1, userName);
			st.setString(2, password);

			try (ResultSet rs = st.executeQuery();) {
				Utente utente = null;
				if (rs.next()) {
					boolean isAdmin = false;
					if (rs.getInt("ISADMIN") == 1)
						isAdmin = true;

					// boolean isBanned = false;
					// if(rs.getInt(5)== 1)
					// isBanned = true;

					boolean isBanned = rs.getInt("ISBANNED") == 1 ? true : false;

					utente = new Utente(rs.getInt("ID_UTENTE"), rs.getString("USER_NAME"), rs.getString("PASSWORD"), isAdmin, isBanned);
				}
				return utente;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}
	}

	public Collection<Utente> allUsers() throws DataException {
		// List<Course> list=new ArrayList<Course>();
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(ALL_USERS);) {
			List<Utente> result = marshalUserName(rs);

			System.out.println(" Username :");
			for (Utente u : result) {
				System.out.println(u.getUserName());
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

	}

	public Collection<Utente> allUsersForAdmin() throws DataException {
		// List<Course> list=new ArrayList<Course>();
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
				Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(ALL_USERS_FOR_ADMIN);) {
			List<Utente> result = marshalUtente(rs);

			System.out.println(" Username :");
			for (Utente u : result) {
				System.out.println(u.getUserName());
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

	}
	
	
	public Collection<Segnalazione> allBans() throws DataException {
		// List<Course> list=new ArrayList<Course>();
		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); 
				Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(ALL_BANS);) {
			List<Segnalazione> result = marshalSegnalazione(rs);

			System.out.println(" segnalazione :");
			for (Segnalazione s : result) {
				System.out.println(s.getDateBanString());
				ResultSet rsBanners = st.executeQuery("select * from utenti where id_utente="+s.getIdBanner());
				while (rsBanners.next()) {
					s.setUserNameBanner(rsBanners.getString("user_name"));
				}
				ResultSet rsBanned = st.executeQuery("select * from utenti where id_utente=" + s.getIdBanned());
				while (rsBanned.next()) {
					s.setUserNameBanned(rsBanned.getString("user_name"));
				}
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}}
	private List<Segnalazione> marshalSegnalazione(ResultSet rs) throws SQLException {
		List<Segnalazione> result = new ArrayList<Segnalazione>();
		while (rs.next()) {
			
			
			Segnalazione s = new Segnalazione(rs.getInt("ID_SEGNALAZIONE"), rs.getInt("ID_SEGNALATORE"),
					rs.getInt("ID_SEGNALATO"), rs.getDate("DATE_TIME_SEGN").toString());
			
			result.add(s);
		}

		return result;
	}

	private List<Utente> marshalUtente(ResultSet rs) throws SQLException {
		List<Utente> result = new ArrayList<Utente>();
		while (rs.next()) {
			boolean isAdmin = rs.getInt("ISADMIN")==1? true:false;
			boolean isBanned= rs.getInt("ISBANNED")==1? true : false;
			Utente u = new Utente(rs.getInt("ID_UTENTE"), rs.getString("USER_NAME"), rs.getString("PASSWORD"), isAdmin,
					isBanned);
			
			result.add(u);
		}

		return result;
	}

	private List<Utente> marshalUserName(ResultSet rs) throws SQLException {
		List<Utente> result = new ArrayList<Utente>();
		while (rs.next()) {
			Utente u = new Utente(rs.getString("USER_NAME"));
			u.setId(rs.getInt("ID_UTENTE"));
			result.add(u);
		}

		return result;
	}

	public Utente saveUserAllInformation(Utente userToInsert, Informazioni infoToInsert) throws DataException {
		Connection conn = null;
		try {
			// preparo la connessione
			conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			conn.setAutoCommit(false);
			// step 1 insert user
			PreparedStatement st = conn.prepareStatement(INSERT_Utente);

			st.setString(1, userToInsert.getUserName());
			st.setString(2, userToInsert.getPassword());

			st.execute();

			// step 2 select last id

			st = conn.prepareStatement(SELECT_LAST_USER_INSERTED);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				infoToInsert.setIdUser(rs.getInt("IDU"));
			}

			// step 3 inser info
			st = conn.prepareStatement(INSERT_INFORMAZIONI);
			st.setString(1, infoToInsert.getName());
			st.setString(2, infoToInsert.getLastName());
			st.setString(3, infoToInsert.getCity());
			st.setString(4, infoToInsert.getSex());
			st.setString(5, infoToInsert.getCountry());
			st.setDouble(6, infoToInsert.getHeight());
			st.setString(7, infoToInsert.getLook());
			st.setString(8, infoToInsert.getRelationship());
			st.setString(9, infoToInsert.getEducation());
			st.setString(10, infoToInsert.getJob());
			st.setString(11, infoToInsert.getHobbies());
			st.setInt(12, infoToInsert.getIdUser());
			st.setInt(13, infoToInsert.getAge());
			st.execute();
			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

		return userToInsert;
	}

	public Utente saveUser(Utente toInsert) throws DataException {

		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement st = conn.prepareStatement(INSERT_Utente);) {

			st.setString(1, toInsert.getUserName());
			st.setString(2, toInsert.getPassword());

			st.execute();
			// st= conn.prepareStatement(SELECT_LAST_USER_INSERTED);
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

		return toInsert;
	}
	
	public int sendMessage(int idSender, int idReceiver, String mess) throws DataException {

		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement st = conn.prepareStatement(INSERT_MESSAGE);) {

			st.setInt(1, idSender);
			st.setInt(2, idReceiver);
			st.setString(3, mess);
			
						
			st.execute();
			
			return 1;
			// st= conn.prepareStatement(SELECT_LAST_USER_INSERTED);
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
			
		}

	
	}
	
	
	public void banUser(int idBanner, int idBanned, String dateString) throws DataException {

		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
				PreparedStatement st = conn.prepareStatement(BAN_USER);) {

			st.setInt(1, idBanner);
			st.setInt(2, idBanned);
			st.setString(3, dateString);
			
			st.execute();
			// st= conn.prepareStatement(SELECT_LAST_USER_INSERTED);
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

		
	}
	

	public void deleteLastUserInserted(String userName) throws DataException {

		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(DELETE_USER_INSERTED);) {

			st.setString(1, userName);

			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

		return;
	}

	public Informazioni saveInformation(Informazioni toInsert2) throws DataException {

		try (Connection conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD); PreparedStatement st = conn.prepareStatement(INSERT_INFORMAZIONI);) {

			st.setString(1, toInsert2.getName());
			st.setString(2, toInsert2.getLastName());
			st.setString(3, toInsert2.getCity());
			st.setString(4, toInsert2.getSex());
			st.setString(5, toInsert2.getCountry());
			st.setDouble(6, toInsert2.getHeight());
			st.setString(7, toInsert2.getLook());
			st.setString(8, toInsert2.getRelationship());
			st.setString(9, toInsert2.getEducation());
			st.setString(10, toInsert2.getJob());
			st.setString(11, toInsert2.getHobbies());
			st.setInt(12, toInsert2.getIdUser());
			st.setInt(13, toInsert2.getAge());
			st.execute();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
		}

		return toInsert2;

	}

}
