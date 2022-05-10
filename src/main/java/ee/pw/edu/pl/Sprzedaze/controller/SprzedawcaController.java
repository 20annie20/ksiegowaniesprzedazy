package ee.pw.edu.pl.Sprzedaze.controller;

import ee.pw.edu.pl.Sprzedaze.model.Sprzedawca;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaService;
import ee.pw.edu.pl.Sprzedaze.services.SprzedawcaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class SprzedawcaController {

    @Autowired
    SprzedawcaServiceImpl sprzedawcaService;

    @RequestMapping("/")
    public String index(Model model) {
        System.out.println("Going to the main page");
        final List<Sprzedawca> lista = sprzedawcaService.getAllSprzedawca();
        System.out.println(lista);
        model.addAttribute("listSprzedawca", lista);
        return "index";
    }

    @RequestMapping("/addSprzedawca")
    public String addSprzedawca(Model model) {
        System.out.println("Idz do dodawania sprzedawcy");
        Sprzedawca sprzedawca = new Sprzedawca();
        model.addAttribute("sprzedawca", sprzedawca);
        return "formularzSprzedawcy";
    }

    @PostMapping("/addSprzedawca")
    public String save(@ModelAttribute("sprzedawca") Sprzedawca sprzedawca)
    {
        System.out.println(sprzedawca.getNazwa());
        if(sprzedawca.getNazwa() == null || sprzedawca.getNazwa().equals(""))
            return "redirect:/addSprzedawca";
        // TODO add popup that sprzedawca name is invalid
        // TODO validate input fields
        sprzedawcaService.saveSprzedawca(sprzedawca);
        return "redirect:/";
    }

    /*
    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/tutorials/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody Tutorial tutorial) {
        Optional<Tutorial> tutorialData = tutorialRepository.findById(id);
        if (tutorialData.isPresent()) {
            Tutorial _tutorial = tutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialRepository.save(_tutorial), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/tutorials/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        try {
            tutorialRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/tutorials")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        try {
            tutorialRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/tutorials/published")
    public ResponseEntity<List<Tutorial>> findByPublished() {
        try {
            List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
            if (tutorials.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    */
}
