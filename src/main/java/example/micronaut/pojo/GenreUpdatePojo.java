package example.micronaut.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class GenreUpdatePojo {
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    public GenreUpdatePojo() {
    }

    public GenreUpdatePojo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
