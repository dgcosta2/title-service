package c322.edu.iu.finalproject.titleservice.controller;

import c322.edu.iu.finalproject.titleservice.model.Title;
import c322.edu.iu.finalproject.titleservice.repository.TitleRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/titles")
public class TitlesController {

    private TitleRepository repository;

    public TitlesController(TitleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Title> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public int create(@Valid @RequestBody Title title) {
        Title newTitle = repository.save(title);
        return newTitle.getId();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Title title, @PathVariable int id) {
        title.setId(id);
        Optional<Title> c = repository.findById(id);
        if (c.isPresent())
            repository.save(title);
        else throw new IllegalStateException("Title is not in the database.");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Title title = new Title();
        title.setId(id);
        repository.delete(title);
    }
}
