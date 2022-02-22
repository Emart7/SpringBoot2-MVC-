package com.example.webexample.controllers;

import com.example.webexample.model.Color;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ColorsController {

    //Previous list of colors
    private static List<Color> colors = new ArrayList<>();

    public ColorsController() {
        colors.add(new Color(1, "Red", "255, 0, 0"));
        colors.add(new Color(2, "Black", "0,0,0"));
        colors.add(new Color(3, "Yellow", "255, 255, 0"));
        colors.add(new Color(4, "White", "255, 255, 255"));
        colors.add(new Color(5, "Gray", "128, 128, 128"));
        colors.add(new Color(6, "Blue", "0, 0, 255"));
    }

    @GetMapping("/colors")
    public List<Color> getAllColors() {
        return colors;
    }

    //We consult the color by its ID
    @GetMapping("/colors/{id}")
    public Color getColorById(@PathVariable("id") Integer id) {
        return colors.stream()
                .filter(c -> c.getIdColor().equals(id))
                .findFirst().get();
    }

    //We consult the color by its name
    @GetMapping("/colors/{id}/{name}")
    public String getColorById(@PathVariable("id") Integer id, @PathVariable("name") String name) {
        return colors.stream()
                .filter(c -> c.getIdColor().equals(id))
                .filter(c -> c.getDescription().equals(name))
                .findFirst().get().
                getRgb();

    }

    @GetMapping("/colorsQuery")
    public String getColorById(@RequestParam("name") String name) {
        return colors.stream()
                .filter(c -> c.getDescription().equals(name))
                .findFirst().get().
                getRgb();

    }

    //We add a new color
    @PostMapping("/colors")
    public String saveColor(@RequestBody Color color) {
        colors.add(color);
        return "Usted guardo Color: Id: " + color.getIdColor() + " Descripcion: " + color.getDescription();
    }

    //We update a color
    @PutMapping("/colors/{id}")
    public String updateColor(@PathVariable("id") Integer id, @RequestBody Color color) {

        colors.stream()
                .filter(c -> c.getIdColor()
                        .equals(id)).findFirst()
                .get()
                .setDescription(color.getDescription());
        return "Usted actualizo el Color: Id: " + color.getIdColor() + " con la nueva Descripcion: " + color.getDescription();
    }

    //We delete a color
    @DeleteMapping("/colors/{id}")
    public String saveColor(@PathVariable("id") Integer id) {

        Color colorToDelete = colors.stream()
                .filter(c -> c.getIdColor().equals(id)).findFirst()
                .get();
        colors.remove(colorToDelete);

        return "Usted elimino Color Id: " + colorToDelete.getIdColor() + " Descripcion: " + colorToDelete.getDescription();
    }
}
