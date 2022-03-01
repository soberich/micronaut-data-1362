package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

@MicronautTest
class MicronautData1362Test {

    @Test
    void testItWorks(PojoRepository pojos) {
        pojos.save(new Pojo(null, List.of()));
        Assertions.assertNotNull(pojos.findAll());
    }
}
