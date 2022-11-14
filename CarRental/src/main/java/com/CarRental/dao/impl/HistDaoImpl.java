package com.CarRental.dao.impl;
import com.CarRental.Controller.bean.Cars;
import com.CarRental.Controller.bean.Hist;
import com.CarRental.dao.HistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class HistDaoImpl extends JdbcDaoSupport implements HistDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }



    @Override
    public List<Hist> getHistById(int hashcode){
        String sql="select * from booking where hashcode=? ";
        List<Hist> list=new ArrayList<>();
        list= getJdbcTemplate().query(sql,new Object[]{hashcode},new ResultSetExtractor<List<Hist>>(){
            public List<Hist> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Hist> list = new ArrayList<Hist>();
                while (rs.next()) {
                    Hist student = new Hist();
                    student.setuserid(rs.getString("userid"));
                    student.setBookedfrom(rs.getString("bookedfrom"));
                    student.setBookedto(rs.getString("bookedto"));
                    student.sethashcode(rs.getString("hashcode"));
                    list.add(student);
                }
                return list;
            }
        });
        return list;
    }
}

