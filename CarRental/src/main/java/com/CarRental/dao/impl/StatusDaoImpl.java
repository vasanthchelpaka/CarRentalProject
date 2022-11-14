package com.CarRental.dao.impl;
import com.CarRental.Controller.bean.Cars;
import com.CarRental.dao.StatusDao;
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
import java.util.ArrayList;
import java.util.List;
@Repository
public class StatusDaoImpl extends JdbcDaoSupport implements StatusDao {
    @Autowired
    JdbcTemplate jdbcTemp;
    public StatusDaoImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }
    @Autowired
    DataSource dataSource;
    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public List<Cars> updateStatus(int carId, int hashcode) {
        List<Cars> list=new ArrayList<>();
        //String sql="UPDATE Cars SET available = '1' WHERE id = ? and hashcode =?";
        String sql="UPDATE Cars SET available = '0' WHERE id = ? and hashcode =?";
        getJdbcTemplate().update(sql,new Object[]{carId,hashcode});
       /* list= getJdbcTemplate().query(sql,new Object[]{carId,hashcode},new ResultSetExtractor<List<Cars>>(){
            public List<Cars> extractData(ResultSet rs) throws SQLException, DataAccessException {
                List<Cars> list = new ArrayList<Cars>();
                while (rs.next()) {
                    Cars student = new Cars();
                    student.setCarId(rs.getInt("id"));
                    student.setCompany(rs.getString("company"));
                    student.setModel(rs.getString("model"));
                    student.setType(rs.getString("car_type"));
                    student.setPrize(rs.getInt("prize"));
                    student.setFuel(rs.getString("fuel"));
                    list.add(student);
                }
                return list;
            }
        });*/

        return list;
    }
}
