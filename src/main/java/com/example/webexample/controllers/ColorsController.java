package com.example.webexample.controllers;

import com.example.webexample.model.Color;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ColorsController {

    private static List<Color> colors = new ArrayList<>();

    public ColorsController() {
        colors.add(new Color(1, "Red"));
        colors.add(new Color(2, "Black"));
    }

    @GetMapping("/colors")
    public List<Color> getAllColors() {
        return colors;
    }

    @GetMapping("/colors/{id}")
    public Color getColorById(@PathVariable("id") Integer id) {
        return colors.stream()
                .filter(c -> c.getIdColor().equals(id))
                .findFirst().get();
    }

    @PostMapping("/colors")
    public String saveColor(@RequestBody Color color) {
        colors.add(color);
        return "Usted guardo Color: Id: " + color.getIdColor() + " Descripcion: " + color.getDescription();
    }

    @PutMapping("/colors/{id}")
    public String updateColor(@PathVariable("id") Integer id, @RequestBody Color color) {

        colors.stream()
                .filter(c -> c.getIdColor()
                        .equals(id)).findFirst()
                .get()
                .setDescription(color.getDescription());
        return "Usted actualizo el Color: Id: " + color.getIdColor() + " con la nueva Descripcion: " + color.getDescription();
    }

    @DeleteMapping("/colors/{id}")
    public String saveColor(@PathVariable("id") Integer id) {

        Color colorToDelete = colors.stream()
                .filter(c -> c.getIdColor().equals(id)).findFirst()
                .get();
        colors.remove(colorToDelete);

        return "Usted elimino Color Id: " + colorToDelete.getIdColor() + " Descripcion: " + colorToDelete.getDescription();
    }
}
