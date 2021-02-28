package magnbred.ntnu.oblig2.publisher.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import magnbred.ntnu.oblig2.publisher.PublisherApplication;
import magnbred.ntnu.oblig2.publisher.model.Address;
import magnbred.ntnu.oblig2.publisher.model.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.MOCK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = MOCK, classes = PublisherApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @Test
    public void testGetAuthors() throws Exception {
        mockMvc.perform(get("/authors").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(1))))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].name", is("Magnus Bredeli")))
                .andExpect(jsonPath("$[0].dateOfBirth", is("03.02.2000")));
    }

    @Test
    public void testGetAuthorById() throws Exception {
        mockMvc.perform(get("/authors/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Magnus Bredeli")))
                .andExpect(jsonPath("$.dateOfBirth", is("03.02.2000")));
    }

    @Test
    public void testGetAuthorByName() throws Exception {
        mockMvc.perform(get("/authors/name=Magnus Bredeli")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Magnus Bredeli")))
                .andExpect(jsonPath("$.dateOfBirth", is("03.02.2000")));
    }

    @Test
    public void testAddAuthor() throws Exception{
        mockMvc.perform(post("/authors")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Mads Selbo Nyberg\",\n" +
                "        \"dateOfBirth\": \"2000.03.08\",\n" +
                "        \"address\": {\n" +
                "            \"address\": \"Oslo 11\"\n" +
                "        }\n" +
                "}")
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(header().string("Location", "/authors/2"))
        .andExpect(jsonPath("$.id").value(2))
        .andExpect(jsonPath("$.name").value("Mads Selbo Nyberg"))
        .andExpect(jsonPath("$.dateOfBirth").value("2000.03.08"));
    }

     @Test
    public void testUpdateAuthor() throws Exception{
        mockMvc.perform(put("/authors/{id}", 1)
        .content(asJsonString(new Author(1, "Magnus Hals Hellerud", "03.02.2000", new Address("Festningsgata 11"))))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name").value("Magnus Hals Hellerud"));
     }

     @Test
     public void testDeleteAuthor() throws Exception{
        mockMvc.perform(delete("/authors/{id}", 1))
                .andExpect(status().isAccepted());
     }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
