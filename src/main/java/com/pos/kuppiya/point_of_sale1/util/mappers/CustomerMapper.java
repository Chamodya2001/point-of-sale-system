package com.pos.kuppiya.point_of_sale1.util.mappers;

import com.pos.kuppiya.point_of_sale1.dto.response.CustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceSalaryAddIdDto;
import com.pos.kuppiya.point_of_sale1.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerDTO entityToDto(Customer customer);
    List<CustomerDTO> entityLidtToDtoList(List<Customer> customer);

    List<ResponceActiveCustomerDTO> entityListToDtoListOnlyName(List<Customer> customers);
    ResponceSalaryAddIdDto entityToResponceDto(Customer customer);
}
