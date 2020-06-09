package com.vole.film.service;

import com.vole.film.FilmApplication;
import com.vole.film.entity.Film;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FilmApplication.class)
@ActiveProfiles("test")
@WebAppConfiguration
public class FilmServiceTest {

    @Resource
    private FilmService filmService;

    @Before
    public void setUp() throws Exception {
        System.out.println("-------------Test Start-----------");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("-------------Test End-------------");
    }

    @Test
    public void findById() {
        Film film = filmService.findById(65);
        System.out.println(film.getName());
    }
}