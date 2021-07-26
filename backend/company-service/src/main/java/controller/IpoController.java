package controller;

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

import services.IpoService;

@RestController
@RequestMapping("/company")
public class IpoController {

    @Autowired
    IpoService ipoService;

    @GetMapping("/ipo")
    public ResponseEntity<List<Ipo>> getAllIpos(){
        return ResponseEntity.ok(ipoService.getAllIpos());
    }

    @PostMapping("/ipo")
    public ResponseEntity<Ipo> addIpo(@RequestBody Ipo ipo){
        return ResponseEntity.ok(ipoService.addIpo(ipo));
    }

    @GetMapping("/ipo/{id}")
    public ResponseEntity getIpoById(@PathVariable("id") int id){
        Optional<Ipo> ipoOptional = Optional.ofNullable(ipoService.getIpoById(id));
        return ipoOptional.isPresent()?ResponseEntity.ok(ipoOptional.get()): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with id "+id+" not found.");
    }

    @DeleteMapping("/ipo/{id}")
    private ResponseEntity deleteIpo(@PathVariable int id){

        if (!ipoService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/ipo/company/{companyId}")
    public ResponseEntity getIpoByCompanyId(@PathVariable("companyId") int companyId) {
        Ipo ipo =  ipoService.getIpoByCompanyId(companyId);
        return ipo!=null? ResponseEntity.ok(ipo): ResponseEntity.status(HttpStatus.NOT_FOUND).body("No IPO found with company id "+companyId);
    }

    @PutMapping("/ipo/{id}")
    public ResponseEntity<?> updateIpoData(@PathVariable int id,@RequestBody Ipo ipo){
        Ipo updatedIpo = ipoService.updateIpo(id, ipo);
        return updatedIpo==null?ResponseEntity.ok("IPO with id "+id+" not found."):ResponseEntity.ok(updatedIpo);
    }

}