package com.pos.kuppiya.point_of_sale1.service.impl;

import com.pos.kuppiya.point_of_sale1.dto.paginated.PaginatedResponceOrderDetails;
import com.pos.kuppiya.point_of_sale1.dto.queryIntefacecs.OrderDetailsInterface;
import com.pos.kuppiya.point_of_sale1.dto.request.RequestOrderSaveDTO;
import com.pos.kuppiya.point_of_sale1.dto.response.ResponceOrderDetailsDto;
import com.pos.kuppiya.point_of_sale1.entity.OrderDetails;
import com.pos.kuppiya.point_of_sale1.entity.Orders;
import com.pos.kuppiya.point_of_sale1.repo.CustomerRepo;
import com.pos.kuppiya.point_of_sale1.repo.ItemRepo;
import com.pos.kuppiya.point_of_sale1.repo.OrderDetailsRepo;
import com.pos.kuppiya.point_of_sale1.repo.OrderRepo;
import com.pos.kuppiya.point_of_sale1.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderDetailsRepo orderDetailsRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders order=new Orders(
              customerRepo.getById(requestOrderSaveDTO.getCustomer_id()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()

        );
        orderRepo.save(order);
        if(orderRepo.existsById(order.getOrderId())){

              List<OrderDetails> orderDetailss=modelMapper.
                      map(requestOrderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){}.
                              getType());
              for(int i=0;i<orderDetailss.size();i++){
                  orderDetailss.get(i).setOrders(order);
             //  orderDetailss.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().);
              }
              if(orderDetailss.size()>0){
                  orderDetailsRepo.saveAll(orderDetailss);
              }else{
                  return "saved";
              }

        }
        return null;
    }

    @Override
    public PaginatedResponceOrderDetails getAllOrderDetails(boolean states, int page, int size) {

        List<OrderDetailsInterface> orderDetailsInterfaces=orderRepo.getAllOrderDetails(states, PageRequest.of(page,size));


        List<ResponceOrderDetailsDto> list =new ArrayList<>();
          for(OrderDetailsInterface o:orderDetailsInterfaces){
              ResponceOrderDetailsDto responceOrderDetailsDto=new ResponceOrderDetailsDto(

                      o.getCustomerName(),o.getCustomerAddress(),o.getContactNumber(),o.getDate(),o.getTotal()

              );
             list.add(responceOrderDetailsDto);

          }
          PaginatedResponceOrderDetails paginatedResponceOrderDetailsDto=new PaginatedResponceOrderDetails(
                 list,
                  orderRepo.countAllOrderDetails(states)
          );
        return paginatedResponceOrderDetailsDto;
    }
}
