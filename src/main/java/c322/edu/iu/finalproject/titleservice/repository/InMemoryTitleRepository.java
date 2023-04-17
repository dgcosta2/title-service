package c322.edu.iu.finalproject.titleservice.repository;

import c322.edu.iu.finalproject.titleservice.model.Title;

import java.util.ArrayList;
import java.util.List;

public class InMemoryTitleRepository{

    private List<Title> titles = new ArrayList<>();

    public List<Title> findAll() {
        return titles;
    }

    public int create(Title title) {
        int id = titles.size() + 1;
        title.setId(id);
        titles.add(title);
        return id;
    }

    public void update(Title title, int id) {
        Title x = getTitleById(id);
        if (x != null) {
            x.setName(title.getName());
            x.setAuthor(title.getAuthor());
            x.setYearOfPublication(title.getYearOfPublication());
        } else {
            throw new IllegalStateException("Title id is not valid.");
        }
    }

    public void delete(int id) {
        Title x = getTitleById(id);
        if (x != null) {
            titles.remove(x);
        } else {
            throw new IllegalStateException("Title id is not valid.");
        }
    }

    public Title getTitleById(int id) {
        return titles.stream().filter(x -> x.getId() == id).findAny().orElse(null);
    }
}
