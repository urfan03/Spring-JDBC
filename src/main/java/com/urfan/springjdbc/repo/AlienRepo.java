package com.urfan.springjdbc.repo;

import com.urfan.springjdbc.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlienRepo {

    private JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    @Autowired
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Alien alien) {

        String sql = "insert into alien (id, name, tech) values(?,?,?)";

        int rows = template.update(sql, alien.getId(), alien.getName(), alien.getTech());
        System.out.println(rows + " rows/s inserted");

    }

    public List<Alien> findAll() {

        String sql = "select * from alien";

        RowMapper<Alien> mapper = (ResultSet rs, int rowNum) -> {

                Alien a =new Alien();

                a.setId(rs.getInt(1));
                a.setName(rs.getString(2));
                a.setTech(rs.getString(3));
                return a;
        };

        List<Alien> aliens =  template.query(sql, mapper);
        return aliens;


    }
}
