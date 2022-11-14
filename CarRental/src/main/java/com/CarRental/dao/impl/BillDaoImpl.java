package com.CarRental.dao.impl;
import com.CarRental.Controller.bean.Cars;
import com.CarRental.dao.BillDao;
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
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Repository
public class BillDaoImpl extends JdbcDaoSupport implements BillDao {

    @Autowired
    JdbcTemplate jdbcTemp;

    @Autowired
    CarDaoImpl carDaoImpl;


    public BillDaoImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }


    @Override
    public List<Cars> getBillById(Integer id){

        int a = ThreadLocalRandom.current().nextInt();
        int x = Math.abs(a);



            String SQL1="update cars set hashcode= ? where id=?";
            jdbcTemp.update(SQL1,new Object[]{x,id});
            String sql2 = "insert into booking (userid,hashcode,bookedfrom,bookedto) values (?,?,?,?) ";
            String sql3="UPDATE Cars SET bookfrom = ?, bookto=? WHERE id = ? ";
            String SQL = "select * from cars where id = ?";
            List<Cars> list=new ArrayList<>();

            list= getJdbcTemplate().query(SQL,new Object[]{id},new ResultSetExtractor<List<Cars>>(){

                public List<Cars> extractData(ResultSet rs) throws SQLException, DataAccessException {
                    List<Cars> list = new ArrayList<Cars>();
                    while (rs.next()) {
                        Cars student = new Cars();
                        student.setCarId(rs.getInt("id"));
                        student.setCompany(rs.getString("company"));
                        student.setModel(rs.getString("model"));
                        student.setType(rs.getString("car_type"));
                        student.setPrize(rs.getInt("prize"));
                        student.sethashcode(String.valueOf(x));
                        list.add(student);
                        LocalDate a = LocalDate.parse(rs.getString("bookfrom"));
                        LocalDate b = LocalDate.parse(rs.getString("bookto"));
                        jdbcTemp.update(sql3,new Object[]{a,b,rs.getInt("id")});
                        jdbcTemp.update(sql2,new Object[]{id,x,rs.getString("bookfrom"),rs.getString("bookto")});
                    }
                    return list;
                }
            });
            return list;
        }


    }

