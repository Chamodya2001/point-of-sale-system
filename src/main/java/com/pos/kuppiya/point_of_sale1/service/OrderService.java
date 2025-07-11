package com.pos.kuppiya.point_of_sale1.service;

import com.pos.kuppiya.point_of_sale1.dto.paginated.PaginatedResponceOrderDetails;
import com.pos.kuppiya.point_of_sale1.dto.request.RequestOrderSaveDTO;

public interface OrderService {

    String addOrder(RequestOrderSaveDTO requestOrderSaveDTO);

    PaginatedResponceOrderDetails getAllOrderDetails(boolean states, int page, int size);
}
