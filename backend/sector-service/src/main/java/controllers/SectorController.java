package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Company;
import entity.Sector;
import services.SectorService;

@RestController
@RequestMapping("/sector")
public class SectorController {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/sectors")
    private ResponseEntity<List<Sector>> getAllSectors(){
        return ResponseEntity.ok(sectorService.getAllSectors());
    }

    @GetMapping("/sectors/{sectorid}")
    private ResponseEntity getSectorById(@PathVariable("sectorid") int sectorId)
    {
        if (sectorService.getSectorById(sectorId)!=null)
        {
            return ResponseEntity.ok(sectorService.getSectorById(sectorId));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector with id "+ sectorId+" not found.");
        }
    }

    @GetMapping("/sectors/name/{name}")
    private ResponseEntity getSectorByName(@PathVariable("name") String sectorName)
    {
        if (sectorService.getSectorByName(sectorName)!=null)
        {
            return ResponseEntity.ok(sectorService.getSectorByName(sectorName));
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sector with name "+ sectorName+" not found.");
        }
    }

    @PostMapping("/sectors")
    private ResponseEntity<Sector> addSector(@RequestBody Sector sector)
    {
        return ResponseEntity.ok(sectorService.addSector(sector));
    }

    @PutMapping("/sectors/{id}")
    private ResponseEntity updateSector(@PathVariable int id, @RequestBody Sector sector){

        return ResponseEntity.ok(sectorService.updateSector(id,sector));
    }

    @DeleteMapping("/sectors/{id}")
    private ResponseEntity deleteSector(@PathVariable int id){

        if (!sectorService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }



    @GetMapping("/companies/{sectorName}")
    private ResponseEntity<List<Company>> getCompanies(@PathVariable("sectorName") String sectorName){
        return ResponseEntity.ok(sectorService.getCompanies(sectorName));
    }

}