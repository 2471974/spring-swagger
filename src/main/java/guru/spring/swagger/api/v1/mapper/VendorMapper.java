package guru.spring.swagger.api.v1.mapper;

import guru.spring.swagger.api.v1.model.VendorDTO;
import guru.spring.swagger.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VendorMapper {

    VendorMapper INSTANCE = Mappers.getMapper(VendorMapper.class);

    //@Mapping(source = "id", target = "id") //USED ONLY WHEN PROPERTY NAMES DONT MATCH
    VendorDTO vendorToVendorDTO(Vendor vendor);

    Vendor vendorDtoToVendor(VendorDTO vendorDTO);



}
