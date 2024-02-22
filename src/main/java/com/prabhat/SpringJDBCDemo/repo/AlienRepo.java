package com.prabhat.SpringJDBCDemo.repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.prabhat.SpringJDBCDemo.model.Alien;

@Repository
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    //Here auto wire is used to generate by Spring itself 
    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    //This method will add the data into the table[ArrayList] is  in AlienRepo
    public void save(Alien alien){

        String sql = "insert into alien (id, name, tech) values (?, ?, ?)";
        int rows = template.update(sql, alien.getId(),alien.getName(),alien.getTech());
        System.out.println(rows);
    }

    public List<Alien> findAll(){

        String sql = "select * from alien";
        RowMapper<Alien> mapper = new RowMapper<Alien>(){

            // Here is the mapper which take the list of alien objects take it one by one

            @Override
            public Alien mapRow(ResultSet rs, int rowNum) throws SQLException {
                Alien a = new Alien();

                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));

                return a;
            }
            
        };

        // After take it one by one it store in the list of alien;
        
        List<Alien> aliens =  template.query(sql,mapper);


        return aliens;
    }
    
}
