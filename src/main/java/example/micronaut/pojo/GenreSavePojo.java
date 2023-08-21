package example.micronaut.pojo;

import javax.validation.constraints.NotBlank;

public class GenreSavePojo {
    @NotBlank
    private String name;

    public GenreSavePojo() {
    }

    public GenreSavePojo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreSavePojo name(String name) {
        this.name = name;
        return this;
    }
}
