package example.micronaut.repository;

import example.micronaut.domain.Genre;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface GenreRepository {
    Optional<Genre> findById(@NotNull Long id);

    Genre save(@NotBlank String name);

    void deleteById(@NotNull Long id);

    List<Genre> findAll();

    int update(@NotNull Long id, @NotBlank String name);
}
