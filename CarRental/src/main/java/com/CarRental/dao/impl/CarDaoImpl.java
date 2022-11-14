package com.CarRental.dao.impl;
import com.CarRental.Controller.bean.Cars;
import com.CarRental.dao.CarDao;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl extends JdbcDaoSupport implements CarDao {


    @Autowired
    JdbcTemplate jdbcTemp;

    public CarDaoImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    List<Cars> list1=new ArrayList<>();

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }



    @Override
    public List<Cars> getCarById(LocalDate bookfrom,LocalDate bookto,String type) {
        List<Cars> list=new ArrayList<>();


        if(type.equals("any")){
            String sql="select * from cars where id in (SELECT id from cars where (( bookto < NOW() AND actualReturnDate is null ) \n" +
                    "OR ( actualReturnDate < NOW() ))\n" +
                    "AND  ((bookfrom NOT BETWEEN ? and ?)\n" +
                    "AND (bookto NOT BETWEEN ? and ?) )\n" +
                    "AND ((bookfrom > ? AND BOOKTO >? ) \n" +
                    "OR  (bookfrom < ? AND BOOKTO < ?))\n" +
                    "AND ( ? > NOW())) ";

            list= getJdbcTemplate().query(sql,new Object[]{bookfrom,bookto,bookfrom,bookto,bookfrom,bookto,bookfrom,bookto,bookfrom},new ResultSetExtractor<List<Cars>>(){
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
                        list1=list;
                        //list1.addAll(list);
                        System.out.println("b");
                        System.out.println(list1);
                        // list1 = list.stream()
                   /*         .collect(Collectors.toList());
                    System.out.println(list1);
                    System.out.println("list1");*/
                    }
                    return list;
                }
            });
            return list;
        }

            String sql = "select * from cars where id in (SELECT id from cars where (( bookto < NOW() AND actualReturnDate is null ) \n" +
                    "OR ( actualReturnDate < NOW() ))\n" +
                    "AND  ((bookfrom NOT BETWEEN ? and ?)\n" +
                    "AND (bookto NOT BETWEEN ? and ?) )\n" +
                    "AND ((bookfrom > ? AND BOOKTO >? ) \n" +
                    "OR  (bookfrom < ? AND BOOKTO < ?))\n" +
                    "AND ( ? > NOW())) AND car_type = ?";

        list= getJdbcTemplate().query(sql,new Object[]{bookfrom,bookto,bookfrom,bookto,bookfrom,bookto,bookfrom,bookto,bookfrom,type},new ResultSetExtractor<List<Cars>>(){
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
                    list1=list;
                    //list1.addAll(list);
                    System.out.println("b");
                    System.out.println(list1);
                   // list1 = list.stream()
                   /*         .collect(Collectors.toList());
                    System.out.println(list1);
                    System.out.println("list1");*/
                }
                return list;
            }
            });
        return list;
    }

    public List<Cars> returnList(){
        //System.out.println(list1);
        //System.out.println("list");
         return this.list1;
    }



}
