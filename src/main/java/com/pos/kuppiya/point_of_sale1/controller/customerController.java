package com.pos.kuppiya.point_of_sale1.controller;


import com.pos.kuppiya.point_of_sale1.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateDTOByQuary;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateNameSalaryNic;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateRequstDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.CustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceSalaryAddIdDto;
import com.pos.kuppiya.point_of_sale1.service.CustomerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
@AllArgsConstructor
public class customerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/saveCustomer")
    public String saveCustomer(@RequestBody CustomerSaveRequestDTO customerSaveRequestDTO) {
        String id = customerService.save(customerSaveRequestDTO);
        return id;

    }


    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody CustomerUpdateRequstDTO customerUpdateRequstDTO) {
        String upte = customerService.updateCustomer(customerUpdateRequstDTO);
        return upte;
    }

    @GetMapping(path = "/getbyID", params = "id")
    public CustomerDTO getCustomerById(@RequestParam(value = "id") int id) {
        CustomerDTO customerDTO = customerService.getCustomerById(id);
        return customerDTO;
    }

    @GetMapping(path = "/getAllCustomer")
    public List<CustomerDTO> getAllCustomer() {
        List<CustomerDTO> customerDTO = customerService.getAllCustomer();
        return customerDTO;

    }
    @DeleteMapping(path = "/deletecustomer/{id}")
    public String  deleteCustomer(@PathVariable(value = "id") int id) throws NotFoundException {
        boolean deleteCustomer=customerService. deleteCustomer(id);

        return"delete";
    }
    @GetMapping(
            path = "getByName",
            params = "name"

    )
    public List<CustomerDTO> getCustomerByName(@RequestParam(value = "name") String name) throws NotFoundException {
        List<CustomerDTO> getCustomer=customerService.getcustomerBYName(name);
        return getCustomer;

    }
    @GetMapping(path = "getByActiveState")
    public List<CustomerDTO> getCustomerByActiveState() throws NotFoundException {
        List<CustomerDTO> getcustomer=customerService.getAllCustomerByActiveState();
        return getcustomer;

    }
    @GetMapping(path = "getByActiveState-inly-name")
    public List<ResponceActiveCustomerDTO> getCustomerByActiveStateOnlyName() throws NotFoundException {
        List<ResponceActiveCustomerDTO> responceActiveCustomerDTOS=customerService.getAllCustomerByActiveStateOnlyNAme();
        return responceActiveCustomerDTOS;

    }


    @PutMapping(path = "/update-query/{id}")
    public String updateCustomerUsingQuary(
            @RequestBody CustomerUpdateDTOByQuary customerUpdateDTOByQuary,
            @PathVariable(value = "id")  int id) {
        String upte1 = customerService.updateCustomerUsingQuary(customerUpdateDTOByQuary,id);
        return upte1;
    }

    @GetMapping(path = "get-all-details-by-nic/{nic}")
    public CustomerDTO getAllDetailsByNic(@PathVariable(value = "nic") String nic) {
        CustomerDTO customerDTOS=customerService.getDetailsByNic(nic);
        return customerDTOS;
    }
    @GetMapping(path = "/get-salary-ad-id-byid/{id}")
    public ResponceSalaryAddIdDto getSalaryADDId(@PathVariable(value = "id") int id) throws NotFoundException {
        ResponceSalaryAddIdDto responceSalaryAddIdDtos=customerService.getSalaryAddressId(id);
        return responceSalaryAddIdDtos;
    }
    @PutMapping(path = "/update-name-salry-nic/{id}")
    public String updateNameSalaryNicUsingQuary(
            @RequestBody CustomerUpdateNameSalaryNic customerUpdateNameSalaryNic,
            @PathVariable(value = "id")  int id) {
        String upte2 = customerService.updateNameSalaryNicUsingQuary(customerUpdateNameSalaryNic,id);
        return upte2;
    }
    @GetMapping(path = "/get-true-active-state/{id}")
    public CustomerDTO getCustomerByActiveState(@PathVariable(value = "id") int id)  {
        CustomerDTO result=customerService.getCustomerByActiveState1(id);
        return result ;
    }





}

