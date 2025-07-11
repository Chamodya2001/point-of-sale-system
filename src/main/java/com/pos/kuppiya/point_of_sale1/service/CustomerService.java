package com.pos.kuppiya.point_of_sale1.service;


import com.pos.kuppiya.point_of_sale1.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateDTOByQuary;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateNameSalaryNic;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateRequstDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.CustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceSalaryAddIdDto;
import javassist.NotFoundException;

import java.util.List;

public interface CustomerService  {

    String save(CustomerSaveRequestDTO customerSaveRequestDTO);


    String updateCustomer(CustomerUpdateRequstDTO customerUpdateRequstDTO);

    CustomerDTO getCustomerById(int id);

    List<CustomerDTO> getAllCustomer();

    boolean deleteCustomer(int id) throws NotFoundException;

    List<CustomerDTO> getcustomerBYName(String name) throws NotFoundException;

    List<CustomerDTO> getAllCustomerByActiveState() throws NotFoundException;

    List<ResponceActiveCustomerDTO> getAllCustomerByActiveStateOnlyNAme() throws NotFoundException;


    String updateCustomerUsingQuary(CustomerUpdateDTOByQuary customerUpdateDTOByQuary, int id);

    CustomerDTO getDetailsByNic(String nic) ;

    ResponceSalaryAddIdDto getSalaryAddressId(int id) throws NotFoundException;

    String updateNameSalaryNicUsingQuary(CustomerUpdateNameSalaryNic customerUpdateNameSalaryNic, int id);


    CustomerDTO getCustomerByActiveState1(int id);
}
