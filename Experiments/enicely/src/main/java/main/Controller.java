package main;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class Controller
{
    HashMap<String, TestUnit> database = new HashMap<>();

    @GetMapping("/")
    public String test()
    {
        return "xyzzz";
    }

    @GetMapping("/name/{name}")
    public TestUnit getByName(@PathVariable String name) {
        return database.get(name);
    }

    @DeleteMapping("/name/{name}")
    public @ResponseBody HashMap<String, TestUnit> deleteByName(@PathVariable String name) {
        database.remove(name);
        return database;
    }

    @PostMapping("/name/{name}")
    public @ResponseBody HashMap<String, TestUnit> addName(@PathVariable String name) {
        database.put(name, new TestUnit(name));
        return database;
    }

    @PutMapping("/name/{name}")
    public @ResponseBody HashMap<String, TestUnit> updateName(@PathVariable String name, @RequestBody TestUnit updated) {
        database.replace(name, updated);
        return database;
    }
}
