package com.pos.kuppiya.point_of_sale1.service.impl;


import com.pos.kuppiya.point_of_sale1.dto.request.CustomerSaveRequestDTO;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateDTOByQuary;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateNameSalaryNic;
import com.pos.kuppiya.point_of_sale1.dto.request.CustomerUpdateRequstDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.CustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceActiveCustomerDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceSalaryAddIdDto;
import com.pos.kuppiya.point_of_sale1.entity.Customer;
import com.pos.kuppiya.point_of_sale1.excepton.EntryDuplicateException;
import com.pos.kuppiya.point_of_sale1.excepton.NOtFoundException;
import com.pos.kuppiya.point_of_sale1.repo.CustomerRepo;
import com.pos.kuppiya.point_of_sale1.service.CustomerService;
import com.pos.kuppiya.point_of_sale1.util.mappers.CustomerMapper;
import javassist.NotFoundException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public String save(CustomerSaveRequestDTO customerSaveRequestDTO) {
        Customer customer=new Customer(

                customerSaveRequestDTO.getCustomerName(),
                customerSaveRequestDTO.getCustomerAddress(),
                customerSaveRequestDTO.getCustomerSalary(),
                customerSaveRequestDTO.getContactNumber(),
                customerSaveRequestDTO.getNic(),
                false




        ) ;
        if(!customerRepo.existsById(customer.getId())){
            customerRepo.save(customer);
            return customerSaveRequestDTO.getCustomerName()+"customer saved";
        }else{
            return customerSaveRequestDTO.getCustomerName()+"existing by customer";

        }

    }

    @Override
    public String updateCustomer(CustomerUpdateRequstDTO customerUpdateRequstDTO) {
        if(customerRepo.existsById(customerUpdateRequstDTO.getId())){
            Customer cu=customerRepo.getById(customerUpdateRequstDTO.getId());
            cu.setCustomerName(customerUpdateRequstDTO.getCustomerName());
            cu.setCustomerAddress(customerUpdateRequstDTO.getCustomerAddress());
            cu.setCustomerSalary(customerUpdateRequstDTO.getCustomerSalary());
            cu.setContactNumber(customerUpdateRequstDTO.getContactNumber());
            cu.setNic(customerUpdateRequstDTO.getNic());

            customerRepo.save(cu);
            return "update";
        }else{
            throw new EntryDuplicateException("not in databse");
        }

        }

    @Override
    public CustomerDTO getCustomerById(int id) {
       //Customer customer=customerRepo.getById(id);
        Optional<Customer> customer=customerRepo.findById(id);
        if(customer.isPresent()){
//            CustomerDTO customerDTO=new CustomerDTO(
//                  customer.get().getId(),
//                  customer.get().getCustomerName(),
//                  customer.get().getCustomerAddress(),
//                  customer.get().getCustomerSalary(),
//                  customer.get().getContactNumber(),
//                  customer.get().getNic(),
//                  customer.get().isActiveState()
//
//
//            );

         //   CustomerDTO customerDTO=modelMapper.map(customer.get() ,CustomerDTO.class);

            CustomerDTO customerDTO=customerMapper.entityToDto(customer.get());
        return customerDTO;

        }else {
            return null;
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> getCustomer =customerRepo.findAll();

//        List<CustomerDTO> customerDTOSList=new ArrayList<>();
//        for(Customer  c: getCustomer){
//            CustomerDTO oneCustomersDetails=new CustomerDTO(
//                    c.getId(),
//                    c.getCustomerName(),
//                    c.getCustomerAddress(),
//                    c.getCustomerSalary(),
//                    c.getContactNumber(),
//                    c.getNic(),
//                    c.isActiveState()
//
//            );
//
//            customerDTOSList.add(oneCustomersDetails);
//
//
//
//        }
//
//
//

  //  List<CustomerDTO> cu=modelMapper.map(getCustomer,new TypeToken<List<CustomerDTO>>(){}.getType());

        List<CustomerDTO> cu=customerMapper.entityLidtToDtoList(getCustomer);

        return cu;
    }

    @Override
    public boolean deleteCustomer(int id) throws NotFoundException {
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);

        }else{
            throw new NotFoundException("not found customer");

        }
        return true;
    }

    @Override
    public List<CustomerDTO> getcustomerBYName(String name) throws NotFoundException {
        List<Customer> customers=customerRepo.findAllByCustomerNameEquals(name);
        if(customers.size()!=0){
            List<CustomerDTO> cu1=
                    modelMapper.map(customers,new TypeToken<List<CustomerDTO>>(){}.getType());

            return cu1;

        }else {
            throw new NotFoundException("not found");
        }

    }

    @Override
    public List<CustomerDTO> getAllCustomerByActiveState() throws NotFoundException {
        List<Customer> customers=customerRepo.findAllByActiveStateEquals(false);
        if(customers.size()!=0){
            List<CustomerDTO> customerDTOS=customerMapper.entityLidtToDtoList(customers);
            return customerDTOS;

        }else {
            throw new NotFoundException("no customers find");

        }


    }

    @Override
    public List<ResponceActiveCustomerDTO> getAllCustomerByActiveStateOnlyNAme() throws NotFoundException {
        List<Customer> customers=customerRepo.findAllByActiveState (false);
        if(customers.size()!=0){
            List<ResponceActiveCustomerDTO> responceActiveCustomerDTOS=customerMapper.entityListToDtoListOnlyName(customers);
            return responceActiveCustomerDTOS;

        }else {
            throw new NotFoundException("no customers find");

        }

    }

    @Override
    public String updateCustomerUsingQuary(CustomerUpdateDTOByQuary customerUpdateDTOByQuary, int id) {
         if(customerRepo.existsById(id)){
             customerRepo.updateCustomerByQuery(customerUpdateDTOByQuary.getCustomerName(),customerUpdateDTOByQuary.getNic(),id);
             return "update sucessfull "+id;
         }else{
             return "not update " +id ;
         }
    }

    @Override
    public CustomerDTO getDetailsByNic(String nic)  {
     Optional<Customer> customer=customerRepo.findByNicEquals(nic);
     if(customer.isPresent()){
         CustomerDTO customerDTO=modelMapper.map(customer.get(),CustomerDTO.class);
         return customerDTO;

     }else{
         throw new NOtFoundException("not found");
     }



    }

    @Override
    public ResponceSalaryAddIdDto getSalaryAddressId(int id) throws NotFoundException {
        Optional<Customer> customers=customerRepo.findById(id);
        if(customers.isPresent()) {
          ResponceSalaryAddIdDto responceSalaryAddIdDtos=customerMapper.entityToResponceDto(customers.get());
          return  responceSalaryAddIdDtos;
        }else {
            throw new NotFoundException("Not found id");

        }
    }

    @Override
    public String updateNameSalaryNicUsingQuary(CustomerUpdateNameSalaryNic customerUpdateNameSalaryNic, int id) {
        if (customerRepo.existsById(id)){
            customerRepo.updateNameSalaryNic(customerUpdateNameSalaryNic.getCustomerName(),customerUpdateNameSalaryNic.getCustomerSalary(),customerUpdateNameSalaryNic.getNic(),id);
            return "update sucessfull "+id;
        }else{
            return "not update " +id ;
        }
    }

    @Override
    public CustomerDTO getCustomerByActiveState1(int id) {
        Optional<Customer> customers=customerRepo.findById(id);
        if(customers.isPresent()) {
            if(customers.get().isActiveState()==true){
                CustomerDTO customerDTO=modelMapper.map(customers.get(),CustomerDTO.class);
                return customerDTO;
            }else {
                System.out.println("this is inactive customer");
            }

        }else {

          throw new NOtFoundException("Not found");

        }
        return null;

    }


}
