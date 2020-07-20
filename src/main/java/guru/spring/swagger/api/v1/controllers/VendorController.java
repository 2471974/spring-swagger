package guru.spring.swagger.api.v1.controllers;

import guru.spring.swagger.api.v1.model.VendorDTO;
import guru.spring.swagger.api.v1.model.VendorListDTO;
import guru.spring.swagger.services.VendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/api/v1/vendors")
@RequestMapping(VendorController.BASE_URL)
public class VendorController {

    public static final String BASE_URL = "/api/v1/vendors";

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping
    public ResponseEntity<VendorListDTO> getAllVendors(){

        return new ResponseEntity<VendorListDTO>(
            new VendorListDTO(
                    vendorService.getAllVendors()),
                    HttpStatus.OK
                );
    }

    @GetMapping("{custid}")
    public ResponseEntity<VendorDTO> getVendorById(@PathVariable String custid){
        return new ResponseEntity<VendorDTO>(
                    vendorService.getVendorById(Long.valueOf(custid)),
                    HttpStatus.OK
                );
    }

    @PostMapping
    public ResponseEntity<VendorDTO> createNewVendor(@RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(
                vendorService.createNewVendor(vendorDTO),
                HttpStatus.CREATED
        );
    }

    @PutMapping("{custid}")
    public ResponseEntity<VendorDTO> postUpdateVendor(
            @PathVariable Long custid,
            @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(
                vendorService.postVendor(custid, vendorDTO),
                HttpStatus.OK
        );
    }

    @PatchMapping("{custid}")
    public ResponseEntity<VendorDTO> patchUpdateVendor(
            @PathVariable Long custid,
            @RequestBody VendorDTO vendorDTO){
        return new ResponseEntity<VendorDTO>(
                vendorService.patchVendor(custid, vendorDTO),
                HttpStatus.OK
        );
    }

    @DeleteMapping("{custid}")
    public ResponseEntity<String> deleteVendor(
            @PathVariable Long custid){
        try{
            vendorService.deleteVendor(custid);
            return new ResponseEntity<String>(
                    "Vendor with ID ['" + custid + "'] deleted successfully",
                    HttpStatus.OK
            );

        }catch(Exception e){
            return new ResponseEntity<String>(
                    e.getLocalizedMessage(),
                    HttpStatus.NOT_FOUND
            );
        }
    }

}
