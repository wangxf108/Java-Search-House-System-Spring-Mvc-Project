package jp.co.house.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.house.entity.NewHouseEntity;
import jp.co.house.model.NewHouseDataModel;

public class DAO {

	public static ArrayList<NewHouseEntity> getHouseData(NewHouseDataModel b){

		//save search result
		ArrayList<NewHouseEntity> searchResult = new ArrayList<NewHouseEntity>();

		try {
			//connet with database
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5434/postgres", "postgres", "postgres");
			con.setAutoCommit(false);

			//SQL文実行
		    String SQL1 = "SELECT \"ID\", housename, price, station, distance, housetype FROM public.house";

		    PreparedStatement ps = con.prepareStatement(SQL1);

		    String cheZan = b.getStation();
		    if (cheZan !=null && !"".equals( cheZan.trim() )) {
		    	String SQL2 = SQL1 + " where station = ? ";
		    	ps = con.prepareStatement(SQL2);
			    ps.setString(1, cheZan);
		    }
		    //実行SQL


			ResultSet resultset = ps.executeQuery();

			while(resultset.next()) {
				NewHouseEntity h1 = new NewHouseEntity();
				h1.setId( resultset.getString("ID"));
				h1.setHouseName(resultset.getString("housename"));
				h1.setPrice((resultset.getString("price")));
				h1.setStation(resultset.getString("station"));
				h1.setDistance(resultset.getString("distance"));
				h1.setHouseType(resultset.getString("housetype"));

				searchResult.add(h1);
				System.out.println(resultset.getString("housename"));

			}

			//DBを閉じる
			ps.close();
			con.close();
		}catch(Exception e1) {
			System.out.println(" DB error");
			return searchResult;
		}
		return searchResult;

		}

}

