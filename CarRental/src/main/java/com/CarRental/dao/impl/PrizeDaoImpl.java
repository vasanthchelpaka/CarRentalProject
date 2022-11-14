package com.CarRental.dao.impl;

import com.CarRental.Controller.bean.Cars;
import com.CarRental.dao.PrizeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Repository
public class PrizeDaoImpl extends JdbcDaoSupport implements PrizeDao {
    @Autowired
    JdbcTemplate jdbcTemp;
    public PrizeDaoImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }
    @Autowired
    DataSource dataSource;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Autowired
    CarDaoImpl carDaoImpl;






 /*   @Override
    public List<Cars> getCarsAfterSort( String prize, String sort) {
        String s = "desc";

        if (s.equals(sort)) {
            String SQL = "select * from cars where car_type= ? && bookto > ? and bookfrom > ? and prize=? order by prize desc";
        }


            String SQL = "select * from cars where car_type= ? && bookto > ? and bookfrom > ? and prize=? order by prize";

        List<Cars> list=new ArrayList<>();

        list= getJdbcTemplate().query(SQL,new Object[]{type,bookfrom,bookto,prize},new ResultSetExtractor<List<Cars>>(){
            public List<Cars> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Cars> list = new ArrayList<Cars>();
                while (rs.next()) {
                    Cars student = new Cars();
                    student.setCarId(rs.getInt("id"));
                    student.setCompany(rs.getString("company"));
                    student.setModel(rs.getString("model"));
                    student.setType(rs.getString("car_type"));
                    student.setPrize(rs.getInt("prize"));
                    list.add(student);
                }
                return list;
            }
        });
        return list;
    }*/

    @Override
    public List<Cars> getCarsAfterSort(String sort) {
        String s = "desc";

        List<Cars> list=new ArrayList<>();
        list=carDaoImpl.returnList();
        Cars a=new Cars();
        Cars.Sortbyroll b=a.new Sortbyroll();
        Cars.Sortbyrolldesc c=a.new Sortbyrolldesc();

        if(s.equals(sort)){
            Collections.sort(list, c);

        }
        else {
            Collections.sort(list, b);
        }

        /*list= getJdbcTemplate().query(SQL,new Object[]{type,bookfrom,bookto,prize},new ResultSetExtractor<List<Cars>>(){
            public List<Cars> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Cars> list = new ArrayList<Cars>();
                while (rs.next()) {
                    Cars student = new Cars();
                    student.setCarId(rs.getInt("id"));
                    student.setCompany(rs.getString("company"));
                    student.setModel(rs.getString("model"));
                    student.setType(rs.getString("car_type"));
                    student.setPrize(rs.getInt("prize"));
                    list.add(student);
                }
                return list;
            }
        });*/
        System.out.println("a");
        System.out.println("in global"+list);

        return list;
    }



}
