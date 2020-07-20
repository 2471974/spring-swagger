package guru.spring.swagger.services;

import guru.spring.swagger.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {

    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long Id);

    VendorDTO createNewVendor(VendorDTO vendorDTO);

    VendorDTO postVendor(Long Id, VendorDTO vendorDTO);

    VendorDTO patchVendor(Long Id, VendorDTO vendorDTO);

    void deleteVendor(Long Id);


}
