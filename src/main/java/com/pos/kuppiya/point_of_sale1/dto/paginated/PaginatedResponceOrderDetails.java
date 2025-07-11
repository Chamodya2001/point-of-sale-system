package com.pos.kuppiya.point_of_sale1.dto.paginated;

import com.pos.kuppiya.point_of_sale1.dto.response.ResponceOrderDetailsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedResponceOrderDetails
{
    private List<ResponceOrderDetailsDto> list;
    private long dataCount;
}
