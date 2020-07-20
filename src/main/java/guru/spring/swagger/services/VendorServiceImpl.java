package guru.spring.swagger.services;

import guru.spring.swagger.api.v1.model.VendorDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {
    @Override
    public List<VendorDTO> getAllVendors() {
        return null;
    }

    @Override
    public VendorDTO getVendorById(Long Id) {
        return null;
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public VendorDTO postVendor(Long Id, VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public VendorDTO patchVendor(Long Id, VendorDTO vendorDTO) {
        return null;
    }

    @Override
    public void deleteVendor(Long Id) {

    }
}
