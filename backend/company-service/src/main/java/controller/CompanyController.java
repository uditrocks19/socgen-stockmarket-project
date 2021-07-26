package controller;

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
import entities.*;
import java.util.List;
import java.util.Optional;

import services.CompanyServices;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyServices companyService;

    @GetMapping("/company")
    public ResponseEntity<List<Company>> getAllCompanies(){
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping("/company")
    public ResponseEntity<Company> addCompany(@RequestBody Company company){
        return ResponseEntity.ok(companyService.addCompany(company));
    }

    @GetMapping("/company/{id}")
    public ResponseEntity getCompanyById(@PathVariable("id") int id){
        Optional<Company> companyOptional = Optional.ofNullable(companyService.getCompanyById(id));
        return companyOptional.isPresent()?ResponseEntity.ok(companyOptional.get()): ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company with id "+id+" not found.");
    }

    @DeleteMapping("/company/{id}")
    private ResponseEntity deleteCompany(@PathVariable int id){

        if (!companyService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
        return ResponseEntity.ok(companyService.updateCompany(id, company));
    }

    @GetMapping("/getCompanyByPattern/{pattern}")
    public ResponseEntity<List<Company>> getCompanyByPattern(@PathVariable("pattern") String pattern){
        return ResponseEntity.ok(companyService.getCompanyByPattern(pattern));
    }


}