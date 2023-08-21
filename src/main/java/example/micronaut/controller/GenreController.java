package example.micronaut.controller;

import example.micronaut.domain.Genre;
import example.micronaut.pojo.GenreSavePojo;
import example.micronaut.pojo.GenreUpdatePojo;
import example.micronaut.repository.GenreRepository;
import io.micronaut.http.HttpHeaders;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Validated
@Controller(value = "/genres")
public class GenreController {
    protected final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Get("/{id}")
    public Genre show(Long id) {
        return genreRepository
                .findById(id)
                .orElse(null);
    }

    @Put("/")
    public HttpResponse update(@Body @Valid GenreUpdatePojo updatePojo) {
        genreRepository.update(updatePojo.getId(), updatePojo.getName());

        return HttpResponse
                .noContent()
                .header(HttpHeaders.LOCATION, location(updatePojo.getId()).getPath());
    }

    @Get(value = "/list")
    public List<Genre> list() {
        return genreRepository.findAll();
    }

    @Post("/")
    public HttpResponse<Genre> save(@Body @Valid GenreSavePojo savePojo) {
        Genre genre = genreRepository.save(savePojo.getName());

        return HttpResponse
                .created(genre)
                .headers(headers -> headers.location(location(genre.getId())));
    }

    @Delete("/{id}")
    public HttpResponse delete(Long id) {
        genreRepository.deleteById(id);
        return HttpResponse.noContent();
    }

    protected URI location(Long id) {
        return URI.create("/genres/" + id);
    }

    protected URI location(Genre genre) {
        return location(genre.getId());
    }
}
